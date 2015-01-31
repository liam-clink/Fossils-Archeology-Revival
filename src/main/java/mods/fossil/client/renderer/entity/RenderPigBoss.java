package mods.fossil.client.renderer.entity;

import mods.fossil.client.model.ModelPigBoss;
import mods.fossil.entity.mob.EntityPigBoss;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderPigBoss extends RenderBiped
{
    private static final ResourceLocation loc = new ResourceLocation("fossil:textures/mob/PigBoss.png");
    private static final ResourceLocation loc2 = new ResourceLocation("fossil:textures/mob/PigBoss_r.png");
    private static final ResourceLocation loc3 = new ResourceLocation("fossil:textures/mob/PigBossCharged_r.png");

    protected ResourceLocation func_110919_a(EntityPigBoss par1Entity)
    {
    	return new ResourceLocation(par1Entity.getSkin());
    }

    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.func_110919_a((EntityPigBoss)par1Entity);
    }

    public RenderPigBoss(ModelBiped var1, float var2)
    {
        super(var1, var2);
        this.setRenderPassModel(new ModelPigBoss());
    }

    @Override
    public void doRender(EntityLiving var1, double var2, double var4, double var6, float var8, float var9)
    {
    	BossStatus.setBossStatus((EntityPigBoss)var1, true);
        ((ModelPigBoss)((ModelPigBoss)this.mainModel)).RangedAttack = ((EntityPigBoss)var1).getAttackMode() == 1;
        super.doRender(var1, var2, var4, var6, var8, var9);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    @Override
    protected int shouldRenderPass(EntityLivingBase var1, int var2, float var3)
    {
        return this.setChargeLineBrightness((EntityPigBoss)var1, var2, var3);
    }

    public int setChargeLineBrightness(EntityPigBoss entityPigBoss, int var2, float var3)
    {
        if (var2 != 0)
        {
            return -1;
        }
        else
        {
            if (entityPigBoss.FireballCount >= 50)
            {
                this.renderManager.renderEngine.bindTexture(new ResourceLocation("fossil:textures/mob/PigBossCharged_r.png"));
            }
            else
            {
            	this.renderManager.renderEngine.bindTexture(new ResourceLocation("fossil:textures/mob/PigBoss.png"));
            }

            float f1 = (1.0F - entityPigBoss.getBrightness(1.0F)) * 0.5F;
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);

            char c0 = 61680;
            int j = c0 % 65536;
            int k = c0 / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
            return 1;
        }
    }
}
