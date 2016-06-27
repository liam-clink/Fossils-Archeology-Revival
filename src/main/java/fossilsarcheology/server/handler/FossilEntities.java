package fossilsarcheology.server.handler;

import fossilsarcheology.server.entity.EntityDinosaurEgg;
import fossilsarcheology.server.entity.toy.EntityToyBall;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.EntityAnuEffect;
import fossilsarcheology.server.entity.EntityAnuLightning;
import fossilsarcheology.server.entity.EntityStoneboard;
import fossilsarcheology.server.entity.mob.EntityAlligatorGar;
import fossilsarcheology.server.entity.mob.EntityAnu;
import fossilsarcheology.server.entity.mob.EntityAnuDead;
import fossilsarcheology.server.entity.mob.EntityAnubite;
import fossilsarcheology.server.entity.mob.EntityBones;
import fossilsarcheology.server.entity.mob.EntityCoelacanth;
import fossilsarcheology.server.entity.mob.EntityFailuresaurus;
import fossilsarcheology.server.entity.mob.EntityFriendlyPigZombie;
import fossilsarcheology.server.entity.mob.EntityNautilus;
import fossilsarcheology.server.entity.mob.EntitySentryPigman;
import fossilsarcheology.server.entity.mob.EntitySturgeon;
import fossilsarcheology.server.entity.mob.EntityTarSlime;
import fossilsarcheology.server.entity.mob.projectile.EntityAncientJavelin;
import fossilsarcheology.server.entity.mob.projectile.EntityJavelin;
import fossilsarcheology.server.entity.toy.EntityToyScratchingPost;
import fossilsarcheology.server.entity.toy.EntityToyTetheredLog;
import fossilsarcheology.server.enums.EnumMobType;
import fossilsarcheology.server.enums.EnumPrehistoric;
import cpw.mods.fml.common.registry.EntityRegistry;

public class FossilEntities {

	static int startEntityId = 300;

	public static void registerEntities() {
		EntityRegistry.registerModEntity(EntityStoneboard.class, "StoneBoard", 1, Revival.INSTANCE, 80, Integer.MAX_VALUE, false);
		EntityRegistry.registerModEntity(EntityJavelin.class, "Javelin", 2, Revival.INSTANCE, 80, 3, true);
		EntityRegistry.registerModEntity(EntityAncientJavelin.class, "AncientJavelin", 3, Revival.INSTANCE, 80, 3, true);
		EntityRegistry.registerModEntity(EntityAnuLightning.class, "FriendlyLighting", 4, Revival.INSTANCE, 80, 3, true);
		registerSpawnable(EntityFailuresaurus.class, "Failuresaurus", 5, 0x61ffbd, 0xf4eee6);
		registerSpawnable(EntityBones.class, "Bones", 6, 12698049, 4802889);
		EntityRegistry.registerModEntity(EntityDinosaurEgg.class, "DinoEgg", 8, Revival.INSTANCE, 80, 1, false);
		EntityRegistry.registerModEntity(EntityFriendlyPigZombie.class, "FriendlyPigZombie", 12, Revival.INSTANCE, 80, 3, true);
		EntityRegistry.registerModEntity(EntityAnuEffect.class, "AnuEffect", 34, Revival.INSTANCE, 80, 3, true);
		registerSpawnable(EntityAnubite.class, "Anubite", 39, 0X2E1E14, 0X601200);
		EntityRegistry.registerModEntity(EntityAnuDead.class, "AnuDead", 41, Revival.INSTANCE, 80, 3, true);
		registerSpawnable(EntityTarSlime.class, "TarSlime", 99, 0X222222, 0x0B0B0B);
		registerSpawnable(EntityAnu.class, "PigBoss", 101, 0X0F0F0F, 0XF72D00);
		registerSpawnable(EntitySentryPigman.class, "SentryPigman", 102, 15373203, 0XD0A750);
		EntityRegistry.registerModEntity(EntityToyBall.class, "ToyBall", 103, Revival.INSTANCE, 80, 3, true);
		EntityRegistry.registerModEntity(EntityToyTetheredLog.class, "ToyTetheredLog", 104, Revival.INSTANCE, 80, 3, true);
		EntityRegistry.registerModEntity(EntityToyScratchingPost.class, "ToyScratchingPost", 105, Revival.INSTANCE, 80, 3, true);
		for (int i = 0; i < EnumPrehistoric.values().length; i++) {
			if (EnumPrehistoric.values()[i].type != EnumMobType.CHICKEN && EnumPrehistoric.values()[i].type != EnumMobType.VANILLA)
				registerSpawnable(EnumPrehistoric.values()[i].getDinoClass(), EnumPrehistoric.values()[i].name(), 200 + i, EnumPrehistoric.values()[i].mainSpawnColor, EnumPrehistoric.values()[i].secondSpawnColor);
		}

		BiomeGenBase[] swamps = BiomeDictionary.getBiomesForType(Type.SWAMP); 
		BiomeGenBase[] rivers = BiomeDictionary.getBiomesForType(Type.RIVER); 
		BiomeGenBase[] oceans = BiomeDictionary.getBiomesForType(Type.OCEAN); 
		SpawnListEntry sturgeon = new SpawnListEntry(EntitySturgeon.class, 20, 1, 1); 
		SpawnListEntry alligatorgar = new SpawnListEntry(EntityAlligatorGar.class, 10, 1, 1); 
		SpawnListEntry coelacanth = new SpawnListEntry(EntityCoelacanth.class, 5, 1, 1); 
		SpawnListEntry nautilus = new SpawnListEntry(EntityNautilus.class, 4, 1, 1);
		if(Revival.CONFIG.spawnSturgeon){
			for(int i = 0; i < rivers.length; i++) {
				rivers[i].getSpawnableList(EnumCreatureType.waterCreature).add(sturgeon);
			}
		}
		if(Revival.CONFIG.spawnAlligatorGar){
			for(int i = 0; i < swamps.length; i++) {
				swamps[i].getSpawnableList(EnumCreatureType.waterCreature).add(alligatorgar);
			}
		}
		if(Revival.CONFIG.spawnCoelacanth){
			for(int i = 0; i < oceans.length; i++) {
				oceans[i].getSpawnableList(EnumCreatureType.waterCreature).add(coelacanth);
			}
		}
		if(Revival.CONFIG.spawnNautilus){
			for(int i = 0; i < oceans.length; i++) {
				oceans[i].getSpawnableList(EnumCreatureType.waterCreature).add(nautilus);
			}
		}
	}

	public static void registerSpawnable(Class entityClass, String name, int entityId, int mainColor, int subColor) {
		EntityRegistry.registerModEntity(entityClass, name, entityId, Revival.INSTANCE, 80, 3, true);
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entityClass);
		EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id, mainColor, subColor));
	}

	public static int getUniqueEntityId() {
		do {
			startEntityId++;
		} while (EntityList.getStringFromID(startEntityId) != null);

		return startEntityId;
	}
}
