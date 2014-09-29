package net.condorcraft110.stygian.gui;

import org.lwjgl.opengl.*;

import net.minecraft.util.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.*;
import net.condorcraft110.stygian.container.*;
import net.condorcraft110.stygian.tileentity.*;

public class GuiSoulForge extends GuiContainer
{
	private static final ResourceLocation bgImage = new ResourceLocation("stygian", "textures/gui/soulForge.png");
	
	private final TileEntitySoulForge tesf;
	
	public GuiSoulForge(TileEntitySoulForge entity, InventoryPlayer inv)
	{
		super(new ContainerSoulForge(entity, inv));
		
		xSize = 175;
		ySize = 209;
		
		this.tesf = entity;
	}
	
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		Minecraft.getMinecraft().renderEngine.bindTexture(bgImage);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		if(tesf.isBurning())
		{
			System.out.println("Rendering progress");
			int i1 = tesf.getBurnTimeRemainingScaled(13);
            this.drawTexturedModalRect(guiLeft + 49, guiTop + 76 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
            i1 = tesf.getForgeTimeScaled(24);
            this.drawTexturedModalRect(guiLeft + 89, guiTop + 35, 176, 14, i1 + 1, 16);
		}
	}
}
