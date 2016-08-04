package fossilsarcheology.server.block;

import fossilsarcheology.Revival;
import fossilsarcheology.server.creativetab.FATabRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
        this.setSoundType(Block.soundTypeMetal);
        this.setHardness(3.0F);
        this.setUnlocalizedName("bubbleMachine");
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
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
    public void randomDisplayTick(World world, BlockPos pos, Random rand) {

        super.randomDisplayTick(world, pos, rand);
        if (world.isBlockIndirectlyGettingPowered(pos)) {
            world.playSound((double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D, "random.pop", 0.5F, rand.nextFloat() * 0.7F + 0.4F, false);

            switch (world.getBlockMetadata(pos)) {
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
    public void onBlockPlacedBy(World world, BlockPos pos, EntityLivingBase placer, ItemStack stack) {
        int rotate = MathHelper.floor_double((double) (placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (rotate == 0) {
            world.setBlockMetadataWithNotify(pos, 2, 2);
        }

        if (rotate == 1) {
            world.setBlockMetadataWithNotify(pos, 5, 2);
        }

        if (rotate == 2) {
            world.setBlockMetadataWithNotify(pos, 3, 2);
        }

        if (rotate == 3) {
            world.setBlockMetadataWithNotify(pos, 4, 2);
        }
    }
}
