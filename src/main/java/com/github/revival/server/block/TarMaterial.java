package com.github.revival.server.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class TarMaterial extends Material {

    public TarMaterial(MapColor color) {
        super(color);
        setNoPushMobility();
    }

    public boolean isLiquid() {
        return true;
    }

    public boolean isSolid() {
        return false;
    }

}
