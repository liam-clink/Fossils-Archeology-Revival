package mods.fossil.items;

import java.util.HashMap;
import java.util.Map;

import mods.fossil.Fossil;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFossilRecord extends ItemRecord
{

    /** The name of the record. */
    public final String recordName;

    public ItemFossilRecord(String string)
    {
        super(string);
        this.recordName = string;
        this.maxStackSize = 1;
        setCreativeTab(Fossil.tabFItems);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        this.itemIcon = reg.registerIcon(Fossil.modid + ":record_bones");
    }
    
    /**
     * Retrieves the resource location of the sound to play for this record.
     * 
     * @param name The name of the record to play
     * @return The resource location for the audio, null to use default.
     */
    public ResourceLocation getRecordResource(String name)
    {
        return new ResourceLocation(Fossil.modid + ":" + this.recordName);
    }

}