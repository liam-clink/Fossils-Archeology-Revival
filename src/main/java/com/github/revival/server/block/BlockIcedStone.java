package com.github.revival.server.block;

import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

import java.util.Random;

public class BlockIcedStone extends Block {
    public BlockIcedStone() {
        super(Material.rock);
        this.setHarvestLevel("pickaxe", 1);
        setHardness(1.5F);
        setResistance(10.0F);
        setStepSound(Block.soundTypeStone);
        setBlockName(LocalizationStrings.BLOCK_ICEDSTONE_NAME);
        setCreativeTab(FATabRegistry.tabFBlocks);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Item getItemDropped(int var1, Random var2, int var3) {
        return Item.getItemFromBlock(Blocks.cobblestone);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
        if (var1.getSavedLightValue(EnumSkyBlock.Block, var2, var3, var4) <= 11 - this.lightOpacity && (!var1.canBlockSeeTheSky(var2, var3 + 1, var4) || !var1.isDaytime())) {
            int var6 = 0;

            while (var6 < 20) {
                int var7 = (new Random()).nextInt(3) - 1;
                int var8 = (new Random()).nextInt(3) - 1;
                int var9 = (new Random()).nextInt(3) - 1;

                if (var1.getBlock(var2 + var7, var3 + var8, var4 + var9) != Blocks.flowing_water && var1.getBlock(var2 + var7, var3 + var8, var4 + var9) != Blocks.water) {
                    if (var1.getBlock(var2 + var7, var3 + var8, var4 + var9) != Blocks.flowing_lava && var1.getBlock(var2 + var7, var3 + var8, var4 + var9) != Blocks.lava && var1.getBlock(var2 + var7, var3 + var8, var4 + var9) != Blocks.fire) {
                        ++var6;
                        continue;
                    }

                    var1.setBlock(var2, var3, var4, Blocks.stone);
                    return;
                }

                var1.setBlock(var2 + var7, var3 + var8, var4 + var9, Blocks.ice);
                return;
            }
        } else {
            var1.setBlock(var2, var3, var4, Blocks.stone);
        }
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
        if (var1.getSavedLightValue(EnumSkyBlock.Block, var2, var3, var4) <= 11 - this.lightOpacity && (!var1.canBlockSeeTheSky(var2, var3 + 1, var4) || !var1.isDaytime())) {
            for (int var6 = -1; var6 <= 1; ++var6) {
                for (int var7 = -1; var7 <= 1; ++var7) {
                    for (int var8 = -1; var8 <= 1; ++var8) {
                        if (var1.getBlock(var2 + var6, var3 + var7, var4 + var8) == Blocks.flowing_water || var1.getBlock(var2 + var6, var3 + var7, var4 + var8) == Blocks.water) {
                            var1.setBlock(var2 + var6, var3 + var7, var4 + var8, Blocks.ice);
                        }

                        if (var1.getBlock(var2 + var6, var3 + var7, var4 + var8) == Blocks.flowing_lava || var1.getBlock(var2 + var6, var3 + var7, var4 + var8) == Blocks.lava || var1.getBlock(var2 + var6, var3 + var7, var4 + var8) == Blocks.fire) {
                            var1.setBlock(var2, var3, var4, Blocks.stone);
                            return;
                        }
                    }
                }
            }
        } else {
            var1.setBlock(var2, var3, var4, Blocks.stone);
        }
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    /*public int getBlockTextureFromSideAndMetadata(int var1, int var2)
    {
        return var2 == 1 ? this.blockIndexInTexture : this.blockIndexInTexture + 1;
    }*/

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("fossil:Iced_Stone");
    }
}
