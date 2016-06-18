package fossilsarcheology.server.entity.mob.test;

import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.Random;

public class DinoAIFindAirTarget extends EntityAIBase {
    private EntityFlyingPrehistoric prehistoric;
    private int shelterX;
    private int shelterY;
    private int shelterZ;
    private World theWorld;

    public DinoAIFindAirTarget(EntityFlyingPrehistoric prehistoric) {
        this.prehistoric = prehistoric;
        this.theWorld = prehistoric.worldObj;
    }

    public boolean shouldExecute() {
        if (prehistoric.isDirectPathBetweenPoints(prehistoric.getPosition(), Vec3.createVectorHelper(shelterX, shelterY, shelterZ))) {
            prehistoric.currentTarget = null;
        }

        if (prehistoric.currentTarget != null) {
            return false;
        } else {
            Vec3 vec = this.findAirTarget();
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

    public Vec3 findAirTarget() {
        Random random = this.prehistoric.getRNG();

        if (prehistoric.getAttackTarget() == null) {
            for (int i = 0; i < 10; ++i) {
                ChunkCoordinates blockpos1 = new ChunkCoordinates((int) this.prehistoric.posX + ((16 + random.nextInt(10)) * (random.nextBoolean() ? -1 : 1)), (int) this.prehistoric.posY + ((random.nextInt(6)) * (random.nextBoolean() ? -1 : 1)), (int) this.prehistoric.posZ + ((6 + random.nextInt(10)) * (random.nextBoolean() ? -1 : 1)));
                if (prehistoric.worldObj.getBlock(blockpos1.posX, blockpos1.posY, blockpos1.posZ).getMaterial() == Material.air) {
                    return Vec3.createVectorHelper(blockpos1.posX, blockpos1.posY, blockpos1.posZ);
                }
            }
        } else {
            ChunkCoordinates blockpos1 = new ChunkCoordinates((int) prehistoric.getAttackTarget().posX, (int) prehistoric.getAttackTarget().posY, (int) prehistoric.getAttackTarget().posZ);
            if (prehistoric.worldObj.getBlock(blockpos1.posX, blockpos1.posY, blockpos1.posZ).getMaterial() == Material.air) {
                return Vec3.createVectorHelper(blockpos1.posX, blockpos1.posY, blockpos1.posZ);
            }
        }

        return null;
    }

}