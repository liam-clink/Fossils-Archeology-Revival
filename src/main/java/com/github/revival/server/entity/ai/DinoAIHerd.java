package com.github.revival.server.entity.ai;

import com.github.revival.server.entity.mob.EntityDinosaur;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.world.World;

import java.util.Random;

public class DinoAIHerd extends EntityAIBase {
    // The assigned Dinosaur
    private EntityDinosaur dinosaur;
    // The speed
    private double speed;
    private Random rand = new Random();
    private PathNavigate pathNavigator;
    private World world;
    private DinoHerd herd;

    public DinoAIHerd(EntityDinosaur dinosaur, double speed) {
        this.dinosaur = dinosaur;
        //this.herd = dinosaur.getHerd();
        this.speed = speed;
        this.pathNavigator = dinosaur.getNavigator();
        this.world = dinosaur.worldObj;
    }

    @Override
    public boolean shouldExecute() {
        if (dinosaur.isInHerd()) {
            return true;
        }
        return false;
    }

    @Override
    public void startExecuting() {

    }

    @Override
    public void updateTask() {

    }

    public void idleAroundLeader() {

    }

    public void idleAsLeader() {

    }

    public void wanderWithLeader() {

    }

    public void wanderAsLeader() {

    }

    public void attack() {

    }

    public void chaseWithLeader() {

    }

    public void chaseAsLeader() {

    }

    public void disperse() {

    }

}
