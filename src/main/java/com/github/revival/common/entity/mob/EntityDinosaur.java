package com.github.revival.common.entity.mob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.github.revival.Revival;
import com.github.revival.client.gui.GuiPedia;
import com.github.revival.common.block.FABlockRegistry;
import com.github.revival.common.config.FossilConfig;
import com.github.revival.common.entity.EntityDinoEgg;
import com.github.revival.common.entity.ai.DinoAIGrowup;
import com.github.revival.common.entity.ai.DinoAIStarvation;
import com.github.revival.common.enums.EnumOrderType;
import com.github.revival.common.enums.EnumPrehistoric;
import com.github.revival.common.enums.EnumSituation;
import com.github.revival.common.handler.LocalizationStrings;
import com.github.revival.common.item.FAItemRegistry;
import com.github.revival.common.tileentity.TileEntityFeeder;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class EntityDinosaur extends EntityPrehistoric implements IEntityAdditionalSpawnData
{
    public static final int HUNGER_TICK_DATA_INDEX = 18;
    public static final int HUNGER_DATA_INDEX = 19;
    public static final int AGE_TICK_DATA_INDEX = 20;
    public static final int AGE_DATA_INDEX = 21;
    public static final int SUBSPECIES_INDEX = 22;
    public static final int MODELIZED_INDEX = 23;

    public static final byte HEART_MESSAGE = 35;
    public static final byte SMOKE_MESSAGE = 36;
    public static final byte AGING_MESSAGE = 37;
    private static final ResourceLocation pediaclock = new ResourceLocation(
            "fossil:textures/gui/PediaClock.png");
    private static final ResourceLocation pediafood = new ResourceLocation(
            "fossil:textures/gui/PediaFood.png");
    private static final ResourceLocation pediaheart = new ResourceLocation(
            "fossil:textures/gui/PediaHeart.png");
    public float RiderStrafe = 0.0F;
    public float RiderForward = 0.0F;
    public boolean RiderJump = false;
    public boolean RiderSneak = false;
    public float minSize;
    public float maxSize;
    public int adultAge;
    public EnumPrehistoric SelfType = null;
    // Breed Tick at the moment, 0=breed, BreedingTime=timer just started
    public int BreedTick;
    // Variable for the thing the dino can hold in it's mouth
    public ItemStack ItemInMouth = null;
    public EnumOrderType OrderStatus;
    public double baseHealth;
    public double baseDamage;
    public double baseSpeed;
    public double maxHealth;
    public double maxDamage;
    public double maxSpeed;

    // EntityDinosaur Constructor
    public EntityDinosaur(World var1, EnumPrehistoric T0)
    {
        super(var1);
        this.SelfType = T0;
        this.OrderStatus = EnumOrderType.FreeMove;
       // this.tasks.addTask(0, new DinoAIGrowup(this));
        this.tasks.addTask(0, new DinoAIStarvation(this));
        this.BreedTick = this.SelfType.BreedingTicks;
        this.setHunger(this.SelfType.MaxHunger / 2);
        this.setHealth((float) this.SelfType.Health0);
    }

    /**
     * Interpolate the size of the dinosaur based on the day 0 value and the max
     * adult value. If the dinosaur is past Adult age, continue to grow but have
     * diminished growth.
     */
    public float getDinosaurSize()
    {
        float step;
        step = (this.maxSize - this.minSize) / (this.adultAge + 1);

        if (this.getDinoAge() > this.adultAge)
        {
            return this.minSize + (step * this.adultAge);
        }

        return this.minSize + (step * this.getDinoAge());
    }

    /**
     * "Sets the scale for an ageable entity according to the boolean parameter, which says if it's a child."
     */
    @Override
    public void setScaleForAge(boolean par1)
    {
        this.setScale(this.getDinosaurSize());
    }

    protected int getExperiencePoints(EntityPlayer par1EntityPlayer)
    {
        return MathHelper.floor_float(this.SelfType.Exp0
                + (float) this.getDinoAge() * this.SelfType.ExpInc);
    }

    /**
     * This gets called when a dinosaur grows naturally or through Chicken
     * Essence.
     */
    public void updateSize()
    {
        this.jump();
    }

    /**
     * Call this in onLivingUpdate() if your dino breaks blocks.
     */
    public void breakBlock(float hardness)
    {
        if (FossilConfig.dinoBlockBreaking)
        {
            if (!isModelized() && this.isAdult() && this.IsHungry())
            {
                for (int a = (int) Math.round(this.boundingBox.minX) - 1; a <= (int) Math.round(this.boundingBox.maxX) + 1; a++)
                {
                    for (int b = (int) Math.round(this.boundingBox.minY) + 1; (b <= (int) Math.round(this.boundingBox.maxY) + 3) && (b <= 127); b++)
                    {
                        for (int c = (int) Math.round(this.boundingBox.minZ) - 1; c <= (int) Math.round(this.boundingBox.maxZ) + 1; c++)
                        {

                            Block block = worldObj.getBlock(a, b, c);
                            if (!(block instanceof BlockBush) && !(block instanceof BlockLiquid) && block != Blocks.bedrock && block != FABlockRegistry.ancientGlass && block != FABlockRegistry.strongGlass && block.getBlockHardness(worldObj, a, b, c) < hardness)
                            {
                                this.motionX *= 0.6D;
                                this.motionZ *= 0.6D;

                                Item item = block.getItemDropped(worldObj.getBlockMetadata(a, b, c), this.getRNG(), 1);
                                int itemCount = block.quantityDropped(getRNG());
                                int itemMeta = block.damageDropped(worldObj.getBlockMetadata(a, b, c));
                                if (block != Blocks.air)
                                {
                                    //this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_" + this.worldObj.getBlockMetadata(a, b, c), a + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width,b + 0.1D, c + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, 4.0D * ((double)this.rand.nextFloat() - 0.5D), 0.5D, ((double)this.rand.nextFloat() - 0.5D) * 4.0D);
                                    this.playSound(block.stepSound.getBreakSound(), 0.15F, 1.0F);
                                }

                                if (!worldObj.isRemote)
                                {
                                    worldObj.setBlock(a, b, c, Blocks.air);
                                }

                                if (item != null)
                                {
                                    float f = 0.7F;
                                    double d0 = (double) (this.getRNG().nextFloat() * f) + (double) (1.0F - f) * 0.5D;
                                    double d1 = (double) (this.getRNG().nextFloat() * f) + (double) (1.0F - f) * 0.5D;
                                    double d2 = (double) (this.getRNG().nextFloat() * f) + (double) (1.0F - f) * 0.5D;
                                    if (!worldObj.isRemote)
                                    {
                                        EntityItem entityitem = new EntityItem(worldObj, (double) a + d0, (double) b + d1, (double) c + d2, new ItemStack(item, itemCount, itemMeta));
                                        entityitem.delayBeforeCanPickup = 10;
                                        worldObj.spawnEntityInWorld(entityitem);

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void setPedia()
    {
        Revival.toPedia = this;
    }

    /**
     * Tells if the Dino is a Adult
     */
    public boolean isAdult()
    {
        return this.getDinoAge() >= this.SelfType.AdultAge;
    }

    /**
     * Tells if the Dino is a Teen
     */
    public boolean isTeen()
    {
        return this.getDinoAge() >= this.SelfType.TeenAge
                && this.getDinoAge() < this.SelfType.AdultAge;
    }

    public boolean isChild()
    {
        return this.getDinoAge() < this.SelfType.TeenAge;
    }

    /**
     * Returns the MaxHunger of the Dino
     */
    public int getMaxHunger()
    {
        return this.SelfType.MaxHunger;
    }

    public boolean isModelized()
    {
        return this.dataWatcher.getWatchableObjectByte(MODELIZED_INDEX) >= 0;
    }

    public void setModelized(boolean var1)
    {
        if (this.SelfType.isModelable())
        {
            this.dataWatcher.updateObject(MODELIZED_INDEX, (byte) (var1 ? 0 : -1));
            // if (var1)
            // this.getTexture = this.getModelTexture();
        }
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(AGE_DATA_INDEX, 0);
        this.dataWatcher.addObject(AGE_TICK_DATA_INDEX, 0);
        this.dataWatcher.addObject(HUNGER_DATA_INDEX, 30);
        this.dataWatcher.addObject(HUNGER_TICK_DATA_INDEX, 300);
        this.dataWatcher.addObject(SUBSPECIES_INDEX, 1);
        this.dataWatcher.addObject(MODELIZED_INDEX, (byte) -1);
    }

    public int getSubSpecies()
    {
        return this.dataWatcher.getWatchableObjectInt(SUBSPECIES_INDEX);
    }

    public void setSubSpecies(int var1)
    {
        this.dataWatcher.updateObject(SUBSPECIES_INDEX, var1);
    }

    public int getDinoAge()
    {
        return this.dataWatcher.getWatchableObjectInt(AGE_DATA_INDEX);
    }

    public void setDinoAge(int var1)
    {
        this.dataWatcher.updateObject(AGE_DATA_INDEX, var1);
    }

    /**
     * Tries to increase the dino age, returns if successful
     */
    public boolean increaseDinoAge()
    {
        if (this.getDinoAge() < this.SelfType.MaxAge)
        {
            this.setDinoAge(this.getDinoAge() + 1);
            return true;
        }

        return false;
    }

    public int getDinoAgeTick()
    {
        return this.dataWatcher.getWatchableObjectInt(AGE_TICK_DATA_INDEX);
    }

    public void setDinoAgeTick(int var1)
    {
        this.dataWatcher.updateObject(AGE_TICK_DATA_INDEX, var1);
    }

    public void increaseDinoAgeTick()
    {
        this.setDinoAgeTick(this.getDinoAgeTick() + 1);
    }

    public int getHunger()
    {
        return this.dataWatcher.getWatchableObjectInt(HUNGER_DATA_INDEX);
    }

    public void setHunger(int var1)
    {
        this.dataWatcher.updateObject(HUNGER_DATA_INDEX, var1);
    }

    public boolean increaseHunger(int var1)
    {
        if (this.getHunger() >= this.getMaxHunger())
        {
            return false;
        }

        this.setHunger(this.getHunger() + var1);

        if (this.getHunger() > this.getMaxHunger())
        {
            this.setHunger(this.getMaxHunger());
        }

        this.worldObj.playSoundAtEntity(this, "random.eat",
                this.getSoundVolume(), this.getSoundPitch());
        return true;
    }

    /**
     * This method gets called when the entity kills another one.
     */
    @Override
    public void onKillEntity(EntityLivingBase var1)
    {
        super.onKillEntity(var1);
        this.increaseHunger(this.SelfType.FoodMobList.getMobFood(var1
                .getClass()));

        this.heal(this.SelfType.FoodMobList.getMobHeal(var1.getClass()));
    }

    public void decreaseHunger()
    {
        if (this.getHunger() > 0)
        {
            this.setHunger(this.getHunger() - 1);
        }
    }

    public boolean IsHungry()
    {
        return this.getHunger() < this.getMaxHunger()
                * this.SelfType.HungryLevel;
    }

    public boolean IsDeadlyHungry()
    {
        return this.getHunger() < this.getMaxHunger()
                * (1 - this.SelfType.HungryLevel);
    }

    public int getHungerTick()
    {
        return this.dataWatcher.getWatchableObjectInt(HUNGER_TICK_DATA_INDEX);
    }

    public void setHungerTick(int var1)
    {
        this.dataWatcher.updateObject(HUNGER_TICK_DATA_INDEX, var1);
    }

    public void decreaseHungerTick()
    {
        if (this.getHungerTick() > 0)
        {
            this.setHungerTick(this.getHungerTick() - 1);
        }
    }

    /**
     * Placeholder, returns the attack strength, should be customized for every
     * Dino
     */
    /*
     * public double getAttackStrength() { return this.SelfType.Strength0 +
	 * this.getDinoAge() * this.SelfType.StrengthInc; }
	 */

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean attackEntityFrom(DamageSource var1, float var2)
    {
        if (isInvulnerable(var1))
        {
            return false;
        }
        else if (var1 == DamageSource.inWall)
        {
            return false;
        }

        // when modelized just drop the model else handle normal attacking
        return this.modelizedDrop() || super.attackEntityFrom(var1, var2);
    }

    protected String getModelTexture()
    {
        return Revival.modid + ":" + "textures/mob/DinosaurModels/DinoModel"
                + this.SelfType.toString() + ".png";
    }

    /**
     * Returns the texture's file path as a String.
     */
    public String getTexture()
    {
        return this.isModelized() ? this.getModelTexture() : Revival.modid + ":"
                + "textures/mob/DinoModel" + this.SelfType.toString() + ".png";
    }

    public void moveEntityWithHeading(float par1, float par2)
    {
        if (!isModelized())
        {
            super.moveEntityWithHeading(par1, par2);

            // this.stepHeight = 0.5F;

            if (this.riddenByEntity != null || this.isAdult())
            {
                this.stepHeight = 1.0F;
            }
        }
        else
        {
            this.motionX *= 0.0D;
            this.motionZ *= 0.0D;
        }

    }

    /**
     * Get number of ticks, at least during which the living entity will be
     * silent.
     */
    public int getTalkInterval()
    {
        return 360;
    }

    @Override
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        if (this.isModelized())
            return null;
        return Revival.modid + ":" + this.SelfType.toString().toLowerCase()
                + "_living";
    }

    @Override
    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        if (this.isModelized())
            return null;
        return Revival.modid + ":" + this.SelfType.toString().toLowerCase()
                + "_hurt";
    }

    @Override
    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        if (this.isModelized())
            return null;
        return Revival.modid + ":" + this.SelfType.toString().toLowerCase()
                + "_death";
    }

    /**
     * Gets the pitch of living sounds in living entities.
     */
    protected float getSoundPitch()
    {
        return (!this.isAdult() && !this.isTeen()) ? (this.rand.nextFloat() - this.rand
                .nextFloat()) * 0.2F + 2.5F
                : (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return (!this.isAdult() && !this.isTeen()) ? 0.4F : 1.0F;
    }


    @SideOnly(Side.CLIENT)
    public void ShowPedia(GuiPedia p0)
    {

        p0.reset();
        p0.PrintPictXY(new ResourceLocation(Revival.modid + ":"
                        + "textures/items/" + this.SelfType.toString() + "_DNA.png"),
                ((p0.xGui / 2) + (p0.xGui / 4)), 7, 16, 16); // 185

		/*
         * LEFT PAGE
		 * 
		 * OWNER: (+2) OWNER NAME RIDEABLE ORDER ABLE TO FLY ABLE TO CHEST
		 * DANGEROUS
		 */

		/*
		 * RIGHT PAGE
		 * 
		 * CUSTOM NAME DINOSAUR NAME DINO AGE HEALTH HUNGER
		 */
        if (this.hasCustomNameTag())
        {
            p0.PrintStringXY(this.getCustomNameTag(), GuiPedia.rightIndent, 24, 40,
                    90, 245);
        }

        p0.PrintStringXY(
                StatCollector.translateToLocal("entity.fossil."
                        + this.SelfType.toString() + ".name"), GuiPedia.rightIndent,
                34, 0, 0, 0);
        p0.PrintPictXY(pediaclock, GuiPedia.rightIndent, 46, 8, 8);
        p0.PrintPictXY(pediaheart, GuiPedia.rightIndent, 58, 9, 9);
        p0.PrintPictXY(pediafood, GuiPedia.rightIndent, 70, 9, 9);

        // Print "Day" after age
        if (this.getDinoAge() == 1)
            p0.PrintStringXY(
                    String.valueOf(this.getDinoAge())
                            + " "
                            + StatCollector
                            .translateToLocal(LocalizationStrings.PEDIA_EGG_DAY),
                    GuiPedia.rightIndent + 12, 46);
        else
            p0.PrintStringXY(
                    String.valueOf(this.getDinoAge())
                            + " "
                            + StatCollector
                            .translateToLocal(LocalizationStrings.PEDIA_EGG_DAYS),
                    GuiPedia.rightIndent + 12, 46);

        // Display Health
        p0.PrintStringXY(
                String.valueOf(this.getHealth()) + '/' + this.getMaxHealth(),
                GuiPedia.rightIndent + 12, 58);
        // Display Hunger
        p0.PrintStringXY(
                String.valueOf(this.getHunger()) + '/' + this.getMaxHunger(),
                GuiPedia.rightIndent + 12, 70);

        // Display owner name
        if (this.SelfType.isTameable() && this.isTamed())
        {
            if (this.getOwnerDisplayName().length() > 0)
            {
                p0.AddStringLR(
                        StatCollector
                                .translateToLocal(LocalizationStrings.PEDIA_TEXT_OWNER),
                        true);

                // //////////1.7.10 BLOCK //////////////

                String s0 = String.valueOf(this.getOwnerDisplayName());
                if (s0.length() > 11)
                {
                    s0 = this.getOwnerDisplayName().substring(0, 11);
                }

                p0.AddStringLR(s0, true);
                // /////////////////////////////////////

                // //////////1.7.2 BLOCK //////////////
				/*
				 * String s0 = this.getOwnerName(); if (s0.length() > 11) { s0 =
				 * this.getOwnerName().substring(0, 11); }
				 * 
				 * p0.AddStringLR(s0, true);
				 */
                // /////////////////////////////////////
            }
            else
            {
                p0.AddStringLR(StatCollector.translateToLocal("Tamed"), true);
            }
        }
        else
        {
            p0.AddStringLR(StatCollector.translateToLocal("Untamed"), true);
        }
        // Display if Rideable
        if (this.SelfType.isRideable() && this.isAdult())
            p0.AddStringLR(StatCollector
                            .translateToLocal(LocalizationStrings.PEDIA_TEXT_RIDEABLE),
                    true);

        if (this.SelfType.orderItem != null)
            p0.AddStringLR(
                    StatCollector.translateToLocal("Order: "
                            + (new ItemStack(this.SelfType.orderItem))
                            .getDisplayName()), true);

        for (int i = 0; i < this.SelfType.FoodItemList.index; i++)
        {
            if (this.SelfType.FoodItemList.getItem(i) != null)
            {
                p0.AddMiniItem(this.SelfType.FoodItemList.getItem(i));
            }
        }

        // TODO show all blocks the dino can eat
    }

    @SideOnly(Side.CLIENT)
    public void ShowPedia2(GuiPedia p0)
    {
        p0.reset();
        p0.AddStringLR("", 150, false);
        String translatePath = "assets/fossil/dinopedia/"
                + Minecraft.getMinecraft().gameSettings.language + "/";
        String bioFile = String.valueOf(this.SelfType) + ".txt";

        if (getClass().getClassLoader().getResourceAsStream(translatePath) == null)
        {
            translatePath = "assets/fossil/dinopedia/" + "en_US" + "/";
        }

        if (getClass().getClassLoader().getResourceAsStream(
                translatePath + bioFile) != null)
        {
            InputStream fileReader = getClass().getClassLoader()
                    .getResourceAsStream(translatePath + bioFile);
            try
            {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileReader));
                String line;
                while ((line = bufferedReader.readLine()) != null)
                {
                    GL11.glPushMatrix();
                    GL11.glScalef(0.5F, 0.5F, 0.5F);
                    p0.AddStringLR(line, 150, false);
                    GL11.glPopMatrix();
                }
                fileReader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            p0.AddStringLR("File not found.", false);
            GL11.glPushMatrix();
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            p0.AddStringLR(translatePath + bioFile, 150, false);
            GL11.glPopMatrix();
        }

        if (Revival.enableDebugging())
        {
            p0.AddStringLR(StatCollector.translateToLocal("Command: " + this.getOrderType()), true);
            p0.AddStringLR(StatCollector.translateToLocal("Sitting: " + this.isSitting()), true);
        }
    }

    /**
     * retrieves the itemstack it can eat and returns the number of items not
     * used
     */
    public int Eat(ItemStack itemstack)
    {
        int i = itemstack.stackSize;

        if (this.IsHungry()
                && (this.SelfType.FoodItemList.CheckItem(itemstack.getItem()) || this.SelfType.FoodBlockList
                .CheckBlock(Block.getBlockFromItem(itemstack.getItem()))))
        {
            // The Dino is Hungry and it can eat the item
            // this.showHeartsOrSmokeFX(false);
            this.worldObj.setEntityState(this, SMOKE_MESSAGE);

            while (i > 0 && this.getHunger() < this.getMaxHunger())
            {
                this.setHunger(this.getHunger()
                        + this.SelfType.FoodItemList.getItemFood(itemstack
                        .getItem()));

                if (!this.worldObj.isRemote) // !this.worldObj.isRemote)
                {
                    this.heal(this.SelfType.FoodItemList.getItemHeal(itemstack
                            .getItem()));
                }

                i--;
            }

            if (this.getHunger() > this.getMaxHunger())
            {
                if (this.isTamed())
                {
                    this.SendStatusMessage(EnumSituation.Full);
                }

                this.setHunger(this.getMaxHunger());
            }

            this.worldObj.playSoundAtEntity(this, "random.eat",
                    this.getSoundVolume(), this.getSoundPitch());

        }

        return i;
    }

    /**
     * The dino grabs an item from this stack with its monstrous teeth
     */
    public void HoldItem(ItemStack var1)
    {
        this.ItemInMouth = new ItemStack(var1.getItem(), 1,
                var1.getItemDamage());
    }

    /**
     * Handles an Itemstack the dinos gets his fangs on
     */
    public int PickUpItem(ItemStack var1)
    {
        int i = Eat(var1);

        if (i > 0
                && (this.SelfType.canCarryItems() || this.SelfType.FoodItemList
                .CheckItem(var1.getItem())) && this.ItemInMouth == null)
        {
            // if there are items left after trying to eat and he has nothing
            // atm and the dino is able to carry things or its his food he takes
            // it in the mouth
            this.HoldItem(var1);
            i--;
        }

        return i;
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    @Override
    public boolean isAIEnabled()
    {
        return !this.isModelized();
    }

    /**
     * Tells if the dino is sitting
     */

    public boolean isSitting()
    {
        return this.getOrderType() == EnumOrderType.Stay;
    }

    public boolean canBePushed()
    {
        return !this.isSitting();
    }

    /**
     * Disables a mob's ability to move on its own while true.
     */
    protected boolean isMovementCeased()
    {
        return this.getOrderType() == EnumOrderType.Stay;
    }

    public Vec3 getBlockToEat(int SEARCH_RANGE)
    {
        Vec3 pos;

        for (int r = 1; r <= SEARCH_RANGE; r++)
        {
            for (int ds = -r; ds <= r; ds++)
            {
                for (int dy = 4; dy > -5; dy--)
                {
                    if (this.posY + dy >= 0
                            && this.posY + dy <= this.worldObj.getHeight()
                            && this.SelfType.FoodBlockList
                            .CheckBlock(this.worldObj.getBlock(
                                    MathHelper.floor_double(this.posX
                                            + ds),
                                    MathHelper.floor_double(this.posY
                                            + dy),
                                    MathHelper.floor_double(this.posZ
                                            - r))))
                    {
                        pos = Vec3.createVectorHelper(
                                MathHelper.floor_double(this.posX + ds),
                                MathHelper.floor_double(this.posY + dy),
                                MathHelper.floor_double(this.posZ - r));
                        return pos;
                    }

                    if (this.posY + dy >= 0
                            && this.posY + dy <= this.worldObj.getHeight()
                            && this.SelfType.FoodBlockList
                            .CheckBlock(this.worldObj.getBlock(
                                    MathHelper.floor_double(this.posX
                                            + ds),
                                    MathHelper.floor_double(this.posY
                                            + dy),
                                    MathHelper.floor_double(this.posZ
                                            + r))))
                    {
                        pos = Vec3.createVectorHelper(
                                MathHelper.floor_double(this.posX + ds),
                                MathHelper.floor_double(this.posY + dy),
                                MathHelper.floor_double(this.posZ + r));
                        return pos;
                    }
                }
            }

            for (int ds = -r + 1; ds <= r - 1; ds++)
            {
                for (int dy = 4; dy > -5; dy--)
                {
                    if (this.posY + dy >= 0
                            && this.posY + dy <= this.worldObj.getHeight()
                            && this.SelfType.FoodBlockList
                            .CheckBlock(this.worldObj.getBlock(
                                    MathHelper.floor_double(this.posX
                                            - r),
                                    MathHelper.floor_double(this.posY
                                            + dy),
                                    MathHelper.floor_double(this.posZ
                                            + ds))))
                    {
                        pos = Vec3.createVectorHelper(
                                MathHelper.floor_double(this.posX - r),
                                MathHelper.floor_double(this.posY + dy),
                                MathHelper.floor_double(this.posZ + ds));
                        return pos;
                    }

                    if (this.posY + dy >= 0
                            && this.posY + dy <= this.worldObj.getHeight()
                            && this.SelfType.FoodBlockList
                            .CheckBlock(this.worldObj.getBlock(
                                    MathHelper.floor_double(this.posX
                                            + r),
                                    MathHelper.floor_double(this.posY
                                            + dy),
                                    MathHelper.floor_double(this.posZ
                                            + ds))))
                    {
                        pos = Vec3.createVectorHelper(
                                MathHelper.floor_double(this.posX + r),
                                MathHelper.floor_double(this.posY + dy),
                                MathHelper.floor_double(this.posZ + ds));
                        return pos;
                    }
                }
            }
        }

        return null;
    }

    public TileEntityFeeder GetNearestFeeder(int SEARCH_RANGE)
    {
        for (int dx = -2; dx != -(SEARCH_RANGE + 1); dx += (dx < 0) ? (dx * -2)
                : (-(2 * dx + 1))) // Creates the following order:
        // -2,2,-3,3,-4,1,....,10, stops with 10.
        // looks at near places, first
        {
            for (int dy = -5; dy < 4; dy++)
            {
                for (int dz = -2; dz != -(SEARCH_RANGE + 1); dz += (dz < 0) ? (dz * -2)
                        : (-(2 * dz + 1))) // Creates the following order:
                // -2,2,-3,3,-4,1,....,10, stops
                // with 10. looks at near places,
                // first
                {
                    if (this.posY + dy >= 0
                            && this.posY + dy <= this.worldObj.getHeight())
                    {
                        TileEntity fed = this.worldObj.getTileEntity(
                                MathHelper.floor_double(this.posX + dx),
                                MathHelper.floor_double(this.posY + dy),
                                MathHelper.floor_double(this.posZ + dz));

                        if (fed != null
                                && fed instanceof TileEntityFeeder
                                && !((TileEntityFeeder) fed)
                                .CheckIsEmpty(this.SelfType))
                        {
                            return (TileEntityFeeder) fed;
                        }
                    }
                }
            }
        }

        return null;
    }

    public void HandleBreed()
    {

        if (this.isAdult())
        {
            --this.BreedTick;

            if (this.BreedTick == 0)
            {
                int PartnerCount = 0;
                List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(
                        this, this.boundingBox.expand(16.0D, 16.0D, 16.0D));

                for (Object obj : list)
                {
                    if (obj instanceof EntityDinosaur)
                    {
                        EntityDinosaur partner = (EntityDinosaur) obj;

                        if (partner.SelfType == this.SelfType
                                && partner.isAdult())// only adults mate
                        {
                            ++PartnerCount;
                        }

                        if (PartnerCount > 20)// There are too many already
                        {
                            return;
                        }
                    }
                }

                if (PartnerCount > 10)// More won't help
                {
                    PartnerCount = 10;
                }

                if ((new Random()).nextInt(100) < PartnerCount)
                {
                    EntityDinoEgg var5;
                    var5 = new EntityDinoEgg(this.worldObj, this.SelfType);
                    var5.setLocationAndAngles(this.posX
                                    + (double) ((new Random()).nextInt(3) - 1),
                            this.posY,
                            this.posZ
                                    + (double) ((new Random()).nextInt(3) - 1),
                            this.worldObj.rand.nextFloat() * 360.0F, 0.0F);

                    this.worldObj.spawnEntityInWorld(var5);

                    // this.showHeartsOrSmokeFX(true);
                    this.worldObj.setEntityState(this, HEART_MESSAGE);
                }

                this.BreedTick = this.SelfType.BreedingTicks;
            }
        }
    }

    public boolean CheckSpace()
    {
        return !this.isEntityInsideOpaqueBlock();
    }

    protected void getPathOrWalkableBlock(Entity var1, float var2)
    {
        PathEntity var3 = this.worldObj.getPathEntityToEntity(this, var1,
                16.0F, true, false, true, false);
        this.setPathToEntity(var3);
    }

    @Override
    public boolean attackEntityAsMob(Entity victim)
    {
        float attackDamage = (float) getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
        int knockback = 0;

        if (victim instanceof EntityLivingBase)
        {
            attackDamage += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase) victim);
            knockback += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase) victim);
        }

        boolean attacked = victim.attackEntityFrom(
                DamageSource.causeMobDamage(this), attackDamage);

        if (attacked)
        {
            if (knockback > 0)
            {
                double vx = -Math.sin(Math.toRadians(rotationYaw)) * knockback
                        * 0.5;
                double vy = 0.1;
                double vz = Math.cos(Math.toRadians(rotationYaw)) * knockback
                        * 0.5;
                victim.addVelocity(vx, vy, vz);
                motionX *= 0.6;
                motionZ *= 0.6;
            }

            setLastAttacker(victim);
        }

        return attacked;
    }

    public void SendOrderMessage(EnumOrderType var1)
    {
        String S = StatCollector.translateToLocal(LocalizationStrings.ORDER_HEAD) + StatCollector.translateToLocal("order." + var1.toString());
        Revival.showMessage(S, (EntityPlayer) this.getOwner());
    }

    public void SendStatusMessage(EnumSituation var1)
    {
        if (this.getOwner() != null && this.getDistanceToEntity(this.getOwner()) < 50.0F)
        {
            String Status1 = StatCollector.translateToLocal(("status." + var1.toString() + ".head"));
            String Dino = this.SelfType.toString();
            String Status2 = StatCollector.translateToLocal("status." + var1.toString());
            Revival.showMessage(Status1 + Dino + " " + Status2, (EntityPlayer) this.getOwner());
        }
    }

    /**
     * Shows hearts or smoke, true=heart, false=smoke
     */
    public void showHeartsOrSmokeFX(boolean hearts, boolean poof)
    {
        String var2 = "heart";

        if (!hearts && !poof)
        {
            var2 = "smoke";
        }

        if (!hearts && poof)
        {
            var2 = "cloud";
        }

        for (int var3 = 0; var3 < 7; ++var3)
        {
            double var4 = this.rand.nextGaussian() * 0.02D;
            double var6 = this.rand.nextGaussian() * 0.02D;
            double var8 = this.rand.nextGaussian() * 0.02D;
            this.worldObj.spawnParticle(var2, this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, var4, var6, var8);
        }
    }

    public float GetDistanceWithXYZ(double var1, double var3, double var5)
    {
        return (float) Math.sqrt(Math.pow(this.posX - var1, 2.0D) + Math.pow(this.posY - var3, 2.0D) + Math.pow(this.posZ - var5, 2.0D));
    }

    public void FaceToCoord(int var1, int var2, int var3)
    {
        if (!this.isModelized())
        {
            double var4 = (double) var1;
            double var6 = (double) var3;
            float var8 = (float) (Math.atan2(var6, var4) * 180.0D / Math.PI) - 90.0F;
            this.rotationYaw = this.updateRotation(this.rotationYaw, var8, 360.0F);
        }
    }

    private float updateRotation(float var1, float var2, float var3)
    {
        float var4;

        for (var4 = var2 - var1; var4 < -180.0F; var4 += 360.0F) ;

        while (var4 >= 180.0F)
        {
            var4 -= 360.0F;
        }

        if (var4 > var3)
        {
            var4 = var3;
        }

        if (var4 < -var3)
        {
            var4 = -var3;
        }

        return var1 + var4;
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected Item getDropItem()
    {
        if (this.isModelized())
        {
            return Items.bone;
        }

        return this.SelfType.foodItem;
    }

    /**
     * Drops the rare drops
     */
    @Override
    protected void dropRareDrop(int par1)
    {
        if (this.isModelized() || !this.isAdult())
        {
            return;
        }

        int j = (new Random()).nextInt(7);
        // int var4 = this.isModelized() ? 0 : this.SelfType.ordinal();
        Item item = null;

        switch (j)
        {
            case 0:
                item = FAItemRegistry.legBone;
                break;

            case 1:
                item = FAItemRegistry.claw;
                break;

            case 2:
                item = FAItemRegistry.foot;
                break;

            case 3:
                item = FAItemRegistry.skull;
                break;

            case 4:
                item = FAItemRegistry.vertebrae;
                break;

            case 5:
                item = FAItemRegistry.armBone;
                break;

            case 6:
                item = FAItemRegistry.dinoRibCage;
                break;
        }

        this.entityDropItem(new ItemStack(item, 1, this.SelfType.ordinal()),
                0.5F);

        if (!this.isAdult())
        {
            return;
        }

        if ((new Random()).nextInt(10000) < 500)
        {
            j = (new Random()).nextInt(7);

            switch (j)
            {
                case 0:
                    item = FAItemRegistry.legBone;
                    break;

                case 1:
                    item = FAItemRegistry.claw;
                    break;

                case 2:
                    item = FAItemRegistry.foot;
                    break;

                case 3:
                    item = FAItemRegistry.skull;
                    break;

                case 4:
                    item = FAItemRegistry.vertebrae;
                    break;

                case 5:
                    item = FAItemRegistry.armBone;
                    break;

                case 6:
                    item = FAItemRegistry.dinoRibCage;
                    break;
            }
            this.entityDropItem(
                    new ItemStack(item, 1, this.SelfType.ordinal()), 0.5F);
        }
    }

    /**
     * Strange function Handling some additional effect when healing, but
     * parameter is absolute unclear
     */
    public void handleHealthUpdate(byte var1)
    {
        if (var1 == HEART_MESSAGE)
        {
            this.showHeartsOrSmokeFX(true, true);
        }
        else if (var1 == SMOKE_MESSAGE)
        {
            this.showHeartsOrSmokeFX(false, false);
        }
        else if (var1 == AGING_MESSAGE)
        {
            this.showHeartsOrSmokeFX(false, true);
            // System.out.println("AGING RECEIVED!");
            // this.updateSize();
        }
        else
        {
            super.handleHealthUpdate(var1);
        }
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean var1, int var2)
    {
        Item var3 = this.getDropItem();

        if (var3 != null)
        {
            this.entityDropItem(
                    new ItemStack(var3, MathHelper.ceiling_float_int(this
                            .getDinoAge() / 2.0F)/* 1 */, 0/* var4 */), 0.5F);
            this.dropRareDrop(var2);
        }
    }

    public boolean isAngry()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
    }

    public void setAngry(boolean var1)
    {
        byte var2 = this.dataWatcher.getWatchableObjectByte(16);

        if (var1)
        {
            this.dataWatcher.updateObject(16, (byte) (var2 | 2));
        }
        else
        {
            this.dataWatcher.updateObject(16, (byte) (var2 & -3));
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.worldObj.isRemote && !this.isTamed())
        {
            this.clearLeashed(true, true);
        }
    }

    protected boolean modelizedInteract(EntityPlayer player)
    {
        ItemStack itemstack = player.inventory.getCurrentItem();

        if (itemstack == null)
        {
            if (player.isSneaking())
            {
                this.nudgeEntity(player);
            }
            else
            {
                this.faceEntity(player, 360.0F, 360.0F);
            }
        }
        else
        {
            if (itemstack.getItem() == Items.bone)
            {
                this.increaseDinoAge();

                if (!player.capabilities.isCreativeMode)
                    --itemstack.stackSize;

                if (itemstack.stackSize <= 0)
                {
                    player.inventory.setInventorySlotContents(
                            player.inventory.currentItem, null);
                }

                return true;
            }
        }

        return false;
    }

    public void nudgeEntity(EntityPlayer player)
    {
        this.setPositionAndUpdate(
                this.posX + (player.posX - this.posX) * 0.01F, this.posY,
                this.posZ + (player.posZ - this.posZ) * 0.01F);
    }

    protected void updateEntityActionState()
    {
        if (!this.isModelized())
        {
            super.updateEntityActionState();
        }
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
    // Formerly playStepSound
    @Override
    protected void func_145780_a(int x, int y, int z, Block blockId)
    {
        if (!inWater && !this.isAdult())
        {
            super.func_145780_a(x, y, z, blockId);
        }
        else
        {
            super.func_145780_a(x, y, z, blockId);
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setBoolean("isModelized", this.isModelized());
        compound.setBoolean("Angry", this.isAngry());
        compound.setInteger("Hunger", this.getHunger());
        compound.setInteger("HungerTick", this.getHungerTick());
        compound.setInteger("DinoAge", this.getDinoAge());
        compound.setInteger("AgeTick", this.getDinoAgeTick());
        compound.setInteger("SubSpecies", this.getSubSpecies());
        compound.setByte("OrderStatus", (byte) this.OrderStatus.ordinal()/*
		 * (byte)
		 * Revival
		 * .
		 * EnumToInt
		 * (
		 * this.
		 * OrderStatus
		 * )
		 */);
		/*
		 * if (this.ItemInMouth != null) { var1.setShort("Itemid",
		 * (short)this.ItemInMouth.itemID); var1.setByte("ItemCount",
		 * (byte)this.ItemInMouth.stackSize); var1.setShort("ItemDamage",
		 * (short)this.ItemInMouth.getItemDamage()); } else {
		 * var1.setShort("Itemid", (short) - 1); var1.setByte("ItemCount",
		 * (byte)0); var1.setShort("ItemDamage", (short)0); }
		 */
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.setModelized(compound.getBoolean("isModelized"));
        this.setAngry(compound.getBoolean("Angry"));
        this.setDinoAge(compound.getInteger("DinoAge"));
        this.setDinoAgeTick(compound.getInteger("AgeTick"));
        this.setHunger(compound.getInteger("Hunger"));
        this.setHungerTick(compound.getInteger("HungerTick"));
        this.setSubSpecies(compound.getInteger("SubSpecies"));
		/*
		 * if (var3 != -1) { this.ItemInMouth = new ItemStack(var3, var4, var5);
		 * } else { this.ItemInMouth = null; }
		 */

        this.SetOrder(EnumOrderType.values()[compound.getByte("OrderStatus")]);
        // this.OrderStatus =
        // EnumOrderType.values()[compound.getByte("OrderStatus")];

        // this.updateSize();
        // this.worldObj.setEntityState(this, this.AGING_MESSAGE);//This seems
        // to be in client-> senseless
    }

    protected boolean modelizedDrop()
    {
        if (this.isModelized())
        {
            if (!this.worldObj.isRemote && !this.isDead)
            {
                this.entityDropItem(new ItemStack(FAItemRegistry.biofossil, 1), 0.0F);
                this.setDead();
            }
            return true;
        }
        return false;
    }

    // protected abstract int foodValue(Item var1);

    /**
     * returns the dinos Order status
     */
    public EnumOrderType getOrderType()
    {
        return this.OrderStatus;
    }

    public void onLivingUpdate()
    {
        if (!this.isModelized())
        {
            if (!this.worldObj.isRemote)
            {
                if (FossilConfig.allowBreeding)
                {
                    this.HandleBreed();
                }
            }

            super.onLivingUpdate();
        }
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow,
     * gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer player)
    {
        // this.getClass();//needed to set which is the actual instance using
        // this function
        if (this.isModelized())
        {
            return this.modelizedInteract(player);
        }
        else
        {
            ItemStack itemstack = player.inventory.getCurrentItem();

            if (itemstack != null)
            {
                if (itemstack.getItem() == FAItemRegistry.chickenEss
                        && !player.worldObj.isRemote)
                {
                    // Be grown up by chicken essence
                    if (this.getDinoAge() < this.SelfType.AdultAge
                            && this.getHunger() > 0)
                    {
                        if (this.getHunger() > 0)
                        {
                            if (!player.capabilities.isCreativeMode)
                            {
                                --itemstack.stackSize;
                            }

                            if (itemstack.stackSize <= 0)
                            {
                                player.inventory.setInventorySlotContents(
                                        player.inventory.currentItem,
                                        null);
                            }

                            if (!player.capabilities.isCreativeMode)
                            {
                                player.inventory
                                        .addItemStackToInventory(new ItemStack(
                                                Items.glass_bottle, 1));
                            }
                            this.setDinoAgeTick(/* this.AgingTicks */this
                                    .getDinoAgeTick() + 2000);
                            this.setHunger(1 + (new Random()).nextInt(this
                                    .getHunger()));
                            return true;
                        }
                    }

                    if (!this.worldObj.isRemote)
                    {
                        Revival.showMessage(
                                StatCollector
                                        .translateToLocal(LocalizationStrings.STATUS_ESSENCE_FAIL),
                                player);
                    }

                    return false;
                }

                if (this.SelfType.FoodItemList.CheckItem(itemstack.getItem())
                        || this.SelfType.FoodBlockList.CheckBlock(Block
                        .getBlockFromItem(itemstack.getItem())))
                {
                    // Item is one of the dinos food items
                    if (!player.worldObj.isRemote)
                    {
                        if (this.getMaxHunger() > this.getHunger())
                        {
                            // The Dino is Hungry and it can eat the item
                            // this.showHeartsOrSmokeFX(false);
                            this.worldObj.setEntityState(this, SMOKE_MESSAGE);
                            this.increaseHunger(this.SelfType.FoodItemList
                                    .getItemFood(itemstack.getItem())
                                    + this.SelfType.FoodBlockList
                                    .getBlockFood(itemstack.getItem()));

                            if (FossilConfig.healingDinos)
                            {
                                // System.out.println("Hbefore:"+String.valueOf(this.health));
                                this.heal(this.SelfType.FoodItemList
                                        .getItemHeal(itemstack.getItem())
                                        + this.SelfType.FoodBlockList.getBlockHeal(Block
                                        .getBlockFromItem(itemstack
                                                .getItem())));
                                // System.out.println("ItemHealValueInDino:"+String.valueOf(this.FoodItemList.getItemHeal(var2.itemID)+this.FoodBlockList.getBlockHeal(var2.itemID)));
                                // System.out.println("Hafter:"+String.valueOf(this.health));
                            }

                            if (this.getHunger() >= this.getMaxHunger())
                            {
                                if (this.isTamed())
                                {
                                    this.SendStatusMessage(EnumSituation.Full);
                                }

                                // this.setHunger(this.getMaxHunger());
                            }

                            --itemstack.stackSize;

							/*
							 * if (var2.stackSize <= 0) {
							 * player.inventory.setInventorySlotContents
							 * (player.inventory.currentItem, (ItemStack)null);
							 * }
							 */
                            if (!this.isTamed() && this.SelfType.isTameable()
                                    && (new Random()).nextInt(10) == 1) // taming
                            // probability
                            // 10%
                            // (not
                            // TREX!)
                            {
                                this.setTamed(true);
                                this.setOwner(player.getUniqueID().toString());

                                this.setOwnerDisplayName(player
                                        .getCommandSenderName());

                                // showHeartsOrSmokeFX(true);
                                this.worldObj.setEntityState(this,
                                        HEART_MESSAGE);
                            }

                            return true;
                        }
                        else
                        {
                            // the dino is not hungry but takes the food for
                            // later, carrying it in the mouth
                            if (this.ItemInMouth == null)
                            {
                                // It has nothing in it's mouth
                                // this.HoldItem(var2);
                                // --var2.stackSize;
								/*
								 * if (var2.stackSize <= 0) {
								 * player.inventory.setInventorySlotContents
								 * (player.inventory.currentItem,
								 * (ItemStack)null); }
								 */
                                return true;
                            }
                        }
                    }

                    return false;
                }
                else// no food, but not nothing
                {

                    if (itemstack.getItem() == Items.lead && this.allowLeashing())
                    {
                        if (func_152114_e(player))
                        {
                            this.setLeashedToEntity(player, true);
                            --itemstack.stackSize;
                            return true;
                        }
                    }

                    if (FMLCommonHandler.instance().getSide().isClient()
                            && itemstack.getItem() == FAItemRegistry.dinoPedia)
                    {
                        // DINOPEDIA
                        // EntityDinosaur.pediaingDino = this;
                        this.setPedia();
                        player.openGui(Revival.instance/* player */, 4,
                                this.worldObj, (int) this.posX,
                                (int) this.posY, (int) this.posZ);
                        return true;
                    }

                    if (itemstack.getItem() == FAItemRegistry.whip && this.isTamed()
                            && this.SelfType.isRideable() && this.isAdult()
                            && !this.worldObj.isRemote
                            && this.riddenByEntity == null
                            && func_152114_e(player))
                    {
                        this.setSitting(false);
                        this.SetOrder(EnumOrderType.FreeMove);
                        // this.OrderStatus = EnumOrderType.FreeMove;
                        setRidingPlayer(player);
                    }

                    if (this.SelfType.orderItem != null
                            && itemstack.getItem() == this.SelfType.orderItem
                            && this.isTamed() && func_152114_e(player)
                            && !player.isRiding())
                    {
                        // THIS DINOS ITEM TO BE CONTROLLED WITH
                        if (!this.worldObj.isRemote)
                        {
                            this.isJumping = false;
                            this.setPathToEntity(null);
                            this.OrderStatus = EnumOrderType.values()[(this.OrderStatus
                                    .ordinal() + 1) % 3];

                            this.SendOrderMessage(this.OrderStatus);

                            if (this.OrderStatus == EnumOrderType.Stay)
                            {
                                this.getNavigator().clearPathEntity();
                                this.setPathToEntity(null);
                                this.setSitting(true);
                            }
                            else
                            {
                                this.setSitting(false);
                            }
                        }

                        return true;
                    }

                    if (this.SelfType.canCarryItems()
                            && itemstack.getItem() != FAItemRegistry.dinoPedia
                            && this.ItemInMouth == null
                            && ((this.isTamed() && player == this.getOwner()) || (new Random())
                            .nextInt(40) == 1))
                    {
                        // The dino takes the item if: able to, has nothing now
                        // and is tamed by the user or willingly(2.5%)
                        // this.HoldItem(var2);
                        // --var2.stackSize;

                        if (itemstack.stackSize <= 0)
                        {
                            player.inventory.setInventorySlotContents(
                                    player.inventory.currentItem,
                                    null);
                        }

                        return true;
                    }
                }
            }

            return super.interact(player);
        }
    }

    public void setOwner(String ownerName)
    {
        this.func_152115_b(ownerName);
    }

    // public void CheckSkin() {}

    public boolean allowLeashing()
    {
        return !this.getLeashed() && !(this instanceof IMob) && this.isTamed();
    }

    public int BlockInteractive()
    {
        return 0;
    }

    /**
     * returns true if all the conditions for steering the entity are met. For
     * pigs, this is true if it is being ridden by a player and the player is
     * holding a carrot-on-a-stick
     */
	/*
	 * public boolean canBeSteered() { ItemStack var1 =
	 * ((EntityPlayer)this.riddenByEntity).getHeldItem(); return var1 != null &&
	 * var1.itemID == Revival.whip.itemID; }
	 */
    public void SetOrder(EnumOrderType var1)
    {
        this.OrderStatus = var1;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable var1)
    {
        return null;
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    @Override
    protected boolean canDespawn()
    {
        return false;
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(
            IEntityLivingData par1EntityLivingData)
    {
        par1EntityLivingData = super.onSpawnWithEgg(par1EntityLivingData);
        Random random = new Random();
        this.setSubSpecies(random.nextInt(4) + 1);
        this.setDinoAge(this.SelfType.AdultAge);
        this.updateSize();
        this.heal(200);
        return par1EntityLivingData;
    }

    public EntityPlayer getRidingPlayer()
    {
        if (riddenByEntity instanceof EntityPlayer)
        {
            return (EntityPlayer) riddenByEntity;
        }
        else
        {
            return null;
        }
    }

    public void setRidingPlayer(EntityPlayer player)
    {
        player.rotationYaw = this.rotationYaw;
        player.rotationPitch = this.rotationPitch;
        player.mountEntity(this);
    }


    public boolean isInvulnerable(DamageSource var1)
    {

        Entity srcEnt = var1.getEntity();
        if (srcEnt != null)
        {
            // ignore own damage
            if (srcEnt == this)
            {
                return true;
            }

            // ignore damage from rider
            if (srcEnt == riddenByEntity)
            {
                return true;
            }
        }

        return false;
    }

    /*
     * Call this function when a player is riding a dinosaur and right clicks
     * with whip. Override in dinosaur classes to create unique actions.
     */
    public void onWhipRightClick()
    {
    }
}