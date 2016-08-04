package fossilsarcheology.server.entity.mob.projectile;

import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BehaviorJavelinDispense extends BehaviorProjectileDispense {
    private int type;

    public BehaviorJavelinDispense(int type) {
        this.type = type;
    }

    @Override
    protected IProjectile getProjectileEntity(World world, IPosition position, ItemStack stack) {
        if (this.type < 0) {
            EntityAncientJavelin entity = new EntityAncientJavelin(world, position.getX(), position.getY(), position.getZ());
            entity.damaged = 1;
            entity.material = ToolMaterial.IRON;
            return entity;
        }

        EntityJavelin entity = new EntityJavelin(world, position.getX(), position.getY(), position.getZ());
        entity.damaged = 1;

        switch (this.type) {
            default:
            case 0:
                entity.material = ToolMaterial.WOOD;
                break;
            case 1:
                entity.material = ToolMaterial.STONE;
                break;
            case 2:
                entity.material = ToolMaterial.IRON;
                break;
            case 3:
                entity.material = ToolMaterial.DIAMOND;
                break;
            case 4:
                entity.material = ToolMaterial.GOLD;
                break;
        }

        return entity;
    }
}
