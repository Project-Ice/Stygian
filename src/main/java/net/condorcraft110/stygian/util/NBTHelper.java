package net.condorcraft110.stygian.util;

import net.condorcraft110.stygian.core.Stygian;
import net.minecraft.nbt.*;
import net.minecraft.item.*;

public class NBTHelper
{
	public static void removeStackTag(ItemStack stack, String name)
	{
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey(name)) stack.getTagCompound().removeTag(name);
		else
		{
			NBTTagCompound tag = new NBTTagCompound();
			stack.setTagCompound(tag);
		}
	}
	
	public static void setStackInt(ItemStack stack, String name, int value)
	{
		if(stack.hasTagCompound()) stack.getTagCompound().setInteger(name, value);
		else
		{
			NBTTagCompound tag = new NBTTagCompound();
			tag.setInteger(name, value);
			stack.setTagCompound(tag);
		}
	}
	
	public static int getStackInt(ItemStack stack, String name)
	{
		return getStackInt(stack, name, 0, false);
	}
	
	public static int getStackInt(ItemStack stack, String name, int _default, boolean setDefault)
	{
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey(name, 3)) return stack.getTagCompound().getInteger(name);
		else
		{
			if(setDefault) setStackInt(stack, name, _default);
			return _default;
		}
	}
	
	public static void removeStackInt(ItemStack stack, String name)
	{
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey(name, 3)) stack.getTagCompound().removeTag(name);
		else
		{
			NBTTagCompound tag = new NBTTagCompound();
			stack.setTagCompound(tag);
		}
	}
	
	public static void setStackDouble(ItemStack stack, String name, double value)
	{
		if(stack.hasTagCompound()) stack.getTagCompound().setDouble(name, value);
		else
		{
			NBTTagCompound tag = new NBTTagCompound();
			tag.setDouble(name, value);
			stack.setTagCompound(tag);
		}
	}
	
	public static double getStackDouble(ItemStack stack, String name)
	{
		return getStackDouble(stack, name, 0, false);
	}
	
	public static double getStackDouble(ItemStack stack, String name, double _default, boolean setDefault)
	{
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey(name, 6)) return stack.getTagCompound().getDouble(name);
		else
		{
			if(setDefault) setStackDouble(stack, name, _default);
			return _default;
		}
	}
	
	public static void removeStackDouble(ItemStack stack, String name)
	{
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey(name, 6)) stack.getTagCompound().removeTag(name);
		else
		{
			NBTTagCompound tag = new NBTTagCompound();
			stack.setTagCompound(tag);
		}
	}
	
	public static void setStackCompoundTag(ItemStack stack, String name, NBTTagCompound value)
	{
		if(stack.hasTagCompound()) stack.getTagCompound().setTag(name, value);
		else
		{
			NBTTagCompound tag = new NBTTagCompound();
			tag.setTag(name, value);
			stack.setTagCompound(tag);
		}
	}
	
	public static NBTTagCompound getStackCompoundTag(ItemStack stack, String name)
	{
		return getStackCompoundTag(stack, name, null, false);
	}
	
	public static NBTTagCompound getStackCompoundTag(ItemStack stack, String name, NBTTagCompound _default, boolean setDefault)
	{
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey(name, 10)) return (NBTTagCompound)stack.getTagCompound().getTag(name);
		else
		{
			if(setDefault) setStackCompoundTag(stack, name, _default);
			return _default;
		}
	}
	
	public static void setStackFloat(ItemStack stack, String name, float value)
	{
		if(stack.hasTagCompound()) stack.getTagCompound().setFloat(name, value);
		else
		{
			NBTTagCompound tag = new NBTTagCompound();
			tag.setFloat(name, value);
			stack.setTagCompound(tag);
		}
	}
	
	public static float getStackFloat(ItemStack stack, String name)
	{
		return getStackFloat(stack, name, 0, false);
	}
	
	public static float getStackFloat(ItemStack stack, String name, float _default, boolean setDefault)
	{
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey(name, 5)) return stack.getTagCompound().getFloat(name);
		else
		{
			if(setDefault) setStackFloat(stack, name, _default);
			return _default;
		}
	}
	
	public static void removeStackFloat(ItemStack stack, String name)
	{
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey(name, 5)) stack.getTagCompound().removeTag(name);
		else
		{
			NBTTagCompound tag = new NBTTagCompound();
			stack.setTagCompound(tag);
		}
	}
}
