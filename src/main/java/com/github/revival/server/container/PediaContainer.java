package com.github.revival.server.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class PediaContainer extends Container {
    @Override
    public boolean canInteractWith(EntityPlayer var1) {
        return false;
    }
}
