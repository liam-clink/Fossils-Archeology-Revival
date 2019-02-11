package fossilsarcheology.server.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public abstract class PalmPlanksSlabBlock extends FossilSlabBlock {
	public PalmPlanksSlabBlock(String name, float hardness, float resistance, SoundType soundType) {
		super(name, hardness, resistance, soundType, Material.WOOD, FABlockRegistry.PALM_PLANKS);
	}

	@Override
	public ItemBlock getItemBlock() {
		return new FossilSlabBlockItem(this, FABlockRegistry.PALM_PLANKS_SINGLESLAB, FABlockRegistry.PALM_PLANKS_DOUBLESLAB);
	}

	public static class Double extends FossilSlabBlock {
		public Double(String name, float hardness, float resistance, SoundType soundType) {
			super(name, hardness, resistance, soundType, Material.WOOD, FABlockRegistry.PALM_PLANKS);
		}

		@Override
        public boolean isDouble() {
			return true;
		}

		@Override
		public ItemBlock getItemBlock() {
			return new FossilSlabBlockItem(this, FABlockRegistry.PALM_PLANKS_SINGLESLAB, FABlockRegistry.PALM_PLANKS_DOUBLESLAB);
		}

		@Override
		public Item getSlabItem() {
			return Item.getItemFromBlock(FABlockRegistry.PALM_PLANKS_SINGLESLAB);
		}
	}

	@Override
	public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return true;
	}

	public static class Half extends FossilSlabBlock {
		public Half(String name, float hardness, float resistance, SoundType soundType) {
			super(name, hardness, resistance, soundType, Material.WOOD, FABlockRegistry.PALM_PLANKS);
		}

		@Override
        public boolean isDouble() {
			return false;
		}

		@Override
		public ItemBlock getItemBlock() {
			return new FossilSlabBlockItem(this, FABlockRegistry.PALM_PLANKS_SINGLESLAB, FABlockRegistry.PALM_PLANKS_DOUBLESLAB);
		}

		@Override
		public Item getSlabItem() {
			return Item.getItemFromBlock(FABlockRegistry.PALM_PLANKS_SINGLESLAB);
		}
	}
}
