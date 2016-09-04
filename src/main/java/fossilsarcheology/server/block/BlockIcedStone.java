package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

import java.util.Random;

public class BlockIcedStone extends Block {
    public BlockIcedStone() {
        super(Material.ROCK);
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(1.5F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.STONE);
        this.setUnlocalizedName(LocalizationStrings.BLOCK_ICEDSTONE_NAME);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(Blocks.COBBLESTONE);
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        this.spread(world, pos);
    }

    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block) {
        this.spread(world, pos);
    }

    private void spread(World world, BlockPos pos) {
        if (world.getLightFor(EnumSkyBlock.BLOCK, pos) <= 11 - this.lightOpacity && (!world.canBlockSeeSky(pos.up()) || !world.isDaytime())) {
            Random random = new Random();
            int runs = 0;
            while (runs < 20) {
                int offsetX = random.nextInt(3) - 1;
                int offsetY = random.nextInt(3) - 1;
                int offsetZ = random.nextInt(3) - 1;
                BlockPos offsetPos = pos.add(offsetX, offsetY, offsetZ);
                IBlockState offsetState = world.getBlockState(offsetPos);
                Block offsetBlock = offsetState.getBlock();
                if (offsetBlock != Blocks.FLOWING_WATER && offsetBlock != Blocks.WATER) {
                    if (offsetBlock != Blocks.FLOWING_LAVA && offsetBlock != Blocks.LAVA && offsetBlock != Blocks.FIRE) {
                        ++runs;
                        continue;
                    }
                    world.setBlockState(pos, Blocks.STONE.getDefaultState());
                    return;
                }
                world.setBlockState(offsetPos, Blocks.ICE.getDefaultState());
                return;
            }
        } else {
            world.setBlockState(pos, Blocks.STONE.getDefaultState());
        }
    }
}
