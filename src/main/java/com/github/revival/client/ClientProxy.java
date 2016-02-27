package com.github.revival.client;

import com.github.revival.Revival;
import com.github.revival.client.model.DeadAnuModel;
import com.github.revival.client.model.FailuresaurusModel;
import com.github.revival.client.model.PigBossModel;
import com.github.revival.client.model.armor.AncientHelmetModel;
import com.github.revival.client.model.prehistoric.*;
import com.github.revival.client.model.prehistoric.alternate.FlyingConfuciusornisModel;
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
import com.github.revival.server.item.FAItemRegistry;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import net.ilexiconn.llibrary.client.model.modelbase.ChainBuffer;
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
    private static final AncientHelmetModel helmetModel = new AncientHelmetModel(1.0f);
    // private JsonTabulaModel velociraptor = ModelHelper.parseModelFromJson(Revival.class.getResourceAsStream("/assets/fossil/models/Velociraptor.json"));

    public void init() {
        super.init();
        RenderingRegistry.registerEntityRenderingHandler(TriceratopsEntity.class, new PrehistoricRenderer(new TriceratopsModel()));
        RenderingRegistry.registerEntityRenderingHandler(VelociraptorEntity.class, new PrehistoricRenderer(new VelociraptorModel()));
        RenderingRegistry.registerEntityRenderingHandler(TyrannosaurusEntity.class, new PrehistoricRenderer(new TyrannosaurusModel()));
        RenderingRegistry.registerEntityRenderingHandler(PterosaurEntity.class, new PrehistoricRenderer(new PteranodonModel()));
        RenderingRegistry.registerEntityRenderingHandler(NautilusEntity.class, new FishRenderer(new NautilusModel()));
        RenderingRegistry.registerEntityRenderingHandler(PlesiosaurusEntity.class, new PrehistoricRenderer(new PlesiosaurusModel()));
        RenderingRegistry.registerEntityRenderingHandler(MosasaurusEntity.class, new PrehistoricRenderer(new MosasaurusModel()));
        RenderingRegistry.registerEntityRenderingHandler(StegosaurusEntity.class, new PrehistoricRenderer(new StegosaurusModel()));
        RenderingRegistry.registerEntityRenderingHandler(DilophosaurusEntity.class, new PrehistoricRenderer(new DilophosaurusModel()));
        RenderingRegistry.registerEntityRenderingHandler(SmilodonEntity.class, new PrehistoricRenderer(new SmilodonModel()));
        RenderingRegistry.registerEntityRenderingHandler(BrachiosaurusEntity.class, new PrehistoricRenderer(new BrachiosaurusModel()));
        RenderingRegistry.registerEntityRenderingHandler(MammothEntity.class, new PrehistoricRenderer(new MammothModel()));
        RenderingRegistry.registerEntityRenderingHandler(SpinosaurusEntity.class, new PrehistoricRenderer(new SpinosaurusModel()));
        RenderingRegistry.registerEntityRenderingHandler(CompsognathusEntity.class, new GlowingPrehistoricRenderer(new CompsognathusModel(), new ResourceLocation("fossil:textures/mob/compsognathus/compsognathus_overlay.png")));
        RenderingRegistry.registerEntityRenderingHandler(DodoEntity.class, new PrehistoricRenderer(new DodoModel()));
        RenderingRegistry.registerEntityRenderingHandler(AnkylosaurusEntity.class, new PrehistoricRenderer(new AnkylosaurusModel()));
        RenderingRegistry.registerEntityRenderingHandler(PachycephalosaurusEntity.class, new PrehistoricRenderer(new PachycephalosaurusModel()));
        RenderingRegistry.registerEntityRenderingHandler(DeinonychusEntity.class, new PrehistoricRenderer(new DeinonychusModel()));
        RenderingRegistry.registerEntityRenderingHandler(GallimimusEntity.class, new PrehistoricRenderer(new GallimimusModel()));
        RenderingRegistry.registerEntityRenderingHandler(SarcosuchusEntity.class, new PrehistoricRenderer(new SarcosuchusModel()));
        RenderingRegistry.registerEntityRenderingHandler(AllosaurusEntity.class, new PrehistoricRenderer(new AllosaurusModel()));
        RenderingRegistry.registerEntityRenderingHandler(CoelacanthEntity.class, new FishRenderer(new CoelacanthModel()));
        RenderingRegistry.registerEntityRenderingHandler(LiopleurodonEntity.class, new PrehistoricRenderer(new LiopleurodonModel()));
        RenderingRegistry.registerEntityRenderingHandler(ElasmotheriumEntity.class, new PrehistoricRenderer(new ElasmotheriumModel()));
        RenderingRegistry.registerEntityRenderingHandler(CeratosaurusEntity.class, new PrehistoricRenderer(new CeratosaurusModel()));
        RenderingRegistry.registerEntityRenderingHandler(ConfuciusornisEntity.class, new FlyingPrehistoricRenderer(new ConfuciusornisModel(), new FlyingConfuciusornisModel()));


        RenderingRegistry.registerEntityRenderingHandler(StoneboardEntity.class, new StoneboardRenderer());
        RenderingRegistry.registerEntityRenderingHandler(FailuresaurusEntity.class, new FailuresaurusRenderer(new FailuresaurusModel(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(AnuEntity.class, new PigBossRenderer(new PigBossModel(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(FriendlyPigZombieEntity.class, new FPZRenderer());
        RenderingRegistry.registerEntityRenderingHandler(DinoEggEntity.class, new DinoEggRenderer(1.5F));
        RenderingRegistry.registerEntityRenderingHandler(JavelinEntity.class, new JavelinRenderer());
        RenderingRegistry.registerEntityRenderingHandler(AncientJavelinEntity.class, new JavelinRenderer());
        RenderingRegistry.registerEntityRenderingHandler(BonesEntity.class, new BonesRenderer());
        RenderingRegistry.registerEntityRenderingHandler(AnuEffectEntity.class, new AnuEffectRenderer());
        RenderingRegistry.registerEntityRenderingHandler(AnubiteEntity.class, new AnubiteRenderer());
        RenderingRegistry.registerEntityRenderingHandler(SentryPigmanEntity.class, new SentryPigmanRenderer());
        RenderingRegistry.registerEntityRenderingHandler(AnuDeadEntity.class, new DeadAnuRenderer(new DeadAnuModel(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBirdEgg.class, new BirdEggRenderer());
        RenderingRegistry.registerEntityRenderingHandler(TarSlimeEntity.class, new TarSlimeRenderer());
        RenderingRegistry.registerEntityRenderingHandler(QuaggaEntity.class, new QuaggaRenderer(new QuaggaModel(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(TerrorBirdEntity.class, new TerrorBirdRenderer(new TerrorBirdModel(), 0.5F));

        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.figurineBlock), new ItemFigurineRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.vaseVoluteBlock), new ItemVaseVoluteRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.vaseAmphoraBlock), new ItemVaseAmphoraRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.vaseKylixBlock), new ItemVaseKylixRenderer());
        MinecraftForgeClient.registerItemRenderer(FAItemRegistry.ancientClock, new ItemAncientClocRender());

        RenderingRegistry.registerBlockHandler(Revival.feederRenderID, new FeederRenderer());

        VillagerRegistry.instance().registerVillagerSkin(10, new ResourceLocation("fossil:textures/model/Archaeologist.png"));

        if (FossilConfig.skullOverlay) {
            MinecraftForge.EVENT_BUS.register(new EventOverlay(Minecraft.getMinecraft()));
        }

        TileEntitySpecialRenderer cultivate = new CultivateSpecialRenderer();
        ClientRegistry.bindTileEntitySpecialRenderer(CultivateTile.class, cultivate);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.blockcultivateActive), new ItemRenderTileEntity(cultivate, new CultivateTile()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.blockcultivateIdle), new ItemRenderTileEntity(cultivate, new CultivateTile()));

        TileEntitySpecialRenderer ancChest = new AncientChestSpecialRenderer();
        ClientRegistry.bindTileEntitySpecialRenderer(AncientChestTile.class, ancChest);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.ancientChest), new ItemRenderTileEntity(ancChest, new AncientChestTile()));

        TileEntitySpecialRenderer totem = new AnuTotemSpecialRenderer();
        ClientRegistry.bindTileEntitySpecialRenderer(AnuTotemTile.class, totem);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.anuTotem), new ItemRenderAnuTotem(totem, new AnuTotemTile()));

        TileEntitySpecialRenderer anubite = new AnubiteStatueSpecialRenderer();
        ClientRegistry.bindTileEntitySpecialRenderer(AnubiteStatueTile.class, anubite);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.anubiteStatue), new ItemRenderAnubite(anubite, new AnubiteStatueTile()));

        TileEntitySpecialRenderer sarcophagus = new SarcophagusSpecialRenderer();
        ClientRegistry.bindTileEntitySpecialRenderer(SarcophagusTile.class, sarcophagus);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.sarcophagus), new ItemRenderSarcophagus(sarcophagus, new SarcophagusTile()));

        ClientRegistry.bindTileEntitySpecialRenderer(TimeMachineTile.class, new TNClockSpecialRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(FigurineTile.class, new FigurineSpecialRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(VaseTile.class, new VaseSpecialRenderer());

        MinecraftForge.EVENT_BUS.register(new PlayerCapesRenderer());
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
        return new ChainBuffer(tailSegments);
    }
}
