package mods.fossil;


import java.util.Random;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class CommonProxy
{
    public void registerRenderThings()
    {
    }

    public void registerTileEntitySpecialRenderer() {}

    public void registerSounds()
    {
    }

    public void registerEvents()
    {
    }

    public void registerChestItems()
    {
      //  Random rand = new Random();
       // ChestGenHooks chestGenAcademyHooks = ChestGenHooks.getInfo("Academy");
        //chestGenAcademyHooks.addItem(new WeightedRandomChestContent(new ItemStack(Item.paper), rand.nextInt(22), 10, 70));
    }
    
    public ModelBiped getArmorModel(int id){
    	return null;
    }
    
    public void registerChestLoot()
    {
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent((new ItemStack(Fossil.figurineBlock, 1, new Random().nextInt(16))),1,1,5));
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Fossil.gem),1,1,1));
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(Fossil.whip),1,1,50));
        ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(Fossil.biofossil),3,9,10));
        ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Fossil.biofossil),3,12,40));
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Fossil.fossilrecordBones),1,1,5));
    }
}
