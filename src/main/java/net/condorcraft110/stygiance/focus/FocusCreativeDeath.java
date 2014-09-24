package net.condorcraft110.stygiance.focus;

import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;

public class FocusCreativeDeath implements ICoreFocus
{
	public String focusName()
	{
		return "death";
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase victim, EntityLivingBase attacker)
	{
		victim.attackEntityFrom(DamageSource.generic, Float.MAX_VALUE);
		
		return true;
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float f, float g, float h)
	{
		return false;
	}
	
	public int maxDamage(ItemStack stack)
	{
		return 0;
	}
	
	public boolean crackedTick(ItemStack stack, World world, Entity entity, int i, boolean b)
	{
		return false;
	}
	
}
