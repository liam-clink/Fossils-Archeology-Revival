package com.github.revival.common.entity.mob;

import net.ilexiconn.llibrary.client.model.modelbase.ChainBuffer;
import net.ilexiconn.llibrary.common.animation.Animation;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.github.revival.Revival;
import com.github.revival.common.config.FossilConfig;
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

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityTyrannosaurus extends EntityNewPrehistoric
{

	public static final double baseDamage = 2;
	public static final double maxDamage = 14;
	public static final double baseHealth = 15;
	public static final double maxHealth = 82;
	public static final double baseSpeed = 0.25D;
	public static final double maxSpeed = 0.45D;
	public static Animation animation_roar = new Animation(1, 100);
	public Object tailbuffer = Revival.proxy.getChainBuffer(3);


	public EntityTyrannosaurus(World world) {
		super(world, EnumPrehistoric.Tyrannosaurus);
		this.setSize(1.5F, 1.25F);
		this.hasFeatherToggle = true;
		this.featherToggle = FossilConfig.featheredTRex;
		minSize = 1F;
		maxSize = 4.5F;
		teenAge = 5;
		developsResistance = true;
		breaksBlocks = true;
		favoriteFood = Items.beef;
	}

	@Override
	public void setSpawnValues() {}

	@Override
	protected void applyEntityAttributes()
	{
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

		return isChild() ? Response.SCARED :Response.AGRESSIVE;
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

	public void onUpdate(){
		super.onUpdate();
		//Revival.proxy.doChainBuffer(tailbuffer, this);
		if(!this.isSleeping() && this.onGround && this.rand.nextInt(200) == 0 && !worldObj.isRemote){
			if(this.getAnimation() != animation_roar){
				this.setAnimation(animation_roar);
			}
		}
		if(getAnimation() == EntityTyrannosaurus.animation_roar && getAnimationTick() == 10){
			this.playSound("fossil:tyrannosaurus_roar", 1, 1);
		}
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

	@Override
	public Animation[] animations() {
		return new Animation[]{this.animation_none, this.animation_roar};
	}
}
