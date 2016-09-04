package fossilsarcheology.server.block;

import fossilsarcheology.Revival;
import fossilsarcheology.server.creativetab.FATabRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockBubbleMachine extends Block {
    private static final PropertyDirection FACING = BlockHorizontal.FACING;

    public BlockBubbleMachine() {
        super(Material.IRON);
        this.setSoundType(SoundType.METAL);
        this.setHardness(3.0F);
        this.setUnlocalizedName("bubbleMachine");
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(FABlockRegistry.INSTANCE.bubbleMachine);
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
        super.randomDisplayTick(state, world, pos, rand);
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        if (world.isBlockIndirectlyGettingPowered(pos) > 0) {
            world.playSound(null, pos, SoundEvents.BLOCK_LAVA_POP, SoundCategory.BLOCKS, 0.5F, rand.nextFloat() * 0.7F + 0.4F);
            switch (state.getValue(FACING)) {
                case SOUTH:
                    Revival.PROXY.spawnBubbleParticles(world, x + rand.nextFloat(), y + rand.nextFloat(), z, 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x + rand.nextFloat(), y + rand.nextFloat(), z, 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x + rand.nextFloat(), y + rand.nextFloat(), z, 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x + rand.nextFloat(), y + rand.nextFloat(), z, 0, 0.1, 0);
                    break;
                case NORTH:
                    Revival.PROXY.spawnBubbleParticles(world, x + rand.nextFloat(), y + rand.nextFloat(), z + 1.1F, 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x + rand.nextFloat(), y + rand.nextFloat(), z + 1.1F, 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x + rand.nextFloat(), y + rand.nextFloat(), z + 1.1F, 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x + rand.nextFloat(), y + rand.nextFloat(), z + 1.1F, 0, 0.1, 0);
                    break;
                case EAST:
                    Revival.PROXY.spawnBubbleParticles(world, x, y + rand.nextFloat(), z + rand.nextFloat(), 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x, y + rand.nextFloat(), z + rand.nextFloat(), 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x, y + rand.nextFloat(), z + rand.nextFloat(), 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x, y + rand.nextFloat(), z + rand.nextFloat(), 0, 0.1, 0);
                    break;
                case WEST:
                    Revival.PROXY.spawnBubbleParticles(world, x + 1.1F, y + rand.nextFloat(), z + rand.nextFloat(), 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x + 1.1F, y + rand.nextFloat(), z + rand.nextFloat(), 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x + 1.1F, y + rand.nextFloat(), z + rand.nextFloat(), 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x + 1.1F, y + rand.nextFloat(), z + rand.nextFloat(), 0, 0.1, 0);
                    break;
            }
        }
    }

    @Override
    public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase entity) {
        return super.onBlockPlaced(world, pos, facing, hitX, hitY, hitZ, meta, entity).withProperty(FACING, EnumFacing.fromAngle(entity.rotationYaw));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.values()[meta]);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).ordinal();
    }
}
