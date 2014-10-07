package net.condorcraft110.stygian.util;

import java.util.*;

import org.apache.logging.log4j.Level;

import net.minecraft.init.*;
import net.minecraft.item.*;
import net.condorcraft110.stygian.core.*;

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
	
	public static void registerRecipes()
	{
		ItemStack crystal = new ItemStack(Stygian.stygianCrystal, 1, 1);
		ItemStack blazeRod = new ItemStack(Items.blaze_rod);
		
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianHelmet), new ItemStack[][]{new ItemStack[]{crystal, crystal, crystal}, new ItemStack[]{crystal, null, crystal}, new ItemStack[]{null, null, null}}));
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianHelmet), new ItemStack[][]{new ItemStack[]{null, null, null}, new ItemStack[]{crystal, crystal, crystal}, new ItemStack[]{crystal, null, crystal}}));
		
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianChestplate), new ItemStack[][]{new ItemStack[]{crystal, null, crystal}, new ItemStack[]{crystal, crystal, crystal}, new ItemStack[]{crystal, crystal, crystal}}));
		
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianLeggings), new ItemStack[][]{new ItemStack[]{crystal, crystal, crystal}, new ItemStack[]{crystal, null, crystal}, new ItemStack[]{crystal, null, crystal}}));
		
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianBoots), new ItemStack[][]{new ItemStack[]{crystal, null, crystal}, new ItemStack[]{crystal, null, crystal}, new ItemStack[]{null, null, null}}));
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianBoots), new ItemStack[][]{new ItemStack[]{null, null, null}, new ItemStack[]{crystal, null, crystal}, new ItemStack[]{crystal, null, crystal}}));
		
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianSword), new ItemStack[][]{new ItemStack[]{crystal, null, null}, new ItemStack[]{crystal, null, null}, new ItemStack[]{blazeRod, null, null}}));
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianSword), new ItemStack[][]{new ItemStack[]{null, crystal, null}, new ItemStack[]{null, crystal, null}, new ItemStack[]{null, blazeRod, null}}));
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianSword), new ItemStack[][]{new ItemStack[]{null, null, crystal}, new ItemStack[]{null, null, crystal}, new ItemStack[]{null, null, blazeRod}}));
		
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianPickaxe), new ItemStack[][]{new ItemStack[]{crystal, crystal, crystal}, new ItemStack[]{null, blazeRod, null}, new ItemStack[]{null, blazeRod, null}}));
		
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianShovel), new ItemStack[][]{new ItemStack[]{crystal, null, null}, new ItemStack[]{blazeRod, null, null}, new ItemStack[]{blazeRod, null, null}}));
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianShovel), new ItemStack[][]{new ItemStack[]{null, crystal, null}, new ItemStack[]{null, blazeRod, null}, new ItemStack[]{null, blazeRod, null}}));
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianShovel), new ItemStack[][]{new ItemStack[]{null, null, crystal}, new ItemStack[]{null, null, blazeRod}, new ItemStack[]{null, null, blazeRod}}));
		
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianAxe), new ItemStack[][]{new ItemStack[]{crystal, crystal, null}, new ItemStack[]{crystal, blazeRod, null}, new ItemStack[]{null, blazeRod, null}}));
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianAxe), new ItemStack[][]{new ItemStack[]{null, crystal, crystal}, new ItemStack[]{null, blazeRod, crystal}, new ItemStack[]{null, blazeRod, null}}));
		
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianHoe), new ItemStack[][]{new ItemStack[]{crystal, crystal, null}, new ItemStack[]{null, blazeRod, null}, new ItemStack[]{null, blazeRod, null}}));
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianHoe), new ItemStack[][]{new ItemStack[]{null, crystal, crystal}, new ItemStack[]{null, blazeRod, null}, new ItemStack[]{null, blazeRod, null}}));
		
		Stygian.logger.log(Level.INFO, "Registered " + forgeRecipes.size() + " forge recipes.");
	}
}
