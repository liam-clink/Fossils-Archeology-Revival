package com.github.revival.server.handler;

import com.github.revival.Revival;
import com.github.revival.server.entity.mob.*;
import com.github.revival.server.entity.mob.test.NewPrehistoricEntity;
import com.github.revival.server.enums.EnumPrehistoric;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.*;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.AchievementEvent;

import java.util.Random;

public class FossilLivingEvent {

    protected Random rand;

    @SubscribeEvent
    public void onEntityConstructing(EntityConstructing event) {
        if (event.entity instanceof EntityHorse && PregnantHorseEntity.get((EntityHorse) event.entity) == null) {
            PregnantHorseEntity.register((EntityHorse) event.entity);
        }

        if (event.entity instanceof EntityCow && PregnantCowEntity.get((EntityCow) event.entity) == null) {
            PregnantCowEntity.register((EntityCow) event.entity);
        }

        if (event.entity instanceof EntityPig && PregnantPigEntity.get((EntityPig) event.entity) == null) {
            PregnantPigEntity.register((EntityPig) event.entity);
        }

        if (event.entity instanceof EntitySheep && PregnantSheepEntity.get((EntitySheep) event.entity) == null) {
            PregnantSheepEntity.register((EntitySheep) event.entity);
        }
    }

    @SubscribeEvent
    public void onAchievementGet(AchievementEvent event) {
        if (event.achievement == FossilAchievementHandler.firstDino) {
            Revival.proxy.playSound("fossil:music.first_dinosaur");
        }
    }

    @SubscribeEvent
    public void onEntityLiving(LivingUpdateEvent event) {
        this.rand = new Random();

        if (event.entityLiving instanceof EntityHorse) {
            PregnantHorseEntity props = PregnantHorseEntity.get((EntityHorse) event.entityLiving);

            if (props.Embryo != null) {

                ++props.EmbryoProgress;
                this.getClass();

                if (props.EmbryoProgress >= props.Embryo.growTime) //var10000 == 3000)
                {
                    GrowEntity(props.Embryo, event);
                    props.EmbryoProgress = 0;
                    props.setEmbryo(null);
                }
            }
        }

        if (event.entityLiving instanceof EntityCow) {
            PregnantCowEntity props = PregnantCowEntity.get((EntityCow) event.entityLiving);

            if (props.Embryo != null) {

                ++props.EmbryoProgress;
                this.getClass();

                if (props.EmbryoProgress >= props.Embryo.growTime) //var10000 == 3000)
                {
                    GrowEntity(props.Embryo, event);
                    props.EmbryoProgress = 0;
                    props.setEmbryo(null);
                }
            }
        }

        if (event.entityLiving instanceof EntityPig) {
            PregnantPigEntity props = PregnantPigEntity.get((EntityPig) event.entityLiving);

            if (props.Embryo != null) {
                ++props.EmbryoProgress;
                this.getClass();

                if (props.EmbryoProgress >= props.Embryo.growTime) //var10000 == 3000)
                {
                    GrowEntity(props.Embryo, event);
                    props.EmbryoProgress = 0;
                    props.setEmbryo(null);
                }
            }
        }

        if (event.entityLiving instanceof EntitySheep) {
            PregnantSheepEntity props = PregnantSheepEntity.get((EntitySheep) event.entityLiving);

            if (props.Embryo != null) {
                ++props.EmbryoProgress;
                this.getClass();

                if (props.EmbryoProgress >= props.Embryo.growTime) //var10000 == 3000)
                {
                    GrowEntity(props.Embryo, event);
                    props.EmbryoProgress = 0;
                    props.setEmbryo(null);
                }
            }
        }
    }

