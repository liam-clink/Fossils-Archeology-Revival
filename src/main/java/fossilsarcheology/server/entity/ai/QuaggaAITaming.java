package fossilsarcheology.server.entity.ai;

import fossilsarcheology.server.entity.mob.EntityQuagga;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;

public class QuaggaAITaming extends EntityAIBase {
    private EntityQuagga quagga;
    private double speed;
    private double targetX;
    private double targetY;
    private double targetZ;

    public QuaggaAITaming(EntityQuagga quagga, double speed) {
        this.quagga = quagga;
        this.speed = speed;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        if (!this.quagga.isTame() && this.quagga.getPassengers().isEmpty()) {
            Vec3d target = RandomPositionGenerator.findRandomTarget(this.quagga, 5, 4);
            if (target == null) {
                return false;
            } else {
                this.targetX = target.xCoord;
                this.targetY = target.yCoord;
                this.targetZ = target.zCoord;
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public void startExecuting() {
        this.quagga.getNavigator().tryMoveToXYZ(this.targetX, this.targetY, this.targetZ, this.speed);
    }

    @Override
    public boolean continueExecuting() {
        return !this.quagga.getNavigator().noPath() && this.quagga.getPassengers().isEmpty();
    }

    @Override
    public void updateTask() {
        if (this.quagga.getRNG().nextInt(50) == 0) {
            if (this.quagga.getControllingPassenger() instanceof EntityPlayer) {
                int temper = this.quagga.getTemper();
                int maxTemper = this.quagga.getMaxTemper();
                if (maxTemper > 0 && this.quagga.getRNG().nextInt(maxTemper) < temper) {
                    this.quagga.setTamedBy((EntityPlayer) this.quagga.getControllingPassenger());
                    this.quagga.worldObj.setEntityState(this.quagga, (byte) 7);
                    return;
                }

                this.quagga.increaseTemper(5);
            }

            this.quagga.getControllingPassenger().dismountRidingEntity();
            this.quagga.makeHorseRearWithSound();
            this.quagga.worldObj.setEntityState(this.quagga, (byte) 6);
        }
    }
}
