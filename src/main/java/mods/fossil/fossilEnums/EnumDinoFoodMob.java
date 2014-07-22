package mods.fossil.fossilEnums;

import mods.fossil.entity.mob.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;

public enum EnumDinoFoodMob
{
	/*
	 * TODO: Change FoodValue so things higher up on the food chain are worth less in FoodValue,
	 * but maybe trade off with higher HealValue and vice versa.
	 * 
	 * Overall boost values over EnumDinoFoodItem for fresh kills.
	 */
    Player(EntityPlayer.class, 30, 2),
    Chicken(EntityChicken.class, 20, 2),
    Cow(EntityCow.class, 50, 5),
    Horse(EntityHorse.class, 50, 3),
    Pig(EntityPig.class, 30, 3),
    Sheep(EntitySheep.class, 35, 3),
    Squid(EntitySquid.class, 30, 3),
    Mob(EntityMob.class, 20, 1),
    Nautilus(EntityNautilus.class, 100, 5),
    Triceratops(null, 50, 3),
    Velociraptor(null, 20, 3),
    TRex(null, 70, 5),
    Pterosaur(null, 35, 2),
    Plesiosaur(null, 50, 3),
    Mosasaurus(null, 50, 3),
    Stegosaurus(null, 50, 3),
    Dilophosaurus(null, 25, 2),
    Brachiosaurus(null, 80, 5),
    Spinosaurus(null, 70, 5),
    Compsognathus(null, 10, 1),
    Ankylosaurus(null, 50, 3),
    Pachycephalosaurus(null, 50, 3),
    Deinonychus(null, 35, 3),
    Gallimimus(null, 40, 4),
    Dodo(EntityDodo.class, 20, 2),
    Coelacanth(EntityCoelacanth.class, 20, 2),
    ;
    public Class preyClass;
    public int FoodValue;
    public int HealValue;

    private EnumDinoFoodMob(Class pClass, int Food, int Heal)
    {
        preyClass = pClass;
        FoodValue = Food;
        HealValue = Heal;
    }
    private EnumDinoFoodMob(EnumDinoFoodMob mob0)
    {
        preyClass = mob0.preyClass;
        FoodValue = mob0.FoodValue;
        HealValue = mob0.HealValue;
    }
    public void setDetails(Class pClass)
    {
        preyClass = pClass;
    }
    public static void init()
    {
        Triceratops.setDetails(EntityTriceratops.class);
        Velociraptor.setDetails(EntityVelociraptor.class);
        TRex.setDetails(EntityTRex.class);
        Pterosaur.setDetails(EntityPterosaur.class);
        Plesiosaur.setDetails(EntityPlesiosaur.class);
        Mosasaurus.setDetails(EntityMosasaurus.class);
        Stegosaurus.setDetails(EntityStegosaurus.class);
        Dilophosaurus.setDetails(EntityDilophosaurus.class);
        Brachiosaurus.setDetails(EntityBrachiosaurus.class);
        Spinosaurus.setDetails(EntitySpinosaurus.class);
        Compsognathus.setDetails(EntityCompsognathus.class);
        Ankylosaurus.setDetails(EntityAnkylosaurus.class);
        Pachycephalosaurus.setDetails(EntityPachycephalosaurus.class);
        Deinonychus.setDetails(EntityDeinonychus.class);
    }
}
