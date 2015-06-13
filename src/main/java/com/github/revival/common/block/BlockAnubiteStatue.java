package com.github.revival.common.block;

import com.github.revival.common.creativetab.FATabRegistry;
import com.github.revival.common.entity.mob.EntityAnubite;
import com.github.revival.common.tileentity.TileEntityAnubiteStatue;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockAnubiteStatue extends BlockContainer
{

    private int counter = 0;

    public BlockAnubiteStatue()
    {
        super(Material.rock);
        this.setBlockBounds(0F, 0.0F, 0F, 1F, 2F, 1);
        this.setCreativeTab(FATabRegistry.tabFBlocks);
        this.setTickRandomly(true);
        this.setBlockUnbreakable();
        this.setResistance(60000000.0F);
        setBlockName("AnubiteStatue");

    }

    public boolean onBlockActivated(World var1, int xCoord, int yCoord, int zCoord,
                                    EntityPlayer var5, int var6, float var7, float var8, float var9)
    {
        var1.newExplosion((Entity) null, xCoord + 0.5F, yCoord, zCoord + 0.5, 5F, true, true);
        EntityAnubite newMob = new EntityAnubite(var1);
        if (!var1.isRemote)
        {
            newMob.setLocationAndAngles(xCoord + 0.5, yCoord, zCoord + 0.5, 0, 0);
            var1.spawnEntityInWorld(newMob);
            var1.removeTileEntity(xCoord, yCoord, zCoord);
            var1.setBlock(xCoord, yCoord, zCoord, Blocks.air);
        }
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconregister)
    {
        this.blockIcon = iconregister.registerIcon("nether_brick");
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
    {
        byte b0 = 0;
        int l = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

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

        super.onBlockPlacedBy(world, x, y, z, entity, stack);
    }

    public int getRenderType()
    {
        return -94;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public TileEntity createNewTileEntity(World world, int i)
    {
        return new TileEntityAnubiteStatue();
    }
}