package com.github.revival.server.entity.mob;

import com.github.revival.Revival;
import com.github.revival.server.entity.ai.DinoAILeapAtTarget;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
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

public class EntityCompsognathus extends EntityNewPrehistoric {
	
	public EntityCompsognathus(World world) {
		super(world, EnumPrehistoric.Compsognathus, 1, 1, 4, 12, 0.25, 0.4);
		this.setSize(1.1F, 1.1F);
		this.pediaScale = 100F;
		this.nearByMobsAllowed = 20;
		this.tasks.addTask(3, new DinoAILeapAtTarget(this));
		this.hasFeatherToggle = true;
		this.featherToggle = Revival.CONFIG.featheredCompsognathus;
		minSize = 0.25F;
		maxSize = 0.65F;
		teenAge = 1;
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

		return Attacking.BASIC;
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

		return Jumping.TWOBLOCKS;
	}

	@Override
	public Response aiResponseType() {

		return Response.SCARED;
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
	public int getAdultAge() {
		return 3;
	}

	@Override
	public String getOverlayTexture() {
		return "fossil:textures/blank.png";
	}

	@Override
	public int getTailSegments() {
		return 2;
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (this.getAttackTarget() != null && this.getAnimation() == ATTACK_ANIMATION && (this.getAnimationTick() <= 20 && this.getAnimationTick() >= 17) && this.onGround) {
			double d0 = this.getAttackTarget().posX - this.posX;
			double d1 = this.getAttackTarget().posZ - this.posZ;
			float f = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
			this.motionX += d0 / (double) f * 0.4D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
			this.motionZ += d1 / (double) f * 0.4D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
			this.getLookHelper().setLookPositionWithEntity(this.getAttackTarget(), 10, 12);
			this.motionY = (double) 0.3;
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
			if (this.getAttackTarget() == entity && this.getAnimation() == ATTACK_ANIMATION && !onGround && this.ridingEntity != entity) {
				IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.attackDamage);
				this.getAttackTarget().attackEntityFrom(DamageSource.causeMobDamage(this), (float) iattributeinstance.getAttributeValue());
			}
		}
	}
}
