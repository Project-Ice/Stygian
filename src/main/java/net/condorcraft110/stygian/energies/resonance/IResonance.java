package net.condorcraft110.stygian.energies.resonance;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;

public interface IResonance
{
	public String getResonanceName();
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase victim, EntityLivingBase attacker);
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float f, float g, float h);
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player);
}
