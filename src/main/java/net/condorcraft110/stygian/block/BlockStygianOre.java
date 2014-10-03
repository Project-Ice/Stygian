package net.condorcraft110.stygian.block;

import java.util.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.material.*;
import net.condorcraft110.stygian.core.*;
import net.minecraft.client.renderer.texture.*;

public class BlockStygianOre extends Block
{
	private final Item dropItem;
	private final int dropMetadata;
	private final String textureName;
	
	public BlockStygianOre(Item dropItem, int dropMetadata, String textureName)
	{
		super(Material.rock);
		
		this.dropItem = dropItem;
		this.dropMetadata = dropMetadata;
		this.textureName = textureName;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = register.registerIcon("stygian:" + textureName);
	}
	
	public IIcon getIcon(int i, int j)
	{
		return blockIcon;
	}
	
	public Item getItemDropped(int i, Random j, int k)
    {
        return dropItem;
    }
	
	public int getExpDrop(IBlockAccess access, int i, int j)
	{
		return MathHelper.getRandomIntegerInRange(Stygian.stygianRandom, 10, 50);
	}
	
	public int damageDropped(int i)
	{
		return dropMetadata;
	}
}
