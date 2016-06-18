package fossilsarcheology.server.item;

import java.util.List;
import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import fossilsarcheology.server.block.BlockTempskya;
import fossilsarcheology.server.block.FABlockRegistry;

public class FossilSeedsItem extends Item

{
    private static final String[] fossilSeeds = new String[]{"dillhoffia", "sarracina", "cephalotaxus", "licopodiophyta", "paleopanax", "zamites", "bennettitales", "welwitschia", "horsetail", "tempskya", "vaccinium", "osmunda", "crataegus", "florissantia", "ephedra"};
    public boolean isFossil;
    private IIcon[] textures;

    public FossilSeedsItem(boolean isFossil) {
        super();
        this.setHasSubtypes(true);
        this.isFossil = isFossil;
    }

    @Override
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list) {
        for (int i = 0; i < fossilSeeds.length; ++i) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        textures = new IIcon[fossilSeeds.length];

        for (int i = 0; i < fossilSeeds.length; ++i) {
            if (isFossil) {
                textures[i] = iconRegister.registerIcon("fossil:" + "plants/fossilSeed_" + fossilSeeds[i]);
            } else {
                textures[i] = iconRegister.registerIcon("fossil:" + "plants/seed_" + fossilSeeds[i]);
            }
        }
    }

    @Override
    public IIcon getIconFromDamage(int meta) {
        if (meta < 0 || meta >= textures.length) {
            meta = 0;
        }

        return textures[meta];
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float a, float b, float c) {

        if (!isFossil && player.canPlayerEdit(x, y, z, i, stack) && player.canPlayerEdit(x, y + 1, z, i, stack)) {
            if (Blocks.sapling.canBlockStay(world, x, y, z) && world.isAirBlock(x, y + 1, z) && world.getBlock(x, y, z) != FABlockRegistry.INSTANCE.welwitschia) {
                if(this.placePlantBlock(stack, world, x, y, z, new Random())){
                    world.playSound((double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D, FABlockRegistry.INSTANCE.dillhoffia.stepSound.getBreakSound(), 1F, new Random().nextFloat() * 0.1F + 0.8F, false);
                }
                --stack.stackSize;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean placePlantBlock(ItemStack stack, World world, int x, int y, int z, Random rand) {
        switch (stack.getItemDamage()) {
            case 0:
                world.setBlock(x, y + 1, z, FABlockRegistry.INSTANCE.dillhoffia);
               return true;
            case 1:
                world.setBlock(x, y + 1, z, FABlockRegistry.INSTANCE.sarracina);
                world.setBlock(x, y + 2, z, FABlockRegistry.INSTANCE.sarracina, 8, 3);
               return true;
            case 2:
                world.setBlock(x, y + 1, z, FABlockRegistry.INSTANCE.cephalotaxus);
               return true;
            case 3:
                world.setBlock(x, y + 1, z, FABlockRegistry.INSTANCE.licopodiophyta);
               return true;
            case 4:
                world.setBlock(x, y + 1, z, FABlockRegistry.INSTANCE.paleopanax);
                world.setBlock(x, y + 2, z, FABlockRegistry.INSTANCE.paleopanax, 8, 3);
               return true;
            case 5:
                world.setBlock(x, y + 1, z, FABlockRegistry.INSTANCE.zamites);
               return true;
            case 6:
                world.setBlock(x, y + 1, z, FABlockRegistry.INSTANCE.bennettitales_small);
               return true;
            case 7:
                world.setBlock(x, y + 1, z, FABlockRegistry.INSTANCE.welwitschia);
               return true;
            case 8:
                world.setBlock(x, y + 1, z, FABlockRegistry.INSTANCE.horsetail_small);
                return true;
            case 9:
                if(((BlockTempskya)FABlockRegistry.INSTANCE.tempskya).canPlaceBlockAt(world, x, y + 1, z)){
                	((BlockTempskya)FABlockRegistry.INSTANCE.tempskya).makeTempskya(world, x, y + 1, z);
                	return true;
                }
            case 10:
                world.setBlock(x, y + 1, z, FABlockRegistry.INSTANCE.vaccinium);
                return true;
            case 11:
                world.setBlock(x, y + 1, z, FABlockRegistry.INSTANCE.osmunda);
                return true;
            case 12:
                world.setBlock(x, y + 1, z, FABlockRegistry.INSTANCE.crataegus);
                world.setBlock(x, y + 2, z, FABlockRegistry.INSTANCE.crataegus, 8, 3);
                return true;
            case 13:
                world.setBlock(x, y + 1, z, FABlockRegistry.INSTANCE.florissantia);
                return true;
            case 14:
                world.setBlock(x, y + 1, z, FABlockRegistry.INSTANCE.ephedra);
                return true;
        }
        return false;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int meta = itemStack.getItemDamage();
        if (meta < 0 || meta >= fossilSeeds.length) {
            meta = 0;
        }

        return super.getUnlocalizedName() + "." + fossilSeeds[meta];
    }
}
