package com.github.revival.server.entity.mob.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.server.enums.EnumPrehistoric;

public class EntityBirdEgg extends EntityThrowable {
    public Item item;
    EnumPrehistoric type;
    boolean cultivated;

    public EntityBirdEgg(EnumPrehistoric type, boolean cultivated, World par1World, Item item) {
        super(par1World);
        this.type = type;
        this.cultivated = cultivated;
        this.item = item;
    }

    public EntityBirdEgg(World par1World, EntityLivingBase par2EntityLivingBase, EnumPrehistoric type, boolean cultivated, Item item) {
        super(par1World, par2EntityLivingBase);
        this.type = type;
        this.cultivated = cultivated;
        this.item = item;

    }


    public String getTexture() {

        return cultivated ? "fossil/items/prehistoric/birdEggs/Egg_" + type.toString() + ".png" : "fossil/items/prehistoric/birdEggs/Egg_Cultivated" + type.toString() + ".png";
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    @Override
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.entityHit != null) {
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0);
        }
        if (this.cultivated) {
            this.spawnAnimal();

        } else {
            if (!this.worldObj.isRemote && this.rand.nextInt(8) == 0) {
                byte b0 = 1;

                if (this.rand.nextInt(32) == 0) {
                    b0 = 4;
                }

                for (int i = 0; i < b0; ++i) {
                    this.spawnAnimal();

                }
                for (int j = 0; j < 8; ++j) {
                    this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
                }
            }
        }

        if (!this.worldObj.isRemote) {
            this.setDead();
        }

    }

    private void spawnAnimal() {
        EntityNewPrehistoric mob = (EntityNewPrehistoric)type.invokeClass(worldObj);
        if (!worldObj.isRemote && mob != null) {
            mob.setDinoAge(1);
            mob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
            this.worldObj.spawnEntityInWorld(mob);
        }
    }
}
