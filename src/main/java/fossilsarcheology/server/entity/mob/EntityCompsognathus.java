package fossilsarcheology.server.entity.mob;

import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.EntityPrehistoric;
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

public class EntityCompsognathus extends EntityPrehistoric {

    public EntityCompsognathus(World world) {
        super(world, PrehistoricEntityType.COMPSOGNATHUS, 1, 1, 4, 12, 0.25, 0.4);
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().setCanSwim(true);
        this.getNavigator().setAvoidSun(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(4, new DinoAILeapAtTarget(this));
        this.tasks.addTask(5, new EntityAIRestrictSun(this));
        this.tasks.addTask(6, new EntityAIFleeSun(this, 1.0D));
        this.tasks.addTask(7, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(8, new DinoAIEatFeeders(this, 1));
        this.tasks.addTask(8, new DinoAIEatItems(this, 1));
        this.tasks.addTask(9, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(10, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(10, new DinoAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new DinoAIHunt(this, 20, false));
        this.setActualSize(1.1F, 1.1F);
        this.nearByMobsAllowed = 5;
        this.hasFeatherToggle = true;
        this.featherToggle = Revival.CONFIG.featheredCompsognathus;
        minSize = 0.25F;
        maxSize = 0.65F;
        teenAge = 2;
        developsResistance = false;
        breaksBlocks = false;
        this.pediaScale = 50F;
    }

    @Override
    public int getAttackLength() {
        return 35;
    }

    @Override
    public void setSpawnValues() {
    }

    @Override
    public PrehistoricAI.Activity getActivityType() {

        return PrehistoricAI.Activity.NOCTURNAL;
    }

    @Override
    public PrehistoricAI.Attacking getAttackType() {

        return PrehistoricAI.Attacking.BASIC;
    }

    @Override
    public PrehistoricAI.Climbing getClimbType() {

        return PrehistoricAI.Climbing.NONE;
    }

    @Override
    public PrehistoricAI.Following getFollowType() {

        return PrehistoricAI.Following.AGRESSIVE;
    }

    @Override
    public PrehistoricAI.Jumping getJumpType() {

        return PrehistoricAI.Jumping.TWOBLOCKS;
    }

    @Override
    public PrehistoricAI.Response getResponseType() {

        return PrehistoricAI.Response.SCARED;
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
    public int getAdultAge() {
        return 4;
    }

    @Override
    public String getOverlayTexture() {
        return "fossil:textures/blank.png";
    }

    @Override
    public int getTailSegments() {
        return 2;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.getAttackTarget() != null && this.getAnimation() == ATTACK_ANIMATION && (this.getAnimationTick() <= 20 && this.getAnimationTick() >= 17) && this.onGround) {
            double d0 = this.getAttackTarget().posX - this.posX;
            double d1 = this.getAttackTarget().posZ - this.posZ;
            float f = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
            this.motionX += d0 / (double) f * 0.4D * 0.800000011920929D + this.motionX * 0.40000000298023224D;
            this.motionZ += d1 / (double) f * 0.4D * 0.800000011920929D + this.motionZ * 0.40000000298023224D;
            this.getLookHelper().setLookPositionWithEntity(this.getAttackTarget(), 10, 12);
            this.motionY = 0.4;
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
            if (this.getAttackTarget() == entity && this.getAnimation() == ATTACK_ANIMATION && !onGround && this.ridingEntity != entity) {
                IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.attackDamage);
                this.getAttackTarget().attackEntityFrom(DamageSource.causeMobDamage(this), (float) iattributeinstance.getAttributeValue());
            }
        }
    }

    public int getMaxHunger() {
        return 50;
    }

    @Override
    public boolean canBeRidden() {
        return false;
    }
}
