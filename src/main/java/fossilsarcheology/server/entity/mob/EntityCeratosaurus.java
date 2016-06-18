package fossilsarcheology.server.entity.mob;

import fossilsarcheology.server.entity.ai.DinoAIAttackOnCollide;
import fossilsarcheology.server.entity.ai.DinoAIAvoidEntity;
import fossilsarcheology.server.entity.ai.DinoAIFollowOwner;
import fossilsarcheology.server.entity.ai.DinoAIHunt;
import fossilsarcheology.server.entity.ai.DinoAILookIdle;
import fossilsarcheology.server.entity.ai.DinoAIRiding;
import fossilsarcheology.server.entity.ai.DinoAIWander;
import fossilsarcheology.server.entity.ai.DinoAIWatchClosest;
import fossilsarcheology.server.entity.mob.test.DinoAIFeeder;
import fossilsarcheology.server.entity.mob.test.EntityNewPrehistoric;
import fossilsarcheology.server.enums.EnumPrehistoric;

import fossilsarcheology.server.enums.EnumPrehistoricAI;
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
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityCeratosaurus extends EntityNewPrehistoric {

    public EntityCeratosaurus(World world) {
        super(world, EnumPrehistoric.Ceratosaurus, 1, 10, 8, 50, 0.35, 0.5);
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().setCanSwim(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new DinoAIRiding(this, 1.0F));
        this.tasks.addTask(3, new DinoAIAvoidEntity(this, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(4, new DinoAIAttackOnCollide(this, 1.5D, false));
        this.tasks.addTask(5, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(6, new DinoAIFeeder(this, 16));
        this.tasks.addTask(7, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(8, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new DinoAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new DinoAIHunt(this, 200, false));
        this.setSize(1.55F, 1.3F);
        this.pediaScale = 7F;
        this.nearByMobsAllowed = 5;
        minSize = 0.4F;
        maxSize = 1.9F;
        teenAge = 5;
        developsResistance = true;
        breaksBlocks = true;
		this.ridingY = 1.8F;
    }

    @Override
    public int getAttackLength() {
        return 30;
    }

    @Override
    public void setSpawnValues() {
    }

    @Override
    public EnumPrehistoricAI.Activity aiActivityType() {
        return EnumPrehistoricAI.Activity.DIURINAL;
    }

    @Override
    public EnumPrehistoricAI.Attacking aiAttackType() {

        return EnumPrehistoricAI.Attacking.GRAB;
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

        return EnumPrehistoricAI.Jumping.BASIC;
    }

    @Override
    public EnumPrehistoricAI.Response aiResponseType() {

        return EnumPrehistoricAI.Response.AGRESSIVE;
    }

    @Override
    public EnumPrehistoricAI.Stalking aiStalkType() {

        return EnumPrehistoricAI.Stalking.NONE;
    }

    @Override
    public EnumPrehistoricAI.Taming aiTameType() {

        return EnumPrehistoricAI.Taming.IMPRINTING;
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
        return 10;
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

    public int getMaxHunger() {
        return 100;
    }
    
	@Override
	public boolean canBeRidden() {
		return true;
	}
}
