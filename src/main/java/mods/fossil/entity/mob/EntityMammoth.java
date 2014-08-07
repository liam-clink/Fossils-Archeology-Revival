package mods.fossil.entity.mob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import mods.fossil.client.gui.GuiPedia;
import mods.fossil.fossilAI.DinoAIRideGround;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
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
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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

public class EntityMammoth extends EntityPrehistoric implements IShearable
{
    private static final int SIZE_MULTIFER = 5;
    private static final int EATING_TIMES_TO_GROW_FUR = 5;
    private static final float CHILD_SIZE_Y = 1.3F;
    private static final float CHILD_SIZE_X = 0.9F;
    private static final float ADULT_SIZE_Y = 6.5F;
    private static final float ADULT_SIZE_X = 4.5F;
    private static final Potion BIOME_SICK = Potion.weakness;
    private static final PotionEffect BIOME_EFFECT = new PotionEffect(Potion.weakness.id, 60, 1);
    private static final BiomeGenBase[] COLD_BIOMES = new BiomeGenBase[] {BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.taiga, BiomeGenBase.taigaHills};
    private static final BiomeGenBase[] HOT_BIOMES = new BiomeGenBase[] {BiomeGenBase.desert, BiomeGenBase.swampland, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.hell, BiomeGenBase.desertHills};
    private EntityAIEatGrass aiEatGrass = new EntityAIEatGrass(this);
    private int eatGrassTimes = 0;
    private int swingTick;

