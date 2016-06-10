package com.github.revival.server.entity.mob.test;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.sun.javafx.geom.Vec3d;

public class DinoAIWaterFindTarget extends EntityAIBase {
	private EntitySwimmingPrehistoric prehistoric;
	private int shelterX;
	private int shelterY;
	private int shelterZ;
	private World theWorld;

	public DinoAIWaterFindTarget(EntitySwimmingPrehistoric prehistoric) {
		this.prehistoric = prehistoric;
		this.theWorld = prehistoric.worldObj;
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	public boolean shouldExecute() {
		if (prehistoric.isDirectPathBetweenPoints(prehistoric.getPositionVector(), Vec3.createVectorHelper(shelterX, shelterY, shelterZ))) {
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

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	public boolean continueExecuting() {
		return prehistoric.currentTarget != null;
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void startExecuting() {
		this.prehistoric.currentTarget = new ChunkCoordinates(shelterX, shelterY, shelterZ);
	}

	public Vec3 findWaterTarget() {
		Random random = this.prehistoric.getRNG();

		if (prehistoric.getAttackTarget() == null) {
			prehistoric.setAttackTarget(null);
			for (int i = 0; i < 10; ++i) {
				ChunkCoordinates blockpos1 = new ChunkCoordinates((int) this.prehistoric.posX + random.nextInt(20) - 10, (int) this.prehistoric.posX + random.nextInt(6) - 3, (int) this.prehistoric.posX + random.nextInt(20) - 10);
				if (prehistoric.worldObj.getBlock(blockpos1.posX, blockpos1.posY, blockpos1.posZ).getMaterial() == Material.water) {
					return Vec3.createVectorHelper(blockpos1.posX, blockpos1.posY, blockpos1.posZ);
				}
			}
		} else {
			ChunkCoordinates blockpos1 = new ChunkCoordinates((int) prehistoric.getAttackTarget().posX, (int) prehistoric.getAttackTarget().posY, (int) prehistoric.getAttackTarget().posZ);
			if (prehistoric.worldObj.getBlock(blockpos1.posX, blockpos1.posY, blockpos1.posZ).getMaterial() == Material.water) {
				return Vec3.createVectorHelper(blockpos1.posX, blockpos1.posY, blockpos1.posZ);
			}
		}

		return null;
	}

}