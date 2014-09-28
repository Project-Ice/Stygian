package net.condorcraft110.stygian.container;

import net.minecraft.item.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;
import net.condorcraft110.stygian.slot.*;
import net.condorcraft110.stygian.tileentity.*;

public class ContainerSoulForge extends Container
{
	private final TileEntitySoulForge tesf;
	
	public ContainerSoulForge(TileEntitySoulForge tesf, InventoryPlayer inv)
	{
		this.tesf = tesf;
		
		// player inv
		for(int j = 0; j < 3; j++)
		{
			for(int i = 0; i < 9; i++)
			{
				addSlotToContainer(new Slot(inv, 9 + i + j * 9, 8 + i * 18, 128 + j * 18));
			}
		}
		
		/// player hotbar
		for(int i = 0; i < 9; i++)
		{
			addSlotToContainer(new Slot(inv, i, 8 + i * 18, 186));
		}
		
		
		// forge crafting slots
		for(int j = 0; j < 3; j++)
		{
			for(int i = 0; i < 3; i++)
			{
				addSlotToContainer(new Slot(tesf, 2 + i + j * 3, 30 + i * 18, 17 + j * 18));
			}
		}
		
		// fuel slot
		addSlotToContainer(new Slot(tesf, 0, 48, 92));
		
		// result slot
		addSlotToContainer(new SlotSoulForge(tesf, 1, 124, 35, true));
	}
	
	public boolean canInteractWith(EntityPlayer player)
	{
		return tesf.isUseableByPlayer(player);
	}
	
	public ItemStack transferStackInSlot(EntityPlayer player, int slot)
	{
		return null;
	}
}
