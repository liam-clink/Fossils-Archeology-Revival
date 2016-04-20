package com.github.revival.server.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import com.github.revival.Revival;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.server.enums.EnumOrderType;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.handler.FossilAchievementHandler;
import com.github.revival.server.handler.LocalizationStrings;
import com.github.revival.server.item.FAItemRegistry;

import cpw.mods.fml.common.FMLCommonHandler;

public class EntityDinoEgg extends EntityLiving{
	public static final int HATCHING_INDEX = 20;
	public static int lastBirthTick;
	public final int HatchingNeedTime;
	public EnumPrehistoric selfType;
	public String ParentOwner;
	private int HatchTime;

	public EntityDinoEgg(World var1, EnumPrehistoric var12) {
		super(var1);
		this.ParentOwner = "";
		this.HatchingNeedTime = this.HatchTime;
		this.preventEntitySpawning = true;
		this.setSize(0.5F, 0.6F);
		this.yOffset = this.height + 0.5F;
		this.selfType = var12;
		lastBirthTick = 0;

	}

	public EntityDinoEgg(World var1) {
		this(var1, EnumPrehistoric.Triceratops);
	}

	protected void entityInit(){
		super.entityInit();
		if (Revival.enableDebugging()) {
			this.HatchTime = 1000;
		} else {
			this.HatchTime = 3000;
		}
		this.dataWatcher.addObject(HATCHING_INDEX, new Integer(0));
	}

	public EntityDinoEgg(World var1, EnumPrehistoric var2, EntityNewPrehistoric var3) {
		this(var1, var2);
		this.ParentOwner = var3.getCommandSenderName();
	}

	protected boolean isAIEnabled(){
		return true;
	}

	public EntityDinoEgg(World var1, double var2, double var4, double var6, EnumPrehistoric var8) {
		this(var1, var8);
		this.setPosition(var2, var4 + (double) this.yOffset, var6);
		this.motionX = 0.0D;
		this.motionY = 0.0D;
		this.motionZ = 0.0D;
		this.prevPosX = var2;
		this.prevPosY = var4;
		this.prevPosZ = var6;
	}

	public String getTexture() {
		return "fossil:textures/model/egg/" + selfType.name() + "_Egg.png";

	}

