package com.github.revival.server.entity.mob;

import com.github.revival.server.enums.EnumPigmenSpeaks;

public class PigmenSpeaker {
    FriendlyPigZombieEntity speaker = null;

    public PigmenSpeaker(FriendlyPigZombieEntity var1) {
        this.speaker = var1;
    }

    public void SendSpeech(EnumPigmenSpeaks var1) {
        this.SendSpeech(var1, "Notch");
    }

    public void SendSpeech(EnumPigmenSpeaks var1, String var2) {
    }
}
