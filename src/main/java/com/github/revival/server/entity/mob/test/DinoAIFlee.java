package com.github.revival.server.entity.mob.test;

import com.github.revival.server.enums.EnumPrehistoricAI.Response;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIPanic;

public class DinoAIFlee extends EntityAIPanic {
	EntityNewPrehistoric prehistoric;

	public DinoAIFlee(EntityNewPrehistoric creature) {
		super(creature, 1.7);
		this.prehistoric = creature;
	}

	public boolean shouldExecute() {
		if (!prehistoric.isMovementBlocked()) {
			return false;
		}
		if (prehistoric instanceof EntityFlyingPrehistoric && ((EntityFlyingPrehistoric) prehistoric).isFlying()) {
			return false;
		}
		if (prehistoric.aiResponseType() == Response.SCARED) {
			return super.shouldExecute();
		}
		if (prehistoric.aiResponseType() == Response.NONE) {
			return super.shouldExecute();
		}
		return false;
	}

}
