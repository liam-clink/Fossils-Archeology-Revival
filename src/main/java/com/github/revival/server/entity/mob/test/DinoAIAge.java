package com.github.revival.server.entity.mob.test;


import com.github.revival.server.config.FossilConfig;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumSituation;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MathHelper;

public class DinoAIAge extends EntityAIBase {
    protected EntityNewPrehistoric AITarget;

    public DinoAIAge(EntityNewPrehistoric var1) {
        this.AITarget = var1;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute() {

        if (/*fossilOptions.DinoGrows && */this.AITarget.getDinoAge() < 999) {
            this.AITarget.increaseDinoAgeTick();
            return this.AITarget.getDinoAgeTick() >= 12000;
        }

        return false;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    @Override
    public boolean continueExecuting() {
        return this.shouldExecute();
    }


    /**
     * Updates the task
     */
    @Override
    public void startExecuting() {
        if (!this.AITarget.worldObj.isRemote) {
            this.AITarget.setPosition(this.AITarget.posX, this.AITarget.posY + 1, this.AITarget.posZ);
            if ((!this.AITarget.isEntityInsideOpaqueBlock()
                    && this.AITarget.selfType != EnumPrehistoric.Mosasaurus
                    && this.AITarget.selfType != EnumPrehistoric.Liopleurodon)
                    || (this.AITarget.isInWater() && this.AITarget.selfType == EnumPrehistoric.Mosasaurus)
                    || (this.AITarget.isInWater() && this.AITarget.selfType == EnumPrehistoric.Liopleurodon)
                    || (this.AITarget.isInWater() && this.AITarget.selfType == EnumPrehistoric.Plesiosaur)) {
                this.AITarget.setDinoAgeTick(0);
                this.AITarget.increaseDinoAge();
                this.AITarget.worldObj.setEntityState(this.AITarget, EntityNewPrehistoric.AGING_MESSAGE);
                this.AITarget.updateSize();

                if (this.AITarget.getMaxHealth() < this.AITarget.getHealth()) {
                    if (FossilConfig.healingDinos) {
                        this.AITarget.heal(MathHelper.ceiling_double_int(this.AITarget.getHealth() * 0.15f));
                    }
                }
            } else {
                this.AITarget.sendStatusMessage(EnumSituation.NoSpace);

            }
        }
    }
}
