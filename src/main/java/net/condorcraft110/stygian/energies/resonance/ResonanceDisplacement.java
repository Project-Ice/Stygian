package net.condorcraft110.stygian.energies.resonance;

import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.condorcraft110.stygian.core.*;
import net.condorcraft110.stygian.util.*;

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
		
		if(world.blockExists(i, j, k))
		{
			boolean flag1 = false;
			
			while (!flag1 && j > 0)
			{
				Block block = world.getBlock(i, j - 1, k);
				
				if(block.getMaterial().blocksMovement() && !world.isAnyLiquid(player.boundingBox))
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

				if(world.getCollidingBoundingBoxes(player, player.boundingBox).isEmpty())
				{
					flag = true;
				}
				else if(!world.isRemote) Stygian.logger.info("Collision found");
			}
		}
		else if(!world.isRemote) Stygian.logger.info("Block doesn't exist");
			
		if(!flag)
		{
			player.setPosition(d3, d4, d5);
			if(!world.isRemote) Stygian.logger.info("failed");
		}
		else
		{
			StygianUtil.doEnderTeleportEffects(player, d3, d4, d5);
		}
	
		return stack;
	}
}
