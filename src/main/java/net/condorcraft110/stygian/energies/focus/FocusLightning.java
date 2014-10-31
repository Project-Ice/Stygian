package net.condorcraft110.stygian.energies.focus;

import java.util.*;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.condorcraft110.stygian.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.player.*;
import net.condorcraft110.stygian.core.*;

public class FocusLightning implements ICoreFocus
{
	public String getFocusName()
	{
		return "lightning";
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase victim, EntityLivingBase attacker)
	{
		EntityLightningBolt lightning = new EntityLightningBolt(victim.worldObj, victim.posX, victim.posY, victim.posZ);
		
		victim.worldObj.spawnEntityInWorld(lightning);
		
		if((!(attacker instanceof EntityPlayer) || !((EntityPlayer)attacker).capabilities.disableDamage) && Stygian.stygianRandom.nextInt(10) == 0)
		{
			EntityLightningBolt attackerLightning = new EntityLightningBolt(attacker.worldObj, attacker.posX, attacker.posY, attacker.posZ);
			
			attacker.worldObj.spawnEntityInWorld(lightning);
		}
		
		return true;
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float f, float g, float h)
	{
		EntityLightningBolt lightning = new EntityLightningBolt(world, x, y, z);
		
		world.spawnEntityInWorld(lightning);
		
		if(!player.capabilities.disableDamage && Stygian.stygianRandom.nextInt(10) == 0)
		{
			EntityLightningBolt playerLightning = new EntityLightningBolt(world, player.posX, player.posY, player.posZ);
			
			world.spawnEntityInWorld(lightning);
		}
		
		return true;
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
		int j = Stygian.stygianRandom.nextInt(400);
		
		if(j == 0)
		{
			EntityLightningBolt lightning = new EntityLightningBolt(world, entity.posX, entity.posY, entity.posZ);
			
			world.addWeatherEffect(lightning);
			
			return true;
		}
		
		return false; // NYI
	}
	
	public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean b)
	{
		
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b)
	{
		
	}
	
	public int[] getRGBAColours()
	{
		return new int[]{3, 80, 150, 255};
	}
}
