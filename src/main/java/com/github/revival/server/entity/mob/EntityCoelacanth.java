package com.github.revival.server.entity.mob;

import com.github.revival.server.entity.mob.test.EntityFishBase;
import com.github.revival.server.enums.EnumPrehistoric;
import net.minecraft.world.World;

public class EntityCoelacanth extends EntityFishBase {
    public EntityCoelacanth(World par1World) {
        super(par1World, EnumPrehistoric.Coelacanth);
        this.setSize(1.9F, 1F);
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY > 45.0D && this.posY < 63.0D && super.getCanSpawnHere();
    }

    @Override
    public String getTexture() {
        return "fossil:textures/model/fish/coelacanth.png";
    }

    @Override
    protected double getSwimSpeed() {
        return 0.35D;
    }
}
