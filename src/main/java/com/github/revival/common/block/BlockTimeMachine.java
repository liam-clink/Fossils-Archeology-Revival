package com.github.revival.common.block;

import com.github.revival.Revival;
import com.github.revival.common.creativetab.FATabRegistry;
import com.github.revival.common.handler.LocalizationStrings;
import com.github.revival.common.tileentity.TileEntityTimeMachine;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockTimeMachine extends BlockContainer
{
    private IIcon Top;
    private IIcon Bottom;
    private IIcon Side2;
    public BlockTimeMachine()
    {
        super(Material.glass);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
        this.setLightOpacity(0);
        this.setLightLevel(0.9375F);
        this.setHardness(0.3F);
        this.setStepSound(Block.soundTypeGlass);
        this.setBlockName(LocalizationStrings.BLOCK_TIMEMACHINE_NAME);
        this.setCreativeTab(FATabRegistry.tabFBlocks);
    }

	/*
     * public String getTextureFile() { return
	 * "/fossil/textures/block/T_mac_o.png"; }
	 */

    /**
     * Retrieves the block texture to use based on the display side. Args:
     * iBlockAccess, x, y, z, side
     */
    /*
	 * public int getBlockTexture(IBlockAccess var1, int var2, int var3, int
	 * var4, int var5) { return var5 == 1 ? 0 : (var5 == 0 ? 1 : 16 + (var5 <= 3
	 * ? 0 : 1)); }
	 */

    /**
     * Returns a new instance of a block's tile entity class. Called on placing
     * the block.
     */
    public TileEntity createNewTileEntity(World var1)
    {
        return new TileEntityTimeMachine();
    }

    /**
     * A randomly called display update to be able to add particles or other
     * items for display
     */
    public void randomDisplayTick(World var1, int var2, int var3, int var4,
                                  Random var5)
    {
        super.randomDisplayTick(var1, var2, var3, var4, var5);

        for (int var6 = var2 - 2; var6 <= var2 + 2; ++var6)
        {
            for (int var7 = var4 - 2; var7 <= var4 + 2; ++var7)
            {
                if (var6 > var2 - 2 && var6 < var2 + 2 && var7 == var4 - 1)
                {
                    var7 = var4 + 2;
                }

                if (var5.nextInt(16) == 0)
                {
                    for (int var8 = var3; var8 <= var3 + 1; ++var8)
                    {
                        if (var1.getBlock(var6, var8, var7) == Blocks.bookshelf)
                        {
                            if (!var1.isAirBlock((var6 - var2) / 2 + var2,
                                    var8, (var7 - var4) / 2 + var4))
                            {
                                break;
                            }

                            var1.spawnParticle(
                                    "enchantmenttable",
                                    (double) var2 + 0.5D,
                                    (double) var3 + 2.0D,
                                    (double) var4 + 0.5D,
                                    (double) ((float) (var6 - var2) + var5
                                            .nextFloat()) - 0.5D,
                                    (double) ((float) (var8 - var3)
                                            - var5.nextFloat() - 1.0F),
                                    (double) ((float) (var7 - var4) + var5
                                            .nextFloat()) - 0.5D);
                        }
                    }
                }
            }
        }
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube? This determines whether
     * or not to render the shared face of two adjacent blocks and also whether
     * the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture.
     * Args: side, metadata
     */
	/*
	 * public int getBlockTextureFromSideAndMetadata(int var1, int var2) {
	 * return this.getBlockTextureFromSide(var1); }
	 */

    /**
     * Returns the block texture based on the side being looked at. Args: side
     */
	/*
	 * public int getBlockTextureFromSide(int var1) { return var1 == 0 ?
	 * this.blockIndexInTexture : (var1 == 1 ? this.blockIndexInTexture :
	 * this.blockIndexInTexture + 16); }
	 */

    /**
     * When this method is called, your block should register all the icons it
     * needs with the given IIconRegister. This is the only chance you get to
     * register icons.
     */
    public void registerBlockIcons(IIconRegister par1IIconRegister)
    {
        this.blockIcon = par1IIconRegister.registerIcon("fossil:TM_Side1");
        this.Side2 = par1IIconRegister.registerIcon("fossil:TM_Side2");
        this.Top = par1IIconRegister.registerIcon("fossil:TM_Top");
        this.Bottom = par1IIconRegister.registerIcon("fossil:TM_Bottom");
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture.
     * Args: side, metadata
     */
    public IIcon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.Top : par1 == 0 ? this.Bottom
                : par1 < 4 ? this.blockIcon : this.Side2;
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World var1, int var2, int var3, int var4,
                                    EntityPlayer var5, int var6, float var7, float var8, float var9)
    {
        if (var1.isRemote)
        {
            return true;
        }
        else
        {
            TileEntityTimeMachine var10 = (TileEntityTimeMachine) var1
                    .getTileEntity(var2, var3, var4);

            if (var10 != null)
            {
                var5.openGui(Revival.instance, 5, var1, var2, var3, var4);
            }

            return true;
        }
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2)
    {

        return new TileEntityTimeMachine();
    }
}