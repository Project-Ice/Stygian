package net.condorcraft110.stygiance;

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
		if(position.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY)
		{
			hitEntity(position.entityHit);
		}
		else if(position.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
		{
			hitBlock(position.blockX, position.blockY, position.blockZ, position.sideHit);
		}
	}
	
	public void hitEntity(Entity entity) {}
	
	public void hitBlock(int x, int y, int z, int side) {}
	
	public void miss() {}
}
