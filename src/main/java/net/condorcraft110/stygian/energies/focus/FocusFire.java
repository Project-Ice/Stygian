package net.condorcraft110.stygian.energies.focus;

import java.util.List;

import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;

public class FocusFire implements ICoreFocus
{
	public String getFocusName()
	{
		return "fire";
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase victim, EntityLivingBase attacker)
	{
		victim.setFire(60);
		
		return true;
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float f, float g, float h)
	{
		world.setBlock(x, y + 1, z, Blocks.fire);
		
		return true;
	}
	
	public int maxDamage(ItemStack stack)
	{
		return 1234567890; // NYI
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		return stack;
	}
	
	public boolean crackedTick(ItemStack stack, World world, Entity entity, int i, boolean b)
	{
		return false; // NYI
	}
	
	public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean b)
	{
		
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b)
	{
		
	}
}
