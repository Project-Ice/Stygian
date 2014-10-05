package net.condorcraft110.stygian.render;

import java.awt.*;
import java.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.item.*;
import net.minecraftforge.client.*;
import net.minecraft.client.renderer.entity.*;

public class RenderElderTools implements IItemRenderer
{
	private static ArrayList<ItemStack> elderItems = new ArrayList<ItemStack>();
	private static RenderItem ri = new RenderItem();
	
	private float hue = 0.0F;
	
	public boolean handleRenderType(ItemStack stack, ItemRenderType type)
	{
		return type != ItemRenderType.FIRST_PERSON_MAP && isElderItem(stack);
	}
	
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return helper == ItemRendererHelper.ENTITY_BOBBING;
	}
	
	public void renderItem(ItemRenderType type, ItemStack stack, Object... data)
	{
		ri.renderIcon(0, 0, stack.getIconIndex(), 16, 16);
		Color color = Color.getHSBColor((hue += 0.01F) % 1.0F, 1.0F, 1.0F);
		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glColor4f((float)color.getRed() / 256, (float)color.getGreen() / 256, (float)color.getBlue() / 256, 0.5F);
			
		GL11.glEnd();
	}
	
	public static void addElderItem(ItemStack stack)
	{
		if(!isElderItem(stack)) elderItems.add(stack);
	}
	
	private static boolean isElderItem(ItemStack stack)
	{
		for(ItemStack stack1 : elderItems)
		{
			if(ItemStack.areItemStacksEqual(stack, stack1)) return true;
		}
		
		return false;
	}
}
