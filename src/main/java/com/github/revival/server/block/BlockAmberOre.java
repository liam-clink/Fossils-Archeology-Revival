package com.github.revival.server.block;

import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.handler.LocalizationStrings;
import com.github.revival.server.item.FAItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

public class BlockAmberOre extends Block {
    public BlockAmberOre() {
        super(Material.rock);
        this.setCreativeTab(FATabRegistry.tabFBlocks);
        setHardness(3.0F);
        setBlockName(LocalizationStrings.AMBER_ORE_NAME);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Item getItemDropped(int var1, Random rand, int var3) {
        return this == FABlockRegistry.amberOre ? FAItemRegistry.amber : Item.getItemFromBlock(this);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random) {
        return this == FABlockRegistry.amberOre ? 2 + par1Random.nextInt(2) : 1;
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int bonus, Random rand) {
        if (bonus > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, rand, bonus)) {
            int quantityMultiplier = rand.nextInt(bonus + 1) - 1;

            if (quantityMultiplier < 0) {
                quantityMultiplier = 0;
            }

            return this.quantityDropped(rand) * (quantityMultiplier + 1);
        } else {
            return this.quantityDropped(rand);
        }
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World world, int x, int y, int z, int par5, float par6, int par7) {
        super.dropBlockAsItemWithChance(world, x, y, z, par5, par6, par7);

        if (this.getItemDropped(par5, world.rand, par7) != Item.getItemFromBlock(this)) {
            int j1 = 0;

            if (this == FABlockRegistry.amberOre) {
                j1 = 1;
            }

            this.dropXpOnBlockBreak(world, x, y, z, j1);
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int damage) {
        return this == FABlockRegistry.amberOre ? 4 : 0;
    }

    public void registerBlockIcons(IIconRegister iconRegistry) {
        this.blockIcon = iconRegistry.registerIcon("fossil:Amber_Ore");
    }
}
