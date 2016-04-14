package com.github.revival.server.entity.mob;

import com.github.revival.Revival;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityTriceratops extends EntityNewPrehistoric {
	public static final double baseDamage = 1;
	public static final double maxDamage = 9;
	public static final double baseHealth = 12;
	public static final double maxHealth = 64;
	public static final double baseSpeed = 0.2D;
	public static final double maxSpeed = 0.35D;

	public EntityTriceratops(World world) {
		super(world, EnumPrehistoric.Triceratops);
		this.hasFeatherToggle = true;
		this.featherToggle = !Revival.CONFIG.quilledTriceratops;
		this.setSize(0.8F, 0.6F);
		this.nearByMobsAllowed = 7;
		minSize = 1F;
		maxSize = 8F;
		teenAge = 5;
		developsResistance = true;
		breaksBlocks = true;
		favoriteFood = Item.getItemFromBlock(Blocks.leaves);
	}

	@Override
	public int getAttackLength() {
		return 30;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		//Revival.proxy.doChainBuffer(tailBuffer, this);
	}

	@Override
	public void setSpawnValues() {
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(baseSpeed);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(baseHealth);
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(baseDamage);
	}


	@Override
	public Activity aiActivityType() {

		return Activity.DIURINAL;
	}

	@Override
	public Attacking aiAttackType() {

		return Attacking.KNOCKUP;
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

		return this.isChild() ? Response.SCARED : Response.TERITORIAL;
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

		return Untaming.STARVE;
	}

	@Override
	public Moving aiMovingType() {

		return Moving.WALK;
	}

	@Override
	public WaterAbility aiWaterAbilityType() {

		return WaterAbility.NONE;
	}

	@Override
	public boolean doesFlock() {
		return true;
	}

	@Override
	public Item getOrderItem() {
		return Items.stick;
	}

	@Override
	public void updateSize() {
		double healthStep;
		double attackStep;
		double speedStep;
		healthStep = (maxHealth - baseHealth) / (this.getAdultAge() + 1);
		attackStep = (maxDamage - baseDamage) / (this.getAdultAge() + 1);
		speedStep = (maxSpeed - baseSpeed) / (this.getAdultAge() + 1);


		if (this.getDinoAge() <= this.getAdultAge()) {

			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(Math.round(baseHealth + (healthStep * this.getDinoAge())));
			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(Math.round(baseDamage + (attackStep * this.getDinoAge())));
			this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(baseSpeed + (speedStep * this.getDinoAge()));

			if (this.isTeen()) {
				this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.5D);
			} else if (this.isAdult()) {
				this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(2.0D);
			} else {
				this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);
			}
		}
	}

	@Override
	public int getAdultAge() {
		return 12;
	}

	@Override
	public int getTailSegments() {
		return 3;
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() == 12 && this.getAttackTarget() != null) {
			this.attackEntityAsMob(this.getAttackTarget());
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		if (this.getAttackBounds().intersectsWith(entity.boundingBox)) {
			if (this.getAnimation() == NO_ANIMATION) {
				this.setAnimation(ATTACK_ANIMATION);
				return false;
			}

			if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() == 12) {
				IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.attackDamage);
				boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) iattributeinstance.getAttributeValue());
				if (entity.ridingEntity != null) {
					if (entity.ridingEntity == this) {
						entity.mountEntity(null);
					}
				}
				//entity.motionY += 0.4000000059604645D;
				return flag;
			}
		}
		return false;
	}
}
