package fossilsarcheology.client.render.item;

import fossilsarcheology.client.model.ModelToyScratchingPost;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

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
                GlStateManager.pushMatrix();
                float scale = 0.9F;
                GlStateManager.translate(0.3F, 0.8F, 0.4F);
                GlStateManager.scale(scale, scale, scale);
                GlStateManager.rotate(145F, 1, 0, 0);
                GlStateManager.rotate(-15F, 0, 0, 1);
                GlStateManager.scale(0.7F, 0.7F, 0.7F);
                GlStateManager.translate(0F, -0.6F, 0F);
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                model.render(0.0625F);
                GlStateManager.popMatrix();
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                GlStateManager.pushMatrix();
                float scale = 1F;
                GlStateManager.translate(0.7F, 1.2F, 0.8F);
                GlStateManager.rotate(-160F, 0, 0, 1);
                GlStateManager.scale(scale, scale, scale);
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                model.render(0.0625F);
                GlStateManager.popMatrix();
                break;

            }
            case INVENTORY: {
                GlStateManager.pushMatrix();
                float scale = 0.7F;
                GlStateManager.scale(scale, scale, scale);
                GlStateManager.translate(0, 0.6F, 0F);
                GlStateManager.rotate(180F, 1, 0, 0);
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                model.render(0.0625F);
                GlStateManager.popMatrix();
                break;
            }
            case ENTITY: {
                GlStateManager.pushMatrix();
                float scale = 0.8F;
                GlStateManager.scale(scale, scale, scale);
                GlStateManager.rotate(180F, 1, 0, 0);
                GlStateManager.rotate(-90F, 0, 1, 0);
                GlStateManager.translate(0F, -1.4F, 0F);
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                model.render(0.0625F);
                GlStateManager.popMatrix();
                break;
            }
            default:
                break;
        }

    }
}
