package mods.fossil.entity.mob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import mods.fossil.client.gui.GuiPedia;
import mods.fossil.fossilAI.DinoAIRaptorLeapAtTarget;
import mods.fossil.fossilAI.DinoAIRideGround;
import mods.fossil.fossilAI.DinoAITargetNonTamedExceptSelfClass;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.IShearable;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityElasmotherium extends EntityPrehistoric
{
    private static final int SKINTYPE = 18;
	private static final int GROWING_AGE = 12;
	private static final int ANIMWATCHER = 19;
	private static final int ANGRYSTATE = 16;
	
	private EntityAIEatGrass aiEatGrass = new EntityAIEatGrass(this);
    private int eatGrassTimes = 0;
    private int attackTimer;

    public EntityElasmotherium(World world)
    {
        super(world);
        this.setSize(2F, 2F);
        this.getNavigator().setAvoidsWater(true);
        
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.1D, Items.wheat, false));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this,  1.1D, true));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, false));
        tasks.addTask(1, new DinoAIRideGround(this, 1.2D)); // mutex all
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }
    
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(24.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0D);
    }

    private void setPedia()
    {
        Fossil.ToPedia = (Object)this;
    }
    
    public boolean attackEntityAsMob(Entity entity)
    {

        boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), this.isChild() ? 
        		2 : (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue());

        if (flag)
        {
	        if (this.rand.nextInt(16) < 8)
	        {
	            this.specialAttack(entity, this.rand.nextInt(2));
	        }
	        this.setLastAttacker(entity);
        }
        return flag;
    }
    
    private void specialAttack(Entity target, int amount)
    {
        this.attackTimer = 10;
        this.worldObj.setEntityState(this, (byte)4);
    	this.playSound("mob.irongolem.throw", 3.0F, 0.2F);

        int offsetX = target.posX > this.posX ? amount : -amount;
        int offsetZ = target.posZ > this.posZ ? amount : -amount;

        target.motionZ = (double)(offsetZ)/3;
        target.motionX = (double)(offsetX)/3;
        target.motionY += 0.4000000059604645D;
    }

    /**
     * Get number of ticks, at least during which the living entity will be silent.
     */
    public int getTalkInterval()
    {
        return 600;
    }
    
    @Override
    protected void collideWithEntity(Entity entity)
    {
        if (this.isAngry() && this.getRNG().nextInt(5) == 0 && this.getEntityToAttack() == null)
        {
            this.attackEntityAsMob((EntityLivingBase)entity);
        }
        super.collideWithEntity(entity);
    }
    
    /**
     * Sets the active target the Task system uses for tracking
     */
    public void setAttackTarget(EntityLivingBase attackTarget)
    {
        super.setAttackTarget(attackTarget);

        if (attackTarget == null)
        {
            this.setAngry(false);
        }
        else if (!this.isTamed())
        {
            this.setAngry(true);
        }
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if (this.attackTimer > 0)
        {
            --this.attackTimer;
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte updateByte)
    {
        if (updateByte == 4)
        {
            this.attackTimer = 10;
            this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
        }
        else
        {
            super.handleHealthUpdate(updateByte);
        }
    }
    
    @Override
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return Fossil.modid + ":" + "elasmotherium_living";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected String getHurtSound()
    {
        return Fossil.modid + ":" + "elasmotherium_hurt";
    }
    @Override
    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return Fossil.modid + ":" + "elasmotherium_death";
    }   

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setInteger("ElasmotheriumSkin", this.getSkin());
        compound.setBoolean("Angry", this.isAngry());

    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.setSkin(compound.getInteger("ElasmotheriumSkin"));
        this.setAngry(compound.getBoolean("Angry"));

    }
    
    public int getSkin()
    {
        return this.dataWatcher.getWatchableObjectByte(SKINTYPE);
    }
    
    public void setSkin(int par1)
    {
        this.dataWatcher.updateObject(SKINTYPE, Byte.valueOf((byte)par1));
    }
    
    /**
     * Disables a mob's ability to move on its own while true.
     */
    protected boolean isMovementCeased()
    {
        return this.isSitting();
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
    	if (this.isChild())
        return 0.4F;
    	
    	return 1.0F;
    }
    
    /**
     * Gets the pitch of living sounds in living entities.
     */
    protected float getSoundPitch()
    {
        return (this.isChild()) ? (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 2.5F 
        		: (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F;
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected Item getDropItem()
    {
        return Items.leather;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean var1, int var2)
    {
        int var3 = this.rand.nextInt(3) + this.rand.nextInt(1 + var2);
        int var4;

        for (var4 = 0; var4 < var3; ++var4)
        {
            this.dropItem(Items.leather, 1);
        }

        var3 = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + var2);

        for (var4 = 0; var4 < var3; ++var4)
        {
            if (this.isBurning())
            {
                this.dropItem(Items.cooked_beef, 1);
            }
            else
            {
                this.dropItem(Items.beef, 1);
            }
        }
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(ANIMWATCHER, new Byte((byte)0)); //Bit used for animations.
        this.dataWatcher.addObject(SKINTYPE, Byte.valueOf((byte)0));
        this.setSkin(this.worldObj.rand.nextInt(3));
        
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer player)
    {
        ItemStack itemstack = player.inventory.getCurrentItem();

        if (itemstack != null)
        {
            if (itemstack.getItem().equals(Fossil.chickenEss))
            {
                this.setGrowingAge(this.getGrowingAge() + 2000);
                itemstack.stackSize--;
                return true;
            }

            if (FMLCommonHandler.instance().getSide().isClient() && itemstack.getItem() == Fossil.dinoPedia)
            {
                this.setPedia();
                player.openGui(Fossil.instance, 4, this.worldObj, (int)this.posX, (int)this.posY, (int)this.posZ);
                return true;
            }
            
            if (itemstack.getItem() == Fossil.whip && this.isTamed() && !this.isChild() && !this.worldObj.isRemote 
            		&& this.riddenByEntity == null && player == this.getOwner()) {
                setRidingPlayer(player);
            }
            
        }

        return super.interact(player);
    }
    
    public void setRidingPlayer(EntityPlayer player)
    {
        player.rotationYaw = this.rotationYaw;
        player.rotationPitch = this.rotationPitch;
        player.mountEntity(this);
    }
    
    @SideOnly(Side.CLIENT)
    public void ShowPedia(GuiPedia p0)
    {
    
    	
        p0.reset();
        p0.PrintPictXY(new ResourceLocation(Fossil.modid + ":" + "textures/items/" + "Elasmotherium/" + "Elasmotherium" + "_DNA.png"), ((p0.xGui/2) + (p0.xGui/4)), 7, 16, 16); //185

        
        /* LEFT PAGE
         * 
         * OWNER:
         * (+2) OWNER NAME 
         * RIDEABLE
         * ORDER
         * ABLE TO FLY
         * ABLE TO CHEST
         * DANGEROUS
         * 
         * 
         */
        
        /* RIGHT PAGE
         * 
         * CUSTOM NAME
         * DINOSAUR NAME
         * DINO AGE
         * HEALTH
         * HUNGER
         * 
         */
        if (this.hasCustomNameTag())
        {
            p0.PrintStringXY(this.getCustomNameTag(), p0.rightIndent, 24, 40, 90, 245);
        }

        p0.PrintStringXY(StatCollector.translateToLocal(LocalizationStrings.ANIMAL_ELASMOTHERIUM), p0.rightIndent, 34, 0, 0, 0);
        //p0.PrintPictXY(pediaclock, p0.rightIndent, 46, 8, 8);
        p0.PrintPictXY(pediaheart, p0.rightIndent, 58, 9, 9);
        //p0.PrintPictXY(pediafood, p0.rightIndent, 70, 9, 9);

        //Print "Day" after age
        /*
        if (this.getDinoAge() == 1)
        {
            p0.PrintStringXY(String.valueOf(this.getDinoAge()) + " " + StatCollector.translateToLocal(LocalizationStrings.PEDIA_EGG_DAY), p0.rightIndent+12, 46);
        }
        else
        {
            p0.PrintStringXY(String.valueOf(this.getDinoAge()) + " " + StatCollector.translateToLocal(LocalizationStrings.PEDIA_EGG_DAYS), p0.rightIndent+12, 46);
        }
        */

        //Display Health
        p0.PrintStringXY(String.valueOf(this.getHealth()) + '/' + this.getMaxHealth(), p0.rightIndent+12, 58);
        //Display Hunger
        //p0.PrintStringXY(String.valueOf(this.getHunger()) + '/' + this.getMaxHunger(), p0.rightIndent+12, 70);

        //Display owner name
        if (this.isTamed())
    	{
        	if(this.getOwnerDisplayName().length() > 0)
	        {
	            p0.AddStringLR(StatCollector.translateToLocal(LocalizationStrings.PEDIA_TEXT_OWNER), true);
	            
	////////////1.7.10 BLOCK //////////////
	            
	            String s0 = String.valueOf(this.getOwnerDisplayName());
	            if (s0.length() > 11)
	            {
	                s0 = this.getOwnerDisplayName().substring(0, 11);
	            }
	            
	            p0.AddStringLR(s0, true);
	///////////////////////////////////////
	            
	////////////1.7.2 BLOCK //////////////      
	            /*
	            String s0 = this.getOwnerName();
	            if (s0.length() > 11)
	            {
	                s0 = this.getOwnerName().substring(0, 11);
	            }
	            
	            p0.AddStringLR(s0, true);
	            */
	///////////////////////////////////////
	        }
        	else
        	{
	            p0.AddStringLR(StatCollector.translateToLocal("Tamed"), true);
        	}
        	
            //Display if Rideable  
            if (this.isAdult())
                p0.AddStringLR(StatCollector.translateToLocal(LocalizationStrings.PEDIA_TEXT_RIDEABLE), true);
    	}
        else
        {
            p0.AddStringLR(StatCollector.translateToLocal("Untamed"), true);
        }
    }

    @SideOnly(Side.CLIENT)
    public void ShowPedia2(GuiPedia p0)
    {
    	super.ShowPedia2(p0, "Elasmotherium");
    }    

    /**
     * This function applies the benefits of growing back wool and faster growing up to the acting entity. (This
     * function is used in the AIEatGrass)
     */
    public void eatGrassBonus()
    {
        if (this.isChild())
        {
            int var1 = this.getGrowingAge() + 1200;

            if (var1 > 0)
            {
                var1 = 0;
            }

            this.setGrowingAge(var1);
        }
    }

    public EntityElasmotherium Imprinting(double var1, double var3, double var5)
    {
        EntityPlayer player = this.worldObj.getClosestPlayer(var1, var3, var5, 50.0D);

        if (player == null)
        {
            return this;
        }
        else
        {
        	this.func_152115_b(player.getUniqueID().toString());
         //   this.setOwner(var7.username);
            this.setTamed(true);
            this.setOwnerDisplayName(player.getCommandSenderName());
            return this;
        }
    }

    @SideOnly(Side.CLIENT)
    public int getattackTimer()
    {
        return this.attackTimer;
    }

    public void moveEntityWithHeading(float par1, float par2)
    {
            super.moveEntityWithHeading(par1, par2);

        //this.stepHeight = 0.5F;

        if (this.riddenByEntity != null || !this.isChild())
        {
            this.stepHeight = 1.0F;
        }
    }
    
    @Override
    public EntityAgeable createChild(EntityAgeable var1)
    {
        EntityAgeable entityChild = new EntityElasmotherium(this.worldObj);
        entityChild.setGrowingAge(-24000);
        return entityChild;
    }
    
    public float getHalfHeight()
    {
        return this.getEyeHeight() / 2.0F + 0.7F;
    }
    
    public float getMountHeight()
    {
        return (this.height * this.getEntitySize())* 0.8F;
    }
    
    public void updateRiderPosition()
    {
        if (this.riddenByEntity != null)
        {
            this.riddenByEntity.setPosition(this.posX, this.posY + (double)this.getMountHeight(), this.posZ);
        }
    }

    public float getEntitySize()
    {
        int i = this.getGrowingAge();
        return i >= 0 ? 1.5F : 0.5F + (float)(-48000 - i) / -48000.0F * 0.5F;
    }
    
    /**
     * "Sets the scale for an ageable entity according to the boolean parameter, which says if it's a child."
     */
    public void setScaleForAge(boolean isChild)
    {
        if (isChild)
        {
            this.setScale(this.getEntitySize());
        }
        else
        {
            this.setScale(1.5F);
        }
    }

    /**
     * "Adds the value of the parameter times 20 to the age of this entity. If the entity is an adult (if the entity's
     * age is greater than 0), it will have no effect."
     */
    public void addGrowth(int p_110195_1_)
    {
        int j = this.getGrowingAge();
        j += p_110195_1_ * 20;

        if (j > 0)
        {
            j = 0;
        }

        this.setGrowingAge(j);
    }
    
    public boolean isAdult()
    {
        return !this.isChild();
    }
    
    /**
     * Determines whether this wolf is angry or not.
     */
    public boolean isAngry()
    {
        return (this.dataWatcher.getWatchableObjectByte(ANGRYSTATE) & 2) != 0;
    }

    /**
     * Sets whether this wolf is angry or not.
     */
    public void setAngry(boolean isAngry)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(ANGRYSTATE);

        if (isAngry)
        {
            this.dataWatcher.updateObject(ANGRYSTATE, Byte.valueOf((byte)(b0 | 2)));
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.4D);
        }
        else
        {
            this.dataWatcher.updateObject(ANGRYSTATE, Byte.valueOf((byte)(b0 & -3)));
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
        }
    }
}
