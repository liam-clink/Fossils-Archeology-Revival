package mods.fossil.blocks;

import java.util.ArrayList;
import java.util.Random;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import mods.fossil.fossilEnums.EnumDinoType;
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
    private int randomMeta;
    Random rand = new Random();

	public BlockFossil()
    {
        super();
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setStepSound(Block.soundTypeStone);
        this.setBlockName(LocalizationStrings.BLOCK_FOSSIL_NAME);
        this.setCreativeTab(Fossil.tabFBlocks);
        this.setHarvestLevel("pickaxe", 2);
        randomMeta = 0;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Item getItemDropped(int var1, Random var2, int var3)
    {
        int i = (new Random()).nextInt(1000);
        
        if (i < 1)
        {
        	this.randomMeta = 0;
            return Fossil.gem;
        }

        if (i < 6)
        {
        	this.randomMeta = 0;
            return Fossil.brokenSword;
        }

        if (i < 11)
        {
        	this.randomMeta = 0;
            return Fossil.brokenhelmet;
        }

        if (i < 13)
        {
        	int dropRandom = rand.nextInt(EnumDinoType.values().length);
        	if(dropRandom != 4)
        		this.randomMeta = dropRandom;
            return Fossil.legBone;
        }

        if (i < 15)
        {
        	int dropRandom = rand.nextInt(EnumDinoType.values().length);
        	if(dropRandom != 4)
        		this.randomMeta = dropRandom;
            return Fossil.skull;
        }

        if (i < 17)
        {
        	int dropRandom = rand.nextInt(EnumDinoType.values().length);
        	if(dropRandom != 4)
        		this.randomMeta = dropRandom;
            return Fossil.claw;
        }

        if (i < 19)
        {
        	int dropRandom = rand.nextInt(EnumDinoType.values().length);
        	if(dropRandom != 4)
        		this.randomMeta = dropRandom;
            return Fossil.foot;
        }
        
        if (i < 21)
        {
        	int dropRandom = rand.nextInt(EnumDinoType.values().length);
        	if(dropRandom != 4)
        		this.randomMeta = dropRandom;
            return Fossil.vertebrae;
        }
        
        if (i < 23)
        {
        	int dropRandom = rand.nextInt(EnumDinoType.values().length);
        	if(dropRandom != 4)
        		this.randomMeta = dropRandom;
            return Fossil.armBone;
        }
        
        if (i < 25)
        {
        	int dropRandom = rand.nextInt(EnumDinoType.values().length);
        	if(dropRandom != 4)
        		this.randomMeta = dropRandom;
            return Fossil.dinoRibCage;
        }

        if (i < 50)
        {
        	this.randomMeta = 0;
            return Item.getItemFromBlock(Fossil.blockSkull);
        }

        if (i < 350)
        {
        	this.randomMeta = 0;
            return Fossil.biofossil;
        }

        if (i < 550)
        {
        	this.randomMeta = 0;
            return Fossil.relic;
        }

        if (i < 900)
        {
        	this.randomMeta = 0;
            return Items.bone;
        }

        this.randomMeta = 0;
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
            	ret.add(new ItemStack(item, 1, randomMeta));
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