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
		
		else if(e.entityPlayer instanceof AbstractClientPlayer
				&& isDonator(e.entityPlayer.getUniqueID())) {
			((AbstractClientPlayer) e.entityPlayer).func_152121_a(
					MinecraftProfileTexture.Type.CAPE, new ResourceLocation(
							"fossil", "textures/DonatorCape.png"));
		}
		
		else if(e.entityPlayer instanceof AbstractClientPlayer
				&& isContributor(e.entityPlayer.getUniqueID())) {
			((AbstractClientPlayer) e.entityPlayer).func_152121_a(
					MinecraftProfileTexture.Type.CAPE, new ResourceLocation(
							"fossil", "textures/ContributorCape.png"));
		}
	}
	
	/*
	 * Checks the players uuid
	 * to make sure it is in the
	 * array to confirm they are a
	 * developer / Donator / Contributor
	 */
	
	public boolean isDeveloper(UUID userid) {
		for (UUID uuid1 : devuuid) {
			if (userid.equals(uuid1)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isDonator(UUID userid) {
		for(UUID uuid1 : donatoruuid) {
			if(userid.equals(uuid1)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isContributor(UUID userid) {
		for(UUID uuid1 : contributoruuid) {
			if(userid.equals(uuid1)) {
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
	
	public UUID[] donatoruuid = new UUID[] {
	/*ginjaninjas7*/UUID.fromString("18eb6ad8-1656-4e41-89f6-88b708a0474c")
	};
	
	public UUID[] contributoruuid = new UUID[] {
	/*Alexthe666*/UUID.fromString("71363abe-fd03-49c9-940d-aae8b8209b7c"),
	/*cyborx25*/UUID.fromString("c1637beb-4336-42f2-ad0b-a7188cf13042"),
	/*ExDragonith*/UUID.fromString("a7970406-e0ac-446b-8fe0-d42c94b594ea"),
	/*duckdude173*/UUID.fromString("12bde8ed-cfe9-49ac-af14-71762a3f49db"),
	/*whitejoshman*/UUID.fromString("28bcc73a-2726-49e8-ac1b-f02dbbb0c83b"),
	/*Shadowbeast007*/UUID.fromString("df3d1115-6601-4346-a063-f1254bf5a069"),
	/*MicroJunk*/UUID.fromString("d1c57f9a-069b-46af-b9ee-44ab0fce1d80")
	};
}