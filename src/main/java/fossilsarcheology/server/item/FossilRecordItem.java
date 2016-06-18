package fossilsarcheology.server.item;

import fossilsarcheology.Revival;
import fossilsarcheology.server.creativetab.FATabRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;

public class FossilRecordItem extends ItemRecord {

    /**
     * The name of the record.
     */
    public final String recordName;
    public final String texture;

    public FossilRecordItem(String string, String texture) {
        super(string);
        this.recordName = string;
        this.maxStackSize = 1;
        this.texture = texture;
        setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg) {
        this.itemIcon = reg.registerIcon(texture);
    }

    /**
     * Retrieves the resource location of the sound to play for this record.
     *
     * @param name The name of the record to play
     * @return The resource location for the audio, null to use default.
     */
    @Override
    public ResourceLocation getRecordResource(String name) {
        return new ResourceLocation(Revival.MODID + ":" + this.recordName);
    }

}