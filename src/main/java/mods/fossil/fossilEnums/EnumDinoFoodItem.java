package mods.fossil.fossilEnums;

import mods.fossil.Fossil;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public enum EnumDinoFoodItem
{
    Wheat(Items.wheat, 10, 2), //Veggie Foods
    Melon(Items.melon, 10, 2),
    Apple(Items.apple, 15, 3),
    Potato(Items.potato, 10, 2),
    BakedPotato(Items.baked_potato, 15, 3),
    Cake(Items.cake, 25, 5),
    Carrot(Items.carrot, 10, 2),
    Cookie(Items.cookie, 15, 4),
    PumpkinPie(Items.pumpkin_pie, 20, 4),
    Sugar(Items.sugar, 10, 2),
    Bread(Items.bread, 25, 2),
    Seeds(Items.wheat_seeds, 5, 1),
    melonSeeds(Items.melon_seeds, 5, 1),

	/*
	 * TODO: Change FoodValue so things higher up on the food chain are worth less in FoodValue,
	 * but maybe trade off with higher HealValue and vice versa.
	 */
    
    FishRaw(Items.fish, 30, 3), //this MUST BE the first carnivore food!
    FishCooked(Items.cooked_fished, 40, 4),
    BeefCooked(Items.cooked_beef, 50, 5),
    BeefRaw(Items.beef, 40, 4),
    ChickenCooked(Items.cooked_chicken, 10, 2),
    ChickenRaw(Items.chicken, 15, 3),
    PorkRaw(Items.porkchop, 30, 2),
    PorkCooked(Items.cooked_porkchop, 50, 3),
    Egg(Items.egg, 10, 2),
    Sjl(Fossil.sjl, 30, 3), //SioChiuLe
    Nautilus(EnumDinoType.Nautilus.DropItem, 20, 2),
    Coelacanth(Fossil.livingCoelacanth, 20, 2),
    ChickenSoupRaw(Fossil.rawChickenSoup, 30, 3),
    ChickenSoupCooked(Fossil.cookedChickenSoup, 40, 3),
    Triceratops(EnumDinoType.Triceratops.DropItem, 50, 3),
    Velociraptor(EnumDinoType.Velociraptor.DropItem, 20, 3),
    TRex(EnumDinoType.TRex.DropItem, 20, 3),
    Pterosaur(EnumDinoType.Pterosaur.DropItem, 15, 2),
    Plesiosaur(EnumDinoType.Plesiosaur.DropItem, 30, 3),
    Mosasaurus(EnumDinoType.Mosasaurus.DropItem, 20, 3),
    Stegosaurus(EnumDinoType.Stegosaurus.DropItem, 50, 3),
    Dilophosaurus(EnumDinoType.Dilophosaurus.DropItem, 25, 2),
    Brachiosaur(EnumDinoType.Brachiosaurus.DropItem, 50, 4),
    Spinosaurus(EnumDinoType.Spinosaurus.DropItem, 20, 3),
    Compsognathus(EnumDinoType.Compsognathus.DropItem, 10, 1),
    Ankylosaurus(EnumDinoType.Ankylosaurus.DropItem, 50, 3),
    Pachycephalosaurus(EnumDinoType.Pachycephalosaurus.DropItem, 50,3),
    Deinonychus(EnumDinoType.Deinonychus.DropItem, 30, 3),
    Gallimimus(EnumDinoType.Gallimimus.DropItem, 35, 4),
    DinoMeatCooked(Fossil.cookedDinoMeat, 50, 5),
    DodoWing(Fossil.dodoWing, 20, 2),
    DodoWingCooked(Fossil.dodoWingCooked, 30, 3),
    Liopleurodon(EnumDinoType.Liopleurodon.DropItem, 20, 3),
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
}
