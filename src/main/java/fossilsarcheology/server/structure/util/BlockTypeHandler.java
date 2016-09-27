package fossilsarcheology.server.structure.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockTypeHandler {
    private static final Map<Block, RotationType> ROTATION_TYPES = new HashMap<>();
    private static final List<Block> WALL_MOUNTED_BLOCKS = new ArrayList<>();

    static {
        register(Blocks.ANVIL, RotationType.HORIZONTAL);
        register(Blocks.BED, RotationType.HORIZONTAL);
        register(Blocks.COCOA, RotationType.HORIZONTAL);
        register(Blocks.OAK_FENCE_GATE, RotationType.HORIZONTAL);
        register(Blocks.DARK_OAK_FENCE_GATE, RotationType.HORIZONTAL);
        register(Blocks.BIRCH_FENCE_GATE, RotationType.HORIZONTAL);
        register(Blocks.JUNGLE_FENCE_GATE, RotationType.HORIZONTAL);
        register(Blocks.ACACIA_FENCE_GATE, RotationType.HORIZONTAL);
        register(Blocks.SPRUCE_FENCE_GATE, RotationType.HORIZONTAL);
        register(Blocks.PUMPKIN, RotationType.HORIZONTAL);
        register(Blocks.LIT_PUMPKIN, RotationType.HORIZONTAL);
        register(Blocks.POWERED_COMPARATOR, RotationType.HORIZONTAL);
        register(Blocks.UNPOWERED_COMPARATOR, RotationType.HORIZONTAL);
        register(Blocks.POWERED_REPEATER, RotationType.HORIZONTAL);
        register(Blocks.UNPOWERED_REPEATER, RotationType.HORIZONTAL);
        register(Blocks.END_PORTAL_FRAME, RotationType.HORIZONTAL);
        register(Blocks.WALL_BANNER, RotationType.HORIZONTAL);
        register(Blocks.STANDING_BANNER, RotationType.HORIZONTAL);
        register(Blocks.CHEST, RotationType.HORIZONTAL);
        register(Blocks.ENDER_CHEST, RotationType.HORIZONTAL);
        register(Blocks.TRAPPED_CHEST, RotationType.HORIZONTAL);
        register(Blocks.OAK_DOOR, RotationType.HORIZONTAL);
        register(Blocks.DARK_OAK_DOOR, RotationType.HORIZONTAL);
        register(Blocks.BIRCH_DOOR, RotationType.HORIZONTAL);
        register(Blocks.JUNGLE_DOOR, RotationType.HORIZONTAL);
        register(Blocks.ACACIA_DOOR, RotationType.HORIZONTAL);
        register(Blocks.SPRUCE_DOOR, RotationType.HORIZONTAL);
        register(Blocks.FURNACE, RotationType.HORIZONTAL);
        register(Blocks.LIT_FURNACE, RotationType.HORIZONTAL);
        register(Blocks.LADDER, RotationType.HORIZONTAL);
        register(Blocks.OAK_STAIRS, RotationType.HORIZONTAL);
        register(Blocks.DARK_OAK_STAIRS, RotationType.HORIZONTAL);
        register(Blocks.BIRCH_STAIRS, RotationType.HORIZONTAL);
        register(Blocks.JUNGLE_STAIRS, RotationType.HORIZONTAL);
        register(Blocks.ACACIA_STAIRS, RotationType.HORIZONTAL);
        register(Blocks.SPRUCE_STAIRS, RotationType.HORIZONTAL);
        register(Blocks.TRAPDOOR, RotationType.HORIZONTAL);
        register(Blocks.TRIPWIRE_HOOK, RotationType.HORIZONTAL);
        register(Blocks.WALL_SIGN, RotationType.HORIZONTAL);

        registerWallMounted(Blocks.TORCH);
        registerWallMounted(Blocks.LEVER);
        registerWallMounted(Blocks.STONE_BUTTON);
        registerWallMounted(Blocks.WOODEN_BUTTON);
    }

    public static void register(Block block, RotationType type) {
        ROTATION_TYPES.put(block, type);
    }

    public static void registerWallMounted(Block block) {
        WALL_MOUNTED_BLOCKS.add(block);
    }

    public static IBlockState set(IBlockState state, EnumFacing direction) {
        RotationType type = ROTATION_TYPES.get(state.getBlock());
        if (type != null) {
            return type.set(state, direction);
        }
        return state;
    }

    public static EnumFacing get(IBlockState state) {
        RotationType type = ROTATION_TYPES.get(state.getBlock());
        if (type != null) {
            return type.get(state);
        }
        return EnumFacing.NORTH;
    }

    public static boolean isWallMounted(IBlockState state) {
        return WALL_MOUNTED_BLOCKS.contains(state.getBlock());
    }

    public static RotationType getRotationType(IBlockState state) {
        return ROTATION_TYPES.get(state.getBlock());
    }

    static abstract class RotationType {
        public static final RotationType HORIZONTAL = RotationType.forProperty(BlockHorizontal.FACING);

        abstract IBlockState set(IBlockState state, EnumFacing direction);

        abstract EnumFacing get(IBlockState state);

        public static RotationType forProperty(PropertyDirection property) {
            return new RotationType() {
                @Override
                IBlockState set(IBlockState state, EnumFacing direction) {
                    return state.withProperty(property, direction);
                }

                @Override
                EnumFacing get(IBlockState state) {
                    return state.getValue(property);
                }
            };
        }
    }
}
