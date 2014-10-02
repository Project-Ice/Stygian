package net.condorcraft110.stygian.item;

import java.util.*;

import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.*;
import net.condorcraft110.stygian.energies.focus.*;
import net.condorcraft110.stygian.registry.FocusRegistry;

public class ItemStygianCore extends Item
{
	public ItemStygianCore()
	{
		setHasSubtypes(true);
		setMaxStackSize(1);
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b)
	{
		list.add(FocusRegistry.getLocalFocusName(stack.getItemDamage()));
	}
	
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
	
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for(int i = 0; i < FocusRegistry.registeredFoci(); i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	public ICoreFocus getFocus(ItemStack stack)
	{
		return FocusRegistry.getFocus(stack.getItemDamage());
	}
	
	public String getLocalFocusName(ItemStack stack)
	{
		return FocusRegistry.getLocalFocusName(stack.getItemDamage());
	}
	
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.epic;
	}
}
