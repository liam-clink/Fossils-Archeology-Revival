package fossilsarcheology.server.creativetab;

import net.minecraft.creativetab.CreativeTabs;

public enum FATabRegistry {
    INSTANCE;

    public CreativeTabs tabFBlocks;
    public CreativeTabs tabFItems;

    public void init() {
        tabFBlocks = new TabFBlocks("Fossil Blocks");
        tabFItems = new TabFItems("Fossil Items");
    }
}