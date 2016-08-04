package fossilsarcheology.server.block;

import fossilsarcheology.server.block.entity.TileEntityAnubiteStatue;
import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.entity.mob.EntityAnubite;
import fossilsarcheology.server.item.block.AnubiteStatueBlockItem;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockAnubiteStatue extends BlockContainer implements IBlockItem {
    private int counter = 0;

    public BlockAnubiteStatue() {
        super(Material.rock);
        this.setBlockBounds(0F, 0.0F, 0F, 1F, 2F, 1);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        this.setTickRandomly(true);
        this.setBlockUnbreakable();
        this.setResistance(60000000.0F);
        setUnlocalizedName("AnubiteStatue");
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        world.newExplosion(null, x + 0.5F, y, z + 0.5, 5F, true, true);
        EntityAnubite newMob = new EntityAnubite(world);
        if (!world.isRemote) {
            newMob.setLocationAndAngles(x + 0.5, y, z + 0.5, 0, 0);
            world.spawnEntityInWorld(newMob);
            world.removeTileEntity(pos);
            world.setBlock(pos, Blocks.air);
        }
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("nether_brick");
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, EntityLivingBase entity, ItemStack stack) {
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

        world.setBlockMetadataWithNotify(pos, b0, 2);

        world.markBlockForUpdate(pos);

        super.onBlockPlacedBy(world, pos, entity, stack);
    }

    @Override
    public int getRenderType() {
        return -94;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityAnubiteStatue();
    }

    @Override
    public Class<? extends ItemBlock> getItemBlockClass() {
        return AnubiteStatueBlockItem.class;
    }
}