package com.github.revival.common.block;

import com.github.revival.common.creativetab.FATabRegistry;
import com.github.revival.common.handler.LocalizationStrings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockAncientStoneSlab extends BlockSlab {
    public static final String[] blockStepTypes = {"ancientStone"};
    private IIcon icon;

    public BlockAncientStoneSlab(boolean doubleSlabbed) {
        super(doubleSlabbed, Material.rock);
        this.setLightOpacity(0);
        this.useNeighborBrightness = true;
        setHardness(1.4F);
        setResistance(7.5F);
        setStepSound(Block.soundTypeWood);
        if (doubleSlabbed) {
            setBlockName(LocalizationStrings.ANCIENT_STONE_DOUBLESLAB_NAME);
        } else {
            setBlockName(LocalizationStrings.ANCIENT_STONE_SINGLESLAB_NAME);
            setCreativeTab(FATabRegistry.tabFBlocks);
        }
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("fossil:Ancient_Stonebricks");
        this.icon = iconRegister.registerIcon("fossil:Ancient_Stonebricks");
    }

    public Item getItemDropped(int var1, Random rand, int var3) {
        return Item.getItemFromBlock(FABlockRegistry.ancientStoneSingleSlab);
    }

    protected ItemStack createStackedBlock(int meta) {
        return new ItemStack(FABlockRegistry.ancientStoneSingleSlab, 2, meta & 7);
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z) {
        return Item.getItemFromBlock(this);
    }

    /**
     * Returns the slab block name with step type.
     */
    // 1.6.4 - getFullSlabName
    @Override
    public String func_150002_b(int meta) {
        if (meta < 0 || meta >= blockStepTypes.length) {
            meta = 0;
        }

        return super.getUnlocalizedName() + "." + blockStepTypes[meta];
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List subBlocks) {
        if (item != Item.getItemFromBlock(FABlockRegistry.ancientStoneDoubleSlab)) {
            subBlocks.add(new ItemStack(item, 1, 0));
        }
    }

}
