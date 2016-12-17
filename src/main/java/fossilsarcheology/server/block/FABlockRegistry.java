	package fossilsarcheology.server.block;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import fossilsarcheology.Revival;
import fossilsarcheology.server.api.BlockEntity;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FABlockRegistry {
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final FossilBlock FOSSIL = new FossilBlock();
    public static final AmberOreBlock AMBER_ORE = new AmberOreBlock();

    public static final AnalyzerBlock ANALYZER = new AnalyzerBlock(false);
    public static final AnalyzerBlock ANALYZER_ACTIVE = new AnalyzerBlock(true);

    public static final PermafrostBlock PERMAFROST = new PermafrostBlock();
    
    public static final DenseSandBlock DENSE_SAND = new DenseSandBlock();
    
    public static final AncientStoneBlock ANCIENT_STONE = new AncientStoneBlock();
    public static final AncientStonebrickBlock ANCIENT_STONE_BRICK = new AncientStonebrickBlock();
    
    public static final VolcanicAshBlock VOLCANIC_ASH = new VolcanicAshBlock("ash");
    public static final VolcanicAshBlock VOLCANIC_BRICK = new VolcanicAshBlock("brick");
    public static final VolcanicAshBlock VOLCANIC_ROCK = new VolcanicAshBlock("rock");
    
    public static final DillhoffiaFlowerBlock DILLHOFFIA_FLOWER = new DillhoffiaFlowerBlock();
    public static final SarraceniaFlowerBlock SARRACENIA_FLOWER = new SarraceniaFlowerBlock();
    
    public static void register() {
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
