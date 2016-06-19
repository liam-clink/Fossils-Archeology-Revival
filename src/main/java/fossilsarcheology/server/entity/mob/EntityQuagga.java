package fossilsarcheology.server.entity.mob;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.AnimalChest;
import net.minecraft.inventory.IInvBasic;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fossilsarcheology.Revival;
import fossilsarcheology.client.gui.GuiPedia;
import fossilsarcheology.server.entity.ai.QuaggaAITaming;
import fossilsarcheology.server.handler.LocalizationStrings;
import fossilsarcheology.server.item.FAItemRegistry;

public class EntityQuagga extends EntityAnimal implements IInvBasic {
    protected static final ResourceLocation pediaheart = new ResourceLocation("fossil:textures/gui/PediaHeart.png");
    private static final IAttribute horseJumpStrength = (new RangedAttribute("horse.jumpStrength", 0.7D, 0.0D, 2.0D)).setDescription("Jump Strength").setShouldWatch(true);
    private static final String[] horseArmorShortName = new String[]{"", "meo", "goo", "dio"};
    private static final String[] horseArmorTextures = new String[]{null, "textures/entity/horse/armor/horse_armor_iron.png", "textures/entity/horse/armor/horse_armor_gold.png", "textures/entity/horse/armor/horse_armor_diamond.png"};
    private static final int[] armorValues = new int[]{0, 5, 7, 11};
    private static final String[] horseTextures = new String[]{"fossil:textures/mob/Quagga_Brown.png"};
    public int timer1;
    public int field_110279_bq;
    public InventoryBasic quaggaChest;
    protected boolean horseJumping;
    /**
     * "The higher this value, the more likely the horse is to be tamed next time a player rides it."
     */
    protected int temper;
    protected float jumpPower;
    private int eatingHaystackCounter;
    private int openMouthCounter;
    private int jumpRearingCounter;
    private boolean hasReproduced;
    private boolean field_110294_bI;
    private float headLean;
    private float prevHeadLean;
    private float rearingAmount;
    private float prevRearingAmount;
    private float mouthOpenness;
    private float prevMouthOpenness;
    private int field_110285_bP;
    private String horseTexture;
    private String[] combinedTexturePath = new String[3];

