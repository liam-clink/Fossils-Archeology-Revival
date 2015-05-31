package mods.fossil.blocks;

import java.util.List;
import java.util.Random;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import mods.fossil.handler.AnuTeleporter;
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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHomePortal extends Block {

	public BlockHomePortal() {
		super(Material.portal);
		this.setResistance(60000000.0F);
		setBlockName("home_portal");

	}
	public boolean isOpaqueCube()
	{
		return false;
	}
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB bb, List list, Entity entity) {}
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass()
	{
		return 1;
	}
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconregister)
	{
		this.blockIcon = iconregister.registerIcon("fossil:overworldPortal");
	}
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		if ((par5Entity.ridingEntity == null) && (par5Entity.riddenByEntity == null) && (par5Entity instanceof EntityPlayerMP))
		{
			EntityPlayerMP thePlayer = (EntityPlayerMP) par5Entity;

			if (thePlayer.timeUntilPortal > 0)
			{
				thePlayer.timeUntilPortal = 10;
			}
			else if (thePlayer.dimension != 0)
			{
				thePlayer.timeUntilPortal = 10;
				thePlayer.travelToDimension(0);
			}
		}
	}
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand)
	{
		super.randomDisplayTick(world, x, y, z, rand);

		if (rand.nextInt(100) == 0)
		{
			world.playSound((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "portal.portal", 1.5F, rand.nextFloat() * 0.4F + 0.8F, false);
		}
		for (int l = x - 2; l <= x + 2; ++l)
		{
			for (int i1 = z - 2; i1 <= z + 2; ++i1)
			{
				if (l > x - 2 && l < x + 2 && i1 == z - 1)
				{
					i1 = z + 2;
				}

				if (rand.nextInt(16) == 0)
				{
					for (int j1 = y; j1 <= y + 1; ++j1)
					{

						if (!world.isAirBlock((l - x) / 2 + x, j1, (i1 - z) / 2 + z))
						{
							break;
						}

						EntityFX particle1 = new EntityPortalFX(world, (double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, (double)((float)(l - x) + rand.nextFloat()) - 0.5D, (double)((float)(j1 - y) - rand.nextFloat() - 1.0F), (double)((float)(i1 - z) + rand.nextFloat()) - 0.5D);
						Minecraft.getMinecraft().effectRenderer.addEffect(particle1); 

					}
				}

			}
		}
	}
}
