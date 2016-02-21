package com.github.revival.client.renderer.particle;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class SleepFX extends EntityFX {
    public static final ResourceLocation textures = new ResourceLocation("fossil:textures/sleep.png");
    private static final ResourceLocation particles = new ResourceLocation("textures/particle/particles.png");
    private static TextureManager textureManager = Minecraft.getMinecraft().getTextureManager();
    float smokeParticleScale;

    public SleepFX(World world, double x, double y, double z, double ix, double iy, double iz) {
        this(world, x, y, z, ix, iy, iz, 1.0F);
    }

    public SleepFX(World world, double x, double y, double z, double ix, double iy, double iz, float i) {
        super(world, x, y, z, 0.0D, 0.0D, 0.0D);
        this.motionX *= 0.10000000149011612D;
        this.motionY *= 0.10000000149011612D;
        this.motionZ *= 0.10000000149011612D;
        this.motionX += ix;
        this.motionY += iy;
        this.motionZ += iz;
        this.smokeParticleScale = this.particleScale * 1.0f;
        this.particleMaxAge = (int) (10.0D / (Math.random() * 0.05D + 0.2D));
        this.particleMaxAge = (int) ((float) this.particleMaxAge * i);
        this.noClip = true;
    }


    @Override
    public void renderParticle(Tessellator tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {
        tessellator.draw();
        GL11.glPushMatrix();
        GL11.glDepthMask(false);
        GL11.glEnable(3042);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(textures);
        float sizeFactor = 0.1F * particleScale;
        float var13 = (float) (prevPosX + (posX - prevPosX) * par2 - EntityFX.interpPosX);
        float var14 = (float) (prevPosY + (posY - prevPosY) * par2 - EntityFX.interpPosY);
        float var15 = (float) (prevPosZ + (posZ - prevPosZ) * par2 - EntityFX.interpPosZ);
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
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(particles);
        tessellator.startDrawingQuads();
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
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

        if (this.onGround) {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }
    }
}