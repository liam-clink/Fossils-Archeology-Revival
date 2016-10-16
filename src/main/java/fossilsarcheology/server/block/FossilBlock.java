package fossilsarcheology.server.block;

import fossilsarcheology.server.api.DefaultRenderedItem;
import fossilsarcheology.server.item.FAItemRegistry;
import fossilsarcheology.server.tab.FATabRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FossilBlock extends Block implements DefaultRenderedItem {
    private int randomMeta;

    public FossilBlock() {
        super(Material.ROCK);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setSoundType(SoundType.STONE);
        this.setUnlocalizedName("fossil");
        this.setCreativeTab(FATabRegistry.BLOCKS);
        this.setHarvestLevel("pickaxe", 2);
        this.randomMeta = 0;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
/*
        int i = rand.nextInt(1100);
        if (i < 1) {
            this.randomMeta = 0;
            return FAItemRegistry.GEM;
        } else if (i < 6) {
            this.randomMeta = 0;
            return FAItemRegistry.brokenSword;
        } else if (i < 11) {
            this.randomMeta = 0;
            return FAItemRegistry.brokenhelmet;
        } else if (i < 13) {
            int dropRandom = rand.nextInt(DinosaurBoneType.values().length);
            if (dropRandom != 4) {
                this.randomMeta = dropRandom;
            }
            return FAItemRegistry.legBone;
        } else if (i < 15) {
            int dropRandom = rand.nextInt(DinosaurBoneType.values().length);
            if (dropRandom != 4) {
                this.randomMeta = dropRandom;
            }
            return FAItemRegistry.skull;
        } else if (i < 17) {
            int dropRandom = rand.nextInt(DinosaurBoneType.values().length);
            if (dropRandom != 4) {
                this.randomMeta = dropRandom;
            }
            return FAItemRegistry.claw;
        } else if (i < 19) {
            int dropRandom = rand.nextInt(DinosaurBoneType.values().length);
            if (dropRandom != 4) {
                this.randomMeta = dropRandom;
            }
            return FAItemRegistry.foot;
        } else if (i < 21) {
            int dropRandom = rand.nextInt(DinosaurBoneType.values().length);
            if (dropRandom != 4) {
                this.randomMeta = dropRandom;
            }
            return FAItemRegistry.vertebrae;
        } else if (i < 23) {
            int dropRandom = rand.nextInt(DinosaurBoneType.values().length);
            if (dropRandom != 4) {
                this.randomMeta = dropRandom;
            }
            return FAItemRegistry.armBone;
        } else if (i < 25) {
            int dropRandom = rand.nextInt(DinosaurBoneType.values().length);
            if (dropRandom != 4) {
                this.randomMeta = dropRandom;
            }
            return FAItemRegistry.dinoRibCage;
        } else if (i < 50) {
            this.randomMeta = 0;
            return Item.getItemFromBlock(FABlockRegistry.INSTANCE.blockSkull);
        } else if (i < 350) {
*/
        this.randomMeta = 0;
        return FAItemRegistry.BIOFOSSIL;
/*        } else if (i < 550) {
            this.randomMeta = 0;
            return FAItemRegistry.relic;
        } else if (i < 900) {
            this.randomMeta = 0;
            return Items.BONE;
        } else if (i < 1200) {
            this.randomMeta = 0;
            return FAItemRegistry.brokenSapling;
        }
        this.randomMeta = 0;
        return Item.getItemFromBlock(Blocks.COBBLESTONE);*/
    }

    @Override
    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity tile, ItemStack stack) {
        super.harvestBlock(world, player, pos, state, tile, stack);
//        player.addStat(FossilAchievementHandler.FIRST_FOSSIL); TODO
    }

    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<>();
        Random random = new Random();
        int count = this.quantityDropped(state, fortune, random);
        for (int i = 0; i < count; i++) {
            Item item = this.getItemDropped(state, random, fortune);
            if (item != null) {
                drops.add(new ItemStack(item, 1, this.randomMeta));
            }
        }
        return drops;
    }
}