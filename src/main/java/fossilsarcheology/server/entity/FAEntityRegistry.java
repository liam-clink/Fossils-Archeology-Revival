package fossilsarcheology.server.entity;

import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.prehistoric.MobType;
import fossilsarcheology.server.entity.prehistoric.PrehistoricEntityType;
import fossilsarcheology.server.entity.projectile.AncientJavelinEntity;
import fossilsarcheology.server.entity.projectile.JavelinEntity;
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
        registerEntity(JavelinEntity.class, "javelin", 0);
        registerEntity(AncientJavelinEntity.class, "ancient_javelin", 1);
        registerEntity(StoneTabletEntity.class, "stone_tablet", 2);
    }

    public static void registerEntity(Class<? extends Entity> entityClass, String name, int id) {
        EntityRegistry.registerModEntity(entityClass, name, id, Revival.INSTANCE, 64, 1, true);
    }

    public static void registerSpawnable(Class<? extends Entity> entityClass, String name, int id, int mainColor, int subColor) {
        EntityRegistry.registerModEntity(entityClass, name, id, Revival.INSTANCE, 512, 1, true, mainColor, subColor);
    }
}
