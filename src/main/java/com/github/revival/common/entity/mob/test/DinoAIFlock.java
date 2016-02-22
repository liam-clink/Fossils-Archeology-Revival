package com.github.revival.common.entity.mob.test;

import com.github.revival.common.entity.mob.EntityDinosaur;
import com.github.revival.common.entity.mob.EntityPrehistoric;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.Vec3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DinoAIFlock extends EntityAIBase {

    public EntityDinosaur entity;
    public float memberRange;
    private List<Entity> entities;
    public List<EntityDinosaur> flock = new ArrayList<EntityDinosaur>();
    public EntityDinosaur leader = null;
    private PathNavigate entityPathNavigate;
    private PathEntity entityPathEntity;

    public DinoAIFlock(EntityDinosaur entity, float memberRange) {
        this.entity = entity;
        this.memberRange = memberRange;
        this.entityPathNavigate = entity.getNavigator();

    }

    @Override
    public boolean shouldExecute() {
        IEntitySelector selector = IEntitySelector.selectAnything;
        entities = entity.worldObj.getEntitiesWithinAABBExcludingEntity(entity, entity.boundingBox.expand((double) memberRange, 3.0D, (double) memberRange), selector);

        for (Entity mob : entities) {
            if (mob instanceof EntityDinosaur) {
                EntityDinosaur member = (EntityDinosaur) mob;
                flock.add(member);
                System.out.println("A Newb Dino joined the Flock!!!");

                if (member.isDead) {
                    System.out.println("Oh No!!! A dino Died and left the flock :(");
                    flock.remove(member);
                }
                if (leader == null || leader.isDead) {
                    System.out.println("The Flock found a new Leader!!!");
                    leader = findLeader(flock);
                }
                return true;
            }
        }
        return false;
    }

    public EntityDinosaur findLeader(List<EntityDinosaur> flock) {
        int index = new Random().nextInt(flock.size());
        return flock.get(index);
    }

    public boolean continueExecuting() {
        return !flock.isEmpty();
    }

    public void updateTask() {
        if (leader.getRNG().nextInt(140) == 0) {
            System.out.println("The flock has a new path!!!");

            Vec3 vec3 = RandomPositionGenerator.findRandomTargetBlockAwayFrom(leader, 32, 7, Vec3.createVectorHelper(leader.posX, leader.posY, leader.posZ));
            entityPathEntity = this.entityPathNavigate.getPathToXYZ(vec3.xCoord + leader.getRNG().nextInt(6), vec3.yCoord, vec3.zCoord + leader.getRNG().nextInt(6));
            System.out.println("Moving to the path!!!");
            for (int i = 0; i < flock.size(); i++) {
                ((EntityPrehistoric) flock.toArray()[i]).getNavigator().setPath(this.entityPathEntity, 3);
            }
        }


    }
}
