package fossilsarcheology.server.entity.mob;

import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.EntityToyBase;
import fossilsarcheology.server.entity.ai.DinoAIEatFeeders;
import fossilsarcheology.server.entity.ai.DinoAIEatItems;
import fossilsarcheology.server.entity.ai.DinoAIFollowOwner;
import fossilsarcheology.server.entity.ai.DinoAIHunt;
import fossilsarcheology.server.entity.ai.DinoAILeapAtTarget;
import fossilsarcheology.server.entity.ai.DinoAILookIdle;
import fossilsarcheology.server.entity.ai.DinoAIWander;
import fossilsarcheology.server.entity.ai.DinoAIWatchClosest;
import fossilsarcheology.server.enums.PrehistoricAI;
import fossilsarcheology.server.enums.PrehistoricEntityType;
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
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityVelociraptor extends EntityPrehistoric {

    public EntityVelociraptor(World world) {
        super(world, PrehistoricEntityType.VELOCIRAPTOR, 1, 4, 4, 22, 0.25, 0.3);
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().setCanSwim(true);
        this.getNavigator().setAvoidSun(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new DinoAILeapAtTarget(this));
        this.tasks.addTask(4, new EntityAIRestrictSun(this));
        this.tasks.addTask(5, new EntityAIFleeSun(this, 1.0D));
        this.tasks.addTask(6, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(7, new DinoAIEatFeeders(this));
        this.tasks.addTask(7, new DinoAIEatItems(this));
        this.tasks.addTask(8, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(9, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new DinoAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new DinoAIHunt(this, 20, false));
        this.hasFeatherToggle = true;
        this.pediaScale = 45F;
        this.featherToggle = Revival.CONFIG.featheredVelociraptor;
        this.setActualSize(1.5F, 1.5F);
        minSize = 0.3F;
        maxSize = 0.8F;
        teenAge = 3;
        developsResistance = false;
        breaksBlocks = false;
        this.nearByMobsAllowed = 9;
    }

    @Override
    public int getAttackLength() {
        return 35;
    }

    @Override
    public void setSpawnValues() {
    }

    @Override
    public int getAdultAge() {
        return 6;
    }

    @Override
    public PrehistoricAI.Activity getActivityType() {

        return PrehistoricAI.Activity.NOCTURNAL;
    }

    @Override
    public PrehistoricAI.Attacking getAttackType() {

        return PrehistoricAI.Attacking.JUMP;
    }

    @Override
    public PrehistoricAI.Climbing getClimbType() {

        return PrehistoricAI.Climbing.ARTHROPOD;
    }

    @Override
    public PrehistoricAI.Following getFollowType() {

        return PrehistoricAI.Following.AGRESSIVE;
    }

    @Override
    public PrehistoricAI.Jumping getJumpType() {

        return PrehistoricAI.Jumping.BASIC;
    }

    @Override
    public PrehistoricAI.Response getResponseType() {

        return isChild() ? PrehistoricAI.Response.SCARED : PrehistoricAI.Response.TERITORIAL;
    }

    @Override
    public PrehistoricAI.Stalking getStalkType() {

        return PrehistoricAI.Stalking.STEALTH;
    }

    @Override
    public PrehistoricAI.Taming getTameType() {

        return PrehistoricAI.Taming.FEEDING;
    }

    @Override
    public PrehistoricAI.Untaming getUntameType() {

        return PrehistoricAI.Untaming.ATTACK;
    }

    @Override
    public PrehistoricAI.Moving getMoveType() {

        return PrehistoricAI.Moving.WALK;
    }

    @Override
    public PrehistoricAI.WaterAbility getWaterAbilityType() {

        return PrehistoricAI.WaterAbility.NONE;
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
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.getAttackTarget() != null && this.ridingEntity != null) {
            if (this.ridingEntity == this.getAttackTarget() && this.ticksExisted % 20 == 0) {
                IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.attackDamage);
                this.getAttackTarget().attackEntityFrom(DamageSource.causeMobDamage(this), (float) iattributeinstance.getAttributeValue());
            }
        }
        if (this.getAttackTarget() != null && this.getAnimation() == attackAnimation && (this.getAnimationTick() >= 17 && this.getAnimationTick() <= 20) && this.onGround) {
            double d0 = this.getAttackTarget().posX - this.posX;
            double d1 = this.getAttackTarget().posZ - this.posZ;
            float f = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
            this.motionX += d0 / (double) f * 0.7D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
            this.motionZ += d1 / (double) f * 0.7D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
            this.motionY = 0.4F;
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        return false;
    }

    @Override
    public void applyEntityCollision(Entity entity) {
        super.applyEntityCollision(entity);
        if (this.getAttackTarget() != null) {
            if (this.getAttackTarget() == entity && this.getAnimation() == attackAnimation && !onGround && this.ridingEntity != entity && (entity instanceof EntityToyBase)) {
                knockbackEntity(entity, 0.1F, 0.1F, 0.1F);
                entity.attackEntityFrom(DamageSource.causeMobDamage(this), 1);
            } else if (this.getAttackTarget() == entity && this.getAnimation() == attackAnimation && !onGround && this.ridingEntity != entity) {
                this.mountEntity(entity);
            }
        }
    }

    @Override
    public int getTailSegments() {
        return 3;
    }

    public int getMaxHunger() {
        return 75;
    }

    @Override
    public boolean canBeRidden() {
        return false;
    }
}
