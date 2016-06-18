package fossilsarcheology.server.item.forge;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSpade;

public class ForgeShovelItem extends ItemSpade {
    String TextureFileName;

    public ForgeShovelItem(ToolMaterial par2ToolMaterial, String TextureFileName0) {
        super(par2ToolMaterial);
        this.TextureFileName = TextureFileName0;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("fossil:" + TextureFileName);
    }
}
