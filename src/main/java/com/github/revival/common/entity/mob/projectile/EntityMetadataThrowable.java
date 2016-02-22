package com.github.revival.common.entity.mob.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityMetadataThrowable extends EntityThrowable {

    public EntityMetadataThrowable(World world) {
        super(world);
    }

    public EntityMetadataThrowable(World world, EntityLivingBase entityLivingBase) {
        super(world, entityLivingBase);
    }

    public EntityMetadataThrowable(World world, double x, double y, double z) {
        super(world);
    }

    @Override
    protected void onImpact(MovingObjectPosition p_70184_1_) {
    }

    public String getTexture() {
        return "";
    }
}
