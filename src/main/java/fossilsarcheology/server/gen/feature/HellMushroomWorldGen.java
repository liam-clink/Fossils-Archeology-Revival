package fossilsarcheology.server.gen.feature;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class HellMushroomWorldGen extends WorldGenerator {
    /**
     * The mushroom type. 0 for brown, 1 for red.
     */
    private int mushroomType = -1;

    public HellMushroomWorldGen(int type) {
        super(true);
        this.mushroomType = type;
    }

    public HellMushroomWorldGen() {
        super(false);
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {
        int mushroomType = rand.nextInt(2);

        if (this.mushroomType >= 0) {
            mushroomType = this.mushroomType;
        }

        int height = rand.nextInt(3) + 4;
        boolean hasSpace = true;

        if (y >= 1 && y + height + 1 < 256) {
            int k1;
            int l1;

            for (int j1 = y; j1 <= y + 1 + height; ++j1) {
                byte b0 = 3;

                if (j1 <= y + 3) {
                    b0 = 0;
                }

                for (k1 = x - b0; k1 <= x + b0 && hasSpace; ++k1) {
                    for (l1 = z - b0; l1 <= z + b0 && hasSpace; ++l1) {
                        if (j1 >= 0 && j1 < 256) {
                            Block block = world.getBlock(k1, j1, l1);

                            if (!block.isAir(world, k1, j1, l1) && !block.isLeaves(world, k1, j1, l1)) {
                                hasSpace = false;
                            }
                        } else {
                            hasSpace = false;
                        }
                    }
                }
            }

            if (!hasSpace) {
                return false;
            } else {
                Block generateOn = world.getBlock(x, y - 1, z);

                if (generateOn != Blocks.dirt && generateOn != Blocks.grass && generateOn != Blocks.netherrack) {
                    return false;
                } else {
                    int topHeight = y + height;

                    if (mushroomType == 1) {
                        topHeight = y + height - 3;
                    }

                    for (k1 = topHeight; k1 <= y + height; ++k1) {
                        l1 = 1;

                        if (k1 < y + height) {
                            ++l1;
                        }

                        if (mushroomType == 0) {
                            l1 = 3;
                        }

                        for (int l2 = x - l1; l2 <= x + l1; ++l2) {
                            for (int i2 = z - l1; i2 <= z + l1; ++i2) {
                                int j2 = 5;

                                if (l2 == x - l1) {
                                    --j2;
                                }

                                if (l2 == x + l1) {
                                    ++j2;
                                }

                                if (i2 == z - l1) {
                                    j2 -= 3;
                                }

                                if (i2 == z + l1) {
                                    j2 += 3;
                                }

                                if (mushroomType == 0 || k1 < y + height) {
                                    if ((l2 == x - l1 || l2 == x + l1) && (i2 == z - l1 || i2 == z + l1)) {
                                        continue;
                                    }

                                    if (l2 == x - (l1 - 1) && i2 == z - l1) {
                                        j2 = 1;
                                    }

                                    if (l2 == x - l1 && i2 == z - (l1 - 1)) {
                                        j2 = 1;
                                    }

                                    if (l2 == x + (l1 - 1) && i2 == z - l1) {
                                        j2 = 3;
                                    }

                                    if (l2 == x + l1 && i2 == z - (l1 - 1)) {
                                        j2 = 3;
                                    }

                                    if (l2 == x - (l1 - 1) && i2 == z + l1) {
                                        j2 = 7;
                                    }

                                    if (l2 == x - l1 && i2 == z + (l1 - 1)) {
                                        j2 = 7;
                                    }

                                    if (l2 == x + (l1 - 1) && i2 == z + l1) {
                                        j2 = 9;
                                    }

                                    if (l2 == x + l1 && i2 == z + (l1 - 1)) {
                                        j2 = 9;
                                    }
                                }

                                if (j2 == 5 && k1 < y + height) {
                                    j2 = 0;
                                }

                                if ((j2 != 0 || y >= y + height - 1) && world.getBlock(l2, k1, i2).canBeReplacedByLeaves(world, l2, k1, i2)) {
                                    this.setBlockAndNotifyAdequately(world, l2, k1, i2, Block.getBlockById(Block.getIdFromBlock(Blocks.brown_mushroom_block) + mushroomType), j2);
                                }
                            }
                        }
                    }

                    for (k1 = 0; k1 < height; ++k1) {
                        Block block2 = world.getBlock(x, y + k1, z);

                        if (block2.canBeReplacedByLeaves(world, x, y + k1, z)) {
                            this.setBlockAndNotifyAdequately(world, x, y + k1, z, Block.getBlockById(Block.getIdFromBlock(Blocks.brown_mushroom_block) + mushroomType), 10);
                        }
                    }

                    return true;
                }
            }
        } else {
            return false;
        }
    }
}