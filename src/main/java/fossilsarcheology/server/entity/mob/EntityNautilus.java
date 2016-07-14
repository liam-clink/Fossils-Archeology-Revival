package fossilsarcheology.server.entity.mob;

import java.util.Collections;
import java.util.List;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.EntityFishBase;
import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.enums.EnumPrehistoric;
import fossilsarcheology.server.item.FAItemRegistry;
import fossilsarcheology.server.message.MessageUpdateNautilus;

public class EntityNautilus extends EntityFishBase {

    public float shellProgress;
    public static final int SHELL_INDEX = 24;
    public boolean isInShell;
    public int ticksToShell;

    public EntityNautilus(World world) {
        super(world, EnumPrehistoric.Nautilus);
        this.setSize(0.8F, 1F);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(SHELL_INDEX, (byte) 0);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setBoolean("InShell", this.isInShell);
        compound.setInteger("ShellTick", this.ticksToShell);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        this.setInShell(compound.getBoolean("InShell"));
        this.ticksToShell = compound.getInteger("ShellTick");
    }

    public void setInShell(boolean inShell) {
        byte b0 = this.dataWatcher.getWatchableObjectByte(SHELL_INDEX);

        if (inShell) {
            this.dataWatcher.updateObject(SHELL_INDEX, (byte) (b0 | 1));
        } else {
            this.dataWatcher.updateObject(SHELL_INDEX, (byte) (b0 & -2));
        }

        if (!worldObj.isRemote) {
            this.isInShell = inShell;
        }
    }

    public boolean isInShell() {
        if (worldObj.isRemote) {
            boolean isInShell = (this.dataWatcher.getWatchableObjectByte(SHELL_INDEX) & 1) != 0;
            this.isInShell = isInShell;
            return isInShell;
        }
        return isInShell;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        boolean inshell = isInShell();
        if (inshell && shellProgress < 20.0F) {
            shellProgress += 0.5F;
        } else if (!inshell && shellProgress > 0.0F) {
            shellProgress -= 0.5F;
        }
        if (ticksToShell > 0) {
            ticksToShell--;
        }
        if (!this.worldObj.isRemote) {
            if (isThereNearbyMobs() && this.ticksToShell == 0 || !this.isInWater() && this.onGround && this.ticksToShell == 0) {
                if (!this.isInShell()) {
                    this.setInShell(true);
                    Revival.NETWORK_WRAPPER.sendToAll(new MessageUpdateNautilus(this.getEntityId(), true));
                }
            } else {
                if (this.isInShell()) {
                    this.setInShell(false);
                    Revival.NETWORK_WRAPPER.sendToAll(new MessageUpdateNautilus(this.getEntityId(), false));
                }
            }
        }
    }

    @Override
    protected void dropFewItems(boolean burning, int i) {
        this.dropItem(FAItemRegistry.INSTANCE.emptyShell, 1);
    }

    public boolean isThereNearbyMobs() {
        Entity targetEntity;
        EntityAINearestAttackableTarget.Sorter theNearestAttackableTargetSorter = new EntityAINearestAttackableTarget.Sorter(this);
        IEntitySelector targetEntitySelector = new IEntitySelector() {
            @Override
            public boolean isEntityApplicable(Entity entity) {
                return (!(entity instanceof EntityFishBase));
            }
        };
        List<EntityPrehistoric> list = worldObj.selectEntitiesWithinAABB(Entity.class, this.boundingBox.expand(2.0D, 2.0D, 2.0D), targetEntitySelector);
        Collections.sort(list, theNearestAttackableTargetSorter);

        if (list.isEmpty()) {
            return false;
        } else {
            for (Entity entity : list) {
                if (isAScaryAnimal(entity)) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean isAScaryAnimal(Entity entity) {
        if (entity instanceof EntityPlayer) {
            return true;
        }
        if (entity instanceof EntityPrehistoric) {
            return ((EntityPrehistoric) entity).type.diet.getFearIndex() >= 2;
        }
        return entity.width >= 1.2;
    }

    @Override
    public boolean attackEntityFrom(DamageSource dmg, float f) {
        if (f > 0 && this.isInShell() && dmg.getEntity() != null) {
            this.playSound("random.break", 1, this.getRNG().nextFloat() + 0.8F);
        	if(this.ridingEntity != null){
                return super.attackEntityFrom(dmg, f);
        	}
            return false;
        }
        if (!this.isInShell()) {
            this.setInShell(true);
            Revival.NETWORK_WRAPPER.sendToAll(new MessageUpdateNautilus(this.getEntityId(), true));
        }
        return super.attackEntityFrom(dmg, f);
    }

    @Override
    public String getTexture() {
        return "fossil:textures/model/fish/nautilus.png";
    }

    @Override
    protected double getSwimSpeed() {
        return 0.25;
    }
}
