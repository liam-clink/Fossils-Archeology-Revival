package fossilsarcheology.server.item;

public class ItemFrozenMeat extends BasicSwordItem {

    public ItemFrozenMeat() {
        super(FAItemRegistry.ICED_MEAT_MATERIAL, "iced_meat");
        this.maxStackSize = 64;
    }
}
