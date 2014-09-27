package net.condorcraft110.stygian.tileentity;

import net.minecraft.nbt.*;
import net.minecraft.item.*;
import net.minecraft.inventory.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.player.*;
import net.condorcraft110.stygian.core.*;
import net.condorcraft110.stygian.util.*;

public class TileEntitySoulForge extends TileEntity implements IInventory
{
	private ItemStack[] contents;
	private ItemStack[][] compiled = null;
	
	private static final int FUEL_TIME = 1600;
	private static final int FORGE_TIME = 200;
	
	private int burnTime;
	private int progress;
	
	public void updateEntity()
	{
		if(burnTime > 0) burnTime--;
		
		if(burnTime > 0)
		{
			if(containsRecipeItem()) forge();
		}
		else if(contents[0] != null && contents[0].getItem() == Stygian.stygianCrystal && contents[0].getItemDamage() == 1)
		{
			contents[0] = decrStackSize(0, 1);
			burnTime = FUEL_TIME;
		}
	}
	
	private void forge()
	{
		ItemStack stack = RecipeManager.getForgeOutput(compile());
		
		if(stack != null)
		{
			if(progress >= FORGE_TIME)
			{
				progress = 0;
				contents[1] = stack;
				clearInventory();
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
		if(compiled != null) return compiled;
		
		return compiled = new ItemStack[][]
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
	
	private void clearInventory()
	{
		for(int i = 2; i < 11; i++)
		{
			contents[i] = null;
		}
	}
	
	public int getSizeInventory()
	{
		return contents.length;
	}
	
	public ItemStack getStackInSlot(int slot)
	{
		return contents[slot];
	}
	
	public ItemStack decrStackSize(int slot, int amount)
	{
		if (contents[slot] != null)
		{
			ItemStack stack;
			
			if (contents[slot].stackSize <= amount)
			{
				stack = contents[slot];
				contents[slot] = null;
			}
			else
			{
				stack = contents[slot].splitStack(amount);
				
				if (contents[slot].stackSize == 0)
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
	
	public String getInventoryName()
	{
		return "container.soulForge";
	}
	
	public boolean hasCustomInventoryName()
	{
		return false;
	}
	
	public int getInventoryStackLimit()
	{
		return 64;
	}
	
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return true;
	}
	
	public void openInventory()
	{
		
	}
	
	public void closeInventory()
	{
		
	}
	
	public boolean isItemValidForSlot(int slot, ItemStack stack)
	{
		return stack != null && slot == 0 ? stack.getItem() == Stygian.stygianCrystal && stack.getItemDamage() == 1 : slot != 1;
	}
	
	public void readFromNBT(NBTTagCompound tag)
	{
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
}
