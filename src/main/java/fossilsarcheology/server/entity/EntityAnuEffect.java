package fossilsarcheology.server.entity;

import fossilsarcheology.server.block.FABlockRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
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
        return this.dataManager.getWatchableObjectByte(18);
    }

    public void setAnuRotation(float par1) {
        this.dataManager.updateObject(18, (byte) par1);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setInteger("AnuRotation", this.getAnuRotation());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setAnuRotation(compound.getInteger("AnuRotation"));
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
        this.dataManager.register(16, (byte) 0);
        this.dataManager.register(18, (byte) 0);
    }

    public void playSummonSong() {
        this.playSound("fossil:anuTotem", 0.15F, 1F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
    }

    @Override
    protected void onDeathUpdate() {
        ++this.deathTicks;

        if (this.deathTicks >= 160 && this.deathTicks <= 180) {
            float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
            float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
            float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
            worldObj.newExplosion(this, posX, posY, posZ, 3F, true, true);
        }

        int i;
        int j;

        if (!this.worldObj.isRemote) {
            if (this.deathTicks > 150 && this.deathTicks % 5 == 0) {
                i = 1000;

                while (i > 0) {
                    j = EntityXPOrb.getXPSplit(i);
                    i -= j;
                    // this.worldObj.spawnEntityInWorld(new
                    // EntityXPOrb(this.worldObj, this.posX, this.posY,
                    // this.posZ, j));
                }
            }

            if (this.deathTicks == 1) {
                // this.worldObj.playBroadcastSound(1018, (int)this.posX,
                // (int)this.posY, (int)this.posZ, 0);
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

            this.createPortal(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ));
            this.setDead();
        }
    }

    private void createPortal(BlockPos pos) {
        worldObj.setBlockState(pos, FABlockRegistry.INSTANCE.anuPortal.getDefaultState());
        worldObj.setBlockState(pos.up(), FABlockRegistry.INSTANCE.anuPortal.getDefaultState());
        worldObj.setBlockState(pos.up(2), Blocks.OBSIDIAN.getDefaultState());
        worldObj.setBlockState(pos.down(), Blocks.OBSIDIAN.getDefaultState());
    }

    @Override
    protected void despawnEntity() {
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    protected float getSoundVolume() {
        return 5.0F;
    }
}