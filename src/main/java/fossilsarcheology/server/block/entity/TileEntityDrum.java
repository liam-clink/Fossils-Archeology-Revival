package fossilsarcheology.server.block.entity;

import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.mob.EntityTyrannosaurus;
import fossilsarcheology.server.enums.OrderType;
import fossilsarcheology.server.enums.PrehistoricEntityType;
import fossilsarcheology.server.handler.LocalizationStrings;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.I18n;

import java.util.List;

//import fossil.entity.mob.EntityPterosaur;
//import fossil.entity.mob.EntityRaptor;
//import fossil.entity.mob.EntityTriceratops;

public class TileEntityDrum extends TileEntity {
    /*
     * final String DRUM = "Drum."; final String MSG = "Msg."; final String
     * ORDER = "Order."; final String HEAD = "Head"; final String MIDDLE =
     * "Middle"; final String TAIL = "Tail"; final String TREXMSG = "Msg.TRex.";
     * final String DINO = "Dino.";
     */
    public OrderType order;

    // public byte note;
    // public boolean previousRedstoneState;

    public TileEntityDrum() {
        this.order = OrderType.STAY;
        // this.note = 0;
        // this.previousRedstoneState = false;
    }

    /**
     * Writes a tile entity to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound var1) {
        super.writeToNBT(var1);
        var1.setByte("Order", (byte) this.order.ordinal());// Revival.EnumToInt(this.Order));
    }

    /**
     * Reads a tile entity from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound var1) {
        super.readFromNBT(var1);
        this.order = OrderType.values()[var1.getByte("Order")];
    }

	/*
     * public void triggerNote(World var1, int var2, int var3, int var4) { if
	 * (var1.getBlockMaterial(var2, var3 + 1, var4) == Material.air) { Material
	 * var5 = var1.getBlockMaterial(var2, var3 - 1, var4); byte var6 = 0;
	 * 
	 * if (var5 == Material.rock) { var6 = 1; }
	 * 
	 * if (var5 == Material.sand) { var6 = 2; }
	 * 
	 * if (var5 == Material.glass) { var6 = 3; }
	 * 
	 * if (var5 == Material.wood) { var6 = 4; }
	 * 
	 * var1.addBlockEvent(var2, var3, var4, Revival.drum.blockID, var6,
	 * this.note); } }
	 */

	/*
     * private String GetOrderString() { return
	 * Revival.GetLangTextByKey("Order." + this.Order.toString()); }
	 */

    public void triggerOrder(EntityPlayer player) {
        this.order = this.order.Next();
        this.worldObj.playSoundEffect((double) this.xCoord, (double) this.yCoord, (double) this.zCoord, "fossil:drum_single", 8.0F, 1.0F);// (float)Math.pow(2.0D,
        // (double)(this.Order.ordinal()/*.ToInt()
        // - 1*/)));
        // String var2 = Revival.GetLangTextByKey("Drum.Head");
        // String var3 = this.GetOrderString();
        Revival.messagePlayer(I18n.translateToLocal(LocalizationStrings.DRUM_TRIGGER) + I18n.translateToLocal("order." + this.order.toString()), player);
        this.markDirty();
    }

