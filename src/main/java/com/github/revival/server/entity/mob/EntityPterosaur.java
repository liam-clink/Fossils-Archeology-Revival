package com.github.revival.server.entity.mob;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.github.revival.server.entity.mob.test.EntityFlyingPrehistoric;
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

public class EntityPterosaur extends EntityFlyingPrehistoric {

	public EntityPterosaur(World world) {
		super(world, EnumPrehistoric.Pterosaur, 1, 2, 6, 30, 0.15, 0.2);
		this.setSize(1.1F, 1.1F);
		minSize = 0.3F;
		maxSize = 1.2F;
		teenAge = 4;
		pediaScale = 25;
	}

	@Override
	public int getAdultAge() {
		return 9;
	}

	@Override
	public void setSpawnValues() {

	}

	@Override
	public Activity aiActivityType() {

		return Activity.DIURINAL;
	}

	@Override
	public Attacking aiAttackType() {

		return Attacking.DROP;
	}

	@Override
	public Climbing aiClimbType() {

		return Climbing.NONE;
	}

	@Override
	public Following aiFollowType() {

		return Following.AGRESSIVE;
	}

	@Override
	public Jumping aiJumpType() {

		return Jumping.BASIC;
	}

	@Override
	public Response aiResponseType() {

		return Response.SCARED;
	}

	@Override
	public Stalking aiStalkType() {

		return Stalking.NONE;
	}

	@Override
	public Taming aiTameType() {

		return Taming.FEEDING;
	}

	@Override
	public Untaming aiUntameType() {

		return Untaming.ATTACK;
	}

	@Override
	public Moving aiMovingType() {

		return Moving.FLIGHT;
	}

	@Override
	public WaterAbility aiWaterAbilityType() {

		return WaterAbility.IGNOREANDFISH;
	}

	@Override
	public boolean doesFlock() {

		return false;
	}

	@Override
	public Item getOrderItem() {
		return Items.arrow;
	}

	@Override
	protected double getFlySpeed() {
		return 1;
	}

	public float getMaleSize() {
		return 1.3F;
	}
}