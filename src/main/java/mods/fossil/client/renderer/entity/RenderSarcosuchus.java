package mods.fossil.client.renderer.entity;

import mods.fossil.client.model.ModelSarcosuchus;
import mods.fossil.client.model.ModelWeakSarcosuchus;
import mods.fossil.client.model.ModelWeakTRex;
import mods.fossil.entity.mob.EntitySarcosuchus;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSarcosuchus extends RenderLiving {
	public RenderSarcosuchus(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}

	/**
	 * Applies the scale to the transform matrix
	 *
	 * Use this to grow the dinonsaur with age.
	 */
	protected void preRenderScale(EntitySarcosuchus entitydinosaur, float par2) {
		GL11.glScalef(entitydinosaur.getDinosaurSize(),
				entitydinosaur.getDinosaurSize(),
				entitydinosaur.getDinosaurSize());
	}

	/**
	 * Allows the render to do any OpenGL state modifications necessary before
	 * the model is rendered. Args: entityLiving, partialTickTime
	 */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.preRenderScale((EntitySarcosuchus)par1EntityLivingBase, par2);
        if (((EntitySarcosuchus)par1EntityLivingBase).isWeak())
        {
            if (!(this.mainModel instanceof ModelWeakSarcosuchus))
            {
                this.mainModel = new ModelWeakSarcosuchus();
            }
        }
        else if (this.mainModel instanceof ModelWeakSarcosuchus)
        {
            this.mainModel = new ModelSarcosuchus();
        }
    }

	protected ResourceLocation func_110919_a(EntitySarcosuchus par1Entity) {
		return new ResourceLocation(par1Entity.getTexture());
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return this.func_110919_a((EntitySarcosuchus) par1Entity);
	}
}