package net.condorcraft110.stygian.util;

import java.util.*;
import java.lang.reflect.*;
import net.minecraft.block.*;
import net.minecraft.potion.*;
import net.minecraft.block.material.*;

public class Reflection
{
	public static Block getRawBlockInstance(Material material)
	{
		Block block = null;
		
		try
		{
			Constructor constructor = Block.class.getDeclaredConstructor(Material.class);
			constructor.setAccessible(true);
			
			block = (Block)constructor.newInstance(material);
		}
		catch(Exception e)
		{
			e.printStackTrace(); // damn
		}
		
		return block;
	}
}
