package com.github.revival.common.entity.mob.test;

import java.util.Collections;
import java.util.List;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

import com.github.revival.common.api.EnumDiet;
import com.github.revival.common.entity.mob.EntityDinosaur;

public class DinoAIAgressive extends EntityAINearestAttackableTarget
{
	private EntityNewPrehistoric mob;
	private final Class<? extends Entity> targetClass;
	private boolean isCannibal;

	public DinoAIAgressive(EntityNewPrehistoric mob, Class<? extends Entity> prey, int hungryTicks, boolean see, boolean isCannibal)
	{
		super(mob, prey, hungryTicks, see);
		this.mob = mob;
		this.targetClass = prey;
		this.isCannibal = isCannibal;
	}


	public boolean shouldExecute()
	{
		Entity targetEntity;
		EntityAINearestAttackableTarget.Sorter theNearestAttackableTargetSorter = new EntityAINearestAttackableTarget.Sorter(mob);
		IEntitySelector targetEntitySelector = new IEntitySelector()
	        {
	            public boolean isEntityApplicable(Entity entity)
	            {
	                return (entity instanceof EntityLivingBase);
	            }
	        };
		double d0 = this.getTargetDistance();
		List list = this.taskOwner.worldObj.selectEntitiesWithinAABB(this.targetClass, this.taskOwner.boundingBox.expand(d0, 4.0D, d0), targetEntitySelector);
		Collections.sort(list, theNearestAttackableTargetSorter);

		if (list.isEmpty())
		{
			return false;
		}
		else
		{
			targetEntity = (EntityLivingBase)list.get(0);

			if(!this.mob.isHungry()){
				return false;
			}

			if(this.mob.selfType.diet != EnumDiet.CARNIVORE ||this.mob.selfType.diet != EnumDiet.CARNIVORE_EGG || this.mob.selfType.diet != EnumDiet.PISCCARNIVORE || this.mob.selfType.diet != EnumDiet.OMNIVORE){
				return false;
			}

			if(targetEntity != null){
				if(targetEntity.width * 1.5F < mob.width || this.mob.preyBlacklist().contains(targetEntity)){
					return false;
				}
			}

			if(this.mob.preyBlacklist().contains(targetClass)){
				return false;
			}

			if(!this.isCannibal){
				if(this.mob.getClass() == this.targetClass){
					return false;
				}
			}

			if(this.mob.isTamed()){
				if(this.mob.getOwner() != null){
					if(this.mob.getOwner().getClass() == this.targetClass){
						if(!this.mob.isHungry()){
							return false;
						}
					}
				}
			}
			return true;
		}
	}


}