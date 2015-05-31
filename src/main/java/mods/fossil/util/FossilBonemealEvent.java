package mods.fossil.util;

import mods.fossil.Fossil;
import mods.fossil.blocks.BlockPalmSapling;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.BonemealEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class FossilBonemealEvent
{
    @SubscribeEvent
    public void onUseBonemeal(BonemealEvent event)
    {
        EntityPlayer player = event.entityPlayer;
        World world = event.world;

        if (event.block == Fossil.palmSap)
        {
            if (!event.world.isRemote)
            {
                ((BlockPalmSapling)Fossil.palmSap).generateTree(event.world, event.x, event.y, event.z, event.world.rand);
                event.setResult(event.getResult().ALLOW);
            }
        }
    }
}
