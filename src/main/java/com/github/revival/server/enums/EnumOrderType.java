package com.github.revival.server.enums;

public enum EnumOrderType {
    STAY, FOLLOW, WANDER;

    public final EnumOrderType Next() {
        return this.values()[(this.ordinal() + 1) % this.values().length];
    }

}
