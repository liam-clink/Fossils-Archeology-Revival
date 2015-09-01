package com.github.revival.common.entity.mobs;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityAllosaurus extends EntityPrehistoric
{

    public EntityAllosaurus(World world)
    {
        super(world, EnumEntityPrehistoric.Allosaurus, 0, null);
    }

    @Override
    void addAI()
    {

    }

    @Override
    public EntityAgeable createChild(EntityAgeable p_90011_1_)
    {
        return new EntityAllosaurus(worldObj);
    }

    @Override
    boolean tryTame(EntityPlayer player)
    {
        // TODO Auto-generated method stub
        return false;
    }

}
