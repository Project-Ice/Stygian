package net.condorcraft110.stygian.util;

import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;

public class NBTHelper
{
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
}
