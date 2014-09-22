package net.condorcraft110.stygiance;

import java.util.*;
import net.minecraft.util.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.common.registry.*;
import net.condorcraft110.stygiance.focus.*;

public class FocusRegistry
{
	private static ArrayList<ICoreFocus> focusRegistry = new ArrayList<ICoreFocus>();
	private static HashMap<ICoreFocus, ItemSceptre> sceptreRegistry = new HashMap<ICoreFocus, ItemSceptre>();
	private static HashMap<ICoreFocus, ItemStygianCore> coreRegistry = new HashMap<ICoreFocus, ItemStygianCore>(); 

	public static void registerFocus(ICoreFocus focus)
	{
		registerFocus(focusRegistry.size(), focus);
	}
	
	public static void registerFocus(ICoreFocus focus, CreativeTabs tab)
	{
		registerFocus(focusRegistry.size(), focus, tab);
	}
	
	public static void registerFocus(int id, ICoreFocus focus)
	{
		registerFocus(id, focus, null);
	}
	
	public static void registerFocus(int id, ICoreFocus focus, CreativeTabs tab)
	{
		ItemSceptre sceptre = new ItemSceptre(focus);
		sceptre.registerRecipe();
		if(tab != null) sceptre.setCreativeTab(Stygian.tabStygian);
		GameRegistry.registerItem(sceptre, "sceptre." + focus.focusName());
		
		ItemStygianCore core = new ItemStygianCore(id);
		core.setCreativeTab(tab);
		GameRegistry.registerItem(core, "core." + focus.focusName());
		
		focusRegistry.add(id, focus);
		sceptreRegistry.put(focus, sceptre);
		coreRegistry.put(focus, core);
	}
	
	public static ICoreFocus getFocus(int id)
	{
		return focusRegistry.get(id);
	}
	
	public static ItemSceptre getSceptreForFocus(ICoreFocus focus)
	{
		return sceptreRegistry.get(focus);
	}
	
	public static int getIDForFocus(ICoreFocus focus)
	{
		return focusRegistry.indexOf(focus);
	}
	
	public static String getLocalFocusName(int id)
	{
		return StatCollector.translateToLocal("focus." + getFocus(id).focusName() + ".name");
	}
	
	static void registerFoci()
	{
		focusRegistry.add(null);
		registerFocus(new FocusLightning(), Stygian.tabStygian);
	}
}
