package net.condorcraft110.stygian.util;

import java.util.*;
import net.minecraft.item.*;

public class RecipeManager
{
	private static final ArrayList<ForgeRecipe> forgeRecipes = new ArrayList<ForgeRecipe>();
	
	public static void registerForgeRecipe(ForgeRecipe recipe)
	{
		forgeRecipes.add(recipe);
	}
	
	public static ItemStack getForgeOutput(ItemStack[][] input)
	{
		for(ForgeRecipe recipe : forgeRecipes)
		{
			ItemStack stack = recipe.getOutput(input);
			
			if(stack != null) return stack;
		}
		
		return null;
	}
}
