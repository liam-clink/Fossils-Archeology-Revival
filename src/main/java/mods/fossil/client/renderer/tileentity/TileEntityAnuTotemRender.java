package mods.fossil.client.renderer.tileentity;

import java.util.List;

import org.lwjgl.opengl.GL11;

import mods.fossil.Fossil;
import mods.fossil.client.model.ModelAnuTotem;
import mods.fossil.client.model.ModelBlock;
import mods.fossil.client.model.ModelEmbryoGeneric;
import mods.fossil.guiBlocks.TileEntityAnuTotem;
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


public class TileEntityAnuTotemRender extends TileEntitySpecialRenderer {

	public static final ResourceLocation texture = new ResourceLocation("fossil:textures/blocks/anuTotem.png");
	

	private ModelAnuTotem modelBlock;

	public TileEntityAnuTotemRender(){
		this.modelBlock = new ModelAnuTotem();

	}

	public void renderAnuAt(TileEntityAnuTotem tileentity, double x, double y, double z, float f) {
		int i1 = 0;
		if (tileentity.hasWorldObj())
		{
			i1 = tileentity.getBlockMetadata();
		}
		short short1 = 0;
		if (i1 == 2)
		{

			short1 = 360;
		}

		if (i1 == 3){
			short1 = 180;
		}

		if (i1 == 4)
		{
			short1 = 90;
		}

		if (i1 == 5)
		{
			short1 = -90;
		}
		
		GL11.glPushMatrix();
		GL11.glTranslatef(0f, 0f,0f);
		GL11.glTranslated((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		GL11.glRotatef((float)short1 * -1F, 0.0F, 1.0F, 0.0F);
		GL11.glPushMatrix();
		this.bindTexture(texture);
		this.modelBlock.renderBlock(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		this.renderAnuAt((TileEntityAnuTotem)tileentity, x, y, z, f);
	}
}

//					
