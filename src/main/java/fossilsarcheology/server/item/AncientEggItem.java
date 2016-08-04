package fossilsarcheology.server.item;

import fossilsarcheology.server.enums.PrehistoricEntityType;
import net.minecraft.item.Item;

public class AncientEggItem extends Item {
    public static final int TypeCount = PrehistoricEntityType.values().length;
    private int DinoType;

    public AncientEggItem(int DinoType0) {
        super();
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.DinoType = DinoType0;
    }

}
