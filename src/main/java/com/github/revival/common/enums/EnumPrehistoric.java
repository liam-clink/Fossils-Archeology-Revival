package com.github.revival.common.enums;

import net.minecraft.entity.passive.*;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.github.revival.common.creativetab.FATabRegistry;
import com.github.revival.common.entity.mob.*;
import com.github.revival.common.item.FAItemRegistry;
import com.github.revival.common.item.ItemAncientEgg;
import com.github.revival.common.item.ItemBirdEgg;


interface I
{
	int NOTHING = 0;

	int NO_FEEDER = 0;//Bits 0+1:	Dinos Can't use Feeder at all
	int HERBIVORE = 1;//Bit 0:		Dino can use Herbivore Part of Feeder
	int CARNIVORE = 2;//Bit 1: 	Dino can use Carnivore Part of Feeder
	int HERB_CARN = 3;//Bits 0+1: 	Dinos can use Herbivore and Carnivore Part of Feeder

	int MODEL = 1 << 2; //Bit 2: Dino is Modelable
	int TAME = 1 << 3; //Bit 3: Dino is Tameable
	int RIDE = 1 << 4; //Bit 4: Dino is Rideable
	int CARRY = 1 << 5; //Bit 5: Dino can Carry Items

}
public enum EnumPrehistoric {

	Nautilus(EntityNautilus.class, EnumMobType.FISH, I.NOTHING, true),
	Coelacanth(EntityCoelacanth.class, EnumMobType.FISH, I.NOTHING, true),
	Triceratops(EntityTriceratops.class, EnumMobType.DINOSAUR, I.MODEL | I.TAME | I.RIDE | I.HERBIVORE, true),
	Velociraptor(EntityVelociraptor.class, EnumMobType.DINOSAUR, I.TAME | I.CARNIVORE, true),
	TRex(EntityTRex.class, EnumMobType.DINOSAUR, I.MODEL | I.TAME | I.RIDE | I.CARNIVORE, true),
	Pterosaur(EntityPterosaur.class, EnumMobType.DINOSAUR, I.MODEL | I.TAME | I.CARNIVORE, true),
	Plesiosaur(EntityPlesiosaur.class, EnumMobType.DINOSAUR, I.MODEL | I.TAME | I.RIDE | I.CARNIVORE, true),
	Mosasaurus(EntityMosasaurus.class, EnumMobType.DINOSAUR, I.MODEL | I.CARNIVORE, true),
	Stegosaurus(EntityStegosaurus.class, EnumMobType.DINOSAUR, I.MODEL | I.TAME | I.HERBIVORE, true),
	Dilophosaurus(EntityDilophosaurus.class, EnumMobType.DINOSAUR, I.TAME | I.CARNIVORE, true),
	Brachiosaurus(EntityBrachiosaurus.class, EnumMobType.DINOSAUR, I.MODEL | I.TAME | I.RIDE | I.HERBIVORE, true),
	Spinosaurus(EntitySpinosaurus.class, EnumMobType.DINOSAUR, I.MODEL | I.CARNIVORE, true),
	Compsognathus(EntityCompsognathus.class, EnumMobType.DINOSAUR, I.MODEL | I.TAME | I.CARNIVORE, true),
	Ankylosaurus(EntityAnkylosaurus.class, EnumMobType.DINOSAUR, I.MODEL | I.TAME | I.RIDE | I.HERBIVORE, true),
	Pachycephalosaurus(EntityPachycephalosaurus.class, EnumMobType.DINOSAUR, I.TAME | I.HERBIVORE, true),
	Deinonychus(EntityDeinonychus.class, EnumMobType.DINOSAUR, I.MODEL | I.TAME | I.CARNIVORE, true),
	Gallimimus(EntityGallimimus.class, EnumMobType.DINOSAUR, I.MODEL | I.TAME | I.RIDE | I.HERB_CARN, true),
	Liopleurodon(EntityLiopleurodon.class, EnumMobType.DINOSAUR, I.MODEL | I.CARNIVORE, true),
	Allosaurus(EntityAllosaurus.class, EnumMobType.DINOSAUR, I.MODEL | I.TAME | I.RIDE | I.CARNIVORE, true),
	Sarcosuchus(EntitySarcosuchus.class, EnumMobType.DINOSAUR, I.TAME | I.CARNIVORE, true),
	Ceratosaurus(EntityCeratosaurus.class, EnumMobType.DINOSAUR, I.MODEL | I.TAME | I.RIDE | I.CARNIVORE, true),
	Confuciusornis(EntityConfuciusornis.class, EnumMobType.BIRD, I.TAME | I.HERBIVORE, true),
	Dodo(EntityDodo.class, EnumMobType.BIRD, I.TAME | I.HERBIVORE, true),
	TerrorBird(EntityTerrorBird.class, EnumMobType.TERRORBIRD, I.TAME, true),
	Mammoth(EntityMammoth.class, EnumMobType.MAMMAL, I.TAME | I.RIDE | I.HERBIVORE, true),
	Smilodon(EntitySmilodon.class, EnumMobType.MAMMAL, I.TAME | I.CARNIVORE, true),
	Quagga(EntityQuagga.class, EnumMobType.MAMMAL, I.TAME | I.RIDE | I.HERBIVORE, true),
	Elasmotherium(EntityQuagga.class, EnumMobType.MAMMAL, I.TAME | I.RIDE | I.HERBIVORE, true),
	Pig(EntityPig.class, EnumMobType.MAMMAL, I.NOTHING, false),
	Cow(EntityCow.class, EnumMobType.MAMMAL, I.NOTHING, false),
	Sheep(EntitySheep.class, EnumMobType.MAMMAL, I.NOTHING, false),
	Chicken(EntityChicken.class, EnumMobType.CHICKEN, I.NOTHING, false);

