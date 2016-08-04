package fossilsarcheology.server.handler;

import fossilsarcheology.client.gui.AnalyzerGUI;
import fossilsarcheology.client.gui.CultivatorGUI;
import fossilsarcheology.client.gui.FeederGUI;
import fossilsarcheology.client.gui.SifterGUI;
import fossilsarcheology.client.gui.TimeMachineGUI;
import fossilsarcheology.client.gui.WorktableGUI;
import fossilsarcheology.client.gui.PediaGUI;
import fossilsarcheology.client.gui.QuaggaContainer;
import fossilsarcheology.client.gui.QuaggaInventoryGUI;
import fossilsarcheology.server.block.entity.TileEntitySifter;
import fossilsarcheology.server.block.entity.TileEntityTimeMachine;
import fossilsarcheology.server.container.AnalyzerContainer;
import fossilsarcheology.server.container.CultivateContainer;
import fossilsarcheology.server.container.FeederContainer;
import fossilsarcheology.server.container.PediaContainer;
import fossilsarcheology.server.container.SifterContainer;
import fossilsarcheology.server.container.TimeMachineContainer;
import fossilsarcheology.server.container.WorktableContainer;
import fossilsarcheology.server.entity.mob.EntityQuagga;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class FossilGuiHandler implements IGuiHandler {
    public static final int ANALYZER_ID = 0;
    public static final int CULTIVATOR_ID = 1;
    public static final int FEEDER_ID = 2;
    public static final int WORKTABLE_ID = 3;
    public static final int PEDIA_ID = 4;
    public static final int TIME_MACHINE_ID = 5;
    public static final int SIFTER_ID = 7;
    public static final int QUAGGA_ID = 8;

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
        switch (id) {
            case ANALYZER_ID:
                return new AnalyzerContainer(player.inventory, tileEntity);
            case CULTIVATOR_ID:
                return new CultivateContainer(player.inventory, tileEntity);
            case FEEDER_ID:
                return new FeederContainer(player.inventory, tileEntity);
            case WORKTABLE_ID:
                return new WorktableContainer(player.inventory, tileEntity);
            case PEDIA_ID:
                return new PediaContainer();
            case TIME_MACHINE_ID:
                return new TimeMachineContainer(player.inventory, (TileEntityTimeMachine) tileEntity);
            case SIFTER_ID:
                return new SifterContainer(player.inventory, tileEntity);
            case QUAGGA_ID:
                EntityQuagga quagga = (EntityQuagga) world.getEntityByID(x);
                return new QuaggaContainer(player.inventory, quagga.quaggaChest, quagga, player);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
        switch (id) {
            case ANALYZER_ID:
                return new AnalyzerGUI(player.inventory, tileEntity);
            case CULTIVATOR_ID:
                return new CultivatorGUI(player.inventory, tileEntity);
            case FEEDER_ID:
                return new FeederGUI(player.inventory, tileEntity);
            case WORKTABLE_ID:
                return new WorktableGUI(player.inventory, tileEntity);
            case PEDIA_ID:
                return new PediaGUI();
            case TIME_MACHINE_ID:
                return new TimeMachineGUI(player.inventory, (TileEntityTimeMachine) tileEntity);
            case SIFTER_ID:
                return new SifterGUI(player.inventory, (TileEntitySifter) tileEntity);
            case QUAGGA_ID:
                EntityQuagga quagga = (EntityQuagga) world.getEntityByID(x);
                return new QuaggaInventoryGUI(player.inventory, quagga.quaggaChest, quagga, player);
        }
        return null;
    }
}
