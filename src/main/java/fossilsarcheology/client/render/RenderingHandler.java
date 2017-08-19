package fossilsarcheology.client.render;

import fossilsarcheology.Revival;
import fossilsarcheology.client.model.*;
import fossilsarcheology.client.render.entity.*;
import fossilsarcheology.client.render.tile.*;
import fossilsarcheology.server.api.DefaultRenderedItem;
import fossilsarcheology.server.api.IgnoreRenderProperty;
import fossilsarcheology.server.api.SubtypeRenderedItem;
import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.block.entity.*;
import fossilsarcheology.server.block.entity.block.TileEntityVolute;
import fossilsarcheology.server.entity.StoneTabletEntity;
import fossilsarcheology.server.entity.monster.*;
import fossilsarcheology.server.entity.prehistoric.*;
import fossilsarcheology.server.entity.projectile.AncientJavelinEntity;
import fossilsarcheology.server.entity.projectile.EntityBirdEgg;
import fossilsarcheology.server.entity.projectile.JavelinEntity;
import fossilsarcheology.server.entity.utility.EntityAnuDead;
import fossilsarcheology.server.entity.utility.EntityAnuEffect;
import fossilsarcheology.server.entity.utility.EntityToyBall;
import fossilsarcheology.server.entity.utility.EntityToyScratchingPost;
import fossilsarcheology.server.item.FAItemRegistry;
import fossilsarcheology.server.item.FossilSeedsItem;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderingHandler {
    private static final Minecraft MINECRAFT = Minecraft.getMinecraft();


    public void onPreInit() {

        this.registerItemRenderer(FAItemRegistry.TAR_BUCKET, "tar_bucket", "inventory");

        for(int i = 0; i < 16; i++){
            this.registerItemRenderer(FAItemRegistry.TOY_BALL, i, "toyball_" + EnumDyeColor.byDyeDamage(i).getName(), "inventory");
        }

        for(int i = 0; i < 16; i++){
            this.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.FIGURINE), i, "figurine_" + i, "inventory");
        }

        for(int i = 0; i < FossilSeedsItem.fossilSeeds.length; i++){
            this.registerItemRenderer(FAItemRegistry.FOSSIL_SEED, i, "fossilseed_" + FossilSeedsItem.fossilSeeds[i], "inventory");
            this.registerItemRenderer(FAItemRegistry.SEED, i, "seed_" + FossilSeedsItem.fossilSeeds[i], "inventory");
        }

        for(int i = 0; i < 5; i++){
            this.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.AMPHORA_VASE), i, "vase_amphora_" + i, "inventory");
            this.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.KYLIX_VASE), i, "vase_kylix_" + i, "inventory");
            this.registerItemRenderer(Item.getItemFromBlock(FABlockRegistry.VOLUTE_VASE), i, "vase_volute_" + i, "inventory");

        }

        for (Block block : FABlockRegistry.BLOCKS) {
            if (block instanceof IgnoreRenderProperty) {
                IProperty<?>[] ignoredProperties = ((IgnoreRenderProperty) block).getIgnoredProperties();
                ModelLoader.setCustomStateMapper(block, new StateMap.Builder().ignore(ignoredProperties).build());
            }
        }

        for (Block block : FABlockRegistry.BLOCKS) {
            if (block instanceof DefaultRenderedItem) {
                this.registerBlockRenderer(block, ((DefaultRenderedItem) block).getResource(block.getUnlocalizedName().substring("tile.".length())), "inventory");
            }
        }

        for (Item item : FAItemRegistry.ITEMS) {
            String name = item.getUnlocalizedName().substring("item.".length());

            if (item instanceof DefaultRenderedItem) {
                this.registerItemRenderer(item, ((DefaultRenderedItem) item).getResource(name), "inventory");
            } else if (item instanceof SubtypeRenderedItem) {
                SubtypeRenderedItem subtypeItem = (SubtypeRenderedItem) item;
                int[] subtypes = subtypeItem.getUsedSubtypes();
                for (int metadata : subtypes) {
                    this.registerItemRenderer(item, metadata, subtypeItem.getResource(name, metadata), "inventory");
                }
            }else if (item instanceof ItemFood){
                this.registerItemRenderer(item, name, "inventory");
                this.registerItemRenderer(item, name, "inventory");
            }
        }
    }

    public void onInit() {
        RenderingRegistry.registerEntityRenderingHandler(JavelinEntity.class, new JavelinRenderer(MINECRAFT.getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(AncientJavelinEntity.class, new JavelinRenderer(MINECRAFT.getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(StoneTabletEntity.class, StoneTabletRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityNautilus.class, new RenderFish(new ModelNautilus(), MINECRAFT.getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityCoelacanth.class, new RenderFish(new ModelCoelacanth(), MINECRAFT.getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityAlligatorGar.class, new RenderFish(new ModelAlligatorGar(), MINECRAFT.getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntitySturgeon.class, new RenderFish(new ModelSturgeon(), MINECRAFT.getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityFailuresaurus.class, new RenderFailuresaurus(new ModelFailuresaurus(), MINECRAFT.getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityAnuEffect.class, new RenderAnuEffect(MINECRAFT.getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityAnuDead.class, new RenderDeadAnu(MINECRAFT.getRenderManager(), new ModelDeadAnu(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityAnubite.class, new RenderAnubite(MINECRAFT.getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntitySentryPigman.class, new RenderSentryPigman(MINECRAFT.getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityTarSlime.class, new RenderTarSlime(MINECRAFT.getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityAnu.class, new RenderPigBoss(MINECRAFT.getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityBirdEgg.class, new RenderBirdEgg(MINECRAFT.getRenderManager(), MINECRAFT.getRenderItem()));
        RenderingRegistry.registerEntityRenderingHandler(EntityToyBall.class, new RenderToyBall(MINECRAFT.getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityToyScratchingPost.class, new RenderToyScratchingPost(MINECRAFT.getRenderManager()));
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
        RenderingRegistry.registerEntityRenderingHandler(EntityLiopleurodon.class, new RenderPrehistoric(new ModelLiopleurodon()));
        RenderingRegistry.registerEntityRenderingHandler(EntityElasmotherium.class, new RenderPrehistoric(new ModelElasmotherium()));
        RenderingRegistry.registerEntityRenderingHandler(EntityCeratosaurus.class, new RenderPrehistoric(new ModelCeratosaurus()));
        RenderingRegistry.registerEntityRenderingHandler(EntityConfuciusornis.class, new RenderPrehistoric(new ModelConfuciusornis()));
        RenderingRegistry.registerEntityRenderingHandler(EntityDryosaurus.class, new RenderPrehistoric(new ModelDryosaurus()));
        RenderingRegistry.registerEntityRenderingHandler(EntityTherizinosaurus.class, new RenderPrehistoric(new ModelTherizinosaurus()));
        RenderingRegistry.registerEntityRenderingHandler(EntityParasaurolophus.class, new RenderPrehistoric(new ModelParasaurolophus()));
        RenderingRegistry.registerEntityRenderingHandler(EntityGastornis.class, new RenderPrehistoric(new ModelTerrorBird()));
        RenderingRegistry.registerEntityRenderingHandler(EntityKelenken.class, new RenderPrehistoric(new ModelTerrorBird()));
        RenderingRegistry.registerEntityRenderingHandler(EntityPhorusrhacos.class, new RenderPrehistoric(new ModelTerrorBird()));
        RenderingRegistry.registerEntityRenderingHandler(EntityTitanis.class, new RenderPrehistoric(new ModelTerrorBird()));
        RenderingRegistry.registerEntityRenderingHandler(EntityHenodus.class, new RenderPrehistoric(new ModelHenodus()));
        RenderingRegistry.registerEntityRenderingHandler(EntityIcthyosaurus.class, new RenderPrehistoric(new ModelIcthyosaurus()));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnuStatue.class, new TileEntityAnuStatueRender());
        ForgeHooksClient.registerTESRItemStack(Item.getItemFromBlock(FABlockRegistry.ANU_STATUE), 0, TileEntityAnuStatue.class);
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnubiteStatue.class, new TileEntityAnubiteStatueRender());
        ForgeHooksClient.registerTESRItemStack(Item.getItemFromBlock(FABlockRegistry.ANUBITE_STATUE), 0, TileEntityAnubiteStatue.class);
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAncientChest.class, new TileEntityAncientChestRender());
        ForgeHooksClient.registerTESRItemStack(Item.getItemFromBlock(FABlockRegistry.ANCIENT_CHEST), 0, TileEntityAncientChest.class);
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySarcophagus.class, new TileEntitySarcophagusRender());
        ForgeHooksClient.registerTESRItemStack(Item.getItemFromBlock(FABlockRegistry.SARCOPHAGUS), 0, TileEntitySarcophagus.class);
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFigurine.class, new TileEntityFigurineRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAmphora.class, new TileEntityVaseRenderer(0));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVolute.class, new TileEntityVaseRenderer(1));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKylix.class, new TileEntityVaseRenderer(2));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTimeMachine.class, new TileEntityTimeMachineRender());

    }

    public void onPostInit() {
    }

    public void registerItemRenderer(Item item, String path, String type) {
        this.registerItemRenderer(item, 0, path, type);
    }

    public void registerItemRenderer(Item item, int meta, String path, String type) {
        ModelResourceLocation resource = new ModelResourceLocation(Revival.MODID + ":" + path, type);
        ModelLoader.setCustomModelResourceLocation(item, meta, resource);
    }

    public void registerBlockRenderer(Block block, int meta, String path, String type) {
        this.registerItemRenderer(Item.getItemFromBlock(block), meta, path, type);
    }

    public void registerBlockRenderer(Block block, final String path, final String type) {
        this.registerBlockRenderer(block, 0, path, type);
    }
}
