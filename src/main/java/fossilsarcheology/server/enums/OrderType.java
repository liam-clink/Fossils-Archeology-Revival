package fossilsarcheology.server.enums;

public enum OrderType {
    STAY, FOLLOW, WANDER;

    public final OrderType Next() {
        return OrderType.values()[(this.ordinal() + 1) % OrderType.values().length];
    }

}
