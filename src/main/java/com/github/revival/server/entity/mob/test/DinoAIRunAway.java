package com.github.revival.server.entity.mob.test;

import com.github.revival.server.enums.EnumPrehistoricAI.Response;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.Vec3;

import java.util.List;

public class DinoAIRunAway extends EntityAIBase {
    private static final String __OBFID = "CL_00001574";
    /**
     * The entity we are attached to
     */
    private EntityCreature theEntity;
    public final IEntitySelector selector = new IEntitySelector() {
        private static final String __OBFID = "CL_00001575";

        /**
         * Return whether the specified entity is applicable to this filter.
         */
        @Override
        public boolean isEntityApplicable(Entity entity) {
            return entity.isEntityAlive() && DinoAIRunAway.this.theEntity.getEntitySenses().canSee(entity);
        }
    };
    private double farSpeed;
    private double nearSpeed;
    private Entity closestLivingEntity;
    private float distanceFromEntity;
    /**
     * The PathEntity of our entity
     */
    private PathEntity entityPathEntity;
    /**
     * The PathNavigate of our entity
     */
    private PathNavigate entityPathNavigate;
    /**
     * The class of the entity we should avoid
     */
    private Class targetEntityClass;

    public DinoAIRunAway(EntityCreature creature, Class target, float distance, double far, double near) {
        this.theEntity = creature;
        this.targetEntityClass = target;
        this.distanceFromEntity = distance;
        this.farSpeed = far;
        this.nearSpeed = near;
        this.entityPathNavigate = creature.getNavigator();
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute() {
        if (this.theEntity instanceof EntityNewPrehistoric) {
            EntityNewPrehistoric prehistoric = (EntityNewPrehistoric) theEntity;
            if (prehistoric.aiResponseType() != Response.SCARED) {
                return false;
            }
        }
        if (closestLivingEntity != null) {
            if (targetEntityClass == closestLivingEntity.getClass() && targetEntityClass != theEntity.getClass()) {
                if (closestLivingEntity.width * 1.5F < theEntity.width) {
                    return false;
                }
            }
        }
        if (this.targetEntityClass == EntityPlayer.class) {
            if (this.theEntity instanceof EntityTameable && ((EntityTameable) this.theEntity).isTamed()) {
                return false;
            }

            this.closestLivingEntity = this.theEntity.worldObj.getClosestPlayerToEntity(this.theEntity, (double) this.distanceFromEntity);

            if (this.closestLivingEntity == null) {
                return false;
            }

        } else {
            List list = this.theEntity.worldObj.selectEntitiesWithinAABB(this.targetEntityClass, this.theEntity.boundingBox.expand((double) this.distanceFromEntity, 3.0D, (double) this.distanceFromEntity), this.selector);

            if (list.isEmpty()) {
                return false;
            }

            this.closestLivingEntity = (Entity) list.get(0);
        }

        Vec3 vec3 = RandomPositionGenerator.findRandomTargetBlockAwayFrom(this.theEntity, 16, 7, Vec3.createVectorHelper(this.closestLivingEntity.posX, this.closestLivingEntity.posY, this.closestLivingEntity.posZ));

        if (vec3 == null) {
            return false;
        } else if (this.closestLivingEntity.getDistanceSq(vec3.xCoord, vec3.yCoord, vec3.zCoord) < this.closestLivingEntity.getDistanceSqToEntity(this.theEntity)) {
            return false;
        } else {
            this.entityPathEntity = this.entityPathNavigate.getPathToXYZ(vec3.xCoord, vec3.yCoord, vec3.zCoord);
            return this.entityPathEntity != null && this.entityPathEntity.isDestinationSame(vec3);
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    @Override
    public boolean continueExecuting() {
        return !this.entityPathNavigate.noPath();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting() {
        this.entityPathNavigate.setPath(this.entityPathEntity, this.farSpeed);
    }

    /**
     * Resets the task
     */
    @Override
    public void resetTask() {
        this.closestLivingEntity = null;
    }

    /**
     * Updates the task
     */
    @Override
    public void updateTask() {
        if (this.theEntity.getDistanceSqToEntity(this.closestLivingEntity) < 49.0D) {
            this.theEntity.getNavigator().setSpeed(this.nearSpeed);
        } else {
            this.theEntity.getNavigator().setSpeed(this.farSpeed);
        }
    }
}