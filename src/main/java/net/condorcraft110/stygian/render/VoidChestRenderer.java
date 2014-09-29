package net.condorcraft110.stygian.render;

import org.lwjgl.opengl.*;
import net.minecraft.util.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.model.*;
import net.minecraftforge.common.util.*;
import net.condorcraft110.stygian.tileentity.*;
import net.minecraft.client.renderer.tileentity.*;

public class VoidChestRenderer extends TileEntitySpecialRenderer
{
	private final ResourceLocation texture = new ResourceLocation("stygian", "textures/models/voidChest.png");
	private final ModelChest model = new ModelChest();
	
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float var8) 
	{
		if(!(tile instanceof TileEntityVoidChest))
		{
			TileEntityVoidChest tevc = (TileEntityVoidChest)tile;
			
			bindTexture(texture);
			GL11.glPushMatrix();
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float) x, (float) y + 1.0F, (float) z + 1.0F);
			GL11.glScalef(1.0F, -1.0F, -1.0F);
			float adjustedLidAngle = tevc.previousLidAngle + (tevc.lidAngle - tevc.previousLidAngle) * var8;
			adjustedLidAngle = 1.0F - adjustedLidAngle;
			adjustedLidAngle = 1.0F - adjustedLidAngle * adjustedLidAngle * adjustedLidAngle;
			model.chestLid.rotateAngleX = -(adjustedLidAngle * (float) Math.PI / 2.0F);
			model.renderAll();
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
			GL11.glPopMatrix();
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}
