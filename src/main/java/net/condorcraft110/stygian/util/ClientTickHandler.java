package net.condorcraft110.stygian.util;

import cpw.mods.fml.common.eventhandler.*;
import net.condorcraft110.stygian.render.*;
import cpw.mods.fml.common.gameevent.TickEvent.*;

public class ClientTickHandler
{
	@SubscribeEvent
	public void onRenderTick(RenderTickEvent event)
	{
		RenderElderTools.hue += 0.011F;
	}
}
