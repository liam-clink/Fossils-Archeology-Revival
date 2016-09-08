package fossilsarcheology.server.item;

import fossilsarcheology.server.enums.PrehistoricEntityType;
import net.minecraft.item.Item;

public class AncientEggItem extends Item {
    public static final int TYPE_COUNT = PrehistoricEntityType.values().length;
    private int type;

    public AncientEggItem(int type) {
        super();
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.type = type;
    }
}
