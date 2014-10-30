package net.condorcraft110.stygian.util;

import java.io.*;
import net.minecraftforge.common.config.*;
import net.condorcraft110.stygian.worldgen.*;

public class StygianConfig
{
	public static boolean showDescriptions, enableDevCapes;
	
	public static void readAndSet(File configDir)
	{
		Configuration config = new Configuration(new File(configDir, "stygian.cfg"));
		
		showDescriptions = config.get("misc", "ShowItemDescriptions", false).getBoolean();
		enableDevCapes = config.get("misc", "EnableDevCapes", true).getBoolean();
		
		WorldGenHandler.stygianClusters = config.get("oregen", "StygianOreClustersPerChunk", 1).getInt();
		WorldGenHandler.stygianClusterSize = config.get("oregen", "StygianClusterSize", 8).getInt();
		WorldGenHandler.stygianMaxY = config.get("oregen", "StygianClusterMaxY", 16).getInt();
		WorldGenHandler.stygianMinY = config.get("oregen", "StygianClusterMinY", 8).getInt();
		
		WorldGenHandler.pyroniumClusters = config.get("oregen", "PyroniumOreClustersPerChunk", 6).getInt();
		WorldGenHandler.pyroniumClusterSize = config.get("oregen", "PyroniumClusterSize", 8).getInt();
		WorldGenHandler.pyroniumMaxY = config.get("oregen", "PyroniumClusterMaxY", 32).getInt();
		WorldGenHandler.pyroniumMinY = config.get("oregen", "PyroniumClusterMinY", 0).getInt();
		
		WorldGenHandler.cryoniteClusters = config.get("oregen", "CryoniteOreClustersPerChunk", 6).getInt();
		WorldGenHandler.cryoniteClusterSize = config.get("oregen", "CryoniteClusterSize", 8).getInt();
		WorldGenHandler.cryoniteMaxY = config.get("oregen", "CryoniteClusterMaxY", 32).getInt();
		WorldGenHandler.cryoniteMinY = config.get("oregen", "CryoniteClusterMinY", 0).getInt();
		
		WorldGenHandler.stupidGeneration = config.get("stupidity", "StupidGeneration", false).getBoolean();
		
		if(config.hasChanged()) config.save();
	}
}
