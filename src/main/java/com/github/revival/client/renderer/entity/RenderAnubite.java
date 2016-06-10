package com.github.revival.client.renderer.entity;

import com.github.revival.client.model.ModelAnubite;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderAnubite extends RenderBiped {
	private static final ResourceLocation skeletonTextures = new ResourceLocation("fossil:textures/model/Anubite_ancient.png");

	public RenderAnubite() {
		super(new ModelAnubite(), 0.3F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return skeletonTextures;
	}

}