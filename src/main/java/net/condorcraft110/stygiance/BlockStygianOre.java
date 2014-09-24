package net.condorcraft110.stygiance;

import java.util.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.*;

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
        return Stygian.stygianCrystal;
    }
	
	public int getExpDrop(IBlockAccess access, int i, int j)
	{
		return MathHelper.getRandomIntegerInRange(Stygian.stygianRandom, 10, 50);
	}
}
