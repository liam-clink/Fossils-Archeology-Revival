package mods.fossil.blocks;

import java.util.ArrayList;
import java.util.Random;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockFossil extends BlockStone
{
    public BlockFossil()
    {
        super();
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setStepSound(Block.soundTypeStone);
        this.setBlockName(LocalizationStrings.BLOCK_FOSSIL_NAME);
        this.setCreativeTab(Fossil.tabFBlocks);
        this.setHarvestLevel("pickaxe", 2);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Item getItemDropped(int var1, Random var2, int var3)
    {
        int i = (new Random()).nextInt(1000);

        if (i < 1)
        {
            return Fossil.gem;
        }

        if (i < 6)
        {
            return Fossil.brokenSword;
        }

        if (i < 11)
        {
            return Fossil.brokenhelmet;
        }

        if (i < 13)
        {
            return Fossil.legBone;
        }

        if (i < 15)
        {
            return Fossil.skull;
        }

        if (i < 17)
        {
            return Fossil.claw;
        }

        if (i < 19)
        {
            return Fossil.foot;
        }

        if (i < 50)
        {
            return Item.getItemFromBlock(Fossil.blockSkull);
        }

        if (i < 350)
        {
            return Fossil.biofossil;
        }

        if (i < 550)
        {
            return Fossil.relic;
        }

        if (i < 900)
        {
            return Items.bone;
        }

        return Item.getItemFromBlock(Blocks.cobblestone);
    }
    
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

        int count = quantityDropped(metadata, fortune, world.rand);
        for(int i = 0; i < count; i++)
        {
            Item item = getItemDropped(metadata, world.rand, fortune);
            if (item != null)
            {
            	ret.add(new ItemStack(item, 1, damageDropped(metadata)));
                //ret.add(new ItemStack(Fossil.biofossil, 1, 0));
            }
        }
        return ret;
    }
    
    @Override
    public void registerBlockIcons(IIconRegister par1IIconRegister)
    {
        this.blockIcon = par1IIconRegister.registerIcon(Fossil.modid + ":" + "Fossil");
    }
}