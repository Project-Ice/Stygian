package net.condorcraft110.stygian.registry;

import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import cpw.mods.fml.common.registry.*;
import net.condorcraft110.stygian.core.*;
import net.condorcraft110.stygian.util.*;
import net.condorcraft110.stygian.energies.focus.*;

public class FocusRegistry
{
	private static boolean registered;
	
	private static ArrayList<ICoreFocus> focusRegistry = new ArrayList<ICoreFocus>();

	public static void registerFocus(ICoreFocus focus)
	{
		registerFocus(focusRegistry.size(), focus);
	}
	
	public static void registerFocus(int id, ICoreFocus focus)
	{
		focusRegistry.add(id, focus);
		
		ItemStack sceptreStack = new ItemStack(Stygian.sceptre, 1, 0);
		NBTHelper.setStackInt(sceptreStack, "FocusID", id);
		
		ItemStack coreStack = new ItemStack(Stygian.focusCore, 1, id);
		
		RecipeManager.registerForgeRecipe(new ForgeRecipe(sceptreStack, new ItemStack[][]{new ItemStack[]{null, null, coreStack}, new ItemStack[]{null, new ItemStack(Stygian.sceptreCoreCradle), null}, new ItemStack[]{new ItemStack(Items.blaze_rod), null, null}}));
	}
	
	public static ICoreFocus getFocus(int id)
	{
		return focusRegistry.get(id);
	}
	
	public static int getIDForFocus(ICoreFocus focus)
	{
		return focusRegistry.indexOf(focus);
	}
	
	public static String getLocalFocusName(int id)
	{
		return StatCollector.translateToLocal("focus." + getFocus(id).getFocusName() + ".name");
	}
	
	public static int registeredFoci()
	{
		return focusRegistry.size();
	}
	
	public static void registerFoci()
	{
		if(registered) return;
		
		registerFocus(new FocusLightning());
		registerFocus(new FocusFire());
		registerFocus(new FocusWind());
		registerFocus(new FocusCreativeDeath());
		registerFocus(new FocusTeleporter());
		registerFocus(new FocusRepulsion());
		
		registered = true;
	}
}
