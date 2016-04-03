package com.github.revival.server.enums;

import net.minecraft.util.EnumChatFormatting;

public enum EnumPrehistoricMood {
    ANGRY(0, -71, EnumChatFormatting.DARK_RED),
    SAD(48, -36, EnumChatFormatting.GOLD),
    CALM(95, 0, EnumChatFormatting.YELLOW),
    CONTENT(142, 36, EnumChatFormatting.GREEN),
    HAPPY(190, 71, EnumChatFormatting.DARK_GREEN);
    public int uv;
    public int value;
    public EnumChatFormatting color;

    EnumPrehistoricMood(int uv, int value, EnumChatFormatting color) {
        this.uv = uv;
        this.value = value;
        this.color = color;
    }
}
