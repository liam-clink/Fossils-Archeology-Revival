package com.github.revival.server.block;

import net.minecraftforge.fluids.Fluid;

public class FluidTar extends Fluid {
    public FluidTar(String fluidName) {
        super(fluidName);
        this.setViscosity(8000);
        this.setIcons(BlockTar.tar_still, BlockTar.tar_flowing);
    }

}
