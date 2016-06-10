package com.github.revival.server.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockTempskya extends BlockBush {
    public String textureName;
    @SideOnly(Side.CLIENT)
    private IIcon tex1;
    @SideOnly(Side.CLIENT)
    private IIcon tex2;
    @SideOnly(Side.CLIENT)
    private IIcon tex3;

    public BlockTempskya(String texture) {
        super(Material.plants);
        this.setHardness(0);
        this.textureName = texture;
        this.setStepSound(soundTypeGrass);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;
        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
        this.setHardness(0.5F);
    }

    @Override
    public boolean canBlockStay(World world, int x, int y, int z) {
        if (world.getBlock(x, y, z) != this) {
            return super.canBlockStay(world, x, y, z);
        }

        int l = world.getBlockMetadata(x, y, z);

        if (l == 0) {
            return super.canBlockStay(world, x, y, z);
        } else {
            return world.getBlock(x, y - 1, z) == this;
        }
    }

    @Override
    protected void checkAndDropBlock(World w, int x, int y, int z) {
        if (!this.canBlockStay(w, x, y, z)) {
            int l = w.getBlockMetadata(x, y, z);

            if (l == 0) {
                this.dropBlockAsItem(w, x, y, z, l, 0);
            }
            w.setBlock(x, y, z, Blocks.air, 0, 3);
        }
    }

    @Override
    public Item getItemDropped(int i, Random rand, int il) {
        if (i == 0) {
            return Item.getItemFromBlock(this);
        } else {
            return null;
        }

    }

    @Override
    public void harvestBlock(World world, EntityPlayer entity, int x, int y, int z, int i) {
        if (i == 0) {
            super.harvestBlock(world, entity, x, y, z, i);
        }
    }

    public void makeTempskya(World world, int x, int y, int z) {
        world.setBlock(x, y, z, this, 0, 2);
        world.setBlock(x, y + 1, z, this, 1, 2);
        world.setBlock(x, y + 2, z, this, 2, 2);
        world.setBlock(x, y + 3, z, this, 3, 2);
    }

    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return !(world.getBlock(x, y, z) != Blocks.air && world.getBlock(x, y + 1, z) != Blocks.air && world.getBlock(x, y + 2, z) != Blocks.air && world.getBlock(x, y + 3, z) != Blocks.air) && super.canPlaceBlockAt(world, x, y, z);

    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack i) {
        makeTempskya(world, x, y, z);
        super.onBlockPlacedBy(world, x, y, z, entity, i);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int i, int z) {
        switch (z) {
            default:
                return this.blockIcon;
            case 1:
                return this.tex1;
            case 2:
                return this.tex2;
            case 3:
                return this.tex3;
        }

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iicon) {
        super.registerBlockIcons(iicon);
        blockIcon = iicon.registerIcon("fossil:plants/plant_tempskya_1");
        tex1 = iicon.registerIcon("fossil:plants/plant_tempskya_2");
        tex2 = iicon.registerIcon("fossil:plants/plant_tempskya_3");
        tex3 = iicon.registerIcon("fossil:plants/plant_tempskya_4");
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;
        return AxisAlignedBB.getBoundingBox((double) par2 + f, (double) par3 + f2, (double) par4, (double) par2 + f1, (float) par3 + this.maxY, (double) par4 + f3);
    }

    @Override
    public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity) {
        return true;
    }
}
