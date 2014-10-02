package net.condorcraft110.stygian.item;

import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.player.*;
import cpw.mods.fml.common.registry.*;
import net.condorcraft110.stygian.util.*;
import net.condorcraft110.stygian.registry.*;

public class ItemSceptre extends Item
{
	public ItemSceptre()
	{
		setHasSubtypes(true);
		setMaxStackSize(1);
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float f, float g, float h)
	{
		switch(stack.getItemDamage())
		{
			case 0:
				return FocusRegistry.getFocus(stack.getTagCompound().getInteger("FocusID")).onItemUse(stack, player, world, x, y, z, i, f, g, h);
			case 1:
				return ResonanceRegistry.getResonance(stack.getTagCompound().getInteger("ResonanceID")).onItemUse(stack, player, world, x, y, z, i, f, g, h);
			default:
				return false;
		}
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase victim, EntityLivingBase attacker)
	{
		switch(stack.getItemDamage())
		{
			case 0:
				return FocusRegistry.getFocus(stack.getTagCompound().getInteger("FocusID")).hitEntity(stack, victim, attacker);
			case 1:
				return ResonanceRegistry.getResonance(stack.getTagCompound().getInteger("ResonanceID")).hitEntity(stack, victim, attacker);
			default:
				return false;
		}
	}
	
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b)
	{
		switch(stack.getItemDamage())
		{
			case 0:
				list.add(FocusRegistry.getLocalFocusName(stack.getTagCompound().getInteger("FocusID")));
				break;
			case 1:
				list.add(ResonanceRegistry.getLocalResonanceName(stack.getTagCompound().getInteger("ResonanceID")));
				break;
		}
	}
	
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for(int i = 0; i < FocusRegistry.registeredFoci(); i++)
		{
			ItemStack stack = new ItemStack(item, 1, 0);
			
			if(stack.hasTagCompound()) stack.getTagCompound().setInteger("FocusID", i);
			else
			{
				NBTTagCompound compound = new NBTTagCompound();
				compound.setInteger("FocusID", i);
				stack.setTagCompound(compound);
			}
			
			list.add(stack);
		}
		
		for(int i = 0; i < ResonanceRegistry.registeredResonances(); i++)
		{
			ItemStack stack = new ItemStack(item, 1, 1);
			
			if(stack.hasTagCompound()) stack.getTagCompound().setInteger("ResonanceID", i);
			else
			{
				NBTTagCompound compound = new NBTTagCompound();
				compound.setInteger("ResonanceID", i);
				stack.setTagCompound(compound);
			}
			
			list.add(stack);
		}
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		switch(stack.getItemDamage())
		{
			case 0:
				return FocusRegistry.getFocus(stack.getTagCompound().getInteger("FocusID")).onItemRightClick(stack, world, player);
			case 1:
				return ResonanceRegistry.getResonance(stack.getTagCompound().getInteger("ResonanceID")).onItemRightClick(stack, world, player);
			default:
				return stack;
		}
	}
	
	public EnumRarity getRarity(ItemStack stack)
	{
		switch(stack.getItemDamage())
		{
			default:
			case 0:
				return EnumRarity.uncommon;
			case 1:
				return EnumRarity.rare;
		}
	}
	
	public String getUnlocalizedName(ItemStack stack)
	{
		switch(stack.getItemDamage())
		{
			default:
			case 0:
				return "item.focusSceptre";
			case 1:
				return "item.resonanceSceptre";
		}
	}
}
