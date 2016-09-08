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
import fossilsarcheology.server.handler.FossilAchievementHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityDodo extends EntityPrehistoric {

    public EntityDodo(World world) {
        super(world, PrehistoricEntityType.DODO, 1, 1, 4, 10, 0.2, 0.25);
        this.teenAge = 3;
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().setCanSwim(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAIPanic(this, 1.5D));
        this.tasks.addTask(5, new DinoAIAttackOnCollide(this, 1.0D, false));
        this.tasks.addTask(6, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(7, new DinoAIEatBlocks(this, 1));
        this.tasks.addTask(7, new DinoAIEatFeeders(this, 1));
        this.tasks.addTask(7, new DinoAIEatItems(this, 1));
        this.tasks.addTask(8, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(9, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new DinoAILookIdle(this));
        this.targetTasks.addTask(4, new DinoAIHunt(this, 20, false));
        this.setActualSize(0.8F, 0.7F);
        this.nearByMobsAllowed = 10;
        minSize = 0.5F;
        maxSize = 1F;
        teenAge = 2;
        developsResistance = false;
        breaksBlocks = false;
        hasTeenTexture = false;
        pediaScale = 40;
    }

    @Override
    public int getAttackLength() {
        return 25;
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

        return PrehistoricAI.Following.NORMAL;
    }

    @Override
    public PrehistoricAI.Jumping getJumpType() {

        return PrehistoricAI.Jumping.BASIC;
    }

    @Override
    public PrehistoricAI.Response getResponseType() {

        return PrehistoricAI.Response.SCARED;
    }

    @Override
    public PrehistoricAI.Stalking getStalkType() {

        return PrehistoricAI.Stalking.NONE;
    }

    @Override
    public PrehistoricAI.Taming getTameType() {

        return PrehistoricAI.Taming.FEEDING;
    }

    @Override
    public PrehistoricAI.Untaming getUntameType() {

        return PrehistoricAI.Untaming.NONE;
    }

    @Override
    public PrehistoricAI.Moving getMoveType() {

        return PrehistoricAI.Moving.WALKANDGLIDE;
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
    public boolean isChild() {
        return !this.isSkeleton() && super.isChild();
    }

    @Override
    public int getAdultAge() {
        return 5;
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
                return flag;
            }
        }
        return false;
    }

    public int getMaxHunger() {
        return 50;
    }

    public void onDeath(DamageSource source) {
        if (source.getEntity() != null && source.getEntity() instanceof EntityPlayer) {
            ((EntityPlayer) source.getEntity()).triggerAchievement(FossilAchievementHandler.deadDodo);
        }
        super.onDeath(source);
    }

    @Override
    public boolean canBeRidden() {
        return false;
    }
}
