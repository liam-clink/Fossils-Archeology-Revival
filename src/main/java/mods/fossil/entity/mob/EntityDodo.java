package mods.fossil.entity.mob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import mods.fossil.client.gui.GuiPedia;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityDodo extends EntityAnimal
{
    public boolean field_70885_d = false;
    public float field_70886_e = 0.0F;
    public float destPos = 0.0F;
    public float field_70884_g;
    public float field_70888_h;
    public float field_70889_i = 1.0F;

    /** The time until the next egg is spawned. */
    public int timeUntilNextEgg;

    public EntityDodo(World par1World)
    {
        super(par1World);
        this.setSize(0.5F, 0.7F);
        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.4D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.0D, Items.melon_seeds, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
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
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }
    
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(18, Byte.valueOf((byte)0));
    	this.setSkin(this.worldObj.rand.nextInt(2));
    }
    
    public int getSkin()
    {
        return this.dataWatcher.getWatchableObjectByte(18);
    }

    public void setSkin(int par1)
    {
        this.dataWatcher.updateObject(18, Byte.valueOf((byte)par1));
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
        par1NBTTagCompound.setInteger("DodoType", this.getSkin());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setSkin(par1NBTTagCompound.getInteger("DodoType"));
    }
    
    @Override
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return Fossil.modid + ":" + "dodo_living";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected String getHurtSound()
    {
        return Fossil.modid + ":" + "dodo_hurt";
    }
    @Override
    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return Fossil.modid + ":" + "dodo_death";
    }
    
    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        this.field_70888_h = this.field_70886_e;
        this.field_70884_g = this.destPos;
        this.destPos = (float)((double)this.destPos + (double)(this.onGround ? -1 : 4) * 0.3D);

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

        this.field_70889_i = (float)((double)this.field_70889_i * 0.9D);

        if (!this.onGround && this.motionY < 0.0D)
        {
            this.motionY *= 0.6D;
        }

        this.field_70886_e += this.field_70889_i * 2.0F;

        if (!this.isChild() && !this.worldObj.isRemote && --this.timeUntilNextEgg <= 0)
        {
            this.playSound("mob.chicken.plop", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(Fossil.dodoEgg, 1);
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float par1) {}

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.2F;
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        this.playSound("mob.chicken.step", 0.15F, 1.0F);
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
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
            this.dropItem(Fossil.dodoWingCooked, 1);
        }
        else
        {
            this.dropItem(Fossil.dodoWing, 1);
        }
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

        return super.interact(var1);
    }
    /**
     * This function is used when two same-species animals in 'love mode' breed to generate the new baby animal.
     */
    public EntityDodo spawnBabyAnimal(EntityAgeable par1EntityAgeable)
    {
        return new EntityDodo(this.worldObj);
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack par1ItemStack)
    {
        return par1ItemStack != null && par1ItemStack.getItem() == Items.melon_seeds;
    }

    public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
    {
        return this.spawnBabyAnimal(par1EntityAgeable);
    }

    public Object Imprinting(double posX, double posY, double posZ)
    {
        return this;
    }

    private static final ResourceLocation dodoeggicon = new ResourceLocation("fossil:textures/items/Egg_Cultivated_Dodo.png");

    @SideOnly(Side.CLIENT)
    public void ShowPedia(GuiPedia p0)
    {
        p0.reset();
        
        if (this.hasCustomNameTag())
        {
            p0.PrintStringXY(this.getCustomNameTag(), p0.rightIndent, 24, 40, 90, 245);
        }

        p0.PrintStringXY(StatCollector.translateToLocal(LocalizationStrings.ANIMAL_DODO), p0.rightIndent, 34, 0, 0, 0);
        p0.PrintPictXY(dodoeggicon, ((p0.xGui/2) + (p0.xGui/4)), 7, 16, 16);

        if (this.hasCustomNameTag())
        {
            p0.AddStringLR("No Despawn", true);
        }
 //       p0.PrintPictXY(ocean, 120, 7, 4, 4);
    }
    
    
    @SideOnly(Side.CLIENT)
    public void ShowPedia2(GuiPedia p0)
    {
    	p0.reset();
		p0.AddStringLR("", 150, false);

    	if(getClass().getClassLoader().getResourceAsStream( "assets/fossil/dinopedia/" + "Dodo" + ".txt" ) != null)
    	{
			InputStream fileReader = getClass().getClassLoader().getResourceAsStream( "assets/fossil/dinopedia/" + "Dodo" + ".txt" );
			try {
			BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(fileReader));
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				GL11.glPushMatrix();
				GL11.glScalef(0.5F, 0.5F, 0.5F);
				p0.AddStringLR(line, 150, false);
				GL11.glPopMatrix();
			}
			fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	else
    	{
    		p0.AddStringLR("File not found.", true);
    	}
    }
}
