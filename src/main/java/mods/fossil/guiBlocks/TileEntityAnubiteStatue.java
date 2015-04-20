package mods.fossil.guiBlocks;

import mods.fossil.Fossil;
import mods.fossil.entity.EntityAnuEffect;
import mods.fossil.entity.mob.EntityAnubite;
import mods.fossil.handler.FossilAchievementHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAnubiteStatue extends TileEntity {

	public void updateEntity()
    {
		for (int var7 = 0; var7 < worldObj.playerEntities.size(); ++var7) {
			EntityPlayer P = (EntityPlayer) worldObj.playerEntities.get(var7);

			if (Math.pow(this.xCoord - P.posX, 2D) + Math.pow(this.yCoord - P.posY, 2D) + Math.pow(this.zCoord - P.posZ, 2D) < 40)
			{
				P.addStat(FossilAchievementHandler.anubiteEncounter, 1);
				if(!P.capabilities.isCreativeMode){
					worldObj.newExplosion((Entity)null, xCoord + 0.5F, yCoord, zCoord + 0.5, 5F, true, true);
					EntityAnubite newMob = new EntityAnubite(worldObj);
					if(!worldObj.isRemote){
					newMob.setLocationAndAngles(xCoord + 0.5, yCoord, zCoord + 0.5, 0,0);
					worldObj.spawnEntityInWorld(newMob);
					worldObj.removeTileEntity(xCoord, yCoord, zCoord);
					worldObj.setBlock(xCoord, yCoord, zCoord, Blocks.air);
					}
				}
			}
		}
		super.updateEntity();
    }
}
