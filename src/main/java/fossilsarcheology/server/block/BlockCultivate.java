package fossilsarcheology.server.block;

import fossilsarcheology.Revival;
import fossilsarcheology.server.block.entity.TileEntityCultivate;
import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.entity.mob.EntityFailuresaurus;
import fossilsarcheology.server.handler.FossilAchievementHandler;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockCultivate extends BlockContainer {
    private static boolean keepInventory = false;
    private final boolean isActive;
    // private final String VAT = "Vat.";
    // private final String ERR_OUTBREAK = "Err.OutBreak";
    private Random rand = new Random();

    public BlockCultivate(boolean isActive) {
        super(Material.GLASS);
        setLightLevel(0.9375F);
        setHardness(0.3F);
        setSoundType(SoundType.GLASS);
        this.isActive = isActive;
        if (isActive) {
            setUnlocalizedName(LocalizationStrings.BLOCK_CULTIVATE_ACTIVE_NAME);
        } else {
            setUnlocalizedName(LocalizationStrings.BLOCK_CULTIVATE_IDLE_NAME);
            setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        }
    }

    public static void updateState(boolean isActive, World world, BlockPos pos) {
        int meta = world.getBlockMetadata(pos);
        TileEntity tile = world.getTileEntity(pos);
        keepInventory = true;
        if (isActive) {
            world.setBlockState(pos, FABlockRegistry.INSTANCE.CULTIVATE_ACTIVE.getDefaultState());
        } else {
            world.setBlockState(pos, FABlockRegistry.INSTANCE.CULTIVATE_IDLE.getDefaultState());
        }
        keepInventory = false;
        world.setBlockMetadataWithNotify(pos, meta, 2);
        tile.validate();
        world.setTileEntity(pos, tile);
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, BlockPos pos, int i) {
        this.returnDNA(world, pos);
        super.onBlockDestroyedByPlayer(world, pos, i);
    }

    @Override
    public Item getItemDropped(int par1, Random rand, int par2) {
        return Item.getItemFromBlock(FABlockRegistry.INSTANCE.CULTIVATE_IDLE);
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        super.onBlockAdded(world, pos, state);
        this.setDefaultDirection(world, pos);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return -90;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderBlockPass() {
        return 1;
    }

    private void setDefaultDirection(World world, BlockPos pos) {
        if (!world.isRemote) {
            Block block = world.getBlockState(pos.add(0, 0, -1));
            Block block1 = world.getBlockState(pos.add(0, 0, 1));
            Block block2 = world.getBlockState(pos.add(-1, 0, 0));
            Block block3 = world.getBlockState(pos.add(1, 0, 0));
            byte rotation = 3;
            if (block.func_149730_j() && !block1.func_149730_j()) {
                rotation = 3;
            }
            if (block1.func_149730_j() && !block.func_149730_j()) {
                rotation = 2;
            }
            if (block2.func_149730_j() && !block3.func_149730_j()) {
                rotation = 5;
            }
            if (block3.func_149730_j() && !block2.func_149730_j()) {
                rotation = 4;
            }
            world.setBlockMetadataWithNotify(pos, rotation, 2);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, BlockPos pos, Random rand) {
        world.spawnParticle("suspended", (double) ((float) x + rand.nextFloat()), (double) ((float) y + rand.nextFloat()), (double) ((float) z + rand.nextFloat()), 0.0D, 0.0D, 0.0D);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        } else {
            player.openGui(Revival.INSTANCE, 1, world, pos);
            return true;
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int par2) {
        return new TileEntityCultivate();
    }

    private void returnDNA(World world, BlockPos pos) {
        if (!keepInventory) {
            TileEntityCultivate tile = (TileEntityCultivate) world.getTileEntity(pos);
            if (tile != null) {
                ItemStack stack = tile.getStackInSlot(0);

                if (stack != null) {
                    float xOffset = this.rand.nextFloat() * 0.8F + 0.1F;
                    float yOffset = this.rand.nextFloat() * 0.8F + 0.1F;
                    float zOffset = this.rand.nextFloat() * 0.8F + 0.1F;

                    while (stack.stackSize > 0) {
                        int rand = this.rand.nextInt(21) + 10;

                        if (rand > stack.stackSize) {
                            rand = stack.stackSize;
                        }

                        stack.stackSize -= rand;
                        EntityItem entityItem = new EntityItem(world, (double) ((float) x + xOffset), (double) ((float) y + yOffset), (double) ((float) z + zOffset), new ItemStack(stack.getItem(), rand, stack.getItemDamage()));

                        if (stack.hasTagCompound()) {
                            entityItem.getEntityItem().setTagCompound(stack.getTagCompound().copy());
                        }

                        float offset = 0.05F;
                        entityItem.motionX = (double) ((float) this.rand.nextGaussian() * offset);
                        entityItem.motionY = (double) ((float) this.rand.nextGaussian() * offset + 0.2F);
                        entityItem.motionZ = (double) ((float) this.rand.nextGaussian() * offset);
                        world.spawnEntityInWorld(entityItem);
                    }
                }
            }
        }
    }

    private void returnIron(World world, BlockPos pos) {
        ItemStack stack = new ItemStack(Items.IRON_INGOT, 3);
        float offsetX = this.rand.nextFloat() * 0.8F + 0.1F;
        float offsetY = this.rand.nextFloat() * 0.8F + 0.1F;
        float offsetZ = this.rand.nextFloat() * 0.8F + 0.1F;

        while (stack.stackSize > 0) {
            int stackDecay = this.rand.nextInt(21) + 10;

            if (stackDecay > stack.stackSize) {
                stackDecay = stack.stackSize;
            }

            stack.stackSize -= stackDecay;
            EntityItem item = new EntityItem(world, (double) ((float) pos.getX() + offsetX), (double) ((float) pos.getY() + offsetY), (double) ((float) pos.getZ() + offsetZ), new ItemStack(stack.getItem(), stackDecay, stack.getItemDamage()));
            float motionMultiplier = 0.05F;
            item.motionX = (double) ((float) this.rand.nextGaussian() * motionMultiplier);
            item.motionY = (double) ((float) this.rand.nextGaussian() * motionMultiplier + 0.2F);
            item.motionZ = (double) ((float) this.rand.nextGaussian() * motionMultiplier);
            world.spawnEntityInWorld(item);
        }
    }

    public void onBlockRemovalLost(World world, BlockPos pos, boolean isActive) {
        keepInventory = false;
        String var6 = I18n.translateToLocal(LocalizationStrings.CULTIVATE_OUTBREAK);

        for (int var7 = 0; var7 < world.playerEntities.size(); ++var7) {
            EntityPlayer P = (EntityPlayer) world.playerEntities.get(var7);

            if (Math.pow(x - P.posX, 2D) + Math.pow(y - P.posY, 2D) + Math.pow(z - P.posZ, 2D) < 10000) // Only
            // for
            // Players
            // closer than 100
            // Metres
            {
                P.addStat(FossilAchievementHandler.failuresaurus, 1);
                Revival.messagePlayer(var6, P);
            }
        }

        this.returnIron(world, pos);
        this.returnDNA(world, pos);
        if (!world.isRemote) {
            if (isActive) {
                TileEntityCultivate tileentity = (TileEntityCultivate) world.getTileEntity(pos);
                if (tileentity != null) {

                    if (tileentity.getDNAType() == 2 || tileentity.getDNAType() == 3) {
                        world.playAuxSFX(2001, pos, Block.getIdFromBlock(Blocks.glass));
                        world.setBlock(x, y + 1, z, FABlockRegistry.INSTANCE.mutantPlant);
                        world.setBlock(x, y + 2, z, FABlockRegistry.INSTANCE.mutantPlant, 8, 3);
                        world.setBlock(pos, Blocks.dirt);

                    } else {
                        Object creature = null;
                        world.playAuxSFX(2001, pos, Block.getIdFromBlock(Blocks.glass));
                        world.setBlock(pos, Blocks.water);

                        if (world.isRemote) {
                            return;
                        }

                        int rand = world.rand.nextInt(100);

                        if (rand <= 5) {
                            creature = new EntityCreeper(world);
                        }

                        if (rand > 5 && rand < 10) {
                            creature = new EntityPigZombie(world);
                        }

                        if (rand >= 10) {
                            creature = new EntityFailuresaurus(world);
                            ((EntityFailuresaurus) creature).setSkin(new Random().nextInt(3));
                        }

                        ((EntityLiving) creature).setLocationAndAngles((double) x, (double) y, (double) z, world.rand.nextFloat() * 360.0F, 0.0F);
                        world.spawnEntityInWorld((Entity) creature);
                    }
                    world.removeTileEntity(pos);
                }

            }
        }
    }

    /**
     * ejects contained items into the world, and notifies neighbours of an
     * update, as appropriate
     */
    @Override
    public void breakBlock(World world, BlockPos pos, Block block, int var6) {
        if (!keepInventory) {
            TileEntityCultivate tileentity = (TileEntityCultivate) world.getTileEntity(pos);

            if (tileentity != null) {
                for (int i = 0; i < tileentity.getSizeInventory(); ++i) {
                    ItemStack itemstack = tileentity.getStackInSlot(i);

                    if (itemstack != null) {
                        float xOffset = this.rand.nextFloat() * 0.8F + 0.1F;
                        float yOffset = this.rand.nextFloat() * 0.8F + 0.1F;
                        float zOffset = this.rand.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0) {
                            int rand = this.rand.nextInt(21) + 10;

                            if (rand > itemstack.stackSize) {
                                rand = itemstack.stackSize;
                            }

                            itemstack.stackSize -= rand;
                            EntityItem entityItem = new EntityItem(world, (double) ((float) x + xOffset), (double) ((float) y + yOffset), (double) ((float) z + zOffset), new ItemStack(itemstack.getItem(), rand, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound()) {
                                entityItem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
                            }

                            float offset = 0.05F;
                            entityItem.motionX = (double) ((float) this.rand.nextGaussian() * offset);
                            entityItem.motionY = (double) ((float) this.rand.nextGaussian() * offset + 0.2F);
                            entityItem.motionZ = (double) ((float) this.rand.nextGaussian() * offset);
                            world.spawnEntityInWorld(entityItem);
                        }
                    }
                }
            }
        }

        super.breakBlock(world, pos, block, var6);
    }

    /**
     * If this returns true, then comparators facing away from this block will
     * use the value from getComparatorInputOverride instead of the actual
     * redstone signal strength.
     */
    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }

    /**
     * If hasComparatorInputOverride returns true, the return value from this is
     * used instead of the redstone signal strength when this block inputs to a
     * comparator.
     */
    @Override
    public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5) {
        return Container.calcRedstoneFromInventory((IInventory) par1World.getTileEntity(par2, par3, par4));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, BlockPos pos) {

        return Item.getItemFromBlock(FABlockRegistry.INSTANCE.CULTIVATE_ACTIVE);
    }
}
