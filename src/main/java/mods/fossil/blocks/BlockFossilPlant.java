package mods.fossil.blocks;

import java.util.Random;

import mods.fossil.Fossil;
import mods.fossil.core.FossilPlants;
import mods.fossil.util.FossilFX;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockFossilPlant extends BlockBush{

	public String textureName;
	private int renderType;
	public BlockFossilPlant(String texture, int renderType){
		super(Material.plants);
		this.setHardness(0);
		this.textureName = texture;
		this.renderType = renderType;
		this.setStepSound(soundTypeGrass);
	}

	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int var6, float var7, float var8, float var9){
		ItemStack itemstack = player.getCurrentEquippedItem();
		if(this == FossilPlants.bennettitales_small){
			this.grow(FossilPlants.bennettitales_large, itemstack, world, x, y, z, player);
			return true;
		}
		if(this == FossilPlants.horsetail_small){
			this.grow(FossilPlants.horsetail_large, itemstack, world, x, y, z, player);
			return true;
		}
		return false;
	}
	public void grow(Block plantBlock, ItemStack itemstack, World world, int x, int y, int z, EntityPlayer player){
		if(itemstack != null){
			if(itemstack.getItem() != null){
				if(itemstack.getItem() == Items.dye){
					if(itemstack.getItemDamage() == 15){
						Random rand = new Random();
						world.spawnParticle("happyVillager", x + (rand.nextDouble() - 0.5D) , y + rand.nextDouble(), z + (rand.nextDouble() - 0.5D), 0.0D, 0.0D, 0.0D);
						world.playAuxSFX(2005, x, y, z, 0);
						int l = ((MathHelper.floor_double((double)(1 * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
						world.setBlock(x, y, z, plantBlock);
						world.setBlock(x, y + 1, z, plantBlock, 8 | l, 2);
						//world.setBlockMetadataWithNotify(x, y, z, 1, 3);

						if (!player.capabilities.isCreativeMode)
						{
							--itemstack.stackSize;
						}
						if (itemstack.stackSize <= 0)
						{
							player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
						}
					}
				}
			}
		}
	}
	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random var1)
	{
		return 1;
	}
	@Override
	public void registerBlockIcons(IIconRegister par1IIconRegister)
	{
		this.blockIcon = par1IIconRegister.registerIcon(Fossil.modid + ":" + textureName);
	}
	@Override
	public int getRenderType()
	{
		return this.renderType;
	}
}
