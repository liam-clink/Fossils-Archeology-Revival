package fossilsarcheology.server.structure.util;

import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.block.BlockRedstoneTorch;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.item.EntityPainting.EnumArt;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemHangingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.nio.ByteBuffer;
import java.util.List;

public class StructureHelper {
    public static boolean addItemToInventory(World world, ItemStack insert, BlockPos pos) {
        TileEntity tile = world.getTileEntity(pos);
        if (tile == null || !(tile instanceof IInventory)) {
            System.err.println("Tile Entity at " + pos + " is " + (tile != null ? "not an IInventory" : "null"));
            return false;
        }
        if (insert.stackSize < 1) {
            System.err.println("Trying to add ItemStack of size 0 to Tile Inventory");
            return false;
        }
        IInventory inventory = (IInventory) tile;
        int remaining = insert.stackSize;
        for (int i = 0; i < inventory.getSizeInventory() && remaining > 0; ++i) {
            ItemStack slot = inventory.getStackInSlot(i);
            if (slot == null && inventory.isItemValidForSlot(i, insert)) {
                remaining -= inventory.getInventoryStackLimit();
                insert.stackSize = (remaining > 0 ? inventory.getInventoryStackLimit() : insert.stackSize);
                inventory.setInventorySlotContents(i, insert);
                inventory.markDirty();
            } else if (slot != null && insert.isStackable() && inventory.isItemValidForSlot(i, insert)) {
                if (slot.getItem() == insert.getItem() && (!insert.getHasSubtypes() || insert.getItemDamage() == slot.getItemDamage()) && ItemStack.areItemStackTagsEqual(insert, slot)) {
                    int newSize = slot.stackSize + remaining;
                    if (newSize <= insert.getMaxStackSize() && newSize <= inventory.getInventoryStackLimit()) {
                        remaining = 0;
                        slot.stackSize = newSize;
                        inventory.markDirty();
                    } else if (slot.stackSize < insert.getMaxStackSize() && insert.getMaxStackSize() <= inventory.getInventoryStackLimit()) {
                        remaining -= insert.getMaxStackSize() - slot.stackSize;
                        slot.stackSize = insert.getMaxStackSize();
                        inventory.markDirty();
                    }
                }
            }
        }
        return remaining < 1;
    }

    public static boolean setEntityInStructure(World world, Entity entity, BlockPos pos) {
        if (entity == null) {
            return false;
        }

        int rotation = 0;
        int rotationMax = (entity.width > 1.0F ? 16 : 4);

        world.setBlockToAir(pos);

        entity.setLocationAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0.0F, 0.0F);

        while (entity.isEntityInsideOpaqueBlock() && rotation < rotationMax) {
            if (entity.width > 1.0F) {
                if (rotation == 4 && entity.isEntityInsideOpaqueBlock()) {
                    entity.setAngles(90.0F, 0.0F);
                    System.out.println("Large entity; rotating 90 degrees");
                } else if (rotation == 8 && entity.isEntityInsideOpaqueBlock()) {
                    entity.setAngles(180.0F, 0.0F);
                    System.out.println("Large entity; rotating 180 degrees");
                } else if (rotation == 12 && entity.isEntityInsideOpaqueBlock()) {
                    entity.setAngles(270.0F, 0.0F);
                    System.out.println("Large entity; rotating 270 degrees");
                }
            }

            System.out.println("Entity inside opaque block at " + entity.posX + "/" + entity.posY + "/" + entity.posZ);

            switch (rotation % 4) {
                case 0:
                    entity.setPosition(entity.posX + 0.5, entity.posY, entity.posZ + 0.5);
                    break;
                case 1:
                    entity.setPosition(entity.posX, entity.posY, entity.posZ - 1.0);
                    break;
                case 2:
                    entity.setPosition(entity.posX - 1.0, entity.posY, entity.posZ);
                    break;
                case 3:
                    entity.setPosition(entity.posX, entity.posY, entity.posZ + 1.0);
                    break;
            }

            ++rotation;
        }
        if (entity.isEntityInsideOpaqueBlock()) {
            System.err.println("Failed to set entity in open space. Returning to default position.");
            entity.setPosition(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
            return false;
        }
        return true;
    }

    public static boolean spawnEntityInStructure(World world, Entity entity, BlockPos pos) {
        if (world.isRemote || entity == null) {
            return false;
        }
        boolean collided = setEntityInStructure(world, entity, pos);
        world.spawnEntityInWorld(entity);
        System.out.println("Spawned entity at " + entity.posX + "/" + entity.posY + "/" + entity.posZ);
        return collided;
    }

    public static AxisAlignedBB getHangingEntityAxisAligned(BlockPos pos, EnumFacing direction) {
        double minX = pos.getX(), minZ = pos.getZ(), maxX = minX, maxZ = minZ;
        switch (direction) {
            case NORTH:
                minX += 0.25;
                maxX += 0.75;
                minZ += 0.5;
                maxZ += 1.5;
                break;
            case SOUTH:
                minX += 0.25;
                maxX += 0.75;
                minZ -= 0.5;
                maxZ += 0.5;
                break;
            case WEST:
                minX += 0.5;
                maxX += 1.5;
                minZ += 0.25;
                maxZ += 0.75;
                break;
            case EAST:
                minX -= 0.5;
                maxX += 0.5;
                minZ += 0.25;
                maxZ += 0.75;
                break;
        }
        return new AxisAlignedBB(minX, pos.getY(), minZ, maxX, pos.getY() + 1, maxZ);
    }

