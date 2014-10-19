package net.condorcraft110.stygian.block;

import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraftforge.fluids.*;
import net.minecraft.block.material.*;
import net.condorcraft110.stygian.util.*;
import net.minecraft.client.renderer.texture.*;

public class BlockFluidLiquidDarkness extends BlockFluidClassic
{
	public IIcon fluidIcon;
	
	public BlockFluidLiquidDarkness(Fluid fluid, Material material)
	{
		super(fluid, material);
	}
	
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if(entity instanceof EntityLivingBase)
		{
			EntityLivingBase entity1 = (EntityLivingBase)entity;
			
			PotionEffect effect = StygianUtil.createIncurablePotionEffect(Potion.blindness.id, 60, Integer.MAX_VALUE);
			
			entity1.addPotionEffect(effect);
		}
	}
	
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = fluidIcon = register.registerIcon("stygian:black");
	}
}
