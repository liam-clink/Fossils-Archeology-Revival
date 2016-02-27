package com.github.revival.server.entity.mob;

import com.github.revival.Revival;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.*;
import com.github.revival.server.handler.FossilAchievementHandler;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityAllosaurus extends EntityNewPrehistoric {
    public static final double baseDamage = 2;
    public static final double maxDamage = 11;
    public static final double baseHealth = 10;
    public static final double maxHealth = 58;
    public static final double baseSpeed = 0.25D;
    public static final double maxSpeed = 0.42D;

    public EntityAllosaurus(World world) {
        super(world, EnumPrehistoric.Allosaurus);
        this.setSize(1.4F, 1.3F);
        minSize = 0.55F;
        maxSize = 3.1F;
        developsResistance = true;
        breaksBlocks = true;
        favoriteFood = Items.beef;
        necklength = 2;
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
        return 10;
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
        return Attacking.BASIC;
    }

    @Override
    public Climbing aiClimbType() {
        return Climbing.NONE;
    }

    @Override
    public Following aiFollowType() {
        return Following.NONE;
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
        return Stalking.NONE;
    }

    @Override
    public Taming aiTameType() {
        return Taming.GEM;
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

    private void triggerTamingAcheivement(EntityPlayer player) {
        player.triggerAchievement(FossilAchievementHandler.squire);
    }

    @Override
    public Item getOrderItem() {
        return Items.bone;
    }

	public int getTailSegments() {
		return 3;
	}
}
