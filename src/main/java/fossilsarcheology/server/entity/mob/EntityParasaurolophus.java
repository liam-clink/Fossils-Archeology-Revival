package fossilsarcheology.server.entity.mob;

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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import fossilsarcheology.Revival;
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
import fossilsarcheology.server.enums.EnumPrehistoric;
import fossilsarcheology.server.enums.EnumPrehistoricAI.Activity;
import fossilsarcheology.server.enums.EnumPrehistoricAI.Attacking;
import fossilsarcheology.server.enums.EnumPrehistoricAI.Climbing;
import fossilsarcheology.server.enums.EnumPrehistoricAI.Following;
import fossilsarcheology.server.enums.EnumPrehistoricAI.Jumping;
import fossilsarcheology.server.enums.EnumPrehistoricAI.Moving;
import fossilsarcheology.server.enums.EnumPrehistoricAI.Response;
import fossilsarcheology.server.enums.EnumPrehistoricAI.Stalking;
import fossilsarcheology.server.enums.EnumPrehistoricAI.Taming;
import fossilsarcheology.server.enums.EnumPrehistoricAI.Untaming;
import fossilsarcheology.server.enums.EnumPrehistoricAI.WaterAbility;

public class EntityParasaurolophus extends EntityPrehistoric {

    private boolean isStanding;
    public float standProgress;

    public EntityParasaurolophus(World world) {
        super(world, EnumPrehistoric.Parasaurolophus, 2, 17, 25, 70, 0.25, 0.35);
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
        this.setActualSize(1.1F, 1.6F);
        this.nearByMobsAllowed = 6;
        minSize = 0.6F;
        maxSize = 2.5F;
        teenAge = 5;
        developsResistance = true;
        breaksBlocks = true;
        this.pediaScale = 30F;
    }

    public int getSpeakLength() {
        return 40;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(29, (byte) 0);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setBoolean("Standing", this.isStanding);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setStanding(compound.getBoolean("Standing"));

    }

    public boolean isStanding() {
        if (worldObj.isRemote) {
            boolean standing = (this.dataWatcher.getWatchableObjectByte(29) & 1) != 0;
            this.isStanding = standing;
            return standing;
        }

        return isStanding;
    }

    public void setStanding(boolean standing) {
        byte b0 = this.dataWatcher.getWatchableObjectByte(29);

        if (standing) {
            this.dataWatcher.updateObject(29, (byte) (b0 | 1));
        } else {
            this.dataWatcher.updateObject(29, (byte) (b0 & -2));
        }

        if (!worldObj.isRemote) {
            this.isStanding = standing;
        }
    }

    @Override
    public int getAttackLength() {
        return 30;
    }

    @Override
    public int getAdultAge() {
        return 13;
    }

    @Override
    public void setSpawnValues() {
    }

    @Override
    public Activity aiActivityType() {

        return Activity.DIURINAL;
    }

    @Override
    public Attacking aiAttackType() {

        return Attacking.CHARGE;
    }

    @Override
    public Climbing aiClimbType() {

        return Climbing.NONE;
    }

    @Override
    public Following aiFollowType() {

        return Following.NONE;
    }

    @Override
    public Jumping aiJumpType() {

        return Jumping.BASIC;
    }

    @Override
    public Response aiResponseType() {

        return Response.TERITORIAL;
    }

    @Override
    public Stalking aiStalkType() {

        return Stalking.NONE;
    }

    @Override
    public Taming aiTameType() {

        return Taming.IMPRINTING;
    }

    @Override
    public Untaming aiUntameType() {

        return Untaming.STARVE;
    }

    @Override
    public Moving aiMovingType() {

        return Moving.WALK;
    }

    @Override
    public WaterAbility aiWaterAbilityType() {

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

            if (this.getAnimation() == ATTACK_ANIMATION && (this.getAnimationTick() >= 12 && this.getAnimationTick() <= 14)) {
                IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.attackDamage);
                boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) iattributeinstance.getAttributeValue());
                if (entity.ridingEntity != null) {
                    if (entity.ridingEntity == this) {
                        entity.mountEntity(null);
                    }
                }
                entity.motionY += 0.1000000059604645D;
                return flag;
            }
        }
        return false;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        boolean standing = this.isStanding();
        if (standing && standProgress < 20.0F) {
            standProgress += 0.5F;
        } else if (!standing && standProgress > 0.0F) {
            standProgress -= 0.5F;
        }
        if (this.getAnimation() == ATTACK_ANIMATION && (this.getAnimationTick() >= 12 && this.getAnimationTick() <= 14) && this.getAttackTarget() != null) {
            this.attackEntityAsMob(this.getAttackTarget());
        }
        if(!this.worldObj.isRemote && !this.isMovementBlocked() && !this.isStanding() && this.getRNG().nextInt(100) == 0){
            this.setStanding(true);
        }
        if(!this.worldObj.isRemote && this.isStanding() && this.getRNG().nextInt(800) == 0){
            this.setStanding(false);
        }
    }

    public void setSleeping(boolean sleeping) {
        if(sleeping){
            this.setStanding(false);
        }
        super.setSleeping(sleeping);
    }

    public void setSitting(boolean sitting) {
        if(sitting){
            this.setStanding(false);
        }
        super.setSitting(sitting);
    }


    public int getMaxHunger() {
        return 175;
    }

    @Override
    public boolean canBeRidden() {
        return false;
    }
}
