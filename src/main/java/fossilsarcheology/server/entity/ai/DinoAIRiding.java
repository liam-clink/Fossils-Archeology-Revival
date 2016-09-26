package fossilsarcheology.server.entity.ai;

import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.EntityPrehistoricSwimming;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;

public class DinoAIRiding extends EntityAIBase {
    private static final float PLAYER_SPEED = 0.98f;
    private final double speed;
    public int FollowTimeWithoutWhip = 120;
    private int lastTimeSeenWhip = -1;
    private EntityPrehistoric prehistoric;
    private EntityPlayer rider;

    public DinoAIRiding(EntityPrehistoric dinosaur, double speed) {
        super();
        this.prehistoric = dinosaur;
        this.speed = speed;
        this.setMutexBits(-1);
    }

    public static boolean hasEquipped(EntityPlayer player, Item item) {
        if (player == null) {
            return false;
        }
        ItemStack stack = player.getHeldItem(EnumHand.MAIN_HAND);
        return stack != null && stack.getItem() == item;
    }

    @Override
    public boolean shouldExecute() {
        if (this.prehistoric.riddenByEntity != null && this.prehistoric.riddenByEntity instanceof EntityPlayer) {
            this.rider = this.prehistoric.getRidingPlayer();
            if (this.rider == null) {
                return false;
            }
            if (hasEquipped(this.rider, FAItemRegistry.INSTANCE.whip)) {
                this.lastTimeSeenWhip = 0;
            }
            return this.lastTimeSeenWhip != -1 && this.prehistoric.riddenByEntity != null && this.prehistoric.getRidingPlayer() != null;
        }
        return false;
    }

    @Override
    public void startExecuting() {
        if (this.prehistoric.riddenByEntity != null && this.prehistoric.riddenByEntity instanceof EntityPlayer) {
            this.prehistoric.getNavigator().clearPathEntity();
            this.lastTimeSeenWhip = -1;
        }
    }

    @Override
    public void resetTask() {
        if (this.prehistoric.riddenByEntity != null && this.prehistoric.riddenByEntity instanceof EntityPlayer) {
            this.lastTimeSeenWhip = -1;
        }
    }

    @Override
    public void updateTask() {
        super.updateTask();
        if (this.prehistoric.riddenByEntity != null && this.prehistoric.riddenByEntity instanceof EntityPlayer) {
            if (this.rider != null) {
                float speedX = this.rider.moveForward / PLAYER_SPEED * (this.prehistoric.getRidingPlayer().isSprinting() ? 4 : 1);
                float speedZ = this.rider.moveStrafing / PLAYER_SPEED * (this.prehistoric.getRidingPlayer().isSprinting() ? 4 : 1);

                if (hasEquipped(this.rider, FAItemRegistry.INSTANCE.whip) || (this.lastTimeSeenWhip < this.FollowTimeWithoutWhip && this.lastTimeSeenWhip != -1)) {
                    float speedPlayer = Math.max(Math.abs(speedX), Math.abs(speedZ));
                    Vec3d look = this.rider.getLookVec();
                    float dir = Math.min(speedX, 0) * -1;
                    dir += speedZ / (speedX * 2 + (speedX < 0 ? -2 : 2));
                    if (dir != 0) {
                        look.rotateAroundY((float) Math.PI * dir);
                    }

                    if (speedPlayer > 0) {
                        if (!this.prehistoric.shouldDismountInWater(this.rider) && this.prehistoric.isInWater()) {
                            if (Math.abs(look.yCoord) > 0.4 && this.prehistoric instanceof EntityPrehistoricSwimming) {
                                this.prehistoric.motionY = Math.max(-0.15, Math.min(0.15, look.yCoord));
                            } else {
                                this.prehistoric.motionY = 0.4D;
                            }
                            this.prehistoric.motionX = (double) (-MathHelper.sin(this.rider.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(this.rider.rotationPitch / 180.0F * (float) Math.PI));
                            this.prehistoric.motionZ = (double) (MathHelper.cos(this.rider.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(this.rider.rotationPitch / 180.0F * (float) Math.PI));
                        } else {
                            this.prehistoric.getMoveHelper().setMoveTo(this.prehistoric.posX + look.xCoord, this.prehistoric.posY, this.prehistoric.posZ + look.zCoord, this.speed);
                        }
                    }

                    this.lastTimeSeenWhip++;
                }
            }
        }
    }
}
