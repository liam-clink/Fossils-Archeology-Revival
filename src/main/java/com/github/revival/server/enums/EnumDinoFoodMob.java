package com.github.revival.server.enums;

import com.github.revival.server.entity.mob.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;

public enum EnumDinoFoodMob {
    /*
     * TODO: Change FoodValue so things higher up on the food chain are worth less in FoodValue,
     * but maybe trade off with higher HealValue and vice versa.
     *
     * Overall boost values over EnumDinoFoodItem for fresh kills.
     */
    Player(EntityPlayer.class, 27, 2),
    Chicken(EntityChicken.class, 5, 2),
    Cow(EntityCow.class, 40, 5),
    Horse(EntityHorse.class, 55, 3),
    Pig(EntityPig.class, 20, 3),
    Sheep(EntitySheep.class, 35, 3),
    Squid(EntitySquid.class, 30, 3),
    Mob(EntityMob.class, 20, 1),
    Nautilus(NautilusEntity.class, 100, 5),
    Triceratops(null, 50, 3),
    Velociraptor(null, 20, 3),
    TRex(null, 70, 5),
    Pterosaur(null, 35, 2),
    Plesiosaur(null, 50, 3),
    Mosasaurus(null, 50, 3),
    Sarcosuchus(null, 50, 3),
    Liopleurodon(null, 50, 3),
    Stegosaurus(null, 50, 3),
    Dilophosaurus(null, 25, 2),
    Brachiosaurus(null, 80, 5),
    Spinosaurus(null, 70, 5),
    Compsognathus(null, 10, 1),
    Ankylosaurus(null, 50, 3),
    Pachycephalosaurus(null, 50, 3),
    Deinonychus(null, 35, 3),
    Gallimimus(null, 40, 4),
    Allosaurus(null, 25, 1),
    Dodo(DodoEntity.class, 20, 2),
    Coelacanth(CoelacanthEntity.class, 20, 2),
    Quagga(QuaggaEntity.class, 50, 3),
    TerrorBird(TerrorBirdEntity.class, 40, 3),
    Mammoth(MammothEntity.class, 100, 7),
    Elasmotherium(ElasmotheriumEntity.class, 80, 7),
    Confuciusornis(ConfuciusornisEntity.class, 15, 2),
    Ceratosaurus(CeratosaurusEntity.class, 25, 1),;
    public Class preyClass;
    public int FoodValue;
    public int HealValue;

    private EnumDinoFoodMob(Class pClass, int Food, int Heal) {
        preyClass = pClass;
        FoodValue = Food;
        HealValue = Heal;
    }

    private EnumDinoFoodMob(EnumDinoFoodMob mob0) {
        preyClass = mob0.preyClass;
        FoodValue = mob0.FoodValue;
        HealValue = mob0.HealValue;
    }

    public static void init() {
        Triceratops.setDetails(TriceratopsEntity.class);
        Velociraptor.setDetails(VelociraptorEntity.class);
        TRex.setDetails(TyrannosaurusEntity.class);
        Pterosaur.setDetails(PterosaurEntity.class);
        Sarcosuchus.setDetails(SarcosuchusEntity.class);
        Plesiosaur.setDetails(PlesiosaurusEntity.class);
        Mosasaurus.setDetails(MosasaurusEntity.class);
        Stegosaurus.setDetails(StegosaurusEntity.class);
        Dilophosaurus.setDetails(DilophosaurusEntity.class);
        Brachiosaurus.setDetails(BrachiosaurusEntity.class);
        Spinosaurus.setDetails(SpinosaurusEntity.class);
        Compsognathus.setDetails(CompsognathusEntity.class);
        Ankylosaurus.setDetails(AnkylosaurusEntity.class);
        Pachycephalosaurus.setDetails(PachycephalosaurusEntity.class);
        Deinonychus.setDetails(DeinonychusEntity.class);
        Liopleurodon.setDetails(LiopleurodonEntity.class);
        Gallimimus.setDetails(GallimimusEntity.class);
        Allosaurus.setDetails(AllosaurusEntity.class);
    }

    public void setDetails(Class pClass) {
        preyClass = pClass;
    }
}
