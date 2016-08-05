package fossilsarcheology.server.handler;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
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
import fossilsarcheology.server.enums.EnumPrehistoric;
import fossilsarcheology.server.item.FAItemRegistry;

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
		if(stack != null && stack.getItem() != null && stack.getItem() == FAItemRegistry.INSTANCE.dinoPedia){
			if (event.entity instanceof EntityHorse && EntityPregnantHorse.get((EntityHorse) event.entity) != null) {
				Revival.toPedia = EntityPregnantHorse.get((EntityHorse) event.entity).horse;
				event.entityPlayer.openGui(Revival.INSTANCE, 4, event.entity.worldObj, (int) event.entity.posX, (int)  event.entity.posY, (int)  event.entity.posZ);
			}

			if (event.entity instanceof EntityCow && EntityPregnantCow.get((EntityCow) event.entity) != null) {
				Revival.toPedia = EntityPregnantCow.get((EntityCow) event.entity).cow;
				event.entityPlayer.openGui(Revival.INSTANCE, 4, event.entity.worldObj, (int) event.entity.posX, (int)  event.entity.posY, (int)  event.entity.posZ);
			}

			if (event.entity instanceof EntityPig && EntityPregnantPig.get((EntityPig) event.entity) != null) {
				Revival.toPedia = EntityPregnantPig.get((EntityPig) event.entity).pig;
				event.entityPlayer.openGui(Revival.INSTANCE, 4, event.entity.worldObj, (int) event.entity.posX, (int)  event.entity.posY, (int)  event.entity.posZ);
			}

			if (event.entity instanceof EntitySheep && EntityPregnantSheep.get((EntitySheep) event.entity) != null) {
				Revival.toPedia = EntityPregnantSheep.get((EntitySheep) event.entity).sheep;
				event.entityPlayer.openGui(Revival.INSTANCE, 4, event.entity.worldObj, (int) event.entity.posX, (int)  event.entity.posY, (int)  event.entity.posZ);
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

			if (props.embryo != null) {

				++props.embryoProgress;
				this.getClass();

				if (props.embryoProgress >= props.embryo.growTime) // var10000
				// == 3000)
				{
					growEntity(props.embryo, event);
					props.embryoProgress = 0;
					props.setEmbryo(null);
				}
			}
		}

		if (event.entityLiving instanceof EntityCow) {
			EntityPregnantCow props = EntityPregnantCow.get((EntityCow) event.entityLiving);

			if (props.embryo != null) {

				++props.embryoProgress;
				this.getClass();

				if (props.embryoProgress >= props.embryo.growTime) // var10000
				// == 3000)
				{
					growEntity(props.embryo, event);
					props.embryoProgress = 0;
					props.setEmbryo(null);
				}
			}
		}

		if (event.entityLiving instanceof EntityPig) {
			EntityPregnantPig props = EntityPregnantPig.get((EntityPig) event.entityLiving);

			if (props.embryo != null) {
				++props.embryoProgress;
				this.getClass();

				if (props.embryoProgress >= props.embryo.growTime) // var10000
				// == 3000)
				{
					growEntity(props.embryo, event);
					props.embryoProgress = 0;
					props.setEmbryo(null);
				}
			}
		}

		if (event.entityLiving instanceof EntitySheep) {
			EntityPregnantSheep props = EntityPregnantSheep.get((EntitySheep) event.entityLiving);

			if (props.embryo != null) {
				++props.embryoProgress;
				this.getClass();

				if (props.embryoProgress >= props.embryo.growTime) // var10000
				// == 3000)
				{
					growEntity(props.embryo, event);
					props.embryoProgress = 0;
					props.setEmbryo(null);
				}
			}
		}
	}

	public void growEntity(EnumPrehistoric embryo, LivingUpdateEvent event) {
		float rnd = new Random().nextInt(100);
		Entity birthEntity;
        EntityLivingBase entity = event.entityLiving;
        switch (embryo) {
		case Pig:
			birthEntity = new EntityPig(entity.worldObj);
			break;
		case Sheep:
			birthEntity = new EntitySheep(entity.worldObj);
			break;
		case Cow:
			birthEntity = new EntityCow(entity.worldObj);
			break;
		case Chicken:
			birthEntity = new EntityChicken(entity.worldObj);
			break;
		case Horse:
			if (entity instanceof EntityHorse) {
				if (rnd < 5) {
					birthEntity = new EntityHorse(entity.worldObj);
					((EntityHorse) birthEntity).setHorseType(3);
					if (((EntityHorse) entity).func_152119_ch() != null) {
						((EntityHorse) birthEntity).func_152120_b(((EntityHorse) entity).func_152119_ch());
						((EntityHorse) birthEntity).setHorseTamed(true);
					}
					break;
				} else if (rnd < 10) {
					birthEntity = new EntityHorse(entity.worldObj);
					((EntityHorse) birthEntity).setHorseType(4);
					if (((EntityHorse) entity).func_152119_ch() != null) {
						((EntityHorse) birthEntity).func_152120_b(((EntityHorse) entity).func_152119_ch());
						((EntityHorse) birthEntity).setHorseTamed(true);
					}
					break;
				} else {
					birthEntity = ((EntityHorse) entity).createChild(new EntityHorse(entity.worldObj));
				}
			} else {
				EntityHorse entityHorse = new EntityHorse(entity.worldObj);
				birthEntity = entityHorse.createChild(new EntityHorse(entity.worldObj));
			}
			break;
		case Smilodon:
			birthEntity = new EntitySmilodon(entity.worldObj);
			if (entity.worldObj.getClosestPlayerToEntity(entity, 15) != null) {
				((EntitySmilodon) birthEntity).setTamed(true);
				((EntitySmilodon) birthEntity).func_152115_b(entity.worldObj.getClosestPlayerToEntity(entity, 15).getCommandSenderName());
			}
			break;
		case Mammoth:
			birthEntity = (new EntityMammoth(entity.worldObj));
			((EntityPrehistoric) birthEntity).func_152114_e(entity.worldObj.getClosestPlayerToEntity(((EntityPrehistoric) birthEntity), 8));
			if (entity.worldObj.getClosestPlayerToEntity(entity, 15) != null) {
				((EntityPrehistoric) birthEntity).setTamed(true);
				((EntityPrehistoric) birthEntity).func_152115_b(entity.worldObj.getClosestPlayerToEntity(entity, 15).getCommandSenderName());
			}
			break;
		case Elasmotherium:
			birthEntity = (new EntityElasmotherium(entity.worldObj));
			if (entity.worldObj.getClosestPlayerToEntity(entity, 15) != null) {
				((EntityPrehistoric) birthEntity).setTamed(true);
				((EntityPrehistoric) birthEntity).func_152115_b(entity.worldObj.getClosestPlayerToEntity(entity, 15).getCommandSenderName());
			}
			break;
		case Quagga:
			birthEntity = new EntityQuagga(entity.worldObj);

			int d0 = (int) (entity.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + ((EntityQuagga) birthEntity).getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + (int) ((EntityQuagga) birthEntity).randomHealthStat());
			((EntityQuagga) birthEntity).getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(d0 / 3.0D);
			double d2 = entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + ((EntityQuagga) birthEntity).getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + ((EntityQuagga) birthEntity).randomSpeedStat();
			((EntityQuagga) birthEntity).getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(d2 / 3.0D);
			break;

		default:
			birthEntity = new EntityPig(entity.worldObj);
		}
		if (!(birthEntity instanceof EntityPrehistoric) && birthEntity instanceof EntityAnimal) {
			((EntityAnimal) birthEntity).setGrowingAge(-24000);
		} else if (birthEntity instanceof EntityPrehistoric) {
            ((EntityPrehistoric) birthEntity).setGender(new Random().nextInt(2));
		}
		birthEntity.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);

		for (int var3 = 0; var3 < 7; ++var3) {
			double var4 = this.rand.nextGaussian() * 0.02D;
			double var6 = this.rand.nextGaussian() * 0.02D;
			double var8 = this.rand.nextGaussian() * 0.02D;
			entity.worldObj.spawnParticle("heart", entity.posX + (double) (this.rand.nextFloat() * entity.width * 2.0F) - (double) entity.width, entity.posY + 0.5D + (double) (this.rand.nextFloat() * entity.height), entity.posZ + (double) (this.rand.nextFloat() * entity.width * 2.0F) - (double) entity.width, var4, var6, var8);
		}

		if (!entity.worldObj.isRemote) {
			entity.worldObj.spawnEntityInWorld(birthEntity);
		}
	}

}
