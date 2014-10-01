package net.condorcraft110.stygian.block;

import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.material.*;
import net.condorcraft110.stygian.core.*;
import cpw.mods.fml.common.network.internal.*;
import net.condorcraft110.stygian.tileentity.*;

public class BlockVoidChest extends Block implements ITileEntityProvider
{
	public BlockVoidChest()
	{
		super(Material.rock);
	}
	
	public TileEntity createNewTileEntity(World world, int i)
	{
		return new TileEntityVoidChest();
	}
	
	public boolean hasTileEntity(int metadata)
	{
		return true;
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote)
		{
			FMLNetworkHandler.openGui(player, Stygian.INSTANCE, 1, world, x, y, z);
		}
		
		return true;
	}
	
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	public int getRenderType()
	{
		return Stygian.voidChestRenderIndex;
	}
	
	public boolean shouldSideBeRendered(IBlockAccess access, int i, int j, int k, int l)
	{
		return false;
	}
}
