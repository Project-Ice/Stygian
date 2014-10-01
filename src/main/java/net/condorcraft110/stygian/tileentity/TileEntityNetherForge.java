package net.condorcraft110.stygian.tileentity;

import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;
import net.minecraft.item.crafting.*;

public class TileEntityNetherForge extends TileEntityBase
{
	public static final int FORGE_TIME = 20;
	
	public ItemStack[] contents = new ItemStack[3];
	public int burnTime, progress, currentItemBurnTime;
	
	public TileEntityNetherForge()
	{
		super("container.netherForge");
	}
	
	public void updateEntity()
	{
		boolean flag = burnTime > 0;
		boolean flag1 = false;

		if(burnTime > 0)
		{
			burnTime--;
		}

		if(!worldObj.isRemote)
		{
			if(burnTime != 0 || contents[1] != null && contents[0] != null)
			{
				if(burnTime == 0 && canSmelt())
				{
					currentItemBurnTime = burnTime = TileEntityFurnace.getItemBurnTime(contents[1]);

					if(burnTime > 0)
					{
						flag1 = true;

						if(contents[1] != null)
						{
							contents[1].stackSize--;

							if(contents[1].stackSize == 0)
							{
								contents[1] = contents[1].getItem().getContainerItem(contents[1]);
							}
						}
					}
				}

				if(isBurning() && canSmelt())
				{
					progress++;

					if(progress == 200)
					{
						progress = 0;
						smeltItem();
						flag1 = true;
					}
				}
				else
				{
					progress = 0;
				}
			}

			if(flag != burnTime > 0)
			{
				flag1 = true;
				//BlockFurnace.updateFurnaceBlockState(burnTime > 0, worldObj, xCoord, yCoord, zCoord);
			}
		}

		if(flag1)
		{
			markDirty();
		}
	}
	
	public int getSizeInventory()
	{
		return 3;
	}
	
	public ItemStack getStackInSlot(int slot)
	{
		return contents[slot];
	}
	
	public ItemStack decrStackSize(int slot, int amount)
	{
		if(contents[slot] != null)
		{
			ItemStack stack;
			
			if(contents[slot].stackSize <= amount)
			{
				stack = contents[slot];
				contents[slot] = null;
			}
			else
			{
				stack = contents[slot].splitStack(amount);
				
				if(contents[slot].stackSize == 0)
				{
					contents[slot] = null;
				}
			}
			
			return stack;
		}
		
		return null;
	}
	
	public ItemStack getStackInSlotOnClosing(int slot)
	{
		return contents[slot];
	}
	
	public void setInventorySlotContents(int slot, ItemStack stack)
	{
		contents[slot] = stack;
	}
	
	public boolean isItemValidForSlot(int slot, ItemStack stack)
	{
		return true;
	}
	
	private boolean canSmelt()
    {
        if(contents[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack stack = FurnaceRecipes.smelting().getSmeltingResult(contents[0]);
            if(stack == null) return false;
            if(contents[2] == null) return true;
            if(!contents[2].isItemEqual(stack)) return false;
            int result = contents[2].stackSize + stack.stackSize;
            return result <= getInventoryStackLimit() && result <= contents[2].getMaxStackSize();
        }
    }
	
    public void smeltItem()
    {
        if(canSmelt())
        {
            ItemStack stack = FurnaceRecipes.smelting().getSmeltingResult(contents[0]);
            
            if(contents[2] == null)
            {
                contents[2] = stack.copy();
            }
            else if(contents[2].getItem() == stack.getItem())
            {
                contents[2].stackSize += stack.stackSize;
            }
            
            contents[0].stackSize--;

            if(contents[0].stackSize <= 0)
            {
                contents[0] = null;
            }
        }
    }
    
    public boolean isBurning()
    {
    	return burnTime > 0;
    }
    
    public int getBurnTimeRemainingScaled(int scale)
    {
    	return burnTime * scale / currentItemBurnTime;
    }
    
    public int getCookProgressScaled(int scale)
    {
    	return burnTime * scale / FORGE_TIME;
    }
}
