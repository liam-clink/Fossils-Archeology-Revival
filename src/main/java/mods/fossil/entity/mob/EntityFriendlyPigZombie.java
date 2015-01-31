package mods.fossil.entity.mob;

import mods.fossil.Fossil;
import mods.fossil.fossilAI.FPZAIFollowOwner;
import mods.fossil.fossilAI.FPZAIOwnerHurtByTarget;
import mods.fossil.fossilAI.FPZAIOwnerHurtTarget;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;

public class EntityFriendlyPigZombie extends EntityMob
{
    private int randomSoundDelay = 0;
    private static final ItemStack defaultHeldItem = new ItemStack(Items.golden_sword, 1);
    public String LeaderName;
    public EntityPlayer Leader = null;
    private boolean dying = false;
    public PigmenSpeaker Mouth = new PigmenSpeaker(this);
    public boolean maskSpeech = true;

    public EntityFriendlyPigZombie(World var1)
    {
        super(var1);
        this.isImmuneToFire = true;
        this.LeaderName = "Notch";
        this.getNavigator().setBreakDoors(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLiving.class, 10.0F * 2.0F, false));
        this.tasks.addTask(5, new FPZAIFollowOwner(this, 10.0F, 10.0F, 2.0F));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new FPZAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new FPZAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);

        if (this.isTamed())
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
        }
        else
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        }
    }
    /**
     * Returns true if the newer Entity AI code should be run
     */
    protected boolean isAIEnabled()
    {
        return true;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
//       this.moveSpeed = this.entityToAttack == null ? 0.5F : 0.95F;
        if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0)
        {
            this.worldObj.playSoundAtEntity(this, "mob.zombiepig.zpigangry", this.getSoundVolume() * 2.0F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 1.8F);
        }

        super.onUpdate();
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() == 0 && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound var1)
    {
        super.writeEntityToNBT(var1);
        var1.setString("LeaderName", this.LeaderName);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound var1)
    {
        super.readEntityFromNBT(var1);
        this.LeaderName = var1.getString("LeaderName");

        if (this.isTamed())
        {
            this.Leader = this.updateLeader();
        }

        this.maskSpeech = false;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if (this.dying)
        {
            this.sucrife(60);
        }

        if (this.isTamed() && FMLCommonHandler.instance().getSide().isClient())
        {
            this.Leader = this.updateLeader();

            if (this.Leader == null)
            {
                this.dying = true;
            }
        }

        super.onLivingUpdate();
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.zombiepig.zpig";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.zombiepig.zpighurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.zombiepig.zpigdeath";
    }

    /**
     * Returns the item that this EntityLiving is holding, if any.
     */
    public ItemStack getHeldItem()
    {
        return defaultHeldItem;
    }

    private void sucrife(int var1)
    {
        this.attackEntityFrom(DamageSource.generic, 20);
    }

    /**
     * Called when a lightning bolt hits the entity.
     */
    public void onStruckByLightning(EntityLightningBolt var1) {}

    public boolean isTamed()
    {
        return this.LeaderName != null && !this.LeaderName.isEmpty();
    }

    private EntityPlayer updateLeader()
    {
        EntityPlayer var1 = this.worldObj.getPlayerEntityByName(this.LeaderName);

        if (var1 == null)
        {
            return null;
        }
        else
        {
            ItemStack var2 = var1.inventory.armorItemInSlot(3);
            return var2 == null ? null : (var2.getItem() != Fossil.ancienthelmet ? null : var1);
        }
    }

    public EntityPlayer getOwner()
    {
        return this.Leader;
    }

    public EntityLivingBase func_130012_q()
    {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean func_142018_a(EntityLivingBase theTarget,
                                 EntityLivingBase var1)
    {
        // TODO Auto-generated method stub
        return false;
    }
}
