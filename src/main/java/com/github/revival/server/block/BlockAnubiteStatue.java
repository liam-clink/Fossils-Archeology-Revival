package com.github.revival.server.block;

import com.github.revival.server.api.ISubBlocksBlock;
import com.github.revival.server.block.entity.TileEntityAnubiteStatue;
import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.entity.mob.EntityAnubite;
import com.github.revival.server.item.block.AnubiteStatueBlockItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockAnubiteStatue extends BlockContainer implements ISubBlocksBlock {
    private int counter = 0;

    public BlockAnubiteStatue() {
        super(Material.rock);
        this.setBlockBounds(0F, 0.0F, 0F, 1F, 2F, 1);
        this.setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
        this.setTickRandomly(true);
        this.setBlockUnbreakable();
        this.setResistance(60000000.0F);
        setBlockName("AnubiteStatue");
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        world.newExplosion(null, x + 0.5F, y, z + 0.5, 5F, true, true);
        EntityAnubite newMob = new EntityAnubite(world);
        if (!world.isRemote) {
            newMob.setLocationAndAngles(x + 0.5, y, z + 0.5, 0, 0);
            world.spawnEntityInWorld(newMob);
            world.removeTileEntity(x, y, z);
            world.setBlock(x, y, z, Blocks.air);
        }
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("nether_brick");
    }

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

    public int getRenderType() {
        return -94;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityAnubiteStatue();
    }

    public Class<? extends ItemBlock> getItemBlockClass() {
        return AnubiteStatueBlockItem.class;
    }
}