package fossilsarcheology.client.render;

import fossilsarcheology.Revival;
import fossilsarcheology.client.model.*;
import fossilsarcheology.client.render.entity.JavelinRenderer;
import fossilsarcheology.client.render.entity.RenderFailuresaurus;
import fossilsarcheology.client.render.entity.RenderFish;
import fossilsarcheology.client.render.entity.StoneTabletRenderer;
import fossilsarcheology.server.api.DefaultRenderedItem;
import fossilsarcheology.server.api.IgnoreRenderProperty;
import fossilsarcheology.server.api.SubtypeRenderedItem;
import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.entity.StoneTabletEntity;
import fossilsarcheology.server.entity.monster.EntityFailuresaurus;
import fossilsarcheology.server.entity.prehistoric.EntityAlligatorGar;
import fossilsarcheology.server.entity.prehistoric.EntityCoelacanth;
import fossilsarcheology.server.entity.prehistoric.EntityNautilus;
import fossilsarcheology.server.entity.prehistoric.EntitySturgeon;
import fossilsarcheology.server.entity.projectile.AncientJavelinEntity;
import fossilsarcheology.server.entity.projectile.JavelinEntity;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderingHandler {
    private static final Minecraft MINECRAFT = Minecraft.getMinecraft();

    public void onPreInit() {
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
