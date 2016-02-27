package com.github.revival.server.handler;

import com.github.revival.server.entity.mob.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;

public class FossilSpawnEggs {
    static int startEntityId = 300;

    public static void addSpawnEggs() {                                                        //bg		//fg
        registerEntityEgg(TriceratopsEntity.class, 0x62d84e, 0xebffd5);
        registerEntityEgg(SarcosuchusEntity.class, 0x2B2B1E, 0x72715B);
        registerEntityEgg(VelociraptorEntity.class, 0xbfa487, 0x936d2e);
        registerEntityEgg(TyrannosaurusEntity.class, 0x763c11, 0xffebc4);
        registerEntityEgg(FailuresaurusEntity.class, 0x61ffbd, 0xf4eee6);
        registerEntityEgg(AnuEntity.class, 0x000000, 0xff0000);
        registerEntityEgg(PterosaurEntity.class, 0xe4cae2, 0x751075);
        registerEntityEgg(NautilusEntity.class, 0xd4aba9, 0x97312f);
        registerEntityEgg(PlesiosaurusEntity.class, 0xa4362e, 0xcd6052);
        registerEntityEgg(MosasaurusEntity.class, 0x9cbd8c, 0x357510);
        registerEntityEgg(StegosaurusEntity.class, 0xbfc9a9, 0x5e7510);
        registerEntityEgg(DilophosaurusEntity.class, 0x474807, 0x9f9e4e);
        registerEntityEgg(SmilodonEntity.class, 0xefa745, 0xf9f4df);
        registerEntityEgg(BonesEntity.class, 0xffffff, 0x000000);
        registerEntityEgg(BrachiosaurusEntity.class, 0x5283bf, 0xffffff);
        registerEntityEgg(MammothEntity.class, 0x3d2700, 0xcc9566);
        registerEntityEgg(SpinosaurusEntity.class, 0x9f9e4e, 0x474807);
        registerEntityEgg(CompsognathusEntity.class, 0x357510, 0x66a24a);
        registerEntityEgg(DodoEntity.class, 0x784830, 0xb59586);
        registerEntityEgg(AnkylosaurusEntity.class, 0xffebc4, 0x763c11);
        registerEntityEgg(PachycephalosaurusEntity.class, 0xdac49d, 0xa86722);
        registerEntityEgg(DeinonychusEntity.class, 0x6a6a6a, 0x2f302e);
        registerEntityEgg(GallimimusEntity.class, 0x8c5517, 0x544833);
        registerEntityEgg(CoelacanthEntity.class, 0x5283bf, 0x66a24a);
        registerEntityEgg(LiopleurodonEntity.class, 0x000000, 0xffffff);
        registerEntityEgg(QuaggaEntity.class, 0x8c4b2e, 0xc6a999);
        registerEntityEgg(TerrorBirdEntity.class, 0x689d94, 0x151917);
        registerEntityEgg(AllosaurusEntity.class, 0x813030, 0x24496e);
        registerEntityEgg(ElasmotheriumEntity.class, 0xcc9566, 0x3d2700);
        registerEntityEgg(ConfuciusornisEntity.class, 0xA4A2A5, 0x773C00);
        registerEntityEgg(CeratosaurusEntity.class, 0x678A5A, 0xD6C78D);
        registerEntityEgg(AnubiteEntity.class, 0x381A1F, 0x732A19);
        registerEntityEgg(SentryPigmanEntity.class, 15373203, 0xD0A750);
        registerEntityEgg(TarSlimeEntity.class, 0X222222, 0x0B0B0B);

    }

    public static int getUniqueEntityId() {
        do {
            startEntityId++;
        }
        while (EntityList.getStringFromID(startEntityId) != null);

        return startEntityId;
    }

    public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) {
        int id = getUniqueEntityId();
        EntityList.IDtoClassMapping.put(id, entity);
        EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id, primaryColor, secondaryColor));
    }
}
