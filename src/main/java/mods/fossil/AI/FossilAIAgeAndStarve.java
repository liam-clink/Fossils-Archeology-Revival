package mods.fossil.AI;

import mods.fossil.entity.mobs.EntityPrehistoric;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.DamageSource;

public class FossilAIAgeAndStarve extends EntityAIBase {
	
	private EntityPrehistoric entity;
	private int ticksTowardNextAge;
	private int ticksTowardHungerDecrement;
	
	public FossilAIAgeAndStarve(EntityPrehistoric entity) {
		this.entity = entity;
		this.setMutexBits(1);
	}

	@Override
	public boolean shouldExecute() {
		ticksTowardNextAge++;
		ticksTowardHungerDecrement++;
		if(ticksTowardNextAge >= EntityPrehistoric.ticksPerAge) {
			entity.incrementAge();
			ticksTowardNextAge = 0;
		}
		if(ticksTowardHungerDecrement >= entity.getType().getTicksPerHungerDecrement()) {
			entity.decrementHunger();
			ticksTowardHungerDecrement = 0;
			if(entity.getHunger() <= 5) {
				entity.attackEntityFrom(DamageSource.starve, 5.0F);
			}
		}
		return false;
	}
	
}
