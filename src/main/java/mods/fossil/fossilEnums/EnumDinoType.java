package mods.fossil.fossilEnums;

import mods.fossil.Fossil;
import mods.fossil.entity.mob.DinoFoodBlockList;
import mods.fossil.entity.mob.DinoFoodItemList;
import mods.fossil.entity.mob.DinoFoodMobList;
import mods.fossil.entity.mob.EntityAnkylosaurus;
import mods.fossil.entity.mob.EntityBrachiosaurus;
import mods.fossil.entity.mob.EntityCompsognathus;
import mods.fossil.entity.mob.EntityDeinonychus;
import mods.fossil.entity.mob.EntityDilophosaurus;
import mods.fossil.entity.mob.EntityGallimimus;
import mods.fossil.entity.mob.EntityMosasaurus;
import mods.fossil.entity.mob.EntityNautilus;
import mods.fossil.entity.mob.EntityPachycephalosaurus;
import mods.fossil.entity.mob.EntityPlesiosaur;
import mods.fossil.entity.mob.EntityPterosaur;
import mods.fossil.entity.mob.EntitySpinosaurus;
import mods.fossil.entity.mob.EntityStegosaurus;
import mods.fossil.entity.mob.EntityTRex;
import mods.fossil.entity.mob.EntityTriceratops;
import mods.fossil.entity.mob.EntityVelociraptor;
import mods.fossil.entity.mob.EntityLiopleurodon;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

interface C
{
    public static final int NOTHING = 0;

    public static final int NO_FEEDER = 0 << 0;//Bits 0+1:	Dinos Can't use Feeder at all
    public static final int HERBIVORE = 1 << 0;//Bit 0:		Dino can use Herbivore Part of Feeder
    public static final int CARNIVORE = 2 << 0;//Bit 1: 	Dino can use Carnivore Part of Feeder
    public static final int HERB_CARN = 3 << 0;//Bits 0+1: 	Dinos can use Herbivore and Carnivore Part of Feeder

    public static final int MODEL = 1 << 2; //Bit 2: Dino is Modelable
    public static final int TAME = 1 << 3; //Bit 3: Dino is Tameable
    public static final int RIDE = 1 << 4; //Bit 4: Dino is Rideable
    public static final int CARRY = 1 << 5; //Bit 5: Dino can Carry Items
}

public enum EnumDinoType
{
    //													C.MODEL	| C.TAME	| C.RIDE	| C.HERBIVORE/CARNIVORE | C.CARRY
    Triceratops(EntityTriceratops.class, 				C.MODEL | C.TAME  	| C.RIDE 	| C.HERBIVORE),
    Velociraptor(EntityVelociraptor.class,						  C.TAME  				| C.CARNIVORE),
    TRex(EntityTRex.class, 								C.MODEL | C.TAME    | C.RIDE  	| C.CARNIVORE),
    Pterosaur(EntityPterosaur.class, 					C.MODEL | C.TAME  			 	| C.CARNIVORE),
    Nautilus(EntityNautilus.class, 						C.NOTHING),
    Plesiosaur(EntityPlesiosaur.class, 					C.MODEL | C.TAME  	| C.RIDE 	| C.CARNIVORE),
    Mosasaurus(EntityMosasaurus.class, 					C.MODEL |  		  				  C.CARNIVORE),
    Stegosaurus(EntityStegosaurus.class, 				C.MODEL | C.TAME  				| C.HERBIVORE),
    Dilophosaurus(EntityDilophosaurus.class,					  C.TAME  	 			| C.CARNIVORE),
    Brachiosaurus(EntityBrachiosaurus.class,			C.MODEL | C.TAME  	| C.RIDE 	| C.HERBIVORE),
    Spinosaurus(EntitySpinosaurus.class, 				C.MODEL 						| C.CARNIVORE),
    Compsognathus(EntityCompsognathus.class,			C.MODEL | C.TAME				| C.CARNIVORE),
    Ankylosaurus(EntityAnkylosaurus.class,  			C.MODEL | C.TAME  	| C.RIDE  	| C.HERBIVORE),
    Pachycephalosaurus(EntityPachycephalosaurus.class, 			  C.TAME 				| C.HERBIVORE),
    Deinonychus(EntityDeinonychus.class,				C.MODEL | C.TAME  				| C.CARNIVORE),
    Gallimimus(EntityGallimimus.class,							  C.TAME	| C.RIDE	| C.HERB_CARN),
    Liopleurodon(EntityLiopleurodon.class, 				C.MODEL |  		  				  C.CARNIVORE),
    //Gastornis(EntityGastornis.class, 							  C.TAME	| C.RIDE	| C.CARNIVORE),
    ;


    private final Class dinoClass;

    public int Flags = 0;
    public Item OrderItem;
    public Item DropItem;
    public Item DNAItem;
    public Item EggItem;

    //List of the eatable Items with the FoodValue and HealingValue belonging to
    public DinoFoodItemList FoodItemList;

    //List of the eatable Blocks with the FoodValue and HealingValue belonging to
    public DinoFoodBlockList FoodBlockList;

    //List of the eatable Mobs with the FoodValue and HealingValue belonging to
    public DinoFoodMobList FoodMobList;

    //Starting width and increase of the Dino - No longer used
    public float Width0 = 0.5F;
    public float WidthInc = 0.4F;

    //Starting length and increase of the Dino - No longer used
    public float Length0 = 0.5F;
    public float LengthInc = 0.2F;

