package mods.fossil.entity.mob;

import mods.fossil.Fossil;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityFailuresaurus extends EntityZombie
{
    public EntityFailuresaurus(World var1)
    {
        super(var1);
        this.experienceValue = 4;
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
    
    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("FailuresaurusSkin", this.getSkin());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setSkin(par1NBTTagCompound.getInteger("FailuresaurusSkin"));
    }
    
    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected Item getDropItem()
    {
        return Fossil.biofossil;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Causes this entity to do an upwards motion (jumping).
     */
    protected void jump() {}

    /**
     * Returns the texture's file path as a String.
     */
    public String getTexture()
    {
        return "fossil:textures/mob/Failuresaurus.png";
    }
}
