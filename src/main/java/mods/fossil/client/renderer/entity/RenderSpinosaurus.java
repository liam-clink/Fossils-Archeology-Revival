package mods.fossil.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.fossil.client.model.ModelSpinosaurus;
import mods.fossil.entity.mob.EntitySpinosaurus;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderSpinosaurus extends RenderLiving
{
    public RenderSpinosaurus(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    /**
     * Applies the scale to the transform matrix
     *
     * Use this to grow the dinonsaur with age.
     */
    protected void preRenderScale(EntitySpinosaurus entitydinosaur, float par2)
    {
        GL11.glScalef(entitydinosaur.getDinosaurSize(), entitydinosaur.getDinosaurSize(), entitydinosaur.getDinosaurSize());
    }
    
    /**
     * Renders the model in RenderLiving
     */
    protected void renderModel(EntityLivingBase entityLivingBase, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        this.renderHead((EntitySpinosaurus)entityLivingBase, par2, par3, par4, par5, par6, par7);
        super.renderModel(entityLivingBase, par2, par3, par4, par5, par6, par7);
    }
    
    protected void renderHead(EntitySpinosaurus entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
    	GL11.glPushMatrix();
    	((ModelSpinosaurus)this.mainModel).headpivot.rotationPointX = ((ModelSpinosaurus)this.mainModel).headdummy.rotationPointX;
    	((ModelSpinosaurus)this.mainModel).headpivot.rotationPointY = ((ModelSpinosaurus)this.mainModel).headdummy.rotationPointY;
    	((ModelSpinosaurus)this.mainModel).headpivot.rotationPointZ = ((ModelSpinosaurus)this.mainModel).headdummy.rotationPointZ;
    	GL11.glPopMatrix();
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.preRenderScale((EntitySpinosaurus)par1EntityLivingBase, par2);
    }

    protected ResourceLocation func_110919_a(EntitySpinosaurus par1Entity)
    {
        return new ResourceLocation(par1Entity.getTexture());
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.func_110919_a((EntitySpinosaurus)par1Entity);
    }
}