package com.github.revival.common.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

import com.github.revival.Revival;
import com.github.revival.client.renderer.particle.FossilFX;
import com.github.revival.common.entity.mob.EntityTarSlime;
import com.github.revival.common.handler.LocalizationStrings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTar extends BlockFluidClassic
{
	public BlockTar()
	{
		super(Revival.tar_fluid, Material.water);
		setBlockName(LocalizationStrings.TAR_NAME);
	}

	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
		if (world.getBlock(x, y, z).getMaterial().isLiquid()) return false;
		return super.canDisplace(world, x, y, z);
	}

	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z) {
		if (world.getBlock(x, y, z).getMaterial().isLiquid()) return false;
		return super.displaceIfPossible(world, x, y, z);
	}

	public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
	{
		if(entity instanceof EntityTarSlime){
			entity.motionY *= 1.070000000745058064D;
			entity.setAir(30);
		}else{
			entity.motionX = 0.000000000000000004D;
			entity.motionY = 0.070000000745058064D;
			entity.fallDistance = 0.0F;
			entity.motionZ = 0.000000000000000004D;
			entity.attackEntityFrom(DamageSource.drown, 1);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		double var6 = (double) ((float) x + random.nextFloat());
		double var8 = (double) y - 0.05D;
		double var10 = (double) ((float) z + random.nextFloat());
		FossilFX.spawnParticle("tarBubble", var6, var8 + 1, var10, 0.0D, 0.0D, 0.0D, 2);
		if (random.nextInt(200) == 0)
		{
			world.playSound(x, y, z, "fossil:tar", 0.1F + random.nextFloat() * 0.2F, 0.4F + random.nextFloat() * 0.15F, false);
		}
	}
}
