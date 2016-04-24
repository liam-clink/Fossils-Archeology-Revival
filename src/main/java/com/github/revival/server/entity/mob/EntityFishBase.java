package com.github.revival.server.entity.mob;

import java.util.Collections;
import java.util.List;

import net.ilexiconn.llibrary.client.model.tools.ChainBuffer;
import net.minecraft.block.material.Material;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.github.revival.Revival;
import com.github.revival.server.entity.mob.test.EntityAIWaterFindTarget;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.item.FAItemRegistry;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class EntityFishBase extends EntityTameable {

	public EnumPrehistoric selfType;
	public ChunkCoordinates currentTarget;
	public double shelterX;
	public double shelterY;
	public double shelterZ;
	@SideOnly(Side.CLIENT)
	public ChainBuffer chainBuffer;

	public EntityFishBase(World par1World, EnumPrehistoric selfType) {
		super(par1World);
		this.tasks.addTask(1, new EntityAIWaterFindTarget(this, 0));
		this.tasks.addTask(2, new EntityAILookIdle(this));
		this.selfType = selfType;
		if (FMLCommonHandler.instance().getSide().isClient()) {
			this.chainBuffer = new ChainBuffer();
		}
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
	}

	private void setPedia() {
		Revival.toPedia = this;
	}

	@Override
	protected Item getDropItem() {
		return Items.fish;
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	private void swimAround() {
		if(!isInsideNautilusShell()){
			if (currentTarget != null){
				if(!isDirectPathBetweenPoints(this.getPosition(1.0F), Vec3.createVectorHelper(shelterX, shelterY, shelterZ))){
					currentTarget = null;
				}
				if (!isTargetInWater() || this.getDistance(currentTarget.posX, currentTarget.posY, currentTarget.posZ) < 1.78F){
					currentTarget = null;
				}
				swimTowardsTarget();
			}
		}
	}

	public void swimTowardsTarget()
	{
		if (currentTarget != null && isTargetInWater() && this.inWater)
		{
			double targetX = currentTarget.posX + 0.5D - posX;
			double targetY = currentTarget.posY + 1D - posY;
			double targetZ = currentTarget.posZ + 0.5D - posZ;
			motionX += (Math.signum(targetX) * 0.5D - motionX) *  0.100000000372529 * getSwimSpeed(); //0.10000000149011612D / 2;
			motionY += (Math.signum(targetY) * 0.5D - motionY) *  0.100000000372529 * getSwimSpeed();//0.10000000149011612D / 2;
			motionZ += (Math.signum(targetZ) * 0.5D - motionZ) *  0.100000000372529 * getSwimSpeed(); //0.10000000149011612D / 2;
			float angle = (float) (Math.atan2(motionZ, motionX) * 180.0D / Math.PI) - 90.0F;
			float rotation = MathHelper.wrapAngleTo180_float(angle - rotationYaw);
			moveForward = 0.5F;
			rotationYaw += rotation;
		}
	}

	protected abstract double getSwimSpeed();

	@Override
	public void onUpdate(){
		super.onUpdate();
		swimAround();
		Revival.PROXY.calculateChainBuffer(this);
		if(this.getClosestMate() != null && this.getGrowingAge() == 0 && this.getClosestMate().getGrowingAge() == 0 && !this.worldObj.isRemote){
			this.setGrowingAge(12000);
			if(this.getGrowingAge() == 12000){
				this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(this.selfType.eggItem)));
			}
			this.getClosestMate().setGrowingAge(12000);
		}
	}
	
	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData) {
		this.setGrowingAge(12000);
		return super.onSpawnWithEgg(par1EntityLivingData);
	}

	public EntityFishBase getClosestMate() {
		EntityAINearestAttackableTarget.Sorter theNearestAttackableTargetSorter = new EntityAINearestAttackableTarget.Sorter(this);
		IEntitySelector targetEntitySelector = new IEntitySelector() {
			@Override
			public boolean isEntityApplicable(Entity entity) {
				return entity instanceof EntityFishBase;
			}
		};
		List<EntityFishBase> list = worldObj.selectEntitiesWithinAABB(Entity.class, this.boundingBox.expand(2.0D, 2.0D, 2.0D), targetEntitySelector);
		Collections.sort(list, theNearestAttackableTargetSorter);

		if (list.isEmpty()) {
			return null;
		} else {
			for(EntityFishBase entity : list){
				return entity.selfType == this.selfType ? entity : null;
			}
			return null;
		}
	}
	
	public boolean isInsideNautilusShell(){
		return this instanceof EntityNautilus && ((EntityNautilus)this).isInShell();
	}

	public void moveEntityWithHeading(float x, float z){
		double d0;
		float f6;
		if (!worldObj.isRemote)
		{
			float f4;
			float f5;

			if (this.isInWater())
			{
				d0 = this.posY;
				f4 = 0.8F;
				f5 = 0.02F;

				this.moveEntity(this.motionX, this.motionY, this.motionZ);
				this.motionX *= (double)f4;
				this.motionX *= 0.900000011920929D;
				this.motionY *= 0.900000011920929D;
				this.motionZ *= 0.900000011920929D;
				this.motionZ *= (double)f4;	
			}
			else
			{
				float f2 = 0.91F;

				if (this.onGround)
				{
					f2 = this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ)).slipperiness * 0.91F;
				}

				float f3 = 0.16277136F / (f2 * f2 * f2);

				if (this.onGround)
				{
					f4 = this.getAIMoveSpeed() * f3;
				}
				else
				{
					f4 = this.jumpMovementFactor;
				}

				this.moveFlying(x, z, f4);
				f2 = 0.91F;

				if (this.onGround)
				{
					f2 = this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ)).slipperiness * 0.91F;
				}

				if (this.isOnLadder())
				{
					f5 = 0.15F;
					this.motionX = MathHelper.clamp_double(this.motionX, (double)(-f5), (double)f5);
					this.motionZ = MathHelper.clamp_double(this.motionZ, (double)(-f5), (double)f5);
					this.fallDistance = 0.0F;

					if (this.motionY < -0.15D)
					{
						this.motionY = -0.15D;
					}
				}

				this.moveEntity(this.motionX, this.motionY, this.motionZ);

				if (this.isCollidedHorizontally && this.isOnLadder())
				{
					this.motionY = 0.2D;
				}

				if (this.worldObj.isRemote && (!this.worldObj.blockExists((int)this.posX, 0, (int)this.posZ)) || !this.worldObj.getChunkFromBlockCoords((int)this.posX, (int)this.posZ).isChunkLoaded)
				{
					if (this.posY > 0.0D)
					{
						this.motionY = -0.1D;
					}
					else
					{
						this.motionY = 0.0D;
					}
				}
				else
				{
					this.motionY -= 0.08D;
				}

				this.motionY *= 0.9800000190734863D;
				this.motionX *= (double)f2;
				this.motionZ *= (double)f2;
			}
		}

		this.prevLimbSwingAmount = this.limbSwingAmount;
		d0 = this.posX - this.prevPosX;
		double d1 = this.posZ - this.prevPosZ;
		f6 = MathHelper.sqrt_double(d0 * d0 + d1 * d1) * 4.0F;

		if (f6 > 1.0F)
		{
			f6 = 1.0F;
		}

		this.limbSwingAmount += (f6 - this.limbSwingAmount) * 0.4F;
		this.limbSwing += this.limbSwingAmount;
	}

	protected boolean isTargetInWater(){
		return currentTarget == null ? false : worldObj.getBlock(currentTarget.posX, currentTarget.posY, currentTarget.posZ).getMaterial() == Material.water && worldObj.getBlock(currentTarget.posX, currentTarget.posY + 1, currentTarget.posZ).getMaterial() == Material.water;
	}

	@Override
	public boolean interact(EntityPlayer var1) {

		if(this.isInsideNautilusShell()){
			this.playSound("random.break", 1, this.getRNG().nextFloat() + 0.8F);
			return true;
		}

		ItemStack var2 = var1.inventory.getCurrentItem();

		if (var2 != null && FMLCommonHandler.instance().getSide().isClient() && var2.getItem() == FAItemRegistry.INSTANCE.dinoPedia) {
			this.setPedia();
			var1.openGui(Revival.INSTANCE, 4, this.worldObj, (int) this.posX, (int) this.posY, (int) this.posZ);
			return true;
		}

		if (var2 == null) {
			ItemStack var3 = new ItemStack(this.selfType.fishItem, 1);

			if (var1.inventory.addItemStackToInventory(var3)) {
				if (!this.worldObj.isRemote) {
					this.worldObj.playSoundAtEntity(var1, "random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
					this.setDead();
				}

				return true;
			}
		}

		return super.interact(var1);
	}

	public boolean canBreatheUnderwater()
	{
		return true;
	}

	public boolean getCanSpawnHere()
	{
		return this.worldObj.checkNoEntityCollision(this.boundingBox);
	}

	public int getTalkInterval()
	{
		return 120;
	}

	protected boolean canDespawn()
	{
		return true;
	}

	protected int getExperiencePoints(EntityPlayer player)
	{
		return 1 + this.worldObj.rand.nextInt(3);
	}

	public void onEntityUpdate()
	{
		int i = this.getAir();
		super.onEntityUpdate();
		if(!this.isInsideNautilusShell()){
			if (this.isEntityAlive() && !this.isInWater())
			{
				--i;
				this.setAir(i);

				if (this.getAir() == -20)
				{
					this.setAir(0);
					this.attackEntityFrom(DamageSource.drown, 2.0F);
				}
			}
			else
			{
				this.setAir(300);
			}
		}
	}

	public EntityAgeable createChild(EntityAgeable entity){
		return null;
	}

	public boolean isDirectPathBetweenPoints(Vec3 vec1, Vec3 vec2)
	{
		MovingObjectPosition movingobjectposition = this.worldObj.func_147447_a(vec1, Vec3.createVectorHelper(vec2.xCoord, vec2.yCoord + (double)this.height * 0.5D, vec2.zCoord), false, true, false);
		return movingobjectposition == null || movingobjectposition.typeOfHit != MovingObjectPosition.MovingObjectType.BLOCK;
	}

	@Override
	public boolean shouldDismountInWater(Entity rider)
	{
		return false;
	}

	public abstract String getTexture();
}

