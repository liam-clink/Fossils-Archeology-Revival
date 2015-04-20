package mods.fossil.items;

import java.util.List;
import java.util.Random;

import mods.fossil.core.FossilPlants;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemFossilSeeds extends Item

{
	private static final String[] fossilSeeds = new String[] {"dillhoffia", "sarracina", "cephalotaxus", "licopodiophyta", "paleopanax", "zamites",
		"bennettitales", "welwitschia", "horsetail"};
	private IIcon[] textures;
	public boolean isFossil;
	public ItemFossilSeeds(boolean isFossil)
	{
		super();
		this.setHasSubtypes(true);
		this.isFossil = isFossil;
	}
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTabs, List list)
	{
		for (int i = 0; i < fossilSeeds.length; ++i) 
		{
			if (i != 3)
			{
				list.add(new ItemStack(item, 1, i));
			}
		}
	}

	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		textures = new IIcon[fossilSeeds.length];

		for (int i = 0; i < fossilSeeds.length; ++i) 
		{
			if(isFossil){
				textures[i] = iconRegister.registerIcon("fossil:"+ "plants/fossilSeed_"+ fossilSeeds[i]);
			}else{
				textures[i] = iconRegister.registerIcon("fossil:"+ "plants/seed_"+ fossilSeeds[i]);	
			}
		}
	}

	@Override
	public IIcon getIconFromDamage(int meta)
	{
		if (meta < 0 || meta >= textures.length) 
		{
			meta = 0;
		}

		return textures[meta];
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float a, float b, float c)
	{

		if (!isFossil && player.canPlayerEdit(x, y, z, i, stack) && player.canPlayerEdit(x, y + 1, z, i, stack))
		{
			if (Blocks.sapling.canBlockStay(world, x, y, z)&& world.isAirBlock(x, y + 1, z)&& world.getBlock(x, y, z) != FossilPlants.welwitschia)
			{
				this.placePlantBlock(stack, world, x, y, z, new Random());
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

	private void placePlantBlock(ItemStack stack, World world, int x, int y, int z, Random rand) {
		world.playSound((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, FossilPlants.dillhoffia.stepSound.getBreakSound(), 1F, rand.nextFloat() * 0.1F + 0.8F, false);
		switch (stack.getItemDamage())
		{
		case 0:
			world.setBlock(x, y + 1, z, FossilPlants.dillhoffia);
			break;
		case 1:
			world.setBlock(x, y + 1, z, FossilPlants.sarracina);
			world.setBlock(x, y + 2, z, FossilPlants.sarracina,8,3);
			break;
		case 2:
			world.setBlock(x, y + 1, z, FossilPlants.cephalotaxus);
			break;
		case 3:
			world.setBlock(x, y + 1, z, FossilPlants.licopodiophyta);
			break;
		case 4:
			world.setBlock(x, y + 1, z, FossilPlants.paleopanax);
			world.setBlock(x, y + 2, z, FossilPlants.paleopanax,8,3);
			break;
		case 5:
			world.setBlock(x, y + 1, z, FossilPlants.zamites);
			break;
		case 6:
			world.setBlock(x, y + 1, z, FossilPlants.bennettitales_small);
			break;
		case 7:
			world.setBlock(x, y + 1, z, FossilPlants.welwitschia);
			break;
		case 8:
			world.setBlock(x, y + 1, z, FossilPlants.horsetail_small);
			break;
		}
	}
	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		int meta = itemStack.getItemDamage();
		if (meta < 0 || meta >= fossilSeeds.length) 
		{
			meta = 0;
		}

		return super.getUnlocalizedName() + "." + fossilSeeds[meta];
	}
}

