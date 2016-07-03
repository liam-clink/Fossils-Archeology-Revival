package fossilsarcheology.server.entity.mob;

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
import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.ai.DinoAIFeeder;
import fossilsarcheology.server.entity.ai.DinoAIFollowOwner;
import fossilsarcheology.server.entity.ai.DinoAIHunt;
import fossilsarcheology.server.entity.ai.DinoAILeapAtTarget;
import fossilsarcheology.server.entity.ai.DinoAILookIdle;
import fossilsarcheology.server.entity.ai.DinoAIWander;
import fossilsarcheology.server.entity.ai.DinoAIWatchClosest;
import fossilsarcheology.server.enums.EnumPrehistoric;
import fossilsarcheology.server.enums.EnumPrehistoricAI;

public class EntityCompsognathus extends EntityPrehistoric {

    public EntityCompsognathus(World world) {
        super(world, EnumPrehistoric.Compsognathus, 1, 1, 4, 12, 0.25, 0.4);
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().setCanSwim(true);
        this.getNavigator().setAvoidSun(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(4, new DinoAILeapAtTarget(this));
        this.tasks.addTask(5, new EntityAIRestrictSun(this));
        this.tasks.addTask(6, new EntityAIFleeSun(this, 1.0D));
        this.tasks.addTask(7, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(8, new DinoAIFeeder(this, 16));
        this.tasks.addTask(9, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(10, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(10, new DinoAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new DinoAIHunt(this, 200, false));
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
    public EnumPrehistoricAI.Activity aiActivityType() {

        return EnumPrehistoricAI.Activity.NOCTURNAL;
    }

    @Override
    public EnumPrehistoricAI.Attacking aiAttackType() {

        return EnumPrehistoricAI.Attacking.BASIC;
    }

    @Override
    public EnumPrehistoricAI.Climbing aiClimbType() {

        return EnumPrehistoricAI.Climbing.NONE;
    }

    @Override
    public EnumPrehistoricAI.Following aiFollowType() {

        return EnumPrehistoricAI.Following.AGRESSIVE;
    }

    @Override
    public EnumPrehistoricAI.Jumping aiJumpType() {

        return EnumPrehistoricAI.Jumping.TWOBLOCKS;
    }

    @Override
    public EnumPrehistoricAI.Response aiResponseType() {

        return EnumPrehistoricAI.Response.SCARED;
    }

    @Override
    public EnumPrehistoricAI.Stalking aiStalkType() {

        return EnumPrehistoricAI.Stalking.STEALTH;
    }

    @Override
    public EnumPrehistoricAI.Taming aiTameType() {

        return EnumPrehistoricAI.Taming.FEEDING;
    }

    @Override
    public EnumPrehistoricAI.Untaming aiUntameType() {

        return EnumPrehistoricAI.Untaming.ATTACK;
    }

    @Override
    public EnumPrehistoricAI.Moving aiMovingType() {

        return EnumPrehistoricAI.Moving.WALK;
    }

    @Override
    public EnumPrehistoricAI.WaterAbility aiWaterAbilityType() {

        return EnumPrehistoricAI.WaterAbility.NONE;
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
            this.motionX += d0 / (double) f * 0.4D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
            this.motionZ += d1 / (double) f * 0.4D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
            this.getLookHelper().setLookPositionWithEntity(this.getAttackTarget(), 10, 12);
            this.motionY = 0.3;
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
