package net.condorcraft110.stygiance;

import java.io.*;

import net.minecraftforge.common.config.*;

public class StygianConfig
{
	public static void readAndSet(File configDir)
	{
		Configuration config = new Configuration(new File(configDir, "stygiance.cfg"));
		
		WorldGenNetherOreHandler.clusters = config.get("oregen", "OreClustersPerChunk", 1).getInt();
		WorldGenNetherOreHandler.clusterSize = config.get("oregen", "ClusterSize", 8).getInt();
		WorldGenNetherOreHandler.maxY = config.get("oregen", "ClusterMaxY", 16).getInt();
		WorldGenNetherOreHandler.minY = config.get("oregen", "ClusterMinY", 8).getInt();
		
		if(config.hasChanged()) config.save();
	}
}
