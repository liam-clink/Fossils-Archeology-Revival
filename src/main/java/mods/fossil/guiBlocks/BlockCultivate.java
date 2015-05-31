package mods.fossil.guiBlocks;

import java.util.Random;

import mods.fossil.Fossil;
import mods.fossil.client.ClientProxy;
import mods.fossil.client.LocalizationStrings;
import mods.fossil.core.FossilPlants;
import mods.fossil.entity.mob.EntityFailuresaurus;
import mods.fossil.handler.FossilAchievementHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCultivate extends BlockContainer {
	// private final String VAT = "Vat.";
	// private final String ERR_OUTBREAK = "Err.OutBreak";
	private Random furnaceRand = new Random();
	private final boolean isActive;
	private static boolean keepFurnaceInventory = false;
	public BlockCultivate(boolean isActive) {
		super(Material.glass);
		setLightLevel(0.9375F);
		setHardness(0.3F);
		setStepSound(Block.soundTypeGlass);
		this.isActive = isActive;
		if (isActive) {
			setBlockName(LocalizationStrings.BLOCK_CULTIVATE_ACTIVE_NAME);
		} else {
			setBlockName(LocalizationStrings.BLOCK_CULTIVATE_IDLE_NAME);
			setCreativeTab(Fossil.tabFBlocks);
		}
	}
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int i) {
		this.ReturnDNA(world, x, y, z);
		super.onBlockDestroyedByPlayer(world, x, y, z, i);
	}

	public Item getItemDropped(int par1, Random rand, int par2) {

		return Item.getItemFromBlock(Fossil.blockcultivateIdle);

	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World var1, int var2, int var3, int var4) {
		super.onBlockAdded(var1, var2, var3, var4);
		this.setDefaultDirection(var1, var2, var3, var4);
	}
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public int getRenderType()
	{
		return -90;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}

	/**
	 * set a blocks direction
	 */
	private void setDefaultDirection(World world, int x, int y, int z) {
		if (!world.isRemote) {
			Block block = world.getBlock(x, y, z - 1);
			Block block1 = world.getBlock(x, y, z + 1);
			Block block2 = world.getBlock(x - 1, y, z);
			Block block3 = world.getBlock(x + 1, y, z);
			byte b0 = 3;

			if (block.func_149730_j() && !block1.func_149730_j()) {
				b0 = 3;
			}

			if (block1.func_149730_j() && !block.func_149730_j()) {
				b0 = 2;
			}

			if (block2.func_149730_j() && !block3.func_149730_j()) {
				b0 = 5;
			}

			if (block3.func_149730_j() && !block2.func_149730_j()) {
				b0 = 4;
			}

			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
	}

	/**
	 * When this method is called, your block should register all the icons it
	 * needs with the given IconRegister. This is the only chance you get to
	 * register icons.
	 */
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("fossil:Culture_Sides_Idle");

	}

	@SideOnly(Side.CLIENT)
	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	public void randomDisplayTick(World var1, int var2, int var3, int var4,
			Random var5) {
		
			var1.spawnParticle("suspended", (double)((float)var2 + var5.nextFloat()), (double)((float)var3 + var5.nextFloat()), (double)((float)var4 + var5.nextFloat()), 0.0D, 0.0D, 0.0D);

		
	}

	/**
	 * Returns the block texture based on the side being looked at. Args: side
	 */
	/*
	 * public int getBlockTextureFromSide(int var1) { return var1 == 1 ? 36 :
	 * (var1 == 0 ? 36 : (var1 == 3 ? 20 : 20)); }
	 */

	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World var1, int var2, int var3, int var4,
			EntityPlayer var5, int var6, float var7, float var8, float var9) {
		if (var1.isRemote) {
			return true;
		} else {
			var5.openGui(Fossil.instance, 1, var1, var2, var3, var4);
			return true;
		}
	}

	public static void updateFurnaceBlockState(boolean isActive, World world,
			int x, int y, int z) {
		int var5 = world.getBlockMetadata(x, y, z);
		TileEntity var6 = world.getTileEntity(x, y, z);
		keepFurnaceInventory = true;

		if (isActive) {

			world.setBlock(x, y, z, Fossil.blockcultivateActive);

		} else {

			world.setBlock(x, y, z, Fossil.blockcultivateIdle);


		}

		keepFurnaceInventory = false;
		world.setBlockMetadataWithNotify(x, y, z, var5, 2);
		var6.validate();
		world.setTileEntity(x, y, z, var6);
	}

	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	@Override
	public TileEntity createNewTileEntity(World world, int par2) {

		return new TileEntityCultivate();
	}

	/**
	 * Called when the block is placed in the world.
	 */
	/*
	 * public void onBlockPlacedBy(World var1, int var2, int var3, int var4,
	 * EntityLiving var5) {This Block doesnt care for directions!
	 * super.onBlockPlacedBy(par1World, par2, par3, par4, par5EntityLiving,
	 * par6ItemStack) int var6 =
	 * MathHelper.floor_double((double)(var5.rotationYaw * 4.0F / 360.0F) +
	 * 0.5D) & 3;
	 * 
	 * if (var6 == 0)var1.setBlockMetadataWithNotify(var2, var3, var4, 2,2);
	 * 
	 * if (var6 == 1)var1.setBlockMetadataWithNotify(var2, var3, var4, 5,2);
	 * 
	 * if (var6 == 2)var1.setBlockMetadataWithNotify(var2, var3, var4, 3,2);
	 * 
	 * if (var6 == 3)var1.setBlockMetadataWithNotify(var2, var3, var4, 4,2); }
	 */
	private void ReturnDNA(World world, int x, int y, int z) {
		if (!keepFurnaceInventory) {
			TileEntityCultivate tileentity = (TileEntityCultivate) world.getTileEntity(x, y, z);
			if(tileentity != null){
				ItemStack itemstack = tileentity.getStackInSlot(0);

				if (itemstack != null) {
					float xOffset = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
					float yOffset = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
					float zOffset = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

					while (itemstack.stackSize > 0) {
						int rand = this.furnaceRand.nextInt(21) + 10;

						if (rand > itemstack.stackSize) {
							rand = itemstack.stackSize;
						}

						itemstack.stackSize -= rand;
						EntityItem entityItem = new EntityItem(world,
								(double) ((float) x + xOffset),
								(double) ((float) y + yOffset),
								(double) ((float) z + zOffset),
								new ItemStack(itemstack.getItem(), rand,
										itemstack.getItemDamage()));

						if (itemstack.hasTagCompound()) {
							entityItem.getEntityItem().setTagCompound(
									(NBTTagCompound) itemstack
									.getTagCompound().copy());
						}

						float offset = 0.05F;
						entityItem.motionX = (double) ((float) this.furnaceRand
								.nextGaussian() * offset);
						entityItem.motionY = (double) ((float) this.furnaceRand
								.nextGaussian() * offset + 0.2F);
						entityItem.motionZ = (double) ((float) this.furnaceRand
								.nextGaussian() * offset);
						world.spawnEntityInWorld(entityItem);
					}
				}
			}
		}
	}

	private void ReturnIron(World world, int x, int y, int z) {

		ItemStack itemstack = new ItemStack(Items.iron_ingot, 3);
		float var6 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
		float var7 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
		float var8 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

		while (itemstack.stackSize > 0) {
			int var9 = this.furnaceRand.nextInt(21) + 10;

			if (var9 > itemstack.stackSize) {
				var9 = itemstack.stackSize;
			}

			itemstack.stackSize -= var9;
			EntityItem world0 = new EntityItem(world,
					(double) ((float) x + var6), (double) ((float) y + var7),
					(double) ((float) z + var8), new ItemStack(
							itemstack.getItem(), var9,
							itemstack.getItemDamage()));
			float world1 = 0.05F;
			world0.motionX = (double) ((float) this.furnaceRand.nextGaussian() * world1);
			world0.motionY = (double) ((float) this.furnaceRand.nextGaussian()
					* world1 + 0.2F);
			world0.motionZ = (double) ((float) this.furnaceRand.nextGaussian() * world1);
			world.spawnEntityInWorld(world0);
		}
	}

	public void onBlockRemovalLost(World world, int x, int y, int z,
			boolean isActive) {
		keepFurnaceInventory = false;
		String var6 = StatCollector.translateToLocal(LocalizationStrings.CULTIVATE_OUTBREAK);

		for (int var7 = 0; var7 < world.playerEntities.size(); ++var7) {
			EntityPlayer P = (EntityPlayer) world.playerEntities.get(var7);

			if (Math.pow(x - P.posX, 2D) + Math.pow(y - P.posY, 2D)
					+ Math.pow(z - P.posZ, 2D) < 10000) // Only for Players
				// closer than 100
				// Metres
			{
				P.addStat(FossilAchievementHandler.failuresaurus, 1);
				Fossil.ShowMessage(var6, P);
			}
		}

		this.ReturnIron(world, x, y, z);
		if(!world.isRemote){
			if (isActive) {
				TileEntityCultivate tileentity = (TileEntityCultivate) world.getTileEntity(x, y, z);
				if(tileentity != null){

					if(tileentity.getDNAType() == 2 ||tileentity.getDNAType() == 3){
						world.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(Blocks.glass));
						world.setBlock(x, y, z, FossilPlants.mutantPlant);
						world.setBlock(x, y+1, z, FossilPlants.mutantPlant, 8, 3);
						world.setBlock(x, y-1, z, Blocks.dirt);

					}else{
						Object creature = null;
						world.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(Blocks.glass));
						world.setBlock(x, y, z, Blocks.water);

						if (world.isRemote) {
							return;
						}

						int rand = world.rand.nextInt(100);

						if (rand <= 5) {
							creature = new EntityCreeper(world);
						}

						if (rand > 5 && rand < 10) {
							creature = new EntityPigZombie(world);
						}

						if (rand >= 10) {
							creature = new EntityFailuresaurus(world);
							((EntityFailuresaurus) creature).setSkin(new Random()
							.nextInt(3));
						}

						((EntityLiving) creature).setLocationAndAngles((double) x,
								(double) y, (double) z, world.rand.nextFloat() * 360.0F,
								0.0F);
						world.spawnEntityInWorld((Entity) creature);
					}
					world.removeTileEntity(x, y, z);
				}
				
			}
		}
	}

	/**
	 * ejects contained items into the world, and notifies neighbours of an
	 * update, as appropriate
	 */
	public void breakBlock(World world, int x, int y, int z, Block block, int var6) {
		if (!keepFurnaceInventory) {
			TileEntityCultivate tileentity = (TileEntityCultivate) world.getTileEntity(x, y, z);

			if (tileentity != null) {
				for (int i = 0; i < tileentity.getSizeInventory(); ++i) {
					ItemStack itemstack = tileentity.getStackInSlot(i);

					if (itemstack != null) {
						float xOffset = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						float yOffset = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						float zOffset = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

						while (itemstack.stackSize > 0) {
							int rand = this.furnaceRand.nextInt(21) + 10;

							if (rand > itemstack.stackSize) {
								rand = itemstack.stackSize;
							}

							itemstack.stackSize -= rand;
							EntityItem entityItem = new EntityItem(world,
									(double) ((float) x + xOffset),
									(double) ((float) y + yOffset),
									(double) ((float) z + zOffset),
									new ItemStack(itemstack.getItem(), rand,
											itemstack.getItemDamage()));

							if (itemstack.hasTagCompound()) {
								entityItem.getEntityItem().setTagCompound(
										(NBTTagCompound) itemstack
										.getTagCompound().copy());
							}

							float offset = 0.05F;
							entityItem.motionX = (double) ((float) this.furnaceRand
									.nextGaussian() * offset);
							entityItem.motionY = (double) ((float) this.furnaceRand
									.nextGaussian() * offset + 0.2F);
							entityItem.motionZ = (double) ((float) this.furnaceRand
									.nextGaussian() * offset);
							world.spawnEntityInWorld(entityItem);
						}
					}
				}
			}
		}

		super.breakBlock(world, x, y, z, block, var6);
	}

	/**
	 * If this returns true, then comparators facing away from this block will
	 * use the value from getComparatorInputOverride instead of the actual
	 * redstone signal strength.
	 */
	public boolean hasComparatorInputOverride() {
		return true;
	}

	/**
	 * If hasComparatorInputOverride returns true, the return value from this is
	 * used instead of the redstone signal strength when this block inputs to a
	 * comparator.
	 */
	public int getComparatorInputOverride(World par1World, int par2, int par3,
			int par4, int par5) {
		return Container.calcRedstoneFromInventory((IInventory) par1World
				.getTileEntity(par2, par3, par4));
	}

	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {

		return Item.getItemFromBlock(Fossil.blockcultivateActive);
	}
}
