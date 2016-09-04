package fossilsarcheology.server.block;

import fossilsarcheology.Revival;
import fossilsarcheology.server.block.entity.TileEntitySifter;
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
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockSifter extends BlockContainer {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;

    private static boolean keepInventory = false;
    private final boolean isActive;
    private Random random = new Random();

    public BlockSifter(boolean isActive) {
        super(Material.WOOD);
        this.isActive = isActive;
        this.setHardness(3.0F);
        this.setSoundType(SoundType.METAL);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        if (isActive) {
            this.setUnlocalizedName(LocalizationStrings.BLOCK_SIFTER_ACTIVE);
        } else {
            this.setUnlocalizedName(LocalizationStrings.BLOCK_SIFTER_IDLE);
            this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        }
    }

    public static void setState(boolean active, World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        TileEntity tile = world.getTileEntity(pos);
        keepInventory = true;
        if (active) {
            world.setBlockState(pos, FABlockRegistry.INSTANCE.blockSifterActive.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
            world.setBlockState(pos, FABlockRegistry.INSTANCE.blockSifterActive.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
        } else {
            world.setBlockState(pos, FABlockRegistry.INSTANCE.blockSifterIdle.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
            world.setBlockState(pos, FABlockRegistry.INSTANCE.blockSifterIdle.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
        }
        keepInventory = false;
        if (tile != null) {
            tile.validate();
            world.setTileEntity(pos, tile);
        }
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        super.onBlockAdded(world, pos, state);
        this.setDefaultDirection(world, pos);
    }

    private void setDefaultDirection(World world, BlockPos pos) {
        if (!world.isRemote) {
            IBlockState state = world.getBlockState(pos);
            IBlockState north = world.getBlockState(pos.north());
            IBlockState south = world.getBlockState(pos.south());
            IBlockState west = world.getBlockState(pos.west());
            IBlockState east = world.getBlockState(pos.east());
            EnumFacing direction = state.getValue(FACING);
            if (direction == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) {
                direction = EnumFacing.SOUTH;
            } else if (direction == EnumFacing.SOUTH && south.isFullBlock() && !north.isFullBlock()) {
                direction = EnumFacing.NORTH;
            } else if (direction == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) {
                direction = EnumFacing.EAST;
            } else if (direction == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) {
                direction = EnumFacing.WEST;
            }
            world.setBlockState(pos, state.withProperty(FACING, direction), 2);
        }
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            player.openGui(Revival.INSTANCE, 7, world, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntitySifter();
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        if (!keepInventory) {
            TileEntitySifter tile = (TileEntitySifter) world.getTileEntity(pos);
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
                            EntityItem entityItem = new EntityItem(world, pos.getX() + xOffset, pos.getY() + yOffset, pos.getZ() + zOffset, new ItemStack(stack.getItem(), rand, stack.getItemDamage()));
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
    @SideOnly(Side.CLIENT)
    public ItemStack getItem(World world, BlockPos pos, IBlockState state) {
        return new ItemStack(FABlockRegistry.INSTANCE.blockSifterIdle);
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
