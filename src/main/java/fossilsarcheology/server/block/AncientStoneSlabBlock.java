package fossilsarcheology.server.block;

import net.minecraft.block.SoundType;

public class AncientStoneSlabBlock extends FossilSlabBlock {
    public AncientStoneSlabBlock(String name, float hardness, float resistance, SoundType soundType) {
        super(name, hardness, resistance, soundType, FABlockRegistry.ANCIENT_STONE_SINGLESLAB);
    }

    public static class Double extends FossilSlabBlock {
        public Double(String name, float hardness, float resistance, SoundType soundType) {
            super(name, hardness, resistance, soundType, FABlockRegistry.ANCIENT_STONE_SINGLESLAB);
        }

        public boolean isDouble()
        {
            return true;
        }
    }

    public static class Half extends FossilSlabBlock {
        public Half(String name, float hardness, float resistance, SoundType soundType) {
            super(name, hardness, resistance, soundType, FABlockRegistry.ANCIENT_STONE_SINGLESLAB);
        }

        public boolean isDouble()
        {
            return false;
        }
    }
}
