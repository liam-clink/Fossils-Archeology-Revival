package com.github.revival.server.entity.mob.test;

import com.github.revival.server.entity.EnumDiet;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

import java.util.Collections;
import java.util.List;

public class DinoAIAgressive extends EntityAINearestAttackableTarget {
    private final Class<? extends Entity> targetClass;
    private EntityNewPrehistoric mob;
    private boolean isCannibal;

    public DinoAIAgressive(EntityNewPrehistoric mob, Class<? extends Entity> prey, int hungryTicks, boolean see, boolean isCannibal) {
        super(mob, prey, hungryTicks, see);
        this.mob = mob;
        this.targetClass = prey;
        this.isCannibal = isCannibal;
    }


    public boolean shouldExecute() {
        Entity targetEntity;
        EntityAINearestAttackableTarget.Sorter theNearestAttackableTargetSorter = new EntityAINearestAttackableTarget.Sorter(mob);
        IEntitySelector targetEntitySelector = new IEntitySelector() {
            public boolean isEntityApplicable(Entity entity) {
                return (entity instanceof EntityLivingBase);
            }
        };
        double d0 = this.getTargetDistance();
        List list = this.taskOwner.worldObj.selectEntitiesWithinAABB(this.targetClass, this.taskOwner.boundingBox.expand(d0, 4.0D, d0), targetEntitySelector);
        Collections.sort(list, theNearestAttackableTargetSorter);


        if (list.isEmpty()) {
            return false;
        } else {
            targetEntity = (EntityLivingBase) list.get(0);

            if (!this.mob.isHungry()) {
                return false;
            }
            if (mob.canAttackClass(targetEntity.getClass())) {
                return false;
            }
            if (mob.isMovementBlocked()) {
                return false;
            }

            if (this.mob.selfType.diet == EnumDiet.HERBIVORE) {
                return false;
            }

            if (targetEntity != null) {
                if (mob.width < targetEntity.width) {
                    return false;
                }
            }

            if (this.mob.isTamed()) {
                if (this.mob.getOwner() != null) {
                    if (this.mob.getOwner().getClass() == targetEntity.getClass()) {
                        if (!this.mob.isHungry()) {
                            return false;
                        }
                    }
                }
            }
            return super.shouldExecute();
        }
    }


}