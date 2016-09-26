package fossilsarcheology.server.entity.mob;

import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.ai.DinoAIAttackOnCollide;
import fossilsarcheology.server.entity.ai.DinoAIEatFeeders;
import fossilsarcheology.server.entity.ai.DinoAIEatItems;
import fossilsarcheology.server.entity.ai.DinoAIFollowOwner;
import fossilsarcheology.server.entity.ai.DinoAIHunt;
import fossilsarcheology.server.entity.ai.DinoAILookIdle;
import fossilsarcheology.server.entity.ai.DinoAIRiding;
import fossilsarcheology.server.entity.ai.DinoAIWander;
import fossilsarcheology.server.entity.ai.DinoAIWatchClosest;
import fossilsarcheology.server.enums.PrehistoricAI;
import fossilsarcheology.server.enums.PrehistoricEntityType;
import fossilsarcheology.server.handler.FossilAchievementHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityAllosaurus extends EntityPrehistoric {

    public EntityAllosaurus(World world) {
        super(world, PrehistoricEntityType.ALLOSAURUS, 2, 11, 10, 58, 0.25, 0.42);
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().setCanSwim(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new DinoAIRiding(this, 1.0F));
        this.tasks.addTask(4, new DinoAIAttackOnCollide(this, 1.0D, false));
        this.tasks.addTask(5, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(6, new DinoAIEatFeeders(this));
        this.tasks.addTask(6, new DinoAIEatItems(this));
        this.tasks.addTask(7, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(8, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new DinoAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new DinoAIHunt(this, 20, false));
        this.setActualSize(1.4F, 1.3F);
        this.pediaScale = 35F;
        this.nearByMobsAllowed = 5;
        minSize = 0.55F;
        maxSize = 3.1F;
        developsResistance = true;
        breaksBlocks = true;
        this.teenAge = 5;
        this.ridingY = 1.3F;
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
    public PrehistoricAI.Activity getActivityType() {
        return PrehistoricAI.Activity.DIURINAL;
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
        return PrehistoricAI.Following.NONE;
    }

    @Override
    public PrehistoricAI.Jumping getJumpType() {
        return PrehistoricAI.Jumping.BASIC;
    }

    @Override
    public PrehistoricAI.Response getResponseType() {
        return PrehistoricAI.Response.TERITORIAL;
    }

    @Override
    public PrehistoricAI.Stalking getStalkType() {
        return PrehistoricAI.Stalking.NONE;
    }

    @Override
    public PrehistoricAI.Taming getTameType() {
        return PrehistoricAI.Taming.GEM;
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
        if (this.getAnimation() == attackAnimation && this.getAnimationTick() == 12 && this.getAttackTarget() != null) {
            this.attackEntityAsMob(this.getAttackTarget());
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (this.getAttackBounds().intersectsWith(entity.boundingBox)) {
            if (this.getAnimation() == NO_ANIMATION) {
                this.setAnimation(attackAnimation);
                return false;
            }
            if (this.getAnimation() == attackAnimation && this.getAnimationTick() == 12) {
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

    public int getMaxHunger() {
        return 125;
    }

    @Override
    public boolean canBeRidden() {
        return true;
    }
}
