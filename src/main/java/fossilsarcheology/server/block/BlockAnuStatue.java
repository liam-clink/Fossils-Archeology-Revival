package fossilsarcheology.server.block;

import fossilsarcheology.server.block.entity.TileEntityAnuTotem;
import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import fossilsarcheology.server.item.block.AnuStatueBlockItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockAnuStatue extends BlockContainer implements IBlockItem {
    private int counter = 0;

    public BlockAnuStatue() {
        super(Material.rock);
        this.setBlockBounds(0F, 0.0F, 0F, 1F, 1.9F, 1);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        this.setTickRandomly(true);
        this.setBlockUnbreakable();
        this.setResistance(60000000.0F);
        setUnlocalizedName(LocalizationStrings.BLOCK_ANU_NAME);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("bedrock");
    }

    @Override
    public void onNeighborBlockChange(World world, BlockPos pos, Block blk) {

    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess world, BlockPos pos, int i) {
        return 15;
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, EntityLivingBase entity, ItemStack stack) {
        byte b0 = 0;
        int l = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0) {
            b0 = 2;
        }

        if (l == 1) {
            b0 = 5;
        }

        if (l == 2) {
            b0 = 3;
        }

        if (l == 3) {
            b0 = 4;
        }

        world.setBlockMetadataWithNotify(pos, b0, 2);

        world.markBlockForUpdate(pos);

        super.onBlockPlacedBy(world, pos, entity, stack);
    }

    @Override
    public int getRenderType() {
        return -93;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityAnuTotem();
    }

    @Override
    public Class<? extends ItemBlock> getItemBlockClass() {
        return AnuStatueBlockItem.class;
    }
}