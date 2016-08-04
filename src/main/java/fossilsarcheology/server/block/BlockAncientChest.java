package fossilsarcheology.server.block;

import fossilsarcheology.server.block.entity.TileEntityAncientChest;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockAncientChest extends BlockContainer {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    private static final AxisAlignedBB BOUNDS = new AxisAlignedBB(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);

    private final Random rand = new Random();

    public BlockAncientChest() {
        super(Material.WOOD);
        this.setUnlocalizedName("ancientChest");
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDS;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }

    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block) {
        super.neighborChanged(state, world, pos, block);
        TileEntityAncientChest tile = (TileEntityAncientChest) world.getTileEntity(pos);
        if (tile != null) {
            tile.updateContainingBlockInfo();
        }
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityAncientChest tile = (TileEntityAncientChest) world.getTileEntity(pos);
        if (tile != null) {
            for (int slot = 0; slot < tile.getSizeInventory(); ++slot) {
                ItemStack stack = tile.getStackInSlot(slot);
                if (stack != null) {
                    float offsetX = this.rand.nextFloat() * 0.8F + 0.1F;
                    float offsetY = this.rand.nextFloat() * 0.8F + 0.1F;
                    EntityItem entity;
                    for (float offsetZ = this.rand.nextFloat() * 0.8F + 0.1F; stack.stackSize > 0; world.spawnEntityInWorld(entity)) {
                        int sizeRemoval = this.rand.nextInt(21) + 10;
                        if (sizeRemoval > stack.stackSize) {
                            sizeRemoval = stack.stackSize;
                        }
                        stack.stackSize -= sizeRemoval;
                        entity = new EntityItem(world, pos.getX() + offsetX, pos.getY() + offsetY, pos.getZ() + offsetZ, new ItemStack(stack.getItem(), sizeRemoval, stack.getItemDamage()));
                        float motionMultiplier = 0.05F;
                        entity.motionX = (double) ((float) this.rand.nextGaussian() * motionMultiplier);
                        entity.motionY = (double) ((float) this.rand.nextGaussian() * motionMultiplier + 0.2F);
                        entity.motionZ = (double) ((float) this.rand.nextGaussian() * motionMultiplier);
                        if (stack.hasTagCompound()) {
                            entity.getEntityItem().setTagCompound(stack.getTagCompound().copy());
                        }
                    }
                }
            }
        }
        super.breakBlock(world, pos, state);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        TileEntityAncientChest tile = (TileEntityAncientChest) world.getTileEntity(pos);
        if (tile != null) {
            if (tile.chestState == 0) {
                if (heldItem != null) {
                    if (heldItem.getItem() == FAItemRegistry.INSTANCE.ancientKey) {
                        tile.setChestState(1);
                        world.markBlockForUpdate(pos);
                        if (!player.capabilities.isCreativeMode) {
                            heldItem.stackSize--;
                        }
                        if (heldItem.stackSize <= 0) {
                            player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                        }
                    }
                }
            } else if (tile.chestState == 1) {
                tile.setChestState(2);
                world.markBlockForUpdate(pos);
                tile.chestLidCounter = 1;
                world.playSound(null, pos.getX(), pos.getY() + 0.5D, pos.getZ(), SoundEvents.BLOCK_CHEST_OPEN, SoundCategory.BLOCKS, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
            }
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityAncientChest();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing facing = EnumFacing.getFront(meta);
        if (facing.getAxis() == EnumFacing.Axis.Y) {
            facing = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty(FACING, facing);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rotation) {
        return state.withProperty(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirror) {
        return state.withRotation(mirror.toRotation(state.getValue(FACING)));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }
}