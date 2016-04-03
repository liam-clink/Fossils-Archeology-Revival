package com.github.revival.server.entity;

import com.github.revival.server.block.FABlockRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityAnuEffect extends EntityLiving {

    public boolean slowed;
    public int deathTicks;
    private Entity target;

    public EntityAnuEffect(World world) {
        super(world);
        this.setSize(1.0F, 1.9F);
        this.isImmuneToFire = true;
        this.ignoreFrustumCheck = true;

    }

    public int getAnuRotation() {
        return this.dataWatcher.getWatchableObjectByte(18);
    }

    public void setAnuRotation(float par1) {
        this.dataWatcher.updateObject(18, Byte.valueOf((byte) par1));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("AnuRotation", this.getAnuRotation());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setAnuRotation(par1NBTTagCompound.getInteger("AnuRotation"));
    }

    @Override
    public void moveEntityWithHeading(float par1, float par2) {
        this.motionX *= 0.0D;
        this.motionY *= 0.0D;
        this.motionZ *= 0.0D;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte) 0));
        this.dataWatcher.addObject(18, Byte.valueOf((byte) 0));
    }

    public void playSummonSong() {
        this.playSound("fossil:anuTotem", 0.15F, 1F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
    }


    /**
     * handles entity death timer, experience orb and particle creation
     */
    @Override
    protected void onDeathUpdate() {
        ++this.deathTicks;

        if (this.deathTicks >= 160 && this.deathTicks <= 180) {
            float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
            float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
            float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
            worldObj.newExplosion((Entity) this, posX, posY, posZ, 3F, true, true);
        }

        int i;
        int j;

        if (!this.worldObj.isRemote) {
            if (this.deathTicks > 150 && this.deathTicks % 5 == 0) {
                i = 1000;

                while (i > 0) {
                    j = EntityXPOrb.getXPSplit(i);
                    i -= j;
                    // this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
                }
            }

            if (this.deathTicks == 1) {
                //  this.worldObj.playBroadcastSound(1018, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            }
        }
        this.renderYawOffset = this.rotationYaw += 20.0F;

        if (this.deathTicks == 200 && !this.worldObj.isRemote) {
            i = 2000;

            while (i > 0) {
                j = EntityXPOrb.getXPSplit(i);
                i -= j;
                this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
            }

            this.createEnderPortal(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ));
            this.setDead();
        }
    }

    /**
     * Creates the ender portal leading back to the normal world after defeating the enderdragon.
     */
    private void createEnderPortal(int x, int y, int z) {
        worldObj.setBlock(x, y, z, FABlockRegistry.INSTANCE.anuPortal);
        worldObj.setBlock(x, y + 1, z, FABlockRegistry.INSTANCE.anuPortal);
        worldObj.setBlock(x, y + 2, z, Blocks.obsidian);
        worldObj.setBlock(x, y - 1, z, Blocks.obsidian);
    }

    /**
     * Makes the entity despawn if requirements are reached
     */
    @Override
    protected void despawnEntity() {

    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    @Override
    protected float getSoundVolume() {
        return 5.0F;
    }
}