package mods.fossil.client.renderer.item;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import mods.fossil.client.model.ModelTNClock;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ItemAncientClocRender implements IItemRenderer {

	protected ModelTNClock model;
	protected ResourceLocation texture = new ResourceLocation("fossil:textures/blocks/TNClock.png");

	public ItemAncientClocRender(){
		model = new ModelTNClock();
	}
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch(type){
		case EQUIPPED: return true; 
		case EQUIPPED_FIRST_PERSON: return true;
		case INVENTORY: return true;
		case ENTITY: return true;

		default: return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		float rot =	(float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);

		switch(type){
		case EQUIPPED:{
			GL11.glPushMatrix();
			float scale = 1.8F;
			GL11.glTranslatef(-0.4F, 1.9F, 0.3F);
			GL11.glScalef(scale, scale, scale);
			GL11.glRotatef(90F, 1, 0, 0);
			GL11.glRotatef(15F, 0, 1, 0);
			GL11.glRotatef(-15F, 0, 0, 1);
			GL11.glTranslatef(0.25F, 0F, 1F);
			GL11.glScalef(0.7F, 0.7F, 0.7F);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.renderItem(0.0625F, rot);
			GL11.glPopMatrix();
			break;
		}
		case EQUIPPED_FIRST_PERSON:{
			GL11.glPushMatrix();
			float scale = 70F;
			GL11.glScalef(scale, scale, scale);
			GL11.glRotatef(180F, 1, 0, 0);
			GL11.glRotatef(-90F, 0, 1, 0);
			GL11.glTranslatef(-1.8F, -0.4F, -1.5F);
			GL11.glScalef(2, 2, 2);
			GL11.glRotatef(-90F, 0, 1, 0);

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.renderItem(0.0625F, rot);
			GL11.glPopMatrix();
			break;

		}
		case INVENTORY:{
			GL11.glPushMatrix();
			float scale = 20F;
			GL11.glScalef(scale, scale, scale);
			GL11.glRotatef(0F, 1, 0, 0);
			GL11.glRotatef(-180F, 0, 1, 0);
			GL11.glRotatef(0F, 0, 0, 1);
			GL11.glTranslatef(-0.4F, 0.4F, -0.1F);
			 GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
		      GL11.glEnable(GL11.GL_ALPHA_TEST);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.renderItem(0.0625F, rot);
			GL11.glPopAttrib();
			GL11.glPopMatrix();
			break;
		}
		case ENTITY:{
			GL11.glPushMatrix();
			float scale = 1.3F;
			GL11.glRotatef(rot, 0, 1, 0);
			GL11.glScalef(scale, scale, scale);
			GL11.glRotatef(180F, 1, 0, 0);
			GL11.glRotatef(-90F, 0, 1, 0);
			GL11.glTranslatef(0F, -0.24F, 0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.renderItem(0.0625F, rot);
			GL11.glPopMatrix();
			break;
		}
		default: break;
		}

	}
}
