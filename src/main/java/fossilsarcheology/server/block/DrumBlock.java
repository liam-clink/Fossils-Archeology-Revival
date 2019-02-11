package fossilsarcheology.server.block;

import fossilsarcheology.client.sound.FASoundRegistry;
import fossilsarcheology.server.api.DefaultRenderedItem;
import fossilsarcheology.server.tab.FATabRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DrumBlock extends Block implements DefaultRenderedItem {
    private static final int DRUM_COUNT = 2;

    public static final PropertyInteger DRUMS = PropertyInteger.create("drums", 0, DRUM_COUNT);

    public DrumBlock() {
        super(Material.WOOD);
        this.setDefaultState(this.blockState.getBaseState().withProperty(DRUMS, 0));
        this.setTickRandomly(true);
        this.setTranslationKey("drum");
        this.setSoundType(SoundType.WOOD);
        this.setCreativeTab(FATabRegistry.BLOCKS);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        int count = state.getValue(DRUMS);
        if (count < DRUM_COUNT) {
            world.setBlockState(pos, state.withProperty(DRUMS, count + 1), 3);
        } else {
            world.setBlockState(pos, state.withProperty(DRUMS, 0), 3);
        }
        world.playSound(player, pos, FASoundRegistry.DRUM_SINGLE, SoundCategory.BLOCKS, 1, 1);
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(DRUMS, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(DRUMS);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, DRUMS);
    }
}
