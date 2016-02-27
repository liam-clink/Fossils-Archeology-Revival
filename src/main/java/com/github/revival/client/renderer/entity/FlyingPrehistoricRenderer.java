package com.github.revival.client.renderer.entity;

import com.github.revival.server.entity.mob.test.NewPrehistoricEntity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.EntityLivingBase;

public class FlyingPrehistoricRenderer extends PrehistoricRenderer {

    public ModelBase flightModel;
    public ModelBase groundModel;

    public FlyingPrehistoricRenderer(ModelBase groundModel, ModelBase flightModel) {
        super(groundModel);
        this.flightModel = flightModel;
        this.groundModel = groundModel;

    }

    @Override
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
         /*   if (par1EntityLivingBase.isChild())
            {
	            GL11.glScalef(0.3F, 0.3F, 0.3F);
	            super.preRenderCallback(par1EntityLivingBase, par2);

	        }
	        else
	        {
	            GL11.glScalef(0.6F, 0.6F, 0.6F);
	            super.preRenderCallback(par1EntityLivingBase, par2);
	        }*/

        if (!((NewPrehistoricEntity) par1EntityLivingBase).onGround) {
            if (!(this.mainModel.getClass() != flightModel.getClass())) {
                this.mainModel = flightModel;
            }
        } else if (this.mainModel.getClass() != groundModel.getClass()) {
            this.mainModel = groundModel;
        }
    }

}
