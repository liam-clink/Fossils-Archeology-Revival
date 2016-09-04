package fossilsarcheology.server.block;

import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockFossilPlant extends BlockBush {
    public String textureName;

    public BlockFossilPlant(String texture) {
        super(Material.PLANTS);
        this.setHardness(0);
        this.textureName = texture;
        this.setSoundType(SoundType.PLANT);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack stack, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (this == FABlockRegistry.INSTANCE.bennettitales_small) {
            this.grow(FABlockRegistry.INSTANCE.bennettitales_large.getDefaultState(), stack, world, pos, player);
            return true;
        } else if (this == FABlockRegistry.INSTANCE.horsetail_small) {
            this.grow(FABlockRegistry.INSTANCE.horsetail_large.getDefaultState(), stack, world, pos, player);
            return true;
        }
        return false;
    }

    public void grow(IBlockState plantBlock, ItemStack stack, World world, BlockPos pos, EntityPlayer player) {
        if (stack != null) {
            if (stack.getItem() == Items.DYE) {
                if (stack.getItemDamage() == 15) {
                    Random rand = new Random();
                    world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + (rand.nextDouble() - 0.5D), pos.getY() + rand.nextDouble(), pos.getZ() + (rand.nextDouble() - 0.5D), 0.0D, 0.0D, 0.0D);
                    world.playEvent(2005, pos, 0);
                    world.setBlockState(pos, plantBlock);
                    world.setBlockState(pos.up(), plantBlock.withProperty(BlockDoublePlant.HALF, BlockDoublePlant.EnumBlockHalf.UPPER));
                    if (!player.capabilities.isCreativeMode) {
                        --stack.stackSize;
                    }
                    if (stack.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }
            }
        }
    }

    @Override
    public int quantityDropped(Random var1) {
        return 1;
    }
}
