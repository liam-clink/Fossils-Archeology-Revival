package com.github.revival.common.entity.mob.test;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

public class DinoAIAgressive extends EntityAINearestAttackableTarget
{
	private EntityNewPrehistoric theTameable;
	private final Class<? extends Entity> targetClass;
	private boolean isCannabil;

	public DinoAIAgressive(EntityNewPrehistoric mob, Class<? extends Entity> prey, int hungryTicks, boolean see, boolean isCannabil)
	{
		super(mob, prey, hungryTicks, see);
		this.theTameable = mob;
		this.targetClass = prey;
		this.isCannabil = isCannabil;
	}


	public boolean shouldExecute()
	{
		Entity closestLivingEntity = this.theTameable.worldObj.getClosestPlayerToEntity(this.theTameable, (double)20);

		if(!this.theTameable.isHungry()){
			return false;
		}
		if(closestLivingEntity != null){
			if(targetClass == closestLivingEntity.getClass()){
				if(closestLivingEntity.width * 1.5F < theTameable.width || this.theTameable.preyBlacklist().contains(closestLivingEntity)){
	    			return false;
	    		}
			}
		}
		if(this.theTameable.preyBlacklist().contains(targetClass)){
			return false;
		}
		if(!this.isCannabil){
			if(this.theTameable.getClass() == this.targetClass){
				return false;
			}
		}
		if(this.theTameable.isTamed()){
			if(this.theTameable.getOwner() != null){
				if(this.theTameable.getOwner().getClass() == this.targetClass){
					if(!this.theTameable.isHungry()){
						return false;
					}
				}
			}
		}
		return super.shouldExecute();
	}
}