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

public class EntitySarcosuchus extends EntitySwimmingPrehistoric {

	public static Animation ROLL_ANIMATION = Animation.create(115);
	private boolean isSwimming;
	public float swimProgress;
	
    public EntitySarcosuchus(World world) {
        super(world, EnumPrehistoric.Sarcosuchus, 1, 3, 15, 70, 0.25, 0.25);
        this.setSize(2.0F, 1.0F);
        isAmphibious = true;
		this.getNavigator().setAvoidsWater(false);
		this.tasks.addTask(1, this.aiSit);
		this.tasks.addTask(2, new DinoAIWaterFindTarget(this, true));
        this.tasks.addTask(3, new DinoAIRiding(this, 1.0F));
		this.tasks.addTask(3, new DinoAIAttackOnCollide(this, 1.5D, false));
		this.tasks.addTask(4, new DinoAIWaterFeeder(this, 16));
		this.tasks.addTask(4, new DinoAIFeeder(this, 16));
		this.tasks.addTask(5, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
		this.tasks.addTask(6, new DinoAIWander(this, 1.0D));
		this.tasks.addTask(7, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new DinoAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(4, new DinoAIHunt(this, 20, false));
        minSize = 0.2F;
        maxSize = 2.3F;
        teenAge = 5;
        developsResistance = true;
        breaksBlocks = true;
		this.hasBabyTexture = true;
		this.ridingY = 1.5F;
    }

    @Override
    public void setSpawnValues() {

    }

    @Override
    public Activity aiActivityType() {

        return Activity.BOTH;
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
    
	public int getMaxHunger() {
		return 150;
	}

	@Override
	protected double getSwimSpeed() {
		return 2;
	}
	
	@Override
	public void updateRiderPosition() {
		if(this.getRidingPlayer() != null && this.func_152114_e(this.getRidingPlayer())){
			super.updateRiderPosition();
			return;
		}
		
		if (this.riddenByEntity != null && riddenByEntity instanceof EntityLivingBase && !this.func_152114_e(((EntityLivingBase) this.riddenByEntity))) {			if(this.getAnimationTick() % 20 == 0 && this.riddenByEntity != null){
				this.riddenByEntity.attackEntityFrom(DamageSource.drown, 10);
				if(riddenByEntity.isDead){
				this.onKillEntity((EntityLivingBase) this.riddenByEntity);
				}
			}
			riddenByEntity.setPosition(this.posX, this.posY + this.getMountedYOffset() + riddenByEntity.getYOffset(), this.posZ);
			this.rotationYaw *= 0;
			riddenByEntity.rotationYaw = this.rotationYaw + this.rotationYawHead + 180;
			rotationYaw = renderYawOffset;
			float radius = 0.4F * (0.7F * getAgeScale()) * -3;
			float angle = (0.01745329251F * this.renderYawOffset) + 3.15F * 0.05F;
			double extraX = (double) (radius * MathHelper.sin((float) (Math.PI + angle)));
			double extraZ = (double) (radius * MathHelper.cos(angle));
			double extraY = 0.5F * getAgeScale();
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
				if (!this.isInWater()) {
					if (this.getAnimation() != ATTACK_ANIMATION) {
						this.setAnimation(ATTACK_ANIMATION);
					}
					if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() > 5) {
						this.getAttackTarget().attackEntityFrom(DamageSource.causeMobDamage(this), (float) this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).getAttributeValue());
					}
					this.attackEntityAsMob(this.getAttackTarget());
				} else {
					this.getAttackTarget().mountEntity(this);
					if (this.getAnimation() != ROLL_ANIMATION) {
						this.setAnimation(ROLL_ANIMATION);
					}
				}
			}
		}
		if(this.isInsideOfMaterial(Material.water)){
			this.setSwimming(true);
		}
	}
	
	public int getAttackLength(){
		return 15;
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if(this.isInWater()){
			return false;
		}
	return true;
	}

	@Override
	public Animation[] getAnimations() {
		return new Animation[] { SPEAK_ANIMATION, ATTACK_ANIMATION, ROLL_ANIMATION };
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
	
	@Override
	public boolean canBeRidden() {
		return true;
	}
}
