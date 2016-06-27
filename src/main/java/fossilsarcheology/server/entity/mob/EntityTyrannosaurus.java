package fossilsarcheology.server.entity.mob;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.ai.DinoAIAttackOnCollide;
import fossilsarcheology.server.entity.ai.DinoAIFeeder;
import fossilsarcheology.server.entity.ai.DinoAIFollowOwner;
import fossilsarcheology.server.entity.ai.DinoAIHunt;
import fossilsarcheology.server.entity.ai.DinoAILookIdle;
import fossilsarcheology.server.entity.ai.DinoAIRiding;
import fossilsarcheology.server.entity.ai.DinoAIWander;
import fossilsarcheology.server.entity.ai.DinoAIWatchClosest;
import fossilsarcheology.server.enums.EnumPrehistoric;
import fossilsarcheology.server.enums.EnumPrehistoricAI;
import fossilsarcheology.server.handler.FossilAchievementHandler;
import fossilsarcheology.server.item.FAItemRegistry;

public class EntityTyrannosaurus extends EntityPrehistoric {

	public static Animation ROAR_ANIMATION = Animation.create(100);

	public EntityTyrannosaurus(World world) {
		super(world, EnumPrehistoric.Tyrannosaurus, 2, 14, 15, 82, 0.25, 0.45);
		this.getNavigator().setAvoidsWater(true);
		this.getNavigator().setCanSwim(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(3, new DinoAIRiding(this, 1.0F));
		this.tasks.addTask(4, new DinoAIAttackOnCollide(this, 1.5D, false));
		this.tasks.addTask(5, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
		this.tasks.addTask(6, new DinoAIFeeder(this, 16));
		this.tasks.addTask(7, new DinoAIWander(this, 1.0D));
		this.tasks.addTask(8, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new DinoAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(4, new DinoAIHunt(this, 200, false));
		this.setActualSize(1.8F, 1.25F);
		this.pediaScale = 1.5F;
		this.hasFeatherToggle = true;
		this.featherToggle = Revival.CONFIG.featheredTRex;
		minSize = 0.4F;
		maxSize = 4.3F;
		teenAge = 5;
		developsResistance = true;
		breaksBlocks = true;
		this.nearByMobsAllowed = 2;
		this.ridingY = 1.45F;
		this.ridingXZ = -0.05F;
	}

	@Override
	public int getAttackLength() {
		return 30;
	}

	@Override
	public int getSpeakLength() {
		return 40;
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
		if (getAttackBounds().intersectsWith(entity.boundingBox)) {
			if (this.getAnimation() == NO_ANIMATION) {
				this.setAnimation(ATTACK_ANIMATION);
				return false;
			}
			if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() == 12) {
				IAttributeInstance attackDamage = this.getEntityAttribute(SharedMonsterAttributes.attackDamage);
				boolean hurt = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) attackDamage.getAttributeValue());
				if (entity.ridingEntity != null) {
					if (entity.ridingEntity == this) {
						entity.mountEntity(null);
					}
				}
				entity.motionY += (0.4000000059604645D / 2);
				knockbackEntity(entity, 1F, 0.1F);
				return hurt;
			}
		}
		return false;
	}

	@Override
	public void setSpawnValues() {}

	@Override
	public EnumPrehistoricAI.Activity aiActivityType() {

		return EnumPrehistoricAI.Activity.DIURINAL;
	}

	@Override
	public EnumPrehistoricAI.Attacking aiAttackType() {

		return EnumPrehistoricAI.Attacking.DROP;
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

		return isChild() ? EnumPrehistoricAI.Response.SCARED : EnumPrehistoricAI.Response.AGRESSIVE;
	}

	@Override
	public EnumPrehistoricAI.Stalking aiStalkType() {

		return EnumPrehistoricAI.Stalking.STEALTH;
	}

	@Override
	public EnumPrehistoricAI.Taming aiTameType() {

		return EnumPrehistoricAI.Taming.GEM;
	}

	@Override
	public EnumPrehistoricAI.Untaming aiUntameType() {

		return EnumPrehistoricAI.Untaming.NONE;
	}

	@Override
	public EnumPrehistoricAI.Moving aiMovingType() {

		return EnumPrehistoricAI.Moving.WALK;
	}

	@Override
	public EnumPrehistoricAI.WaterAbility aiWaterAbilityType() {

		return EnumPrehistoricAI.WaterAbility.NONE;
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
	public void onUpdate() {
		super.onUpdate();
		if (!this.isSleeping() && this.rand.nextInt(500) == 0 && !worldObj.isRemote && !this.isSkeleton() && !this.isActuallyWeak() && !this.isSitting() && this.getAttackTarget() == null) {
			if (this.getAnimation() == NO_ANIMATION) {
				this.setAnimation(ROAR_ANIMATION);
			}
		}
		if (getAnimation() == EntityTyrannosaurus.ROAR_ANIMATION && getAnimationTick() == 10) {
			this.playSound("fossil:tyrannosaurus_roar", this.getSoundPitch(), this.getSoundVolume());
		}
	}

	private void triggerTamingAcheivement(EntityPlayer player) {
		player.triggerAchievement(FossilAchievementHandler.theKing);

	}

	@Override
	public int getAdultAge() {
		return 12;
	}

	@Override
	public Animation[] getAnimations() {
		return new Animation[] { SPEAK_ANIMATION, ATTACK_ANIMATION, ROAR_ANIMATION };
	}

	@Override
	public int getTailSegments() {
		return 3;
	}

	public int getMaxHunger() {
		return 150;
	}

	public void onDeath(DamageSource source) {
		if (source.getEntity() != null && source.getEntity() instanceof EntityPlayer) {
			((EntityPlayer) source.getEntity()).triggerAchievement(FossilAchievementHandler.trexKill);
		}
		super.onDeath(source);
	}

	@Override
	protected String getLivingSound() {
		return this.isWeak() ? "fossil:tyrannosaurus_weak" : super.getLivingSound();
	}
	
	@Override
	public boolean canBeRidden() {
		return true;
	}
}
