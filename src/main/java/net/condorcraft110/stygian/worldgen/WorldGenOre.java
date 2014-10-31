package net.condorcraft110.stygian.worldgen;

import java.util.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.feature.*;

/**
 * Slightly modified version of powercrystals' NetherOres generation code 
 * @author powercrystals
 * @author condorcraft110
 */
public class WorldGenOre extends WorldGenerator
{
	private Block target, block;
	private int metadata, numberOfBlocks;
	
	public WorldGenOre(Block target, Block block, int metadata, int numBlocks)
	{
		this.target = target;
		this.block = block;
		this.metadata = metadata;
		this.numberOfBlocks = numBlocks;
	}
	
	public boolean generate(World world, Random random, int chunkX, int y, int chunkZ)
	{
		float f = random.nextFloat() * (float)Math.PI;
		double d = (float)(chunkX + 8) + (MathHelper.sin(f) * (float)numberOfBlocks) / 8F;
		double d1 = (float)(chunkX + 8) - (MathHelper.sin(f) * (float)numberOfBlocks) / 8F;
		double d2 = (float)(chunkZ + 8) + (MathHelper.cos(f) * (float)numberOfBlocks) / 8F;
		double d3 = (float)(chunkZ + 8) - (MathHelper.cos(f) * (float)numberOfBlocks) / 8F;
		double d4 = (y + random.nextInt(3)) - 2;
		double d5 = (y + random.nextInt(3)) - 2;
		for(int blockNum = 0; blockNum <= numberOfBlocks; blockNum++)
		{
			double d6 = d + ((d1 - d) * (double)blockNum) / (double)numberOfBlocks;
			double d7 = d4 + ((d5 - d4) * (double)blockNum) / (double)numberOfBlocks;
			double d8 = d2 + ((d3 - d2) * (double)blockNum) / (double)numberOfBlocks;
			double d9 = (random.nextDouble() * (double)numberOfBlocks) / 16D;
			double d10 = (double)(MathHelper.sin(((float)blockNum * 3.141593F) / (float)numberOfBlocks) + 1.0F) * d9 + 1.0D;
			double d11 = (double)(MathHelper.sin(((float)blockNum * 3.141593F) / (float)numberOfBlocks) + 1.0F) * d9 + 1.0D;
			int xStart = MathHelper.floor_double(d6 - d10 / 2D);
			int yStart = MathHelper.floor_double(d7 - d11 / 2D);
			int zStart = MathHelper.floor_double(d8 - d10 / 2D);
			int xStop = MathHelper.floor_double(d6 + d10 / 2D);
			int yStop = MathHelper.floor_double(d7 + d11 / 2D);
			int zStop = MathHelper.floor_double(d8 + d10 / 2D);
			for(int blockX = xStart; blockX <= xStop; blockX++)
			{
				double d12 = (((double)blockX + 0.5D) - d6) / (d10 / 2D);
				if(d12 * d12 >= 1.0D)
				{
					continue;
				}
				for(int blockY = yStart; blockY <= yStop; blockY++)
				{
					double d13 = (((double)blockY + 0.5D) - d7) / (d11 / 2D);
					if(d12 * d12 + d13 * d13 >= 1.0D)
					{
						continue;
					}
					for(int blockZ = zStart; blockZ <= zStop; blockZ++)
					{
						double d14 = (((double)blockZ + 0.5D) - d8) / (d10 / 2D);
						if(d12 * d12 + d13 * d13 + d14 * d14 < 1.0D && (WorldGenHandler.stupidGeneration || world.getBlock(blockX, blockY, blockZ) == target))
						{
							world.setBlock(blockX, blockY, blockZ, block, metadata, 2);
						}
					}
				}
			}
		}
		
		return true;
	}
}