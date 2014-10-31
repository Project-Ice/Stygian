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

public class ItemDarkResonanceArmour extends ItemArmor implements ISpecialArmor
{
	private static IIcon[] icons = new IIcon[4];
	
	public ItemDarkResonanceArmour(ArmorMaterial material, int renderIndex, int type)
	{
		super(material, renderIndex, type);
	}
	
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot)
	{
		if(source != source.inFire && source != source.lava && source != source.onFire) stack.damageItem(damage, entity);
	}
	
	public int getArmorDisplay(EntityPlayer player, ItemStack stack, int slot)
	{
		return 40;
	}
	
	public ArmorProperties getProperties(EntityLivingBase entity, ItemStack stack, DamageSource source, double damage, int slot)
	{
		if(source == source.inFire || source == source.lava || source == source.onFire)
		{
			return new ArmorProperties(0, 0.25, Integer.MAX_VALUE);
		}
		else if(source == source.wither || source == source.magic)
		{
			return new ArmorProperties(0, 0.2, MathHelper.ceiling_double_int((getMaxDamage() + 1 - stack.getItemDamage()) * 0.5D));
		}
		
		return new ArmorProperties(0, damageReduceAmount / 25.0, getMaxDamage() + 1 - stack.getItemDamage());
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		icons[0] = register.registerIcon("stygian:darkResonanceHelmet");
		icons[1] = register.registerIcon("stygian:darkResonanceChestplate");
		icons[2] = register.registerIcon("stygian:darkResonanceLeggings");
		icons[3] = register.registerIcon("stygian:darkResonanceBoots");
		
		if(this == Stygian.darkResonanceHelmet) itemIcon = icons[0];
		else if(this == Stygian.darkResonanceChestplate) itemIcon = icons[1];
		else if(this == Stygian.darkResonanceLeggings) itemIcon = icons[2];
		else if(this == Stygian.darkResonanceBoots) itemIcon = icons[3];
	}
	 
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		Item item = stack.getItem();
		if(item == Stygian.darkResonanceHelmet) return icons[0];
		else if(item == Stygian.darkResonanceChestplate) return icons[1];
		else if(item == Stygian.darkResonanceLeggings) return icons[2];
		else if(item == Stygian.darkResonanceBoots) return icons[3];
		return null;
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		Item item = stack.getItem();
		if(item == Stygian.darkResonanceHelmet || item == Stygian.darkResonanceChestplate || item == Stygian.darkResonanceBoots)
		{
			return "stygian:textures/models/armor/dark_resonance_layer_1.png";
		}
		return "stygian:textures/models/armor/dark_resonance_layer_2.png";
	}
}
