package com.github.revival.server.entity.mob;

import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.Activity;
import com.github.revival.server.enums.EnumPrehistoricAI.Attacking;
import com.github.revival.server.enums.EnumPrehistoricAI.Climbing;
import com.github.revival.server.enums.EnumPrehistoricAI.Following;
import com.github.revival.server.enums.EnumPrehistoricAI.Jumping;
import com.github.revival.server.enums.EnumPrehistoricAI.Moving;
import com.github.revival.server.enums.EnumPrehistoricAI.Response;
import com.github.revival.server.enums.EnumPrehistoricAI.Stalking;
import com.github.revival.server.enums.EnumPrehistoricAI.Taming;
import com.github.revival.server.enums.EnumPrehistoricAI.Untaming;
import com.github.revival.server.enums.EnumPrehistoricAI.WaterAbility;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityDodo extends EntityNewPrehistoric {

    public static final double baseDamage = 1;
    public static final double maxDamage = 1;
    public static final double baseHealth = 4;
    public static final double maxHealth = 10;
    public static final double baseSpeed = 0.2D;
    public static final double maxSpeed = 0.4D;
    public static final int FAT_INDEX = 29;

    public EntityDodo(World world) {
        super(world, EnumPrehistoric.Dodo);
        this.setSize(0.8F, 0.7F);
        this.nearByMobsAllowed = 10;
        minSize = 0.5F;
        maxSize = 1F;
        teenAge = 2;
        developsResistance = false;
        breaksBlocks = false;
        favoriteFood = Items.melon;
        hasTeenTexture = false;
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(FAT_INDEX, 0);
    }

    public int getFat() {
        return this.dataWatcher.getWatchableObjectInt(FAT_INDEX);
    }

    public void setFat(int var1) {
        this.dataWatcher.updateObject(FAT_INDEX, var1);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setFat(compound.getInteger("FatLevel"));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setInteger("FatLevel", this.getFat());
    }

    @Override
    public void setSpawnValues() {
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(baseSpeed);
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(baseHealth);
        getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(baseDamage);
    }

    @Override
    public Activity aiActivityType() {

        return Activity.DIURINAL;
    }

    @Override
    public Attacking aiAttackType() {

        return Attacking.BASIC;
    }

    @Override
    public Climbing aiClimbType() {

        return Climbing.NONE;
    }

    @Override
    public Following aiFollowType() {

        return Following.NORMAL;
    }

    @Override
    public Jumping aiJumpType() {

        return Jumping.BASIC;
    }

    @Override
    public Response aiResponseType() {

        return Response.SCARED;
    }

    @Override
    public Stalking aiStalkType() {

        return Stalking.NONE;
    }

    @Override
    public Taming aiTameType() {

        return Taming.FEEDING;
    }

    @Override
    public Untaming aiUntameType() {

        return Untaming.NONE;
    }

    @Override
    public Moving aiMovingType() {

        return Moving.WALKANDGLIDE;
    }

    @Override
    public WaterAbility aiWaterAbilityType() {

        return WaterAbility.NONE;
    }

    @Override
    public boolean doesFlock() {
        return false;
    }

    @Override
    public Item getOrderItem() {
        return Items.stick;
    }

    @Override
    public void updateSize() {
        double healthStep;
        double attackStep;
        double speedStep;
        healthStep = (maxHealth - baseHealth) / (this.getAdultAge() + 1);
        attackStep = (maxDamage - baseDamage) / (this.getAdultAge() + 1);
        speedStep = (maxSpeed - baseSpeed) / (this.getAdultAge() + 1);


        if (this.getDinoAge() <= this.getAdultAge()) {

            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(Math.round(baseHealth + (healthStep * this.getDinoAge())));
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(Math.round(baseDamage + (attackStep * this.getDinoAge())));
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(baseSpeed + (speedStep * this.getDinoAge()));
        }
    }

    @Override
    public int getAdultAge() {
        return 5;
    }

    @Override
    public boolean interact(EntityPlayer player) {
        super.interact(player);
        ItemStack itemstack = player.inventory.getCurrentItem();
        if (itemstack != null) {
            if (itemstack.getItem() != null) {
                if (itemstack.getItem() == Items.melon_seeds) {
                    System.out.println("lel");
                    if (this.getFat() < 10) {
                        this.setFat(this.getFat() + 1);
                        this.worldObj.playSoundAtEntity(this, "random.eat",
                                this.getSoundVolume(), this.getSoundPitch());
                    } else {
                        if (!this.worldObj.isRemote) {
                            this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 2, true);
                        }
                        this.setDinoAge(1);
                        this.setFat(0);
                    }
                }
            }
        }
        return super.interact(player);
    }

    @Override
    public boolean allowLeashing() {
        return true;
    }

    @Override
    public void onLivingUpdate() {
        this.pediaScale = 40F;

        super.onLivingUpdate();
        this.motionX *= 0;
        this.motionZ *= 0;
        if (this.getFat() > 5) {
            this.motionY += 0.1D;
            if (this.posY > 200) {
                if (!this.worldObj.isRemote) {
                    this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 2, true);
                }
                this.setDinoAge(1);
                this.setFat(0);
            }
        }
    }

    @Override
    protected String getLivingSound() {
        return "fossil:dodo_living";
    }

    @Override
    protected String getHurtSound() {
        return "fossil:dodo_hurt";
    }

    @Override
    protected String getDeathSound() {
        return "fossil:dodo_death";
    }

}
