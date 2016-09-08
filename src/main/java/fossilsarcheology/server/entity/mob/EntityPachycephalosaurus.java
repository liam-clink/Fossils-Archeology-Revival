package fossilsarcheology.server.entity.mob;

import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.ai.DinoAIAttackOnCollide;
import fossilsarcheology.server.entity.ai.DinoAIEatBlocks;
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
import net.minecraft.world.World;

public class EntityPachycephalosaurus extends EntityPrehistoric {

    public EntityPachycephalosaurus(World world) {
        super(world, PrehistoricEntityType.PACHYCEPHALOSAURUS, 2, 12, 6, 28, 0.25, 0.4);
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().setCanSwim(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new DinoAIRiding(this, 1.5D));
        this.tasks.addTask(4, new DinoAIAttackOnCollide(this, 1.5D, false));
        this.tasks.addTask(5, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(6, new DinoAIEatBlocks(this, 1));
        this.tasks.addTask(6, new DinoAIEatFeeders(this, 1));
        this.tasks.addTask(6, new DinoAIEatItems(this, 1));
        this.tasks.addTask(7, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(8, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new DinoAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new DinoAIHunt(this, 20, false));
        this.setActualSize(1.0F, 1.5F);
        this.nearByMobsAllowed = 4;
        minSize = 0.5F;
        maxSize = 2F;
        teenAge = 4;
        developsResistance = true;
        breaksBlocks = false;
        hasBabyTexture = false;
        this.ridingY = 1.55F;
        this.pediaScale = 40F;
    }

    @Override
    public int getAttackLength() {
        return 30;
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
        return PrehistoricAI.Attacking.KNOCKUP;
    }

    @Override
    public PrehistoricAI.Climbing getClimbType() {
        return PrehistoricAI.Climbing.NONE;
    }

    @Override
    public PrehistoricAI.Following getFollowType() {

        return PrehistoricAI.Following.SKITTISH;
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

        return PrehistoricAI.Taming.IMPRINTING;
    }

    @Override
    public PrehistoricAI.Untaming getUntameType() {

        return PrehistoricAI.Untaming.STARVE;
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

    public int getMaxHunger() {
        return 100;
    }

    @Override
    public boolean canBeRidden() {
        return true;
    }
}
