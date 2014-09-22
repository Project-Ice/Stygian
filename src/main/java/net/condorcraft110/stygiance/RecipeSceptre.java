package net.condorcraft110.stygiance;

import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.inventory.*;
import net.minecraft.item.crafting.*;
import net.condorcraft110.stygiance.focus.*;

public class RecipeSceptre implements IRecipe
{
	private final ICoreFocus focus;
	
	public RecipeSceptre(ICoreFocus focus)
	{
		this.focus = focus;
	}
	
	public boolean matches(InventoryCrafting inv, World world)
	{
		try
		{
			ItemStack stack0 = inv.getStackInRowAndColumn(2, 0);
			ItemStack stack1 = inv.getStackInRowAndColumn(1, 1);
			ItemStack stack2 = inv.getStackInRowAndColumn(0, 2);
			// TODO ifs instead of ?:
			return stack0.getItem() == Items.blaze_rod && stack1.getItem() == Stygian.sceptreCoreCradle && (stack2.getItem() instanceof ItemStygianCore && FocusRegistry.getFocus(stack2.getItemDamage()) == focus);
		}
		catch(NullPointerException e)
		{
			return false;
		}
	}
	
	public ItemStack getCraftingResult(InventoryCrafting inv)
	{
		return new ItemStack(FocusRegistry.getSceptreForFocus(focus));
	}
	
	public int getRecipeSize()
	{
		return 3;
	}
	
	public ItemStack getRecipeOutput()
	{
		return null;
	}
}
