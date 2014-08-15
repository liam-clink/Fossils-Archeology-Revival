package mods.fossil.entity.mob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import mods.fossil.client.gui.GuiPedia;
import net.minecraft.block.material.Material;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityCoelacanth extends EntityWaterMob {

	public float squidPitch;
    public float prevSquidPitch;
    public float squidYaw;
    public float prevSquidYaw;
    
    public int BreedTick = 3000;

    /**
     * appears to be rotation in radians; we already have pitch & yaw, so this completes the triumvirate.
     */
    public float squidRotation;

    /** previous squidRotation in radians. */
    public float prevSquidRotation;

    /** angle of the tentacles in radians */
    public float tentacleAngle;

    /** the last calculated angle of the tentacles in radians */
    public float prevTentacleAngle;
    private float randomMotionSpeed;

    /** change in squidRotation in radians. */
    private float rotationVelocity;
    private float field_70871_bB;
    private float randomMotionVecX;
    private float randomMotionVecY;
    private float randomMotionVecZ;
    
    EntityPrehistoric entityPrehistoricClass = new EntityPrehistoric(worldObj);
    
    public EntityCoelacanth(World par1World)
    {
        super(par1World);
        
        this.setSize(this.width * 3.5F, this.height * 0.5F);
        
  //      this.setSize(this.width * 6.0F, this.height * 6.0F);
        
        this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
    }
    
    protected void entityInit()
    {
        super.entityInit();
        
        this.dataWatcher.addObject(18, Byte.valueOf((byte)0));
        this.setSkin(this.worldObj.rand.nextInt(3));
    }
    
    public int getSkin()
    {
        return this.dataWatcher.getWatchableObjectByte(18);
    }
    
    public void setSkin(int par1)
    {
        this.dataWatcher.updateObject(18, Byte.valueOf((byte)par1));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }
    
    private void setPedia()
    {
        Fossil.ToPedia = (Object)this;
    }
    
    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("CoelacanthType", this.getSkin());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setSkin(par1NBTTagCompound.getInteger("CoelacanthType"));
    }
    
    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected Item getDropItem()
    {
        return Items.fish;
    }
    
    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }
    
    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer var1)
    {
        ItemStack var2 = var1.inventory.getCurrentItem();

        if (var2 != null && FMLCommonHandler.instance().getSide().isClient() && var2.getItem() == Fossil.dinoPedia)
        {
            this.setPedia();
            var1.openGui(Fossil.instance, 4, this.worldObj, (int)this.posX, (int)this.posY, (int)this.posZ);
            return true;
        }
        
        if (var2 == null)
        {

        	
        	ItemStack var3 = new ItemStack(Fossil.livingCoelacanth, 1, getSkin());
            

            if (var1.inventory.addItemStackToInventory(var3))
            {
                if (!this.worldObj.isRemote)
                {
                    this.worldObj.playSoundAtEntity(var1, "random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                    this.setDead();
                }

                return true;
            }
        }

        return super.interact(var1);
    }

    private static final ResourceLocation ocean = new ResourceLocation("fossil:textures/items/Coelacanth_live_Ocean.png");
    private static final ResourceLocation river = new ResourceLocation("fossil:textures/items/Coelacanth_live_River.png");
    private static final ResourceLocation swamp = new ResourceLocation("fossil:textures/items/Coelacanth_live_Swamp.png");

    @SideOnly(Side.CLIENT)
    public void ShowPedia(GuiPedia p0)
    {
        p0.reset();
        
        if (this.hasCustomNameTag())
        {
            p0.PrintStringXY(this.getCustomNameTag(), p0.rightIndent, 24, 40, 90, 245);
        }

        p0.PrintStringXY(StatCollector.translateToLocal(LocalizationStrings.ANIMAL_COELACANTH), p0.rightIndent, 34, 0, 0, 0);
        
        switch(this.getSkin())
        {
        	case 0:
        		 p0.PrintPictXY(ocean, ((p0.xGui/2) + (p0.xGui/4)), 7, 16, 16); break;
        	case 1:
       		 	p0.PrintPictXY(river, ((p0.xGui/2) + (p0.xGui/4)), 7, 16, 16); break;
        	case 2:
       		 	p0.PrintPictXY(swamp, ((p0.xGui/2) + (p0.xGui/4)), 7, 16, 16); break;
        	default:
       		 	p0.PrintPictXY(ocean, ((p0.xGui/2) + (p0.xGui/4)), 7, 16, 16); break;
        }
        
        if (this.hasCustomNameTag())
         {
             p0.AddStringLR("No Despawn", true);
         }
 //       p0.PrintPictXY(ocean, 120, 7, 4, 4);
    }
    
    @SideOnly(Side.CLIENT)
    public void ShowPedia2(GuiPedia p0)
    {
    	entityPrehistoricClass.ShowPedia2(p0, "Coelacanth");
    }
    
    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
        HandleBreed();
    }
    
    /**
     * Checks if this entity is inside water (if inWater field is true as a result of handleWaterMovement() returning
     * true)
     */
    public boolean isInWater()
    {
        return this.worldObj.handleMaterialAcceleration(this.boundingBox.expand(0.0D, -0.6000000238418579D, 0.0D), Material.water, this);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        this.prevSquidPitch = this.squidPitch;
        this.prevSquidYaw = this.squidYaw;
        this.prevSquidRotation = this.squidRotation;
        this.prevTentacleAngle = this.tentacleAngle;
        this.squidRotation += this.rotationVelocity;

        if (this.squidRotation > ((float)Math.PI * 2F))
        {
            this.squidRotation -= ((float)Math.PI * 2F);

            if (this.rand.nextInt(20) == 0)
            {
                this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
            }
        }

        if (this.isInWater())
        {
            float f;

            if (this.squidRotation < (float)Math.PI)
            {
                f = this.squidRotation / (float)Math.PI;
                this.tentacleAngle = MathHelper.sin(f * f * (float)Math.PI) * (float)Math.PI * 0.25F;

                if ((double)f > 0.75D)
                {
                    this.randomMotionSpeed = 1.0F;
                    this.field_70871_bB = 1.0F;
                }
                else
                {
                    this.field_70871_bB *= 0.8F;
                }
            }
            else
            {
                this.tentacleAngle = 0.0F;
                this.randomMotionSpeed *= 0.9F;
                this.field_70871_bB *= 0.99F;
            }

            if (!this.worldObj.isRemote)
            {
                this.motionX = (double)(this.randomMotionVecX * this.randomMotionSpeed);
                this.motionY = (double)(this.randomMotionVecY * this.randomMotionSpeed);
                this.motionZ = (double)(this.randomMotionVecZ * this.randomMotionSpeed);
            }

            f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.renderYawOffset += (-((float)Math.atan2(this.motionX, this.motionZ)) * 180.0F / (float)Math.PI - this.renderYawOffset) * 0.1F;
            this.rotationYaw = this.renderYawOffset;
            this.squidYaw += (float)Math.PI * this.field_70871_bB * 1.5F;
            this.squidPitch += (-((float)Math.atan2((double)f, this.motionY)) * 180.0F / (float)Math.PI - this.squidPitch) * 0.1F;
        }
        else
        {
            this.tentacleAngle = MathHelper.abs(MathHelper.sin(this.squidRotation)) * (float)Math.PI * 0.25F;

            if (!this.worldObj.isRemote)
            {
                this.motionX = 0.0D;
                this.motionY -= 0.08D;
                this.motionY *= 0.9800000190734863D;
                this.motionZ = 0.0D;
            }

            this.squidPitch = (float)((double)this.squidPitch + (double)(-90.0F - this.squidPitch) * 0.02D);
        }
    }

    /**
     * Moves the entity based on the specified heading.  Args: strafe, forward
     */
    public void moveEntityWithHeading(float par1, float par2)
    {
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
    }

    protected void updateEntityActionState()
    {
        ++this.entityAge;

        if (this.entityAge > 100)
        {
            this.randomMotionVecX = this.randomMotionVecY = this.randomMotionVecZ = 0.0F;
        }
        else if (this.rand.nextInt(50) == 0 || !this.inWater || this.randomMotionVecX == 0.0F && this.randomMotionVecY == 0.0F && this.randomMotionVecZ == 0.0F)
        {
            float f = this.rand.nextFloat() * (float)Math.PI * 2.0F;
            this.randomMotionVecX = MathHelper.cos(f) * 0.2F;
            this.randomMotionVecY = -0.1F + this.rand.nextFloat() * 0.2F;
            this.randomMotionVecZ = MathHelper.sin(f) * 0.2F;
        }

        this.despawnEntity();
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return this.posY > 45.0D && this.posY < 63.0D && super.getCanSpawnHere();
    }
    
    public void HandleBreed()
    {
        boolean var1 = false;
        --this.BreedTick;

        if (this.BreedTick == 0)
        {
            int var2 = 0;
            List var3 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

            for (int var4 = 0; var4 < var3.size(); ++var4)
            {
                if (var3.get(var4) instanceof EntityCoelacanth)
                {
                    if (!var1)
                    {
                        ++var2;

                        if (var2 > 30)//too many, start damaging them
                        {
                            var1 = true;//restart
                            var4 = 0;
                        }
                    }
                    else
                    {
                        //damage them
                        EntityCoelacanth var5 = (EntityCoelacanth)((EntityCoelacanth)var3.get(var4));
                        var5.attackEntityFrom(DamageSource.starve, 100);
                    }
                }
            }

            if (!var1)
            {
                if (var2 > 30)
                {
                    ;//no more
                }
                else
                {
                    EntityCoelacanth var6 = null;

                    if ((new Random()).nextInt(100) + 1 < var2)
                    {
                        var6 = new EntityCoelacanth(this.worldObj);
                        var6.setLocationAndAngles(this.posX + (double)((new Random()).nextInt(3) - 1), this.posY, this.posZ + (double)((new Random()).nextInt(3) - 1), this.worldObj.rand.nextFloat() * 360.0F, 0.0F);

                        if (this.worldObj.checkNoEntityCollision(var6.boundingBox) && this.worldObj.getCollidingBoundingBoxes(var6, var6.boundingBox).size() == 0 && this.worldObj.isAnyLiquid(var6.boundingBox))
                        {
                            this.worldObj.spawnEntityInWorld(var6);
                        }
                    }
                }
            }

            this.BreedTick = 3000;
        }
    }
}
