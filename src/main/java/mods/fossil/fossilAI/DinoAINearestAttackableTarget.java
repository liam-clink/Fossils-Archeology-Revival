package mods.fossil.fossilAI;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

public class DinoAINearestAttackableTarget extends EntityAINearestAttackableTarget {

	private boolean asChild;
	private EntityCreature entity;

	/*
	 * Check if the attacking creature is a child, and if so will it run.
	 */
	public DinoAINearestAttackableTarget(EntityCreature entity, Class targetClass, int chance, boolean canSee, boolean isNearby, boolean asChild) {
		super(entity, targetClass, chance, canSee, isNearby);
		this.asChild = asChild;
		this.entity = entity;
	}

	@Override
    public boolean shouldExecute()
    {
		if(this.entity.isChild())
		{
			if(this.asChild == true)
				return super.shouldExecute();
		}
		else
		{
			return super.shouldExecute();
		}
		
		return false;
    }
	
	
	
	
}
