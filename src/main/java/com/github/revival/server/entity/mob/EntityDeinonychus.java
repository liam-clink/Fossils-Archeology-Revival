package com.github.revival.server.entity.mob;

import java.lang.reflect.Field;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.github.revival.Revival;
import com.github.revival.server.entity.ai.DinoAILeapAtTarget;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.server.entity.mob.test.EntityToyBase;
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

import cpw.mods.fml.relauncher.ReflectionHelper;

public class EntityDeinonychus extends EntityNewPrehistoric {

	public EntityDeinonychus(World world) {
		super(world, EnumPrehistoric.Deinonychus, 2, 6, 10, 32, 0.23, 0.35);
		this.nearByMobsAllowed = 9;
		this.pediaScale = 24F;
		this.tasks.addTask(3, new DinoAILeapAtTarget(this));
		this.hasFeatherToggle = true;
		this.featherToggle = Revival.CONFIG.featheredDeinonychus;
		this.setSize(1.8F, 1.25F);
		minSize = 0.3F;
		maxSize = 1;
		teenAge = 4;
		developsResistance = false;
		breaksBlocks = false;
	}

	@Override
	public int getAttackLength() {
		return 35;
	}

	@Override
	public void setSpawnValues() {
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

		return Jumping.TWOBLOCKS;
	}

	@Override
	public Response aiResponseType() {

		return Response.TERITORIAL;
	}

	@Override
	public Stalking aiStalkType() {

		return Stalking.STEALTH;
	}

	@Override
	public Taming aiTameType() {

		return Taming.IMPRINTING;
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
	public int getAdultAge() {
		return 10;
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
			this.motionX += d0 / (double) f * 1.4D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
			this.motionZ += d1 / (double) f * 1.4D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
			this.getLookHelper().setLookPositionWithEntity(this.getAttackTarget(), 10, 12);
			this.motionY = (double) 0.6;
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
				entity.attackEntityFrom(DamageSource.causeMobDamage(this), 1);
			} else if (this.getAttackTarget() == entity && this.getAnimation() == ATTACK_ANIMATION && !onGround && this.ridingEntity != entity) {
				this.mountEntity(entity);
			}
		}
	}

	@Override
	public boolean canAttackClass(Class clazz) {
		return (clazz != EntityVelociraptor.class) && super.canAttackClass(clazz);
	}

	@Override
	public boolean attackEntityFrom(DamageSource dmg, float i) {
		if (this.ridingEntity != null) {
			if (this.getLastAttacker() != null) {
				if (this.getLastAttacker() == this.ridingEntity) {
					if (this.getRNG().nextInt(2) == 0) {
						this.mountEntity(null);
					}
				}
			}
		}
		return super.attackEntityFrom(dmg, i);
	}
}
