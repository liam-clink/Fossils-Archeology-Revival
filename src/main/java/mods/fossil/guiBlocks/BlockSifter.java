package mods.fossil.guiBlocks;

import java.util.Random;

import mods.fossil.Fossil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSifter extends BlockContainer
{
    //private final String VAT = "Vat.";
    //private final String ERR_OUTBREAK = "Err.OutBreak";
    private Random furnaceRand = new Random();
    private final boolean isActive;
    private static boolean keepFurnaceInventory = false;
    @SideOnly(Side.CLIENT)
    private IIcon Top;
    @SideOnly(Side.CLIENT)
    private IIcon Bottom;

    public BlockSifter(boolean isActive)
    {
        super(Material.wood);
        this.isActive = isActive;
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        this.setDefaultDirection(world, x, y, z);
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
                b0 = 3;
            }

            if (block1.func_149730_j() && !block.func_149730_j())
            {
                b0 = 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j())
            {
                b0 = 5;
            }

            if (block3.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }
    


    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("fossil:SifterSides");
        this.Bottom = par1IconRegister.registerIcon("fossil:SifterBottom");
        this.Top = this.isActive ? par1IconRegister.registerIcon("fossil:SifterTopActive") : par1IconRegister.registerIcon("fossil:SifterTop");
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public IIcon getIcon(int par1, int par2)
    {
    	return par1 == 1 ? this.Top : (par1 != 0 ? this.blockIcon : this.Bottom);   
    }
    

    @SideOnly(Side.CLIENT)
    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World var1, int var2, int var3, int var4, Random var5) {}

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    /*public int getBlockTextureFromSide(int var1)
    {
        return var1 == 1 ? 36 : (var1 == 0 ? 36 : (var1 == 3 ? 20 : 20));
    }*/

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
            var5.openGui(Fossil.instance, 7, var1, var2, var3, var4);
            return true;
        }
    }

    /**
     * Update which block ID the furnace is using depending on whether or not it is burning
     */
    public static void updateFurnaceBlockState(boolean isActive, World world, int x, int y, int z)
    {
        int l = world.getBlockMetadata(x, y, z);
        TileEntity tileentity = world.getTileEntity(x, y, z);
        keepFurnaceInventory = true;

        if (isActive)
        {
            world.setBlock(x, y, z, Fossil.blockSifterActive);
        }
        else
        {
            world.setBlock(x, y, z, Fossil.blockSifterIdle);
        }

        keepFurnaceInventory = false;
        world.setBlockMetadataWithNotify(x, y, z, l, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            world.setTileEntity(x, y, z, tileentity);
        }
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    @Override
    public TileEntity createNewTileEntity(World world, int par2)
    {
        return new TileEntitySifter();
    }

    /**
     * Called when the block is placed in the world.
     */
    /*public void onBlockPlacedBy(World var1, int var2, int var3, int var4, EntityLiving var5)
    {This Block doesnt care for directions!
    	super.onBlockPlacedBy(par1World, par2, par3, par4, par5EntityLiving, par6ItemStack)
        int var6 = MathHelper.floor_double((double)(var5.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (var6 == 0)var1.setBlockMetadataWithNotify(var2, var3, var4, 2,2);

        if (var6 == 1)var1.setBlockMetadataWithNotify(var2, var3, var4, 5,2);

        if (var6 == 2)var1.setBlockMetadataWithNotify(var2, var3, var4, 3,2);

        if (var6 == 3)var1.setBlockMetadataWithNotify(var2, var3, var4, 4,2);
    }*/

    private void ReturnIron(World world, int x, int y, int z)
    {
        ItemStack itemstack = new ItemStack(Items.iron_ingot, 3);
        float var6 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
        float var7 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
        float var8 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

        while (itemstack.stackSize > 0)
        {
            int var9 = this.furnaceRand.nextInt(21) + 10;

            if (var9 > itemstack.stackSize)
            {
                var9 = itemstack.stackSize;
            }

            itemstack.stackSize -= var9;
            EntityItem world0 = new EntityItem(world, (double)((float)x + var6), (double)((float)y + var7), (double)((float)z + var8), new ItemStack(itemstack.getItem(), var9, itemstack.getItemDamage()));
            float world1 = 0.05F;
            world0.motionX = (double)((float)this.furnaceRand.nextGaussian() * world1);
            world0.motionY = (double)((float)this.furnaceRand.nextGaussian() * world1 + 0.2F);
            world0.motionZ = (double)((float)this.furnaceRand.nextGaussian() * world1);
            world.spawnEntityInWorld(world0);
        }
    }

    /**
     * ejects contained items into the world, and notifies neighbours of an update, as appropriate
     */
    public void breakBlock(World world, int x, int y, int z, Block block, int var6)
    {
        if (!keepFurnaceInventory)
        {
            TileEntitySifter tileentity = (TileEntitySifter)world.getTileEntity(x, y, z);

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
                world.func_147453_f(x, y, z, block);
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

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public Item getItem(World world, int x, int y, int z)
    {
    	return Item.getItemFromBlock(Fossil.blockSifterIdle);
    }
}
