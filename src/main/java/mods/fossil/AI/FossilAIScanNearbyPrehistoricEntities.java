package mods.fossil.AI;

import java.util.ArrayList;

import mods.fossil.entity.mobs.EntityPrehistoric;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;

public class FossilAIScanNearbyPrehistoricEntities extends EntityAIBase {
	
	private EntityPrehistoric entity;
	
	public FossilAIScanNearbyPrehistoricEntities(EntityPrehistoric entity) {
		this.entity = entity;
	}
	
	@Override
	public boolean shouldExecute() {
		return true;
	}
	
	@Override
	public void updateTask() {
		ArrayList<EntityPrehistoric> possibleFleeEntities = new ArrayList<EntityPrehistoric>();
		for(Object tempEntity: entity.worldObj.loadedEntityList) {
			if(tempEntity instanceof EntityPrehistoric && entity.getType().shouldRunFromEntity((EntityPrehistoric)tempEntity)) {
				if(entity.distanceStatus((Entity)tempEntity) > 0 && entity.canFindEntity((Entity)tempEntity)) {
					possibleFleeEntities.add((EntityPrehistoric)tempEntity);
				}
			}
		}
	}
}
