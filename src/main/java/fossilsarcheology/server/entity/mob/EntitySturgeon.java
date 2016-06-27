package fossilsarcheology.server.entity.mob;

import net.minecraft.world.World;
import fossilsarcheology.server.entity.EntityFishBase;
import fossilsarcheology.server.enums.EnumPrehistoric;

public class EntitySturgeon extends EntityFishBase {
    public EntitySturgeon(World par1World) {
        super(par1World, EnumPrehistoric.Sturgeon);
        this.setSize(1.9F, 1F);
    }

    @Override
    public String getTexture() {
        return "fossil:textures/model/fish/sturgeon.png";
    }

    @Override
    protected double getSwimSpeed() {
        return 0.35D;
    }
}
