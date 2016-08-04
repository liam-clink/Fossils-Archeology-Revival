package fossilsarcheology.client.render.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class DeathOrbFX extends Particle {
    private static final ResourceLocation TEXTURE = new ResourceLocation("fossil:textures/darkOrb.png");
    private static final ResourceLocation PARTICLES_TEXTURE = new ResourceLocation("textures/particle/particles.png");
    private static TextureManager textureManager = Minecraft.getMinecraft().getTextureManager();
    private float scale;

    public DeathOrbFX(World world, double x, double y, double z, double motionX, double motionY, double motionZ) {
        this(world, pos, motionX, motionY, motionZ, 1.0F);
    }

    public DeathOrbFX(World world, double x, double y, double z, double motionX, double motionY, double motionZ, float age) {
        super(world, pos, 0.0D, 0.0D, 0.0D);
        this.motionX *= 0.10000000149011612D;
        this.motionY *= 0.10000000149011612D;
        this.motionZ *= 0.10000000149011612D;
        this.motionX += motionX;
        this.motionY += motionY;
        this.motionZ += motionZ;
        this.scale = this.particleScale * 1.5F;
        this.particleMaxAge = (int) (84.0D / (Math.random() * 0.05D + 0.2D));
        this.particleMaxAge = (int) ((float) this.particleMaxAge * age);
        this.field_190017_n = false;
    }

    @Override
    public void renderParticle(Tessellator tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {
        tessellator.draw();
        GlStateManager.pushMatrix();
        GL11.glDepthMask(false);
        GL11.glEnable(3042);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE);
        float sizeFactor = 0.1F * particleScale;
        float var13 = (float) (prevPosX + (posX - prevPosX) * par2 - Particle.interpPosX);
        float var14 = (float) (prevPosY + (posY - prevPosY) * par2 - Particle.interpPosY);
        float var15 = (float) (prevPosZ + (posZ - prevPosZ) * par2 - Particle.interpPosZ);
        tessellator.startDrawingQuads();
        tessellator.setBrightness(240);
        tessellator.setColorRGBA_F(particleRed, particleGreen, particleBlue, 1.0F);
        tessellator.addVertexWithUV(var13 - par3 * sizeFactor - par6 * sizeFactor, var14 - par4 * sizeFactor, var15 - par5 * sizeFactor - par7 * sizeFactor, 0.0D, 1.0D);
        tessellator.addVertexWithUV(var13 - par3 * sizeFactor + par6 * sizeFactor, var14 + par4 * sizeFactor, var15 - par5 * sizeFactor + par7 * sizeFactor, 1.0D, 1.0D);
        tessellator.addVertexWithUV(var13 + par3 * sizeFactor + par6 * sizeFactor, var14 + par4 * sizeFactor, var15 + par5 * sizeFactor + par7 * sizeFactor, 1.0D, 0.0D);
        tessellator.addVertexWithUV(var13 + par3 * sizeFactor - par6 * sizeFactor, var14 - par4 * sizeFactor, var15 + par5 * sizeFactor - par7 * sizeFactor, 0.0D, 0.0D);
        tessellator.draw();
        GL11.glDisable(3042);
        GL11.glDepthMask(true);
        GlStateManager.popMatrix();
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(PARTICLES_TEXTURE);
        tessellator.startDrawingQuads();
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }

        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.motionY += 0.004D;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);

        if (this.posY == this.prevPosY) {
            this.motionX *= 1.1D;
            this.motionZ *= 1.1D;
        }

        this.motionX *= 0.9599999785423279D;
        this.motionY *= 0.9599999785423279D;
        this.motionZ *= 0.9599999785423279D;

        if (this.isCollided) {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }
    }
}