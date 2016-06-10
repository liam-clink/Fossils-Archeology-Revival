package com.github.revival.server.block;

import com.github.revival.Revival;
import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.handler.LocalizationStrings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockPalmLeaves extends BlockLeaves {
    public static final String[][] TEXTURES = new String[][]{{"leaves_palaeoraphe"}, {"leaves_palaeoraphe_fast"}};
    private IIcon[][] icons = new IIcon[2][];

    private byte[] adjacentTreeBlocks;

    public BlockPalmLeaves() {
        super();
        this.setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
        this.setResistance(1.0F);
        this.setBlockName(LocalizationStrings.PALAE_LEAVES_NAME);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderColor(int meta) {
        int type = this.getType(meta);
        return type == 1 ? ColorizerFoliage.getFoliageColorPine() : (type == 2 ? ColorizerFoliage.getFoliageColorBirch() : ColorizerFoliage.getFoliageColorBasic());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);
        int type = this.getType(meta);
        if (type == 1) {
            return ColorizerFoliage.getFoliageColorPine();
        } else if (type == 2) {
            return ColorizerFoliage.getFoliageColorBirch();
        } else {
            int red = 0;
            int green = 0;
            int blue = 0;
            for (int zOffset = -1; zOffset <= 1; ++zOffset) {
                for (int xOffset = -1; xOffset <= 1; ++xOffset) {
                    int biomeColor = world.getBiomeGenForCoords(x + xOffset, z + zOffset).getBiomeFoliageColor(x, y, z);
                    red += (biomeColor & 0xFF0000) >> 16;
                    green += (biomeColor & 0xFF00) >> 8;
                    blue += biomeColor & 0xFF;
                }
            }
            return (red / 9 & 0xFF) << 16 | (green / 9 & 0xFF) << 8 | blue / 9 & 0xFF;
        }
    }

    private int getType(int meta) {
        return meta & 3;
    }

    @Override
    public Item getItemDropped(int par1, Random rand, int par3) {
        return Item.getItemFromBlock(FABlockRegistry.INSTANCE.palmSap);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        this.setGraphicsLevel(Minecraft.getMinecraft().gameSettings.fancyGraphics);
        int type = this.getType(meta);
        return type == 1 ? this.icons[this.field_150127_b][1] : (type == 3 ? this.icons[this.field_150127_b][3] : (type == 2 ? this.icons[this.field_150127_b][2] : this.icons[this.field_150127_b][0]));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        for (int i = 0; i < TEXTURES.length; ++i) {
            this.icons[i] = new IIcon[TEXTURES[i].length];
            for (int j = 0; j < TEXTURES[i].length; ++j) {
                this.icons[i][j] = iconRegister.registerIcon(Revival.MODID + ":" + TEXTURES[i][j]);
            }
        }
    }

    @Override
    public String[] func_150125_e() {
        return TEXTURES[this.field_150127_b];
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        if (!world.isRemote) {
            int meta = world.getBlockMetadata(x, y, z);
            if ((meta & 8) != 0 && (meta & 4) == 0) {
                byte scanArea = 4;
                int i = scanArea + 1;
                byte size = 32;
                int sizeSquared = size * size;
                int center = size / 2;
                if (this.adjacentTreeBlocks == null) {
                    this.adjacentTreeBlocks = new byte[size * size * size];
                }
                if (world.checkChunksExist(x - i, y - i, z - i, x + i, y + i, z + i)) {
                    for (int offsetX = -scanArea; offsetX <= scanArea; ++offsetX) {
                        for (int offsetY = -scanArea; offsetY <= scanArea; ++offsetY) {
                            for (int offsetZ = -scanArea; offsetZ <= scanArea; ++offsetZ) {
                                Block block = world.getBlock(x + offsetX, y + offsetY, z + offsetZ);
                                if (!block.canSustainLeaves(world, x + offsetX, y + offsetY, z + offsetZ)) {
                                    if (block.isLeaves(world, x + offsetX, y + offsetY, z + offsetZ)) {
                                        this.adjacentTreeBlocks[(offsetX + center) * sizeSquared + (offsetY + center) * size + offsetZ + center] = -2;
                                    } else {
                                        this.adjacentTreeBlocks[(offsetX + center) * sizeSquared + (offsetY + center) * size + offsetZ + center] = -1;
                                    }
                                } else {
                                    this.adjacentTreeBlocks[(offsetX + center) * sizeSquared + (offsetY + center) * size + offsetZ + center] = 0;
                                }
                            }
                        }
                    }
                    for (int blockType = 1; blockType <= 4; ++blockType) {
                        for (int offsetX = -scanArea; offsetX <= scanArea; ++offsetX) {
                            for (int offsetY = -scanArea; offsetY <= scanArea; ++offsetY) {
                                for (int offsetZ = -scanArea; offsetZ <= scanArea; ++offsetZ) {
                                    if (this.adjacentTreeBlocks[(offsetX + center) * sizeSquared + (offsetY + center) * size + offsetZ + center] == blockType - 1) {
                                        for (int adjacentX = -1; adjacentX <= 1; adjacentX++) {
                                            for (int adjacentY = -1; adjacentY <= 1; adjacentY++) {
                                                for (int adjacentZ = -1; adjacentZ <= 1; adjacentZ++) {
                                                    int index = (offsetX + center + adjacentX) * sizeSquared + (offsetY + center + adjacentY) * size + offsetZ + center + adjacentZ;
                                                    if (this.adjacentTreeBlocks[index] == -2) {
                                                        this.adjacentTreeBlocks[index] = (byte) blockType;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (this.adjacentTreeBlocks[center * sizeSquared + center * size + center] >= 0) {
                    world.setBlockMetadataWithNotify(x, y, z, meta & -9, 4);
                } else {
                    this.removeLeaves(world, x, y, z);
                }
            }
        }
    }

    private void removeLeaves(World world, int x, int y, int z) {
        this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
        world.setBlockToAir(x, y, z);
    }
}
