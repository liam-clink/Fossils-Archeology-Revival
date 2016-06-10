package com.github.revival.server.entity.mob;

import com.github.revival.Revival;
import com.github.revival.server.entity.ai.DinoAILeapAtTarget;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.server.entity.mob.test.EntityToyBase;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityVelociraptor extends EntityNewPrehistoric {

	public EntityVelociraptor(World world) {
		super(world, EnumPrehistoric.Velociraptor, 1, 4, 4, 22, 0.25, 0.3);
		this.tasks.addTask(3, new DinoAILeapAtTarget(this));
		this.hasFeatherToggle = true;
		this.pediaScale = 45F;
		this.featherToggle = Revival.CONFIG.featheredVelociraptor;
		this.setSize(1.5F, 1.5F);
		minSize = 0.3F;
		maxSize = 0.8F;
		teenAge = 3;
		developsResistance = false;
		breaksBlocks = false;
		this.nearByMobsAllowed = 9;
	}

	@Override
	public int getAttackLength() {
		return 35;
	}

	@Override
	public void setSpawnValues() {
	}

	@Override
	public int getAdultAge() {
		return 6;
	}

	@Override
	public Activity aiActivityType() {

		return Activity.NOCTURNAL;
	}

	@Override
	public Attacking aiAttackType() {

		return Attacking.JUMP;
	}

	@Override
	public Climbing aiClimbType() {

		return Climbing.ARTHROPOD;
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

		return isChild() ? Response.SCARED : Response.TERITORIAL;
	}

	@Override
	public Stalking aiStalkType() {

		return Stalking.STEALTH;
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

		return Moving.WALK;
	}

	@Override
	public WaterAbility aiWaterAbilityType() {

		return WaterAbility.NONE;
	}

	@Override
	public boolean doesFlock() {
		return false;
	}

	@Override
	public Item getOrderItem() {

		return Items.bone;
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (this.getAttackTarget() != null && this.ridingEntity != null) {
			if (this.ridingEntity == this.getAttackTarget() && this.ticksExisted % 20 == 0) {
				IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.attackDamage);
				this.getAttackTarget().attackEntityFrom(DamageSource.causeMobDamage(this), (float) iattributeinstance.getAttributeValue());
			}
		}
		if (this.getAttackTarget() != null && this.getAnimation() == ATTACK_ANIMATION && (this.getAnimationTick() >= 17 && this.getAnimationTick() <= 20) && this.onGround) {
			double d0 = this.getAttackTarget().posX - this.posX;
			double d1 = this.getAttackTarget().posZ - this.posZ;
			float f = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
			this.motionX += d0 / (double) f * 0.7D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
			this.motionZ += d1 / (double) f * 0.7D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
			this.motionY = 0.4F;
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		return false;
	}

	@Override
	public void applyEntityCollision(Entity entity) {
		super.applyEntityCollision(entity);
		if (this.getAttackTarget() != null) {
			if (this.getAttackTarget() == entity && this.getAnimation() == ATTACK_ANIMATION && !onGround && this.ridingEntity != entity && (entity instanceof EntityToyBase)) {
				this.knockBackMob(entity, 0.1F, 0.1F, 0.1F);
				entity.attackEntityFrom(DamageSource.causeMobDamage(this), 1);
			} else if (this.getAttackTarget() == entity && this.getAnimation() == ATTACK_ANIMATION && !onGround && this.ridingEntity != entity) {
				this.mountEntity(entity);
			}
		}
	}

	@Override
	public int getTailSegments() {
		return 3;
	}
}
