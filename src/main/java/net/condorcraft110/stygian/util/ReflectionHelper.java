package net.condorcraft110.stygian.util;

import java.util.*;
import java.lang.reflect.*;
import net.minecraft.block.*;
import net.minecraft.potion.*;
import net.minecraft.block.material.*;

public class ReflectionHelper
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
	
	public static void setFinalField(Field field, Object obj, Object value)
	{
		try
		{
			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
			
			field.setAccessible(true);
			
			field.set(obj, value);
		}
		catch(Exception e)
		{
			throw new StygianException(e);
		}
	}
}
