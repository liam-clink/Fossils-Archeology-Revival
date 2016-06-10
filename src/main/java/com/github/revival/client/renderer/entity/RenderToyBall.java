package com.github.revival.client.renderer.entity;

import net.minecraft.block.BlockColored;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.github.revival.client.model.ModelToyBall;
import com.github.revival.server.entity.toy.EntityToyBall;

public class RenderToyBall extends RenderLiving {

	public RenderToyBall() {
		super(new ModelToyBall(), 0.3F);
	}

	protected void preRenderCallback(EntityLivingBase living, float f) {
		int i = BlockColored.func_150032_b(((EntityToyBall) living).getColor());
		GL11.glColor3f(EntitySheep.fleeceColorTable[i][0], EntitySheep.fleeceColorTable[i][1], EntitySheep.fleeceColorTable[i][2]);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("fossil:textures/model/toy/ball.png");
	}
}
