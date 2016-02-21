package com.github.revival.common.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityFigurine extends TileEntity {
    /**
     * Entity type for this figurine.
     */
    private int figurineType;

    /**
     * The figurine's rotation.
     */
    private int figurineRotation;

    /**
     * Writes a tile entity to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setByte("FigurineType",
                (byte) (this.figurineType & 255));
        par1NBTTagCompound.setByte("Rot", (byte) (this.figurineRotation & 255));
    }

    @Override
    public boolean canUpdate() {
        return false;
    }

    /**
     * Reads a tile entity from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readFromNBT(par1NBTTagCompound);
        this.figurineType = par1NBTTagCompound.getByte("FigurineType");
        this.figurineRotation = par1NBTTagCompound.getByte("Rot");
    }

    /**
     * Overriden in a sign to provide the text.
     */
    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord,
                this.zCoord, 4, nbttagcompound);
    }

    @Override
    public void onDataPacket(NetworkManager netManager,
                             S35PacketUpdateTileEntity packet) {
        readFromNBT(packet.func_148857_g());
    }

    /**
     * Get the entity type for the figurine
     */
    public int getFigurineType() {
        return this.figurineType;
    }

    /**
     * Set the entity type for the figurine
     */
    public void setFigurineType(int par1) {
        this.figurineType = par1;
    }

    /**
     * Set the figurine's rotation
     */
    public void setFigurineRotation(int par1) {
        this.figurineRotation = par1;
    }

    @SideOnly(Side.CLIENT)
    public int func_82119_b() {
        return this.figurineRotation;
    }
}
