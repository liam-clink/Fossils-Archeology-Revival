package fossilsarcheology.server.entity.mob;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import fossilsarcheology.server.entity.EntityPrehistoricSwimming;
import fossilsarcheology.server.entity.EntityToyBase;
import fossilsarcheology.server.entity.ai.DinoAIEatFeeders;
import fossilsarcheology.server.entity.ai.DinoAIEatItems;
import fossilsarcheology.server.entity.ai.DinoAIHunt;
import fossilsarcheology.server.entity.ai.DinoAILookIdle;
import fossilsarcheology.server.entity.ai.DinoAIRiding;
import fossilsarcheology.server.entity.ai.DinoAIWatchClosest;
import fossilsarcheology.server.entity.ai.DinoAIWaterFindTarget;
import fossilsarcheology.server.enums.EnumPrehistoric;
import fossilsarcheology.server.enums.EnumPrehistoricAI.Activity;
import fossilsarcheology.server.enums.EnumPrehistoricAI.Attacking;
import fossilsarcheology.server.enums.EnumPrehistoricAI.Climbing;
import fossilsarcheology.server.enums.EnumPrehistoricAI.Following;
import fossilsarcheology.server.enums.EnumPrehistoricAI.Jumping;
import fossilsarcheology.server.enums.EnumPrehistoricAI.Moving;
import fossilsarcheology.server.enums.EnumPrehistoricAI.Response;
import fossilsarcheology.server.enums.EnumPrehistoricAI.Stalking;
import fossilsarcheology.server.enums.EnumPrehistoricAI.Taming;
import fossilsarcheology.server.enums.EnumPrehistoricAI.Untaming;
import fossilsarcheology.server.enums.EnumPrehistoricAI.WaterAbility;
import fossilsarcheology.server.item.FAItemRegistry;

public class EntityMosasaurus extends EntityPrehistoricSwimming {

	public static Animation SHAKE_ANIMATION = Animation.create(50);

	public EntityMosasaurus(World world) {
		super(world, EnumPrehistoric.Mosasaurus, 2, 9, 12, 70, 0.3, 0.35);
		this.getNavigator().setAvoidsWater(false);
		this.tasks.addTask(1, this.aiSit);
		this.tasks.addTask(2, new DinoAIWaterFindTarget(this, false));
        this.tasks.addTask(3, new DinoAIRiding(this, 1.0F));
        this.tasks.addTask(4, new DinoAIEatFeeders(this, 1));
        this.tasks.addTask(4, new DinoAIEatItems(this, 1));
        this.tasks.addTask(5, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(5, new DinoAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new DinoAIHunt(this, 20, false));
		this.hasBabyTexture = false;
		this.setActualSize(1.5F, 0.6F);
		minSize = 0.6F;
		maxSize = 4.1F;
		teenAge = 5;
		developsResistance = true;
		breaksBlocks = true;
		hasBabyTexture = false;
		pediaScale = 30;
	}

	@Override
	public void setSpawnValues() {}

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

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (this.getAttackTarget() != null) {
	        if (getAttackBounds().intersectsWith(this.getAttackTarget().boundingBox)) {
				if (!this.isEntitySmallerThan(this.getAttackTarget(), 2F * (this.getAgeScale() / this.maxSize))) {
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
			if((this.getAnimationTick() > 55 || this.getAnimation() == NO_ANIMATION)){
				if(riddenByEntity instanceof EntityToyBase){
					((EntityToyBase) riddenByEntity).dismountEntity(this);
				}
				this.riddenByEntity.attackEntityFrom(DamageSource.causeMobDamage(this),  Math.max(((EntityLivingBase) this.riddenByEntity).getMaxHealth(), 100));
				this.onKillEntity((EntityLivingBase) this.riddenByEntity);
				this.setAttackTarget(null);
			}
			
			float modTick_1 = 5 * MathHelper.sin((float) (Math.PI + (this.getAnimationTick() * 0.275F)));
			rotationYaw = renderYawOffset;
			float radius = 0.5F * (0.7F * getAgeScale()) * -3;
			float angle = (0.01745329251F * this.renderYawOffset) + 3.15F + (modTick_1 * 1.75F) * 0.05F;
			double extraX = (double) (radius * MathHelper.sin((float) (Math.PI + angle)));
			double extraZ = (double) (radius * MathHelper.cos(angle));
			double extraY = -0.15F * (getAgeScale());
			riddenByEntity.setPosition(this.posX + extraX, this.posY + extraY, this.posZ + extraZ);
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		return true;
	}

	@Override
	public int getMaxHunger() {
		return 125;
	}

	@Override
	public Animation[] getAnimations() {
		return new Animation[] { SPEAK_ANIMATION, ATTACK_ANIMATION, SHAKE_ANIMATION };
	}
	
	@Override
	public boolean canBeRidden() {
		return true;
	}
}
