package net.condorcraft110.stygian.item;

import java.util.*;

import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.renderer.texture.*;

public class ItemStygianCrystal extends Item
{
	private IIcon[] icons = new IIcon[2];
	
	public ItemStygianCrystal()
	{
		setHasSubtypes(true);
	}
	
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
	}
	
	public String getUnlocalizedName(ItemStack stack)
	{
		return "item." + (stack.getItemDamage() == 0 ? "iS" : "s") + "tygianCrystal";
	}
	
	public void registerIcons(IIconRegister register)
	{
		icons[0] = register.registerIcon("stygian:stygianCrystalInactive");
		icons[1] = register.registerIcon("stygian:stygianCrystalActive");
	}
	
	public IIcon getIconFromDamage(int damage)
	{
		return icons[MathHelper.clamp_int(damage, 0, 1)];
	}
}