    //Starting height and increase of the dino - No longer used
    public float Height0 = 0.5F;
    public float HeightInc = 0.2F;

    //Age Limit of The Dino, arbitrary number, dinosaurs stop growing after hitting adult age.
    public int MaxAge = 999;
    //Age When Dino gets adult, starts Breeding, is Ridable...
    public int AdultAge = 6;
    //Age When Dino gets teen..
    public int TeenAge = 3;

    //Health of the Dino when hatched
    public double Health0 = 20;
    public double HealthMax = 20;

    //The attacking strength of the Dino when hatched
    public double Strength0 = 2;
    public double StrengthMax = 2;

    //The speed of the dino when hatched
    public double Speed0 = 0.25D;
    public double SpeedMax = 0.3D;

    //The Breeding time of the dinosaur, standard value 3000 ticks
    public int BreedingTicks = 3000;
    //Ticks the Dino needs for aging, standard 12000
    public int AgingTicks = 12000;

    //Hunger Limit of the Dino, standard is 100
    public int MaxHunger = 100;
    //The Level below which the dino starts looking for food. Standard is 0.8 [times MaxHunger]
    public float HungryLevel = 0.8f;

    //Base Experience Points of the Dino
    public float Exp0 = 1.0f;
    //Experience increase per day for the dino
    public float ExpInc = 0.2f;

    private float DinoSizeMin = 1.0f;
    private float DinoSizeMax = 10.0f;

    /**
     * Params: Class, Flags
     */
    private EnumDinoType(Class class0, int f0)
    {
        this.dinoClass = class0;
        this.Flags = f0;
        this.FoodItemList = new DinoFoodItemList();
        this.FoodBlockList = new DinoFoodBlockList();
        this.FoodMobList = new DinoFoodMobList();
    }

    /**
     * sets the OrderItem,DropItem,DNAItem and EggItem for the Dino
     */
    private void setItems(Item order)//,Item drop,Item dna,Item egg)
    {
        //this.DropItem = drop;
        //this.DNAItem = dna;
        //this.EggItem = egg;
        this.OrderItem = order;
    }

    /**
     * sets the TeenAge, AdultAge and MaxAge for the Dino
     */
    private void setAges(int Teen, int Adult, int Max)
    {
        if (Teen > 0)
        {
            this.TeenAge = Teen;
        }

        if (Adult > 0)
        {
            this.AdultAge = Adult;
        }

        if (Max > 0)
        {
            this.MaxAge = Max;
        }
    }

    private void setDinoSize(float SizeMin, float SizeMax)
    {
        this.DinoSizeMin = SizeMin;
        this.DinoSizeMax = SizeMax;
    }

    /**
     * sets the min/max values for Health, Attack Damage, Speed, and the Max Hunger Value
     */
    private void setProperties(double H0, double HMax, double Str0, double StrMax, double Sp0, double SpMax, int Hunger)
    {
        if (H0 > 0)
        {
            this.Health0 = H0;
        }

        if (Str0 > 0)
        {
            this.Strength0 = Str0;
        }

        if (Sp0 > 0)
        {
            this.Speed0 = Sp0;
        }
        
        if (HMax > 0) {
        	this.HealthMax = HMax;
        }
        
        if (StrMax > 0) {
        	this.StrengthMax = StrMax;
        }
        
        if (SpMax > 0) {
        	this.SpeedMax = SpMax;
        }

        if (Hunger > 0)
        {
            this.MaxHunger = Hunger;
        }
    }

    /**
     * sets the breeding time, the aging time and the hungry-level
     * Hungry level h:below h*MaxHunger, the dinos starts looking for food, below (1-h)*Maxhunger, the dino is starving
     */
    private void setAddProperties(int Breed, int Age, float HLevel)
    {
        if (Breed > 0)
        {
            this.BreedingTicks = Breed;
        }

        if (Age > 0)
        {
            this.AgingTicks = Age;
        }

        if (HLevel > 0)
        {
            this.HungryLevel = HLevel;
        }
    }

    /**
     * sets the breeding time, the aging time and the hungry-level
     * Hungry level h:below h*MaxHunger, the dinos starts looking for food, below (1-h)*Maxhunger, the dino is starving
     */
    private void setExperience(float E0, float EInc)
    {
        if (E0 > 0)
        {
            this.Exp0 = E0;
        }

        if (EInc > 0)
        {
            this.ExpInc = EInc;
        }
    }

