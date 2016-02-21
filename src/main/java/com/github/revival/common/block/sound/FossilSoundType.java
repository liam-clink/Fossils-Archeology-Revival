package com.github.revival.common.block.sound;

import net.minecraft.block.Block.SoundType;

public class FossilSoundType extends SoundType {

    public FossilSoundType(float vol, float frec) {
        super("", frec, frec);

    }

    /**
     * Used when a block breaks, e.g.: Player break, Sheep eating grass, etc..
     */
    public String getBreakSound() {
        return "mob.slime.big";
    }

    public String getStepResourcePath() {
        return "mob.slime.small";
    }

}
