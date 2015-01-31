package mods.fossil.handler;

import mods.fossil.Fossil;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class FossilToolEvent {

	private int paleontologyBonus;
	private int archeologyBonus;
	
	private boolean hasPaleontologyBonus = false;
	private boolean hasArcheologyBonus = false;

	@SubscribeEvent
	public void onHarvestBlocks(BlockEvent.HarvestDropsEvent event)
	{
		Block block = event.block;

		EntityPlayer player = event.harvester;
        if(player != null)
        {
        	paleontologyBonus = EnchantmentHelper.getEnchantmentLevel(Fossil.paleontology.effectId, event.harvester.inventory.getCurrentItem());
        	archeologyBonus = EnchantmentHelper.getEnchantmentLevel(Fossil.archeology.effectId, event.harvester.inventory.getCurrentItem());
        	
			if(event.harvester.inventory.getCurrentItem() == null)
			{
				return;
			} 
			else 
			{
				if(paleontologyBonus > 0)
				{
					hasPaleontologyBonus = true;
				}
				
				if(archeologyBonus > 0)
				{
					hasArcheologyBonus = true;
				}
			}
	
			if(hasPaleontologyBonus == true)
			{
	
					if(block == Fossil.blockFossil)
					{
						switch(paleontologyBonus){
						case 1:
							if(player.worldObj.rand.nextFloat() < 0.70)
							{
								event.drops.remove(0);
								event.drops.add(new ItemStack(Fossil.biofossil, 1));
								break;
							}
							else {
								break;
							}
						case 2:
							if(player.worldObj.rand.nextFloat() < 0.80)
							{
								event.drops.remove(0);
								event.drops.add(new ItemStack(Fossil.biofossil, 1));
								break;
							}
							else {
								break;
							}
						case 3:
							if(player.worldObj.rand.nextFloat() < 0.90)
							{
								event.drops.remove(0);
								event.drops.add(new ItemStack(Fossil.biofossil, 1));
								break;
							}
							else {
								break;
							}
						default: break;
						}
						
	
	
					}
					
					if(block == Fossil.blockPermafrost)
					{
						switch(paleontologyBonus){
						case 1:
							if(player.worldObj.rand.nextFloat() < 0.50)
							{
								event.drops.remove(0);
								event.drops.add(new ItemStack(Fossil.icedMeat, 1));
								break;
							}
							else {
								break;
							}
						case 2:
							if(player.worldObj.rand.nextFloat() < 0.70)
							{
								event.drops.remove(0);
								event.drops.add(new ItemStack(Fossil.icedMeat, 1));
								break;
							}
							else {
								break;
							}
						case 3:
							if(player.worldObj.rand.nextFloat() < 0.90)
							{
								event.drops.remove(0);
								event.drops.add(new ItemStack(Fossil.icedMeat, 1));
								break;
							}
							else {
								break;
							}
						default: break;
						}
					}
			}
			
			//Handle archeology bonus
			if(hasArcheologyBonus == true)
			{
				
				float rand = player.worldObj.rand.nextInt(1000);
	
					if(block == Fossil.blockFossil)
					{
						switch(archeologyBonus){
						case 1:
							if(rand < 500)
							{
								event.drops.remove(0);
								event.drops.add(new ItemStack(Fossil.relic, 1));
								break;
							}
							else {
								break;
							}
						case 2:
							if(rand < 700)
							{
								event.drops.remove(0);
								event.drops.add(new ItemStack(Fossil.relic, 1));
								break;
							}
							else {
								break;
							}
						case 3:
							if(rand < 900)
							{
								event.drops.remove(0);
								event.drops.add(new ItemStack(Fossil.relic, 1));
								break;
							}
							else if(rand < 904)
							{
								event.drops.remove(0);
								event.drops.add(new ItemStack(Fossil.gem, 1));
								break;
							}
							else {
								break;
							}
						default: break;
						}
					}
			}
		}
	}
}
