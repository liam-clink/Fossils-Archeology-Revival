package mods.fossil.AI;

import mods.fossil.entity.mob.EntityPrehistoric;
import net.minecraft.entity.ai.EntityAIBase;

public abstract class FossilAIInHerd extends EntityAIBase {
	
	public static int MODE_IDLE = 0;
	public static int MODE_WANDER = 1;
	public static int MODE_ATTACK = 2;
	public static int MODE_FOLLOW = 3;
	public static int MODE_FLEE = 4;
	
	private EntityPrehistoric entity;
	private int mode;
	
	public FossilAIInHerd(EntityPrehistoric entity) {
		this.entity = entity;
	}
	
	@Override
	public boolean shouldExecute() {
		return entity.isInHerd();
	}

}
