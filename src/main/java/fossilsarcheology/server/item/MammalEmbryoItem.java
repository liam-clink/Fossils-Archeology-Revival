package fossilsarcheology.server.item;

import fossilsarcheology.server.entity.mob.EntityPregnantCow;
import fossilsarcheology.server.entity.mob.EntityPregnantHorse;
import fossilsarcheology.server.entity.mob.EntityPregnantPig;
import fossilsarcheology.server.entity.mob.EntityPregnantSheep;
import fossilsarcheology.server.enums.EnumPrehistoric;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class MammalEmbryoItem extends Item {
	private int type;
	private EnumPrehistoric embryo;
	private Random rand;

	public MammalEmbryoItem(int type) {
		super();
		this.setMaxDamage(0);
		this.maxStackSize = 64;
		this.type = type;
		this.rand = new Random();
	}

	public static EnumPrehistoric getEmbryo(int type) {
		return EnumPrehistoric.values()[type];
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase entity) {
		embryo = getEmbryo(type);
		if (entity instanceof EntityAnimal && ((EntityAnimal) entity).getGrowingAge() == 0) {
			if (!player.worldObj.isRemote) {
                if (entity instanceof EntityPig) {
                    EntityPregnantPig props = EntityPregnantPig.get(((EntityPig) entity));
                    if (props.embryo != null) {
                        return false;
                    }
                    if (embryo != null) {
                        props.setEmbryo(embryo);
                        if (!player.capabilities.isCreativeMode) {
                            stack.stackSize--;
                        }
                    } else {
                        return false;
                    }
                } else if (entity instanceof EntityCow) {
                    EntityPregnantCow props = EntityPregnantCow.get(((EntityCow) entity));
                    if (props.embryo != null) {
                        return false;
                    }
                    if (embryo != null) {
                        props.setEmbryo(embryo);
                        if (!player.capabilities.isCreativeMode) {
                            stack.stackSize--;
                        }
                    } else {
                        return false;
                    }
                } else if (entity instanceof EntitySheep) {
                    EntityPregnantSheep props = EntityPregnantSheep.get(((EntitySheep) entity));
                    if (props.embryo != null) {
                        return false;
                    }
                    if (embryo != null) {
                        props.setEmbryo(embryo);
                        if (!player.capabilities.isCreativeMode) {
                            stack.stackSize--;
                        }
                    } else {
                        return false;
                    }
                } else if (entity instanceof EntityHorse) {
                    EntityPregnantHorse props = EntityPregnantHorse.get(((EntityHorse) entity));
                    if (((EntityHorse) entity).getHorseType() != 0 || props.embryo != null) {
                        return false;
                    }
                    if (embryo != null) {
                        props.setEmbryo(embryo);
                        if (!player.capabilities.isCreativeMode) {
                            stack.stackSize--;
                        }
                    } else {
                        return false;
                    }
                }
            }

			for (int i = 0; i < 7; ++i) {
				double velX = this.rand.nextGaussian() * 0.02D;
				double velY = this.rand.nextGaussian() * 0.02D;
				double velZ = this.rand.nextGaussian() * 0.02D;
				entity.worldObj.spawnParticle("smoke", entity.posX + (double) (this.rand.nextFloat() * entity.width * 2.0F) - (double) entity.width, entity.posY + 0.5D + (double) (this.rand.nextFloat() * entity.height), entity.posZ + (double) (this.rand.nextFloat() * entity.width * 2.0F) - (double) entity.width, velX, velY, velZ);
			}

			return true;
		}

		return false;
	}

}
