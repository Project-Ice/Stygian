package net.condorcraft110.stygian.worldgen;

import java.util.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import cpw.mods.fml.common.*;
import net.minecraft.world.chunk.*;
import net.condorcraft110.stygian.core.*;

public class WorldGenHandler implements IWorldGenerator
{
	public static int stygianClusters = 1;
	public static int stygianClusterSize = 8;
	public static int stygianMaxY = 16;
	public static int stygianMinY = 8;
	
	public static int pyroniumClusters = 6;
	public static int pyroniumClusterSize = 8;
	public static int pyroniumMaxY = 32;
	public static int pyroniumMinY = 0;
	
	public static int cryoniteClusters = 6;
	public static int cryoniteClusterSize = 8;
	public static int cryoniteMaxY = 32;
	public static int cryoniteMinY = 0;
	
	public static boolean stupidGeneration = false;
	
	private static final WorldGenOre generateStygian = new WorldGenOre(Blocks.netherrack, Stygian.stygianOre, 0, stygianClusterSize);
	private static final WorldGenOre generatePyronium = new WorldGenOre(Blocks.stone, Stygian.pyroniumOre, 0, pyroniumClusterSize);
	private static final WorldGenOre generateCryonite = new WorldGenOre(Blocks.stone, Stygian.cryoniteOre, 0, cryoniteClusterSize);
	
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
			generatePyronium.generate(world, random, x, y, z);
		}
		
		for(int i = 0; i < cryoniteClusters; i++)
		{
			int x = chunkX + random.nextInt(16); 
			int y = cryoniteMinY + random.nextInt(cryoniteMaxY - cryoniteMinY);
			int z = chunkZ + random.nextInt(16);
			generateCryonite.generate(world, random, x, y, z);
		}
	}
	
	private void generateNether(World world, Random random, int chunkX, int chunkZ)
	{
		for(int i = 0; i < stygianClusters; i++)
		{
			int x = chunkX + random.nextInt(16); 
			int y = stygianMinY + random.nextInt(stygianMaxY - stygianMinY);
			int z = chunkZ + random.nextInt(16);
			generateStygian.generate(world, random, x, y, z);
		}
	}
}
