package fossilsarcheology.server.handler;

import fossilsarcheology.server.block.entity.TileEntitySifter;
import fossilsarcheology.server.block.entity.TileEntityTimeMachine;
import fossilsarcheology.server.entity.mob.EntityQuagga;
import cpw.mods.fml.common.network.IGuiHandler;
import fossilsarcheology.client.gui.*;
import fossilsarcheology.server.container.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class FossilGuiHandler implements IGuiHandler {
    @Override
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
                return null;
            case 5:
                return new TimeMachineContainer(player.inventory, (TileEntityTimeMachine) tileEntity);
            case 6:
                return new NotebookContainer();
            case 7:
                return new SifterContainer(player.inventory, tileEntity);
            case 8:
                EntityQuagga quagga = (EntityQuagga) world.getEntityByID(x);
                return new ContainerQuagga(player.inventory, quagga.quaggaChest, quagga);

        }

        return null;
    }

    @Override
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
