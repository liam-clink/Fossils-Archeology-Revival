package com.github.revival.server.entity.mob.test;

import com.github.revival.server.enums.EnumPrehistoricAI.Response;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIPanic;

public class DinoAIFlee extends EntityAIPanic{
	EntityNewPrehistoric creature;
	public DinoAIFlee(EntityNewPrehistoric creature) {
	    super(creature, 1.7);
	    this.creature = creature;
    }
	
    public boolean shouldExecute()
    {
    	if(!creature.canWander){
    		return false;
    	}
  
    	if(this.creature instanceof EntityNewPrehistoric && ((EntityNewPrehistoric)creature).aiResponseType() == Response.SCARED){
    		return super.shouldExecute();
    	}
    	if(this.creature instanceof EntityNewPrehistoric && ((EntityNewPrehistoric)creature).aiResponseType() == Response.NONE){
    		return super.shouldExecute();
    	}
    	return false;
    }

}
