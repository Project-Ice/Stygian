package net.condorcraft110.stygian.energies.focus;

import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraft.server.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.monster.*;
import net.condorcraft110.stygian.core.*;
import net.condorcraft110.stygian.util.*;
import net.condorcraft110.stygian.registry.*;
import net.condorcraft110.stygian.dimension.*;

public class FocusTeleporter implements ICoreFocus
{
	public String getFocusName()
	{
		return "teleporter";
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
		if(player instanceof EntityPlayerMP)
		{
			EntityPlayerMP playerMP = (EntityPlayerMP)player;
			MinecraftServer server = MinecraftServer.getServer();
			
			if(stack != null && stack.getItem() == Stygian.sceptre
					&& stack.getItemDamage() == 0
					&& FocusRegistry.getFocus(stack.getTagCompound().getInteger("FocusID")) instanceof FocusTeleporter)
			{

				if(playerMP.dimension != Stygian.sideworldDimensionID)
				{
					NBTHelper.setStackCompoundTag(stack, "PreviousPlayerData", StygianUtil.writePlayerPositionToTag(playerMP));
					
					server.getConfigurationManager().transferPlayerToDimension(playerMP, Stygian.sideworldDimensionID, new TeleporterSideworld(server.worldServerForDimension(Stygian.sideworldDimensionID)));
					playerMP.addPotionEffect(StygianUtil.createIncurablePotionEffect(Potion.blindness.id, 20, 10));
					if(!playerMP.capabilities.disableDamage) playerMP.setHealth(playerMP.getHealth() * 0.75f);
				}
				else
				{
					NBTTagCompound tag = NBTHelper.getStackCompoundTag(stack, "PreviousPlayerData");
					
					if(tag != null)
					{
						int dimension = tag.getInteger("Dimension");
						server.getConfigurationManager().transferPlayerToDimension(playerMP, dimension, new TeleporterSideworld(server.worldServerForDimension(dimension)));
						playerMP.addPotionEffect(StygianUtil.createIncurablePotionEffect(Potion.blindness.id, 20, 10));
						if(!playerMP.capabilities.disableDamage) playerMP.setHealth(playerMP.getHealth() * 0.75f);
					}
					else
					{
						Stygian.logger.info("Teleporter ItemStack " + stack.toString() + " does not have a PreviousPlayerData NBT tag, weird things may happen >:)");
						
						switch(Stygian.stygianRandom.nextInt(7))
						{
							case 0:
								playerMP.addPotionEffect(StygianUtil.createIncurablePotionEffect(Potion.confusion.id, 400, 1));
								playerMP.addPotionEffect(StygianUtil.createIncurablePotionEffect(Potion.hunger.id, 400, 5));
								playerMP.addPotionEffect(StygianUtil.createIncurablePotionEffect(Potion.poison.id, 400, 3));
								playerMP.addPotionEffect(StygianUtil.createIncurablePotionEffect(Potion.blindness.id, 400, 10));
								break;
							case 1:
								playerMP.setFire(20);
								break;
							case 2:
								EntityCreeper creeper = new EntityCreeper(world);
								creeper.setLocationAndAngles(playerMP.posX, playerMP.posY + 1.0, playerMP.posZ, playerMP.rotationYaw, playerMP.rotationPitch);
								if(Stygian.stygianRandom.nextInt(5) == 0) creeper.getDataWatcher().updateObject(17, Byte.valueOf((byte)1));
								world.spawnEntityInWorld(creeper);
								break;
							case 3:
								playerMP.addPotionEffect(StygianUtil.createIncurablePotionEffect(Potion.wither.id, 300, 0));
								break;
							case 4:
								if(Stygian.stygianRandom.nextInt(2) == 0)
								{
									EntityGiantZombie giant = new EntityGiantZombie(world);
									giant.setLocationAndAngles(playerMP.posX, playerMP.posY + 1.0, playerMP.posZ, playerMP.rotationYaw, playerMP.rotationPitch);
									world.spawnEntityInWorld(giant);
								}
								break;
						}
					}
				}
			}
		}
		
		return stack;
	}
	
	public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean b)
	{
		
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b)
	{
		
	}
	
	public int[] getRGBAColours()
	{
		return new int[]{0, 0, 255, 255};
	}
}
