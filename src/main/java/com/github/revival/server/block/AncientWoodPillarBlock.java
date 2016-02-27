package com.github.revival.server.block;

import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.handler.LocalizationStrings;
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

public class AncientWoodPillarBlock extends Block {
    @SideOnly(Side.CLIENT)
    private IIcon top;

    public AncientWoodPillarBlock() {
        super(Material.wood);
        setCreativeTab(FATabRegistry.tabFBlocks);
        setHardness(2.0F);
        setBlockName(LocalizationStrings.ANCIENT_WOOD_PILLAR_NAME);
    }

    public static int limitToValidMetadata(int meta) {
        return meta & 3;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("fossil:Ancient_Wood_Pillar"); //adding in a texture, 1.5.1 style!
        this.top = iconRegister.registerIcon("fossil:Ancient_Wood_Pillar_Top");
    }

    // this sets the amount droped when broken.
    public int quantityDropped(Random rand) {
        return 1;
    }

    // this tells the game what to drop if the block is brocken with an explosion. an example of this would be creeper explosions
    // making stone drop cobblestone.
    public Item getItemDropped(int var1, Random rand, int var3) {
        return Item.getItemFromBlock(FABlockRegistry.palmLog);
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public IIcon getIcon(int side, int meta) {
        return ((meta & 12) == 0 && side < 2) || ((meta & 12) == 8 && side > 1 && side < 4) || ((meta & 12) == 4 && side > 3) ? this.top : this.blockIcon;
    }

    /**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
     */
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
        int validMeta = metadata & 3;
        byte modifier = 0;

        switch (side) {
            case 0:
            case 1:
                modifier = 0;
                break;
            case 2:
            case 3:
                modifier = 8;
                break;

            case 4:
            case 5:
                modifier = 4;
        }

        return validMeta | modifier;
    }

    public int damageDropped(int meta) {
        return meta & 3;
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int var1) {
        return new ItemStack(this, 1, limitToValidMetadata(var1));
    }

    public boolean canSustainLeaves(World world, int x, int y, int z) {
        return true;
    }

    public boolean isWood(World world, int x, int y, int z) {
        return true;
    }
}
