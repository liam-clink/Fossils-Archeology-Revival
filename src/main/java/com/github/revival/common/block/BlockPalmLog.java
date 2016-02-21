package com.github.revival.common.block;

import com.github.revival.common.creativetab.FATabRegistry;
import com.github.revival.common.handler.LocalizationStrings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockPalmLog extends Block {
    public static final String[] woodType = new String[]{"palmLog"};
    @SideOnly(Side.CLIENT)
    private IIcon Top;

    public BlockPalmLog() {
        super(Material.wood);
        this.setCreativeTab(FATabRegistry.tabFBlocks);
        this.setStepSound(Block.soundTypeWood);
        this.setHardness(1.4F);
        this.setResistance(1.0F);
        this.setBlockName(LocalizationStrings.PALAE_LOG_NAME);
    }

    public static int limitToValidMetadata(int var0) {
        return var0 & 3;
    }

    @SideOnly(Side.CLIENT)
    /**
     * When this method is called, your block should register all the icons it needs with the given IIconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerBlockIcons(IIconRegister var1) {
        this.blockIcon = var1.registerIcon("fossil:Palae_Log");
        this.Top = var1.registerIcon("fossil:Palae_Log_Top");
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public IIcon getIcon(int var1, int var2) {
        return ((var2 & 12) == 0 && var1 < 2) || ((var2 & 12) == 8 && var1 > 1 && var1 < 4) || ((var2 & 12) == 4 && var1 > 3) ? this.Top : this.blockIcon;
    }

    // this sets how the block is rendered. i recomend keeping it at 31.
    public int getRenderType() {
        return 31;
    }

    // this sets the amount droped when broken.
    public int quantityDropped(Random par1Random) {
        return 1;
    }

    // this tells the game what to drop if the block is brocken with an explosion. an example of this would be creeper explosions
    // making stone drop cobblestone.
    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return Item.getItemFromBlock(FABlockRegistry.palmLog);
    }

    // this essentially helps leaves to decay when they are not conected to wood.
    public void breakBlock(World var1, int var2, int var3, int var4, int var5, int var6) {
        byte var7 = 4;
        int var8 = var7 + 1;

        if (var1.checkChunksExist(var2 - var8, var3 - var8, var4 - var8, var2 + var8, var3 + var8, var4 + var8)) {
            for (int var9 = -var7; var9 <= var7; ++var9) {
                for (int var10 = -var7; var10 <= var7; ++var10) {
                    for (int var11 = -var7; var11 <= var7; ++var11) {
                        Block var12 = var1.getBlock(var2 + var9, var3 + var10, var4 + var11);

                        if (var12 == FABlockRegistry.palmLeaves || var12 == FABlockRegistry.palmLeaves) {
                            int var13 = var1.getBlockMetadata(var2 + var9, var3 + var10, var4 + var11);

                            if ((var13 & 8) == 0) {
                                var1.setBlockMetadataWithNotify(var2 + var9, var3 + var10, var4 + var11, var13 | 8, 2);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
     */
    public int onBlockPlaced(World var1, int var2, int var3, int var4, int var5, float var6, float var7, float var8, int var9) {
        int var10 = var9 & 3;
        byte var11 = 0;

        switch (var5) {
            case 0:
            case 1:
                var11 = 0;
                break;

            case 2:
            case 3:
                var11 = 8;
                break;

            case 4:
            case 5:
                var11 = 4;
        }

        return var10 | var11;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int var1) {
        return var1 & 3;
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int var1) {
        return new ItemStack(this, 1, limitToValidMetadata(var1));
    }

    public boolean canSustainLeaves(World var1, int var2, int var3, int var4) {
        return true;
    }

    public boolean isWood(World var1, int var2, int var3, int var4) {
        return true;
    }
}
