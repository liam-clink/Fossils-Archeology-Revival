package com.github.revival.server.block;

import com.github.revival.Revival;
import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.handler.FossilAchievementHandler;
import com.github.revival.server.handler.LocalizationStrings;
import com.github.revival.server.item.FAItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class BlockFossil extends BlockStone {
    Random rand = new Random();
    private int randomMeta;

    public BlockFossil() {
        super();
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setStepSound(Block.soundTypeStone);
        this.setBlockName(LocalizationStrings.BLOCK_FOSSIL_NAME);
        this.setCreativeTab(FATabRegistry.tabFBlocks);
        this.setHarvestLevel("pickaxe", 2);
        randomMeta = 0;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Item getItemDropped(int var1, Random var2, int var3) {
        int i = (new Random()).nextInt(1100);

        if (i < 1) {
            this.randomMeta = 0;
            return FAItemRegistry.gem;
        }

        if (i < 6) {
            this.randomMeta = 0;
            return FAItemRegistry.brokenSword;
        }

        if (i < 11) {
            this.randomMeta = 0;
            return FAItemRegistry.brokenhelmet;
        }

        if (i < 13) {
            int dropRandom = rand.nextInt(EnumPrehistoric.values().length);
            if (dropRandom != 4) {
                this.randomMeta = dropRandom;
            }
            return FAItemRegistry.legBone;
        }

        if (i < 15) {
            int dropRandom = rand.nextInt(EnumPrehistoric.values().length);
            if (dropRandom != 4) {
                this.randomMeta = dropRandom;
            }
            return FAItemRegistry.skull;
        }

        if (i < 17) {
            int dropRandom = rand.nextInt(EnumPrehistoric.values().length);
            if (dropRandom != 4) {
                this.randomMeta = dropRandom;
            }
            return FAItemRegistry.claw;
        }

        if (i < 19) {
            int dropRandom = rand.nextInt(EnumPrehistoric.values().length);
            if (dropRandom != 4) {
                this.randomMeta = dropRandom;
            }
            return FAItemRegistry.foot;
        }

        if (i < 21) {
            int dropRandom = rand.nextInt(EnumPrehistoric.values().length);
            if (dropRandom != 4) {
                this.randomMeta = dropRandom;
            }
            return FAItemRegistry.vertebrae;
        }

        if (i < 23) {
            int dropRandom = rand.nextInt(EnumPrehistoric.values().length);
            if (dropRandom != 4) {
                this.randomMeta = dropRandom;
            }
            return FAItemRegistry.armBone;
        }

        if (i < 25) {
            int dropRandom = rand.nextInt(EnumPrehistoric.values().length);
            if (dropRandom != 4) {
                this.randomMeta = dropRandom;
            }
            return FAItemRegistry.dinoRibCage;
        }

        if (i < 50) {
            this.randomMeta = 0;
            return Item.getItemFromBlock(FABlockRegistry.blockSkull);
        }

        if (i < 350) {
            this.randomMeta = 0;
            return FAItemRegistry.biofossil;
        }

        if (i < 550) {
            this.randomMeta = 0;
            return FAItemRegistry.relic;
        }

        if (i < 900) {
            this.randomMeta = 0;
            return Items.bone;
        }
        if (i < 1200) {
            this.randomMeta = 0;
            return FAItemRegistry.brokenSapling;
        }
        this.randomMeta = 0;
        return Item.getItemFromBlock(Blocks.cobblestone);
    }

    public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int i) {
        super.harvestBlock(world, player, x, y, z, i);
        player.triggerAchievement(FossilAchievementHandler.firstFossil);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

        int count = quantityDropped(metadata, fortune, world.rand);
        for (int i = 0; i < count; i++) {
            Item item = getItemDropped(metadata, world.rand, fortune);
            if (item != null) {
                ret.add(new ItemStack(item, 1, randomMeta));
            }
        }
        return ret;
    }


    @Override
    public void registerBlockIcons(IIconRegister par1IIconRegister) {
        this.blockIcon = par1IIconRegister.registerIcon(Revival.MODID + ":" + "Fossil");
    }
}