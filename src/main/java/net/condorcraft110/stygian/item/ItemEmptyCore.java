package net.condorcraft110.stygian.item;

import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.condorcraft110.stygian.core.*;
import net.condorcraft110.stygian.block.*;

public class ItemEmptyCore extends Item
{
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		MovingObjectPosition position = this.getMovingObjectPositionFromPlayer(world, player, true);
		
		if(position == null)
		{
			return stack;
		}
		else
		{
			if(position.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
			{
				int i = position.blockX;
				int j = position.blockY;
				int k = position.blockZ;
				
				if(!world.canMineBlock(player, i, j, k))
				{
					return stack;
				}
				
				if(!player.canPlayerEdit(i, j, k, position.sideHit, stack))
				{
					return stack;
				}
				
				Block block = world.getBlock(i, j, k);
				
				if(block instanceof BlockFocusNode)
				{
					world.setBlockToAir(i, j, k);
					return new ItemStack(Stygian.focusCore, 1, ((BlockFocusNode)block).focusID);
				}
			}
			
			return stack;
		}
	}
}
