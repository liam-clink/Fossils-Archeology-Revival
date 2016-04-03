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
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;


public class EntityAnkylosaurus extends EntityNewPrehistoric {

    public static final double baseDamage = 2;
    public static final double maxDamage = 9;
    public static final double baseHealth = 25;
    public static final double maxHealth = 70;
    public static final double baseSpeed = 0.15D;
    public static final double maxSpeed = 0.25D;

    public EntityAnkylosaurus(World world) {
        super(world, EnumPrehistoric.Ankylosaurus);
        this.setSize(2.2F, 1.0F);
        this.pediaScale = 3F;
        this.nearByMobsAllowed = 6;
        minSize = 1.0F;
        maxSize = 3.0F;
        teenAge = 5;
        developsResistance = true;
        breaksBlocks = true;
        favoriteFood = Items.apple;
    }

    @Override
    public int getAttackLength() {
        return 30;
    }

    @Override
    public void updateSize() {

        double healthStep;
        double attackStep;
        double speedStep;
        healthStep = (maxHealth - baseHealth) / (this.getAdultAge() + 1);
        attackStep = (maxDamage - baseDamage) / (this.getAdultAge() + 1);
        speedStep = (maxSpeed - baseSpeed) / (this.getAdultAge() + 1);


        if (this.getDinoAge() <= this.getAdultAge()) {

            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(Math.round(baseHealth + (healthStep * this.getDinoAge())));
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(Math.round(baseDamage + (attackStep * this.getDinoAge())));
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(baseSpeed + (speedStep * this.getDinoAge()));

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

        return Activity.DIURINAL;
    }

    @Override
    public Attacking aiAttackType() {

        return Attacking.TAILSWING;
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

        return Response.TERITORIAL;
    }

    @Override
    public Stalking aiStalkType() {

        return Stalking.NONE;
    }

    @Override
    public Taming aiTameType() {

        return Taming.IMPRINTING;
    }

    @Override
    public Untaming aiUntameType() {

        return Untaming.STARVE;
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

    @Override
    public int getTailSegments() {
        return 4;
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (this.boundingBox.intersectsWith(entity.boundingBox)) {
            if (this.getAnimation() == NO_ANIMATION) {
                this.setAnimation(animation_attack);
                return false;
            }

            if (this.getAnimation() == animation_attack && this.getAnimationTick() == 20) {
                IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.attackDamage);
                boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) iattributeinstance.getAttributeValue());

                if (flag) {
                    if (entity.ridingEntity != null) {
                        if (entity.ridingEntity == this) {
                            entity.mountEntity(null);
                        }
                    }
                    entity.motionY += 0.4000000059604645D;
                    knockbackEntity(entity, 2F, 0.1F);
                }

                return flag;
            }
        }
        return false;
    }
}
