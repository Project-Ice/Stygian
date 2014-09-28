package net.condorcraft110.stygian.gui;

import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.player.*;
import cpw.mods.fml.common.network.*;
import net.condorcraft110.stygian.container.*;
import net.condorcraft110.stygian.tileentity.*;

public class StygianGuiHandler implements IGuiHandler
{
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity entity = world.getTileEntity(x, y, z);
		
		switch(id)
		{
			case 0:
				if(entity != null && entity instanceof TileEntitySoulForge)
				{
					return new ContainerSoulForge((TileEntitySoulForge)entity, player.inventory);
				}
		}
		
		return null;
	}
	
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity entity = world.getTileEntity(x, y, z);
		
		switch(id)
		{
			case 0:
				if(entity != null && entity instanceof TileEntitySoulForge)
				{
					return new GuiSoulForge((TileEntitySoulForge)entity, player.inventory);
				}
		}
		
		return null;
	}
}
