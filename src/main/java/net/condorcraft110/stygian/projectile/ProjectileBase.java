package net.condorcraft110.stygian.projectile;

import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;

public class ProjectileBase extends EntityThrowable
{
	public ProjectileBase(World world) 
	{
		super(world);
	}
	
	public ProjectileBase(World world, EntityLivingBase entity) 
	{
		super(world, entity);
	}
	
	public ProjectileBase(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}
	
	protected void onImpact(MovingObjectPosition position)
	{
		switch(position.typeOfHit)
		{
			case ENTITY:
				hitEntity(position.entityHit);
			case BLOCK:
				hitBlock(position.blockX, position.blockZ, position.blockZ, position.sideHit);
			case MISS:
				miss();
		}
	}
	
	public void hitEntity(Entity entity) {}
	
	public void hitBlock(int x, int y, int z, int side)
	{
		setDead();
	}
	
	public void miss() {}
}
