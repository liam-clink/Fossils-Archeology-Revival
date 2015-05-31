package mods.fossil.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Iterator;
import java.util.Random;

import mods.fossil.Fossil;
import mods.fossil.guiBlocks.TileEntityAncientChest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import static net.minecraftforge.common.util.ForgeDirection.*;

public class BlockAncientChest extends BlockContainer
{
	private final Random field_149955_b = new Random();
	public final int field_149956_a;
	private static final String __OBFID = "CL_00000214";

	public BlockAncientChest()
	{
		super(Material.wood);
		this.field_149956_a = 0;
		this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
		this.setBlockName("ancientChest");
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

	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType()
	{
		return 22;
	}

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	public void setBlockBoundsBasedOnState(IBlockAccess access, int x, int y, int z)
	{

		this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);

	}


	/**
	 * Called when the block is placed in the world.
	 */
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase p_149689_5_, ItemStack stack)
	{

		byte b0 = 0;
		int l = MathHelper.floor_double((double)(p_149689_5_.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (l == 0)
		{
			b0 = 2;
		}

		if (l == 1)
		{
			b0 = 5;
		}

		if (l == 2)
		{
			b0 = 3;
		}

		if (l == 3)
		{
			b0 = 4;
		}
		world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		world.markBlockForUpdate(x, y, z);
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
	 * their own) Args: x, y, z, neighbor Block
	 */
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		super.onNeighborBlockChange(world, x, y, z, block);
		TileEntityAncientChest TileEntityAncientChest = (TileEntityAncientChest)world.getTileEntity(x, y, z);

		if (TileEntityAncientChest != null)
		{
			TileEntityAncientChest.updateContainingBlockInfo();
		}
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int i)
	{
		TileEntityAncientChest TileEntityAncientChest = (TileEntityAncientChest)world.getTileEntity(x, y, z);

		if (TileEntityAncientChest != null)
		{
			for (int i1 = 0; i1 < TileEntityAncientChest.getSizeInventory(); ++i1)
			{
				ItemStack itemstack = TileEntityAncientChest.getStackInSlot(i1);

				if (itemstack != null)
				{
					float f = this.field_149955_b.nextFloat() * 0.8F + 0.1F;
					float f1 = this.field_149955_b.nextFloat() * 0.8F + 0.1F;
					EntityItem entityitem;

					for (float f2 = this.field_149955_b.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem))
					{
						int j1 = this.field_149955_b.nextInt(21) + 10;

						if (j1 > itemstack.stackSize)
						{
							j1 = itemstack.stackSize;
						}

						itemstack.stackSize -= j1;
						entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
						float f3 = 0.05F;
						entityitem.motionX = (double)((float)this.field_149955_b.nextGaussian() * f3);
						entityitem.motionY = (double)((float)this.field_149955_b.nextGaussian() * f3 + 0.2F);
						entityitem.motionZ = (double)((float)this.field_149955_b.nextGaussian() * f3);

						if (itemstack.hasTagCompound())
						{
							entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
						}
					}
				}
			}

			world.func_147453_f(x, y, z, block);
		}

		super.breakBlock(world, x, y, z, block, i);
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	 public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float f1, float f2)
	{
		TileEntityAncientChest chest =  (TileEntityAncientChest)world.getTileEntity(x, y, z);
		if(chest.chestState == 0){
			if(player.getHeldItem() != null){
				if(player.getHeldItem().getItem() != null){
					if(player.getHeldItem().getItem() == Fossil.ancientKey){
						chest.setChestState(1);
						world.markBlockForUpdate(x, y, z);
						 if (!player.capabilities.isCreativeMode)
				            {
				                --player.getHeldItem().stackSize;
				            }

				            if (player.getHeldItem().stackSize <= 0)
				            {
				            	player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
				            }

					}  
				}  
			}
		}else if(chest.chestState == 1){
			chest.setChestState(2);
			world.markBlockForUpdate(x, y, z);
			chest.chestLidCounter = 1;
            world.playSoundEffect(x, (double)y + 0.5D, z, "random.chestopen", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

		}
		return true;
	}

	 public IInventory invActivated(World world, int x, int y, int z)
	 {
		 Object object = (TileEntityAncientChest)world.getTileEntity(x, y, z);

		 if (object == null)
		 {
			 return null;
		 }
		 else if (world.isSideSolid(x, y + 1, z, DOWN))
		 {
			 return null;
		 }
		 else
		 {
			 return (IInventory)object;
		 }
	 }

	 /**
	  * Returns a new instance of a block's tile entity class. Called on placing the block.
	  */
	 public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	 {
		 TileEntityAncientChest TileEntityAncientChest = new TileEntityAncientChest();
		 return TileEntityAncientChest;
	 }

	 @SideOnly(Side.CLIENT)
	 public void registerBlockIcons(IIconRegister iicon)
	 {
		 this.blockIcon = iicon.registerIcon("fossil:chestSquare");
	 }
}