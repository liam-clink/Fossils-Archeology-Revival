package com.github.revival.common.entity.mob;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.common.enums.EnumPrehistoric;
import com.github.revival.common.enums.EnumPrehistoricAI.Activity;
import com.github.revival.common.enums.EnumPrehistoricAI.Attacking;
import com.github.revival.common.enums.EnumPrehistoricAI.Climbing;
import com.github.revival.common.enums.EnumPrehistoricAI.Following;
import com.github.revival.common.enums.EnumPrehistoricAI.Jumping;
import com.github.revival.common.enums.EnumPrehistoricAI.Moving;
import com.github.revival.common.enums.EnumPrehistoricAI.Response;
import com.github.revival.common.enums.EnumPrehistoricAI.Stalking;
import com.github.revival.common.enums.EnumPrehistoricAI.Taming;
import com.github.revival.common.enums.EnumPrehistoricAI.Untaming;
import com.github.revival.common.enums.EnumPrehistoricAI.WaterAbility;
import com.github.revival.common.item.FAItemRegistry;

public class EntitySarcosuchus extends EntityNewPrehistoric
{

	public static final double baseDamage = 1;
	public static final double maxDamage = 3;
	public static final double baseHealth = 5;
	public static final double maxHealth = 70;
	public static final double baseSpeed = 0.25D;
	public static final double maxSpeed = 0.25D;
	
	public EntitySarcosuchus(World world) {
		super(world, EnumPrehistoric.Sarcosuchus);
        this.setSize(4.0F, 1.0F);
        minSize = 0.2F;
		maxSize = 1.3F;
		teenAge = 5;
		developsResistance = true;
		breaksBlocks = true;
		favoriteFood = Items.beef;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(baseSpeed);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(baseHealth);
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(baseDamage);
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
		return FAItemRegistry.skullStick;
	}

	public void updateSize()
	{
		 double healthStep;
	        double attackStep;
	        double speedStep;
	        healthStep = (this.maxHealth - this.baseHealth) / (this.getAdultAge() + 1);
	        attackStep = (this.maxDamage - this.baseDamage) / (this.getAdultAge() + 1);
	        speedStep = (this.maxSpeed - this.baseSpeed) / (this.getAdultAge() + 1);
	        
	        
	        if (this.getDinoAge() <= this.getAdultAge())
	        {

	            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(Math.round(this.baseHealth + (healthStep * this.getDinoAge())));
	            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(Math.round(this.baseDamage + (attackStep * this.getDinoAge())));
	            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.baseSpeed + (speedStep * this.getDinoAge()));

	            if (this.isTeen())
	            {
	                this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.5D);
	            }
	            else if (this.isAdult())
	            {
	                this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(2.0D);
	            }
	            else
	            {
	                this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);
	            }
	        }
	}

	@Override
	public int getAdultAge() {
		return 12;
	}
	

}
