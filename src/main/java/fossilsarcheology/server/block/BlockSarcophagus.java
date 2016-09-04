package fossilsarcheology.server.block;

import fossilsarcheology.server.block.entity.TileEntitySarcophagus;
import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.FossilAchievementHandler;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSarcophagus extends BlockContainer {
    private static final AxisAlignedBB BOUNDS = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 1.9F, 1.0F);
    private static final PropertyDirection FACING = BlockHorizontal.FACING;

    public BlockSarcophagus() {
        super(Material.ROCK);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        this.setTickRandomly(true);
        this.setBlockUnbreakable();
        this.setResistance(60000000.0F);
        this.setUnlocalizedName("sarcophagus");
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDS;
    }

    @Override
    public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase entity) {
        return super.onBlockPlaced(world, pos, facing, hitX, hitY, hitZ, meta, entity).withProperty(FACING, EnumFacing.fromAngle(entity.rotationYaw));
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        TileEntitySarcophagus tile = (TileEntitySarcophagus) world.getTileEntity(pos);
        if (tile.chestState == 0) {
            if (heldItem != null) {
                if (heldItem.getItem() == FAItemRegistry.INSTANCE.gem) {
                    tile.setChestState(1);
                    world.markChunkDirty(pos, tile);
                    player.addStat(FossilAchievementHandler.anuAttack, 1);
                    if (!player.capabilities.isCreativeMode) {
                        --heldItem.stackSize;
                    }
                    if (heldItem.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }
            }
        } else if (tile.chestState == 1) {
            tile.setChestState(2);
            world.markChunkDirty(pos, tile);
            tile.chestLidCounter = 1;
            world.playSound(pos.getX(), pos.getY() + 0.5D, pos.getZ(), SoundEvents.BLOCK_CHEST_OPEN, SoundCategory.BLOCKS, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F, false);
        }
        return true;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntitySarcophagus();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.values()[meta]);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).ordinal();
    }
}