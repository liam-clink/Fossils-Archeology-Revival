package fossilsarcheology.server.block;

import fossilsarcheology.Revival;
import fossilsarcheology.server.block.entity.TileEntityFeeder;
import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockFeeder extends BlockContainer {
    private static final int NO_BIT = 0;
    private static final int HERB_BIT = 0x4;
    private static final int CARN_BIT = 0x8;
    private static final int BOTH_BITS = 0xC;
    private static final int DIRECTION_BITS = 0x3;
    private Random random = new Random();

    private static final PropertyDirection FACING = BlockHorizontal.FACING;

    public BlockFeeder(boolean isActive) {
        super(Material.IRON);
        if (isActive) {
            GameRegistry.registerTileEntity(TileEntityFeeder.class, "NewFeeder");
        }
        this.setHardness(3.5F);
        this.setSoundType(SoundType.METAL);
        if (!isActive) {
            this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
            this.setUnlocalizedName(LocalizationStrings.FEEDER_ACTIVE_NAME);
        } else {
            this.setUnlocalizedName(LocalizationStrings.FEEDER_IDLE_NAME);
        }
    }

    public static void updateFeederBlockState(boolean herb, boolean carn, World world, BlockPos pos) {
        int meta = world.getBlockMetadata(pos);
        TileEntity tile = world.getTileEntity(pos);

        if (herb) {
            meta |= HERB_BIT;
        } else {
            meta &= ~HERB_BIT;
        }
        if (carn) {
            meta |= CARN_BIT;
        } else {
            meta &= ~CARN_BIT;
        }

        world.setBlockMetadataWithNotify(pos, meta, 2);

        if (tile != null) {
            world.setTileEntity(pos, tile);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getItem(World world, BlockPos pos, IBlockState state) {
        return new ItemStack(FABlockRegistry.INSTANCE.feederActive);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(FABlockRegistry.INSTANCE.feederActive);
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        super.onBlockAdded(world, pos, state);
        this.setDefaultFacing(world, pos, state);
    }

    private void setDefaultFacing(World world, BlockPos pos, IBlockState state) {
        if (!world.isRemote) {
            IBlockState north = world.getBlockState(pos.north());
            IBlockState south = world.getBlockState(pos.south());
            IBlockState west = world.getBlockState(pos.west());
            IBlockState east = world.getBlockState(pos.east());
            EnumFacing facing = state.getValue(FACING);
            if (facing == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) {
                facing = EnumFacing.SOUTH;
            } else if (facing == EnumFacing.SOUTH && south.isFullBlock() && !north.isFullBlock()) {
                facing = EnumFacing.NORTH;
            } else if (facing == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) {
                facing = EnumFacing.EAST;
            } else if (facing == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) {
                facing = EnumFacing.WEST;
            }
            world.setBlockState(pos, state.withProperty(FACING, facing), 2);
        }
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        } else {
            TileEntityFeeder tile = (TileEntityFeeder) world.getTileEntity(pos);
            if (tile != null) {
                player.openGui(Revival.INSTANCE, 2, world, pos.getX(), pos.getY(), pos.getZ());
            }
            return true;
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityFeeder();
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityFeeder tile = (TileEntityFeeder) world.getTileEntity(pos);
        if (tile != null) {
            for (int i = 0; i < tile.getSizeInventory(); ++i) {
                ItemStack stack = tile.getStackInSlot(i);
                if (stack != null) {
                    float xOffset = this.random.nextFloat() * 0.8F + 0.1F;
                    float yOffset = this.random.nextFloat() * 0.8F + 0.1F;
                    float zOffset = this.random.nextFloat() * 0.8F + 0.1F;
                    while (stack.stackSize > 0) {
                        int rand = this.random.nextInt(21) + 10;
                        if (rand > stack.stackSize) {
                            rand = stack.stackSize;
                        }
                        stack.stackSize -= rand;
                        EntityItem entityItem = new EntityItem(world, (pos.getX() + xOffset), (pos.getY() + yOffset), (pos.getZ() + zOffset), new ItemStack(stack.getItem(), rand, stack.getItemDamage()));
                        if (stack.hasTagCompound()) {
                            entityItem.getEntityItem().setTagCompound(stack.getTagCompound().copy());
                        }
                        float offset = 0.05F;
                        entityItem.motionX = (this.random.nextGaussian() * offset);
                        entityItem.motionY = (this.random.nextGaussian() * offset + 0.2F);
                        entityItem.motionZ = (this.random.nextGaussian() * offset);
                        world.spawnEntityInWorld(entityItem);
                    }
                }
            }
        }
        super.breakBlock(world, pos, state);
    }

    @Override
    public boolean hasComparatorInputOverride(IBlockState state) {
        return true;
    }

    @Override
    public int getComparatorInputOverride(IBlockState blockState, World world, BlockPos pos) {
        return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(pos));
    }

    @Override
    public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase entity) {
        return super.onBlockPlaced(world, pos, facing, hitX, hitY, hitZ, meta, entity).withProperty(FACING, EnumFacing.fromAngle(entity.rotationYaw));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
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
