package net.condorcraft110.stygian.core;

import cpw.mods.fml.common.registry.*;
import net.condorcraft110.stygian.tileentity.*;

public class CommonProxy
{
	public int getStygianRenderIndex()
	{
		return -1;
	}
	
	public int getVoidChestRenderingIndex()
	{
		return -1;
	}
	
	public int getResonanceRenderIndex()
	{
		return -1;
	}
	
	public int getDarkResonanceRenderIndex()
	{
		return -1;
	}
	
	public int getCryoniteRenderIndex()
	{
		return -1;
	}
	
	public int getPyroniumRenderIndex()
	{
		return -1;
	}
	
	public void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntitySoulForge.class, "soulForge");
		GameRegistry.registerTileEntity(TileEntityVoidChest.class, "voidChest");
		GameRegistry.registerTileEntity(TileEntityNetherForge.class, "netherForge");
	}
	
	public void registerRenderers()
	{
		
	}
	
	public void registerCapes()
	{
		
	}
	
	public void registerTickHandlers()
	{
		
	}
}
