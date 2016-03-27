package com.github.revival.client.model.prehistoric;

import com.github.revival.client.model.base.ModelPrehistoric;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.util.MathHelper;

public class ModelNautilus extends ModelPrehistoric {

    public AdvancedModelRenderer Shell;
    public AdvancedModelRenderer Head;
    public AdvancedModelRenderer Tech1;
    public AdvancedModelRenderer Tech2;
    public AdvancedModelRenderer Tech3;
    public AdvancedModelRenderer Tech4;
    public AdvancedModelRenderer Tech5;
    public AdvancedModelRenderer Tech6;

    public ModelNautilus() {
        this.Shell = new AdvancedModelRenderer(this, 0, 12);
        this.Shell.addBox(-2.0F, -5.0F, -5.0F, 4, 10, 10, 0.0F);
        this.Shell.setRotationPoint(2.0F, 15.0F, 1.0F);
        this.Shell.rotateAngleX = 0.0F;
        this.Shell.rotateAngleY = 0.0F;
        this.Shell.rotateAngleZ = 0.0F;
        this.Shell.mirror = false;
        this.Head = new AdvancedModelRenderer(this, 0, 0);
        this.Head.addBox(-3.0F, 1.0F, -7.0F, 6, 6, 6, 0.0F);
        this.Head.setRotationPoint(2.0F, 15.0F, 1.0F);
        this.Head.rotateAngleX = -0.8588527F;
        this.Head.rotateAngleY = 0.0F;
        this.Head.rotateAngleZ = 0.0F;
        this.Head.mirror = false;
        this.Tech1 = new AdvancedModelRenderer(this, 0, 12);
        this.Tech1.addBox(-1.0F, -1.0F, -2.0F, 1, 8, 1, 0.0F);
        this.Tech1.setRotationPoint(2.0F, 16.0F, -6.0F);
        this.Tech1.rotateAngleX = 0.0F;
        this.Tech1.rotateAngleY = 0.0F;
        this.Tech1.rotateAngleZ = 0.0F;
        this.Tech1.mirror = false;
        this.Tech2 = new AdvancedModelRenderer(this, 0, 12);
        this.Tech2.addBox(-2.0F, 0.0F, -1.0F, 1, 8, 1, 0.0F);
        this.Tech2.setRotationPoint(2.0F, 16.0F, -6.0F);
        this.Tech2.rotateAngleX = 0.0F;
        this.Tech2.rotateAngleY = 0.0F;
        this.Tech2.rotateAngleZ = 0.0F;
        this.Tech2.mirror = false;
        this.Tech3 = new AdvancedModelRenderer(this, 0, 12);
        this.Tech3.addBox(2.0F, 1.0F, 0.0F, 1, 8, 1, 0.0F);
        this.Tech3.setRotationPoint(1.0F, 16.0F, -6.0F);
        this.Tech3.rotateAngleX = 0.0F;
        this.Tech3.rotateAngleY = 0.0F;
        this.Tech3.rotateAngleZ = 0.0F;
        this.Tech3.mirror = false;
        this.Tech4 = new AdvancedModelRenderer(this, 0, 12);
        this.Tech4.addBox(1.0F, 0.0F, -1.0F, 1, 8, 1, 0.0F);
        this.Tech4.setRotationPoint(2.0F, 16.0F, -6.0F);
        this.Tech4.rotateAngleX = 0.0F;
        this.Tech4.rotateAngleY = 0.0F;
        this.Tech4.rotateAngleZ = 0.0F;
        this.Tech4.mirror = false;
        this.Tech5 = new AdvancedModelRenderer(this, 0, 12);
        this.Tech5.addBox(0.0F, -1.0F, -2.0F, 1, 8, 1, 0.0F);
        this.Tech5.setRotationPoint(2.0F, 16.0F, -6.0F);
        this.Tech5.rotateAngleX = 0.0F;
        this.Tech5.rotateAngleY = 0.0F;
        this.Tech5.rotateAngleZ = 0.0F;
        this.Tech5.mirror = false;
        this.Tech6 = new AdvancedModelRenderer(this, 0, 12);
        this.Tech6.addBox(-2.0F, 1.0F, 0.0F, 1, 8, 1, 0.0F);
        this.Tech6.setRotationPoint(2.0F, 16.0F, -6.0F);
        this.Tech6.rotateAngleX = 0.0F;
        this.Tech6.rotateAngleY = 0.0F;
        this.Tech6.rotateAngleZ = 0.0F;
        this.Tech6.mirror = false;
        doAdvancedStuff(false);

    }


    @Override
    public void renderLiving(EntityNewPrehistoric entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Tech1.rotateAngleX = 0.2F * MathHelper.sin(f2 * 0.3F + 1.0F) + 0.4F;
        this.Tech2.rotateAngleX = 0.2F * MathHelper.sin(f2 * 0.3F + 2.0F) + 0.4F;
        this.Tech3.rotateAngleX = 0.2F * MathHelper.sin(f2 * 0.3F + 3.0F) + 0.4F;
        this.Tech4.rotateAngleX = 0.2F * MathHelper.sin(f2 * 0.3F + 4.0F) + 0.4F;
        this.Tech5.rotateAngleX = 0.2F * MathHelper.sin(f2 * 0.3F + 5.0F) + 0.4F;
        this.Tech6.rotateAngleX = 0.2F * MathHelper.sin(f2 * 0.3F + 6.0F) + 0.4F;
    }

    @Override
    public void renderFossil(EntityNewPrehistoric entity, float f, float f1, float f2, float f3, float f4, float f5) {

    }

    @Override
    public void renderSleeping(EntityNewPrehistoric entity, float f, float f1, float f2, float f3, float f4, float f5) {

    }
}
