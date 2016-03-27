package com.github.revival.server.block;

import com.github.revival.Revival;
import com.github.revival.server.api.ISubBlocksBlock;
import com.github.revival.server.block.entity.TileEntityFigurine;
import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.handler.LocalizationStrings;
import com.github.revival.server.item.block.FigurineBlockItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class BlockFigurine extends BlockContainer implements ISubBlocksBlock {
    public static final String[] shortname =
            {
                    "figurine_steve_pristine",
                    "figurine_skeleton_pristine",
                    "figurine_zombie_pristine",
                    "figurine_pigzombie_pristine",
                    "figurine_enderman_pristine",
                    "figurine_steve_damaged",
                    "figurine_skeleton_damaged",
                    "figurine_zombie_damaged",
                    "figurine_pigzombie_damaged",
                    "figurine_enderman_damaged",
                    "figurine_steve_broken",
                    "figurine_skeleton_broken",
                    "figurine_zombie_broken",
                    "figurine_pigzombie_broken",
                    "figurine_enderman_broken",
                    "figurine_mysterious",
            };

    private IIcon[] icons;

    public BlockFigurine() {
        super(Material.wood);
        setBlockBounds(0.25f, 0f, 0.25f, 0.75f, 0.5f, 0.75f);
        setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
        setBlockName(LocalizationStrings.FIGURINE_NAME);
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item par1, CreativeTabs creativetabs, List list) {
        for (int j = 0; j < 16; ++j) {
            list.add(new ItemStack(par1, 1, j));
        }
    }

    public int getRenderType() {
        return -1;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean canProvidePower() {
        return true;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
        int l = MathHelper.floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 1.5D) & 3;
        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
        TileEntity tileentity = par1World.getTileEntity(par2, par3, par4);
        ((TileEntityFigurine) tileentity).setFigurineType(par6ItemStack.getItemDamage());
        ((TileEntityFigurine) tileentity).setFigurineRotation(1);
    }

    public TileEntity createNewTileEntity(World world, int par2) {
        return new TileEntityFigurine();
    }

    public int getDamageValue(World par1World, int par2, int par3, int par4) {
        TileEntity tileentity = par1World.getTileEntity(par2, par3, par4);
        return tileentity != null && tileentity instanceof TileEntityFigurine ? ((TileEntityFigurine) tileentity).getFigurineType() : super.getDamageValue(par1World, par2, par3, par4);
    }

    public int damageDropped(int meta) {
        return meta;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return icons[meta];
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconregister) {
        icons = new IIcon[shortname.length];

        for (int i = 0; i < shortname.length; ++i) {
            icons[i] = iconregister.registerIcon(Revival.MODID + ":figurines/icons/" + "figurine_icon_" + i);
        }
    }

    public Class<? extends ItemBlock> getItemBlockClass() {
        return FigurineBlockItem.class;
    }
}
