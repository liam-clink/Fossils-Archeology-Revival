package com.github.revival.server.entity.ai;

import com.github.revival.server.entity.mob.EntityDinosaur;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

import java.util.Random;

public class DinoAIFlying extends EntityAIBase {

    public static eFlyingState currentState = eFlyingState.FS_ON_GROUND;

    private static Vec3 motionVector = Vec3.createVectorHelper(0.0D, 0.0D, 0.0D);
    protected eFlyingState previousState = eFlyingState.FS_ON_GROUND;
    protected boolean isAscending = false;
    private EntityDinosaur dino = null;
    private double takeOffInitialHeight = 0;
    private double takeOffDestinationHeight = 0;
    private Vec3 wanderDestination = null;
    private float MOTION_VECTOR_SCALE = 100.0f;
    private float SPEED_IN_AIR = 0.1f;

    public DinoAIFlying(EntityDinosaur Dinosaur) {
        dino = Dinosaur;
        this.setMutexBits(5);
    }

    @Override
    public boolean shouldExecute() {
        if (dino.IsHungry()) {
            return false;
        }
        if (!dino.isAdult()) {
            return false;
        }
        return !dino.getOrderType().equals(dino.OrderStatus.STAY);
    }

    @Override
    public void startExecuting() {
        duringFlight();
    }

    @Override
    public boolean continueExecuting() {
        if (dino.IsHungry()) {
            landFlight();
            return false;
        }
        return true;
    }

    @Override
    public void updateTask() {
        switch (currentState) {
            case FS_ASCENDING:
                ascendFlight();
                break;

            case FS_DESCENDING:
                descendFlight();
                break;

            case FS_IN_AIR:
                duringFlight();
                break;

            case FS_ON_GROUND:
                onGround();
                break;

            default:
                break;
        }
    }

    public void duringFlight() {
        positionChecker();
    }

    public void descendFlight() {

    }

    public void ascendFlight() {

    }

    public void landFlight() {

    }

    public void onGround() {

    }

    public void positionChecker() {
        Random rand = new Random();

        motionVector.xCoord = dino.motionX * MOTION_VECTOR_SCALE;
        motionVector.yCoord = dino.motionY * MOTION_VECTOR_SCALE;
        motionVector.zCoord = dino.motionZ * MOTION_VECTOR_SCALE;

        wanderDestination = RandomPositionGenerator
                .findRandomTargetBlockTowards(this.dino, 5, 10,
                        motionVector);
        if (wanderDestination == null) {
            return;
        }

        if (dino.worldObj.getHeightValue((int) wanderDestination.xCoord,
                (int) wanderDestination.zCoord) + 1 > wanderDestination.yCoord) {
            wanderDestination.yCoord = +3;
        }
    }

    public enum eFlyingState {
        FS_ON_GROUND, FS_IN_AIR, FS_ASCENDING, FS_DESCENDING
    }
}