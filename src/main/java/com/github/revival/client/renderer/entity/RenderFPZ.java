package com.github.revival.client.renderer.entity;

import com.github.revival.client.model.ModelFPZ;
import com.github.revival.server.entity.mob.EntityFriendlyPigZombie;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderFPZ extends RenderBiped {
    private static final ResourceLocation texture = new ResourceLocation("textures/entity/zombie_pigman.png");

    public RenderFPZ() {
        super(new ModelFPZ(), 0.5F);
    }

    protected void scalePigman(EntityFriendlyPigZombie par1EntitySkeleton, float par2) {
        if (par1EntitySkeleton.isSitting()) GL11.glTranslatef(0F, 0.4F, 0F);
    }


    @Override
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
        this.scalePigman((EntityFriendlyPigZombie) par1EntityLivingBase, par2);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return texture;
    }
}
