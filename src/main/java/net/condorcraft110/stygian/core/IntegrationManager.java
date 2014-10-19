package net.condorcraft110.stygian.core;

import net.minecraft.nbt.*;
import net.minecraft.item.*;
import cpw.mods.fml.common.event.*;
import net.condorcraft110.stygian.util.*;

public class IntegrationManager
{
	static void init()
	{
		addEMC(new ItemStack(Stygian.stygianCrystal, 1, 0), 32768);
		addEMC(new ItemStack(Stygian.stygianCrystal, 1, 1), 40960);
	}
	
	// same as Project E API for now
	// TODO tweak for soul forge
	public static void addEMC(ItemStack stack, int emc)
	{
		NBTTagCompound tag = new NBTTagCompound();
		
		stack.writeToNBT(tag);
		
		NBTHelper.setStackInt(stack, "EMC", emc);
		
		FMLInterModComms.sendMessage("ProjectE", "registerEMC", tag);
	}
}
