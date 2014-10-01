package net.condorcraft110.stygian.block;

import cpw.mods.fml.common.network.internal.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.condorcraft110.stygian.core.*;
import net.condorcraft110.stygian.tileentity.*;

public class BlockNetherForge extends Block implements ITileEntityProvider
{
	public BlockNetherForge()
	{
		super(Material.rock);
	}

	public TileEntity createNewTileEntity(World world, int i)
	{
		return new TileEntityNetherForge();
	}
	
	public boolean hasTileEntity(int metadata)
	{
		return true;
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote)
		{
			FMLNetworkHandler.openGui(player, Stygian.INSTANCE, 2, world, x, y, z);
		}
		
		return true;
	}
}
