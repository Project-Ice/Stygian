package net.condorcraft110.stygian.util;

import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;

public class PlayerLookHelper
{
	public static void forcePlayerToLookAtEntity(EntityPlayer player, Entity entityToLookAt, float increment)
	{
		forcePlayerToLookAtEntity(player, entityToLookAt, increment, increment);
	}
	
	public static void forcePlayerToLookAtEntity(EntityPlayer player, Entity entityToLookAt, float yawIncrement, float pitchIncrement)
	{
		double d0 = entityToLookAt.posX - player.posX;
		double d2 = entityToLookAt.posZ - player.posZ;
		double d1;
		
		if(entityToLookAt instanceof EntityLivingBase)
		{
			EntityLivingBase entityLiving = (EntityLivingBase)entityToLookAt;
			d1 = entityLiving.posY + (double)entityLiving.getEyeHeight() - (player.posY + (double)player.getEyeHeight());
		}
		else
		{
			d1 = (entityToLookAt.boundingBox.minY + entityToLookAt.boundingBox.maxY) / 2.0 - (player.posY + (double)player.getEyeHeight());
		}
		
		double d3 = (double)MathHelper.sqrt_double(d0 * d0 + d2 * d2);
		float f2 = (float)(Math.atan2(d2, d0) * 180.0 / Math.PI) - 90.0F;
		float f3 = (float)(-(Math.atan2(d1, d3) * 180.0 / Math.PI));
		player.rotationPitch = updateRotation(player.rotationPitch, f3, pitchIncrement);
		player.rotationYaw = updateRotation(player.rotationYaw, f2, yawIncrement);
	}
	
	private static float updateRotation(float currentRotation, float intendedRotation, float increment)
	{
		float f3 = MathHelper.wrapAngleTo180_float(intendedRotation - currentRotation);
		
		if(f3 > increment)
		{
			f3 = increment;
		}
		
		if(f3 < -increment)
		{
			f3 = -increment;
		}
		
		return currentRotation + f3;
	}
}
