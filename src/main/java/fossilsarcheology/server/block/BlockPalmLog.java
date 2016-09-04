package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockPalmLog extends Block {
    public BlockPalmLog() {
        super(Material.WOOD);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        this.setSoundType(SoundType.WOOD);
        this.setHardness(1.4F);
        this.setResistance(1.0F);
        this.setUnlocalizedName(LocalizationStrings.PALAE_LOG_NAME);
    }

    @Override
    public int quantityDropped(Random rand) {
        return 1;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(FABlockRegistry.INSTANCE.palmLog);
    }

    @Override
    public void breakBlock(World world, BlockPos pos, Block oldBlock, int oldMeta) {
        byte scanArea = 4;
        int i = scanArea + 1;
        if (world.checkChunksExist(x - i, y - i, z - i, x + i, y + i, z + i)) {
            for (int offsetX = -scanArea; offsetX <= scanArea; ++offsetX) {
                for (int offsetY = -scanArea; offsetY <= scanArea; ++offsetY) {
                    for (int offsetZ = -scanArea; offsetZ <= scanArea; ++offsetZ) {
                        Block block = world.getBlock(x + offsetX, y + offsetY, z + offsetZ);
                        if (block.isLeaves(world, x + offsetX, y + offsetY, z + offsetZ)) {
                            int metadata = world.getBlockMetadata(x + offsetX, y + offsetY, z + offsetZ);
                            if ((metadata & 8) == 0) {
                                world.setBlockMetadataWithNotify(x + offsetX, y + offsetY, z + offsetZ, metadata | 8, 2);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public int onBlockPlaced(World world, BlockPos pos, int side, float hitX, float hitY, float hitZ, int meta) {
        int var10 = meta & 3;
        byte var11 = 0;
        switch (side) {
            case 0:
            case 1:
                var11 = 0;
                break;
            case 2:
            case 3:
                var11 = 8;
                break;
            case 4:
            case 5:
                var11 = 4;
        }
        return var10 | var11;
    }

    @Override
    public int damageDropped(int meta) {
        return meta & 3;
    }

    @Override
    protected ItemStack createStackedBlock(int var1) {
        return new ItemStack(this, 1, validateMeta(var1));
    }

    @Override
    public boolean canSustainLeaves(IBlockAccess world, BlockPos pos) {
        return true;
    }

    @Override
    public boolean isWood(IBlockAccess world, BlockPos pos) {
        return true;
    }
}
