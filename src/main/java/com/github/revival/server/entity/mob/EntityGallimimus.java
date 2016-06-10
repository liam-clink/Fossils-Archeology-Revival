package com.github.revival.server.entity.mob;

import com.github.revival.Revival;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityGallimimus extends EntityNewPrehistoric {

	public EntityGallimimus(World world) {
		super(world, EnumPrehistoric.Gallimimus, 1, 3, 8, 40, 0.25, 0.4);
		this.setSize(1.1F, 2F);
		this.pediaScale = 6F;
		this.hasFeatherToggle = true;
		this.featherToggle = Revival.CONFIG.featheredGallimimus;
		minSize = 0.5F;
		maxSize = 2.2F;
		teenAge = 4;
		developsResistance = true;
		breaksBlocks = false;
	}

	@Override
	public int getAttackLength() {
		return 30;
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

		return Attacking.BASIC;
	}

	@Override
	public Climbing aiClimbType() {

		return Climbing.NONE;
	}

	@Override
	public Following aiFollowType() {

		return Following.SKITTISH;
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
	public int getAdultAge() {
		return 10;
	}

	@Override
	public int getTailSegments() {
		return 3;
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (this.getAnimation() == ATTACK_ANIMATION && (this.getAnimationTick() >= 10 && this.getAnimationTick() <= 13) && this.getAttackTarget() != null) {
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
			if (this.getAnimation() == ATTACK_ANIMATION && (this.getAnimationTick() >= 10 && this.getAnimationTick() <= 13)) {
				IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.attackDamage);
				boolean flag = entity.attackEntityFrom(DamageSource.generic, (float) iattributeinstance.getAttributeValue());
				if (entity.ridingEntity != null) {
					if (entity.ridingEntity == this) {
						entity.mountEntity(null);
					}
				}
				entity.motionY += (0.4000000059604645D / 2);
				knockbackEntity(entity, 0.5F, 0.1F);
			}
		}
		return false;
	}

	public boolean canDinoHunt(Entity target) {
		return target.width <= 0.6D && super.canDinoHunt(target);
	}
}
