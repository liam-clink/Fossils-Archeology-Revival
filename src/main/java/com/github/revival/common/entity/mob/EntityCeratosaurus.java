package com.github.revival.common.entity.mob;

import com.github.revival.Revival;
import com.github.revival.common.entity.ai.*;
import com.github.revival.common.enums.EnumDinoType;
import com.github.revival.common.enums.EnumSituation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.Random;

public class EntityCeratosaurus extends EntityDinosaur
{
    public static final double baseHealth = EnumDinoType.Ceratosaurus.Health0;
    public static final double baseDamage = EnumDinoType.Ceratosaurus.Strength0;
    public static final double baseSpeed = EnumDinoType.Ceratosaurus.Speed0;
    public static final double maxHealth = EnumDinoType.Ceratosaurus.HealthMax;
    public static final double maxDamage = EnumDinoType.Ceratosaurus.StrengthMax;
    public static final double maxSpeed = EnumDinoType.Ceratosaurus.SpeedMax;
    private static float health = 10;
    public final int Areas = 15;
    final EntityAIControlledByPlayer aiControlledByPlayer;
    private final String texturePath;
    public boolean Screaming;
    public int SkillTick = 0;
    public int WeakToDeath = 0;
    public int TooNearMessageTick = 0;
    public boolean SneakScream = false;
    private boolean looksWithInterest;
    private int Timer;

