package net.condorcraft110.stygian.util;

import java.io.*;
import net.minecraftforge.common.config.*;
import net.condorcraft110.stygian.worldgen.*;

public class StygianConfig
{
	public static boolean showDescriptions;
	
	public static void readAndSet(File configDir)
	{
		Configuration config = new Configuration(new File(configDir, "stygiance.cfg"));
		
		showDescriptions = config.get("misc", "ShowItemDescriptions", true).getBoolean();
		WorldGenHandler.stygianClusters = config.get("oregen", "StygianOreClustersPerChunk", 1).getInt();
		WorldGenHandler.stygianClusterSize = config.get("oregen", "StygianClusterSize", 8).getInt();
		WorldGenHandler.stygianMaxY = config.get("oregen", "StygianClusterMaxY", 16).getInt();
		WorldGenHandler.stygianMinY = config.get("oregen", "StygianClusterMinY", 8).getInt();
		WorldGenHandler.stygianClusters = config.get("oregen", "StygianOreClustersPerChunk", 1).getInt();
		WorldGenHandler.stygianClusterSize = config.get("oregen", "StygianClusterSize", 8).getInt();
		WorldGenHandler.stygianMaxY = config.get("oregen", "StygianClusterMaxY", 16).getInt();
		WorldGenHandler.stygianMinY = config.get("oregen", "StygianClusterMinY", 8).getInt();
		
		if(config.hasChanged()) config.save();
	}
}
