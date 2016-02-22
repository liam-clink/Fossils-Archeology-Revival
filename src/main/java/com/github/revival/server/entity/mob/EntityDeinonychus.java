package com.github.revival.server.entity.mob;

import com.github.revival.Revival;
import com.github.revival.server.config.FossilConfig;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityDeinonychus extends EntityNewPrehistoric {

    public static final double baseDamage = 2;
    public static final double maxDamage = 10;
    public static final double baseHealth = 10;
    public static final double maxHealth = 32;
    public static final double baseSpeed = 0.23D;
    public static final double maxSpeed = 0.35D;
    public Object tailbuffer = Revival.proxy.getChainBuffer(2);

    public EntityDeinonychus(World world) {
        super(world, EnumPrehistoric.Deinonychus);
        this.hasFeatherToggle = true;
        this.featherToggle = FossilConfig.featheredDeinonychus;
        this.setSize(1.8F, 1.25F);
        minSize = 0.3F;
        maxSize = 1;
        teenAge = 4;
        developsResistance = false;
        breaksBlocks = false;
        favoriteFood = Items.chicken;
    }

    public static int getAttackLength() {
        return 45;
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

        return Attacking.JUMP;
    }

    @Override
    public Climbing aiClimbType() {

        return Climbing.ARTHROPOD;
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

    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.getAttackTarget() != null) {
            double d_0 = this.getDistanceSqToEntity(this.getAttackTarget());
            boolean b = d_0 >= 6.0D && d_0 <= 18.0D ? (!this.onGround ? false : this.getRNG().nextInt(5) == 0) : false;
            if (b) {
                double d0 = this.posX - this.posX;
                double d1 = this.posZ - this.posZ;
                float f = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
                this.motionX += d0 / (double) f * 0.1D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
                this.motionZ += d1 / (double) f * 0.1D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
                this.motionY = 0.4;
            }
            if (this.ridingEntity != null) {
                if (this.ridingEntity == this.getAttackTarget()) {
                    if (this.ticksExisted % 20 == 0) {
                        this.ridingEntity.attackEntityFrom(DamageSource.causeMobDamage(this), 0);
                    }
                }
            }

        }

    }

    public boolean attackEntityAsMob(Entity entity) {
        double d_0 = this.getDistanceSqToEntity(entity);
        boolean b = d_0 >= 1.0D && d_0 <= 2.0D ? (!this.onGround ? false : this.getRNG().nextInt(5) == 0) : false;
        if (b && this.ridingEntity != entity) {
            this.mountEntity(entity);
        }
        return false;
    }
}
