package mods.fossil.client;

import mods.fossil.CommonProxy;
import mods.fossil.Fossil;
import mods.fossil.client.model.ModelAllosaurus;
import mods.fossil.client.model.ModelAnkylosaurus;
import mods.fossil.client.model.ModelBrachiosaurus;
import mods.fossil.client.model.ModelCeratosaurus;
import mods.fossil.client.model.ModelCoelacanth;
import mods.fossil.client.model.ModelCompsognathus;
import mods.fossil.client.model.ModelDeadAnu;
import mods.fossil.client.model.ModelDeinonychus;
import mods.fossil.client.model.ModelDilophosaurus;
import mods.fossil.client.model.ModelDodo;
import mods.fossil.client.model.ModelElasmotherium;
import mods.fossil.client.model.ModelFailuresaurus;
import mods.fossil.client.model.ModelGallimimus;
import mods.fossil.client.model.ModelLiopleurodon;
import mods.fossil.client.model.ModelMammoth;
import mods.fossil.client.model.ModelMosasaurus;
import mods.fossil.client.model.ModelNautilus;
import mods.fossil.client.model.ModelPachycephalosaurus;
import mods.fossil.client.model.ModelPigBoss;
import mods.fossil.client.model.ModelPlesiosaur;
import mods.fossil.client.model.ModelPteranodon;
import mods.fossil.client.model.ModelQuagga;
import mods.fossil.client.model.ModelSarcosuchus;
import mods.fossil.client.model.ModelSmilodon;
import mods.fossil.client.model.ModelSpinosaurus;
import mods.fossil.client.model.ModelStegosaurus;
import mods.fossil.client.model.ModelTRex;
import mods.fossil.client.model.ModelTerrorBird;
import mods.fossil.client.model.ModelTriceratops;
import mods.fossil.client.model.ModelVelociraptor;
import mods.fossil.client.model.armor.ModelAncientHelmet;
import mods.fossil.client.renderer.entity.RenderAllosaurus;
import mods.fossil.client.renderer.entity.RenderAnkylosaurus;
import mods.fossil.client.renderer.entity.RenderAnuEffect;
import mods.fossil.client.renderer.entity.RenderAnubite;
import mods.fossil.client.renderer.entity.RenderBones;
import mods.fossil.client.renderer.entity.RenderBrachiosaurus;
import mods.fossil.client.renderer.entity.RenderCeratosaurus;
import mods.fossil.client.renderer.entity.RenderCoelacanth;
import mods.fossil.client.renderer.entity.RenderCompsognathus;
import mods.fossil.client.renderer.entity.RenderConfuciusornis;
import mods.fossil.client.renderer.entity.RenderDeadAnu;
import mods.fossil.client.renderer.entity.RenderDeinonychus;
import mods.fossil.client.renderer.entity.RenderDilophosaurus;
import mods.fossil.client.renderer.entity.RenderDinoEgg;
import mods.fossil.client.renderer.entity.RenderDodo;
import mods.fossil.client.renderer.entity.RenderElasmotherium;
import mods.fossil.client.renderer.entity.RenderFPZ;
import mods.fossil.client.renderer.entity.RenderFailuresaurus;
import mods.fossil.client.renderer.entity.RenderFollowers;
import mods.fossil.client.renderer.entity.RenderGallimimus;
import mods.fossil.client.renderer.entity.RenderJavelin;
import mods.fossil.client.renderer.entity.RenderLiopleurodon;
import mods.fossil.client.renderer.entity.RenderMammoth;
import mods.fossil.client.renderer.entity.RenderMosasaurus;
import mods.fossil.client.renderer.entity.RenderNautilus;
import mods.fossil.client.renderer.entity.RenderPachycephalosaurus;
import mods.fossil.client.renderer.entity.RenderPigBoss;
import mods.fossil.client.renderer.entity.RenderPlayerCapes;
import mods.fossil.client.renderer.entity.RenderPlesiosaur;
import mods.fossil.client.renderer.entity.RenderPterosaur;
import mods.fossil.client.renderer.entity.RenderQuagga;
import mods.fossil.client.renderer.entity.RenderSarcosuchus;
import mods.fossil.client.renderer.entity.RenderSentryPigman;
import mods.fossil.client.renderer.entity.RenderSmilodon;
import mods.fossil.client.renderer.entity.RenderSpinosaurus;
import mods.fossil.client.renderer.entity.RenderStegosaurus;
import mods.fossil.client.renderer.entity.RenderStoneboard;
import mods.fossil.client.renderer.entity.RenderTRex;
import mods.fossil.client.renderer.entity.RenderTerrorBird;
import mods.fossil.client.renderer.entity.RenderTriceratops;
import mods.fossil.client.renderer.entity.RenderVelociraptor;
import mods.fossil.client.renderer.item.ItemAncientClocRender;
import mods.fossil.client.renderer.item.ItemFigurineRenderer;
import mods.fossil.client.renderer.item.ItemRenderAnuTotem;
import mods.fossil.client.renderer.item.ItemRenderAnubite;
import mods.fossil.client.renderer.item.ItemRenderSarcophagus;
import mods.fossil.client.renderer.item.ItemRenderTileEntity;
import mods.fossil.client.renderer.item.ItemVaseAmphoraRenderer;
import mods.fossil.client.renderer.item.ItemVaseKylixRenderer;
import mods.fossil.client.renderer.item.ItemVaseVoluteRenderer;
import mods.fossil.client.renderer.tileentity.RenderFeeder;
import mods.fossil.client.renderer.tileentity.RenderTNClock;
import mods.fossil.client.renderer.tileentity.TileEntityAncientChestRender;
import mods.fossil.client.renderer.tileentity.TileEntityAnuTotemRender;
import mods.fossil.client.renderer.tileentity.TileEntityAnubiteStatueRender;
import mods.fossil.client.renderer.tileentity.TileEntityCultivateRenderer;
import mods.fossil.client.renderer.tileentity.TileEntityFigurineRenderer;
import mods.fossil.client.renderer.tileentity.TileEntitySarcophagusRender;
import mods.fossil.client.renderer.tileentity.TileEntityVaseRenderer;
import mods.fossil.entity.EntityAncientJavelin;
import mods.fossil.entity.EntityAnuEffect;
import mods.fossil.entity.EntityDinoEgg;
import mods.fossil.entity.EntityJavelin;
import mods.fossil.entity.EntityStoneboard;
import mods.fossil.entity.EntityTerrorBirdEgg;
import mods.fossil.entity.mob.EntityAllosaurus;
import mods.fossil.entity.mob.EntityAnkylosaurus;
import mods.fossil.entity.mob.EntityAnu;
import mods.fossil.entity.mob.EntityAnuDead;
import mods.fossil.entity.mob.EntityAnubite;
import mods.fossil.entity.mob.EntityBones;
import mods.fossil.entity.mob.EntityBrachiosaurus;
import mods.fossil.entity.mob.EntityCeratosaurus;
import mods.fossil.entity.mob.EntityCoelacanth;
import mods.fossil.entity.mob.EntityCompsognathus;
import mods.fossil.entity.mob.EntityConfuciusornis;
import mods.fossil.entity.mob.EntityConfuciusornisEgg;
import mods.fossil.entity.mob.EntityCultivatedChickenEgg;
import mods.fossil.entity.mob.EntityCultivatedConfuciusornisEgg;
import mods.fossil.entity.mob.EntityCultivatedDodoEgg;
import mods.fossil.entity.mob.EntityDeinonychus;
import mods.fossil.entity.mob.EntityDilophosaurus;
import mods.fossil.entity.mob.EntityDodo;
import mods.fossil.entity.mob.EntityDodoEgg;
import mods.fossil.entity.mob.EntityElasmotherium;
import mods.fossil.entity.mob.EntityFailuresaurus;
import mods.fossil.entity.mob.EntityFriendlyPigZombie;
import mods.fossil.entity.mob.EntityGallimimus;
import mods.fossil.entity.mob.EntityLiopleurodon;
import mods.fossil.entity.mob.EntityMammoth;
import mods.fossil.entity.mob.EntityMosasaurus;
import mods.fossil.entity.mob.EntityNautilus;
import mods.fossil.entity.mob.EntityPachycephalosaurus;
import mods.fossil.entity.mob.EntityPlesiosaur;
import mods.fossil.entity.mob.EntityPterosaur;
import mods.fossil.entity.mob.EntityQuagga;
import mods.fossil.entity.mob.EntitySarcosuchus;
import mods.fossil.entity.mob.EntitySentryPigman;
import mods.fossil.entity.mob.EntitySmilodon;
import mods.fossil.entity.mob.EntitySpinosaurus;
import mods.fossil.entity.mob.EntityStegosaurus;
import mods.fossil.entity.mob.EntityTRex;
import mods.fossil.entity.mob.EntityTerrorBird;
import mods.fossil.entity.mob.EntityTriceratops;
import mods.fossil.entity.mob.EntityVelociraptor;
import mods.fossil.guiBlocks.TileEntityAncientChest;
import mods.fossil.guiBlocks.TileEntityAnuTotem;
import mods.fossil.guiBlocks.TileEntityAnubiteStatue;
import mods.fossil.guiBlocks.TileEntityCultivate;
import mods.fossil.guiBlocks.TileEntityFigurine;
import mods.fossil.guiBlocks.TileEntitySarcophagus;
import mods.fossil.guiBlocks.TileEntityTimeMachine;
import mods.fossil.guiBlocks.TileEntityVase;
import mods.fossil.handler.EventOverlay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;



