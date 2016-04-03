package com.github.revival.server.entity.mob;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityDodoEgg extends EntityThrowable {

    public EntityDodoEgg(World par1World) {
        super(par1World);

    }

    public EntityDodoEgg(World par1World, EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }

    public EntityDodoEgg(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    public String getTexture() {

        return "/mods/fossil/textures/items/Egg_Dodo.png";
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    @Override
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.entityHit != null) {
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0);
        }
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

        if (!this.worldObj.isRemote) {
            this.setDead();
        }

    }

    private void spawnAnimal() {
        EntityDodo entitydodo = new EntityDodo(this.worldObj);
        entitydodo.setGrowingAge(-24000);
        entitydodo.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
        this.worldObj.spawnEntityInWorld(entitydodo);
    }
}
