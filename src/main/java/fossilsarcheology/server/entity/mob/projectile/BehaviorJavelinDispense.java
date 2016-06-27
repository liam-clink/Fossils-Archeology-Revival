package fossilsarcheology.server.entity.mob.projectile;

import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class BehaviorJavelinDispense extends BehaviorProjectileDispense {
    /**
     * Reference to the MinecraftServer object.
     */
    final MinecraftServer mcServer;
    int javelin;

    public BehaviorJavelinDispense(MinecraftServer par1, int jav0) {
        this.mcServer = par1;
        this.javelin = jav0;
    }

    /**
     * Return the projectile entity spawned by this dispense behavior.
     */
    @Override
    protected IProjectile getProjectileEntity(World par1World, IPosition par2IPosition) {
        if (this.javelin < 0) {
            EntityAncientJavelin var3 = new EntityAncientJavelin(par1World, par2IPosition.getX(), par2IPosition.getY(), par2IPosition.getZ());
            var3.canBePickedUp = 1;
            var3.material = ToolMaterial.IRON;
            return var3;
        }

        EntityJavelin var3 = new EntityJavelin(par1World, par2IPosition.getX(), par2IPosition.getY(), par2IPosition.getZ());
        var3.canBePickedUp = 1;

        switch (this.javelin) {
            default:
            case 0:
                var3.material = ToolMaterial.WOOD;
                break;

            case 1:
                var3.material = ToolMaterial.STONE;
                break;

            case 2:
                var3.material = ToolMaterial.IRON;
                break;

            case 3:
                var3.material = ToolMaterial.EMERALD;
                break;

            case 4:
                var3.material = ToolMaterial.GOLD;
                break;
        }

        return var3;
    }
}
