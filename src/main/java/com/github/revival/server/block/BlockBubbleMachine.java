package com.github.revival.server.block;

import com.github.revival.Revival;
import com.github.revival.server.creativetab.FATabRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class BlockBubbleMachine extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon top;
    @SideOnly(Side.CLIENT)
    private IIcon front;
    @SideOnly(Side.CLIENT)
    private IIcon back;
    @SideOnly(Side.CLIENT)
    private IIcon bottom;

    protected BlockBubbleMachine() {
        super(Material.iron);
        this.setStepSound(Block.soundTypeMetal);
        this.setHardness(3.0F);
        this.setBlockName("bubbleMachine");
        this.setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
    }

    @Override
    public Item getItemDropped(int var1, Random rand, int var3) {
        return Item.getItemFromBlock(FABlockRegistry.INSTANCE.bubbleMachine);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("fossil:bubble_blower_side");
        this.top = iconRegister.registerIcon("fossil:bubble_blower_top");
        this.front = iconRegister.registerIcon("fossil:bubble_blower_front");
        this.back = iconRegister.registerIcon("fossil:bubble_blower_back");
        this.bottom = iconRegister.registerIcon("fossil:bubble_blower_bottom");
    }

    @Override
    public IIcon getIcon(int side, int metadata) {
        if (metadata == 0 && side == 3) {
            return this.front;
        }
        return side == 1 ? this.top : (side == 0 ? this.bottom : (side != metadata ? this.back : this.front));
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand) {

        super.randomDisplayTick(world, x, y, z, rand);
        if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
            world.playSound((double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D, "random.pop", 0.5F, rand.nextFloat() * 0.7F + 0.4F, false);

            switch (world.getBlockMetadata(x, y, z)) {
                case 2:
                    Revival.PROXY.spawnBubbleParticles(world, x + rand.nextFloat(), y + rand.nextFloat(), z, 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x + rand.nextFloat(), y + rand.nextFloat(), z, 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x + rand.nextFloat(), y + rand.nextFloat(), z, 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x + rand.nextFloat(), y + rand.nextFloat(), z, 0, 0.1, 0);
                    break;
                case 3:
                    Revival.PROXY.spawnBubbleParticles(world, x + rand.nextFloat(), y + rand.nextFloat(), z + 1.1F, 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x + rand.nextFloat(), y + rand.nextFloat(), z + 1.1F, 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x + rand.nextFloat(), y + rand.nextFloat(), z + 1.1F, 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x + rand.nextFloat(), y + rand.nextFloat(), z + 1.1F, 0, 0.1, 0);
                    break;
                case 4:
                    Revival.PROXY.spawnBubbleParticles(world, x, y + rand.nextFloat(), z + rand.nextFloat(), 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x, y + rand.nextFloat(), z + rand.nextFloat(), 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x, y + rand.nextFloat(), z + rand.nextFloat(), 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x, y + rand.nextFloat(), z + rand.nextFloat(), 0, 0.1, 0);
                    break;
                case 5:
                    Revival.PROXY.spawnBubbleParticles(world, x + 1.1F, y + rand.nextFloat(), z + rand.nextFloat(), 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x + 1.1F, y + rand.nextFloat(), z + rand.nextFloat(), 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x + 1.1F, y + rand.nextFloat(), z + rand.nextFloat(), 0, 0.1, 0);
                    Revival.PROXY.spawnBubbleParticles(world, x + 1.1F, y + rand.nextFloat(), z + rand.nextFloat(), 0, 0.1, 0);
                    break;
            }
        }
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack stack) {
        int rotate = MathHelper.floor_double((double) (placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (rotate == 0) {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (rotate == 1) {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (rotate == 2) {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (rotate == 3) {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
    }
}
