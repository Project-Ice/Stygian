package net.condorcraft110.stygian.util;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

public class StygianUtil
{
	public static PotionEffect createIncurablePotionEffect(int id, int duration, int amplifier)
	{
		PotionEffect effect = new PotionEffect(id, duration, amplifier);
		
		effect.getCurativeItems().clear();
		
		return effect;
	}
	
	public static boolean areItemStacksEqualIgnoringSize(ItemStack stack0, ItemStack stack1)
	{
		if(stack0 == stack1) return true;
		
		boolean result = stack0 != null && stack1 != null;
		
		ItemStack resizedStack0 = stack0.copy();
		ItemStack resizedStack1 = stack1.copy();
		
		resizedStack0.stackSize = resizedStack1.stackSize = 1;
		result = result && ItemStack.areItemStacksEqual(resizedStack0, resizedStack1);
		
		// FIXME
		/*if(result && stack0 != null && stack1 != null)
		{
			if(stack0.hasTagCompound() != stack1.hasTagCompound()) result = false;
			else if(stack0.hasTagCompound() && stack1.hasTagCompound())
			{
				NBTTagCompound tag0 = stack0.getTagCompound();
				NBTTagCompound tag1 = stack1.getTagCompound();
				
				Map map0 = null;
				Map map1 = null;
				
				try
				{
					for(Field field : NBTTagCompound.class.getDeclaredFields())
					{
						if(field.getType() == Map.class)
						{
							field.setAccessible(true);
							map0 = (Map)field.get(tag0);
							map1 = (Map)field.get(tag1);
						}
					}
				}
				catch(Exception e)
				{
					throw new StygianException(e);
				}
				
				if(map0 == null || map1 == null) throw new StygianException("Error comparing ItemStacks!");

				Iterator iterator0 = map0.keySet().iterator();
				Iterator iterator1 = map1.keySet().iterator();
				
				while(iterator0.hasNext())
				{
					String key0 = (String)iterator0.next();
					
					while(iterator1.hasNext())
					{
						String key1 = (String)iterator1.next();
						
						result = result && (key0.equals("Count") || key1.equals("Count") || key0.equals(key1) || (map0.get(key0).equals(map1.get(key0)) && map0.get(key1).equals(map0.get(key1))));
						
						if(!result) break;
					}
					
					if(!result) break;
				}
				
				result = result && !(iterator0.hasNext() || iterator1.hasNext());
			}
		}*/
		
		return result;
	}
	
	public static boolean areItemStacksEqualIgnoringDamage(ItemStack stack0, ItemStack stack1)
	{
		if(stack0 == stack1) return true;
		
		boolean result = stack0 != null && stack1 != null;
		
		ItemStack undamagedStack0 = stack0.copy();
		ItemStack undamagedStack1 = stack1.copy();
		
		undamagedStack0.setItemDamage(0);
		undamagedStack1.setItemDamage(0);
		result = result && ItemStack.areItemStacksEqual(undamagedStack0, undamagedStack1);
		
		return result;
	}
	
	public static boolean areItemStacksEqualIgnoringSizeAndDamage(ItemStack stack0, ItemStack stack1)
	{
		if(stack0 == stack1) return true;
		
		boolean result = stack0 != null && stack1 != null;
		
		ItemStack cleanedStack0 = stack0.copy();
		ItemStack cleanedStack1 = stack1.copy();
		
		cleanedStack0.stackSize = cleanedStack1.stackSize = 0;
		cleanedStack0.setItemDamage(0);
		cleanedStack1.setItemDamage(0);
		
		result = result && ItemStack.areItemStacksEqual(cleanedStack0, cleanedStack1);
		
		return result;
	}
}
