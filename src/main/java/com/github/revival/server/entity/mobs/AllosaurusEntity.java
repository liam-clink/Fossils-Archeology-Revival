package com.github.revival.server.entity.mobs;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class AllosaurusEntity extends PrehistoricEntity {

    public AllosaurusEntity(World world) {
        super(world, EnumEntityPrehistoric.Allosaurus, 0, null);
    }

    @Override
    void addAI() {

    }

    @Override
    public EntityAgeable createChild(EntityAgeable p_90011_1_) {
        return new AllosaurusEntity(worldObj);
    }

    @Override
    boolean tryTame(EntityPlayer player) {
        // TODO Auto-generated method stub
        return false;
    }

}
