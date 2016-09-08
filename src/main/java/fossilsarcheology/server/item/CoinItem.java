package fossilsarcheology.server.item;

import fossilsarcheology.server.enums.EnumCoinType;
import net.minecraft.item.Item;

public class CoinItem extends Item {
    private EnumCoinType coinType = null;

    protected CoinItem(EnumCoinType coinType) {
        super();
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.coinType = coinType;
    }

    public int getTargetDimension() {
        return this.coinType.targetDimension;
    }
}
