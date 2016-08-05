package fossilsarcheology.server.entity.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import fossilsarcheology.Revival;
import fossilsarcheology.client.gui.GuiPedia;
import fossilsarcheology.server.entity.IViviparous;
import fossilsarcheology.server.enums.EnumPrehistoric;
import fossilsarcheology.server.handler.LocalizationStrings;

public class EntityPregnantSheep implements IViviparous, IExtendedEntityProperties {
    public final static String PREGNANT_SHEEP_PROP = "EntityPregnantSheep";
    public final EntitySheep sheep;

    public int embryoProgress;
    public EnumPrehistoric embryo;

    public EntityPregnantSheep(EntitySheep sheep) {
        this.sheep = sheep;
        this.embryoProgress = 0;
        this.embryo = null;
    }

    public static final void register(EntitySheep entity) {
        entity.registerExtendedProperties(EntityPregnantSheep.PREGNANT_SHEEP_PROP, new EntityPregnantSheep(entity));
    }

    public static final EntityPregnantSheep get(EntitySheep entity) {
        return (EntityPregnantSheep) entity.getExtendedProperties(PREGNANT_SHEEP_PROP);
    }

    @Override
    public void saveNBTData(NBTTagCompound compound) {
        compound.setInteger("EmbryoProgress", this.embryoProgress);
        if (this.embryo != null) {
            compound.setByte("Inside", (byte) this.embryo.ordinal());
        }
    }

    @Override
    public void loadNBTData(NBTTagCompound compound) {
        if (compound.hasKey("EmbryoProgress")) {
            this.embryoProgress = compound.getInteger("EmbryoProgress");
        }
        if (compound.hasKey("Inside")) {
            this.embryo = EnumPrehistoric.values()[compound.getByte("Inside")];
        }
    }

    @Override
    public void init(Entity entity, World world) {
    }

    @Override
    public void setEmbryo(EnumPrehistoric animalType) {
        this.embryo = animalType;
    }

    public void setPedia() {
        Revival.toPedia = this;
    }

    @Override
    public void showPedia(GuiPedia pedia) {
        if (this.embryo != null) {
            int progress = (int) Math.floor(((float) this.embryoProgress / (float) this.embryo.growTime * 100.0F));
            pedia.reset();
            pedia.addStringLR(StatCollector.translateToLocal(LocalizationStrings.PEDIA_EMBRYO_INSIDE), false);
            pedia.addStringLR(StatCollector.translateToLocal("pedia.embryo." + this.embryo.toString()), false, 40, 90, 245);
            pedia.addStringLR(StatCollector.translateToLocal(LocalizationStrings.PEDIA_EMBRYO_GROWING), false);
            pedia.addStringLR(String.valueOf(progress) + "/100", false);
        } else {
            pedia.reset();
            pedia.addStringLR(StatCollector.translateToLocal(LocalizationStrings.PEDIA_EMBRYO_INSIDE), false);
            pedia.addStringLR(StatCollector.translateToLocal(LocalizationStrings.PEDIA_EMBRYO_GROWING), false);
        }
    }

}
