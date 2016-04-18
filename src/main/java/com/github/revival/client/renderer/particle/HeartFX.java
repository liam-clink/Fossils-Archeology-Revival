package com.github.revival.client.renderer.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public class HeartFX extends BubbleFX {

	public HeartFX(World world, double x, double y, double z, double motionX, double motionY, double motionZ) {
	    super(world, x, y, z, motionX, motionY, motionZ);
        this.setParticleTextureIndex(80);

    }

}
