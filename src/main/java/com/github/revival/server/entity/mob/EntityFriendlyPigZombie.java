package com.github.revival.server.entity.mob;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.github.revival.Revival;
import com.github.revival.server.entity.EntityMLighting;

public class EntityFriendlyPigZombie extends EntityTameable {
	private static final ItemStack defaultHeldItem = new ItemStack(Items.golden_sword, 1);

	public EntityFriendlyPigZombie(World var1) {
		super(var1);
		this.isImmuneToFire = true;
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(4, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		this.setTamed(false);
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(19, new Byte((byte)0));
	}
	
	public void onLivingUpdate(){
		super.onLivingUpdate();
	}
	
    public void onKillEntity(EntityLivingBase entity) {
    	super.onKillEntity(entity);
    	sendMessageToOwner("pigman.kill");
    }


	public void setAttackTarget(EntityLivingBase mob)
	{
		super.setAttackTarget(mob);
		if (mob == null)
		{
			this.setAngry(false);
		}
		else if (!this.isTamed())
		{
			this.setAngry(true);
		}
	}

	public void writeEntityToNBT(NBTTagCompound compound)
	{
		super.writeEntityToNBT(compound);
		compound.setBoolean("Angry", this.isAngry());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	 public void readEntityFromNBT(NBTTagCompound compound)
	{
		super.readEntityFromNBT(compound);
		this.setAngry(compound.getBoolean("Angry"));
	}

	 public boolean attackEntityFrom(DamageSource damage, float f)
	 {
		 if (this.isEntityInvulnerable())
		 {
			 return false;
		 }
		 else
		 {
			 Entity entity = damage.getEntity();
			 this.aiSit.setSitting(false);

			 if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
			 {
				 f = (f + 1.0F) / 2.0F;
			 }

			 return super.attackEntityFrom(damage, f);
		 }
	 }

	 public boolean attackEntityAsMob(Entity entity)
	 {
		 boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), 5);

		 if (flag)
		 {
			 int i = this.worldObj.difficultySetting.getDifficultyId();

			 if (this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < (float)i * 0.3F)
			 {
				 entity.setFire(2 * i);
			 }
		 }

		 return flag;
	 }

	 protected void func_145780_a(int i, int i1, int i2, Block block)
	 {
		 this.playSound("mob.zombie.step", 0.15F, 1.0F);
	 }

	 protected void applyEntityAttributes() {
		 super.applyEntityAttributes();
		 this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);

		 if (this.isTamed()) {
			 this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
		 } else {
			 this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		 }
	 }

	 public boolean isAngry()
	 {
		 return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
	 }

	 public void setAngry(boolean b)
	 {

		 byte b0 = this.dataWatcher.getWatchableObjectByte(16);

		 if (b)
		 {
			 this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 2)));
		 }
		 else
		 {
			 this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -3)));
		 }
	 }
	 
	 public void sendMessageToOwner(String words){
		 if(this.getOwner() instanceof EntityPlayer){
			 Revival.showMessage(StatCollector.translateToLocal(words), (EntityPlayer)this.getOwner());
		 }
			 
	 }

	 public boolean func_142018_a(EntityLivingBase entity, EntityLivingBase thisMobsOwner)
	 {

		 if (entity instanceof EntityWolf)
		 {
			 EntityWolf entitywolf = (EntityWolf)entity;

			 if (entitywolf.isTamed() && entitywolf.getOwner() == thisMobsOwner)
			 {
				 return false;
			 }
		 }
		 if (entity instanceof EntityFriendlyPigZombie)
		 {
			 EntityFriendlyPigZombie entitywfpz = (EntityFriendlyPigZombie)entity;

			 if (entitywfpz.isTamed() && entitywfpz.getOwner() == thisMobsOwner)
			 {
				 return false;
			 }
		 }

		 return entity instanceof EntityPlayer && thisMobsOwner instanceof EntityPlayer && !((EntityPlayer)thisMobsOwner).canAttackPlayer((EntityPlayer)entity) ? false : !(entity instanceof EntityHorse) || !((EntityHorse)entity).isTame();

	 }

	 protected boolean isAIEnabled() {
		 return true;
	 }

	 protected String getLivingSound() {
		 return "mob.zombiepig.zpig";
	 }

	 protected String getHurtSound() {
		 return "mob.zombiepig.zpighurt";
	 }

	 protected String getDeathSound() {
		 return "mob.zombiepig.zpigdeath";
	 }
	 
	 public boolean interact(EntityPlayer player)
	 {
		 if (this.func_152114_e(player) && !this.worldObj.isRemote)
		 {
			 this.aiSit.setSitting(!this.isSitting());
			 this.isJumping = false;
			 this.setPathToEntity((PathEntity)null);
			 this.setTarget((Entity)null);
			 this.setAttackTarget((EntityLivingBase)null);
			 sendMessageToOwner("pigman.sit");
			 return true;
		 }
		 return false;
	 }

	 public ItemStack getHeldItem() {
		 return defaultHeldItem;
	 }
	 @Override
	 public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		 return null;
	 }
}
