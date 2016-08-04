package fossilsarcheology.client.render.entity;

import fossilsarcheology.server.entity.mob.projectile.EntityBirdEgg;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBirdEgg extends RenderSnowball<EntityBirdEgg> {
    public RenderBirdEgg(RenderManager renderManager, RenderItem renderItem) {
        super(renderManager, null, renderItem);
    }

    @Override
    public ItemStack getStackToRender(EntityBirdEgg entity) {
        return new ItemStack(entity.item);
    }
}