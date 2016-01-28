package com.github.revival.common.block;

import net.minecraftforge.fluids.Fluid;

public class FluidTar extends Fluid
{
	public FluidTar(String fluidName) 
	{
		super(fluidName);
		this.setViscosity(6000);
		//this.setIcons(this.block.getIcon(0, 0), this.block.getIcon(0, 0)); Nope!
	}

}
