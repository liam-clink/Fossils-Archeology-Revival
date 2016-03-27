package com.github.revival.server.item;

import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.entity.EntityStoneboard;
import com.github.revival.server.handler.FossilAchievementHandler;
import com.github.revival.server.handler.LocalizationStrings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.world.World;

public class StoneBoardItem extends Item {
    public StoneBoardItem() {
        this.setCreativeTab(CreativeTabs.tabDecorations);
        setUnlocalizedName(LocalizationStrings.TABLET_NAME);
        setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
    }

    public boolean onItemUse(ItemStack var1, EntityPlayer var2, World world, int x, int y, int z, int direction, float par8, float par9, float par10) {
        if (direction == 0 || direction == 1) {
            return false;
        } else {
            int var11 = Direction.facingToDirection[direction];
            EntityStoneboard var12 = new EntityStoneboard(world, x, y, z, var11);

            if (!var2.canPlayerEdit(x, y, z, direction, var1)) {
                return false;
            } else {
                if (var12 != null && var12.onValidSurface()) {
                    if (!world.isRemote) {
                        world.spawnEntityInWorld(var12);
                    }
                    var2.addStat(FossilAchievementHandler.tablet, 1);

                    --var1.stackSize;
                }

                return true;
            }
        }
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("fossil:Stone_Tablet");
    }
}
