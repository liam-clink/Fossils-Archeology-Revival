package mods.fossil.fossilAI;

import mods.fossil.entity.mob.EntityAnu;
import mods.fossil.entity.mob.EntityDinosaur;
import mods.fossil.fossilEnums.EnumOrderType;
import mods.fossil.fossilInterface.IWaterDino;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;

public class AnuAIFly extends EntityAIBase
{
    protected EntityAnu entity;

    public AnuAIFly(EntityAnu var1)
    {
        this.entity = var1;

    }


    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        return entity.getAttackMode() == 1;
    }


    /**
     * Updates the task
     */
    public void updateTask()
    {
    }
}
