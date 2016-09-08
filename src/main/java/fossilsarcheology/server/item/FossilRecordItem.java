package fossilsarcheology.server.item;

import fossilsarcheology.server.creativetab.FATabRegistry;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.SoundEvent;

public class FossilRecordItem extends ItemRecord {
    public final String recordName;
    public final String texture;

    public FossilRecordItem(String name, String texture, SoundEvent sound) {
        super(name, sound);
        this.recordName = name;
        this.maxStackSize = 1;
        this.texture = texture;
        this.setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
    }
}