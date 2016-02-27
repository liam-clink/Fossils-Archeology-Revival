package com.github.revival.server.block;

import com.github.revival.client.renderer.particle.FossilFX;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import java.util.List;
import java.util.Random;

public class FossilTallPlantBlock extends BlockDoublePlant implements IGrowable, IShearable {
    public String textureName;
    @SideOnly(Side.CLIENT)
    private IIcon[] doublePlantBottomIcons;
    @SideOnly(Side.CLIENT)
    private IIcon[] doublePlantTopIcons;

    public FossilTallPlantBlock(String string) {
        super();
        this.setHardness(0.0F);
        this.setStepSound(soundTypeGrass);
        this.textureName = string;
    }

    public static boolean func_149887_c(int i) {
        return (i & 8) != 0;
    }

    public static int func_149890_d(int i) {
        return i & 7;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType() {
        return 40;
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int i, int j, int k, Random random) {
        if (this == FABlockRegistry.mutantPlant) {
            if (world.getBlockMetadata(i, j, k) != 0) {
                int l = ((MathHelper.floor_double((double) (1 * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
                int q = 8 | l;
                world.spawnParticle("blockcrack_" + Block.getIdFromBlock(FABlockRegistry.mutantPlant) + "_" + q, i + ((double) random.nextFloat()), j + ((double) random.nextFloat()), k + ((double) random.nextFloat()), 4.0D * ((double) random.nextFloat()), 0.5D, ((double) random.nextFloat()) * 4.0D);
                world.spawnParticle("blockcrack_" + Block.getIdFromBlock(FABlockRegistry.mutantPlant) + "_" + q, i + ((double) random.nextFloat()), j + ((double) random.nextFloat()), k + ((double) random.nextFloat()), 4.0D * ((double) random.nextFloat()), 0.5D, ((double) random.nextFloat()) * 4.0D);
                world.spawnParticle("blockcrack_" + Block.getIdFromBlock(FABlockRegistry.mutantPlant) + "_" + q, i + ((double) random.nextFloat()), j + ((double) random.nextFloat()), k + ((double) random.nextFloat()), 4.0D * ((double) random.nextFloat() - 0.5D), 0.5D, ((double) random.nextFloat() - 0.5D) * 4.0D);
                world.spawnParticle("blockcrack_" + Block.getIdFromBlock(FABlockRegistry.mutantPlant) + "_" + q, i + ((double) random.nextFloat()), j + ((double) random.nextFloat()), k + ((double) random.nextFloat()), 4.0D * ((double) random.nextFloat() - 0.5D), 0.5D, ((double) random.nextFloat() - 0.5D) * 4.0D);
            }
        }
        if (this == FABlockRegistry.sarracina) {
            if (world.getBlockMetadata(i, j, k) == 0) {
                FossilFX.spawnParticle("flies", i + 0.7, j + 0.8, k + 0.6, 0.0D, 1.5D, 0.0D, 3);
                FossilFX.spawnParticle("flies", i + 0.7, j + 0.5, k, 0.0D, 1.5D, 0.0D, 2);
                FossilFX.spawnParticle("flies", i, j + 0.5, k + 0.5, 0.0D, 1.5D, 0.0D, 4);
                FossilFX.spawnParticle("flies", i + 0.3, j + 0.5, k + 0.9, 0.0D, 1.5D, 0.0D, 4);
            }

        }
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess a, int x, int y, int z) {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public int func_149885_e(IBlockAccess a, int x, int z, int i) {
        int l = a.getBlockMetadata(x, z, i);
        return !func_149887_c(l) ? l & 7 : a.getBlockMetadata(x, z - 1, i) & 7;
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World w, int x, int y, int z) {
        return super.canPlaceBlockAt(w, x, y, z) && w.isAirBlock(x, y + 1, z);
    }

    /**
     * checks if the block can stay, if not drop as item
     */
    protected void checkAndDropBlock(World w, int x, int y, int z) {
        if (!this.canBlockStay(w, x, y, z)) {
            int l = w.getBlockMetadata(x, y, z);

            if (!func_149887_c(l)) {
                this.dropBlockAsItem(w, x, y, z, l, 0);

                if (w.getBlock(x, y + 1, z) == this) {
                    w.setBlock(x, y + 1, z, Blocks.air, 0, 2);
                }
            }

            w.setBlock(x, y, z, Blocks.air, 0, 2);
        }
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World world, int x, int y, int z) {
        if (world.getBlock(x, y, z) != this) {
            return super.canBlockStay(world, x, y, z); //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
        }
        int l = world.getBlockMetadata(x, y, z);
        return func_149887_c(l) ? world.getBlock(x, y - 1, z) == this : world.getBlock(x, y + 1, z) == this && super.canBlockStay(world, x, y, z);
    }

    public Item getItemDropped(int i, Random rand, int il) {
        if (func_149887_c(i)) {
            return null;
        } else {
            int k = func_149890_d(i);
            return k != 3 && k != 2 ? Item.getItemFromBlock(this) : null;
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int i) {
        return func_149887_c(i) ? 0 : i & 7;
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int i, int z) {
        return func_149887_c(z) ? this.doublePlantBottomIcons[0] : this.doublePlantBottomIcons[z & 7];
    }

    @SideOnly(Side.CLIENT)
    public IIcon func_149888_a(boolean a, int z) {
        return a ? this.doublePlantTopIcons[z] : this.doublePlantBottomIcons[z];
    }

    /**
     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
     * when first determining what to render.
     */
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess a, int x, int y, int z) {
        int l = this.func_149885_e(a, x, y, z);
        return l != 2 && l != 3 ? 16777215 : a.getBiomeGenForCoords(x, z).getBiomeGrassColor(x, y, z);
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack i) {
        int l = ((MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
        world.setBlock(x, y + 1, z, this, 8 | l, 2);
    }

    /**
     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
     * block and l is the block's subtype/damage.
     */
    public void harvestBlock(World world, EntityPlayer entity, int x, int y, int z, int i) {
        if (world.isRemote || entity.getCurrentEquippedItem() == null || entity.getCurrentEquippedItem().getItem() != Items.shears || func_149887_c(i) || !this.func_149886_b(world, x, y, z, i, entity)) {
            super.harvestBlock(world, entity, x, y, z, i);
        }
    }

    /**
     * Called when the block is attempted to be harvested
     */
    public void onBlockHarvested(World world, int x, int y, int z, int i, EntityPlayer f) {
        if (func_149887_c(i)) {
            if (world.getBlock(x, y - 1, z) == this) {
                if (!f.capabilities.isCreativeMode) {
                    int i1 = world.getBlockMetadata(x, y - 1, z);
                    int j1 = func_149890_d(i1);

                    if (j1 != 3 && j1 != 2) {
                        world.func_147480_a(x, y - 1, z, true);
                    } else {
                        if (!world.isRemote && f.getCurrentEquippedItem() != null && f.getCurrentEquippedItem().getItem() == Items.shears) {
                            this.func_149886_b(world, x, y, z, i1, f);
                        }

                        world.setBlockToAir(x, y - 1, z);
                    }
                } else {
                    world.setBlockToAir(x, y - 1, z);
                }
            }
        } else if (f.capabilities.isCreativeMode && world.getBlock(x, y + 1, z) == this) {
            world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
        }

        super.onBlockHarvested(world, x, y, z, i, f);
    }

    private boolean func_149886_b(World world, int x, int z, int y, int i, EntityPlayer p_149886_6_) {
        int i1 = func_149890_d(i);

        if (i1 != 3 && i1 != 2) {
            return false;
        } else {
            p_149886_6_.addStat(StatList.mineBlockStatArray[Block.getIdFromBlock(this)], 1);
            byte b0 = 1;

            if (i1 == 3) {
                b0 = 2;
            }

            this.dropBlockAsItem(world, x, z, y, new ItemStack(Blocks.tallgrass, 2, b0));
            return true;
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int var6, float var7, float var8, float var9) {
        ItemStack itemstack = player.getCurrentEquippedItem();
        if (itemstack != null) {
            if (itemstack.getItem() != null) {
                if (itemstack.getItem() == Items.dye) {
                    if (itemstack.getItemDamage() == 15) {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iicon) {
        this.doublePlantBottomIcons = new IIcon[1];
        this.doublePlantTopIcons = new IIcon[1];

        for (int i = 0; i < this.doublePlantBottomIcons.length; ++i) {
            this.doublePlantBottomIcons[i] = iicon.registerIcon("fossil:" + textureName + "_1");
            this.doublePlantTopIcons[i] = iicon.registerIcon("fossil:" + textureName + "_2");
        }

        this.sunflowerIcons = new IIcon[2];
        this.sunflowerIcons[0] = iicon.registerIcon("fossil:plants/plant_sunflower");
        this.sunflowerIcons[1] = iicon.registerIcon("fossil:plants/plant_sunflower");
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item block, CreativeTabs creativetabs, List list) {

        list.add(new ItemStack(block, 1, 1));

    }

    /**
     * Get the block's damage value (for use with pick block).
     */
    public int getDamageValue(World world, int x, int z, int y) {
        int l = world.getBlockMetadata(x, z, y);
        return func_149887_c(l) ? func_149890_d(world.getBlockMetadata(x, z - 1, y)) : func_149890_d(l);
    }

    public boolean func_149851_a(World world, int x, int y, int z, boolean isActive) {
        int l = this.func_149885_e(world, x, y, z);
        return l != 2 && l != 3;
    }

    public boolean func_149852_a(World world, Random rand, int x, int y, int z) {
        return true;
    }

    public void func_149853_b(World world, Random rand, int x, int y, int z) {
        int l = this.func_149885_e(world, x, y, z);
        this.dropBlockAsItem(world, x, y, z, new ItemStack(this, 1, l));
    }

}