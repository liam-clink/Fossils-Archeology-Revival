package fossilsarcheology.server.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticlePortal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

public class BlockHomePortal extends Block {
    public BlockHomePortal() {
        super(Material.PORTAL);
        this.setResistance(60000000.0F);
        this.setUnlocalizedName("home_portal");
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entity) {
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
        if ((entity.getRidingEntity() == null) && (entity.getPassengers().size() == 0) && (entity instanceof EntityPlayerMP)) {
            EntityPlayerMP thePlayer = (EntityPlayerMP) entity;
            if (thePlayer.timeUntilPortal > 0) {
                thePlayer.timeUntilPortal = 10;
            } else if (thePlayer.dimension != 0) {
                thePlayer.timeUntilPortal = 10;
                thePlayer.changeDimension(0);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
        super.randomDisplayTick(state, world, pos, rand);
        int blockX = pos.getX();
        int blockY = pos.getY();
        int blockZ = pos.getZ();
        if (rand.nextInt(100) == 0) {
            world.playSound(null, pos, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 1.5F, rand.nextFloat() * 0.4F + 0.8F);
        }
        for (int x = blockX - 2; x <= blockX + 2; ++x) {
            for (int z = blockZ - 2; z <= blockZ + 2; ++z) {
                if (x > blockX - 2 && x < blockX + 2 && z == blockZ - 1) {
                    z = blockZ + 2;
                }
                if (rand.nextInt(16) == 0) {
                    for (int y = blockY; y <= blockY + 1; ++y) {
                        if (!world.isAirBlock(new BlockPos((x - blockX) / 2 + blockX, y, (z - blockZ) / 2 + blockZ))) {
                            break;
                        }
                        Particle particle = new ParticlePortal.Factory().getEntityFX(0, world, blockX + 0.5D, blockY + 0.5D, blockZ + 0.5D, ((x - blockX) + rand.nextFloat()) - 0.5D, ((y - blockY) - rand.nextFloat() - 1.0F), ((z - blockZ) + rand.nextFloat()) - 0.5D);
                        Minecraft.getMinecraft().effectRenderer.addEffect(particle);
                    }
                }
            }
        }
    }
}
