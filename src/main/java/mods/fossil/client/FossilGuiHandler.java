package mods.fossil.client;

import cpw.mods.fml.common.network.IGuiHandler;
import mods.fossil.client.gui.*;
import mods.fossil.entity.mob.EntityQuagga;
import mods.fossil.guiBlocks.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class FossilGuiHandler implements IGuiHandler
{
    private EntityQuagga quagga;
    
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tile_entity = world.getTileEntity(x, y, z);

        switch (id)
        {
            case 0:
                return new ContainerAnalyzer(player.inventory, (TileEntityAnalyzer) tile_entity);

            case 1:
                return new ContainerCultivate(player.inventory, (TileEntityCultivate) tile_entity);

            case 2:
                return new ContainerFeeder(player.inventory, (TileEntityFeeder) tile_entity);

            case 3:
                return new ContainerWorktable(player.inventory, (TileEntityWorktable) tile_entity);

            case 4:
                return new ContainerPedia();

            case 5:
                return new ContainerTimeMachine(player.inventory, (TileEntityTimeMachine) tile_entity);

            case 6:
                return new ContainerNotebook();
            
            case 7:
            	return new ContainerSifter(player.inventory, (TileEntitySifter) tile_entity);
            	
            case 8:
            	quagga = (EntityQuagga)world.getEntityByID(x);
            	return new ContainerQuagga(player.inventory, quagga.quaggaChest, quagga);
          
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tile_entity = world.getTileEntity(x, y, z);

        switch (id)
        {
            case 0:
                return new GuiAnalyzer(player.inventory, (TileEntityAnalyzer) tile_entity);

            case 1:
                return new GuiCultivate(player.inventory, (TileEntityCultivate) tile_entity);

            case 2:
                return new GuiFeeder(player.inventory, (TileEntityFeeder) tile_entity);

            case 3:
                return new GuiWorktable(player.inventory, (TileEntityWorktable) tile_entity);

            case 4:
                return new GuiPedia();

            case 5:
                return new GuiTimeMachine(player.inventory, (TileEntityTimeMachine) tile_entity);

            case 6:
                return new GuiNotebook();
                
            case 7:
            	return new GuiSifter(player.inventory, (TileEntitySifter) tile_entity);
            	
            case 8:
            	quagga = (EntityQuagga)world.getEntityByID(x);
                return new GuiQuagga(player.inventory, quagga.quaggaChest, quagga);

        }

        return null;
    }
}
