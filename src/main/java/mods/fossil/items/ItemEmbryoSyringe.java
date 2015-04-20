package mods.fossil.items;

import java.util.Random;

import mods.fossil.Fossil;
import mods.fossil.entity.mob.EntityPregnantCow;
import mods.fossil.entity.mob.EntityPregnantHorse;
import mods.fossil.entity.mob.EntityPregnantPig;
import mods.fossil.entity.mob.EntityPregnantSheep;
import mods.fossil.fossilEnums.EnumAnimalType;
import mods.fossil.fossilInterface.IViviparous;
import mods.fossil.handler.FossilAchievementHandler;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemEmbryoSyringe extends Item
{
    //private String[] ItemNames = new String[] {"EmbyoPig", "EmbyoSheep", "EmbyoCow", "EmbyoSmilodon", "EmbyoMammoth"};
    int AnimalType;
    private EnumAnimalType embryo;
    private Random rand;
    
    public ItemEmbryoSyringe(int AnimalType0)
    {
        super();
        //this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.AnimalType = AnimalType0;
        this.rand = new Random();
    }

    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon("fossil:" + EnumAnimalType.values()[AnimalType].name() + "_Syringe");
    }

    /*
     * Gets an icon index based on an item's damage value
     */
    //public int getIconFromDamage(int var1)
    //{
    //    return var1;
    //}

    //public String getItemNameIS(ItemStack var1)
    //{
    //    int var2 = var1.getItemDamage();
    //    return var2 < this.ItemNames.length ? this.ItemNames[var2] : "EmbyoSyring";
    //}

    public static EnumAnimalType GetEmbryo(int var0)
    {
        return EnumAnimalType.values()[var0];
    }

    /**
     * dye sheep, place saddles, etc ...
     */
    public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase thisEntity)
    {
        if (thisEntity instanceof EntityAnimal && ((EntityAnimal)thisEntity).getGrowingAge() == 0)
        {
            Object pregnantEntity = null;

            if (thisEntity instanceof EntityPig)
            {
            	EntityPregnantPig props = EntityPregnantPig.get(((EntityPig)thisEntity));
                if (props.Embryo != null)
                {
                	return false;
                }
                embryo = this.EmbryoSelector(itemstack, thisEntity);
                if(embryo != null)
                {
                	props.SetEmbryo(embryo);
                }
                else
                {
                	return false;
                }
            }

            else if (thisEntity instanceof EntityCow)
            {
            	EntityPregnantCow props = EntityPregnantCow.get(((EntityCow)thisEntity));
                if (props.Embryo != null)
                {
                	return false;
                }
                embryo = this.EmbryoSelector(itemstack, thisEntity);
                if(embryo != null)
                {
                	props.SetEmbryo(embryo);
                }
                else
                {
                	return false;
                }
            }

            else if (thisEntity instanceof EntitySheep)
            {
            	EntityPregnantSheep props = EntityPregnantSheep.get(((EntitySheep)thisEntity));
                if (props.Embryo != null)
                {
                	return false;
                }
                embryo = this.EmbryoSelector(itemstack, thisEntity);
                if(embryo != null)
                {
                	props.SetEmbryo(embryo);
                }
                else
                {
                	return false;
                }
            }
            
            else if (thisEntity instanceof EntityHorse)
            {
            	EntityPregnantHorse props = EntityPregnantHorse.get(((EntityHorse)thisEntity));
                if ( ((EntityHorse)thisEntity).getHorseType() != 0 
                		|| props.Embryo != null)
                {
                	return false;
                }
                embryo = this.EmbryoSelector(itemstack, thisEntity);
                if(embryo != null)
                {
                	props.SetEmbryo(embryo);
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
                thisEntity.worldObj.spawnParticle("smoke", thisEntity.posX + (double)(this.rand.nextFloat() * thisEntity.width * 2.0F) - (double)thisEntity.width, thisEntity.posY + 0.5D + (double)(this.rand.nextFloat() * thisEntity.height), thisEntity.posZ + (double)(this.rand.nextFloat() * thisEntity.width * 2.0F) - (double)thisEntity.width, var4, var6, var8);
            }
            
            //player.triggerAchievement(FossilAchievementHandler.IceAge);
            return true;
        }

        return false;
    }
    
    private EnumAnimalType EmbryoSelector(ItemStack itemstack, EntityLivingBase thisEntity)
    {
        EnumAnimalType e0 = null;

        if (itemstack.getItem() == Fossil.embryoQuagga && thisEntity instanceof EntityHorse)
        {
            e0 = EnumAnimalType.Quagga;
        }
        
        if (itemstack.getItem() == Fossil.embryoChicken)
        {
            e0 = EnumAnimalType.Chicken;
        }

        if (itemstack.getItem() == Fossil.embryoCow)
        {
            e0 = EnumAnimalType.Cow;
        }
        
        if (itemstack.getItem() == Fossil.embryoHorse)
        {
            e0 = EnumAnimalType.Horse;
        }

        if (itemstack.getItem() == Fossil.embryoMammoth)
        {
            e0 = EnumAnimalType.Mammoth;
        }
        
        if (itemstack.getItem() == Fossil.embryoElasmotherium)
        {
            e0 = EnumAnimalType.Elasmotherium;
        }

        if (itemstack.getItem() == Fossil.embryoPig)
        {
            e0 = EnumAnimalType.Pig;
        }

        if (itemstack.getItem() == Fossil.embryoSmilodon)
        {
            e0 = EnumAnimalType.Smilodon;
        }

        if (itemstack.getItem() == Fossil.embryoSheep)
        {
            e0 = EnumAnimalType.Sheep;
        }
        
        if (e0 != null)
        {
            --itemstack.stackSize;
    		return e0;
        }
		return null;
    }
}
