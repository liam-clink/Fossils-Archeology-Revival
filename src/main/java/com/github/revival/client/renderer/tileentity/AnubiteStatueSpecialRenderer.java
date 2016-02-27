package com.github.revival.client.renderer.tileentity;

import com.github.revival.client.model.AnubiteModel;
import com.github.revival.server.block.entity.AnubiteStatueTile;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;


public class AnubiteStatueSpecialRenderer extends TileEntitySpecialRenderer {

    public static final ResourceLocation texture = new ResourceLocation("fossil:textures/model/Anubite_ancient_statue.png");


    private AnubiteModel modelBlock;

    public AnubiteStatueSpecialRenderer() {
        this.modelBlock = new AnubiteModel();

    }

    public void renderAnuAt(AnubiteStatueTile tileentity, double x, double y, double z, float f) {
        int i1 = 0;
        if (tileentity.hasWorldObj()) {
            i1 = tileentity.getBlockMetadata();
        }
        short short1 = 0;
        if (i1 == 2) {

            short1 = 360;
        }

        if (i1 == 3) {
            short1 = 180;
        }

        if (i1 == 4) {
            short1 = 90;
        }

        if (i1 == 5) {
            short1 = -90;
        }

        GL11.glPushMatrix();
        GL11.glTranslatef(0f, 0f, 0f);
        GL11.glTranslated((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glRotatef(180, 0F, 0F, 1F);
        GL11.glRotatef((float) short1 * -1F, 0.0F, 1.0F, 0.0F);
        GL11.glPushMatrix();
        this.bindTexture(texture);
        this.modelBlock.renderBlock(0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
        this.renderAnuAt((AnubiteStatueTile) tileentity, x, y, z, f);
    }
}

//					
