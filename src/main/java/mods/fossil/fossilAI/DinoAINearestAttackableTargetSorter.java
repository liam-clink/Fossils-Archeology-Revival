package mods.fossil.fossilAI;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;

import java.util.Comparator;

public class DinoAINearestAttackableTargetSorter implements Comparator
{
    private Entity entit;
    final EntityAIBase ai;

    public DinoAINearestAttackableTargetSorter(EntityAIBase var1, Entity var2)
    {
        this.ai = var1;
        this.entit = var2;
    }

    public int func_48469_a(Entity var1, Entity var2)
    {
        double var3 = this.entit.getDistanceSqToEntity(var1);
        double var5 = this.entit.getDistanceSqToEntity(var2);
        return var3 < var5 ? -1 : (var3 > var5 ? 1 : 0);
    }

    public int compare(Object var1, Object var2)
    {
        return this.func_48469_a((Entity)var1, (Entity)var2);
    }
}