    public EntityQuagga(World par1World) {
        super(par1World);
        this.setSize(1.4F, 1.6F);
        this.isImmuneToFire = false;
        this.setChested(false);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.2D));
        this.tasks.addTask(1, new QuaggaAITaming(this, 1.2D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityMob.class, 1.0D, true));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWander(this, 0.7D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.func_110226_cD();
        this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityTitanis.class, 16.0F, 1D, 1.2D));
        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityPhorusrhacos.class, 16.0F, 1D, 1.2D));
        this.tasks.addTask(5, new EntityAIAvoidEntity(this, EntityKelenken.class, 16.0F, 1D, 1.2D));
    }

    public static boolean func_110211_v(Item item) {
        return item == Items.iron_horse_armor || item == Items.golden_horse_armor || item == Items.diamond_horse_armor;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, 0);
        this.dataWatcher.addObject(21, String.valueOf(""));
        this.dataWatcher.addObject(22, 0);
    }

    private void setPedia() {
        Revival.toPedia = this;
    }

    /**
     * Gets the username of the entity.
     */
    public String getEntityName() {
        if (this.hasCustomNameTag()) {
            return this.getCustomNameTag();
        } else {
            return StatCollector.translateToLocal("entity.fossil.Quagga.name");
        }
    }

    private boolean getHorseWatchableBoolean(int par1) {
        return (this.dataWatcher.getWatchableObjectInt(16) & par1) != 0;
    }

    private void setHorseWatchableBoolean(int par1, boolean par2) {
        int j = this.dataWatcher.getWatchableObjectInt(16);

        if (par2) {
            this.dataWatcher.updateObject(16, j | par1);
        } else {
            this.dataWatcher.updateObject(16, j & ~par1);
        }
    }

    public boolean isAdultHorse() {
        return !this.isChild();
    }

    public boolean isTame() {
        return this.getHorseWatchableBoolean(2);
    }

    public boolean canBeTamed() {
        return this.isAdultHorse();
    }

    public String getOwnerName() {
        return this.dataWatcher.getWatchableObjectString(21);
    }

    public void setOwnerName(String par1Str) {
        this.dataWatcher.updateObject(21, par1Str);
    }

    public float getHorseSize() {
        int i = this.getGrowingAge();
        return i >= 0 ? 1.0F : 0.5F + (float) (-24000 - i) / -24000.0F * 0.5F;
    }

    @SideOnly(Side.CLIENT)
    private void setHorseTexturePaths() {
        this.horseTexture = "horse/";
        this.combinedTexturePath[0] = null;
        this.combinedTexturePath[1] = null;
        int k;

        this.combinedTexturePath[0] = horseTextures[0];
        this.horseTexture = this.horseTexture + "";

        k = this.horseArmor();
        this.combinedTexturePath[1] = horseArmorTextures[k];
        this.horseTexture = this.horseTexture + horseArmorShortName[k];
    }

    @SideOnly(Side.CLIENT)
    public String getHorseTexture() {
        if (this.horseTexture == null) {
            this.setHorseTexturePaths();
        }

        return this.horseTexture;
    }

    @SideOnly(Side.CLIENT)
    public String[] getVariantTexturePaths() {
        if (this.horseTexture == null) {
            this.setHorseTexturePaths();
        }

        return this.combinedTexturePath;
    }

    /**
     * "Sets the scale for an ageable entity according to the boolean parameter, which says if it's a child."
     */
    @Override
    public void setScaleForAge(boolean par1) {
        if (par1) {
            this.setScale(this.getHorseSize());
        } else {
            this.setScale(1.0F);
        }
    }

    public boolean isHorseJumping() {
        return this.horseJumping;
    }

    public void setHorseJumping(boolean par1) {
        this.horseJumping = par1;
    }

    public void setHorseTamed(boolean par1) {
        this.setHorseWatchableBoolean(2, par1);
    }

    @Override
    public boolean allowLeashing() {
        return super.allowLeashing();
    }

    @Override
    protected void func_142017_o(float par1) {
        if (par1 > 6.0F && this.isEatingHaystack()) {
            this.setEatingHaystack(false);
        }
    }

    public boolean isChested() {
        return this.getHorseWatchableBoolean(8);
    }

    public void setChested(boolean par1) {
        this.setHorseWatchableBoolean(8, par1);
    }

    public int horseArmor() {
        return this.dataWatcher.getWatchableObjectInt(22);
    }

    /**
     * 0 = iron, 1 = gold, 2 = diamond
     */
    public int getHorseArmorIndex(ItemStack par1ItemStack) {
        return par1ItemStack == null ? 0 : (par1ItemStack.getItem() == Items.iron_horse_armor ? 1 : (par1ItemStack.getItem() == Items.golden_horse_armor ? 2 : (par1ItemStack.getItem() == Items.diamond_horse_armor ? 3 : 0)));
    }

    public boolean isEatingHaystack() {
        return this.getHorseWatchableBoolean(32);
    }

    public void setEatingHaystack(boolean par1) {
        this.setEating(par1);
    }

    public boolean isRearing() {
        return this.getHorseWatchableBoolean(64);
    }

    public void setRearing(boolean par1) {
        if (par1) {
            this.setEatingHaystack(false);
        }

        this.setHorseWatchableBoolean(64, par1);
    }

    public boolean getBred() {
        return this.getHorseWatchableBoolean(16);
    }

    public void setBred(boolean par1) {
        this.setHorseWatchableBoolean(16, par1);
    }

    public boolean getHasReproduced() {
        return this.hasReproduced;
    }

    public void setHasReproduced(boolean par1) {
        this.hasReproduced = par1;
    }

    public void setHorseArmor(int par1) {
        this.dataWatcher.updateObject(22, par1);
        this.func_110230_cF();
    }

    public int getTemper() {
        return this.temper;
    }

    public void setTemper(int par1) {
        this.temper = par1;
    }

    public int increaseTemper(int par1) {
        int j = MathHelper.clamp_int(this.getTemper() + par1, 0, this.getMaxTemper());
        this.setTemper(j);
        return j;
    }

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        Entity entity = par1DamageSource.getEntity();
        return !(this.riddenByEntity != null && this.riddenByEntity.equals(entity)) && super.attackEntityFrom(par1DamageSource, par2);
    }

    /**
     * Returns the current armor value as determined by a call to
     * InventoryPlayer.getTotalArmorValue
     */
    @Override
    public int getTotalArmorValue() {
        return armorValues[this.horseArmor()];
    }

    /**
     * Returns true if this entity should push and be pushed by other entities
     * when colliding.
     */
    @Override
    public boolean canBePushed() {
        return this.riddenByEntity == null;
    }

    public boolean prepareChunkForSpawn() {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posZ);
        this.worldObj.getBiomeGenForCoords(i, j);
        return true;
    }

    public void dropChests() {
        if (!this.worldObj.isRemote && this.isChested()) {
            this.dropItem(Item.getItemFromBlock(Blocks.chest), 1);
            this.setChested(false);
        }
    }

    private void eatFood() {
        this.openHorseMouth();
        this.worldObj.playSoundAtEntity(this, "eating", 1.0F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    @Override
    protected void fall(float par1) {
        if (par1 > 1.0F) {
            this.playSound("mob.horse.land", 0.4F, 1.0F);
        }

        int i = MathHelper.ceiling_float_int(par1 * 0.5F - 3.0F);

        if (i > 0) {
            this.attackEntityFrom(DamageSource.fall, (float) i);

            if (this.riddenByEntity != null) {
                this.riddenByEntity.attackEntityFrom(DamageSource.fall, (float) i);
            }

            Block block = this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY - 0.2D - (double) this.prevRotationYaw), MathHelper.floor_double(this.posZ));

            if (block.getMaterial() != Material.air) {
                Block.SoundType soundtype = block.stepSound;
                this.worldObj.playSoundAtEntity(this, soundtype.getStepResourcePath(), soundtype.getVolume() * 0.5F, soundtype.getPitch() * 0.75F);
            }
        }
    }

    private int func_110225_cC() {
        int i = 0;
        return this.isChested() && (i == 0) ? 17 : 17;
    }

    private void func_110226_cD() {
        InventoryBasic animalchest = this.quaggaChest;
        // AnimalChest animalchest = this.quaggaChest;
        this.quaggaChest = new AnimalChest("QuaggaChest", this.func_110225_cC());
        this.quaggaChest.func_110133_a(this.getEntityName());

        if (animalchest != null) {
            animalchest.func_110132_b(this);
            int i = Math.min(animalchest.getSizeInventory(), this.quaggaChest.getSizeInventory());

            for (int j = 0; j < i; ++j) {
                ItemStack itemstack = animalchest.getStackInSlot(j);

                if (itemstack != null) {
                    this.quaggaChest.setInventorySlotContents(j, itemstack.copy());
                }
            }

            animalchest = null;
        }

        this.quaggaChest.func_110134_a(this);
        this.func_110232_cE();
    }

    private void func_110232_cE() {
        if (!this.worldObj.isRemote) {
            this.setHorseSaddled(this.quaggaChest.getStackInSlot(0) != null);

            this.setHorseArmor(this.getHorseArmorIndex(this.quaggaChest.getStackInSlot(1)));
        }
    }

    /**
     * Called by InventoryBasic.onInventoryChanged() on a array that is never
     * filled.
     */
    @Override
    public void onInventoryChanged(InventoryBasic par1InventoryBasic) {
        int i = this.horseArmor();
        boolean flag = this.isHorseSaddled();
        this.func_110232_cE();

        if (this.ticksExisted > 20) {
            if (i == 0 && i != this.horseArmor()) {
                this.playSound("mob.horse.armor", 0.5F, 1.0F);
            }

            if (!flag && this.isHorseSaddled()) {
                this.playSound("mob.horse.leather", 0.5F, 1.0F);
            }
        }
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this
     * entity.
     */
    @Override
    public boolean getCanSpawnHere() {
        this.prepareChunkForSpawn();
        return super.getCanSpawnHere();
    }

    public double getHorseJumpStrength() {
        return this.getEntityAttribute(horseJumpStrength).getAttributeValue();
    }

    /**
     * Returns the sound this mob makes on death.
     */
    @Override
    protected String getDeathSound() {
        this.openHorseMouth();
        return "mob.horse.death";
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    @Override
    protected Item getDropItem() {
        return Items.leather;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected String getHurtSound() {
        this.openHorseMouth();

        if (this.rand.nextInt(3) == 0) {
            this.makeHorseRear();
        }
        return "mob.horse.hit";
    }

    public boolean isHorseSaddled() {
        return this.getHorseWatchableBoolean(4);
    }

    public void setHorseSaddled(boolean par1) {
        this.setHorseWatchableBoolean(4, par1);
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    @Override
    protected String getLivingSound() {
        this.openHorseMouth();

        if (this.rand.nextInt(10) == 0 && !this.isMovementBlocked()) {
            this.makeHorseRear();
        }

        return "mob.horse.idle";
    }

    protected String getAngrySoundName() {
        this.openHorseMouth();
        this.makeHorseRear();
        return "mob.horse.angry";
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
    // playStepSound
    @Override
    protected void func_145780_a(int x, int y, int z, Block block) {
        Block.SoundType soundtype = block.stepSound;

        if (this.worldObj.getBlock(x, y + 1, z) == Blocks.snow_layer) {
            soundtype = Blocks.snow_layer.stepSound;
        }

        if (!block.getMaterial().isLiquid()) {
            if (this.riddenByEntity != null) {
                ++this.field_110285_bP;

                if (this.field_110285_bP > 5 && this.field_110285_bP % 3 == 0) {
                    this.playSound("mob.horse.gallop", soundtype.getVolume() * 0.15F, soundtype.getPitch());

                    if (this.rand.nextInt(10) == 0) {
                        this.playSound("mob.horse.breathe", soundtype.getVolume() * 0.6F, soundtype.getPitch());
                    }
                } else if (this.field_110285_bP <= 5) {
                    this.playSound("mob.horse.wood", soundtype.getVolume() * 0.15F, soundtype.getPitch());
                }
            } else if (soundtype == Block.soundTypeWood) {
                this.playSound("mob.horse.wood", soundtype.getVolume() * 0.15F, soundtype.getPitch());
            } else {
                this.playSound("mob.horse.soft", soundtype.getVolume() * 0.15F, soundtype.getPitch());
            }
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(horseJumpStrength);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(53.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.22499999403953552D);
    }

    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    @Override
    public int getMaxSpawnedInChunk() {
        return 6;
    }

    public int getMaxTemper() {
        return 200;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    @Override
    protected float getSoundVolume() {
        return 0.8F;
    }

    /**
     * Get number of ticks, at least during which the living entity will be
     * silent.
     */
    @Override
    public int getTalkInterval() {
        return 400;
    }

    @SideOnly(Side.CLIENT)
    public boolean func_110239_cn() {
        return this.horseArmor() > 0;
    }

    private void func_110230_cF() {
        this.horseTexture = null;
    }

    public void openGUI(EntityPlayer player) {
        if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == player) && this.isTame()) {
            this.quaggaChest.func_110133_a(this.getCommandSenderName());
            if (!worldObj.isRemote) {
                player.openGui(Revival.INSTANCE, 8, worldObj, this.getEntityId(), 0, 0);
            }
        }
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow,
     * gets into the saddle on a pig.
     */
    @Override
    public boolean interact(EntityPlayer player) {
        ItemStack itemstack = player.inventory.getCurrentItem();

        if (itemstack != null && itemstack.getItem() == Items.spawn_egg) {
            return super.interact(player);
        } else if (itemstack != null && FMLCommonHandler.instance().getSide().isClient() && itemstack.getItem() == FAItemRegistry.INSTANCE.dinoPedia) {
            this.setPedia();
            player.openGui(Revival.INSTANCE, 4, this.worldObj, (int) this.posX, (int) this.posY, (int) this.posZ);
            return true;
        } else if (this.isTame() && this.isAdultHorse() && player.isSneaking()) {
            this.openGUI(player);
            return true;
        } else if (this.canBeTamed() && this.riddenByEntity != null) {
            return super.interact(player);
        } else {
            if (itemstack != null) {
                boolean flag = false;

                byte b0 = -1;

                if (itemstack.getItem() == Items.iron_horse_armor) {
                    b0 = 1;
                } else if (itemstack.getItem() == Items.golden_horse_armor) {
                    b0 = 2;
                } else if (itemstack.getItem() == Items.diamond_horse_armor) {
                    b0 = 3;
                }

                if (b0 >= 0) {
                    if (!this.isTame()) {
                        this.makeHorseRearWithSound();
                        return true;
                    }

                    this.openGUI(player);
                    return true;
                }

                if (!flag) {
                    float f = 0.0F;
                    short short1 = 0;
                    byte b1 = 0;

                    if (itemstack.getItem() == Items.wheat) {
                        f = 2.0F;
                        short1 = 60;
                        b1 = 3;
                    } else if (itemstack.getItem() == Items.sugar) {
                        f = 1.0F;
                        short1 = 30;
                        b1 = 3;
                    } else if (itemstack.getItem() == Items.bread) {
                        f = 7.0F;
                        short1 = 180;
                        b1 = 3;
                    } else if (Block.getBlockFromItem(itemstack.getItem()) == Blocks.hay_block) {
                        f = 20.0F;
                        short1 = 180;
                    } else if (itemstack.getItem() == Items.apple) {
                        f = 3.0F;
                        short1 = 60;
                        b1 = 3;
                    } else if (itemstack.getItem() == Items.golden_carrot) {
                        f = 4.0F;
                        short1 = 60;
                        b1 = 5;

                        if (this.isTame() && this.getGrowingAge() == 0) {
                            flag = true;
                            this.func_146082_f(player);
                        }
                    } else if (itemstack.getItem() == Items.golden_apple) {
                        f = 10.0F;
                        short1 = 240;
                        b1 = 10;

                        if (this.isTame() && this.getGrowingAge() == 0) {
                            flag = true;
                            this.func_146082_f(player);
                        }
                    }

                    if (this.getHealth() < this.getMaxHealth() && f > 0.0F) {
                        this.heal(f);
                        flag = true;
                    }

                    if (!this.isAdultHorse() && short1 > 0) {
                        this.addGrowth(short1);
                        flag = true;
                    }

                    if (b1 > 0 && (flag || !this.isTame()) && b1 < this.getMaxTemper()) {
                        flag = true;
                        this.increaseTemper(b1);
                    }

                    if (flag) {
                        this.eatFood();
                    }
                }

                if (!this.isTame() && !flag) {
                    if (itemstack != null && itemstack.interactWithEntity(player, this)) {
                        return true;
                    }

                    this.makeHorseRearWithSound();
                    return true;
                }

                if (!flag && !this.isChested() && itemstack.getItem() == Item.getItemFromBlock(Blocks.chest)) {
                    this.setChested(true);
                    this.playSound("mob.chickenplop", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
                    flag = true;
                    this.func_110226_cD();
                }

                if (!flag && this.canBeTamed() && !this.isHorseSaddled() && itemstack.getItem() == Items.saddle) {
                    this.openGUI(player);
                    return true;
                }

                if (flag) {
                    if (!player.capabilities.isCreativeMode && --itemstack.stackSize == 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }

                    return true;
                }
            }

            if (this.canBeTamed() && this.riddenByEntity == null) {
                if (itemstack != null && itemstack.interactWithEntity(player, this)) {
                    return true;
                } else {
                    this.mountQuagga(player);
                    return true;
                }
            } else {
                return super.interact(player);
            }
        }
    }

    private void mountQuagga(EntityPlayer player) {
        player.rotationYaw = this.rotationYaw;
        player.rotationPitch = this.rotationPitch;
        this.setEatingHaystack(false);
        this.setRearing(false);

        if (!this.worldObj.isRemote) {
            player.mountEntity(this);
        }
    }

    /**
     * Dead and sleeping entities cannot move
     */
    @Override
    protected boolean isMovementBlocked() {
        return this.riddenByEntity != null && this.isHorseSaddled() || this.isEatingHaystack() || this.isRearing();
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed
     * it (wheat, carrots or seeds depending on the animal type)
     */
    @Override
    public boolean isBreedingItem(ItemStack par1ItemStack) {
        return false;
    }

    private void func_110210_cH() {
        this.timer1 = 1;
    }

    /**
     * Called when the mob's health reaches 0.
     */
    @Override
    public void onDeath(DamageSource par1DamageSource) {
        super.onDeath(par1DamageSource);

        if (!this.worldObj.isRemote) {
            this.dropChestItems();
        }
    }

    /**
     * Called frequently so the entity can update its state every tick as
     * required. For example, zombies and skeletons use this to react to
     * sunlight and start to burn.
     */
    @Override
    public void onLivingUpdate() {
        if (this.rand.nextInt(200) == 0) {
            this.func_110210_cH();
        }

        super.onLivingUpdate();

        if (!this.worldObj.isRemote) {
            if (this.rand.nextInt(900) == 0 && this.deathTime == 0) {
                this.heal(1.0F);
            }

            if (!this.isEatingHaystack() && this.riddenByEntity == null && this.rand.nextInt(300) == 0 && this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY) - 1, MathHelper.floor_double(this.posZ)) == Blocks.grass) {
                this.setEatingHaystack(true);
            }

            if (this.isEatingHaystack() && ++this.eatingHaystackCounter > 50) {
                this.eatingHaystackCounter = 0;
                this.setEatingHaystack(false);
            }
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        super.onUpdate();

        if (this.worldObj.isRemote && this.dataWatcher.hasChanges()) {
            this.dataWatcher.func_111144_e();
            this.func_110230_cF();
        }

        if (this.openMouthCounter > 0 && ++this.openMouthCounter > 30) {
            this.openMouthCounter = 0;
            this.setHorseWatchableBoolean(128, false);
        }

        if (!this.worldObj.isRemote && this.jumpRearingCounter > 0 && ++this.jumpRearingCounter > 20) {
            this.jumpRearingCounter = 0;
            this.setRearing(false);
        }

        if (this.timer1 > 0 && ++this.timer1 > 8) {
            this.timer1 = 0;
        }

        if (this.field_110279_bq > 0) {
            ++this.field_110279_bq;

            if (this.field_110279_bq > 300) {
                this.field_110279_bq = 0;
            }
        }

        this.prevHeadLean = this.headLean;

        if (this.isEatingHaystack()) {
            this.headLean += (1.0F - this.headLean) * 0.4F + 0.05F;

            if (this.headLean > 1.0F) {
                this.headLean = 1.0F;
            }
        } else {
            this.headLean += (0.0F - this.headLean) * 0.4F - 0.05F;

            if (this.headLean < 0.0F) {
                this.headLean = 0.0F;
            }
        }

        this.prevRearingAmount = this.rearingAmount;

        if (this.isRearing()) {
            this.prevHeadLean = this.headLean = 0.0F;
            this.rearingAmount += (1.0F - this.rearingAmount) * 0.4F + 0.05F;

            if (this.rearingAmount > 1.0F) {
                this.rearingAmount = 1.0F;
            }
        } else {
            this.field_110294_bI = false;
            this.rearingAmount += (0.8F * this.rearingAmount * this.rearingAmount * this.rearingAmount - this.rearingAmount) * 0.6F - 0.05F;

            if (this.rearingAmount < 0.0F) {
                this.rearingAmount = 0.0F;
            }
        }

        this.prevMouthOpenness = this.mouthOpenness;

        if (this.getHorseWatchableBoolean(128)) {
            this.mouthOpenness += (1.0F - this.mouthOpenness) * 0.7F + 0.05F;

            if (this.mouthOpenness > 1.0F) {
                this.mouthOpenness = 1.0F;
            }
        } else {
            this.mouthOpenness += (0.0F - this.mouthOpenness) * 0.7F - 0.05F;

            if (this.mouthOpenness < 0.0F) {
                this.mouthOpenness = 0.0F;
            }
        }
    }

    private void openHorseMouth() {
        if (!this.worldObj.isRemote) {
            this.openMouthCounter = 1;
            this.setHorseWatchableBoolean(128, true);
        }
    }

    @Override
    public void setEating(boolean par1) {
        this.setHorseWatchableBoolean(32, par1);
    }

    private void makeHorseRear() {
        if (!this.worldObj.isRemote) {
            this.jumpRearingCounter = 1;
            this.setRearing(true);
        }
    }

    public void makeHorseRearWithSound() {
        this.makeHorseRear();
        String s = this.getAngrySoundName();

        if (s != null) {
            this.playSound(s, this.getSoundVolume(), this.getSoundPitch());
        }
    }

    public void dropChestItems() {
        this.dropItemsInChest(this, this.quaggaChest);
        this.dropChests();
    }

    private void dropItemsInChest(Entity entity, InventoryBasic animalChest) {
        if (animalChest != null && !this.worldObj.isRemote) {
            for (int i = 0; i < animalChest.getSizeInventory(); ++i) {
                ItemStack itemstack = animalChest.getStackInSlot(i);

                if (itemstack != null) {
                    this.entityDropItem(itemstack, 0.0F);
                }
            }
        }
    }

    public boolean setTamedBy(EntityPlayer player) {
        this.setOwnerName(player.getCommandSenderName());
        this.setHorseTamed(true);
        return true;
    }

    /**
     * Moves the entity based on the specified heading. Args: strafe, forward
     */
    @Override
    public void moveEntityWithHeading(float par1, float par2) {
        if (this.riddenByEntity != null && this.isHorseSaddled()) {
            this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
            this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5F;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
            par1 = ((EntityLivingBase) this.riddenByEntity).moveStrafing * 0.5F;
            par2 = ((EntityLivingBase) this.riddenByEntity).moveForward;

            if (par2 <= 0.0F) {
                par2 *= 0.25F;
                this.field_110285_bP = 0;
            }

            if (this.onGround && this.jumpPower == 0.0F && this.isRearing() && !this.field_110294_bI) {
                par1 = 0.0F;
                par2 = 0.0F;
            }

            if (this.jumpPower > 0.0F && !this.isHorseJumping() && this.onGround) {
                this.motionY = this.getHorseJumpStrength() * (double) this.jumpPower;

                if (this.isPotionActive(Potion.jump)) {
                    this.motionY += (double) ((float) (this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F);
                }

                this.setHorseJumping(true);
                this.isAirBorne = true;

                if (par2 > 0.0F) {
                    float f2 = MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F);
                    float f3 = MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F);
                    this.motionX += (double) (-0.4F * f2 * this.jumpPower);
                    this.motionZ += (double) (0.4F * f3 * this.jumpPower);
                    this.playSound("mob.horse.jump", 0.4F, 1.0F);
                }

                this.jumpPower = 0.0F;
            }

            this.stepHeight = 1.0F;
            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

            if (!this.worldObj.isRemote) {
                this.setAIMoveSpeed((float) this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
                super.moveEntityWithHeading(par1, par2);
            }

            if (this.onGround) {
                this.jumpPower = 0.0F;
                this.setHorseJumping(false);
            }

            this.prevLimbSwingAmount = this.limbSwingAmount;
            double d0 = this.posX - this.prevPosX;
            double d1 = this.posZ - this.prevPosZ;
            float f4 = MathHelper.sqrt_double(d0 * d0 + d1 * d1) * 4.0F;

            if (f4 > 1.0F) {
                f4 = 1.0F;
            }

            this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4F;
            this.limbSwing += this.limbSwingAmount;
        } else {
            this.stepHeight = 0.5F;
            this.jumpMovementFactor = 0.02F;
            super.moveEntityWithHeading(par1, par2);
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setBoolean("EatingHaystack", this.isEatingHaystack());
        compound.setBoolean("ChestedHorse", this.isChested());
        compound.setBoolean("HasReproduced", this.getHasReproduced());
        compound.setBoolean("Bred", this.getBred());
        compound.setInteger("Temper", this.getTemper());
        compound.setBoolean("Tame", this.isTame());
        compound.setString("OwnerName", this.getOwnerName());

        if (this.isChested()) {
            NBTTagList nbttaglist = new NBTTagList();

            for (int i = 2; i < this.quaggaChest.getSizeInventory(); ++i) {
                ItemStack itemstack = this.quaggaChest.getStackInSlot(i);

                if (itemstack != null) {
                    NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                    nbttagcompound1.setByte("Slot", (byte) i);
                    itemstack.writeToNBT(nbttagcompound1);
                    nbttaglist.appendTag(nbttagcompound1);
                }
            }

            compound.setTag("Items", nbttaglist);
        }

        if (this.quaggaChest.getStackInSlot(1) != null) {
            compound.setTag("ArmorItem", this.quaggaChest.getStackInSlot(1).writeToNBT(new NBTTagCompound()));
        }

        if (this.quaggaChest.getStackInSlot(0) != null) {
            compound.setTag("SaddleItem", this.quaggaChest.getStackInSlot(0).writeToNBT(new NBTTagCompound()));
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setEatingHaystack(par1NBTTagCompound.getBoolean("EatingHaystack"));
        this.setBred(par1NBTTagCompound.getBoolean("Bred"));
        this.setChested(par1NBTTagCompound.getBoolean("ChestedHorse"));
        this.setHasReproduced(par1NBTTagCompound.getBoolean("HasReproduced"));
        this.setTemper(par1NBTTagCompound.getInteger("Temper"));
        this.setHorseTamed(par1NBTTagCompound.getBoolean("Tame"));

        if (par1NBTTagCompound.hasKey("OwnerName")) {
            this.setOwnerName(par1NBTTagCompound.getString("OwnerName"));
        }

        IAttributeInstance attributeinstance = this.getAttributeMap().getAttributeInstanceByName("Speed");

        if (attributeinstance != null) {
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(attributeinstance.getBaseValue() * 0.25D);
        }

        if (this.isChested()) {
            NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items", 10);
            this.func_110226_cD();

            for (int i = 0; i < nbttaglist.tagCount(); ++i) {
                NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
                int j = nbttagcompound1.getByte("Slot") & 255;

                if (j >= 2 && j < this.quaggaChest.getSizeInventory()) {
                    this.quaggaChest.setInventorySlotContents(j, ItemStack.loadItemStackFromNBT(nbttagcompound1));
                }
            }
        }

        ItemStack itemstack;

        if (par1NBTTagCompound.hasKey("ArmorItem")) {
            itemstack = ItemStack.loadItemStackFromNBT(par1NBTTagCompound.getCompoundTag("ArmorItem"));

            if (itemstack != null && func_110211_v(itemstack.getItem())) {
                this.quaggaChest.setInventorySlotContents(1, itemstack);
            }
        }

        if (par1NBTTagCompound.hasKey("SaddleItem")) {
            itemstack = ItemStack.loadItemStackFromNBT(par1NBTTagCompound.getCompoundTag("SaddleItem"));

            if (itemstack != null && itemstack.getItem() == Items.saddle) {
                this.quaggaChest.setInventorySlotContents(0, itemstack);
            }
        } else if (par1NBTTagCompound.getBoolean("Saddle")) {
            this.quaggaChest.setInventorySlotContents(0, new ItemStack(Items.saddle));
        }

        this.func_110232_cE();
    }

    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    @Override
    public boolean canMateWith(EntityAnimal par1EntityAnimal) {
        return !(par1EntityAnimal == this || par1EntityAnimal.getClass() != this.getClass());
    }

    @Override
    public EntityAgeable createChild(EntityAgeable par1EntityAgeable) {
        EntityQuagga entityQuagga = (EntityQuagga) par1EntityAgeable;
        EntityQuagga babyQuagga = new EntityQuagga(this.worldObj);

        double d0 = this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + par1EntityAgeable.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + (double) this.randomHealthStat();
        babyQuagga.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(d0 / 3.0D);
        double d1 = this.getEntityAttribute(horseJumpStrength).getBaseValue() + par1EntityAgeable.getEntityAttribute(horseJumpStrength).getBaseValue() + this.randomJumpStat();
        babyQuagga.getEntityAttribute(horseJumpStrength).setBaseValue(d1 / 3.0D);
        double d2 = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + par1EntityAgeable.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + this.randomSpeedStat();
        babyQuagga.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(d2 / 3.0D);
        return babyQuagga;
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData) {
        Object par1EntityLivingData1 = super.onSpawnWithEgg(par1EntityLivingData);
        boolean flag = false;

        if (this.rand.nextInt(5) == 0) {
            this.setGrowingAge(-24000);
        }
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double) this.randomHealthStat());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.randomSpeedStat());
        this.getEntityAttribute(horseJumpStrength).setBaseValue(this.randomJumpStat());

        this.setHealth(this.getMaxHealth());
        return (IEntityLivingData) par1EntityLivingData1;
    }

    @SideOnly(Side.CLIENT)
    public float getGrassEatingAmount(float par1) {
        return this.prevHeadLean + (this.headLean - this.prevHeadLean) * par1;
    }

    @SideOnly(Side.CLIENT)
    public float getRearingAmount(float par1) {
        return this.prevRearingAmount + (this.rearingAmount - this.prevRearingAmount) * par1;
    }

    @SideOnly(Side.CLIENT)
    public float getMouthOpenness(float par1) {
        return this.prevMouthOpenness + (this.mouthOpenness - this.prevMouthOpenness) * par1;
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    @Override
    protected boolean isAIEnabled() {
        return true;
    }

    public void setJumpPower(int par1) {
        if (this.isHorseSaddled()) {
            if (par1 < 0) {
                par1 = 0;
            } else {
                this.field_110294_bI = true;
                this.makeHorseRear();
            }

            if (par1 >= 90) {
                this.jumpPower = 1.0F;
            } else {
                this.jumpPower = 0.4F + 0.4F * (float) par1 / 90.0F;
            }
        }
    }

    @SideOnly(Side.CLIENT)
    /**
     * "Spawns particles for the horse entity. par1 tells whether to spawn hearts. If it is false, it spawns smoke."
     */
    protected void spawnHorseParticles(boolean par1) {
        String s = par1 ? "heart" : "smoke";

        for (int i = 0; i < 7; ++i) {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.worldObj.spawnParticle(s, this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, d0, d1, d2);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte par1) {
        if (par1 == 7) {
            this.spawnHorseParticles(true);
        } else if (par1 == 6) {
            this.spawnHorseParticles(false);
        } else {
            super.handleHealthUpdate(par1);
        }
    }

    @Override
    public void updateRiderPosition() {
        super.updateRiderPosition();

        if (this.prevRearingAmount > 0.0F) {
            float f = MathHelper.sin(this.renderYawOffset * (float) Math.PI / 180.0F);
            float f1 = MathHelper.cos(this.renderYawOffset * (float) Math.PI / 180.0F);
            float f2 = 0.7F * this.prevRearingAmount;
            float f3 = 0.15F * this.prevRearingAmount;
            this.riddenByEntity.setPosition(this.posX + (double) (f2 * f), this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset() + (double) f3, this.posZ - (double) (f2 * f1));

            if (this.riddenByEntity instanceof EntityLivingBase) {
                ((EntityLivingBase) this.riddenByEntity).renderYawOffset = this.renderYawOffset;
            }
        }
    }

    public float randomHealthStat() {
        return 15.0F + (float) this.rand.nextInt(8) + (float) this.rand.nextInt(9);
    }

    public double randomJumpStat() {
        return 0.4000000059604645D + this.rand.nextDouble() * 0.2D + this.rand.nextDouble() * 0.2D + this.rand.nextDouble() * 0.2D;
    }

    public double randomSpeedStat() {
        return (0.44999998807907104D + this.rand.nextDouble() * 0.3D + this.rand.nextDouble() * 0.3D + this.rand.nextDouble() * 0.3D) * 0.25D;
    }

    /**
     * returns true if this entity is by a ladder, false otherwise
     */
    @Override
    public boolean isOnLadder() {
        return false;
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity
     * has recently been hit by a player. @param par2 - Level of Looting used to
     * kill this mob.
     */
    @Override
    protected void dropFewItems(boolean hasBeenHit, int looting) {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + looting);
        int k;

        for (k = 0; k < j; ++k) {
            if (this.isBurning()) {
                // this.dropItem(FAItemRegistry.INSTANCE.quaggaMeatCooked, 1);
            } else {
                // this.dropItem(FAItemRegistry.INSTANCE.quaggaMeat, 1);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void showPedia(GuiPedia p0) {
    }

    @SideOnly(Side.CLIENT)
    public void showPedia2(GuiPedia p0) {
    }
}
