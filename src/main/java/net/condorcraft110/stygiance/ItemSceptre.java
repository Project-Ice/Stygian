package net.condorcraft110.stygiance;

import java.util.List;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.player.*;
import cpw.mods.fml.common.registry.*;
import net.condorcraft110.stygiance.focus.*;

public class ItemSceptre extends Item
{
	private final ICoreFocus focus;
	
	public ItemSceptre(ICoreFocus focus)
	{
		setUnlocalizedName("focusSceptre");
		setTextureName("stygian:sceptre");
		setMaxStackSize(1);
		this.focus = focus;
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float f, float g, float h)
	{
		return focus.onItemUse(stack, player, world, x, y, z, i, f, g, h);
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase victim, EntityLivingBase attacker)
	{
		return focus.hitEntity(stack, victim, attacker);
	}
	
	public boolean hasEffect(ItemStack stack)
	{
		return focus != null;
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b)
	{
		list.add(FocusRegistry.getLocalFocusName(stack.getTagCompound().getInteger("FocusID")));
	}
	
	public void registerRecipe()
	{
		GameRegistry.addRecipe(new RecipeSceptre(focus));
	}
}
