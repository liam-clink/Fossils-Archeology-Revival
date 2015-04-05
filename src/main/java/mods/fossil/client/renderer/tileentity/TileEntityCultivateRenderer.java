package mods.fossil.client.renderer.tileentity;

import java.util.List;

import org.lwjgl.opengl.GL11;

import mods.fossil.Fossil;
import mods.fossil.client.model.ModelBlock;
import mods.fossil.client.model.ModelEmbryoGeneric;
import mods.fossil.guiBlocks.TileEntityCultivate;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;


public class TileEntityCultivateRenderer extends TileEntitySpecialRenderer {

	public static final ResourceLocation texture = new ResourceLocation("fossil:textures/blocks/cultureVat/culturevat.png");
	public static final ResourceLocation textureEmbryoBasic = new ResourceLocation("fossil:textures/blocks/cultureVat/embryo_Generic.png");

	private ModelEmbryoGeneric model;
	private ModelBlock modelBlock;

	public TileEntityCultivateRenderer(){
		this.model = new ModelEmbryoGeneric();
		this.modelBlock = new ModelBlock();

	}

	public void renderCultureVatAt(TileEntityCultivate tileentity, double x, double y, double z, float f) {

		float rot = 0.0F;
		if (tileentity.getWorldObj() != null)
		{
			rot = tileentity.getWorldObj().getWorldTime() % 360L;
		}
		GL11.glPushMatrix();
		GL11.glTranslatef(0f, 0f,0f);
		GL11.glTranslated((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		GL11.glPushMatrix();
		if(tileentity.isActive){
		GL11.glPushMatrix();
		GL11.glRotatef(rot, 0, 9, 0);
		this.bindTexture(textureEmbryoBasic);
		model.render(0.0625F);
		GL11.glPopMatrix();
		}
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		this.bindTexture(texture);
		this.modelBlock.render(0.0625F);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		this.renderCultureVatAt((TileEntityCultivate)tileentity, x, y, z, f);
	}
}

//					
