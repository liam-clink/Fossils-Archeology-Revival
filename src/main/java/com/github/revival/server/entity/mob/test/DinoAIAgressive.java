package com.github.revival.server.entity.mob.test;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DinoAIAgressive extends EntityAITarget {
	private final Class targetClass;
	private final int targetChance;
	private final DinoAIAgressive.Sorter theNearestAttackableTargetSorter;
	private final IEntitySelector targetEntitySelector;
	private EntityLivingBase targetEntity;

	public DinoAIAgressive(EntityNewPrehistoric mob, Class targetClass, int selectorTime, boolean sight) {
		this(mob, targetClass, selectorTime, sight, false);
		this.setMutexBits(1);
	}

	public DinoAIAgressive(EntityNewPrehistoric mob, Class targetClass, int selectorTime, boolean sight, boolean nearbyOnly) {
		this(mob, targetClass, selectorTime, sight, nearbyOnly, (IEntitySelector) null);
		this.setMutexBits(1);
	}

	public DinoAIAgressive(EntityNewPrehistoric mob, Class targetClass, int selectorTime, boolean sight, boolean nearbyOnly, final IEntitySelector selector) {
		super(mob, sight, nearbyOnly);
		this.targetClass = targetClass;
		this.targetChance = selectorTime;
		this.theNearestAttackableTargetSorter = new DinoAIAgressive.Sorter(mob);
		this.setMutexBits(1);
		this.targetEntitySelector = new IEntitySelector() {
			@Override
			public boolean isEntityApplicable(Entity entity) {
				return entity instanceof EntityLivingBase && (!(selector != null && !selector.isEntityApplicable(entity)) && DinoAIAgressive.this.isSuitableTarget((EntityLivingBase) entity, false));
			}
		};
	}

	@Override
	public boolean shouldExecute() {

		if(!((EntityNewPrehistoric)this.taskOwner).canWander){
			if(((EntityNewPrehistoric)this.taskOwner).flockObj != null){
				if(((EntityNewPrehistoric)this.taskOwner).flockObj.flockLeader != this.taskOwner){
					return false;
				}
			}
		}

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
				return ((EntityNewPrehistoric) taskOwner).canDinoHunt(targetEntity);
			}
		}
	}

	@Override
	public void startExecuting() {
		if(((EntityNewPrehistoric)this.taskOwner).ticksTillPlay > 0 && targetEntity instanceof EntityToyBase){
			this.taskOwner.setAttackTarget(null);

		}else{
			this.taskOwner.setAttackTarget(this.targetEntity);
			if(((EntityNewPrehistoric)this.taskOwner).flockObj != null){
				if(((EntityNewPrehistoric)this.taskOwner).flockObj.flockLeader == this.taskOwner){
					for(EntityNewPrehistoric prehistoric : ((EntityNewPrehistoric)this.taskOwner).flockObj.flockMembers){
						prehistoric.setAttackTarget(this.targetEntity);
					}
				}
			}
		}
		super.startExecuting();
	}

	public static class Sorter implements Comparator {
		private final Entity theEntity;

		public Sorter(Entity entity) {
			this.theEntity = entity;
		}

		public int compare(Entity firstEntity, Entity secondEntity) {
			double d0 = this.theEntity.getDistanceSqToEntity(firstEntity);
			double d1 = this.theEntity.getDistanceSqToEntity(secondEntity);
			return d0 < d1 ? -1 : (d0 > d1 ? 1 : 0);
		}

		@Override
		public int compare(Object firstEntity, Object secondEntity) {
			return this.compare((Entity) firstEntity, (Entity) secondEntity);
		}
	}
}