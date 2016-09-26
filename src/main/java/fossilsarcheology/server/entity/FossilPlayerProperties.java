package fossilsarcheology.server.entity;

import net.ilexiconn.llibrary.server.capability.EntityDataHandler;
import net.ilexiconn.llibrary.server.capability.IEntityData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class FossilPlayerProperties implements IEntityData<EntityPlayer> {
    public static final String ID = "FAPlayer";

    private EntityPlayer player;
    private boolean hasKilledAnu;

    public FossilPlayerProperties() {
        hasKilledAnu = false;
    }

    public static final void register(EntityPlayer player) {
        EntityDataHandler.INSTANCE.registerExtendedEntityData(player, new FossilPlayerProperties());
    }

    public static final FossilPlayerProperties get(EntityPlayer player) {
        return (FossilPlayerProperties) EntityDataHandler.INSTANCE.getEntityData(player, ID);
    }

    @Override
    public void saveNBTData(NBTTagCompound compound) {
        NBTTagCompound properties = new NBTTagCompound();
        properties.setBoolean("HasKilledAnu", this.hasKilledAnu);
        compound.setTag(ID, properties);
    }

    @Override
    public void loadNBTData(NBTTagCompound compound) {
        NBTTagCompound properties = (NBTTagCompound) compound.getTag(ID);
        this.hasKilledAnu = properties.getBoolean("HasKilledAnu");
        compound.setTag(ID, properties);
    }

    @Override
    public void init(EntityPlayer entity, World world) {
        this.player = entity;
    }

    @Override
    public String getID() {
        return ID;
    }

    public boolean isKilledAnu() {
        return hasKilledAnu;
    }

    public void setKilledAnu(boolean killedAnu) {
        this.hasKilledAnu = killedAnu;
    }
}