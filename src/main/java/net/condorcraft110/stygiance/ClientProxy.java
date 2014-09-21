package net.condorcraft110.stygiance;

import cpw.mods.fml.client.registry.*;

public class ClientProxy extends CommonProxy
{
	public int getStygianRenderIndex()
	{
		return RenderingRegistry.addNewArmourRendererPrefix("stygian");
	}
}
