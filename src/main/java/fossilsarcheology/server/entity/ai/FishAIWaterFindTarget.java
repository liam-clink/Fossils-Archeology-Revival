package fossilsarcheology.server.entity.ai;

import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

import fossilsarcheology.server.entity.EntityFishBase;

public class FishAIWaterFindTarget extends EntityAIBase {
    private EntityFishBase mob;
    private double shelterX;
    private double shelterY;
    private double shelterZ;
    private double movementSpeed;
    private World theWorld;

    public FishAIWaterFindTarget(EntityFishBase mob, double speed) {
        this.mob = mob;
        this.movementSpeed = speed;
        this.theWorld = mob.worldObj;
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        if (!mob.isDirectPathBetweenPoints(new BlockPos(MathHelper.floor_double(mob.posX), MathHelper.floor_double(mob.posY), MathHelper.floor_double(mob.posZ)), new BlockPos(MathHelper.floor_double(shelterX), MathHelper.floor_double(shelterY), MathHelper.floor_double(shelterZ)))) {
            mob.currentTarget = null;
        }

        if (mob.currentTarget != null && mob.getDistance(mob.currentTarget.getX(), mob.currentTarget.getY(), mob.currentTarget.getZ()) < 10F) {
            return false;
        } else {
            BlockPos vec3 = this.findWaterTarget();

            if (vec3 == null) {
                return false;
            } else {
                this.shelterX = vec3.getX();
                this.shelterY = vec3.getY();
                this.shelterZ = vec3.getZ();
                return true;
            }
        }
    }

    public boolean continueExecuting() {
        return mob.currentTarget != null;
    }

    public void startExecuting() {
        this.mob.currentTarget = new BlockPos((int) shelterX, (int) shelterY, (int) shelterZ);
    }

    public BlockPos findWaterTarget() {
        if (mob.getAttackTarget() == null || !mob.getPassengers().isEmpty() && mob.getAttackTarget() != null) {
            Random random = this.mob.getRNG();
            mob.setAttackTarget(null);
            BlockPos chunkCoordinates = getCoords();
            for (int i = 0; i < 10; ++i) {
                BlockPos coords = new BlockPos(chunkCoordinates.getX() + random.nextInt(20) - 10, chunkCoordinates.getY() + random.nextInt(6) - 3, chunkCoordinates.getZ() + random.nextInt(20) - 10);
                if (mob.worldObj.getBlockState(new BlockPos(coords.getX(), coords.getY(), coords.getZ())).getMaterial() == Material.WATER) {
                    return coords;
                }
            }
        } else {
            Random random = this.mob.getRNG();
            BlockPos coords = getCoords();
            if (mob.worldObj.getBlockState(new BlockPos(coords.getX(), coords.getY(), coords.getZ())).getMaterial() == Material.WATER) {
                return coords;
            }
        }

        return null;
    }

    public BlockPos getCoords() {
        int i = MathHelper.floor_double(mob.posX);
        int j = MathHelper.floor_double(mob.posY);
        int k = MathHelper.floor_double(mob.posZ);
        boolean b = mob.worldObj.getBlockState(new BlockPos(i, j + 1, k)).getMaterial() == Material.WATER;
        return new BlockPos((int) this.mob.posX, (int) this.mob.getEntityBoundingBox().minY, (int) this.mob.posZ);
    }

}