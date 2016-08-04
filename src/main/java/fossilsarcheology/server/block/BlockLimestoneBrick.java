package fossilsarcheology.server.block;

import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockLimestoneBrick extends Block {

    public BlockLimestoneBrick(Material material) {
        super(Material.rock);
        setHardness(3.0F);
        setResistance(20.0F);
        setSoundType(Block.soundTypeStone);
        setUnlocalizedName(LocalizationStrings.BLOCK_LIMESTONEBRICK_NAME);
    }

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("fossil:Limestone_Brick");
    }

}
