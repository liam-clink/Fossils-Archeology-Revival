package fossilsarcheology.server.enums;

import fossilsarcheology.Revival;

public enum EnumAnimalType {
    PIG(3000),
    SHEEP(3000),
    COW(3000),
    CHICKEN(1000),
    SMILODON(4500),
    MAMMOTH(6000),
    HORSE(3500),
    QUAGGA(4000),
    ELASMOTHERIUM(5000),;

    public int growTime;

    EnumAnimalType(int grow0) {
        if (Revival.RELEASE_TYPE.enableDebugging()) {
            growTime = 100;
        } else {
            growTime = grow0;
        }
    }
}
