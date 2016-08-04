package fossilsarcheology.server.structure.util;

import com.mojang.authlib.GameProfile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.block.BlockRedstoneTorch;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHangingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPacketSpawnPainting;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public abstract class StructureGeneratorBase extends WorldGenerator {
    /**
     * Use this value to skip setting a block at an x,y,z coordinate for
     * whatever reason.
     */
    public static final int SET_NO_BLOCK = Integer.MAX_VALUE;

    /**
     * The directional values associated with player facing:
     */
    public static final int SOUTH = 0, WEST = 1, NORTH = 2, EAST = 3;

    /**
     * A mapping of block ids to rotation type for handling rotation. Allows
     * custom blocks to be added.
     */
    private static final Map<IBlockState, Rotation> blockRotationData = new HashMap<>();
    private static final GameProfile generatorName = new GameProfile(UUID.fromString("54acf800-054d-11e4-9191-0800200c9a66"), "fake");

    static {
        blockRotationData.put(Blocks.ANVIL.getDefaultState(), Rotation.ANVIL);

        blockRotationData.put(Blocks.IRON_DOOR.getDefaultState(), Rotation.DOOR);
        blockRotationData.put(Blocks.OAK_DOOR.getDefaultState(), Rotation.DOOR);
        blockRotationData.put(Blocks.DARK_OAK_DOOR.getDefaultState(), Rotation.DOOR);
        blockRotationData.put(Blocks.ACACIA_DOOR.getDefaultState(), Rotation.DOOR);
        blockRotationData.put(Blocks.BIRCH_DOOR.getDefaultState(), Rotation.DOOR);
        blockRotationData.put(Blocks.JUNGLE_DOOR.getDefaultState(), Rotation.DOOR);
        blockRotationData.put(Blocks.SPRUCE_DOOR.getDefaultState(), Rotation.DOOR);

        blockRotationData.put(Blocks.BED.getDefaultState(), Rotation.GENERIC);
        blockRotationData.put(Blocks.COCOA.getDefaultState(), Rotation.GENERIC);
        blockRotationData.put(Blocks.OAK_FENCE_GATE.getDefaultState(), Rotation.GENERIC);
        blockRotationData.put(Blocks.DARK_OAK_FENCE_GATE.getDefaultState(), Rotation.GENERIC);
        blockRotationData.put(Blocks.ACACIA_FENCE_GATE.getDefaultState(), Rotation.GENERIC);
        blockRotationData.put(Blocks.BIRCH_FENCE_GATE.getDefaultState(), Rotation.GENERIC);
        blockRotationData.put(Blocks.JUNGLE_FENCE_GATE.getDefaultState(), Rotation.GENERIC);
        blockRotationData.put(Blocks.SPRUCE_FENCE_GATE.getDefaultState(), Rotation.GENERIC);
        blockRotationData.put(Blocks.PUMPKIN.getDefaultState(), Rotation.GENERIC);
        blockRotationData.put(Blocks.LIT_PUMPKIN.getDefaultState(), Rotation.GENERIC);
        blockRotationData.put(Blocks.END_PORTAL_FRAME.getDefaultState(), Rotation.GENERIC);
        blockRotationData.put(Blocks.TRIPWIRE_HOOK.getDefaultState(), Rotation.GENERIC);

        blockRotationData.put(Blocks.CHEST.getDefaultState(), Rotation.PISTON_CONTAINER);
        blockRotationData.put(Blocks.TRAPPED_CHEST.getDefaultState(), Rotation.PISTON_CONTAINER);
        blockRotationData.put(Blocks.DISPENSER.getDefaultState(), Rotation.PISTON_CONTAINER);
        blockRotationData.put(Blocks.DROPPER.getDefaultState(), Rotation.PISTON_CONTAINER);
        blockRotationData.put(Blocks.ENDER_CHEST.getDefaultState(), Rotation.PISTON_CONTAINER);
        blockRotationData.put(Blocks.LIT_FURNACE.getDefaultState(), Rotation.PISTON_CONTAINER);
        blockRotationData.put(Blocks.FURNACE.getDefaultState(), Rotation.PISTON_CONTAINER);
        blockRotationData.put(Blocks.HOPPER.getDefaultState(), Rotation.PISTON_CONTAINER);
        blockRotationData.put(Blocks.LADDER.getDefaultState(), Rotation.PISTON_CONTAINER);
        blockRotationData.put(Blocks.WALL_SIGN.getDefaultState(), Rotation.PISTON_CONTAINER);
        blockRotationData.put(Blocks.PISTON.getDefaultState(), Rotation.PISTON_CONTAINER);
        blockRotationData.put(Blocks.PISTON_EXTENSION.getDefaultState(), Rotation.PISTON_CONTAINER);
        blockRotationData.put(Blocks.PISTON_HEAD.getDefaultState(), Rotation.PISTON_CONTAINER);
        blockRotationData.put(Blocks.STICKY_PISTON.getDefaultState(), Rotation.PISTON_CONTAINER);
        blockRotationData.put(Blocks.ACTIVATOR_RAIL.getDefaultState(), Rotation.PISTON_CONTAINER);
        blockRotationData.put(Blocks.DETECTOR_RAIL.getDefaultState(), Rotation.PISTON_CONTAINER);
        blockRotationData.put(Blocks.GOLDEN_RAIL.getDefaultState(), Rotation.PISTON_CONTAINER);

        blockRotationData.put(Blocks.QUARTZ_ORE.getDefaultState(), Rotation.QUARTZ);

        blockRotationData.put(Blocks.RAIL.getDefaultState(), Rotation.RAIL);

        blockRotationData.put(Blocks.POWERED_COMPARATOR.getDefaultState(), Rotation.REPEATER);
        blockRotationData.put(Blocks.UNPOWERED_COMPARATOR.getDefaultState(), Rotation.REPEATER);
        blockRotationData.put(Blocks.POWERED_REPEATER.getDefaultState(), Rotation.REPEATER);
        blockRotationData.put(Blocks.UNPOWERED_REPEATER.getDefaultState(), Rotation.REPEATER);

        blockRotationData.put(Blocks.STANDING_SIGN.getDefaultState(), Rotation.SIGNPOST);

        blockRotationData.put(Blocks.SKULL.getDefaultState(), Rotation.SKULL);

        blockRotationData.put(Blocks.BRICK_STAIRS.getDefaultState(), Rotation.STAIRS);
        blockRotationData.put(Blocks.STONE_STAIRS.getDefaultState(), Rotation.STAIRS);
        blockRotationData.put(Blocks.NETHER_BRICK_STAIRS.getDefaultState(), Rotation.STAIRS);
        blockRotationData.put(Blocks.QUARTZ_STAIRS.getDefaultState(), Rotation.STAIRS);
        blockRotationData.put(Blocks.SANDSTONE_STAIRS.getDefaultState(), Rotation.STAIRS);
        blockRotationData.put(Blocks.STONE_BRICK_STAIRS.getDefaultState(), Rotation.STAIRS);
        blockRotationData.put(Blocks.BIRCH_STAIRS.getDefaultState(), Rotation.STAIRS);
        blockRotationData.put(Blocks.JUNGLE_STAIRS.getDefaultState(), Rotation.STAIRS);
        blockRotationData.put(Blocks.OAK_STAIRS.getDefaultState(), Rotation.STAIRS);
        blockRotationData.put(Blocks.SPRUCE_STAIRS.getDefaultState(), Rotation.STAIRS);
        blockRotationData.put(Blocks.ACACIA_STAIRS.getDefaultState(), Rotation.STAIRS);
        blockRotationData.put(Blocks.DARK_OAK_STAIRS.getDefaultState(), Rotation.STAIRS);

        blockRotationData.put(Blocks.TRAPDOOR.getDefaultState(), Rotation.TRAPDOOR);

        blockRotationData.put(Blocks.VINE.getDefaultState(), Rotation.VINE);

        blockRotationData.put(Blocks.LEVER.getDefaultState(), Rotation.LEVER);

        blockRotationData.put(Blocks.STONE_BUTTON.getDefaultState(), Rotation.WALL_MOUNTED);
        blockRotationData.put(Blocks.WOODEN_BUTTON.getDefaultState(), Rotation.WALL_MOUNTED);
        blockRotationData.put(Blocks.REDSTONE_TORCH.getDefaultState(), Rotation.WALL_MOUNTED);
        blockRotationData.put(Blocks.UNLIT_REDSTONE_TORCH.getDefaultState(), Rotation.WALL_MOUNTED);
        blockRotationData.put(Blocks.TORCH.getDefaultState(), Rotation.WALL_MOUNTED);

        blockRotationData.put(Blocks.LOG.getDefaultState(), Rotation.WOOD);
    }

    /**
     * Stores a list of the structure to build, in 'layers' made up of
     * individual blockArrays.
     */
    private final List<int[][][][]> blockArrayList = new LinkedList<>();

    /**
     * Stores blocks that need to be set post-generation, such as torches
     */
    private final List<BlockData> postGenBlocks = new LinkedList<>();

    /**
     * Stores the direction this structure faces. Default is EAST.
     */
    private int structureFacing = EAST, manualRotations = 0;

    /**
     * Stores the player's facing for structure generation
     */
    private int facing;

    /**
     * Stores amount to offset structure's location in the world, if any.
     */
    private int offsetX = 0, offsetY = 0, offsetZ = 0;

    /**
     * When true all blocks will be set to air within the structure's area.
     */
    private boolean removeStructure = false;

    /**
     * Stores the data for current layer. See StructureArray.java for
     * information on how create a blockArray.
     */
    private int[][][][] blockArray;

    /**
     * Basic constructor. Sets generator to notify other blocks of blocks it
     * changes.
     */
    public StructureGeneratorBase() {
        super(true);
    }

    /**
     * Constructs the generator based on the player's facing and blockArray for
     * the structure
     */
    public StructureGeneratorBase(Entity entity, int[][][][] blocks) {
        this(entity, blocks, EAST, 0, 0, 0);
    }

    /**
     * Constructs the generator with the player's facing, the blockArray for the
     * structure and the structure's facing
     */
    public StructureGeneratorBase(Entity entity, int[][][][] blocks, int structureFacing) {
        this(entity, blocks, structureFacing, 0, 0, 0);
    }

    /**
     * Constructor for one line setting of all variables necessary to generate
     * structure
     *
     * @param blocks The structure's blockArray
     * @param structureFacing The direction in which the structure faces
     * @param offX Amount to offset the structure's location along the east-west
     * axis
     * @param offY Amount to offset the structure's location along the vertical
     * axis
     * @param offZ Amount to offset the structure's location along the
     * north-south axis
     */
    public StructureGeneratorBase(Entity entity, int[][][][] blocks, int structureFacing, int offX, int offY, int offZ) {
        super(true);
        this.setPlayerFacing(entity);
        this.setBlockArray(blocks);
        this.setStructureFacing(structureFacing);
        this.setOffset(offX, offY, offZ);
    }

    /**
     * Maps a block id to a specified rotation type. Allows custom blocks to
     * rotate with structure.
     *
     * @param blockID a valid block id, 0 to 4095 (4096 total)
     * @param rotationType types predefined by enumerated type Rotation
     * @return false if a rotation type has already been specified for the given
     * blockID
     */
    public static boolean registerCustomBlockRotation(int blockID, Rotation rotationType) {
        return registerCustomBlockRotation(blockID, rotationType, false);
    }

    /**
     * Maps a block id to a specified rotation type. Allows custom blocks to
     * rotate with structure.
     *
     * @param state a valid block id, 0 to 4095 (4096 total)
     * @param rotationType types predefined by enumerated type Rotation
     * @param override if true, will override the previously set rotation data for
     * specified blockID
     * @return false if a rotation type has already been specified for the given
     * blockID
     */
    public static boolean registerCustomBlockRotation(IBlockState state, Rotation rotationType, boolean override) {
        if (blockRotationData.containsKey(state)) {
            if (override) {
                blockRotationData.remove(state);
            } else {
                return false;
            }
        }

        blockRotationData.put(state, rotationType);

        return true;
    }

    /**
     * Use this method to add an ItemStack to the first available slot in a
     * TileEntity that implements IInventory (and thus, by extension,
     * ISidedInventory)
     *
     * @return true if entire itemstack was added
     */
    public static boolean addItemToTileInventory(World world, ItemStack stack, BlockPos pos) {
        TileEntity tile = world.getTileEntity(pos);

        if (tile == null || !(tile instanceof IInventory)) {
            System.out.println("Tile Entity at " + pos .getX() + "/" + pos.getY() + "/" + pos.getZ() + " is " + (tile != null ? "not an IInventory" : "null"));
            return false;
        }

        if (stack.stackSize < 1) {
            System.out.println("Trying to add ItemStack of size 0 to Tile Inventory");
            return false;
        }

        IInventory inventory = (IInventory) tile;
        int remaining = stack.stackSize;

        for (int i = 0; i < inventory.getSizeInventory() && remaining > 0; ++i) {
            ItemStack slot = inventory.getStackInSlot(i);

            if (slot == null && inventory.isItemValidForSlot(i, stack)) {
                remaining -= inventory.getInventoryStackLimit();
                stack.stackSize = (remaining > 0 ? inventory.getInventoryStackLimit() : stack.stackSize);
                inventory.setInventorySlotContents(i, stack);
                inventory.markDirty();
            } else if (slot != null && stack.isStackable() && inventory.isItemValidForSlot(i, stack)) {
                if (slot.getItem() == stack.getItem() && (!stack.getHasSubtypes() || stack.getItemDamage() == slot.getItemDamage()) && ItemStack.areItemStackTagsEqual(stack, slot)) {
                    int newStackSize = slot.stackSize + remaining;
                    if (newStackSize <= stack.getMaxStackSize() && newStackSize <= inventory.getInventoryStackLimit()) {
                        remaining = 0;
                        slot.stackSize = newStackSize;
                        inventory.markDirty();
                    } else if (slot.stackSize < stack.getMaxStackSize() && stack.getMaxStackSize() <= inventory.getInventoryStackLimit()) {
                        remaining -= stack.getMaxStackSize() - slot.stackSize;
                        slot.stackSize = stack.getMaxStackSize();
                        inventory.markDirty();
                    }
                }
            }
        }
        return remaining < 1;
    }

    /**
     * Sets an entity's location so that it doesn't spawn inside of walls.
     * Automatically removes placeholder block at coordinates x/y/z.
     *
     * @return false if no suitable location found
     */
    public static boolean setEntityInStructure(World world, Entity entity, BlockPos pos) {
        if (entity == null) {
            return false;
        }

        int i = 0, iMax = (entity.width > 1.0F ? 16 : 4);

        world.setBlockToAir(pos);

        entity.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), 0.0F, 0.0F);

        while (entity.isEntityInsideOpaqueBlock() && i < iMax) {
            if (i == 4 && entity.isEntityInsideOpaqueBlock() && entity.width > 1.0F) {
                entity.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), 90.0F, 0.0F);
            } else if (i == 8 && entity.isEntityInsideOpaqueBlock() && entity.width > 1.0F) {
                entity.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), 180.0F, 0.0F);
            } else if (i == 12 && entity.isEntityInsideOpaqueBlock() && entity.width > 1.0F) {
                entity.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), 270.0F, 0.0F);
            }
            switch (i % 4) {
                case 0:
                    entity.setPosition(entity.posX + 0.5D, entity.posY, entity.posZ + 0.5D);
                    break;
                case 1:
                    entity.setPosition(entity.posX, entity.posY, entity.posZ - 1.0D);
                    break;
                case 2:
                    entity.setPosition(entity.posX - 1.0D, entity.posY, entity.posZ);
                    break;
                case 3:
                    entity.setPosition(entity.posX, entity.posY, entity.posZ + 1.0D);
                    break;
            }
            ++i;
        }
        if (entity.isEntityInsideOpaqueBlock()) {
            entity.setPosition(entity.posX + 0.5D, entity.posY, entity.posZ + 0.5D);
            return false;
        }

        return true;
    }

    /**
     * Spawns an entity in the structure by using setEntityInStructure.
     *
     * @return true if entity spawned without collision (entity will still spawn
     * if false, but may be in a wall)
     */
    public static boolean spawnEntityInStructure(World world, Entity entity, BlockPos pos) {
        if (world.isRemote || entity == null) {
            return false;
        }

        boolean collided = setEntityInStructure(world, entity, pos);
        world.spawnEntityInWorld(entity);

        return collided;
    }

    /**
     * Returns an AxisAlignedBB suitable for a hanging entity at x/y/z facing
     * direction
     */
    public static AxisAlignedBB getHangingEntityAxisAligned(BlockPos pos, int direction) {
        double minX = pos.getX(), minZ = pos.getZ(), maxX = minX, maxZ = minZ;

        switch (direction) {
            case 2: // frame facing NORTH
                minX += 0.25D;
                maxX += 0.75D;
                minZ += 0.5D;
                maxZ += 1.5D;
                break;
            case 3: // frame facing SOUTH
                minX += 0.25D;
                maxX += 0.75D;
                minZ -= 0.5D;
                maxZ += 0.5D;
                break;
            case 4: // frame facing WEST
                minX += 0.5D;
                maxX += 1.5D;
                minZ += 0.25D;
                maxZ += 0.75D;
                break;
            case 5: // frame facing EAST
                minX -= 0.5D;
                maxX += 0.5D;
                minZ += 0.25D;
                maxZ += 0.75D;
                break;
        }

        return new AxisAlignedBB(minX, pos.getY(), minZ, maxX, pos.getY() + 1.0, maxZ);
    }

    /**
     * Places a hanging item entity in the world at the correct location and
     * facing. Note that you MUST use a WALL_MOUNTED type block id (such as
     * torch) for your custom block id's getRealBlockID return value in order
     * for orientation to be correct. Coordinates x,y,z are the location of the
     * block used to spawn the entity NOTE: Automatically removes the dummy
     * block at x/y/z before placing the entity, so the metadata stored in the
     * block will no longer be available, but will be returned by this method so
     * it can be stored in a local variable for later use.
     *
     * @param hanging Must be an instance of ItemHangingEntity, such as
     * Items.painting
     * @return Returns direction for further processing such as for ItemFrames,
     * or -1 if no entity set
     */
    public static EnumFacing setHangingEntity(World world, ItemStack hanging, BlockPos pos) {
        if (hanging.getItem() == null || !(hanging.getItem() instanceof ItemHangingEntity)) {
            return null;
        }

        IBlockState state = world.getBlockState(pos);

        if (world.getBlockMetadata(pos) < 1 || world.getBlockMetadata(pos) > 5) {
            return null;
        }

        int[] metaToFacing = { 5, 4, 3, 2 };
        EnumFacing direction = metaToFacing[world.getBlockMetadata(pos) - 1];
        FakePlayer player = new FakePlayer((WorldServer) world, generatorName);

        world.setBlockToAir(pos);

        pos = pos.offset(direction);

        hanging.getItem().onItemUse(hanging, player, world, pos, EnumHand.MAIN_HAND, direction, 0, 0, 0);

        return direction;
    }

    /**
     * Set's the itemstack contained in ItemFrame at x/y/z with default
     * rotation.
     *
     * @param direction Use the value returned from the setHangingEntity method
     */
    public static void setItemFrameStack(World world, ItemStack stack, BlockPos pos, int direction) {
        setItemFrameStack(world, stack, pos, direction, 0);
    }

    /**
     * Set's the itemstack contained in ItemFrame at x/y/z with specified
     * rotation.
     *
     * @param direction Use the value returned from the setHangingEntity method
     * @param itemRotation 0,1,2,3 starting at default and rotating 90 degrees clockwise
     */
    public static void setItemFrameStack(World world, ItemStack itemstack, BlockPos pos, int direction, int itemRotation) {
        List<EntityItemFrame> frames = world.getEntitiesWithinAABB(EntityItemFrame.class, getHangingEntityAxisAligned(pos, direction));
        if (frames != null && !frames.isEmpty()) {
            for (EntityItemFrame frame : frames) {
                frame.setDisplayedItem(itemstack);
                frame.setItemRotation(itemRotation);
            }
        }
    }

    /**
     * Sets the art for a painting at location x/y/z and sends a packet to
     * update players.
     *
     * @param direction Use the value returned from the setHangingEntity method
     * @return false if 'name' didn't match any EnumArt values.
     */
    public static boolean setPaintingArt(World world, String name, BlockPos pos, int direction) {
        List<EntityPainting> paintings = world.getEntitiesWithinAABB(EntityPainting.class, getHangingEntityAxisAligned(pos, direction));

        if (paintings != null && !paintings.isEmpty() && name.length() > 0) {
            for (EntityPainting toEdit : paintings) {
                EntityPainting.EnumArt[] aenumart = EntityPainting.EnumArt.values();

                for (EntityPainting.EnumArt enumart : aenumart) {
                    if (enumart.title.equals(name)) {
                        toEdit.art = enumart;
                        MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
                        if (server != null) {
                            server.getConfigurationManager().sendToAllNear(pos, 64, world.provider.getDimension(), new SPacketSpawnPainting(toEdit));
                        } else {
                            System.out.println("Attempt to send packet to all around without a server instance available");
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Adds text to a sign in the world. Use EnumChatFormatting to set colors.
     * Text of more than 15 characters per line will be truncated automatically.
     *
     * @param text A String array of no more than 4 elements; additional elements
     * will be ignored
     * @return false if no sign tile entity was found at x/y/z
     */
    public static boolean setSignText(World world, String[] text, BlockPos pos) {
        TileEntitySign sign = (world.getTileEntity(pos) instanceof TileEntitySign ? (TileEntitySign) world.getTileEntity(pos) : null);
        if (sign != null) {
            for (int i = 0; i < sign.signText.length && i < text.length; ++i) {
                if (text[i] != null && text[i].length() > 15) {
                    sign.signText[i] = new TextComponentString(text[i].substring(0, 15));
                } else {
                    sign.signText[i] = new TextComponentString(text[i]);
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Method to set skulls not requiring extra rotation data (i.e. wall-mounted
     * skulls whose rotation is determined by metadata)
     */
    public static boolean setSkullData(World world, int type, BlockPos pos) {
        return setSkullData(world, type, -1, pos);
    }

    /**
     * Sets skull type and name for a TileEntitySkull at x/y/z
     *
     * @param type Type of skull: 0 Skeleton, 1 Wither Skeleton, 2 Zombie, 3
     * Human, 4 Creeper
     * @param rot Sets the rotation for the skull if positive value is used
     * @return false if errors were encountered (i.e. incorrect tile entity at
     * x/y/z)
     */
    public static boolean setSkullData(World world, int type, int rot, BlockPos pos) {
        TileEntitySkull skull = (world.getTileEntity(pos) instanceof TileEntitySkull ? (TileEntitySkull) world.getTileEntity(pos) : null);
        if (skull != null) {
            skull.func_152107_a(3);
            if (rot > -1) {
                skull.func_145903_a(rot % 16);
            }
            return true;
        }
        return false;
    }

    /**
     * Allows the use of block ids greater than 4095 as custom 'hooks' to
     * trigger onCustomBlockAdded
     *
     * @param fakeID ID you use to identify your 'event'. Absolute value must be
     * greater than 4095
     * @param customData1 Custom data may be used to subtype events for given fakeID
     * Returns the real id of the block to spawn in the world; must
     * be less or equal to 4095
     */
    public abstract int getRealBlockID(int fakeID, int customData1);

    /**
     * A custom 'hook' to allow setting of tile entities, spawning entities,
     * etc.
     *
     * @param fakeID The custom identifier used to distinguish between types
     * @param customData1 Custom data which can be used to subtype events for given
     * fakeID
     * @param customData2 Additional custom data
     */
    public abstract void onCustomBlockAdded(World world, BlockPos pos, int fakeID, int customData1, int customData2);

    /**
     * Returns facing value as set from player, or 0 if no facing was specified
     */
    public final int getPlayerFacing() {
        return facing;
    }

    /**
     * Sets the direction in which the player is facing. The structure will be
     * generated opposite of player view (so player will be looking at front
     * when finished)
     */
    public final void setPlayerFacing(Entity entity) {
        facing = MathHelper.floor_double((entity.rotationYaw * 4F) / 360f + 0.5D) & 3;
    }

    /**
     * Sets the default direction the structure is facing. This side will always
     * face the player unless you manually rotate the structure with the
     * rotateStructureFacing() method.
     */
    public final void setStructureFacing(int facing) {
        structureFacing = facing % 4;
    }

    /**
     * This will manually rotate the structure's facing 90 degrees clockwise.
     * Note that a different side will now face the player when generated.
     */
    public final void rotateStructureFacing() {
        structureFacing = ++structureFacing % 4;
        manualRotations = ++manualRotations % 4;
    }

    /**
     * Manually rotates the structure's facing a specified number of times.
     */
    public final void rotateStructureFacing(int rotations) {
        structureFacing = (structureFacing + rotations) % 4;
        manualRotations = (manualRotations + rotations) % 4;
    }

    /**
     * Returns a string describing current facing of structure
     */
    public final String currentStructureFacing() {
        return (structureFacing == EAST ? "East" : structureFacing == WEST ? "West" : structureFacing == NORTH ? "North" : "South");
    }

    /**
     * Adds a block array 'layer' to the list to be generated
     */
    public final void addBlockArray(int blocks[][][][]) {
        if (FMLCommonHandler.instance().getEffectiveSide().isServer()) {
            blockArrayList.add(blocks);
            if (blockArray == null) {
                blockArray = blocks;
            }
        }
    }

    /**
     * Overwrites current list with the provided blockArray
     */
    public final void setBlockArray(int blocks[][][][]) {
        if (FMLCommonHandler.instance().getEffectiveSide().isServer()) {
            blockArrayList.clear();
            blockArrayList.add(blocks);
            blockArray = blocks;
        }
    }

    /**
     * Adds all elements contained in the parameter list to the structure
     */
    public final void addBlockArrayList(List<int[][][][]> list) {
        blockArrayList.addAll(list);

        if (blockArray == null && list.size() > 0) {
            blockArray = list.get(0);
        }
    }

    /**
     * Overwrites current blockArrayList with list provided
     */
    public final void setBlockArrayList(List<int[][][][]> list) {
        blockArrayList.clear();
        blockArrayList.addAll(list);
        blockArray = (list.size() > 0 ? list.get(0) : null);
    }

    /**
     * Overwrites current Structure information with passed in structure Sets
     * structure facing to the default facing of the structure Does NOT set
     * offset for the structure
     */
    public final void setStructure(Structure structure) {
        if (structure != null) {
            reset();
            setBlockArrayList(structure.blockArrayList());
            setStructureFacing(structure.getFacing());
        }
    }

    /**
     * Overwrites current Structure information with passed in structure and
     * rotates it a number of times starting from its default facing
     */
    public final void setStructureWithRotation(Structure structure, int rotations) {
        setStructure(structure);
        manualRotations = 0;
        for (int i = 0; i < rotations % 4; ++i) {
            rotateStructureFacing();
        }
    }

    /**
     * Returns lowest structure layer's width along the x axis or 0 if no
     * structure has been added
     */
    public final int getWidthX() {
        return blockArray != null ? blockArray[0].length : 0;
    }

    /**
     * Returns lowest structure layer's width along the z axis or 0 if no
     * structure has been set
     */
    public final int getWidthZ() {
        return blockArray != null ? blockArray[0][0].length : 0;
    }

    /**
     * Returns current structure layer's height or 0 if no structure has been
     * set
     */
    public final int getHeight() {
        return blockArray != null ? blockArray.length : 0;
    }

    /**
     * Returns the original facing for the structure
     */
    public final int getOriginalFacing() {
        return (structureFacing + (4 - manualRotations)) % 4;
    }

    /**
     * Returns true if the structure has been rotated onto the opposite axis
     * from original
     */
    public final boolean isOppositeAxis() {
        return getOriginalFacing() % 2 != structureFacing % 2;
    }

    /**
     * Sets the amount by which to offset the structure's generated location in
     * the world. For advanced users only. Recommended to use setDefaultOffset()
     * methods instead.
     */
    public final void setOffset(int offX, int offY, int offZ) {
        offsetX = offX;
        offsetY = offY;
        offsetZ = offZ;
    }

    /**
     * Call this only after setting the blockArray and immediately before
     * generation. Sets a default offset amount that will keep the entire
     * structure's boundaries from overlapping with the position spawned at, so
     * it will never spawn on the player.
     */
    public final void setDefaultOffset() {
        this.setDefaultOffset(new BlockPos(0, 0, 0));
    }

    /**
     * Sets offsets such that the structure always generates in front of the
     * player, regardless of structure facing, offset by parameters x/y/z. Only
     * call this method immediately before generation. NOTE: If your structures
     * y=0 layer has an area smaller than another part of the structure, setting
     * default offset will not work correctly.
     *
     * @param x Positive value spawns structure further away from player,
     * negative closer to or behind
     * @param z Positive value spawns structure more to the right, negative to
     * the left
     */
    public final void setDefaultOffset(BlockPos pos) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        boolean flagNS = getOriginalFacing() % 2 == 0;
        int length = flagNS ? getWidthX() : getWidthZ();
        int adj1 = length - (flagNS ? getWidthZ() : getWidthX());

        boolean flag1 = (flagNS ? (getWidthX() % 2 == 0 && adj1 % 2 == 1) || (getWidthX() % 2 == 1 && adj1 % 2 == -1) : (getWidthX() % 2 == 0 && adj1 % 2 == -1) || (getWidthX() % 2 == 1 && adj1 % 2 == 1));

        if (flag1 && !flagNS) {
            adj1 = -adj1;
        }

        int adj2 = (length + 1) % 2;
        int adj3 = adj1 % 2;
        int adj4 = adj1 / 2 + adj3;

        switch (getOriginalFacing()) {
            case 0: // SOUTH
                offsetZ = x + length / 2 - (manualRotations == 0 ? adj1 / 2 + (adj3 == 0 ? 0 : adj1 < 0 && flag1 ? adj3 : adj2) : manualRotations == 1 ? (adj3 == 0 ? adj2 : adj1 > 0 && flag1 ? adj3 : 0) : manualRotations == 2 ? adj1 / 2 + (adj3 == 0 || flag1 ? adj2 : adj3) : 0);
                offsetX = -z + (manualRotations == 0 ? adj2 + (adj3 > 0 && !flag1 ? adj4 : 0) : manualRotations == 1 ? (adj3 == 0 ? adj2 : flag1 ? (adj3 < 0 ? -adj3 : 0) : adj3) : manualRotations == 2 ? (adj3 > 0 && !flag1 ? adj4 : 0) : 0);
                break;
            case 1: // WEST
                offsetX = x + length / 2 - (manualRotations == 0 ? (flag1 ? -adj4 : adj1 / 2) : manualRotations == 2 ? (flag1 ? (adj1 > 0 ? -adj1 / 2 : -adj4) : adj1 / 2 + (adj3 == 0 ? adj2 : 0)) : manualRotations == 3 ? (adj3 == 0 || flag1 ? adj2 : -adj3) : 0);
                offsetZ = z + (manualRotations == 1 ? (adj3 < 0 && !flag1 ? adj4 : adj3 > 0 && flag1 ? (adj1 > 1 ? -adj1 / 2 : -adj4) : 0) + (adj3 == 0 ? -adj2 : 0) : manualRotations == 2 ? (adj3 == 0 || flag1 ? -adj2 : adj3) : manualRotations == 3 ? (adj3 < 0 && !flag1 ? adj4 : 0) : 0);
                break;
            case 2: // NORTH
                offsetZ = -x - length / 2 + (manualRotations == 0 ? adj1 / 2 + (adj3 == 0 || flag1 ? adj2 : adj3) : manualRotations == 2 ? (flag1 ? adj4 : adj1 / 2) : manualRotations == 3 ? (adj3 == 0 || flag1 ? adj2 : 0) : 0);
                offsetX = z - (manualRotations == 0 ? (adj3 > 0 ? adj3 - adj2 : 0) : manualRotations == 2 ? (adj3 > 0 ? adj3 : adj2) : manualRotations == 3 ? (adj3 > 0 ? adj3 - adj2 : adj3 < 0 ? -adj3 : adj2) : 0);
                break;
            case 3: // EAST
                offsetX = -x - length / 2 + (manualRotations == 0 ? adj1 / 2 + (adj3 == 0 ? adj2 : flag1 ? -adj1 + (adj1 > 0 ? adj3 : 0) : 0) : manualRotations == 1 ? (adj3 == 0 || flag1 ? adj2 : -adj3) : manualRotations == 2 ? (flag1 ? -adj4 : adj1 / 2) : 0);
                offsetZ = -z - (manualRotations == 0 ? (adj3 == 0 || flag1 ? -adj2 : adj3) : manualRotations == 1 ? (adj3 != 0 && !flag1 ? adj4 : 0) : manualRotations == 3 ? (adj3 < 0 && !flag1 ? adj4 : adj3 > 0 && flag1 ? -adj4 : 0) + (adj3 == 0 ? -adj2 : flag1 && adj1 > 1 ? adj3 : 0) : 0);
                break;
        }

        offsetY = 1 + y;
    }

    /**
     * Toggles between generate and remove structure setting. Returns value for
     * ease of reference.
     */
    public final boolean toggleRemoveStructure() {
        removeStructure = !removeStructure;
        return removeStructure;
    }

    /**
     * Sets remove structure to true or false
     */
    public final void setRemoveStructure(boolean value) {
        removeStructure = value;
    }

    /**
     * Returns true if the generator has enough information to generate a
     * structure
     */
    public final boolean canGenerate() {
        return blockArrayList.size() > 0 || blockArray != null;
    }

    /**
     * Generates each consecutive blockArray in the current list at location
     * posX, posZ, with posY incremented by the height of each previously
     * generated blockArray.
     */
    @Override
    public final boolean generate(World world, Random random, BlockPos pos) {
        if (world.isRemote || !canGenerate()) {
            return false;
        }

        boolean generated = true;
        int rotations = ((isOppositeAxis() ? structureFacing + 2 : structureFacing) + facing) % 4;

        setOffsetFromRotation();

        for (int[][][][] blocks : blockArrayList) {
            if (!generated) {
                break;
            }
            this.blockArray = blocks;
            generated = generateLayer(world, pos, rotations);
            offsetY += blocks.length;
        }

        if (generated) {
            doPostGenProcessing(world);
        }

        reset();

        return generated;
    }

    /**
     * Custom 'generate' method that generates a single 'layer' from the list of
     * blockArrays
     */
    private boolean generateLayer(World world, BlockPos pos, int rotations) {
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();

        int centerX = blockArray[0].length / 2, centerZ = blockArray[0][0].length / 2;

        for (int y = (removeStructure ? blockArray.length - 1 : 0); (removeStructure ? y >= 0 : y < blockArray.length); y = (removeStructure ? --y : ++y)) {
            for (int x = 0; x < blockArray[0].length; ++x) {
                for (int z = 0; z < blockArray[0][0].length; ++z) {
                    if (blockArray[0][0][0].length == 0 || blockArray[y][x][z][0] == SET_NO_BLOCK) {
                        continue;
                    }

                    int rotX = posX, rotZ = posZ, rotY = posY + y + offsetY;

                    switch (rotations) {
                        case 0: // Player is looking at the front of the default
                            // structure
                            rotX += x - centerX + offsetX;
                            rotZ += z - centerZ + offsetZ;
                            break;
                        case 1: // Rotate structure 90 degrees clockwise
                            rotX += -(z - centerZ + offsetZ);
                            rotZ += x - centerX + offsetX;
                            break;
                        case 2: // Rotate structure 180 degrees
                            rotX += -(x - centerX + offsetX);
                            rotZ += -(z - centerZ + offsetZ);
                            break;
                        case 3: // Rotate structure 270 degrees clockwise
                            rotX += z - centerZ + offsetZ;
                            rotZ += -(x - centerX + offsetX);
                            break;
                        default:
                            break;
                    }

                    int customData1 = (blockArray[y][x][z].length > 2 ? blockArray[y][x][z][2] : 0);
                    int fakeID = blockArray[y][x][z][0];
                    int realID = (Math.abs(fakeID) > 4095 ? getRealBlockID(fakeID, customData1) : fakeID);

                    if (removeStructure) {
                        if (!removeBlockAt(world, fakeID, realID, new BlockPos(rotX, rotY, rotZ), rotations)) {
                            return false;
                        }
                    } else {
                        if (Math.abs(realID) > 4095) {
                            System.err.println("Invalid block ID. Initial ID: " + fakeID + ", returned id from getRealID: " + realID);
                            continue;
                        }

                        int customData2 = (blockArray[y][x][z].length > 3 ? blockArray[y][x][z][3] : 0);
                        int meta = (blockArray[y][x][z].length > 1 ? blockArray[y][x][z][1] : 0);

                        setBlockAt(world, fakeID, realID, meta, customData1, customData2, new BlockPos(rotX, rotY, rotZ));
                    }
                }
            }
        }

        return true;
    }

    /**
     * Handles setting block with fakeID at x/y/z in world. Arguments should be
     * those retrieved from blockArray
     */
    private void setBlockAt(World world, int fakeID, int realID, int meta, int customData1, int customData2, BlockPos pos) {
        if (realID >= 0 || world.isAirBlock(pos) || world.getBlockState(pos).getMaterial().blocksMovement()) {
            if (blockRotationData.containsKey(realID)) {
                meta = getMetadata(Math.abs(realID), meta, facing);
            }
            if (blockRotationData.containsKey(realID) && (blockRotationData.get(realID) == Rotation.WALL_MOUNTED || blockRotationData.get(realID) == Rotation.LEVER)) {
                postGenBlocks.add(new BlockData(pos, fakeID, meta, customData1, customData2));
            } else {
                world.setBlockState(pos, Block.getBlockById(realID), meta, 2);

                if (blockRotationData.containsKey(realID)) {
                    setMetadata(world, pos, meta, facing);
                }

                if (Math.abs(fakeID) > 4095) {
                    onCustomBlockAdded(world, pos, fakeID, customData1, customData2);
                }
            }
        }
    }

    /**
     * Removes block at x/y/z and cleans up any items/entities that may be left
     * behind Returns false if realID is mismatched with world's blockID at
     * x/y/z
     */
    private boolean removeBlockAt(World world, int fakeID, int realID, BlockPos pos, int rotations) {
        IBlockState worldState = world.getBlockState(pos);
        if (realID == 0 || Block.getBlockById(worldState) == null || (realID < 0 && worldState != Math.abs(realID))) {
            return true;
        } else if (Math.abs(realID) == worldState || materialsMatch(realID, worldState)) // ||
        // Math.abs(fakeID)
        // >
        // 4095
        {
            world.setBlockToAir(pos);
            List<Entity> list = world.getEntitiesWithinAABB(Entity.class, getHangingEntityAxisAligned(pos, Direction.directionToFacing[rotations]).expand(1.0F, 1.0F, 1.0F));

            for (Entity entity : list) {
                if (!(entity instanceof EntityPlayer)) {
                    entity.setDead();
                }
            }
        } else {
            return false;
        }

        return true;
    }

    /**
     * Returns true if material for realID matches or is compatible with worldID
     * material
     */
    private boolean materialsMatch(int realID, int worldID) {
        return (Block.getBlockById(worldID).getMaterial() == Material.grass && Block.getBlockById(Math.abs(realID)).getMaterial() == Material.ground) || (Block.getBlockById(worldID).getMaterial().isLiquid() && Block.getBlockById(Math.abs(realID)).getMaterial() == Block.getBlockById(worldID).getMaterial()) || (Block.getBlockById(worldID).getMaterial() == Material.ice && Block.getBlockById(Math.abs(realID)).getMaterial() == Material.water) || (Block.getBlockById(worldID).getMaterial() == Material.piston && Block.getBlockById(Math.abs(realID)).getMaterial() == Material.piston) || (Block.getBlockById(worldID) instanceof BlockRedstoneTorch && Block.getBlockById(Math.abs(realID)) instanceof BlockRedstoneTorch) || (Block.getBlockById(worldID) instanceof BlockRedstoneRepeater && Block.getBlockById(Math.abs(realID)) instanceof BlockRedstoneRepeater);
    }

    /**
     * Sets blocks flagged for post-gen processing; triggers onCustomBlockAdded
     * method where applicable
     */
    private void doPostGenProcessing(World world) {
        int fakeID, realID;

        for (BlockData block : postGenBlocks) {
            fakeID = block.getBlockID();
            realID = (Math.abs(fakeID) > 4095 ? getRealBlockID(fakeID, block.getCustomData1()) : fakeID);

            if (Math.abs(realID) > 4095) {
                System.err.println("Invalid block ID. Initial ID: " + fakeID + ", returned id from getRealID: " + realID);
                continue;
            }

            if (realID >= 0 || world.isAirBlock(block.getPosX(), block.getPosY(), block.getPosZ()) || (world.getBlockState(block.getPosX(), block.getPosY(), block.getPosZ()) != null && !world.getBlockState(block.getPosX(), block.getPosY(), block.getPosZ()).getMaterial().blocksMovement())) {
                world.setBlockState(block.getPosX(), block.getPosY(), block.getPosZ(), Block.getBlockById(Math.abs(realID)), block.getMetaData(), 3);

                if (Math.abs(fakeID) > 4095) {
                    onCustomBlockAdded(world, block.getPosX(), block.getPosY(), block.getPosZ(), fakeID, block.getCustomData1(), block.getCustomData2());
                }
            }
        }

        postGenBlocks.clear();
    }

    /**
     * Fixes blocks metadata after they've been placed in the world,
     * specifically for blocks such as rails, furnaces, etc. whose orientation
     * is automatically determined by the block when placed via the onBlockAdded
     * method.
     */
    private void setMetadata(World world, BlockPos pos, int origMeta, int facing) {
        int id = world.getBlockState(pos);

        if (blockRotationData.get(id) == null) {
            return;
        }

        switch (blockRotationData.get(id)) {
            case PISTON_CONTAINER:
                world.setBlockMetadataWithNotify(pos, origMeta, 2);
                break;
            case RAIL:
                world.setBlockMetadataWithNotify(pos, origMeta, 2);
                break;
            default:
                break;
        }
    }

    /**
     * This method will return the correct metadata value for the block type
     * based on how it was rotated in the world, IF and ONLY IF you used the
     * correct metadata value to set the block's default orientation for your
     * structure's default facing.
     * <p/>
     * If your structure's front faces EAST by default, for example, and you
     * want a wall sign out front greeting all your guests, you'd better use '5'
     * as its metadata value in your blockArray so it faces EAST as well.
     * <p/>
     * Please read the blockArray notes very carefully and test out your
     * structure to make sure everything is oriented how you thought it was.
     */
    private int getMetadata(int id, int origMeta, int facing) {
        if (blockRotationData.get(id) == null) {
            return 0;
        }

        int rotations = ((isOppositeAxis() ? structureFacing + 2 : structureFacing) + facing) % 4;

        int meta = origMeta, bitface, tickDelay = meta >> 2, bit9 = meta >> 3, bit4 = meta & 4, bit8 = meta & 8, extra = meta & ~3;

        for (int i = 0; i < rotations; ++i) {
            bitface = meta % 4;

            switch (blockRotationData.get(id)) {
                case ANVIL:
                    meta ^= 1;
                    break;
                case DOOR:
                    if (bit8 != 0) {
                        return meta;
                    }
                    meta = (bitface == 3 ? 0 : bitface + 1);
                    meta |= extra;
                    break;
                case GENERIC:
                    meta = (bitface == 3 ? 0 : bitface + 1) | bit4 | bit8;
                    break;
                case PISTON_CONTAINER:
                    meta -= meta > 7 ? 8 : 0;
                    if (meta > 1) {
                        meta = meta == 2 ? 5 : meta == 5 ? 3 : meta == 3 ? 4 : 2;
                    }
                    meta |= bit8 | bit9 << 3;
                    break;
                case QUARTZ:
                    meta = meta == 3 ? 4 : meta == 4 ? 3 : meta;
                    break;
                case RAIL:
                    if (meta < 2) {
                        meta ^= 1;
                    } else if (meta < 6) {
                        meta = meta == 2 ? 5 : meta == 5 ? 3 : meta == 3 ? 4 : 2;
                    } else {
                        meta = meta == 9 ? 6 : meta + 1;
                    }
                    break;
                case REPEATER:
                    meta = (bitface == 3 ? 0 : bitface + 1) | (tickDelay << 2);
                    break;
                case SIGNPOST:
                    meta = meta < 12 ? meta + 4 : meta - 12;
                    break;
                case SKULL:
                    meta = meta == 1 ? 1 : meta == 4 ? 2 : meta == 2 ? 5 : meta == 5 ? 3 : 4;
                    break;
                case STAIRS:
                    meta = (bitface == 0 ? 2 : bitface == 2 ? 1 : bitface == 1 ? 3 : 0) | bit4;
                    break;
                case TRAPDOOR:
                    meta = (bitface == 0 ? 3 : bitface == 3 ? 1 : bitface == 1 ? 2 : 0) | bit4 | bit8;
                    break;
                case VINE:
                    meta = meta == 1 ? 2 : meta == 2 ? 4 : meta == 4 ? 8 : 1;
                    break;
                case WALL_MOUNTED:
                    if (meta > 0 && meta < 5) {
                        meta = meta == 4 ? 1 : meta == 1 ? 3 : meta == 3 ? 2 : 4;
                    }
                    break;
                case LEVER:
                    meta -= meta > 7 ? 8 : 0;
                    if (meta > 0 && meta < 5) {
                        meta = meta == 4 ? 1 : meta == 1 ? 3 : meta == 3 ? 2 : 4;
                    } else if (meta == 5 || meta == 6) {
                        meta = meta == 5 ? 6 : 5;
                    } else {
                        meta = meta == 7 ? 0 : 7;
                    }
                    meta |= bit8;
                    break;
                case WOOD:
                    if (meta > 4 && meta < 12) {
                        meta = meta < 8 ? meta + 4 : meta - 4;
                    }
                    break;
                default:
                    break;
            }
        }

        return meta;
    }

    /**
     * Adjusts offsetX and offsetZ amounts to compensate for manual rotation
     */
    private void setOffsetFromRotation() {
        int x, z;
        for (int i = 0; i < manualRotations; ++i) {
            x = -offsetZ;
            z = offsetX;
            offsetX = x;
            offsetZ = z;
        }
    }

    /**
     * Clears blockArray, blockArrayList and offsets for next structure
     */
    private void reset() {
        blockArrayList.clear();
        blockArray = null;
        offsetX = offsetY = offsetZ = 0;
    }

    /**
     * Valid rotation types. Each type is handled like vanilla blocks of this
     * kind.
     */
    public enum Rotation {
        ANVIL, DOOR, GENERIC, PISTON_CONTAINER, QUARTZ, RAIL, REPEATER, SIGNPOST, SKULL, STAIRS, TRAPDOOR, VINE, WALL_MOUNTED, LEVER, WOOD
    }
}
