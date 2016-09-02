package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockAncientWoodPillar extends Block {
    public BlockAncientWoodPillar() {
        super(Material.WOOD);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        this.setHardness(2.0F);
        this.setUnlocalizedName(LocalizationStrings.ANCIENT_WOOD_PILLAR_NAME);
    }

    public static int limitToValidMetadata(int meta) {
        return meta & 3;
    }

    @Override
    public int quantityDropped(Random rand) {
        return 1;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(FABlockRegistry.INSTANCE.ancientWoodPillar);
    }

    @Override
    public int onBlockPlaced(World world, BlockPos pos, int side, float hitX, float hitY, float hitZ, int metadata) {
        int validMeta = metadata & 3;
        byte modifier = 0;

        switch (side) {
            case 0:
            case 1:
                modifier = 0;
                break;
            case 2:
            case 3:
                modifier = 8;
                break;

            case 4:
            case 5:
                modifier = 4;
        }

        return validMeta | modifier;
    }

    @Override
    public int damageDropped(int meta) {
        return meta & 3;
    }

    @Override
    protected ItemStack createStackedBlock(int var1) {
        return new ItemStack(this, 1, limitToValidMetadata(var1));
    }

    public boolean canSustainLeaves(World world, BlockPos pos) {
        return true;
    }

    public boolean isWood(World world, BlockPos pos) {
        return true;
    }
}
