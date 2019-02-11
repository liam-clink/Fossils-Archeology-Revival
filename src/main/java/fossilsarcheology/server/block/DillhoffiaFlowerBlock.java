package fossilsarcheology.server.block;

import fossilsarcheology.server.api.DefaultRenderedItem;
import fossilsarcheology.server.tab.FATabRegistry;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class DillhoffiaFlowerBlock extends BlockBush implements DefaultRenderedItem {

	public DillhoffiaFlowerBlock() {
		setCreativeTab(FATabRegistry.BLOCKS);
		setTranslationKey("dillhoffia_flower");
		setSoundType(SoundType.PLANT);
	}

	@Override
	public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return true;
	}

}
