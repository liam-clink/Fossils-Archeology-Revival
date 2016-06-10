package com.github.revival.client.renderer.item;

import net.minecraft.block.BlockColored;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.github.revival.client.model.ModelToyBall;

public class ItemToyBallRender implements IItemRenderer {

	protected ModelToyBall model;
	protected ResourceLocation texture = new ResourceLocation("fossil:textures/model/toy/ball.png");

	public ItemToyBallRender() {
		model = new ModelToyBall();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch (type) {
		case EQUIPPED:
			return true;
		case EQUIPPED_FIRST_PERSON:
			return true;
		case INVENTORY:
			return true;
		case ENTITY:
			return true;

		default:
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	public void renderBall(ItemStack stack) {
		int i = BlockColored.func_150032_b(stack.getItemDamage());
		GL11.glPushMatrix();
		GL11.glColor3f(EntitySheep.fleeceColorTable[i][0], EntitySheep.fleeceColorTable[i][1], EntitySheep.fleeceColorTable[i][2]);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		model.ball.render(0.0625F);
		GL11.glPopMatrix();
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

		switch (type) {
		case EQUIPPED: {
			GL11.glPushMatrix();
			float scale = 1.8F;
			GL11.glTranslatef(-0.55F, 2F, -0.7F);
			GL11.glScalef(scale, scale, scale);
			GL11.glRotatef(90F, 1, 0, 0);
			GL11.glRotatef(15F, 0, 1, 0);
			GL11.glRotatef(-15F, 0, 0, 1);
			GL11.glTranslatef(0.25F, 0F, 1F);
			GL11.glScalef(0.7F, 0.7F, 0.7F);
			renderBall(item);
			GL11.glPopMatrix();
			break;
		}
		case EQUIPPED_FIRST_PERSON: {
			GL11.glPushMatrix();
			float scale = 1.5F;
			GL11.glScalef(scale, scale, scale);
			GL11.glTranslatef(0F, -0.55F, 0.5F);
			renderBall(item);
			GL11.glPopMatrix();
			break;

		}
		case INVENTORY: {
			GL11.glPushMatrix();
			float scale = 2F;
			GL11.glScalef(scale, scale, scale);
			GL11.glTranslatef(0F, -1.25F, 0F);
			renderBall(item);
			GL11.glPopMatrix();
			break;
		}
		case ENTITY: {
			GL11.glPushMatrix();
			float scale = 1.3F;
			GL11.glScalef(scale, scale, scale);
			GL11.glRotatef(180F, 1, 0, 0);
			GL11.glRotatef(-90F, 0, 1, 0);
			GL11.glTranslatef(0F, -1.4F, 0F);
			renderBall(item);
			GL11.glPopMatrix();
			break;
		}
		default:
			break;
		}

	}
}
