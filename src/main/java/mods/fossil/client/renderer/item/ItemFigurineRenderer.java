package mods.fossil.client.renderer.item;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import mods.fossil.client.model.ModelFigurine;
import mods.fossil.client.model.ModelFigurineBroken;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemFigurineRenderer implements IItemRenderer
{
    private static ModelFigurine modelfigurine;
    private static ModelFigurineBroken modelbroken;
    
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

    public ItemFigurineRenderer()
    {
        modelfigurine = new ModelFigurine();
        modelbroken = new ModelFigurineBroken();

    }

    private static void bindTexture(ResourceLocation texture){
    	Minecraft.getMinecraft().renderEngine.bindTexture(texture);
	}

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        //return true;
        return type != ItemRenderType.INVENTORY;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
    	int meta = item.getItemDamage();
    	glPushMatrix();
    	GL11.glTranslatef(0.0F, 2.3F, 0.7F);
    	GL11.glRotatef(-180.0F, 0F, 0F, 1F);
    	GL11.glRotatef(-80.0F, 0F, 1F, 0F);
    	
        switch (meta)
        {
            case 0: default: this.bindTexture(pristine_steve); break;
            case 1: this.bindTexture(pristine_skeleton); break;
            case 2: this.bindTexture(pristine_zombie); break;
            case 3: this.bindTexture(pristine_enderman); break;
            case 4: this.bindTexture(pristine_zombiepig); break;
            case 5: this.bindTexture(damaged_steve); break;
            case 6: this.bindTexture(damaged_skeleton); break;          	
            case 7: this.bindTexture(damaged_zombie); break;
            case 8: this.bindTexture(damaged_enderman); break;
            case 9: this.bindTexture(damaged_zombiepig); break;
            case 10: this.bindTexture(broken_steve); break;
            case 11: this.bindTexture(broken_skeleton); break;
            case 12: this.bindTexture(broken_zombie); break;
            case 13: this.bindTexture(broken_enderman); break;
            case 14: this.bindTexture(broken_zombiepig); break;
            case 15: this.bindTexture(mysterious); break;
        }
        
        if (meta < 10 || meta == 15)
        	this.modelfigurine.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        else
        	this.modelbroken.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        
        glPopMatrix();
    }
}