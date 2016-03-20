package com.github.revival.server.creativetab;

import net.ilexiconn.llibrary.common.content.IContentHandler;
import net.minecraft.creativetab.CreativeTabs;

public class FATabRegistry implements IContentHandler {
    public static CreativeTabs tabFBlocks;
    public static CreativeTabs tabFItems;

    public void init() {
        tabFBlocks = new TabFBlocks("Fossil Blocks");
        tabFItems = new TabFItems("Fossil Items");
    }

    public void gameRegistry() throws Exception {

    }
}