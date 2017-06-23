package fossilsarcheology.server.block;

import fossilsarcheology.server.tab.FATabRegistry;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AncientGlassBlock extends BlockBreakable {

    public AncientGlassBlock() {
        super(Material.GLASS, true);
        this.setLightOpacity(1);
        this.setUnlocalizedName("ancientGlass");
        this.setSoundType(SoundType.GLASS);
        this.setHardness(1F);
        this.setCreativeTab(FATabRegistry.BLOCKS);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }
}
