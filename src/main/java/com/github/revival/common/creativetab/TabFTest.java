package com.github.revival.common.creativetab;

import com.github.revival.common.block.FABlockRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabFTest extends CreativeTabs
{

    public TabFTest(String title)
    {
        super(title);
    }

    @Override
    public Item getTabIconItem()
    {
        return Item.getItemFromBlock(FABlockRegistry.blockTimeMachine);
    }

}
