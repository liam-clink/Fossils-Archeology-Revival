package com.github.revival.server.enums;

public enum EnumOrderType {
    STAY, FOLLOW, WANDER;

    public final EnumOrderType Next() {
        return EnumOrderType.values()[(this.ordinal() + 1) % EnumOrderType.values().length];
    }

}
