package net.condorcraft110.stygian.misc;

import net.condorcraft110.stygian.core.Stygian;
import net.minecraft.creativetab.*;
import net.minecraft.item.Item;

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
}