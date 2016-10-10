package fossilsarcheology.client.render;

import fossilsarcheology.Revival;
import fossilsarcheology.client.render.entity.JavelinRenderer;
import fossilsarcheology.client.render.entity.StoneTabletRenderer;
import fossilsarcheology.server.api.DefaultRenderedItem;
import fossilsarcheology.server.api.IgnoreRenderProperty;
import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.entity.StoneTabletEntity;
import fossilsarcheology.server.entity.projectile.AncientJavelinEntity;
import fossilsarcheology.server.entity.projectile.JavelinEntity;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
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
    private ItemModelMesher modelMesher;

    public void onPreInit() {
        for (Block block : FABlockRegistry.BLOCKS) {
            if (block instanceof IgnoreRenderProperty) {
                IProperty<?>[] ignoredProperties = ((IgnoreRenderProperty) block).getIgnoredProperties();
                ModelLoader.setCustomStateMapper(block, new StateMap.Builder().ignore(ignoredProperties).build());
            }
        }

        RenderingRegistry.registerEntityRenderingHandler(JavelinEntity.class, JavelinRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AncientJavelinEntity.class, JavelinRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(StoneTabletEntity.class, StoneTabletRenderer::new);
    }

    public void onInit() {
        this.modelMesher = MINECRAFT.getRenderItem().getItemModelMesher();

        for (Block block : FABlockRegistry.BLOCKS) {
            if (block instanceof DefaultRenderedItem) {
                this.registerBlockRenderer(block, ((DefaultRenderedItem) block).getResource(block.getUnlocalizedName().substring("tile.".length())), "inventory");
            }
        }
    }

    public void onPostInit() {
        for (Item item : FAItemRegistry.ITEMS) {
            if (item instanceof DefaultRenderedItem) {
                this.registerItemRenderer(item, ((DefaultRenderedItem) item).getResource(item.getUnlocalizedName().substring("item.".length())), "inventory");
            }
        }
    }

    public void registerItemRenderer(Item item, String path, String type) {
        this.modelMesher.register(item, stack -> new ModelResourceLocation(Revival.MODID + ":" + path, type));
    }

    public void registerItemRenderer(Item item, int meta, String path, String type) {
        this.modelMesher.register(item, meta, new ModelResourceLocation(Revival.MODID + ":" + path, type));
    }

    public void registerBlockRenderer(Block block, int meta, String path, String type) {
        this.modelMesher.register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(Revival.MODID + ":" + path, type));
    }

    public void registerBlockRenderer(Block block, final String path, final String type) {
        this.modelMesher.register(Item.getItemFromBlock(block), stack -> new ModelResourceLocation(Revival.MODID + ":" + path, type));
    }
}
