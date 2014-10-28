package net.condorcraft110.stygian.entity;

import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.monster.*;
import net.condorcraft110.stygian.core.*;
import net.condorcraft110.stygian.util.*;

public class EntityWatchmaker extends EntityLiving implements IBossDisplayData, IMob, IRangedAttackMob
{
	public EntityWatchmaker(World world)
	{
		super(world);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1000.0);
		setHealth(getMaxHealth());
		isImmuneToFire = true;
		ignoreFrustumCheck = true;
		addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, Integer.MAX_VALUE, Integer.MAX_VALUE));
	}
	
	public void onUpdate()
	{
		
	}
	
	public void attackEntityWithRangedAttack(EntityLivingBase target, float f)
	{
		if(target instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)target;
			player.addPotionEffect(StygianUtil.createIncurablePotionEffect(Stygian.potionTimeSickness.id, Integer.MAX_VALUE, 2));
			player.attackEntityFrom(Stygian.damageSourceTime, target.getHealth() / 2.0F);
			PlayerLookHelper.forcePlayerToLookAtEntity(player, this, 1.0F);
		}
	}
	
	public boolean attackEntityFrom(DamageSource source, float damage)
	{
		return source == Stygian.damageSourceAttackWatchmaker ? super.attackEntityFrom(source, damage) : false;
	}
}
