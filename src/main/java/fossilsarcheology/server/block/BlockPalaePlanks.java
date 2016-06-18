package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockPalaePlanks extends Block {
    public BlockPalaePlanks() {
        super(Material.wood);
        setHardness(2.0F);
        setResistance(5.0F);
        setStepSound(Block.soundTypeWood);
        setBlockName(LocalizationStrings.PALAE_PLANKS_NAME);
        this.setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
    }

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("fossil:Palae_Planks");
    }
}
