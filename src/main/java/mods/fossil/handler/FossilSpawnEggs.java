package mods.fossil.handler;

import mods.fossil.entity.mob.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;

public class FossilSpawnEggs
{
    static int startEntityId = 300;

    public static void addSpawnEggs()
    {														//bg		//fg
        registerEntityEgg(EntityTriceratops.class, 			0x62d84e, 0xebffd5);
        registerEntityEgg(EntitySarcosuchus.class,          0x2B2B1E, 0x72715B);
        registerEntityEgg(EntityVelociraptor.class, 		0xbfa487, 0x936d2e);
        registerEntityEgg(EntityTRex.class, 				0x763c11, 0xffebc4);
        registerEntityEgg(EntityFailuresaurus.class, 		0x61ffbd, 0xf4eee6);
		registerEntityEgg(EntityPigBoss.class, 				0x000000, 0xff0000);
        registerEntityEgg(EntityPterosaur.class, 			0xe4cae2, 0x751075);
        registerEntityEgg(EntityNautilus.class, 			0xd4aba9, 0x97312f);
        registerEntityEgg(EntityPlesiosaur.class, 			0xa4362e, 0xcd6052);
        registerEntityEgg(EntityMosasaurus.class, 			0x9cbd8c, 0x357510);
        registerEntityEgg(EntityStegosaurus.class, 			0xbfc9a9, 0x5e7510);
        registerEntityEgg(EntityDilophosaurus.class,		0x474807, 0x9f9e4e);
        registerEntityEgg(EntitySmilodon.class, 			0xefa745, 0xf9f4df);
        registerEntityEgg(EntityBones.class, 				0xffffff, 0x000000);
        registerEntityEgg(EntityBrachiosaurus.class, 		0x5283bf, 0xffffff);
        registerEntityEgg(EntityMammoth.class, 				0x3d2700, 0xcc9566);
        registerEntityEgg(EntitySpinosaurus.class, 			0x9f9e4e, 0x474807);
        registerEntityEgg(EntityCompsognathus.class, 		0x357510, 0x66a24a);
        registerEntityEgg(EntityDodo.class, 				0x784830, 0xb59586);
        registerEntityEgg(EntityAnkylosaurus.class, 		0xffebc4, 0x763c11);
        registerEntityEgg(EntityPachycephalosaurus.class, 	0xdac49d, 0xa86722);
        registerEntityEgg(EntityDeinonychus.class, 			0x6a6a6a, 0x2f302e);
        registerEntityEgg(EntityGallimimus.class, 			0x8c5517, 0x544833);
        registerEntityEgg(EntityCoelacanth.class, 			0x5283bf, 0x66a24a);
        registerEntityEgg(EntityLiopleurodon.class, 		0x000000, 0xffffff);
        registerEntityEgg(EntityQuagga.class, 				0x8c4b2e, 0xc6a999);
        registerEntityEgg(EntityTerrorBird.class, 			0x689d94, 0x151917);
        registerEntityEgg(EntityAllosaurus.class, 			0x813030, 0x24496e);
        registerEntityEgg(EntityElasmotherium.class, 		0xcc9566, 0x3d2700);
        registerEntityEgg(EntityConfuciusornis.class, 		0xA4A2A5, 0x773C00);
        registerEntityEgg(EntityCeratosaurus.class, 		0x678A5A, 0xD6C78D);
        registerEntityEgg(EntityAnubite.class, 				0x381A1F, 0x732A19);
        registerEntityEgg(EntitySentryPigman.class, 		15373203, 0xD0A750);

    }

    public static int getUniqueEntityId()
    {
        do
        {
            startEntityId++;
        }
        while (EntityList.getStringFromID(startEntityId) != null);

        return startEntityId;
    }

    public static void registerEntityEgg(Class <? extends Entity > entity, int primaryColor, int secondaryColor)
    {
        int id = getUniqueEntityId();
        EntityList.IDtoClassMapping.put(id, entity);
        EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id, primaryColor, secondaryColor));
    }
}
