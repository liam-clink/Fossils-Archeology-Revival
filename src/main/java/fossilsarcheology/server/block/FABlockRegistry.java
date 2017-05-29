	package fossilsarcheology.server.block;

    import fossilsarcheology.Revival;
    import fossilsarcheology.server.api.BlockEntity;
    import net.minecraft.block.Block;
    import net.minecraft.block.material.MapColor;
    import net.minecraft.block.material.Material;
    import net.minecraft.item.ItemBlock;
    import net.minecraft.util.ResourceLocation;
    import net.minecraftforge.fluids.Fluid;
    import net.minecraftforge.fluids.FluidRegistry;
    import net.minecraftforge.fml.common.registry.GameRegistry;

    import java.lang.reflect.Field;
    import java.util.ArrayList;
    import java.util.List;

public class FABlockRegistry {
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final FossilBlock FOSSIL = new FossilBlock();
    public static final AmberOreBlock AMBER_ORE = new AmberOreBlock();
    public static final SkullBlock SKULL_BLOCK = new SkullBlock(false);
    public static final SkullBlock SKULL_LANTERN = new SkullBlock(true);
    public static final CultivateBlock CULTIVATE_IDLE = new CultivateBlock(false);
    public static final CultivateBlock CULTIVATE_ACTIVEE = new CultivateBlock(true);
    public static final WorktableBlock WORKTABLE_IDLE = new WorktableBlock(false);
    public static final WorktableBlock WORKTABLE_ACTIVE = new WorktableBlock(true);
    public static final SifterBlock SIFTER_IDLE = new SifterBlock(false);
    public static final SifterBlock SIFTER_ACTIVE = new SifterBlock(true);
    public static final AnalyzerBlock ANALYZER = new AnalyzerBlock(false);
    public static final AnalyzerBlock ANALYZER_ACTIVE = new AnalyzerBlock(true);
    public static final BubbleBlowerBlock BUBBLE_MACHINE = new BubbleBlowerBlock();
    public static final FeederBlock FEEDER = new FeederBlock();
    public static final PermafrostBlock PERMAFROST = new PermafrostBlock();
    public static final IcedStoneBlock ICED_STONE = new IcedStonetBlock();
    public static final DenseSandBlock DENSE_SAND = new DenseSandBlock();
    public static final StrongGlassBlock STRONG_GLASS = new StrongGlassBlock();
    public static final AncientGlassBlock ANCIENT_GLASS = new AncientGlassBlock();
    public static final SlimeTrailBlock SLIME_TRAIL = new SlimeTrailBlock();
    public static final AncientStoneBlock ANCIENT_STONE = new AncientStoneBlock();
    public static final AncientStonebrickBlock ANCIENT_STONE_BRICK = new AncientStonebrickBlock();
    public static final AncientStoneStairsBlock ANCIENT_STONE_STAIRS = new AncientStoneStairsBlock();
    public static final AncientStoneSlabBlock ANCIENT_STONE_DOUBLESLAB = new AncientStoneSlabBlock(true);
    public static final AncientStoneSlabBlock ANCIENT_STONE_SINGLESLAB = new AncientStoneSlabBlock(false);
    public static final VolcanicAshBlock VOLCANIC_ASH = new VolcanicAshBlock("ash");
    public static final VolcanicAshBlock VOLCANIC_BRICK = new VolcanicAshBlock("brick");
    public static final VolcanicAshBlock VOLCANIC_ROCK = new VolcanicAshBlock("rock");
    public static final VolcanicStairsBlock VOLCANIC_STAIRS = new VolcanicStairsBlock();
    public static final VolcanicSlabBlock VOLCANIC_DOUBLESLAB = new VolcanicSlabBlock(true);
    public static final VolcanicSlabBlock VOLCANIC_SINGLESLAB = new VolcanicSlabBlock(false);
    public static final AnuPortalBlock ANU_PORTAL = new AnuPortalBlock();
    public static final AnuStatueBlock ANU_STATUE = new AnuStatueBlock();
    public static final HomePortalBlock HOME_PORTAL = new HomePortalBlock();
    public static final AnubiteStatueBlock ANUBITE_STATUE = new AnubiteStatueBlock();
    public static final AncientChestBlock ANCIENT_CHEST = new AncientChestBlock();
    public static final SarcophagusBlock SARCOPHAGUS = new SarcophagusBlock();
    public static final Block FIGURINE = new Block(Material.AIR);//TODO later
    public static final AmphoraVaseBlock AMPHORA_VASE = new AmphoraVaseBlock();
    public static final KylixVaseBlock KYLIX_VASE = new KylixVaseBlock();
    public static final VoluteVaseBlock VOLUTE_VASE = new VoluteVaseBlock();
    public static final TimeMachineBlock TIME_MACHINE = new TimeMachineBlock();
    public static final DrumBlock DRUM = new DrumBlock();
    public static final TarBlock TAR = new TarBlock();
    public static final PalmLogBlock PALM_LOG = new PalmLogBlock();
    public static final PalmLeavesBlock PALM_LEAVES = new PalmLeavesBlock();
    public static final PalmSaplingBlock PALM_SAPLING = new PalmSaplingBlock();
    public static final PalmPlanksBlock PALM_PLANKS = new PalmPlanksBlock();
    public static final PalmPlanksSlabBlock PALM_PLANKS_DOUBLESLAB = new PalmPlanksSlabBlock(true);
    public static final PalmPlanksSlabBlock PALM_PLANKS_SINGLESLAB = new PalmPlanksSlabBlock(false);
    public static final PalmPlanksStairsBlock PALM_PLANKS_STAIRS = new PalmPlanksStairsBlock();
    public static final AncientWoodBlock ANCIENT_WOOD = new AncientWoodBlock();
    public static final AncientWoodPlateBlock ANCIENT_WOOD_PLATE = new AncientWoodPlateBlock();
    public static final AncientWoodStairsBlock ANCIENT_WOOD_STAIRS = new AncientWoodStairsBlock();
    public static final AncientWoodSlabBlock ANCIENT_WOOD_DOUBLESLAB = new AncientWoodSlabBlock(true);
    public static final AncientWoodSlabBlock ANCIENT_WOOD_SINGLESLAB = new AncientWoodSlabBlock(false);
    public static final ObsidianSpikesBlock OBSIDIAN_SPIKES = new ObsidianSpikesBlock();
    public static final FernsBlock FERNS = new FernsBlock();
    public static final DillhoffiaFlowerBlock DILLHOFFIA_FLOWER = new DillhoffiaFlowerBlock();
    public static final SarraceniaFlowerBlock SARRACENIA_FLOWER = new SarraceniaFlowerBlock();
    public static final CephalotaxusFlowerBlock CEPHALOTAXUS_FLOWER = new CephalotaxusFlowerBlock();
    public static final LicopodiophytaFlowerBlock LICOPODIOPHYTA_FLOWER = new LicopodiophytaFlowerBlock();
    public static final PaleopanaxFlowerBlock PALEOPANAX_FLOWER = new PaleopanaxFlowerBlock();
    public static final ZamitesFlowerBlock ZAMITES_FLOWER = new ZamitesFlowerBlock();
    public static final BennettitalesSmallFlowerBlock BENNETTITALES_SMALL_FLOWER = new BennettitalesSmallFlowerBlock();
    public static final BennettitalesLargeFlowerBlock BENNETTITALES_LARGE_FLOWER = new BennettitalesLargeFlowerBlock();
    public static final WelwitschiaFlowerBlock WELWITSCHIA_FLOWER = new WelwitschiaFlowerBlock();
    public static final HorsetailSmallFlowerBlock HORSETAIL_SMALL_FLOWER = new HorsetailSmallFlowerBlock();
    public static final HorsetailLargeFlowerBlock HORSETAIL_LARGE_FLOWER = new HorsetailLargeFlowerBlock();
    public static final MutantFlowerBlock MUTANT_FLOWER = new MutantFlowerBlock();
    public static final TempskyaBlock TEMPSKYA_FLOWER = new TempskyaBlock();
    public static final VacciniumFlowerBlock VACCINIUM_FLOWER = new VacciniumFlowerBlock();
    public static final OsmundaFlowerBlock OSMUNDA_FLOWER = new OsmundaFlowerBlock();
    public static final CrataegusFlowerBlock CRATAEGUS_FLOWER = new CrataegusFlowerBlock();
    public static final FlorissantiaFlowerBlock FLORISSANTIA_FLOWER = new FlorissantiaFlowerBlock();
    public static final EphendraFlowerBlock EPENDRA_FLOWER = new EphendraFlowerBlock();
    public static final Fluid TAR_FLUID = new FluidTar();
    public static final Fluid TAR_MATERIAL = new MaterialTar(MapColor.BLACK);



    public static void register() {
        FluidRegistry.registerFluid(TAR_FLUID);

        try {
            for (Field f : FABlockRegistry.class.getDeclaredFields()) {
                Object obj = f.get(null);
                if (obj instanceof Block) {
                    FABlockRegistry.registerBlock((Block) obj);
                } else if (obj instanceof Block[]) {
                    for (Block block : (Block[]) obj) {
                        FABlockRegistry.registerBlock(block);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void registerBlock(Block block) {
        String name = block.getUnlocalizedName().substring("tile.".length());
        ResourceLocation identifier = new ResourceLocation(Revival.MODID, name);
        GameRegistry.register(block, identifier);
        GameRegistry.register(new ItemBlock(block), identifier);
        BLOCKS.add(block);
        if (block instanceof BlockEntity) {
            GameRegistry.registerTileEntity(((BlockEntity) block).getEntity(), Revival.MODID + "." + name);
        }
    }
}
