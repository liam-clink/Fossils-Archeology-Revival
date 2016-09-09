package fossilsarcheology.server.entity.mob;

import fossilsarcheology.server.entity.EntityPrehistoricSwimming;
import fossilsarcheology.server.entity.EntityToyBase;
import fossilsarcheology.server.entity.ai.DinoAIAttackOnCollide;
import fossilsarcheology.server.entity.ai.DinoAIEatFeeders;
import fossilsarcheology.server.entity.ai.DinoAIEatItems;
import fossilsarcheology.server.entity.ai.DinoAIFollowOwner;
import fossilsarcheology.server.entity.ai.DinoAIHunt;
import fossilsarcheology.server.entity.ai.DinoAILookIdle;
import fossilsarcheology.server.entity.ai.DinoAIRiding;
import fossilsarcheology.server.entity.ai.DinoAIWander;
import fossilsarcheology.server.entity.ai.DinoAIWatchClosest;
import fossilsarcheology.server.entity.ai.DinoAIWaterFindTarget;
import fossilsarcheology.server.enums.PrehistoricAI;
import fossilsarcheology.server.enums.PrehistoricEntityType;
import fossilsarcheology.server.item.FAItemRegistry;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntitySarcosuchus extends EntityPrehistoricSwimming {

    public static Animation ROLL_ANIMATION = Animation.create(115);
    private boolean isSwimming;
    public float swimProgress;

    public EntitySarcosuchus(World world) {
        super(world, PrehistoricEntityType.SARCOSUCHUS, 1, 3, 15, 70, 0.25, 0.25);
        this.setActualSize(2.0F, 1.0F);
        isAmphibious = true;
        this.getNavigator().setAvoidsWater(false);
        this.tasks.addTask(1, this.aiSit);
        this.tasks.addTask(2, new DinoAIWaterFindTarget(this, true));
        this.tasks.addTask(3, new DinoAIRiding(this, 1.0F));
        this.tasks.addTask(3, new DinoAIAttackOnCollide(this, 1.5D, false));
        this.tasks.addTask(4, new DinoAIEatFeeders(this, 1));
        this.tasks.addTask(4, new DinoAIEatItems(this, 1));
        this.tasks.addTask(5, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(6, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(7, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new DinoAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new DinoAIHunt(this, 20, false));
        minSize = 0.2F;
        maxSize = 2.3F;
        teenAge = 5;
        developsResistance = true;
        breaksBlocks = true;
        this.hasBabyTexture = true;
        this.ridingY = 1.2F;
        this.pediaScale = 30;
    }

    @Override
    public void setSpawnValues() {

    }

    @Override
    public PrehistoricAI.Activity getActivityType() {

        return PrehistoricAI.Activity.BOTH;
    }

    @Override
    public PrehistoricAI.Attacking getAttackType() {

        return PrehistoricAI.Attacking.DROWN;
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

        return PrehistoricAI.Jumping.BASIC;
    }

    @Override
    public PrehistoricAI.Response getResponseType() {

        return PrehistoricAI.Response.AGRESSIVE;
    }

    @Override
    public PrehistoricAI.Stalking getStalkType() {

        return PrehistoricAI.Stalking.NONE;
    }

    @Override
    public PrehistoricAI.Taming getTameType() {

        return PrehistoricAI.Taming.BLUEGEM;
    }

    @Override
    public PrehistoricAI.Untaming getUntameType() {

        return PrehistoricAI.Untaming.NONE;
    }

    @Override
    public PrehistoricAI.Moving getMoveType() {

        return PrehistoricAI.Moving.SEMIAQUATIC;
    }

    @Override
    public PrehistoricAI.WaterAbility getWaterAbilityType() {

        return PrehistoricAI.WaterAbility.ATTACK;
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
    public int getAdultAge() {
        return 12;
    }

    public int getMaxHunger() {
        return 150;
    }

    @Override
    protected double getSwimSpeed() {
        return 2;
    }

    @Override
    public void updateRiderPosition() {
        if (this.getRidingPlayer() != null && this.isOwnerName(this.getRidingPlayer())) {
            super.updateRiderPosition();
            return;
        }
        if (this.riddenByEntity != null && riddenByEntity instanceof EntityLivingBase && !this.isOwnerName(((EntityLivingBase) this.riddenByEntity))) {
            if (this.getAnimationTick() % 20 == 0 && this.riddenByEntity != null) {
                this.riddenByEntity.attackEntityFrom(DamageSource.drown, 10);

                if (riddenByEntity instanceof EntityToyBase) {
                    ((EntityToyBase) riddenByEntity).dismountEntity(this);
                }
                if (riddenByEntity.isDead) {
                    this.onKillEntity((EntityLivingBase) this.riddenByEntity);
                }
            }
            riddenByEntity.setPosition(this.posX, this.posY + this.getMountedYOffset() + riddenByEntity.getYOffset(), this.posZ);
            this.rotationYaw *= 0;
            riddenByEntity.rotationYaw = this.rotationYaw + this.rotationYawHead + 180;
            rotationYaw = renderYawOffset;
            float radius = -0.7F * (0.7F * getAgeScale()) * -3;
            float angle = (0.01745329251F * this.renderYawOffset) + 3.15F * 0.05F;
            double extraX = (double) (radius * MathHelper.sin((float) (Math.PI + angle)));
            double extraZ = (double) (radius * MathHelper.cos(angle));
            double extraY = 0.5F * getAgeScale();
            riddenByEntity.setPosition(this.posX + extraX, this.posY + extraY, this.posZ + extraZ);
        }
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        boolean swimming = this.isSwimming();
        if (swimming && swimProgress < 20.0F) {
            swimProgress += 0.5F;
            if (sitProgress != 0)
                sitProgress = sleepProgress = 0F;
        } else if (!swimming && swimProgress > 0.0F) {
            swimProgress -= 0.5F;
            if (sitProgress != 0)
                sitProgress = sleepProgress = 0F;
        }
        if (this.isSwimming() && (this.isSitting() || this.isSleeping())) {
            this.setSitting(false);
            this.setSleeping(false);
        }
        if (this.getAttackTarget() != null) {
            if (getAttackBounds().intersectsWith(this.getAttackTarget().boundingBox)) {
                if (!this.isInWater()) {
                    if (this.getAnimation() != attackAnimation) {
                        this.setAnimation(attackAnimation);
                    }
                    if (this.getAnimation() == attackAnimation && this.getAnimationTick() > 5) {
                        this.getAttackTarget().attackEntityFrom(DamageSource.causeMobDamage(this), (float) this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).getAttributeValue());
                    }
                    this.attackEntityAsMob(this.getAttackTarget());
                } else {
                    this.getAttackTarget().mountEntity(this);
                    if (this.getAnimation() != ROLL_ANIMATION) {
                        this.setAnimation(ROLL_ANIMATION);
                    }
                }
            }
        }
        if (this.isInWaterMaterial()) {
            this.setSwimming(true);
        } else {
            this.setSwimming(false);
        }
    }

    public int getAttackLength() {
        return 15;
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (this.isInWater()) {
            return false;
        }
        return true;
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[] { speakAnimation, attackAnimation, ROLL_ANIMATION };
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(29, (byte) 0);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setBoolean("Swimming", this.isSwimming);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setSwimming(compound.getBoolean("Swimming"));

    }

    public boolean isSwimming() {
        if (worldObj.isRemote) {
            boolean isSwimming = (this.dataManager.getWatchableObjectByte(29) & 1) != 0;
            this.isSwimming = isSwimming;
            return isSwimming;
        }

        return isSwimming;
    }

    public void setSwimming(boolean swimming) {
        byte b0 = this.dataManager.getWatchableObjectByte(29);

        if (swimming) {
            this.dataManager.updateObject(29, (byte) (b0 | 1));
        } else {
            this.dataManager.updateObject(29, (byte) (b0 & -2));
        }

        if (!worldObj.isRemote) {
            this.isSwimming = swimming;
        }
    }

    @Override
    protected String getLivingSound() {
        return this.isChild() ? "fossil:sarcosuchus_baby_living" : "fossil:sarcosuchus_living";
    }

    @Override
    public boolean canBeRidden() {
        return true;
    }
}
