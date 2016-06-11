package com.github.revival.server.entity.mob;

import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.github.revival.server.entity.ai.DinoAIHunt;
import com.github.revival.server.entity.ai.DinoAILookIdle;
import com.github.revival.server.entity.ai.DinoAIWatchClosest;
import com.github.revival.server.entity.mob.test.DinoAIFeeder;
import com.github.revival.server.entity.mob.test.DinoAIWaterFindTarget;
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
import com.github.revival.server.item.FAItemRegistry;

public class EntityMosasaurus extends EntitySwimmingPrehistoric {

	public EntityMosasaurus(World world) {
		super(world, EnumPrehistoric.Mosasaurus, 2, 9, 12, 70, 0.3, 0.35);
		this.getNavigator().setAvoidsWater(false);
		this.tasks.addTask(1, this.aiSit);
		this.tasks.addTask(2, new DinoAIWaterFindTarget(this));
		this.tasks.addTask(3, new DinoAIFeeder(this, 16));
		this.tasks.addTask(4, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new DinoAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new DinoAIHunt(this, 200, false));
		this.hasBabyTexture = false;
		this.setSize(1.5F, 0.6F);
		minSize = 0.6F;
		maxSize = 2.1F;
		teenAge = 5;
		developsResistance = true;
		breaksBlocks = true;
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

		return FAItemRegistry.INSTANCE.skullStick;
	}

	@Override
	public int getAdultAge() {
		return 11;
	}

	@Override
	protected double getSwimSpeed() {
		return 2.5D;
	}

	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (this.getAttackTarget() != null) {
			double d0 = this.getDistanceSqToEntity(this.getAttackTarget());
			// System.out.println((Math.min(this.getAdultAge(),
			// this.getAgeInDays()) / this.getAdultAge()));
			if (d0 < 10) {
				this.getAttackTarget().mountEntity(this);
			}
		}
		
	}

	public void updateRiderPosition() {
		super.updateRiderPosition();
		if (this.riddenByEntity != null) {
			this.motionY *= 0;
			this.riddenByEntity.rotationYaw = this.rotationYaw + this.rotationYawHead + 180;
			rotationYaw = renderYawOffset;
			float radius = 0.5F * (0.7F * getAgeScale()) * -3;
			float angle = (0.01745329251F * this.renderYawOffset) + 3.15F;
			double extraX = (double) (radius * MathHelper.sin((float) (Math.PI + angle)));
			double extraZ = (double) (radius * MathHelper.cos(angle));
			double extraY = 0.4F * getAgeScale();
			this.riddenByEntity.setPosition(this.posX + extraX, this.posY + extraY, this.posZ + extraZ);
		}
	}

	public int getMaxHunger() {
		return 125;
	}
}
