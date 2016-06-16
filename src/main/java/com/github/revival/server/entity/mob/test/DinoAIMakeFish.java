package com.github.revival.server.entity.mob.test;

import java.util.Map;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import fossilsarcheology.api.EnumDiet;
import fossilsarcheology.api.FoodMappings;

public class DinoAIMakeFish extends EntityAIBase {

	private EntitySwimmingPrehistoric dinosaur;
	private World world;

	public DinoAIMakeFish(EntitySwimmingPrehistoric dinosaur) {
		this.dinosaur = dinosaur;
		this.world = dinosaur.worldObj;
	}

	@Override
	public boolean shouldExecute() {
		if (!this.dinosaur.isHungry()) {
			return false;
		}
		if (this.dinosaur.getRNG().nextInt(15) != 0) {
			return false;
		}
		if (!this.dinosaur.isInWater()) {
			return false;
		}
		if (this.dinosaur.FISH_ANIMATION == null) {
			return false;
		}
		return true;
	}

	public boolean continueExecuting() {
		if (!this.dinosaur.isHungry()) {
			return false;
		}
		if (!this.dinosaur.isInWater()) {
			return false;
		}
		return true;
	}
	
    public void startExecuting() {
    	if(this.dinosaur.isInWater()){
    		if(this.dinosaur.getAnimation() != this.dinosaur.FISH_ANIMATION){
    			this.dinosaur.setAnimation(this.dinosaur.FISH_ANIMATION);
    		}
    	}
    }
    
    public void updateTask() {
    	if(this.dinosaur.getAnimation() == this.dinosaur.FISH_ANIMATION){
    		if(this.dinosaur.getAnimationTick() > 20){
    			ItemStack stack2 = new ItemStack(Items.fish, 1 +  this.dinosaur.getRNG().nextInt(2), this.dinosaur.getRNG().nextInt(2));
    			this.dinosaur.entityDropItem(stack2, 1);
    			resetTask();
    			return;
    		}	
		}
    }
}
