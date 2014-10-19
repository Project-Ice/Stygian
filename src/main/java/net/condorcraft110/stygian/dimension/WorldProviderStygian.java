package net.condorcraft110.stygian.dimension;

import net.minecraft.world.*;
import net.minecraft.world.biome.*;

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
		return "Leaving the Sideworld";
	}
	
	public void registerWorldChunkManager()
	{
		worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.forest, 0.0F);
	}
}
