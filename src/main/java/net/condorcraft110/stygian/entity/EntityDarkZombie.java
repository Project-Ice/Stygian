package net.condorcraft110.stygian.entity;

import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.monster.*;

public class EntityDarkZombie extends EntityMob
{
	private final EntityPlayer targetPlayer;
	
	public EntityDarkZombie(World world, EntityPlayer player)
	{
		super(world);
		this.experienceValue = 10;
		this.targetPlayer = player;
	}
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(80.0);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0);
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(Double.POSITIVE_INFINITY);
	}
	
	protected Entity findPlayerToAttack()
	{
		return targetPlayer;
	}
	
	public boolean attackEntityFrom(DamageSource source, float damage)
	{
		if(source instanceof EntityDamageSource && source.getEntity().equals(targetPlayer))
		{
			super.attackEntityFrom(source, damage);
			return true;
		}
		
		return false;
	}
}
