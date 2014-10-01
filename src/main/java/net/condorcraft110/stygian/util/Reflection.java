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
	
	public static PotionEffect createIncurablePotionEffect(int potionID, int duration, int amplifier)
	{
		PotionEffect effect = new PotionEffect(potionID, duration, amplifier);
		
		for(Field field : effect.getClass().getFields())
		{
			if(field.getType() == ArrayList.class)
			{
				field.setAccessible(true);
				
				try
				{
					ArrayList list = (ArrayList)field.get(effect);
					list.clear();
				}
				catch(Exception e)
				{
					throw new StygianException(e); // should never happen
				}
				
				break;
			}
		}
		
		return effect;
	}
}
