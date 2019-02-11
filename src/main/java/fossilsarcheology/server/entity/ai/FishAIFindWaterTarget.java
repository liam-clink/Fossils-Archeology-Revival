package fossilsarcheology.server.entity.ai;

import fossilsarcheology.server.entity.EntityFishBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

import java.util.ArrayList;
import java.util.List;

public class FishAIFindWaterTarget extends EntityAIBase {
	private final EntityFishBase mob;

	public FishAIFindWaterTarget(EntityFishBase mob) {
		this.mob = mob;
	}

	@Override
	public boolean shouldExecute() {
		if (!this.mob.isInWater()) {
			return false;
		}
		if (this.mob.getRNG().nextFloat() < 0.5F) {
			Path path = this.mob.getNavigator().getPath();
			if (!this.mob.getNavigator().noPath() && !isDirectPathBetweenPoints(this.mob, this.mob.getPositionVector(), new Vec3d(path.getFinalPathPoint().x, path.getFinalPathPoint().y, path.getFinalPathPoint().z)) || path != null && path.getFinalPathPoint() != null &&  this.mob.getDistanceSq(path.getFinalPathPoint().x, path.getFinalPathPoint().y, path.getFinalPathPoint().z) < 3) {
				this.mob.getNavigator().clearPath();
			}
			if (this.mob.getNavigator().noPath()) {
				BlockPos vec3 = this.findWaterTarget();
				if (vec3 != null) {
					this.mob.getNavigator().tryMoveToXYZ(vec3.getX(), vec3.getY(), vec3.getZ(), 1.0);
					return true;
				}
			}
		}
		return false;
	}

	public boolean isDirectPathBetweenPoints(Entity entity, Vec3d vec1, Vec3d vec2) {
		RayTraceResult movingobjectposition = entity.world.rayTraceBlocks(vec1, new Vec3d(vec2.x, vec2.y + (double) entity.height * 0.5D, vec2.z), false, true, false);
		return movingobjectposition == null || movingobjectposition.typeOfHit != RayTraceResult.Type.BLOCK;
	}

	@Override
	public boolean shouldContinueExecuting() {
		return false;
	}

	public BlockPos findWaterTarget() {
		if (this.mob.getAttackTarget() == null) {
			List<BlockPos> water = new ArrayList<>();
			for (int x = (int) this.mob.posX - 5; x < (int) this.mob.posX + 5; x++) {
				for (int y = (int) this.mob.posY - 3; y < (int) this.mob.posY + 3; y++) {
					for (int z = (int) this.mob.posZ - 5; z < (int) this.mob.posZ + 5; z++) {
						if (this.mob.isDirectPathBetweenPoints(this.mob.getPositionVector(), new Vec3d(x, y, z))) {
							water.add(new BlockPos(x, y, z));
						}
					}
				}
			}
			if (!water.isEmpty()) {
				return water.get(this.mob.getRNG().nextInt(water.size()));
			}
		} else {
			BlockPos blockpos1;
			blockpos1 = new BlockPos(this.mob.getAttackTarget());
			if (this.mob.world.getBlockState(blockpos1).getMaterial() == Material.WATER) {
				return blockpos1;
			}
		}
		return null;
	}
}
