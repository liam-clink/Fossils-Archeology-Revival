package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockAmberOre extends Block {
    public BlockAmberOre() {
        super(Material.ROCK);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        setHardness(3.0F);
        setUnlocalizedName(LocalizationStrings.AMBER_ORE_NAME);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return this == FABlockRegistry.INSTANCE.amberOre ? FAItemRegistry.INSTANCE.amber : Item.getItemFromBlock(this);
    }

    @Override
    public int quantityDropped(Random random) {
        return this == FABlockRegistry.INSTANCE.amberOre ? 2 + random.nextInt(2) : 1;
    }

    @Override
    public int quantityDroppedWithBonus(int bonus, Random rand) {
        if (bonus > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getDefaultState(), rand, bonus)) {
            int quantityMultiplier = rand.nextInt(bonus + 1) - 1;
            if (quantityMultiplier < 0) {
                quantityMultiplier = 0;
            }
            return this.quantityDropped(rand) * (quantityMultiplier + 1);
        } else {
            return this.quantityDropped(rand);
        }
    }

    @Override
    public void dropBlockAsItemWithChance(World world, BlockPos pos, IBlockState state, float chance, int fortune) {
        super.dropBlockAsItemWithChance(world, pos, state, chance, fortune);

        if (this.getItemDropped(state, world.rand, fortune) != Item.getItemFromBlock(this)) {
            int amount = 0;
            if (this == FABlockRegistry.INSTANCE.amberOre) {
                amount = 1;
            }
            this.dropXpOnBlockBreak(world, pos, amount);
        }
    }

    @Override
    public int damageDropped(IBlockState state) {
        return this == FABlockRegistry.INSTANCE.amberOre ? 4 : 0;
    }
}
