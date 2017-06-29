package fossilsarcheology.server.block.entity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.tileentity.TileEntity;

public class TileEntityVolute extends TileEntity {

    private int vaseType;
    private int vaseRotation;

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setByte("VaseType", (byte) (this.vaseType & 255));
        par1NBTTagCompound.setByte("Rot", (byte) (this.vaseRotation & 255));
        return par1NBTTagCompound;
    }

    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readFromNBT(par1NBTTagCompound);
        this.vaseType = par1NBTTagCompound.getByte("VaseType");
        this.vaseRotation = par1NBTTagCompound.getByte("Rot");
    }

    @Override
    public void onDataPacket(NetworkManager netManager, net.minecraft.network.play.server.SPacketUpdateTileEntity packet) {
        readFromNBT(packet.getNbtCompound());
    }

    public int getVaseType() {
        return this.vaseType;
    }

    public void setVaseType(int par1) {
        this.vaseType = par1;
    }

    public void setVaseRotation(int par1) {
        this.vaseRotation = par1;
    }



}
