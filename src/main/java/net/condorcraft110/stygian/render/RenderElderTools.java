package net.condorcraft110.stygian.render;

import java.awt.*;
import java.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraftforge.client.*;
import net.minecraft.client.renderer.*;
import net.condorcraft110.stygian.core.*;
import net.condorcraft110.stygian.item.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.texture.*;

public class RenderElderTools implements IItemRenderer
{
	private static ArrayList<ItemStack> elderItems = new ArrayList<ItemStack>();
	public static float hue = 0.0F;
	
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
		Color colour = Color.getHSBColor(hue, 1.0F, 1.0F);
		
		switch(type)
		{
			case INVENTORY:
				GL11.glPushMatrix();
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glDepthMask(false);
					GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
					RenderItem.getInstance().renderIcon(0, 0, (((ItemElderSword)stack.getItem()).handleIcon), 16, 16);
					GL11.glColor4f((float)colour.getRed() / 255, (float)colour.getGreen() / 255, (float)colour.getBlue() / 255, 1.0F);
					RenderItem.getInstance().renderIcon(0, 0, (((ItemElderSword)stack.getItem()).bladeIcon), 16, 16);
					GL11.glDepthMask(true);
					GL11.glDisable(GL11.GL_BLEND);
				GL11.glPopMatrix();
				break;
			case ENTITY:
			default:
				GL11.glPushMatrix();
					renderIcon(((ItemElderSword)stack.getItem()).handleIcon);
					GL11.glColor4f((float)colour.getRed() / 255, (float)colour.getGreen() / 255, (float)colour.getBlue() / 255, 1.0F);
					renderIcon(((ItemElderSword)stack.getItem()).bladeIcon);
				GL11.glPopMatrix();
				break;
		}
	}
	
	public static void registerElderItem(ItemStack stack)
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
	
	public static void registerElderItems()
	{
		registerElderItem(new ItemStack(Stygian.elderSword));
	}
	
	private static void renderIcon(IIcon icon)
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationItemsTexture);
		ItemRenderer.renderItemIn2D(Tessellator.instance, icon.getMaxU(), icon.getMinV(), icon.getMinU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 1.0F / 16.0F);
	}
}