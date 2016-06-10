package com.github.revival.server.enums;

public enum EnumCoinType {
    NORMAL(1), HELL(0);
    public int targetDimension;

    EnumCoinType(int var3) {
        this.targetDimension = var3;
    }
}
