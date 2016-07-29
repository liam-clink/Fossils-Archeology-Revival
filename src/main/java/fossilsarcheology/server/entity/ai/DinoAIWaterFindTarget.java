package fossilsarcheology.server.entity.ai;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import fossilsarcheology.server.entity.EntityPrehistoricSwimming;
import fossilsarcheology.server.enums.EnumOrderType;

public class DinoAIWaterFindTarget extends EntityAIBase {
	private EntityPrehistoricSwimming prehistoric;
	private int shelterX;
	private int shelterY;
	private int shelterZ;
	private World theWorld;
	private boolean canGoOnLand;
	
	public DinoAIWaterFindTarget(EntityPrehistoricSwimming prehistoric, boolean canGoOnLand) {
		this.prehistoric = prehistoric;
		this.theWorld = prehistoric.worldObj;
		this.canGoOnLand = canGoOnLand;
	}

	public boolean shouldExecute() {
		if (prehistoric.isMovementBlocked()) {
			return false;
		}
		if (prehistoric.getRidingPlayer() != null) {
			return false;
		}
		if (prehistoric.isDirectPathBetweenPoints(prehistoric.getPosition(), Vec3.createVectorHelper(shelterX, shelterY, shelterZ))) {
			prehistoric.currentTarget = null;
		}
		if (prehistoric.currentTarget != null && prehistoric.getDistance(prehistoric.currentTarget.posX, prehistoric.currentTarget.posY, prehistoric.currentTarget.posZ) < 10F) {
			return false;
		} else {
			Vec3 vec = this.findWaterTarget();
			if (vec == null) {
				return false;
			} else {
				this.shelterX = (int) vec.xCoord;
				this.shelterY = (int) vec.yCoord;
				this.shelterZ = (int) vec.zCoord;
				return true;
			}
		}
	}

	public boolean continueExecuting() {
		return prehistoric.currentTarget != null;
	}

	public void startExecuting() {
		this.prehistoric.currentTarget = new ChunkCoordinates(shelterX, shelterY, shelterZ);
	}

	public Vec3 findWaterTarget() {
		Random random = this.prehistoric.getRNG();
		if (prehistoric.isTamed() && prehistoric.currentOrder == EnumOrderType.FOLLOW && prehistoric.getOwner() != null) {
			ChunkCoordinates blockpos1 = new ChunkCoordinates((int) prehistoric.getOwner().posX, (int) prehistoric.getOwner().posY, (int) prehistoric.getOwner().posZ);
			if (canGoToBlock(blockpos1.posX, blockpos1.posY, blockpos1.posZ)) {
				return Vec3.createVectorHelper(blockpos1.posX, blockpos1.posY, blockpos1.posZ);
			}
		}
		if (prehistoric.getAttackTarget() == null) {
			List<Vec3> water = new ArrayList<Vec3>();
			for(int x = (int)prehistoric.posX - 5; x < (int)prehistoric.posX + 5; x++){
				for(int y = (int)prehistoric.posY - 5; y < (int)prehistoric.posY + 5; y++){
					for(int z = (int)prehistoric.posZ - 5; z < (int)prehistoric.posZ + 5; z++){
						if(prehistoric.isDirectPathBetweenPoints(prehistoric.getPosition(), Vec3.createVectorHelper(x, y, z))) {
							water.add(Vec3.createVectorHelper(x, y, z));
						}
					}
				}
			}
			if(!water.isEmpty()){
				return water.get(prehistoric.getRNG().nextInt(water.size()));
			}
		} else {
			ChunkCoordinates blockpos1 = new ChunkCoordinates((int) prehistoric.getAttackTarget().posX, (int) prehistoric.getAttackTarget().posY, (int) prehistoric.getAttackTarget().posZ);
			if (canGoToBlock(blockpos1.posX, blockpos1.posY, blockpos1.posZ)) {
				return Vec3.createVectorHelper(blockpos1.posX, blockpos1.posY, blockpos1.posZ);
			}
		}

		return null;
	}
	
	public boolean canGoToBlock(int x, int y, int z){
		if(this.canGoOnLand){
			return prehistoric.worldObj.getBlock(x, y, z).getMaterial() == Material.water || prehistoric.worldObj.getBlock(x, y, z).getMaterial() == Material.air && prehistoric.worldObj.getBlock(x, y - 1, z).getMaterial() != Material.air && prehistoric.worldObj.getBlock(x, y - 1, z).getMaterial() != Material.water;
		}else{
			return prehistoric.worldObj.getBlock(x, y, z).getMaterial() == Material.water;
		}
	}

}