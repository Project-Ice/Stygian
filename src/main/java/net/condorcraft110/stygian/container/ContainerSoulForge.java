package net.condorcraft110.stygian.container;

import net.condorcraft110.stygian.slot.SlotSoulForge;
import net.condorcraft110.stygian.tileentity.TileEntitySoulForge;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerSoulForge extends Container
{
	private final TileEntitySoulForge tesf;
	private int burnTime;
	private int progress;
	
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
	
	@Override
	public void addCraftingToCrafters(ICrafting crafting)
	{
		super.addCraftingToCrafters(crafting);
		crafting.sendProgressBarUpdate(this, 0, tesf.burnTime);
		crafting.sendProgressBarUpdate(this, 1, tesf.progress);
	}
	
	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();

		for(int i = 0; i < this.crafters.size(); ++i)
		{
			ICrafting icrafting = (ICrafting) this.crafters.get(i);

			if(burnTime != tesf.burnTime)
			{
				icrafting.sendProgressBarUpdate(this, 0, tesf.burnTime);
			}

			if(progress != tesf.progress)
			{
				icrafting.sendProgressBarUpdate(this, 1, tesf.progress);
			}
		}
		
		burnTime = tesf.burnTime;
		progress = tesf.progress;
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int value)
	{
		if(id == 0)
		{
			tesf.burnTime = value;
		}
		
		if(id == 1)
		{
			tesf.progress = value;
		}
	}
}
