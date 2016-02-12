package com.github.revival;

import com.github.revival.client.renderer.tileentity.RenderFeeder;
import com.github.revival.common.CommonProxy;
import com.github.revival.common.ModState;
import com.github.revival.common.biome.BiomeBasic;
import com.github.revival.common.block.FABlockRegistry;
import com.github.revival.common.block.sound.FossilSoundType;
import com.github.revival.common.config.FossilConfig;
import com.github.revival.common.creativetab.FATabRegistry;
import com.github.revival.common.dimension.anu.WorldProviderAnu;
import com.github.revival.common.dimension.treasure.WorldProviderTreasure;
import com.github.revival.common.enchantment.EnchantmentArcheology;
import com.github.revival.common.enchantment.EnchantmentPaleontology;
import com.github.revival.common.entity.*;
import com.github.revival.common.entity.mob.*;
import com.github.revival.common.enums.EnumDinoFoodMob;
import com.github.revival.common.enums.EnumPrehistoric;
import com.github.revival.common.gen.*;
import com.github.revival.common.gen.structure.AcademyGenerator;
import com.github.revival.common.gen.structure.ShipWreckGenerator;
import com.github.revival.common.handler.*;
import com.github.revival.common.item.FAItemRegistry;
import com.github.revival.common.message.MessageDinoSit;
import com.github.revival.common.tileentity.*;
import com.github.revival.misc.FossilFoodMappings;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import net.ilexiconn.llibrary.common.config.ConfigHelper;
import net.ilexiconn.llibrary.common.content.ContentHelper;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import org.apache.logging.log4j.Level;

@Mod(modid = Revival.MODID, name = "Fossils and Archeology Revival", version = Revival.VERSION, dependencies = "required-after:llibrary@[" + Revival.LLIBRARY_VERSION + ",)")
public class Revival
{
	public static final String MODID = "fossil";
	public static final ModState STATE = ModState.DEV;
	public static final String VERSION = "7.3.0-develop";
    public static final String LLIBRARY_VERSION = "0.7.0";

	@SidedProxy(clientSide = "com.github.revival.client.ClientProxy", serverSide = "com.github.revival.common.CommonProxy")
	public static CommonProxy proxy;
	@Instance(MODID)
	public static Revival instance;

	public static FossilGuiHandler guiHandler = new FossilGuiHandler();

	public static Object toPedia;
	public static SimpleNetworkWrapper channel;

	public static int feederRenderID;

	public static Enchantment paleontology;
	public static Enchantment archeology;

	public static BiomeGenBase anuBiome;
	public static BiomeGenBase treasureBiome;
	public static ArmorMaterial bone = EnumHelper.addArmorMaterial("Bone", 25, new int[]{2, 7, 6, 2}, 15);
	public static ToolMaterial scarab = EnumHelper.addToolMaterial("Scarab", 3, 1861, 8.0F, 4.0F, 25);

	public static final FossilSoundType soundTypeSlime = new FossilSoundType(1.0F, 1.0F);

	public static ToolMaterial toothDaggerMaterial = EnumHelper.addToolMaterial("toothDagger", 3, 250, 70.0F, 1.5F, 25);
	public Configuration config;
	
	public static Material tar_material;
	public static Fluid tar_fluid;

	public static boolean enableDebugging()
	{
		return STATE == ModState.DEV;
	}

	public static void showMessage(String message, EntityPlayer player)
	{
		if (player != null)
		{
			player.addChatMessage(new ChatComponentText(message));
		}
	}