    public static EnumFacing setHangingEntity(World world, ItemStack hanging, BlockPos pos) {
        if (!(hanging.getItem() instanceof ItemHangingEntity)) {
            return null;
        }
        IBlockState state = world.getBlockState(pos);
        EnumFacing direction = BlockTypeHandler.get(state);
        world.setBlockToAir(pos);
        return direction;
    }

    public static void setItemFrameStack(World world, ItemStack itemstack, BlockPos pos, EnumFacing direction) {
        setItemFrameStack(world, itemstack, pos, direction, 0);
    }

    public static void setItemFrameStack(World world, ItemStack itemstack, BlockPos pos, EnumFacing direction, int itemRotation) {
        List<EntityItemFrame> frames = world.getEntitiesWithinAABB(EntityItemFrame.class, getHangingEntityAxisAligned(pos, direction));
        if (!frames.isEmpty()) {
            for (EntityItemFrame frame : frames) {
                frame.setDisplayedItem(itemstack);
                frame.setItemRotation(itemRotation);
            }
        }
    }

    public static boolean setPaintingArt(World world, String name, BlockPos pos, EnumFacing direction) {
        List<EntityPainting> paintings = world.getEntitiesWithinAABB(EntityPainting.class, getHangingEntityAxisAligned(pos, direction));
        if (!paintings.isEmpty() && name.length() > 0) {
            for (EntityPainting painting : paintings) {
                EnumArt[] arts = EnumArt.values();
                for (EnumArt art : arts) {
                    if (art.title.equals(name)) {
                        painting.art = art;
                        return true;
                    }
                }
                System.err.println(name + " does not match any values in EnumArt; unable to set painting art.");
            }
        }
        System.err.println("No EntityPainting was found at " + pos);
        return false;
    }

    public static boolean setSignText(World world, String[] text, BlockPos pos) {
        TileEntitySign sign = (world.getTileEntity(pos) instanceof TileEntitySign ? (TileEntitySign) world.getTileEntity(pos) : null);
        if (sign != null) {
            for (int i = 0; i < sign.signText.length && i < text.length; ++i) {
                if (text[i] == null) {
                    System.err.println("Uninitialized String element while setting sign text at index " + i);
                } else if (text[i].length() > 15) {
                    System.err.println(text[i] + " is too long to fit on a sign; maximum length is 15 characters.");
                    sign.signText[i] = new TextComponentString(text[i].substring(0, 15));
                } else {
                    sign.signText[i] = new TextComponentString(text[i]);
                }
            }
            return true;
        }
        System.err.println("No TileEntitySign was found at " + pos);
        return false;
    }

    public static boolean setSkullData(World world, int type, BlockPos pos) {
        return setSkullData(world, type, -1, pos);
    }

    public static boolean setSkullData(World world, int type, int rotation, BlockPos pos) {
        TileEntitySkull skull = (world.getTileEntity(pos) instanceof TileEntitySkull ? (TileEntitySkull) world.getTileEntity(pos) : null);
        if (skull != null) {
            if (type > 4 || type < 0) {
                System.err.println("Custom data value " + type + " not valid for skulls. Valid values are 0 to 4.");
                type = 0;
            }
            skull.setType(type);
            if (rotation > -1) {
                skull.setSkullRotation(rotation % 16);
            }
            return true;
        }

        System.err.println("No TileEntitySkull found at " + pos);
        return false;
    }

    public static IBlockState applyStructureRotation(IBlockState state, EnumFacing rotation) {
        BlockTypeHandler.RotationType rotationType = BlockTypeHandler.getRotationType(state);
        if (rotationType == null) {
            return state;
        }
        return rotationType.set(state, StructureHelper.add(rotationType.get(state), rotation));
    }

    public static BlockPos getRotatedPosition(BlockPos position) {
        return new BlockPos(-position.getZ(), position.getY(), position.getX());
    }

    public static EnumFacing rotate(EnumFacing facing, int amount) {
        return EnumFacing.getHorizontal((facing.getHorizontalIndex() + amount) % 4);
    }

    public static EnumFacing add(EnumFacing facing, EnumFacing amount) {
        return StructureHelper.rotate(facing, amount.getHorizontalIndex());
    }

    public static boolean materialsMatch(IBlockState block1, IBlockState block2) {
        return block1.getMaterial() == Material.GRASS && block2.getMaterial() == Material.GROUND || (block1.getMaterial().isLiquid() && block2.getMaterial() == block1.getMaterial()) || (block1.getMaterial() == Material.ICE && block2.getMaterial() == Material.WATER || (block1.getMaterial() == Material.PISTON && block2.getMaterial() == Material.PISTON) || (block1 instanceof BlockRedstoneTorch && block2 instanceof BlockRedstoneTorch) || (block1 instanceof BlockRedstoneRepeater && block2 instanceof BlockRedstoneRepeater));
    }

    public static ByteBuffer wrapIntegers(int... data) {
        ByteBuffer buffer = ByteBuffer.allocate(data.length * 4);
        for (int i : data) {
            buffer.putInt(i);
        }
        buffer.flip();
        return buffer;
    }
}
