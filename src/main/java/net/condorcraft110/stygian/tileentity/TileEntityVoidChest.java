package net.condorcraft110.stygian.tileentity;

import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;

public class TileEntityVoidChest extends TileEntityBase
{
	private ItemStack[] contents = new ItemStack[91];
	
	public float lidAngle, previousLidAngle;
	public int playersUsing;
	
	public TileEntityVoidChest()
	{
		super("container.voidChest");
	}
	
	public void updateEntity()
	{
		previousLidAngle = lidAngle;
		float angleIncrement = 0.1F;
		double adjustedXCoord, adjustedZCoord;
		
		if(playersUsing > 0 && lidAngle == 0.0F)
		{
			adjustedXCoord = xCoord + 0.5D;
			adjustedZCoord = zCoord + 0.5D;
			worldObj.playSoundEffect(adjustedXCoord, yCoord + 0.5D, adjustedZCoord, "random.chestopen", 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
		}

		if((playersUsing == 0 && lidAngle > 0.0F) || (playersUsing > 0 && lidAngle < 1.0F))
		{
			float var8 = lidAngle;

			if(playersUsing > 0)
			{
				lidAngle += angleIncrement;
			}
			else
			{
				lidAngle -= angleIncrement;
			}

			if(lidAngle > 1.0F)
			{
				lidAngle = 1.0F;
			}

			if(lidAngle < 0.5F && var8 >= 0.5F)
			{
				adjustedXCoord = xCoord + 0.5D;
				adjustedZCoord = zCoord + 0.5D;
				worldObj.playSoundEffect(adjustedXCoord, yCoord + 0.5D, adjustedZCoord, "random.chestclosed", 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
			}

			if (lidAngle < 0.0F)
			{
			   lidAngle = 0.0F;
			}
		}
	}

	public int getSizeInventory()
	{
		return 91;
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
	
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack stack)
	{
		return true;
	}
	
	public void openInventory()
	{
		playersUsing++;
		
	}
	
	public void closeInventory()
	{
		playersUsing--;
	}
	
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		
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
		
		NBTTagList list = new NBTTagList();
		
		for(int i = 0; i < getSizeInventory(); i++)
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
