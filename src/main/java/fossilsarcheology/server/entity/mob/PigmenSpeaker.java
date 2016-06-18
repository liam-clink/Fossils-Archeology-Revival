package fossilsarcheology.server.entity.mob;

import fossilsarcheology.server.enums.EnumPigmenSpeaks;

public class PigmenSpeaker {
    EntityFriendlyPigZombie speaker = null;

    public PigmenSpeaker(EntityFriendlyPigZombie var1) {
        this.speaker = var1;
    }

    public void SendSpeech(EnumPigmenSpeaks var1) {
        this.SendSpeech(var1, "Notch");
    }

    public void SendSpeech(EnumPigmenSpeaks var1, String var2) {
    }
}
