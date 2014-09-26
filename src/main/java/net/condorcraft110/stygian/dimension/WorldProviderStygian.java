package net.condorcraft110.stygian.dimension;

import net.minecraft.world.*;

public class WorldProviderStygian extends WorldProvider
{
	public String getDimensionName()
	{
		return "Sideworld";
	}
	
	public String getWelcomeMessage()
	{
		return "Entering the Sideworld";
	}
	
	public String getDepartMessage()
	{
		return "Returning to the Overworld";
	}
}
