package com.github.revival.common.entity.mob.projectile;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.github.revival.common.entity.mob.EntityConfuciusornis;
import com.github.revival.common.entity.mob.EntityDodo;
import com.github.revival.common.enums.EnumPrehistoric;

public class EntityBirdEgg extends EntityThrowable
{
	EnumPrehistoric type;
	boolean cultivated;
	public Item item;

	public EntityBirdEgg(EnumPrehistoric type, boolean cultivated, World par1World, Item item)
	{
		super(par1World);
		this.type = type;
		this.cultivated = cultivated;
		this.item = item;
	}

	public EntityBirdEgg(World par1World, EntityLivingBase par2EntityLivingBase, EnumPrehistoric type, boolean cultivated, Item item)
	{
		super(par1World, par2EntityLivingBase);
		this.type = type;
		this.cultivated = cultivated;
		this.item = item;

	}


	public String getTexture()
	{

		return cultivated ? "fossil/items/prehistoric/birdEggs/Egg_" + type.toString() + ".png" : "fossil/items/prehistoric/birdEggs/Egg_Cultivated" + type.toString() + ".png";
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
	{
		if (par1MovingObjectPosition.entityHit != null)
		{
			par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0);
		}
		if(this.cultivated){
			this.spawnAnimal();

		}
		else
		{
			if (!this.worldObj.isRemote && this.rand.nextInt(8) == 0)
			{
				byte b0 = 1;

				if (this.rand.nextInt(32) == 0)
				{
					b0 = 4;
				}

				for (int i = 0; i < b0; ++i)
				{
					this.spawnAnimal();

				}
				for (int j = 0; j < 8; ++j)
				{
					this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
				}
			}
		}

		if (!this.worldObj.isRemote)
		{
			this.setDead();
		}

	}

	private void spawnAnimal()
	{
		EntityAnimal mob;
		switch(type)
		{
		case Dodo:
			mob = new EntityDodo(this.worldObj);
			break;

		case Confuciusornis:
			mob = new EntityConfuciusornis(this.worldObj);
			break;

		case Chicken:
			mob = new EntityChicken(this.worldObj);
			break;

		default:
			mob = new EntityChicken(this.worldObj);
			break;

		};
		if(!worldObj.isRemote){
			mob.setGrowingAge(-24000);
			mob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			this.worldObj.spawnEntityInWorld(mob);
		}
	}
}
