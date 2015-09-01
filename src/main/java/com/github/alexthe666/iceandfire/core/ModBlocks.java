package com.github.alexthe666.iceandfire.core;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.block.BlockGoldPile;

public class ModBlocks {

	public static Block goldPile;

	public static void init(){
		goldPile = new BlockGoldPile();
	}	
	
	protected void entityInit()
    {
		
    }
}
