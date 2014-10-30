package net.condorcraft110.stygian.core;

import java.util.*;

import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.block.*;
import cpw.mods.fml.common.*;
import net.minecraft.potion.*;
import net.minecraft.item.Item.*;
import cpw.mods.fml.common.Mod.*;

import org.apache.logging.log4j.*;

import net.minecraftforge.common.*;
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
import net.condorcraft110.stygian.potion.*;
import net.condorcraft110.stygian.registry.*;
import net.condorcraft110.stygian.worldgen.*;
import net.condorcraft110.stygian.dimension.*;

@Mod(name = "Stygian", modid = "stygian", version = "2.6")
public class Stygian
{
	public static final Random stygianRandom = new Random();
	
	@SidedProxy(clientSide = "net.condorcraft110.stygian.core.ClientProxy", serverSide = "net.condorcraft110.stygian.core.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance
	public static Stygian INSTANCE;
	
	public static Logger logger = LogManager.getLogger("Stygian");
	
	public static final ArmorMaterial stygianArmourMaterial = EnumHelper.addArmorMaterial("stygian", 99, new int[]{9, 24, 18, 9}, 30);
	public static final ArmorMaterial resonanceArmourMaterial = EnumHelper.addArmorMaterial("resonance", 198, new int[]{18, 48, 36, 18}, 60);
	public static final ArmorMaterial darkResonanceArmourMaterial = EnumHelper.addArmorMaterial("darkResonance", 396, new int[]{36, 96, 72, 36}, 120);
	public static int stygianArmourRenderIndex;
	public static int voidChestRenderIndex;
	public static int resonanceArmourRenderIndex;
	public static int darkResonanceArmourRenderIndex;
	public static final CreativeTabs tabStygian = new CreativeTabStygian(); 
	public static final ToolMaterial stygianToolMaterial = EnumHelper.addToolMaterial("stygian", 5, 4683, 24.0F, 9.0F, 30);
	public static final ToolMaterial resonanceToolMaterial = EnumHelper.addToolMaterial("resonance", 6, 9366, 48.0F, 18.0F, 60);
	public static final ToolMaterial darkResonanceToolMaterial = EnumHelper.addToolMaterial("darkResonance", 7, 18732, 96.0F, 36, 120);
	public static final ToolMaterial elderToolMaterial = EnumHelper.addToolMaterial("stygianElder", 8, 75928, 384, 144, 480);
	
	public static Block stygianBlock = ReflectionHelper.getRawBlockInstance(Material.rock).setBlockName("blockStygian").setHardness(12.0F).setResistance(6000000.0F).setBlockTextureName("stygian:stygianBlock");
	
	public static Block stygianStone = ReflectionHelper.getRawBlockInstance(Material.rock).setBlockName("blockStygianStone").setHardness(12.0F).setResistance(6000000.0F);
	public static Block stygianDirt = ReflectionHelper.getRawBlockInstance(Material.rock).setBlockName("blockStygianDirt").setHardness(12.0F).setResistance(6000000.0F);
	
	public static ItemStygianCrystal stygianCrystal = new ItemStygianCrystal();
	
	public static ItemResource resource = new ItemResource();
	
	public static ItemStygianSword stygianSword = (ItemStygianSword)new ItemStygianSword(stygianToolMaterial).setUnlocalizedName("stygianSword").setTextureName("stygian:stygianSword");
	public static ItemStygianPickaxe stygianPickaxe = (ItemStygianPickaxe)new ItemStygianPickaxe(stygianToolMaterial).setUnlocalizedName("stygianPickaxe").setTextureName("stygian:stygianPickaxe");
	public static ItemSpade stygianShovel = (ItemSpade)new ItemSpade(stygianToolMaterial).setUnlocalizedName("stygianShovel").setTextureName("stygian:stygianShovel");
	public static ItemStygianAxe stygianAxe = (ItemStygianAxe)new ItemStygianAxe(stygianToolMaterial).setUnlocalizedName("stygianAxe").setTextureName("stygian:stygianAxe");
	public static ItemHoe stygianHoe = (ItemHoe)new ItemHoe(stygianToolMaterial).setUnlocalizedName("stygianHoe").setTextureName("stygian:stygianHoe");
	
	public static ItemStygianSword resonanceSword = (ItemStygianSword)new ItemStygianSword(resonanceToolMaterial).setUnlocalizedName("resonanceSword").setTextureName("stygian:resonanceSword");
	public static ItemStygianPickaxe resonancePickaxe = (ItemStygianPickaxe)new ItemStygianPickaxe(resonanceToolMaterial).setUnlocalizedName("resonancePickaxe").setTextureName("stygian:resonancePickaxe");
	public static ItemSpade resonanceShovel = (ItemSpade)new ItemSpade(resonanceToolMaterial).setUnlocalizedName("resonanceShovel").setTextureName("stygian:resonanceShovel");
	public static ItemStygianAxe resonanceAxe = (ItemStygianAxe)new ItemStygianAxe(resonanceToolMaterial).setUnlocalizedName("resonanceAxe").setTextureName("stygian:resonanceAxe");
	public static ItemHoe resonanceHoe = (ItemHoe)new ItemHoe(resonanceToolMaterial).setUnlocalizedName("resonanceHoe").setTextureName("stygian:resonanceHoe");
	
	public static ItemStygianSword darkResonanceSword = (ItemStygianSword)new ItemStygianSword(darkResonanceToolMaterial).setUnlocalizedName("darkResonanceSword").setTextureName("stygian:darkResonanceSword");
	public static ItemStygianPickaxe darkResonancePickaxe = (ItemStygianPickaxe)new ItemStygianPickaxe(darkResonanceToolMaterial).setUnlocalizedName("darkResonancePickaxe").setTextureName("stygian:darkResonancePickaxe");
	public static ItemSpade darkResonanceShovel = (ItemSpade)new ItemSpade(darkResonanceToolMaterial).setUnlocalizedName("darkResonanceShovel").setTextureName("stygian:darkResonanceShovel");
	public static ItemStygianAxe darkResonanceAxe = (ItemStygianAxe)new ItemStygianAxe(darkResonanceToolMaterial).setUnlocalizedName("darkResonanceAxe").setTextureName("stygian:darkResonanceAxe");
	public static ItemHoe darkResonanceHoe = (ItemHoe)new ItemHoe(darkResonanceToolMaterial).setUnlocalizedName("darkResonanceHoe").setTextureName("stygian:darkResonanceHoe");

	public static ItemElderSword elderSword = (ItemElderSword)new ItemElderSword(elderToolMaterial).setUnlocalizedName("elderSword");
	public static ItemElderPickaxe elderPickaxe = (ItemElderPickaxe)new ItemElderPickaxe(elderToolMaterial).setUnlocalizedName("elderPickaxe");
	public static ItemElderShovel elderShovel = (ItemElderShovel)new ItemElderShovel(elderToolMaterial).setUnlocalizedName("elderShovel");
	public static ItemElderAxe elderAxe = (ItemElderAxe)new ItemElderAxe(elderToolMaterial).setUnlocalizedName("elderAxe");
	public static ItemElderHoe elderHoe = (ItemElderHoe)new ItemElderHoe(elderToolMaterial).setUnlocalizedName("elderHoe");
	
	public static ItemStygianArmour stygianHelmet;
	public static ItemStygianArmour stygianChestplate;
	public static ItemStygianArmour stygianLeggings;
	public static ItemStygianArmour stygianBoots;
	
	public static ItemResonanceArmour resonanceHelmet;
	public static ItemResonanceArmour resonanceChestplate;
	public static ItemResonanceArmour resonanceLeggings;
	public static ItemResonanceArmour resonanceBoots;
	
	public static ItemDarkResonanceArmour darkResonanceHelmet;
	public static ItemDarkResonanceArmour darkResonanceChestplate;
	public static ItemDarkResonanceArmour darkResonanceLeggings;
	public static ItemDarkResonanceArmour darkResonanceBoots;
	
	public static Item sceptreCoreCradle = new Item().setUnlocalizedName("sceptreCoreCradle").setTextureName("stygian:sceptreCoreCradle");
	
	public static ItemHourglass hourglass = (ItemHourglass)new ItemHourglass(false).setUnlocalizedName("hourglassIntact").setTextureName("stygian:hourglass");
	public static ItemHourglass hourglassCracked = (ItemHourglass)new ItemHourglass(true).setUnlocalizedName("hourglassCracked").setTextureName("stygian:hourglassCracked");

	public static Item stygianCore = new Item().setUnlocalizedName("stygianCore").setTextureName("stygian:focusCore");
	public static ItemSceptre sceptre = (ItemSceptre)new ItemSceptre().setUnlocalizedName("focusSceptre").setTextureName("stygian:sceptre").setFull3D();
	public static ItemStygianCore focusCore = (ItemStygianCore)new ItemStygianCore().setUnlocalizedName("stygianCore").setTextureName("stygian:focusCore");
	
	public static ItemResonanceStar resonanceStar = (ItemResonanceStar)new ItemResonanceStar().setUnlocalizedName("resonanceStar").setTextureName("stygian:resonanceStar");

	public static DamageSource damageSourceDrain = new DamageSource("stygianDrain").setDamageBypassesArmor().setDamageIsAbsolute().setMagicDamage();
	public static DamageSource damageSourceAttackWatchmaker = new DamageSource("watchmakerAttack");
	public static DamageSource damageSourceTime = new DamageSource("time").setDamageBypassesArmor().setDamageIsAbsolute();

	public static BlockStygianOre stygianOre = (BlockStygianOre)new BlockStygianOre(stygianCrystal, 0, "stygianOre", 10, 50).setBlockName("oreStygian").setBlockTextureName("stygian:oreStygian").setHardness(10.0F).setResistance(6000000.0F);
	public static BlockStygianOre pyroniumOre = (BlockStygianOre)new BlockStygianOre(resource, 0, "pyroniumOre", 4, 8).setBlockName("pyroniumOre").setBlockTextureName("stygian:pyroniumOre");
	public static BlockStygianOre cryoniteOre = (BlockStygianOre)new BlockStygianOre(resource, 1, "cryoniteOre", 4, 8).setBlockName("cryoniteOre").setBlockTextureName("stygian:cryoniteOre");
	
	public static BlockSoulForge soulForgeInactive = (BlockSoulForge)new BlockSoulForge(false).setBlockName("soulForge").setBlockTextureName("stygian:soulForge");
	public static BlockSoulForge soulForgeActive = (BlockSoulForge)new BlockSoulForge(true).setBlockName("soulForge").setBlockTextureName("stygian:soulForge");
	
	public static BlockVoidChest voidChest = (BlockVoidChest)new BlockVoidChest().setBlockName("voidChest").setBlockTextureName("stygian:black");
	public static BlockNetherForge netherForge = (BlockNetherForge)new BlockNetherForge().setBlockName("netherForge").setBlockTextureName("netherForge");
	
	public static Material liquidDarknessMaterial = new Material(MapColor.blackColor);
	public static FluidLiquidDarkness liquidDarkness = new FluidLiquidDarkness();
	public static BlockFluidLiquidDarkness liquidDarknessBlock;
	
	public static int sideworldDimensionID;
	public static WorldProviderStygian sideworldProvider = new WorldProviderStygian();
	
	public static PotionTimeSickness potionTimeSickness;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
//		Potion[] potionTypesModified = new Potion[2048];
//		System.arraycopy(Potion.potionTypes, 0, potionTypesModified, 0, Potion.potionTypes.length);
//		ReflectionHelper.setFinalField(cpw.mods.fml.relauncher.ReflectionHelper.findField(Potion.class, "potionTypes", "a"), null, potionTypesModified);
		
		logger.info("Reticulating splines...");
		
		StygianConfig.readAndSet(event.getModConfigurationDirectory());
		
		MinecraftForge.EVENT_BUS.register(new StygianEventHandler());
		
		stygianArmourRenderIndex = proxy.getStygianRenderIndex();
		voidChestRenderIndex = proxy.getVoidChestRenderingIndex();
		resonanceArmourRenderIndex = proxy.getResonanceRenderIndex();
		
		stygianHelmet = (ItemStygianArmour)new ItemStygianArmour(stygianArmourMaterial, stygianArmourRenderIndex, 0).setUnlocalizedName("stygianHelmet").setTextureName("stygian:stygianHelmet");
		stygianChestplate = (ItemStygianArmour)new ItemStygianArmour(stygianArmourMaterial, stygianArmourRenderIndex, 1).setUnlocalizedName("stygianChestplate").setTextureName("stygian:stygianChestplate");
		stygianLeggings = (ItemStygianArmour)new ItemStygianArmour(stygianArmourMaterial, stygianArmourRenderIndex, 2).setUnlocalizedName("stygianLeggings").setTextureName("stygian:stygianLeggings");
		stygianBoots = (ItemStygianArmour)new ItemStygianArmour(stygianArmourMaterial, stygianArmourRenderIndex, 3).setUnlocalizedName("stygianBoots").setTextureName("stygian:stygianBoots");
		
		resonanceHelmet = (ItemResonanceArmour)new ItemResonanceArmour(resonanceArmourMaterial, resonanceArmourRenderIndex, 0).setUnlocalizedName("resonanceHelmet").setTextureName("stygian:resonanceHelmet");
		resonanceChestplate = (ItemResonanceArmour)new ItemResonanceArmour(resonanceArmourMaterial, resonanceArmourRenderIndex, 1).setUnlocalizedName("resonanceChestplate").setTextureName("stygian:resonanceChestplate");
		resonanceLeggings = (ItemResonanceArmour)new ItemResonanceArmour(resonanceArmourMaterial, resonanceArmourRenderIndex, 2).setUnlocalizedName("resonanceLeggings").setTextureName("stygian:resonanceLeggings");
		resonanceBoots = (ItemResonanceArmour)new ItemResonanceArmour(resonanceArmourMaterial, resonanceArmourRenderIndex, 3).setUnlocalizedName("resonanceBoots").setTextureName("stygian:resonanceBoots");
		
		darkResonanceHelmet = (ItemDarkResonanceArmour)new ItemDarkResonanceArmour(darkResonanceArmourMaterial, darkResonanceArmourRenderIndex, 0).setUnlocalizedName("darkResonanceHelmet").setTextureName("stygian:darkResonanceHelmet");
		darkResonanceChestplate = (ItemDarkResonanceArmour)new ItemDarkResonanceArmour(darkResonanceArmourMaterial, darkResonanceArmourRenderIndex, 1).setUnlocalizedName("darkResonanceChestplate").setTextureName("stygian:darkResonanceChestplate");
		darkResonanceLeggings = (ItemDarkResonanceArmour)new ItemDarkResonanceArmour(darkResonanceArmourMaterial, darkResonanceArmourRenderIndex, 2).setUnlocalizedName("darkResonanceLeggings").setTextureName("stygian:darkResonanceLeggings");
		darkResonanceBoots = (ItemDarkResonanceArmour)new ItemDarkResonanceArmour(darkResonanceArmourMaterial, darkResonanceArmourRenderIndex, 3).setUnlocalizedName("darkResonanceBoots").setTextureName("stygian:darkResonanceBoots");
		
//		potionTimeSickness = (PotionTimeSickness)new PotionTimeSickness(598).setPotionName("potion.timeSickness");
		
		GameRegistry.registerItem(stygianCrystal, "stygianCrystal");
		
		GameRegistry.registerItem(resource, "resource");
		
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
		
		GameRegistry.registerItem(darkResonanceSword, "darkResonanceSword");
		GameRegistry.registerItem(darkResonancePickaxe, "darkResonancePickaxe");
		GameRegistry.registerItem(darkResonanceShovel, "darkResonanceShovel");
		GameRegistry.registerItem(darkResonanceAxe, "darkResonanceAxe");
		GameRegistry.registerItem(darkResonanceHoe, "darkResonanceHoe");

		GameRegistry.registerItem(elderSword, "elderSword");
		GameRegistry.registerItem(elderPickaxe, "elderPickaxe");
		GameRegistry.registerItem(elderShovel, "elderShovel");
		GameRegistry.registerItem(elderAxe, "elderAxe");
		GameRegistry.registerItem(elderHoe, "elderHoe");
		
		GameRegistry.registerItem(stygianHelmet, "stygianHelmet");
		GameRegistry.registerItem(stygianChestplate, "stygianChestplate");
		GameRegistry.registerItem(stygianLeggings, "stygianLeggings");
		GameRegistry.registerItem(stygianBoots, "stygianBoots");
		
		GameRegistry.registerItem(resonanceHelmet, "resonanceHelmet");
		GameRegistry.registerItem(resonanceChestplate, "resonanceChestplate");
		GameRegistry.registerItem(resonanceLeggings, "resonanceLeggings");
		GameRegistry.registerItem(resonanceBoots, "resonanceBoots");
		
		GameRegistry.registerItem(darkResonanceHelmet, "darkResonanceHelmet");
		GameRegistry.registerItem(darkResonanceChestplate, "darkResonanceChestplate");
		GameRegistry.registerItem(darkResonanceLeggings, "darkResonanceLeggings");
		GameRegistry.registerItem(darkResonanceBoots, "darkResonanceBoots");
		
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

		GameRegistry.registerBlock(soulForgeInactive, "soulForgeInactive");
		GameRegistry.registerBlock(soulForgeActive, "soulForgeActive");
		
		GameRegistry.registerBlock(voidChest, "voidChest");
		GameRegistry.registerBlock(netherForge, "netherForge");
		
		FluidRegistry.registerFluid(liquidDarkness);
		
		liquidDarknessBlock = (BlockFluidLiquidDarkness)new BlockFluidLiquidDarkness(liquidDarkness, liquidDarknessMaterial).setBlockName("liquidDarkness").setBlockTextureName("stygian:black");
		
		GameRegistry.registerBlock(liquidDarknessBlock, "liquidDarkness");
		liquidDarkness.setBlock(liquidDarknessBlock);
		
		GameRegistry.registerWorldGenerator(new WorldGenHandler(), 0);
		
		//EntityRegistry.registerGlobalEntityID(EntityDarkLightning.class, "darkLightningBolt", 301);
		
		//EntityRegistry.registerModEntity(EntityDarkLightning.class, "darkLightningBolt", 0, this, 80, 3, false);
		
		sideworldDimensionID = DimensionManager.getNextFreeDimId();
		DimensionManager.registerProviderType(sideworldDimensionID, WorldProviderSurface.class, true);
		DimensionManager.registerDimension(sideworldDimensionID, sideworldDimensionID);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		liquidDarkness.setIcons(liquidDarknessBlock.fluidIcon);
		
		stygianCrystal.setCreativeTab(tabStygian);
		
		resource.setCreativeTab(tabStygian);
		
		stygianSword.setCreativeTab(tabStygian);
		stygianPickaxe.setCreativeTab(tabStygian);
		stygianShovel.setCreativeTab(tabStygian);
		stygianAxe.setCreativeTab(tabStygian);
		stygianHoe.setCreativeTab(tabStygian);
		
		resonanceSword.setCreativeTab(tabStygian);
		resonancePickaxe.setCreativeTab(tabStygian);
		resonanceShovel.setCreativeTab(tabStygian);
		resonanceAxe.setCreativeTab(tabStygian);
		resonanceHoe.setCreativeTab(tabStygian);
		
		darkResonanceSword.setCreativeTab(tabStygian);
		darkResonancePickaxe.setCreativeTab(tabStygian);
		darkResonanceShovel.setCreativeTab(tabStygian);
		darkResonanceAxe.setCreativeTab(tabStygian);
		darkResonanceHoe.setCreativeTab(tabStygian);

		elderSword.setCreativeTab(tabStygian);
		elderPickaxe.setCreativeTab(tabStygian);
		elderShovel.setCreativeTab(tabStygian);
		elderAxe.setCreativeTab(tabStygian);
		elderHoe.setCreativeTab(tabStygian);
		
		stygianHelmet.setCreativeTab(tabStygian);
		stygianChestplate.setCreativeTab(tabStygian);
		stygianLeggings.setCreativeTab(tabStygian);
		stygianBoots.setCreativeTab(tabStygian);
		
		resonanceHelmet.setCreativeTab(tabStygian);
		resonanceChestplate.setCreativeTab(tabStygian);
		resonanceLeggings.setCreativeTab(tabStygian);
		resonanceBoots.setCreativeTab(tabStygian);
		
		darkResonanceHelmet.setCreativeTab(tabStygian);
		darkResonanceChestplate.setCreativeTab(tabStygian);
		darkResonanceLeggings.setCreativeTab(tabStygian);
		darkResonanceBoots.setCreativeTab(tabStygian);
		
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
		
		soulForgeInactive.setCreativeTab(tabStygian);
		
		voidChest.setCreativeTab(tabStygian);
		netherForge.setCreativeTab(tabStygian);
		
		liquidDarknessBlock.setCreativeTab(tabStygian);
		
		stygianArmourMaterial.customCraftingMaterial = stygianCrystal;
		stygianToolMaterial.customCraftingMaterial = stygianCrystal;

		stygianOre.setHarvestLevel("pickaxe", 3);
		stygianBlock.setHarvestLevel("pickaxe", 4);
		
		GameRegistry.addRecipe(new ItemStack(soulForgeInactive, 1), "@#@", "#-#", "@_@", '@', Blocks.diamond_block, '#', new ItemStack(stygianCrystal, 1, 1), '-', Blocks.furnace, '_', Items.lava_bucket);
		
		GameRegistry.addSmelting(new ItemStack(stygianCrystal, 1, 0), new ItemStack(stygianCrystal, 1, 1), 48.0F);
		
		proxy.registerTileEntities();
		proxy.registerGuiHandler();
		proxy.registerRenderers();
		proxy.registerCapes();
		proxy.registerTickHandlers();
		
		FocusRegistry.registerFoci();
		ResonanceRegistry.registerResonances();
		
		RecipeManager.registerRecipes();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		IntegrationManager.init();
	}
}