    public void GrowEntity(EnumPrehistoric embryo, LivingUpdateEvent event) {
        float rnd = new Random().nextInt(100);
        Object birthEntity;
        switch (embryo) {
            case Pig:
                birthEntity = new EntityPig(event.entityLiving.worldObj);
                break;

            case Sheep:
                birthEntity = new EntitySheep(event.entityLiving.worldObj);
                break;

            case Cow:
                birthEntity = new EntityCow(event.entityLiving.worldObj);
                break;

            case Chicken:
                birthEntity = new EntityChicken(event.entityLiving.worldObj);
                break;

            case Horse:
                if (event.entityLiving instanceof EntityHorse) {
                    if (rnd < 1) {
                        birthEntity = new EntityHorse(event.entityLiving.worldObj);
                        ((EntityHorse) birthEntity).setHorseType(3);
                        if (((EntityHorse) event.entityLiving).func_152119_ch() != null) {
                            ((EntityHorse) birthEntity).func_152120_b(((EntityHorse) event.entityLiving).func_152119_ch());
                            ((EntityHorse) birthEntity).setHorseTamed(true);
                        }
                        break;
                    } else if (rnd < 2) {
                        birthEntity = new EntityHorse(event.entityLiving.worldObj);
                        ((EntityHorse) birthEntity).setHorseType(4);
                        if (((EntityHorse) event.entityLiving).func_152119_ch() != null) {
                            ((EntityHorse) birthEntity).func_152120_b(((EntityHorse) event.entityLiving).func_152119_ch());
                            ((EntityHorse) birthEntity).setHorseTamed(true);
                        }
                        break;
                    } else {
                        birthEntity = ((EntityHorse) event.entityLiving).createChild(new EntityHorse(event.entityLiving.worldObj));
                    }
                } else {
                    EntityHorse entityHorse = new EntityHorse(event.entityLiving.worldObj);
                    birthEntity = entityHorse.createChild(new EntityHorse(event.entityLiving.worldObj));
                }
                break;

            case Smilodon:
                birthEntity = new SmilodonEntity(event.entityLiving.worldObj);
                if (new Random().nextInt(5) == 0) {
                    // ((SmilodonEntity) birthEntity).setSkin(1);
                }
                break;

            case Mammoth:
                birthEntity = (new MammothEntity(event.entityLiving.worldObj));
                ((NewPrehistoricEntity) birthEntity).func_152114_e(event.entityLiving.worldObj.getClosestPlayerToEntity(((NewPrehistoricEntity) birthEntity), 8));
                if (new Random().nextInt(5) == 0) {
                    // ((MammothEntity) birthEntity).setSkin(2);
                }
                break;

            case Elasmotherium:
                birthEntity = (new ElasmotheriumEntity(event.entityLiving.worldObj));
                ((NewPrehistoricEntity) birthEntity).func_152114_e(event.entityLiving.worldObj.getClosestPlayerToEntity(((NewPrehistoricEntity) birthEntity), 8));
                break;

            case Quagga:
                birthEntity = new QuaggaEntity(event.entityLiving.worldObj);

                int d0 = (int) (event.entityLiving.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + ((QuaggaEntity) birthEntity).getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + (int) ((QuaggaEntity) birthEntity).randomHealthStat());
                ((QuaggaEntity) birthEntity).getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(d0 / 3.0D);
                double d2 = event.entityLiving.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + ((QuaggaEntity) birthEntity).getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + ((QuaggaEntity) birthEntity).randomSpeedStat();
                ((QuaggaEntity) birthEntity).getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(d2 / 3.0D);
                break;

            default:
                birthEntity = new EntityPig(event.entityLiving.worldObj);
        }

        ((EntityAnimal) birthEntity).setGrowingAge(-24000);
        ((EntityAnimal) birthEntity).setLocationAndAngles(event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, event.entityLiving.rotationYaw, event.entityLiving.rotationPitch);

        for (int var3 = 0; var3 < 7; ++var3) {
            double var4 = this.rand.nextGaussian() * 0.02D;
            double var6 = this.rand.nextGaussian() * 0.02D;
            double var8 = this.rand.nextGaussian() * 0.02D;
            event.entityLiving.worldObj.spawnParticle("heart", event.entityLiving.posX + (double) (this.rand.nextFloat() * event.entityLiving.width * 2.0F) - (double) event.entityLiving.width, event.entityLiving.posY + 0.5D + (double) (this.rand.nextFloat() * event.entityLiving.height), event.entityLiving.posZ + (double) (this.rand.nextFloat() * event.entityLiving.width * 2.0F) - (double) event.entityLiving.width, var4, var6, var8);
        }

        if (!event.entityLiving.worldObj.isRemote) {
            event.entityLiving.worldObj.spawnEntityInWorld((Entity) birthEntity);
        }
    }

}
