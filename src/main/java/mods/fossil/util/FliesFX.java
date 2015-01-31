package mods.fossil.util;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class FliesFX extends EntityFX
{
    //declare your variables
    public static final ResourceLocation resourceloc = new ResourceLocation("fossil:textures/Flies.png");
    private static TextureManager textureManager = Minecraft.getMinecraft().getTextureManager(); //get the TextureManager instance

    float particleScaleOverTime;

    public FliesFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12)
    {
        this(par1World, par2, par4, par6, par8, par10, par12, 2.0F);
    }

    public FliesFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12, float par14)
    {
        super(par1World, par2, par4, par6, 0.0D, 0.0D, 0.0D);
        this.motionX *= 0.009999999776482582D;
        this.motionY *= 0.009999999776482582D;
        this.motionZ *= 0.009999999776482582D;
        //this.motionY += 0.1D;
        this.particleScale *= 0.75F;
        this.particleScale *= par14;
        this.particleScaleOverTime = this.particleScale;
        this.particleMaxAge = 16;
        this.noClip = false;
        this.setParticleTextureIndex(0);
    }

    public void renderParticle(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        Tessellator tessellator1 = new Tessellator();
        tessellator1.startDrawingQuads();
        tessellator1.setBrightness(getBrightnessForRender(f));
        float f6 = (((float)particleAge + f) / (float)particleMaxAge) * 32F;

        if (f6 < 0.0F)
        {
            f6 = 0.0F;
        }

        if (f6 > 1.0F)
        {
            f6 = 1.0F;
        }

        this.particleScale = this.particleScaleOverTime * f6;
        Minecraft mc = FMLClientHandler.instance().getClient();
        textureManager.bindTexture(resourceloc);
        float f0 = (float) this.particleTextureIndexX / 16F;
        float f7 = f0 + 0.0624375F;
        float f8 = (float) this.particleTextureIndexX / 16F;
        float f9 = f8 + 0.0624375F;
        float f10 = 0.1F * particleScale;
        float f11 = (float)((prevPosX + (posX - prevPosX) * (double)f) - interpPosX);
        float f12 = (float)((prevPosY + (posY - prevPosY) * (double)f) - interpPosY);
        float f13 = (float)((prevPosZ + (posZ - prevPosZ) * (double)f) - interpPosZ);
        float f14 = 1.0F;
        tessellator1.setColorOpaque_F(particleRed * f14, particleGreen * f14, particleBlue * f14);
        tessellator1.addVertexWithUV(f11 - f1 * f10 - f4 * f10, f12 - f2 * f10, f13 - f3 * f10 - f5 * f10, f7, f9);
        tessellator1.addVertexWithUV((f11 - f1 * f10) + f4 * f10, f12 + f2 * f10, (f13 - f3 * f10) + f5 * f10, f7, f8);
        tessellator1.addVertexWithUV(f11 + f1 * f10 + f4 * f10, f12 + f2 * f10, f13 + f3 * f10 + f5 * f10, f0, f8);
        tessellator1.addVertexWithUV((f11 + f1 * f10) - f4 * f10, f12 - f2 * f10, (f13 + f3 * f10) - f5 * f10, f0, f9);
        tessellator1.draw();
//        GL11.glBindTexture(GL11.GL_TEXTURE_2D, mc.renderEngine.getTexture("/particles.png"));
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setDead();
        }

        this.moveEntity(this.motionX, this.motionY, this.motionZ);

        if (this.posY == this.prevPosY)
        {
            this.motionX *= 1.1D;
            this.motionZ *= 1.1D;
        }

        this.motionX *= 0.8600000143051147D;
        this.motionY *= 0.8600000143051147D;
        this.motionZ *= 0.8600000143051147D;

        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }
    }
}