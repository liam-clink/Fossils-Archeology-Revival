package mods.fossil.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class BlockAnuItem extends ItemBlock {

	public BlockAnuItem(Block block) {
		super(block);
	}

	  public EnumRarity getRarity(ItemStack item)
	    {
	        return EnumRarity.epic;
	    }
}
