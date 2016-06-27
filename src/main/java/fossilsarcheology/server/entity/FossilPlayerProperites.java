package fossilsarcheology.server.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class FossilPlayerProperites implements IExtendedEntityProperties {

    public final static String EXT_PROP_NAME = "FAPlayer";
    private final EntityPlayer player;
    private boolean hasKilledAnu;

    public FossilPlayerProperites(EntityPlayer player) {
        this.player = player;
        hasKilledAnu = false;
    }

    public static final void register(EntityPlayer player) {
        player.registerExtendedProperties(FossilPlayerProperites.EXT_PROP_NAME, new FossilPlayerProperites(player));
    }

    public static final FossilPlayerProperites get(EntityPlayer player) {
        return (FossilPlayerProperites) player.getExtendedProperties(EXT_PROP_NAME);
    }

    @Override
    public void saveNBTData(NBTTagCompound compound) {
        NBTTagCompound properties = new NBTTagCompound();
        properties.setBoolean("HasKilledAnu", this.hasKilledAnu);
        compound.setTag(EXT_PROP_NAME, properties);
    }

    @Override
    public void loadNBTData(NBTTagCompound compound) {
        NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
        this.hasKilledAnu = properties.getBoolean("HasKilledAnu");
        compound.setTag(EXT_PROP_NAME, properties);
    }

    @Override
    public void init(Entity entity, World world) {
    }

    public boolean isKilledAnu() {
        return hasKilledAnu;
    }

    public void setKilledAnu(boolean i) {
        this.hasKilledAnu = i;
    }

}