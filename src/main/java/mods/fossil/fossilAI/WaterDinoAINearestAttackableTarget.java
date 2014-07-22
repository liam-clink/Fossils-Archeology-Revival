package mods.fossil.fossilAI;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

public class WaterDinoAINearestAttackableTarget extends EntityAINearestAttackableTarget
{
    public WaterDinoAINearestAttackableTarget(EntityCreature var1, Class par2Class, int par3, boolean par4, boolean par5)
    {
        super(var1, par2Class, par3, par4, par5);
    }

    /**
     * A method used to see if an entity is a suitable target through a number of checks.
     */
    protected boolean isSuitableTarget(EntityLiving var1, boolean var2)
    {
        return var1 != null && !var1.isInWater() ? false : super.isSuitableTarget(var1, var2);
    }
}
