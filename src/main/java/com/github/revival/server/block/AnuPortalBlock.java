package com.github.revival.server.block;

import com.github.revival.server.config.FossilConfig;
import com.github.revival.server.handler.AnuTeleporter;
import com.github.revival.server.handler.LocalizationStrings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class AnuPortalBlock extends Block {
    public AnuPortalBlock() {
        super(Material.portal);
        this.setResistance(60000000.0F);
        setBlockName(LocalizationStrings.BLOCK_ANU_PORTAL_NAME);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB bb, List list, Entity entity) {
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("portal");
    }

    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        if ((entity.ridingEntity == null) && (entity.riddenByEntity == null) && (entity instanceof EntityPlayerMP)) {
            EntityPlayerMP thePlayer = (EntityPlayerMP) entity;
            if (thePlayer.timeUntilPortal > 0) {
                thePlayer.timeUntilPortal = 10;
            } else if (thePlayer.dimension != FossilConfig.dimIdDarknessLair) {
                thePlayer.timeUntilPortal = 10;
                thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, FossilConfig.dimIdDarknessLair, new AnuTeleporter(thePlayer.mcServer.worldServerForDimension(FossilConfig.dimIdDarknessLair)));
            } else {
                thePlayer.timeUntilPortal = 10;
                thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new AnuTeleporter(thePlayer.mcServer.worldServerForDimension(0)));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
        super.randomDisplayTick(world, x, y, z, rand);
        if (rand.nextInt(100) == 0) {
            world.playSound((double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D, "portal.portal", 1.5F, rand.nextFloat() * 0.4F + 0.8F, false);
        }
        for (int l = x - 2; l <= x + 2; ++l) {
            for (int i1 = z - 2; i1 <= z + 2; ++i1) {
                if (l > x - 2 && l < x + 2 && i1 == z - 1) {
                    i1 = z + 2;
                }
                if (rand.nextInt(16) == 0) {
                    for (int j1 = y; j1 <= y + 1; ++j1) {
                        if (!world.isAirBlock((l - x) / 2 + x, j1, (i1 - z) / 2 + z)) {
                            break;
                        }
                        EntityFX particle1 = new EntityPortalFX(world, (double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D, (double) ((float) (l - x) + rand.nextFloat()) - 0.5D, (double) ((float) (j1 - y) - rand.nextFloat() - 1.0F), (double) ((float) (i1 - z) + rand.nextFloat()) - 0.5D);
                        Minecraft.getMinecraft().effectRenderer.addEffect(particle1);
                    }
                }
            }
        }
    }
}
