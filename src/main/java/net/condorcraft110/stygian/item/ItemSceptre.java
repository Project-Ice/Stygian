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
				int focusID = NBTHelper.getStackInt(stack, "FocusID");
				list.add(FocusRegistry.getLocalFocusName(focusID));
				FocusRegistry.getFocus(focusID).addInformation(stack, player, list, b);
				break;
			case 1:
				int resonanceID = NBTHelper.getStackInt(stack, "ResonanceID");
				list.add(ResonanceRegistry.getLocalResonanceName(resonanceID));
				break;
		}
	}
	
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for(int i = 0; i < FocusRegistry.registeredFoci(); i++)
		{
			ItemStack stack = new ItemStack(item, 1, 0);
			
			NBTHelper.setStackInt(stack, "FocusID", i);
			
			list.add(stack);
		}
		
		for(int i = 0; i < ResonanceRegistry.registeredResonances(); i++)
		{
			ItemStack stack = new ItemStack(item, 1, 1);
			
			NBTHelper.setStackInt(stack, "ResonanceID", i);
			
			list.add(stack);
		}
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		switch(stack.getItemDamage())
		{
			case 0:
				return FocusRegistry.getFocus(NBTHelper.getStackInt(stack, "FocusID")).onItemRightClick(stack, world, player);
			case 1:
				return ResonanceRegistry.getResonance(NBTHelper.getStackInt(stack, "ResonanceID")).onItemRightClick(stack, world, player);
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
	
	public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean b)
	{
		switch(stack.getItemDamage())
		{
			case 0:
				FocusRegistry.getFocus(NBTHelper.getStackInt(stack, "FocusID")).onUpdate(stack, world, entity, i, b);
				break;
			case 1:
				//ResonanceRegistry.getResonance(NBTHelper.getStackInt(stack, "ResonanceID")).onUpdate(stack, world, entity, i, b);
				break;
		}
	}
}
