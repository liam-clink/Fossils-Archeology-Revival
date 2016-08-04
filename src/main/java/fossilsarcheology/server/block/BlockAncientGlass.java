package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockAncientGlass extends Block {
    public BlockAncientGlass(Material material) {
        super(material);
        this.setLightOpacity(1);
        this.setUnlocalizedName(LocalizationStrings.ANCIENT_GLASS_NAME);
        this.setSoundType(SoundType.GLASS);
        this.setHardness(1F);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess world, BlockPos pos, int side) {
        return world.getBlock(pos) != this && super.shouldSideBeRendered(world, pos, side);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderBlockPass() {
        return 0;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
}
