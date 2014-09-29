package net.condorcraft110.stygian.gui;

import org.lwjgl.opengl.*;

import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.gui.inventory.*;
import net.condorcraft110.stygian.container.*;
import net.condorcraft110.stygian.tileentity.*;

public class GuiVoidChest extends GuiContainer
{
	private static final ResourceLocation bgImage = new ResourceLocation("stygian", "textures/gui/voidChest.png");
	
	public GuiVoidChest(TileEntityVoidChest entity, InventoryPlayer inv)
	{
		super(new ContainerVoidChest(entity, inv));
		
		xSize = 247;
		ySize = 239;
	}
	
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		Minecraft.getMinecraft().renderEngine.bindTexture(bgImage);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
}
