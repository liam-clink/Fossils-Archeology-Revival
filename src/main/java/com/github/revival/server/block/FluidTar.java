package com.github.revival.server.block;

import net.minecraftforge.fluids.Fluid;

public class FluidTar extends Fluid {
    public FluidTar(String fluidName) {
        super(fluidName);
        this.setViscosity(8000);
        this.setIcons(TarBlock.tar_still, TarBlock.tar_flowing);
    }

}
