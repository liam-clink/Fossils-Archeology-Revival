package com.github.revival.server.gen.feature;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class TarPitWorldGen extends WorldGenerator {
    private Block blockIndex;

    public TarPitWorldGen(Block block) {
        blockIndex = block;
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        x -= 8;
        Block block = world.getBlock(x, y, z);

        if (block != Blocks.grass) {
            return false;
        }

        for (z -= 8; y > 5 && world.isAirBlock(x, y, z); y--) {
        }

        if (y <= 4) {
            return false;
        }

        y -= 4;
        boolean aflag[] = new boolean[2048];
        int rand = random.nextInt(4) + 4;

        for (int j1 = 0; j1 < rand; j1++) {
            double d = random.nextDouble() * 6D + 3D;
            double d1 = random.nextDouble() * 4D + 2D;
            double d2 = random.nextDouble() * 6D + 3D;
            double d3 = random.nextDouble() * (16D - d - 2D) + 1.0D + d / 2D;
            double d4 = random.nextDouble() * (8D - d1 - 4D) + 2D + d1 / 2D;
            double d5 = random.nextDouble() * (16D - d2 - 2D) + 1.0D + d2 / 2D;

            for (int i3 = 1; i3 < 15; i3++) {
                for (int j3 = 1; j3 < 15; j3++) {
                    for (int k3 = 1; k3 < 7; k3++) {
                        double d6 = ((double) i3 - d3) / (d / 2D);
                        double d7 = ((double) k3 - d4) / (d1 / 2D);
                        double d8 = ((double) j3 - d5) / (d2 / 2D);
                        double d9 = d6 * d6 + d7 * d7 + d8 * d8;

                        if (d9 < 1.0D) {
                            aflag[(i3 * 16 + j3) * 8 + k3] = true;
                        }
                    }
                }
            }
        }

        for (int k1 = 0; k1 < 16; k1++) {
            for (int i2 = 0; i2 < 16; i2++) {
                for (int k2 = 0; k2 < 8; k2++) {
                    boolean flag = !aflag[(k1 * 16 + i2) * 8 + k2]
                            && (k1 < 15 && aflag[((k1 + 1) * 16 + i2) * 8 + k2]
                            || k1 > 0
                            && aflag[((k1 - 1) * 16 + i2) * 8 + k2]
                            || i2 < 15
                            && aflag[(k1 * 16 + (i2 + 1)) * 8 + k2]
                            || i2 > 0
                            && aflag[(k1 * 16 + (i2 - 1)) * 8 + k2]
                            || k2 < 7
                            && aflag[(k1 * 16 + i2) * 8 + (k2 + 1)] || k2 > 0
                            && aflag[(k1 * 16 + i2) * 8 + (k2 - 1)]);

                    if (!flag) {
                        continue;
                    }

                    Material material = world.getBlock(x + k1, y + k2, z + i2)
                            .getMaterial();

                    if (k2 >= 4 && material.isLiquid()) {
                        return false;
                    }

                    if (k2 < 4
                            && !material.isSolid()
                            && world.getBlock(x + k1, y + k2, z + i2) != blockIndex) {
                        return false;
                    }
                }
            }
        }

        for (int l1 = 0; l1 < 16; l1++) {
            for (int j2 = 0; j2 < 16; j2++) {
                for (int l2 = 0; l2 < 8; l2++) {
                    if (aflag[(l1 * 16 + j2) * 8 + l2]) {
                        world.setBlock(x + l1, y + l2, z + j2,
                                (l2 >= 4 ? Blocks.air : blockIndex));
                    }
                }
            }
        }

        return true;
    }
}