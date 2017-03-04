package fossilsarcheology.server.entity.prehistoric;

import net.minecraft.world.World;

public abstract class EntityPrehistoricSwimming extends EntityPrehistoric{
    public EntityPrehistoricSwimming(World world, PrehistoricEntityType type, double baseDamage, double maxDamage, double baseHealth, double maxHealth, double baseSpeed, double maxSpeed) {
        super(world, type, baseDamage, maxDamage, baseHealth, maxHealth, baseSpeed, maxSpeed);
    }
}