	private final Class dinoClass;
	public EnumMobType type;
	public DinoFoodItemList FoodItemList;
	public DinoFoodBlockList FoodBlockList;
	public DinoFoodMobList FoodMobList;
	public int MaxAge = 999;
	public int AdultAge = 6;
	public int TeenAge = 3;
	public double Health0 = 20;
	public double HealthMax = 20;
	public double Strength0 = 2;
	public double StrengthMax = 2;
	public double Speed0 = 0.25D;
	public double SpeedMax = 0.3D;
	public int BreedingTicks = 3000;
	public int AgingTicks = 12000;
	public int MaxHunger = 100;
	public float HungryLevel = 0.8f;
	public float Exp0 = 1.0f;
	public float ExpInc = 0.2f;
	private static float sizeBaby = 1;
	private static float sizeTeen = 1;
	private static float sizeAdult = 1;
	public int Flags = 0;
	public static Item orderItem;
	public static Item foodItem;
	public static Item DNAItem;
	public static Item eggItem;
	public static Item embryoItem;
	public static Item birdEggItem;
	public static Item bestBirdEggItem;

	EnumPrehistoric(Class class0, EnumMobType animalType, int f0, boolean init)
	{
		this.dinoClass = class0;
		this.type = animalType;
		this.Flags = f0;
		this.FoodItemList = new DinoFoodItemList();
		this.FoodBlockList = new DinoFoodBlockList();
		this.FoodMobList = new DinoFoodMobList();
	}
	
	public static void init(){
		for (int i = 0; i < values().length; i++)
        {
			if(values()[i].type == EnumMobType.DINOSAUR){
	            values()[i].eggItem = new ItemAncientEgg(i).setUnlocalizedName("egg" + EnumDinoType.values()[i].name()).setCreativeTab(FATabRegistry.tabFMaterial);	
			}
			if(values()[i].type == EnumMobType.BIRD){
			}
			if(values()[i].type == EnumMobType.BIRD || values()[i].type == EnumMobType.CHICKEN){
			}
        }

	}

