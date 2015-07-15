package com.github.revival.common.entity.mob;

import com.github.revival.Revival;
import com.github.revival.common.block.FABlockRegistry;
import com.github.revival.common.config.FossilConfig;
import com.github.revival.common.entity.ai.*;
import com.github.revival.common.enums.EnumPrehistoric;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.world.World;

import java.util.Random;

public class EntityTriceratops extends EntityDinosaur
{
    public static final double baseHealth = EnumPrehistoric.Triceratops.Health0;
    public static final double baseDamage = EnumPrehistoric.Triceratops.Strength0;
    public static final double baseSpeed = EnumPrehistoric.Triceratops.Speed0;
    public static final double maxHealth = EnumPrehistoric.Triceratops.HealthMax;
    public static final double maxDamage = EnumPrehistoric.Triceratops.StrengthMax;
    public static final double maxSpeed = EnumPrehistoric.Triceratops.SpeedMax;
    private final String texturePath;
    public boolean Running = false;
    private boolean looksWithInterest;

    public EntityTriceratops(World var1)
    {
        super(var1, EnumPrehistoric.Triceratops);
        this.looksWithInterest = false;
        this.updateSize();
        this.setSubSpecies((new Random()).nextInt(3) + 1);
        /*
         * EDIT VARIABLES PER DINOSAUR TYPE
		 */
        this.adultAge = EnumPrehistoric.Triceratops.AdultAge;
        // Set initial size for hitbox. (length/width, height)
        this.setSize(0.8F, 0.8F);
        // Size of dinosaur at day 0.
        this.minSize = 1.0F;
        // Size of dinosaur at age Adult.
        this.maxSize = 8.0F;
        if (FossilConfig.quilledTriceratops)
        {
            texturePath = Revival.modid + ":textures/mob/" + this.SelfType.toString() + "/quilled/";
        }
        else
        {
            texturePath = Revival.modid + ":textures/mob/" + this.SelfType.toString() + "/";
        }

        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.2F));
        this.tasks.addTask(4, new DinoAIAttackOnCollide(this, 1.1D, true));
        this.tasks.addTask(5, new DinoAIFollowOwner(this, 1.0F, 5.0F, 2.0F));
        this.tasks.addTask(7, new DinoAIEat(this, 48));
        this.tasks.addTask(8, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(10, new EntityAILookIdle(this));
        tasks.addTask(1, new DinoAIRideGround(this, 1.1)); // mutex all

        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
    }

    public void onLivingUpdate()
    {
        breakBlock(5);
        super.onLivingUpdate();
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(baseSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(baseHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(baseDamage);
    }

    /**
     * Returns the texture's file path as a String.
     */
    public String getTexture()
    {
        if (this.isModelized())
        {
            return super.getModelTexture();
        }

        if (this.isAdult())
        {
            switch (this.getSubSpecies())
            {
                case 0:
                default:
                    return texturePath + "Triceratops_Green_Adult.png";

                case 1:
                    return texturePath + "Triceratops_Brown_Adult.png";

                case 2:
                    return texturePath + "Triceratops_Grey_Adult.png";
            }
        }

        if (this.isTeen())
        {
            switch (this.getSubSpecies())
            {
                case 0:
                default:
                    return texturePath + "Triceratops_Green_Teen.png";

                case 1:
                    return texturePath + "Triceratops_Brown_Teen.png";

                case 2:
                    return texturePath + "Triceratops_Grey_Teen.png";
            }
        }

        switch (this.getSubSpecies())
        {
            case 0:
            default:
                return texturePath + "Triceratops_Green_Baby.png";

            case 1:
                return texturePath + "Triceratops_Brown_Baby.png";

            case 2:
                return texturePath + "Triceratops_Grey_Baby.png";
        }
    }

    /**
     * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
     * use in wolves.
     */
    public int getVerticalFaceSpeed()
    {
        return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
    }

    /**
     * Disables a mob's ability to move on its own while true.
     */
    protected boolean isMovementCeased()
    {
        return this.isSitting();
    }

    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack()
    {
        return this.isSelfAngry() ? this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D) : null;
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer var1)
    {
        //Add special item interaction code here
        return super.interact(var1);
    }

    public boolean isSelfAngry()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
    }

	/*public boolean isSelfSitting()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }*/

    public void setSelfAngry(boolean var1)
    {
        byte var2 = this.dataWatcher.getWatchableObjectByte(16);

        if (var1)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte) (var2 | 2)));
            //        this.moveSpeed = 2.0F;
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte) (var2 & -3)));
            //         this.moveSpeed = 0.5F;
        }
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() == 0 && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

    public float getEyeHeight()
    {
        return (float) this.getDinoAge() / 2.7F;
    }


    public float getMountHeight()
    {
        return this.height * 0.75F;
    }

    public void updateRiderPosition()
    {
        if (this.riddenByEntity != null)
        {
            this.riddenByEntity.setPosition(this.posX, this.posY + this.getMountHeight() + this.riddenByEntity.getYOffset(), this.posZ);
        }
    }

    public EntityTriceratops spawnBabyAnimal(EntityAgeable var1)
    {
        return new EntityTriceratops(this.worldObj);
    }

    private boolean FindFren(int var1)
    {
        float var2 = (float) (var1 * 2);
        int var3 = 0;
        int var4 = 0;
        int var5 = 0;
        int var6;
        int var7;

        for (var6 = -var1; var6 <= var1; ++var6)
        {
            for (var7 = -2; var7 <= 2; ++var7)
            {
                for (int var8 = -var1; var8 <= var1; ++var8)
                {
                    if (this.worldObj.getBlock((int) Math.round(this.posX + (double) var6), (int) Math.round(this.posY + (double) var7), (int) Math.round(this.posZ + (double) var8)) == FABlockRegistry.ferns && var2 > this.GetDistanceWithXYZ(this.posX + (double) var6, this.posY + (double) var7, this.posZ + (double) var8))
                    {
                        var2 = this.GetDistanceWithXYZ(this.posX + (double) var6, this.posY + (double) var7, this.posZ + (double) var8);
                        var3 = var6;
                        var4 = var7;
                        var5 = var8;
                    }
                }
            }
        }

        if (var2 == (float) (var1 * 2))
        {
            return false;
        }
        else if (Math.sqrt((double) (var3 ^ 2 + var4 ^ 2 + var5 ^ 2)) >= 2.0D)
        {
            this.setPathToEntity(this.worldObj.getEntityPathToXYZ(this, (int) Math.round(this.posX + (double) var3), (int) Math.round(this.posY + (double) var4), (int) Math.round(this.posZ + (double) var5), 10.0F, true, false, true, false));
            return true;
        }
        else
        {
            this.FaceToCoord((int) (-(this.posX + (double) var3)), (int) (this.posY + (double) var4), (int) (-(this.posZ + (double) var5)));
            this.increaseHunger(10);

            for (var6 = -1; var6 <= 1; ++var6)
            {
                for (var7 = -1; var7 <= 1; ++var7)
                {
                    if (this.worldObj.getBlock((int) Math.round(this.posX + (double) var3 + (double) var6), (int) Math.round(this.posY + (double) var4), (int) Math.round(this.posZ + (double) var5 + (double) var7)) == FABlockRegistry.ferns)
                    {
                        this.worldObj.playAuxSFX(2001, (int) Math.round(this.posX + (double) var3 + (double) var6), (int) Math.round(this.posY + (double) var4), (int) Math.round(this.posZ + (double) var5 + (double) var7), Block.getIdFromBlock(Blocks.tallgrass));
                        this.worldObj.setBlock((int) Math.round(this.posX + (double) var3 + (double) var6), (int) Math.round(this.posY + (double) var4), (int) Math.round(this.posZ + (double) var5 + (double) var7), Blocks.air, 0, 2);

                        if (this.worldObj.getBlock((int) Math.round(this.posX + (double) var3 + (double) var6), (int) Math.round(this.posY + (double) var4) + 1, (int) Math.round(this.posZ + (double) var5 + (double) var7)) == FABlockRegistry.ferns)//fernUpper
                        {
                            this.worldObj.setBlock((int) Math.round(this.posX + (double) var3 + (double) var6), (int) Math.round(this.posY + (double) var4) + 1, (int) Math.round(this.posZ + (double) var5 + (double) var7), Blocks.air, 0, 2);
                        }

                        if (this.worldObj.getBlock((int) Math.round(this.posX + (double) var3 + (double) var6), (int) Math.round(this.posY + (double) var4) - 1, (int) Math.round(this.posZ + (double) var5 + (double) var7)) == Blocks.grass)
                        {
                            this.worldObj.setBlock((int) Math.round(this.posX + (double) var3 + (double) var6), (int) Math.round(this.posY + (double) var4) - 1, (int) Math.round(this.posZ + (double) var5 + (double) var7), Blocks.dirt);
                        }
                    }
                }

                this.heal(3);
                this.setPathToEntity((PathEntity) null);
            }

            return true;
        }
    }

    @Override
    public EntityAgeable createChild(EntityAgeable var1)
    {
        EntityTriceratops baby = new EntityTriceratops(this.worldObj);
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
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData)
    {
        par1EntityLivingData = super.onSpawnWithEgg(par1EntityLivingData);
        Random random = new Random();
        this.setSubSpecies(random.nextInt(3));
        this.setDinoAge(this.SelfType.AdultAge);
        this.updateSize();
        this.heal(200);
        return par1EntityLivingData;
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
