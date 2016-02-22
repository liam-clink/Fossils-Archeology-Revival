package com.github.revival.server.block;

import com.github.revival.server.handler.LocalizationStrings;
import com.github.revival.server.item.FAItemRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockFern extends BlockBush {
    public static IIcon[] fernPics = new IIcon[13];


    public BlockFern() {
        super(Material.plants);
        this.setTickRandomly(true);
        float var3 = 0.5F;
        this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.25F, 0.5F + var3);
        this.disableStats();
        this.setBlockName(LocalizationStrings.FERN_BLOCK_NAME);
        this.setHardness(0.0F);
        this.setStepSound(Block.soundTypeGrass);
        this.setCreativeTab((CreativeTabs) null);

        //this.setCreativeTab(Revival.tabFBlocks);
        //this.setRequiresSelfNotify();
    }

    public static boolean CheckUnderTree(World var0, int var1, int var2, int var3) {
        for (int var4 = var2; var4 <= 128; ++var4) {
            if (var0.getBlock(var1, var4, var3).getMaterial() == Material.leaves) {
                return true;
            }
        }

        return false;
    }

    /*public BlockFern(int var1, int var2, boolean lev0)
    {
        this(var1, var2);
    }*/
    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IIconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerBlockIcons(IIconRegister par1IIconRegister) {
        this.fernPics[0] = par1IIconRegister.registerIcon("fossil:Fern_1S1");
        this.fernPics[1] = par1IIconRegister.registerIcon("fossil:Fern_1S2");
        this.fernPics[2] = par1IIconRegister.registerIcon("fossil:Fern_1S3");
        this.fernPics[3] = par1IIconRegister.registerIcon("fossil:Fern_1S4");
        this.fernPics[4] = par1IIconRegister.registerIcon("fossil:Fern_1S5");
        this.fernPics[5] = par1IIconRegister.registerIcon("fossil:Fern_1S6");
        this.fernPics[6] = par1IIconRegister.registerIcon("fossil:Fern_1S7");
        this.fernPics[7] = par1IIconRegister.registerIcon("fossil:Fern_1S8");
        this.fernPics[8] = par1IIconRegister.registerIcon("fossil:Fern_2S1");
        this.fernPics[9] = par1IIconRegister.registerIcon("fossil:Fern_2S2");
        this.fernPics[10] = par1IIconRegister.registerIcon("fossil:Fern_2S3");
        this.fernPics[11] = par1IIconRegister.registerIcon("fossil:Fern_2S4");
        this.fernPics[12] = par1IIconRegister.registerIcon("fossil:Fern_2S5");
    }

    protected boolean canPlaceBlockOn(Block block) {
        return block == Blocks.grass;
    }

    public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
        super.updateTick(var1, var2, var3, var4, var5);
        int var6 = var1.getBlockMetadata(var2, var3, var4);

        if (CheckUnderTree(var1, var2, var3, var4) && this.Cangrow(var6)) {
            // only the low ones grow and update the upper ones!
            if (var5.nextInt(10) > 1) {
                ++var6;//let it grow

                if (this.GetLv2(var6)) //gets level 2
                {
                    if (!var1.isAirBlock(var2, var3 + 1, var4))//not possible!
                    {
                        --var6;
                    } else//create new top block
                    {
                        var1.setBlock(var2, var3 + 1, var4, FABlockRegistry.ferns);//fernUpper
                        var1.setBlockMetadataWithNotify(var2, var3 + 1, var4, this.CheckSubType(var6) == 0 ? var6 + 2 : var6 + 1, 2);
                    }
                } else if (this.HasLv2(var6)) {
                    if (var1.getBlock(var2, var3 + 1, var4) == FABlockRegistry.ferns)//fernUpper
                    {
                        var1.setBlockMetadataWithNotify(var2, var3 + 1, var4, this.CheckSubType(var6) == 0 ? var6 + 2 : var6 + 1, 2);    //update top block meta data
                    } else {
                        var6 = this.CheckSubType(var6) == 0 ? 3 : 10;    //reset to last block one stage high
                    }
                }

				/*if (var6 == 1 && (new Random()).nextInt(10) < 5)
                {
                    var6 += 7;
                }*/
                //System.out.println(String.valueOf(var6));
                var1.setBlockMetadataWithNotify(var2, var3, var4, var6, 2);
            }

			/*else if (!this.lv2 && var5.nextInt(100) < 5)
            {
                this.breakBlock(var1, var2, var3, var4, this.blockID, var6);
            }*/
        }

        //var1.getBlock(var2, var3, var4);

        if (var6 % 7 >= 3) {
            for (int var8 = -1; var8 <= 1; ++var8) {
                for (int var9 = -1; var9 <= 1; ++var9) {
                    for (int var10 = -1; var10 <= 1; ++var10) {
                        if ((var8 != 0 || var10 != 0 || var9 != 0) && var1.getBlock(var2 + var8, var9 + var3 - 1, var4 + var10) == Blocks.grass && (var1.isAirBlock(var2 + var8, var9 + var3, var4 + var10) || var1.getBlock(var2 + var8, var9 + var3, var4 + var10) == Blocks.tallgrass) && CheckUnderTree(var1, var2 + var8, var9 + var3, var4 + var10) && (new Random()).nextInt(10) <= 9) {
                            var1.setBlock(var2 + var8, var9 + var3, var4 + var10, FABlockRegistry.ferns);
                            var1.setBlockMetadataWithNotify(var2 + var8, var9 + var3, var4 + var10, 0 + 8 * this.CheckSubType(var6), 2);
                        }
                    }
                }
            }
        }
    }

    public void fertilize(World var1, int var2, int var3, int var4)//?????
    {
        var1.setBlockMetadataWithNotify(var2, var3, var4, 5 + 7 * (new Random()).nextInt(1), 2);
    }

    private float getGrowthRate(World var1, int var2, int var3, int var4) {
        float var5 = 1.0F;
        Block var6 = var1.getBlock(var2, var3, var4 - 1);
        Block var7 = var1.getBlock(var2, var3, var4 + 1);
        Block var8 = var1.getBlock(var2 - 1, var3, var4);
        Block var9 = var1.getBlock(var2 + 1, var3, var4);
        Block var10 = var1.getBlock(var2 - 1, var3, var4 - 1);
        Block var11 = var1.getBlock(var2 + 1, var3, var4 - 1);
        Block var12 = var1.getBlock(var2 + 1, var3, var4 + 1);
        Block var13 = var1.getBlock(var2 - 1, var3, var4 + 1);
        boolean var14 = var8 == FABlockRegistry.ferns || var9 == FABlockRegistry.ferns;
        boolean var15 = var6 == FABlockRegistry.ferns || var7 == FABlockRegistry.ferns;
        boolean var16 = var10 == FABlockRegistry.ferns || var11 == FABlockRegistry.ferns || var12 == FABlockRegistry.ferns || var13 == FABlockRegistry.ferns;

        for (int var17 = var2 - 1; var17 <= var2 + 1; ++var17) {
            for (int var18 = var4 - 1; var18 <= var4 + 1; ++var18) {
                Block var19 = var1.getBlock(var17, var3 - 1, var18);
                float var20 = 0.0F;

                if (var19 == Blocks.grass) {
                    var20 = 1.0F;

                    if (var1.getBlockMetadata(var17, var3 - 1, var18) > 0) {
                        var20 = 3.0F;
                    }
                }

                if (var17 != var2 || var18 != var4) {
                    var20 /= 4.0F;
                }

                var5 += var20;
            }
        }

        if (var16 || var14 && var15) {
            var5 /= 2.0F;
        }

        return var5;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public IIcon getIcon(int var1, int var2) {
        if (var2 < 0 || var2 >= fernPics.length) {
            var2 = 0;
        }

        return fernPics[var2];
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World var1, int var2, int var3, int var4, int var5, float var6, int var7) {
        super.dropBlockAsItemWithChance(var1, var2, var3, var4, var5, var6, var7);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Item getItemDropped(int var1, Random var2, int var3) {
        if (var2.nextInt(4) == 0) {
            return FAItemRegistry.fernSeed;
        }
        return null;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random var1) {
        return 1;
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World var1, int var2, int var3, int var4) {
        boolean var5 = true;

        if (this.CheckLevel(var1.getBlockMetadata(var2, var3, var4))) {
            return var1.getBlock(var2, var3 - 1, var4) == FABlockRegistry.ferns;    //fernblock below
        } else {
            var5 = var1.getBlock(var2, var3 - 1, var4) == Blocks.grass && CheckUnderTree(var1, var2, var3, var4);//on grass, under tree

            if (this.HasLv2(var1.getBlockMetadata(var2, var3, var4))) {
                var5 &= var1.getBlock(var2, var3 + 1, var4) == FABlockRegistry.ferns;    //and has the upper block it needs//fernUpper
            }

            return var5;
        }
    }

    public int CheckSubType(int var1) {
        return var1 > 7 ? 1 : 0;
    }

    public boolean CheckLevel(int var1)//false==down, true= up
    {
        return (var1 >= 6 && var1 <= 7) || var1 == 12;
    }

    public boolean Cangrow(int var1)// only the low ones grow and update the upper ones!
    {
        return (var1 >= 0 && var1 < 5) || (var1 >= 8 && var1 < 11);
    }

    public boolean HasLv2(int var1) {
        return (var1 >= 4 && var1 <= 5) || (var1 >= 11 && var1 <= 11);
    }

    public boolean GetLv2(int var1)//the stages where it gets a second level
    {
        return (var1 == 4) || (var1 == 11);
    }

    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        return new ItemStack(FAItemRegistry.fernSeed);
    }

    @Override
    public int getBlockColor() {
        double var1 = 0.5D;
        double var3 = 1.0D;

        return ColorizerGrass.getGrassColor(var1, var3);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderColor(int par1) {
        return ColorizerGrass.getGrassColor(0.5D, 1.0D);
    }

    @Override
    public int getRenderType() {
        return 1;
    }

    @Override
    public int colorMultiplier(IBlockAccess world, int x, int y, int z) {
        return world.getBiomeGenForCoords(x, z).getBiomeFoliageColor(x, y, z);
    }
}
