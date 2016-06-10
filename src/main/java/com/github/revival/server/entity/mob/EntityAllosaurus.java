package com.github.revival.server.entity.mob;

import com.github.revival.server.entity.ai.DinoAIAttackOnCollide;
import com.github.revival.server.entity.ai.DinoAIAvoidEntity;
import com.github.revival.server.entity.ai.DinoAIFollowOwner;
import com.github.revival.server.entity.ai.DinoAIHunt;
import com.github.revival.server.entity.ai.DinoAILeapAtTarget;
import com.github.revival.server.entity.ai.DinoAILookIdle;
import com.github.revival.server.entity.ai.DinoAIWander;
import com.github.revival.server.entity.ai.DinoAIWatchClosest;
import com.github.revival.server.entity.mob.test.DinoAIFeeder;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.*;
import com.github.revival.server.handler.FossilAchievementHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityAllosaurus extends EntityNewPrehistoric {

    public EntityAllosaurus(World world) {
        super(world, EnumPrehistoric.Allosaurus, 2, 11, 10, 58, 0.25, 0.42);
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().setCanSwim(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new DinoAIAvoidEntity(this, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(4, new DinoAIAttackOnCollide(this, 1.0D, false));
        this.tasks.addTask(5, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(6, new DinoAIFeeder(this, 16));
        this.tasks.addTask(7, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(8, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new DinoAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new DinoAIHunt(this, 200, false));
        this.setSize(1.4F, 1.3F);
        this.pediaScale = 3F;
        this.nearByMobsAllowed = 5;
        minSize = 0.55F;
        maxSize = 3.1F;
        developsResistance = true;
        breaksBlocks = true;
    }

    @Override
    public int getAttackLength() {
        return 30;
    }

    @Override
    public int getAdultAge() {
        return 10;
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

    @Override
    public int getTailSegments() {
        return 3;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() == 12 && this.getAttackTarget() != null) {
            this.attackEntityAsMob(this.getAttackTarget());
        }
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
                double d0 = this.getAttackTarget().posX - this.posX;
                double d1 = this.getAttackTarget().posZ - this.posZ;
                float f = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
                entity.addVelocity(-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * (0.1F * this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue() / 2), 0.0D, MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * (0.1F * this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue() / 2));
                entity.isAirBorne = false;
                return flag;
            }
        }
        return false;
    }
}
