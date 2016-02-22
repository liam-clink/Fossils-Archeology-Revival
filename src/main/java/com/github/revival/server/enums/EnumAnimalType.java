package com.github.revival.server.enums;

import com.github.revival.Revival;

public enum EnumAnimalType {
    Pig(3000),
    Sheep(3000),
    Cow(3000),
    Chicken(1000),
    Smilodon(4500),
    Mammoth(6000),
    Horse(3500),
    Quagga(4000),
    Elasmotherium(5000),;

    public int GrowTime;

    private EnumAnimalType(int grow0) {
        if (Revival.enableDebugging()) {
            GrowTime = 100;
        } else {
            GrowTime = grow0;
        }
    }
}
