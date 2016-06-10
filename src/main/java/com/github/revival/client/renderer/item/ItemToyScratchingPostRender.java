package com.github.revival.client.renderer.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.github.revival.client.model.ModelToyScratchingPost;

public class ItemToyScratchingPostRender implements IItemRenderer {

	protected ModelToyScratchingPost model;
	protected ResourceLocation texture = new ResourceLocation("fossil:textures/model/toy/scratching_post.png");

	public ItemToyScratchingPostRender() {
		model = new ModelToyScratchingPost();
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

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

		switch (type) {
		case EQUIPPED: {
			GL11.glPushMatrix();
			float scale = 0.9F;
			GL11.glTranslatef(0.3F, 0.8F, 0.4F);
			GL11.glScalef(scale, scale, scale);
			GL11.glRotatef(145F, 1, 0, 0);
			GL11.glRotatef(-15F, 0, 0, 1);
			GL11.glScalef(0.7F, 0.7F, 0.7F);
			GL11.glTranslatef(0F, -0.6F, 0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.render(0.0625F);
			GL11.glPopMatrix();
			break;
		}
		case EQUIPPED_FIRST_PERSON: {
			GL11.glPushMatrix();
			float scale = 1F;
			GL11.glTranslatef(0.7F, 1.2F, 0.8F);
			GL11.glRotatef(-160F, 0, 0, 1);
			GL11.glScalef(scale, scale, scale);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.render(0.0625F);
			GL11.glPopMatrix();
			break;

		}
		case INVENTORY: {
			GL11.glPushMatrix();
			float scale = 0.7F;
			GL11.glScalef(scale, scale, scale);
			GL11.glTranslatef(0, 0.6F, 0F);
			GL11.glRotatef(180F, 1, 0, 0);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.render(0.0625F);
			GL11.glPopMatrix();
			break;
		}
		case ENTITY: {
			GL11.glPushMatrix();
			float scale = 0.8F;
			GL11.glScalef(scale, scale, scale);
			GL11.glRotatef(180F, 1, 0, 0);
			GL11.glRotatef(-90F, 0, 1, 0);
			GL11.glTranslatef(0F, -1.4F, 0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.render(0.0625F);
			GL11.glPopMatrix();
			break;
		}
		default:
			break;
		}

	}
}
