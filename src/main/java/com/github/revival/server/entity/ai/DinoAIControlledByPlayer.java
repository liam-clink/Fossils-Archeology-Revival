package com.github.revival.server.entity.ai;

import com.github.revival.server.config.FossilConfig;
import com.github.revival.server.entity.mob.EntityDinosaur;
import com.github.revival.server.item.FAItemRegistry;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class DinoAIControlledByPlayer extends EntityAIBase {
    private final EntityDinosaur motionTarget;
    public int FollowTimeWithoutWhip = 90;
    //private final float maxSpeed;
    private float currentSpeed = 0.0F;
    private int lastTimeSeenWhip = -1;
    /**
     * Whether the entity's speed is boosted.
     */
    private boolean speedBoosted = false;

    /**
     * Counter for speed boosting, upon reaching maxSpeedBoostTime the speed boost will be disabled
     */
    private int speedBoostTime = 0;

    /**
     * Maximum time the entity's speed should be boosted for.
     */
    private int maxSpeedBoostTime = 100;

    public DinoAIControlledByPlayer(EntityDinosaur var1)//, float var2)
    {
        this.motionTarget = var1;
        //this.maxSpeed = var2;
        this.setMutexBits(123);
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        this.currentSpeed = 0.0F;
        this.lastTimeSeenWhip = -1;
    }

    /**
     * Resets the task
     */
    public void resetTask() {
        this.speedBoosted = false;
        this.currentSpeed = 0.0F;
        this.lastTimeSeenWhip = -1;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
        /*System.out.println(String.valueOf(this.speedBoosted));
        if(this.motionTarget.riddenByEntity != null)
        	System.out.println(String.valueOf(this.motionTarget.canBeSteered()));
        System.out.println("LastWhip "+String.valueOf(this.lastTimeSeenWhip));*/
        if (this.motionTarget.isEntityAlive() && this.motionTarget.riddenByEntity != null && this.motionTarget.riddenByEntity instanceof EntityPlayer) {
            if (/*this.lastTimeSeenWhip==FollowTimeWithoutWhip &&*/ this.motionTarget.canBeSteered()) {
                this.lastTimeSeenWhip = 0;
                EntityPlayer P = (EntityPlayer) this.motionTarget.riddenByEntity;
                /* Handle whip damage in whip class so it doesn't constantly drain while riding.
                if (!P.capabilities.isCreativeMode)
                {//decrease the whips uses left
                    ItemStack I = P.getHeldItem();
                    if (I != null && I.itemID == Revival.whip.itemID)
                    	I.setItemDamage(I.getItemDamage()+1);
                }
                */
            }

            if (!this.motionTarget.canBeSteered() && this.lastTimeSeenWhip < FollowTimeWithoutWhip && this.lastTimeSeenWhip != -1) {
                this.lastTimeSeenWhip++;
            }

            return this.speedBoosted || this.motionTarget.canBeSteered() || (this.lastTimeSeenWhip < FollowTimeWithoutWhip && this.lastTimeSeenWhip != -1);
        }

        return false;
    }

    /**
     * Updates the task
     */
    public void updateTask() {
        this.motionTarget.decreaseHungerTick();

        //System.out.println(String.valueOf(this.motionTarget.ticksExisted%100));
        if (this.speedBoosted) {
            if (this.speedBoostTime++ > this.maxSpeedBoostTime) {
                this.speedBoosted = false;
                this.speedBoostTime = 0;
            }
        }

        //currentSpeed=this.motionTarget.HandleRiding(currentSpeed,(float)speedBoostTime/(float)maxSpeedBoostTime);
        EntityPlayer P = (EntityPlayer) this.motionTarget.riddenByEntity;

        if (!P.capabilities.isCreativeMode && this.currentSpeed >= this.motionTarget.getAIMoveSpeed() * 0.5F && this.motionTarget.getRNG().nextFloat() < 0.006F && !this.speedBoosted) {
            //decrease the whips uses left
            ItemStack I = P.getHeldItem();

            if (I != null && I.getItem() == FAItemRegistry.whip) {
                //var21.damageItem(1, P);
                I.setItemDamage(I.getItemDamage() + 1);
                /*if (var21.stackSize == 0)
                {//Auto-Use the next whip if the player has at least one more
                    //var1.inventory.hasItemStack(par1ItemStack)
                    //var1.inventory.setCurrentItem(par1, par2, par3, par4)
                }*/
            }
        }

        if (this.speedBoosted && this.motionTarget.RiderSneak && this.lastTimeSeenWhip == 0 && this.motionTarget.onGround && FossilConfig.dinoBlockBreaking) {
            int BlocksDestroyed = this.motionTarget.BlockInteractive();
            this.currentSpeed -= BlocksDestroyed * 0.02;

            if (this.currentSpeed < -0.15F) {
                this.currentSpeed = -0.15F;
            }

            this.speedBoostTime += BlocksDestroyed;
        }

        //((WorldServer)this.motionTarget.worldObj).getEntityTracker().sendPacketToAllPlayersTrackingEntity(this.motionTarget, new Packet34EntityTeleport(this.motionTarget));
    }

    /**
     * Return whether the entity's speed is boosted.
     */
    public boolean isSpeedBoosted() {
        return this.speedBoosted;
    }

    /**
     * Boost the entity's movement speed.
     */
    public void boostSpeed() {
        this.speedBoosted = true;
        this.speedBoostTime = 0;
        this.maxSpeedBoostTime = this.motionTarget.getRNG().nextInt(381) + 600;
    }

    /**
     * Return whether the entity is being controlled by a player.
     */
    public boolean isControlledByPlayer() {
        return this.motionTarget.isEntityAlive() && this.motionTarget.riddenByEntity != null && this.motionTarget.riddenByEntity instanceof EntityPlayer && (this.speedBoosted || this.motionTarget.canBeSteered() || this.lastTimeSeenWhip < 90); //!this.isSpeedBoosted() && this.currentSpeed > this.motionTarget.getSpeed() * 0.3F;
    }
}
