package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

public class BlockAncientWoodSlab extends BlockSlab {
    public static final String[] woodType = { "ancientWood" };

    public BlockAncientWoodSlab(boolean doubleSlabbed) {
        super(doubleSlabbed, Material.wood);
        setLightOpacity(0);
        useNeighborBrightness = true;
        setHardness(1.4F);
        setResistance(7.5F);
        setSoundType(Block.soundTypeWood);
        if (doubleSlabbed) {
            setUnlocalizedName(LocalizationStrings.ANCIENT_WOOD_DOUBLESLAB_NAME);
        } else {
            setUnlocalizedName(LocalizationStrings.ANCIENT_WOOD_SINGLESLAB_NAME);
            setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, BlockPos pos) {
        return Item.getItemFromBlock(this);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("fossil:Ancient_Wood");
    }

    @Override
    public Item getItemDropped(int var1, Random rand, int var3) {
        return Item.getItemFromBlock(FABlockRegistry.INSTANCE.ancientWoodSingleSlab);
    }

    public void onBlockPlacedBy(World world, BlockPos pos, EntityLiving placer) {
        if (world.getBlock(x, y - 1, z) == FABlockRegistry.INSTANCE.ancientWoodSingleSlab) {
            world.setBlock(pos, Blocks.air, 0, 2);
            world.setBlock(x, y - 1, z, FABlockRegistry.INSTANCE.ancientWoodDoubleSlab);
        }

        if (world.getBlock(x, y + 1, z) == FABlockRegistry.INSTANCE.ancientWoodSingleSlab) {
            world.setBlock(pos, Blocks.air, 0, 2);
            world.setBlock(x, y + 1, z, FABlockRegistry.INSTANCE.ancientWoodDoubleSlab);
        }
    }

    @Override
    protected ItemStack createStackedBlock(int meta) {
        return new ItemStack(FABlockRegistry.INSTANCE.ancientWoodSingleSlab, 2, meta & 7);
    }

    @Override
    public String func_150002_b(int meta) {
        if ((meta < 0) || (meta >= woodType.length)) {
            meta = 0;
        }

        return super.getUnlocalizedName() + "." + woodType[meta];
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List subBlocks) {
        if (item != Item.getItemFromBlock(FABlockRegistry.INSTANCE.ancientWoodDoubleSlab)) {
            subBlocks.add(new ItemStack(item, 1, 0));
        }
    }
}
