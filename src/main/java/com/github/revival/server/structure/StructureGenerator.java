package com.github.revival.server.structure;

import com.github.revival.server.structure.util.StructureGeneratorBase;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class StructureGenerator extends StructureGeneratorBase {
	public StructureGenerator() {

	}

	public StructureGenerator(Entity entity, int[][][][] blocks) {
		super(entity, blocks);
	}

	public StructureGenerator(Entity entity, int[][][][] blocks, int structureFacing) {
		super(entity, blocks, structureFacing);
	}

	public StructureGenerator(Entity entity, int[][][][] blocks, int structureFacing, int offX, int offY, int offZ) {
		super(entity, blocks, structureFacing, offX, offY, offZ);
	}

	@Override
	public int getRealBlockID(int fakeID, int customData1) {
		return 0;
	}

	@Override
	public void onCustomBlockAdded(World world, int x, int y, int z, int fakeID, int customData1, int customData2) {

	}
}
