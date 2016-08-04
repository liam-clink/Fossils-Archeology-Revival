package fossilsarcheology.server.handler;

import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.enchantment.FAEnchantmentRegistry;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FossilToolEvent {
    private int paleontologyBonus;
    private int archeologyBonus;

    private boolean hasPaleontologyBonus = false;
    private boolean hasArcheologyBonus = false;

    @SubscribeEvent
    public void onHarvestBlocks(BlockEvent.HarvestDropsEvent event) {
        Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
        EntityPlayer player = event.getHarvester();

        if (player != null) {
            paleontologyBonus = EnchantmentHelper.getEnchantmentLevel(FAEnchantmentRegistry.INSTANCE.paleontology, player.inventory.getCurrentItem());
            archeologyBonus = EnchantmentHelper.getEnchantmentLevel(FAEnchantmentRegistry.INSTANCE.archeology, player.inventory.getCurrentItem());

            if (player.inventory.getCurrentItem() == null) {
                return;
            } else {
                if (paleontologyBonus > 0) {
                    hasPaleontologyBonus = true;
                }
                if (archeologyBonus > 0) {
                    hasArcheologyBonus = true;
                }
            }

            if (hasPaleontologyBonus) {

                if (block == FABlockRegistry.INSTANCE.blockFossil) {
                    switch (paleontologyBonus) {
                        case 1:
                            if (player.worldObj.rand.nextFloat() < 0.70) {
                                event.getDrops().remove(0);
                                event.getDrops().add(new ItemStack(FAItemRegistry.INSTANCE.biofossil, 1));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (player.worldObj.rand.nextFloat() < 0.80) {
                                event.getDrops().remove(0);
                                event.getDrops().add(new ItemStack(FAItemRegistry.INSTANCE.biofossil, 1));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (player.worldObj.rand.nextFloat() < 0.90) {
                                event.getDrops().remove(0);
                                event.getDrops().add(new ItemStack(FAItemRegistry.INSTANCE.biofossil, 1));
                                break;
                            } else {
                                break;
                            }
                        default:
                            break;
                    }
                }

                if (block == FABlockRegistry.INSTANCE.blockPermafrost) {
                    switch (paleontologyBonus) {
                        case 1:
                            if (player.worldObj.rand.nextFloat() < 0.50) {
                                event.getDrops().remove(0);
                                event.getDrops().add(new ItemStack(FAItemRegistry.INSTANCE.icedMeat, 1));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (player.worldObj.rand.nextFloat() < 0.70) {
                                event.getDrops().remove(0);
                                event.getDrops().add(new ItemStack(FAItemRegistry.INSTANCE.icedMeat, 1));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (player.worldObj.rand.nextFloat() < 0.90) {
                                event.getDrops().remove(0);
                                event.getDrops().add(new ItemStack(FAItemRegistry.INSTANCE.icedMeat, 1));
                                break;
                            } else {
                                break;
                            }
                        default:
                            break;
                    }
                }
            }

            // Handle archeology bonus
            if (hasArcheologyBonus) {
                int rand = player.worldObj.rand.nextInt(1000);

                if (block == FABlockRegistry.INSTANCE.blockFossil) {
                    switch (archeologyBonus) {
                        case 1:
                            if (rand < 500) {
                                event.getDrops().remove(0);
                                event.getDrops().add(new ItemStack(FAItemRegistry.INSTANCE.relic, 1));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (rand < 700) {
                                event.getDrops().remove(0);
                                event.getDrops().add(new ItemStack(FAItemRegistry.INSTANCE.relic, 1));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (rand < 900) {
                                event.getDrops().remove(0);
                                event.getDrops().add(new ItemStack(FAItemRegistry.INSTANCE.relic, 1));
                                break;
                            } else if (rand < 904) {
                                event.getDrops().remove(0);
                                event.getDrops().add(new ItemStack(FAItemRegistry.INSTANCE.gem, 1));
                                break;
                            } else {
                                break;
                            }
                        default:
                            break;
                    }
                }
            }
        }
    }
}
