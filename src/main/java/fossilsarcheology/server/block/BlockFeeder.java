package fossilsarcheology.server.block;

import fossilsarcheology.Revival;
import fossilsarcheology.client.render.tileentity.RenderFeeder;
import fossilsarcheology.server.block.entity.TileEntityFeeder;
import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockFeeder extends BlockContainer {
    private static final int NO_BIT = 0;
    private static final int HERB_BIT = 4;
    private static final int CARN_BIT = 8;
    private static final int BOTH_BITS = 12;
    private static final int DIRECTION_BITS = 3;
    private Random furnaceRand = new Random();
    private IIcon Top1;// None
    private IIcon Top2;// Herb
    private IIcon Top3;// Carn
    private IIcon Top4;// Both
    private IIcon Front1;
    private IIcon Front2;
    private IIcon Front3;
    private IIcon Front4;
    private IIcon Bottom;

    public BlockFeeder(boolean isActive) {
        super(Material.iron);
        if (isActive) {
            GameRegistry.registerTileEntity(TileEntityFeeder.class, "NewFeeder");
        }
        setHardness(3.5F);
        setSoundType(Block.soundTypeMetal);

        if (!isActive) {
            setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
            setUnlocalizedName(LocalizationStrings.FEEDER_ACTIVE_NAME);
        } else {
            setUnlocalizedName(LocalizationStrings.FEEDER_IDLE_NAME);

        }
    }

    public static void updateFeederBlockState(boolean herb, boolean carn, World world, BlockPos pos) {
        int meta = world.getBlockMetadata(pos);
        TileEntity tileentity = world.getTileEntity(pos);

        // world.setBlock(pos, FABlockRegistry.INSTANCE.feederActive);

        if (herb) // If there's VEGGIES
        {
            meta |= HERB_BIT;
        } else
        // If there's NO VEGGIES
        {
            meta &= ~HERB_BIT;
        }
        if (carn) // If there's MEAT
        {
            meta |= CARN_BIT;
        } else
        // If there's NO MEAT
        {
            meta &= ~CARN_BIT;
        }

        world.setBlockMetadataWithNotify(pos, meta, 2);

        if (tileentity != null) {
            world.setTileEntity(pos, tileentity);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, BlockPos pos) {
        return Item.getItemFromBlock(FABlockRegistry.INSTANCE.feederActive);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    @Override
    public Item getItemDropped(int var1, Random var2, int var3) {
        return Item.getItemFromBlock(FABlockRegistry.INSTANCE.feederActive);
    }

    /**
     * Called whenever the block is added into the world. Args: world, pos
     */
    @Override
    public void onBlockAdded(World world, BlockPos pos) {
        super.onBlockAdded(world, pos);
        this.setDefaultDirection(world, pos);
    }

    @Override
    public int getRenderType() {
        return RenderFeeder.feederRenderID;
    }

    /**
     * set a blocks direction
     */
    private void setDefaultDirection(World world, BlockPos pos) {
        if (!world.isRemote) {
            Block block = world.getBlock(pos - 1);
            Block block1 = world.getBlock(pos + 1);
            Block block2 = world.getBlock(x - 1, y, z);
            Block block3 = world.getBlock(x + 1, y, z);

            byte b0 = 3;

            if (block.func_149730_j() && !block1.func_149730_j()) {
                b0 = 3;
            }

            if (block1.func_149730_j() && !block.func_149730_j()) {
                b0 = 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j()) {
                b0 = 5;
            }

            if (block3.func_149730_j() && !block2.func_149730_j()) {
                b0 = 4;
            }

            world.setBlockMetadataWithNotify(pos, b0, 2);
        }
    }

    /**
     * When this method is called, your block should register all the icons it
     * needs with the given IconRegister. This is the only chance you get to
     * register icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("fossil:Feeder_Sides");
        this.Bottom = par1IconRegister.registerIcon("fossil:Feeder_Bottom");
        this.Top1 = par1IconRegister.registerIcon("fossil:Feeder_Top1");
        this.Top2 = par1IconRegister.registerIcon("fossil:Feeder_Top2");
        this.Top3 = par1IconRegister.registerIcon("fossil:Feeder_Top3");
        this.Top4 = par1IconRegister.registerIcon("fossil:Feeder_Top4");
        this.Front1 = par1IconRegister.registerIcon("fossil:Feeder_Front1");
        this.Front2 = par1IconRegister.registerIcon("fossil:Feeder_Front2");
        this.Front3 = par1IconRegister.registerIcon("fossil:Feeder_Front3");
        this.Front4 = par1IconRegister.registerIcon("fossil:Feeder_Front4");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        if (meta == 0 && side == 3) {
            return Front1;
        }
        if (side == 0) {
            return this.Bottom;
        } else if (side != 1 && ((meta & DIRECTION_BITS) + 2) != side) {
            return this.blockIcon;
        } else {
            if (side == 1) {
                switch (meta & BOTH_BITS) {
                    case NO_BIT:
                        return this.Top1;// no food

                    case HERB_BIT:
                        return this.Top2;// herbivore

                    case CARN_BIT:
                        return this.Top3;// carnivore

                    case BOTH_BITS:
                        return this.Top4;// both
                }
            } else// Front
            {
                switch (meta & BOTH_BITS) {
                    case NO_BIT:
                        return this.Front1;// no food

                    case HERB_BIT:
                        return this.Front2;// herbivore

                    case CARN_BIT:
                        return this.Front3;// carnivore

                    case BOTH_BITS:
                        return this.Front4;// both
                }
            }

        }
        return this.blockIcon;
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, EntityPlayer player, int var6, float var7, float var8, float var9) {
        if (world.isRemote) {
            return true;
        } else {
            TileEntityFeeder tileentity = (TileEntityFeeder) world.getTileEntity(pos);

            if (tileentity != null) {
                player.openGui(Revival.INSTANCE, 2, world, pos);
            }

            return true;
        }
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing
     * the block.
     */
    @Override
    public TileEntity createNewTileEntity(World world, int par2) {
        return new TileEntityFeeder();
    }

    /**
     * Called when the block is placed in the world.
     */
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, EntityLivingBase entityLivingBase, ItemStack itemstack) {
        int entityDirection = MathHelper.floor_double((double) (entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (entityDirection == 0) {
            world.setBlockMetadataWithNotify(pos, 0, 2);
        }

        if (entityDirection == 1) {
            world.setBlockMetadataWithNotify(pos, 3, 2);
        }

        if (entityDirection == 2) {
            world.setBlockMetadataWithNotify(pos, 1, 2);
        }

        if (entityDirection == 3) {
            world.setBlockMetadataWithNotify(pos, 2, 2);
        }

        if (itemstack.hasDisplayName()) {
            ((TileEntityFeeder) world.getTileEntity(pos)).setGuiDisplayName(itemstack.getDisplayName());
        }
    }

    /**
     * ejects contained items into the world, and notifies neighbours of an
     * update, as appropriate
     */
    @Override
    public void breakBlock(World world, BlockPos pos, Block block, int var6) {
        TileEntityFeeder tileentity = (TileEntityFeeder) world.getTileEntity(pos);

        if (tileentity != null) {
            for (int i = 0; i < tileentity.getSizeInventory(); ++i) {
                ItemStack itemstack = tileentity.getStackInSlot(i);

                if (itemstack != null) {
                    float xOffset = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                    float yOffset = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                    float zOffset = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

                    while (itemstack.stackSize > 0) {
                        int rand = this.furnaceRand.nextInt(21) + 10;

                        if (rand > itemstack.stackSize) {
                            rand = itemstack.stackSize;
                        }

                        itemstack.stackSize -= rand;
                        EntityItem entityItem = new EntityItem(world, (double) ((float) x + xOffset), (double) ((float) y + yOffset), (double) ((float) z + zOffset), new ItemStack(itemstack.getItem(), rand, itemstack.getItemDamage()));

                        if (itemstack.hasTagCompound()) {
                            entityItem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
                        }

                        float offset = 0.05F;
                        entityItem.motionX = (double) ((float) this.furnaceRand.nextGaussian() * offset);
                        entityItem.motionY = (double) ((float) this.furnaceRand.nextGaussian() * offset + 0.2F);
                        entityItem.motionZ = (double) ((float) this.furnaceRand.nextGaussian() * offset);
                        world.spawnEntityInWorld(entityItem);
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
}
