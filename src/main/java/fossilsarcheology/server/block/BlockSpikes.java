package fossilsarcheology.server.block;

import fossilsarcheology.server.entity.mob.EntityAnu;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockSpikes extends Block {
    public BlockSpikes() {
        super(Material.ROCK);
        this.setHarvestLevel("pickaxe", 3);
        this.setSoundType(SoundType.STONE);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox((double) ((float) p_149668_2_ + f), (double) p_149668_3_, (double) ((float) p_149668_4_ + f), (double) ((float) (p_149668_2_ + 1) - f), (double) (float) (p_149668_3_ + 0.5), (double) ((float) (p_149668_4_ + 1) - f));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_) {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox((double) ((float) p_149633_2_ + f), (double) p_149633_3_, (double) ((float) p_149633_4_ + f), (double) ((float) (p_149633_2_ + 1) - f), p_149633_3_ + 0.5, (double) ((float) (p_149633_4_ + 1) - f));
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube? This determines whether
     * or not to render the shared face of two adjacent blocks and also whether
     * the player can attach torches, redstone wire, etc to this block.
     */
    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
        return world.getBlock(p_149742_2_, p_149742_3_ - 1, p_149742_4_).isOpaqueCube();
    }

    @Override
    public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
        int l = MathHelper.floor_double((double) (p_149689_5_.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, l, 2);
    }

    @Override
    public boolean canBlockStay(World world, BlockPos pos) {
        return canPlaceBlockAt(world, pos);
    }

    @Override
    public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
        if (!this.canBlockStay(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_)) {
            this.dropBlockAsItem(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_1_.getBlockMetadata(p_149695_2_, p_149695_3_, p_149695_4_), 0);
            p_149695_1_.setBlock(p_149695_2_, p_149695_3_, p_149695_4_, getBlockById(0), 0, 2);
        }
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the
     * block). Args: world, pos, entity
     */
    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, Entity entity) {
        if (!(entity instanceof EntityAnu)) {
            if (entity instanceof EntityLivingBase) {
                double var4 = x - entity.posX;
                double var5 = z - entity.posZ;

                entity.attackEntityFrom(DamageSource.generic, 1.0F);
                if ((entity instanceof EntityPlayer) && !((EntityPlayer) entity).capabilities.isCreativeMode) {
                    ((EntityLivingBase) entity).knockBack(entity, 0, var4 * 5.0D, var5 * 5.0D);
                }
                if (!world.isRemote && !(entity instanceof EntityPlayer)) {
                    ((EntityLivingBase) entity).knockBack(entity, 0, var4 * 5.0D, var5 * 5.0D);
                }
            }
        }
    }

    @Override
    public int getRenderType() {
        return 6;
    }
}
