package net.condorcraft110.stygian.core;

import net.minecraft.entity.player.*;
import net.minecraftforge.event.entity.*;
import cpw.mods.fml.common.eventhandler.*;
import net.condorcraft110.stygian.entity.*;
import cpw.mods.fml.common.eventhandler.Event.*;

public class StygianEventHandler
{
	@SubscribeEvent
	public void onEntityStruckByLightning(EntityStruckByLightningEvent event)
	{
		if(event.lightning instanceof EntityDarkLightning && !(event.entity instanceof EntityPlayer))
		{
			event.entity.travelToDimension(1);

			event.setResult(Result.ALLOW);
		}
	}
}
