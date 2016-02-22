/*
 ** 2012 April 25
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package com.github.revival.common.entity.ai;

import com.github.revival.common.entity.mob.EntityPrehistoric;
import com.github.revival.common.item.FAItemRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;

/**
 * AI for player-controlled ground movements.
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class DinoAIRideGround extends DinoAIRide {
    private static final float PLAYER_SPEED = 0.98f;
    private final double speed;
    public int FollowTimeWithoutWhip = 120;
    private int lastTimeSeenWhip = -1;

    public DinoAIRideGround(EntityPrehistoric dinosaur, double speed) {
        super(dinosaur);
        this.speed = speed;
    }

    public static boolean hasEquipped(EntityPlayer player, Item item) {
        if (player == null)
            return false;

        ItemStack itemStack = player.getCurrentEquippedItem();

        if (itemStack == null) {
            return false;
        }

        return itemStack.getItem() == item;
    }


    public boolean shouldExecute() {
        super.shouldExecute();
        if (hasEquipped(rider, FAItemRegistry.whip))
            this.lastTimeSeenWhip = 0;

        return this.lastTimeSeenWhip != -1 && this.dinosaur.riddenByEntity != null;

    }

    @Override
    public void startExecuting() {
        dinosaur.getNavigator().clearPathEntity();
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
            float speedX = rider.moveForward / PLAYER_SPEED;
            float speedY = rider.moveStrafing / PLAYER_SPEED;

            if (hasEquipped(rider, FAItemRegistry.whip) || (this.lastTimeSeenWhip < FollowTimeWithoutWhip && this.lastTimeSeenWhip != -1)) {
                float speedPlayer = Math.max(Math.abs(speedX), Math.abs(speedY));
                Vec3 look = rider.getLookVec();
                float dir = Math.min(speedX, 0) * -1;
                dir += speedY / (speedX * 2 + (speedX < 0 ? -2 : 2));
                if (dir != 0) {
                    look.rotateAroundY((float) Math.PI * dir);
                }

                if (speedPlayer > 0) {
                    dinosaur.getMoveHelper().setMoveTo(dinosaur.posX + look.xCoord, dinosaur.posY, dinosaur.posZ + look.zCoord, speed * speedPlayer);

                    //This block checks if the dinosaur can be ridden in water, if so, handle Y velocity. Still looking for elegant way.
                    if (!dinosaur.shouldDismountInWater(rider) && dinosaur.isInWater()) {
                        if (Math.abs(look.yCoord) > 0.4) {
                            dinosaur.motionY = Math.max(-0.15, Math.min(0.15, look.yCoord));
                            //dinosaur.setVelocity(dinosaur.motionX, Math.max(-0.15, Math.min(0.15, look.yCoord)), dinosaur.motionZ);
                        }
                    }
                }

                this.lastTimeSeenWhip++;
            }
        }
    }
}
