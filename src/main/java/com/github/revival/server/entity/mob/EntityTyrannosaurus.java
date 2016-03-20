package com.github.revival.server.entity.mob;

import com.github.revival.Revival;
import com.github.revival.server.config.FossilConfig;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.*;
import com.github.revival.server.handler.FossilAchievementHandler;
import com.github.revival.server.item.FAItemRegistry;

import net.ilexiconn.llibrary.common.animation.Animation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityTyrannosaurus extends EntityNewPrehistoric {

    public static final double baseDamage = 2;
    public static final double maxDamage = 14;
    public static final double baseHealth = 15;
    public static final double maxHealth = 82;
    public static final double baseSpeed = 0.25D;
    public static final double maxSpeed = 0.4D;
    public static Animation animation_roar = new Animation(3, 100);

    public EntityTyrannosaurus(World world) {
        super(world, EnumPrehistoric.Tyrannosaurus);
        this.setSize(1.8F, 1.25F);
        this.hasFeatherToggle = true;
        this.featherToggle = FossilConfig.featheredTRex;
        minSize = 0.4F;
        maxSize = 4.5F;
        teenAge = 5;
        developsResistance = true;
        breaksBlocks = true;
        favoriteFood = Items.beef;
    }
    
	public int getAttackLength() {
		return 30;
	}
	
    public void onLivingUpdate(){
    	super.onLivingUpdate();
    	if(this.getAnimation() == this.animation_attack && this.getAnimationTick() == 12 && this.getAttackTarget() != null){
    		this.attackEntityAsMob(this.getAttackTarget());
    	}
    }
    
    public boolean attackEntityAsMob(Entity entity)
	{
		if(this.getAnimation() == animation_none){
			this.setAnimation(animation_attack);
			return false;
		}
		if(this.getAnimation() == animation_attack && this.getAnimationTick() == 12){
			IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.attackDamage);
			boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)iattributeinstance.getAttributeValue());

			if (flag)
			{
				if(entity.ridingEntity != null){
					if(entity.ridingEntity  == this){
						entity.mountEntity(null);
					}
				}
				entity.motionY += (0.4000000059604645D / 2);
                knockbackEntity(entity, 1F, 0.1F);	
				
			}

			return flag;
		}
		return false;
	}

    @Override
    public void setSpawnValues() {
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(baseSpeed);
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(baseHealth);
        getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(baseDamage);
    }

    @Override
    public Activity aiActivityType() {

        return Activity.DURINAL;
    }

    @Override
    public Attacking aiAttackType() {

        return Attacking.DROP;
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

        return isChild() ? Response.SCARED : Response.AGRESSIVE;
    }

    @Override
    public Stalking aiStalkType() {

        return Stalking.STEALTH;
    }

    @Override
    public Taming aiTameType() {

        return Taming.GEM;
    }

    @Override
    public Untaming aiUntameType() {

        return Untaming.NONE;
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

        return FAItemRegistry.skullStick;
    }

    public void onUpdate() {
        super.onUpdate();

        //Revival.proxy.doChainBuffer(tailbuffer, this);
        if (!this.isSleeping() && this.rand.nextInt(500) == 0 && !worldObj.isRemote && !this.isSitting() && this.getAttackTarget() == null) {
            if (this.getAnimation() == this.animation_none) {
                this.setAnimation(animation_roar);
            }
        }
        if (getAnimation() == EntityTyrannosaurus.animation_roar && getAnimationTick() == 10) {
            this.playSound("fossil:tyrannosaurus_roar", 1, 1);
        }
    }

    private void triggerTamingAcheivement(EntityPlayer player) {
        player.triggerAchievement(FossilAchievementHandler.theKing);

    }

    public void updateSize() {
        double healthStep;
        double attackStep;
        double speedStep;
        healthStep = (this.maxHealth - this.baseHealth) / (this.getAdultAge() + 1);
        attackStep = (this.maxDamage - this.baseDamage) / (this.getAdultAge() + 1);
        speedStep = (this.maxSpeed - this.baseSpeed) / (this.getAdultAge() + 1);


        if (this.getDinoAge() <= this.getAdultAge()) {

            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(Math.round(this.baseHealth + (healthStep * this.getDinoAge())));
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(Math.round(this.baseDamage + (attackStep * this.getDinoAge())));
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.baseSpeed + (speedStep * this.getDinoAge()));

            if (this.isTeen()) {
                this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.5D);
            } else if (this.isAdult()) {
                this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(2.0D);
            } else {
                this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);
            }
        }
    }

    @Override
    public int getAdultAge() {
        return 12;
    }

    @Override
    public Animation[] animations() {
        return new Animation[]{this.animation_none, this.animation_speak, this.animation_attack, this.animation_roar};
    }

	public int getTailSegments() {
		return 3;
	}
}
