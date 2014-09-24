package net.condorcraft110.stygiance;

import java.util.*;

import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import cpw.mods.fml.common.registry.*;
import net.condorcraft110.stygiance.focus.*;

public class FocusRegistry
{
	private static ArrayList<ICoreFocus> focusRegistry = new ArrayList<ICoreFocus>();

	public static void registerFocus(ICoreFocus focus)
	{
		registerFocus(focusRegistry.size(), focus);
	}
	
	public static void registerFocus(int id, ICoreFocus focus)
	{
		focusRegistry.add(id, focus);
		GameRegistry.addRecipe(new ItemStack(Stygian.sceptre, 1, id), "  @", " # ", "~  ", '@', new ItemStack(Stygian.focusCore, 1, id), '#', Stygian.sceptreCoreCradle, '~', Items.blaze_rod);
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
		return StatCollector.translateToLocal("focus." + getFocus(id).focusName() + ".name");
	}
	
	public static int registeredFoci()
	{
		return focusRegistry.size();
	}
	
	static void registerFoci()
	{
		registerFocus(new FocusLightning());
		registerFocus(new FocusFire());
		registerFocus(new FocusWind());
		registerFocus(new FocusCreativeDeath());
	}
}
