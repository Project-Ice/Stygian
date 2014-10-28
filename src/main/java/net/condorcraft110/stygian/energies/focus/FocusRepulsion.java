package net.condorcraft110.stygian.energies.focus;

import java.util.*;

import net.minecraft.nbt.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.condorcraft110.stygian.*;
import net.minecraft.entity.player.*;
import net.condorcraft110.stygian.core.*;
import net.condorcraft110.stygian.util.*;

public class FocusRepulsion implements ICoreFocus
{
	public String getFocusName()
	{
		return "repulsion";
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase victim, EntityLivingBase attacker)
	{
		return false;
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float f, float g, float h)
	{
		return false;
	}
	
	public int maxDamage(ItemStack stack)
	{
		return 0;
	}
	
	public boolean crackedTick(ItemStack stack, World world, Entity entity, int i, boolean b)
	{
		return false;
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		NBTTagCompound tag = NBTHelper.getStackCompoundTag(stack, "RepulsionData", new NBTTagCompound(), false);
		
		if(player.isSneaking())
		{
			tag.setInteger("Mode", (tag.getInteger("Mode") + 1) % 3);
			
			if(!world.isRemote) player.addChatMessage(new ChatComponentText("Switched to mode " + tag.getInteger("Mode") + 1));//new ChatComponentTranslation("message.focus.repulsion.mode", tag.getInteger("Mode") + 1));
		}
		else
		{
			tag.setBoolean("Active", !tag.getBoolean("Active"));
			
			if(!world.isRemote) player.addChatMessage(new ChatComponentText("Now " + (tag.getBoolean("Active") ? "active" : "inactive")));
		}
		
		stack.setTagCompound(tag);
		
		return stack;
	}
	
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean isHeld)
	{
		if(world.isRemote || slot > 8 || !(entity instanceof EntityPlayer)) return;
		
		EntityPlayer player = (EntityPlayer)entity;
		
		NBTTagCompound tag = NBTHelper.getStackCompoundTag(stack, "RepulsionData", new NBTTagCompound(), true);
		
		boolean active = tag.getBoolean("Active");
		
		if(active)
		{
			List<Entity> entities = world.getEntitiesWithinAABBExcludingEntity(player, AxisAlignedBB.getBoundingBox(player.posX - 5, player.posY - 5, player.posZ - 5, player.posX + 5, player.posY + 5, player.posZ + 5));
			
			switch(tag.getInteger("Mode"))
			{
				default:
					//TODO more modes
				case 1:
					for(Entity toRepel : entities)
					{
						Vec3 playerVec3 = Vec3.createVectorHelper(player.posX, player.posY, player.posZ);
						Vec3 toRepelVec3 = Vec3.createVectorHelper(toRepel.posX, toRepel.posY, toRepel.posZ);
						
						double distance = playerVec3.distanceTo(toRepelVec3);
						
						Vec3 vec3 = Vec3.createVectorHelper(toRepelVec3.xCoord - playerVec3.xCoord, toRepelVec3.yCoord - playerVec3.yCoord, toRepelVec3.zCoord - playerVec3.zCoord);

						toRepel.motionX += vec3.xCoord / 1.5 / distance;
						toRepel.motionY += vec3.yCoord / 1.5 / distance;
						toRepel.motionZ += vec3.zCoord / 1.5 / distance;
					}
			}
		}
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b)
	{
		list.add(NBTHelper.getStackCompoundTag(stack, "RepulsionData", new NBTTagCompound(), true).getBoolean("Active") ? "Active" : "Inactive");
	}
}
