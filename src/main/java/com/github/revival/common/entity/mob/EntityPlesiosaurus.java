package com.github.revival.common.entity.mob;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.common.enums.EnumPrehistoric;
import com.github.revival.common.enums.EnumPrehistoricAI.Activity;
import com.github.revival.common.enums.EnumPrehistoricAI.Attacking;
import com.github.revival.common.enums.EnumPrehistoricAI.Climbing;
import com.github.revival.common.enums.EnumPrehistoricAI.Following;
import com.github.revival.common.enums.EnumPrehistoricAI.Jumping;
import com.github.revival.common.enums.EnumPrehistoricAI.Moving;
import com.github.revival.common.enums.EnumPrehistoricAI.Response;
import com.github.revival.common.enums.EnumPrehistoricAI.Stalking;
import com.github.revival.common.enums.EnumPrehistoricAI.Taming;
import com.github.revival.common.enums.EnumPrehistoricAI.Untaming;
import com.github.revival.common.enums.EnumPrehistoricAI.WaterAbility;
import com.github.revival.common.item.FAItemRegistry;

public class EntityPlesiosaurus extends EntityNewPrehistoric
{

	public static final double baseDamage = 2;
	public static final double maxDamage = 12;
	public static final double baseHealth = 10;
	public static final double maxHealth = 30;
	public static final double baseSpeed = 0.2D;
	public static final double maxSpeed = 0.3D;
	
	public EntityPlesiosaurus(World world) {
		super(world, EnumPrehistoric.Plesiosaur);
		this.setSize(1.0F, 1.0F);
		minSize = 1F;
		maxSize = 6F;
		teenAge = 3;
		adultAge = 7;
		developsResistance = true;
		breaksBlocks = true;
		favoriteFood = Items.fish;

	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(baseSpeed);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(baseHealth);
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(baseDamage);
	}
	
	@Override
	public void setSpawnValues() {}



	@Override
	public Activity aiActivityType() {

		return Activity.BOTH;
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

		return Following.NORMAL;
	}

	@Override
	public Jumping aiJumpType() {

		return Jumping.BASIC;
	}

	@Override
	public Response aiResponseType() {

		return Response.WATERCALM;
	}

	@Override
	public Stalking aiStalkType() {

		return Stalking.NONE;
	}

	@Override
	public Taming aiTameType() {

		return Taming.IMPRINTING;
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

		return WaterAbility.IGNOREANDFISH;
	}

	@Override
	public boolean doesFlock() {

		return false;
	}

	@Override
	public Item getOrderItem() {

		return FAItemRegistry.emptyShell;
	}
	public void updateSize()
	{
		double healthStep;
		double attackStep;
		double speedStep;
		healthStep = (this.maxHealth - this.baseHealth) / (this.adultAge + 1);
		attackStep = (this.maxDamage - this.baseDamage) / (this.adultAge + 1);
		speedStep = (this.maxSpeed - this.baseSpeed) / (this.adultAge + 1);


		if (this.getDinoAge() <= this.adultAge)
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(Math.round(this.baseHealth + (healthStep * this.getDinoAge())));
			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(Math.round(this.baseDamage + (attackStep * this.getDinoAge())));
			this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.baseSpeed + (speedStep * this.getDinoAge()));

			if (this.isTeen())
			{
				this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.5D);
			}
			else if (this.isAdult())
			{
				this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(2.0D);
			}
			else
			{
				if(this.developsResistance)
					this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);
			}
		}
	}
}