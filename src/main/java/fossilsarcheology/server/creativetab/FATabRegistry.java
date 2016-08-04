package fossilsarcheology.server.creativetab;

import net.minecraft.creativetab.CreativeTabs;

public enum FATabRegistry {
    INSTANCE;

    public CreativeTabs BLOCKS;
    public CreativeTabs ITEMS;

    public void init() {
        BLOCKS = new BLOCKS("Fossil Blocks");
        ITEMS = new TabFItems("Fossil Items");
    }
}