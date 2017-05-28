package fossilsarcheology.server.entity;

import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.monster.EntityFailuresaurus;
import fossilsarcheology.server.entity.monster.EntityFriendlyPigZombie;
import fossilsarcheology.server.entity.monster.EntitySentryPigman;
import fossilsarcheology.server.entity.monster.EntityTarSlime;
import fossilsarcheology.server.entity.prehistoric.*;
import fossilsarcheology.server.entity.projectile.AncientJavelinEntity;
import fossilsarcheology.server.entity.projectile.JavelinEntity;
import fossilsarcheology.server.entity.utility.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class FAEntityRegistry {
    public static void register() {
        for (int id = 0; id < PrehistoricEntityType.values().length; id++) {
            PrehistoricEntityType type = PrehistoricEntityType.values()[id];
            if (type.mobType != MobType.CHICKEN && type.mobType != MobType.VANILLA) {
                registerSpawnable(type.getEntity(), type.name().toLowerCase(), id + 200, type.primaryEggColor, type.secondaryEggColor);
            }
        }
        registerEntity(JavelinEntity.class, "javelin", 0);
        registerEntity(AncientJavelinEntity.class, "ancient_javelin", 1);
        registerEntity(StoneTabletEntity.class, "stone_tablet", 2);
        registerSpawnable(EntityFailuresaurus.class, "Failuresaurus", 5, 0x61ffbd, 0xf4eee6);
        registerEntity(EntityDinosaurEgg.class, "DinoEgg", 8);

        EntityRegistry.registerModEntity(EntityFriendlyPigZombie.class, "FriendlyPigZombie", 12, Revival.INSTANCE, 80, 3, true);
        EntityRegistry.registerModEntity(EntityAnuEffect.class, "AnuEffect", 13, Revival.INSTANCE, 80, 3, true);
        EntityRegistry.registerModEntity(EntityAnuDead.class, "AnuDead", 15, Revival.INSTANCE, 80, 3, true);
        registerSpawnable(EntityTarSlime.class, "TarSlime", 16, 0X222222, 0x0B0B0B);
        registerSpawnable(EntitySentryPigman.class, "SentryPigman", 18, 15373203, 0XD0A750);

        registerSpawnable(EntityAnubite.class, "Anubite", 39, 0X2E1E14, 0X601200);
        registerSpawnable(EntityAnu.class, "PigBoss", 17, 0X0F0F0F, 0XF72D00);

        EntityRegistry.registerModEntity(EntityToyBall.class, "ToyBall", 103, Revival.INSTANCE, 80, 3, true);
        EntityRegistry.registerModEntity(EntityToyTetheredLog.class, "ToyTetheredLog", 104, Revival.INSTANCE, 80, 3, true);
        EntityRegistry.registerModEntity(EntityToyScratchingPost.class, "ToyScratchingPost", 105, Revival.INSTANCE, 80, 3, true);

        Biome[] swamps = BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SWAMP);
        Biome[] rivers = BiomeDictionary.getBiomesForType(BiomeDictionary.Type.RIVER);
        Biome[] oceans = BiomeDictionary.getBiomesForType(BiomeDictionary.Type.OCEAN);
        Biome.SpawnListEntry sturgeon = new Biome.SpawnListEntry(EntitySturgeon.class, 20, 1, 1);
        Biome.SpawnListEntry alligatorgar = new Biome.SpawnListEntry(EntityAlligatorGar.class, 40, 1, 1);
        Biome.SpawnListEntry coelacanth = new Biome.SpawnListEntry(EntityCoelacanth.class, 20, 1, 1);
        Biome.SpawnListEntry nautilus = new Biome.SpawnListEntry(EntityNautilus.class, 4, 1, 1);
        if(Revival.CONFIG.spawnSturgeon){
            for(int i = 0; i < rivers.length; i++) {
                rivers[i].getSpawnableList(EnumCreatureType.WATER_CREATURE).add(sturgeon);
            }
        }
        if(Revival.CONFIG.spawnAlligatorGar){
            for(int i = 0; i < swamps.length; i++) {
                swamps[i].getSpawnableList(EnumCreatureType.WATER_CREATURE).add(alligatorgar);
            }
        }
        if(Revival.CONFIG.spawnCoelacanth){
            for(int i = 0; i < oceans.length; i++) {
                oceans[i].getSpawnableList(EnumCreatureType.WATER_CREATURE).add(coelacanth);
            }
        }
        if(Revival.CONFIG.spawnNautilus){
            for(int i = 0; i < oceans.length; i++) {
                oceans[i].getSpawnableList(EnumCreatureType.WATER_CREATURE).add(nautilus);
            }
        }
    }

    public static void registerEntity(Class<? extends Entity> entityClass, String name, int id) {
        EntityRegistry.registerModEntity(entityClass, name, id, Revival.INSTANCE, 64, 1, true);
    }

    public static void registerSpawnable(Class<? extends Entity> entityClass, String name, int id, int mainColor, int subColor) {
        EntityRegistry.registerModEntity(entityClass, name, id, Revival.INSTANCE, 64, 1, true, mainColor, subColor);
    }
}
