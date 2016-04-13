package com.github.revival.server.entity.toy;

import net.minecraft.world.World;

import com.github.revival.server.entity.mob.test.EntityToyBase;

public class EntityToyBall extends EntityToyBase{

	public int rollValue;
	
	public EntityToyBall(World world) {
	    super(world, 15);
	    this.setSize(0.8F, 0.8F);
    }
	
	public void onUpdate(){
		double prevMotionX = this.motionX;
		double prevMotionZ = this.motionZ;
		if(this.motionX != prevMotionX || this.motionZ != prevMotionZ){
			rollValue++;
		}
	}
}
