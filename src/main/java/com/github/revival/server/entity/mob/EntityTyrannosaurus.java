package com.github.revival.server.entity.mob;

import com.github.revival.Revival;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.*;
import com.github.revival.server.handler.FossilAchievementHandler;
import com.github.revival.server.item.FAItemRegistry;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityTyrannosaurus extends EntityNewPrehistoric {

    public static Animation ROAR_ANIMATION = Animation.create(100);

    public EntityTyrannosaurus(World world) {
        super(world, EnumPrehistoric.Tyrannosaurus, 2, 14, 15, 82, 0.25, 0.5);
        this.setSize(1.8F, 1.25F);
        this.pediaScale = 1.5F;
        this.hasFeatherToggle = true;
        this.featherToggle = Revival.CONFIG.featheredTRex;
        minSize = 0.4F;
        maxSize = 4.5F;
        teenAge = 5;
        developsResistance = true;
        breaksBlocks = true;
        this.nearByMobsAllowed = 2;
    }

    @Override
    public int getAttackLength() {
        return 30;
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
        if (getAttackBounds().intersectsWith(entity.boundingBox)) {
            if (this.getAnimation() == NO_ANIMATION) {
                this.setAnimation(ATTACK_ANIMATION);
                return false;
            }
            if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() == 12) {
                IAttributeInstance attackDamage = this.getEntityAttribute(SharedMonsterAttributes.attackDamage);
                boolean hurt = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) attackDamage.getAttributeValue());
                if (entity.ridingEntity != null) {
                    if (entity.ridingEntity == this) {
                        entity.mountEntity(null);
                    }
                }
                entity.motionY += (0.4000000059604645D / 2);
                knockbackEntity(entity, 1F, 0.1F);
                return hurt;
            }
        }
        return false;
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

        return isChild() ? Response.SCARED : Response.AGRESSIVE;
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

        return FAItemRegistry.INSTANCE.skullStick;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        // Revival.proxy.doChainBuffer(tailBuffer, this);
        if (!this.isSleeping() && this.rand.nextInt(500) == 0 && !worldObj.isRemote && !this.isSitting() && this.getAttackTarget() == null) {
            if (this.getAnimation() == NO_ANIMATION) {
                this.setAnimation(ROAR_ANIMATION);
            }
        }
        if (getAnimation() == EntityTyrannosaurus.ROAR_ANIMATION && getAnimationTick() == 10) {
            this.playSound("fossil:tyrannosaurus_roar", 1, 1);
        }
    }

    private void triggerTamingAcheivement(EntityPlayer player) {
        player.triggerAchievement(FossilAchievementHandler.theKing);

    }

    @Override
    public int getAdultAge() {
        return 12;
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{SPEAK_ANIMATION, ATTACK_ANIMATION, ROAR_ANIMATION};
    }

    @Override
    public int getTailSegments() {
        return 3;
    }
}
