package com.github.revival.server.entity.mob.test;

import net.minecraft.item.Item;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.Activity;
import com.github.revival.server.enums.EnumPrehistoricAI.Attacking;
import com.github.revival.server.enums.EnumPrehistoricAI.Climbing;
import com.github.revival.server.enums.EnumPrehistoricAI.Following;
import com.github.revival.server.enums.EnumPrehistoricAI.Jumping;
import com.github.revival.server.enums.EnumPrehistoricAI.Moving;
import com.github.revival.server.enums.EnumPrehistoricAI.Response;
import com.github.revival.server.enums.EnumPrehistoricAI.Stalking;
import com.github.revival.server.enums.EnumPrehistoricAI.Taming;
import com.github.revival.server.enums.EnumPrehistoricAI.Untaming;
import com.github.revival.server.enums.EnumPrehistoricAI.WaterAbility;

public abstract class EntityFlyingPrehistoric extends EntityNewPrehistoric{

	public ChunkCoordinates currentTarget;

	public EntityFlyingPrehistoric(World world, EnumPrehistoric selfType) {
		super(world, selfType);
		this.tasks.addTask(11, new DinoAIFindAirTarget(this));
	}

	public boolean isDirectPathBetweenPoints(ChunkCoordinates vec1, ChunkCoordinates vec2)
	{
		return vec1.getDistanceSquaredToChunkCoordinates(vec2) > 16;
	}
}