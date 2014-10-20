package net.condorcraft110.stygian.energies.resonance;

import net.minecraft.nbt.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.condorcraft110.stygian.core.Stygian;
import net.condorcraft110.stygian.util.*;

public class ResonanceRecall implements IResonance
{
	public String getResonanceName()
	{
		return "recall";
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
		if(player.isSneaking())
		{
			NBTHelper.setStackCompoundTag(stack, "RecallPosition", StygianUtil.writePlayerPositionToTag(player));
			
			if(!world.isRemote) player.addChatMessage(new ChatComponentText("Recall position set"));
		}
		else
		{
			NBTTagCompound tag = NBTHelper.getStackCompoundTag(stack, "RecallPosition");
			
			if(tag != null)
			{
				if(player.dimension == tag.getInteger("Dimension"))
				{
					player.setLocationAndAngles(tag.getDouble("X"),
							tag.getDouble("Y"),
							tag.getDouble("Z"),
							tag.getFloat("Yaw"),
							tag.getFloat("Pitch"));
					
					player.rotationYawHead = tag.getFloat("YawHead");
				}
				else
				{
					if(!world.isRemote) player.addChatMessage(new ChatComponentText("Cannot teleport between dimensions!"));
				}
			}
			else
			{
				if(!world.isRemote) player.addChatMessage(new ChatComponentText("No recall position set!"));
			}
		}
		
		return stack;
	}
}
