package fossilsarcheology.server.block.entity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityVase extends TileEntity {
    private int vaseType;
    private int vaseTypeMeta;
    private int vaseRotation;

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound = super.writeToNBT(compound);
        compound.setByte("VaseType", (byte) (this.vaseType & 255));
        compound.setByte("VaseTypeMeta", (byte) (this.vaseTypeMeta & 255));
        compound.setByte("Rot", (byte) (this.vaseRotation & 255));
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.vaseType = compound.getByte("VaseType");
        this.vaseRotation = compound.getByte("Rot");
        this.vaseTypeMeta = compound.getByte("VaseTypeMeta");
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return new SPacketUpdateTileEntity(this.getPos(), 0, nbttagcompound);
    }

    @Override
    public void onDataPacket(NetworkManager netManager, SPacketUpdateTileEntity packet) {
        readFromNBT(packet.getNbtCompound());
    }

    public int getVaseType() {
        return this.vaseType;
    }

    public void setVaseType(int par1) {
        this.vaseType = par1;
    }

    public int getVaseTypeMeta() {
        return this.vaseTypeMeta;
    }

    public void setVaseTypeMeta(int par1) {
        this.vaseTypeMeta = par1;
    }

    public void setVaseRotation(int par1) {
        this.vaseRotation = par1;
    }

    @SideOnly(Side.CLIENT)
    public int getRotation() {
        return this.vaseRotation;
    }
}
