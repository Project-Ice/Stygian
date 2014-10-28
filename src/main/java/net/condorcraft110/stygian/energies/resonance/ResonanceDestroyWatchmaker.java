package net.condorcraft110.stygian.energies.resonance;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.condorcraft110.stygian.core.*;
import net.condorcraft110.stygian.entity.*;

public class ResonanceDestroyWatchmaker implements IResonance
{
	public String getResonanceName()
	{
		return "destroyWatchmaker";
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase victim, EntityLivingBase attacker)
	{
		if(victim instanceof EntityWatchmaker)
		{
			victim.attackEntityFrom(Stygian.damageSourceAttackWatchmaker, 10.0F);
			return true;
		}
		
		return false;
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float f, float g, float h)
	{
		return false;
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		return stack;
	}
}
