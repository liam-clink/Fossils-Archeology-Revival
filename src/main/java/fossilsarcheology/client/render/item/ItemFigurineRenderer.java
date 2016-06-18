package fossilsarcheology.client.render.item;

import fossilsarcheology.client.model.ModelFigurine;
import fossilsarcheology.client.model.ModelFigurineBroken;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;

public class ItemFigurineRenderer implements IItemRenderer {
    // the model texture of our block
    private static final ResourceLocation pristine_steve = new ResourceLocation("fossil:textures/blocks/figurines/figurine_steve_pristine.png");
    private static final ResourceLocation pristine_skeleton = new ResourceLocation("fossil:textures/blocks/figurines/figurine_skeleton_pristine.png");
    private static final ResourceLocation pristine_zombie = new ResourceLocation("fossil:textures/blocks/figurines/figurine_zombie_pristine.png");
    private static final ResourceLocation pristine_enderman = new ResourceLocation("fossil:textures/blocks/figurines/figurine_enderman_pristine.png");
    private static final ResourceLocation pristine_zombiepig = new ResourceLocation("fossil:textures/blocks/figurines/figurine_pigzombie_pristine.png");
    private static final ResourceLocation damaged_steve = new ResourceLocation("fossil:textures/blocks/figurines/figurine_steve_damaged.png");
    private static final ResourceLocation damaged_skeleton = new ResourceLocation("fossil:textures/blocks/figurines/figurine_skeleton_damaged.png");
    private static final ResourceLocation damaged_zombie = new ResourceLocation("fossil:textures/blocks/figurines/figurine_zombie_damaged.png");
    private static final ResourceLocation damaged_enderman = new ResourceLocation("fossil:textures/blocks/figurines/figurine_enderman_damaged.png");
    private static final ResourceLocation damaged_zombiepig = new ResourceLocation("fossil:textures/blocks/figurines/figurine_pigzombie_damaged.png");
    private static final ResourceLocation broken_steve = new ResourceLocation("fossil:textures/blocks/figurines/figurine_steve_broken.png");
    private static final ResourceLocation broken_skeleton = new ResourceLocation("fossil:textures/blocks/figurines/figurine_skeleton_broken.png");
    private static final ResourceLocation broken_zombie = new ResourceLocation("fossil:textures/blocks/figurines/figurine_zombie_broken.png");
    private static final ResourceLocation broken_enderman = new ResourceLocation("fossil:textures/blocks/figurines/figurine_enderman_broken.png");
    private static final ResourceLocation broken_zombiepig = new ResourceLocation("fossil:textures/blocks/figurines/figurine_pigzombie_broken.png");
    private static final ResourceLocation mysterious = new ResourceLocation("fossil:textures/blocks/figurines/figurine_mysterious.png");
    private static ModelFigurine modelfigurine;
    private static ModelFigurineBroken modelbroken;

    public ItemFigurineRenderer() {
        modelfigurine = new ModelFigurine();
        modelbroken = new ModelFigurineBroken();

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
                bindTexture(pristine_steve);
                break;
            case 1:
                bindTexture(pristine_skeleton);
                break;
            case 2:
                bindTexture(pristine_zombie);
                break;
            case 3:
                bindTexture(pristine_enderman);
                break;
            case 4:
                bindTexture(pristine_zombiepig);
                break;
            case 5:
                bindTexture(damaged_steve);
                break;
            case 6:
                bindTexture(damaged_skeleton);
                break;
            case 7:
                bindTexture(damaged_zombie);
                break;
            case 8:
                bindTexture(damaged_enderman);
                break;
            case 9:
                bindTexture(damaged_zombiepig);
                break;
            case 10:
                bindTexture(broken_steve);
                break;
            case 11:
                bindTexture(broken_skeleton);
                break;
            case 12:
                bindTexture(broken_zombie);
                break;
            case 13:
                bindTexture(broken_enderman);
                break;
            case 14:
                bindTexture(broken_zombiepig);
                break;
            case 15:
                bindTexture(mysterious);
                break;
        }

        if (meta < 10 || meta == 15) {
            modelfigurine.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        } else {
            modelbroken.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        }

        glPopMatrix();
    }
}