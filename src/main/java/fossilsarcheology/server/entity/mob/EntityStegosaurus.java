package fossilsarcheology.server.entity.mob;

import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.ai.DinoAIAttackOnCollide;
import fossilsarcheology.server.entity.ai.DinoAIEatBlocks;
import fossilsarcheology.server.entity.ai.DinoAIEatFeeders;
import fossilsarcheology.server.entity.ai.DinoAIEatItems;
import fossilsarcheology.server.entity.ai.DinoAIFollowOwner;
import fossilsarcheology.server.entity.ai.DinoAIHunt;
import fossilsarcheology.server.entity.ai.DinoAILookIdle;
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

public class EntityStegosaurus extends EntityPrehistoric {

    public EntityStegosaurus(World world) {
        super(world, PrehistoricEntityType.STEGOSAURUS, 2, 9, 12, 66, 0.25, 0.3);
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().setCanSwim(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new DinoAIAttackOnCollide(this, 1.5D, false));
        this.tasks.addTask(4, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(5, new DinoAIEatBlocks(this));
        this.tasks.addTask(5, new DinoAIEatFeeders(this));
        this.tasks.addTask(5, new DinoAIEatItems(this));
        this.tasks.addTask(6, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(7, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new DinoAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new DinoAIHunt(this, 20, false));
        this.setActualSize(1.4F, 1.3F);
        this.nearByMobsAllowed = 7;
        minSize = 1F;
        maxSize = 2.5F;
        teenAge = 5;
        developsResistance = true;
        breaksBlocks = true;
        this.pediaScale = 20F;
    }

    @Override
    public int getAttackLength() {
        return 30;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.getAnimation() == attackAnimation && (this.getAnimationTick() >= 17 && this.getAnimationTick() <= 19) && this.getAttackTarget() != null) {
            this.attackEntityAsMob(this.getAttackTarget());
        }
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

        return PrehistoricAI.Attacking.TAILSWING;
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
    public int getAdultAge() {
        return 12;
    }

    @Override
    public int getTailSegments() {
        return 3;
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (this.getAttackBounds().intersectsWith(entity.boundingBox)) {
            if (this.getAnimation() == NO_ANIMATION) {
                this.setAnimation(attackAnimation);
                return false;
            }

            if (this.getAnimation() == attackAnimation && (this.getAnimationTick() >= 17 && this.getAnimationTick() <= 20)) {
                IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.attackDamage);
                boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) iattributeinstance.getAttributeValue());
                if (entity.ridingEntity != null) {
                    if (entity.ridingEntity == this) {
                        entity.mountEntity(null);
                    }
                }
                knockbackEntity(entity, 1.5F, 0.2F);
                return flag;
            }
        }
        return false;
    }

    public int getMaxHunger() {
        return 175;
    }

    @Override
    public boolean canBeRidden() {
        return false;
    }
}
