package fossilsarcheology.server.gen.structure.academy;

import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.enums.PrehistoricEntityType;
import fossilsarcheology.server.item.FAItemRegistry;
import fossilsarcheology.server.structure.util.CustomBlock;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.nio.ByteBuffer;
import java.util.Random;

import static fossilsarcheology.server.structure.util.StructureGeneratorBase.addItemToInventory;

public class AcademyUtil {
    public static final CustomBlock CHEST = new CustomBlock() {
        @Override
        public IBlockState getBlock(World world, BlockPos position, ByteBuffer data) {
            return Blocks.CHEST.getDefaultState();
        }

        @Override
        public void onPlace(World world, BlockPos position, ByteBuffer data) {
            Random rand = new Random();
            int lootType = data.getInt();
            if (lootType == AcademyUtil.RARE_LOOT_F1) {
                for (int iterate = 0; iterate < rand.nextInt(3) + 3; iterate++) {
                    int i = rand.nextInt(PrehistoricEntityType.values().length + 1); // +1
                    Item item;
                    if (i == 0) {
                        item = FAItemRegistry.INSTANCE.brokenSapling;
                    } else {
                        item = PrehistoricEntityType.values()[i - 1].dnaItem;
                    }
                    int loot = (int) (Math.random() * 100);
                    if (loot < 80) {
                        addItemToInventory(world, new ItemStack(item, rand.nextInt(4) + 1), position);
                    } else {
                        addItemToInventory(world, new ItemStack(item, 1), position);
                    }
                }
            } else if (lootType == AcademyUtil.COMMON_LOOT_F1) {
                for (int iterate = 0; iterate < rand.nextInt(12); iterate++) {
                    int loot = rand.nextInt(100);
                    if (loot < 30) {
                        addItemToInventory(world, new ItemStack(Items.PAPER, rand.nextInt(22)), position);
                    } else if (loot < 40) {
                        addItemToInventory(world, new ItemStack(Items.BOOK, rand.nextInt(12)), position);
                    } else if (loot < 50) {
                        addItemToInventory(world, new ItemStack(Items.BONE, rand.nextInt(22)), position);
                    } else if (loot < 60) {
                        addItemToInventory(world, new ItemStack(Items.WRITABLE_BOOK, rand.nextInt(5)), position);
                    } else if (loot < 75) {
                        addItemToInventory(world, new ItemStack(FAItemRegistry.INSTANCE.biofossil, rand.nextInt(22)), position);
                    } else if (loot < 85) {
                        addItemToInventory(world, new ItemStack(FAItemRegistry.INSTANCE.woodjavelin, rand.nextInt(16)), position);
                    } else if (loot < 95) {
                        addItemToInventory(world, new ItemStack(FAItemRegistry.INSTANCE.stonejavelin, rand.nextInt(16)), position);
                    } else if (loot < 101) {
                        addItemToInventory(world, new ItemStack(FABlockRegistry.INSTANCE.drum, 1), position);
                    }
                }
            } else if (lootType == AcademyUtil.RARE_LOOT_F2) {
                for (int iterate = 0; iterate < rand.nextInt(1) + 3; iterate++) {
                    int i = rand.nextInt(10);
                    if (i < 3) {
                        addItemToInventory(world, new ItemStack(FAItemRegistry.INSTANCE.dinoPedia, rand.nextInt(1) + 1), position);
                    } else if (i < 7) {
                        addItemToInventory(world, new ItemStack(FAItemRegistry.INSTANCE.relic, rand.nextInt(9) + 1), position);
                    } else {
                        addItemToInventory(world, new ItemStack(FAItemRegistry.INSTANCE.potteryShards, rand.nextInt(9) + 1), position);
                    }
                }
            } else if (lootType == AcademyUtil.COMMON_LOOT_F2) {
                for (int iterate = 0; iterate < rand.nextInt(12); iterate++) {
                    int loot = rand.nextInt(100);
                    if (loot < 40) {
                        addItemToInventory(world, new ItemStack(Items.PAPER, rand.nextInt(22)), position);
                    } else if (loot < 60) {
                        addItemToInventory(world, new ItemStack(Items.DYE, 0, rand.nextInt(10)), position);
                    } else if (loot < 80) {
                        addItemToInventory(world, new ItemStack(Items.STRING, rand.nextInt(10)), position);
                    } else if (loot < 90) {
                        addItemToInventory(world, new ItemStack(Items.COMPASS, rand.nextInt(2)), position);
                    } else if (loot < 101) {
                        addItemToInventory(world, new ItemStack(Items.MAP, rand.nextInt(5)), position);
                    }
                }
            } else if (lootType == AcademyUtil.RARE_LOOT_F3) {
                for (int iterate = 0; iterate < rand.nextInt(4); iterate++) {
                    int loot = rand.nextInt(100);
                    if (loot < 20) {
                        addItemToInventory(world, new ItemStack(FABlockRegistry.INSTANCE.ancientGlass, rand.nextInt(10)), position);
                    } else if (loot < 40) {
                        addItemToInventory(world, new ItemStack(FABlockRegistry.INSTANCE.ancientWood, rand.nextInt(15)), position);
                    } else if (loot < 50) {
                        addItemToInventory(world, new ItemStack(FAItemRegistry.INSTANCE.whip, 1), position);
                    } else if (loot < 60) {
                        addItemToInventory(world, (new ItemStack(Item.getItemFromBlock(FABlockRegistry.INSTANCE.figurineBlock), rand.nextInt(2), rand.nextInt(15))), position);
                    } else if (loot < 80) {
                        addItemToInventory(world, new ItemStack(Items.IRON_INGOT, rand.nextInt(15)), position);
                    } else if (loot < 90) {
                        addItemToInventory(world, new ItemStack(FAItemRegistry.INSTANCE.fossilrecordBones, 1), position);
                    } else if (loot < 101) {
                        addItemToInventory(world, new ItemStack(Items.NAME_TAG, rand.nextInt(2)), position);
                    }
                }
            } else if (lootType == AcademyUtil.TEMPLE_COMMON_LOOT) {
                for (int iterate = 0; iterate < rand.nextInt(4); iterate++) {
                    int loot = rand.nextInt(100);
                    if (loot < 40) {
                        addItemToInventory(world, new ItemStack(Items.GOLD_NUGGET, rand.nextInt(16) + 12), position);
                    } else if (loot < 50) {
                        addItemToInventory(world, new ItemStack(FAItemRegistry.INSTANCE.goldjavelin, rand.nextInt(10) + 1), position);
                    } else if (loot < 60) {
                        addItemToInventory(world, (new ItemStack(Item.getItemFromBlock(FABlockRegistry.INSTANCE.figurineBlock), rand.nextInt(2), rand.nextInt(15))), position);
                    } else if (loot < 80) {
                        addItemToInventory(world, new ItemStack(Items.GOLD_INGOT, rand.nextInt(5) + 1), position);
                    } else if (loot < 90) {
                        addItemToInventory(world, new ItemStack(FAItemRegistry.INSTANCE.fossilrecordBones, 1), position);
                    } else if (loot < 101) {
                        addItemToInventory(world, new ItemStack(Items.NAME_TAG, rand.nextInt(2)), position);
                    }
                }
            } else if (lootType == AcademyUtil.TEMPLE_RARE_LOOT) {
                int loot = rand.nextInt(100);
                if (loot < 90) {
                    addItemToInventory(world, new ItemStack(FAItemRegistry.INSTANCE.goldjavelin, rand.nextInt(11) + 1), position);
                    addItemToInventory(world, new ItemStack(Items.EMERALD, rand.nextInt(5)), position);
                } else {
                    addItemToInventory(world, new ItemStack(FAItemRegistry.INSTANCE.goldjavelin, rand.nextInt(10) + 3), position);
                    addItemToInventory(world, new ItemStack(FAItemRegistry.INSTANCE.diamondjavelin, rand.nextInt(10) + 1), position);
                    addItemToInventory(world, new ItemStack(FAItemRegistry.INSTANCE.relic, rand.nextInt(20)), position);
                    addItemToInventory(world, new ItemStack(FAItemRegistry.INSTANCE.skullStick, rand.nextInt(1)), position);
                    addItemToInventory(world, new ItemStack(Items.EMERALD, rand.nextInt(5) + 3), position);
                }
            }
        }
    };

    public static final int CUSTOM_DISPENSER = 4098, ITEM_FRAME = 4099, PAINTING = 4100, SPAWN_VILLAGER = 4101, CUSTOM_SKULL = 4102, CUSTOM_SIGNWALL = 4103, CUSTOM_SIGNPOST = 4104, RANDOM_HOLE = 4105, RANDOM_HOLE_L2 = 4106, RANDOM_HOLE_L3 = 4107, BIOME_BLOCK = 4108;

    public static final int RARE_LOOT_F1 = -1;
    public static final int COMMON_LOOT_F1 = -2;
    public static final int RARE_LOOT_F2 = -3;
    public static final int COMMON_LOOT_F2 = -4;
    public static final int RARE_LOOT_F3 = -5;
    public static final int COMMON_LOOT_F3 = -6;

    public static final int TEMPLE_COMMON_LOOT = -7;
    public static final int TEMPLE_RARE_LOOT = -8;

    public static final int CUSTOM_SIGN_1 = 1;
}
