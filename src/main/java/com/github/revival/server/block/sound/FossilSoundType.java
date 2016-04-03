package com.github.revival.server.block.sound;

import net.minecraft.block.Block.SoundType;

public class FossilSoundType extends SoundType {
    public FossilSoundType(float vol, float frec) {
        super("", frec, frec);
    }

    /**
     * Used when a block breaks, e.g.: Player break, Sheep eating grass, etc..
     */
    @Override
    public String getBreakSound() {
        return "mob.slime.big";
    }

    @Override
    public String getStepResourcePath() {
        return "mob.slime.small";
    }

}