    /**
     * Initializes all individual Dino values
     */
    public static void init()
    {
        //								Order Item			Drop Item				DNA Item				Egg Item
        Triceratops.setItems(Items.stick);  //,			Fossil.rawTriceratops, 	Fossil.dnaTriceratops, 	Fossil.eggTriceratops);

        Triceratops.setAges(5, 12, -1);
        Triceratops.setProperties(12.0D, 32.0D, 1.0D, 9.0D, 0.2D, 0.25D, 500);
        Triceratops.setExperience(0.5F, 0.2F);
        Triceratops.FoodItemList.addItem(EnumDinoFoodItem.Wheat);
        Triceratops.FoodItemList.addItem(EnumDinoFoodItem.Melon);
        Triceratops.FoodItemList.addItem(EnumDinoFoodItem.Apple);
        Triceratops.FoodItemList.addItem(EnumDinoFoodItem.Bread);
        Triceratops.FoodItemList.addItem(EnumDinoFoodItem.Potato);
        Triceratops.FoodBlockList.addblock(EnumDinoFoodBlock.Ferns);
        Triceratops.FoodBlockList.addblock(EnumDinoFoodBlock.Leaves);
        Triceratops.FoodBlockList.addblock(EnumDinoFoodBlock.Palae);
        Triceratops.FoodBlockList.addblock(EnumDinoFoodBlock.RedFlower);
        Triceratops.FoodBlockList.addblock(EnumDinoFoodBlock.YellowFlower);
        
        Pachycephalosaurus.setItems(Items.stick);       //,         Fossil.rawPachycephalosaurus,  Fossil.dnaPachycephalosaurus,  Fossil.eggPachycephalosaurus);

        Pachycephalosaurus.setAges(4, 10, -1);
        Pachycephalosaurus.setProperties(4.0D, 20.0D, 2.0D, 7.0D, 0.25D, 0.4D, 300);
        Pachycephalosaurus.setExperience(0.5F, 0.2F);
        Pachycephalosaurus.FoodItemList.addItem(EnumDinoFoodItem.Wheat);
        Pachycephalosaurus.FoodItemList.addItem(EnumDinoFoodItem.Melon);
        Pachycephalosaurus.FoodItemList.addItem(EnumDinoFoodItem.Apple);
        Pachycephalosaurus.FoodItemList.addItem(EnumDinoFoodItem.Bread);
        Pachycephalosaurus.FoodItemList.addItem(EnumDinoFoodItem.Carrot);
        Pachycephalosaurus.FoodBlockList.addblock(EnumDinoFoodBlock.Ferns);
        Pachycephalosaurus.FoodBlockList.addblock(EnumDinoFoodBlock.Leaves);
        Pachycephalosaurus.FoodBlockList.addblock(EnumDinoFoodBlock.Palae);
        Pachycephalosaurus.FoodBlockList.addblock(EnumDinoFoodBlock.RedFlower);
        Pachycephalosaurus.FoodBlockList.addblock(EnumDinoFoodBlock.YellowFlower);
        
        Ankylosaurus.setItems(Items.stick);       //,         Fossil.rawAnkylosaurus,  Fossil.dnaAnkylosaurus,  Fossil.eggAnkylosaurus);
        Ankylosaurus.setDinoSize(1.0F, 10.0F);

        Ankylosaurus.setAges(5, 12, -1);
        Ankylosaurus.setProperties(25.0D, 70.0D, 2.0D, 9.0D, 0.25D, -1, 500);
        Ankylosaurus.setExperience(0.5F, 0.2F);
        Ankylosaurus.FoodItemList.addItem(EnumDinoFoodItem.Wheat);
        Ankylosaurus.FoodItemList.addItem(EnumDinoFoodItem.Melon);
        Ankylosaurus.FoodItemList.addItem(EnumDinoFoodItem.Apple);
        Ankylosaurus.FoodItemList.addItem(EnumDinoFoodItem.Bread);
        Ankylosaurus.FoodItemList.addItem(EnumDinoFoodItem.Potato);
        Ankylosaurus.FoodBlockList.addblock(EnumDinoFoodBlock.Ferns);
        Ankylosaurus.FoodBlockList.addblock(EnumDinoFoodBlock.Leaves);
        Ankylosaurus.FoodBlockList.addblock(EnumDinoFoodBlock.Palae);
        Ankylosaurus.FoodBlockList.addblock(EnumDinoFoodBlock.RedFlower);
        Ankylosaurus.FoodBlockList.addblock(EnumDinoFoodBlock.YellowFlower);
        
        Velociraptor.setItems(Items.bone);  //,			Fossil.rawVelociraptor, Fossil.dnaVelociraptor, Fossil.eggVelociraptor);

        Velociraptor.setAges(3, 6, -1);
        Velociraptor.setProperties(3.0D, 16.0D, 2.0D, 7.0D, 0.25D, 0.35D, 150);
        Velociraptor.setExperience(0.7F, 0.7F);
        Velociraptor.FoodItemList.addItem(EnumDinoFoodItem.PorkRaw);
        Velociraptor.FoodItemList.addItem(EnumDinoFoodItem.PorkCooked);
        Velociraptor.FoodItemList.addItem(EnumDinoFoodItem.BeefRaw);
        Velociraptor.FoodItemList.addItem(EnumDinoFoodItem.BeefCooked);
        Velociraptor.FoodItemList.addItem(EnumDinoFoodItem.DinoMeatCooked);
        Velociraptor.FoodItemList.addItem(EnumDinoFoodItem.Triceratops);
        Velociraptor.FoodItemList.addItem(EnumDinoFoodItem.Stegosaurus);
        Velociraptor.FoodItemList.addItem(EnumDinoFoodItem.Plesiosaur);
        Velociraptor.FoodItemList.addItem(EnumDinoFoodItem.Pterosaur);
        Velociraptor.FoodItemList.addItem(EnumDinoFoodItem.Brachiosaur);
        Velociraptor.FoodItemList.addItem(EnumDinoFoodItem.Pachycephalosaurus);
        Velociraptor.FoodItemList.addItem(EnumDinoFoodItem.Dilophosaurus);
        Velociraptor.FoodItemList.addItem(EnumDinoFoodItem.Deinonychus);
        Velociraptor.FoodItemList.addItem(EnumDinoFoodItem.Compsognathus);
        Velociraptor.FoodItemList.addItem(EnumDinoFoodItem.Gallimimus);
        Velociraptor.FoodMobList.addMob(EnumDinoFoodMob.Pig);
        Velociraptor.FoodMobList.addMob(EnumDinoFoodMob.Cow);
        Velociraptor.FoodMobList.addMob(EnumDinoFoodMob.Triceratops);
        Velociraptor.FoodMobList.addMob(EnumDinoFoodMob.Stegosaurus);
        Velociraptor.FoodMobList.addMob(EnumDinoFoodMob.Pterosaur);      
        Velociraptor.FoodMobList.addMob(EnumDinoFoodMob.Dodo);
        Velociraptor.FoodMobList.addMob(EnumDinoFoodMob.Chicken);
        
        
        Compsognathus.setItems(Items.bone);      //,          Fossil.rawCompsognathus, Fossil.dnaCompsognathus, Fossil.eggCompsognathus);

        Compsognathus.setAges(1, 3, -1);
        Compsognathus.setProperties(2.0D, 10.0D, 1.0D, 3.0D, 0.25D, 0.30D, 100);
        Compsognathus.setExperience(0.2F, 0.2F);
        Compsognathus.FoodItemList.addItem(EnumDinoFoodItem.PorkRaw);
        Compsognathus.FoodItemList.addItem(EnumDinoFoodItem.PorkCooked);
        Compsognathus.FoodItemList.addItem(EnumDinoFoodItem.BeefRaw);
        Compsognathus.FoodItemList.addItem(EnumDinoFoodItem.BeefCooked);
        Compsognathus.FoodItemList.addItem(EnumDinoFoodItem.DinoMeatCooked);
        Compsognathus.FoodItemList.addItem(EnumDinoFoodItem.Triceratops);
        Compsognathus.FoodItemList.addItem(EnumDinoFoodItem.Stegosaurus);
        Compsognathus.FoodItemList.addItem(EnumDinoFoodItem.Plesiosaur);
        Compsognathus.FoodItemList.addItem(EnumDinoFoodItem.Pterosaur);
        Compsognathus.FoodItemList.addItem(EnumDinoFoodItem.Brachiosaur);
        Compsognathus.FoodItemList.addItem(EnumDinoFoodItem.Pachycephalosaurus);
        Compsognathus.FoodItemList.addItem(EnumDinoFoodItem.Dilophosaurus);
        Compsognathus.FoodItemList.addItem(EnumDinoFoodItem.Deinonychus);
        Compsognathus.FoodItemList.addItem(EnumDinoFoodItem.Gallimimus);
        Compsognathus.FoodMobList.addMob(EnumDinoFoodMob.Pig);
        Compsognathus.FoodMobList.addMob(EnumDinoFoodMob.Chicken);
        Compsognathus.FoodMobList.addMob(EnumDinoFoodMob.Dodo);
        
        TRex.setItems(Fossil.skullStick);    //,	Fossil.rawTRex, 		Fossil.dnaTRex, 		Fossil.eggTRex);

        TRex.setAges(5, 12, -1);
        TRex.setProperties(15.0D, 60.0D, 2.0D, 14.0D, 0.25D, 0.45D, 500);
        TRex.setExperience(1F, 1F);
        TRex.FoodItemList.addItem(EnumDinoFoodItem.PorkRaw);
        TRex.FoodItemList.addItem(EnumDinoFoodItem.BeefRaw);
        TRex.FoodItemList.addItem(EnumDinoFoodItem.ChickenRaw);
        TRex.FoodItemList.addItem(EnumDinoFoodItem.Triceratops);
        TRex.FoodItemList.addItem(EnumDinoFoodItem.Stegosaurus);
        TRex.FoodItemList.addItem(EnumDinoFoodItem.Dilophosaurus);
        TRex.FoodItemList.addItem(EnumDinoFoodItem.Plesiosaur);
        TRex.FoodItemList.addItem(EnumDinoFoodItem.Pterosaur);
        TRex.FoodItemList.addItem(EnumDinoFoodItem.Brachiosaur);
        TRex.FoodItemList.addItem(EnumDinoFoodItem.Velociraptor);
        TRex.FoodItemList.addItem(EnumDinoFoodItem.Deinonychus);
        TRex.FoodItemList.addItem(EnumDinoFoodItem.Pachycephalosaurus);
        TRex.FoodItemList.addItem(EnumDinoFoodItem.Spinosaurus);
        TRex.FoodItemList.addItem(EnumDinoFoodItem.Ankylosaurus);
        TRex.FoodItemList.addItem(EnumDinoFoodItem.Gallimimus);
        TRex.FoodMobList.addMob(EnumDinoFoodMob.Pig);
        TRex.FoodMobList.addMob(EnumDinoFoodMob.Cow);
        TRex.FoodMobList.addMob(EnumDinoFoodMob.Chicken);
        TRex.FoodMobList.addMob(EnumDinoFoodMob.Sheep);
        TRex.FoodMobList.addMob(EnumDinoFoodMob.Triceratops);
        TRex.FoodMobList.addMob(EnumDinoFoodMob.Stegosaurus);
        TRex.FoodMobList.addMob(EnumDinoFoodMob.Dilophosaurus);
        TRex.FoodMobList.addMob(EnumDinoFoodMob.Plesiosaur);
        TRex.FoodMobList.addMob(EnumDinoFoodMob.Pterosaur);
        TRex.FoodMobList.addMob(EnumDinoFoodMob.Brachiosaurus);
        TRex.FoodMobList.addMob(EnumDinoFoodMob.Velociraptor);
        TRex.FoodMobList.addMob(EnumDinoFoodMob.Deinonychus);
        TRex.FoodMobList.addMob(EnumDinoFoodMob.Ankylosaurus);
        TRex.FoodMobList.addMob(EnumDinoFoodMob.Pachycephalosaurus);
        TRex.FoodItemList.addItem(EnumDinoFoodItem.Gallimimus);
        TRex.FoodMobList.addMob(EnumDinoFoodMob.Dodo);
        
        Pterosaur.setItems(Items.arrow);   //,			Fossil.rawPterosaur, 	Fossil.dnaPterosaur, 	Fossil.eggPterosaur);

        Pterosaur.setAges(4, 9, -1);
        Pterosaur.setProperties(6.0D, 24.0D, 1.0D, 6.0D, 0.15D, 0.2D, 200);
        Pterosaur.setExperience(0.3F, 0.3F);
        Pterosaur.FoodItemList.addItem(EnumDinoFoodItem.FishRaw);
        Pterosaur.FoodItemList.addItem(EnumDinoFoodItem.FishCooked);
        Pterosaur.FoodItemList.addItem(EnumDinoFoodItem.Sjl);
        Pterosaur.FoodItemList.addItem(EnumDinoFoodItem.ChickenRaw);
        Pterosaur.FoodMobList.addMob(EnumDinoFoodMob.Chicken);
        
        Nautilus.setItems(null);   //,				Fossil.rawNautilus, 	Fossil.dnaNautilus, 	Fossil.shellNautilus);
        Nautilus.setExperience(1.0F, 0F);
        
        Plesiosaur.setItems(Fossil.magicConch);  //,	Fossil.rawPlesiosaur, 	Fossil.dnaPlesiosaur, 	Fossil.eggPlesiosaur);

        Pterosaur.setAges(3, 7, -1);
        Plesiosaur.setProperties(10.0D, 20.0D, 1.0D, 5.0D, 0.2D, 0.3D, 500);
        Plesiosaur.setExperience(0.5F, 0.25F);
        Plesiosaur.FoodItemList.addItem(EnumDinoFoodItem.FishRaw);
        Plesiosaur.FoodItemList.addItem(EnumDinoFoodItem.FishCooked);
        Plesiosaur.FoodItemList.addItem(EnumDinoFoodItem.Sjl);
        Plesiosaur.FoodItemList.addItem(EnumDinoFoodItem.ChickenRaw);
        Plesiosaur.FoodMobList.addMob(EnumDinoFoodMob.Nautilus);
        Plesiosaur.FoodMobList.addMob(EnumDinoFoodMob.Chicken);
        Plesiosaur.FoodMobList.addMob(EnumDinoFoodMob.Dodo);
        
        Mosasaurus.setItems(null);  //,				Fossil.rawMosasaurus, 	Fossil.dnaMosasaurus, 	Fossil.eggMosasaurus);

        Mosasaurus.setAges(5, 11, -1);
        Mosasaurus.setProperties(12.0D, 35.0D, 2.0D, 9.0D, 0.3D, 0.35D, 500);
        Mosasaurus.setExperience(1F, 1F);
        Mosasaurus.FoodItemList.addItem(EnumDinoFoodItem.Nautilus);
        Mosasaurus.FoodItemList.addItem(EnumDinoFoodItem.Plesiosaur);
        Mosasaurus.FoodItemList.addItem(EnumDinoFoodItem.Coelacanth);
        Mosasaurus.FoodMobList.addMob(EnumDinoFoodMob.Squid);
        Mosasaurus.FoodMobList.addMob(EnumDinoFoodMob.Nautilus);
        Mosasaurus.FoodMobList.addMob(EnumDinoFoodMob.Coelacanth);
        Mosasaurus.FoodMobList.addMob(EnumDinoFoodMob.Plesiosaur);
        Mosasaurus.FoodMobList.addMob(EnumDinoFoodMob.Cow);
        
        Liopleurodon.setItems(null);  //,				Fossil.rawLiopleurodon, 	Fossil.dnaLiopleurodon, 	Fossil.eggLiopleurodon);
        Liopleurodon.setAges(6, 13, -1);
        Liopleurodon.setProperties(10.0D, 40.0D, 2.0D, 12.0D, 0.3D, 0.4D, 500);
        Liopleurodon.setExperience(1F, 1F);
        Liopleurodon.FoodItemList.addItem(EnumDinoFoodItem.Nautilus);
        Liopleurodon.FoodItemList.addItem(EnumDinoFoodItem.Plesiosaur);
        Liopleurodon.FoodItemList.addItem(EnumDinoFoodItem.Coelacanth);
        Liopleurodon.FoodMobList.addMob(EnumDinoFoodMob.Squid);
        Liopleurodon.FoodMobList.addMob(EnumDinoFoodMob.Nautilus);
        Liopleurodon.FoodMobList.addMob(EnumDinoFoodMob.Coelacanth);
        Liopleurodon.FoodMobList.addMob(EnumDinoFoodMob.Plesiosaur);
        Liopleurodon.FoodMobList.addMob(EnumDinoFoodMob.Cow);
        
        Stegosaurus.setItems(Items.stick);  //,			Fossil.rawStegosaurus, 	Fossil.dnaStegosaurus, 	Fossil.eggStegosaurus);

        Stegosaurus.setAges(5, 12, -1);
        Stegosaurus.setProperties(12.0D, 35.0D, 2.0D, 9.0D, 0.2D, 0.25D, 500);
        Stegosaurus.setExperience(0.5F, 0.2F);
        Stegosaurus.FoodItemList.addItem(EnumDinoFoodItem.Wheat);
        Stegosaurus.FoodItemList.addItem(EnumDinoFoodItem.Melon);
        Stegosaurus.FoodItemList.addItem(EnumDinoFoodItem.Carrot);
        Stegosaurus.FoodItemList.addItem(EnumDinoFoodItem.Sugar);
        Stegosaurus.FoodItemList.addItem(EnumDinoFoodItem.Cookie);
        Stegosaurus.FoodItemList.addItem(EnumDinoFoodItem.Bread);
        Stegosaurus.FoodBlockList.addblock(EnumDinoFoodBlock.Ferns);
        Stegosaurus.FoodBlockList.addblock(EnumDinoFoodBlock.Leaves);
        Stegosaurus.FoodBlockList.addblock(EnumDinoFoodBlock.Palae);
        Stegosaurus.FoodBlockList.addblock(EnumDinoFoodBlock.RedFlower);
        Stegosaurus.FoodBlockList.addblock(EnumDinoFoodBlock.YellowFlower);
        
        Dilophosaurus.setItems(Items.bone);  //,			Fossil.rawDilophosaurus,Fossil.dnaDilophosaurus,Fossil.eggDilophosaurus);

        Dilophosaurus.setAges(4, 8, -1);
        Dilophosaurus.setProperties(4.0D, 20.0D, 1.0D, 8.0D, 0.25D, 0.4D, 400);
        Dilophosaurus.setExperience(1F, 1F);
        Dilophosaurus.FoodItemList.addItem(EnumDinoFoodItem.PorkRaw);
        Dilophosaurus.FoodItemList.addItem(EnumDinoFoodItem.PorkCooked);
        Dilophosaurus.FoodItemList.addItem(EnumDinoFoodItem.ChickenRaw);
        Dilophosaurus.FoodItemList.addItem(EnumDinoFoodItem.ChickenCooked);
        Dilophosaurus.FoodItemList.addItem(EnumDinoFoodItem.DinoMeatCooked);
        Dilophosaurus.FoodItemList.addItem(EnumDinoFoodItem.Pterosaur);
        Dilophosaurus.FoodItemList.addItem(EnumDinoFoodItem.Triceratops);
        Dilophosaurus.FoodItemList.addItem(EnumDinoFoodItem.Gallimimus);
        Dilophosaurus.FoodItemList.addItem(EnumDinoFoodItem.Compsognathus);
        Dilophosaurus.FoodItemList.addItem(EnumDinoFoodItem.Egg);
        Dilophosaurus.FoodMobList.addMob(EnumDinoFoodMob.Triceratops);
        Dilophosaurus.FoodMobList.addMob(EnumDinoFoodMob.Compsognathus);
        Dilophosaurus.FoodMobList.addMob(EnumDinoFoodMob.Gallimimus);
        Dilophosaurus.FoodMobList.addMob(EnumDinoFoodMob.Pterosaur);
        Dilophosaurus.FoodMobList.addMob(EnumDinoFoodMob.Pig);
        Dilophosaurus.FoodMobList.addMob(EnumDinoFoodMob.Chicken);
        Dilophosaurus.FoodMobList.addMob(EnumDinoFoodMob.Dodo);
        
        Brachiosaurus.setItems(Items.stick);  //,			Fossil.rawBrachiosaurus,Fossil.dnaBrachiosaurus,Fossil.eggBrachiosaurus);

        Brachiosaurus.setAges(9, 20, -1);
        Brachiosaurus.setProperties(20.0D, 110.0D, 2.0D, 18.0D, 0.25D, 0.2D, 600);
        Brachiosaurus.setExperience(0.6F, 0.15F);
        Brachiosaurus.FoodItemList.addItem(EnumDinoFoodItem.Sugar);
        Brachiosaurus.FoodItemList.addItem(EnumDinoFoodItem.Cookie);
        Brachiosaurus.FoodItemList.addItem(EnumDinoFoodItem.Apple);
        Brachiosaurus.FoodBlockList.addblock(EnumDinoFoodBlock.Ferns);
        Brachiosaurus.FoodBlockList.addblock(EnumDinoFoodBlock.Leaves);
        Brachiosaurus.FoodBlockList.addblock(EnumDinoFoodBlock.Palae);
        Brachiosaurus.FoodBlockList.addblock(EnumDinoFoodBlock.RedFlower);
        Brachiosaurus.FoodBlockList.addblock(EnumDinoFoodBlock.YellowFlower);
        
        Spinosaurus.setItems(Fossil.skullStick);  //,	Fossil.rawSpinosaurus,	Fossil.dnaSpinosaurus,	Fossil.eggSpinosaurus);
        // Dimensions for Dragonith's Spinosaur.
        Spinosaurus.setAges(5, 12, -1);
        Spinosaurus.setProperties(15.0D, 60.0D, 2.0D, 14.0D, 0.25D, 0.30D, 500);
        Spinosaurus.setExperience(0F, 0.9F);
        Spinosaurus.FoodItemList.addItem(EnumDinoFoodItem.PorkRaw);
        Spinosaurus.FoodItemList.addItem(EnumDinoFoodItem.BeefRaw);
        Spinosaurus.FoodItemList.addItem(EnumDinoFoodItem.ChickenRaw);
        Spinosaurus.FoodItemList.addItem(EnumDinoFoodItem.Triceratops);
        Spinosaurus.FoodItemList.addItem(EnumDinoFoodItem.Stegosaurus);
        Spinosaurus.FoodItemList.addItem(EnumDinoFoodItem.Dilophosaurus);
        Spinosaurus.FoodItemList.addItem(EnumDinoFoodItem.Plesiosaur);
        Spinosaurus.FoodItemList.addItem(EnumDinoFoodItem.Pterosaur);
        Spinosaurus.FoodItemList.addItem(EnumDinoFoodItem.Brachiosaur);
        Spinosaurus.FoodItemList.addItem(EnumDinoFoodItem.Velociraptor);
        Spinosaurus.FoodItemList.addItem(EnumDinoFoodItem.Deinonychus);
        Spinosaurus.FoodItemList.addItem(EnumDinoFoodItem.Pachycephalosaurus);
        Spinosaurus.FoodItemList.addItem(EnumDinoFoodItem.Gallimimus);        
        Spinosaurus.FoodItemList.addItem(EnumDinoFoodItem.FishRaw);
        Spinosaurus.FoodMobList.addMob(EnumDinoFoodMob.Pig);
        Spinosaurus.FoodMobList.addMob(EnumDinoFoodMob.Cow);
        Spinosaurus.FoodMobList.addMob(EnumDinoFoodMob.Chicken);
        Spinosaurus.FoodMobList.addMob(EnumDinoFoodMob.Triceratops);
        Spinosaurus.FoodMobList.addMob(EnumDinoFoodMob.Stegosaurus);
        Spinosaurus.FoodMobList.addMob(EnumDinoFoodMob.Dilophosaurus);
        Spinosaurus.FoodMobList.addMob(EnumDinoFoodMob.Plesiosaur);
        Spinosaurus.FoodMobList.addMob(EnumDinoFoodMob.Pterosaur);
        Spinosaurus.FoodMobList.addMob(EnumDinoFoodMob.Velociraptor);
        Spinosaurus.FoodMobList.addMob(EnumDinoFoodMob.Dodo);
        Spinosaurus.FoodMobList.addMob(EnumDinoFoodMob.Deinonychus);
        Spinosaurus.FoodMobList.addMob(EnumDinoFoodMob.Pachycephalosaurus);
        Spinosaurus.FoodMobList.addMob(EnumDinoFoodMob.Gallimimus);
        
        Deinonychus.setItems(Items.bone);  //,			Fossil.rawDeinonychus, Fossil.dnaDeinonychus, Fossil.eggDeinonychus);

        Deinonychus.setAges(4, 10, -1);
        Deinonychus.setProperties(5.0D, 11.0D, 2.0D, 10.0D, 0.23D, 0.35D, 200);
        Deinonychus.setExperience(0.7F, 0.7F);
        Deinonychus.FoodItemList.addItem(EnumDinoFoodItem.PorkRaw);
        Deinonychus.FoodItemList.addItem(EnumDinoFoodItem.PorkCooked);
        Deinonychus.FoodItemList.addItem(EnumDinoFoodItem.BeefRaw);
        Deinonychus.FoodItemList.addItem(EnumDinoFoodItem.BeefCooked);
        Deinonychus.FoodItemList.addItem(EnumDinoFoodItem.ChickenCooked);
        Deinonychus.FoodItemList.addItem(EnumDinoFoodItem.ChickenRaw);
        Deinonychus.FoodItemList.addItem(EnumDinoFoodItem.DinoMeatCooked);
        Deinonychus.FoodItemList.addItem(EnumDinoFoodItem.Triceratops);
        Deinonychus.FoodItemList.addItem(EnumDinoFoodItem.Stegosaurus);
        Deinonychus.FoodItemList.addItem(EnumDinoFoodItem.Plesiosaur);
        Deinonychus.FoodItemList.addItem(EnumDinoFoodItem.Pterosaur);
        Deinonychus.FoodItemList.addItem(EnumDinoFoodItem.Brachiosaur);
        Deinonychus.FoodItemList.addItem(EnumDinoFoodItem.Gallimimus);
        Deinonychus.FoodItemList.addItem(EnumDinoFoodItem.Velociraptor);
        Deinonychus.FoodMobList.addMob(EnumDinoFoodMob.Pig);
        Deinonychus.FoodMobList.addMob(EnumDinoFoodMob.Cow);
        Deinonychus.FoodMobList.addMob(EnumDinoFoodMob.Triceratops);
        Deinonychus.FoodMobList.addMob(EnumDinoFoodMob.Stegosaurus);
        Deinonychus.FoodMobList.addMob(EnumDinoFoodMob.Pterosaur);
        Deinonychus.FoodMobList.addMob(EnumDinoFoodMob.Dodo);
        Deinonychus.FoodMobList.addMob(EnumDinoFoodMob.Chicken);
        Deinonychus.FoodMobList.addMob(EnumDinoFoodMob.Gallimimus);
        Deinonychus.FoodMobList.addMob(EnumDinoFoodMob.Velociraptor);
        
        Gallimimus.setItems(Items.stick);  //,			Fossil.rawGallimimus, Fossil.dnaGallimimus, Fossil.eggGallimimus);

        Gallimimus.setAges(4, 10, -1);
        Gallimimus.setProperties(4.0D, 20.0D, 2.0D, 6.0D, 0.3D, 0.65D, 300);
        Gallimimus.setExperience(0.7F, 0.7F);
        Gallimimus.FoodItemList.addItem(EnumDinoFoodItem.PorkRaw);
        Gallimimus.FoodItemList.addItem(EnumDinoFoodItem.PorkCooked);
        Gallimimus.FoodItemList.addItem(EnumDinoFoodItem.BeefRaw);
        Gallimimus.FoodItemList.addItem(EnumDinoFoodItem.BeefCooked);
        Gallimimus.FoodItemList.addItem(EnumDinoFoodItem.ChickenCooked);
        Gallimimus.FoodItemList.addItem(EnumDinoFoodItem.ChickenRaw);
        Gallimimus.FoodItemList.addItem(EnumDinoFoodItem.DinoMeatCooked);
        Gallimimus.FoodItemList.addItem(EnumDinoFoodItem.Triceratops);
        Gallimimus.FoodItemList.addItem(EnumDinoFoodItem.Stegosaurus);
        Gallimimus.FoodItemList.addItem(EnumDinoFoodItem.Plesiosaur);
        Gallimimus.FoodItemList.addItem(EnumDinoFoodItem.Pterosaur);
        Gallimimus.FoodItemList.addItem(EnumDinoFoodItem.Brachiosaur);
        Gallimimus.FoodItemList.addItem(EnumDinoFoodItem.Compsognathus);
        Gallimimus.FoodItemList.addItem(EnumDinoFoodItem.Velociraptor);
        Gallimimus.FoodItemList.addItem(EnumDinoFoodItem.Pterosaur); 
        
        //Veg foods
        Gallimimus.FoodBlockList.addblock(EnumDinoFoodBlock.Ferns);
        Gallimimus.FoodBlockList.addblock(EnumDinoFoodBlock.Palae);
        Gallimimus.FoodItemList.addItem(EnumDinoFoodItem.Bread);
        Gallimimus.FoodItemList.addItem(EnumDinoFoodItem.Potato);
        Gallimimus.FoodBlockList.addblock(EnumDinoFoodBlock.RedFlower);
        Gallimimus.FoodBlockList.addblock(EnumDinoFoodBlock.YellowFlower);
        Gallimimus.FoodItemList.addItem(EnumDinoFoodItem.Seeds);
        Gallimimus.FoodItemList.addItem(EnumDinoFoodItem.melonSeeds);
        
        /*
        Gastornis.setItems(Item.arrow);  //,			Fossil.rawGastornis, Fossil.dnaGastornis, Fossil.eggGastornis);
        Gastornis.setAges(4, 10, -1);
        Gastornis.setProperties(4.0D, 20.0D, 2.0D, 6.0D, 0.3D, 0.65D, 300);
        Gastornis.setExperience(0.2F, 0.2F);
        Gastornis.FoodItemList.addItem(EnumDinoFoodItem.BeefRaw);
        Gastornis.FoodMobList.addMob(EnumDinoFoodMob.Quagga);
        Gastornis.FoodMobList.addMob(EnumDinoFoodMob.Horse);
        */
    }

