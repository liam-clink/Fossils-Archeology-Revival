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
import fossilsarcheology.server.enums.PrehistoricAI.Activity;
import fossilsarcheology.server.enums.PrehistoricAI.Attacking;
import fossilsarcheology.server.enums.PrehistoricAI.Climbing;
import fossilsarcheology.server.enums.PrehistoricAI.Following;
import fossilsarcheology.server.enums.PrehistoricAI.Jumping;
import fossilsarcheology.server.enums.PrehistoricAI.Moving;
import fossilsarcheology.server.enums.PrehistoricAI.Response;
import fossilsarcheology.server.enums.PrehistoricAI.Stalking;
import fossilsarcheology.server.enums.PrehistoricAI.Taming;
import fossilsarcheology.server.enums.PrehistoricAI.Untaming;
import fossilsarcheology.server.enums.PrehistoricAI.WaterAbility;
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

public class EntityAnkylosaurus extends EntityPrehistoric {

    public EntityAnkylosaurus(World world) {
        super(world, PrehistoricEntityType.ANKYLOSAURUS, 2, 9, 25, 70, 0.25, 0.45);
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().setCanSwim(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new DinoAIRiding(this, 1.0F));
        this.tasks.addTask(3, new DinoAIAttackOnCollide(this, 1.0D, false));
        this.tasks.addTask(4, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(5, new DinoAIEatBlocks(this, 1));
        this.tasks.addTask(5, new DinoAIEatFeeders(this, 1));
        this.tasks.addTask(5, new DinoAIEatItems(this, 1));
        this.tasks.addTask(6, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(7, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new DinoAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new DinoAIHunt(this, 20, false));
        this.setActualSize(1.7F, 1.0F);
        this.nearByMobsAllowed = 6;
        minSize = 1.0F;
        maxSize = 3.0F;
        teenAge = 5;
        developsResistance = true;
        breaksBlocks = true;
        this.ridingY = 1.3F;
        this.pediaScale = 45F;
        this.hasBabyTexture = false;
    }

    @Override
    public int getAttackLength() {
        return 30;
    }

    @Override
    public int getAdultAge() {
        return 12;
    }

    @Override
    public void setSpawnValues() {
    }

    @Override
    public Activity getActivityType() {

        return Activity.DIURINAL;
    }

    @Override
    public Attacking getAttackType() {

        return Attacking.TAILSWING;
    }

    @Override
    public Climbing getClimbType() {

        return Climbing.NONE;
    }

    @Override
    public Following getFollowType() {

        return Following.NONE;
    }

    @Override
    public Jumping getJumpType() {

        return Jumping.BASIC;
    }

    @Override
    public Response getResponseType() {

        return Response.TERITORIAL;
    }

    @Override
    public Stalking getStalkType() {

        return Stalking.NONE;
    }

    @Override
    public Taming getTameType() {

        return Taming.IMPRINTING;
    }

    @Override
    public Untaming getUntameType() {

        return Untaming.STARVE;
    }

    @Override
    public Moving getMoveType() {

        return Moving.WALK;
    }

    @Override
    public WaterAbility getWaterAbilityType() {

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
    public int getTailSegments() {
        return 4;
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (this.getAttackBounds().intersectsWith(entity.boundingBox)) {
            if (this.getAnimation() == NO_ANIMATION) {
                this.setAnimation(ATTACK_ANIMATION);
                return false;
            }

            if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() > 15) {
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
        return 175;
    }

    @Override
    public boolean canBeRidden() {
        return true;
    }
}
