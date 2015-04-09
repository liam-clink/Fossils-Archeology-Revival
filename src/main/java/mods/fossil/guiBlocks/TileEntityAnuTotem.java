package mods.fossil.guiBlocks;

import mods.fossil.Fossil;
import mods.fossil.entity.EntityAnuEffect;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAnuTotem extends TileEntity {

	public void updateEntity()
    {
		 if(worldObj.getBlock(this.xCoord -1, yCoord, zCoord-1)==Fossil.figurineBlock&&worldObj.getBlock(xCoord+1, yCoord, zCoord-1)==Fossil.figurineBlock&&
					worldObj.getBlock(xCoord+1, yCoord, zCoord+1)==Fossil.figurineBlock&&worldObj.getBlock(xCoord-1, yCoord, zCoord+1)==Fossil.figurineBlock
					&& worldObj.getBlock(xCoord-1, yCoord, zCoord)==Blocks.redstone_wire&&worldObj.getBlock(xCoord+1, yCoord, zCoord)==Blocks.redstone_wire
					&& worldObj.getBlock(xCoord, yCoord, zCoord-1)==Blocks.redstone_wire&&worldObj.getBlock(xCoord, yCoord, zCoord+1)==Blocks.redstone_wire){
			
				worldObj.newExplosion((Entity)null, xCoord + 0.5F, yCoord, zCoord + 0.5, 5F, true, true);
				EntityAnuEffect newMob = new EntityAnuEffect(worldObj);
				if(!worldObj.isRemote){
				newMob.setLocationAndAngles(xCoord + 0.5, yCoord, zCoord + 0.5, 0,0);
				
				worldObj.spawnEntityInWorld(newMob);
				}
				newMob.setAnuRotation(worldObj.getBlockMetadata(xCoord, yCoord, zCoord));
				newMob.playSummonSong();
				newMob.setHealth(0);
				worldObj.setBlockToAir(xCoord-1, yCoord, zCoord);
				worldObj.setBlockToAir(xCoord+1, yCoord, zCoord);
				worldObj.setBlockToAir(xCoord, yCoord, zCoord-1);
				worldObj.setBlockToAir(xCoord, yCoord, zCoord+1);
				worldObj.setBlockToAir(xCoord-1, yCoord, zCoord-1);
				worldObj.setBlockToAir(xCoord+1, yCoord, zCoord+1);
				worldObj.setBlockToAir(xCoord-1, yCoord, zCoord+1);
				worldObj.setBlockToAir(xCoord+1, yCoord, zCoord-1);
				worldObj.setBlockToAir(xCoord, yCoord, zCoord);
				worldObj.setBlockToAir(xCoord, yCoord+1, zCoord);

		}
		super.updateEntity();
    }
}
