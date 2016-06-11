package com.github.revival.server.entity.mob;

import com.github.revival.server.entity.ai.DinoAIHunt;
import com.github.revival.server.entity.ai.DinoAILookIdle;
import com.github.revival.server.entity.ai.DinoAIWatchClosest;
import com.github.revival.server.entity.mob.test.DinoAIFeeder;
import com.github.revival.server.entity.mob.test.DinoAIWaterFindTarget;
import com.github.revival.server.entity.mob.test.EntitySwimmingPrehistoric;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.*;

import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityLiopleurodon extends EntitySwimmingPrehistoric {

	public static final double baseDamage = 2;
	public static final double maxDamage = 12;
	public static final double baseHealth = 10;
	public static final double maxHealth = 45;
	public static final double baseSpeed = 0.3D;
	public static final double maxSpeed = 0.4D;

	public EntityLiopleurodon(World world) {
		super(world, EnumPrehistoric.Liopleurodon, 2, 12, 10, 45, 0.3, 0.4);
        this.getNavigator().setAvoidsWater(false);
        this.tasks.addTask(1, this.aiSit);
        this.tasks.addTask(2, new DinoAIWaterFindTarget(this));
        this.tasks.addTask(3, new DinoAIFeeder(this, 16));
        this.tasks.addTask(4, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(4, new DinoAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new DinoAIHunt(this, 200, false));
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
}