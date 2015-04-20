package mods.fossil.items;

import mods.fossil.Fossil;
import mods.fossil.entity.mob.EntityConfuciusornisEgg;
import mods.fossil.entity.mob.EntityCultivatedChickenEgg;
import mods.fossil.entity.mob.EntityCultivatedConfuciusornisEgg;
import mods.fossil.entity.mob.EntityCultivatedDodoEgg;
import mods.fossil.entity.mob.EntityDodoEgg;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBirdEgg extends Item
{
	int eggSelector;
	public ItemBirdEgg(int eggSelector)
	{
		super();
		this.eggSelector = eggSelector;
		this.maxStackSize = 16;
		this.setCreativeTab(Fossil.tabFItems);
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (!par3EntityPlayer.capabilities.isCreativeMode)
		{
			--par1ItemStack.stackSize;
		}

		par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!par2World.isRemote)
		{
			if(this.eggSelector == 0){
				par2World.spawnEntityInWorld(new EntityDodoEgg(par2World, par3EntityPlayer));
			}else if(this.eggSelector == 1){
				par2World.spawnEntityInWorld(new EntityCultivatedDodoEgg(par2World, par3EntityPlayer));
			}else if(this.eggSelector == 2){
				par2World.spawnEntityInWorld(new EntityConfuciusornisEgg(par2World, par3EntityPlayer));
			}else if(this.eggSelector == 3){
				par2World.spawnEntityInWorld(new EntityCultivatedConfuciusornisEgg(par2World, par3EntityPlayer));
			}
			else if(this.eggSelector == 4){
				par2World.spawnEntityInWorld(new EntityCultivatedChickenEgg(par2World, par3EntityPlayer));
			}
		}

		return par1ItemStack;
	}
}
