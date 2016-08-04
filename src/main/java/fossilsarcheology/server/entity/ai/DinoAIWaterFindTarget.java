package fossilsarcheology.server.entity.ai;

import fossilsarcheology.server.entity.EntityPrehistoricSwimming;
import fossilsarcheology.server.enums.EnumOrderType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

import java.util.Random;

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
        if (prehistoric.isDirectPathBetweenPoints(prehistoric.getPosition(), new Vec3d(shelterX, shelterY, shelterZ))) {
            prehistoric.currentTarget = null;
        }
        if (prehistoric.currentTarget != null && prehistoric.getDistance(prehistoric.currentTarget.posX, prehistoric.currentTarget.posY, prehistoric.currentTarget.posZ) < 10F) {
            return false;
        } else {
            Vec3d vec = this.findWaterTarget();
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

    public Vec3d findWaterTarget() {
        Random random = this.prehistoric.getRNG();
        if (prehistoric.isTamed() && prehistoric.currentOrder == EnumOrderType.FOLLOW) {
            ChunkCoordinates blockpos1 = new ChunkCoordinates((int) prehistoric.getOwner().posX, (int) prehistoric.getOwner().posY, (int) prehistoric.getOwner().posZ);
            if (canGoToBlock(blockpos1.posX, blockpos1.posY, blockpos1.posZ)) {
                return new Vec3d(blockpos1.posX, blockpos1.posY, blockpos1.posZ);
            }
        }

        if (prehistoric.getAttackTarget() == null) {
            for (int i = 0; i < 10; ++i) {
                ChunkCoordinates blockpos1 = new ChunkCoordinates((int) this.prehistoric.posX + ((4 + random.nextInt(10)) * (random.nextBoolean() ? -1 : 1)), (int) this.prehistoric.posY + (prehistoric.onGround ? 1 + random.nextInt(6) : (random.nextInt(6) * (random.nextBoolean() ? -1 : 1))), (int) this.prehistoric.posZ + ((4 + random.nextInt(10)) * (random.nextBoolean() ? -1 : 1)));
                if (canGoToBlock(blockpos1.posX, blockpos1.posY, blockpos1.posZ)) {
                    return new Vec3d(blockpos1.posX, blockpos1.posY, blockpos1.posZ);
                }
            }
        } else {
            ChunkCoordinates blockpos1 = new ChunkCoordinates((int) prehistoric.getAttackTarget().posX, (int) prehistoric.getAttackTarget().posY, (int) prehistoric.getAttackTarget().posZ);
            if (canGoToBlock(blockpos1.posX, blockpos1.posY, blockpos1.posZ)) {
                return new Vec3d(blockpos1.posX, blockpos1.posY, blockpos1.posZ);
            }
        }

        return null;
    }

    public boolean canGoToBlock(BlockPos pos) {
        if (this.canGoOnLand) {
            return prehistoric.worldObj.getBlock(pos).getMaterial() == Material.water || prehistoric.worldObj.getBlock(pos).getMaterial() == Material.air && prehistoric.worldObj.getBlock(x, y - 1, z).getMaterial() != Material.air && prehistoric.worldObj.getBlock(x, y - 1, z).getMaterial() != Material.water;
        } else {
            return prehistoric.worldObj.getBlock(pos).getMaterial() == Material.water;
        }
    }

}