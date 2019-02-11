package fossilsarcheology.client.render.entity;

import fossilsarcheology.Revival;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSlime;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.ResourceLocation;

public class RenderTarSlime extends RenderSlime {

	public RenderTarSlime(RenderManager rendermanager) {
		super(rendermanager);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntitySlime entity) {
		return new ResourceLocation(Revival.MODID, "textures/model/tar_slime.png");
	}
}
