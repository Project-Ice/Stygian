package net.condorcraft110.stygian.energies.focus;

import java.util.List;

import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.player.*;
import net.condorcraft110.stygian.projectile.*;

public class FocusCreativeDeath implements ICoreFocus
{
	public String getFocusName()
	{
		return "death";
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase victim, EntityLivingBase attacker)
	{
		if(victim instanceof EntityDragon)
		{
			BossUtil.attackDragonFrom((EntityDragon)victim, DamageSource.generic, Float.POSITIVE_INFINITY);
		}
		else victim.attackEntityFrom(DamageSource.generic, Float.POSITIVE_INFINITY);
		
		return true;
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float f, float g, float h)
	{
		return false;
	}
	
	public int maxDamage(ItemStack stack)
	{
		return 0; // NYI
	}
	
	public boolean crackedTick(ItemStack stack, World world, Entity entity, int i, boolean b)
	{
		return false;
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		world.spawnEntityInWorld(new ProjectileDeath(world, player));
		
		return stack;
	}
	
	public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean b)
	{
		
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b)
	{
		list.add("Creative only");
	}
	
	public int[] getRGBAColours()
	{
		return new int[]{0, 0, 0, 255};
	}
}
