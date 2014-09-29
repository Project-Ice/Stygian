package net.condorcraft110.stygian.container;

import net.minecraft.item.*;
import net.minecraft.inventory.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.entity.player.*;
import net.condorcraft110.stygian.tileentity.*;

public class ContainerVoidChest extends Container
{
	private final TileEntityVoidChest tevc;
	
	public ContainerVoidChest(TileEntityVoidChest tevc, InventoryPlayer inv)
	{
		this.tevc = tevc;
		
		// player inv
		for(int j = 0; j < 3; j++)
		{
			for(int i = 0; i < 9; i++)
			{
				addSlotToContainer(new Slot(inv, 9 + i + j * 9, 44 + i * 18, 158 + j * 18));
			}
		}
		
		/// player hotbar
		for(int i = 0; i < 9; i++)
		{
			addSlotToContainer(new Slot(inv, i, 44 + i * 18, 216));
		}
		
		
		// chest slots
		for(int j = 0; j < 7; j++)
		{
			for(int i = 0; i < 13; i++)
			{
				addSlotToContainer(new Slot(tevc, i + j * 13, 8 + i * 18, 18 + j * 18));
			}
		}
	}
	
	public boolean canInteractWith(EntityPlayer player)
	{
		return tevc.isUseableByPlayer(player);
	}
	
	public ItemStack transferStackInSlot(EntityPlayer player, int slot)
	{
		return null;
	}
}
