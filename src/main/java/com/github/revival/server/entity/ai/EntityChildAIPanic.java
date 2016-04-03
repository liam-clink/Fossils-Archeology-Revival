package com.github.revival.server.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIPanic;

public class EntityChildAIPanic extends EntityAIPanic {

    private EntityCreature theEntityCreature;
    private double speed;

    public EntityChildAIPanic(EntityCreature entity, double speed) {
        super(entity, speed);
        this.theEntityCreature = entity;
        this.speed = speed;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        if (!this.theEntityCreature.isChild()) {
            return false;
        }

        return super.shouldExecute();
    }
}
