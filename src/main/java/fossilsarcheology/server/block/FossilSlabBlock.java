package fossilsarcheology.server.block;

import fossilsarcheology.server.api.DefaultRenderedItem;
import fossilsarcheology.server.tab.FATabRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class FossilSlabBlock extends BlockSlab implements DefaultRenderedItem {

    public static final PropertyEnum<FossilSlabBlock.Variant> VARIANT = PropertyEnum.<FossilSlabBlock.Variant>create("variant", FossilSlabBlock.Variant.class);
    private Block baseBlock;
    public FossilSlabBlock(String name, float hardness, float resistance, SoundType soundType, Block baseBlock) {
        super(Material.ROCK);
        IBlockState iblockstate = this.blockState.getBaseState();
        this.baseBlock = baseBlock;
        this.setLightOpacity(0);
        this.useNeighborBrightness = true;
        setHardness(hardness);
        setResistance(resistance);
        setSoundType(soundType);
        if (this.isDouble()) {
            setUnlocalizedName(name + "Double");
        } else {
            iblockstate = iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
            setUnlocalizedName(name);
            setCreativeTab(FATabRegistry.BLOCKS);
        }
        this.setDefaultState(iblockstate.withProperty(VARIANT, FossilSlabBlock.Variant.DEFAULT));
    }

    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(baseBlock);
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(baseBlock);
    }

    public IBlockState getStateFromMeta(int meta) {
        IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, FossilSlabBlock.Variant.DEFAULT);

        if (!this.isDouble()) {
            iblockstate = iblockstate.withProperty(HALF, (meta & 8) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
        }

        return iblockstate;
    }

    public int getMetaFromState(IBlockState state) {
        int i = 0;

        if (!this.isDouble() && state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP) {
            i |= 8;
        }

        return i;

    }

    protected BlockStateContainer createBlockState() {
        return this.isDouble() ? new BlockStateContainer(this, new IProperty[] {VARIANT}): new BlockStateContainer(this, new IProperty[] {HALF, VARIANT});
    }

    @Override
    public String getUnlocalizedName(int meta) {
        return super.getUnlocalizedName();
    }

    @Override
    public boolean isDouble() {
        return false;
    }

    public static class Double extends FossilSlabBlock {
        public Double(String name, float hardness, float resistance, SoundType soundType, Block baseBlock) {
            super(name, hardness, resistance, soundType, baseBlock);
        }

        public boolean isDouble()
        {
            return true;
        }
    }

    public static class Half extends FossilSlabBlock {
        public Half(String name, float hardness, float resistance, SoundType soundType, Block baseBlock) {
            super(name, hardness, resistance, soundType, baseBlock);
        }

        public boolean isDouble()
        {
            return false;
        }
    }

    @Override
    public IProperty<?> getVariantProperty() {
        return VARIANT;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack) {
        return Variant.DEFAULT;
    }

    public static enum Variant implements IStringSerializable {
        DEFAULT;

        public String getName()
        {
            return "default";
        }
    }
}
