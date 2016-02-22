package com.github.revival.common.entity.ai;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DinoAIAttackBabies extends EntityAITarget {
    private static final String __OBFID = "CL_00001620";
    private final Class targetClass;
    private final int targetChance;
    /**
     * Instance of EntityAINearestAttackableTargetSorter.
     */
    private final DinoAIAttackBabies.Sorter theNearestAttackableTargetSorter;
    /**
     * This filter is applied to the Entity search.  Only matching entities will be targetted.  (null -> no
     * restrictions)
     */
    private final IEntitySelector targetEntitySelector;
    private EntityLivingBase targetEntity;

    public DinoAIAttackBabies(EntityCreature entity, Class target, int chance, boolean idk) {
        this(entity, target, chance, idk, false);
    }

    public DinoAIAttackBabies(EntityCreature entity, Class target, int chance, boolean var1, boolean var2) {
        this(entity, target, chance, var1, var2, (IEntitySelector) null);
    }

    public DinoAIAttackBabies(EntityCreature entity, Class target, int chance, boolean var1, boolean var2, final IEntitySelector selector) {
        super(entity, var1, var2);
        this.targetClass = target;
        this.targetChance = chance;
        this.theNearestAttackableTargetSorter = new DinoAIAttackBabies.Sorter(entity);
        this.setMutexBits(1);
        this.targetEntitySelector = new IEntitySelector() {
            private static final String __OBFID = "CL_00001621";

            /**
             * Return whether the specified entity is applicable to this filter.
             */
            public boolean isEntityApplicable(Entity p_82704_1_) {
                return !(p_82704_1_ instanceof EntityLivingBase) ? false : (selector != null && !selector.isEntityApplicable(p_82704_1_) ? false : DinoAIAttackBabies.this.isSuitableTarget((EntityLivingBase) p_82704_1_, false));
            }
        };
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
        if (targetEntity != null) {
            if (targetEntity.isChild()) {
                if (this.targetChance > 0 && this.taskOwner.getRNG().nextInt(this.targetChance) != 0) {
                    return false;
                } else {
                    double d0 = this.getTargetDistance();
                    List list = this.taskOwner.worldObj.selectEntitiesWithinAABB(this.targetClass, this.taskOwner.boundingBox.expand(d0, 4.0D, d0), this.targetEntitySelector);
                    Collections.sort(list, this.theNearestAttackableTargetSorter);

                    if (list.isEmpty()) {
                        return false;
                    } else {
                        this.targetEntity = (EntityLivingBase) list.get(0);
                        return true;
                    }
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        this.taskOwner.setAttackTarget(this.targetEntity);
        super.startExecuting();
    }

    public static class Sorter implements Comparator {
        private static final String __OBFID = "CL_00001622";
        private final Entity theEntity;

        public Sorter(Entity p_i1662_1_) {
            this.theEntity = p_i1662_1_;
        }

        public int compare(Entity p_compare_1_, Entity p_compare_2_) {
            double d0 = this.theEntity.getDistanceSqToEntity(p_compare_1_);
            double d1 = this.theEntity.getDistanceSqToEntity(p_compare_2_);
            return d0 < d1 ? -1 : (d0 > d1 ? 1 : 0);
        }

        public int compare(Object p_compare_1_, Object p_compare_2_) {
            return this.compare((Entity) p_compare_1_, (Entity) p_compare_2_);
        }
    }
}