    /**
     *      * takes an item and returns if it is a Dino DNA
     */
    public static boolean isDinoDNA(Item i0)
    {
        for (int i = 0; i < values().length; i++)
        {
            if (values()[i].DNAItem == i0)
            {
                return true;
            }
        }

        return false;
    }

    /**
     * takes an Item and returns if it is a dino drop
     */
    public static boolean isDinoDrop(Item i0)
    {
        for (int i = 0; i < values().length; i++)
        {
            if (values()[i].DropItem == i0)
            {
                return true;
            }
        }

        return false;
    }

    /**
     * takes an item, if it is a dinos dropItem or EggItem, it returns the corresponding DNA Item
     */
    public static Item getDNA(Item i0)
    {
        for (int i = 0; i < values().length; i++)
        {
            if (values()[i].DropItem == i0 || values()[i].EggItem == i0)
            {
                return values()[i].DNAItem;
            }
        }

        return null;
    }

    /**
     * takes an item, if it is a dinos DNAItem or EggItem, it returns the corresponding Drop Item
     */
    public static Item getDrop(Item i0)
    {
        for (int i = 0; i < values().length; i++)
        {
            if (values()[i].DNAItem == i0 || values()[i].EggItem == i0)
            {
                return values()[i].DropItem;
            }
        }

        return null;
    }

