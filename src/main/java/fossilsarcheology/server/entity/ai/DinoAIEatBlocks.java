package fossilsarcheology.server.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.Item;
import net.minecraft.util.ChunkCoordinates;
import fossilsarcheology.Revival;
import fossilsarcheology.api.FoodMappings;
import fossilsarcheology.server.entity.EntityPrehistoric;

public class DinoAIEatBlocks extends EntityAIBase {
	private ChunkCoordinates targetBlock;
	private EntityPrehistoric prehistoric;
	private double speed;

	public DinoAIEatBlocks(EntityPrehistoric prehistoric, double speed) {
		super();
		this.prehistoric = prehistoric;
		this.speed = speed;
		this.setMutexBits(1);
	}

	@Override
	public boolean shouldExecute() {

		if (prehistoric.getHunger() >= 100) {
			//return false;
		}
		if (prehistoric.isMovementBlocked()) {
			return false;
		}
		if (prehistoric.getRNG().nextInt(1) != 0) {
			return false;
		}
		int radius = 16;
		for (int x = (int) (prehistoric.posX) - (radius / 2); x < (int) (prehistoric.posX) + (radius / 2); x++) {
			for (int y = (int) (prehistoric.posY) - (radius / 2); y < (int) (prehistoric.posY) + (radius / 2); y++) {
				for (int z = (int) (prehistoric.posZ) - (radius / 2); z < (int) (prehistoric.posZ) + (radius / 2); z++) {
					if (FoodMappings.INSTANCE.getBlockFoodAmount(prehistoric.worldObj.getBlock(x, y, z), prehistoric.type.diet) > 0) {
						targetBlock = new ChunkCoordinates(x, y, z);
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean continueExecuting() {
		if (targetBlock == null) {
			return false;
		}
		if (prehistoric.getHunger() >= 100) {

			return false;
		}

		if (prehistoric.isMovementBlocked()) {
			return false;
		}
		return true;
	}

	@Override
	public void startExecuting() {
		super.startExecuting();
	}

	@Override
	public void updateTask() {
		if (targetBlock != null) {
			Block block = prehistoric.worldObj.getBlock(this.targetBlock.posX, this.targetBlock.posY, this.targetBlock.posZ);
			if (FoodMappings.INSTANCE.getBlockFoodAmount(block, prehistoric.type.diet) > 0) {
				double d0 = prehistoric.getDistance(this.targetBlock.posX, this.targetBlock.posY, this.targetBlock.posZ);
				if (d0 * d0 < 6) {
					prehistoric.setHunger(Math.min(100, prehistoric.getHunger() + FoodMappings.INSTANCE.getBlockFoodAmount(block, prehistoric.type.diet)));
					prehistoric.setHealth(Math.min(prehistoric.getMaxHealth(), (int) (prehistoric.getHealth() + FoodMappings.INSTANCE.getBlockFoodAmount(block, prehistoric.type.diet) / 10)));
					prehistoric.doFoodEffect(Item.getItemFromBlock(block));
					prehistoric.worldObj.func_147480_a(this.targetBlock.posX, this.targetBlock.posY, this.targetBlock.posZ, false);
					targetBlock = null;
					resetTask();
					return;
				}else{
					if(prehistoric.getNavigator().noPath()){
						this.prehistoric.getNavigator().tryMoveToXYZ(this.targetBlock.posX, this.targetBlock.posY, this.targetBlock.posZ, speed);
					}
				}
			}
		}
	}

}
