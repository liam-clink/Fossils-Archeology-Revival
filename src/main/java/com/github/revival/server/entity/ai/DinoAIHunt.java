package com.github.revival.server.entity.ai;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;

import fossilsarcheology.api.FoodMappings;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;

public class DinoAIHunt extends EntityAITarget {
	private final int targetTicks;
	private final DinoAIHunt.Sorter theNearestAttackableTargetSorter;
	private final IEntitySelector targetEntitySelector;
	private EntityLivingBase targetEntity;

	public DinoAIHunt(EntityCreature prehistoric, int ticks, boolean sight) {
		this(prehistoric, ticks, sight, false);
	}

	public DinoAIHunt(EntityCreature prehistoric, int ticks, boolean sight, boolean nearby) {
		this(prehistoric, ticks, sight, nearby, (IEntitySelector) null);
	}

	public DinoAIHunt(EntityCreature prehistoric, int ticks, boolean sight, boolean nearby, final IEntitySelector selector) {
		super(prehistoric, sight, nearby);
		this.targetTicks = ticks;
		this.theNearestAttackableTargetSorter = new DinoAIHunt.Sorter(prehistoric);
		this.setMutexBits(1);
		this.targetEntitySelector = new IEntitySelector() {
			public boolean isEntityApplicable(Entity target) {
				return !(target instanceof EntityLivingBase) ? false : (selector != null && !selector.isEntityApplicable(target) ? false : DinoAIHunt.this.isSuitableTarget((EntityLivingBase) target, false));
			}
		};
	}

	public boolean shouldExecute() {
		
		if (this.targetTicks > 0 && this.taskOwner.getRNG().nextInt(this.targetTicks) != 0) {
			return false;
		} else {
			double d0 = this.getTargetDistance();
			List list = this.taskOwner.worldObj.selectEntitiesWithinAABB(EntityLivingBase.class, this.taskOwner.boundingBox.expand(d0, 4.0D, d0), this.targetEntitySelector);
			Collections.sort(list, this.theNearestAttackableTargetSorter);

			if (list.isEmpty()) {
				return false;
			} else {
				this.targetEntity = (EntityLivingBase) list.get(0);
				if(this.taskOwner instanceof EntityNewPrehistoric){
					EntityNewPrehistoric prehistoric = (EntityNewPrehistoric)this.taskOwner;
					if(prehistoric.isMovementBlocked() && !prehistoric.canDinoHunt(targetEntity)){
						return false;
					}
					if(FoodMappings.instance().getEntityFoodAmount(this.targetEntity.getClass(), prehistoric.type.diet) == 0){
						return false;
					}
				}
				return true;
			}
		}
	}

	public void startExecuting() {
		this.taskOwner.setAttackTarget(this.targetEntity);
		super.startExecuting();
	}

	public static class Sorter implements Comparator {
		private final Entity theEntity;

		public Sorter(Entity entity) {
			this.theEntity = entity;
		}

		public int compare(Entity entity, Entity entity1) {
			double d0 = this.theEntity.getDistanceSqToEntity(entity);
			double d1 = this.theEntity.getDistanceSqToEntity(entity1);
			return d0 < d1 ? -1 : (d0 > d1 ? 1 : 0);
		}

		public int compare(Object entity, Object entity1) {
			return this.compare((Entity) entity, (Entity) entity1);
		}
	}
}