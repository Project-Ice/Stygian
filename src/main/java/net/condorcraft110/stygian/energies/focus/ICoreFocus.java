package net.condorcraft110.stygian.energies.focus;

import java.util.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;

public interface ICoreFocus
{
	public String getFocusName();
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase victim, EntityLivingBase attacker);
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float f, float g, float h);
	
	public int maxDamage(ItemStack stack); // NYI
	
	public boolean crackedTick(ItemStack stack, World world, Entity entity, int i, boolean b); // NYI
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player);
	
	//public boolean isUnstable();
	
	public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean b);
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b);
}
