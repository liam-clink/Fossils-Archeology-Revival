package fossilsarcheology.server.villager;

import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class ArcheaologistProfession extends VillagerRegistry.VillagerProfession {
    public ArcheaologistProfession() {
        super("fossil:archaeologist", "fossil:textures/model/Archaeologist.png", "minecraft:textures/entity/zombie_villager/zombie_villager.png");
        new ArcheaologistCareer(this, "fossil:archaeologist").addTrade(0, new FossilTradeHandler());
    }
}
