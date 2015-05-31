package mods.fossil.entity.mob;

import java.util.List;

import mods.fossil.Fossil;
import mods.fossil.client.FossilOptions;
import mods.fossil.entity.EntityMLighting;
import mods.fossil.fossilAI.AnuAIArrowAttack;
import mods.fossil.fossilAI.AnuAIAttackOnCollide;
import mods.fossil.fossilAI.AnuAIAvoidEntity;
import mods.fossil.fossilEnums.EnumPigmenSpeaks;
import mods.fossil.gens.feature.WorldGenMegaSpike;
import mods.fossil.gens.feature.WorldGenSpikesBlock;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenIceSpike;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import net.minecraft.world.gen.feature.WorldGenSpikes;

public class EntityAnu extends EntityMob implements IBossDisplayData, IRangedAttackMob{

	public int allHealth = 300;
	public int middleHealth = 200;
	public int finalHealth = 100;
	//length of song in ticks
	public int songLength = 4041;
	public int songCounter = 0;
	private AnuAIAvoidEntity aiFear = new AnuAIAvoidEntity(this, EntityPlayer.class, 5.0F, 0.8D, 1.33D);
	private AnuAIAttackOnCollide aiAttackOnCollide = new AnuAIAttackOnCollide(this, EntityPlayer.class, 1.2D, false);
	private AnuAIArrowAttack aiArrowAttack = new AnuAIArrowAttack(this, 1.0D, 20, 60, 15.0F);
	private ChunkCoordinates currentTarget;
	public boolean isFlying;

	public EntityAnu(World world) {
		super(world);
		this.setSize(1F,1.8F);
		this.getNavigator().setBreakDoors(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityLivingBase.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.tasks.addTask(4, aiFear);
		this.tasks.addTask(5, aiArrowAttack);
		this.tasks.addTask(5, aiAttackOnCollide);
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGolem.class, 0, true));

