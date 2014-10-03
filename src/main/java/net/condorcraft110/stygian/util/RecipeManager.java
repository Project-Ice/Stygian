package net.condorcraft110.stygian.util;

import java.util.*;
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
		ItemStack active = new ItemStack(Stygian.stygianCrystal, 1, 1);
		
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianHelmet), new ItemStack[][]{new ItemStack[]{active, active, active}, new ItemStack[]{active, null, active}, new ItemStack[]{null, null, null}}));
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianHelmet), new ItemStack[][]{new ItemStack[]{null, null, null}, new ItemStack[]{active, active, active}, new ItemStack[]{active, null, active}}));
		
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianChestplate), new ItemStack[][]{new ItemStack[]{active, null, active}, new ItemStack[]{active, active, active}, new ItemStack[]{active, active, active}}));
		
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianLeggings), new ItemStack[][]{new ItemStack[]{active, active, active}, new ItemStack[]{active, null, active}, new ItemStack[]{active, null, active}}));
		
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianBoots), new ItemStack[][]{new ItemStack[]{active, null, active}, new ItemStack[]{active, null, active}, new ItemStack[]{null, null, null}}));
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianBoots), new ItemStack[][]{new ItemStack[]{null, null, null}, new ItemStack[]{active, null, active}, new ItemStack[]{active, null, active}}));
		
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianSword), new ItemStack[][]{new ItemStack[]{active, null, null}, new ItemStack[]{active, null, null}, new ItemStack[]{new ItemStack(Items.blaze_rod), null, null}}));
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianSword), new ItemStack[][]{new ItemStack[]{null, active, null}, new ItemStack[]{null, active, null}, new ItemStack[]{null, new ItemStack(Items.blaze_rod), null}}));
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianSword), new ItemStack[][]{new ItemStack[]{null, null, active}, new ItemStack[]{null, null, active}, new ItemStack[]{null, null, new ItemStack(Items.blaze_rod)}}));
		
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianPickaxe), new ItemStack[][]{new ItemStack[]{active, active, active}, new ItemStack[]{null, new ItemStack(Items.blaze_rod), null}, new ItemStack[]{null, new ItemStack(Items.blaze_rod), null}}));
		
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianShovel), new ItemStack[][]{new ItemStack[]{active, null, null}, new ItemStack[]{new ItemStack(Items.blaze_rod), null, null}, new ItemStack[]{new ItemStack(Items.blaze_rod), null, null}}));
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianShovel), new ItemStack[][]{new ItemStack[]{null, active, null}, new ItemStack[]{null, new ItemStack(Items.blaze_rod), null}, new ItemStack[]{null, new ItemStack(Items.blaze_rod), null}}));
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianShovel), new ItemStack[][]{new ItemStack[]{null, null, active}, new ItemStack[]{null, null, new ItemStack(Items.blaze_rod)}, new ItemStack[]{null, null, new ItemStack(Items.blaze_rod)}}));
		
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianAxe), new ItemStack[][]{new ItemStack[]{active, active, null}, new ItemStack[]{active, new ItemStack(Items.blaze_rod), null}, new ItemStack[]{null, new ItemStack(Items.blaze_rod), null}}));
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianAxe), new ItemStack[][]{new ItemStack[]{null, active, active}, new ItemStack[]{null, new ItemStack(Items.blaze_rod), active}, new ItemStack[]{null, new ItemStack(Items.blaze_rod), null}}));
		
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianHoe), new ItemStack[][]{new ItemStack[]{active, active, null}, new ItemStack[]{null, new ItemStack(Items.blaze_rod), null}, new ItemStack[]{null, new ItemStack(Items.blaze_rod), null}}));
		registerForgeRecipe(new ForgeRecipe(new ItemStack(Stygian.stygianHoe), new ItemStack[][]{new ItemStack[]{null, active, active}, new ItemStack[]{null, new ItemStack(Items.blaze_rod), null}, new ItemStack[]{null, new ItemStack(Items.blaze_rod), null}}));
	}
}
