package com.github.revival.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTarSlimeOuter extends ModelBase {
	public ModelRenderer outside;

	public ModelTarSlimeOuter() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.outside = new ModelRenderer(this, 0, 0);
		this.outside.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.outside.addBox(-4.0F, 16.0F, -4.0F, 8, 8, 8, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.outside.render(f5);
	}
}
