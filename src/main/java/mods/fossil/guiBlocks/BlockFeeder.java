package mods.fossil.guiBlocks;

import java.util.Random;

import mods.fossil.Fossil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFeeder extends BlockContainer
{
    private Random furnaceRand = new Random();
    //private final boolean isActive;
    //private static boolean keepFurnaceInventory = false;
    private IIcon Top1;//None
    private IIcon Top2;//Herb
    private IIcon Top3;//Carn
    private IIcon Top4;//Both
    private IIcon Front1;
    private IIcon Front2;
    private IIcon Front3;
    private IIcon Front4;
    private IIcon Bottom;
    
    private static final int NO_BIT = 0;
    private static final int HERB_BIT = 4;
    private static final int CARN_BIT = 8;
    private static final int BOTH_BITS = 12;
    
    private static final int DIRECTION_BITS = 3;
    
    //MetaDataInfo: &8 == has Herbivore, &16==has Carnivore Food
    public BlockFeeder()//, boolean var2)
    {
        super(Material.rock);
       // this.isActive = var2;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    @Override
    public Item getItemDropped(int var1, Random var2, int var3)
    {
        return Item.getItemFromBlock(Fossil.feederActive);
    }
    
    public int getRenderType()
    {
    	return 2303;
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World var1, int var2, int var3, int var4)
    {
        super.onBlockAdded(var1, var2, var3, var4);
        this.setDefaultDirection(var1, var2, var3, var4);
    }

    /**
     * set a blocks direction
     */
    private void setDefaultDirection(World world, int x, int y, int z)
    {
        if (!world.isRemote)
        {
        	Block block = world.getBlock(x, y, z - 1);
            Block block1 = world.getBlock(x, y, z + 1);
            Block block2 = world.getBlock(x - 1, y, z);
            Block block3 = world.getBlock(x + 1, y, z);
            byte b0 = 3;

            if (block.func_149730_j() && !block1.func_149730_j())
            {
                b0 = 3 - 2;
            }

            if (block1.func_149730_j() && !block.func_149730_j())
            {
                b0 = 2 - 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j())
            {
                b0 = 5 - 2;
            }

            if (block3.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 4 - 2;
            }

            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World var1, int var2, int var3, int var4, Random var5)
    {
    	int var6 = var1.getBlockMetadata(var2, var3, var4);
        if ((var6&BOTH_BITS)!=0 && var5.nextInt(25)==0)//this.isActive)
        {
            float var7 = (float)var2 + 0.5F;
            float var8 = (float)var3 + 0.0F + var5.nextFloat() * 6.0F / 16.0F;
            float var9 = (float)var4 + 0.5F;
            float var10 = 0.52F;
            float var11 = var5.nextFloat() * 0.6F - 0.3F;

            if ((var6&DIRECTION_BITS) == 4-2)
            {
                var1.spawnParticle("smoke", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
                //var1.spawnParticle("flame", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
            }
            else if ((var6&DIRECTION_BITS) == 5-2)
            {
                var1.spawnParticle("smoke", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
                //var1.spawnParticle("flame", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
            }
            else if ((var6&DIRECTION_BITS) == 2-2)
            {
                var1.spawnParticle("smoke", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
                //var1.spawnParticle("flame", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
            }
            else if ((var6&DIRECTION_BITS) == 3-2)
            {
                var1.spawnParticle("smoke", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
                //var1.spawnParticle("flame", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    /*public int getBlockTextureFromSide(int var1)
    {
        return var1 == 1 ? 18 : (var1 == 0 ? 18 : (var1 == 3 ? 34 : 35));
    }*/
    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("fossil:Feeder_Sides");
        this.Bottom = par1IconRegister.registerIcon("fossil:Feeder_Bottom");
        this.Top1 = par1IconRegister.registerIcon("fossil:Feeder_Top1");
        this.Top2 = par1IconRegister.registerIcon("fossil:Feeder_Top2");
        this.Top3 = par1IconRegister.registerIcon("fossil:Feeder_Top3");
        this.Top4 = par1IconRegister.registerIcon("fossil:Feeder_Top4");
        this.Front1 = par1IconRegister.registerIcon("fossil:Feeder_Front1");
        this.Front2 = par1IconRegister.registerIcon("fossil:Feeder_Front2");
        this.Front3 = par1IconRegister.registerIcon("fossil:Feeder_Front3");
        this.Front4 = par1IconRegister.registerIcon("fossil:Feeder_Front4");
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public IIcon getIcon(int side, int metadata)
    {
    	// Side value: 3
        if (side != 1 && ((metadata & DIRECTION_BITS) + 2) != side) //Not Top and not Front=>Side
        {
            //System.out.println("FEEDER SIDE VALUE:"+String.valueOf((metadata&DIRECTION_BITS)+2)+" , " + side);
            return this.blockIcon;
        }
        else
        {
            if (side == 0) //Bottom
            {
                return this.Bottom;
            }

            if (side == 1) //Top
            {
                switch (metadata & BOTH_BITS)
                {
                    case NO_BIT:
                        return this.Top1;//no food

                    case HERB_BIT:
                        return this.Top2;//herbivore

                    case CARN_BIT:
                        return this.Top3;//carnivore

                    case BOTH_BITS:
                        return this.Top4;//both
                }
            }
            else//Front
            {
                switch (metadata & BOTH_BITS)
                {
                    case NO_BIT:
                        return this.Front1;//no food

                    case HERB_BIT:
                        return this.Front2;//herbivore

                    case CARN_BIT:
                        return this.Front3;//carnivore

                    case BOTH_BITS:
                        return this.Front4;//both
                }
            }
        }

        return this.blockIcon;
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5, int var6, float var7, float var8, float var9)
    {
        if (var1.isRemote)
        {
            return true;
        }
        else
        {
        	var5.openGui(Fossil.instance, 2, var1, var2, var3, var4);
            return true;
        }
    }

    public static void updateFurnaceBlockState(boolean herb,boolean carn, World var1, int var2, int var3, int var4)
    {
    	if(var1.getBlock(var2, var3, var4)==Fossil.feederIdle)//won't be used anymore
    		var1.setBlock(var2, var3, var4,Fossil.feederActive,0,2);
        int var5 = var1.getBlockMetadata(var2, var3, var4);
        //System.out.println("FEEDER INPUT:HERB:"+String.valueOf(herb)+" CARN:"+String.valueOf(carn));
        //System.out.println("FEEDER BEFORE:"+String.valueOf(var5));
        if(herb)
        	var5|=HERB_BIT;
        else
        	var5&=~HERB_BIT;
        if(carn)
        	var5|=CARN_BIT;
        else
        	var5&=~CARN_BIT;
        //System.out.println("FEEDER AFTER:"+String.valueOf(var5));
        var1.setBlockMetadataWithNotify(var2, var3, var4, var5, 2);
        /*TileEntity var6 = var1.getTileEntity(var2, var3, var4);
        keepFurnaceInventory = true;

        if (var0)
        {
            var1.setBlock(var2, var3, var4, Fossil.feederActive.blockID);
        }
        else
        {
            var1.setBlock(var2, var3, var4, Fossil.feederIdle.blockID);
        }

        keepFurnaceInventory = false;
        var1.setBlock(var2, var3, var4, var5);
        var6.validate();
        var1.setBlockTileEntity(var2, var3, var4, var6);*/
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World world, int par2)
    {
        return new TileEntityFeeder();
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World var1, int var2, int var3, int var4, EntityLiving var5, ItemStack par6ItemStack)
    {
        int var6 = MathHelper.floor_double((double)(var5.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (var6 == 0)
        {
            var1.setBlockMetadataWithNotify(var2, var3, var4, 2 - 2, 2);
        }

        if (var6 == 1)
        {
            var1.setBlockMetadataWithNotify(var2, var3, var4, 5 - 2, 2);
        }

        if (var6 == 2)
        {
            var1.setBlockMetadataWithNotify(var2, var3, var4, 3 - 2, 2);
        }

        if (var6 == 3)
        {
            var1.setBlockMetadataWithNotify(var2, var3, var4, 4 - 2, 2);
        }

        if (par6ItemStack.hasDisplayName())
        {
            ((TileEntityFeeder)var1.getTileEntity(var2, var3, var4)).setGuiDisplayName(par6ItemStack.getDisplayName());
        }
    }
    
    /**
     * ejects contained items into the world, and notifies neighbours of an update, as appropriate
     */
    public void breakBlock(World world, int x, int y, int z, Block block, int var6)
    {
            TileEntityFeeder tileentity = (TileEntityFeeder)world.getTileEntity(x, y, z);

            if (tileentity != null)
            {
                for (int i = 0; i < tileentity.getSizeInventory(); ++i)
                {
                    ItemStack itemstack = tileentity.getStackInSlot(i);

                    if (itemstack != null)
                    {
                        float xOffset = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                        float yOffset = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                        float zOffset = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0)
                        {
                            int rand = this.furnaceRand.nextInt(21) + 10;

                            if (rand > itemstack.stackSize)
                            {
                            	rand = itemstack.stackSize;
                            }

                            itemstack.stackSize -= rand;
                            EntityItem entityItem = new EntityItem(world, (double)((float)x + xOffset), (double)((float)y + yOffset), (double)((float)z + zOffset), new ItemStack(itemstack.getItem(), rand, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound())
                            {
                            	entityItem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float offset = 0.05F;
                            entityItem.motionX = (double)((float)this.furnaceRand.nextGaussian() * offset);
                            entityItem.motionY = (double)((float)this.furnaceRand.nextGaussian() * offset + 0.2F);
                            entityItem.motionZ = (double)((float)this.furnaceRand.nextGaussian() * offset);
                            world.spawnEntityInWorld(entityItem);
                        }
                    }
                }
            }
        super.breakBlock(world, x, y, z, block, var6);
    }
    
    /**
     * If this returns true, then comparators facing away from this block will use the value from
     * getComparatorInputOverride instead of the actual redstone signal strength.
     */
    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    /**
     * If hasComparatorInputOverride returns true, the return value from this is used instead of the redstone signal
     * strength when this block inputs to a comparator.
     */
    public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5)
    {
        return Container.calcRedstoneFromInventory((IInventory)par1World.getTileEntity(par2, par3, par4));
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z)
    {
        return Item.getItemFromBlock(Fossil.feederActive);
    }
}