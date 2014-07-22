package mods.fossil.client.renderer.tileentity;

import mods.fossil.client.model.ModelVaseAmphora;
import mods.fossil.client.model.ModelVaseKylix;
import mods.fossil.client.model.ModelVaseVolute;
import mods.fossil.guiBlocks.TileEntityVase;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class TileEntityVaseRenderer extends TileEntitySpecialRenderer
{
    // the model of our block
    public final ModelVaseVolute modelVolute;
    public final ModelVaseAmphora modelAmphora;
    public final ModelVaseKylix modelKylix;
	private ModelBase proxyVase;

    // volute textures
    private static final ResourceLocation damaged_volute = new ResourceLocation("fossil:textures/blocks/vases/vase_damaged_volute.png");
    private static final ResourceLocation restored_volute = new ResourceLocation("fossil:textures/blocks/vases/vase_restored_volute.png");
    private static final ResourceLocation redFigure_volute = new ResourceLocation("fossil:textures/blocks/vases/vase_redFigure_volute.png");
    private static final ResourceLocation blackFigure_volute = new ResourceLocation("fossil:textures/blocks/vases/vase_blackFigure_volute.png");
    private static final ResourceLocation porcelain_volute = new ResourceLocation("fossil:textures/blocks/vases/vase_porcelain_volute.png");
    
    // amphora textures
    private static final ResourceLocation damaged_amphora = new ResourceLocation("fossil:textures/blocks/vases/vase_damaged_amphora.png");
    private static final ResourceLocation restored_amphora = new ResourceLocation("fossil:textures/blocks/vases/vase_restored_amphora.png");
    private static final ResourceLocation redFigure_amphora = new ResourceLocation("fossil:textures/blocks/vases/vase_redFigure_amphora.png");
    private static final ResourceLocation blackFigure_amphora = new ResourceLocation("fossil:textures/blocks/vases/vase_blackFigure_amphora.png");
    private static final ResourceLocation porcelain_amphora = new ResourceLocation("fossil:textures/blocks/vases/vase_porcelain_amphora.png");
    
    // kylix textures
    private static final ResourceLocation damaged_kylix = new ResourceLocation("fossil:textures/blocks/vases/vase_damaged_kylix.png");
    private static final ResourceLocation restored_kylix = new ResourceLocation("fossil:textures/blocks/vases/vase_restored_kylix.png");
    private static final ResourceLocation redFigure_kylix = new ResourceLocation("fossil:textures/blocks/vases/vase_redFigure_kylix.png");
    private static final ResourceLocation blackFigure_kylix = new ResourceLocation("fossil:textures/blocks/vases/vase_blackFigure_kylix.png");
    private static final ResourceLocation porcelain_kylix = new ResourceLocation("fossil:textures/blocks/vases/vase_porcelain_kylix.png");

    // also gets model of our block
    public TileEntityVaseRenderer()
    {
        this.modelVolute = new ModelVaseVolute();
        this.modelAmphora = new ModelVaseAmphora();
        this.modelKylix = new ModelVaseKylix();
    }

    // renders tileentity in world
    public void renderTileEntityFigurineAt(TileEntityVase te, double x, double y, double z, float scale)
    {
        // push matrix tells the renderer to start doing something
        GL11.glPushMatrix();
        // this sets the initial location
        GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
        // this rotates your block otherwise will render upside down
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 1.0F, 0.0F, 1.0F);
        rotateBlock(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord, te.blockType, te.getVaseTypeMeta(), te.getVaseType());
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    // rotates block
    private void rotateBlock(World world, int x, int y, int z, Block block, int meta, int vaseType)
    {
        if (world != null)
        {
            int dir = world.getBlockMetadata(x, y, z);
            GL11.glPushMatrix();
            // this line rotates renderer
            GL11.glRotatef(dir * (90), 0F, 1F, 0F);
            GL11.glScalef(1F, 1F, 1F);

            switch (vaseType)
            {
            case 0: default: this.proxyVase = this.modelVolute; 
            // gets the texture for model
            switch (meta)
            {
                case 0:
                default:
                    this.bindTexture(damaged_volute);
                    this.proxyVase.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;
                case 1:
                    this.bindTexture(restored_volute);
                    this.proxyVase.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;
                case 2:
                    this.bindTexture(redFigure_volute);
                    this.proxyVase.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;
                case 3:
                    this.bindTexture(blackFigure_volute);
                    this.proxyVase.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;
                case 4:
                    this.bindTexture(porcelain_volute);
                    this.proxyVase.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;             
            }
            break;
            case 1: this.proxyVase = this.modelAmphora; 
            // gets the texture for model
            switch (meta)
            {
                case 0:
                default:
                    this.bindTexture(damaged_amphora);
                    this.proxyVase.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;
                case 1:
                    this.bindTexture(restored_amphora);
                    this.proxyVase.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;
                case 2:
                    this.bindTexture(redFigure_amphora);
                    this.proxyVase.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;
                case 3:
                    this.bindTexture(blackFigure_amphora);
                    this.proxyVase.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;
                case 4:
                    this.bindTexture(porcelain_amphora);
                    this.proxyVase.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;
            }
            break;
            case 2: this.proxyVase = this.modelKylix; 
            // gets the texture for model
            switch (meta)
            {
                case 0:
                default:
                    this.bindTexture(damaged_kylix);
                    this.proxyVase.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;
                case 1:
                    this.bindTexture(restored_kylix);
                    this.proxyVase.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;
                case 2:
                    this.bindTexture(redFigure_kylix);
                    this.proxyVase.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;
                case 3:
                    this.bindTexture(blackFigure_kylix);
                    this.proxyVase.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;
                case 4:
                    this.bindTexture(porcelain_kylix);
                    this.proxyVase.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                    break;
            }
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
            FMLClientHandler.instance().getClient().renderEngine.bindTexture(damaged_volute);
            this.proxyVase.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
        }
    }

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double d0, double d1,
                                   double d2, float f)
    {
        this.renderTileEntityFigurineAt((TileEntityVase)tileentity, d0, d1, d2, f);
    }
}
