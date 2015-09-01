package com.github.revival.common.item;

import com.github.revival.common.entity.mob.EntityPregnantCow;
import com.github.revival.common.entity.mob.EntityPregnantHorse;
import com.github.revival.common.entity.mob.EntityPregnantPig;
import com.github.revival.common.entity.mob.EntityPregnantSheep;
import com.github.revival.common.enums.EnumAnimalType;
import com.github.revival.common.enums.EnumPrehistoric;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;

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

    public static EnumAnimalType GetEmbryo(int var0)
    {
        return EnumAnimalType.values()[var0];
    }
}
