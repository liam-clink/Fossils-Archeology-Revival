package fossilsarcheology.server.entity;

import fossilsarcheology.Revival;
import fossilsarcheology.server.enums.EnumOrderType;
import fossilsarcheology.server.enums.EnumPrehistoric;
import fossilsarcheology.server.handler.FossilAchievementHandler;
import fossilsarcheology.server.handler.LocalizationStrings;
import fossilsarcheology.server.item.FAItemRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import io.netty.buffer.ByteBuf;
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

public class EntityDinosaurEgg extends EntityLiving implements IEntityAdditionalSpawnData {
	public static final int HATCHING_INDEX = 20;
	public static int lastBirthTick;
	public final int totalHatchTime;
	public EnumPrehistoric selfType;
	public String parentOwner;
	private int hatchTime;

	public EntityDinosaurEgg(World world, EnumPrehistoric prehistoric) {
		super(world);
		this.parentOwner = "";
		this.totalHatchTime = this.hatchTime;
		this.preventEntitySpawning = true;
		this.setSize(0.5F, 0.6F);
		this.selfType = prehistoric;
		lastBirthTick = 0;
	}

	@Override
	protected boolean canDespawn() {
		return false;
	}
	
	public EntityDinosaurEgg(World world) {
		this(world, EnumPrehistoric.Triceratops);
	}

	protected void entityInit() {
		super.entityInit();
		if (Revival.enableDebugging()) {
			this.hatchTime = 1000;
		} else {
			this.hatchTime = 3000;
		}
		this.dataWatcher.addObject(HATCHING_INDEX, 0);
	}

	public EntityDinosaurEgg(World world, EnumPrehistoric prehistoric, EntityPrehistoric entity) {
		this(world, prehistoric);
		this.parentOwner = entity.getCommandSenderName();
	}

	protected boolean isAIEnabled() {
		return true;
	}

	public EntityDinosaurEgg(World world, double x, double y, double z, EnumPrehistoric prehistoric) {
		this(world, prehistoric);
		this.setPosition(x, y, z);
		this.motionX = 0.0D;
		this.motionY = 0.0D;
		this.motionZ = 0.0D;
		this.prevPosX = x;
		this.prevPosY = y;
		this.prevPosZ = z;
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
		this.dataWatcher.updateObject(HATCHING_INDEX, i);
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
		if ((double) brightness >= 0.5D && !this.inWater) {
			lastBirthTick = this.getBirthTick();
			this.setBirthTick(this.getBirthTick() + 1);
		} else {
			BiomeGenBase biome = this.worldObj.getBiomeGenForCoords((int) this.posX, (int) this.posZ);
			float temperature = biome.temperature;
			if ((temperature <= 0.15F && brightness < 0.5) || this.inWater) {
				this.setBirthTick(this.getBirthTick() - 1);
			}
		}
		if (this.getBirthTick() >= this.totalHatchTime) {

			Entity entity = this.selfType.invokeClass(this.worldObj);
			if (entity != null) {
				if (entity instanceof EntityPrehistoric) {
					if (player != null) {
						player.addStat(FossilAchievementHandler.firstDino, 1);
					
					}
					EntityPrehistoric prehistoricEntity = (EntityPrehistoric) entity;
					if (prehistoricEntity.type.isTameable() && player != null) {
						if (prehistoricEntity.type != EnumPrehistoric.Tyrannosaurus && prehistoricEntity.type != EnumPrehistoric.Allosaurus && prehistoricEntity.type != EnumPrehistoric.Sarcosuchus) {
							prehistoricEntity.setTamed(true);
							prehistoricEntity.func_152115_b(player.getUniqueID().toString());
							prehistoricEntity.currentOrder = EnumOrderType.WANDER;
							prehistoricEntity.setHealth((float) prehistoricEntity.baseHealth);

						}
					}
					prehistoricEntity.onSpawnWithEgg(null);
					prehistoricEntity.setAgeInDays(0);
					prehistoricEntity.updateAbilities();

				}
				for(int i = 0; i < 4; i++){
					double motionX = rand.nextGaussian() * 0.1D;
					double motionY = rand.nextGaussian() * 0.1D;
					double motionZ = rand.nextGaussian() * 0.1D;
					float f = (float) (getRNG().nextFloat() * (this.boundingBox.maxX - this.boundingBox.minX) + this.boundingBox.minX);
					float f1 = (float) (getRNG().nextFloat() * (this.boundingBox.maxY - this.boundingBox.minY) + this.boundingBox.minY);
					float f2 = (float) (getRNG().nextFloat() * (this.boundingBox.maxZ - this.boundingBox.minZ) + this.boundingBox.minZ);
					worldObj.spawnParticle("iconcrack_" + Item.getIdFromItem(this.selfType.eggItem) + "_0", f, f1, f2, motionX, motionY, motionZ);
				}
				entity.setLocationAndAngles((double) ((int) Math.floor(this.posX)), (double) ((int) Math.floor(this.posY) + 1), (double) ((int) Math.floor(this.posZ)), this.worldObj.rand.nextFloat() * 360.0F, 0.0F);
				if (this.worldObj.isRemote) {
					return;
				}
				if (this.worldObj.getCollidingBoundingBoxes(entity, ((EntityLiving) entity).boundingBox).size() == 0 && (!this.worldObj.isAnyLiquid(((EntityLiving) entity).boundingBox) || this.selfType == EnumPrehistoric.Mosasaurus || this.selfType == EnumPrehistoric.Liopleurodon)) {
					this.worldObj.spawnEntityInWorld(entity);
					if (player != null) {
						Revival.messagePlayer(StatCollector.translateToLocal(LocalizationStrings.DINOEGG_HATCHED), player);
					}
					this.setDead();
				} else {
					Revival.messagePlayer(StatCollector.translateToLocal(LocalizationStrings.DINOEGG_NOSPACE), player);
					this.setBirthTick(this.getBirthTick() - 500);
				}
			}
		}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		compound.setInteger("BirthTick", this.getBirthTick());
		compound.setInteger("DinoType", this.selfType.ordinal());
		compound.setString("ParentOwner", this.parentOwner);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		this.setBirthTick(compound.getInteger("BirthTick"));
		this.selfType = EnumPrehistoric.values()[compound.getInteger("DinoType")];
		this.parentOwner = compound.getString("ParentOwner");
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		if (damage > 0 && !this.worldObj.isRemote) {
			Item item = this.selfType.eggItem;
			ItemStack stack = new ItemStack(item, 1, 1);
			this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, stack));
			this.worldObj.playSoundAtEntity(this, "random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
			this.setDead();
		}
		return super.attackEntityFrom(source, damage);
	}

	@Override
	public boolean interact(EntityPlayer player) {
		ItemStack itemstack = player.inventory.getCurrentItem();
		if (itemstack == null) {
			Item item = this.selfType.eggItem;
			ItemStack stack = new ItemStack(item);
			if (!player.capabilities.isCreativeMode) {
				if (player.inventory.addItemStackToInventory(stack)) {
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

	@Override
	public void writeSpawnData(ByteBuf buffer) {
		buffer.writeInt(this.selfType.ordinal());
	}

	@Override
	public void readSpawnData(ByteBuf additionalData) {
		this.selfType = EnumPrehistoric.values()[additionalData.readInt()];
	}
}
