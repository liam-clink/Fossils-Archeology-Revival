package com.github.revival.server.entity.mob;

import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
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
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityConfuciusornis extends EntityNewPrehistoric {

    public static final double baseDamage = 0;
    public static final double maxDamage = 0;
    public static final double baseHealth = 4;
    public static final double maxHealth = 12;
    public static final double baseSpeed = 0.25D;
    public static final double maxSpeed = 0.25D;

    public EntityConfuciusornis(World world) {
        super(world, EnumPrehistoric.Confuciusornis);
        this.setSize(0.5F, 0.5F);
        minSize = 0.3F;
        maxSize = 0.6F;
        teenAge = 1;
        developsResistance = false;
        breaksBlocks = false;
        favoriteFood = Items.pumpkin_seeds;
    }

    @Override
    protected void applyEntityAttributes() {
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
        return Activity.DIURINAL;
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
        return Following.SKITTISH;
    }

    @Override
    public Jumping aiJumpType() {
        return Jumping.BASIC;
    }

    @Override
    public Response aiResponseType() {
        return Response.SCARED;
    }

    @Override
    public Stalking aiStalkType() {
        return Stalking.STEALTH;
    }

    @Override
    public Taming aiTameType() {
        return Taming.FEEDING;
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
        return Items.stick;
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
        return 3;
    }

}
