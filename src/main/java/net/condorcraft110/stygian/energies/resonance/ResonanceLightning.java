package net.condorcraft110.stygian.energies.resonance;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;

import net.minecraft.entity.effect.*;
import net.minecraft.entity.player.*;
import net.condorcraft110.stygian.entity.*;
import net.condorcraft110.stygian.energies.resonance.*;

public class ResonanceLightning implements IResonance
{
	public String resonanceName()
	{
		return "lightning";
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase victim, EntityLivingBase attacker)
	{
		EntityDarkLightning lightning = new EntityDarkLightning(victim.worldObj, victim.posX, victim.posY, victim.posZ);
		//EntityLightningBolt lightning = new EntityLightningBolt(victim.worldObj, victim.posX, victim.posY, victim.posZ);
		
		victim.worldObj.addWeatherEffect(lightning);
		
		return true;
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float f, float g, float h)
	{
		EntityDarkLightning lightning = new EntityDarkLightning(world, x, y, z);
		//EntityLightningBolt lightning = new EntityLightningBolt(world, x, y, z);
		
		world.spawnEntityInWorld(lightning);
		
		return true;
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		return stack;
	}
}
