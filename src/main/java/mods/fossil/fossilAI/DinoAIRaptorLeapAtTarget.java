package mods.fossil.fossilAI;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MathHelper;

public class DinoAIRaptorLeapAtTarget extends EntityAIBase
{
    /** The entity that is leaping. */
    EntityLiving leaper;
    /** The entity that the leaper is leaping towards. */
    EntityLivingBase leapTarget;
    /** The entity's motionY after leaping. */
    float leapMotionY;
    float leapMotionX;
    float leapMotionZ;

    public DinoAIRaptorLeapAtTarget(EntityLiving thisEntity, float motionY, float motionX, float motionZ)
    {
        this.leaper = thisEntity;
        this.leapMotionY = motionY;
        this.leapMotionX = motionX;
        this.leapMotionZ = motionZ;
        this.setMutexBits(5);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        this.leapTarget = this.leaper.getAttackTarget();

        if (this.leapTarget == null)
        {
            return false;
        }
        else
        {
            double d0 = this.leaper.getDistanceSqToEntity(this.leapTarget);
            return d0 >= 8.0D && d0 <= 16.0D ? (!this.leaper.onGround ? false : this.leaper.getRNG().nextInt(5) == 0) : false;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return !this.leaper.onGround;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        double d0 = this.leapTarget.posX - this.leaper.posX;
        double d1 = this.leapTarget.posZ - this.leaper.posZ;
        float f = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
        this.leaper.motionX += d0 * (double)this.leapMotionX;
        this.leaper.motionZ += d1 * (double)this.leapMotionZ;
        this.leaper.motionY = (double)this.leapMotionY;
    }
}