package fossilsarcheology.server.item;

import fossilsarcheology.server.block.BlockTempskya;
import fossilsarcheology.server.block.FABlockRegistry;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class FossilSeedsItem extends Item {
    private static final String[] SEED_TYPES = new String[] { "dillhoffia", "sarracina", "cephalotaxus", "licopodiophyta", "paleopanax", "zamites", "bennettitales", "welwitschia", "horsetail", "tempskya", "vaccinium", "osmunda", "crataegus", "florissantia", "ephedra" };
    public boolean isFossil;

    public FossilSeedsItem(boolean isFossil) {
        super();
        this.setHasSubtypes(true);
        this.isFossil = isFossil;
    }

    @Override
    public void getSubItems(Item item, CreativeTabs creativeTabs, List<ItemStack> subItems) {
        for (int i = 0; i < SEED_TYPES.length; ++i) {
            subItems.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!isFossil && player.canPlayerEdit(pos, facing, stack) && player.canPlayerEdit(pos.up(), facing, stack)) {
            if (Blocks.SAPLING.canPlaceBlockAt(world, pos) && world.isAirBlock(pos.up()) && world.getBlockState(pos).getBlock() != FABlockRegistry.INSTANCE.welwitschia) {
                if (this.placePlantBlock(stack, world, pos, new Random())) {
                    world.playSound(null, pos, FABlockRegistry.INSTANCE.dillhoffia.getSoundType().getBreakSound(), SoundCategory.BLOCKS, 1F, world.rand.nextFloat() * 0.1F + 0.8F);
                }
                --stack.stackSize;
                return EnumActionResult.SUCCESS;
            }
        }
        return EnumActionResult.PASS;
    }

    private boolean placePlantBlock(ItemStack stack, World world, BlockPos pos, Random rand) {
        switch (stack.getItemDamage()) {
            case 0:
                world.setBlockState(pos.up(), FABlockRegistry.INSTANCE.dillhoffia.getDefaultState());
                return true;
            case 1:
                world.setBlockState(pos.up(), FABlockRegistry.INSTANCE.sarracina.getDefaultState());
                world.setBlockState(pos.up(2), FABlockRegistry.INSTANCE.sarracina.getDefaultState().withProperty(BlockDoublePlant.HALF, BlockDoublePlant.EnumBlockHalf.UPPER), 3);
                return true;
            case 2:
                world.setBlockState(pos.up(), FABlockRegistry.INSTANCE.cephalotaxus.getDefaultState());
                return true;
            case 3:
                world.setBlockState(pos.up(), FABlockRegistry.INSTANCE.licopodiophyta.getDefaultState());
                return true;
            case 4:
                world.setBlockState(pos.up(), FABlockRegistry.INSTANCE.paleopanax.getDefaultState());
                world.setBlockState(pos.up(2), FABlockRegistry.INSTANCE.paleopanax.getDefaultState().withProperty(BlockDoublePlant.HALF, BlockDoublePlant.EnumBlockHalf.UPPER), 3);
                return true;
            case 5:
                world.setBlockState(pos.up(), FABlockRegistry.INSTANCE.zamites.getDefaultState());
                return true;
            case 6:
                world.setBlockState(pos.up(), FABlockRegistry.INSTANCE.bennettitales_small.getDefaultState());
                return true;
            case 7:
                world.setBlockState(pos.up(), FABlockRegistry.INSTANCE.welwitschia.getDefaultState());
                return true;
            case 8:
                world.setBlockState(pos.up(), FABlockRegistry.INSTANCE.horsetail_small.getDefaultState());
                return true;
            case 9:
                if (FABlockRegistry.INSTANCE.tempskya.canPlaceBlockAt(world, pos.up())) {
                    ((BlockTempskya) FABlockRegistry.INSTANCE.tempskya).makeTempskya(world, pos.up());
                    return true;
                }
            case 10:
                world.setBlockState(pos.up(), FABlockRegistry.INSTANCE.vaccinium.getDefaultState());
                return true;
            case 11:
                world.setBlockState(pos.up(), FABlockRegistry.INSTANCE.osmunda.getDefaultState());
                return true;
            case 12:
                world.setBlockState(pos.up(), FABlockRegistry.INSTANCE.crataegus.getDefaultState());
                world.setBlockState(pos.up(2), FABlockRegistry.INSTANCE.crataegus.getDefaultState().withProperty(BlockDoublePlant.HALF, BlockDoublePlant.EnumBlockHalf.UPPER), 3);
                return true;
            case 13:
                world.setBlockState(pos.up(), FABlockRegistry.INSTANCE.florissantia.getDefaultState());
                return true;
            case 14:
                world.setBlockState(pos.up(), FABlockRegistry.INSTANCE.ephedra.getDefaultState());
                return true;
        }
        return false;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int meta = itemStack.getItemDamage();
        if (meta < 0 || meta >= SEED_TYPES.length) {
            meta = 0;
        }
        return super.getUnlocalizedName() + "." + SEED_TYPES[meta];
    }
}
