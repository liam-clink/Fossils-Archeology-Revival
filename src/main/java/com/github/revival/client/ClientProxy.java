package com.github.revival.client;

import com.github.revival.Revival;
import com.github.revival.client.model.ModelDeadAnu;
import com.github.revival.client.model.ModelFailuresaurus;
import com.github.revival.client.model.ModelPigBoss;
import com.github.revival.client.model.armor.ModelAncientHelmet;
import com.github.revival.client.model.prehistoric.*;
import com.github.revival.client.model.prehistoric.alternate.ModelFlyingConfuciusornis;
import com.github.revival.client.renderer.entity.*;
import com.github.revival.client.renderer.item.*;
import com.github.revival.client.renderer.particle.DeathOrbFX;
import com.github.revival.client.renderer.particle.SleepFX;
import com.github.revival.client.renderer.particle.TarDropsFX;
import com.github.revival.client.renderer.tileentity.*;
import com.github.revival.server.ServerProxy;
import com.github.revival.server.block.FABlockRegistry;
import com.github.revival.server.block.entity.*;
import com.github.revival.server.config.FossilConfig;
import com.github.revival.server.entity.*;
import com.github.revival.server.entity.mob.*;
import com.github.revival.server.entity.mob.projectile.EntityBirdEgg;
import com.github.revival.server.handler.EventNewMenu;
import com.github.revival.server.handler.EventOverlay;
import com.github.revival.server.handler.FossilClientEvents;
import com.github.revival.server.item.FAItemRegistry;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import net.ilexiconn.llibrary.client.model.tools.ChainBuffer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;


public class ClientProxy extends ServerProxy {
    private static final ModelAncientHelmet helmetModel = new ModelAncientHelmet(1.0f);
    // private JsonTabulaModel velociraptor = ModelHelper.parseModelFromJson(Revival.class.getResourceAsStream("/assets/fossil/models/Velociraptor.json"));

