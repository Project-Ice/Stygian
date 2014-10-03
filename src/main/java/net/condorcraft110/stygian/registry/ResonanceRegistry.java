package net.condorcraft110.stygian.registry;

import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import cpw.mods.fml.common.registry.*;
import net.condorcraft110.stygian.core.*;
import net.condorcraft110.stygian.energies.resonance.*;

public class ResonanceRegistry
{
	private static boolean registered;
	
	private static ArrayList<IResonance> resonanceRegistry = new ArrayList<IResonance>();

	public static void registerResonance(IResonance resonance)
	{
		registerResonance(resonanceRegistry.size(), resonance);
	}
	
	public static void registerResonance(int id, IResonance resonance)
	{
		resonanceRegistry.add(id, resonance);
		
		ItemStack stack = new ItemStack(Stygian.sceptre, 1, 0);
		
		if(stack.hasTagCompound()) stack.getTagCompound().setInteger("FocusID", id);
		else
		{
			NBTTagCompound tag = new NBTTagCompound();
			tag.setInteger("ResonanceID", id);
			stack.setTagCompound(tag);
		}
		
		GameRegistry.addRecipe(stack, "  @", " # ", "~  ", '@', new ItemStack(Stygian.resonanceStar, 1, id), '#', Stygian.sceptreCoreCradle, '~', Items.blaze_rod);
	}
	
	public static IResonance getResonance(int id)
	{
		return resonanceRegistry.get(id);
	}
	
	public static int getIDForResonance(IResonance resonance)
	{
		return resonanceRegistry.indexOf(resonance);
	}
	
	public static String getLocalResonanceName(int id)
	{
		return StatCollector.translateToLocal("resonance." + getResonance(id).resonanceName() + ".name");
	}
	
	public static int registeredResonances()
	{
		return resonanceRegistry.size();
	}
	
	public static void registerResonances()
	{
		if(registered) return;
		
		registerResonance(new ResonanceLightning());
		
		registered = true;
	}
}