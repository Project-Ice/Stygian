package net.condorcraft110.stygian.tileentity;

import net.minecraft.item.*;
import net.minecraft.inventory.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.player.*;

public abstract class TileEntityBase extends TileEntity implements IInventory
{
	private final String name;
	
	public TileEntityBase(String name)
	{
		this.name = name;
	}
	
	public String getInventoryName()
	{
		return name;
	}
	
	public boolean hasCustomInventoryName()
	{
		return false;
	}
	
	public int getInventoryStackLimit()
	{
		return 64;
	}
	
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_)
	{
		return true;
	}
	
	public void openInventory()
	{
		
	}
	
	public void closeInventory()
	{
		
	}
}
