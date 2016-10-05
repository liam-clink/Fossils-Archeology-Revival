package fossilsarcheology.server.entity;

import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.prehistoric.MobType;
import fossilsarcheology.server.entity.prehistoric.PrehistoricEntityType;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class FAEntityRegistry {
    public static void register() {
        for (int id = 0; id < PrehistoricEntityType.values().length; id++) {
            PrehistoricEntityType type = PrehistoricEntityType.values()[id];
            if (type.mobType != MobType.CHICKEN && type.mobType != MobType.VANILLA) {
                registerSpawnable(type.getEntity(), type.name(), id + 200, type.primaryEggColor, type.secondaryEggColor);
            }
        }
    }

    public static void registerSpawnable(Class<? extends Entity> entityClass, String name, int entityId, int mainColor, int subColor) {
        EntityRegistry.registerModEntity(entityClass, name, entityId, Revival.INSTANCE, 512, 3, true, mainColor, subColor);
    }
}
