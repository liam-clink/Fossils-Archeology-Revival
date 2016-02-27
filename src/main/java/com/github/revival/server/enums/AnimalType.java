package com.github.revival.server.enums;

import com.github.revival.Revival;

public enum AnimalType {
    PIG(3000),
    SHEEP(3000),
    COW(3000),
    Chicken(1000),
    Smilodon(4500),
    Mammoth(6000),
    Horse(3500),
    Quagga(4000),
    Elasmotherium(5000),;

    public int GrowTime;

    private AnimalType(int grow0) {
        if (Revival.enableDebugging()) {
            GrowTime = 100;
        } else {
            GrowTime = grow0;
        }
    }
}
