package mods.fossil.client.renderer.entity;

import java.util.UUID;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPlayer {

	/*
	 * Renders the cape on the player if they are in the array
	 */
	
	@SubscribeEvent
	public void playerRender(RenderPlayerEvent.Pre e) {
		if (e.entityPlayer instanceof AbstractClientPlayer
				&& isDeveloper(e.entityPlayer.getUniqueID())) {
			((AbstractClientPlayer) e.entityPlayer).func_152121_a(
					MinecraftProfileTexture.Type.CAPE, new ResourceLocation(
							"fossil", "textures/FossilCape.png"));
		}
	}
	
	/*
	 * Checks the players uuid
	 * to make sure it is in the
	 * array to confirm they are a
	 * developer
	 */
	
	public boolean isDeveloper(UUID userid) {
		for (UUID uuid1 : devuuid) {
			if (userid.equals(uuid1)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * The array where all the 
	 * UUIDs of the players are stored
	 */
	
	public UUID[] devuuid = new UUID[] {
	/*JTGhawk137*/UUID.fromString("54201149-1f1f-498b-98ca-50f66951a68f"),
	/*tyranno66*/UUID.fromString("04e6d7f5-b587-4e4f-8ce0-b210d368a79e"),
	/*Raptorfarian*/UUID.fromString("0ed918c8-d612-4360-b711-cd415671356f"),
	/*4f6f3b*/UUID.fromString("0248b8a4-7fab-4d6f-8a22-8a51534fd53f"),
	/*Bluestreak52*/UUID.fromString("5468a8f2-84d6-46e2-b58c-f9d576b67544"),
	/*Robberto08*/UUID.fromString("05b14ce7-0ff1-4b8e-9ef8-d98502e9bf07")
	};
}