	private void setPedia() {
		Revival.toPedia = this;
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	public int getBirthTick() {
		return this.dataWatcher.getWatchableObjectInt(HATCHING_INDEX);
	}

	public void setBirthTick(int i) {
		this.dataWatcher.updateObject(HATCHING_INDEX, Integer.valueOf(i));
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity entity) {
		return this.boundingBox;
	}

	@Override
	public AxisAlignedBB getBoundingBox() {
		return this.boundingBox;
	}

	@Override
	public boolean canBePushed() {
		return true;
	}

	@Override
	public boolean canBeCollidedWith() {
		return !this.isDead;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		this.tickHatching();
	}

	private void tickHatching() {
		float brightness = this.getBrightness(1.0F);
		EntityPlayer player = this.worldObj.getClosestPlayerToEntity(this, 16.0D);
		if (this.selfType == EnumPrehistoric.Mosasaurus || this.selfType == EnumPrehistoric.Liopleurodon) {
			if (this.inWater) {
				lastBirthTick = this.getBirthTick();
				this.setBirthTick(this.getBirthTick() + 1);

			} else {
				this.setBirthTick(this.getBirthTick() - 1);
			}

		} else if ((double) brightness >= 0.5D && !this.inWater) {
			lastBirthTick = this.getBirthTick();
			this.setBirthTick(this.getBirthTick() + 1);

		} else {
			BiomeGenBase var5 = this.worldObj.getBiomeGenForCoords((int) this.posX, (int) this.posZ);
			float var6 = var5.temperature;
			if ((var6 <= 0.15F && brightness < 0.5) || this.inWater) {
				this.setBirthTick(this.getBirthTick() - 1);
			}
		}

		if (this.getBirthTick() >= this.HatchingNeedTime) {
			if (this.worldObj.isRemote) {
				return;
			}

			BiomeGenBase var3 = this.worldObj.provider.worldChunkMgr.getBiomeGenAt((int) Math.floor(this.posX), (int) Math.floor(this.posZ));
			Object var5 = this.selfType.invokeClass(this.worldObj);
			if(var5 != null){

				if (var5 instanceof EntityNewPrehistoric) {
					if (player != null) {
						player.addStat(FossilAchievementHandler.firstDino, 1);
					}
					if (((EntityNewPrehistoric) var5).selfType.isTameable() && player != null) {
						if (((EntityNewPrehistoric) var5).selfType != EnumPrehistoric.Tyrannosaurus && ((EntityNewPrehistoric) var5).selfType != EnumPrehistoric.Allosaurus && ((EntityNewPrehistoric) var5).selfType != EnumPrehistoric.Sarcosuchus) {
							((EntityNewPrehistoric) var5).setTamed(true);
							((EntityNewPrehistoric) var5).setOwner(player.getUniqueID().toString());
							((EntityNewPrehistoric) var5).setOwnerDisplayName(player.getCommandSenderName());
							((EntityNewPrehistoric) var5).currentOrder = EnumOrderType.FOLLOW;
						}
					}
				}

				((EntityLiving) var5).setLocationAndAngles((double) ((int) Math.floor(this.posX)), (double) ((int) Math.floor(this.posY) + 1), (double) ((int) Math.floor(this.posZ)), this.worldObj.rand.nextFloat() * 360.0F, 0.0F);

				if (this.worldObj.checkNoEntityCollision(((EntityLiving) var5).boundingBox)
						&& this.worldObj.getCollidingBoundingBoxes((Entity) var5, ((EntityLiving) var5).boundingBox).size() == 0
						&& (!this.worldObj.isAnyLiquid(((EntityLiving) var5).boundingBox)
								|| this.selfType == EnumPrehistoric.Mosasaurus || this.selfType == EnumPrehistoric.Liopleurodon)) {
					//if (!this.worldObj.isRemote)
					{
						this.worldObj.spawnEntityInWorld((Entity) var5);

						if (player != null) {
							Revival.showMessage(StatCollector.translateToLocal(LocalizationStrings.DINOEGG_HATCHED), player);
						}
					}
					this.setDead();
				} else {
					//System.err.println("EGGERROR-NOPLACE");
					Revival.showMessage(StatCollector.translateToLocal(LocalizationStrings.DINOEGG_NOSPACE), player);
					this.setBirthTick(this.getBirthTick() - 500);
					//System.err.println("EGGERROR3"+String.valueOf(i));
				}
			}
		}
	}


	@Override
	public void writeEntityToNBT(NBTTagCompound var1) {
		var1.setInteger("BirthTick", this.getBirthTick());
		var1.setInteger("DinoType", this.EnumToInt(this.selfType));
		var1.setString("ParentOwner", this.ParentOwner);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound var1) {
		EnumPrehistoric[] var2 = EnumPrehistoric.values();
		this.setBirthTick(var1.getInteger("BirthTick"));
		this.selfType = var2[var1.getInteger("DinoType")];
		this.ParentOwner = var1.getString("ParentOwner");
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float f)
	{
		if(f > 0 && !this.worldObj.isRemote){
			Item i0 = this.selfType.eggItem;
			ItemStack var3 = new ItemStack(i0, 1, 1);
			this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, var3));
			this.worldObj.playSoundAtEntity(this, "random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
			this.setDead();
		}
		return super.attackEntityFrom(source, f);
	}

	@Override
	public boolean interact(EntityPlayer player) {
		ItemStack itemstack = player.inventory.getCurrentItem();

		if (itemstack == null) {
			Item i0 = this.selfType.eggItem;
			ItemStack var3 = new ItemStack(i0);
			if(!player.capabilities.isCreativeMode){
				if (player.inventory.addItemStackToInventory(var3)) {
					this.worldObj.playSoundAtEntity(player, "random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
				}
			}
			this.setDead();

			return true;
		} else if (FMLCommonHandler.instance().getSide().isClient() && itemstack.getItem() == FAItemRegistry.INSTANCE.dinoPedia) {
			this.setPedia();
			player.openGui(Revival.INSTANCE, 4, worldObj, (int) posX, (int) posY, (int) posZ);
			return true;
		}

		return false;
	}

	private int EnumToInt(EnumPrehistoric var1) {
		return this.selfType.ordinal();
	}
}
