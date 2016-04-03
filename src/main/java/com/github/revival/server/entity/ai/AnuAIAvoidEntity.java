package com.github.revival.server.entity.ai;

import com.github.revival.server.entity.mob.EntityAnu;
import net.minecraft.entity.ai.EntityAIAvoidEntity;

public class AnuAIAvoidEntity extends EntityAIAvoidEntity {
    private EntityAnu theEntity;

    public AnuAIAvoidEntity(EntityAnu p_i1616_1_, Class p_i1616_2_, float p_i1616_3_, double p_i1616_4_, double p_i1616_6_) {
        super(p_i1616_1_, p_i1616_2_, p_i1616_3_, p_i1616_4_, p_i1616_6_);
        theEntity = p_i1616_1_;
    }

    @Override
    public boolean shouldExecute() {
        if (theEntity.getAttackMode() == 2) {
            return super.shouldExecute();
        }
        return false;
    }


}
