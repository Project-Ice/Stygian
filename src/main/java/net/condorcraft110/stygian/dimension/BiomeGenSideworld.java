package net.condorcraft110.stygian.dimension;

import net.condorcraft110.stygian.core.Stygian;
import net.minecraft.world.biome.*;

public class BiomeGenSideworld extends BiomeGenBase
{
	public BiomeGenSideworld(int id)
	{
		super(id, false);
		
		topBlock = Stygian.stygianDirt;
		fillerBlock = Stygian.stygianDirt;
	}
}
