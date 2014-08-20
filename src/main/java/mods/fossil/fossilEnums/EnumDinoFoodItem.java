package mods.fossil.fossilEnums;

import mods.fossil.Fossil;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public enum EnumDinoFoodItem
{
    Wheat(Items.wheat, 13, 2), //Veggie Foods
    Melon(Items.melon, 10, 2),
    Apple(Items.apple, 20, 3),
    Potato(Items.potato, 20, 5),
    BakedPotato(Items.baked_potato, 35, 6),
    Cake(Items.cake, 50, 8),
    Carrot(Items.carrot, 15, 4),
    Cookie(Items.cookie, 10, 6),
    PumpkinPie(Items.pumpkin_pie, 25, 8),
    Sugar(Items.sugar, 7, 2),
    Bread(Items.bread, 25, 2),
    Seeds(Items.wheat_seeds, 5, 1),
    melonSeeds(Items.melon_seeds, 5, 1),
    pumpkinSeeds(Items.pumpkin_seeds, 5, 1),

	/*
	 * TODO: Change FoodValue so things higher up on the food chain are worth less in FoodValue,
	 * but maybe trade off with higher HealValue and vice versa.
	 */
    
    FishRaw(Items.fish, 30, 4), //this MUST BE the first carnivore food!
    FishCooked(Items.cooked_fished, 45, 6),
    BeefCooked(Items.cooked_beef, 60, 6),
    BeefRaw(Items.beef, 40, 4),
    ChickenCooked(Items.cooked_chicken, 15, 4),
    ChickenRaw(Items.chicken, 10, 3),
    PorkRaw(Items.porkchop, 35, 4),
    PorkCooked(Items.cooked_porkchop, 55, 5),
    Egg(Items.egg, 7, 2),
    Sjl(Fossil.sjl, 65, 7), //SioChiuLe
    Nautilus(EnumDinoType.Nautilus.DropItem, 28, 2),
    Coelacanth(Fossil.livingCoelacanth, 33, 2),
    ChickenSoupRaw(Fossil.rawChickenSoup, 25, 1),
    ChickenSoupCooked(Fossil.cookedChickenSoup, 50, 5),
    Triceratops(EnumDinoType.Triceratops.DropItem, 55, 5),
    Velociraptor(EnumDinoType.Velociraptor.DropItem, 28, 3),
    TRex(EnumDinoType.TRex.DropItem, 60, 7),
    Pterosaur(EnumDinoType.Pterosaur.DropItem, 35, 2),
    Plesiosaur(EnumDinoType.Plesiosaur.DropItem, 40, 5),
    Mosasaurus(EnumDinoType.Mosasaurus.DropItem, 30, 4),
    Liopleurodon(EnumDinoType.Liopleurodon.DropItem, 28, 3),
    Stegosaurus(EnumDinoType.Stegosaurus.DropItem, 55, 5),
    Dilophosaurus(EnumDinoType.Dilophosaurus.DropItem, 28, 4),
    Brachiosaur(EnumDinoType.Brachiosaurus.DropItem, 80, 9),
    Spinosaurus(EnumDinoType.Spinosaurus.DropItem, 65, 7),
    Compsognathus(EnumDinoType.Compsognathus.DropItem, 15, 2),
    Ankylosaurus(EnumDinoType.Ankylosaurus.DropItem, 53, 3),
    Pachycephalosaurus(EnumDinoType.Pachycephalosaurus.DropItem, 40,3),
    Deinonychus(EnumDinoType.Deinonychus.DropItem, 35, 4),
    Gallimimus(EnumDinoType.Gallimimus.DropItem, 58, 5),
    DinoMeatCooked(Fossil.cookedDinoMeat, 75, 8),
    DodoWing(Fossil.dodoWing, 23, 3),
    DodoWingCooked(Fossil.dodoWingCooked, 40, 5),
    DodoEgg(Fossil.dodoEgg, 10, 3),
    TerrorBirdMeat(Fossil.terrorBirdMeat, 11, 4),
    TerrorBirdMeatCooked(Fossil.terrorBirdMeatCooked, 21, 6),
    TerrorBirdEgg(Fossil.terrorBirdEgg, 10, 3)
    ;
    public Item item;
    public int FoodValue;
    public int HealValue;

    public static final int ISHERBIVOROUS = 1;
    public static final int ISCARNIVOROUS = 2;
    public static final int ISNOFOOD = 0;

    private EnumDinoFoodItem(Item item0, int Food, int Heal)
    {
        this.item = item0;
        this.FoodValue = Food;
        this.HealValue = Heal;
    }

    /**
     *
     * Takes the itemid and tells if its herbivore, carnivore or no food
     */
    public static int foodtype(Item i0)
    {
        for (int i = 0; i < EnumDinoFoodItem.values().length; i++) //check all entries
        {
            if (EnumDinoFoodItem.values()[i].item == i0) //found it in the list
            {
                if (i < EnumDinoFoodItem.FishRaw.ordinal()) //its before SJL, the first carn. food
                {
                    return ISHERBIVOROUS;
                }

                return ISCARNIVOROUS;
            }
        }

        return ISNOFOOD;//wasnt found at all
    }

    /**
     *
     * Takes the itemid and gives the food value
     */
    public static int getItemFood(Item i0)
    {
        for (int i = 0; i < EnumDinoFoodItem.values().length; i++)
        {
            if (EnumDinoFoodItem.values()[i].item == i0)
            {
                return EnumDinoFoodItem.values()[i].FoodValue;
            }
        }

        return 0;
    }
    
    public static void carnivoreItemPreset(EnumDinoType dinoType)
    {
    	dinoType.FoodItemList.addItem(BeefCooked);
    	dinoType.FoodItemList.addItem(BeefRaw);
    	dinoType.FoodItemList.addItem(ChickenCooked);
    	dinoType.FoodItemList.addItem(ChickenRaw);
    	dinoType.FoodItemList.addItem(PorkRaw);
    	dinoType.FoodItemList.addItem(PorkCooked);
    	dinoType.FoodItemList.addItem(Triceratops);
    	dinoType.FoodItemList.addItem(Velociraptor);
    	dinoType.FoodItemList.addItem(TRex);
    	dinoType.FoodItemList.addItem(Pterosaur);
    	dinoType.FoodItemList.addItem(Plesiosaur);
    	dinoType.FoodItemList.addItem(Mosasaurus);
    	dinoType.FoodItemList.addItem(Liopleurodon);
    	dinoType.FoodItemList.addItem(Stegosaurus);
    	dinoType.FoodItemList.addItem(Dilophosaurus);
    	dinoType.FoodItemList.addItem(Brachiosaur);
    	dinoType.FoodItemList.addItem(Spinosaurus);
    	dinoType.FoodItemList.addItem(Compsognathus);
    	dinoType.FoodItemList.addItem(Ankylosaurus);
    	dinoType.FoodItemList.addItem(Pachycephalosaurus);
    	dinoType.FoodItemList.addItem(Deinonychus);
    	dinoType.FoodItemList.addItem(Gallimimus);
    	dinoType.FoodItemList.addItem(DinoMeatCooked);
    	dinoType.FoodItemList.addItem(DodoWing);
    	dinoType.FoodItemList.addItem(DodoWingCooked);
    	dinoType.FoodItemList.addItem(TerrorBirdMeat);
    	dinoType.FoodItemList.addItem(TerrorBirdMeatCooked);
    }
    
    public static void raptorItemPreset(EnumDinoType dinoType)
    {
    	dinoType.FoodItemList.addItem(TerrorBirdEgg);
    	dinoType.FoodItemList.addItem(DodoEgg);
    	dinoType.FoodItemList.addItem(Egg);
    }
}
