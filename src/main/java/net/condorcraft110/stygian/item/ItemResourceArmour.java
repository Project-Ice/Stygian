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

public class ItemResourceArmour extends ItemArmor implements ISpecialArmor
{
	private static IIcon[] icons = new IIcon[8];
	
	public ItemResourceArmour(ArmorMaterial material, int renderIndex, int type)
	{
		super(material, renderIndex, type);
	}
	
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot)
	{
		if(!source.isFireDamage()) stack.damageItem(damage, entity);
		else
		{
			Item item = stack.getItem();
			
			if(item == Stygian.cryoniteHelmet || item == Stygian.cryoniteChestplate || item == Stygian.cryoniteLeggings || item == Stygian.cryoniteBoots)
			{
				stack.damageItem(MathHelper.ceiling_double_int(damage * 1.1), entity);
			}
			else if(item == Stygian.pyroniumHelmet || item == Stygian.pyroniumChestplate || item == Stygian.pyroniumLeggings || item == Stygian.pyroniumBoots)
			{

				stack.damageItem(MathHelper.floor_double(damage / 1.1), entity);
			}
		}
	}
	
	public int getArmorDisplay(EntityPlayer player, ItemStack stack, int slot)
	{
		return 40;
	}
	
	public ArmorProperties getProperties(EntityLivingBase entity, ItemStack stack, DamageSource source, double damage, int slot)
	{
		if(!source.isFireDamage())
		{
			return new ArmorProperties(0, damageReduceAmount / 25.0, getMaxDamage() + 1 - stack.getItemDamage());
		}
		else
		{
			Item item = stack.getItem();
			
			if(item == Stygian.cryoniteHelmet || item == Stygian.cryoniteChestplate || item == Stygian.cryoniteLeggings || item == Stygian.cryoniteBoots)
			{
				return new ArmorProperties(0, damageReduceAmount / 15.0, getMaxDamage() + 1 - stack.getItemDamage());
			}
			else if(item == Stygian.pyroniumHelmet || item == Stygian.pyroniumChestplate || item == Stygian.pyroniumLeggings || item == Stygian.pyroniumBoots)
			{
				return new ArmorProperties(0, damageReduceAmount / 35.0, getMaxDamage() + 1 - stack.getItemDamage());
			}
		}
		
		return new ArmorProperties(0, damageReduceAmount / 25.0, getMaxDamage() + 1 - stack.getItemDamage());
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		icons[0] = register.registerIcon("stygian:cryoniteHelmet");
		icons[1] = register.registerIcon("stygian:cryoniteChestplate");
		icons[2] = register.registerIcon("stygian:cryoniteLeggings");
		icons[3] = register.registerIcon("stygian:cryoniteBoots");
		icons[4] = register.registerIcon("stygian:pyroniumHelmet");
		icons[5] = register.registerIcon("stygian:pyroniumChestplate");
		icons[6] = register.registerIcon("stygian:pyroniumLeggings");
		icons[7] = register.registerIcon("stygian:pyroniumBoots");

		if(this == Stygian.cryoniteHelmet) itemIcon = icons[0];
		else if(this == Stygian.cryoniteChestplate) itemIcon = icons[1];
		else if(this == Stygian.cryoniteLeggings) itemIcon = icons[2];
		else if(this == Stygian.cryoniteBoots) itemIcon = icons[3];
		else if(this == Stygian.pyroniumHelmet) itemIcon = icons[4];
		else if(this == Stygian.pyroniumChestplate) itemIcon = icons[5];
		else if(this == Stygian.pyroniumLeggings) itemIcon = icons[6];
		else if(this == Stygian.pyroniumBoots) itemIcon = icons[7];
	}
	 
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		Item item = stack.getItem();
		if(item == Stygian.cryoniteHelmet) return icons[0];
		else if(item == Stygian.cryoniteChestplate) return icons[1];
		else if(item == Stygian.cryoniteLeggings) return icons[2];
		else if(item == Stygian.cryoniteBoots) return icons[3];
		else if(item == Stygian.pyroniumHelmet) return icons[4];
		else if(item == Stygian.pyroniumChestplate) return icons[5];
		else if(item == Stygian.pyroniumLeggings) return icons[6];
		else if(item == Stygian.pyroniumBoots) return icons[7];
		return null;
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		Item item = stack.getItem();
		if(item == Stygian.cryoniteHelmet || item == Stygian.cryoniteChestplate || item == Stygian.cryoniteBoots)
		{
			return "stygian:textures/models/armor/cryonite_layer_1.png";
		}
		else if(item == Stygian.cryoniteLeggings)
		{
			return  "stygian:textures/models/armor/cryonite_layer_2.png";
		}
		else if(item == Stygian.pyroniumHelmet || item == Stygian.pyroniumChestplate || item == Stygian.pyroniumBoots)
		{
			return "stygian:textures/models/armor/pyronium_layer_1.png";
		}
		else if(item == Stygian.pyroniumLeggings)
		{
			return  "stygian:textures/models/armor/pyronium_layer_2.png";
		}
		return null;
	}
}
