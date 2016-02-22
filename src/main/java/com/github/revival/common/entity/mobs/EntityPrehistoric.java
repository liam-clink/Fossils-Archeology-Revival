package com.github.revival.common.entity.mobs;

import com.github.revival.Revival;
import com.github.revival.client.gui.GuiPedia;
import com.github.revival.common.item.FAItemRegistry;
import com.github.revival.common.tileentity.TileEntityFeeder;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public abstract class EntityPrehistoric extends EntityAgeable {

    public static int ticksPerAge = 12000;

    // Instance properties
    private int age;
    private float exp;
    private int hunger;
    private boolean inHerd;
    private boolean isWild;
    private boolean isStatue;
    private EnumEntityPrehistoric type;
    private String ownerDisplayName;
    private ItemStack itemCarrying;
    private EntityAIBase aiInControl;
    private int subSpecies;
    private boolean male;
    private Vec3 home;

    public EntityPrehistoric(World world, EnumEntityPrehistoric type, int subSpecies, ModelBase model) {
        super(world);
        this.type = type;
        this.exp = type.getBaseExp();
        this.subSpecies = subSpecies;
        this.hunger = type.getMaxHunger() / 2;
        this.setSize(type.getBaseBoundingBoxHeight(), type.getBaseBoundingBoxWidth());
        if ((new Random()).nextBoolean()) {
            male = true;
        } else {
            male = false;
        }
        //this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(type.getMaxHealth());
    }

	/*
     * 	TODO
	 * 		-Get sounds
	 */

    /**
     * Method to add all mob ai
     */
    abstract void addAI();

    abstract boolean tryTame(EntityPlayer player);

    @Override
    public boolean interact(EntityPlayer player) {
        if (this.isStatue) {
            return statueInteract(player);
        }

        return tryTame(player);
    }

    private boolean statueInteract(EntityPlayer player) {
        ItemStack itemStack = player.inventory.getCurrentItem();

        if (itemStack.getItem().equals(Items.bone)) {
            this.age++;
            if (!player.capabilities.isCreativeMode) {
                itemStack.stackSize--;
                if (itemStack.stackSize == 0) {
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                }
            }
            return true;
        } else {
            if (player.isSneaking()) {
                this.setPositionAndUpdate(this.posX + (this.posX - player.posX) * 0.1F, this.posY, this.posZ + (this.posZ - player.posZ) * 0.1F);
            } else {
                this.faceEntity(player, 360.0F, 360.0F);
            }
        }
        return false;
    }

    /**
     * Shows the dinopedia
     *
     * @param p0
     */
    @SideOnly(Side.CLIENT)
    public void ShowPedia2(GuiPedia p0) {
        p0.reset();
        p0.addStringLR("", 150, false);
        String translatePath = "assets/fossil/dinopedia/" + Minecraft.getMinecraft().gameSettings.language + "/";
        String bioFile = type.toString() + ".txt";

        if (getClass().getClassLoader().getResourceAsStream(translatePath) == null) {
            translatePath = "assets/fossil/dinopedia/" + "en_US" + "/";
        }

        if (getClass().getClassLoader().getResourceAsStream(translatePath + bioFile) != null) {
            InputStream fileReader = getClass().getClassLoader().getResourceAsStream(translatePath + bioFile);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileReader));
                StringBuffer stringBuffer = new StringBuffer();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    GL11.glPushMatrix();
                    GL11.glScalef(0.5F, 0.5F, 0.5F);
                    p0.addStringLR(line, 150, false);
                    GL11.glPopMatrix();
                }
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            p0.addStringLR("File not found.", false);
            GL11.glPushMatrix();
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            p0.addStringLR(translatePath + bioFile, 150, false);
            GL11.glPopMatrix();
        }
    }

    @Override
    protected void dropFewItems(boolean var1, int numToDrop) {
        this.entityDropItem(new ItemStack(getDropItem(), numToDrop, 0), 0.5F);
    }


    @Override
    protected void dropRareDrop(int numToDrop) {
        if (this.isStatue || this.isChild()) {
            return;
        }

        Item toDrop = null;
        switch ((new Random()).nextInt(7)) {
            case 0:
                toDrop = FAItemRegistry.legBone;
                break;

            case 1:
                toDrop = FAItemRegistry.claw;
                break;

            case 2:
                toDrop = FAItemRegistry.foot;
                break;

            case 3:
                toDrop = FAItemRegistry.skull;
                break;

            case 4:
                toDrop = FAItemRegistry.vertebrae;
                break;

            case 5:
                toDrop = FAItemRegistry.armBone;
                break;

            case 6:
                toDrop = FAItemRegistry.dinoRibCage;
                break;
        }
        entityDropItem(new ItemStack(toDrop, 1, type.ordinal()), 0.5F);

        if (!this.isAdult()) {
            return;
        }

        if ((new Random()).nextInt(20) == 0) {
            switch ((new Random()).nextInt(7)) {
                case 0:
                    toDrop = FAItemRegistry.legBone;
                    break;

                case 1:
                    toDrop = FAItemRegistry.claw;
                    break;

                case 2:
                    toDrop = FAItemRegistry.foot;
                    break;

                case 3:
                    toDrop = FAItemRegistry.skull;
                    break;

                case 4:
                    toDrop = FAItemRegistry.vertebrae;
                    break;

                case 5:
                    toDrop = FAItemRegistry.armBone;
                    break;

                case 6:
                    toDrop = FAItemRegistry.dinoRibCage;
                    break;
            }
            entityDropItem(new ItemStack(toDrop, 1, type.ordinal()), 0.5F);
        }

    }

    /**
     * Spawns either a heart, smoke, or cloud particle
     * 0 - heart
     * 1 - smoke
     * 2 - cloud
     *
     * @param particleID
     */
    public void spawnParticle(int particleID) {
        String particleString = "";

        switch (particleID) {
            case 0:
                particleString = "heart";
                break;
            case 1:
                particleString = "smoke";
                break;
            case 2:
                particleString = "cloud";
                break;
        }

        for (int i = 0; i < 7; i++) {
            double var4 = this.rand.nextGaussian() * 0.02D;
            double var6 = this.rand.nextGaussian() * 0.02D;
            double var8 = this.rand.nextGaussian() * 0.02D;
            this.worldObj.spawnParticle(particleString, this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, var4, var6, var8);
        }
    }

    /**
     * Eats from a feeder
     *
     * @param feeder
     */
    public void eatFromFeeder(TileEntityFeeder feeder) {
        while (hunger <= type.getMaxHunger() && (feeder.MeatCurrent > 0 || feeder.VegCurrent > 0)) {
            if (feeder.MeatCurrent > 0) {
                hunger++;
                feeder.MeatCurrent--;
            }
            if (feeder.VegCurrent > 0) {
                hunger++;
                feeder.VegCurrent--;
            }
        }

    }

    /**
     * Points the entity in a direction and moves it
     */
    @Override
    public void moveEntityWithHeading(float xHeading, float yHeading) {
        if (!isStatue()) {
            super.moveEntityWithHeading(xHeading, yHeading);
            if (this.riddenByEntity != null || this.isAdult()) {
                this.stepHeight = 1.0F;
            } else {
                this.stepHeight = 0.5F;
            }
        }
    }

    /**
     * Gets the riding player
     *
     * @return
     */
    public EntityPlayer getRidingPlayer() {
        if (riddenByEntity instanceof EntityPlayer) {
            return (EntityPlayer) riddenByEntity;
        }
        return null;
    }

    @Override
    protected Item getDropItem() {
        if (this.isStatue) {
            return FAItemRegistry.biofossil;
        }
        return type.getDropItem();
    }

    /**
     * Attacks an entity
     *
     * @param target
     */
    @Override
    public boolean attackEntityAsMob(Entity target) {

        boolean attacked = target.attackEntityFrom(DamageSource.causeMobDamage(this), (float) this.getStrength());

        if (attacked) {

        }

        return attacked;
    }

    /**
     * Runs when mob is attacked
     */
    @Override
    public boolean attackEntityFrom(DamageSource attacker, float var2) {
        if (attacker.getEntity().equals(riddenByEntity) || attacker.getEntity().equals(this)) {
            return false;
        }
        if (dropStatue()) {
            return true;
        }
        return super.attackEntityFrom(attacker, var2);
    }

    /**
     * Executes when the mob kills an entity
     * TODO
     * -Add hunger and health values for other mobs
     */
    @Override
    public void onKillEntity(EntityLivingBase entity) {
        if (entity instanceof EntityPrehistoric) {
            addHunger(((EntityPrehistoric) entity).getType().getHungerIfEaten());
            heal(((EntityPrehistoric) entity).getType().getHealthIfEaten());
        }
    }

    public int pickupItem(ItemStack item) {
        if (type.willEat(item.getItem())) {
            eat(item);
        } else {
            holdItem(item);
        }
        return 0;
    }

    public void eat(ItemStack itemstack) {
        EnumEdibleFoodstuff food = EnumEdibleFoodstuff.getFromItem(itemstack.getItem());
        while (this.hunger < type.getMaxHunger() && itemstack.stackSize > 0) {
            this.hunger += food.getBaseHungerHeal();
            this.setHealth(this.getHealth() + food.getBaseHealthHeal());
            itemstack.stackSize--;
        }
        if (this.hunger < type.getMaxHunger()) {
            this.hunger = type.getMaxHunger();
        }
    }

    public void holdItem(ItemStack item) {
        this.itemCarrying = new ItemStack(item.getItem(), item.getItemDamage());
    }

    public boolean dropStatue() {
        if (isStatue()) {
            if (!this.worldObj.isRemote && !this.isDead) {
                this.entityDropItem(new ItemStack(FAItemRegistry.biofossil, 1), 0.0F);
                this.setDead();
            }
            return true;
        }
        return false;
    }

    public void setPathToEntity(Entity entity) {
        // TODO
    }

    public void setPathToPosition(Vec3 location) {
        // TODO
    }

    @Override
    public float getEyeHeight() {
        return type.getBaseEyeHeight() * this.getSize();
    }

    /**
     * Interpolates the strength of the mob
     *
     * @return
     */
    public double getStrength() {
        double step = (type.getMaxStrength() - type.getBaseStrength()) / (type.getAdultAge());
        if (this.age > type.getAdultAge()) {
            return type.getBaseStrength() + (step * type.getAdultAge());
        }
        return type.getBaseStrength() + (step * age);
    }

    /**
     * Interpolates the size of the mob
     *
     * @return
     */
    public float getSize() {
        float step = (type.getMaxSize() - type.getBaseSize()) / (type.getAdultAge());
        if (this.age > type.getAdultAge()) {
            return type.getBaseSize() + (step * type.getAdultAge());
        }
        return type.getBaseSize() + (step * age);
    }

    /**
     * Sets the scale of the dinosaur
     */
    @Override
    public void setScaleForAge(boolean child) {
        this.setScale(getSize());
    }

    private void setPedia() {
        Revival.toPedia = this;
    }

    public int getSubSpecies() {
        return subSpecies;
    }

    /**
     * Dino can't climb ladder
     */
    @Override
    public boolean isOnLadder() {
        return false;
    }

    /**
     * Gets the experience points of the mob
     */
    @Override
    protected int getExperiencePoints(EntityPlayer player) {
        return (int) exp;
    }

    @Override
    public boolean isAIEnabled() {
        return !this.isStatue && !this.worldObj.isRemote;
    }

    @Override
    public boolean canBePushed() {
        return !this.isStatue;
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    /**
     * Gets the age of the mob
     */
    public int getAge() {
        return age;
    }

    /**
     * Increments the age of the mob
     */
    public void incrementAge() {
        age++;
        exp += type.getExpDaily();
    }

    /**
     * Gets the mob hunger
     *
     * @return
     */
    public int getHunger() {
        return hunger;
    }

    /**
     * Decrements the hunger
     */
    public void decrementHunger() {
        if (hunger > 0) {
            hunger--;
        }
    }

    /**
     * Adds hunger to hunger
     *
     * @param hunger
     */
    public boolean addHunger(int hunger) {
        if (this.hunger >= type.getMaxHunger()) {
            this.hunger = type.getMaxHunger();
            return false;
        }
        this.hunger += hunger;
        if (this.hunger > type.getMaxHunger()) {
            this.hunger = type.getMaxHunger();
        }
        this.worldObj.playSoundAtEntity(this, "random.eat", this.getSoundVolume(), this.getSoundPitch());
        return true;
    }

    /**
     * Gets the type of the mob for property referencing
     *
     * @return
     */
    public EnumEntityPrehistoric getType() {
        return type;
    }

    /**
     * Gets the owner's display name
     *
     * @return
     */
    public String getOwnerDisplayName() {
        return ownerDisplayName;
    }

    /**
     * Sets the owner's display name
     *
     * @param ownerDisplayName
     */
    public void setOwnerDisplayName(String ownerDisplayName) {
        this.ownerDisplayName = ownerDisplayName;
    }

    /**
     * Returns true if the mob is a statue
     *
     * @return
     */
    public boolean isStatue() {
        return isStatue;
    }

    public void setStatue(boolean isStatue) {
        this.isStatue = isStatue;
    }

    /**
     * Returns true if the mob is in a herd
     *
     * @return
     */
    public boolean isInHerd() {
        return inHerd;
    }

    /**
     * Returns true if the mob is wild
     *
     * @return
     */
    public boolean isWild() {
        return isWild;
    }

    /**
     * Returns true if the mob is an adult
     *
     * @return
     */
    public boolean isAdult() {
        return this.age >= type.getAdultAge();
    }

    /**
     * Returns true if the mob is a teen
     *
     * @return
     */
    public boolean isTeen() {
        return this.age >= type.getTeenAge();
    }

    /**
     * Returns true if the mob is a child
     */
    public boolean isChild() {
        return this.age < type.getTeenAge();
    }

    public boolean hasOwner() {
        return ownerDisplayName == null || ownerDisplayName.isEmpty();
    }

    public boolean isMale() {
        return male;
    }

    /**
     * Returns 0 if not hungry, 1 if slightly hungry, 2 if deadly hungry
     *
     * @return
     */
    public int hungerLevel() {
        float hungerRatio = ((float) hunger) / type.getMaxHunger();
        if (hungerRatio < type.getHungerLevel()) {
            if (hungerRatio < type.getHungerLevel() / 4) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    protected String getModelTexture() {
        return Revival.MODID + ":" + "textures/mob/DinosaurModels/DinoModel" + type.toString() + ".png";
    }

    public String getTexture() {
        // TODO
        return null;
    }

    public Vec3 getHome() {
        return home;
    }

    public void setHome(Vec3 home) {
        this.home = home;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setBoolean("isStatue", this.isStatue);
        compound.setInteger("Hunger", this.hunger);
        compound.setInteger("DinoAge", this.age);
        compound.setInteger("SubSpecies", this.subSpecies);
        compound.setFloat("Experience", this.exp);
        // Set hunger + age tick and task + target
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.isStatue = compound.getBoolean("isStatue");
        this.hunger = compound.getInteger("Hunger");
        this.age = compound.getInteger("DinoAge");
        this.subSpecies = compound.getInteger("SubSpecies");
        this.exp = compound.getFloat("Experience");
        // get hunger + age tick and task + target
    }

    /**
     * Calculates the distance to a location
     *
     * @param location
     * @return
     */
    public double distanceToLocation(Vec3 location) {
        return Math.sqrt(Math.pow(posX - location.xCoord + 0.5, 2) + Math.pow(posZ - location.zCoord + 0.5, 2));
    }

    /**
     * Calculates the distance to an entity
     *
     * @param entity
     * @return
     */
    public double distanceToEntity(Entity entity) {
        return Math.sqrt(Math.pow(posX - entity.posX, 2) + Math.pow(posZ - entity.posZ, 2));
    }

    /**
     * Calculates the distance to a feeder
     *
     * @param entity
     * @return
     */
    public double distanceToFeeder(TileEntityFeeder entity) {
        return Math.sqrt(Math.pow(posX - entity.xCoord + 0.5, 2) + Math.pow(posY - entity.yCoord + 0.5, 2));
    }

    /**
     * Calculates the distance status of a location
     * 0 - not aware, 1 - needs line of sight, 2 - immediately aware
     *
     * @param location
     * @return
     */
    public int distanceStatus(Vec3 location) {
        double distance = this.distanceToLocation(location);
        if (distance < type.getImmediateAwarenessRadius()) {
            return 2;
        } else if (distance < type.getMaxAwarenessRadius()) {
            return 1;
        }
        return 0;
    }

    /**
     * Calculates the distance status of an entity.
     *
     * @param entity
     * @return
     */
    public int distanceStatus(Entity entity) {
        return distanceStatus(Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ));
    }

    /**
     * Calculates the distance status of a feeder
     *
     * @param entity
     * @return
     */
    public int distanceStatus(TileEntityFeeder entity) {
        return distanceStatus(Vec3.createVectorHelper(entity.xCoord, entity.yCoord, entity.zCoord));
    }

    /**
     * Calculates whether the entity can be seen.  Checks both visibility and field of view
     *
     * @param entity
     * @return
     */
    private boolean canSeeEntity(Entity entity) {
        boolean canSeeAnyDir = worldObj.rayTraceBlocks(Vec3.createVectorHelper(posX, posY, posZ), Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ)) == null;
        boolean entityWithinFieldOfView = Vec3.createVectorHelper(entity.posX - posX, entity.posY - posY, entity.posZ - posZ).normalize().dotProduct(getLookVec()) > 0.8;
        return canSeeAnyDir && entityWithinFieldOfView;
    }

    /**
     * Checks if the entity can see the block.  Only checks the possible 3 faces
     *
     * @param position
     * @return
     */
    private boolean rayTraceBlock(Vec3 position) {
        if (posY >= position.yCoord) {
            if (canSeeBlockFace(position, 0)) {
                return true;
            }
        } else {
            if (canSeeBlockFace(position, 1)) {
                return true;
            }
        }
        if (Math.abs(posX - position.xCoord) >= Math.abs(posZ - position.zCoord)) {
            if (posX >= position.xCoord) {
                if (canSeeBlockFace(position, 2)) {
                    return true;
                }
            } else {
                if (canSeeBlockFace(position, 3)) {
                    return true;
                }
            }
        } else {
            if (posZ >= position.zCoord) {
                if (canSeeBlockFace(position, 4)) {
                    return true;
                }
            } else {
                if (canSeeBlockFace(position, 5)) {
                    return true;
                }
            }
        }
        if (Math.abs(posX - position.xCoord) >= Math.abs(posZ - position.zCoord)) {
            if (posZ >= position.zCoord) {
                if (canSeeBlockFace(position, 4)) {
                    return true;
                }
            } else {
                if (canSeeBlockFace(position, 5)) {
                    return true;
                }
            }
        } else {
            if (posX >= position.xCoord) {
                if (canSeeBlockFace(position, 2)) {
                    return true;
                }
            } else {
                if (canSeeBlockFace(position, 3)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if the entity can see a blocks face.
     * 0 = y+
     * 1 = y-
     * 2 = x+
     * 3 = x-
     * 4 = z+
     * 5 = z-
     *
     * @param position
     * @param face
     * @return
     */
    private boolean canSeeBlockFace(Vec3 position, int face) {
        Vec3 target = null;
        switch (face) {
            case 0:
                target = position.addVector(0.5, 1.0, 0.5);
                break;
            case 1:
                target = position.addVector(0.5, 0.0, 0.5);
                break;
            case 2:
                target = position.addVector(1.0, 0.5, 0.5);
                break;
            case 3:
                target = position.addVector(0.0, 0.5, 0.5);
                break;
            case 4:
                target = position.addVector(0.5, 0.5, 1.0);
                break;
            case 5:
                target = position.addVector(0.5, 0.5, 0.0);
                break;
        }
        MovingObjectPosition hit = worldObj.rayTraceBlocks(Vec3.createVectorHelper(posX, posY + getEyeHeight(), posZ), target);
        return vec3Equals(Vec3.createVectorHelper(hit.blockX, hit.blockY, hit.blockZ), position);
    }

    /**
     * Calculates whether the feeder can be seen.  Checks both visibility and field of view
     *
     * @param entity
     * @return
     */
    private boolean canSeeBlock(Vec3 position) {
        boolean canSeeAnyDir = rayTraceBlock(position);
        boolean blockWithinFieldOfView = Vec3.createVectorHelper(position.xCoord - posX + 0.5, position.yCoord - posY + 0.5, position.zCoord - posZ + 0.5).normalize().dotProduct(getLookVec()) > 0.8;
        return canSeeAnyDir && blockWithinFieldOfView;
    }

    /**
     * Calculates whether or not the entity can be found
     *
     * @param entity
     * @return
     */
    public boolean canFindEntity(Entity entity) {
        switch (distanceStatus(entity)) {
            case 0:
                return false;
            case 1:
                return canSeeEntity(entity);
            case 2:
                return true;
        }
        return false;
    }

    /**
     * Calculates whether or not the feeder can be found
     *
     * @param entity
     * @return
     */
    public boolean canFindFeeder(TileEntityFeeder entity) {
        return canFindBlock(Vec3.createVectorHelper(entity.xCoord, entity.yCoord, entity.zCoord));
    }

    /**
     * Calculates whether or not a block can be found
     *
     * @param block
     * @return
     */
    public boolean canFindBlock(Vec3 block) {
        switch (distanceStatus(block)) {
            case 0:
                return false;
            case 1:
                return canSeeBlock(block);
            case 2:
                return true;
        }
        return false;
    }

    private boolean vec3Equals(Vec3 v1, Vec3 v2) {
        return v1.xCoord == v2.xCoord && v1.yCoord == v2.yCoord && v1.zCoord == v2.zCoord;
    }

}
