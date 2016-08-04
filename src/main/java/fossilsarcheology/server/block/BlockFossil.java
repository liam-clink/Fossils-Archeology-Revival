package fossilsarcheology.server.block;

import fossilsarcheology.Revival;
import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.enums.EnumDinoBones;
import fossilsarcheology.server.handler.FossilAchievementHandler;
import fossilsarcheology.server.handler.LocalizationStrings;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class BlockFossil extends BlockStone {
    Random rand = new Random();
    private int randomMeta;

    public BlockFossil() {
        super();
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setSoundType(Block.soundTypeStone);
        this.setUnlocalizedName(LocalizationStrings.BLOCK_FOSSIL_NAME);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        this.setHarvestLevel("pickaxe", 2);
        randomMeta = 0;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    @Override
    public Item getItemDropped(int var1, Random var2, int var3) {
        int i = (new Random()).nextInt(1100);

        if (i < 1) {
            this.randomMeta = 0;
            return FAItemRegistry.INSTANCE.gem;
        }

        if (i < 6) {
            this.randomMeta = 0;
            return FAItemRegistry.INSTANCE.brokenSword;
        }

        if (i < 11) {
            this.randomMeta = 0;
            return FAItemRegistry.INSTANCE.brokenhelmet;
        }

        if (i < 13) {
            int dropRandom = rand.nextInt(EnumDinoBones.values().length);
            if (dropRandom != 4) {
                this.randomMeta = dropRandom;
            }
            return FAItemRegistry.INSTANCE.legBone;
        }

        if (i < 15) {
            int dropRandom = rand.nextInt(EnumDinoBones.values().length);
            if (dropRandom != 4) {
                this.randomMeta = dropRandom;
            }
            return FAItemRegistry.INSTANCE.skull;
        }

        if (i < 17) {
            int dropRandom = rand.nextInt(EnumDinoBones.values().length);
            if (dropRandom != 4) {
                this.randomMeta = dropRandom;
            }
            return FAItemRegistry.INSTANCE.claw;
        }

        if (i < 19) {
            int dropRandom = rand.nextInt(EnumDinoBones.values().length);
            if (dropRandom != 4) {
                this.randomMeta = dropRandom;
            }
            return FAItemRegistry.INSTANCE.foot;
        }

        if (i < 21) {
            int dropRandom = rand.nextInt(EnumDinoBones.values().length);
            if (dropRandom != 4) {
                this.randomMeta = dropRandom;
            }
            return FAItemRegistry.INSTANCE.vertebrae;
        }

        if (i < 23) {
            int dropRandom = rand.nextInt(EnumDinoBones.values().length);
            if (dropRandom != 4) {
                this.randomMeta = dropRandom;
            }
            return FAItemRegistry.INSTANCE.armBone;
        }

        if (i < 25) {
            int dropRandom = rand.nextInt(EnumDinoBones.values().length);
            if (dropRandom != 4) {
                this.randomMeta = dropRandom;
            }
            return FAItemRegistry.INSTANCE.dinoRibCage;
        }

        if (i < 50) {
            this.randomMeta = 0;
            return Item.getItemFromBlock(FABlockRegistry.INSTANCE.blockSkull);
        }

        if (i < 350) {
            this.randomMeta = 0;
            return FAItemRegistry.INSTANCE.biofossil;
        }

        if (i < 550) {
            this.randomMeta = 0;
            return FAItemRegistry.INSTANCE.relic;
        }

        if (i < 900) {
            this.randomMeta = 0;
            return Items.bone;
        }
        if (i < 1200) {
            this.randomMeta = 0;
            return FAItemRegistry.INSTANCE.brokenSapling;
        }
        this.randomMeta = 0;
        return Item.getItemFromBlock(Blocks.cobblestone);
    }

    @Override
    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, int i) {
        super.harvestBlock(world, player, pos, i);
        player.triggerAchievement(FossilAchievementHandler.firstFossil);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, BlockPos pos, int metadata, int fortune) {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

        int count = quantityDropped(metadata, fortune, world.rand);
        for (int i = 0; i < count; i++) {
            Item item = getItemDropped(metadata, world.rand, fortune);
            if (item != null) {
                ret.add(new ItemStack(item, 1, randomMeta));
            }
        }
        return ret;
    }

    @Override
    public void registerBlockIcons(IIconRegister par1IIconRegister) {
        this.blockIcon = par1IIconRegister.registerIcon(Revival.MODID + ":" + "Fossil");
    }
}