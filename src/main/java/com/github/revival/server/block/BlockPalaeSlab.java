package com.github.revival.server.block;

import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.handler.LocalizationStrings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockPalaeSlab extends BlockSlab {
	public static final String[] woodType = { "palae" };

	public BlockPalaeSlab(boolean doubleSlabbed) {
		super(doubleSlabbed, Material.wood);
		this.setLightOpacity(0);
		this.useNeighborBrightness = true;
		this.setHardness(1.4F);
		this.setResistance(7.5F);
		this.setStepSound(Block.soundTypeWood);
		if (doubleSlabbed) {
			setBlockName(LocalizationStrings.PALAE_DOUBLESLAB_NAME);
		} else {
			setBlockName(LocalizationStrings.PALAE_SINGLESLAB_NAME);
			setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(this);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("fossil:Palae_Planks");
	}

	@Override
	public Item getItemDropped(int var1, Random var2, int var3) {
		return Item.getItemFromBlock(FABlockRegistry.INSTANCE.palaeSingleSlab);
	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving) {
		if (par1World.getBlock(par2, par3 - 1, par4) == FABlockRegistry.INSTANCE.palaeSingleSlab) {
			par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
			par1World.setBlock(par2, par3 - 1, par4, FABlockRegistry.INSTANCE.palaeDoubleSlab);
		}

		if (par1World.getBlock(par2, par3 + 1, par4) == FABlockRegistry.INSTANCE.palaeSingleSlab) {
			par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
			par1World.setBlock(par2, par3 + 1, par4, FABlockRegistry.INSTANCE.palaeDoubleSlab);
		}
	}

	@Override
	protected ItemStack createStackedBlock(int par1) {
		return new ItemStack(FABlockRegistry.INSTANCE.palaeSingleSlab, 2, par1 & 7);
	}

	@Override
	public String func_150002_b(int par1) {
		if ((par1 < 0) || (par1 >= woodType.length)) {
			par1 = 0;
		}

		return super.getUnlocalizedName() + "." + woodType[par1];
	}

	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		if (par1 != Item.getItemFromBlock(FABlockRegistry.INSTANCE.palaeDoubleSlab)) {
			par3List.add(new ItemStack(par1, 1, 0));
		}
	}
}
