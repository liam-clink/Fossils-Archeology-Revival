package mods.fossil.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockRail;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockSlimeTrail extends BlockRail{

	public BlockSlimeTrail(){
		super();
		this.slipperiness = 1.12F;

	}
	public Item getItemDropped(int var1, Random var2, int var3)
	{
		if(var2.nextInt(3) == 0){
			return Items.slime_ball;
		}else{
			return Item.getItemById(0);

		}

	}

}
