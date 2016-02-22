package com.github.revival.common.entity.mob;

import com.github.revival.common.item.FAItemRegistry;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

public class EntityCoelacanth extends EntityFishBase {
    public EntityCoelacanth(World par1World) {
        super(par1World);
    }

    @Override
    public String getItemTexture() {
        return "fossil:textures/items/prehistoric/fish/Coelacanth_live_Ocean.png";
    }

    @Override
    public String getTexture() {
        return "fossil:textures/mob/fish/coelacanth.png";
    }

    @Override
    public void spawnBaby(int i) {
        EntityFishBase var6 = null;

        if ((new Random()).nextInt(100) + 1 < i) {
            var6 = new EntityCoelacanth(this.worldObj);
            var6.setLocationAndAngles(this.posX + (double) ((new Random()).nextInt(3) - 1), this.posY, this.posZ + (double) ((new Random()).nextInt(3) - 1), this.worldObj.rand.nextFloat() * 360.0F, 0.0F);

            if (this.worldObj.checkNoEntityCollision(var6.boundingBox) && this.worldObj.getCollidingBoundingBoxes(var6, var6.boundingBox).size() == 0 && this.worldObj.isAnyLiquid(var6.boundingBox)) {
                this.worldObj.spawnEntityInWorld(var6);
            }
        }
    }

    @Override
    public String getName() {
        return "Coelacanth";
    }

    @Override
    public String getCodeName() {
        return "entity.coelacanth.name";
    }

    @Override
    public Item getItem() {
        return FAItemRegistry.livingCoelacanth;
    }

}
