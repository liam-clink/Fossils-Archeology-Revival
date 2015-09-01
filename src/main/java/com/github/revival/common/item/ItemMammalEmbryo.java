package com.github.revival.common.item;

import com.github.revival.common.entity.mob.EntityPregnantCow;
import com.github.revival.common.entity.mob.EntityPregnantHorse;
import com.github.revival.common.entity.mob.EntityPregnantPig;
import com.github.revival.common.entity.mob.EntityPregnantSheep;
import com.github.revival.common.enums.EnumPrehistoric;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class ItemMammalEmbryo extends Item
{
    int AnimalType;
    private EnumPrehistoric embryo;
    private Random rand;
    
    public ItemMammalEmbryo(int AnimalType0)
    {
        super();
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.AnimalType = AnimalType0;
        this.rand = new Random();
    }

    public static EnumPrehistoric getEmbryo(int var0)
    {
        return EnumPrehistoric.values()[var0];
    }

    /**
     * dye sheep, place saddles, etc ...
     */
    public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase thisEntity)
    {
        embryo = this.getEmbryo(AnimalType);

        if (thisEntity instanceof EntityAnimal && ((EntityAnimal) thisEntity).getGrowingAge() == 0)
        {
            Object pregnantEntity = null;

            if (thisEntity instanceof EntityPig)
            {
                EntityPregnantPig props = EntityPregnantPig.get(((EntityPig) thisEntity));
                if (props.Embryo != null)
                {
                    return false;
                }
                if (embryo != null)
                {
                    props.setEmbryo(embryo);
                }
                else
                {
                    return false;
                }
            }

            else if (thisEntity instanceof EntityCow)
            {
                EntityPregnantCow props = EntityPregnantCow.get(((EntityCow) thisEntity));
                if (props.Embryo != null)
                {
                    return false;
                }
                if (embryo != null)
                {
                    props.setEmbryo(embryo);
                }
                else
                {
                    return false;
                }
            }

            else if (thisEntity instanceof EntitySheep)
            {
                EntityPregnantSheep props = EntityPregnantSheep.get(((EntitySheep) thisEntity));
                if (props.Embryo != null)
                {
                    return false;
                }
                if (embryo != null)
                {
                    props.setEmbryo(embryo);
                }
                else
                {
                    return false;
                }
            }
            
            else if (thisEntity instanceof EntityHorse)
            {
                EntityPregnantHorse props = EntityPregnantHorse.get(((EntityHorse) thisEntity));
                if (((EntityHorse) thisEntity).getHorseType() != 0
                        || props.Embryo != null)
                {
                    return false;
                }
                if (embryo != null)
                {
                    props.setEmbryo(embryo);
                }
                else
                {
                    return false;
                }
            }

            for (int var3 = 0; var3 < 7; ++var3)
            {
                double var4 = this.rand.nextGaussian() * 0.02D;
                double var6 = this.rand.nextGaussian() * 0.02D;
                double var8 = this.rand.nextGaussian() * 0.02D;
                thisEntity.worldObj.spawnParticle("smoke", thisEntity.posX + (double) (this.rand.nextFloat() * thisEntity.width * 2.0F) - (double) thisEntity.width, thisEntity.posY + 0.5D + (double) (this.rand.nextFloat() * thisEntity.height), thisEntity.posZ + (double) (this.rand.nextFloat() * thisEntity.width * 2.0F) - (double) thisEntity.width, var4, var6, var8);
            }
            
            return true;
        }

        return false;
    }
    
   
}
