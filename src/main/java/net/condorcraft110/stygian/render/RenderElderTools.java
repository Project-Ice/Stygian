package net.condorcraft110.stygian.render;

import java.awt.*;
import java.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.item.*;
import net.minecraftforge.client.*;
import net.condorcraft110.stygian.core.*;
import net.minecraft.client.renderer.entity.*;

public class RenderElderTools implements IItemRenderer
{
	//private static ArrayList<ItemStack> elderItems = new ArrayList<ItemStack>();
	private static RenderItem ri = new RenderItem();
	
	private float hue = 0.0F;
	
	public boolean handleRenderType(ItemStack stack, ItemRenderType type)
	{
		return type != ItemRenderType.FIRST_PERSON_MAP && isElderItem(stack);
	}
	
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack stack, ItemRendererHelper helper)
	{
		return type != ItemRenderType.FIRST_PERSON_MAP && helper == ItemRendererHelper.ENTITY_BOBBING && isElderItem(stack);
	}
	
	public void renderItem(ItemRenderType type, ItemStack stack, Object... data) // only sword for now
	{
		Color color = Color.getHSBColor(hue += 0.01F, 1.0F, 1.0F);
		
		ri.renderIcon(0, 0, stack.getIconIndex(), 16, 16);
		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glColor4f((float)color.getRed() / 256, (float)color.getGreen() / 256, (float)color.getBlue() / 256, 0.5F);
			
			GL11.glVertex2i(15, 0);
			GL11.glVertex2i(15, 3);
			GL11.glVertex2i(16, 3);
			GL11.glVertex2i(16, 0);
			
			GL11.glVertex2i(14, 0);
			GL11.glVertex2i(14, 4);
			GL11.glVertex2i(15, 4);
			GL11.glVertex2i(15, 0);
			
			GL11.glVertex2i(13, 0);
			GL11.glVertex2i(13, 5);
			GL11.glVertex2i(14, 5);
			GL11.glVertex2i(14, 0);
			
			GL11.glVertex2i(12, 1);
			GL11.glVertex2i(12, 6);
			GL11.glVertex2i(13, 6);
			GL11.glVertex2i(13, 1);
			
			GL11.glVertex2i(11, 2);
			GL11.glVertex2i(11, 7);
			GL11.glVertex2i(12, 7);
			GL11.glVertex2i(12, 2);
			
			GL11.glVertex2i(10, 3);
			GL11.glVertex2i(10, 8);
			GL11.glVertex2i(11, 8);
			GL11.glVertex2i(11, 3);
			
			GL11.glVertex2i(9, 4);
			GL11.glVertex2i(9, 9);
			GL11.glVertex2i(10, 9);
			GL11.glVertex2i(10, 4);
			
			GL11.glVertex2i(8, 5);
			GL11.glVertex2i(8, 10);
			GL11.glVertex2i(9, 10);
			GL11.glVertex2i(9, 5);
			
			GL11.glVertex2i(7, 6);
			GL11.glVertex2i(7, 13);
			GL11.glVertex2i(8, 13);
			GL11.glVertex2i(8, 6);
			
			GL11.glVertex2i(6, 7);
			GL11.glVertex2i(6, 13);
			GL11.glVertex2i(7, 13);
			GL11.glVertex2i(7, 7);
			
			GL11.glVertex2i(2, 6);
			GL11.glVertex2i(2, 8);
			GL11.glVertex2i(3, 8);
			GL11.glVertex2i(3, 6);
			
			GL11.glVertex2i(3, 6);
			GL11.glVertex2i(3, 10);
			GL11.glVertex2i(4, 10);
			GL11.glVertex2i(4, 6);
			
			GL11.glVertex2i(4, 7);
			GL11.glVertex2i(4, 11);
			GL11.glVertex2i(5, 11);
			GL11.glVertex2i(5, 7);
			
			GL11.glVertex2i(5, 8);
			GL11.glVertex2i(5, 12);
			GL11.glVertex2i(6, 12);
			GL11.glVertex2i(6, 8);
			
			GL11.glVertex2i(8, 11);
			GL11.glVertex2i(8, 14);
			GL11.glVertex2i(9, 14);
			GL11.glVertex2i(9, 11);
			
			GL11.glVertex2i(9, 12);
			GL11.glVertex2i(9, 14);
			GL11.glVertex2i(10, 14);
			GL11.glVertex2i(10, 12);
			
			GL11.glVertex2i(0, 13);
			GL11.glVertex2i(0, 16);
			GL11.glVertex2i(2, 16);
			GL11.glVertex2i(2, 13);
			
			GL11.glVertex2i(2, 14);
			GL11.glVertex2i(2, 16);
			GL11.glVertex2i(3, 16);
			GL11.glVertex2i(3, 14);
		GL11.glEnd();
		
		GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		
	}
	
	/*public static void addElderItem(ItemStack stack)
	{
		if(!isElderItem(stack)) elderItems.add(stack);
	}*/
	
	private static boolean isElderItem(ItemStack stack)
	{
		/*for(ItemStack stack1 : elderItems)
		{
			if(ItemStack.areItemStacksEqual(stack, stack1)) return true;
		}
		
		return false;*/
		
		return stack.getItem() == Stygian.elderSword;
	}
}