    /**
     * takes an item, if it is a dinos DNAItem or DropItem, it returns the corresponding Egg Item
     */
    public static Item getEgg(Item i0)
    {
        for (int i = 0; i < values().length; i++)
        {
            if (values()[i].DNAItem == i0 || values()[i].DropItem == i0)
            {
                return values()[i].EggItem;
            }
        }

        return null;
    }
    /**
     * takes an drop-,dna- or eggitem and gives the index, -1 means not found
     */
    public static int getIndex(Item i0)
    {
        for (int i = 0; i < values().length; i++)
        {
            if (values()[i].DNAItem == i0 || values()[i].DropItem == i0 || values()[i].EggItem == i0)
            {
                return i;
            }
        }

        return -1;
    }
    public Class getDinoClass()
    {
        return this.dinoClass;
    }
    public boolean isModelable()
    {
        return (this.Flags & C.MODEL) != 0;
    }
    public boolean isTameable()
    {
        return (this.Flags & C.TAME) != 0;
    }
    public boolean isRideable()
    {
        return (this.Flags & C.RIDE) != 0;
    }
    public boolean canCarryItems()
    {
        return (this.Flags & C.CARRY) != 0;
    }
    public boolean useFeeder()
    {
        return (this.Flags & C.HERB_CARN) != 0;
    }
    public boolean isHerbivore()
    {
        return (this.Flags & C.HERBIVORE) != 0;
    }
    public boolean isCarnivore()
    {
        return (this.Flags & C.CARNIVORE) != 0;
    }
}