package com.github.revival.server.block;

import com.github.revival.server.api.ISubBlocksBlock;
import com.github.revival.server.block.entity.TileEntityAnuTotem;
import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.handler.LocalizationStrings;
import com.github.revival.server.item.block.AnuStatueBlockItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAnuStatue extends BlockContainer implements ISubBlocksBlock {
	private int counter = 0;

	public BlockAnuStatue() {
		super(Material.rock);
		this.setBlockBounds(0F, 0.0F, 0F, 1F, 1.9F, 1);
		this.setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
		this.setTickRandomly(true);
		this.setBlockUnbreakable();
		this.setResistance(60000000.0F);
		setBlockName(LocalizationStrings.BLOCK_ANU_NAME);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon("bedrock");
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block blk) {

	}

	@Override
	public boolean canProvidePower() {
		return true;
	}

	@Override
	public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int i) {
		return 15;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		byte b0 = 0;
		int l = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (l == 0) {
			b0 = 2;
		}

		if (l == 1) {
			b0 = 5;
		}

		if (l == 2) {
			b0 = 3;
		}

		if (l == 3) {
			b0 = 4;
		}

		world.setBlockMetadataWithNotify(x, y, z, b0, 2);

		world.markBlockForUpdate(x, y, z);

		super.onBlockPlacedBy(world, x, y, z, entity, stack);
	}

	@Override
	public int getRenderType() {
		return -93;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityAnuTotem();
	}

	@Override
	public Class<? extends ItemBlock> getItemBlockClass() {
		return AnuStatueBlockItem.class;
	}
}