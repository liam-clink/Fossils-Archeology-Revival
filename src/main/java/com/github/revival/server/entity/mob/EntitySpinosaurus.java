package com.github.revival.server.entity.mob;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.github.revival.server.entity.ai.DinoAIAttackOnCollide;
import com.github.revival.server.entity.ai.DinoAIFollowOwner;
import com.github.revival.server.entity.ai.DinoAIHunt;
import com.github.revival.server.entity.ai.DinoAILookIdle;
import com.github.revival.server.entity.ai.DinoAIRiding;
import com.github.revival.server.entity.ai.DinoAIWander;
import com.github.revival.server.entity.ai.DinoAIWatchClosest;
import com.github.revival.server.entity.mob.test.DinoAIFeeder;
import com.github.revival.server.entity.mob.test.DinoAIMakeFish;
import com.github.revival.server.entity.mob.test.DinoAIWaterFeeder;
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

public class EntitySpinosaurus extends EntitySwimmingPrehistoric {

	public static Animation SHAKE_ANIMATION = Animation.create(65);
	private boolean isSwimming;
	public float swimProgress;

	public EntitySpinosaurus(World world) {
		super(world, EnumPrehistoric.Spinosaurus, 2, 14, 15, 60, 0.25, 0.3);
		this.setSize(1.5F, 1.0F);
		isAmphibious = true;
		FISH_ANIMATION = Animation.create(35);
		this.getNavigator().setAvoidsWater(false);
		this.tasks.addTask(1, this.aiSit);
		this.tasks.addTask(2, new DinoAIWaterFindTarget(this, true));
        this.tasks.addTask(3, new DinoAIRiding(this, 1.0F));
		this.tasks.addTask(3, new DinoAIAttackOnCollide(this, 1.5D, false));
		this.tasks.addTask(4, new DinoAIWaterFeeder(this, 16));
		this.tasks.addTask(4, new DinoAIFeeder(this, 16));
		this.tasks.addTask(5, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
		this.tasks.addTask(6, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(7, new DinoAIMakeFish(this));
		this.tasks.addTask(8, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new DinoAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(4, new DinoAIHunt(this, 20, false));
		minSize = 0.6F;
		maxSize = 4.75F;
		teenAge = 5;
		developsResistance = true;
		breaksBlocks = true;
		this.hasBabyTexture = true;
		this.ridingXZ = -0.3F;
		this.ridingY = 1.2F;
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

		return Moving.SEMIAQUATIC;
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
		return 12;
	}

	@Override
	public int getTailSegments() {
		return 3;
	}

	public int getMaxHunger() {
		return 175;
	}

	@Override
	protected double getSwimSpeed() {
		return 1;
	}

	@Override
	public void updateRiderPosition() {
		if(this.getRidingPlayer() != null && this.func_152114_e(this.getRidingPlayer())){
			super.updateRiderPosition();
			return;
		}
		
		if (this.riddenByEntity != null && riddenByEntity instanceof EntityLivingBase && !this.func_152114_e(((EntityLivingBase) this.riddenByEntity))) {
			if(this.getAnimationTick() > 55 && this.riddenByEntity != null){
				this.riddenByEntity.attackEntityFrom(DamageSource.causeMobDamage(this), ((EntityLivingBase) this.riddenByEntity).getMaxHealth());
				this.onKillEntity((EntityLivingBase) this.riddenByEntity);
			}
			riddenByEntity.setPosition(this.posX, this.posY + this.getMountedYOffset() + riddenByEntity.getYOffset(), this.posZ);
			float modTick_0 = this.getAnimationTick() - 15;
			float modTick_1 = this.getAnimationTick() > 15 ? 6 * MathHelper.sin((float) (Math.PI + (modTick_0 * 0.275F))) : 0;
			float modTick_2 = this.getAnimationTick() > 15 ? 15 : this.getAnimationTick();
			this.rotationYaw *= 0;
			riddenByEntity.rotationYaw = this.rotationYaw + this.rotationYawHead + 180;
			rotationYaw = renderYawOffset;
			float radius = 0.6F * (0.7F * getAgeScale()) * -3;
			float angle = (0.01745329251F * this.renderYawOffset) + 3.15F + (modTick_1 * 1.75F) * 0.05F;
			double extraX = (double) (radius * MathHelper.sin((float) (Math.PI + angle)));
			double extraZ = (double) (radius * MathHelper.cos(angle));
			double extraY = 0.5F * (getAgeScale() + (modTick_1 * 0.05) + (modTick_2 * 0.15) - 2);
			super.updateRiderPosition();
			riddenByEntity.setPosition(this.posX + extraX, this.posY + extraY, this.posZ + extraZ);		
		}
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		boolean swimming = this.isSwimming();
        if (swimming && swimProgress < 20.0F) {
        	swimProgress += 0.5F;
            if (sitProgress != 0)
                sitProgress = sleepProgress = 0F;
        } else if (!swimming && swimProgress > 0.0F) {
        	swimProgress -= 0.5F;
            if (sitProgress != 0)
                sitProgress = sleepProgress = 0F;
        }
		if (this.getAttackTarget() != null) {
	        if (getAttackBounds().intersectsWith(this.getAttackTarget().boundingBox)) {
				if (this.getAttackTarget().width > 1.5F) {
					if (this.getAnimation() != ATTACK_ANIMATION) {
						this.setAnimation(ATTACK_ANIMATION);
					}
					if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() > 10) {
						this.getAttackTarget().attackEntityFrom(DamageSource.causeMobDamage(this), (float) this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).getAttributeValue());
					}
					this.attackEntityAsMob(this.getAttackTarget());
				} else if(this.riddenByEntity != null){
					this.getAttackTarget().mountEntity(this);
					if (this.getAnimation() != SHAKE_ANIMATION) {
						this.setAnimation(SHAKE_ANIMATION);
					}
				}
			}
		}
		if(this.isInsideOfMaterial(Material.water)){
			this.setSwimming(true);
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if(this.isInWater()){
			return false;
		}

		return true;
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(29, (byte) 0);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean("Swimming", this.isSwimming);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setSwimming(compound.getBoolean("Swimming"));

	}

	public boolean isSwimming() {
		if (worldObj.isRemote) {
			boolean isSwimming = (this.dataWatcher.getWatchableObjectByte(29) & 1) != 0;
			this.isSwimming = isSwimming;
			return isSwimming;
		}

		return isSwimming;
	}

	public void setSwimming(boolean swimming) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(29);

		if (swimming) {
			this.dataWatcher.updateObject(29, (byte) (b0 | 1));
		} else {
			this.dataWatcher.updateObject(29, (byte) (b0 & -2));
		}

		if (!worldObj.isRemote) {
			this.isSwimming = swimming;
		}
	}

	public int getAttackLength(){
		return 25;
	}

	@Override
	public Animation[] getAnimations() {
		return new Animation[] { SPEAK_ANIMATION, ATTACK_ANIMATION, SHAKE_ANIMATION, FISH_ANIMATION };
	}
	
	@Override
	public boolean canBeRidden() {
		return true;
	}
}
