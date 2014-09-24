package net.condorcraft110.stygiance.focus;

import net.condorcraft110.stygiance.ProjectileBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

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
		entity.attackEntityFrom(DamageSource.generic, Float.POSITIVE_INFINITY);
	}
	
	protected float getGravityVelocity()
	{
		return 0.0F;
	}
}
