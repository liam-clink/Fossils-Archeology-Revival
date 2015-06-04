package mods.fossil.core;

import mods.fossil.Fossil;
import net.minecraft.init.Blocks;

public class FossilFireSupport {
	public static void setFireInfo(){
		Blocks.fire.setFireInfo(Fossil.palmLeaves, 30, 60);
		Blocks.fire.setFireInfo(Fossil.palmLog, 5, 20);
		Blocks.fire.setFireInfo(Fossil.palaePlanks, 5, 20);
		Blocks.fire.setFireInfo(Fossil.palaeStairs, 5, 20);
		Blocks.fire.setFireInfo(Fossil.palaeSingleSlab, 5, 20);
		Blocks.fire.setFireInfo(Fossil.palaeDoubleSlab, 5, 20);
		Blocks.fire.setFireInfo(Fossil.blockworktableIdle, 5, 20);
		Blocks.fire.setFireInfo(Fossil.blockworktableActive, 5, 20);
		Blocks.fire.setFireInfo(Fossil.ancientWood, 5, 20);
		Blocks.fire.setFireInfo(Fossil.ancientWoodPillar, 5, 20);
		Blocks.fire.setFireInfo(Fossil.ancientWoodPlate, 5, 20);
		Blocks.fire.setFireInfo(Fossil.ancientWoodStairs, 5, 20);
		Blocks.fire.setFireInfo(Fossil.ancientWoodSingleSlab, 5, 20);
		Blocks.fire.setFireInfo(Fossil.ancientWoodDoubleSlab, 5, 20);
		Blocks.fire.setFireInfo(Fossil.ferns, 30, 60);
		Blocks.fire.setFireInfo(FossilPlants.bennettitales_large, 60, 100);
		Blocks.fire.setFireInfo(FossilPlants.bennettitales_small, 60, 100);
		Blocks.fire.setFireInfo(FossilPlants.cephalotaxus, 60, 100);
		Blocks.fire.setFireInfo(FossilPlants.dillhoffia, 60, 100);
		Blocks.fire.setFireInfo(FossilPlants.horsetail_large, 60, 100);
		Blocks.fire.setFireInfo(FossilPlants.horsetail_small, 60, 100);
		Blocks.fire.setFireInfo(FossilPlants.licopodiophyta, 60, 100);
		Blocks.fire.setFireInfo(FossilPlants.mutantPlant, 60, 100);
		Blocks.fire.setFireInfo(FossilPlants.paleopanax, 60, 100);
		Blocks.fire.setFireInfo(FossilPlants.sarracina, 60, 100);
		Blocks.fire.setFireInfo(FossilPlants.welwitschia, 60, 100);
		Blocks.fire.setFireInfo(FossilPlants.zamites, 60, 100);
	}
}
