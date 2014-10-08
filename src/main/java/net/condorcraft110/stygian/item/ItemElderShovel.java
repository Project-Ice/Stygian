package net.condorcraft110.stygian.item;

import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.texture.*;

public class ItemElderShovel extends ItemSpade
{
	private IIcon headIcon;
	private IIcon handleIcon;
	
	public ItemElderShovel(ToolMaterial material)
	{
		super(material);
	}
	
	public void registerIcons(IIconRegister register)
	{
		headIcon = register.registerIcon("stygian:elderShovel");
		handleIcon = register.registerIcon("stygian:elderShovelHandle");
	}
	
	public IIcon getIcon(ItemStack stack, int pass)
	{
		return MathHelper.clamp_int(pass, 0, 1) == 0 ? handleIcon : headIcon;
	}
}
