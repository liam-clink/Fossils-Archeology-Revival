package com.github.revival.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTarSlime extends ModelBase {
    public ModelRenderer eyeRight;
    public ModelRenderer eyeLeft;
    public ModelRenderer mouth;
    public ModelRenderer inside;

    public ModelTarSlime() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.eyeLeft = new ModelRenderer(this, 32, 4);
        this.eyeLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.eyeLeft.addBox(1.25F, 18.5F, -3.5F, 2, 2, 2, 0.0F);
        this.mouth = new ModelRenderer(this, 32, 8);
        this.mouth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.mouth.addBox(0.0F, 21.0F, -3.5F, 1, 1, 1, 0.0F);
        this.eyeRight = new ModelRenderer(this, 32, 0);
        this.eyeRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.eyeRight.addBox(-3.25F, 17.5F, -3.5F, 2, 2, 2, 0.0F);
        this.inside = new ModelRenderer(this, 0, 16);
        this.inside.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.inside.addBox(-3.0F, 17.0F, -3.0F, 6, 6, 6, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.eyeLeft.render(f5);
        this.mouth.render(f5);
        this.eyeRight.render(f5);
        this.inside.render(f5);
    }

    
}
