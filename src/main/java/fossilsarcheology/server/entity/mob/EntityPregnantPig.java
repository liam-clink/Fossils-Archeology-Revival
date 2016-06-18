package fossilsarcheology.server.entity.mob;

import fossilsarcheology.Revival;
import fossilsarcheology.client.gui.GuiPedia;
import fossilsarcheology.server.entity.IViviparous;
import fossilsarcheology.server.enums.EnumPrehistoric;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class EntityPregnantPig implements IViviparous, IExtendedEntityProperties {
    public final static String PREGNANT_PIG_PROP = "EntityPregnantPig";
    private final EntityPig pig;

    public int EmbryoProgress;
    public EnumPrehistoric Embryo;
    private World worldObj;

    public EntityPregnantPig(EntityPig pig) {
        this.pig = pig;
        this.EmbryoProgress = 0;
        this.Embryo = null;
    }

    // Register properties.
    public static final void register(EntityPig entity) {
        entity.registerExtendedProperties(EntityPregnantPig.PREGNANT_PIG_PROP, new EntityPregnantPig(entity));
    }

    // Return EntityPregnant* properties for Vanilla entity mobs.
    public static final EntityPregnantPig get(EntityPig entity) {
        return (EntityPregnantPig) entity.getExtendedProperties(PREGNANT_PIG_PROP);
    }

    // Save any custom data that needs saving here
    @Override
    public void saveNBTData(NBTTagCompound compound) {
        // We need to create a new tag compound that will save everything for
        // our Extended Properties
        NBTTagCompound properties = new NBTTagCompound();

        // We only have 2 variables currently; save them both to the new tag
        properties.setInteger("EmbryoProgress", this.EmbryoProgress);
        if (this.Embryo != null) {
            properties.setByte("Inside", (byte) this.Embryo.ordinal());
        }

		/*
         * Now add our custom tag to the player's tag with a unique name (our
		 * property's name). This will allow you to save multiple types of
		 * properties and distinguish between them. If you only have one type,
		 * it isn't as important, but it will still avoid conflicts between your
		 * tag names and vanilla tag names. For instance, if you add some
		 * "Items" tag, that will conflict with vanilla. Not good. So just use a
		 * unique tag name.
		 */
        compound.setTag(PREGNANT_PIG_PROP, properties);
    }

    // Load whatever data you saved
    @Override
    public void loadNBTData(NBTTagCompound compound) {
        // Here we fetch the unique tag compound we set for this class of
        // Extended Properties
        NBTTagCompound properties = (NBTTagCompound) compound.getTag(PREGNANT_PIG_PROP);
        // Get our data from the custom tag compound

        if (compound.hasKey("EmbryoProgress")) {
            this.EmbryoProgress = properties.getInteger("EmbryoProgress");
        }

        if (compound.hasKey("Inside")) {
            this.Embryo = EnumPrehistoric.values()[properties.getByte("Inside")];
        }
    }

    @Override
    public void init(Entity entity, World world) {
    }

    @Override
    public void setEmbryo(EnumPrehistoric animalType) {
        this.Embryo = animalType;
    }

    public void setPedia() {
        Revival.toPedia = this;
    }

    @Override
    public void showPedia(GuiPedia p0) {
        if (this.Embryo != null) {
            int quot = (int) Math.floor(((float) this.EmbryoProgress / (float) this.Embryo.growTime * 100.0F));

            p0.reset();
            p0.addStringLR(StatCollector.translateToLocal(LocalizationStrings.PEDIA_EMBRYO_INSIDE), false);
            p0.addStringLR(StatCollector.translateToLocal("pedia.embryo." + this.Embryo.toString()), false, 40, 90, 245);
            p0.addStringLR(StatCollector.translateToLocal(LocalizationStrings.PEDIA_EMBRYO_GROWING), false);
            p0.addStringLR(String.valueOf(quot) + "/100", false);
        } else {
            p0.reset();
            p0.addStringLR(StatCollector.translateToLocal(LocalizationStrings.PEDIA_EMBRYO_INSIDE), false);
            p0.addStringLR(StatCollector.translateToLocal(LocalizationStrings.PEDIA_EMBRYO_GROWING), false);
        }
    }

}
