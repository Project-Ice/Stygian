package net.condorcraft110.stygian.core;

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
import net.minecraftforge.fluids.*;
import net.condorcraft110.stygian.*;
import net.minecraft.block.material.*;
import cpw.mods.fml.client.registry.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.item.ItemArmor.*;
import net.minecraftforge.common.util.*;
import net.condorcraft110.stygian.item.*;
import net.condorcraft110.stygian.misc.*;
import net.condorcraft110.stygian.util.*;
import net.condorcraft110.stygian.block.*;
import net.condorcraft110.stygian.fluid.*;
import net.condorcraft110.stygian.entity.*;
import net.condorcraft110.stygian.registry.*;
import net.condorcraft110.stygian.worldgen.*;

@Mod(name = "Stygian", modid = "stygian", version = "2.1")
public class Stygian
{
	public static final Random stygianRandom = new Random();
	
	@SidedProxy(clientSide = "net.condorcraft110.stygian.core.ClientProxy", serverSide = "net.condorcraft110.stygian.core.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance
	public static Stygian INSTANCE;
	
	public static final ArmorMaterial stygianArmourMaterial = EnumHelper.addArmorMaterial("stygian", 99, new int[]{9, 24, 18, 9}, 30);
	public static final ArmorMaterial resonanceArmourMaterial = EnumHelper.addArmorMaterial("resonance", 198, new int[]{18, 48, 36, 18}, 60);
	public static int stygianArmourRenderIndex;
	public static int voidChestRenderIndex;
	public static int resonanceArmourRenderIndex;
	public static final CreativeTabs tabStygian = new CreativeTabStygian(); 
	public static final ToolMaterial stygianToolMaterial = EnumHelper.addToolMaterial("stygian", 5, 4683, 24.0F, 9.0F, 30);
	public static final ToolMaterial resonanceToolMaterial = EnumHelper.addToolMaterial("resonance", 6, 9366, 48.0F, 18.0F, 60);
	
	public static Block stygianBlock = Reflection.getRawBlockInstance(Material.rock).setBlockName("blockStygian").setHardness(12.0F).setResistance(6000000.0F);
	
	public static ItemStygianCrystal stygianCrystal = new ItemStygianCrystal();
	
	public static ItemResource resource = new ItemResource();

	public static ItemStygianSword stygianSword = (ItemStygianSword)new ItemStygianSword(stygianToolMaterial).setUnlocalizedName("stygianSword");
	public static ItemStygianPickaxe stygianPickaxe = (ItemStygianPickaxe)new ItemStygianPickaxe(stygianToolMaterial).setUnlocalizedName("stygianPickaxe");
	public static ItemSpade stygianShovel = (ItemSpade)new ItemSpade(stygianToolMaterial).setUnlocalizedName("stygianShovel");
	public static ItemStygianAxe stygianAxe = (ItemStygianAxe)new ItemStygianAxe(stygianToolMaterial).setUnlocalizedName("stygianAxe");
	public static ItemHoe stygianHoe = (ItemHoe)new ItemHoe(stygianToolMaterial).setUnlocalizedName("stygianHoe");
	
	public static ItemStygianSword resonanceSword = (ItemStygianSword)new ItemStygianSword(resonanceToolMaterial).setUnlocalizedName("resonanceSword");
	public static ItemStygianPickaxe resonancePickaxe = (ItemStygianPickaxe)new ItemStygianPickaxe(resonanceToolMaterial).setUnlocalizedName("resonancePickaxe");
	public static ItemSpade resonanceShovel = (ItemSpade)new ItemSpade(resonanceToolMaterial).setUnlocalizedName("resonanceShovel");
	public static ItemStygianAxe resonanceAxe = (ItemStygianAxe)new ItemStygianAxe(resonanceToolMaterial).setUnlocalizedName("resonanceAxe");
	public static ItemHoe resonanceHoe = (ItemHoe)new ItemHoe(resonanceToolMaterial).setUnlocalizedName("resonanceHoe");

	public static ItemStygianArmour stygianHelmet;
	public static ItemStygianArmour stygianChestplate;
	public static ItemStygianArmour stygianLeggings;
	public static ItemStygianArmour stygianBoots;
	
	public static ItemResonanceArmour resonanceHelmet;
	public static ItemResonanceArmour resonanceChestplate;
	public static ItemResonanceArmour resonanceLeggings;
	public static ItemResonanceArmour resonanceBoots;
	
	public static Item sceptreCoreCradle = new Item().setUnlocalizedName("sceptreCoreCradle");
	
	public static ItemHourglass hourglass = (ItemHourglass)new ItemHourglass(false).setUnlocalizedName("hourglassIntact");
	public static ItemHourglass hourglassCracked = (ItemHourglass)new ItemHourglass(true).setUnlocalizedName("hourglassCracked");

	public static Item stygianCore = new Item().setUnlocalizedName("stygianCore");
	public static ItemSceptre sceptre = (ItemSceptre)new ItemSceptre().setUnlocalizedName("focusSceptre");
	public static ItemStygianCore focusCore = (ItemStygianCore)new ItemStygianCore().setUnlocalizedName("stygianCore");
	
	public static ItemResonanceStar resonanceStar = (ItemResonanceStar)new ItemResonanceStar().setUnlocalizedName("resonanceStar");
	
	public static DamageSource damageSourceDrain = new DamageSource("stygianDrain").setDamageBypassesArmor().setDamageIsAbsolute().setMagicDamage();

	public static BlockStygianOre stygianOre = (BlockStygianOre)new BlockStygianOre(stygianCrystal, 0, "stygianOre").setBlockName("oreStygian").setHardness(10.0F).setResistance(6000000.0F);
	public static BlockStygianOre pyroniumOre = (BlockStygianOre)new BlockStygianOre(resource, 0, "pyroniumOre").setBlockName("pyroniumOre");
	public static BlockStygianOre cryoniteOre = (BlockStygianOre)new BlockStygianOre(resource, 1, "cryoniteOre").setBlockName("cryoniumOre");
	
	public static BlockSoulForge soulForge = (BlockSoulForge)new BlockSoulForge().setBlockName("soulForge");
	public static BlockVoidChest voidChest = (BlockVoidChest)new BlockVoidChest().setBlockName("voidChest");
	public static BlockNetherForge netherForge = (BlockNetherForge)new BlockNetherForge().setBlockName("netherForge");
	
	public static Material liquidDarknessMaterial = new Material(MapColor.blackColor);
	public static FluidLiquidDarkness liquidDarkness = new FluidLiquidDarkness();
	public static BlockFluidLiquidDarkness liquidDarknessBlock;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		StygianConfig.readAndSet(event.getModConfigurationDirectory());
		
		stygianArmourRenderIndex = proxy.getStygianRenderIndex();
		voidChestRenderIndex = proxy.getVoidChestRenderingIndex();
		resonanceArmourRenderIndex = proxy.getResonanceRenderIndex();
		
		stygianHelmet = (ItemStygianArmour)new ItemStygianArmour(stygianArmourMaterial, stygianArmourRenderIndex, 0).setUnlocalizedName("stygianHelmet");
		stygianChestplate = (ItemStygianArmour)new ItemStygianArmour(stygianArmourMaterial, stygianArmourRenderIndex, 1).setUnlocalizedName("stygianChestplate");
		stygianLeggings = (ItemStygianArmour)new ItemStygianArmour(stygianArmourMaterial, stygianArmourRenderIndex, 2).setUnlocalizedName("stygianLeggings");
		stygianBoots = (ItemStygianArmour)new ItemStygianArmour(stygianArmourMaterial, stygianArmourRenderIndex, 3).setUnlocalizedName("stygianBoots");
		
		resonanceHelmet = (ItemResonanceArmour)new ItemResonanceArmour(resonanceArmourMaterial, resonanceArmourRenderIndex, 0).setUnlocalizedName("resonanceHelmet");
		resonanceChestplate = (ItemResonanceArmour)new ItemResonanceArmour(resonanceArmourMaterial, resonanceArmourRenderIndex, 1).setUnlocalizedName("resonanceChestplate");
		resonanceLeggings = (ItemResonanceArmour)new ItemResonanceArmour(resonanceArmourMaterial, resonanceArmourRenderIndex, 2).setUnlocalizedName("resonanceLeggings");
		resonanceBoots = (ItemResonanceArmour)new ItemResonanceArmour(resonanceArmourMaterial, resonanceArmourRenderIndex, 3).setUnlocalizedName("resonanceBoots");
		
		GameRegistry.registerItem(stygianCrystal, "stygianCrystal");
		
		GameRegistry.registerItem(stygianSword, "stygianSword");
		GameRegistry.registerItem(stygianPickaxe, "stygianPickaxe");
		GameRegistry.registerItem(stygianShovel, "stygianShovel");
		GameRegistry.registerItem(stygianAxe, "stygianAxe");
		GameRegistry.registerItem(stygianHoe, "stygianHoe");
		
		GameRegistry.registerItem(resonanceSword, "resonanceSword");
		GameRegistry.registerItem(resonancePickaxe, "resonancePickaxe");
		GameRegistry.registerItem(resonanceShovel, "resonanceShovel");
		GameRegistry.registerItem(resonanceAxe, "resonanceAxe");
		GameRegistry.registerItem(resonanceHoe, "resonanceHoe");
		
		GameRegistry.registerItem(stygianHelmet, "stygianHelmet");
		GameRegistry.registerItem(stygianChestplate, "stygianChestplate");
		GameRegistry.registerItem(stygianLeggings, "stygianLeggings");
		GameRegistry.registerItem(stygianBoots, "stygianBoots");
		
		GameRegistry.registerItem(resonanceHelmet, "resonanceHelmet");
		GameRegistry.registerItem(resonanceChestplate, "resonanceChestplate");
		GameRegistry.registerItem(resonanceLeggings, "resonanceLeggings");
		GameRegistry.registerItem(resonanceBoots, "resonanceBoots");
		
		GameRegistry.registerItem(sceptreCoreCradle, "sceptreCoreCradle");
		
		GameRegistry.registerItem(stygianCore, "stygianCore");
		GameRegistry.registerItem(sceptre, "sceptre");
		GameRegistry.registerItem(focusCore, "focusCore");
		
		GameRegistry.registerItem(resonanceStar, "resonanceStar");
		
		GameRegistry.registerItem(hourglass, "hourglass");
		GameRegistry.registerItem(hourglassCracked, "hourglassCracked");
		
		GameRegistry.registerBlock(stygianOre, "stygianOre");
		GameRegistry.registerBlock(pyroniumOre, "pyroniumOre");
		GameRegistry.registerBlock(cryoniteOre, "cryoniteOre");
		GameRegistry.registerBlock(stygianBlock, "stygianBlock");
		
		GameRegistry.registerBlock(soulForge, "soulForge");
		GameRegistry.registerBlock(voidChest, "voidChest");
		GameRegistry.registerBlock(netherForge, "netherForge");
		
		FluidRegistry.registerFluid(liquidDarkness);
		
		liquidDarknessBlock = (BlockFluidLiquidDarkness)new BlockFluidLiquidDarkness(liquidDarkness, liquidDarknessMaterial).setBlockName("liquidDarkness");
		
		GameRegistry.registerBlock(liquidDarknessBlock, "liquidDarkness");
		
		GameRegistry.registerWorldGenerator(new WorldGenNetherOreHandler(), 0);
		
		EntityRegistry.registerModEntity(EntityDarkLightning.class, "darkLightningBolt", 0, this, 80, 3, false);
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
		
		resonanceStar.setTextureName("stygian:resonanceStar");

		stygianOre.setBlockTextureName("stygian:stygianOre");
		pyroniumOre.setBlockTextureName("stygian:pyroniumOre");
		cryoniteOre.setBlockTextureName("stygian:cryoniteOre");
		stygianBlock.setBlockTextureName("stygian:stygianBlock");
		
		liquidDarkness.setIcons(liquidDarknessBlock.fluidIcon);
		
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
		
		resonanceHelmet.setCreativeTab(tabStygian);
		resonanceChestplate.setCreativeTab(tabStygian);
		resonanceLeggings.setCreativeTab(tabStygian);
		resonanceBoots.setCreativeTab(tabStygian);
		
		hourglass.setCreativeTab(tabStygian);
		hourglassCracked.setCreativeTab(tabStygian);
		
		stygianCore.setCreativeTab(tabStygian);
		sceptreCoreCradle.setCreativeTab(tabStygian);
		sceptre.setCreativeTab(tabStygian);
		focusCore.setCreativeTab(tabStygian);
		
		resonanceStar.setCreativeTab(tabStygian);
		
		stygianOre.setCreativeTab(tabStygian);
		pyroniumOre.setCreativeTab(tabStygian);
		cryoniteOre.setCreativeTab(tabStygian);
		stygianBlock.setCreativeTab(tabStygian);
		
		soulForge.setCreativeTab(tabStygian);
		voidChest.setCreativeTab(tabStygian);
		netherForge.setCreativeTab(tabStygian);
		
		liquidDarknessBlock.setCreativeTab(tabStygian);
		
		stygianArmourMaterial.customCraftingMaterial = stygianCrystal;
		stygianToolMaterial.customCraftingMaterial = stygianCrystal;

		stygianOre.setHarvestLevel("pickaxe", 3);
		stygianBlock.setHarvestLevel("pickaxe", 4);
		
		GameRegistry.addRecipe(new ItemStack(soulForge, 1), "@#@", "#-#", "@_@", '@', Blocks.diamond_block, '#', new ItemStack(resource, 1, 0), '-', Blocks.furnace, '_', Items.lava_bucket);
		
		ItemStack active = new ItemStack(stygianCrystal, 1, 1);
		GameRegistry.addRecipe(new ItemStack(stygianSword, 1), "@", "@", "#", '@', active, '#', Items.blaze_rod);
		GameRegistry.addRecipe(new ItemStack(stygianPickaxe, 1), "@@@", " # ", " # ", '@', active, '#', Items.blaze_rod);
		GameRegistry.addRecipe(new ItemStack(stygianShovel, 1), "@", "#", "#", '@', active, '#', Items.blaze_rod);
		GameRegistry.addRecipe(new ItemStack(stygianAxe, 1), "@@", "@#", " #", '@', active, '#', Items.blaze_rod);
		GameRegistry.addRecipe(new ItemStack(stygianAxe, 1), "@@", "#@", "# ", '@', active, '#', Items.blaze_rod);
		GameRegistry.addRecipe(new ItemStack(stygianHoe, 1), "@@ ", " # ", " # ", '@', active, '#', Items.blaze_rod);
		GameRegistry.addRecipe(new ItemStack(stygianHoe, 1), " @@", " # ", " # ", '@', active, '#', Items.blaze_rod);
		
		GameRegistry.addRecipe(new ItemStack(stygianHelmet, 1), "@@@", "@ @", '@', active);
		GameRegistry.addRecipe(new ItemStack(stygianChestplate, 1), "@ @", "@@@", "@@@", '@', active);
		GameRegistry.addRecipe(new ItemStack(stygianLeggings, 1), "@@@", "@ @", "@ @", '@', active);
		GameRegistry.addRecipe(new ItemStack(stygianBoots, 1), "@ @", "@ @", '@', active);
		
		GameRegistry.addRecipe(new ItemStack(stygianCore, 1), "-#-", "#@#", "-#-", '@', active, '#', Items.ender_pearl, '-', Items.diamond);
		
		GameRegistry.addRecipe(new ItemStack(stygianBlock, 1), "@@@", "@@@", "@@@", '@', active);
		GameRegistry.addShapelessRecipe(new ItemStack(stygianCrystal, 9, 1), new ItemStack(stygianBlock, 1));
		
		GameRegistry.addSmelting(new ItemStack(stygianCrystal, 1, 0), active, 48.0F);
		
		proxy.registerTileEntities();
		proxy.registerGuiHandler();
		proxy.registerRenderers();
		
		FocusRegistry.registerFoci();
		ResonanceRegistry.registerResonances();
		
		RecipeManager.registerRecipes();
		
		//RecipeManager.registerForgeRecipe(new ForgeRecipe(new ItemStack(stygianCrystal, 128, 1), new ItemStack[][]{new ItemStack[]{null, null, null}, new ItemStack[]{null, new ItemStack(stygianCrystal, 1, 0), null}, new ItemStack[]{null, null, null}}));
	}
}
