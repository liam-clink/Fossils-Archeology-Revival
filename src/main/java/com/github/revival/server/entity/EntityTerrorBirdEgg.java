package com.github.revival.server.entity;

import com.github.revival.server.entity.mob.EntityTerrorBird;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityTerrorBirdEgg extends EntityThrowable {
	private int subType;
	private boolean isCultivated;

	public EntityTerrorBirdEgg(World par1World) {
		super(par1World);
	}

	public EntityTerrorBirdEgg(World world, EntityLivingBase entityLivingBase, int subType, boolean isCultivated) {
		super(world, entityLivingBase);
		this.subType = subType;
		this.isCultivated = isCultivated;
	}

	public EntityTerrorBirdEgg(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public String getTexture() {
		if (this.isCultivated) {
			return "/mods/fossil/textures/items/TerrorBird/" + "Egg_Cultivated_" + EntityTerrorBird.names[this.subType];
		}

		return "/mods/fossil/textures/items/TerrorBird/" + "Egg_" + EntityTerrorBird.names[this.subType];
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	@Override
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
		if (par1MovingObjectPosition.entityHit != null) {
			par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0);
		}

		if (!this.worldObj.isRemote) {
			if (!this.isCultivated) {
				if (this.rand.nextInt(8) == 0) {
					byte b0 = 1;

					if (this.rand.nextInt(32) == 0) {
						b0 = 4;
					}

					for (int i = 0; i < b0; ++i) {
						EntityTerrorBird entity = new EntityTerrorBird(this.worldObj);
						entity.setGrowingAge(-24000);
						entity.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
						entity.setSkin(this.subType);
						this.worldObj.spawnEntityInWorld(entity);
					}
				}
			} else {
				EntityTerrorBird entity = new EntityTerrorBird(this.worldObj);
				entity.setGrowingAge(-24000);
				entity.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
				entity.setSkin(this.subType);
				this.worldObj.spawnEntityInWorld(entity);
			}
		}

		for (int j = 0; j < 8; ++j) {
			this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
		}

		if (!this.worldObj.isRemote) {
			this.setDead();
		}
	}
}
