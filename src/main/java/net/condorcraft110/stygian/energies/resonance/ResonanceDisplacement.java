package net.condorcraft110.stygian.energies.resonance;

import java.awt.Paint;

import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.condorcraft110.stygian.core.*;

public class ResonanceDisplacement implements IResonance
{
	public String getResonanceName()
	{
		return "displacement";
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase victim, EntityLivingBase attacker)
	{
		return false;
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float f, float g, float h)
	{
		return false;
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if(!player.worldObj.isRemote)
		{
			double d3 = player.posX;
			double d4 = player.posY;
			double d5 = player.posZ;
			player.posX = player.posX + (Stygian.stygianRandom.nextDouble() - 0.5D) * 64.0D;
			player.posY = player.posY + (double)(Stygian.stygianRandom.nextInt(64) - 32);
			player.posZ = player.posZ + (Stygian.stygianRandom.nextDouble() - 0.5D) * 64.0D;
			boolean flag = false;
			int i = MathHelper.floor_double(player.posX);
			int j = MathHelper.floor_double(player.posY);
			int k = MathHelper.floor_double(player.posZ);
	
			if(player.worldObj.blockExists(i, j, k))
			{
				boolean flag1 = false;
				
				while (!flag1 && j > 0)
				{
					//Block block = player.worldObj.getBlock(i, j - 1, k);
					
					if(world.blockExists(i, j - 1, k))//block.getMaterial().blocksMovement())
					{
						flag1 = true;
					}
					else
					{
						player.posY--;
						j--;
					}
				}
				
				if(flag1)
				{
					player.setPosition(player.posX, player.posY, player.posZ);
	
					if(player.worldObj.getCollidingBoundingBoxes(player, player.boundingBox).isEmpty())
					{
						flag = true;
					}
					else Stygian.logger.info("Collision found");
				}
			}
			
			if(!flag)
			{
				//player.setPosition(d3, d4, d5);
				Stygian.logger.info("failed");
			}
			else
			{
				short short1 = 128;
	
				for(int l = 0; l < short1; l++)
				{
					double d6 = (double)l / ((double)short1 - 1.0D);
					float f = (Stygian.stygianRandom.nextFloat() - 0.5F) * 0.2F;
					float f1 = (Stygian.stygianRandom.nextFloat() - 0.5F) * 0.2F;
					float f2 = (Stygian.stygianRandom.nextFloat() - 0.5F) * 0.2F;
					double d7 = d3 + (player.posX - d3) * d6 + (Stygian.stygianRandom.nextDouble() - 0.5D) * (double)player.width * 2.0D;
					double d8 = d4 + (player.posY - d4) * d6 + Stygian.stygianRandom.nextDouble() * (double)player.height;
					double d9 = d5 + (player.posZ - d5) * d6 + (Stygian.stygianRandom.nextDouble() - 0.5D) * (double)player.width * 2.0D;
					player.worldObj.spawnParticle("portal", d7, d8, d9, (double)f, (double)f1, (double)f2);
				}
	
				player.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0F, 1.0F);
				player.playSound("mob.endermen.portal", 1.0F, 1.0F);
			}
		}
		
		return stack;
	}
}
