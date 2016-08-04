package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockAncientWoodPlate extends Block {
    public BlockAncientWoodPlate() {
        super(Material.wood);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        setHardness(0.6F);
        setUnlocalizedName(LocalizationStrings.ANCIENT_WOOD_PLATE_NAME);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("fossil:Ancient_Wood_Plates");
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, BlockPos pos) {
        int meta = world.getBlockMetadata(pos) & 7;
        float f = 0.125F;
        return AxisAlignedBB.getBoundingBox((double) x + this.minX, (double) y + this.minY, (double) z + this.minZ, (double) x + this.maxX, (double) ((float) y + (float) meta * f), (double) z + this.maxZ);
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

    /**
     * If this block doesn't render as an ordinary block it will return False
     * (examples: signs, buttons, stairs, etc)
     */
    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    /**
     * Checks to see if its valid to put this block at the specified
     * coordinates. Args: world, pos
     */
    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        return super.canPlaceBlockAt(world, pos) && this.canBlockStay(world, pos);
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which
     * neighbor changed (coordinates passed are their own) Args: pos,
     * neighbor blockID
     */
    @Override
    public void onNeighborBlockChange(World world, BlockPos pos, Block block) {
        this.func_111046_k(world, pos);
    }

    private boolean func_111046_k(World world, BlockPos pos) {
        if (!this.canBlockStay(world, pos)) {
            this.dropBlockAsItem(world, pos, world.getBlockMetadata(pos), 0);
            world.setBlockToAir(pos);
            return false;
        } else {
            return true;
        }
    }

    /**
     * Called when the player destroys a block with an item that can harvest it.
     * (i, j, k) are the coordinates of the block and l is the block's
     * subtype/damage.
     */
    @Override
    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, int meta) {
        super.harvestBlock(world, player, pos, meta);
        world.setBlockToAir(pos);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(Random rand) {
        return 1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, pos, side
     */
    public boolean shouldSideBeRendered(IBlockAccess world, BlockPos pos, int side) {
        return side == 1 || super.shouldSideBeRendered(world, pos, side);
    }
}