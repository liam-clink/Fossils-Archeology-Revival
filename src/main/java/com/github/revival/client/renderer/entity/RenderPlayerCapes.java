package com.github.revival.client.renderer.entity;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;

import java.util.UUID;

@SideOnly(Side.CLIENT)
public class RenderPlayerCapes
{

	/*
     * Renders the cape on the player if they are in the array
	 */


    public UUID[] devuuid = new UUID[]{
			/*tyranno66*/UUID.fromString("04e6d7f5-b587-4e4f-8ce0-b210d368a79e"),
			/*Raptorfarian*/UUID.fromString("0ed918c8-d612-4360-b711-cd415671356f"),
			/*4f6f3b*/UUID.fromString("0248b8a4-7fab-4d6f-8a22-8a51534fd53f"),
			/*Bluestreak52*/UUID.fromString("5468a8f2-84d6-46e2-b58c-f9d576b67544"),
			/*Robberto08*/UUID.fromString("05b14ce7-0ff1-4b8e-9ef8-d98502e9bf07"),
			/*Alexthe666*/UUID.fromString("71363abe-fd03-49c9-940d-aae8b8209b7c"),
			/*NanoTyrano*/UUID.fromString("d4c29faf-82bc-4d34-bda0-cb850595595a"),
			/*iLexiconn*/UUID.fromString("40e85e42-21f6-46b6-b5b3-6aeb07f3e3fd")
    };
    public UUID[] contributoruuid = new UUID[]{
			/*JTGhawk137*/UUID.fromString("54201149-1f1f-498b-98ca-50f66951a68f"),
			/*cyborx25*/UUID.fromString("c1637beb-4336-42f2-ad0b-a7188cf13042"),
			/*ExDragonith*/UUID.fromString("a7970406-e0ac-446b-8fe0-d42c94b594ea"),
			/*duckdude173*/UUID.fromString("12bde8ed-cfe9-49ac-af14-71762a3f49db"),
			/*whitejoshman*/UUID.fromString("28bcc73a-2726-49e8-ac1b-f02dbbb0c83b"),
			/*Shadowbeast007*/UUID.fromString("df3d1115-6601-4346-a063-f1254bf5a069"),
			/*MicroJunk*/UUID.fromString("d1c57f9a-069b-46af-b9ee-44ab0fce1d80")
    };
/*	@SubscribeEvent
    public void playerRender(RenderPlayerEvent.Specials.Pre e) {
		
		if(e.entityPlayer instanceof AbstractClientPlayer&& isDeveloper(e.entityPlayer.getUniqueID())){
			e.setCanceled(true);
		}
		
		double x = e.entityPlayer.posX;
		 double y = e.entityPlayer.posY;
		 double z = e.entityPlayer.posZ;
		 float yaw = e.entityPlayer.rotationYaw;
		 RenderFollowers.doRender(e.entityPlayer, x, y, z, yaw, 0.0625F);
	/*	float tick = 0;
		float unknown = 0.0625F;
		float f2 = this.interpolateRotation(e.entityPlayer.prevRenderYawOffset, e.entityPlayer.renderYawOffset, unknown);
		float f3 = this.interpolateRotation(e.entityPlayer.prevRotationYawHead, e.entityPlayer.rotationYawHead,  unknown);
		float f4;

		if (e.entityPlayer.isRiding() && e.entityPlayer.ridingEntity instanceof EntityLivingBase)
		{
			EntityLivingBase entitylivingbase1 = (EntityLivingBase)e.entityPlayer.ridingEntity;
			f2 = this.interpolateRotation(entitylivingbase1.prevRenderYawOffset, entitylivingbase1.renderYawOffset,  unknown);
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
			float f13 = e.entityPlayer.prevRotationPitch + (e.entityPlayer.rotationPitch - e.entityPlayer.prevRotationPitch) * unknown;

			if (e.entityPlayer instanceof AbstractClientPlayer) {
				RenderHelper.disableStandardItemLighting();
				GL11.glPushMatrix();
				//Alexthe666
				if(e.entityPlayer.getUniqueID().equals(alexID)){
					GL11.glPushMatrix();
					GL11.glScalef(0.03F, 0.03F, 0.03F);

					GL11.glRotatef(180F, 1, 0, 0);
					GL11.glRotatef(tick, 0, 0.5F, 0);
					GL11.glTranslatef(0, -30F, 0);
					GL11.glPushMatrix();
					FMLClientHandler.instance().getClient().getTextureManager().bindTexture(new ResourceLocation("fossil:textures/mob/Dilophosaurus/Dilophosaurus_Adult.png"));
					model_Alexthe666_1.renderFollower(0.625F, f3 - f2, f13);
					GL11.glPopMatrix();
					GL11.glPopMatrix();

				}
				if(e.entityPlayer.getUniqueID().equals(redID)){
					GL11.glPushMatrix();
					GL11.glScalef(0.03F, 0.03F, 0.03F);
					GL11.glRotatef(180F, 1, 0, 0);
					GL11.glRotatef(tick, 0, 0.5F, 0);
					GL11.glTranslatef(0, -30F, 0);
					GL11.glPushMatrix();
					FMLClientHandler.instance().getClient().getTextureManager().bindTexture(new ResourceLocation("fossil:textures/mob/Spinosaurus_Adult.png"));
					model_Bluestreak52.renderFollower(0.625F);
					GL11.glPopMatrix();
					GL11.glPopMatrix();

				}
				if(e.entityPlayer.getUniqueID().equals(tyrannoID)){
					GL11.glPushMatrix();
					GL11.glScalef(0.03F, 0.03F, 0.03F);
					GL11.glRotatef(180F, 1, 0, 0);
					GL11.glRotatef(tick, 0, 0.5F, 0);
					GL11.glTranslatef(0, -30F, 0);
					GL11.glPushMatrix();
					FMLClientHandler.instance().getClient().getTextureManager().bindTexture(new ResourceLocation("fossil:textures/mob/TRex/feathered/Feathered_TRex_Adult.png"));
					model_tyranno66.renderFollower(0.625F);
					GL11.glPopMatrix();
					GL11.glPopMatrix();

				}
				if(e.entityPlayer.getUniqueID().equals(raptorID)){
					GL11.glPushMatrix();
					GL11.glScalef(0.03F, 0.03F, 0.03F);
					GL11.glRotatef(180F, 1, 0, 0);
					GL11.glRotatef(tick, 0, 0.5F, 0);
					GL11.glTranslatef(0, -30F, 0);
					GL11.glPushMatrix();
					FMLClientHandler.instance().getClient().getTextureManager().bindTexture(new ResourceLocation("fossil:textures/mob/Deinonychus/feathered/Feathered_Deinonychus_Grey_Adult.png"));
					model_Raptorfarian.renderFollower(0.625F);
					GL11.glPopMatrix();
					GL11.glPopMatrix();

				}
				if(e.entityPlayer.getUniqueID().equals(robbID)){
					GL11.glPushMatrix();
					GL11.glScalef(0.03F, 0.03F, 0.03F);
					GL11.glRotatef(180F, 1, 0, 0);
					GL11.glRotatef(tick, 0, 0.5F, 0);
					GL11.glTranslatef(0, -30F, 0);
					GL11.glPushMatrix();
					FMLClientHandler.instance().getClient().getTextureManager().bindTexture(new ResourceLocation("fossil:textures/mob/Brachiosaurus.png"));
					model_Robberto08.renderFollower(0.625F);
					GL11.glPopMatrix();
					GL11.glPopMatrix();

				}
				if(e.entityPlayer.getUniqueID().equals(nanoID)){
					GL11.glPushMatrix();
					GL11.glScalef(0.03F, 0.03F, 0.03F);
					GL11.glRotatef(180F, 1, 0, 0);
					GL11.glRotatef(tick, 0, 0.5F, 0);
					GL11.glTranslatef(0, -30F, 0);
					GL11.glPushMatrix();
					FMLClientHandler.instance().getClient().getTextureManager().bindTexture(new ResourceLocation("fossil:textures/mob/Nautilus.png"));
					model_NanoTyrano.renderFollower(0.625F);
					GL11.glPopMatrix();
					GL11.glPopMatrix();

				}
				GL11.glPopMatrix();
				RenderHelper.enableStandardItemLighting();
			}
		}
	}*/

