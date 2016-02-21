package com.github.revival.common.block;

import com.github.revival.Revival;
import com.github.revival.common.entity.mob.EntityTarSlime;
import com.github.revival.common.handler.LocalizationStrings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

import java.util.Random;

public class BlockTar extends BlockFluidClassic {
    public static IIcon tar_still;
    public static IIcon tar_flowing;

    public BlockTar() {
        super(Revival.tar_fluid, Revival.tar_material);
        setBlockName(LocalizationStrings.TAR_NAME);
        setBlockTextureName("fossil:Tar");
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

    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity) {
        if (!(entity instanceof EntityTarSlime)) {
            entity.setInWeb();
            if (entity.getEyeHeight() + entity.posY >= j && entity.getEyeHeight() + entity.posY <= j + 1) {
                entity.attackEntityFrom(DamageSource.drown, 1);
            }
        } else {
            entity.setAir(30);
            entity.motionY += 0.05F;
        }

        if (entity instanceof EntitySheep) {
            EntitySheep sheep = (EntitySheep) entity;
            sheep.setFleeceColor(15);
        }
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return (side == 0 || side == 1) ? tar_still : tar_flowing;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {

        tar_still = register.registerIcon("fossil:Tar");
        tar_flowing = register.registerIcon("fossil:tar_flowing");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        double var6 = (double) ((float) x + random.nextFloat());
        double var8 = (double) y - 0.05D;
        double var10 = (double) ((float) z + random.nextFloat());
        //FossilFX.spawnParticle("tarBubble", var6, var8 + 1, var10, 0.0D, 0.0D, 0.0D, 2);
        if (random.nextInt(200) == 0) {
            world.playSound(x, y, z, "fossil:tar", 0.1F + random.nextFloat() * 0.2F, 0.4F + random.nextFloat() * 0.15F, false);
        }
    }

}
