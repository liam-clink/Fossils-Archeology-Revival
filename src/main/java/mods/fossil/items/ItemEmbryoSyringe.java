package mods.fossil.items;

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
    public ItemEmbryoSyringe(int AnimalType0)
    {
        super();
        //this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.AnimalType = AnimalType0;
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
                pregnantEntity = new EntityPregnantPig(thisEntity.worldObj);
            }

            if (thisEntity instanceof EntityCow)
            {
                pregnantEntity = new EntityPregnantCow(thisEntity.worldObj);
            }

            if (thisEntity instanceof EntitySheep)
            {
                pregnantEntity = new EntityPregnantSheep(thisEntity.worldObj);
                ((EntitySheep)pregnantEntity).setFleeceColor(((EntitySheep)thisEntity).getFleeceColor());
                ((EntitySheep)pregnantEntity).setSheared(((EntitySheep)thisEntity).getSheared());
            }
            
            if (thisEntity instanceof EntityHorse)
            {
            	
                if ( ((EntityHorse)thisEntity).getHorseType() != 0 )
                {
                	return false;
                }
                pregnantEntity = new EntityPregnantHorse(thisEntity.worldObj);

                
                ((EntityHorse)pregnantEntity).setHorseType(((EntityHorse)thisEntity).getHorseType());
                ((EntityHorse)pregnantEntity).setHorseVariant(((EntityHorse)thisEntity).getHorseVariant());
                ((EntityHorse)pregnantEntity).setHorseTamed(((EntityHorse)thisEntity).isTame());
                ((EntityHorse)pregnantEntity).setHorseSaddled(((EntityHorse)thisEntity).isHorseSaddled());
        		((EntityHorse)pregnantEntity).func_152120_b(((EntityHorse)thisEntity).func_152119_ch());
        		((EntityHorse)pregnantEntity).setHorseTamed(((EntityHorse)thisEntity).isTame());
        		((EntityHorse)pregnantEntity).setTemper(((EntityHorse)thisEntity).getTemper());
        		((EntityHorse)pregnantEntity).setHealth(((EntityHorse)thisEntity).getHealth());
        		((EntityHorse)pregnantEntity).setGrowingAge(((EntityHorse)thisEntity).getGrowingAge());
            }

            if (pregnantEntity != null)
            {
                EnumAnimalType e0 = EnumAnimalType.Chicken;

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

//                if(var1==Fossil.embryoDodo)e0=EnumAnimalType.Dodo;
                ((IViviparous)pregnantEntity).SetEmbryo(e0);
                ((EntityAnimal)pregnantEntity).setLocationAndAngles(thisEntity.posX, thisEntity.posY, thisEntity.posZ, thisEntity.rotationYaw, thisEntity.rotationPitch);
                thisEntity.setDead();

                if (!thisEntity.worldObj.isRemote)
                {
                    thisEntity.worldObj.spawnEntityInWorld((EntityAnimal)pregnantEntity);
                }

                --itemstack.stackSize;
            }

            player.triggerAchievement(FossilAchievementHandler.IceAge);
            return true;
        }

        return false;
    }
}
