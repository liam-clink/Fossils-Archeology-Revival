package com.github.revival.server.entity.mob.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.Vec3;

import com.github.revival.server.enums.EnumPrehistoric;

public class Flock {
	public float flockYaw;
	public List<EntityNewPrehistoric> flockMembers = new ArrayList<EntityNewPrehistoric>();
	public EntityNewPrehistoric flockLeader;
	public EnumPrehistoric type;
	private double flockPosX;
	private double flockPosY;
	private double flockPosZ;
	/**
	 * The PathEntity of our entity
	 */
	private PathEntity flockPathEntity;
	/**
	 * The PathNavigate of our entity
	 */
	private PathNavigate flockPathNavigate;

	public static int generateVarience(int max, int min) {
		return -min + (int) (Math.random() * ((max - (-min)) + 1));
	}

	public void createFlock(EntityNewPrehistoric creator) {
		flockMembers.add(creator);
		flockLeader = creator;
		flockPosX = creator.posX;
		flockPosY = creator.posY;
		flockPosZ = creator.posZ;


	}

	public void onUpdate() {
		if (flockLeader == null || flockLeader.isDead) {
			setNewLeader();
		}
		if (flockLeader != null) {
			flockYaw = flockLeader.rotationYaw;
		}
		for (int i = 0; i < flockMembers.size(); i++) {
			EntityNewPrehistoric member = ((EntityNewPrehistoric) flockMembers.toArray()[i]);
			if (member != null && flockLeader != null && this.flockPathNavigate != null && this.flockPathNavigate.getPath() != null) {
				if(member.getNavigator().noPath()){
					member.getNavigator().setPath(this.flockLeader.getNavigator().getPath(), 1);
				}else{
					member.canWander = false;
				}
			}
		}


		if (flockPathNavigate == null) {
			flockPathNavigate = flockLeader.getNavigator();
		}
		if (closestEntity() != null) {
			if (closestEntity().getClass() == flockLeader.getClass()) {
				if (flockLeader.getRNG().nextInt(20) == 0) {
					Vec3 vec3 = RandomPositionGenerator.findRandomTargetBlockAwayFrom(closestEntity(), 32, 7, Vec3.createVectorHelper(closestEntity().posX, closestEntity().posY, closestEntity().posZ));
					this.flockPathEntity = this.flockPathNavigate.getPathToXYZ(vec3.xCoord, vec3.yCoord, vec3.zCoord);
					this.flockPathNavigate.setPath(this.flockPathEntity, 0.7);
				}
			}
		}
	}

	public EntityNewPrehistoric closestEntity() {
		IEntitySelector selector = IEntitySelector.selectAnything;
		List<Entity> entities = flockLeader.worldObj.getEntitiesWithinAABBExcludingEntity(flockLeader, flockLeader.boundingBox.expand((double) 12, 3.0D, (double) 12), selector);
		for (Entity mob : entities) {
			if (mob instanceof EntityNewPrehistoric) {
				return (EntityNewPrehistoric) mob;
			}
		}
		return null;
	}

	public void setNewLeader() {
		int index = new Random().nextInt(flockMembers.size());
		flockLeader = flockMembers.get(index);
	}

	public void disband() {
		flockMembers.clear();

	}
}
