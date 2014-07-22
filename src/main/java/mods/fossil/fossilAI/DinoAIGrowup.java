package mods.fossil.fossilAI;

import mods.fossil.Fossil;
import mods.fossil.entity.mob.EntityDinosaur;
import mods.fossil.fossilEnums.EnumDinoType;
import mods.fossil.fossilEnums.EnumSituation;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MathHelper;

public class DinoAIGrowup extends EntityAIBase
{
    protected EntityDinosaur AITarget;

    public DinoAIGrowup(EntityDinosaur var1)
    {
        this.AITarget = var1;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {

	        if (/*FossilOptions.DinoGrows && */this.AITarget.getDinoAge() < this.AITarget.SelfType.MaxAge)
	        {
	            this.AITarget.increaseDinoAgeTick();
	            return this.AITarget.getDinoAgeTick() >= this.AITarget.SelfType.AgingTicks;
	        }

        return false;
    }
    
    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return this.shouldExecute();
    }
    

    /**
     * Updates the task
     */
    public void startExecuting()
    {
        if (!this.AITarget.worldObj.isRemote)
        {
            this.AITarget.setPosition(this.AITarget.posX, this.AITarget.posY+1, this.AITarget.posZ);
            if (((this.AITarget.CheckSpace() && this.AITarget.SelfType != EnumDinoType.Mosasaurus)) || ((this.AITarget.isInWater() && this.AITarget.SelfType == EnumDinoType.Mosasaurus)))
            {
                this.AITarget.setDinoAgeTick(0);
                this.AITarget.increaseDinoAge();
                this.AITarget.worldObj.setEntityState(this.AITarget, this.AITarget.AGING_MESSAGE);
                //this.AITarget.CheckSkin();
                this.AITarget.updateSize();

                if (this.AITarget.getMaxHealth() < this.AITarget.getHealth())
                {
                    //the dino heals itself 15% when growing up
                    if (Fossil.FossilOptions.Heal_Dinos)
                    {
                        this.AITarget.heal(MathHelper.ceiling_double_int(this.AITarget.getHealth() * 0.15f));
                    }
                }

                /*this.AITarget.setDinoAge(this.AITarget.getDinoAge()-1);
                this.AITarget.worldObj.setEntityState(this.AITarget, this.AITarget.AGING_MESSAGE);
                //this.AITarget.CheckSkin();

                if (this.AITarget.getHealth() > MathHelper.ceiling_double_int(this.AITarget.getMaxHealth()*0.05f))
                {
                	if(Fossil.FossilOptions.Heal_Dinos)
                		this.AITarget.attackEntityFrom(DamageSource.generic, MathHelper.ceiling_double_int(this.AITarget.getMaxHealth()*0.05f));
                }

                this.AITarget.updateSize();
                //this.AITarget.setPosition(this.AITarget.posX, this.AITarget.posY, this.AITarget.posZ);

                if (this.AITarget.isTamed())
                {
                    this.AITarget.SendStatusMessage(EnumSituation.NoSpace);//, this.AITarget.SelfType);
                }*/
            }
            else
            {
                this.AITarget.SendStatusMessage(EnumSituation.NoSpace);    //, this.AITarget.SelfType);

            }
        }
    }
}
