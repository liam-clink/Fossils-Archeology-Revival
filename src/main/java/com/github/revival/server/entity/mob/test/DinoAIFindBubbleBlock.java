package com.github.revival.server.entity.mob.test;

import com.github.revival.Revival;
import com.github.revival.server.block.FABlockRegistry;
import com.github.revival.server.block.entity.TileEntityNewFeeder;
import com.github.revival.server.enums.EnumOrderType;
import com.github.revival.server.item.FAItemRegistry;
import com.github.revival.server.message.MessageFoodParticles;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MathHelper;

public class DinoAIFindBubbleBlock extends EntityAIBase {

	private EntityNewPrehistoric dinosaur;
	private int blockX, blockY, blockZ;

	public DinoAIFindBubbleBlock(EntityNewPrehistoric dinosaur) {
		this.dinosaur = dinosaur;
		this.setMutexBits(1);
	}

	@Override
	public boolean isInterruptible() {
		return false;
	}

	@Override
	public boolean shouldExecute() {
		if (isThereActuallyABlock()) {
			blockX = dinosaur.getNearestBubbleBlock(48, 0);
			blockY = dinosaur.getNearestBubbleBlock(48, 1);
			blockZ = dinosaur.getNearestBubbleBlock(48, 3);
			if (dinosaur.worldObj.getBlock(blockX, blockY, blockZ) == FABlockRegistry.INSTANCE.bubbleMachine && dinosaur.worldObj.isBlockIndirectlyGettingPowered(blockX, blockY, blockZ)) {
				return this.dinosaur.ticksTillPlay == 0;
			}
		}
		return false;
	}

	@Override
	public boolean continueExecuting() {
		return this.dinosaur.ticksTillPlay == 0 && dinosaur.worldObj.getBlock(blockX, blockY, blockZ) == FABlockRegistry.INSTANCE.bubbleMachine && dinosaur.worldObj.isBlockIndirectlyGettingPowered(blockX, blockY, blockZ);
	}

	@Override
	public void updateTask() {
		int range = 48;
		this.dinosaur.setSitting(false);
		this.dinosaur.setOrder(EnumOrderType.WANDER);
		double distance = Math.sqrt(Math.pow(this.dinosaur.posX - this.blockX, 2.0D) + Math.pow(this.dinosaur.posZ - this.blockZ, 2.0D));
		if (!continueExecuting()) {
			endTask();
		}
		if (distance < range) {
			this.dinosaur.getNavigator().tryMoveToXYZ(this.blockX, this.blockY + 1, this.blockZ, 1.0D);
			for (int i = 0; i < 1; ++i) {
				double dd = this.dinosaur.getRNG().nextGaussian() * 0.02D;
				double dd1 = this.dinosaur.getRNG().nextGaussian() * 0.02D;
				double dd2 = this.dinosaur.getRNG().nextGaussian() * 0.02D;
				Revival.PROXY.spawnPacketHeartParticles(this.dinosaur.worldObj, (float) (this.dinosaur.posX + (this.dinosaur.getRNG().nextFloat() * this.dinosaur.width * 2.0F) - this.dinosaur.width), (float) (this.dinosaur.posY + 0.5D + (this.dinosaur.getRNG().nextFloat() * this.dinosaur.height)), (float) (this.dinosaur.posZ + (this.dinosaur.getRNG().nextFloat() * this.dinosaur.width * 2.0F) - this.dinosaur.width), dd, dd1, dd2);
			}
		} else {
			endTask();
		}
	}

	private void endTask() {
		blockX = blockY = blockZ = 0;
	}

	public boolean isThereActuallyABlock() {
		return dinosaur.getNearestBubbleBlock(48, 0) != 0 && dinosaur.getNearestBubbleBlock(48, 1) != 0 && dinosaur.getNearestBubbleBlock(48, 2) != 0;
	}

}
