package fossilsarcheology.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fossilsarcheology.Revival;
import net.ilexiconn.llibrary.client.gui.config.ConfigGUI;
import net.ilexiconn.llibrary.server.config.ConfigHandler;
import net.minecraft.client.gui.GuiScreen;

@SideOnly(Side.CLIENT)
public class RevivalConfigGUI extends ConfigGUI {
    public RevivalConfigGUI(GuiScreen parent) {
        super(parent, Revival.INSTANCE, ConfigHandler.INSTANCE.getConfigForID(Revival.MODID));
    }
}
