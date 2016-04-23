package com.github.revival.server.entity.toy;

import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.github.revival.server.entity.mob.test.EntityToyBase;
import com.github.revival.server.item.FAItemRegistry;

public class EntityToyScratchingPost extends EntityToyBase{

	public EntityToyScratchingPost(World world) {
	    super(world, 20);
    }

	@Override
    protected ItemStack getItem() {
	    return new ItemStack(FAItemRegistry.INSTANCE.toyScratchingPost);
    }

	@Override
    protected String getAttackNoise() {
	    return "dig.wood";
    }

	@Override
	public void onUpdate(){
		super.onUpdate();
		this.motionX *= 0;
		this.motionY *= 0;
		this.motionZ *= 0;
		if(!isOnBlock()){
			if(!this.worldObj.isRemote)this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, this.getItem()));
			this.setDead();
			this.playSound(getAttackNoise(), 1, 1);
		}
	}
	
	public boolean isOnBlock()
	{
		int blockX = MathHelper.floor_double(this.posX);
		int blockY = MathHelper.floor_double(this.posY) - 1;
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
	
	protected float getSoundPitch()
    {
        return super.getSoundPitch() * 0.2F;
    }
}
