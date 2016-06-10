package com.github.revival.server.block.entity;

import com.github.revival.server.entity.mob.EntityAnubite;
import com.github.revival.server.handler.FossilAchievementHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAnubiteStatue extends TileEntity {

    @Override
    public void updateEntity() {
        EntityPlayer player = this.worldObj.getClosestPlayer(xCoord, yCoord, zCoord, 5);
        if (player != null) {
            player.addStat(FossilAchievementHandler.anubiteEncounter, 1);
            if (!player.capabilities.isCreativeMode) {
                worldObj.newExplosion(null, xCoord + 0.5F, yCoord, zCoord + 0.5, 5F, true, true);
                EntityAnubite newMob = new EntityAnubite(worldObj);
                if (!worldObj.isRemote) {
                    newMob.setLocationAndAngles(xCoord + 0.5, yCoord, zCoord + 0.5, 0, 0);
                    worldObj.spawnEntityInWorld(newMob);
                    worldObj.removeTileEntity(xCoord, yCoord, zCoord);
                    worldObj.setBlock(xCoord, yCoord, zCoord, Blocks.air);
                }
            }
        }
        super.updateEntity();
    }
}
