package fossilsarcheology.server.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.mob.EntityPregnantCow;
import fossilsarcheology.server.entity.mob.EntityPregnantHorse;
import fossilsarcheology.server.entity.mob.EntityPregnantPig;
import fossilsarcheology.server.entity.mob.EntityPregnantSheep;
import fossilsarcheology.server.enums.EnumPrehistoric;
import fossilsarcheology.server.item.FAItemRegistry;
import fossilsarcheology.server.message.MessageSyncEmbryo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

public class FossilInteractEvent {
    @SubscribeEvent
    public void onEntityInteract(EntityInteractEvent event) {
        EntityPlayer player = event.entityPlayer;
        ItemStack stack = player.inventory.getCurrentItem();
        Entity target = event.target;
        if (target != null) {
            if (stack != null) {
                if (player.getHeldItem().getItem() == FAItemRegistry.INSTANCE.dinoPedia) {
                    if (target instanceof EntityHorse) {
                        EntityPregnantHorse properties = EntityPregnantHorse.get((EntityHorse) target);
                        if (properties.embryo != null) {
                            if (!player.worldObj.isRemote) {
                                Revival.NETWORK_WRAPPER.sendTo(new MessageSyncEmbryo(target, properties.embryo, properties.embryoProgress), (EntityPlayerMP) player);
                            }
                            properties.setPedia();
                            player.openGui(Revival.INSTANCE, 4, target.worldObj, (int) target.posX, (int) target.posY, (int) target.posZ);
                        }
                    } else if (target instanceof EntityCow) {
                        EntityPregnantCow properties = EntityPregnantCow.get((EntityCow) target);
                        if (properties.embryo != null) {
                            if (!player.worldObj.isRemote) {
                                Revival.NETWORK_WRAPPER.sendTo(new MessageSyncEmbryo(target, properties.embryo, properties.embryoProgress), (EntityPlayerMP) player);
                            }
                            properties.setPedia();
                            player.openGui(Revival.INSTANCE, 4, target.worldObj, (int) target.posX, (int) target.posY, (int) target.posZ);
                        }
                    } else if (target instanceof EntityPig) {
                        EntityPregnantPig properties = EntityPregnantPig.get((EntityPig) target);
                        if (properties.embryo != null) {
                            if (!player.worldObj.isRemote) {
                                Revival.NETWORK_WRAPPER.sendTo(new MessageSyncEmbryo(target, properties.embryo, properties.embryoProgress), (EntityPlayerMP) player);
                            }
                            properties.setPedia();
                            player.openGui(Revival.INSTANCE, 4, target.worldObj, (int) target.posX, (int) target.posY, (int) target.posZ);
                        }
                    } else if (target instanceof EntitySheep) {
                        EntityPregnantSheep properties = EntityPregnantSheep.get((EntitySheep) target);
                        if (properties.embryo != null) {
                            if (!player.worldObj.isRemote) {
                                Revival.NETWORK_WRAPPER.sendTo(new MessageSyncEmbryo(target, properties.embryo, properties.embryoProgress), (EntityPlayerMP) player);
                            }
                            properties.setPedia();
                            player.openGui(Revival.INSTANCE, 4, target.worldObj, (int) target.posX, (int) target.posY, (int) target.posZ);
                        }
                    }
                }
            }
        }
    }
}