    public EntityCeratosaurus(World var1)
    {
        super(var1, EnumDinoType.Ceratosaurus);
        this.looksWithInterest = false;
        this.updateSize();
        /*
         * EDIT VARIABLES PER DINOSAUR TYPE
		 */
        this.adultAge = EnumDinoType.Ceratosaurus.AdultAge;
        // Set initial size for hitbox. (length/width, height)
        this.setSize(1.55F, 1.3F);
        // Size of dinosaur at day 0.
        this.minSize = 0.4F;
        // Size of dinosaur at age Adult.
        this.maxSize = 1.9F;
        texturePath = Revival.modid + ":textures/mob/" + this.SelfType.toString() + "/";

        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(3, new DinoAIAttackOnCollide(this, 1.3D, true));
        this.tasks.addTask(5, new DinoAIFollowOwner(this, 1.0F, 10.0F, 2.0F));
        this.tasks.addTask(4, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(4, new DinoAIEat(this, 60));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new DinoAITargetNonTamedExceptSelfClass(this, EntityLiving.class, 750, false));
        tasks.addTask(1, new DinoAIRideGround(this, 1));
        this.tasks.addTask(2, this.aiControlledByPlayer = new EntityAIControlledByPlayer(this, 0.3F));
        this.stepHeight = 1F;
        this.targetTasks.addTask(5, new DinoAIHunt(this, EntityLiving.class, 200, false));
        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityTRex.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntitySpinosaurus.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityBrachiosaurus.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityAllosaurus.class, 16.0F, 0.8D, 1.33D));

        //this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));

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
     * Return the AI task for player control.
     */
    public EntityAIControlledByPlayer getAIControlledByPlayer()
    {
        return this.aiControlledByPlayer;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(baseSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(baseHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(baseDamage);
    }
	/*
	 * Checks if the entity's current position is a valid location to spawn this entity.
	 */

    public boolean getCanSpawnHere()
    {
        return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() == 0 && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

    public float getEyeHeight()
    {
        return 2.0F + (float) this.getDinoAge() / 1.8F;
    }

    public float getRideHeight()
    {
        return this.getEyeHeight() + 0.2F;
    }

    /*
        /**
     * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
     * use in wolves.
     */
    public int getVerticalFaceSpeed()
    {
        return 50;
    }

    @SideOnly(Side.CLIENT)
    public int getTimer()
    {
        return this.Timer;
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte par1)
    {
        if (par1 == 4)
        {
            this.Timer = 20;
        }

    }

    @Override
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        if (this.isModelized())
            return null;
        return Revival.modid + ":" + this.SelfType.toString().toLowerCase() + "_living";
    }

    protected String getHurtSound()
    {
        if (this.isModelized())
            return null;
        return Revival.modid + ":" + "allosaurus_hurt";
    }

    protected String getDeathSound()
    {
        if (this.isModelized())
            return null;
        return Revival.modid + ":" + "allosaurus_death";
    }

    /**
     * Disables a mob's ability to move on its own while true.
     */
    protected boolean isMovementCeased()
    {
        return this.isSitting();// || this.field_25052_g;
    }

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean attackEntityFrom(DamageSource damagesource, float damageamount)
    {
        Entity entity = damagesource.getEntity();
        boolean var4 = false;
        this.setSitting(false);

        if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
        {
            damageamount = (damageamount + 1) / 2;
        }

        if (super.attackEntityFrom(damagesource, damageamount))
        {
            if (!this.isAngry())
            {
                if (entity instanceof EntityArrow && ((EntityArrow) entity).shootingEntity != null)
                {
                    entity = ((EntityArrow) entity).shootingEntity;
                }

                if (entity instanceof EntityLiving)
                {
                    this.setTarget((EntityLiving) entity);
                }

                if (entity instanceof EntityPlayer && this.isTamed() && ((EntityPlayer) entity) == this.getOwner() && this.getRNG().nextInt(6) == 0)
                {
                    //Hit by the owner->untame
                    this.SendStatusMessage(EnumSituation.Betrayed);
                    this.setTamed(false);
                    this.setOwner("");
                    this.ItemInMouth = null;
                    this.setAngry(true);
                    this.setTarget(entity);
                    var4 = true;
                }
            }
            else if (entity != this && entity != null)
            {
                this.entityToAttack = entity;
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isAngry()
    {
        return true;
    }

    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack()
    {
        return (this.isAngry() && !this.isTamed()) ? this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D) : null;
    }

    @Override
    public boolean attackEntityAsMob(Entity victim)
    {
        Random random = new Random();
        float attackDamage = (float) getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
        int knockback = 0;

        if (victim instanceof EntityLivingBase)
        {
            attackDamage += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase) victim);
            knockback += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase) victim);
        }
        boolean attacked = victim.attackEntityFrom(DamageSource.causeMobDamage(this), attackDamage);

        if (attacked)
        {
            if (knockback > 0)
            {
                double vx = -Math.sin(Math.toRadians(rotationYaw)) * knockback * 0.5;
                double vy = 0.1;
                double vz = Math.cos(Math.toRadians(rotationYaw)) * knockback * 0.5;
                victim.addVelocity(vx, vy, vz);
                motionX *= 0.6;
                motionZ *= 0.6;
            }

            setLastAttacker(victim);
        }

        return attacked;
    }


    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    protected void attackEntity(Entity entity, float var2)
    {
        super.attackEntity(entity, var2);
    }

    public boolean CheckSpace()
    {
        return !this.isEntityInsideOpaqueBlock();
    }

    public float getMountHeight()
    {
        return this.height;
    }

    public void updateRiderPosition()
    {
        if (this.riddenByEntity != null)
        {
            this.riddenByEntity.setPosition(this.posX, this.posY + this.getMountHeight() + this.riddenByEntity.getYOffset(), this.posZ);
        }
    }

	/*
    private void Flee(Entity var1, int var2)
    {
        int var3 = (new Random()).nextInt(var2) + 1;
        int var4 = (int)Math.round(Math.sqrt(Math.pow((double)var2, 2.0D) - Math.pow((double)var3, 2.0D)));
        boolean var5 = false;
        int var6 = 0;
        boolean var7 = false;
        boolean var8 = false;
        boolean var9 = true;
        boolean var10 = true;
        boolean var11 = true;
        float var12 = -99999.0F;
        int var14;

        if (var1.posX <= this.posX)
        {
            var14 = (int)Math.round(this.posX) + var3;
        }
        else
        {
            var14 = (int)Math.round(this.posX) - var3;
        }

        int var15;

        if (var1.posZ <= this.posZ)
        {
            var15 = (int)Math.round(this.posZ) + var4;
        }
        else
        {
            var15 = (int)Math.round(this.posZ) - var4;
        }

        for (int var13 = 128; var13 > 0; --var13)
        {
            if (!this.worldObj.isAirBlock(var14, var13, var15))
            {
                var6 = var13;
                break;
            }
        }

        this.setTamed(false);
        this.setOwner("");
        this.setPathToEntity(this.worldObj.getEntityPathToXYZ(this, var14, var6, var15, (float)var2, true, false, true, false));
    }
	 */


    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        breakBlock(5);
        if (this.Timer > 0)
        {
            --this.Timer;
        }
        super.onLivingUpdate();
    }

    /**
     * Returns the texture's file path as a String.
     */
    @Override
    public String getTexture()
    {
        if (this.isModelized())
        {
            return super.getTexture();
        }

        if (this.isAdult())
        {
            switch (this.getSubSpecies())
            {
                case 1:
                    return texturePath + "Ceratosaurus_Red_Adult.png";
                default:
                    return texturePath + "Ceratosaurus_Green_Adult.png";
            }
        }
        else
        {
            switch (this.getSubSpecies())
            {
                case 1:
                    return texturePath + "Ceratosaurus_Red_Baby.png";
                default:
                    return texturePath + "Ceratosaurus_Green_Baby.png";
            }
        }

    }

    /**
     * Causes this entity to do an upwards motion (jumping).
     */
	/*
    protected void jump()
    {
        if (!this.isInWater())
        {
            if (this.riddenByEntity != null)
            {
                this.motionY += 0.6299999803304672D;
            }
            else
            {
                super.jump();
            }
        }
        else if (!this.onGround)
        {
            this.motionY -= 0.1D;
        }
    }
	 */
    public EntityCeratosaurus spawnBabyAnimal(EntityAgeable var1)
    {
        return new EntityCeratosaurus(this.worldObj);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable var1)
    {
        EntityCeratosaurus baby = new EntityCeratosaurus(this.worldObj);
        baby.setSubSpecies(this.getSubSpecies());
        return baby;
    }

    /**
     * This gets called when a dinosaur grows naturally or through Chicken Essence.
     */

    @Override
    public void updateSize()
    {
        double healthStep;
        double attackStep;
        double speedStep;
        healthStep = (this.maxHealth - this.baseHealth) / (this.adultAge + 1);
        attackStep = (this.maxDamage - this.baseDamage) / (this.adultAge + 1);
        speedStep = (this.maxSpeed - this.baseSpeed) / (this.adultAge + 1);


        if (this.getDinoAge() <= this.adultAge)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(Math.round(this.baseHealth + (healthStep * this.getDinoAge())));
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(Math.round(this.baseDamage + (attackStep * this.getDinoAge())));
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.baseSpeed + (speedStep * this.getDinoAge()));

            if (this.isTeen())
            {
                this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.5D);
            }
            else if (this.isAdult())
            {
                this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(2.0D);
            }
            else
            {
                this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);
            }
        }
    }

    @Override
    public void writeSpawnData(ByteBuf buffer)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void readSpawnData(ByteBuf additionalData)
    {
        // TODO Auto-generated method stub

    }
}
