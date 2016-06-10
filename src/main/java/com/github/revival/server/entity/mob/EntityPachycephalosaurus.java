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
import net.minecraft.world.World;

public class EntityPachycephalosaurus extends EntityNewPrehistoric {

    public EntityPachycephalosaurus(World world) {
        super(world, EnumPrehistoric.Pachycephalosaurus, 2, 12, 6, 28, 0.25, 0.4);
        this.setSize(1.0F, 1.5F);
        this.nearByMobsAllowed = 4;
        this.pediaScale = 10F;
        minSize = 0.5F;
        maxSize = 2F;
        teenAge = 4;
        developsResistance = true;
        breaksBlocks = false;
        hasBabyTexture = false;
    }

    @Override
    public int getAttackLength() {
        return 30;
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
        return Attacking.KNOCKUP;
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
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() == 12 && this.getAttackTarget() != null) {
            this.attackEntityAsMob(this.getAttackTarget());
        }
    }

    @Override
    public int getAdultAge() {
        return 10;
    }

    @Override
    public int getTailSegments() {
        return 3;
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (this.getAttackBounds().intersectsWith(entity.boundingBox)) {
            if (this.getAnimation() == NO_ANIMATION) {
                this.setAnimation(ATTACK_ANIMATION);
                return false;
            }

            if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() == 12) {
                IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.attackDamage);
                boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) iattributeinstance.getAttributeValue());
                if (entity.ridingEntity != null) {
                    if (entity.ridingEntity == this) {
                        entity.mountEntity(null);
                    }
                }
                entity.motionY += 0.4000000059604645D;
                knockbackEntity(entity, 2F, 0.1F);
                return flag;
            }
        }
        return false;
    }
}
