package net.condorcraft110.stygiance;

import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import cpw.mods.fml.relauncher.*;
import net.minecraftforge.common.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraftforge.common.ISpecialArmor.*;

public class ItemStygianArmour extends ItemArmor// implements ISpecialArmor
{
	private IIcon[] icons = new IIcon[4];
	
	public ItemStygianArmour(ArmorMaterial material, int renderIndex, int type)
	{
		super(material, renderIndex, type);
	}
	
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot)
	{
		stack.damageItem(1, entity);
	}
	
	public int getArmorDisplay(EntityPlayer player, ItemStack stack, int slot)
	{
		return 40;
	}
	
	public ArmorProperties getProperties(EntityLivingBase entity, ItemStack stack, DamageSource source, double damage, int slot)
	{
		if(source == source.inFire || source == source.lava || source == source.onFire)
		{
			return new ArmorProperties(1, 1, MathHelper.ceiling_double_int(damage));
		}
		else if(source == source.wither)
		{
			return new ArmorProperties(1, 1, MathHelper.ceiling_double_int(damage * 0.5D));
		}
		
		return new ArmorProperties(0, 0, 0);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		icons[0] = register.registerIcon("stygian:stygianHelmet");
		icons[1] = register.registerIcon("stygian:stygianChestplate");
		icons[2] = register.registerIcon("stygian:stygianLeggings");
		icons[3] = register.registerIcon("stygian:stygianBoots");
		
		if(this == Stygian.stygianHelmet) itemIcon = icons[0];
		else if(this == Stygian.stygianChestplate) itemIcon = icons[1];
		else if(this == Stygian.stygianLeggings) itemIcon = icons[2];
		else if(this == Stygian.stygianBoots) itemIcon = icons[3];
	}
	 
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		Item item = stack.getItem();
		if(item == Stygian.stygianHelmet) return icons[0];
		else if(item == Stygian.stygianChestplate) return icons[1];
		else if(item == Stygian.stygianLeggings) return icons[2];
		else if(item == Stygian.stygianBoots) return icons[3];
		return null;
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		Item item = stack.getItem();
		if(item == Stygian.stygianHelmet || item == Stygian.stygianChestplate || item == Stygian.stygianBoots)
		{
			return "stygian:textures/models/armor/stygian_layer_1.png";
		}
		return "stygian:textures/models/armor/stygian_layer_2.png";
	}
}
