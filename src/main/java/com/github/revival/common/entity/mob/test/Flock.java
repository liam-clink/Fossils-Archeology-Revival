package com.github.revival.common.entity.mob.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

import com.github.revival.common.entity.mob.EntityPrehistoric;
import com.github.revival.common.enums.EnumPrehistoric;

public class Flock {
	private double flockPosX;
	private double flockPosY;
	private double flockPosZ;
	public float flockYaw;
	public List<EntityPrehistoric> flockMembers = new ArrayList<EntityPrehistoric>();
	public EntityPrehistoric flockLeader;
	public EnumPrehistoric type;
	/** The PathEntity of our entity */
	private PathEntity flockPathEntity;
	/** The PathNavigate of our entity */
	private PathNavigate flockPathNavigate;

	public void createFlock(EntityPrehistoric creator){
		flockMembers.add(creator);
		flockLeader = creator;
		flockPosX = creator.posX;
		flockPosY = creator.posY;
		flockPosZ = creator.posZ;


	}
	public void onUpdate(){
		if(flockLeader == null || flockLeader.isDead){
			setNewLeader();
		}			
		if(flockLeader != null){
			flockYaw = flockLeader.rotationYaw;
		}
		for (int i = 0; i < flockMembers.size(); i++)
		{
			EntityPrehistoric member = ((EntityPrehistoric)flockMembers.toArray()[i]);
			if(member != null){
				if(flockLeader != null){
					//member.getNavigator().tryMoveToEntityLiving(flockLeader, 0.7);
					float f2 = MathHelper.sin(this.flockYaw * (float)Math.PI / 180.0F);
					float f3 = MathHelper.cos(this.flockYaw * (float)Math.PI / 180.0F);
					member.motionX = (double)(-1 * 0.1 * f2);
					member.motionZ = (double)( 0.1 * f3);
					member.rotationYaw = flockYaw;
					
					if(flockMembers.contains(member)){
						if(member.isDead){
							flockMembers.remove(member);
						}
					}
				}
			}

		}


		if(flockPathNavigate == null){
			flockPathNavigate = flockLeader.getNavigator();
		}
		if(closestEntity() != null){
			if(closestEntity().getClass() == flockLeader.getClass()){
				if(flockLeader.getRNG().nextInt(20) == 0){
					Vec3 vec3 = RandomPositionGenerator.findRandomTargetBlockAwayFrom(closestEntity(), 16, 7, Vec3.createVectorHelper(closestEntity().posX, closestEntity().posY, closestEntity().posZ));
					this.flockPathEntity = this.flockPathNavigate.getPathToXYZ(vec3.xCoord, vec3.yCoord, vec3.zCoord);
					this.flockPathNavigate.setPath(this.flockPathEntity, 0.7);
				}
			}
		}
	}


	public EntityPrehistoric closestEntity(){
		IEntitySelector selector =IEntitySelector.selectAnything;
		List<Entity> entities = flockLeader.worldObj.getEntitiesWithinAABBExcludingEntity(flockLeader, flockLeader.boundingBox.expand((double)12, 3.0D, (double)12), selector);
		for(Entity mob: entities){
			if(mob instanceof EntityPrehistoric){
				return (EntityPrehistoric) mob;
			}
		}
		return null;
	}

	public void setNewLeader(){
		int index = new Random().nextInt(flockMembers.size());		
		flockLeader = flockMembers.get(index);
	}
	public static int generateVarience(int max, int min) {
		int ii = -min + (int) (Math.random() * ((max - (-min)) + 1));
		return ii;
	}
	private float entityDistance(Entity e1, Entity e2)
	{
		return (float) Math.sqrt(Math.pow(e1.posX - e2.posX, 2) + Math.pow(e1.posY - e2.posY, 2));
	}
	public void disband(){
		flockMembers.clear();

	}
}
