package net.condorcraft110.stygiance;

import java.util.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import cpw.mods.fml.common.*;
import net.minecraft.item.Item.*;
import cpw.mods.fml.common.Mod.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.common.event.*;
import net.minecraft.block.material.*;
import cpw.mods.fml.client.registry.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.item.ItemArmor.*;
import net.minecraftforge.common.util.*;

@Mod(name = "Stygian Complex Edition", modid = "stygiance", version = "1.6")
public class Stygian
{
	public static final Random stygianRandom = new Random();
	
	@SidedProxy(clientSide = "net.condorcraft110.stygiance.ClientProxy", serverSide = "net.condorcraft110.stygiance.CommonProxy")
	public static CommonProxy proxy;
	
	public static final ArmorMaterial stygianArmourMaterial = EnumHelper.addArmorMaterial("stygian", 99, new int[]{9, 24, 18, 9}, 30);
	public static int stygianArmourRenderIndex;
	public static final CreativeTabs tabStygian = new CreativeTabStygian(); 
	public static final ToolMaterial stygianToolMaterial = EnumHelper.addToolMaterial("stygian", 5, 4683, 24.0F, 9.0F, 30);
	
	public static BlockStygianOre stygianOre = (BlockStygianOre)new BlockStygianOre().setBlockName("oreStygian").setHardness(10.0F).setResistance(6000000.0F);
	public static Block stygianBlock = Reflection.getRawBlockInstance(Material.rock).setBlockName("blockStygian").setBlockTextureName("stygianBlock");
	
	public static BlockSoulForge soulForgeInactive = (BlockSoulForge)new BlockSoulForge(false).setBlockName("soulForge");
	public static BlockSoulForge soulForgeActive = (BlockSoulForge)new BlockSoulForge(true).setBlockName("soulForge");
	
	public static Item stygianCrystal = new ItemStygianCrystal();
	
	public static ItemStygianSword stygianSword = (ItemStygianSword)new ItemStygianSword(stygianToolMaterial).setUnlocalizedName("stygianSword");
	public static ItemStygianPickaxe stygianPickaxe = (ItemStygianPickaxe)new ItemStygianPickaxe(stygianToolMaterial).setUnlocalizedName("stygianPickaxe");
	public static ItemSpade stygianShovel = (ItemSpade)new ItemSpade(stygianToolMaterial).setUnlocalizedName("stygianShovel");
	public static ItemStygianAxe stygianAxe = (ItemStygianAxe)new ItemStygianAxe(stygianToolMaterial).setUnlocalizedName("stygianAxe");
	public static ItemHoe stygianHoe = (ItemHoe)new ItemHoe(stygianToolMaterial).setUnlocalizedName("stygianHoe");
	
	public static ItemStygianArmour stygianHelmet;
	public static ItemStygianArmour stygianChestplate;
	public static ItemStygianArmour stygianLeggings;
	public static ItemStygianArmour stygianBoots;
	
	public static Item sceptreCoreCradle = new Item().setUnlocalizedName("sceptreCoreCradle");
	
	public static ItemHourglass hourglass = (ItemHourglass)new ItemHourglass(false).setUnlocalizedName("hourglassIntact");
	public static ItemHourglass hourglassCracked = (ItemHourglass)new ItemHourglass(true).setUnlocalizedName("hourglassCracked");

	public static Item stygianCore = new Item().setUnlocalizedName("stygianCore");
	public static Item sceptre = new ItemSceptre().setUnlocalizedName("focusSceptre");
	public static Item focusCore = new ItemStygianCore().setUnlocalizedName("stygianCore");
	
	public static DamageSource damageSourceDrain = new DamageSource("stygianDrain").setDamageBypassesArmor().setDamageIsAbsolute().setMagicDamage();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		checkStandardNotInstalled();
		
		StygianConfig.readAndSet(event.getModConfigurationDirectory());
		
		stygianArmourRenderIndex = proxy.getStygianRenderIndex();
		
		stygianHelmet = (ItemStygianArmour)new ItemStygianArmour(stygianArmourMaterial, stygianArmourRenderIndex, 0).setUnlocalizedName("stygianHelmet");
		stygianChestplate = (ItemStygianArmour)new ItemStygianArmour(stygianArmourMaterial, stygianArmourRenderIndex, 1).setUnlocalizedName("stygianChestplate");
		stygianLeggings = (ItemStygianArmour)new ItemStygianArmour(stygianArmourMaterial, stygianArmourRenderIndex, 2).setUnlocalizedName("stygianLeggings");
		stygianBoots = (ItemStygianArmour)new ItemStygianArmour(stygianArmourMaterial, stygianArmourRenderIndex, 3).setUnlocalizedName("stygianBoots");
		
		GameRegistry.registerItem(stygianCrystal, "stygianCrystal");
		
		GameRegistry.registerItem(stygianSword, "stygianSword");
		GameRegistry.registerItem(stygianPickaxe, "stygianPickaxe");
		GameRegistry.registerItem(stygianShovel, "stygianShovel");
		GameRegistry.registerItem(stygianAxe, "stygianAxe");
		GameRegistry.registerItem(stygianHoe, "stygianHoe");
		
		GameRegistry.registerItem(stygianHelmet, "stygianHelmet");
		GameRegistry.registerItem(stygianChestplate, "stygianChestplate");
		GameRegistry.registerItem(stygianLeggings, "stygianLeggings");
		GameRegistry.registerItem(stygianBoots, "stygianBoots");
		
		GameRegistry.registerItem(sceptreCoreCradle, "sceptreCoreCradle");
		
		GameRegistry.registerItem(stygianCore, "stygianCore");
		GameRegistry.registerItem(sceptre, "sceptre");
		GameRegistry.registerItem(focusCore, "focusCore");
		
