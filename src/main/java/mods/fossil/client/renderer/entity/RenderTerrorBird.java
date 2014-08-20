package mods.fossil.client.renderer.entity;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.fossil.Fossil;
import mods.fossil.entity.mob.EntityBrachiosaurus;
import mods.fossil.entity.mob.EntityTerrorBird;
import mods.fossil.entity.mob.EntityTerrorBird;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderTerrorBird extends RenderLiving
{
    private static final ResourceLocation gastornisBaby = new ResourceLocation(Fossil.modid + ":" + "textures/mob/TerrorBird/Gastornis_Baby.png");
    private static final ResourceLocation gastornisAdult = new ResourceLocation(Fossil.modid + ":" + "textures/mob/TerrorBird/Gastornis_Adult.png");
    private static final ResourceLocation PhorusrhacosBaby = new ResourceLocation(Fossil.modid + ":" + "textures/mob/TerrorBird/Phorusrhacos_Baby.png");
    private static final ResourceLocation PhorusrhacosAdult = new ResourceLocation(Fossil.modid + ":" + "textures/mob/TerrorBird/Phorusrhacos_Adult.png");
    private static final ResourceLocation TitanisBaby = new ResourceLocation(Fossil.modid + ":" + "textures/mob/TerrorBird/Titanis_Baby.png");
    private static final ResourceLocation TitanisAdult = new ResourceLocation(Fossil.modid + ":" + "textures/mob/TerrorBird/Titanis_Adult.png");
    private static final ResourceLocation KelenkenAdult = new ResourceLocation(Fossil.modid + ":" + "textures/mob/TerrorBird/Kelenken_Adult.png");
    private static final ResourceLocation KelenkenBaby = new ResourceLocation(Fossil.modid + ":" + "textures/mob/TerrorBird/Kelenken_Baby.png");
    

    public RenderTerrorBird(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    public void renderDodo(EntityTerrorBird entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender(entity, par2, par4, par6, par8, par9);
    }
    
    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(EntityTerrorBird entity, float angle)
    {
    	if(entity.isAngry())
        return entity.getWingRotation();
    	
        float f1 = entity.field_70888_h + (entity.field_70886_e - entity.field_70888_h) * angle;
        float f2 = entity.field_70884_g + (entity.destPos - entity.field_70884_g) * angle;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }
    
    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(EntityLivingBase entityLivingBase, float angle)
    {
        return this.handleRotationFloat((EntityTerrorBird)entityLivingBase, angle);
    }
    
    /**
     * Applies the scale to the transform matrix
     *
     * Use this to grow the dinonsaur with age.
     */
    protected void preRenderScale(EntityTerrorBird entity, float par2)
    {
    	switch(entity.getSkin())
    	{
    	case 0:
    		default:
    	        GL11.glScalef(0.85F, 0.85F, 0.85F); break;
    		case 1:
    			GL11.glScalef(1.1F, 1.1F, 1.1F); break;
    		case 2:
    			GL11.glScalef(1.0F, 1.0F, 1.0F); break;
    		case 3:
    			GL11.glScalef(1.4F, 1.4F, 1.4F); break;
    	}
    }
    
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.preRenderScale((EntityTerrorBird)par1EntityLivingBase, par2);
    }

    protected ResourceLocation func_110919_a(EntityTerrorBird entity)
    {
    	switch (entity.getSkin())
        {
            case 0:
            default:
            	if(entity.isChild())
                return gastornisBaby;
            	return gastornisAdult;

            case 1:
            	if(entity.isChild())
                return PhorusrhacosBaby;
            	return PhorusrhacosAdult;
                
            case 2:
            	if(entity.isChild())
                return TitanisBaby;
            	return TitanisAdult;
            	
            case 3:
            	if(entity.isChild())
                return KelenkenBaby;
            	return KelenkenAdult;
        }
    }

    protected float getWingRotation(EntityTerrorBird entityLiving, float par2)
    {
        float f1 = entityLiving.field_70888_h + (entityLiving.field_70886_e - entityLiving.field_70888_h) * par2;
        float f2 = entityLiving.field_70884_g + (entityLiving.destPos - entityLiving.field_70884_g) * par2;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }

    public void doRender(EntityLiving entityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderDodo((EntityTerrorBird)entityLiving, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.func_110919_a((EntityTerrorBird)entity);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderDodo((EntityTerrorBird)entity, par2, par4, par6, par8, par9);
    }
}
