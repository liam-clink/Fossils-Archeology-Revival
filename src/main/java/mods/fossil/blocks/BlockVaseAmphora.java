package mods.fossil.blocks;

import java.util.List;

import mods.fossil.Fossil;
import mods.fossil.guiBlocks.TileEntityVase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockVaseAmphora extends BlockContainer
{
    public static final String[] longname =
    {
        "Damaged Amphora",
        "Restored Amphora",
        "Red-Figure Amphora",
        "Black-Figure Amphora",
        "Porcelain Amphora",
    };
    public static final String[] shortname =
    {
        "damaged_amphora",
        "restored_amphora",
        "redFigure_amphora",
        "blackFigure_amphora",
        "porcelain_amphora",
    };

    private IIcon[] icons;
	private int getMeta;

    public BlockVaseAmphora()
    {
        super(Material.clay);
        this.setCreativeTab(Fossil.tabFFigurines);
    }

    
    @SideOnly(Side.CLIENT)
    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubBlocks(Item par1, CreativeTabs creativetabs, List list)
    {
        for (int j = 0; j < shortname.length; ++j)
        {
            list.add(new ItemStack(par1, 1, j));
        }
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return -1;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();

            return false;
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        this.setBlockBounds(0.15F, 0.0F, 0.15F, 0.85F, 1.3F, 0.85F);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 1.5D) & 3;
        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
        TileEntity tileentity = par1World.getTileEntity(par2, par3, par4);
        ((TileEntityVase)tileentity).setVaseTypeMeta(par6ItemStack.getItemDamage());
        ((TileEntityVase)tileentity).setVaseType(1);
        ((TileEntityVase)tileentity).setVaseRotation(1);
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block oldBlock, int oldMeta)
    {
        TileEntity tileentity = world.getTileEntity(x, y, z);
        this.getMeta = getDamageValue(world, x, y, z);
        super.breakBlock(world, x, y, z, oldBlock, oldMeta);
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    @Override
    public TileEntity createNewTileEntity(World par1World, int par2)
    {
        return new TileEntityVase();
    }

    /**
     * Get the block's damage value (for use with pick block).
     */
    public int getDamageValue(World par1World, int par2, int par3, int par4)
    {
        TileEntity tileentity = par1World.getTileEntity(par2, par3, par4);
        return tileentity != null && tileentity instanceof TileEntityVase ? ((TileEntityVase)tileentity).getVaseTypeMeta() : super.getDamageValue(par1World, par2, par3, par4);
    }
    
    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    
    @Override
    public int damageDropped(int meta)
    {
        return this.getMeta;
    }

    @SideOnly(Side.CLIENT)
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public IIcon getIcon(int side, int meta)
    {
        return icons[meta];
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconregister)
    {
        icons = new IIcon[shortname.length];

        for (int i = 0; i < shortname.length; ++i)
        {
        	
           // icons[i] = iconregister.registerIcon(Fossil.modid + ":figurines/" + (this.getUnlocalizedName().substring(5)) + i);
            icons[i] = iconregister.registerIcon(Fossil.modid + ":vases/icons/" + "vase_icon_amphora_" + i);
        }
    }
    
}
