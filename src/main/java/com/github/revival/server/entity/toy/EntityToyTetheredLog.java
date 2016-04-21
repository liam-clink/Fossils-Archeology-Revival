package com.github.revival.server.entity.toy;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.server.entity.mob.test.EntityToyBase;
import com.github.revival.server.item.FAItemRegistry;

public class EntityToyTetheredLog extends EntityToyBase implements IAnimatedEntity{

	private Animation currentAnimation;
	private int animTick;
	public static Animation KNOCKBACK_ANIMATION = Animation.create(20);

	public EntityToyTetheredLog(World world) {
	    super(world, 30);
		this.setSize(0.6F, 1.9375F);
    }

	@Override
	public void onUpdate(){
		super.onUpdate();
		AnimationHandler.INSTANCE.updateAnimations(this);
		this.motionX *= 0;
		this.motionY *= 0;
		this.motionZ *= 0;
		if(getBlockUp().isOpaqueCube()){
			if(!this.worldObj.isRemote)this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, this.getItem()));
			this.setDead();
			this.playSound(getAttackNoise(), 1, 1);
		}
	}
	
	public Block getBlockUp()
	{
		int blockX = MathHelper.floor_double(this.posX);
		int blockY = MathHelper.floor_double(this.boundingBox.maxX - 1);
		int blockZ = MathHelper.floor_double(this.posZ);
		return this.worldObj.getBlock(blockX, blockY, blockZ);
	}

	
	public boolean attackEntityFrom(DamageSource dmg, float f)
    {
		if(dmg.getEntity() != null){
			if(dmg.getEntity() instanceof EntityPlayer){
				if(!this.worldObj.isRemote)this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, this.getItem()));
				this.setDead();
				this.playSound(getAttackNoise(), 1, 1);
				return true;
			}
			if(dmg.getEntity() instanceof EntityNewPrehistoric){
				((EntityNewPrehistoric)dmg.getEntity()).doPlayBonus(toyBonus);
				if (this.getAnimation() == NO_ANIMATION && !worldObj.isRemote) {
					this.setAnimation(KNOCKBACK_ANIMATION);
				}
				if(getAttackNoise() != null){
					this.playSound(getAttackNoise(), 1, 1);
				}
			}
		}
		return dmg != DamageSource.outOfWorld;
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
		return new Animation[]{KNOCKBACK_ANIMATION};
    }

}
