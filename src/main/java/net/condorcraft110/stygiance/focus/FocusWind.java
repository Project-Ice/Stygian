package net.condorcraft110.stygiance.focus;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;

public class FocusWind implements ICoreFocus
{
	public String focusName()
	{
		return "wind";
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase victim, EntityLivingBase attacker)
	{
		victim.knockBack(attacker, Integer.MAX_VALUE, -attacker.getLookVec().xCoord, -attacker.getLookVec().zCoord);
		return true;
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float f, float g, float h)
	{
		return false;
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
}
