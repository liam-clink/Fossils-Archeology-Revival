package com.github.revival.server.block;

import com.github.revival.Revival;
import com.github.revival.server.block.entity.TileEntityAnalyzer;
import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.handler.LocalizationStrings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class BlockAnalyzer extends BlockContainer {
    private static boolean keepFurnaceInventory = false;
    private final boolean isActive;
    private Random rand = new Random();
    @SideOnly(Side.CLIENT)
    private IIcon top;
    @SideOnly(Side.CLIENT)
    private IIcon front;

    public BlockAnalyzer(boolean isActive) {
        super(Material.iron);
        setHardness(3.0F);
        setStepSound(Block.soundTypeMetal);
        this.isActive = isActive;
        if (isActive) {
            setLightLevel(0.9375F);
            setBlockName(LocalizationStrings.BLOCK_ANALYZER_ACTIVE_NAME);
        } else {
            setBlockName(LocalizationStrings.BLOCK_ANALYZER_IDLE_NAME);
            setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
        }
        // this.blockIndexInTexture = 45;
    }

    /**
     * Update which block ID the furnace is using depending on whether or not it
     * is burning
     */
    public static void updateFurnaceBlockState(boolean isActive, World world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);
        TileEntity tileentity = world.getTileEntity(x, y, z);
        keepFurnaceInventory = true;

        if (isActive) {
            world.setBlock(x, y, z, FABlockRegistry.INSTANCE.blockanalyzerActive);
        } else {
            world.setBlock(x, y, z, FABlockRegistry.INSTANCE.blockanalyzerIdle);
        }

        keepFurnaceInventory = false;
        world.setBlockMetadataWithNotify(x, y, z, meta, 2);

        if (tileentity != null) {
            tileentity.validate();
            world.setTileEntity(x, y, z, tileentity);
        }
    }

    /*
     * public String getTextureFile() { return
     * "/fossil/textures/Fos_terrian.png"; }
     */
    public int getRenderType() {
        return 2303;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    @Override
    public Item getItemDropped(int var1, Random rand, int var3) {
        return Item.getItemFromBlock(FABlockRegistry.INSTANCE.blockanalyzerIdle);
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        this.setDefaultDirection(world, x, y, z);
    }

    /**
     * set a blocks direction
     */
    private void setDefaultDirection(World world, int x, int y, int z) {
        if (!world.isRemote) {
            Block block = world.getBlock(x, y, z - 1);
            Block block1 = world.getBlock(x, y, z + 1);
            Block block2 = world.getBlock(x - 1, y, z);
            Block block3 = world.getBlock(x + 1, y, z);
            byte b0 = 3;

            if (block.func_149730_j() && !block1.func_149730_j()) {
                b0 = 3;
            }

            if (block1.func_149730_j() && !block.func_149730_j()) {
                b0 = 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j()) {
                b0 = 5;
            }

            if (block3.func_149730_j() && !block2.func_149730_j()) {
                b0 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }

    /**
     * When this method is called, your block should register all the icons it
     * needs with the given IconRegister. This is the only chance you get to
     * register icons.
     */
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("fossil:Analyser_Sides");
        this.top = iconRegister.registerIcon("fossil:Analyser_Top");
        this.front = this.isActive ? iconRegister.registerIcon("fossil:Analyser_Front_Active") : iconRegister.registerIcon("fossil:Analyser_Front_Idle");
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture.
     * Args: side, metadata
     */
    public IIcon getIcon(int side, int metadata) {
        return side == 1 ? this.top : (side == 0 ? this.blockIcon : (side != metadata ? this.blockIcon : this.front));

        // return side == 1 ? this.top : ((side == metadata && side != 0) || (metadata
        // == 3 && side == 0) ? this.front : this.blockIcon);
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        } else {
            player.openGui(Revival.instance, 0, world, x, y, z);
            return true;
        }
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack stack) {
        int rotate = MathHelper.floor_double((double) (placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (rotate == 0) {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (rotate == 1) {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (rotate == 2) {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (rotate == 3) {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }

        if (stack.hasDisplayName()) {
            ((TileEntityAnalyzer) world.getTileEntity(x, y, z)).setGuiDisplayName(stack.getDisplayName());
        }
    }

    /**
     * ejects contained items into the world, and notifies neighbours of an
     * update, as appropriate
     */
    public void breakBlock(World world, int x, int y, int z, Block block, int var6) {
        if (!keepFurnaceInventory) {
            TileEntityAnalyzer tileentity = (TileEntityAnalyzer) world.getTileEntity(x, y, z);

            if (tileentity != null) {
                for (int i = 0; i < tileentity.getSizeInventory(); ++i) {
                    ItemStack itemstack = tileentity.getStackInSlot(i);

                    if (itemstack != null) {
                        float xOffset = this.rand.nextFloat() * 0.8F + 0.1F;
                        float yOffset = this.rand.nextFloat() * 0.8F + 0.1F;
                        float zOffset = this.rand.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0) {
                            int rand = this.rand.nextInt(21) + 10;

                            if (rand > itemstack.stackSize) {
                                rand = itemstack.stackSize;
                            }

                            itemstack.stackSize -= rand;
                            EntityItem entityItem = new EntityItem(world,
                                    (double) ((float) x + xOffset),
                                    (double) ((float) y + yOffset),
                                    (double) ((float) z + zOffset),
                                    new ItemStack(itemstack.getItem(), rand,
                                            itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound()) {
                                entityItem.getEntityItem().setTagCompound(
                                        (NBTTagCompound) itemstack
                                                .getTagCompound().copy());
                            }

                            float offset = 0.05F;
                            entityItem.motionX = (double) ((float) this.rand
                                    .nextGaussian() * offset);
                            entityItem.motionY = (double) ((float) this.rand
                                    .nextGaussian() * offset + 0.2F);
                            entityItem.motionZ = (double) ((float) this.rand
                                    .nextGaussian() * offset);
                            world.spawnEntityInWorld(entityItem);
                        }
                    }
                }
            }
        }

        super.breakBlock(world, x, y, z, block, var6);
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing
     * the block.
     */
    @Override
    public TileEntity createNewTileEntity(World world, int par2) {
        return new TileEntityAnalyzer();
    }

    /**
     * If this returns true, then comparators facing away from this block will
     * use the value from getComparatorInputOverride instead of the actual
     * redstone signal strength.
     */
    public boolean hasComparatorInputOverride() {
        return true;
    }

    /**
     * If hasComparatorInputOverride returns true, the return value from this is
     * used instead of the redstone signal strength when this block inputs to a
     * comparator.
     */
    public int getComparatorInputOverride(World par1World, int par2, int par3,
                                          int par4, int par5) {
        return Container.calcRedstoneFromInventory((IInventory) par1World
                .getTileEntity(par2, par3, par4));
    }

    /**
     * only called by clickMiddleMouseButton , and passed to
     * inventory.setCurrentItem (along with isCreative)
     */
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z) {
        return Item.getItemFromBlock(FABlockRegistry.INSTANCE.blockanalyzerIdle);
    }
}
