package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFossilSkull extends BlockDirectional {
    private boolean isActive;
    @SideOnly(Side.CLIENT)
    private IIcon textureTop;
    @SideOnly(Side.CLIENT)
    private IIcon textureFront;

    public BlockFossilSkull(boolean isActive) {
        super(Material.rock);
        this.setTickRandomly(true);
        this.isActive = isActive;
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        this.setUnlocalizedName(isActive ? "skullLantern" : "skullBlock");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return side == 1 ? this.textureTop : (side == 0 ? this.textureTop : (meta == 2 && side == 2 ? this.textureFront : (meta == 3 && side == 5 ? this.textureFront : (meta == 0 && side == 3 ? this.textureFront : (meta == 1 && side == 4 ? this.textureFront : this.blockIcon)))));
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, EntityLivingBase entity, ItemStack stack) {
        int l = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        world.setBlockMetadataWithNotify(pos, l, 2);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iicon) {
        this.textureFront = iicon.registerIcon("fossil:Skull_Front_" + (this.isActive ? "on" : "off"));
        this.textureTop = iicon.registerIcon("fossil:Skull_Back");
        this.blockIcon = iicon.registerIcon("fossil:Skull_Side");
    }
}