package mods.fossil.gens;

import java.util.Random;

import mods.fossil.Fossil;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenPalaeoraphe extends WorldGenerator {
	public WorldGenPalaeoraphe() {
	}

	public boolean generate(World var1, Random var2, int var3, int var4,
			int var5) {
		Block j1 = var1.getBlock(var3, var4 - 1, var5);

		if (j1 != Blocks.grass && j1 != Blocks.dirt || var4 >= 128 - 12 - 1) {
			return false;
		}

		// int deltaY = 5;
		int deltaY = var2.nextInt(10);

		for (int y = (var4 - 1) + 1; y <= var4 + 10 + deltaY; y++) {
			var1.setBlock(var3, y, var5, Fossil.palmLog);
		}

		var4 = var4 - 5 + deltaY;
		var1.setBlock(var3, var4 + 16, var5, Fossil.palmLeaves);
		var1.setBlock(var3 + 1, var4 + 15, var5, Fossil.palmLeaves);
		var1.setBlock(var3 + 2, var4 + 15, var5, Fossil.palmLeaves);
		var1.setBlock(var3 + 3, var4 + 15, var5, Fossil.palmLeaves);
		var1.setBlock(var3 + 4, var4 + 15, var5, Fossil.palmLeaves);
		var1.setBlock(var3 + 5, var4 + 14, var5, Fossil.palmLeaves);
		var1.setBlock(var3, var4 + 15, var5 + 1, Fossil.palmLeaves);
		var1.setBlock(var3, var4 + 15, var5 + 2, Fossil.palmLeaves);
		var1.setBlock(var3, var4 + 15, var5 + 3, Fossil.palmLeaves);
		var1.setBlock(var3, var4 + 15, var5 + 4, Fossil.palmLeaves);
		var1.setBlock(var3, var4 + 14, var5 + 5, Fossil.palmLeaves);
		var1.setBlock(var3 - 1, var4 + 15, var5, Fossil.palmLeaves);
		var1.setBlock(var3 - 2, var4 + 15, var5, Fossil.palmLeaves);
		var1.setBlock(var3 - 3, var4 + 15, var5, Fossil.palmLeaves);
		var1.setBlock(var3 - 4, var4 + 15, var5, Fossil.palmLeaves);
		var1.setBlock(var3 - 5, var4 + 14, var5, Fossil.palmLeaves);
		var1.setBlock(var3, var4 + 15, var5 - 1, Fossil.palmLeaves);
		var1.setBlock(var3, var4 + 15, var5 - 2, Fossil.palmLeaves);
		var1.setBlock(var3, var4 + 15, var5 - 3, Fossil.palmLeaves);
		var1.setBlock(var3, var4 + 15, var5 - 4, Fossil.palmLeaves);
		var1.setBlock(var3, var4 + 14, var5 - 5, Fossil.palmLeaves);
		var1.setBlock(var3 + 1, var4 + 15, var5 + 1, Fossil.palmLeaves);
		var1.setBlock(var3 + 1, var4 + 15, var5 - 1, Fossil.palmLeaves);
		var1.setBlock(var3 - 1, var4 + 15, var5 + 1, Fossil.palmLeaves);
		var1.setBlock(var3 - 1, var4 + 15, var5 - 1, Fossil.palmLeaves);
		var1.setBlock(var3 + 2, var4 + 15, var5 + 2, Fossil.palmLeaves);
		var1.setBlock(var3 + 2, var4 + 15, var5 - 2, Fossil.palmLeaves);
		var1.setBlock(var3 - 2, var4 + 15, var5 + 2, Fossil.palmLeaves);
		var1.setBlock(var3 - 2, var4 + 15, var5 - 2, Fossil.palmLeaves);
		var1.setBlock(var3 + 3, var4 + 14, var5 + 3, Fossil.palmLeaves);
		var1.setBlock(var3 + 3, var4 + 14, var5 - 3, Fossil.palmLeaves);
		var1.setBlock(var3 - 3, var4 + 14, var5 + 3, Fossil.palmLeaves);
		var1.setBlock(var3 - 3, var4 + 14, var5 - 3, Fossil.palmLeaves);
		/*
		 * var1.setBlockAndMetadata(var3 + 6, var4 + 14, var5,
		 * Fossil.palmLeaves, 0); var1.setBlockAndMetadata(var3, var4 + 13, var5
		 * + 6, Fossil.palmLeaves, 0); var1.setBlockAndMetadata(var3 - 6, var4 +
		 * 13, var5, Fossil.palmLeaves, 0); var1.setBlockAndMetadata(var3, var4
		 * + 13, var5 - 6, Fossil.palmLeaves, 0);
		 */
		return true;
	}
}
