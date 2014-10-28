package net.condorcraft110.stygian.registry;

import java.util.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.condorcraft110.stygian.core.*;
import net.condorcraft110.stygian.util.*;
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
		NBTHelper.setStackInt(stack, "ResonanceID", id);
		
		//TODO recipe
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
		return StatCollector.translateToLocal("resonance." + getResonance(id).getResonanceName() + ".name");
	}
	
	public static int registeredResonances()
	{
		return resonanceRegistry.size();
	}
	
	public static void registerResonances()
	{
		if(registered) return;
		
		registerResonance(new ResonanceLightning());
		registerResonance(new ResonanceRecall());
		//registerResonance(new ResonanceDisplacement());
		registerResonance(new ResonanceDestroyWatchmaker());
		
		registered = true;
	}
}
