package net.condorcraft110.stygian.slot;

import net.minecraft.item.*;
import net.minecraft.inventory.*;

public class SlotSoulForge extends Slot
{
	private final boolean type;
	
	public SlotSoulForge(IInventory inv, int slotID, int x, int y, boolean type)
	{
		super(inv, slotID, x, y);
		
		this.type = type;
	}
	
	public boolean isItemValid(ItemStack stack)
	{
		return false;
	}
}
