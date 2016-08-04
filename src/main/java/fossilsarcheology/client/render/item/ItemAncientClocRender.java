package fossilsarcheology.client.render.item;

import fossilsarcheology.client.model.ModelTNClock;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ItemAncientClocRender implements IItemRenderer {

    protected ModelTNClock model;
    protected ResourceLocation texture = new ResourceLocation("fossil:textures/blocks/TNClock.png");

    public ItemAncientClocRender() {
        model = new ModelTNClock();
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
        float rot = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);

        switch (type) {
            case EQUIPPED: {
                GlStateManager.pushMatrix();
                float scale = 1.8F;
                GlStateManager.translate(-0.4F, 1.9F, 0.3F);
                GlStateManager.scale(scale, scale, scale);
                GlStateManager.rotate(90F, 1, 0, 0);
                GlStateManager.rotate(15F, 0, 1, 0);
                GlStateManager.rotate(-15F, 0, 0, 1);
                GlStateManager.translate(0.25F, 0F, 1F);
                GlStateManager.scale(0.7F, 0.7F, 0.7F);
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                model.renderItem(0.0625F, rot);
                GlStateManager.popMatrix();
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                GlStateManager.pushMatrix();
                float scale = 70F;
                GlStateManager.scale(scale, scale, scale);
                GlStateManager.rotate(180F, 1, 0, 0);
                GlStateManager.rotate(-90F, 0, 1, 0);
                GlStateManager.translate(-1.8F, -0.4F, -1.5F);
                GlStateManager.scale(2, 2, 2);
                GlStateManager.rotate(-90F, 0, 1, 0);

                Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                model.renderItem(0.0625F, rot);
                GlStateManager.popMatrix();
                break;

            }
            case INVENTORY: {
                GlStateManager.pushMatrix();
                float scale = 20F;
                GlStateManager.scale(scale, scale, scale);
                GlStateManager.rotate(0F, 1, 0, 0);
                GlStateManager.rotate(-180F, 0, 1, 0);
                GlStateManager.rotate(0F, 0, 0, 1);
                GlStateManager.translate(-0.4F, 0.4F, -0.1F);
                GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
                GL11.glEnable(GL11.GL_ALPHA_TEST);
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                model.renderItem(0.0625F, rot);
                GL11.glPopAttrib();
                GlStateManager.popMatrix();
                break;
            }
            case ENTITY: {
                GlStateManager.pushMatrix();
                float scale = 1.3F;
                GlStateManager.rotate(rot, 0, 1, 0);
                GlStateManager.scale(scale, scale, scale);
                GlStateManager.rotate(180F, 1, 0, 0);
                GlStateManager.rotate(-90F, 0, 1, 0);
                GlStateManager.translate(0F, -0.24F, 0F);
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                model.renderItem(0.0625F, rot);
                GlStateManager.popMatrix();
                break;
            }
            default:
                break;
        }

    }
}