    public boolean sendOrder(Item item, EntityPlayer var2) {
        // var2.itemID == this.ItemToControl.itemID && this.isTamed() &&
        // var1.username.equalsIgnoreCase(this.getOwnerName())
		/*
		 * String var3 = ""; String var4 = ""; String var5 =
		 * Revival.GetLangTextByKey("Drum.Msg.Head"); String var6 =
		 * Revival.GetLangTextByKey("Drum.Msg.Middle"); String var7 =
		 * Revival.GetLangTextByKey("Drum.Msg.Tail");
		 */
        this.worldObj.playSoundEffect((double) this.xCoord, (double) this.yCoord, (double) this.zCoord, "fossil:drum_triple", 8.0F, 1.0F); // (float)Math.pow(2.0D,
        // (double)(this.Order.ordinal()/*ToInt()
        // - 1*/)));

        if (item != FAItemRegistry.INSTANCE.skullStick) // That is treated
        // specially ;)
        {
            for (int i = 0; i < PrehistoricEntityType.values().length; ++i) {
                if (PrehistoricEntityType.values()[i].orderItem != null && PrehistoricEntityType.values()[i].orderItem == item) {
                    Revival.messagePlayer(I18n.translateToLocal(LocalizationStrings.DRUM_ORDERING) + I18n.translateToLocal("fossil.entity." + PrehistoricEntityType.values()[i].toString()) + ": " + I18n.translateToLocal("order." + this.order.toString()), var2);
                }
            } // Output: Ordering Triceratops: Stay

            List list = this.worldObj.getEntitiesWithinAABB(EntityPrehistoric.class, AxisAlignedBB.getBoundingBox((double) this.xCoord, (double) this.yCoord, (double) this.zCoord, (double) this.xCoord + 1.0D, (double) this.yCoord + 1.0D, (double) this.zCoord + 1.0D).expand(30.0D, 4.0D, 30.0D));

            for (Object aList : list) {
                Entity var3 = (Entity) aList;
                EntityPrehistoric var4 = (EntityPrehistoric) var3;
                if (item == var4.type.orderItem && var4.isTamed() && var2.getCommandSenderName().equalsIgnoreCase(var4.getCommandSenderName())) {
                    var4.setOrder(this.order);
                }
            }

        } else {
            Revival.messagePlayer(I18n.translateToLocal(LocalizationStrings.DRUM_TREX + String.valueOf(this.order.ordinal() + 1)), var2);
            List list = this.worldObj.getEntitiesWithinAABB(EntityTyrannosaurus.class, AxisAlignedBB.getBoundingBox((double) this.xCoord, (double) this.yCoord, (double) this.zCoord, (double) this.xCoord + 1.0D, (double) this.yCoord + 1.0D, (double) this.zCoord + 1.0D).expand(50.0D, 4.0D, 50.0D));

            for (Object aList : list) {
                Entity var4 = (Entity) aList;
                EntityTyrannosaurus var5 = (EntityTyrannosaurus) var4;

                if (var5.isAdult() && !var5.isTamed()) {
                    var5.setAngry(true);
                    var5.setAttackTarget(var2);
                }
            }
        }

        return true;
		/*
		 * if (var1 != Item.stick.itemID && var1 != Items.bone && var1 !=
		 * Revival.skullStick.itemID && var1 != Item.arrow.itemID) { return
		 * false; } else { if (var1 == Item.stick.itemID) { this.OrderTri();
		 * var3 = Revival.GetLangTextByKey("Dino.Triceratops"); }
		 * 
		 * if (var1 == Items.bone) { this.OrderRaptor(); var3 =
		 * Revival.GetLangTextByKey("Dino.Raptor"); }
		 * 
		 * if (var1 == Item.arrow.itemID) { this.OrderPTS(); var3 =
		 * Revival.GetLangTextByKey("Dino.Pterosaur"); }
		 * 
		 * if (var1 == Revival.skullStick.itemID) { this.OrderTRex(var2); }
		 * 
		 * var4 = this.GetOrderString();
		 * 
		 * if (var1 != Revival.skullStick.itemID) { Revival.ShowMessage(var5 +
		 * var3 + var6 + var4 + var7, var2); return true; } else { String var8 =
		 * Revival.GetLangTextByKey("Drum.Msg.TRex." +
		 * String.valueOf(this.Order.ordinal()/*ToInt() + 1*));
		 * Revival.ShowMessage(var8, var2); return true; } }
		 */
    }

	/*
	 * private void OrderRaptor() { List var1 =
	 * this.worldObj.getEntitiesWithinAABB(EntityRaptor.class,
	 * AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)this.xCoord,
	 * (double)this.yCoord, (double)this.zCoord, (double)this.xCoord + 1.0D,
	 * (double)this.yCoord + 1.0D, (double)this.zCoord + 1.0D).expand(30.0D,
	 * 4.0D, 30.0D)); Iterator var2 = var1.iterator();
	 * 
	 * while (var2.hasNext()) { Entity var3 = (Entity)var2.next();
	 * EntityDinosaur var4 = (EntityDinosaur)var3;
	 * 
	 * if (var4.isTamed()) { var4.SetOrder(this.Order); } } }
	 * 
	 * private void OrderPTS() { List var1 =
	 * this.worldObj.getEntitiesWithinAABB(EntityPterosaur.class,
	 * AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)this.xCoord,
	 * (double)this.yCoord, (double)this.zCoord, (double)this.xCoord + 1.0D,
	 * (double)this.yCoord + 1.0D, (double)this.zCoord + 1.0D).expand(30.0D,
	 * 4.0D, 30.0D)); Iterator var2 = var1.iterator();
	 * 
	 * while (var2.hasNext()) { Entity var3 = (Entity)var2.next();
	 * EntityDinosaur var4 = (EntityDinosaur)var3;
	 * 
	 * if (var4.isTamed()) { var4.SetOrder(this.Order); } } }
	 * 
	 * private void OrderTri() { List var1 =
	 * this.worldObj.getEntitiesWithinAABB(EntityTriceratops.class,
	 * AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)this.xCoord,
	 * (double)this.yCoord, (double)this.zCoord, (double)this.xCoord + 1.0D,
	 * (double)this.yCoord + 1.0D, (double)this.zCoord + 1.0D).expand(30.0D,
	 * 4.0D, 30.0D)); Iterator var2 = var1.iterator();
	 * 
	 * while (var2.hasNext()) { Entity var3 = (Entity)var2.next();
	 * EntityDinosaur var4 = (EntityDinosaur)var3;
	 * 
	 * if (var4.isTamed()) { var4.SetOrder(this.Order); } } }
	 * 
	 * private void OrderTRex(EntityPlayer var1) { List var2 =
	 * this.worldObj.getEntitiesWithinAABB(EntityTRex.class,
	 * AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)this.xCoord,
	 * (double)this.yCoord, (double)this.zCoord, (double)this.xCoord + 1.0D,
	 * (double)this.yCoord + 1.0D, (double)this.zCoord + 1.0D).expand(50.0D,
	 * 4.0D, 50.0D)); Iterator var3 = var2.iterator();
	 * 
	 * while (var3.hasNext()) { Entity var4 = (Entity)var3.next(); EntityTRex
	 * var5 = (EntityTRex)var4;
	 * 
	 * if (var5.getDinoAge() >= 3 && !var5.isTamed()) { var5.setSelfAngry(true);
	 * var5.setAttackTarget(var1); } } }
	 */

    @Override
    public boolean canUpdate() {
        return false;
    }

}
