package mods.fossil.fossilEnums;

import mods.fossil.Fossil;

public enum EnumAnimalType
{
    Pig(3000),
    Sheep(3000),
    Cow(3000),
    Chicken(1000),
    Smilodon(4000),
    Mammoth(6000),
    Horse(3500);

    public int GrowTime;

    private EnumAnimalType(int grow0)
    {
        if (Fossil.DebugMode())
        {
            GrowTime = 100;
        }
        else
        {
            GrowTime = grow0;
        }
    }
}
