package fossilsarcheology.server.entity;

import fossilsarcheology.Revival;
import fossilsarcheology.api.Diet;
import fossilsarcheology.api.FoodMappings;
import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.block.entity.TileEntityFeeder;
import fossilsarcheology.server.entity.mob.EntitySpinosaurus;
import fossilsarcheology.server.entity.mob.Flock;
import fossilsarcheology.server.enums.EnumDinoBones;
import fossilsarcheology.server.enums.MobType;
import fossilsarcheology.server.enums.OrderType;
import fossilsarcheology.server.enums.PrehistoricAI;
import fossilsarcheology.server.enums.PrehistoricAI.Taming;
import fossilsarcheology.server.enums.PrehistoricEntityType;
import fossilsarcheology.server.enums.PrehistoricMood;
import fossilsarcheology.server.enums.PrehistoricSituation;
import fossilsarcheology.server.enums.TimePeriod;
import fossilsarcheology.server.handler.LocalizationStrings;
import fossilsarcheology.server.item.FAItemRegistry;
import fossilsarcheology.server.message.MessageFoodParticles;
import fossilsarcheology.server.message.MessageHappyParticles;
import fossilsarcheology.server.message.MessageSetDay;
import fossilsarcheology.server.message.MessageUpdateEgg;
import net.ilexiconn.llibrary.client.model.tools.ChainBuffer;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class EntityPrehistoric extends EntityTameable implements IPrehistoricAI, IAnimatedEntity {
    /**
     * Up to 8 flags with byte
     */
    protected static final int FLAG_SKELETON = 0;
    protected static final int FLAG_SLEEPING = 1;
    protected static final int FLAG_SITTING = 2;
    protected static final int FLAG_ANGRY = 3;
    protected static final int FLAG_GENDER = 4;
    protected static final int FLAG_CLIMBABLE_BLOCK = 5;

    private static final DataParameter<Integer> AGE = EntityDataManager.createKey(EntityPrehistoric.class, DataSerializers.VARINT);
    private static final DataParameter<String> OWNER = EntityDataManager.createKey(EntityPrehistoric.class, DataSerializers.STRING);
    private static final DataParameter<Integer> HUNGER = EntityDataManager.createKey(EntityPrehistoric.class, DataSerializers.VARINT);
    private static final DataParameter<Byte> FLAGS = EntityDataManager.createKey(EntityPrehistoric.class, DataSerializers.BYTE);
    private static final DataParameter<Integer> MOOD = EntityDataManager.createKey(EntityPrehistoric.class, DataSerializers.VARINT);

    public Animation speakAnimation;
    public Animation attackAnimation;
    public float minSize;
    public float maxSize;
    public int teenAge;
    public PrehistoricEntityType type;
    public ItemStack ItemInMouth = null;
    public OrderType currentOrder;
    public boolean hasFeatherToggle = false;
    public boolean featherToggle;
    public boolean hasTeenTexture = false;
    public boolean hasBabyTexture;
    public float weakProgress;
    public float sitProgress;
    public int ticksSitted;
    protected boolean isSitting;
    public float sleepProgress;
    public float climbProgress;
    public int ticksSlept;
    protected boolean isSleeping;
    protected boolean developsResistance;
    protected boolean breaksBlocks;
    private Animation currentAnimation;
    private int animTick;
    @SideOnly(Side.CLIENT)
    public ChainBuffer chainBuffer;
    public float pediaScale;
    public boolean mood_nospace;
    public boolean mood_noplants;
    protected int nearByMobsAllowed;
    public int ticksTillPlay;
    public int mateDelay;
    public int prevAge;
    public boolean isDaytime;
    public Flock flock;
    public double baseDamage;
    public double maxDamage;
    public double baseHealth;
    public double maxHealth;
    public double baseSpeed;
    public double maxSpeed;
    public float ridingXZ;
    public float ridingY;
    public float actualWidth;

    public EntityPrehistoric(World world, PrehistoricEntityType type, double baseDamage, double maxDamage, double baseHealth, double maxHealth, double baseSpeed, double maxSpeed) {
        super(world);
        this.setHunger(this.getMaxHunger() / 2);
        this.setScale(this.getAgeScale());
        this.speakAnimation = Animation.create(this.getSpeakLength());
        this.attackAnimation = Animation.create(this.getAttackLength());
        this.hasBabyTexture = true;
        this.type = type;
        this.pediaScale = 1.0F;
        this.nearByMobsAllowed = 15;
        this.currentOrder = OrderType.WANDER;
        if (mateDelay == 0) {
            mateDelay = this.rand.nextInt(6000) + 6000;
        }
        if (FMLCommonHandler.instance().getSide().isClient()) {
            this.chainBuffer = new ChainBuffer();
        }
        this.baseDamage = baseDamage;
        this.maxDamage = maxDamage;
        this.baseHealth = baseHealth;
        this.maxHealth = maxHealth;
        this.baseSpeed = baseSpeed;
        this.maxSpeed = maxSpeed;
        this.updateAbilities();
    }

    public boolean isCannibalistic() {
        return false;
    }

    public int getSpeakLength() {
        return 20;
    }

    public int getAttackLength() {
        return 20;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(AGE, 1);
        this.dataManager.register(OWNER, "");
        this.dataManager.register(HUNGER, 0);
        this.dataManager.register(FLAGS, (byte) 0);
        this.dataManager.register(MOOD, 0);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setInteger("AgeTick", this.getAgeInTicks());
        compound.setInteger("Hunger", this.getHunger());
        compound.setBoolean("isModelized", this.isSkeleton());
        compound.setBoolean("Angry", this.isAngry());
        compound.setInteger("Gender", this.getGender());
        compound.setBoolean("Sleeping", this.isSleeping);
        compound.setInteger("Mood", this.getMood());
        compound.setBoolean("Sitting", this.isSitting);
        compound.setBoolean("MoodNoSpace", this.mood_nospace);
        compound.setBoolean("MoodNoPlants", this.mood_noplants);
        compound.setInteger("TicksSincePlay", this.ticksTillPlay);
        compound.setInteger("TicksSinceMate", this.mateDelay);
        compound.setByte("Order", (byte) this.currentOrder.ordinal());
        compound.setString("OwnerDisplayName", this.getOwnerName());
    }

    public String getOwnerName() {
        return this.dataManager.get(OWNER);
    }

    public void setOwnerName(String name) {
        this.dataManager.set(OWNER, name);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1D);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setAgeInTicks(compound.getInteger("AgeTick"));
        this.setHunger(compound.getInteger("Hunger"));
        this.setSkeleton(compound.getBoolean("isModelized"));
        this.setAngry(compound.getBoolean("Angry"));
        this.setGender(compound.getInteger("Gender"));
        this.setSleeping(compound.getBoolean("Sleeping"));
        this.setSitting(compound.getBoolean("Sitting"));
        this.setMood(compound.getInteger("Mood"));
        this.setOrder(OrderType.values()[compound.getByte("currentOrder")]);
        this.mood_nospace = compound.getBoolean("MoodNoSpace");
        this.mood_noplants = compound.getBoolean("MoodNoPlants");
        this.ticksTillPlay = compound.getInteger("TicksSincePlay");
        this.mateDelay = compound.getInteger("TicksSinceMate");
        this.currentOrder = OrderType.values()[compound.getByte("Order")];
        String owner;
        if (compound.hasKey("Owner", 8)) {
            owner = compound.getString("Owner");
            this.setOwnerName(owner);
        } else {
            this.setOwnerName(compound.getString("OwnerDisplayName"));
        }
    }

    public AxisAlignedBB getAttackBounds() {
        return this.getEntityBoundingBox().expand(3.0F, 3.0F, 3.0F);
    }

    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
        data = super.onInitialSpawn(difficulty, data);
        Random random = new Random();
        this.setAgeInDays(this.getAdultAge());
        this.setSpawnValues();
        this.setGender(random.nextInt(2));
        this.updateAbilities();
        ticksTillPlay = 0;
        mateDelay = 24000;
        this.heal(this.getMaxHealth());
        return data;
    }

    public void setActualSize(float width, float height) {
        this.actualWidth = width;
        this.setSize(width, height);
    }

    @Override
    public boolean isAIDisabled() {
        return this.isSkeleton();
    }

    public void doPlayBonus(int playBonus) {
        ticksTillPlay = this.rand.nextInt(600) + 600;
        this.setMood(this.getMood() + playBonus);
        Revival.NETWORK_WRAPPER.sendToAll(new MessageHappyParticles(this.getEntityId()));
    }

    public abstract void setSpawnValues();

    public OrderType getOrderType() {
        return this.currentOrder;
    }

    @Override
    public boolean isMovementBlocked() {
        return this.getHealth() <= 0.0F || isSitting() || isSleeping() || this.isSkeleton() || this.isActuallyWeak();
    }

    @Override
    public boolean isSitting() {
        if (worldObj.isRemote) {
            boolean isSitting = this.getFlag(FLAG_SITTING);
            if (isSitting != this.isSitting) {
                ticksSitted = 0;
            }
            this.isSitting = isSitting;
            return isSitting;
        }
        return isSitting;
    }

    public boolean isSleeping() {
        if (worldObj.isRemote) {
            boolean isSleeping = this.getFlag(FLAG_SLEEPING);
            if (isSleeping != this.isSleeping) {
                ticksSlept = 0;
            }
            this.isSleeping = isSleeping;
            return isSleeping;
        }
        return isSleeping;
    }

    public BlockPos getBlockToEat(int range) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        range /= 2;
        for (int x = -range; x < range; x++) {
            for (int y = -5; y < 5; y++) {
                for (int z = -range; z < range; z++) {
                    if (this.posY + y >= 0 && this.posY + y <= this.worldObj.getHeight()) {
                        pos.setPos(this.posX + x, this.posY + y, this.posZ + z);
                        if (FoodMappings.INSTANCE.getBlockFoodAmount(this.worldObj.getBlockState(pos).getBlock(), type.diet) > 0) {
                            return pos;
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public boolean canBeLeashedTo(EntityPlayer player) {
        return !this.getLeashed() && !(this instanceof IMob) && this.isTamed();
    }

    public void setOrder(OrderType order) {
        this.currentOrder = order;
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    public TileEntityFeeder getFeeder(int range) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        range /= 2;
        for (int x = -range; x < range; x++) {
            for (int y = -5; y < 5; y++) {
                for (int z = -range; z < range; z++) {
                    if (this.posY + y >= 0 && this.posY + y <= this.worldObj.getHeight()) {
                        pos.setPos(this.posX + x, this.posY + y, this.posZ + z);
                        TileEntity feeder = this.worldObj.getTileEntity(pos);
                        if (feeder != null && feeder instanceof TileEntityFeeder && !((TileEntityFeeder) feeder).isEmpty(type)) {
                            return (TileEntityFeeder) feeder;
                        }
                    }
                }
            }
        }
        return null;
    }

    public float getActualWidth() {
        return this.actualWidth * this.getAgeScale();
    }

    public boolean arePlantsNearby(int range) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        range /= 2;
        for (int x = -range; x < range; x++) {
            for (int y = -5; y < 5; y++) {
                for (int z = -range; z < range; z++) {
                    if (this.posY + y >= 0 && this.posY + y <= this.worldObj.getHeight()) {
                        pos.setPos(this.posX + x, this.posY + y, this.posZ + z);
                        if (this.isPlantBlock(this.worldObj.getBlockState(pos))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean canBePushed() {
        return !this.isSkeleton() && super.canBePushed();
    }

    public BlockPos getBubbleBlock(int range) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        range /= 2;
        for (int x = -range; x < range; x++) {
            for (int y = -5; y < 5; y++) {
                for (int z = -range; z < range; z++) {
                    if (this.posY + y >= 0 && this.posY + y <= this.worldObj.getHeight()) {
                        pos.setPos(this.posX + x, this.posY + y, this.posZ + z);
                        if (this.worldObj.getBlockState(pos).getBlock() == FABlockRegistry.INSTANCE.bubbleMachine && this.worldObj.isBlockIndirectlyGettingPowered(pos) > 0) {
                            return pos;
                        }
                    }
                }
            }
        }
        return null;
    }

    public boolean isPlantBlock(IBlockState block) {
        return block.getMaterial() == Material.GRASS || block.getMaterial() == Material.PLANTS || block.getMaterial() == Material.LEAVES;
    }

    public boolean canSleep() {
        return !(!this.onGround && ticksExisted % 20 != 0) && !this.isInWater() && (this.getActivityType() == PrehistoricAI.Activity.DIURINAL && !this.isDaytime() || this.getActivityType() == PrehistoricAI.Activity.NOCTURNAL && this.isDaytime() && !this.worldObj.canBlockSeeSky(this.getPosition()) || this.getActivityType() == PrehistoricAI.Activity.BOTH);
    }

    public boolean isDaytime() {
        if (worldObj.isRemote) {
            return isDaytime;
        } else {
            Revival.NETWORK_WRAPPER.sendToAll(new MessageSetDay(this.getEntityId(), this.worldObj.isDaytime()));
            return this.worldObj.isDaytime();
        }
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.isSkeleton()) {
            this.motionX *= 0;
            this.motionY *= 0;
            this.motionZ *= 0;
        }
        if (this.getOwner() != null && this.getOwnerName().equals("")) {
            this.setOwnerName(this.getOwner().getName());
        }
        if (this.getHunger() > this.getMaxHunger()) {
            this.setHunger(this.getMaxHunger());
        }
        if (this.getMood() > 100) {
            this.setMood(100);
        }
        if (this.getMood() < -100) {
            this.setMood(-100);
        }
        if (this.ticksTillPlay > 0) {
            this.ticksTillPlay--;
        }
        if (this.mateDelay > 0) {
            this.mateDelay--;
        }
        if (this.getRidingPlayer() != null) {
            this.stepHeight = 1;
        }
        if (this.getBlockUnder() == FABlockRegistry.INSTANCE.bubbleMachine && this.worldObj.isBlockIndirectlyGettingPowered(this.getPosition().down()) > 0 && this.ticksTillPlay == 0) {
            this.jump();
            for (int i = 0; i < 1; ++i) {
                double dd = this.getRNG().nextGaussian() * 0.02D;
                double dd1 = this.getRNG().nextGaussian() * 0.02D;
                double dd2 = this.getRNG().nextGaussian() * 0.02D;
                Revival.PROXY.spawnPacketHeartParticles(this.worldObj, (float) (this.posX + (this.getRNG().nextFloat() * this.width * 2.0F) - this.width), (float) (this.posY + 0.5D + (this.getRNG().nextFloat() * this.height)), (float) (this.posZ + (this.getRNG().nextFloat() * this.width * 2.0F) - this.width), dd, dd1, dd2);
            }
            this.doPlayBonus(15);
        }
        if (mateDelay == 0 && this.getGender() == 1) {
            this.mate();
        }
        if (!this.arePlantsNearby(16) && !mood_noplants) {
            boolean inital_mood_noplants = mood_noplants;
            this.mood_noplants = true;
            if (mood_noplants != inital_mood_noplants) {
                this.setMood(this.getMood() - 50);
            }
        }
        if (this.arePlantsNearby(16)) {
            boolean inital_mood_noplants = mood_noplants;
            this.mood_noplants = false;
            if (mood_noplants != inital_mood_noplants) {
                this.setMood(this.getMood() + 50);
            }
        }

        if (this.isThereNearbyTypes() && !mood_nospace) {
            boolean inital_mood_nospace = mood_nospace;
            this.mood_nospace = true;
            if (mood_nospace != inital_mood_nospace) {
                this.setMood(this.getMood() - 50);
            }
        }
        if (!this.isThereNearbyTypes()) {
            boolean inital_mood_nospace = mood_nospace;
            this.mood_nospace = false;
            if (mood_nospace != inital_mood_nospace) {
                this.setMood(this.getMood() + 50);
            }
        }

        if (this.isSitting()) {
            ticksSitted++;
        }
        if (this.isSleeping()) {
            ticksSlept++;
        }

        if (!worldObj.isRemote && !this.isInWater() && this.getPassengers().isEmpty() && !this.isSitting() && this.getRNG().nextInt(100) == 1 && !this.isRiding() && (this.getAnimation() == NO_ANIMATION || this.getAnimation() == speakAnimation) && !this.isSleeping()) {
            this.setSitting(true);
            ticksSitted = 0;
        }

        if (!worldObj.isRemote && !this.isInWater() && (this.isSitting() && ticksSitted > 100 && this.getRNG().nextInt(100) == 1 || this.getAttackTarget() != null) && !this.isSleeping()) {
            this.setSitting(false);
            ticksSitted = 0;
        }
        if (!worldObj.isRemote && !this.isInWater() && this.getPassengers().isEmpty() && !this.isActuallyWeak() && this.canSleep() && this.getRNG().nextInt(100) == 1 && this.getAttackTarget() == null && (this.getAnimation() == NO_ANIMATION || this.getAnimation() == speakAnimation)) {
            this.setSitting(false);
            this.setSleeping(true);
            ticksSlept = 0;
        }

        if (!worldObj.isRemote && (!this.canSleep() || this.isActuallyWeak() || (this.isSleeping() && ticksSlept > 200 && this.getRNG().nextInt(1000) == 1 || this.getAttackTarget() != null || this.isInWater()))) {
            this.setSitting(false);
            this.setSleeping(false);
            ticksSlept = 0;
        }

        if (this.currentOrder == OrderType.STAY && !this.isSitting() && !this.isActuallyWeak()) {
            this.setSitting(true);
            this.setSleeping(false);
        }

        if (breaksBlocks) {
            this.breakBlock(5);
        }

        if (this.doesFlock() && flock == null) {
            if (this.getNearbyFlock() != null) {
                this.getNearbyFlock().flockMembers.add(this);
            } else {
                flock = new Flock();
                flock.createFlock(this);
            }
        }
        if (this.flock != null) {
            if (this == flock.flockLeader) {
                this.flock.onUpdate();
            }
        }
    }

    public EntityLivingBase getOwner() {
        return this.worldObj.getPlayerEntityByName(this.getOwnerName());
    }

    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }

    public Block getBlockUnder() {
        return this.worldObj.getBlockState(this.getPosition().down()).getBlock();
    }

    public EntityPrehistoric findFlockLeader(List<EntityPrehistoric> flock) {
        int index = new Random().nextInt(flock.size());
        return flock.get(index);
    }

    public EntityPlayer getRidingPlayer() {
        Entity riddenByEntity = this.getPassengers().get(0);
        if (riddenByEntity instanceof EntityPlayer) {
            return (EntityPlayer) riddenByEntity;
        } else {
            return null;
        }
    }

    public void setRidingPlayer(EntityPlayer player) {
        player.rotationYaw = this.rotationYaw;
        player.rotationPitch = this.rotationPitch;
        player.startRiding(this);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.setAgeInTicks(this.getAgeInTicks() + 1);
        if (this.getAgeInTicks() % 24000 == 0) {
            this.updateAbilities();
        }
        if (this.getAgeInTicks() % 1200 == 0 && this.getHunger() > 0) {
            this.setHunger(this.getHunger() - 1);
        }
        boolean sitting = isSitting();
        if (sitting && sitProgress < 20.0F) {
            sitProgress += 0.5F;
            if (sleepProgress != 0) {
                sleepProgress = 0F;
            }
        } else if (!sitting && sitProgress > 0.0F) {
            sitProgress -= 0.5F;
            if (sleepProgress != 0) {
                sleepProgress = 0F;
            }
        }
        boolean sleeping = isSleeping();
        if (sleeping && sleepProgress < 20.0F) {
            sleepProgress += 0.5F;
            if (sitProgress != 0) {
                sitProgress = 0F;
            }
        } else if (!sleeping && sleepProgress > 0.0F) {
            sleepProgress -= 0.5F;
            if (sitProgress != 0) {
                sitProgress = 0F;
            }
        }
        boolean climbing = this.getClimbType() == PrehistoricAI.Climbing.ARTHROPOD && (this.isBesideClimbableBlock() && !this.onGround);
        if (climbing && climbProgress < 20.0F) {
            climbProgress += 1F;
            if (sitProgress != 0) {
                sitProgress = 0F;
            }
        } else if (!climbing && climbProgress > 0.0F) {
            climbProgress -= 1F;
            if (sitProgress != 0) {
                sitProgress = 0F;
            }
        }
        boolean weak = this.isActuallyWeak();
        if (weak && weakProgress < 20.0F) {
            weakProgress += 0.5F;
            sitProgress = 0F;
            sleepProgress = 0F;
        } else if (!weak && weakProgress > 0.0F) {
            weakProgress -= 0.5F;
            sitProgress = 0F;
            sleepProgress = 0F;
        }
        if (!this.worldObj.isRemote) {
            if (this.getClimbType() == PrehistoricAI.Climbing.ARTHROPOD) {
                this.setBesideClimbableBlock(this.isCollidedHorizontally);
            } else {
                this.setBesideClimbableBlock(false);
            }
        }
        Revival.PROXY.calculateChainBuffer(this);
        AnimationHandler.INSTANCE.updateAnimations(this);
    }

    @Override
    public abstract PrehistoricAI.Activity getActivityType();

    @Override
    public abstract PrehistoricAI.Attacking getAttackType();

    @Override
    public abstract PrehistoricAI.Climbing getClimbType();

    @Override
    public abstract PrehistoricAI.Following getFollowType();

    @Override
    public abstract PrehistoricAI.Jumping getJumpType();

    @Override
    public abstract PrehistoricAI.Response getResponseType();

    @Override
    public abstract PrehistoricAI.Stalking getStalkType();

    @Override
    public abstract PrehistoricAI.Taming getTameType();

    @Override
    public abstract PrehistoricAI.Untaming getUntameType();

    @Override
    public abstract PrehistoricAI.Moving getMoveType();

    @Override
    public abstract PrehistoricAI.WaterAbility getWaterAbilityType();

    public abstract int getAdultAge();

    public abstract boolean doesFlock();

    @Override
    public boolean canAttackClass(Class clazz) {
        return this.getClass() != clazz && clazz != EntityDinosaurEgg.class;
    }

    public float getAgeScale() {
        float step = (this.maxSize - this.minSize) / ((this.getAdultAge() * 24000) + 1);
        if (this.getAgeInTicks() > this.getAdultAge() * 24000) {
            return this.minSize + ((step) * this.getAdultAge() * 24000);
        }
        return this.minSize + ((step * this.getAgeInTicks()));
    }

    @Override
    protected int getExperiencePoints(EntityPlayer par1EntityPlayer) {
        return MathHelper.floor_float(this.type.Exp0 + (float) this.getAgeInDays() * this.type.ExpInc);
    }

    public void updateAbilities() {
        double healthStep = (maxHealth - baseHealth) / (this.getAdultAge());
        double attackStep = (maxDamage - baseDamage) / (this.getAdultAge());
        double speedStep = (maxSpeed - baseSpeed) / (this.getAdultAge());
        if (this.getAgeInDays() <= this.getAdultAge()) {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(Math.round(baseHealth + (healthStep * this.getAgeInDays())));
            this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(Math.round(baseDamage + (attackStep * this.getAgeInDays())));
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(baseSpeed + (speedStep * this.getAgeInDays()));
            if (this.developsResistance) {
                if (this.isTeen()) {
                    this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.5D);
                } else if (this.isAdult()) {
                    this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(2.0D);
                } else {
                    this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.0D);
                }
            }
        }
    }

    public void breakBlock(float hardness) {
        if (Revival.CONFIG.dinoBlockBreaking) {
            if (!isSkeleton() && this.isAdult() && this.isHungry()) {
                BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
                AxisAlignedBB bounds = this.getEntityBoundingBox();
                for (int x = (int) Math.round(bounds.minX) - 1; x <= (int) Math.round(bounds.maxX) + 1; x++) {
                    for (int y = (int) Math.round(bounds.minY) + 1; (y <= (int) Math.round(bounds.maxY) + 3) && (y <= 255); y++) {
                        for (int z = (int) Math.round(bounds.minZ) - 1; z <= (int) Math.round(bounds.maxZ) + 1; z++) {
                            pos.setPos(x, y, z);
                            IBlockState state = worldObj.getBlockState(pos);
                            Block block = state.getBlock();
                            if (!(block instanceof BlockBush) && !(block instanceof BlockLiquid) && block != Blocks.BEDROCK && block != FABlockRegistry.INSTANCE.ancientGlass && block != FABlockRegistry.INSTANCE.strongGlass && state.getBlockHardness(worldObj, pos) < hardness) {
                                this.motionX *= 0.6D;
                                this.motionZ *= 0.6D;
                                if (block != Blocks.AIR) {
                                    if (!worldObj.isRemote) {
                                        worldObj.destroyBlock(pos, true);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void setScaleForAge(boolean child) {
        if (ticksExisted % 20 == 0) {
            this.setScale(this.getAgeScale());
        }
    }

    public Entity createEgg(EntityAgeable entity) {
        Entity baby = null;
        if (this.type.mobType == MobType.MAMMAL) {
            baby = this.type.invokeClass(this.worldObj);
        }
        if (this.type.mobType == MobType.BIRD) {
            baby = new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(this.type.birdEggItem));
        }
        if (this.type.mobType == MobType.DINOSAUR) {
            if (Revival.CONFIG.eggsLikeChickens) {
                baby = new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(this.type.eggItem));
            } else {
                baby = new EntityDinosaurEgg(this.worldObj, this.type);
                ((EntityDinosaurEgg) baby).selfType = this.type;
            }
        }
        return baby;
    }

    public boolean isAdult() {
        return this.getAgeInDays() >= getAdultAge();
    }

    public boolean isTeen() {
        return this.getAgeInDays() >= teenAge && this.getAgeInDays() < getAdultAge();
    }

    @Override
    public boolean isChild() {
        return this.getAgeInDays() < teenAge && !this.isSkeleton();
    }

    public abstract int getMaxHunger();

    public boolean isSkeleton() {
        return this.getFlag(FLAG_SKELETON);
    }

    public void setSkeleton(boolean skeleton) {
        this.setFlag(FLAG_SKELETON, skeleton);
    }

    public int getAgeInDays() {
        return this.dataManager.get(AGE) / 24000;
    }

    public void setAgeInDays(int days) {
        this.dataManager.set(AGE, days * 24000);
        this.updateAbilities();
    }

    public int getAgeInTicks() {
        return this.dataManager.get(AGE);
    }

    public void setAgeInTicks(int ticks) {
        this.dataManager.set(AGE, ticks);
    }

    public int getHunger() {
        return this.dataManager.get(HUNGER);
    }

    public void setHunger(int hunger) {
        this.dataManager.set(HUNGER, Math.min(this.getMaxHunger(), hunger));
    }

    public boolean increaseHunger(int hunger) {
        if (this.getHunger() >= this.getMaxHunger()) {
            return false;
        }
        this.setHunger(this.getHunger() + hunger);
        if (this.getHunger() > this.getMaxHunger()) {
            this.setHunger(this.getMaxHunger());
        }
        this.playSound(SoundEvents.ENTITY_GENERIC_EAT, this.getSoundVolume(), this.getSoundPitch());
        return true;
    }

    @Override
    public void onKillEntity(EntityLivingBase var1) {
        super.onKillEntity(var1);
        this.increaseHunger(FoodMappings.INSTANCE.getEntityFoodAmount(var1.getClass(), this.type.diet));
        this.heal(FoodMappings.INSTANCE.getEntityFoodAmount(var1.getClass(), this.type.diet) / 3);
        this.setMood(this.getMood() + 25);
    }

    public boolean isHungry() {
        return this.getHunger() < this.getMaxHunger() * 0.75F;
    }

    public boolean isDeadlyHungry() {
        return this.getHunger() < this.getMaxHunger() * 0.25F;
    }

    public void sendStatusMessage(PrehistoricSituation situation) {
        if (this.getOwner() != null && this.getDistanceToEntity(this.getOwner()) < 50.0F) {
            String statusHead = I18n.translateToLocal(("status." + situation.toString() + ".head"));
            String dinosaur = this.type.toString();
            String statusFoot = I18n.translateToLocal("status." + situation.toString());
            Revival.messagePlayer(statusHead + dinosaur + statusFoot, (EntityPlayer) this.getOwner());
        }
    }

    @Override
    public boolean isOnLadder() {
        return !(this.getMoveType() == PrehistoricAI.Moving.AQUATIC || this.getMoveType() == PrehistoricAI.Moving.SEMIAQUATIC) && this.getClimbType() == PrehistoricAI.Climbing.ARTHROPOD && this.isBesideClimbableBlock();
    }

    public boolean isAngry() {
        return this.getFlag(FLAG_ANGRY);
    }

    public void setAngry(boolean angry) {
        this.setFlag(FLAG_ANGRY, angry);
    }

    public int getGender() {
        return this.getFlag(FLAG_GENDER) ? 1 : 0;
    }

    public void setGender(int gender) {
        this.setFlag(FLAG_GENDER, gender == 1);
    }

    public void setSleeping(boolean sleeping) {
        this.setFlag(FLAG_SLEEPING, sleeping);
        if (!worldObj.isRemote) {
            this.isSleeping = sleeping;
        }
    }

    public int getMood() {
        return this.dataManager.get(MOOD);
    }

    public void setMood(int mood) {
        this.dataManager.set(MOOD, mood);
    }

    public PrehistoricMood getMoodFace() {
        if (this.getMood() == 100) {
            return PrehistoricMood.HAPPY;
        } else if (this.getMood() >= 50) {
            return PrehistoricMood.CONTENT;
        } else if (this.getMood() == -100) {
            return PrehistoricMood.ANGRY;
        } else if (this.getMood() <= -50) {
            return PrehistoricMood.SAD;
        } else {
            return PrehistoricMood.CALM;
        }
    }

    public int getScaledMood() {
        return (int) (71 * -(this.getMood() * 0.01));
    }

    @Override
    public void setSitting(boolean sitting) {
        super.setSitting(sitting);
        if (!worldObj.isRemote) {
            this.isSitting = sitting;
        }
    }

    @Override
    public boolean shouldDismountInWater(Entity rider) {
        return false;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (amount > 0 && this.isSkeleton()) {
            this.playSound(SoundEvents.ENTITY_SKELETON_HURT, 0.8F, 1);
            if (!worldObj.isRemote) {
                if (this.type.timePeriod == TimePeriod.CENOZOIC) {
                    this.dropItem(FAItemRegistry.INSTANCE.tarfossil, 1);
                } else {
                    this.dropItem(FAItemRegistry.INSTANCE.biofossil, 1);
                }
                this.entityDropItem(new ItemStack(Items.BONE, Math.min(this.getAgeInDays(), this.getAdultAge()), 1), 1);
            }
            this.setDead();
            return false;
        }
        if (this.getLastAttacker() instanceof EntityPlayer) {
            if (this.getOwner() == this.getLastAttacker()) {
                this.setTamed(false);
                this.setMood(this.getMood() - 15);
                this.sendStatusMessage(PrehistoricSituation.Betrayed);
            }
        }
        if (amount > 0) {
            this.setSitting(false);
            this.setSleeping(false);
        }
        if (source.getEntity() != null) {
            this.setMood(this.getMood() - 5);
        }
        if (this.getHurtSound() != null) {
            if (this.getAnimation() != null) {
                if (this.getAnimation() == NO_ANIMATION && worldObj.isRemote) {
                    this.setAnimation(speakAnimation);
                }
            }
        }
        super.attackEntityFrom(source, amount);
        return super.attackEntityFrom(source, amount);
    }

    public static boolean isEntitySmallerThan(Entity entity, float size) {
        if (entity instanceof EntityPrehistoric) {
            return ((EntityPrehistoric) entity).getActualWidth() <= size;
        } else {
            return entity.width <= size;
        }
    }

    public boolean isBesideClimbableBlock() {
        return this.getFlag(FLAG_CLIMBABLE_BLOCK);
    }

    public void setBesideClimbableBlock(boolean isCollided) {
        this.setFlag(FLAG_CLIMBABLE_BLOCK, isCollided);
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
        if (this.getClimbType() != PrehistoricAI.Climbing.ARTHROPOD && this.getMoveType() != PrehistoricAI.Moving.WALKANDGLIDE && this.getMoveType() != PrehistoricAI.Moving.FLIGHT) {
            super.fall(distance, damageMultiplier);
        }
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand, ItemStack stack) {
        if (this.isSkeleton()) {
            if (stack == null) {
                if (player.isSneaking()) {
                    this.nudgeEntity(player);
                } else {
                    this.faceEntity(player, 360.0F, 360.0F);
                }
            } else {
                if (stack.getItem() == Items.BONE && this.getAgeInDays() < this.getAdultAge()) {
                    this.playSound(SoundEvents.ENTITY_SKELETON_AMBIENT, 0.8F, 1);
                    this.setAgeInDays(this.getAgeInDays() + 1);
                    if (!player.capabilities.isCreativeMode) {
                        --stack.stackSize;
                    }
                    if (stack.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                    return true;
                }
            }
        } else {
            if (stack != null) {
                if ((this.getTameType() == PrehistoricAI.Taming.GEM && stack.getItem() == FAItemRegistry.INSTANCE.gem) || (this.getTameType() == PrehistoricAI.Taming.BLUEGEM && stack.getItem() == FAItemRegistry.INSTANCE.gem_blue)) {
                    if (!this.isTamed() && !this.isOwnerName(player) && this.isActuallyWeak()) {
                        this.triggerTamingAcheivement(player);
                        this.heal(200);
                        this.setMood(100);
                        this.increaseHunger(500);
                        this.setTamed(true);
                        this.getNavigator().clearPathEntity();
                        this.setAttackTarget(null);
                        this.setOwnerName(player.getName());
                        --stack.stackSize;
                        if (stack.stackSize <= 0) {
                            player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                        }
                        return true;
                    }
                }
            }
            if (stack != null) {
                if (stack.getItem() == FAItemRegistry.INSTANCE.chickenEssence && !player.worldObj.isRemote) {
                    if (this.getAgeInDays() < this.getAdultAge() && this.getHunger() > 0) {
                        if (this.getHunger() > 0) {
                            if (!player.capabilities.isCreativeMode) {
                                --stack.stackSize;
                            }
                            if (stack.stackSize <= 0) {
                                player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                            }
                            if (!player.capabilities.isCreativeMode) {
                                player.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE, 1));
                            }
                            Revival.NETWORK_WRAPPER.sendToAll(new MessageFoodParticles(getEntityId(), Item.getIdFromItem(FAItemRegistry.INSTANCE.chickenEssence)));
                            this.setAgeInDays(this.getAgeInDays() + 1);
                            this.setHunger(1 + (new Random()).nextInt(this.getHunger()));
                            this.setOwnerName(player.getName());
                            return true;
                        }
                    }
                    if (!this.worldObj.isRemote) {
                        Revival.messagePlayer(I18n.translateToLocal(LocalizationStrings.STATUS_ESSENCE_FAIL), player);
                    }
                    return false;
                }
                if (FoodMappings.INSTANCE.getItemFoodAmount(stack.getItem(), this.type.diet) != 0) {
                    if (!player.worldObj.isRemote) {
                        if (this.getMaxHunger() > this.getHunger() || this.getHealth() > this.getMaxHealth() && Revival.CONFIG.healingDinos) {
                            this.setHunger(this.getHunger() + FoodMappings.INSTANCE.getItemFoodAmount(stack.getItem(), this.type.diet));
                            if (!worldObj.isRemote) {
                                this.eatItem(stack);
                            }
                            if (Revival.CONFIG.healingDinos) {
                                this.heal(3);
                            }
                            if (this.getHunger() >= this.getMaxHunger()) {
                                if (this.isTamed()) {
                                    this.sendStatusMessage(PrehistoricSituation.Full);
                                }
                            }
                            --stack.stackSize;
                            if (this.getTameType() == PrehistoricAI.Taming.FEEDING) {
                                if (!this.isTamed() && this.type.isTameable() && (new Random()).nextInt(10) == 1) {
                                    this.setTamed(true);
                                    this.setOwnerName(player.getName());
                                    this.worldObj.setEntityState(this, (byte) 35);
                                }
                            }
                            return true;
                        } else {
                            if (this.ItemInMouth == null) {
                                return true;
                            }
                        }
                    }
                    return false;
                } else {
                    if (stack.getItem() == Items.LEAD && this.canBeLeashedTo(player)) {
                        if (isOwnerName(player)) {
                            this.setLeashedToEntity(player, true);
                            --stack.stackSize;
                            return true;
                        }
                    }
                    if (FMLCommonHandler.instance().getSide().isClient() && stack.getItem() == FAItemRegistry.INSTANCE.dinoPedia) {
                        this.setPedia();
                        player.openGui(Revival.INSTANCE, 4, this.worldObj, (int) this.posX, (int) this.posY, (int) this.posZ);
                        return true;
                    }
                    if (stack.getItem() == FAItemRegistry.INSTANCE.whip && this.getTameType() != PrehistoricAI.Taming.NONE && this.isAdult() && !this.worldObj.isRemote) {
                        if (this.isTamed() && isOwnerName(player) && this.canBeRidden()) {
                            if (this.getRidingPlayer() == null) {
                                Revival.NETWORK_WRAPPER.sendToAll(new MessageFoodParticles(getEntityId(), FABlockRegistry.INSTANCE.volcanicRock));
                                this.setOrder(OrderType.WANDER);
                                setRidingPlayer(player);
                                this.setSitting(false);
                                this.setSleeping(false);
                            } else if (this.getRidingPlayer() == player) {
                                this.setSprinting(true);
                                Revival.NETWORK_WRAPPER.sendToAll(new MessageFoodParticles(getEntityId(), FABlockRegistry.INSTANCE.volcanicRock));
                                this.setMood(this.getMood() - 1);
                            }
                        } else if (!this.isTamed() && this.getTameType() != PrehistoricAI.Taming.BLUEGEM && this.getTameType() != PrehistoricAI.Taming.GEM) {
                            this.setMood(this.getMood() - 1);
                            Revival.NETWORK_WRAPPER.sendToAll(new MessageFoodParticles(getEntityId(), FABlockRegistry.INSTANCE.volcanicRock));
                            if (getRNG().nextInt(5) == 0) {
                                Revival.messagePlayer(I18n.translateToLocal("prehistoric.autotame") + this.getName() + I18n.translateToLocal("prehistoric.period"), player);
                                this.setMood(this.getMood() - 25);
                                this.setTamed(true);
                                Revival.NETWORK_WRAPPER.sendToAll(new MessageFoodParticles(getEntityId(), Item.getIdFromItem(Items.GOLD_INGOT)));
                                this.setOwnerName(player.getName());
                            }
                        }
                        this.setSitting(false);
                    }
                    if (this.getOrderItem() != null && stack.getItem() == this.getOrderItem() && this.isTamed() && this.getOwnerName().equals(player.getName()) && !player.isRiding()) {
                        if (!this.worldObj.isRemote) {
                            this.isJumping = false;
                            this.getNavigator().clearPathEntity();
                            this.currentOrder = OrderType.values()[(this.currentOrder.ordinal() + 1) % 3];
                            this.sendOrderMessage(this.currentOrder);
                        }
                        return true;
                    }
                }
            }
        }
        return super.processInteract(player, hand, stack);
    }

    public abstract Item getOrderItem();

    private void triggerTamingAcheivement(EntityPlayer player) {
        // player.triggerAchievement(FossilAchievementHandler.theKing);

    }

    public boolean isWeak() {
        return (this.getHealth() < 8) && (this.getAgeInDays() >= this.getAdultAge()) && !this.isTamed();
    }

    protected void setPedia() {
        Revival.toPedia = this;
    }

    private void sendOrderMessage(OrderType order) {
        String message = I18n.translateToLocal(LocalizationStrings.ORDER_HEAD) + I18n.translateToLocal("order." + order.toString().toLowerCase());
        Revival.messagePlayer(message, this.worldObj.getPlayerEntityByName(this.getOwnerName()));
    }

    public void nudgeEntity(EntityPlayer player) {
        this.setPositionAndUpdate(this.posX + (player.posX - this.posX) * 0.01F, this.posY, this.posZ + (player.posZ - this.posZ) * 0.01F);
    }

    public ArrayList<Class<? extends Entity>> preyList() {
        return new ArrayList<>();
    }

    public ArrayList<Class<? extends Entity>> preyBlacklist() {
        return new ArrayList<>();
    }

    public void playerRoar(EntityPlayer player) {
    }

    public void playerAttack(EntityPlayer player) {
    }

    public void playerJump(EntityPlayer player) {
    }

    public void playerFlyUp(EntityPlayer player) {
    }

    public void playerFlyDown(EntityPlayer player) {
    }

    public String getTexture() {
        if (this.isSkeleton()) {
            return "fossil:textures/model/" + type.toString().toLowerCase() + "_0/" + type.toString().toLowerCase() + "_skeleton.png";
        }
        if (this.hasBabyTexture) {
            String toggle = this.hasFeatherToggle ? !this.featherToggle ? "feathered/" : "scaled/" : "";
            boolean isBaby = this.isChild() && this.hasBabyTexture;
            String gender = this.hasTeenTexture ? this.isTeen() ? "_teen" : isBaby ? "_baby" : this.getGender() == 0 ? "_female" : "_male" : this.isChild() ? "_baby" : this.getGender() == 0 ? "_female" : "_male";
            String sleeping = !this.isSleeping() ? this.isActuallyWeak() ? "_sleeping" : "" : "_sleeping";
            String toggleList = this.hasFeatherToggle ? !this.featherToggle ? "_feathered" : "_scaled" : "";
            return "fossil:textures/model/" + type.toString().toLowerCase() + "_0/" + toggle + type.toString().toLowerCase() + gender + toggleList + sleeping + ".png";
        } else {
            String toggle = this.hasFeatherToggle ? !this.featherToggle ? "feathered/" : "scaled/" : "";
            String gender = this.getGender() == 0 ? "_female" : "_male";
            String sleeping = !this.isSleeping() ? this.isActuallyWeak() ? "_sleeping" : "" : "_sleeping";
            String toggleList = this.hasFeatherToggle ? !this.featherToggle ? "_feathered" : "_scaled" : "";
            return "fossil:textures/model/" + type.toString().toLowerCase() + "_0/" + toggle + type.toString().toLowerCase() + gender + toggleList + sleeping + ".png";
        }
    }

    public boolean isOwnerName(EntityLivingBase entity) {
        if (entity != null) {
            String name = entity.getName();
            return name != null && this.getOwnerName() != null && this.getOwnerName().equals(name);
        }
        return false;
    }

    public boolean isActuallyWeak() {
        return (this.getTameType() == Taming.BLUEGEM || this.getTameType() == Taming.GEM) && this.isWeak();
    }

    public int getTailSegments() {
        return 3;
    }

    @Override
    public void updateRidden() {
        super.updateRidden();
        Entity ridingEntity = this.getRidingEntity();
        if (ridingEntity != null) {
            if (ridingEntity instanceof EntityPlayer) {
                this.setPosition(posX, posY - ridingEntity.getYOffset(), posZ);
            }
        }
    }

    private double getSpeed() {
        return 0.4D;
    }

    public float getMaleSize() {
        return 1.0F;
    }

    public String getOverlayTexture() {
        return "fossil:textures/blank.png";
    }

    @Override
    public int getAnimationTick() {
        return animTick;
    }

    @Override
    public void setAnimationTick(int tick) {
        animTick = tick;
    }

    @Override
    public Animation getAnimation() {
        return currentAnimation == null ? NO_ANIMATION : currentAnimation;
    }

    @Override
    public void setAnimation(Animation animation) {
        currentAnimation = animation;
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[] { speakAnimation, attackAnimation };
    }

    @Override
    public void playLivingSound() {
        if (!this.isSleeping() && !this.isSkeleton()) {
            super.playLivingSound();
            if (this.getAnimation() != null) {
                if (this.getAnimation() == NO_ANIMATION && !worldObj.isRemote) {
                    this.setAnimation(speakAnimation);
                }
            }
        }
    }

    public void knockbackEntity(Entity entity, float strengthHorizontal, float strengthVertical) {
        if (!(entity instanceof EntityToyBase)) {
            entity.motionY += 0.4000000059604645D;
            knockbackEntity(entity, 0.25D * strengthHorizontal, 0.2D * strengthVertical, 0.25D * strengthHorizontal);
        }
    }

    public void knockbackEntity(Entity entity, double motionX, double motionY, double motionZ) {
        entity.isAirBorne = true;
        float motion = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
        entity.motionX /= 2.0D;
        entity.motionY /= 2.0D;
        entity.motionZ /= 2.0D;
        entity.motionX -= motionX / (double) motion;
        entity.motionY += motionY;
        entity.motionZ -= motionZ / (double) motion;
    }

    @Override
    public void knockBack(Entity entity, float strength, double xRatio, double zRatio) {
        if (entity != null && entity instanceof EntityPrehistoric) {
            if (this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).getAttributeValue() <= 0 && this.onGround) {
                this.velocityChanged = false;
                knockbackEntity(entity, 1, 0.4D, 1);
            }
        } else {
            super.knockBack(entity, strength, xRatio, zRatio);
        }
    }

    public boolean canDinoHunt(Entity target, boolean hunger) {
        boolean isAnotherDino = target instanceof EntityPrehistoric;
        if (this.type.diet != Diet.HERBIVORE && this.type.diet != Diet.NONE && canAttackClass(target.getClass())) {
            if (isAnotherDino ? this.getActualWidth() >= ((EntityPrehistoric) target).getActualWidth() : this.getActualWidth() >= target.width) {
                return !hunger || isHungry() || target instanceof EntityToyBase && this.ticksTillPlay == 0;
            }
        }
        return false;
    }

    public boolean isSad() {
        return this.getMoodFace() == PrehistoricMood.SAD;
    }

    public Flock getNearbyFlock() {
        EntityAINearestAttackableTarget.Sorter targetSorter = new EntityAINearestAttackableTarget.Sorter(this);
        double range = 64;
        List<EntityPrehistoric> entities = worldObj.getEntitiesWithinAABB(EntityPrehistoric.class, this.getEntityBoundingBox().expand(range, 4.0D, range), (entity) -> entity != null);
        Collections.sort(entities, targetSorter);
        if (!entities.isEmpty()) {
            for (EntityPrehistoric mob : entities) {
                if (mob.type == this.type && mob.flock != null && mob.flock.flockLeader == mob) {
                    return mob.flock;
                }
            }
        }
        return null;
    }

    public void mate() {
        EntityAINearestAttackableTarget.Sorter targetSorter = new EntityAINearestAttackableTarget.Sorter(this);
        double range = 64;
        List<EntityPrehistoric> entities = worldObj.getEntitiesWithinAABB(EntityPrehistoric.class, this.getEntityBoundingBox().expand(range, 4.0D, range), (entity) -> entity != null && entity.type == this.type && entity.isAdult() && entity.getGender() == 0 && entity.mateDelay == 0);
        Collections.sort(entities, targetSorter);
        if (!entities.isEmpty() && this.mateDelay == 0) {
            EntityPrehistoric prehistoric = entities.get(0);
            if (prehistoric.mateDelay == 0) {
                this.getNavigator().tryMoveToEntityLiving(prehistoric, 1);
                double distance = (double) (this.width * 8.0F * this.width * 8.0F + prehistoric.width);
                if (this.getDistanceSq(prehistoric.posX, prehistoric.getEntityBoundingBox().minY, prehistoric.posZ) <= distance && prehistoric.onGround && this.onGround) {
                    prehistoric.procreate(this);
                    this.mateDelay = this.rand.nextInt(6000) + 6000;
                    prehistoric.mateDelay = this.rand.nextInt(12000) + 24000;
                }
            }
        }
    }

    public abstract boolean canBeRidden();

    public boolean canBeSteered() {
        return canBeRidden() && (this.getRidingPlayer() != null && this.isOwnerName(this.getRidingPlayer()));
    }

    public void procreate(EntityPrehistoric mob) {
        for (int i = 0; i < 7; ++i) {
            double motionX = this.rand.nextGaussian() * 0.02D;
            double motionY = this.rand.nextGaussian() * 0.02D;
            double motionZ = this.rand.nextGaussian() * 0.02D;
            Revival.PROXY.spawnPacketHeartParticles(this.worldObj, (float) (this.posX + (this.rand.nextFloat() * this.width * 2.0F) - this.width), (float) (this.posY + 0.5D + (this.rand.nextFloat() * this.height)), (float) (this.posZ + (this.rand.nextFloat() * this.width * 2.0F) - this.width), motionX, motionY, motionZ);
            Revival.PROXY.spawnPacketHeartParticles(mob.worldObj, (float) (mob.posX + (mob.rand.nextFloat() * mob.width * 2.0F) - mob.width), (float) (mob.posY + 0.5D + (mob.rand.nextFloat() * mob.height)), (float) (mob.posZ + (mob.rand.nextFloat() * mob.width * 2.0F) - mob.width), motionX, motionY, motionZ);
        }
        if (this.rand.nextInt(15) == 0) {
            this.playSound("fossil:music.mating", 1, 1);
        }
        Entity hatchling = this.createEgg(mob);
        if (hatchling != null && !worldObj.isRemote) {
            this.setAttackTarget(null);
            mob.setAttackTarget(null);
            hatchling.setPositionAndRotation(this.posX, this.posY + 1, this.posZ, this.rotationYaw, 0);
            if (hatchling instanceof EntityDinosaurEgg) {
                Revival.NETWORK_WRAPPER.sendToAll(new MessageUpdateEgg(hatchling.getEntityId(), this.type.ordinal()));
            } else {
                if (hatchling instanceof EntityPrehistoric) {
                    EntityPrehistoric prehistoricHatchling = (EntityPrehistoric) hatchling;
                    prehistoricHatchling.onInitialSpawn(worldObj.getDifficultyForLocation(this.getPosition()), null);
                    prehistoricHatchling.setAgeInDays(1);
                    prehistoricHatchling.updateAbilities();
                    prehistoricHatchling.setHealth((float) this.baseHealth);
                }
            }
            this.worldObj.spawnEntityInWorld(hatchling);
        }
    }

    public boolean isThereNearbyTypes() {
        EntityAINearestAttackableTarget.Sorter targetSorter = new EntityAINearestAttackableTarget.Sorter(this);
        double range = 64;
        List<EntityPrehistoric> entities = worldObj.getEntitiesWithinAABB(EntityPrehistoric.class, this.getEntityBoundingBox().expand(range, 4.0D, range), (entity) -> entity != null && entity.type == this.type && entity.isAdult() && entity.getGender() == 0 && entity.mateDelay == 0);
        Collections.sort(entities, targetSorter);
        if (entities.isEmpty() || this.doesFlock()) {
            return false;
        } else {
            List<EntityPrehistoric> nearbyTypes = new ArrayList<>();
            for (EntityPrehistoric mob : entities) {
                if (mob.type == this.type && mob.isAdult()) {
                    nearbyTypes.add(mob);
                }
            }
            return nearbyTypes.size() > this.nearByMobsAllowed;
        }
    }

    public void doFoodEffect(Item item) {
        this.playSound(SoundEvents.ENTITY_GENERIC_EAT, this.getSoundVolume(), this.getSoundPitch());
        if (item != null) {
            if (item instanceof ItemBlock) {
                spawnItemParticle(item, true);
            } else {
                spawnItemParticle(item, false);
            }
        }
    }

    public void doFoodEffect() {
        this.playSound(SoundEvents.ENTITY_GENERIC_EAT, this.getSoundVolume(), this.getSoundPitch());
        switch (this.type.diet) {
            case HERBIVORE:
                spawnItemParticle(Items.WHEAT_SEEDS, false);
                break;
            case OMNIVORE:
                spawnItemParticle(Items.BREAD, false);
                break;
            case PISCIVORE:
                spawnItemParticle(Items.FISH, false);
                break;
            default:
                spawnItemParticle(Items.BEEF, false);
                break;
        }
    }

    public void spawnItemParticle(Item item, boolean itemBlock) {
        if (!worldObj.isRemote) {
            if (itemBlock && item instanceof ItemBlock) {
                Revival.NETWORK_WRAPPER.sendToAll(new MessageFoodParticles(this.getEntityId(), Block.getIdFromBlock(((ItemBlock) item).block)));
            } else {
                Revival.NETWORK_WRAPPER.sendToAll(new MessageFoodParticles(this.getEntityId(), Item.getIdFromItem(item)));
            }
        }
    }

    public boolean isInWaterMaterial() {
        int y = MathHelper.floor_float((float) MathHelper.floor_double(this.posY));
        IBlockState block = this.worldObj.getBlockState(this.getPosition());
        if (block.getMaterial() == Material.WATER) {
            double filled = 1.0f;
            if (block instanceof IFluidBlock) {
                filled = ((IFluidBlock) block).getFilledPercentage(worldObj, this.getPosition());
            }
            if (filled < 0) {
                filled *= -1;
                return this.posY > y + (1 - filled);
            } else {
                return this.posY < y + filled;
            }
        } else {
            return false;
        }
    }

    public void eatItem(ItemStack stack) {
        if (stack != null && stack.stackSize > 0) {
            if (FoodMappings.INSTANCE.getItemFoodAmount(stack.getItem(), type.diet) != 0) {
                this.setMood(this.getMood() + 5);
                doFoodEffect(stack.getItem());
                Revival.NETWORK_WRAPPER.sendToAll(new MessageFoodParticles(getEntityId(), Item.getIdFromItem(stack.getItem())));
                this.setHunger(this.getHunger() + FoodMappings.INSTANCE.getItemFoodAmount(stack.getItem(), type.diet));
                stack.stackSize--;
            }
        }
    }

    public String getTempermentString() {
        String temperment = null;
        if (this.getResponseType() == PrehistoricAI.Response.AGRESSIVE || this.getResponseType() == PrehistoricAI.Response.WATERAGRESSIVE) {
            temperment = "agressive";
        } else if (this.getResponseType() == PrehistoricAI.Response.SCARED) {
            temperment = "scared";
        } else if (this.getResponseType() == PrehistoricAI.Response.NONE || this.getResponseType() == PrehistoricAI.Response.WATERCALM) {
            temperment = "none";
        } else if (this.getResponseType() == PrehistoricAI.Response.TERITORIAL) {
            temperment = "territorial";
        }
        return "pedia.temperament." + temperment;
    }

    public boolean canRunFrom(Entity entity) {
        if (width <= entity.width) {
            if (entity instanceof EntityPrehistoric) {
                EntityPrehistoric mob = (EntityPrehistoric) entity;
                if (mob.type.diet != Diet.HERBIVORE) {
                    return true;
                }
            } else {
                if (entity instanceof EntityPlayer) {
                    EntityPlayer player = (EntityPlayer) entity;
                    if (this.getOwner() == player) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    protected void dropFewItems(boolean bool, int rand) {
        if (this.type.mobType == MobType.BIRD || this.type.mobType == MobType.TERRORBIRD) {
            int feathers = this.rand.nextInt(3) + this.rand.nextInt(1 + rand);
            for (int i = 0; i < feathers; ++i) {
                this.dropItem(Items.FEATHER, 1);
            }
        }
        if (this.isBurning() && this.type.cookedFoodItem != null) {
            this.dropItem(this.type.cookedFoodItem, Math.min(this.getAgeInDays(), this.getAdultAge()));
        } else if (this.type.foodItem != null) {
            this.dropItem(this.type.foodItem, Math.min(this.getAgeInDays(), this.getAdultAge()));
        }
        EnumDinoBones bones = EnumDinoBones.get(this.type);
        if (bones != null) {
            int damage = bones.ordinal();
            this.entityDropItem(new ItemStack(FAItemRegistry.INSTANCE.skull, this.rand.nextInt(1), damage), 0);
            this.entityDropItem(new ItemStack(FAItemRegistry.INSTANCE.armBone, this.rand.nextInt(2), damage), 0);
            this.entityDropItem(new ItemStack(FAItemRegistry.INSTANCE.dinoRibCage, this.rand.nextInt(1), damage), 0);
            this.entityDropItem(new ItemStack(FAItemRegistry.INSTANCE.vertebrae, this.rand.nextInt(5), damage), 0);
            this.entityDropItem(new ItemStack(FAItemRegistry.INSTANCE.foot, this.rand.nextInt(2), damage), 0);
            this.entityDropItem(new ItemStack(FAItemRegistry.INSTANCE.claw, this.rand.nextInt(2), damage), 0);
        }
    }

    public double getMountedYOffset() {
        return 0;
    }

    @Override
    public void updatePassenger(Entity passenger) {
        if (this.isOwnerName(this.getRidingPlayer()) && this.getAttackTarget() != this.getRidingPlayer()) {
            rotationYaw = renderYawOffset;
            rotationYaw = passenger.rotationYaw;
            float radius = ridingXZ * (0.7F * getAgeScale()) * -3;
            float angle = (0.01745329251F * this.renderYawOffset);
            double extraX = (double) (radius * MathHelper.sin((float) (Math.PI + angle)));
            double extraZ = (double) (radius * MathHelper.cos(angle));
            double extraY = ridingY * (getAgeScale());
            float spinosaurusAddition = 0;
            if (this instanceof EntitySpinosaurus) {
                spinosaurusAddition = -(((EntitySpinosaurus) this).swimProgress * 0.1F);
            }
            passenger.setPosition(this.posX + extraX, this.posY + extraY + spinosaurusAddition, this.posZ + extraZ);
            return;
        }
        super.updatePassenger(passenger);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable entity) {
        Entity baby = this.type.invokeClass(this.worldObj);
        if (entity instanceof EntityPrehistoric) {
            EntityPrehistoric prehistoricBaby = (EntityPrehistoric) baby;
            prehistoricBaby.onInitialSpawn(worldObj.getDifficultyForLocation(this.getPosition()), null);
            prehistoricBaby.setAgeInDays(0);
            prehistoricBaby.updateAbilities();
            prehistoricBaby.setHealth((float) this.baseHealth);
            return prehistoricBaby;
        }
        return null;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return "fossil:" + this.type.name().toLowerCase() + "_living";
    }

    @Override
    protected SoundEvent getHurtSound() {
        return "fossil:" + this.type.name().toLowerCase() + "_hurt";
    }

    @Override
    protected SoundEvent getDeathSound() {
        return "fossil:" + this.type.name().toLowerCase() + "_death";
    }

    public boolean isAquatic() {
        return this instanceof EntityPrehistoricSwimming;
    }

    protected boolean getFlag(int key) {
        return (this.dataManager.get(FLAGS) >> key & 1) == 1;
    }

    protected void setFlag(int key, boolean value) {
        byte flags = this.dataManager.get(FLAGS);
        int bit = 1 << key;
        if (value) {
            this.dataManager.set(FLAGS, (byte) (flags | bit));
        } else {
            this.dataManager.set(FLAGS, (byte) (flags & ~bit));
        }
    }
}
