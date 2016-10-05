package fossilsarcheology.server.item;

import fossilsarcheology.server.api.DefaultRenderedItem;
import fossilsarcheology.server.entity.prehistoric.PrehistoricEntityType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

import java.util.Random;

public class MammalEmbryoItem extends Item implements DefaultRenderedItem {
    private PrehistoricEntityType type;
    private Random rand;

    public MammalEmbryoItem(PrehistoricEntityType type) {
        super();
        this.setMaxDamage(0);
        this.type = type;
        this.rand = new Random();
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase entity, EnumHand hand) {
        /*if (entity instanceof EntityAnimal && ((EntityAnimal) entity).getGrowingAge() == 0) {
            if (entity instanceof EntityPig) {
                EntityPregnantPig props = EntityPregnantPig.get(((EntityPig) entity));
                if (props.embryo != null) {
                    return false;
                }
                if (this.type != null) {
                    props.setEmbryo(this.type);
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
                if (this.type != null) {
                    props.setEmbryo(this.type);
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
                if (this.type != null) {
                    props.setEmbryo(this.type);
                    if (!player.capabilities.isCreativeMode) {
                        stack.stackSize--;
                    }
                } else {
                    return false;
                }
            } else if (entity instanceof EntityHorse) {
                EntityHorse horse = (EntityHorse) entity;
                EntityPregnantHorse props = EntityPregnantHorse.get(horse);
                if (horse.getHorseVariant() != 0 || props.Embryo != null) {
                    return false;
                }
                if (this.type != null) {
                    props.setEmbryo(this.type);
                    if (!player.capabilities.isCreativeMode) {
                        stack.stackSize--;
                    }
                } else {
                    return false;
                }
            }
            for (int i = 0; i < 7; i++) {
                entity.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, entity.posX + this.rand.nextFloat() * entity.width * 2.0F - entity.width, entity.posY + 0.5D + (this.rand.nextFloat() * entity.height), entity.posZ + (this.rand.nextFloat() * entity.width * 2.0F) - entity.width, this.rand.nextGaussian() * 0.02D, this.rand.nextGaussian() * 0.02D, this.rand.nextGaussian() * 0.02D);
            }
            return true;
        } TODO
        return false;*/
        return false;
    }
}
