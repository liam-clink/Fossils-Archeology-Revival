package mods.fossil.client.renderer.tileentity;

import cpw.mods.fml.client.FMLClientHandler;
import mods.fossil.client.model.ModelFigurine;
import mods.fossil.client.model.ModelFigurineBroken;
import mods.fossil.guiBlocks.TileEntityFigurine;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class TileEntityFigurineRenderer extends TileEntitySpecialRenderer
{
    // the model of our block
    public final ModelFigurine model;
    public final ModelFigurineBroken modelbroken;

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

    // also gets model of our block
    public TileEntityFigurineRenderer()
    {
        this.model = new ModelFigurine();
        this.modelbroken = new ModelFigurineBroken();
    }

    // renders tileentity in world
    public void renderTileEntityFigurineAt(TileEntityFigurine te, double x, double y, double z, float scale)
    {
        // push matrix tells the renderer to start doing something
        GL11.glPushMatrix();
        // this sets the initial location
        GL11.glTranslatef((float)x + 0.5F, (float)y + 0.75F, (float)z + 0.5F);
        // this rotates your block otherwise will render upside down
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 1.0F, 0.0F, 1.0F);
        rotateBlock(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord, te.blockType, te.getFigurineType());
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    // rotates block
    private void rotateBlock(World world, int x, int y, int z, Block block, int par6)
    {
        if (world != null)
        {
            int dir = world.getBlockMetadata(x, y, z);
            GL11.glPushMatrix();
            // this line rotates renderer
            GL11.glRotatef(dir * (90), 0F, 1F, 0F);
            GL11.glScalef(0.5F, 0.5F, 0.5F);

            // gets the texture for model
            switch (par6)
            {
                case 0:
                default:
                    this.bindTexture(pristine_steve);
                    this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;

                case 1:
                    this.bindTexture(pristine_skeleton);
                    this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;

                case 2:
                    this.bindTexture(pristine_zombie);
                    this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;

                case 3:
                    this.bindTexture(pristine_enderman);
                    this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;

                case 4:
                    this.bindTexture(pristine_zombiepig);
                    this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;

                case 5:
                    this.bindTexture(damaged_steve);
                    this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;

                case 6:
                    this.bindTexture(damaged_skeleton);
                    this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;

                case 7:
                    this.bindTexture(damaged_zombie);
                    this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;

                case 8:
                    this.bindTexture(damaged_enderman);
                    this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;

                case 9:
                    this.bindTexture(damaged_zombiepig);
                    this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;

                case 10:
                    this.bindTexture(broken_steve);
                    this.modelbroken.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;

                case 11:
                    this.bindTexture(broken_skeleton);
                    this.modelbroken.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;

                case 12:
                    this.bindTexture(broken_zombie);
                    this.modelbroken.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;

                case 13:
                    this.bindTexture(broken_enderman);
                    this.modelbroken.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;

                case 14:
                    this.bindTexture(broken_zombiepig);
                    this.modelbroken.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;

                case 15:
                    this.bindTexture(mysterious);
                    this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;
            }

            // renders the model
            //this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
        }
        else
        {
            GL11.glPushMatrix();
            GL11.glRotatef(0F, 0F, 1F, 0F);
            FMLClientHandler.instance().getClient().renderEngine.bindTexture(pristine_steve);
            this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
        }
    }

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double d0, double d1,
                                   double d2, float f)
    {
        this.renderTileEntityFigurineAt((TileEntityFigurine)tileentity, d0, d1, d2, f);
    }
}
