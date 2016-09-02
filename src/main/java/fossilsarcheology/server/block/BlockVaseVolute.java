package fossilsarcheology.server.block;

import fossilsarcheology.Revival;
import fossilsarcheology.server.block.entity.TileEntityVase;
import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import fossilsarcheology.server.item.block.VaseVoluteBlockItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockVaseVolute extends BlockContainer implements IBlockItem {
    public static final String[] NAMES = { "damaged_volute", "restored_volute", "redFigure_volute", "blackFigure_volute", "porcelain_volute", };

    private IIcon[] icons;
    private int getMeta;

    public BlockVaseVolute() {
        super(Material.clay);
        setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        setUnlocalizedName(LocalizationStrings.VASE_VOLUTE);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List subBlocks) {
        for (int i = 0; i < NAMES.length; ++i) {
            subBlocks.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
        this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.9F, 0.9F);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    /**
     * Called when the block is placed in the world.
     */
    @Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
        int l = MathHelper.floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 1.5D) & 3;
        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
        TileEntity tileentity = par1World.getTileEntity(par2, par3, par4);
        ((TileEntityVase) tileentity).setVaseTypeMeta(par6ItemStack.getItemDamage());
        ((TileEntityVase) tileentity).setVaseType(0);
        ((TileEntityVase) tileentity).setVaseRotation(1);
    }

    @Override
    public void breakBlock(World world, BlockPos pos, Block oldBlock, int oldMeta) {
        this.getMeta = getDamageValue(world, pos);
        super.breakBlock(world, pos, oldBlock, oldMeta);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int par2) {
        return new TileEntityVase();
    }

    @Override
    public int getDamageValue(World world, BlockPos pos) {
        TileEntity tile = world.getTileEntity(pos);
        return tile != null && tile instanceof TileEntityVase ? ((TileEntityVase) tile).getVaseTypeMeta() : super.getDamageValue(world, par2, par3, par4);
    }

    @Override
    public int damageDropped(int meta) {
        return this.getMeta;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return icons[meta];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconregister) {
        icons = new IIcon[NAMES.length];

        for (int i = 0; i < NAMES.length; ++i) {
            icons[i] = iconregister.registerIcon(Revival.MODID + ":vases/icons/" + "vase_icon_volute_" + i);
        }
    }

    @Override
    public Class<? extends ItemBlock> getItemBlockClass() {
        return VaseVoluteBlockItem.class;
    }
}
