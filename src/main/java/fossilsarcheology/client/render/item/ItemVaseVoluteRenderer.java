package fossilsarcheology.client.render.item;

import fossilsarcheology.client.model.ModelVaseVolute;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;

public class ItemVaseVoluteRenderer implements IItemRenderer {
    private static final ResourceLocation damaged_volute = new ResourceLocation("fossil:textures/blocks/vases/vase_damaged_volute.png");
    private static final ResourceLocation restored_volute = new ResourceLocation("fossil:textures/blocks/vases/vase_restored_volute.png");
    private static final ResourceLocation redFigure_volute = new ResourceLocation("fossil:textures/blocks/vases/vase_redFigure_volute.png");
    private static final ResourceLocation blackFigure_volute = new ResourceLocation("fossil:textures/blocks/vases/vase_blackFigure_volute.png");
    private static final ResourceLocation porcelain_volute = new ResourceLocation("fossil:textures/blocks/vases/vase_porcelain_volute.png");
    private static ModelVaseVolute model;

    public ItemVaseVoluteRenderer() {
        model = new ModelVaseVolute();

    }

    private static void bindTexture(ResourceLocation texture) {
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        // return true;
        return type != ItemRenderType.INVENTORY;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        int meta = item.getItemDamage();
        glPushMatrix();
        GL11.glTranslatef(0.0F, 2.3F, 0.7F);
        GL11.glRotatef(-180.0F, 0F, 0F, 1F);
        GL11.glRotatef(-80.0F, 0F, 1F, 0F);

        switch (meta) {
            case 0:
            default:
                bindTexture(damaged_volute);
                break;
            case 1:
                bindTexture(restored_volute);
                break;
            case 2:
                bindTexture(redFigure_volute);
                break;
            case 3:
                bindTexture(blackFigure_volute);
                break;
            case 4:
                bindTexture(porcelain_volute);
                break;
        }

        model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

        glPopMatrix();
    }
}