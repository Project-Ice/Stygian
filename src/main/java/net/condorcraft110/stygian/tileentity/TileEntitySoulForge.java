package net.condorcraft110.stygian.tileentity;

import net.minecraft.nbt.*;
import net.minecraft.item.*;
import net.minecraft.inventory.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.player.*;
import net.condorcraft110.stygian.block.BlockSoulForge;
import net.condorcraft110.stygian.core.*;
import net.condorcraft110.stygian.util.*;

public class TileEntitySoulForge extends TileEntityBase
{
	private ItemStack[] contents = new ItemStack[11];
	
	private static final int FUEL_TIME = 400;
	private static final int FORGE_TIME = 200;
	
	public int burnTime;
	public int progress;
	
	public TileEntitySoulForge()
	{
		super("container.soulForge");
	}
	
	public void updateEntity()
	{
		boolean flag0 = burnTime > 0;
		boolean flag1 = false;
		
		if(flag0) burnTime--;
		
		boolean consumedFuelCrystal = false;
		
		if(!worldObj.isRemote)
		{
			if(flag0)
			{
				if(containsRecipeItem()) forge();
				markDirty();
			}
			else if(contents[0] != null && contents[0].getItem() == Stygian.stygianCrystal && contents[0].getItemDamage() == 1 && canForge())
			{
				decrStackSize(0, 1);
				consumedFuelCrystal = true;
				markDirty();
			}
			else
			{
				progress = 0;
			}
			
			BlockSoulForge.updateBlockState(flag0, worldObj, xCoord, yCoord, zCoord, this);
		}
		
		if(consumedFuelCrystal) burnTime = FUEL_TIME;
	}
	
	private void forge()
	{
		ItemStack stack = RecipeManager.getForgeOutput(compile());
		
		if(stack != null)
		{
			if(progress >= FORGE_TIME)
			{
				progress = 0;
				if(!worldObj.isRemote)
				{
					contents[1] = stack;
					decrAllInvStacks(1);
				}
			}
			else progress++;
		}
	}
	
	public boolean containsRecipeItem()
	{
		for(int i = 2; i < 11; i++)
		{
			if(getStackInSlot(i) != null) return true;
		}
		
		return false;
	}
			
	private ItemStack[][] compile()
	{
		return new ItemStack[][]
		{
			new ItemStack[]
			{
				contents[2], contents[3], contents[4]
			},
			new ItemStack[]
			{
				contents[5], contents[6], contents[7]
			},
			new ItemStack[]
			{
				contents[8], contents[9], contents[10]
			}
		};
	}
	
	private ItemStack[] decrAllInvStacks(int amount)
	{
		ItemStack[] result = new ItemStack[9];
		
		for(int i = 2; i < 11; i++)
		{
			if(contents[i] != null)
			{
				ItemStack stack;
				
				if(contents[i].stackSize <= amount)
				{
					stack = contents[i];
					contents[i] = null;
				}
				else
				{
					stack = contents[i].splitStack(amount);
					
					if(contents[i].stackSize == 0)
					{
						contents[i] = null;
					}
				}
				
				result[i - 2] = stack;
			}
			else
			{
				result[i - 2] = null;
			}
		}
		
		return result;
	}
	
	private void clearInventory()
	{
		for(int i = 2; i < 11; i++)
		{
			contents[i] = null;
		}
	}
	
	public int getSizeInventory()
	{
		return 11;
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
		return stack != null && slot == 0 ? stack.getItem() == Stygian.stygianCrystal && stack.getItemDamage() == 1 : slot != 1;
	}
	
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		
		burnTime = (int)tag.getShort("BurnTime");
		progress = (int)tag.getShort("Progress");
		
		NBTTagList list = tag.getTagList("Contents", 10);
		
		for(int i = 0; i < list.tagCount(); i++)
		{
			NBTTagCompound tag1 = list.getCompoundTagAt(i);
			
			contents[(int)tag1.getByte("Slot")] = ItemStack.loadItemStackFromNBT(tag1);
		}
	}
	
	public void writeToNBT(NBTTagCompound tag)
	{
		super.writeToNBT(tag);
		
		tag.setShort("BurnTime", (short)burnTime);
		tag.setShort("Progress", (short)progress);
		
		NBTTagList list = new NBTTagList();
		
		for(int i = 0; i < 11; i++)
		{
			ItemStack currentContents = contents[i];
			
			if(currentContents != null)
			{
				NBTTagCompound tag1 = new NBTTagCompound();
				tag1.setByte("Slot", (byte)i);
				currentContents.writeToNBT(tag1);
				list.appendTag(tag1);
			}
		}
		
		tag.setTag("Contents", list);
	}
	
	public boolean isBurning()
	{
		return burnTime > 0;
	}
	
	public int getForgeTimeScaled(int scale)
	{
		return progress * scale / FORGE_TIME;
	}
	
	public int getBurnTimeRemainingScaled(int scale)
	{
		return burnTime * scale / FUEL_TIME;
	}
	
	public boolean canAddStackToSlot(int slot, ItemStack stack)
	{
		return stack != null && (contents[slot] == null || (contents[slot].stackSize + stack.stackSize <= getInventoryStackLimit() && (contents[slot].getItem() == stack.getItem() && contents[slot].getItemDamage() == stack.getItemDamage())));
	}
	
	public void addStackToSlot(int slot, ItemStack stack)
	{
		if(contents[slot] == null) contents[slot] = stack;
		else
		{
			// stuff
		}
	}
	
	public boolean canForge()
	{
		if(!containsRecipeItem()) return false;
		
		ItemStack result = RecipeManager.getForgeOutput(compile());
		
		return canAddStackToSlot(1, result);
	}
}
