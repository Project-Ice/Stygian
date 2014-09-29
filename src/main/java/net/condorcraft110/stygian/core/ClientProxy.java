package net.condorcraft110.stygian.core;

import cpw.mods.fml.common.network.*;
import cpw.mods.fml.client.registry.*;
import net.condorcraft110.stygian.gui.*;
import net.condorcraft110.stygian.render.*;
import net.condorcraft110.stygian.tileentity.*;

public class ClientProxy extends CommonProxy
{
	public int getStygianRenderIndex()
	{
		return RenderingRegistry.addNewArmourRendererPrefix("stygian");
	}
	
	public int getVoidChestRenderingIndex()
	{
		return RenderingRegistry.getNextAvailableRenderId();
	}
	
	public void registerGuiHandler()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(Stygian.INSTANCE, new StygianGuiHandler());
	}
	
	public void registerRenderers()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVoidChest.class, new VoidChestRenderer());
	}
}
