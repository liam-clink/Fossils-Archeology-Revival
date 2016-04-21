package com.github.revival.client.renderer.item;

import net.minecraft.block.BlockColored;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.github.revival.client.model.ModelToyTetheredLog;

public class ItemToyTetheredBallRender implements IItemRenderer {

    protected ModelToyTetheredLog model;
    protected ResourceLocation texture = new ResourceLocation("fossil:textures/model/toy/log_swing.png");

    public ItemToyTetheredBallRender() {
        model = new ModelToyTetheredLog();
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
        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

        switch (type) {
            case EQUIPPED: {
                GL11.glPushMatrix();
                float scale = 0.9F;
                GL11.glTranslatef(0.3F, 0.5F, -0.2F);
                GL11.glScalef(scale, scale, scale);
                GL11.glRotatef(145F, 1, 0, 0);
                GL11.glRotatef(-15F, 0, 0, 1);
                GL11.glScalef(0.7F, 0.7F, 0.7F);
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                model.rope0.render(0.0625F);
                GL11.glPopMatrix();
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
            	GL11.glPushMatrix();
                float scale = 1F;
                GL11.glTranslatef(0.7F, 1.6F, 0.8F);
                GL11.glRotatef(-160F, 0, 0, 1);
                GL11.glScalef(scale, scale, scale);
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                model.rope0.render(0.0625F);
                GL11.glPopMatrix();
                break;

            }
            case INVENTORY: {
                GL11.glPushMatrix();
                float scale = 9F;
                GL11.glScalef(scale, scale, scale);
                GL11.glRotatef(-90F, 0, 1, 0);
                GL11.glTranslatef(1.5F, 0.4F, -0.85F);
                GL11.glRotatef(45F, 0, 0, -1);
                GL11.glRotatef(45F, 0, 1, 0);
                GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
                GL11.glEnable(GL11.GL_ALPHA_TEST);
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                model.rope0.render(0.0625F);
                GL11.glPopAttrib();
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
                model.rope0.render(0.0625F);
                GL11.glPopMatrix();
                break;
            }
            default:
                break;
        }

    }
}
