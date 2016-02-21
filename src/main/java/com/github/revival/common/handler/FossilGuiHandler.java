package com.github.revival.common.handler;

import com.github.revival.client.gui.*;
import com.github.revival.common.container.*;
import com.github.revival.common.entity.mob.EntityQuagga;
import com.github.revival.common.tileentity.TileEntitySifter;
import com.github.revival.common.tileentity.TileEntityTimeMachine;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class FossilGuiHandler implements IGuiHandler {
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);

        switch (id) {
            case 0:
                return new ContainerAnalyzer(player.inventory, tileEntity);
            case 1:
                return new ContainerCultivate(player.inventory, tileEntity);
            case 2:
                return new ContainerFeeder(player.inventory, tileEntity);
            case 3:
                return new ContainerWorktable(player.inventory, tileEntity);
            case 4:
                return new ContainerPedia();
            case 5:
                return new ContainerTimeMachine(player.inventory, (TileEntityTimeMachine) tileEntity);
            case 6:
                return new ContainerNotebook();
            case 7:
                return new ContainerSifter(player.inventory, tileEntity);
            case 8:
                EntityQuagga quagga = (EntityQuagga) world.getEntityByID(x);
                return new ContainerQuagga(player.inventory, quagga.quaggaChest, quagga);

        }

        return null;
    }

    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);

        switch (id) {
            case 0:
                return new GuiAnalyzer(player.inventory, tileEntity);
            case 1:
                return new GuiCultivate(player.inventory, tileEntity);
            case 2:
                return new GuiFeeder(player.inventory, tileEntity);
            case 3:
                return new GuiWorktable(player.inventory, tileEntity);
            case 4:
                return new GuiPedia();
            case 5:
                return new GuiTimeMachine(player.inventory, (TileEntityTimeMachine) tileEntity);
            case 6:
                return new GuiNotebook();
            case 7:
                return new GuiSifter(player.inventory, (TileEntitySifter) tileEntity);
            case 8:
                EntityQuagga quagga = (EntityQuagga) world.getEntityByID(x);
                return new GuiQuagga(player.inventory, quagga.quaggaChest, quagga);
        }

        return null;
    }
}
