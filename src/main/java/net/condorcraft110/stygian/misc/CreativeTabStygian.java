package net.condorcraft110.stygian.misc;

import net.minecraft.item.*;
import net.minecraft.creativetab.*;
import net.condorcraft110.stygian.core.*;

public class CreativeTabStygian extends CreativeTabs
{
	public CreativeTabStygian()
	{
		super("stygian");
	}
	
	public Item getTabIconItem()
	{
		return Stygian.stygianCrystal;
	}
	
	public int func_151243_f()
	{
		return 1;
	}
}
