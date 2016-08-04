package fossilsarcheology.client.render.item;

import fossilsarcheology.client.model.ModelToyBall;
import net.minecraft.block.BlockColored;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

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
        GlStateManager.pushMatrix();
        GlStateManager.color(EntitySheep.fleeceColorTable[i][0], EntitySheep.fleeceColorTable[i][1], EntitySheep.fleeceColorTable[i][2]);
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        model.ball.render(0.0625F);
        GlStateManager.popMatrix();
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

        switch (type) {
            case EQUIPPED: {
                GlStateManager.pushMatrix();
                float scale = 1.8F;
                GlStateManager.translate(-0.55F, 2F, -0.7F);
                GlStateManager.scale(scale, scale, scale);
                GlStateManager.rotate(90F, 1, 0, 0);
                GlStateManager.rotate(15F, 0, 1, 0);
                GlStateManager.rotate(-15F, 0, 0, 1);
                GlStateManager.translate(0.25F, 0F, 1F);
                GlStateManager.scale(0.7F, 0.7F, 0.7F);
                renderBall(item);
                GlStateManager.popMatrix();
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                GlStateManager.pushMatrix();
                float scale = 1.5F;
                GlStateManager.scale(scale, scale, scale);
                GlStateManager.translate(0F, -0.55F, 0.5F);
                renderBall(item);
                GlStateManager.popMatrix();
                break;

            }
            case INVENTORY: {
                GlStateManager.pushMatrix();
                float scale = 2F;
                GlStateManager.scale(scale, scale, scale);
                GlStateManager.translate(0F, -1.25F, 0F);
                renderBall(item);
                GlStateManager.popMatrix();
                break;
            }
            case ENTITY: {
                GlStateManager.pushMatrix();
                float scale = 1.3F;
                GlStateManager.scale(scale, scale, scale);
                GlStateManager.rotate(180F, 1, 0, 0);
                GlStateManager.rotate(-90F, 0, 1, 0);
                GlStateManager.translate(0F, -1.4F, 0F);
                renderBall(item);
                GlStateManager.popMatrix();
                break;
            }
            default:
                break;
        }

    }
}
