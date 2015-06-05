package mods.fossil.client.renderer.entity;

import java.util.UUID;

import mods.fossil.client.model.ModelBrachiosaurus;
import mods.fossil.client.model.ModelCompsognathus;
import mods.fossil.client.model.ModelDeinonychus;
import mods.fossil.client.model.ModelDilophosaurus;
import mods.fossil.client.model.ModelNautilus;
import mods.fossil.client.model.ModelSpinosaurus;
import mods.fossil.client.model.ModelTRex;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class RenderFollowers extends RenderPlayer {

	public ModelDilophosaurus model_Alexthe666_1 = new ModelDilophosaurus();
	public ModelSpinosaurus model_Bluestreak52 = new ModelSpinosaurus();
	public ModelTRex model_tyranno66 = new ModelTRex();
	public ModelDeinonychus model_Raptorfarian = new ModelDeinonychus();
	public ModelBrachiosaurus model_Robberto08 = new ModelBrachiosaurus();
	public ModelCompsognathus model_NanoTyrano = new ModelCompsognathus();

	public UUID alexID = UUID.fromString("71363abe-fd03-49c9-940d-aae8b8209b7c");
	public UUID redID = UUID.fromString("5468a8f2-84d6-46e2-b58c-f9d576b67544");
	public UUID tyrannoID = UUID.fromString("04e6d7f5-b587-4e4f-8ce0-b210d368a79e");
	public UUID raptorID = UUID.fromString("0ed918c8-d612-4360-b711-cd415671356f");
	public UUID robbID = UUID.fromString("05b14ce7-0ff1-4b8e-9ef8-d98502e9bf07");
	public UUID nanoID = UUID.fromString("d4c29faf-82bc-4d34-bda0-cb850595595a");


	public void doRender(AbstractClientPlayer player, double x, double y, double z, float yaw, float unknownFloat)
	{
		float f2 = this.interpolateRotation(player.prevRenderYawOffset, player.renderYawOffset, unknownFloat);
		float f3 = this.interpolateRotation(player.prevRotationYawHead, player.rotationYawHead, unknownFloat);
		float f4;

		if (player.isRiding() && player.ridingEntity instanceof EntityLivingBase)
		{
			EntityLivingBase entitylivingbase1 = (EntityLivingBase)player.ridingEntity;
			f2 = this.interpolateRotation(entitylivingbase1.prevRenderYawOffset, entitylivingbase1.renderYawOffset, unknownFloat);
			f4 = MathHelper.wrapAngleTo180_float(f3 - f2);

			if (f4 < -85.0F)
			{
				f4 = -85.0F;
			}

			if (f4 >= 85.0F)
			{
				f4 = 85.0F;
			}

			f2 = f3 - f4;

			if (f4 * f4 > 2500.0F)
			{
				f2 += f4 * 0.2F;
			}
		}

		float f13 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * unknownFloat;
		f4 = this.handleRotationFloat(player, unknownFloat);
		float f5 = 0.0625F;
		float f6 = player.prevLimbSwingAmount + (player.limbSwingAmount - player.prevLimbSwingAmount) * unknownFloat;
		float f7 = player.limbSwing - player.limbSwingAmount * (1.0F - unknownFloat);

		if (player.isChild())
		{
			f7 *= 3.0F;
		}

		if (f6 > 1.0F)
		{
			f6 = 1.0F;
		}
		if(player.getUniqueID().equals(alexID)){
			GL11.glPushMatrix();
			GL11.glTranslatef(0, 0.8F, 0);
			GL11.glScalef(0.3F, 0.3F, 0.3F);
			GL11.glRotatef(180, 1, 0, 0);
			GL11.glRotatef(player.rotationYawHead, 0, 1, 0);
			GL11.glPushMatrix();
			FMLClientHandler.instance().getClient().getTextureManager().bindTexture(new ResourceLocation("fossil:textures/mob/Dilophosaurus/Dilophosaurus_Adult.png"));
			model_Alexthe666_1.render(player, f7, f6, f4, f3 - f2, f13, f5);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		}

		if(player.getUniqueID().equals(redID)){
			GL11.glPushMatrix();
			GL11.glTranslatef(0, 0.8F, 0);
			GL11.glScalef(0.3F, 0.3F, 0.3F);
			GL11.glRotatef(180, 1, 0, 0);
			GL11.glRotatef(player.rotationYawHead, 0, 1, 0);
			GL11.glPushMatrix();
			FMLClientHandler.instance().getClient().getTextureManager().bindTexture(new ResourceLocation("fossil:textures/mob/Spinosaurus_Adult.png"));
			model_Bluestreak52.render(player, f7, f6, f4, f3 - f2, f13, f5);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		}

		if(player.getUniqueID().equals(tyrannoID)){
			GL11.glPushMatrix();
			GL11.glTranslatef(0, 0.8F, 0);
			GL11.glScalef(0.3F, 0.3F, 0.3F);
			GL11.glRotatef(180, 1, 0, 0);
			GL11.glRotatef(player.rotationYawHead, 0, 1, 0);
			GL11.glPushMatrix();
			FMLClientHandler.instance().getClient().getTextureManager().bindTexture(new ResourceLocation("fossil:textures/mob/TRex/feathered/Feathered_TRex_Adult.png"));
			model_tyranno66.render(player, f7, f6, f4, f3 - f2, f13, f5);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		}
		if(player.getUniqueID().equals(raptorID)){
			GL11.glPushMatrix();
			GL11.glTranslatef(0, 0.8F, 0);
			GL11.glScalef(0.3F, 0.3F, 0.3F);
			GL11.glRotatef(180, 1, 0, 0);
			GL11.glRotatef(player.rotationYawHead, 0, 1, 0);
			GL11.glPushMatrix();
			FMLClientHandler.instance().getClient().getTextureManager().bindTexture(new ResourceLocation("fossil:textures/mob/Deinonychus/feathered/Feathered_Deinonychus_Grey_Adult.png"));
			model_Raptorfarian.render(player, f7, f6, f4, f3 - f2, f13, f5);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		}
		if(player.getUniqueID().equals(robbID)){
			GL11.glPushMatrix();
			GL11.glTranslatef(0, 0.8F, 0);
			GL11.glScalef(0.3F, 0.3F, 0.3F);
			GL11.glRotatef(180, 1, 0, 0);
			GL11.glRotatef(player.rotationYawHead, 0, 1, 0);
			GL11.glPushMatrix();
			FMLClientHandler.instance().getClient().getTextureManager().bindTexture(new ResourceLocation("fossil:textures/mob/Brachiosaurus.png"));
			model_Robberto08.render(player, f7, f6, f4, f3 - f2, f13, f5);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		}
		if(player.getUniqueID().equals(nanoID)){
			GL11.glPushMatrix();
			GL11.glTranslatef(0F, 0.9F, 0);
			GL11.glScalef(0.4F, 0.4F, 0.4F);
			GL11.glRotatef(180, 1, 0, 0);
			GL11.glRotatef(player.rotationYawHead, 0, 1, 0);
			GL11.glTranslatef(-0.0625F, 0.0F, 0);

			GL11.glPushMatrix();
			FMLClientHandler.instance().getClient().getTextureManager().bindTexture(new ResourceLocation("fossil:textures/mob/Compsognathus/feathered/Feathered_Compsognathus_Green.png"));
			model_NanoTyrano.render(player, f7, f6, f4, f3 - f2, f13, f5);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		}
		super.doRender(player, x, y, z, yaw, unknownFloat);
	}

	private float interpolateRotation(float x, float y, float i)
	{
		float f3;

		for (f3 = y - x; f3 < -180.0F; f3 += 360.0F)
		{
			;
		}

		while (f3 >= 180.0F)
		{
			f3 -= 360.0F;
		}

		return x + i * f3;
	}
}
