package net.condorcraft110.stygian.block;

import cpw.mods.fml.common.network.internal.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.condorcraft110.stygian.core.*;
import net.condorcraft110.stygian.tileentity.*;

public class BlockSoulForge extends Block implements ITileEntityProvider
{
	private final boolean active;
	
	private IIcon frontIcon, sideIcon, topIcon, bottomIcon;
	
	public BlockSoulForge(boolean active)
	{
		super(Material.rock);
		
		this.active = active;
	}

	public TileEntity createNewTileEntity(World world, int i)
	{
		return new TileEntitySoulForge();
	}
	
	public boolean hasTileEntity(int metadata)
	{
		return true;
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote)
		{
			FMLNetworkHandler.openGui(player, Stygian.INSTANCE, 0, world, x, y, z);
		}
		
		return true;
	}
	
	public void registerBlockIcons(IIconRegister register)
	{
		frontIcon = register.registerIcon("stygian:soulForgeFront" + (active ? "On" : "Off"));
		sideIcon = register.registerIcon("stygian:soulForgeSide");
		topIcon = register.registerIcon("stygian:soulForgeTop");
		bottomIcon = register.registerIcon("stygian:soulForgeBottom");
	}
	
	public IIcon getIcon(int side, int metadata)
	{
		switch(side)
		{
			case 0:
				return bottomIcon;
			case 1:
				return topIcon;
			case 2:
			case 3:
			case 4:
				return sideIcon;
			case 5:
				return frontIcon;
		}
		
		return null;
	}
	
	public static void updateBlockState(boolean active, World world, int x, int y, int z, TileEntitySoulForge tesf)
	{
		Block block = world.getBlock(x, y, z);
		
		if(block instanceof BlockSoulForge)
		{
			if(active && block == Stygian.soulForgeInactive)
			{
				world.setBlock(x, y, z, Stygian.soulForgeActive, 0, 3);
				world.setTileEntity(x, y, z, tesf);
			}
			else if(!active && block == Stygian.soulForgeActive)
			{
				world.setBlock(x, y, z, Stygian.soulForgeInactive, 0, 3);
				world.setTileEntity(x, y, z, tesf);
			}
		}
	}
}
