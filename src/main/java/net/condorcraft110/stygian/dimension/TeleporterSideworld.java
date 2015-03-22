package net.condorcraft110.stygian.dimension;

import net.condorcraft110.stygian.core.*;
import net.condorcraft110.stygian.energies.focus.*;
import net.condorcraft110.stygian.registry.*;
import net.condorcraft110.stygian.util.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;

public class TeleporterSideworld extends Teleporter
{
	private final WorldServer world;
	
	public TeleporterSideworld(WorldServer worldServer)
	{
		super(worldServer);
		
		this.world = worldServer;
	}
	
	public void placeInPortal(Entity entity, double x, double y, double z, float f)
	{
		if(entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)entity;
			ItemStack stack = player.getHeldItem();
			
			if(player.dimension != Stygian.sideworldDimensionID)
			{
				if(stack != null && stack.getItem() == Stygian.sceptre
						&& stack.getItemDamage() == 0
						&& FocusRegistry.getFocus(NBTHelper.getStackInt(stack, "FocusID")) instanceof FocusTeleporter)
				{
					NBTTagCompound tag = NBTHelper.getStackCompoundTag(stack, "PreviousPlayerData");
					
					player.setLocationAndAngles(tag.getDouble("X"),
							tag.getDouble("Y"),
							tag.getDouble("Z"),
							tag.getFloat("Yaw"),
							tag.getFloat("Pitch"));
					
					player.rotationYawHead = tag.getFloat("YawHead");
				}
			}
			else
			{
				NBTTagCompound tag = NBTHelper.getStackCompoundTag(stack, "PreviousPlayerData");
				
				//player.setLocationAndAngles(0.0, 64.0, 0.0, player.rotationPitch, player.rotationYaw);
				player.setLocationAndAngles(tag.getDouble("X"),
						(double)world.getTopSolidOrLiquidBlock(MathHelper.floor_double(tag.getDouble("X")),
								MathHelper.floor_double(tag.getDouble("Z"))),
						tag.getDouble("Z"),
						tag.getFloat("Yaw"),
						tag.getFloat("Pitch"));
				
				player.rotationYawHead = tag.getFloat("YawHead");
			}
		}
	}
}