    public void init() {
        super.init();
        RenderingRegistry.registerEntityRenderingHandler(EntityTriceratops.class, new RenderPrehistoric(new ModelTriceratops()));
        RenderingRegistry.registerEntityRenderingHandler(EntityVelociraptor.class, new RenderPrehistoric(new ModelVelociraptor()));
        RenderingRegistry.registerEntityRenderingHandler(EntityTyrannosaurus.class, new RenderPrehistoric(new ModelTyrannosaurus()));
        RenderingRegistry.registerEntityRenderingHandler(EntityPterosaur.class, new RenderPrehistoric(new ModelPteranodon()));
        RenderingRegistry.registerEntityRenderingHandler(EntityNautilus.class, new RenderFish(new ModelNautilus()));
        RenderingRegistry.registerEntityRenderingHandler(EntityPlesiosaurus.class, new RenderPrehistoric(new ModelPlesiosaurus()));
        RenderingRegistry.registerEntityRenderingHandler(EntityMosasaurus.class, new RenderPrehistoric(new ModelMosasaurus()));
        RenderingRegistry.registerEntityRenderingHandler(EntityStegosaurus.class, new RenderPrehistoric(new ModelStegosaurus()));
        RenderingRegistry.registerEntityRenderingHandler(EntityDilophosaurus.class, new RenderPrehistoric(new ModelDilophosaurus()));
        RenderingRegistry.registerEntityRenderingHandler(EntitySmilodon.class, new RenderPrehistoric(new ModelSmilodon()));
        RenderingRegistry.registerEntityRenderingHandler(EntityBrachiosaurus.class, new RenderPrehistoric(new ModelBrachiosaurus()));
        RenderingRegistry.registerEntityRenderingHandler(EntityMammoth.class, new RenderPrehistoric(new ModelMammoth()));
        RenderingRegistry.registerEntityRenderingHandler(EntitySpinosaurus.class, new RenderPrehistoric(new ModelSpinosaurus()));
        RenderingRegistry.registerEntityRenderingHandler(EntityCompsognathus.class, new RenderGlowingPrehistoric(new ModelCompsognathus(), new ResourceLocation("fossil:textures/mob/compsognathus/compsognathus_overlay.png")));
        RenderingRegistry.registerEntityRenderingHandler(EntityDodo.class, new RenderPrehistoric(new ModelDodo()));
        RenderingRegistry.registerEntityRenderingHandler(EntityAnkylosaurus.class, new RenderPrehistoric(new ModelAnkylosaurus()));
        RenderingRegistry.registerEntityRenderingHandler(EntityPachycephalosaurus.class, new RenderPrehistoric(new ModelPachycephalosaurus()));
        RenderingRegistry.registerEntityRenderingHandler(EntityDeinonychus.class, new RenderPrehistoric(new ModelDeinonychus()));
        RenderingRegistry.registerEntityRenderingHandler(EntityGallimimus.class, new RenderPrehistoric(new ModelGallimimus()));
        RenderingRegistry.registerEntityRenderingHandler(EntitySarcosuchus.class, new RenderPrehistoric(new ModelSarcosuchus()));
        RenderingRegistry.registerEntityRenderingHandler(EntityAllosaurus.class, new RenderPrehistoric(new ModelAllosaurus()));
        RenderingRegistry.registerEntityRenderingHandler(EntityCoelacanth.class, new RenderFish(new ModelCoelacanth()));
        RenderingRegistry.registerEntityRenderingHandler(EntityLiopleurodon.class, new RenderPrehistoric(new ModelLiopleurodon()));
        RenderingRegistry.registerEntityRenderingHandler(EntityElasmotherium.class, new RenderPrehistoric(new ModelElasmotherium()));
        RenderingRegistry.registerEntityRenderingHandler(EntityCeratosaurus.class, new RenderPrehistoric(new ModelCeratosaurus()));
        RenderingRegistry.registerEntityRenderingHandler(EntityConfuciusornis.class, new RenderFlyingPrehistoric(new ModelConfuciusornis(), new ModelFlyingConfuciusornis()));


        RenderingRegistry.registerEntityRenderingHandler(EntityStoneboard.class, new RenderStoneboard());
        RenderingRegistry.registerEntityRenderingHandler(EntityFailuresaurus.class, new RenderFailuresaurus(new ModelFailuresaurus(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityAnu.class, new RenderPigBoss(new ModelPigBoss(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityFriendlyPigZombie.class, new RenderFPZ());
        RenderingRegistry.registerEntityRenderingHandler(EntityDinoEgg.class, new RenderDinoEgg(1.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityJavelin.class, new RenderJavelin());
        RenderingRegistry.registerEntityRenderingHandler(EntityAncientJavelin.class, new RenderJavelin());
        RenderingRegistry.registerEntityRenderingHandler(EntityBones.class, new RenderBones());
        RenderingRegistry.registerEntityRenderingHandler(EntityAnuEffect.class, new RenderAnuEffect());
        RenderingRegistry.registerEntityRenderingHandler(EntityAnubite.class, new RenderAnubite());
        RenderingRegistry.registerEntityRenderingHandler(EntitySentryPigman.class, new RenderSentryPigman());
        RenderingRegistry.registerEntityRenderingHandler(EntityAnuDead.class, new RenderDeadAnu(new ModelDeadAnu(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBirdEgg.class, new RenderBirdEgg());
        RenderingRegistry.registerEntityRenderingHandler(EntityTarSlime.class, new RenderTarSlime());
        RenderingRegistry.registerEntityRenderingHandler(EntityQuagga.class, new RenderQuagga(new ModelQuagga(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityTerrorBird.class, new RenderTerrorBird(new ModelTerrorBird(), 0.5F));

        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.INSTANCE.figurineBlock), new ItemFigurineRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.INSTANCE.vaseVoluteBlock), new ItemVaseVoluteRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.INSTANCE.vaseAmphoraBlock), new ItemVaseAmphoraRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.INSTANCE.vaseKylixBlock), new ItemVaseKylixRenderer());
        MinecraftForgeClient.registerItemRenderer(FAItemRegistry.INSTANCE.ancientClock, new ItemAncientClocRender());

        RenderingRegistry.registerBlockHandler(Revival.feederRenderID, new RenderFeeder());

        VillagerRegistry.instance().registerVillagerSkin(10, new ResourceLocation("fossil:textures/model/Archaeologist.png"));

        if (FossilConfig.skullOverlay) {
            MinecraftForge.EVENT_BUS.register(new EventOverlay(Minecraft.getMinecraft()));
        }

        TileEntitySpecialRenderer cultivate = new TileEntityCultivateRenderer();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCultivate.class, cultivate);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.INSTANCE.blockcultivateActive), new ItemRenderTileEntity(cultivate, new TileEntityCultivate()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.INSTANCE.blockcultivateIdle), new ItemRenderTileEntity(cultivate, new TileEntityCultivate()));

        TileEntitySpecialRenderer ancChest = new TileEntityAncientChestRender();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAncientChest.class, ancChest);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.INSTANCE.ancientChest), new ItemRenderTileEntity(ancChest, new TileEntityAncientChest()));

        TileEntitySpecialRenderer totem = new TileEntityAnuTotemRender();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnuTotem.class, totem);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.INSTANCE.anuTotem), new ItemRenderAnuTotem(totem, new TileEntityAnuTotem()));

        TileEntitySpecialRenderer anubite = new TileEntityAnubiteStatueRender();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnubiteStatue.class, anubite);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.INSTANCE.anubiteStatue), new ItemRenderAnubite(anubite, new TileEntityAnubiteStatue()));

        TileEntitySpecialRenderer sarcophagus = new TileEntitySarcophagusRender();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySarcophagus.class, sarcophagus);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.INSTANCE.sarcophagus), new ItemRenderSarcophagus(sarcophagus, new TileEntitySarcophagus()));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTimeMachine.class, new RenderTNClock());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFigurine.class, new TileEntityFigurineRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVase.class, new TileEntityVaseRenderer());

        MinecraftForge.EVENT_BUS.register(new FossilClientEvents());
        MinecraftForge.EVENT_BUS.register(new RenderPlayerCapes());
        MinecraftForge.EVENT_BUS.register(new EventNewMenu());
    }

    public ModelBiped getArmorModel(int id) {
        switch (id) {
            case 0:
                return helmetModel;
            default:
                break;
        }

        return helmetModel;
    }

    public void playSound(String soundName) {
        Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.func_147673_a(new ResourceLocation(soundName)));
    }

    public void stopSound() {
        Minecraft.getMinecraft().getSoundHandler().stopSounds();
    }

    public void spawnAnuParticle(World world, double posX, double posY, double posZ) {
        EntityFX particle1 = new DeathOrbFX(world, posX, posY, posZ, 0, 0, 0);
        Minecraft.getMinecraft().effectRenderer.addEffect(particle1);
    }

    public void spawnSleepParticle(World world, double posX, double posY, double posZ) {
        EntityFX particle1 = new SleepFX(world, posX, posY, posZ, 0, 0, 0);
        Minecraft.getMinecraft().effectRenderer.addEffect(particle1);
    }

    public void spawnTarParticle(World world, double posX, double posY, double posZ) {
        EntityFX particle1 = new TarDropsFX(world, posX, posY, posZ);
        Minecraft.getMinecraft().effectRenderer.addEffect(particle1);
    }

    public void animate(int animateID) {
    }

    public void doChainBuffer(ChainBuffer buffer, EntityLivingBase entity) {
        buffer.calculateChainSwingBuffer(70F, 5, 4, entity);
    }

    public ChainBuffer getChainBuffer(int tailSegments) {
        return new ChainBuffer();
    }
}
