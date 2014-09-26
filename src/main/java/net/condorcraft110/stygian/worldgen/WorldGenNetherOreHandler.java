package net.condorcraft110.stygian.worldgen;

import java.util.*;

import net.condorcraft110.stygian.core.Stygian;
import net.minecraft.world.*;
import cpw.mods.fml.common.*;
import net.minecraft.world.chunk.*;

public class WorldGenNetherOreHandler implements IWorldGenerator
{
	public static int clusters = 1;
	public static int clusterSize = 8;
	public static int maxY = 8;
	public static int minY = 16;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		if(world.provider.dimensionId == -1)
		{
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateNether(World world, Random random, int chunkX, int chunkZ)
	{
		for(int i = 0; i < clusters; i++)
		{
			int x = chunkX + random.nextInt(16); 
			int y = minY + random.nextInt(maxY - minY);
			int z = chunkZ + random.nextInt(16);
			new WorldGenNetherOre(Stygian.stygianOre, 0, clusterSize).generate(world, random, x, y, z);
		}
	}
}
