package net.condorcraft110.stygiance;

import java.util.Random;

import net.minecraft.util.*;
import net.minecraft.block.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.item.Item;

public class BlockStygianOre extends Block
{
	public BlockStygianOre()
	{
		super(Material.rock);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = register.registerIcon("stygian:stygianOre");
	}
	
	public IIcon getIcon(int i, int j)
	{
		return blockIcon;
	}
	
	public Item getItemDropped(int i, Random j, int k)
    {
        return Stygian.inactiveStygianCrystal;
    }
}
