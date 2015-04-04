package mods.fossil.client.renderer.entity;

import mods.fossil.client.model.ModelFlyingPteranodon;
import mods.fossil.client.model.ModelPteranodon;
import mods.fossil.client.model.ModelTRex;
import mods.fossil.client.model.ModelWeakTRex;
import mods.fossil.entity.mob.EntityMosasaurus;
import mods.fossil.entity.mob.EntityPterosaur;
import mods.fossil.entity.mob.EntityTRex;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPterosaur extends RenderLiving {

	public RenderPterosaur(ModelPteranodon par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}

	/**
	 * Applies the scale to the transform matrix
	 *
	 * Use this to grow the dinonsaur with age.
	 */
	protected void preRenderScale(EntityPterosaur entitydinosaur, float par2) {
		GL11.glScalef(entitydinosaur.getDinosaurSize(),entitydinosaur.getDinosaurSize(),entitydinosaur.getDinosaurSize());
		GL11.glScalef(1.8f, 1.8f, 1.8f);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
		this.preRenderScale((EntityPterosaur) par1EntityLivingBase, par2);
		
		if (!((EntityPterosaur) par1EntityLivingBase).checkGround((EntityPterosaur) par1EntityLivingBase)) {
			if (!(this.mainModel instanceof ModelFlyingPteranodon)) {
				this.mainModel = new ModelFlyingPteranodon();
			}
		}
		else if (this.mainModel instanceof ModelFlyingPteranodon) {
			this.mainModel = new ModelPteranodon();
		}
	}
	 protected ResourceLocation func_110919_a(EntityPterosaur par1Entity)
	    {
	        return new ResourceLocation(par1Entity.getTexture());
	    }

	    /**
	     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	     */
	    protected ResourceLocation getEntityTexture(Entity par1Entity)
	    {
	        return this.func_110919_a((EntityPterosaur)par1Entity);
	    }
}