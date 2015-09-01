package com.github.revival.common.tileentity;

import com.github.revival.common.block.FABlockRegistry;
import com.github.revival.common.entity.EntityAnuEffect;
import com.github.revival.common.handler.FossilAchievementHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAnuTotem extends TileEntity
{

    public void updateEntity()
    {
        for (int var7 = 0; var7 < worldObj.playerEntities.size(); ++var7)
        {
            EntityPlayer P = (EntityPlayer) worldObj.playerEntities.get(var7);

            if (Math.pow(this.xCoord - P.posX, 2D) + Math.pow(this.yCoord - P.posY, 2D) + Math.pow(this.zCoord - P.posZ, 2D) < 40)
            {
                P.addStat(FossilAchievementHandler.findAnuTotem, 1);
            }
        }

        if (worldObj.getBlock(this.xCoord - 1, yCoord, zCoord - 1) == FABlockRegistry.figurineBlock && worldObj.getBlock(xCoord + 1, yCoord, zCoord - 1) == FABlockRegistry.figurineBlock &&
                worldObj.getBlock(xCoord + 1, yCoord, zCoord + 1) == FABlockRegistry.figurineBlock && worldObj.getBlock(xCoord - 1, yCoord, zCoord + 1) == FABlockRegistry.figurineBlock
                && worldObj.getBlock(xCoord - 1, yCoord, zCoord) == Blocks.redstone_wire && worldObj.getBlock(xCoord + 1, yCoord, zCoord) == Blocks.redstone_wire
                && worldObj.getBlock(xCoord, yCoord, zCoord - 1) == Blocks.redstone_wire && worldObj.getBlock(xCoord, yCoord, zCoord + 1) == Blocks.redstone_wire)
        {
            for (int var7 = 0; var7 < worldObj.playerEntities.size(); ++var7)
            {
                EntityPlayer P = (EntityPlayer) worldObj.playerEntities.get(var7);

                if (Math.pow(this.xCoord - P.posX, 2D) + Math.pow(this.yCoord - P.posY, 2D) + Math.pow(this.zCoord - P.posZ, 2D) < 90)
                {
                    P.addStat(FossilAchievementHandler.anuPortal, 1);
                }
            }
            worldObj.newExplosion((Entity) null, xCoord + 0.5F, yCoord, zCoord + 0.5, 5F, true, true);
            EntityAnuEffect newMob = new EntityAnuEffect(worldObj);
            if (!worldObj.isRemote)
            {
                newMob.setLocationAndAngles(xCoord + 0.5, yCoord, zCoord + 0.5, 0, 0);

                worldObj.spawnEntityInWorld(newMob);
            }
            newMob.setAnuRotation(worldObj.getBlockMetadata(xCoord, yCoord, zCoord));
            newMob.playSummonSong();
            newMob.setHealth(0);
            worldObj.setBlockToAir(xCoord - 1, yCoord, zCoord);
            worldObj.setBlockToAir(xCoord + 1, yCoord, zCoord);
            worldObj.setBlockToAir(xCoord, yCoord, zCoord - 1);
            worldObj.setBlockToAir(xCoord, yCoord, zCoord + 1);
            worldObj.setBlockToAir(xCoord - 1, yCoord, zCoord - 1);
            worldObj.setBlockToAir(xCoord + 1, yCoord, zCoord + 1);
            worldObj.setBlockToAir(xCoord - 1, yCoord, zCoord + 1);
            worldObj.setBlockToAir(xCoord + 1, yCoord, zCoord - 1);
            worldObj.setBlockToAir(xCoord, yCoord, zCoord);
            worldObj.setBlockToAir(xCoord, yCoord + 1, zCoord);

        }
        super.updateEntity();
    }
}