	public static boolean isDNA(Item i0)
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

	public static boolean isDinoEgg(Item i0)
	{
		for (int i = 0; i < values().length; i++)
		{
			if (values()[i].type == EnumMobType.DINOSAUR){
				if (values()[i].eggItem == i0)
				{
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * takes an Item and returns if it is a dino drop
	 */
	public static boolean isFoodItem(Item i0)
	{
		for (int i = 0; i < values().length; i++)
		{
			if (values()[i].foodItem == i0)
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
			if (values()[i].bestBirdEggItem == i0 || values()[i].birdEggItem == i0 || values()[i].embryoItem == i0 || values()[i].foodItem == i0 || values()[i].eggItem == i0)
			{
				return values()[i].DNAItem;
			}
		}

		return null;
	}

	public static boolean isEmbryo(Item i0)
	{
		for (int i = 0; i < values().length; i++)
		{
			if(values()[i].type == EnumMobType.MAMMAL){

				if (values()[i].embryoItem == i0)
				{
					return true;
				}
			}
		}

		return false;
	}
	/**
	 * takes an item, if it is a dinos DNAItem or EggItem, it returns the corresponding Drop Item
	 */
	public static Item getFoodItem(Item i0)
	{
		for (int i = 0; i < values().length; i++)
		{
				if (values()[i].bestBirdEggItem == i0 || values()[i].birdEggItem == i0 || values()[i].embryoItem == i0 || values()[i].DNAItem == i0 || values()[i].eggItem == i0)
				{
					return values()[i].foodItem;
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
			if(values()[i].type == EnumMobType.DINOSAUR){

			if (values()[i].foodItem == i0 || values()[i].DNAItem == i0)
			{
				return values()[i].eggItem;
			}
			}
		}

		return null;
	}
	public static Item getEmbryo(Item i0)
	{
		for (int i = 0; i < values().length; i++)
		{
			if(values()[i].type == EnumMobType.MAMMAL){
				if(values()[i].DNAItem == i0 || values()[i].foodItem == i0 )
				{
					return values()[i].embryoItem;
				}
			}
		}

		return null;
	}
	public static Item getBirdEgg(Item i0)
	{
		for (int i = 0; i < values().length; i++)
		{
			if(values()[i].type == EnumMobType.BIRD){
				if(values()[i].bestBirdEggItem == i0 || values()[i].DNAItem == i0 || values()[i].foodItem == i0)
				{
					return values()[i].birdEggItem;
				}
			}
		}

		return null;
	}public static Item getBestBirdEgg(Item i0)
	{
		for (int i = 0; i < values().length; i++)
		{
			if(values()[i].type == EnumMobType.BIRD || values()[i].type == EnumMobType.CHICKEN){

				if(values()[i].birdEggItem == i0 || values()[i].DNAItem == i0 || values()[i].foodItem == i0)
				{
					return values()[i].bestBirdEggItem;
				}
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
			if(values()[i].bestBirdEggItem == i0 || values()[i].embryoItem == i0 || values()[i].birdEggItem == i0 || values()[i].DNAItem == i0 || values()[i].foodItem == i0 || values()[i].eggItem == i0)
			{
				return i;
			}
		}

		return -1;
	}

	/**
	 * sets the OrderItem,DropItem,DNAItem and EggItem for the Dino
	 */
	private void setOrderItem(Item order)
	{
		this.orderItem = order;
	}
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

	    private void setDinoSize(float sizeBaby, float sizeTeen, float sizeAdult)
	    {
	    	EnumPrehistoric.sizeBaby = sizeBaby;
	        EnumPrehistoric.sizeTeen = sizeTeen;
	        EnumPrehistoric.sizeAdult = sizeAdult;
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

	        if (HMax > 0)
	        {
	            this.HealthMax = HMax;
	        }

	        if (StrMax > 0)
	        {
	            this.StrengthMax = StrMax;
	        }

	        if (SpMax > 0)
	        {
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
