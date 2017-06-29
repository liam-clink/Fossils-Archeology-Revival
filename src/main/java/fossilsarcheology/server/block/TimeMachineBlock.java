package fossilsarcheology.server.block;

import fossilsarcheology.server.api.BlockEntity;
import fossilsarcheology.server.api.DefaultRenderedItem;
import fossilsarcheology.server.tab.FATabRegistry;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class TimeMachineBlock extends BlockContainer implements DefaultRenderedItem, BlockEntity {
    public static final AxisAlignedBB QUARTER_BLOCK_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D);

    public TimeMachineBlock() {
        super(Material.GLASS);
        this.setLightOpacity(0);
        this.setLightLevel(0.9375F);
        this.setHardness(0.3F);
        this.setSoundType(SoundType.GLASS);
        this.setUnlocalizedName("timeMachine");
        this.setCreativeTab(FATabRegistry.BLOCKS);
    }

    @Override
    public Class<? extends TileEntity> getEntity() {
        return TileEntityTimeMachine.class;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityTimeMachine();
    }
}
