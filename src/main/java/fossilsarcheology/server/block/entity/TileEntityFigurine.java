package fossilsarcheology.server.block.entity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityFigurine extends TileEntity {
    private int figurineType;
    private int figurineRotation;

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound = super.writeToNBT(compound);
        compound.setByte("FigurineType", (byte) (this.figurineType & 255));
        compound.setByte("Rot", (byte) (this.figurineRotation & 255));
        return compound;
    }

    @Override
    public boolean canUpdate() {
        return false;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.figurineType = compound.getByte("FigurineType");
        this.figurineRotation = compound.getByte("Rot");
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound data = new NBTTagCompound();
        this.writeToNBT(data);
        return new SPacketUpdateTileEntity(this.pos, 4, data);
    }

    @Override
    public void onDataPacket(NetworkManager netManager, SPacketUpdateTileEntity packet) {
        this.readFromNBT(packet.getNbtCompound());
    }

    public int getFigurineType() {
        return this.figurineType;
    }

    public void setFigurineType(int type) {
        this.figurineType = type;
    }

    public void setFigurineRotation(int rotation) {
        this.figurineRotation = rotation;
    }

    @SideOnly(Side.CLIENT)
    public int getFigurineRotation() {
        return this.figurineRotation;
    }
}
