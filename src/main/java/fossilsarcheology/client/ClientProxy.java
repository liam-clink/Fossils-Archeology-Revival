package fossilsarcheology.client;

import fossilsarcheology.Revival;
import fossilsarcheology.client.model.ModelDeadAnu;
import fossilsarcheology.client.model.ModelFailuresaurus;
import fossilsarcheology.client.model.ModelPigBoss;
import fossilsarcheology.client.model.armor.ModelAncientHelmet;
import fossilsarcheology.client.render.particle.BubbleFX;
import fossilsarcheology.client.render.particle.DeathOrbFX;
import fossilsarcheology.client.render.particle.HeartFX;
import fossilsarcheology.server.ServerProxy;
import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.entity.mob.projectile.EntityAncientJavelin;
import fossilsarcheology.server.entity.mob.projectile.EntityBirdEgg;
import fossilsarcheology.server.entity.mob.projectile.EntityJavelin;
import fossilsarcheology.server.entity.toy.EntityToyBall;
import fossilsarcheology.server.entity.toy.EntityToyScratchingPost;
import fossilsarcheology.server.entity.toy.EntityToyTetheredLog;
import fossilsarcheology.server.handler.EventNewMenu;
import fossilsarcheology.server.handler.EventOverlay;
import fossilsarcheology.server.handler.FossilClientEvents;
import fossilsarcheology.server.item.FAItemRegistry;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import fossilsarcheology.client.model.prehistoric.*;
import fossilsarcheology.client.render.entity.*;
import fossilsarcheology.client.render.item.*;
import fossilsarcheology.client.render.tileentity.*;
import fossilsarcheology.server.block.entity.*;
import fossilsarcheology.server.entity.*;
import fossilsarcheology.server.entity.mob.*;
import net.ilexiconn.llibrary.client.lang.LanguageHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.particle.EntityBlockDustFX;
import net.minecraft.client.particle.EntityBreakingFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends ServerProxy {
    private static final ModelAncientHelmet helmetModel = new ModelAncientHelmet(1.0f);

    // private JsonTabulaModel velociraptor =
    // ModelHelper.parseModelFromJson(Revival.class.getResourceAsStream("/assets/fossil/models/Velociraptor.json"));

    @Override
    public void init() {
        super.init();
        VillagerRegistry.instance().registerVillagerSkin(Revival.CONFIG.villagerId, new ResourceLocation("fossil:textures/model/Archaeologist.png"));
        RenderingRegistry.registerEntityRenderingHandler(EntityTriceratops.class, new RenderPrehistoric(new ModelTriceratops()));
        RenderingRegistry.registerEntityRenderingHandler(EntityVelociraptor.class, new RenderPrehistoric(new ModelVelociraptor()));
        RenderingRegistry.registerEntityRenderingHandler(EntityTyrannosaurus.class, new RenderPrehistoric(new ModelTyrannosaurus()));
        RenderingRegistry.registerEntityRenderingHandler(EntityPterosaur.class, new RenderPrehistoric(new ModelPteranodon()));
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
        RenderingRegistry.registerEntityRenderingHandler(EntityAlligatorGar.class, new RenderFish(new ModelAlligatorGar()));
        RenderingRegistry.registerEntityRenderingHandler(EntitySturgeon.class, new RenderFish(new ModelSturgeon()));
        RenderingRegistry.registerEntityRenderingHandler(EntityLiopleurodon.class, new RenderPrehistoric(new ModelLiopleurodon()));
        RenderingRegistry.registerEntityRenderingHandler(EntityElasmotherium.class, new RenderPrehistoric(new ModelElasmotherium()));
        RenderingRegistry.registerEntityRenderingHandler(EntityCeratosaurus.class, new RenderPrehistoric(new ModelCeratosaurus()));
        RenderingRegistry.registerEntityRenderingHandler(EntityConfuciusornis.class, new RenderPrehistoric(new ModelConfuciusornis()));
        RenderingRegistry.registerEntityRenderingHandler(EntityGastornis.class, new RenderPrehistoric(new ModelTerrorBird()));
        RenderingRegistry.registerEntityRenderingHandler(EntityKelenken.class, new RenderPrehistoric(new ModelTerrorBird()));
        RenderingRegistry.registerEntityRenderingHandler(EntityPhorusrhacos.class, new RenderPrehistoric(new ModelTerrorBird()));
        RenderingRegistry.registerEntityRenderingHandler(EntityTitanis.class, new RenderPrehistoric(new ModelTerrorBird()));
        RenderingRegistry.registerEntityRenderingHandler(EntityNautilus.class, new RenderFish(new ModelNautilus()));
        RenderingRegistry.registerEntityRenderingHandler(EntityStoneboard.class, new RenderStoneboard());
        RenderingRegistry.registerEntityRenderingHandler(EntityFailuresaurus.class, new RenderFailuresaurus(new ModelFailuresaurus(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityAnu.class, new RenderPigBoss(new ModelPigBoss(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityFriendlyPigZombie.class, new RenderFPZ());
        RenderingRegistry.registerEntityRenderingHandler(EntityDinosaurEgg.class, new RenderDinoEgg(0.2F));
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
        RenderingRegistry.registerEntityRenderingHandler(EntityToyBall.class, new RenderToyBall());
        RenderingRegistry.registerEntityRenderingHandler(EntityToyTetheredLog.class, new RenderToyTetheredLog());
        RenderingRegistry.registerEntityRenderingHandler(EntityToyScratchingPost.class, new RenderToyScratchingPost());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.INSTANCE.figurineBlock), new ItemFigurineRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.INSTANCE.vaseVoluteBlock), new ItemVaseVoluteRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.INSTANCE.vaseAmphoraBlock), new ItemVaseAmphoraRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.INSTANCE.vaseKylixBlock), new ItemVaseKylixRenderer());
        MinecraftForgeClient.registerItemRenderer(FAItemRegistry.INSTANCE.ancientClock, new ItemAncientClocRender());
        MinecraftForgeClient.registerItemRenderer(FAItemRegistry.INSTANCE.toyBall, new ItemToyBallRender());
        MinecraftForgeClient.registerItemRenderer(FAItemRegistry.INSTANCE.toyTetheredLog, new ItemToyTetheredBallRender());
        MinecraftForgeClient.registerItemRenderer(FAItemRegistry.INSTANCE.toyScratchingPost, new ItemToyScratchingPostRender());

        RenderingRegistry.registerBlockHandler(RenderFeeder.feederRenderID, new RenderFeeder());

        VillagerRegistry.instance().registerVillagerSkin(10, new ResourceLocation("fossil:textures/model/Archaeologist.png"));

        if (Revival.CONFIG.skullOverlay) {
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

        try {
            LanguageHandler.INSTANCE.loadRemoteLocalization(Revival.MODID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ModelBiped getArmorModel(int id) {
        switch (id) {
            case 0:
                return helmetModel;
            default:
                break;
        }

        return helmetModel;
    }

    @Override
    public void playSound(String soundName) {
        Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.func_147673_a(new ResourceLocation(soundName)));
    }

    @Override
    public void stopSound(String soundName) {
        ISound sound = PositionedSoundRecord.func_147673_a(new ResourceLocation(soundName));
        if (Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(sound))
            Minecraft.getMinecraft().getSoundHandler().stopSound(sound);
    }

    @Override
    public void spawnAnuParticle(World world, double posX, double posY, double posZ) {
        EntityFX particle1 = new DeathOrbFX(world, posX, posY, posZ, 0, 0, 0);
        Minecraft.getMinecraft().effectRenderer.addEffect(particle1);
    }

    @Override
    public void animate(int animateID) {
    }

    public void calculateChainBuffer(EntityPrehistoric entity) {
        entity.chainBuffer.calculateChainSwingBuffer(70, 10, 4, entity);
    }

    public void calculateChainBuffer(EntityFishBase entity) {
        entity.chainBuffer.calculateChainSwingBuffer(70, 10, 4, entity);
    }

    public void spawnBubbleParticles(World world, float f, float f1, float f2, double motionX, double motionY, double motionZ) {
        Minecraft.getMinecraft().effectRenderer.addEffect(new BubbleFX(world, f, f1, f2, motionX, motionY, motionZ));
    }

    public void spawnPacketHeartParticles(World world, float f, float f1, float f2, double motionX, double motionY, double motionZ) {
        Minecraft.getMinecraft().effectRenderer.addEffect(new HeartFX(world, f, f1, f2, motionX, motionY, motionZ));
    }

    public void spawnPacketItemParticles(World world, float f, float f1, float f2, double motionX, double motionY, double motionZ, Item item) {
        Minecraft.getMinecraft().effectRenderer.addEffect(new EntityBreakingFX(world, f, f1, f2, motionX, motionY, motionZ, item, 0));
    }

    public void spawnPacketBlockParticles(World world, float f, float f1, float f2, double motionX, double motionY, double motionZ, Block block) {
        Minecraft.getMinecraft().effectRenderer.addEffect(new EntityBlockDustFX(world, f, f1, f2, motionX, motionY, motionZ, block, 0));
    }
}
