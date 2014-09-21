package net.condorcraft110.stygiance;

import net.minecraft.item.*;
import net.minecraft.entity.*;

public class ItemStygianSword extends ItemSword
{
	public ItemStygianSword(ToolMaterial material)
	{
		super(material);
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase entity0, EntityLivingBase entity1)
	{
		float damage = (itemRand.nextFloat() * 2) + 1;
		
		entity0.attackEntityFrom(Stygian.damageSourceDrain, damage);
		entity1.heal(damage);
		
		return super.hitEntity(stack, entity0, entity1);
	}
}
