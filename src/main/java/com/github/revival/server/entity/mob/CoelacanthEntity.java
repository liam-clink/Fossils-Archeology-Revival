package com.github.revival.server.entity.mob;

import com.github.revival.server.item.FAItemRegistry;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

public class CoelacanthEntity extends FishBaseEntity {
    public CoelacanthEntity(World par1World) {
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
        FishBaseEntity entity = null;

        if ((new Random()).nextInt(100) + 1 < i) {
            entity = new CoelacanthEntity(this.worldObj);
            entity.setLocationAndAngles(this.posX + (double) ((new Random()).nextInt(3) - 1), this.posY, this.posZ + (double) ((new Random()).nextInt(3) - 1), this.worldObj.rand.nextFloat() * 360.0F, 0.0F);

            if (this.worldObj.checkNoEntityCollision(entity.boundingBox) && this.worldObj.getCollidingBoundingBoxes(entity, entity.boundingBox).size() == 0 && this.worldObj.isAnyLiquid(entity.boundingBox)) {
                this.worldObj.spawnEntityInWorld(entity);
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
