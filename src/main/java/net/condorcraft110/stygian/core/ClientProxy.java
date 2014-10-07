package net.condorcraft110.stygian.core;

import cpw.mods.fml.common.*;
import net.minecraftforge.client.*;
import cpw.mods.fml.common.network.*;
import cpw.mods.fml.client.registry.*;
import net.condorcraft110.stygian.gui.*;
import com.jadarstudios.developercapes.*;
import net.condorcraft110.stygian.util.*;
import net.condorcraft110.stygian.entity.*;
import net.condorcraft110.stygian.render.*;
import net.condorcraft110.stygian.tileentity.*;

public class ClientProxy extends CommonProxy
{
	public int getStygianRenderIndex()
	{
		return RenderingRegistry.addNewArmourRendererPrefix("stygian");
	}
	
	public int getVoidChestRenderingIndex()
	{
		return RenderingRegistry.getNextAvailableRenderId();
	}
	
	public int getResonanceRenderIndex()
	{
		return RenderingRegistry.addNewArmourRendererPrefix("resonance");
	}
	
	public int getDarkResonanceRenderIndex()
	{
		return RenderingRegistry.addNewArmourRendererPrefix("darkResonance");
	}
	
	public void registerGuiHandler()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(Stygian.INSTANCE, new StygianGuiHandler());
	}
	
	public void registerRenderers()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVoidChest.class, new VoidChestRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkLightning.class, new RenderColouredLightning(0, 0, 0, 127));
		MinecraftForgeClient.registerItemRenderer(Stygian.elderSword, new RenderElderTools());
	}
	
	public void registerCapes()
	{
		DevCapes.getInstance().registerConfig("http://files.condorcraft110.net/mods/stygian/capes/config.json");
	}
	
	public void registerTickHandlers()
	{
		FMLCommonHandler.instance().bus().register(new ClientTickHandler());
	}
	
	public void registerElderItems()
	{
		RenderElderTools.registerElderItems();
	}
}
