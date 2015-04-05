package mods.fossil.entity.mob;

import mods.fossil.Fossil;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityFailuresaurus extends EntityMob
{
	public EntityFailuresaurus(World var1)
	{
		super(var1);
		this.setSize(0.8F, 0.8F);
		this.experienceValue = 4;
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));

	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
		this.dataWatcher.addObject(18, Byte.valueOf((byte)0));
		this.setSkin(this.worldObj.rand.nextInt(3));
	}
	protected boolean canDespawn()
	{
		return false;
	}
	public boolean allowLeashing()
    {
        return true;
    }
	public boolean isOnLadder()
	{
		return this.isBesideClimbableBlock();
	}
	public void onUpdate()
	{
		super.onUpdate();

		if (!this.worldObj.isRemote)
		{
			this.setBesideClimbableBlock(this.isCollidedHorizontally);
		}
	}
	public void setBesideClimbableBlock(boolean isClollided)
	{
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);

		if (isClollided)
		{
			b0 = (byte)(b0 | 1);
		}
		else
		{
			b0 &= -2;
		}

		this.dataWatcher.updateObject(16, Byte.valueOf(b0));
	}
	public int getSkin()
	{
		return this.dataWatcher.getWatchableObjectByte(18);
	}
	public boolean isBesideClimbableBlock()
	{
		return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}
	public void setSkin(int par1)
	{
		this.dataWatcher.updateObject(18, Byte.valueOf((byte)par1));
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("FailuresaurusSkin", this.getSkin());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.setSkin(par1NBTTagCompound.getInteger("FailuresaurusSkin"));
	}

	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	protected Item getDropItem()
	{
		return Fossil.failuresaurusFlesh;
	}

	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.posY);
		int k = MathHelper.floor_double(this.posZ);
		for (int l = 0; l < 4; ++l)
		{
			i = MathHelper.floor_double(this.posX + (double)((float)(l % 2 * 2 - 1) * 0.25F));
			j = MathHelper.floor_double(this.posY);
			k = MathHelper.floor_double(this.posZ + (double)((float)(l / 2 % 2 * 2 - 1) * 0.25F));

			if (this.worldObj.getBlock(i, j, k).getMaterial() == Material.air && Fossil.blockSlimeTrail.canPlaceBlockAt(this.worldObj, i, j, k))
			{
				this.worldObj.setBlock(i, j, k, Fossil.blockSlimeTrail);
			}
		}
	}
	protected String getLivingSound()
	{
		return "mob.zombie.say";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{
		return "mob.zombie.hurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "mob.zombie.death";
	}
	/**
	 * Causes this entity to do an upwards motion (jumping).
	 */
	protected void jump() {}

	/**
	 * Returns the texture's file path as a String.
	 */
	public String getTexture()
	{
		return "fossil:textures/mob/Failuresaurus.png";
	}
}
