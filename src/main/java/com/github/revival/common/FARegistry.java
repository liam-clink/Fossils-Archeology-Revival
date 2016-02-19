package com.github.revival.common;

import net.ilexiconn.llibrary.common.content.IContentHandler;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public abstract class FARegistry implements IContentHandler
{
    public abstract void initCreativeTabs();

    public void setCreativeTab(CreativeTabs creativeTab, Block... blocks)
    {
        for (Block block : blocks) block.setCreativeTab(creativeTab);
    }

    public void setCreativeTab(CreativeTabs creativeTab, Item... items)
    {
        for (Item item : items) item.setCreativeTab(creativeTab);
    }
}
