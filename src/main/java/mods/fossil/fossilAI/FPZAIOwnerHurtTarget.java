package mods.fossil.fossilAI;

import mods.fossil.entity.mob.EntityFriendlyPigZombie;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;

public class FPZAIOwnerHurtTarget extends EntityAITarget
{
    EntityFriendlyPigZombie fpz;
    EntityLivingBase theTarget;
    private int field_142050_e;

    public FPZAIOwnerHurtTarget(EntityFriendlyPigZombie var1)
    {
        super(var1, false);
        this.fpz = var1;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (!this.fpz.isTamed())
        {
            return false;
        }
        else
        {
            EntityLivingBase var1 = this.fpz.getOwner();

            if (var1 == null)
            {
                return false;
            }
            else
            {
                this.theTarget = var1.getLastAttacker();
                int i = var1.getLastAttackerTime();
                return i != this.field_142050_e && this.isSuitableTarget(this.theTarget, false) && this.fpz.func_142018_a(this.theTarget, var1);
            }
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.taskOwner.setAttackTarget(this.theTarget);
        super.startExecuting();
    }
}
