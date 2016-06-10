package com.github.revival.server.entity.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
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
import com.github.revival.server.item.FAItemRegistry;

public class EntityKelenken extends EntityNewPrehistoric {

	public EntityKelenken(World world) {
		super(world, EnumPrehistoric.Kelenken, 1, 6, 10, 40, 0.25, 0.35);
		this.setSize(1.4F, 2.5F);
		this.pediaScale = 17F;
		this.nearByMobsAllowed = 3;
		minSize = 0.4F;
		maxSize = 1.4F;
		teenAge = 4;
		developsResistance = true;
		breaksBlocks = false;
	}

	@Override
	public int getAttackLength() {
		return 25;
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

		return Attacking.STOMP;
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

		return Response.TERITORIAL;
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
		return false;
	}

	@Override
	public Item getOrderItem() {
		return Items.bone;
	}

	@Override
	public int getAdultAge() {
		return 8;
	}

	@Override
	public float getMaleSize() {
		return 1.2F;
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() == 15 && this.getAttackTarget() != null) {
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
			if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() == 15) {
				IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.attackDamage);
				boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) iattributeinstance.getAttributeValue());
				if (entity.ridingEntity != null) {
					if (entity.ridingEntity == this) {
						entity.mountEntity(null);
					}
				}
				entity.motionY += (0.4000000059604645D / 2);
				knockbackEntity(entity, 0.05F, -1.1F);
				return flag;
			}
		}
		return false;
	}
}
