package mods.fossil.handler;

import java.util.Arrays;
import java.util.HashSet;

import mods.fossil.Fossil;
import mods.fossil.fossilEnums.EnumDinoType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class FossilCraftingHandler
{
    HashSet<Integer> eggsFound = new HashSet<Integer>();
    Integer[] subeggsTotal = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    HashSet<Integer> eggsTotal = new HashSet<Integer>(Arrays.asList(subeggsTotal));

    @SubscribeEvent
    public void onCrafting(EntityPlayer player, ItemStack itemstack,
                           IInventory craftMatrix)
    {
        if (itemstack.getItem() == Item.getItemFromBlock(Fossil.blockworktableIdle))
        {
                player.addStat(FossilAchievementHandler.ArchWorkbench, 1);
        }
        
        if (itemstack.getItem() == Item.getItemFromBlock(Fossil.blockanalyzerIdle))
        {
                player.addStat(FossilAchievementHandler.Analyzer, 1);
        }
        
        if (itemstack.getItem() == Item.getItemFromBlock(Fossil.blockcultivateIdle))
        {
                player.addStat(FossilAchievementHandler.CultVat, 1);
        }
        
        if (itemstack.getItem() == Item.getItemFromBlock(Fossil.blockSifterIdle))
        {
                player.addStat(FossilAchievementHandler.Sifter, 1);
        }
        
        if (itemstack.getItem() == Fossil.dinoPedia)
        {
                player.addStat(FossilAchievementHandler.Dinopedia, 1);
        }
    }

    @SubscribeEvent
    public void onSmelting(EntityPlayer player, ItemStack itemstack)
    {
        for (int i = 0; i < EnumDinoType.values().length; i++)
        {
            if (itemstack.getItem() == EnumDinoType.values()[i].EggItem)
            {
                player.addStat(FossilAchievementHandler.FirstEgg, 1);

                if (!eggsFound.contains(i))
                {
                    this.eggsFound.add(i);
                }
            }
        }

        if (Fossil.DebugMode()){
        Fossil.Console("eggsTotal: " + this.eggsTotal);
        Fossil.Console("eggsFound: " + this.eggsFound);
        Fossil.Console("" + eggsFound.containsAll(eggsTotal));
        }

        if (eggsFound.containsAll(eggsTotal))
        {
            player.addStat(FossilAchievementHandler.AllEggs, 1);
        }
    }
}
