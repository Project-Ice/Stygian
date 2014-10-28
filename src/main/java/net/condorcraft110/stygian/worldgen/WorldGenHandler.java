package net.condorcraft110.stygian.worldgen;

import java.util.*;
import net.minecraft.world.*;
import cpw.mods.fml.common.*;
import net.minecraft.world.chunk.*;
import net.condorcraft110.stygian.core.*;

public class WorldGenHandler implements IWorldGenerator
{
	public static int stygianClusters = 1;
	public static int stygianClusterSize = 8;
	public static int stygianMaxY = 8;
	public static int stygianMinY = 16;
	
	public static int pyroniumClusters = 6;
	public static int pyroniumClusterSize = 8;
	public static int pyroniumMaxY = 32;
	public static int pyroniumMinY = 0;
	
	public static int cryoniteClusters = 6;
	public static int cryoniteClusterSize = 8;
	public static int cryoniteMaxY = 32;
	public static int cryoniteMinY = 0;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.dimensionId)
		{
			case 0:
				generateSurface(world, random, chunkX * 16, chunkZ * 16);
				break;
			case -1:
				generateNether(world, random, chunkX * 16, chunkZ * 16);
				break;
		}
	}
	
	private void generateSurface(World world, Random random, int chunkX, int chunkZ)
	{
		for(int i = 0; i < pyroniumClusters; i++)
		{
			int x = chunkX + random.nextInt(16); 
			int y = pyroniumMinY + random.nextInt(pyroniumMaxY - pyroniumMinY);
			int z = chunkZ + random.nextInt(16);
			new WorldGenSurfaceOre(Stygian.pyroniumOre, 0, pyroniumClusterSize).generate(world, random, x, y, z);
		}
		
		for(int i = 0; i < cryoniteClusters; i++)
		{
			int x = chunkX + random.nextInt(16); 
			int y = cryoniteMinY + random.nextInt(cryoniteMaxY - cryoniteMinY);
			int z = chunkZ + random.nextInt(16);
			new WorldGenSurfaceOre(Stygian.cryoniteOre, 0, cryoniteClusterSize).generate(world, random, x, y, z);
		}
	}
	
	private void generateNether(World world, Random random, int chunkX, int chunkZ)
	{
		for(int i = 0; i < stygianClusters; i++)
		{
			int x = chunkX + random.nextInt(16); 
			int y = stygianMinY + random.nextInt(stygianMaxY - stygianMinY);
			int z = chunkZ + random.nextInt(16);
			new WorldGenNetherOre(Stygian.stygianOre, 0, stygianClusterSize).generate(world, random, x, y, z);
		}
	}
}
