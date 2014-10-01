package net.condorcraft110.stygian.item;

import java.util.*;

import net.minecraft.item.*;
import net.minecraft.creativetab.*;
import net.minecraftforge.fluids.*;

public class ItemStygianBucket extends ItemBucket
{
	public ItemStygianBucket(BlockFluidBase fluid)
	{
		super(fluid);
		setHasSubtypes(true);
	}
	
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for(int i = 0; i < 2; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
}
