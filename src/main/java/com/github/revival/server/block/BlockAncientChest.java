package com.github.revival.server.block;

import com.github.revival.server.block.entity.TileEntityAncientChest;
import com.github.revival.server.item.FAItemRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;

public class BlockAncientChest extends BlockContainer {
    private final Random rand = new Random();

    public BlockAncientChest() {
        super(Material.wood);
        this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
        this.setBlockName("ancientChest");
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube() {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock() {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType() {
        return 22;
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
    }


    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack stack) {

        byte facing = 0;
        int rotation = MathHelper.floor_double((double) (placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (rotation == 0) {
            facing = 2;
        }

        if (rotation == 1) {
            facing = 5;
        }

        if (rotation == 2) {
            facing = 3;
        }

        if (rotation == 3) {
            facing = 4;
        }
        world.setBlockMetadataWithNotify(x, y, z, facing, 2);
        world.markBlockForUpdate(x, y, z);
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        super.onNeighborBlockChange(world, x, y, z, block);
        TileEntityAncientChest tile = (TileEntityAncientChest) world.getTileEntity(x, y, z);

        if (tile != null) {
            tile.updateContainingBlockInfo();
        }
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int i) {
        TileEntityAncientChest tile = (TileEntityAncientChest) world.getTileEntity(x, y, z);

        if (tile != null) {
            for (int slot = 0; slot < tile.getSizeInventory(); ++slot) {
                ItemStack stack = tile.getStackInSlot(slot);

                if (stack != null) {
                    float offsetX = this.rand.nextFloat() * 0.8F + 0.1F;
                    float offsetY = this.rand.nextFloat() * 0.8F + 0.1F;
                    EntityItem itemEntity;

                    for (float offsetZ = this.rand.nextFloat() * 0.8F + 0.1F; stack.stackSize > 0; world.spawnEntityInWorld(itemEntity)) {
                        int sizeRemoval = this.rand.nextInt(21) + 10;

                        if (sizeRemoval > stack.stackSize) {
                            sizeRemoval = stack.stackSize;
                        }

                        stack.stackSize -= sizeRemoval;
                        itemEntity = new EntityItem(world, (double) ((float) x + offsetX), (double) ((float) y + offsetY), (double) ((float) z + offsetZ), new ItemStack(stack.getItem(), sizeRemoval, stack.getItemDamage()));
                        float motionMultiplier = 0.05F;
                        itemEntity.motionX = (double) ((float) this.rand.nextGaussian() * motionMultiplier);
                        itemEntity.motionY = (double) ((float) this.rand.nextGaussian() * motionMultiplier + 0.2F);
                        itemEntity.motionZ = (double) ((float) this.rand.nextGaussian() * motionMultiplier);

                        if (stack.hasTagCompound()) {
                            itemEntity.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
                        }
                    }
                }
            }

            world.func_147453_f(x, y, z, block);
        }

        super.breakBlock(world, x, y, z, block, i);
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float f1, float f2) {
        TileEntityAncientChest tile = (TileEntityAncientChest) world.getTileEntity(x, y, z);
        if (tile.chestState == 0) {
            if (player.getHeldItem() != null) {
                if (player.getHeldItem().getItem() != null) {
                    if (player.getHeldItem().getItem() == FAItemRegistry.ancientKey) {
                        tile.setChestState(1);
                        world.markBlockForUpdate(x, y, z);
                        if (!player.capabilities.isCreativeMode) {
                            --player.getHeldItem().stackSize;
                        }

                        if (player.getHeldItem().stackSize <= 0) {
                            player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
                        }

                    }
                }
            }
        } else if (tile.chestState == 1) {
            tile.setChestState(2);
            world.markBlockForUpdate(x, y, z);
            tile.chestLidCounter = 1;
            world.playSoundEffect(x, (double) y + 0.5D, z, "random.chestopen", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

        }
        return true;
    }

    public IInventory invActivated(World world, int x, int y, int z) {
        Object object = (TileEntityAncientChest) world.getTileEntity(x, y, z);

        if (object == null) {
            return null;
        } else if (world.isSideSolid(x, y + 1, z, DOWN)) {
            return null;
        } else {
            return (IInventory) object;
        }
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World world, int p_149915_2_) {
        return new TileEntityAncientChest();
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("fossil:AncientChestSquare");
    }
}