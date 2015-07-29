package com.github.revival.common.entity.mob;

import com.github.revival.Revival;
import com.github.revival.client.gui.GuiPedia;
import com.github.revival.common.entity.ai.DinoAIAttackBabies;
import com.github.revival.common.enums.EnumPrehistoric;
import com.github.revival.common.item.FAItemRegistry;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class EntityConfuciusornis extends EntityAnimal
{
    private static final ResourceLocation icon = new ResourceLocation("fossil:textures/items/Egg_Cultivated_Confuciusornis.png");
    public boolean field_70885_d = false;
    public float field_70886_e = 0.0F;
    public float destPos = 0.0F;
    public float field_70884_g;
    public float field_70888_h;
    public float field_70889_i = 1.0F;
    /**
     * The time until the next egg is spawned.
     */
    public int timeUntilNextEgg;
    public boolean isFlying;
    public ChunkCoordinates currentTarget;
    public DinoAIAttackBabies aiAttackBabies = new DinoAIAttackBabies(this, EntityCompsognathus.class, 0, false);
    EntityPrehistoric entityPrehistoricClass = new EntityPrehistoric(worldObj);

    public EntityConfuciusornis(World par1World)
    {
        super(par1World);
        this.setSize(0.5F, 0.5F);
        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.4D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.0D, Items.pumpkin_seeds, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(3, this.aiAttackBabies);
        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityTyrannosaurus.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityVelociraptor.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityTerrorBird.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityAllosaurus.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityDeinonychus.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityDilophosaurus.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntitySarcosuchus.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityPterosaur.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntitySpinosaurus.class, 16.0F, 0.8D, 1.33D));

    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    protected Item getDropItem()
    {
        return Items.feather;
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    protected void dropFewItems(boolean par1, int par2)
    {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);

        for (int k = 0; k < j; ++k)
        {
            this.dropItem(Items.feather, 1);
        }

        if (this.isBurning())
        {
            this.dropItem(EnumPrehistoric.Confuciusornis.cookedFoodItem, 1);
        }
        else
        {
            this.dropItem(EnumPrehistoric.Confuciusornis.foodItem, 1);
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource var1, float var2)
    {
        flyAround();
        return super.attackEntityFrom(var1, var2);

    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(18, Byte.valueOf((byte) 0));
    }

    private void setPedia()
    {
        Revival.toPedia = (Object) this;
    }

    @Override
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return Revival.modid + ":" + "confuciusornis_living";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected String getHurtSound()
    {
        return Revival.modid + ":" + "confuciusornis_hurt";
    }

    @Override
    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return Revival.modid + ":" + "confuciusornis_death";
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float par1)
    {
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.2F;
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer var1)
    {
        ItemStack var2 = var1.inventory.getCurrentItem();

        if (var2 != null && FMLCommonHandler.instance().getSide().isClient() && var2.getItem() == FAItemRegistry.dinoPedia)
        {
            this.setPedia();
            var1.openGui(Revival.instance, 4, this.worldObj, (int) this.posX, (int) this.posY, (int) this.posZ);
            return true;
        }

        return super.interact(var1);
    }

    /**
     * This function is used when two same-species animals in 'love mode' breed to generate the new baby animal.
     */
    public EntityConfuciusornis spawnBabyAnimal(EntityAgeable par1EntityAgeable)
    {
        return new EntityConfuciusornis(this.worldObj);
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack par1ItemStack)
    {
        return par1ItemStack != null && par1ItemStack.getItem() == Items.pumpkin_seeds;
    }

    public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
    {
        return this.spawnBabyAnimal(par1EntityAgeable);
    }

    public Object Imprinting(double posX, double posY, double posZ)
    {
        return this;
    }

    @SideOnly(Side.CLIENT)
    public void ShowPedia(GuiPedia p0)
    {
        p0.reset();

        if (this.hasCustomNameTag())
        {
            p0.PrintStringXY(this.getCustomNameTag(), p0.rightIndent, 24, 40, 90, 245);
        }

        p0.PrintStringXY(StatCollector.translateToLocal("entity.fossil.Confuciusornis.name"), p0.rightIndent, 34, 0, 0, 0);
        p0.PrintPictXY(icon, ((p0.xGui / 2) + (p0.xGui / 4)), 7, 16, 16);
        p0.AddStringLR("No Despawn", true);
        //p0.AddStringLR(LocalizationStrings.PEDIA_TEXT_FLY, true);
    }

    protected void updateFallState(double par1, boolean par3)
    {
    }

    public void setFlying(boolean state)
    {
        isFlying = state;
    }

    public void onLivingUpdate()
    {
        this.field_70888_h = this.field_70886_e;
        this.field_70884_g = this.destPos;
        this.destPos = (float) ((double) this.destPos + (double) (this.onGround ? -1 : 4) * 0.3D);

        if (this.destPos < 0.0F)
        {
            this.destPos = 0.0F;
        }

        if (this.destPos > 1.0F)
        {
            this.destPos = 1.0F;
        }

        if (!this.onGround && this.field_70889_i < 1.0F)
        {
            this.field_70889_i = 1.0F;
        }

        this.field_70889_i = (float) ((double) this.field_70889_i * 0.9D);

        if (!this.onGround && this.motionY < 0.0D)
        {
            this.motionY *= 0.6D;
        }

        this.field_70886_e += this.field_70889_i * 2.0F;

        if (!this.isChild() && !this.worldObj.isRemote && --this.timeUntilNextEgg <= 0)
        {
            this.playSound("mob.chicken.plop", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(EnumPrehistoric.Confuciusornis.birdEggItem, 1);
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }
        if (motionY < 0.0D)
        {
            motionY *= 0.6D;
        }
        if (this.riddenByEntity == null)
        {
            if (!this.isChild())
            {
                if (!worldObj.isRemote)
                {
                    if (getEntityToAttack() == null)
                    {
                        if (rand.nextInt(200) == 0)
                            if (!isFlying)
                                setFlying(true);
                            else
                                setFlying(false);

                        if (isFlying)
                        {
                            flyAround();
                        }
                        else
                        {

                        }

                        if (getEntityToAttack() != null)
                        {
                            currentTarget = new ChunkCoordinates(
                                    (int) getEntityToAttack().posX,
                                    (int) ((int) getEntityToAttack().posY + getEntityToAttack()
                                            .getEyeHeight()),
                                    (int) getEntityToAttack().posZ);
                            setFlying(false);
                            flyTowardsTarget();
                        }
                    }
                }
            }
        }
        super.onLivingUpdate();
    }

    public void flyTowardsTarget()
    {
        if (currentTarget != null)
        {
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

    public void flyAround()
    {
        if (currentTarget != null)
            if (!worldObj.isAirBlock(currentTarget.posX, currentTarget.posY,
                    currentTarget.posZ) || currentTarget.posY < 1)
                currentTarget = null;

        if (currentTarget == null
                || rand.nextInt(30) == 0
                || currentTarget.getDistanceSquared((int) posX, (int) posY,
                (int) posZ) < 10F)
            currentTarget = new ChunkCoordinates((int) posX + rand.nextInt(90)
                    - rand.nextInt(60), (int) posY + rand.nextInt(60) - 2,
                    (int) posZ + rand.nextInt(90) - rand.nextInt(60));

        flyTowardsTarget();
    }

    @SideOnly(Side.CLIENT)
    public void ShowPedia2(GuiPedia p0)
    {
        entityPrehistoricClass.ShowPedia2(p0, "confuciusornis");
    }

    public boolean checkGround(EntityConfuciusornis mob)
    {
        mob = this;
        if (mob.worldObj.isAirBlock((int) mob.posX,
                (int) mob.posY - 1, (int) mob.posZ))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
