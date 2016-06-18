package fossilsarcheology.server.entity.mob;

import fossilsarcheology.server.entity.ai.DinoAIHunt;
import fossilsarcheology.server.entity.ai.DinoAILookIdle;
import fossilsarcheology.server.entity.ai.DinoAIWatchClosest;
import fossilsarcheology.server.entity.mob.test.DinoAIWaterFeeder;
import fossilsarcheology.server.entity.mob.test.DinoAIWaterFindTarget;
import fossilsarcheology.server.entity.mob.test.EntitySwimmingPrehistoric;
import fossilsarcheology.server.enums.EnumPrehistoric;

import fossilsarcheology.server.enums.EnumPrehistoricAI;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityLiopleurodon extends EntitySwimmingPrehistoric {

	public static Animation SHAKE_ANIMATION = Animation.create(50);

	public EntityLiopleurodon(World world) {
		super(world, EnumPrehistoric.Liopleurodon, 2, 12, 10, 45, 0.3, 0.4);
        this.getNavigator().setAvoidsWater(false);
        this.tasks.addTask(1, this.aiSit);
        this.tasks.addTask(2, new DinoAIWaterFindTarget(this, false));
		this.tasks.addTask(3, new DinoAIWaterFeeder(this, 16));
        this.tasks.addTask(4, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(4, new DinoAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new DinoAIHunt(this, 20, false));
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
	public EnumPrehistoricAI.Activity aiActivityType() {

		return EnumPrehistoricAI.Activity.DIURINAL;
	}

	@Override
	public EnumPrehistoricAI.Attacking aiAttackType() {

		return EnumPrehistoricAI.Attacking.DROWN;
	}

	@Override
	public EnumPrehistoricAI.Climbing aiClimbType() {

		return EnumPrehistoricAI.Climbing.NONE;
	}

	@Override
	public EnumPrehistoricAI.Following aiFollowType() {

		return EnumPrehistoricAI.Following.AGRESSIVE;
	}

	@Override
	public EnumPrehistoricAI.Jumping aiJumpType() {

		return EnumPrehistoricAI.Jumping.BASIC;
	}

	@Override
	public EnumPrehistoricAI.Response aiResponseType() {

		return EnumPrehistoricAI.Response.AGRESSIVE;
	}

	@Override
	public EnumPrehistoricAI.Stalking aiStalkType() {

		return EnumPrehistoricAI.Stalking.NONE;
	}

	@Override
	public EnumPrehistoricAI.Taming aiTameType() {

		return EnumPrehistoricAI.Taming.BLUEGEM;
	}

	@Override
	public EnumPrehistoricAI.Untaming aiUntameType() {

		return EnumPrehistoricAI.Untaming.NONE;
	}

	@Override
	public EnumPrehistoricAI.Moving aiMovingType() {

		return EnumPrehistoricAI.Moving.AQUATIC;
	}

	@Override
	public EnumPrehistoricAI.WaterAbility aiWaterAbilityType() {

		return EnumPrehistoricAI.WaterAbility.ATTACK;
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
		return 2.5D;
	}

	public int getMaxHunger() {
		return 125;
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (this.getAttackTarget() != null) {
	        if (getAttackBounds().intersectsWith(this.getAttackTarget().boundingBox)) {
				if (this.getAttackTarget().width > 2F * (this.getAgeScale() / this.maxSize)) {
					if (this.getAnimation() != ATTACK_ANIMATION) {
						this.setAnimation(ATTACK_ANIMATION);
					}
					if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() > 5) {
						this.getAttackTarget().attackEntityFrom(DamageSource.causeMobDamage(this), (float) this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).getAttributeValue());
					}
					this.attackEntityAsMob(this.getAttackTarget());
				} else {
					this.getAttackTarget().mountEntity(this);
					if (this.getAnimation() != SHAKE_ANIMATION) {
						this.setAnimation(SHAKE_ANIMATION);
					}
				}
			}
		}

	}

	@Override
	public void updateRiderPosition() {
		if(this.getRidingPlayer() != null && this.func_152114_e(this.getRidingPlayer())){
			super.updateRiderPosition();
			return;
		}
		if (this.riddenByEntity != null && riddenByEntity instanceof EntityLivingBase) {
			if (this.getAnimationTick() > 45) {
				this.riddenByEntity.attackEntityFrom(DamageSource.causeMobDamage(this), ((EntityLivingBase) this.riddenByEntity).getMaxHealth());
				this.onKillEntity((EntityLivingBase) this.riddenByEntity);
				this.setAttackTarget(null);
			}

			float modTick_1 = 5 * MathHelper.sin((float) (Math.PI + (this.getAnimationTick() * 0.275F)));
			rotationYaw = renderYawOffset;
			float radius = 0.5F * (0.7F * getAgeScale()) * -3;
			float angle = (0.01745329251F * this.renderYawOffset) + 3.15F + (modTick_1 * 1.75F) * 0.05F;
			double extraX = (double) (radius * MathHelper.sin((float) (Math.PI + angle)));
			double extraZ = (double) (radius * MathHelper.cos(angle));
			double extraY = 0.15F * (getAgeScale());
			super.updateRiderPosition();
			riddenByEntity.setPosition(this.posX + extraX, this.posY + extraY, this.posZ + extraZ);
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		return true;
	}
	
	@Override
	public boolean canBeRidden() {
		return true;
	}
}