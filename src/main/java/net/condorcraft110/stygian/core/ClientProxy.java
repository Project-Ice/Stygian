package net.condorcraft110.stygian.core;

import cpw.mods.fml.common.network.*;
import cpw.mods.fml.client.registry.*;
import net.condorcraft110.stygian.gui.*;

public class ClientProxy extends CommonProxy
{
	public int getStygianRenderIndex()
	{
		return RenderingRegistry.addNewArmourRendererPrefix("stygian");
	}
	
	public void registerGuiHandler()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(Stygian.INSTANCE, new StygianGuiHandler());
	}
}
