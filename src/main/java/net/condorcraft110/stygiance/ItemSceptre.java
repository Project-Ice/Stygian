package net.condorcraft110.stygiance;

import java.util.*;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.player.*;
import cpw.mods.fml.common.registry.*;
import net.condorcraft110.stygiance.focus.*;

public class ItemSceptre extends Item
{
	public ItemSceptre()
	{
		setHasSubtypes(true);
		setMaxStackSize(1);
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float f, float g, float h)
	{
		return FocusRegistry.getFocus(stack.getItemDamage()).onItemUse(stack, player, world, x, y, z, i, f, g, h);
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase victim, EntityLivingBase attacker)
	{
		return FocusRegistry.getFocus(stack.getItemDamage()).hitEntity(stack, victim, attacker);
	}
	
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b)
	{
		list.add(FocusRegistry.getLocalFocusName(stack.getItemDamage()));
	}
	
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for(int i = 0; i < FocusRegistry.registeredFoci(); i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		return FocusRegistry.getFocus(stack.getItemDamage()).onItemRightClick(stack, world, player);
	}
	
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.epic;
	}
}