public class ClientProxy extends CommonProxy {

	private static final ModelAncientHelmet helmet_0 = new ModelAncientHelmet(1.0f);
	@Override
	public void registerRenderThings() {

		/*
		 * Entity Registry
		 */

		RenderingRegistry.registerEntityRenderingHandler(EntityStoneboard.class, new RenderStoneboard());
		RenderingRegistry.registerEntityRenderingHandler(EntityTriceratops.class, new RenderTriceratops(new ModelTriceratops(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityVelociraptor.class, new RenderVelociraptor(new ModelVelociraptor(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTRex.class, new RenderTRex(new ModelTRex(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFailuresaurus.class, new RenderFailuresaurus(new ModelFailuresaurus(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityAnu.class, new RenderPigBoss(new ModelPigBoss(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFriendlyPigZombie.class, new RenderFPZ());
		RenderingRegistry.registerEntityRenderingHandler(EntityPterosaur.class, new RenderPterosaur(new ModelPteranodon(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityNautilus.class, new RenderNautilus(new ModelNautilus(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPlesiosaur.class, new RenderPlesiosaur(new ModelPlesiosaur(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMosasaurus.class, new RenderMosasaurus(new ModelMosasaurus(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityStegosaurus.class, new RenderStegosaurus(new ModelStegosaurus(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDinoEgg.class, new RenderDinoEgg(1.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDilophosaurus.class, new RenderDilophosaurus(new ModelDilophosaurus(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySmilodon.class, new RenderSmilodon(new ModelSmilodon(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityJavelin.class, new RenderJavelin());
		RenderingRegistry.registerEntityRenderingHandler(EntityAncientJavelin.class, new RenderJavelin());
		RenderingRegistry.registerEntityRenderingHandler(EntityBones.class, new RenderBones());
		RenderingRegistry.registerEntityRenderingHandler(EntityBrachiosaurus.class, new RenderBrachiosaurus(new ModelBrachiosaurus(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMammoth.class, new RenderMammoth(new ModelMammoth(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySpinosaurus.class, new RenderSpinosaurus(new ModelSpinosaurus(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityCompsognathus.class, new RenderCompsognathus(new ModelCompsognathus(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDodo.class, new RenderDodo(new ModelDodo(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityCultivatedChickenEgg.class, new RenderSnowball(Fossil.cultivatedChickenEgg));
		RenderingRegistry.registerEntityRenderingHandler(EntityDodoEgg.class, new RenderSnowball(Fossil.dodoEgg));
		RenderingRegistry.registerEntityRenderingHandler(EntityCultivatedDodoEgg.class, new RenderSnowball(Fossil.cultivatedDodoEgg));
		RenderingRegistry.registerEntityRenderingHandler(EntityConfuciusornisEgg.class, new RenderSnowball(Fossil.confuciusornisEgg));
		RenderingRegistry.registerEntityRenderingHandler(EntityCultivatedConfuciusornisEgg.class, new RenderSnowball(Fossil.cultivatedConfuciusornisEgg));
		RenderingRegistry.registerEntityRenderingHandler(EntityAnkylosaurus.class, new RenderAnkylosaurus(new ModelAnkylosaurus(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPachycephalosaurus.class, new RenderPachycephalosaurus(new ModelPachycephalosaurus(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDeinonychus.class, new RenderDeinonychus(new ModelDeinonychus(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGallimimus.class, new RenderGallimimus(new ModelGallimimus(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySarcosuchus.class, new RenderSarcosuchus(new ModelSarcosuchus(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityAllosaurus.class, new RenderAllosaurus(new ModelAllosaurus(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityCoelacanth.class, new RenderCoelacanth(new ModelCoelacanth(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLiopleurodon.class, new RenderLiopleurodon(new ModelLiopleurodon(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityQuagga.class, new RenderQuagga(new ModelQuagga(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTerrorBird.class, new RenderTerrorBird(new ModelTerrorBird(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTerrorBirdEgg.class, new RenderSnowball(Fossil.terrorBirdEgg));
		RenderingRegistry.registerEntityRenderingHandler(EntityElasmotherium.class, new RenderElasmotherium(new ModelElasmotherium(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityAnuEffect.class, new RenderAnuEffect());
		RenderingRegistry.registerEntityRenderingHandler(EntityConfuciusornis.class, new RenderConfuciusornis());
		RenderingRegistry.registerEntityRenderingHandler(EntityAnubite.class, new RenderAnubite());
		RenderingRegistry.registerEntityRenderingHandler(EntityCeratosaurus.class, new RenderCeratosaurus(new ModelCeratosaurus(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySentryPigman.class, new RenderSentryPigman());
		RenderingRegistry.registerEntityRenderingHandler(EntityAnuDead.class, new RenderDeadAnu(new ModelDeadAnu(), 0.3F));

		if(FossilOptions.DeveloperSpecials){
			RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new RenderFollowers());
		}
		/*
		 * Item Registry
		 */

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Fossil.figurineBlock), new ItemFigurineRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Fossil.vaseVoluteBlock), new ItemVaseVoluteRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Fossil.vaseAmphoraBlock), new ItemVaseAmphoraRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Fossil.vaseKylixBlock), new ItemVaseKylixRenderer());
		MinecraftForgeClient.registerItemRenderer(Fossil.ancientClock, (IItemRenderer)new ItemAncientClocRender());

		/*
		 * Block Registry
		 */

		RenderingRegistry.registerBlockHandler(Fossil.feederRenderID, new RenderFeeder());

		/*
		 * Villager Registry
		 */

		VillagerRegistry.instance().registerVillagerSkin(10, new ResourceLocation("fossil:textures/mob/Archaeologist.png"));

		if(FossilOptions.Skull_Overlay){
			MinecraftForge.EVENT_BUS.register(new EventOverlay(Minecraft.getMinecraft()));
		}
	}
	/*
	 * TileEntity Registry
	 */

	@Override
	public void registerTileEntitySpecialRenderer() {

		TileEntitySpecialRenderer cultivate = new TileEntityCultivateRenderer();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCultivate.class, cultivate);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Fossil.blockcultivateActive),new ItemRenderTileEntity(cultivate, new TileEntityCultivate()));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Fossil.blockcultivateIdle),new ItemRenderTileEntity(cultivate, new TileEntityCultivate()));


		TileEntitySpecialRenderer ancChest = new TileEntityAncientChestRender();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAncientChest.class, ancChest);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Fossil.ancientChest),new ItemRenderTileEntity(ancChest, new TileEntityAncientChest()));

		TileEntitySpecialRenderer totem = new TileEntityAnuTotemRender();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnuTotem.class, totem); 
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Fossil.anuTotem),new ItemRenderAnuTotem(totem, new TileEntityAnuTotem()));

		TileEntitySpecialRenderer anubite = new TileEntityAnubiteStatueRender();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnubiteStatue.class, anubite); 
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Fossil.anubiteStatue),new ItemRenderAnubite(anubite, new TileEntityAnubiteStatue()));

		TileEntitySpecialRenderer sarcophagus = new TileEntitySarcophagusRender();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySarcophagus.class, sarcophagus); 
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Fossil.sarcophagus),new ItemRenderSarcophagus(sarcophagus, new TileEntitySarcophagus()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTimeMachine.class, new RenderTNClock());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFigurine.class, new TileEntityFigurineRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVase.class, new TileEntityVaseRenderer()); 
	}
	public ModelBiped getArmorModel(int id){

		switch (id) { 
		case 0:
			return helmet_0; 
		default:
			break;
		}
		return helmet_0;
	} 
	/*
	 * Events Registery
	 */

	public void registerEvents() {
		MinecraftForge.EVENT_BUS.register(new RenderPlayerCapes());
	}
	public void playSound(String soundName) {
		Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.func_147673_a(new ResourceLocation(soundName)));
	}
	public void stopSound() {
		Minecraft.getMinecraft().getSoundHandler().stopSounds();
	}

}
