package fossilsarcheology.client.render.particle;

import net.minecraft.client.particle.ParticleFlame;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class BubbleFX extends ParticleFlame {
    public BubbleFX(World world, double x, double y, double z, double motionX, double motionY, double motionZ) {
        super(world, pos, motionX, motionY, motionZ);
        this.particleRed = 1.0F;
        this.particleGreen = 1.0F;
        this.particleBlue = 1.0F;
        this.setParticleTextureIndex(32);
        this.setSize(0.02F, 0.02F);
        this.particleScale = this.rand.nextFloat() * 0.6F;
        this.particleMaxAge = (int) (18.0D / (Math.random() * 0.4D + 0.2D));
    }
}
