package net.condorcraft110.stygian.item;

import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;

public class ItemElderSword extends ItemSword
{
	public IIcon handleIcon;
	public IIcon bladeIcon;
	
	public ItemElderSword(ToolMaterial material)
	{
		super(material);
	}
	
	public void registerIcons(IIconRegister register)
	{
		handleIcon = register.registerIcon("stygian:elderSwordHandle");
		bladeIcon = register.registerIcon("stygian:elderSword");
	}
}
