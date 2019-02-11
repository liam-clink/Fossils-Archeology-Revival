package fossilsarcheology.server.item;

import fossilsarcheology.server.api.DefaultRenderedItem;
import fossilsarcheology.server.entity.prehistoric.PrehistoricEntityType;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;

public class ItemDinoMeat extends ItemFood implements DefaultRenderedItem {
    public final String resourceName;

    public ItemDinoMeat(int amount, float saturation, boolean isWolfMeat, String name, PrehistoricEntityType type) {
        super(amount, saturation, isWolfMeat);
        this.resourceName = type.resourceName + "_" + name;
    }

    @Override
    public String getResource(ResourceLocation registryName) {
        return this.resourceName;
    }
}
