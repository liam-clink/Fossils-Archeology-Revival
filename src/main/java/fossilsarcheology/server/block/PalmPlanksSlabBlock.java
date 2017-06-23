package fossilsarcheology.server.block;

import net.minecraft.block.SoundType;

public class PalmPlanksSlabBlock extends FossilSlabBlock {
    public PalmPlanksSlabBlock(String name, float hardness, float resistance, SoundType soundType) {
        super(name, hardness, resistance, soundType, FABlockRegistry.PALM_PLANKS_SINGLESLAB);
    }

    public static class Double extends FossilSlabBlock {
        public Double(String name, float hardness, float resistance, SoundType soundType) {
            super(name, hardness, resistance, soundType, FABlockRegistry.PALM_PLANKS_SINGLESLAB);
        }

        public boolean isDouble()
        {
            return true;
        }
    }

    public static class Half extends FossilSlabBlock {
        public Half(String name, float hardness, float resistance, SoundType soundType) {
            super(name, hardness, resistance, soundType, FABlockRegistry.PALM_PLANKS_SINGLESLAB);
        }

        public boolean isDouble()
        {
            return false;
        }
    }
}
