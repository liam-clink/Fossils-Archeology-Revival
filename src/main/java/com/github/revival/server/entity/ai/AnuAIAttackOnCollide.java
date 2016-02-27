package com.github.revival.server.entity.ai;

import com.github.revival.server.entity.mob.AnuEntity;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;

public class AnuAIAttackOnCollide extends EntityAIAttackOnCollide {
    private AnuEntity theEntity;

    public AnuAIAttackOnCollide(AnuEntity p_i1616_1_, Class p_i1616_2_, double p_i1616_4_, boolean p_i1616_6_) {
        super(p_i1616_1_, p_i1616_2_, p_i1616_4_, p_i1616_6_);
        theEntity = p_i1616_1_;
    }

    public boolean shouldExecute() {
        if (theEntity.getAttackMode() == 0) {
            return super.shouldExecute();
        }
        return false;
    }

}