    public EntityMammoth(World var1)
    {
        super(var1);
        this.setSize(1.0F, 1.0F);
        this.getNavigator().setAvoidsWater(true);
        
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.wheat, false));
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this,  1.0D, true));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        
        tasks.addTask(1, new DinoAIRideGround(this, 1)); // mutex all

        
        this.experienceValue = 5;
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
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
    }

    private void setPedia()
    {
        Fossil.ToPedia = (Object)this;
    }
    public boolean attackEntityAsMob(Entity var1)
    {
        this.swingTick = 10;
        this.worldObj.setEntityState(this, (byte)4);
        boolean var2 = var1.attackEntityFrom(DamageSource.causeMobDamage(this), this.isChild() ? 2 : 7);

        if (var2)
        {
            var1.motionY += 0.4000000059604645D;
        }

        this.worldObj.playSoundAtEntity(this, "mob.irongolem.throw", 1.0F, 1.0F);
        return var2;
    }

    /**
     * Get number of ticks, at least during which the living entity will be silent.
     */
    public int getTalkInterval()
    {
        return 360;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        this.updateSize();

        if (this.swingTick > 0)
        {
            --this.swingTick;
        }

        if (!this.isPotionActive(BIOME_SICK) && this.checkBiomeAndWeakness())
        {
            this.addPotionEffect(BIOME_EFFECT);
        }
    }

    /**
     * Returns the texture's file path as a String.
     */
    public String getTexture()
    {
        return this.isChild() ? "fossil:textures/mob/MammothYoung.png" : (!this.getSheared() ? "fossil:textures/mob/MammothAdult.png" : "fossil:textures/mob/MammothFurless.png");
    }
    
    @Override
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return Fossil.modid + ":" + "mammoth_living";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected String getHurtSound()
    {
        return Fossil.modid + ":" + "mammoth_hurt";
    }
    @Override
    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return Fossil.modid + ":" + "mammoth_death";
    }   

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound var1)
    {
        super.writeEntityToNBT(var1);
        var1.setBoolean("Sheared", this.getSheared());
        var1.setByte("Color", (byte)this.getFleeceColor());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound var1)
    {
        super.readEntityFromNBT(var1);
        this.setSheared(var1.getBoolean("Sheared"));
        this.setFleeceColor(var1.getByte("Color"));
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
        this.dataWatcher.addObject(18, new Byte((byte)3));
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer player)
    {
        ItemStack var2 = player.inventory.getCurrentItem();

        if (var2 != null)
        {
            if (var2.getItem().equals(Fossil.chickenEss))
            {
                this.setGrowingAge(this.getGrowingAge() + 2000);
                var2.stackSize--;
                return true;
            }

            if (FMLCommonHandler.instance().getSide().isClient() && var2.getItem() == Fossil.dinoPedia)
            {
                this.setPedia();
                player.openGui(Fossil.instance, 4, this.worldObj, (int)this.posX, (int)this.posY, (int)this.posZ);
                return true;
            }
            
            if (var2.getItem() == Fossil.whip && this.isTamed() && !this.isChild() && !this.worldObj.isRemote 
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
        p0.PrintPictXY(new ResourceLocation(Fossil.modid + ":" + "textures/items/" + "Mammoth" + "_DNA.png"), ((p0.xGui/2) + (p0.xGui/4)), 7, 16, 16); //185

        
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

        p0.PrintStringXY(StatCollector.translateToLocal(LocalizationStrings.ANIMAL_MAMMOTH), p0.rightIndent, 34, 0, 0, 0);
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
            p0.AddStringLR(StatCollector.translateToLocal(LocalizationStrings.PEDIA_TEXT_OWNER), true);
        //    String s0 = this.getOwnerName();
            //this.func_152115_b(player.getUniqueID().toString());

	            String s0 = this.getOwner().getCommandSenderName();
	            if (s0.length() > 11)
	            {
	                s0 = this.getOwner().getCommandSenderName().substring(0, 11);
	            }
	            
	            p0.AddStringLR(s0, true);

        }
        //Display if Rideable
        /*
        if (this.isRideable() && this.isAdult())
            p0.AddStringLR(StatCollector.translateToLocal(LocalizationStrings.PEDIA_TEXT_RIDEABLE), true);

        if (this.SelfType.OrderItem != null)
        p0.AddStringLR(StatCollector.translateToLocal("Order: " + this.SelfType.OrderItem.getStatName()), true);

        
        for (int i = 0; i < this.SelfType.FoodItemList.index; i++)
        {
            if (this.SelfType.FoodItemList.getItem(i) != null)
            {
                p0.AddMiniItem(this.SelfType.FoodItemList.getItem(i));
            }
        }
        */

        //TODO show all blocks the dino can eat
    }

    @SideOnly(Side.CLIENT)
    public void ShowPedia2(GuiPedia p0)
    {
    	p0.reset();
		p0.AddStringLR("", 150, false);

    	if(getClass().getClassLoader().getResourceAsStream( "assets/fossil/dinopedia/" + "Mammoth" + ".txt" ) != null)
    	{
			InputStream fileReader = getClass().getClassLoader().getResourceAsStream( "assets/fossil/dinopedia/" + "Mammoth" + ".txt" );
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
    
    public EntityAnimal spawnBabyAnimal(EntityAnimal var1)
    {
        EntityMammoth var2 = new EntityMammoth(this.worldObj);

        if (this.isTamed())
        {
          //  var2.func_146067_o(this.getOwner());
            var2.setTamed(true);
        }

        return var2;
    }

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x,int y, int z) {
        this.eatGrassTimes = 0;
        return !this.getSheared() && !this.isChild();
	}

    public void setSheared(boolean var1)
    {
        byte var2 = this.dataWatcher.getWatchableObjectByte(18);

        if (var1)
        {
            this.dataWatcher.updateObject(18, Byte.valueOf((byte)(var2 | 16)));
        }
        else
        {
            this.dataWatcher.updateObject(18, Byte.valueOf((byte)(var2 & -17)));
        }
    }

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world,int x, int y, int z, int fortune) {
        ArrayList var7 = new ArrayList();
        int var8 = 1 + this.rand.nextInt(20);

        for (int var9 = 0; var9 < var8; ++var9)
        {
            var7.add(new ItemStack(Blocks.wool, 1, 12));
        }

        this.setSheared(true);
        return var7;
	}

    public int getFleeceColor()
    {
        return this.dataWatcher.getWatchableObjectByte(18) & 15;
    }

    public void setFleeceColor(int var1)
    {
        byte var2 = this.dataWatcher.getWatchableObjectByte(18);
        this.dataWatcher.updateObject(18, Byte.valueOf((byte)(var2 & 240 | var1 & 15)));
    }

    public boolean getSheared()
    {
        return (this.dataWatcher.getWatchableObjectByte(18) & 16) != 0;
    }

    public void updateSize()
    {
        if (!this.isChild())
        {
            if (this.width != 4.5F || this.height != 6.5F)
            {
                this.setSize(4.5F, 6.5F);
                this.setPosition(this.posX, this.posY, this.posZ);
            }
        }
    }

    /**
     * This function applies the benefits of growing back wool and faster growing up to the acting entity. (This
     * function is used in the AIEatGrass)
     */
    public void eatGrassBonus()
    {
        if (this.getSheared())
        {
            ++this.eatGrassTimes;

            if (this.eatGrassTimes >= 5)
            {
                this.setSheared(false);
                this.eatGrassTimes = 0;
            }
        }

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

    private boolean checkBiomeAndWeakness()
    {
        if (this.isChild())
        {
            return false;
        }
        else
        {
            BiomeGenBase var1 = this.worldObj.getBiomeGenForCoords((int)this.posX, (int)this.posZ);
            boolean var2 = this.isBiomeCold(var1);
            boolean var3 = this.isBiomeHot(var1);
            return this.getSheared() ? var2 : var3;
        }
    }

    private boolean isBiomeHot(BiomeGenBase var1)
    {
        return this.isBiomeInList(HOT_BIOMES, var1);
    }

    private boolean isBiomeCold(BiomeGenBase var1)
    {
        return this.isBiomeInList(COLD_BIOMES, var1);
    }

    private boolean isBiomeInList(BiomeGenBase[] var1, BiomeGenBase var2)
    {
        for (int var3 = 0; var3 < var1.length; ++var3)
        {
            if (var1[var3].equals(var2))
            {
                return true;
            }
        }

        return false;
    }

    public EntityMammoth Imprinting(double var1, double var3, double var5)
    {
        EntityPlayer var7 = this.worldObj.getClosestPlayer(var1, var3, var5, 50.0D);

        if (var7 == null)
        {
            return this;
        }
        else
        {
        	this.func_152115_b(var7.getUniqueID().toString());
         //   this.setOwner(var7.username);
            this.setTamed(true);
            return this;
        }
    }

    public int getSwingTick()
    {
        return this.swingTick;
    }

    /*public EntityAgeable func_90011_a(EntityAgeable var1)
    {
        return null;
    }*/

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
        EntityAgeable var2 = (new EntityMammoth(this.worldObj)).Imprinting(this.posX, this.posY, this.posZ);
        var2.setGrowingAge(-24000);
        var2.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
        return var2;
    }
    
    public float getEyeHeight()
    {
        return 5.3F;
    }

    public float getHalfHeight()
    {
        return this.getEyeHeight() / 2.0F + 0.7F;
    }
    
    public void updateRiderPosition()
    {
        if (this.riddenByEntity != null)
        {
            this.riddenByEntity.setPosition(this.posX, this.posY + (double)this.getEyeHeight(), this.posZ);
        }
    }


}
