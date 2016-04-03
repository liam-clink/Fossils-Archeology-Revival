package com.github.revival.server.block.entity;

import com.github.revival.server.entity.mob.EntityAnu;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySarcophagus extends TileEntity {
    public int chestState = 0;
    public int chestLidCounter;
    public int chestLidCounter2;

    @Override
    public void updateEntity() {
        super.updateEntity();

        if (this.chestState != 3) {
            if (chestLidCounter != 0 && chestLidCounter < 91) {
                chestLidCounter++;
            }
            if (chestLidCounter == 91) {
                this.setChestState(3);
                EntityAnu newMob = new EntityAnu(worldObj);
                if (!worldObj.isRemote) {
                    newMob.setLocationAndAngles(xCoord + 0.5, yCoord, zCoord + 0.5, 0, 0);

                    worldObj.spawnEntityInWorld(newMob);
                }
                newMob.initializeMob();
                worldObj.playSoundEffect(this.xCoord, (double) this.yCoord + 0.5D, this.zCoord, "random.chestclosed", 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
            }
        } else {
            if (chestLidCounter != 0 && chestLidCounter > 0) {
                chestLidCounter--;
            }
            if (chestLidCounter == 0) {
                this.setChestState(0);
            }
        }
    }

    public void setChestState(int state) {
        chestState = state;
    }

}

