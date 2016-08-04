package fossilsarcheology.server.handler;

import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.mob.EntityElasmotherium;
import fossilsarcheology.server.entity.mob.EntityMammoth;
import fossilsarcheology.server.entity.mob.EntityPregnantCow;
import fossilsarcheology.server.entity.mob.EntityPregnantHorse;
import fossilsarcheology.server.entity.mob.EntityPregnantPig;
import fossilsarcheology.server.entity.mob.EntityPregnantSheep;
import fossilsarcheology.server.entity.mob.EntityQuagga;
import fossilsarcheology.server.entity.mob.EntitySmilodon;
import fossilsarcheology.server.enums.PrehistoricEntityType;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.AchievementEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class FossilLivingEvent {

    protected Random rand;

    @SubscribeEvent
    public void onEntityConstructing(EntityConstructing event) {
        if (event.entity instanceof EntityHorse && EntityPregnantHorse.get((EntityHorse) event.entity) == null) {
            EntityPregnantHorse.register((EntityHorse) event.entity);
        }

        if (event.entity instanceof EntityCow && EntityPregnantCow.get((EntityCow) event.entity) == null) {
            EntityPregnantCow.register((EntityCow) event.entity);
        }

        if (event.entity instanceof EntityPig && EntityPregnantPig.get((EntityPig) event.entity) == null) {
            EntityPregnantPig.register((EntityPig) event.entity);
        }

        if (event.entity instanceof EntitySheep && EntityPregnantSheep.get((EntitySheep) event.entity) == null) {
            EntityPregnantSheep.register((EntitySheep) event.entity);
        }
    }

    @SubscribeEvent
    public void entityInteractEvent(EntityInteractEvent event) {
        ItemStack stack = event.entityPlayer.getHeldItem();
        if (stack != null && stack.getItem() != null && stack.getItem() == FAItemRegistry.INSTANCE.dinoPedia) {
            if (event.entity instanceof EntityHorse && EntityPregnantHorse.get((EntityHorse) event.entity) != null) {
                Revival.toPedia = EntityPregnantHorse.get((EntityHorse) event.entity).horse;
                event.entityPlayer.openGui(Revival.INSTANCE, 4, event.entity.worldObj, (int) event.entity.posX, (int) event.entity.posY, (int) event.entity.posZ);
            }

            if (event.entity instanceof EntityCow && EntityPregnantCow.get((EntityCow) event.entity) != null) {
                Revival.toPedia = EntityPregnantCow.get((EntityCow) event.entity).cow;
                event.entityPlayer.openGui(Revival.INSTANCE, 4, event.entity.worldObj, (int) event.entity.posX, (int) event.entity.posY, (int) event.entity.posZ);
            }

            if (event.entity instanceof EntityPig && EntityPregnantPig.get((EntityPig) event.entity) != null) {
                Revival.toPedia = EntityPregnantPig.get((EntityPig) event.entity).pig;
                event.entityPlayer.openGui(Revival.INSTANCE, 4, event.entity.worldObj, (int) event.entity.posX, (int) event.entity.posY, (int) event.entity.posZ);
            }

            if (event.entity instanceof EntitySheep && EntityPregnantSheep.get((EntitySheep) event.entity) != null) {
                Revival.toPedia = EntityPregnantSheep.get((EntitySheep) event.entity).sheep;
                event.entityPlayer.openGui(Revival.INSTANCE, 4, event.entity.worldObj, (int) event.entity.posX, (int) event.entity.posY, (int) event.entity.posZ);
            }
        }
    }

    @SubscribeEvent
    public void onAchievementGet(AchievementEvent event) {
        if (event.achievement == FossilAchievementHandler.firstDino) {
            Revival.PROXY.playSound("fossil:music.first_dinosaur");
        }
    }

    @SubscribeEvent
    public void onEntityLiving(LivingUpdateEvent event) {
        this.rand = new Random();

        if (event.entityLiving instanceof EntityHorse) {
            EntityPregnantHorse props = EntityPregnantHorse.get((EntityHorse) event.entityLiving);

            if (props.Embryo != null) {

                ++props.EmbryoProgress;
                this.getClass();

                if (props.EmbryoProgress >= props.Embryo.growTime) // var10000
                // == 3000)
                {
                    GrowEntity(props.Embryo, event);
                    props.EmbryoProgress = 0;
                    props.setEmbryo(null);
                }
            }
        }

        if (event.entityLiving instanceof EntityCow) {
            EntityPregnantCow props = EntityPregnantCow.get((EntityCow) event.entityLiving);

            if (props.embryo != null) {

                ++props.EmbryoProgress;
                this.getClass();

                if (props.EmbryoProgress >= props.embryo.growTime) // var10000
                // == 3000)
                {
                    GrowEntity(props.embryo, event);
                    props.EmbryoProgress = 0;
                    props.setEmbryo(null);
                }
            }
        }

        if (event.entityLiving instanceof EntityPig) {
            EntityPregnantPig props = EntityPregnantPig.get((EntityPig) event.entityLiving);

            if (props.embryo != null) {
                ++props.EmbryoProgress;
                this.getClass();

                if (props.EmbryoProgress >= props.embryo.growTime) // var10000
                // == 3000)
                {
                    GrowEntity(props.embryo, event);
                    props.EmbryoProgress = 0;
                    props.setEmbryo(null);
                }
            }
        }

        if (event.entityLiving instanceof EntitySheep) {
            EntityPregnantSheep props = EntityPregnantSheep.get((EntitySheep) event.entityLiving);

            if (props.embryo != null) {
                ++props.EmbryoProgress;
                this.getClass();

                if (props.EmbryoProgress >= props.embryo.growTime) // var10000
                // == 3000)
                {
                    GrowEntity(props.embryo, event);
                    props.EmbryoProgress = 0;
                    props.setEmbryo(null);
                }
            }
        }
    }

    public void GrowEntity(PrehistoricEntityType embryo, LivingUpdateEvent event) {
        float rnd = new Random().nextInt(100);
        Object birthEntity;
        switch (embryo) {
            case PIG:
                birthEntity = new EntityPig(event.entityLiving.worldObj);
                break;

            case SHEEP:
                birthEntity = new EntitySheep(event.entityLiving.worldObj);
                break;

            case COW:
                birthEntity = new EntityCow(event.entityLiving.worldObj);
                break;

            case CHICKEN:
                birthEntity = new EntityChicken(event.entityLiving.worldObj);
                break;

            case HORSE:
                if (event.entityLiving instanceof EntityHorse) {
                    if (rnd < 5) {
                        birthEntity = new EntityHorse(event.entityLiving.worldObj);
                        ((EntityHorse) birthEntity).setHorseType(3);
                        if (((EntityHorse) event.entityLiving).func_152119_ch() != null) {
                            ((EntityHorse) birthEntity).func_152120_b(((EntityHorse) event.entityLiving).func_152119_ch());
                            ((EntityHorse) birthEntity).setHorseTamed(true);
                        }
                        break;
                    } else if (rnd < 10) {
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

            case SMILODON:
                birthEntity = new EntitySmilodon(event.entityLiving.worldObj);
                if (event.entityLiving.worldObj.getClosestPlayerToEntity(event.entityLiving, 15) != null) {
                    ((EntitySmilodon) birthEntity).setTamed(true);
                    ((EntitySmilodon) birthEntity).func_152115_b(event.entityLiving.worldObj.getClosestPlayerToEntity(event.entityLiving, 15).getCommandSenderName());
                }
                break;

            case MAMMOTH:
                birthEntity = (new EntityMammoth(event.entityLiving.worldObj));
                ((EntityPrehistoric) birthEntity).func_152114_e(event.entityLiving.worldObj.getClosestPlayerToEntity(((EntityPrehistoric) birthEntity), 8));
                if (event.entityLiving.worldObj.getClosestPlayerToEntity(event.entityLiving, 15) != null) {
                    ((EntityPrehistoric) birthEntity).setTamed(true);
                    ((EntityPrehistoric) birthEntity).func_152115_b(event.entityLiving.worldObj.getClosestPlayerToEntity(event.entityLiving, 15).getCommandSenderName());
                }
                break;

            case ELASMOTHERIUM:
                birthEntity = (new EntityElasmotherium(event.entityLiving.worldObj));
                if (event.entityLiving.worldObj.getClosestPlayerToEntity(event.entityLiving, 15) != null) {
                    ((EntityPrehistoric) birthEntity).setTamed(true);
                    ((EntityPrehistoric) birthEntity).func_152115_b(event.entityLiving.worldObj.getClosestPlayerToEntity(event.entityLiving, 15).getCommandSenderName());
                }
                break;

            case QUAGGA:
                birthEntity = new EntityQuagga(event.entityLiving.worldObj);

                int d0 = (int) (event.entityLiving.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + ((EntityQuagga) birthEntity).getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + (int) ((EntityQuagga) birthEntity).randomHealthStat());
                ((EntityQuagga) birthEntity).getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(d0 / 3.0D);
                double d2 = event.entityLiving.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + ((EntityQuagga) birthEntity).getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + ((EntityQuagga) birthEntity).randomSpeedStat();
                ((EntityQuagga) birthEntity).getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(d2 / 3.0D);
                break;

            default:
                birthEntity = new EntityPig(event.entityLiving.worldObj);
        }
        if (!(birthEntity instanceof EntityPrehistoric)) {
            ((EntityAnimal) birthEntity).setGrowingAge(-24000);
        }
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
