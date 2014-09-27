package net.condorcraft110.stygian.container;

import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;
import net.condorcraft110.stygian.tileentity.*;

public class ContainerSoulForge extends Container
{
	private final TileEntitySoulForge tesf;
	
	public ContainerSoulForge(TileEntitySoulForge tesf)
	{
		this.tesf = tesf;
		
		this.addSlotToContainer(new Slot(tesf, 0, 1, 1));
	}
	
	public boolean canInteractWith(EntityPlayer p_75145_1_)
	{
		return false;
	}
}
