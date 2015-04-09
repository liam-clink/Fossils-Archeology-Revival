package mods.fossil;

import java.util.Random;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class CommonProxy {
	public void registerRenderThings() {
	}

	public void registerTileEntitySpecialRenderer() {
	}

	public void registerSounds() {
	}

	public void registerEvents() {
	}

	public void registerChestItems() {
		// Random rand = new Random();
		// ChestGenHooks chestGenAcademyHooks =
		// ChestGenHooks.getInfo("Academy");
		// chestGenAcademyHooks.addItem(new WeightedRandomChestContent(new
		// ItemStack(Item.paper), rand.nextInt(22), 10, 70));
	}

	public ModelBiped getArmorModel(int id) {
		return null;
	}

	public void registerChestLoot() {
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(
				new WeightedRandomChestContent((new ItemStack(
						Fossil.figurineBlock, 1, new Random().nextInt(16))), 1,
						1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(Fossil.gem), 1, 1,
						1));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(
				new WeightedRandomChestContent(new ItemStack(Fossil.whip), 1,
						1, 50));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(
				new WeightedRandomChestContent(new ItemStack(Fossil.biofossil),
						3, 9, 10));
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(Fossil.biofossil),
						3, 12, 40));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(
						Fossil.fossilrecordBones), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Fossil.fossilrecordBones), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(Fossil.fossilrecordBones), 1, 1, 5));
		
		ChestGenHooks chestcontents = ChestGenHooks.getInfo(Fossil.CHEST_HELLSHIP);

		/*chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Fossil.ancientGlass), 2, 5, 5));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Fossil.amber), 1, 2, 76));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Fossil.ancientSword), 1, 1, 50));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Fossil.ancientVase), 1, 1, 36));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Fossil.ancientVaseBroken), 1, 1, 69));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Fossil.blockSkull), 1, 2, 40));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Fossil.drum), 1, 1, 28));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Fossil.potteryShards), 1, 3, 10));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Fossil.goldjavelin), 1, 1, 33));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Fossil.ironjavelin), 1, 1, 46));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Fossil.relic), 1, 5, 12));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Fossil.emptyShell), 1, 2, 20));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Fossil.stoneboard), 1, 3, 5));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Items.bone), 1, 3, 5));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Items.emerald), 1, 3, 25));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Items.flint), 1, 3, 5));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Items.blaze_rod), 1, 3, 5));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_11), 1, 1, 15));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Items.ghast_tear), 1, 2, 5));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Blocks.bookshelf), 1, 5, 15));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Blocks.glowstone), 1, 4, 15));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Blocks.obsidian), 1, 6, 15));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Items.netherbrick), 1, 12, 5));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Blocks.tnt), 1, 6, 5));*/



	}
}
