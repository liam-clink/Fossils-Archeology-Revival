package com.github.revival.server.entity.ai;

import com.github.revival.server.entity.mob.AnuEntity;
import net.minecraft.entity.ai.EntityAIArrowAttack;

public class AnuAIArrowAttack extends EntityAIArrowAttack {
    private AnuEntity theEntity;

    public AnuAIArrowAttack(AnuEntity p_i1650_1_, double p_i1650_2_, int p_i1650_4_, int p_i1650_5_, float p_i1650_6_) {
        super(p_i1650_1_, p_i1650_2_, p_i1650_4_, p_i1650_5_, p_i1650_6_);
        theEntity = p_i1650_1_;
    }

    public boolean shouldExecute() {
        if (theEntity.getAttackMode() == 1) {
            return super.shouldExecute();
        }
        return false;
    }
}
