package net.condorcraft110.stygiance;

import net.minecraft.item.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.creativetab.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.player.EntityPlayer;

public class ItemStygianCrystal extends Item
{
	private boolean active;
	private IIcon[] icons = new IIcon[2];
	
	public ItemStygianCrystal(boolean active)
	{
		super();
		setCreativeTab(CreativeTabs.tabMaterials);
		this.active = active;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		icons[0] = register.registerIcon("stygian:stygianCrystalInactive");
		icons[1] = register.registerIcon("stygian:stygianCrystalActive");
		
		itemIcon = active ? icons[1] : icons[0];
	}
	 
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		return active ? icons[1] : icons[0];
	}
}
