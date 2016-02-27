package com.github.revival.server.handler;

import com.github.revival.client.gui.*;
import com.github.revival.server.block.entity.SifterTile;
import com.github.revival.server.block.entity.TimeMachineTile;
import com.github.revival.server.container.*;
import com.github.revival.server.entity.mob.QuaggaEntity;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class FossilGuiHandler implements IGuiHandler {
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);

        switch (id) {
            case 0:
                return new AnalyzerContainer(player.inventory, tileEntity);
            case 1:
                return new CultivateContainer(player.inventory, tileEntity);
            case 2:
                return new FeederContainer(player.inventory, tileEntity);
            case 3:
                return new WorktableContainer(player.inventory, tileEntity);
            case 4:
                return new PediaContainer();
            case 5:
                return new TimeMachineContainer(player.inventory, (TimeMachineTile) tileEntity);
            case 6:
                return new NotebookContainer();
            case 7:
                return new SifterContainer(player.inventory, tileEntity);
            case 8:
                QuaggaEntity quagga = (QuaggaEntity) world.getEntityByID(x);
                return new QuaggaContainer(player.inventory, quagga.quaggaChest, quagga);

        }

        return null;
    }

    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);

        switch (id) {
            case 0:
                return new AnalyzerGui(player.inventory, tileEntity);
            case 1:
                return new CultivateGui(player.inventory, tileEntity);
            case 2:
                return new FeederGui(player.inventory, tileEntity);
            case 3:
                return new WorktableGui(player.inventory, tileEntity);
            case 4:
                return new PediaGui();
            case 5:
                return new TimeMachineGui(player.inventory, (TimeMachineTile) tileEntity);
            case 6:
                return new NotebookGui();
            case 7:
                return new SifterGui(player.inventory, (SifterTile) tileEntity);
            case 8:
                QuaggaEntity quagga = (QuaggaEntity) world.getEntityByID(x);
                return new QuaggaGui(player.inventory, quagga.quaggaChest, quagga);
        }

        return null;
    }
}
