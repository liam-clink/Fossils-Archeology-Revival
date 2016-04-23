package com.github.revival.server.entity.mob.test;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class EntityToyBase extends EntityLiving{

	public int toyBonus;

	public EntityToyBase(World world, int toyBonus) {
		super(world);
		this.toyBonus = toyBonus;

	}

	protected boolean isAIEnabled(){
		return true;
	}

	public boolean attackEntityFrom(DamageSource dmg, float f)
	{
		if(dmg.getEntity() != null){
			if(dmg.getEntity() instanceof EntityPlayer){
				this.playSound(getAttackNoise(), 1, this.getSoundPitch());
				if(!this.worldObj.isRemote)this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, this.getItem()));
				this.setDead();
				return true;
			}
			if(dmg.getEntity() instanceof EntityNewPrehistoric){
				((EntityNewPrehistoric)dmg.getEntity()).doPlayBonus(toyBonus);
				if(getAttackNoise() != null){
					this.playSound(getAttackNoise(), 1, this.getSoundPitch());
				}
			}
		}
		return dmg != DamageSource.outOfWorld;
	}

	public boolean canBreatheUnderwater()
	{
		return true;
	}

	protected abstract ItemStack getItem();

	protected abstract String getAttackNoise();

}
