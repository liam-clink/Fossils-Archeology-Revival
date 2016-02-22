package com.github.revival.server.block;

import com.github.revival.server.block.entity.TileEntityDrum;
import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.handler.LocalizationStrings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockDrum extends BlockContainer {
    IIcon Top1;
    IIcon Top2;
    IIcon Top3;
    IIcon Bottom;

    public BlockDrum() {
        super(Material.wood);
        this.setBlockName(LocalizationStrings.DRUM_NAME);
        this.setHardness(0.8F);
        this.setCreativeTab(FATabRegistry.tabFBlocks);
    }

	/*
     * public String getTextureFile() { return
	 * "/fossil/textures/Fos_terrian.png"; }
	 */

    /**
     * From the specified side and block metadata retrieves the blocks texture.
     * Args: side, metadata
     */
    /*
     * public int getBlockTextureFromSideAndMetadata(int var1, int var2) { if
	 * (var1 != 1 && var1 != 0) { return 4; } else { switch (var2) { case 0:
	 * default: return 1;
	 * 
	 * case 1: return 2;
	 * 
	 * case 2: return 3; } } }
	 */
    @SideOnly(Side.CLIENT)
    /**
     * When this method is called, your block should register all the icons it needs with the given IIconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerBlockIcons(IIconRegister par1IIconRegister) {
        this.blockIcon = par1IIconRegister.registerIcon("fossil:Drum_Side");
        this.Top1 = par1IIconRegister.registerIcon("fossil:Drum_Top1");
        this.Top2 = par1IIconRegister.registerIcon("fossil:Drum_Top2");
        this.Top3 = par1IIconRegister.registerIcon("fossil:Drum_Top3");
        this.Bottom = par1IIconRegister.registerIcon("fossil:Drum_Bottom");
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture.
     * Args: side, metadata
     */
    public IIcon getIcon(int par1, int par2) {
        if (par1 != 1 && par1 != 0) {
            return blockIcon;
        } else {
            if (par1 == 0) {
                return Bottom;
            }

            switch (par2) {
                case 0:
                default:
                    return Top1;

                case 1:
                    return Top2;

                case 2:
                    return Top3;
            }
        }
    }

	/*
     * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor blockID
	 */
    /*
	 * public void onNeighborBlockChange(World var1, int var2, int var3, int
	 * var4, int var5) {//plays a sound when powered....what for, this does
	 * nothing.....but keep the code... if (var5 > 0 &&
	 * Block.blocksList[var5].canProvidePower()) { boolean var6 =
	 * var1.isBlockGettingPowered(var2, var3, var4); TileEntityDrum var7 =
	 * (TileEntityDrum)var1.getTileEntity(var2, var3, var4);
	 * 
	 * if (var7.previousRedstoneState != var6) { if (var6) {
	 * var7.triggerNote(var1, var2, var3, var4); }
	 * 
	 * var7.previousRedstoneState = var6; } } }
	 */

    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
                                    EntityPlayer player, int var6, float var7, float var8, float var9) {
        if (!world.isRemote) {
            TileEntityDrum tileEntity = (TileEntityDrum) world.getTileEntity(x,
                    y, z);
            tileEntity.TriggerOrder(player);
            world.setBlockMetadataWithNotify(x, y, z,
                    tileEntity.Order.ordinal(), var6);
        }

        return true;
    }

    /**
     * Called when the block is clicked by a player. Args: x, y, z, entityPlayer
     */
    public void onBlockClicked(World var1, int var2, int var3, int var4,
                               EntityPlayer var5) {
        if (!var1.isRemote) {
            TileEntityDrum var6 = (TileEntityDrum) var1.getTileEntity(var2,
                    var3, var4);

            if (var5.inventory.getCurrentItem() != null) {
                var6.SendOrder(var5.inventory.getCurrentItem().getItem(), var5);
            }
        }
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing
     * the block.
     */
    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityDrum();
    }
}
