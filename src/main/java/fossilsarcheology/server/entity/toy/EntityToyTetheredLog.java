package fossilsarcheology.server.entity.toy;

import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.EntityToyBase;
import fossilsarcheology.server.item.FAItemRegistry;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityToyTetheredLog extends EntityToyBase implements IAnimatedEntity {

    private Animation currentAnimation;
    private int animTick;
    public static Animation KNOCKBACK_ANIMATION = Animation.create(20);

    public EntityToyTetheredLog(World world) {
	super(world, 30);
	this.setSize(0.6F, 1.9375F);
    }

    @Override
    public void onUpdate() {
	super.onUpdate();
	AnimationHandler.INSTANCE.updateAnimations(this);

	this.motionX *= 0;
	this.motionY *= 0;
	this.motionZ *= 0;
	if (!isAttachedToBlock()) {
	    if (!this.worldObj.isRemote)
		this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, this.getItem()));
	    this.setDead();
	    this.playSound(getAttackNoise(), 1, 1);
	}
    }

    public boolean isAttachedToBlock() {
	int blockX = MathHelper.floor_double(this.posX);
	int blockY = MathHelper.floor_double(this.posY) + 2;
	int blockZ = MathHelper.floor_double(this.posZ);
	return !this.worldObj.isAirBlock(blockX, blockY, blockZ);
    }

    public AxisAlignedBB getCollisionBox(Entity entity) {
	return this.boundingBox;
    }

    @Override
    public AxisAlignedBB getBoundingBox() {
	return this.boundingBox;
    }

    @Override
    public boolean canBePushed() {
	return false;
    }

    @Override
    public boolean canBeCollidedWith() {
	return !this.isDead;
    }

    public boolean attackEntityFrom(DamageSource dmg, float f) {
	if (dmg.getEntity() != null)
	    this.rotationYaw = dmg.getEntity().rotationYaw;
	if (this.getAnimation() == NO_ANIMATION && !worldObj.isRemote) {
	    this.setAnimation(KNOCKBACK_ANIMATION);
	}
	return super.attackEntityFrom(dmg, f);
    }

    @Override
    protected void applyEntityAttributes() {
	super.applyEntityAttributes();
	getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0);
	getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1);
    }

    @Override
    protected ItemStack getItem() {
	return new ItemStack(FAItemRegistry.INSTANCE.toyTetheredLog);
    }

    @Override
    protected String getAttackNoise() {
	return "dig.wood";
    }

    @Override
    public int getAnimationTick() {
	return animTick;
    }

    @Override
    public void setAnimationTick(int tick) {
	animTick = tick;
    }

    @Override
    public Animation getAnimation() {
	return currentAnimation;
    }

    @Override
    public void setAnimation(Animation animation) {
	currentAnimation = animation;
    }

    @Override
    public Animation[] getAnimations() {
	return new Animation[] { KNOCKBACK_ANIMATION };
    }

    protected void collideWithEntity(Entity entity) {
	if (entity instanceof EntityPrehistoric && ((EntityPrehistoric) entity).ticksTillPlay == 0) {
	    ((EntityPrehistoric) entity).doPlayBonus(toyBonus);
	    if (this.getAnimation() != KNOCKBACK_ANIMATION) {
		this.setAnimation(KNOCKBACK_ANIMATION);
	    }
	    if (getAttackNoise() != null) {
		this.playSound(getAttackNoise(), 1, this.getSoundPitch());
	    }
	}
    }

    protected float getSoundPitch() {
	return super.getSoundPitch() * 0.2F;
    }

}
