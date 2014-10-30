package net.condorcraft110.stygian.energies.focus;

import java.util.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.condorcraft110.stygian.core.*;

public class FocusWind implements ICoreFocus
{
	public String getFocusName()
	{
		return "wind";
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase victim, EntityLivingBase attacker)
	{
		double d1 = attacker.posX - victim.posX;
		double d0;

		for(d0 = attacker.posZ - victim.posZ; d1 * d1 + d0 * d0 < 1.0E-3; d0 = (Math.random() - Math.random()) * 0.1)
		{
			d1 = (Math.random() - Math.random()) * 0.1;
		}
		
		victim.isAirBorne = true;
		victim.motionX /= 2.0;
		victim.motionY /= 2.0;
		victim.motionZ /= 2.0;
		victim.motionX -= d1 * 2;
		victim.motionY += 2.0;
		victim.motionZ -= d0 * 2;
		
		if((!(attacker instanceof EntityPlayer) || !((EntityPlayer)attacker).capabilities.isCreativeMode) && Stygian.stygianRandom.nextInt(10) == 0)
		{
			attacker.motionY += 2.0;
		}
		
		return true;
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float f, float g, float h)
	{
		return false;
	}
	
	public int maxDamage(ItemStack stack)
	{
		return 1234567890; // NYI
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		return stack;
	}
	
	public boolean crackedTick(ItemStack stack, World world, Entity entity, int i, boolean b)
	{
		return false; // NYI
	}
	
	public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean b)
	{
		
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b)
	{
		
	}
}
