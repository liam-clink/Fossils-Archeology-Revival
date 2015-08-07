package com.github.revival.client.renderer.entity;

import com.github.revival.Revival;
import com.github.revival.common.entity.mob.EntityVelociraptor;
import com.github.revival.common.json.JsonTabulaModel;
import com.github.revival.common.json.ModelHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderVelociraptor extends RenderLiving
{
    private static JsonTabulaModel model = ModelHelper.parseModelFromJson(Revival.class.getResourceAsStream("assets/fossil/models/Velociraptor.json"));

    public RenderVelociraptor()
    {
        super(model.modelJson, 0.5f);
    }

    /**
     * Applies the scale to the transform matrix
     * <p/>
     * Use this to grow the dinonsaur with age.
     */
    protected void preRenderScale(EntityVelociraptor entitydinosaur, float par2)
    {

        GL11.glScalef(entitydinosaur.getDinosaurSize(), entitydinosaur.getDinosaurSize(), entitydinosaur.getDinosaurSize());
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.preRenderScale((EntityVelociraptor) par1EntityLivingBase, par2);
    }

    protected ResourceLocation func_110919_a(EntityVelociraptor par1Entity)
    {
        return new ResourceLocation(par1Entity.getTexture());
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.func_110919_a((EntityVelociraptor) par1Entity);
    }
}