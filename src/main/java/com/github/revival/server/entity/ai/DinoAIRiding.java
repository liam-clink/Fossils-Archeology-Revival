package com.github.revival.server.entity.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;

import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.server.item.FAItemRegistry;

public class DinoAIRiding extends EntityAIBase {
    private static final float PLAYER_SPEED = 0.98f;
    private final double speed;
    public int FollowTimeWithoutWhip = 120;
    private int lastTimeSeenWhip = -1;
    private EntityNewPrehistoric prehistoric;
    private EntityPlayer rider;
    
    public DinoAIRiding(EntityNewPrehistoric dinosaur, double speed) {
        super();
        this.prehistoric = dinosaur;
        this.speed = speed;
        setMutexBits(-1);

    }

    public static boolean hasEquipped(EntityPlayer player, Item item) {
        if (player == null) {
            return false;
        }

        ItemStack itemStack = player.getCurrentEquippedItem();

        return itemStack != null && itemStack.getItem() == item;

    }

    @Override
    public boolean shouldExecute() {
        rider = prehistoric.getRidingPlayer();
        if(rider == null){
        	return false;
        }
        if (hasEquipped(rider, FAItemRegistry.INSTANCE.whip)) {
            this.lastTimeSeenWhip = 0;
        }

        return this.lastTimeSeenWhip != -1 && this.prehistoric.riddenByEntity != null;

    }

    @Override
    public void startExecuting() {
        prehistoric.getNavigator().clearPathEntity();
        this.lastTimeSeenWhip = -1;
    }

    @Override
    public void resetTask() {
        this.lastTimeSeenWhip = -1;
    }

    @Override
    public void updateTask() {
        super.updateTask();
        if (rider != null) {
            float speedX = rider.moveForward / PLAYER_SPEED * (prehistoric.getRidingPlayer().isSprinting() ? 4 : 1);
            float speedZ = rider.moveStrafing / PLAYER_SPEED * (prehistoric.getRidingPlayer().isSprinting() ? 4 : 1);

            if (hasEquipped(rider, FAItemRegistry.INSTANCE.whip) || (this.lastTimeSeenWhip < FollowTimeWithoutWhip && this.lastTimeSeenWhip != -1)) {
                float speedPlayer = Math.max(Math.abs(speedX), Math.abs(speedZ));
                Vec3 look = rider.getLookVec();
                float dir = Math.min(speedX, 0) * -1;
                dir += speedZ / (speedX * 2 + (speedX < 0 ? -2 : 2));
                if (dir != 0) {
                    look.rotateAroundY((float) Math.PI * dir);
                }

                if (speedPlayer > 0) {
                    prehistoric.getMoveHelper().setMoveTo(prehistoric.posX + look.xCoord, prehistoric.posY, prehistoric.posZ + look.zCoord, speed);
                    if (!prehistoric.shouldDismountInWater(rider) && prehistoric.isInWater()) {
                        if (Math.abs(look.yCoord) > 0.4) {
                            prehistoric.motionY = Math.max(-0.15, Math.min(0.15, look.yCoord));
                        }
                    }
                }

                this.lastTimeSeenWhip++;
            }
        }
    }
}
