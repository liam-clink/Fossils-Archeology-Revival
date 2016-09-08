package fossilsarcheology.server.block.entity;

import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.mob.EntityTyrannosaurus;
import fossilsarcheology.server.enums.OrderType;
import fossilsarcheology.server.enums.PrehistoricEntityType;
import fossilsarcheology.server.handler.LocalizationStrings;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.translation.I18n;

import java.util.List;

public class TileEntityDrum extends TileEntity {
    public OrderType order;

    public TileEntityDrum() {
        this.order = OrderType.STAY;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound = super.writeToNBT(compound);
        compound.setByte("Order", (byte) this.order.ordinal());
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.order = OrderType.values()[compound.getByte("Order")];
    }

    public void triggerOrder(EntityPlayer player) {
        this.order = this.order.Next();
        this.worldObj.playSound(null, this.pos, "fossil:drum_single", SoundCategory.BLOCKS, 8.0F, 1.0F);
        Revival.messagePlayer(I18n.translateToLocal(LocalizationStrings.DRUM_TRIGGER) + I18n.translateToLocal("order." + this.order.toString()), player);
        this.markDirty();
    }

    public boolean sendOrder(Item item, EntityPlayer player) {
        this.worldObj.playSound(null, this.pos, "fossil:drum_triple", SoundCategory.BLOCKS, 8.0F, 1.0F);
        if (item != FAItemRegistry.INSTANCE.skullStick) {
            for (PrehistoricEntityType type : PrehistoricEntityType.values()) {
                if (type.orderItem != null && type.orderItem == item) {
                    Revival.messagePlayer(I18n.translateToLocal(LocalizationStrings.DRUM_ORDERING) + I18n.translateToLocal("fossil.entity." + type.toString()) + ": " + I18n.translateToLocal("order." + this.order.toString()), player);
                }
            }
            List<EntityPrehistoric> entities = this.worldObj.getEntitiesWithinAABB(EntityPrehistoric.class, new AxisAlignedBB(this.pos.getX(), this.pos.getY(), this.pos.getZ(), this.pos.getX() + 1.0, this.pos.getY() + 1.0, this.pos.getZ() + 1.0).expand(30.0D, 4.0D, 30.0D));
            for (EntityPrehistoric entity : entities) {
                if (item == entity.type.orderItem && entity.isTamed() && player.getName().equalsIgnoreCase(entity.getName())) {
                    entity.setOrder(this.order);
                }
            }
        } else {
            Revival.messagePlayer(I18n.translateToLocal(LocalizationStrings.DRUM_TREX + String.valueOf(this.order.ordinal() + 1)), player);
            List<EntityTyrannosaurus> entities = this.worldObj.getEntitiesWithinAABB(EntityTyrannosaurus.class, new AxisAlignedBB(this.pos.getX(), this.pos.getY(), this.pos.getZ(), this.pos.getX() + 1.0, this.pos.getY() + 1.0, this.pos.getZ() + 1.0).expand(50.0D, 4.0D, 50.0D));
            for (EntityTyrannosaurus entity : entities) {
                if (entity.isAdult() && !entity.isTamed()) {
                    entity.setAngry(true);
                    entity.setAttackTarget(player);
                }
            }
        }
        return true;
    }
}
