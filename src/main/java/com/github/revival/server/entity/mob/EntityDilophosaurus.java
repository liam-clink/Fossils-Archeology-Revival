package com.github.revival.server.entity.mob;

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

public class EntityDilophosaurus extends EntityNewPrehistoric {

    public static final double baseDamage = 1;
    public static final double maxDamage = 8;
    public static final double baseHealth = 8;
    public static final double maxHealth = 40;
    public static final double baseSpeed = 0.25D;
    public static final double maxSpeed = 0.4D;

    public EntityDilophosaurus(World world) {
        super(world, EnumPrehistoric.Dilophosaurus);
        this.setSize(1.5F, 0.9F);
        minSize = 0.5F;
        maxSize = 2F;
        teenAge = 4;
        developsResistance = true;
        breaksBlocks = false;
        favoriteFood = Items.beef;
    }

	public int getAttackLength() {
		return 30;
	}
	
    @Override
    public void setSpawnValues() {
    }
    
    public void onLivingUpdate(){
    	super.onLivingUpdate();
    	if(this.getAnimation() == this.animation_attack && this.getAnimationTick() == 12 && this.getAttackTarget() != null){
    		this.attackEntityAsMob(this.getAttackTarget());
    	}
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

        return Attacking.CHARGE;
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

        return Response.TERRITORIAL;
    }

    @Override
    public Stalking aiStalkType() {

        return Stalking.STEALTH;
    }

    @Override
    public Taming aiTameType() {

        return Taming.IMPRINTING;
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
        }
    }

    @Override
    public int getAdultAge() {
        return 8;
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

}