	public static void printDebug(String message)
	{
		if (enableDebugging())
		{
			FMLLog.log(Revival.MODID, Level.INFO, message);
		}
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		channel = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
		channel.registerMessage(MessageDinoSit.class, MessageDinoSit.class, 2, Side.SERVER);

		MinecraftForge.EVENT_BUS.register(new FossilBonemealEvent());
		MinecraftForge.EVENT_BUS.register(new EventPlayer());
		VillagerRegistry.instance().registerVillageTradeHandler(10, new FossilTradeHandler());
		VillagerRegistry.instance().registerVillagerId(10);

		ConfigHelper.registerConfigHandler(MODID, event.getSuggestedConfigurationFile(), new FossilConfig());
		ContentHelper.init(new FATabRegistry(), new FABlockRegistry(), new FAItemRegistry());
		EnumPrehistoric.init();
		FossilOreDictionary.oreRegistration();
		FossilFoodMappings.init();
		DimensionManager.registerProviderType(FossilConfig.dimIdDarknessLair, WorldProviderAnu.class, false);
		DimensionManager.registerDimension(FossilConfig.dimIdDarknessLair, FossilConfig.dimIdDarknessLair);
		DimensionManager.registerProviderType(FossilConfig.dimIdTreasure, WorldProviderTreasure.class, false);
		DimensionManager.registerDimension(FossilConfig.dimIdTreasure, FossilConfig.dimIdTreasure);

		paleontology = new EnchantmentPaleontology(FossilConfig.enchIdPaleontology, 2, EnumEnchantmentType.digger);
		archeology = new EnchantmentArcheology(FossilConfig.enchIdArcheology, 2, EnumEnchantmentType.digger);

		anuBiome = new BiomeBasic(FossilConfig.biomeIdDarknessLair, Blocks.netherrack, Blocks.netherrack, true, 0, 0).setDisableRain().setBiomeName(LocalizationStrings.BIOME_ANU).setTemperatureRainfall(0.8F, 0F).setHeight(new BiomeGenBase.Height(0F, 0F));
		treasureBiome = new BiomeBasic(FossilConfig.biomeIdTreasure, Blocks.air, Blocks.air, true, 1, 0).setDisableRain().setBiomeName(StatCollector.translateToLocal("biome.treasure.name")).setTemperatureRainfall(0.8F, 0F).setHeight(new BiomeGenBase.Height(0F, 0F));

		EntityRegistry.registerModEntity(EntityStoneboard.class, "StoneBoard", 1, this, 250, Integer.MAX_VALUE, false);
		EntityRegistry.registerModEntity(EntityJavelin.class, "Javelin", 2, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityAncientJavelin.class, "AncientJavelin", 3, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityMLighting.class, "FriendlyLighting", 4, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityFailuresaurus.class, "Failuresaurus", 5, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityBones.class, "Bones", 6, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityDinoEgg.class, "DinoEgg", 8, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityFriendlyPigZombie.class, "FriendlyPigZombie", 12, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityAnu.class, "PigBoss", 13, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntitySmilodon.class, "Smilodon", 22, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityMammoth.class, "Mammoth", 24, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityDodo.class, "Dodo", 25, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityDodoEgg.class, "DodoEgg", 26, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityCoelacanth.class, "Coelacanth", 28, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityQuagga.class, "Quagga", 30, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityTerrorBird.class, "TerrorBird", 31, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityTerrorBirdEgg.class, "TerrorBirdEgg", 32, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityElasmotherium.class, "Elasmotherium", 33, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityAnuEffect.class, "AnuEffect", 34, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityAnubite.class, "Anubite", 39, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntitySentryPigman.class, "SentryPigman", 40, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityAnuDead.class, "AnuDead", 41, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityTarSlime.class, "TarSlime", 42, this, 250, 3, true);

		for (int i = 0; i < EnumPrehistoric.values().length; i++)
		{
			EntityRegistry.registerModEntity(EnumPrehistoric.values()[i].getDinoClass(), EnumPrehistoric.values()[i].name(), 200 + i, this, 250, 3, true);
		}

		EntityRegistry.addSpawn(EntityCoelacanth.class, 1, 2, 4, EnumCreatureType.waterCreature, BiomeGenBase.ocean);
		EntityRegistry.addSpawn(EntityNautilus.class, 5, 4, 14, EnumCreatureType.waterCreature, BiomeGenBase.river, BiomeGenBase.ocean);

		FossilSpawnEggs.addSpawnEggs();
		EnumDinoFoodMob.init();

		GameRegistry.registerWorldGenerator(new FossilGenerator(), 0);

		if (FossilConfig.generatePalaeoraphe) GameRegistry.registerWorldGenerator(new WorldGeneratorPalaeoraphe(), 0);
		if (FossilConfig.generateAcademy) GameRegistry.registerWorldGenerator(new AcademyGenerator(), 0);
		if (FossilConfig.generateShips) GameRegistry.registerWorldGenerator(new ShipWreckGenerator(), 0);

		GameRegistry.registerWorldGenerator(new WorldGenMiscStructures(), 0);

		GameRegistry.registerWorldGenerator(new TarGenerator(), 0);
		GameRegistry.registerWorldGenerator(new VolcanicRockGenerator(), 13);

		feederRenderID = RenderingRegistry.getNextAvailableRenderId();

		NetworkRegistry.INSTANCE.registerGuiHandler(this, guiHandler);

		GameRegistry.registerTileEntity(TileEntityCultivate.class, LocalizationStrings.BLOCK_CULTIVATE_IDLE_NAME);
		GameRegistry.registerTileEntity(TileEntityAnalyzer.class, LocalizationStrings.BLOCK_ANALYZER_IDLE_NAME);
		GameRegistry.registerTileEntity(TileEntityWorktable.class, LocalizationStrings.BLOCK_WORKTABLE_IDLE_NAME);
		GameRegistry.registerTileEntity(TileEntityDrum.class, LocalizationStrings.DRUM_NAME);
		GameRegistry.registerTileEntity(TileEntityFeeder.class, LocalizationStrings.T_FEEDER_IDLE_NAME);
		GameRegistry.registerTileEntity(TileEntityTimeMachine.class, LocalizationStrings.BLOCK_TIMEMACHINE_NAME);
		GameRegistry.registerTileEntity(TileEntitySifter.class, LocalizationStrings.BLOCK_SIFTER_IDLE);
		GameRegistry.registerTileEntity(TileEntityFigurine.class, "figurineType");
		GameRegistry.registerTileEntity(TileEntityVase.class, "vaseType");
		GameRegistry.registerTileEntity(TileEntityAnuTotem.class, LocalizationStrings.BLOCK_ANU_NAME);
		GameRegistry.registerTileEntity(TileEntityAnubiteStatue.class, "Anubite_Statue");
		GameRegistry.registerTileEntity(TileEntityAncientChest.class, "Ancient_Chest");
		GameRegistry.registerTileEntity(TileEntitySarcophagus.class, "sarcophagus");

		RenderingRegistry.registerBlockHandler(2303, RenderFeeder.INSTANCE);
		proxy.init();

		FossilRecipeHandler.addRecipe();

		FMLCommonHandler.instance().bus().register(new PickupHandler());
		FMLCommonHandler.instance().bus().register(new EventFossilAchivements());

		proxy.registerChestLoot();
		FossilAchievementHandler.loadAchievements();
		MinecraftForge.EVENT_BUS.register(new FossilToolEvent());
		MinecraftForge.EVENT_BUS.register(new FossilLivingEvent());
		MinecraftForge.EVENT_BUS.register(new FossilInteractEvent());

		FMLCommonHandler.instance().bus().register(new FossilConnectionEvent());
		
	}
}
