package net.condorcraft110.stygian.item;

import java.util.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.creativetab.*;
import net.minecraft.client.renderer.texture.*;

public class ItemResource extends Item
{
	private final String[] iconNames = new String[]{"pyroniumIngot", "cryoniteCrystal"};
	private IIcon[] icons = new IIcon[iconNames.length];
	
	public ItemResource()
	{
		setHasSubtypes(true);
	}
	
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for(int i = 0; i < iconNames.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	public IIcon getIconFromDamage(int damage)
	{
		return icons[MathHelper.clamp_int(damage, 0, iconNames.length)];
	}
	
	public void registerIcons(IIconRegister register)
	{
		for(int i = 0; i < iconNames.length; i++)
		{
			icons[i] = register.registerIcon("stygian:" + iconNames[i]);
		}
	}
	
	public String getUnlocalizedName(ItemStack stack)
	{
		return iconNames[stack.getItemDamage()];
	}
}
