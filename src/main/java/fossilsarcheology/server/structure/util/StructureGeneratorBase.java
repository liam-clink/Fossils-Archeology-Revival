package fossilsarcheology.server.structure.util;

import net.minecraft.block.BlockRail;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.block.BlockRedstoneTorch;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class StructureGeneratorBase extends WorldGenerator {
    private final List<Object[][][][]> blockArrayList = new LinkedList<>();

    private final List<BlockData> postGenerators = new LinkedList<>();

    private EnumFacing structureFacing = EnumFacing.EAST;
    private int manualRotations = 0;

    private EnumFacing facing;

    private BlockPos offset = BlockPos.ORIGIN;

    private boolean clearSpace = false;

    private Object[][][][] blockArray;

    public StructureGeneratorBase() {
        super(true);
    }

    public StructureGeneratorBase(Entity entity, Object[][][][] blocks) {
        this(entity, blocks, EnumFacing.EAST, BlockPos.ORIGIN);
    }

    public StructureGeneratorBase(Entity entity, Object[][][][] blocks, EnumFacing structureFacing) {
        this(entity, blocks, structureFacing, BlockPos.ORIGIN);
    }

    public StructureGeneratorBase(Entity entity, Object[][][][] blocks, EnumFacing structureFacing, BlockPos offset) {
        super(true);
        this.setPlayerFacing(entity);
        this.setBlockArray(blocks);
        this.setStructureFacing(structureFacing);
        this.setOffset(offset);
    }

    public static boolean addItemToInventory(World world, ItemStack stack, BlockPos pos) {
        return StructureHelper.addItemToInventory(world, stack, pos);
    }

    public static boolean setEntityInStructure(World world, Entity entity, BlockPos pos) {
        return StructureHelper.setEntityInStructure(world, entity, pos);
    }

    public static boolean spawnEntityInStructure(World world, Entity entity, BlockPos pos) {
        return StructureHelper.spawnEntityInStructure(world, entity, pos);
    }

    public static AxisAlignedBB getHangingEntityAxisAligned(BlockPos pos, EnumFacing direction) {
        return StructureHelper.getHangingEntityAxisAligned(pos, direction);
    }

    public static EnumFacing setHangingEntity(World world, ItemStack hanging, BlockPos pos) {
        return StructureHelper.setHangingEntity(world, hanging, pos);
    }

    public static void setItemFrameStack(World world, ItemStack stack, BlockPos pos, EnumFacing direction) {
        setItemFrameStack(world, stack, pos, direction, 0);
    }

    public static void setItemFrameStack(World world, ItemStack itemstack, BlockPos pos, EnumFacing direction, int itemRotation) {
        StructureHelper.setItemFrameStack(world, itemstack, pos, direction, itemRotation);
    }

    public static boolean setPaintingArt(World world, String name, BlockPos pos, EnumFacing direction) {
        return StructureHelper.setPaintingArt(world, name, pos, direction);
    }

    public static boolean setSignText(World world, String[] text, BlockPos pos) {
        return StructureHelper.setSignText(world, text, pos);
    }

    public static boolean setSkullData(World world, int type, BlockPos pos) {
        return StructureHelper.setSkullData(world, type, pos);
    }

    public static boolean setSkullData(World world, int type, int rotation, BlockPos pos) {
        return StructureHelper.setSkullData(world, type, rotation, pos);
    }

    public final EnumFacing getPlayerFacing() {
        return this.facing;
    }

    public final void setPlayerFacing(Entity entity) {
        this.facing = EnumFacing.fromAngle(entity.rotationYaw).getOpposite();
    }

    public final void setStructureFacing(EnumFacing facing) {
        this.structureFacing = facing;
    }

    public final void rotateStructure() {
        this.rotateStructure(1);
    }

    public final void rotateStructure(int amount) {
        this.structureFacing = StructureHelper.rotate(this.structureFacing, amount);
        this.manualRotations = (this.manualRotations + amount) % 4;
    }

    public final void addBlockLayer(Object[][][][] blocks) {
        if (FMLCommonHandler.instance().getEffectiveSide().isServer()) {
            this.blockArrayList.add(blocks);
            if (this.blockArray == null) {
                this.blockArray = blocks;
            }
        }
    }

    public final void setBlockArray(Object[][][][] blocks) {
        if (FMLCommonHandler.instance().getEffectiveSide().isServer()) {
            this.blockArrayList.clear();
            this.blockArrayList.add(blocks);
            this.blockArray = blocks;
        }
    }

    public final void addBlockArrayList(List<Object[][][][]> list) {
        this.blockArrayList.addAll(list);
        if (this.blockArray == null && list.size() > 0) {
            this.blockArray = list.get(0);
        }
    }

    public final void setBlockArrayList(List<Object[][][][]> list) {
        this.blockArrayList.clear();
        this.blockArrayList.addAll(list);
        this.blockArray = (list.size() > 0 ? list.get(0) : null);
    }

    public final void setStructure(Structure structure) {
        if (structure != null) {
            this.reset();
            this.setBlockArrayList(structure.blockArrayList());
            this.setStructureFacing(structure.getFacing());
        }
    }

    public final void setStructureWithRotation(Structure structure, int rotations) {
        this.setStructure(structure);
        this.manualRotations = 0;
        for (int i = 0; i < rotations % 4; ++i) {
            this.rotateStructure();
        }
    }

    public final int getBaseSizeX() {
        return this.blockArray != null ? this.blockArray[0].length : 0;
    }

    public final int getBaseSizeZ() {
        return this.blockArray != null ? this.blockArray[0][0].length : 0;
    }

    public final int getHeight() {
        return this.blockArray != null ? this.blockArray.length : 0;
    }

    public final EnumFacing getOriginalFacing() {
        return StructureHelper.rotate(this.structureFacing, (4 - this.manualRotations));
    }

    public final boolean isOppositeAxis() {
        return this.getOriginalFacing().getHorizontalIndex() % 2 != this.structureFacing.getHorizontalIndex() % 2;
    }

    public final void setOffset(BlockPos offset) {
        this.offset = offset;
    }

    public final void setDefaultOffset() {
        this.setDefaultOffset(BlockPos.ORIGIN);
    }

    public final void setDefaultOffset(BlockPos offset) {
        int x = offset.getX();
        int y = offset.getY();
        int z = offset.getZ();
        boolean flagNS = this.getOriginalFacing().getHorizontalIndex() % 2 == 0;
        int length = flagNS ? this.getBaseSizeX() : this.getBaseSizeZ();
        int adj1 = length - (flagNS ? this.getBaseSizeZ() : this.getBaseSizeX());
        boolean flag1 = (flagNS ? (this.getBaseSizeX() % 2 == 0 && adj1 % 2 == 1) || (this.getBaseSizeX() % 2 == 1 && adj1 % 2 == -1) : (this.getBaseSizeX() % 2 == 0 && adj1 % 2 == -1) || (this.getBaseSizeX() % 2 == 1 && adj1 % 2 == 1));
        if (flag1 && !flagNS) {
            adj1 = -adj1;
        }
        int adj2 = (length + 1) % 2;
        int adj3 = adj1 % 2;
        int adj4 = adj1 / 2 + adj3;
        int offsetX = 0;
        int offsetZ = 0;
        switch (this.getOriginalFacing()) {
            case SOUTH:
                offsetZ = x + length / 2 - (this.manualRotations == 0 ? adj1 / 2 + (adj3 == 0 ? 0 : adj1 < 0 && flag1 ? adj3 : adj2) : this.manualRotations == 1 ? (adj3 == 0 ? adj2 : adj1 > 0 && flag1 ? adj3 : 0) : this.manualRotations == 2 ? adj1 / 2 + (adj3 == 0 || flag1 ? adj2 : adj3) : 0);
                offsetX = -z + (this.manualRotations == 0 ? adj2 + (adj3 > 0 && !flag1 ? adj4 : 0) : this.manualRotations == 1 ? (adj3 == 0 ? adj2 : flag1 ? (adj3 < 0 ? -adj3 : 0) : adj3) : this.manualRotations == 2 ? (adj3 > 0 && !flag1 ? adj4 : 0) : 0);
                break;
            case WEST:
                offsetX = x + length / 2 - (this.manualRotations == 0 ? (flag1 ? -adj4 : adj1 / 2) : this.manualRotations == 2 ? (flag1 ? (adj1 > 0 ? -adj1 / 2 : -adj4) : adj1 / 2 + (adj3 == 0 ? adj2 : 0)) : this.manualRotations == 3 ? (adj3 == 0 || flag1 ? adj2 : -adj3) : 0);
                offsetZ = z + (this.manualRotations == 1 ? (adj3 < 0 && !flag1 ? adj4 : adj3 > 0 && flag1 ? (adj1 > 1 ? -adj1 / 2 : -adj4) : 0) + (adj3 == 0 ? -adj2 : 0) : this.manualRotations == 2 ? (adj3 == 0 || flag1 ? -adj2 : adj3) : this.manualRotations == 3 ? (adj3 < 0 && !flag1 ? adj4 : 0) : 0);
                break;
            case NORTH:
                offsetZ = -x - length / 2 + (this.manualRotations == 0 ? adj1 / 2 + (adj3 == 0 || flag1 ? adj2 : adj3) : this.manualRotations == 2 ? (flag1 ? adj4 : adj1 / 2) : this.manualRotations == 3 ? (adj3 == 0 || flag1 ? adj2 : 0) : 0);
                offsetX = z - (this.manualRotations == 0 ? (adj3 > 0 ? adj3 - adj2 : 0) : this.manualRotations == 2 ? (adj3 > 0 ? adj3 : adj2) : this.manualRotations == 3 ? (adj3 > 0 ? adj3 - adj2 : adj3 < 0 ? -adj3 : adj2) : 0);
                break;
            case EAST:
                offsetX = -x - length / 2 + (this.manualRotations == 0 ? adj1 / 2 + (adj3 == 0 ? adj2 : flag1 ? -adj1 + (adj1 > 0 ? adj3 : 0) : 0) : this.manualRotations == 1 ? (adj3 == 0 || flag1 ? adj2 : -adj3) : this.manualRotations == 2 ? (flag1 ? -adj4 : adj1 / 2) : 0);
                offsetZ = -z - (this.manualRotations == 0 ? (adj3 == 0 || flag1 ? -adj2 : adj3) : this.manualRotations == 1 ? (adj3 != 0 && !flag1 ? adj4 : 0) : this.manualRotations == 3 ? (adj3 < 0 && !flag1 ? adj4 : adj3 > 0 && flag1 ? -adj4 : 0) + (adj3 == 0 ? -adj2 : flag1 && adj1 > 1 ? adj3 : 0) : 0);
                break;
        }
        this.offset = new BlockPos(offsetX, y + 1, offsetZ);
    }

    public final boolean toggleClearSpace() {
        this.clearSpace = !this.clearSpace;
        return this.clearSpace;
    }

    public final void setClearSpace(boolean value) {
        this.clearSpace = value;
    }

    public final boolean canGenerate() {
        return this.blockArrayList.size() > 0 || this.blockArray != null;
    }

    @Override
    public final boolean generate(World world, Random random, BlockPos pos) {
        if (world.isRemote || !this.canGenerate()) {
            return false;
        }

        boolean generated = true;
        EnumFacing structureFacing = this.isOppositeAxis() ? this.structureFacing.getOpposite() : this.structureFacing;
        EnumFacing direction = StructureHelper.rotate(structureFacing, this.facing.getHorizontalIndex());

        this.applyManualRotation();

        for (Object[][][][] blocks : this.blockArrayList) {
            if (!generated) {
                break;
            }
            this.blockArray = blocks;
            generated = this.generateLayer(world, pos, direction);
            this.offset = this.offset.up(blocks.length);
        }

        if (generated) {
            this.postGenerate(world);
        }

        this.reset();

        return generated;
    }

    private boolean generateLayer(World world, BlockPos pos, EnumFacing direction) {
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();

        int centerX = this.blockArray[0].length / 2, centerZ = this.blockArray[0][0].length / 2;

        BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos();

        for (int y = (this.clearSpace ? this.blockArray.length - 1 : 0); (this.clearSpace ? y >= 0 : y < this.blockArray.length); y = (this.clearSpace ? --y : ++y)) {
            for (int x = 0; x < this.blockArray[0].length; ++x) {
                for (int z = 0; z < this.blockArray[0][0].length; ++z) {
                    Object blockData = this.blockArray[y][x][z][0];

                    if (this.blockArray[0][0][0].length == 0 || blockData == null) {
                        continue;
                    }

                    int rotatedX = posX;
                    int rotatedZ = posZ;
                    int rotatedY = posY + y + this.offset.getY();

                    switch (direction) {
                        case NORTH:
                            rotatedX += x - centerX + this.offset.getX();
                            rotatedZ += z - centerZ + this.offset.getZ();
                            break;
                        case EAST:
                            rotatedX += -(z - centerZ + this.offset.getZ());
                            rotatedZ += x - centerX + this.offset.getX();
                            break;
                        case SOUTH:
                            rotatedX += -(x - centerX + this.offset.getX());
                            rotatedZ += -(z - centerZ + this.offset.getZ());
                            break;
                        case WEST:
                            rotatedX += z - centerZ + this.offset.getZ();
                            rotatedZ += -(x - centerX + this.offset.getX());
                            break;
                        default:
                            break;
                    }

                    blockPos.setPos(rotatedX, rotatedY, rotatedZ);

                    ByteBuffer data = (ByteBuffer) this.blockArray[y][x][z][1];

                    CustomBlock customBlock = null;
                    IBlockState state;

                    if (blockData instanceof CustomBlock) {
                        customBlock = (CustomBlock) blockData;
                        state = ((CustomBlock) blockData).getBlock(world, blockPos, data);
                    } else {
                        state = (IBlockState) blockData;
                    }

                    if (this.clearSpace) {
                        if (!this.removeBlock(world, state, blockPos, direction)) {
                            return false;
                        }
                    } else {
                        this.setBlockAt(world, customBlock, data, blockPos);
                    }
                }
            }
        }

        return true;
    }

    private void setBlockAt(World world, CustomBlock customBlock, ByteBuffer data, BlockPos position) {
        IBlockState state = customBlock.getBlock(world, position, data);
        data.position(0);
        if ((state != null && state.getBlock() != Blocks.AIR) || world.isAirBlock(position) || world.getBlockState(position).getMaterial().blocksMovement()) {
            state = this.rotate(state, this.facing);
            if (BlockTypeHandler.isWallMounted(state)) {
                this.postGenerators.add(new BlockData(position, customBlock, data));
            } else {
                world.setBlockState(position, state, 2);
                this.fixRotation(world, position, state);
                customBlock.onPlace(world, position, data);
            }
        }
    }

    private void setBlockAt(World world, IBlockState state, BlockPos pos) {
        if (state.getBlock() != Blocks.AIR || world.isAirBlock(pos) || world.getBlockState(pos).getMaterial().blocksMovement()) {
            state = this.rotate(state, this.facing);
            world.setBlockState(pos, state, 2);
            this.fixRotation(world, pos, state);
        }
    }

    private boolean removeBlock(World world, IBlockState state, BlockPos pos, EnumFacing direction) {
        IBlockState worldState = world.getBlockState(pos);
        if (state.getBlock() == Blocks.AIR || worldState.getBlock() == Blocks.AIR || (state == null && worldState.getBlock() != state.getBlock())) {
            return true;
        } else if (state.getBlock() == worldState.getBlock() || this.materialsMatch(state, worldState)) {
            world.setBlockToAir(pos);
            List<Entity> entities = world.getEntitiesWithinAABB(Entity.class, getHangingEntityAxisAligned(pos, direction).expand(1.0F, 1.0F, 1.0F));
            for (Entity entity : entities) {
                if (!(entity instanceof EntityPlayer)) {
                    entity.setDead();
                }
            }
        } else {
            return false;
        }
        return true;
    }

    private boolean materialsMatch(IBlockState state, IBlockState world) {
        return (world.getMaterial() == Material.GRASS && state.getMaterial() == Material.GROUND) || (world.getMaterial().isLiquid() && state.getMaterial() == world.getMaterial()) || (world.getMaterial() == Material.ICE && state.getMaterial() == Material.WATER) || (world.getMaterial() == Material.PISTON && state.getMaterial() == Material.PISTON) || (world instanceof BlockRedstoneTorch && state instanceof BlockRedstoneTorch) || (world instanceof BlockRedstoneRepeater && state instanceof BlockRedstoneRepeater);
    }

    private void postGenerate(World world) {
        for (BlockData block : this.postGenerators) {
            BlockPos position = block.getPosition();
            if (world.isAirBlock(position) || !world.getBlockState(position).getMaterial().blocksMovement()) {
                CustomBlock customBlock = block.getCustomBlock();
                ByteBuffer data = block.getData();
                world.setBlockState(position, customBlock.getBlock(world, position, data), 3);
                data.position(0);
                customBlock.onPlace(world, position, data);
                data.position(0);
            }
        }
        this.postGenerators.clear();
    }

    private void fixRotation(World world, BlockPos pos, IBlockState state) {
        if (state.getBlock() instanceof BlockRail) {
            world.setBlockState(pos, state, 2);
        }
    }

    private IBlockState rotate(IBlockState state, EnumFacing facing) {
        return StructureHelper.applyStructureRotation(state, StructureHelper.add(facing, this.isOppositeAxis() ? this.structureFacing.getOpposite() : this.structureFacing));
    }

    private void applyManualRotation() {
        for (int i = 0; i < this.manualRotations; ++i) {
            this.offset = StructureHelper.getRotatedPosition(this.offset);
        }
    }

    private void reset() {
        this.blockArrayList.clear();
        this.blockArray = null;
        this.offset = BlockPos.ORIGIN;
    }
}
