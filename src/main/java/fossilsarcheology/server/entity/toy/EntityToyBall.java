package fossilsarcheology.server.entity.toy;

import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.mob.test.EntityNewPrehistoric;
import fossilsarcheology.server.entity.mob.test.EntityToyBase;
import fossilsarcheology.server.item.FAItemRegistry;
import fossilsarcheology.server.message.MessageRollBall;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityToyBall extends EntityToyBase {

    public int rollValue;

    public EntityToyBall(World world) {
        super(world, 15);
        this.setSize(0.5F, 0.5F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0);
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, 0);
    }

    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setInteger("Color", this.getColor());
    }

    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setColor(compound.getInteger("Color"));
    }

    public void setColor(int color) {
        this.dataWatcher.updateObject(20, color);
    }

    public int getColor() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    @Override
    public void applyEntityCollision(Entity entity) {
        if (entity != null && !(entity instanceof EntityToyBase)) {
            this.rotationYaw = entity.rotationYaw;
            this.addVelocity((double) (-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * 0.5F), 0.1D, (double) (MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * 0.5F));
        }
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.motionX > 0 || this.motionZ < 0 || this.motionZ > 0 || this.motionZ < 0) {
            rollValue++;
            Revival.NETWORK_WRAPPER.sendToAll(new MessageRollBall(this.getEntityId(), this.rollValue));
        }
    }

    @Override
    protected ItemStack getItem() {
        return new ItemStack(FAItemRegistry.INSTANCE.toyBall, 1, this.getColor());
    }
    
    public boolean attackEntityFrom(DamageSource dmg, float f) {
        if (dmg.getEntity() != null) {
            if (dmg.getEntity() instanceof EntityPlayer) {
                this.playSound(getAttackNoise(), 1, this.getSoundPitch());
                if (!this.worldObj.isRemote)
                    this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, this.getItem()));
                this.setDead();
                return true;
            }
            if (dmg.getEntity() instanceof EntityNewPrehistoric) {
                ((EntityNewPrehistoric) dmg.getEntity()).doPlayBonus(toyBonus);
                if (getAttackNoise() != null) {
                    this.playSound(getAttackNoise(), 1, this.getSoundPitch());
                    this.rotationYaw = dmg.getEntity().rotationYaw;
                    this.addVelocity((double) (-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * 0.5F), 0.1D, (double) (MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * 0.5F));
                }
            }
        }
        return dmg != DamageSource.outOfWorld;
    }

    @Override
    protected String getAttackNoise() {
        return "mob.slime.attack";
    }
}
