package net.condorcraft110.stygian.util;

import net.minecraft.item.*;

public class ForgeRecipe // Unrelated to Minecraft Forge
{
	private final ItemStack output;
	private final ItemStack[][] recipe;
	
	public ForgeRecipe(ItemStack output, ItemStack[][] input)
	{
		if(input.length != 3) throw new StygianException("Invalid forge recipe");
		
		for(ItemStack[] element : input)
		{
			if(element.length != 3) throw new StygianException("Invalid forge recipe");
		}
		
		this.output = output;
		this.recipe = input;
	}
	
	public ItemStack getOutput(ItemStack[][] input)
	{
		if(input == null) return null;
		
		boolean matchFound = true;
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; i < 3; i++)
			{
				if(input[i][j] == null)
				{
					if(recipe[i][j] != null)
					{
						matchFound = false;
						break;
					}
				}
				else if(!input[i][j].equals(recipe[i][j]))
				{
					matchFound = false;
					break;
				}
			}
			
			if(!matchFound) break;
		}
		
		return matchFound ? output.copy() : null;
	}
}
