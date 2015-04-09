package mods.fossil.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemFossilSeed extends Item implements IPlantable
{
	String TextureFileName;
	Block plantBlock;
	public ItemFossilSeed(String TextureFileName0, Block block)
	{
		this.TextureFileName = TextureFileName0;
		this.plantBlock = block;
	}

	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("fossil:" + TextureFileName);
	}
	
	 public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float a, float b, float c)
	    {
	        if (i != 1)
	        {
	            return false;
	        }
	        else if (player.canPlayerEdit(x, y, z, i, stack) && player.canPlayerEdit(x, y + 1, z, i, stack))
	        {
	            if (world.getBlock(x, y, z).canSustainPlant(world, x, y, z, ForgeDirection.UP, this) && world.isAirBlock(x, y + 1, z))
	            {
	                world.setBlock(x, y + 1, z, this.plantBlock);
	                --stack.stackSize;
	                return true;
	            }
	            else
	            {
	                return false;
	            }
	        }
	        else
	        {
	            return false;
	        }
	    }

	  @Override
	    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
	    {
	        return EnumPlantType.Plains;
	    }

	    @Override
	    public Block getPlant(IBlockAccess world, int x, int y, int z)
	    {
	        return plantBlock;
	    }

	    @Override
	    public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
	    {
	        return 0;
	    }
}
