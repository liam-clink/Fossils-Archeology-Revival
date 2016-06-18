package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockAncientStonebrick extends Block {
    public BlockAncientStonebrick() {
        super(Material.rock);
        this.setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
        setHardness(1.5F);
        setBlockName(LocalizationStrings.ANCIENT_STONE_BRICK_NAME);
    }

    /**
     * When this method is called, your block should register all the icons it
     * needs with the given IconRegister. This is the only chance you get to
     * register icons.
     */
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("fossil:Ancient_Stonebricks");
    }
}
