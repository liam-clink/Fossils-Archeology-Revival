package com.github.revival.server.entity.mob;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.github.revival.server.entity.mob.test.EntitySwimmingPrehistoric;
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

public class EntityLiopleurodon extends EntitySwimmingPrehistoric {

	public static final double baseDamage = 2;
	public static final double maxDamage = 12;
	public static final double baseHealth = 10;
	public static final double maxHealth = 45;
	public static final double baseSpeed = 0.3D;
	public static final double maxSpeed = 0.4D;

	public EntityLiopleurodon(World world) {
		super(world, EnumPrehistoric.Liopleurodon, 2, 12, 10, 45, 0.3, 0.4);
		this.hasBabyTexture = false;
		this.setSize(1.5F, 0.5F);
		minSize = 0.8F;
		maxSize = 1.8F;
		teenAge = 6;
		developsResistance = true;
		breaksBlocks = false;
		hasBabyTexture = false;
		pediaScale = 6;
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

		return Attacking.DROWN;
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

		return Response.AGRESSIVE;
	}

	@Override
	public Stalking aiStalkType() {

		return Stalking.NONE;
	}

	@Override
	public Taming aiTameType() {

		return Taming.BLUEGEM;
	}

	@Override
	public Untaming aiUntameType() {

		return Untaming.NONE;
	}

	@Override
	public Moving aiMovingType() {

		return Moving.AQUATIC;
	}

	@Override
	public WaterAbility aiWaterAbilityType() {

		return WaterAbility.ATTACK;
	}

	@Override
	public boolean doesFlock() {

		return false;
	}

	@Override
	public Item getOrderItem() {

		return Items.stick;
	}

	@Override
	public int getAdultAge() {
		return 13;
	}

	@Override
	protected double getSwimSpeed() {
		return 3;
	}

}