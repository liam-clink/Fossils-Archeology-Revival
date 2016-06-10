package com.github.revival.server.entity.mob.test;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.Vec3;

import java.util.ArrayList;
import java.util.List;

public class DinoAIRunAway extends EntityAIBase {

    private EntityNewPrehistoric dinosaur;
    public IEntitySelector selector;
    private Entity closestLivingEntity;
    private float distanceFromEntity;
    private PathEntity entityPathEntity;
    private PathNavigate entityPathNavigate;
    private Class targetEntityClass;

    public DinoAIRunAway(EntityNewPrehistoric creature, Class target, float distance, double far, double near) {
        this.dinosaur = creature;
        this.targetEntityClass = target;
        this.distanceFromEntity = distance;
        this.entityPathNavigate = creature.getNavigator();
        selector = new IEntitySelector() {
            @Override
            public boolean isEntityApplicable(Entity entity) {
                return entity.isEntityAlive() && DinoAIRunAway.this.dinosaur.getEntitySenses().canSee(entity);
            }
        };
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {

        List list = this.dinosaur.worldObj.selectEntitiesWithinAABB(this.targetEntityClass, this.dinosaur.boundingBox.expand((double) this.distanceFromEntity, 3.0D, (double) this.distanceFromEntity), this.selector);
        List<EntityLivingBase> secondList = new ArrayList<EntityLivingBase>();
        if (list.isEmpty()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            EntityLivingBase mob = (EntityLivingBase) list.get(i);
            if (this.dinosaur.canRunFrom(mob)) {
                secondList.add(mob);
            }
        }
        if (secondList.isEmpty()) {
            return false;
        }
        this.closestLivingEntity = secondList.get(0);

        Vec3 vec3 = RandomPositionGenerator.findRandomTargetBlockAwayFrom(this.dinosaur, 16, 7, Vec3.createVectorHelper(this.closestLivingEntity.posX, this.closestLivingEntity.posY, this.closestLivingEntity.posZ));
        if (vec3 == null) {
            return false;
        } else {
            this.entityPathEntity = this.entityPathNavigate.getPathToXYZ(vec3.xCoord, vec3.yCoord, vec3.zCoord);
            return this.entityPathEntity != null;
        }
    }

    @Override
    public boolean continueExecuting() {
        return !this.entityPathNavigate.noPath();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting() {
        this.entityPathNavigate.setPath(this.entityPathEntity, 1);
    }

    @Override
    public void resetTask() {
        this.closestLivingEntity = null;
    }

    @Override
    public void updateTask() {
        if (this.dinosaur.getDistanceSqToEntity(this.closestLivingEntity) < 49.0D) {
            this.dinosaur.getNavigator().setSpeed(1);
        } else {
            this.dinosaur.getNavigator().setSpeed(1);
        }
    }
}