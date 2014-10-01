package net.condorcraft110.stygian.container;

import cpw.mods.fml.relauncher.*;
import net.condorcraft110.stygian.tileentity.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.tileentity.*;

public class ContainerNetherForge extends Container
{
	private TileEntityNetherForge tenf;
	private int lastCookTime, lastBurnTime, lastItemBurnTime;

	public ContainerNetherForge(TileEntityNetherForge tenf, InventoryPlayer player)
	{
		this.tenf = tenf;
		
		addSlotToContainer(new Slot(tenf, 0, 56, 17));
		addSlotToContainer(new Slot(tenf, 1, 56, 53));
		addSlotToContainer(new SlotFurnace(player.player, tenf, 2, 116, 35));
		int i;

		for(i = 0; i < 3; i++)
		{
			for(int j = 0; j < 9; ++j)
			{
				addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for(i = 0; i < 9; i++)
		{
			addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
		}
	}

	public void addCraftingToCrafters(ICrafting crafting)
	{
		super.addCraftingToCrafters(crafting);
		crafting.sendProgressBarUpdate(this, 0, tenf.progress);
		crafting.sendProgressBarUpdate(this, 1, tenf.burnTime);
		crafting.sendProgressBarUpdate(this, 2, tenf.currentItemBurnTime);
	}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();

		for(int i = 0; i < crafters.size(); i++)
		{
			ICrafting icrafting = (ICrafting)crafters.get(i);

			if(lastCookTime != tenf.progress)
			{
				icrafting.sendProgressBarUpdate(this, 0, tenf.progress);
			}

			if(lastBurnTime != tenf.burnTime)
			{
				icrafting.sendProgressBarUpdate(this, 1, tenf.burnTime);
			}

			if(lastItemBurnTime != tenf.currentItemBurnTime)
			{
				icrafting.sendProgressBarUpdate(this, 2, tenf.currentItemBurnTime);
			}
		}

		lastCookTime = tenf.progress;
		lastBurnTime = tenf.burnTime;
		lastItemBurnTime = tenf.currentItemBurnTime;
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int p_75137_1_, int p_75137_2_)
	{
		if(p_75137_1_ == 0)
		{
			tenf.progress = p_75137_2_;
		}

		if(p_75137_1_ == 1)
		{
			tenf.burnTime = p_75137_2_;
		}

		if(p_75137_1_ == 2)
		{
			tenf.currentItemBurnTime = p_75137_2_;
		}
	}

	public boolean canInteractWith(EntityPlayer p_75145_1_)
	{
		return tenf.isUseableByPlayer(p_75145_1_);
	}

	/**
	 * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	 */
	public ItemStack transferStackInSlot(EntityPlayer player, int slotID)
	{
		ItemStack stack = null;
		Slot slot = (Slot)inventorySlots.get(slotID);
		
		if(slot != null && slot.getHasStack())
		{
			ItemStack stack1 = slot.getStack();
			stack = stack1.copy();
			
			if(slotID == 2)
			{
				if(!mergeItemStack(stack1, 3, 39, true))
				{
					return null;
				}
				
				slot.onSlotChange(stack1, stack);
			}
			else if(slotID != 1 && slotID != 0)
			{
				if(FurnaceRecipes.smelting().getSmeltingResult(stack1) != null)
				{
					if(!mergeItemStack(stack1, 0, 1, false))
					{
						return null;
					}
				}
				else if(TileEntityFurnace.isItemFuel(stack1))
				{
					if(!mergeItemStack(stack1, 1, 2, false))
					{
						return null;
					}
				}
				else if(slotID >= 3 && slotID < 30)
				{
					if(!mergeItemStack(stack1, 30, 39, false))
					{
						return null;
					}
				}
				else if(slotID >= 30 && slotID < 39 && !mergeItemStack(stack1, 3, 30, false))
				{
					return null;
				}
			}
			else if(!mergeItemStack(stack1, 3, 39, false))
			{
				return null;
			}
			
			if(stack1.stackSize == 0)
			{
				slot.putStack((ItemStack)null);
			}
			else
			{
				slot.onSlotChanged();
			}
			
			if(stack1.stackSize == stack.stackSize)
			{
				return null;
			}
			
			slot.onPickupFromSlot(player, stack1);
		}
		
		return stack;
	}
}
