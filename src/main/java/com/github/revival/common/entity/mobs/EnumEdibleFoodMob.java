package com.github.revival.common.entity.mobs;

import net.minecraft.entity.EntityLiving;

public class EnumEdibleFoodMob
{

    ;

    private Class entityClass;

    private EnumEdibleFoodMob(Class entityClass)
    {
        this.entityClass = entityClass;
    }

    public boolean isEntity(EntityLiving entity)
    {
        return entityClass.equals(entity.getClass());
    }

}
