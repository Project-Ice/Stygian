package net.condorcraft110.stygian.item;

import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import cpw.mods.fml.relauncher.*;
import net.minecraftforge.common.*;
import net.minecraft.entity.player.*;
import net.condorcraft110.stygian.core.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraftforge.common.ISpecialArmor.*;

public class ItemResonanceArmour extends ItemArmor implements ISpecialArmor
{
	private IIcon[] icons = new IIcon[4];
	
	public ItemResonanceArmour(ArmorMaterial material, int renderIndex, int type)
	{
		super(material, renderIndex, type);
	}
	
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot)
	{
		stack.damageItem(damage, entity);
	}
	
	public int getArmorDisplay(EntityPlayer player, ItemStack stack, int slot)
	{
		return 40;
	}
	
	public ArmorProperties getProperties(EntityLivingBase entity, ItemStack stack, DamageSource source, double damage, int slot)
	{
		if(source == source.inFire || source == source.lava || source == source.onFire)
		{
			return new ArmorProperties(0, Integer.MAX_VALUE, getMaxDamage() + 1 - stack.getItemDamage());
		}
		else if(source == source.wither)
		{
			return new ArmorProperties(0, MathHelper.ceiling_double_int(damage * 0.5D), MathHelper.ceiling_double_int((getMaxDamage() + 1 - stack.getItemDamage()) * 0.5D));
		}
		
		return new ArmorProperties(0, 0, 0);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		icons[0] = register.registerIcon("stygian:resonanceHelmet");
		icons[1] = register.registerIcon("stygian:resonanceChestplate");
		icons[2] = register.registerIcon("stygian:resonanceLeggings");
		icons[3] = register.registerIcon("stygian:resonanceBoots");
		
		if(this == Stygian.resonanceHelmet) itemIcon = icons[0];
		else if(this == Stygian.resonanceChestplate) itemIcon = icons[1];
		else if(this == Stygian.resonanceLeggings) itemIcon = icons[2];
		else if(this == Stygian.resonanceBoots) itemIcon = icons[3];
	}
	 
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		Item item = stack.getItem();
		if(item == Stygian.resonanceHelmet) return icons[0];
		else if(item == Stygian.resonanceChestplate) return icons[1];
		else if(item == Stygian.resonanceLeggings) return icons[2];
		else if(item == Stygian.resonanceBoots) return icons[3];
		return null;
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		Item item = stack.getItem();
		if(item == Stygian.resonanceHelmet || item == Stygian.resonanceChestplate || item == Stygian.resonanceBoots)
		{
			return "stygian:textures/models/armor/resonance_layer_1.png";
		}
		return "stygian:textures/models/armor/resonance_layer_2.png";
	}
}
