package net.condorcraft110.stygian.core;

import cpw.mods.fml.client.registry.*;

public class ClientProxy extends CommonProxy
{
	public int getStygianRenderIndex()
	{
		return RenderingRegistry.addNewArmourRendererPrefix("stygian");
	}
}
