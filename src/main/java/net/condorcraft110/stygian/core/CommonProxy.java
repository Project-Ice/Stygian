package net.condorcraft110.stygian.core;

import cpw.mods.fml.common.registry.*;
import net.condorcraft110.stygian.tileentity.*;

public class CommonProxy
{
	public int getStygianRenderIndex()
	{
		return -1;
	}
	
	public void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntitySoulForge.class, "tileEntitySoulForge");
	}
	
	public void registerGuiHandler()
	{
		
	}
}
