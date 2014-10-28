package net.condorcraft110.stygian.projectile;

import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.boss.*;

public class ProjectileDeath extends ProjectileBase
{
	public ProjectileDeath(World world) 
	{
		super(world);
	}
	
	public ProjectileDeath(World world, EntityLivingBase entity) 
	{
		super(world, entity);
	}
	
	public ProjectileDeath(World world, double x, double y, double z) 
	{
		super(world, x, y, z);
	}
	
	public void hitEntity(Entity entity)
	{
		if(entity instanceof EntityDragon)
		{
			BossUtil.attackDragonFrom((EntityDragon)entity, DamageSource.generic, Float.POSITIVE_INFINITY);
		}
		else entity.attackEntityFrom(DamageSource.generic, Float.POSITIVE_INFINITY);
	}
	
	protected float getGravityVelocity()
	{
		return 0.0F;
	}
	
	public void hitBlock(int x, int y, int z, int side)
	{
		Block block = worldObj.getBlock(x, y, z);
		
		if(block != Blocks.glass && block != Blocks.glass_pane)
		{
			setDead();
		}
	}
}
