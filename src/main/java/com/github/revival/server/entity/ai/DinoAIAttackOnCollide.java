package com.github.revival.server.entity.ai;

import com.github.revival.server.entity.mob.EntityDinosaur;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class DinoAIAttackOnCollide extends EntityAIBase {
    private final EntityDinosaur attacker;
    World worldObj;
    /**
     * An amount of decrementing ticks that allows the entity to attack once the tick reaches 0.
     */
    int attackTick;
    double field_75440_e;
    boolean field_75437_f;

    /**
     * The PathEntity of our entity.
     */
    PathEntity entityPathEntity;
    Class classTarget;
    private int field_75445_i;

    public DinoAIAttackOnCollide(EntityDinosaur par1EntityDinosaur, Class par2Class, double par3, boolean par5) {
        this(par1EntityDinosaur, par3, par5);
        this.classTarget = par2Class;
    }

    public DinoAIAttackOnCollide(EntityDinosaur par1EntityDinosaur, double par2, boolean par4) {
        this.attacker = par1EntityDinosaur;
        this.worldObj = par1EntityDinosaur.worldObj;
        this.field_75440_e = par2;
        this.field_75437_f = par4;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
        EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();

        if (entitylivingbase == null) {
            return false;
        } else if (!entitylivingbase.isEntityAlive()) {
            return false;
        } else if (this.classTarget != null && !this.classTarget.isAssignableFrom(entitylivingbase.getClass())) {
            return false;
        } else {
            this.entityPathEntity = this.attacker.getNavigator().getPathToEntityLiving(entitylivingbase);
            return this.entityPathEntity != null;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting() {
        EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
        return entitylivingbase == null ? false : (!entitylivingbase.isEntityAlive() ? false : (!this.field_75437_f ? !this.attacker.getNavigator().noPath() : this.attacker.isWithinHomeDistance(MathHelper.floor_double(entitylivingbase.posX), MathHelper.floor_double(entitylivingbase.posY), MathHelper.floor_double(entitylivingbase.posZ))));
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        this.attacker.getNavigator().setPath(this.entityPathEntity, this.field_75440_e);
        this.field_75445_i = 0;
    }

    /**
     * Resets the task
     */
    public void resetTask() {
        this.attacker.getNavigator().clearPathEntity();
    }

    /**
     * Updates the task
     */
    public void updateTask() {
        EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
        this.attacker.getLookHelper().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);

        if ((this.field_75437_f || this.attacker.getEntitySenses().canSee(entitylivingbase)) && --this.field_75445_i <= 0) {
            this.field_75445_i = 4 + this.attacker.getRNG().nextInt(7);
            this.attacker.getNavigator().tryMoveToEntityLiving(entitylivingbase, this.field_75440_e);
        }

        this.attackTick = Math.max(this.attackTick - 1, 0);
        double d0 = (double) (this.attacker.width * 2.0F * this.attacker.width * 2.0F + entitylivingbase.width);

        if (this.attacker.getDistanceSq(entitylivingbase.posX, entitylivingbase.boundingBox.minY, entitylivingbase.posZ) <= d0) {
            if (this.attackTick <= 0) {
                this.attackTick = 20;

                if (this.attacker.getHeldItem() != null) {
                    this.attacker.swingItem();
                }

                this.attacker.attackEntityAsMob(entitylivingbase);
            }
        }
    }
}
