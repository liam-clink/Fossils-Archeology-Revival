package fossilsarcheology.server.handler;

import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.mob.EntityPregnantCow;
import fossilsarcheology.server.entity.mob.EntityPregnantHorse;
import fossilsarcheology.server.entity.mob.EntityPregnantPig;
import fossilsarcheology.server.entity.mob.EntityPregnantSheep;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FossilInteractEvent {
    @SubscribeEvent
    public void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        EntityPlayer player = event.getEntityPlayer();
        ItemStack stack = player.inventory.getCurrentItem();
        if (event.getTarget() != null) {
            if (stack != null) {
                if (event.getTarget() instanceof EntityHorse) {
                    if (player.getHeldItem(event.getHand()).getItem() == FAItemRegistry.INSTANCE.dinoPedia) {
                        EntityPregnantHorse props = EntityPregnantHorse.get((EntityHorse) event.getTarget());
                        if (props.Embryo != null) {
                            props.setPedia();
                            player.openGui(Revival.INSTANCE, 4, event.getTarget().worldObj, (int) event.getTarget().posX, (int) event.getTarget().posY, (int) event.getTarget().posZ);
                        }
                    } else {
                        ((EntityHorse) event.getTarget()).processInteract(player, event.getHand(), stack);
                    }
                }
                if (event.getTarget() instanceof EntityCow) {
                    if (player.getHeldItem(event.getHand()).getItem() == FAItemRegistry.INSTANCE.dinoPedia) {
                        EntityPregnantCow props = EntityPregnantCow.get((EntityCow) event.getTarget());

                        if (props.embryo != null) {
                            props.setPedia();
                            player.openGui(Revival.INSTANCE, 4, event.getTarget().worldObj, (int) event.getTarget().posX, (int) event.getTarget().posY, (int) event.getTarget().posZ);
                        }
                    } else {
                        ((EntityCow) event.getTarget()).processInteract(player, event.getHand(), stack);
                    }
                }
                if (event.getTarget() instanceof EntityPig) {
                    if (player.getHeldItem(event.getHand()).getItem() == FAItemRegistry.INSTANCE.dinoPedia) {
                        EntityPregnantPig props = EntityPregnantPig.get((EntityPig) event.getTarget());

                        if (props.embryo != null) {
                            props.setPedia();
                            player.openGui(Revival.INSTANCE, 4, event.getTarget().worldObj, (int) event.getTarget().posX, (int) event.getTarget().posY, (int) event.getTarget().posZ);
                        }
                    } else {
                        ((EntityPig) event.getTarget()).processInteract(player, event.getHand(), stack);
                    }
                }
                if (event.getTarget() instanceof EntitySheep) {
                    if (player.getHeldItem(event.getHand()).getItem() == FAItemRegistry.INSTANCE.dinoPedia) {
                        EntityPregnantSheep props = EntityPregnantSheep.get((EntitySheep) event.getTarget());
                        if (props.embryo != null) {
                            props.setPedia();
                            player.openGui(Revival.INSTANCE, 4, event.getTarget().worldObj, (int) event.getTarget().posX, (int) event.getTarget().posY, (int) event.getTarget().posZ);
                        }
                    } else {
                        ((EntitySheep) event.getTarget()).processInteract(player, event.getHand(), stack);
                    }
                }
            }
        }
    }
}
