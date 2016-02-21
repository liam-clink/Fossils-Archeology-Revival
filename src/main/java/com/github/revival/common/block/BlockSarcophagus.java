package com.github.revival.common.block;

import com.github.revival.common.creativetab.FATabRegistry;
import com.github.revival.common.handler.FossilAchievementHandler;
import com.github.revival.common.item.FAItemRegistry;
import com.github.revival.common.tileentity.TileEntitySarcophagus;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockSarcophagus extends BlockContainer {

    public BlockSarcophagus() {
        super(Material.rock);
        this.setBlockBounds(0F, 0.0F, 0F, 1F, 1.9F, 1);
        this.setCreativeTab(FATabRegistry.tabFBlocks);
        this.setTickRandomly(true);
        this.setBlockUnbreakable();
        this.setResistance(60000000.0F);
        setBlockName("sarcophagus");

    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconregister) {
        this.blockIcon = iconregister.registerIcon("fossil:sarcophagus");
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
        return -91;
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float f1, float f2) {
        TileEntitySarcophagus chest = (TileEntitySarcophagus) world.getTileEntity(x, y, z);
        if (chest.chestState == 0) {
            if (player.getHeldItem() != null) {
                if (player.getHeldItem().getItem() != null) {
                    if (player.getHeldItem().getItem() == FAItemRegistry.gem) {
                        chest.setChestState(1);
                        world.markBlockForUpdate(x, y, z);
                        player.addStat(FossilAchievementHandler.anuAttack, 1);

                        if (!player.capabilities.isCreativeMode) {
                            --player.getHeldItem().stackSize;
                        }

                        if (player.getHeldItem().stackSize <= 0) {
                            player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
                        }

                    }
                }
            }
        } else if (chest.chestState == 1) {
            chest.setChestState(2);
            world.markBlockForUpdate(x, y, z);
            chest.chestLidCounter = 1;
            world.playSoundEffect(x, (double) y + 0.5D, z, "random.chestopen", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

        }
        return true;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntitySarcophagus();
    }
}