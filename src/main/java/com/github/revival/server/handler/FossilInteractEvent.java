package com.github.revival.server.handler;

import com.github.revival.Revival;
import com.github.revival.server.entity.mob.PregnantCowEntity;
import com.github.revival.server.entity.mob.PregnantHorseEntity;
import com.github.revival.server.entity.mob.PregnantPigEntity;
import com.github.revival.server.entity.mob.PregnantSheepEntity;
import com.github.revival.server.item.FAItemRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

public class FossilInteractEvent {

    @SubscribeEvent
    public void onEntityInteract(EntityInteractEvent event) {
        if (event.entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.entity;
            ItemStack itemstack = player.inventory.getCurrentItem();
            if (event.target != null) {
                if (itemstack != null) {
                    if (event.target instanceof EntityHorse) {
                        if (player.getHeldItem().getItem() == FAItemRegistry.dinoPedia) {
                            PregnantHorseEntity props = PregnantHorseEntity.get((EntityHorse) event.target);

                            if (props.Embryo != null) {
                                props.setPedia();
                                player.openGui(Revival.instance, 4, event.target.worldObj, (int) event.target.posX, (int) event.target.posY, (int) event.target.posZ);
                            }
                        } else {
                            ((EntityHorse) event.target).interact(player);
                        }
                    }

                    if (event.target instanceof EntityCow) {
                        if (player.getHeldItem().getItem() == FAItemRegistry.dinoPedia) {
                            PregnantCowEntity props = PregnantCowEntity.get((EntityCow) event.target);

                            if (props.Embryo != null) {
                                props.setPedia();
                                player.openGui(Revival.instance, 4, event.target.worldObj, (int) event.target.posX, (int) event.target.posY, (int) event.target.posZ);
                            }
                        } else {
                            ((EntityCow) event.target).interact(player);
                        }
                    }

                    if (event.target instanceof EntityPig) {
                        if (player.getHeldItem().getItem() == FAItemRegistry.dinoPedia) {
                            PregnantPigEntity props = PregnantPigEntity.get((EntityPig) event.target);

                            if (props.Embryo != null) {
                                props.setPedia();
                                player.openGui(Revival.instance, 4, event.target.worldObj, (int) event.target.posX, (int) event.target.posY, (int) event.target.posZ);
                            }
                        } else {
                            ((EntityPig) event.target).interact(player);
                        }
                    }

                    if (event.target instanceof EntitySheep) {
                        if (player.getHeldItem().getItem() == FAItemRegistry.dinoPedia) {
                            PregnantSheepEntity props = PregnantSheepEntity.get((EntitySheep) event.target);

                            if (props.Embryo != null) {
                                props.setPedia();
                                player.openGui(Revival.instance, 4, event.target.worldObj, (int) event.target.posX, (int) event.target.posY, (int) event.target.posZ);
                            }
                        } else {
                            ((EntitySheep) event.target).interact(player);
                        }
                    }
                }
            }
        }
    }
}
