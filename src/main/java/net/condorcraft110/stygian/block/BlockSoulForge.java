package net.condorcraft110.stygian.block;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.tileentity.*;
import net.condorcraft110.stygian.core.Stygian;
import net.condorcraft110.stygian.tileentity.*;

public class BlockSoulForge extends Block implements ITileEntityProvider
{
	public BlockSoulForge()
	{
		super(Material.rock);
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
}
