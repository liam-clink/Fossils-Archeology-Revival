package com.github.revival.common.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MaterialTar extends Material {

    public MaterialTar(MapColor color) {
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
