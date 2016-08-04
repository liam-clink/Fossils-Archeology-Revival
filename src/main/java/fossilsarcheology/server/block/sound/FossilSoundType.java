package fossilsarcheology.server.block.sound;

import net.minecraft.block.SoundType;

public class FossilSoundType extends SoundType {
    public FossilSoundType(float vol, float frec) {
        super("", frec, frec);
    }

    @Override
    public String getBreakSound() {
        return "mob.slime.big";
    }

    @Override
    public String getStepResourcePath() {
        return "mob.slime.small";
    }
}
