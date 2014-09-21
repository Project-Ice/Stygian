package net.condorcraft110.stygiance;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLightningRod extends Item {
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float f, float g, float h) {
		EntityLightningBolt lightning = new EntityLightningBolt(world, x, y, z);
		
		world.spawnEntityInWorld(lightning);
		
		return true;
	}

}
