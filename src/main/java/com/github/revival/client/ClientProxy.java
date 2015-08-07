package com.github.revival.client;

import com.github.revival.Revival;
import com.github.revival.client.model.*;
import com.github.revival.client.model.armor.ModelAncientHelmet;
import com.github.revival.client.renderer.entity.*;
import com.github.revival.client.renderer.item.*;
import com.github.revival.client.renderer.particle.DeathOrbFX;
import com.github.revival.client.renderer.tileentity.*;
import com.github.revival.common.CommonProxy;
import com.github.revival.common.block.FABlockRegistry;
import com.github.revival.common.config.FossilConfig;
import com.github.revival.common.entity.*;
import com.github.revival.common.entity.mob.*;
import com.github.revival.common.entity.mob.projectile.EntityBirdEgg;
import com.github.revival.common.handler.EventNewMenu;
import com.github.revival.common.handler.EventOverlay;
import com.github.revival.common.item.FAItemRegistry;
import com.github.revival.common.tileentity.*;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;


public class ClientProxy extends CommonProxy
{
	private static final ModelAncientHelmet helmet_0 = new ModelAncientHelmet(1.0f);

	public void init()
	{
		super.init();
		RenderingRegistry.registerEntityRenderingHandler(EntityStoneboard.class, new RenderStoneboard());
		RenderingRegistry.registerEntityRenderingHandler(EntityTriceratops.class, new RenderTriceratops(new ModelTriceratops(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityVelociraptor.class, new RenderVelociraptor());
		RenderingRegistry.registerEntityRenderingHandler(EntityTyrannosaurus.class, new RenderTRex(new ModelTRex(), 0.5F));
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
		//RenderingRegistry.registerEntityRenderingHandler(EntityCultivatedChickenEgg.class, new RenderSnowball(FAItemRegistry.cultivatedChickenEgg));
		//RenderingRegistry.registerEntityRenderingHandler(EntityDodoEgg.class, new RenderSnowball(FAItemRegistry.dodoEgg));
		//RenderingRegistry.registerEntityRenderingHandler(EntityCultivatedDodoEgg.class, new RenderSnowball(FAItemRegistry.));
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
		//   RenderingRegistry.registerEntityRenderingHandler(EntityTerrorBirdEgg.class, new RenderSnowball(FAItemRegistry.terrorBirdEgg));
		RenderingRegistry.registerEntityRenderingHandler(EntityElasmotherium.class, new RenderElasmotherium(new ModelElasmotherium(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityAnuEffect.class, new RenderAnuEffect());
		RenderingRegistry.registerEntityRenderingHandler(EntityConfuciusornis.class, new RenderConfuciusornis());
		RenderingRegistry.registerEntityRenderingHandler(EntityAnubite.class, new RenderAnubite());
		RenderingRegistry.registerEntityRenderingHandler(EntityCeratosaurus.class, new RenderCeratosaurus(new ModelCeratosaurus(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySentryPigman.class, new RenderSentryPigman());
		RenderingRegistry.registerEntityRenderingHandler(EntityAnuDead.class, new RenderDeadAnu(new ModelDeadAnu(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBirdEgg.class, new RenderBirdEgg());

		if (FossilConfig.developerSpecials)
		{
			//RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new RenderFollowers());
		}

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.figurineBlock), new ItemFigurineRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.vaseVoluteBlock), new ItemVaseVoluteRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.vaseAmphoraBlock), new ItemVaseAmphoraRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.vaseKylixBlock), new ItemVaseKylixRenderer());
		MinecraftForgeClient.registerItemRenderer(FAItemRegistry.ancientClock, new ItemAncientClocRender());

		RenderingRegistry.registerBlockHandler(Revival.feederRenderID, new RenderFeeder());

		VillagerRegistry.instance().registerVillagerSkin(10, new ResourceLocation("fossil:textures/mob/Archaeologist.png"));

		if (FossilConfig.skullOverlay)
		{
			MinecraftForge.EVENT_BUS.register(new EventOverlay(Minecraft.getMinecraft()));
		}

		TileEntitySpecialRenderer cultivate = new TileEntityCultivateRenderer();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCultivate.class, cultivate);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.blockcultivateActive), new ItemRenderTileEntity(cultivate, new TileEntityCultivate()));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.blockcultivateIdle), new ItemRenderTileEntity(cultivate, new TileEntityCultivate()));


		TileEntitySpecialRenderer ancChest = new TileEntityAncientChestRender();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAncientChest.class, ancChest);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.ancientChest), new ItemRenderTileEntity(ancChest, new TileEntityAncientChest()));

		TileEntitySpecialRenderer totem = new TileEntityAnuTotemRender();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnuTotem.class, totem);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.anuTotem), new ItemRenderAnuTotem(totem, new TileEntityAnuTotem()));

		TileEntitySpecialRenderer anubite = new TileEntityAnubiteStatueRender();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnubiteStatue.class, anubite);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.anubiteStatue), new ItemRenderAnubite(anubite, new TileEntityAnubiteStatue()));

		TileEntitySpecialRenderer sarcophagus = new TileEntitySarcophagusRender();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySarcophagus.class, sarcophagus);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.sarcophagus), new ItemRenderSarcophagus(sarcophagus, new TileEntitySarcophagus()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTimeMachine.class, new RenderTNClock());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFigurine.class, new TileEntityFigurineRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVase.class, new TileEntityVaseRenderer());

		MinecraftForge.EVENT_BUS.register(new RenderPlayerCapes());
		MinecraftForge.EVENT_BUS.register(new EventNewMenu());
	}

	public ModelBiped getArmorModel(int id)
	{

		switch (id)
		{
		case 0:
			return helmet_0;
		default:
			break;
		}
		return helmet_0;
	}

	public void playSound(String soundName)
	{
		Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.func_147673_a(new ResourceLocation(soundName)));
	}

	public void stopSound()
	{
		Minecraft.getMinecraft().getSoundHandler().stopSounds();
	}

	public void spawnAnuParticle(World world, double posX, double posY, double posZ)
	{
		EntityFX particle1 = new DeathOrbFX(world, posX, posY, posZ, 0, 0, 0);
		Minecraft.getMinecraft().effectRenderer.addEffect(particle1);
	}
}
