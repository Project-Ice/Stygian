package net.condorcraft110.stygian.item;

import java.util.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.condorcraft110.stygian.registry.*;

public class ItemFocusNode extends Item
{
	public ItemFocusNode()
	{
		setHasSubtypes(true);
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b)
	{
		list.add(FocusRegistry.getLocalFocusName(stack.getItemDamage()));
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float f, float g, float h)
	{
		world.setBlock(x, y, z, FocusRegistry.getNode(stack.getItemDamage()));
		
		return true;
	}
	
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for(int i = 0; i < FocusRegistry.registeredFoci(); i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
}
