package com.github.revival.server.block;

import com.github.revival.Revival;
import com.github.revival.server.block.entity.TileEntityCultivate;
import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.entity.mob.EntityFailuresaurus;
import com.github.revival.server.handler.FossilAchievementHandler;
import com.github.revival.server.handler.LocalizationStrings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
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
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCultivate extends BlockContainer {
    private static boolean keepFurnaceInventory = false;
    private final boolean isActive;
    // private final String VAT = "Vat.";
    // private final String ERR_OUTBREAK = "Err.OutBreak";
    private Random rand = new Random();

    public BlockCultivate(boolean isActive) {
        super(Material.glass);
        setLightLevel(0.9375F);
        setHardness(0.3F);
        setStepSound(Block.soundTypeGlass);
        this.isActive = isActive;
        if (isActive) {
            setBlockName(LocalizationStrings.BLOCK_CULTIVATE_ACTIVE_NAME);
        } else {
            setBlockName(LocalizationStrings.BLOCK_CULTIVATE_IDLE_NAME);
            setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
        }
    }

    public static void updateFurnaceBlockState(boolean isActive, World world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);
        TileEntity tile = world.getTileEntity(x, y, z);
        keepFurnaceInventory = true;

        if (isActive) {
            world.setBlock(x, y, z, FABlockRegistry.INSTANCE.blockcultivateActive);
        } else {
            world.setBlock(x, y, z, FABlockRegistry.INSTANCE.blockcultivateIdle);
        }

        keepFurnaceInventory = false;
        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
        tile.validate();
        world.setTileEntity(x, y, z, tile);
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int i) {
        this.returnDNA(world, x, y, z);
        super.onBlockDestroyedByPlayer(world, x, y, z, i);
    }

    @Override
    public Item getItemDropped(int par1, Random rand, int par2) {
        return Item.getItemFromBlock(FABlockRegistry.INSTANCE.blockcultivateIdle);
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        this.setDefaultDirection(world, x, y, z);
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

    /**
     * set a blocks direction
     */
    private void setDefaultDirection(World world, int x, int y, int z) {
        if (!world.isRemote) {
            Block block = world.getBlock(x, y, z - 1);
            Block block1 = world.getBlock(x, y, z + 1);
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

            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }

    /**
     * When this method is called, your block should register all the icons it
     * needs with the given IconRegister. This is the only chance you get to
     * register icons.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("fossil:Culture_Top");
    }

    /**
     * Returns the block texture based on the side being looked at. Args: side
     */
    /*
	 * public int getBlockTextureFromSide(int var1) { return var1 == 1 ? 36 :
	 * (var1 == 0 ? 36 : (var1 == 3 ? 20 : 20)); }
	 */
    @Override
    @SideOnly(Side.CLIENT)
    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
        world.spawnParticle("suspended", (double) ((float) x + rand.nextFloat()), (double) ((float) y + rand.nextFloat()), (double) ((float) z + rand.nextFloat()), 0.0D, 0.0D, 0.0D);
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        } else {
            player.openGui(Revival.INSTANCE, 1, world, x, y, z);
            return true;
        }
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing
     * the block.
     */
    @Override
    public TileEntity createNewTileEntity(World world, int par2) {
        return new TileEntityCultivate();
    }

    /**
     * Called when the block is placed in the world.
     */
	/*
	 * public void onBlockPlacedBy(World var1, int var2, int var3, int var4,
	 * EntityLiving var5) {This Block doesnt care for directions!
	 * super.onBlockPlacedBy(par1World, par2, par3, par4, par5EntityLiving,
	 * par6ItemStack) int var6 =
	 * MathHelper.floor_double((double)(var5.rotationYaw * 4.0F / 360.0F) +
	 * 0.5D) & 3;
	 * 
	 * if (var6 == 0)var1.setBlockMetadataWithNotify(var2, var3, var4, 2,2);
	 * 
	 * if (var6 == 1)var1.setBlockMetadataWithNotify(var2, var3, var4, 5,2);
	 * 
	 * if (var6 == 2)var1.setBlockMetadataWithNotify(var2, var3, var4, 3,2);
	 * 
	 * if (var6 == 3)var1.setBlockMetadataWithNotify(var2, var3, var4, 4,2); }
	 */
    private void returnDNA(World world, int x, int y, int z) {
        if (!keepFurnaceInventory) {
            TileEntityCultivate tile = (TileEntityCultivate) world.getTileEntity(x, y, z);
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
                            entityItem.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
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

    private void returnIron(World world, int x, int y, int z) {
        ItemStack stack = new ItemStack(Items.iron_ingot, 3);
        float offsetX = this.rand.nextFloat() * 0.8F + 0.1F;
        float offsetY = this.rand.nextFloat() * 0.8F + 0.1F;
        float offsetZ = this.rand.nextFloat() * 0.8F + 0.1F;

        while (stack.stackSize > 0) {
            int stackDecay = this.rand.nextInt(21) + 10;

            if (stackDecay > stack.stackSize) {
                stackDecay = stack.stackSize;
            }

            stack.stackSize -= stackDecay;
            EntityItem item = new EntityItem(world, (double) ((float) x + offsetX), (double) ((float) y + offsetY), (double) ((float) z + offsetZ), new ItemStack(stack.getItem(), stackDecay, stack.getItemDamage()));
            float motionMutlipler = 0.05F;
            item.motionX = (double) ((float) this.rand.nextGaussian() * motionMutlipler);
            item.motionY = (double) ((float) this.rand.nextGaussian() * motionMutlipler + 0.2F);
            item.motionZ = (double) ((float) this.rand.nextGaussian() * motionMutlipler);
            world.spawnEntityInWorld(item);
        }
    }

    public void onBlockRemovalLost(World world, int x, int y, int z, boolean isActive) {
        keepFurnaceInventory = false;
        String var6 = StatCollector.translateToLocal(LocalizationStrings.CULTIVATE_OUTBREAK);

        for (int var7 = 0; var7 < world.playerEntities.size(); ++var7) {
            EntityPlayer P = (EntityPlayer) world.playerEntities.get(var7);

            if (Math.pow(x - P.posX, 2D) + Math.pow(y - P.posY, 2D) + Math.pow(z - P.posZ, 2D) < 10000) // Only
            // for
            // Players
            // closer than 100
            // Metres
            {
                P.addStat(FossilAchievementHandler.failuresaurus, 1);
                Revival.showMessage(var6, P);
            }
        }

        this.returnIron(world, x, y, z);
        this.returnDNA(world, x, y, z);
        if (!world.isRemote) {
            if (isActive) {
                TileEntityCultivate tileentity = (TileEntityCultivate) world.getTileEntity(x, y, z);
                if (tileentity != null) {

                    if (tileentity.getDNAType() == 2 || tileentity.getDNAType() == 3) {
                        world.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(Blocks.glass));
                        world.setBlock(x, y + 1, z, FABlockRegistry.INSTANCE.mutantPlant);
                        world.setBlock(x, y + 2, z, FABlockRegistry.INSTANCE.mutantPlant, 8, 3);
                        world.setBlock(x, y, z, Blocks.dirt);

                    } else {
                        Object creature = null;
                        world.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(Blocks.glass));
                        world.setBlock(x, y, z, Blocks.water);

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
                    world.removeTileEntity(x, y, z);
                }

            }
        }
    }

    /**
     * ejects contained items into the world, and notifies neighbours of an
     * update, as appropriate
     */
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int var6) {
        if (!keepFurnaceInventory) {
            TileEntityCultivate tileentity = (TileEntityCultivate) world.getTileEntity(x, y, z);

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

        super.breakBlock(world, x, y, z, block, var6);
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
    public Item getItem(World world, int x, int y, int z) {

        return Item.getItemFromBlock(FABlockRegistry.INSTANCE.blockcultivateActive);
    }
}