		this.isImmuneToFire = true;
		this.experienceValue = 50;	
	}
	public void setFlying(boolean state) {
		isFlying = state;
	}
	public boolean isAIEnabled()
	{
		return true;
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(300D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35D);
	}
	protected String getLivingSound()
	{
		if(this.getAttackMode() == 0){
			return "fossil:anu_living_healthy";
		}else if(this.getAttackMode() == 1){
			return "fossil:anu_living_middle";
		}
		return "fossil:anu_living_middle";
	}
	protected String getHurtSound()
	{
		return "random.break";
	}
	protected String getDeathSound()
	{
		return "mob.irongolem.death";
	}
	public boolean attackEntityFrom(DamageSource damageSource, float var2)
	{
		Entity targetEntity = damageSource.getEntity();

		AxisAlignedBB chatDistance = this.boundingBox.expand(30.0D, 30.0D, 30.0D);
		List playerList = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, chatDistance);

		if (targetEntity instanceof EntityGhast)
		{
			return false;
		}
		else
		{
			if (targetEntity instanceof EntityPlayer)
			{

				if(this.getRNG().nextInt(7) == 0){
					if (var2 != 0)
					{
						ItemStack itemstack = ((EntityPlayer)targetEntity).inventory.getCurrentItem();

						if (itemstack == null)
						{
							if (!this.worldObj.isRemote)
								Fossil.ShowMessage(StatCollector.translateToLocal("entity.fossil.PigBoss.name") + ": " 
										+ StatCollector.translateToLocal("anuSpeaker.draw"), (EntityPlayer)targetEntity);

							return super.attackEntityFrom(damageSource, var2);
						}
						else
						{
							if (itemstack.getItem() == Fossil.ancientSword)
							{

								if (!this.worldObj.isRemote)
									Fossil.ShowMessage(StatCollector.translateToLocal("entity.fossil.PigBoss.name") + ": " + 
											StatCollector.translateToLocal("anuSpeaker.mySword"), (EntityPlayer)targetEntity);

								return super.attackEntityFrom(damageSource, var2);
							}


							if (itemstack.getItem() != Fossil.ancientSword && itemstack.getItem() instanceof ItemSword)
							{

								if (!this.worldObj.isRemote)
									Fossil.ShowMessage(StatCollector.translateToLocal("entity.fossil.PigBoss.name") + ": " + 
											StatCollector.translateToLocal("anuSpeaker.draw"), (EntityPlayer)targetEntity);

								return super.attackEntityFrom(damageSource, var2);
							}

							if (damageSource.damageType == "arrow")
							{
								if (!this.worldObj.isRemote)
									Fossil.ShowMessage(StatCollector.translateToLocal("entity.fossil.PigBoss.name") + ": " + 
											StatCollector.translateToLocal("anuSpeaker.coward"), (EntityPlayer)targetEntity);

								return super.attackEntityFrom(damageSource, var2);
							}else{

							}
						}
					}
				}
			}
		}
		return super.attackEntityFrom(damageSource, var2);
	}

	public void updateAITasks(){
		if(this.getAttackMode() == 2){
			if (this.ticksExisted % 20 == 0)
			{
				this.heal(1.0F);
			}
		}
		super.updateAITasks();
	}
	protected Entity findPlayerToAttack()
	{
		EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);

		if(entityplayer != null && this.canEntityBeSeen(entityplayer)){
			if(this.getRNG().nextInt(1) == 0){
				Fossil.ShowMessage(StatCollector.translateToLocal("entity.fossil.PigBoss.name") + ": " + 
						StatCollector.translateToLocal("anuSpeaker.hello"), (EntityPlayer)entityplayer);
			}else{
				Fossil.ShowMessage(StatCollector.translateToLocal("entity.fossil.PigBoss.name") + ": " + 
						StatCollector.translateToLocal("anuSpeaker.fewBeaten"), (EntityPlayer)entityplayer);
			}

			super.findPlayerToAttack();
			return entityplayer;
		}

		return null;
	}
	public void onDeath(DamageSource dmg)
	{

		EntityAnuDead entity = new EntityAnuDead(this.worldObj);
		if(!this.worldObj.isRemote){
			entity.setLocationAndAngles(this.posX + this.getRNG().nextInt(4), this.posY, this.posZ + this.getRNG().nextInt(4), this.rotationYaw, this.rotationPitch);
			this.worldObj.spawnEntityInWorld(entity);
		}
		entity.setHealth(0F);
		Fossil.ShowMessage(
				StatCollector.translateToLocal("entity.fossil.PigBoss.name") + ": " + 
						StatCollector.translateToLocal("anuSpeaker.no"), this.worldObj.getClosestPlayerToEntity(this, 50));
		super.onDeath(dmg);
	}
	/**
	 * Called when the mob is falling. Calculates and applies fall damage.
	 */
	protected void fall(float i) {}
	/**
	 * Takes in the distance the entity has fallen this tick and whether its on the ground to update the fall distance
	 * and deal fall damage if landing on the ground.  Args: distanceFallenThisTick, onGround
	 */
	protected void updateFallState(double x, boolean y) {}


	public boolean attackEntityAsMob(Entity entity){
		if(this.getRNG().nextInt(4) == 0){
			this.worldObj.addWeatherEffect(new EntityMLighting(this.worldObj, entity.posX, entity.posY, entity.posZ));  
		}
		return super.attackEntityAsMob(entity);
	}
	public void spawnMobs(EntityLiving entity){
		if(!this.worldObj.isRemote){
			entity.setLocationAndAngles(this.posX + this.getRNG().nextInt(4), this.posY, this.posZ + this.getRNG().nextInt(4), this.rotationYaw, this.rotationPitch);
			this.worldObj.spawnEntityInWorld(entity);
			if(entity instanceof EntitySkeleton){
				((EntitySkeleton)entity).setSkeletonType(1);
				((EntitySkeleton)entity).setCurrentItemOrArmor(0, new ItemStack(Items.bow));

			}
			if(entity instanceof EntitySentryPigman){
				((EntitySentryPigman)entity).setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
			}

		}
	}
	protected void dropFewItems(boolean par1, int par2)
    {
        this.dropItem(Fossil.ancientKey, 1);
    }
	public void onLivingUpdate(){
		ISound music = PositionedSoundRecord.func_147673_a(new ResourceLocation("fossil:music.anu"));
		if(songCounter < songLength){
			songCounter++;
		}
		if(songCounter == songLength - 1){
			songCounter = 0;
		}
		if(songCounter == 1){
			Minecraft.getMinecraft().getSoundHandler().playSound(music);
		}
		if(this.isDead){
			Minecraft.getMinecraft().getSoundHandler().stopSounds();
		}
		super.onLivingUpdate();
		if (this.getAttackMode() == 1 && !this.onGround && this.motionY < 0.0D)
		{
			this.motionY *= 0.6D;
		}
		if(this.getAttackMode() == 1){
			if (!worldObj.isRemote) {
				setFlying(true);
				if (!this.checkGround()) {
					flyAround();
				} else {}
				if (getEntityToAttack() != null) {
					currentTarget = new ChunkCoordinates((int)getEntityToAttack().posX  + rand.nextInt(20) - rand.nextInt(10),(int)((int) getEntityToAttack().posY + getEntityToAttack().getEyeHeight()) + rand.nextInt(20) - rand.nextInt(10),(int) getEntityToAttack().posZ + rand.nextInt(40) - rand.nextInt(10));
					setFlying(false);
					flyTowardsTarget();
				}
			}
		}
		if(this.getHealth() < middleHealth && this.getAttackMode() != 1){
			this.setAttackMode(1);
		}
		if(this.getHealth() < finalHealth && this.getAttackMode() != 2){
			this.setAttackMode(2);

		}
		if(this.getAttackMode() == 1){

			for (int i = 0; i < 2; ++i)
			{
				this.worldObj.spawnParticle("smoke", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
			}
		}
		if(this.getAttackMode() == 2){
			for (int i = 0; i < 2; ++i)
			{
				this.worldObj.spawnParticle("dripLava", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
			}
		}
		if(this.getAttackMode() == 2){
			int spikechoice = this.getRNG().nextInt(250);
			int defensechoice = this.getRNG().nextInt(500);
			int spawnPigmenChoice = this.getRNG().nextInt(250);
			int spawnWitherChoice = this.getRNG().nextInt(350);
			int spawnBlazeChoice = this.getRNG().nextInt(300);

			if(spikechoice == 0){
				this.playSound("dig.stone", 1, 1);
				new WorldGenSpikesBlock().generate(worldObj, this.getRNG(), (int)this.posX,  (int)this.posY,  (int)this.posZ);
			}	
			if(defensechoice == 0){
				this.playSound("dig.stone", 1, 1);
				if(!worldObj.isRemote){
					this.generateDefenseHutP1((int)this.posX, (int)this.posY, (int)this.posZ);
					this.generateDefenseHutP2((int)this.posX, (int)this.posY, (int)this.posZ);
					this.generateDefenseHutP2((int)this.posX, (int)this.posY + 1, (int)this.posZ);
					this.generateDefenseHutP2((int)this.posX, (int)this.posY + 2, (int)this.posZ);
					this.generateDefenseHutP1((int)this.posX, (int)this.posY + 4, (int)this.posZ);
				}
			}	
			if(spawnPigmenChoice == 0){
				Fossil.ShowMessage(
						StatCollector.translateToLocal("entity.fossil.PigBoss.name") + ": " + 
								StatCollector.translateToLocal("anuSpeaker.trans"), this.worldObj.getClosestPlayerToEntity(this, 50));
				this.spawnMobs(new EntitySentryPigman(worldObj));
			}
			if(spawnWitherChoice == 0){
				this.spawnMobs(new EntitySkeleton(worldObj));
				Fossil.ShowMessage(
						StatCollector.translateToLocal("entity.fossil.PigBoss.name") + ": " + 
								StatCollector.translateToLocal("anuSpeaker.archers"), this.worldObj.getClosestPlayerToEntity(this, 50));
			}
			if(spawnBlazeChoice == 0){
				this.spawnMobs(new EntityBlaze(worldObj));
				Fossil.ShowMessage(
						StatCollector.translateToLocal("entity.fossil.PigBoss.name") + ": " + 
								StatCollector.translateToLocal("anuSpeaker.blaze"), this.worldObj.getClosestPlayerToEntity(this, 50));
			}
		}	
	}

	public void flyTowardsTarget() {
		if (currentTarget != null) {
			double targetX = currentTarget.posX + 0.5D - posX;
			double targetY = currentTarget.posY + 1D - posY;
			double targetZ = currentTarget.posZ + 0.5D - posZ;
			motionX += (Math.signum(targetX) * 0.5D - motionX) * 0.10000000149011612D;
			motionY += (Math.signum(targetY) * 0.699999988079071D - motionY) * 0.10000000149011612D;
			motionZ += (Math.signum(targetZ) * 0.5D - motionZ) * 0.10000000149011612D;
			float angle = (float) (Math.atan2(motionZ, motionX) * 180.0D / Math.PI) - 90.0F;
			float rotation = MathHelper.wrapAngleTo180_float(angle
					- rotationYaw);
			moveForward = 0.5F;
			rotationYaw += rotation;
		}

	}

	public void flyAround() {
		if (currentTarget != null)
			if (!worldObj.isAirBlock(currentTarget.posX, currentTarget.posY,
					currentTarget.posZ) || currentTarget.posY < 1)
				currentTarget = null;

		if (currentTarget == null
				|| rand.nextInt(30) == 0
				|| currentTarget.getDistanceSquared((int) posX, (int) posY,
						(int) posZ) < 10F)
			currentTarget = new ChunkCoordinates((int) posX + rand.nextInt(20)
					- rand.nextInt(10), (int) posY + rand.nextInt(30) - 2,
					(int) posZ + rand.nextInt(20) - rand.nextInt(10));

		flyTowardsTarget();
	}


	private void generateDefenseHutP2(int x, int y, int z) {
		this.worldObj.setBlock(x - 3, y, z, Blocks.obsidian);
		this.worldObj.setBlock(x - 3, y, z + 1, Blocks.obsidian);
		this.worldObj.setBlock(x - 3, y, z + 2, Blocks.obsidian);
		this.worldObj.setBlock(x - 3, y, z - 1, Blocks.obsidian);
		this.worldObj.setBlock(x - 3, y, z - 2, Blocks.obsidian);
		this.worldObj.setBlock(x + 3, y, z, Blocks.obsidian);
		this.worldObj.setBlock(x + 3, y, z + 1, Blocks.obsidian);
		this.worldObj.setBlock(x + 3, y, z + 2, Blocks.obsidian);
		this.worldObj.setBlock(x + 3, y, z - 1, Blocks.obsidian);
		this.worldObj.setBlock(x + 3, y, z - 2, Blocks.obsidian);
		this.worldObj.setBlock(x, y, z + 3, Blocks.obsidian);
		this.worldObj.setBlock(x + 1, y, z + 3, Blocks.obsidian);
		this.worldObj.setBlock(x + 2, y, z + 3, Blocks.obsidian);
		this.worldObj.setBlock(x - 1, y, z + 3, Blocks.obsidian);
		this.worldObj.setBlock(x - 2, y, z + 3, Blocks.obsidian);
		this.worldObj.setBlock(x, y, z - 3, Blocks.obsidian);
		this.worldObj.setBlock(x + 1, y, z - 3, Blocks.obsidian);
		this.worldObj.setBlock(x + 2, y, z - 3, Blocks.obsidian);
		this.worldObj.setBlock(x - 1, y, z - 3, Blocks.obsidian);
		this.worldObj.setBlock(x - 2, y, z - 3, Blocks.obsidian);
	}
	private void generateDefenseHutP1(int x, int y, int z) {
		this.worldObj.setBlock(x, y - 1, z, Blocks.obsidian);
		this.worldObj.setBlock(x + 1, y - 1, z, Blocks.obsidian);
		this.worldObj.setBlock(x + 2, y - 1, z, Blocks.obsidian);
		this.worldObj.setBlock(x - 1, y - 1, z, Blocks.obsidian);
		this.worldObj.setBlock(x - 2, y - 1, z, Blocks.obsidian);
		this.worldObj.setBlock(x, y - 1, z + 1, Blocks.obsidian);
		this.worldObj.setBlock(x + 1, y - 1, z + 1, Blocks.obsidian);
		this.worldObj.setBlock(x + 2, y - 1, z + 1, Blocks.obsidian);
		this.worldObj.setBlock(x - 1, y - 1, z + 1, Blocks.obsidian);
		this.worldObj.setBlock(x - 2, y - 1, z + 1, Blocks.obsidian);
		this.worldObj.setBlock(x, y - 1, z + 2, Blocks.obsidian);
		this.worldObj.setBlock(x + 1, y - 1, z + 2, Blocks.obsidian);
		this.worldObj.setBlock(x + 2, y - 1, z + 2, Blocks.obsidian);
		this.worldObj.setBlock(x - 1, y - 1, z + 2, Blocks.obsidian);
		this.worldObj.setBlock(x - 2, y - 1, z + 2, Blocks.obsidian);
		this.worldObj.setBlock(x, y - 1, z - 1, Blocks.obsidian);
		this.worldObj.setBlock(x + 1, y - 1, z - 1, Blocks.obsidian);
		this.worldObj.setBlock(x + 2, y - 1, z - 1, Blocks.obsidian);
		this.worldObj.setBlock(x - 1, y - 1, z - 1, Blocks.obsidian);
		this.worldObj.setBlock(x - 2, y - 1, z - 1, Blocks.obsidian);
		this.worldObj.setBlock(x, y - 1, z - 2, Blocks.obsidian);
		this.worldObj.setBlock(x + 1, y - 1, z - 2, Blocks.obsidian);
		this.worldObj.setBlock(x + 2, y - 1, z - 2, Blocks.obsidian);
		this.worldObj.setBlock(x - 1, y - 1, z - 2, Blocks.obsidian);
		this.worldObj.setBlock(x - 2, y - 1, z - 2, Blocks.obsidian);

	}


	public boolean checkGround() {
		if(!this.onGround){
			if (this.worldObj.isAirBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ)) {
				return true;
			} else {
				return false;
			}
		}else{
			return false;	
		}
	}
	public ItemStack getHeldItem()
	{
		return new ItemStack(Fossil.ancientSword);
	}
	public void initializeMob(){
		this.setAttackMode(0);
		this.setCurrentItemOrArmor(0, new ItemStack(Fossil.ancientSword));
		this.enchantEquipment();
		EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);

		if(entityplayer != null && this.canEntityBeSeen(entityplayer)){
			if(this.getRNG().nextInt(1) == 0){
				Fossil.ShowMessage(StatCollector.translateToLocal("entity.fossil.PigBoss.name") + ": " + 
						StatCollector.translateToLocal("anuSpeaker.hello"), (EntityPlayer)entityplayer);
			}else{
				Fossil.ShowMessage(StatCollector.translateToLocal("entity.fossil.PigBoss.name") + ": " + 
						StatCollector.translateToLocal("anuSpeaker.fewBeaten"), (EntityPlayer)entityplayer);
			}
		}
	}

	//0 == melee, 1 == flight/ranged, 2 == defense
	public int getAttackMode() 
	{ 
		return this.dataWatcher.getWatchableObjectByte(19); 
	}
	//0 == melee, 1 == flight/ranged, 2 == defense
	public void setAttackMode(int i) 
	{ 
		this.dataWatcher.updateObject(19, Byte.valueOf((byte)i)); 
	}
	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("AttackMode", this.getAttackMode());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.setAttackMode(par1NBTTagCompound.getInteger("AttackMode"));
	}
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(19, Byte.valueOf((byte)0));
	}

	protected boolean canDespawn()
	{
		return false;
	}
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData)
	{
		par1EntityLivingData = super.onSpawnWithEgg(par1EntityLivingData);
		this.initializeMob();
		return par1EntityLivingData;
	}
	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase entity ,float y) {
		double d5 = entity.posX - this.posX;
		double d6 = entity.boundingBox.minY + (double)(entity.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
		double d7 = entity.posZ - this.posZ;
		this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1008, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
		EntityLargeFireball entitylargefireball = new EntityLargeFireball(this.worldObj, this, d5, d6, d7);
		entitylargefireball.field_92057_e = 2;
		double d8 = 4.0D;
		Vec3 vec3 = this.getLook(1.0F);
		entitylargefireball.posX = this.posX + vec3.xCoord * d8;
		entitylargefireball.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
		entitylargefireball.posZ = this.posZ + vec3.zCoord * d8;
		this.worldObj.spawnEntityInWorld(entitylargefireball);
	}

}
