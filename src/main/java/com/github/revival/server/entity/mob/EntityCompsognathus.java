package com.github.revival.server.entity.mob;

import com.github.revival.Revival;
import com.github.revival.server.config.FossilConfig;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.*;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityCompsognathus extends EntityNewPrehistoric {
    public static final double baseDamage = 1;
    public static final double maxDamage = 1;
    public static final double baseHealth = 4;
    public static final double maxHealth = 12;
    public static final double baseSpeed = 0.25D;
    public static final double maxSpeed = 0.3D;
    public Object tailbuffer = Revival.proxy.getChainBuffer(2);

    public EntityCompsognathus(World world) {
        super(world, EnumPrehistoric.Compsognathus);
        this.hasFeatherToggle = true;
        this.featherToggle = FossilConfig.featheredCompsognathus;
        this.setSize(1.0F, 1.0F);
        minSize = 0.25F;
        maxSize = 0.65F;
        teenAge = 1;
        developsResistance = false;
        breaksBlocks = false;
        favoriteFood = Items.chicken;
    }

    public void onUpdate() {
        super.onUpdate();
        //Revival.proxy.doChainBuffer(tailbuffer, this);
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

        return Activity.NOCTURNAL;
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

        return Following.AGRESSIVE;
    }

    @Override
    public Jumping aiJumpType() {

        return Jumping.TWOBLOCKS;
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
        return 3;
    }

    public String getOverlayTexture() {
        if (this.getSleeping() != 1 && !this.worldObj.isDaytime()) {
            return "fossil:textures/mob/compsognathus/overlay.png";
        } else {
            return "fossil:textures/blank.png";
        }
    }
}
