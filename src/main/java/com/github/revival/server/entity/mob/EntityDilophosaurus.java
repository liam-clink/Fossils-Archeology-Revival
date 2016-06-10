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

public class EntityDilophosaurus extends EntityNewPrehistoric {

    public EntityDilophosaurus(World world) {
        super(world, EnumPrehistoric.Dilophosaurus, 1, 8, 8, 40, 0.25, 0.4);
        this.setSize(1.5F, 0.9F);
        this.nearByMobsAllowed = 7;
        this.pediaScale = 6.5F;
        minSize = 0.5F;
        maxSize = 2F;
        teenAge = 4;
        developsResistance = true;
        breaksBlocks = false;
    }

    @Override
    public int getAttackLength() {
        return 30;
    }

    @Override
    public void setSpawnValues() {
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() == 12 && this.getAttackTarget() != null) {
            this.attackEntityAsMob(this.getAttackTarget());
        }
    }

    @Override
    public Activity aiActivityType() {

        return Activity.DIURINAL;
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

        return Response.TERITORIAL;
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

    @Override
    public int getAdultAge() {
        return 8;
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
                entity.motionY += (0.4000000059604645D / 2);
                knockbackEntity(entity, 1F, 0.1F);
                return flag;
            }
        }
        return false;
    }

}
