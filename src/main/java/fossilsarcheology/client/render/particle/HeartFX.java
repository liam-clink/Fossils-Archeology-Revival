package fossilsarcheology.client.render.particle;

import net.minecraft.world.World;

public class HeartFX extends BubbleFX {

    public HeartFX(World world, double x, double y, double z, double motionX, double motionY, double motionZ) {
        super(world, pos, motionX, motionY, motionZ);
        this.setParticleTextureIndex(80);

    }

}