		GameRegistry.registerItem(hourglass, "hourglass");
		GameRegistry.registerItem(hourglassCracked, "hourglassCracked");
		
		GameRegistry.registerBlock(stygianOre, "stygianOre");

		GameRegistry.registerBlock(soulForgeInactive, "soulForgeInactive");
		GameRegistry.registerBlock(soulForgeActive, "soulForgeActive");
		
		GameRegistry.registerWorldGenerator(new WorldGenNetherOreHandler(), 0);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		stygianSword.setTextureName("stygian:stygianSword");
		stygianPickaxe.setTextureName("stygian:stygianPickaxe");
		stygianShovel.setTextureName("stygian:stygianShovel");
		stygianAxe.setTextureName("stygian:stygianAxe");
		stygianHoe.setTextureName("stygian:stygianHoe");
		
		stygianHelmet.setTextureName("stygian:stygianHelmet");
		stygianChestplate.setTextureName("stygian:stygianChestplate");
		stygianLeggings.setTextureName("stygian:stygianLeggings");
		stygianBoots.setTextureName("stygian:stygianBoots");
		
		sceptreCoreCradle.setTextureName("stygian:sceptreCoreCradle");
		
		hourglass.setTextureName("stygian:hourglass");
		hourglassCracked.setTextureName("stygian:hourglassCracked");
		
		stygianCore.setTextureName("stygian:focusCore");
		sceptre.setTextureName("stygian:sceptre");
		focusCore.setTextureName("stygian:focusCore");
		
		stygianOre.setBlockTextureName("stygian:stygianOre");
		
		stygianCrystal.setCreativeTab(tabStygian);
		
		stygianSword.setCreativeTab(tabStygian);
		stygianPickaxe.setCreativeTab(tabStygian);
		stygianShovel.setCreativeTab(tabStygian);
		stygianAxe.setCreativeTab(tabStygian);
		stygianHoe.setCreativeTab(tabStygian);
		
		stygianHelmet.setCreativeTab(tabStygian);
		stygianChestplate.setCreativeTab(tabStygian);
		stygianLeggings.setCreativeTab(tabStygian);
		stygianBoots.setCreativeTab(tabStygian);
		
		hourglass.setCreativeTab(tabStygian);
		hourglassCracked.setCreativeTab(tabStygian);
		
		stygianCore.setCreativeTab(tabStygian);
		sceptreCoreCradle.setCreativeTab(tabStygian);
		sceptre.setCreativeTab(tabStygian);
		focusCore.setCreativeTab(tabStygian);
		
		stygianArmourMaterial.customCraftingMaterial = stygianCrystal;
		stygianToolMaterial.customCraftingMaterial = stygianCrystal;
		
		stygianOre.setHarvestLevel("pickaxe", 3);
		
		GameRegistry.addRecipe(new ItemStack(stygianSword, 1), "@", "@", "#", '@', new ItemStack(stygianCrystal, 1, 1), '#', Items.blaze_rod);
		GameRegistry.addRecipe(new ItemStack(stygianPickaxe, 1), "@@@", " # ", " # ", '@', new ItemStack(stygianCrystal, 1, 1), '#', Items.blaze_rod);
		GameRegistry.addRecipe(new ItemStack(stygianShovel, 1), "@", "#", "#", '@', new ItemStack(stygianCrystal, 1, 1), '#', Items.blaze_rod);
		GameRegistry.addRecipe(new ItemStack(stygianAxe, 1), "@@", "@#", " #", '@', new ItemStack(stygianCrystal, 1, 1), '#', Items.blaze_rod);
		GameRegistry.addRecipe(new ItemStack(stygianAxe, 1), "@@", "#@", "# ", '@', new ItemStack(stygianCrystal, 1, 1), '#', Items.blaze_rod);
		GameRegistry.addRecipe(new ItemStack(stygianHoe, 1), "@@ ", " # ", " # ", '@', new ItemStack(stygianCrystal, 1, 1), '#', Items.blaze_rod);
		GameRegistry.addRecipe(new ItemStack(stygianHoe, 1), " @@", " # ", " # ", '@', new ItemStack(stygianCrystal, 1, 1), '#', Items.blaze_rod);
		
		GameRegistry.addRecipe(new ItemStack(stygianHelmet, 1), "@@@", "@ @", '@', new ItemStack(stygianCrystal, 1, 1));
		GameRegistry.addRecipe(new ItemStack(stygianChestplate, 1), "@ @", "@@@", "@@@", '@', new ItemStack(stygianCrystal, 1, 1));
		GameRegistry.addRecipe(new ItemStack(stygianLeggings, 1), "@@@", "@ @", "@ @", '@', new ItemStack(stygianCrystal, 1, 1));
		GameRegistry.addRecipe(new ItemStack(stygianBoots, 1), "@ @", "@ @", '@', new ItemStack(stygianCrystal, 1, 1));
		
		GameRegistry.addRecipe(new ItemStack(stygianCore, 1), "-#-", "#@#", "-#-", '@', new ItemStack(stygianCrystal, 1, 1), '#', Items.ender_pearl, '-', Items.diamond);
		
		GameRegistry.addSmelting(new ItemStack(stygianCrystal, 1, 0), new ItemStack(stygianCrystal, 1, 1), 48.0F);
		
		FocusRegistry.registerFoci();
	}
	
	private void checkStandardNotInstalled()
	{
		try
		{
			Class.forName("net.condorcraft110.stygian.Stygian");
		}
		catch(ClassNotFoundException e)
		{
			return;
		}
		
		throw new Error("Stygian Standard Edition detected, it is incompatible with Complex Edition!");
	}
}
