package com.github.revival.server.entity.mob.test;

import net.minecraft.entity.EntityLiving;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class PathNavigateClimber extends PathNavigate {
    private EntityLiving entity;

    public PathNavigateClimber(EntityLiving entity, World world) {
        super(entity, world);
        this.entity = entity;
    }

    @Override
    public boolean isPositionClear(int p_75496_1_, int p_75496_2_, int p_75496_3_, int p_75496_4_, int p_75496_5_, int p_75496_6_, Vec3 p_75496_7_, double p_75496_8_, double p_75496_10_) {
        return false;
    }

}
