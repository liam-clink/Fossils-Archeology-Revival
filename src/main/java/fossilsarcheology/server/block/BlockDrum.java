package fossilsarcheology.server.block;

import fossilsarcheology.server.block.entity.TileEntityDrum;
import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IIcon;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockDrum extends BlockContainer {
    public BlockDrum() {
        super(Material.WOOD);
        this.setUnlocalizedName(LocalizationStrings.DRUM_NAME);
        this.setHardness(0.8F);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntityDrum tileEntity = (TileEntityDrum) world.getTileEntity(pos);
            tileEntity.triggerOrder(player);
            world.setBlockMetadataWithNotify(pos, tileEntity.order.ordinal(), side);
        }
        return true;
    }

    @Override
    public void onBlockClicked(World world, BlockPos pos, EntityPlayer player) {
        if (!world.isRemote) {
            TileEntityDrum tile = (TileEntityDrum) world.getTileEntity(pos);
            if (player.inventory.getCurrentItem() != null) {
                tile.sendOrder(player.inventory.getCurrentItem().getItem(), player);
            }
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityDrum();
    }
}