    @SubscribeEvent
    public void playerRender(RenderPlayerEvent.Pre e)
    {
        float tick = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);

        if (e.entityPlayer instanceof AbstractClientPlayer
                && isDeveloper(e.entityPlayer.getUniqueID()))
        {
            ((AbstractClientPlayer) e.entityPlayer).func_152121_a(
                    MinecraftProfileTexture.Type.CAPE, new ResourceLocation(
                            "fossil", "textures/FossilCape.png"));
        }

        else if (e.entityPlayer instanceof AbstractClientPlayer
                && isContributor(e.entityPlayer.getUniqueID()))
        {
            ((AbstractClientPlayer) e.entityPlayer).func_152121_a(
                    MinecraftProfileTexture.Type.CAPE, new ResourceLocation(
                            "fossil", "textures/ContributorCape.png"));
        }
    }

    private float interpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_)
    {
        float f3;

        for (f3 = p_77034_2_ - p_77034_1_; f3 < -180.0F; f3 += 360.0F)
        {
            ;
        }

        while (f3 >= 180.0F)
        {
            f3 -= 360.0F;
        }

        return p_77034_1_ + p_77034_3_ * f3;
    }

	/*
	 * The array where all the 
	 * UUIDs of the players are stored
	 */

    public boolean isDeveloper(UUID userid)
    {
        for (UUID uuid1 : devuuid)
        {
            if (userid.equals(uuid1))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isContributor(UUID userid)
    {
        for (UUID uuid1 : contributoruuid)
        {
            if (userid.equals(uuid1))
            {
                return true;
            }
        }
        return false;
    }
}
