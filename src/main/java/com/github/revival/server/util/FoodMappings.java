package com.github.revival.server.util;

import com.github.revival.server.entity.EnumDiet;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;

import java.util.Map;

public class FoodMappings {
	private static final FoodMappings INSTANCE = new FoodMappings();
	private Map<Integer, Integer> carnivoreItemDiet;
	private Map<Integer, Integer> herbivoreItemDiet;
	private Map<Integer, Integer> omnivoreItemDiet;
	private Map<Integer, Integer> piscivoreItemDiet;
	private Map<Integer, Integer> carnivore_eggItemDiet;
	private Map<Integer, Integer> insectivoreItemDiet;
	private Map<Integer, Integer> pisccarnivoreItemDiet;
	private Map<Integer, Integer> carnivoreBlockDiet;
	private Map<Integer, Integer> herbivoreBlockDiet;
	private Map<Integer, Integer> omnivoreBlockDiet;
	private Map<Integer, Integer> piscivoreBlockDiet;
	private Map<Integer, Integer> carnivore_eggBlockDiet;
	private Map<Integer, Integer> insectivoreBlockDiet;
	private Map<Integer, Integer> pisccarnivoreBlockDiet;
	private Map<Class<? extends Entity>, Integer> carnivoreEntityDiet;
	private Map<Class<? extends Entity>, Integer> herbivoreEntityDiet;
	private Map<Class<? extends Entity>, Integer> omnivoreEntityDiet;
	private Map<Class<? extends Entity>, Integer> piscivoreEntityDiet;
	private Map<Class<? extends Entity>, Integer> carnivore_eggEntityDiet;
	private Map<Class<? extends Entity>, Integer> insectivoreEntityDiet;
	private Map<Class<? extends Entity>, Integer> pisccarnivoreEntityDiet;

	public static FoodMappings instance() {
		return INSTANCE;
	}

	public void addToItemMappings(Item item, int food, EnumDiet diet) {
		if (item != null) {
			switch (diet) {
			case CARNIVORE:
				if (carnivoreItemDiet == null) {
					carnivoreItemDiet = Maps.newHashMap();
				}
				carnivoreItemDiet.put(Item.getIdFromItem(item), food);
				break;
			case HERBIVORE:
				if (herbivoreItemDiet == null) {
					herbivoreItemDiet = Maps.newHashMap();
				}
				herbivoreItemDiet.put(Item.getIdFromItem(item), food);
				break;
			case OMNIVORE:
				if (omnivoreItemDiet == null) {
					omnivoreItemDiet = Maps.newHashMap();
				}
				omnivoreItemDiet.put(Item.getIdFromItem(item), food);
				break;
			case PISCIVORE:
				if (piscivoreItemDiet == null) {
					piscivoreItemDiet = Maps.newHashMap();
				}
				piscivoreItemDiet.put(Item.getIdFromItem(item), food);
				break;
			case CARNIVORE_EGG:
				if (carnivore_eggItemDiet == null) {
					carnivore_eggItemDiet = Maps.newHashMap();
				}
				carnivore_eggItemDiet.put(Item.getIdFromItem(item), food);
				break;
			case INSECTIVORE:
				if (insectivoreItemDiet == null) {
					insectivoreItemDiet = Maps.newHashMap();
				}
				insectivoreItemDiet.put(Item.getIdFromItem(item), food);
				break;
			case PISCCARNIVORE:
				if (pisccarnivoreItemDiet == null) {
					pisccarnivoreItemDiet = Maps.newHashMap();
				}
				pisccarnivoreItemDiet.put(Item.getIdFromItem(item), food);
				break;
			default:
				break;
			}
		}
	}

	public int getItemFoodAmount(Item item, EnumDiet diet) {
		switch (diet) {
		case CARNIVORE:
			if (carnivoreItemDiet != null && carnivoreItemDiet.containsKey(Item.getIdFromItem(item))) {
				return carnivoreItemDiet.get(Item.getIdFromItem(item));
			}
			break;
		case HERBIVORE:
			if (herbivoreItemDiet != null && herbivoreItemDiet.containsKey(Item.getIdFromItem(item))) {
				return herbivoreItemDiet.get(Item.getIdFromItem(item));
			}
			break;
		case OMNIVORE:
			if (omnivoreItemDiet != null && omnivoreItemDiet.containsKey(Item.getIdFromItem(item))) {
				return omnivoreItemDiet.get(Item.getIdFromItem(item));
			}
			break;
		case PISCIVORE:
			if (piscivoreItemDiet != null && piscivoreItemDiet.containsKey(Item.getIdFromItem(item))) {
				return piscivoreItemDiet.get(Item.getIdFromItem(item));
			}
			break;
		case CARNIVORE_EGG:
			if (carnivore_eggItemDiet != null && carnivore_eggItemDiet.containsKey(Item.getIdFromItem(item))) {
				return carnivore_eggItemDiet.get(Item.getIdFromItem(item));
			}
			break;
		case INSECTIVORE:
			if (insectivoreItemDiet != null && insectivoreItemDiet.containsKey(Item.getIdFromItem(item))) {
				return insectivoreItemDiet.get(Item.getIdFromItem(item));
			}
			break;
		case PISCCARNIVORE:
			if (pisccarnivoreItemDiet != null && pisccarnivoreItemDiet.containsKey(Item.getIdFromItem(item))) {
				return pisccarnivoreItemDiet.get(Item.getIdFromItem(item));
			}
			break;
		default:
			return 0;
		}
		return 0;
	}

	public void addToBlockMappings(Block block, int food, EnumDiet diet, boolean registerItem) {
		switch (diet) {
		case CARNIVORE:
			if (carnivoreBlockDiet == null) {
				carnivoreBlockDiet = Maps.newHashMap();
			}
			carnivoreBlockDiet.put(Block.getIdFromBlock(block), food);
			break;
		case HERBIVORE:
			if (herbivoreBlockDiet == null) {
				herbivoreBlockDiet = Maps.newHashMap();
			}
			herbivoreBlockDiet.put(Block.getIdFromBlock(block), food);
			break;
		case OMNIVORE:
			if (omnivoreBlockDiet == null) {
				omnivoreBlockDiet = Maps.newHashMap();
			}
			omnivoreBlockDiet.put(Block.getIdFromBlock(block), food);
			break;
		case PISCIVORE:
			if (piscivoreBlockDiet == null) {
				piscivoreBlockDiet = Maps.newHashMap();
			}
			piscivoreBlockDiet.put(Block.getIdFromBlock(block), food);
			break;
		case CARNIVORE_EGG:
			if (carnivore_eggBlockDiet == null) {
				carnivore_eggBlockDiet = Maps.newHashMap();
			}
			carnivore_eggBlockDiet.put(Block.getIdFromBlock(block), food);
			break;
		case INSECTIVORE:
			if (insectivoreBlockDiet == null) {
				insectivoreBlockDiet = Maps.newHashMap();
			}
			insectivoreBlockDiet.put(Block.getIdFromBlock(block), food);
			break;
		case PISCCARNIVORE:
			if (pisccarnivoreBlockDiet == null) {
				pisccarnivoreBlockDiet = Maps.newHashMap();
			}
			pisccarnivoreBlockDiet.put(Block.getIdFromBlock(block), food);
			break;
		default:
			break;
		}
		if (registerItem) {
			addToItemMappings(Item.getItemFromBlock(block), food, diet);
		}
	}

	public int getBlockFoodAmount(Block block, EnumDiet diet) {
		switch (diet) {
		case CARNIVORE:
			if (carnivoreBlockDiet != null && carnivoreBlockDiet.containsKey(Block.getIdFromBlock(block))) {
				return carnivoreBlockDiet.get(Block.getIdFromBlock(block));
			}
			break;
		case HERBIVORE:
			if (herbivoreBlockDiet != null && herbivoreBlockDiet.containsKey(Block.getIdFromBlock(block))) {
				return herbivoreBlockDiet.get(Block.getIdFromBlock(block));
			}
			break;
		case OMNIVORE:
			if (omnivoreBlockDiet != null && omnivoreBlockDiet.containsKey(Block.getIdFromBlock(block))) {
				return omnivoreBlockDiet.get(Block.getIdFromBlock(block));
			}
			break;
		case PISCIVORE:
			if (piscivoreBlockDiet != null && piscivoreBlockDiet.containsKey(Block.getIdFromBlock(block))) {
				return piscivoreBlockDiet.get(Block.getIdFromBlock(block));
			}
			break;
		case CARNIVORE_EGG:
			if (carnivore_eggBlockDiet != null && carnivore_eggBlockDiet.containsKey(Block.getIdFromBlock(block))) {
				return carnivore_eggBlockDiet.get(Block.getIdFromBlock(block));
			}
			break;
		case INSECTIVORE:
			if (insectivoreBlockDiet != null && insectivoreBlockDiet.containsKey(Block.getIdFromBlock(block))) {
				return insectivoreBlockDiet.get(Block.getIdFromBlock(block));
			}
			break;
		case PISCCARNIVORE:
			if (pisccarnivoreBlockDiet != null && pisccarnivoreBlockDiet.containsKey(Block.getIdFromBlock(block))) {
				return pisccarnivoreBlockDiet.get(Block.getIdFromBlock(block));
			}
			break;
		default:
			return 0;
		}
		return 0;
	}

	public void addToEntityMappings(Class<? extends Entity> entity, int food, EnumDiet diet) {
		switch (diet) {
		case CARNIVORE:
			if (carnivoreEntityDiet == null) {
				carnivoreEntityDiet = Maps.newHashMap();
			}
			carnivoreEntityDiet.put(entity, food);
			break;
		case HERBIVORE:
			if (herbivoreEntityDiet == null) {
				herbivoreEntityDiet = Maps.newHashMap();
			}
			herbivoreEntityDiet.put(entity, food);
			break;
		case OMNIVORE:
			if (omnivoreEntityDiet == null) {
				omnivoreEntityDiet = Maps.newHashMap();
			}
			omnivoreEntityDiet.put(entity, food);
			break;
		case PISCIVORE:
			if (piscivoreEntityDiet == null) {
				piscivoreEntityDiet = Maps.newHashMap();
			}
			piscivoreEntityDiet.put(entity, food);
			break;
		case CARNIVORE_EGG:
			if (carnivore_eggEntityDiet == null) {
				carnivore_eggEntityDiet = Maps.newHashMap();
			}
			carnivore_eggEntityDiet.put(entity, food);
			break;
		case INSECTIVORE:
			if (insectivoreEntityDiet == null) {
				insectivoreEntityDiet = Maps.newHashMap();
			}
			insectivoreEntityDiet.put(entity, food);
			break;
		case PISCCARNIVORE:
			if (pisccarnivoreEntityDiet == null) {
				pisccarnivoreEntityDiet = Maps.newHashMap();
			}
			pisccarnivoreEntityDiet.put(entity, food);
			break;
		default:
			break;
		}
	}

	public int getEntityFoodAmount(Class<? extends Entity> entity, EnumDiet diet) {
		switch (diet) {
		case CARNIVORE:
			if (carnivoreEntityDiet != null && carnivoreEntityDiet.containsKey(entity)) {
				return carnivoreEntityDiet.get(entity);
			}
			break;
		case HERBIVORE:
			if (herbivoreEntityDiet != null && herbivoreEntityDiet.containsKey(entity)) {
				return herbivoreEntityDiet.get(entity);
			}
			break;
		case OMNIVORE:
			if (omnivoreEntityDiet != null && omnivoreEntityDiet.containsKey(entity)) {
				return omnivoreEntityDiet.get(entity);
			}
			break;
		case PISCIVORE:
			if (piscivoreEntityDiet != null && piscivoreEntityDiet.containsKey(entity)) {
				return piscivoreEntityDiet.get(entity);
			}
			break;
		case CARNIVORE_EGG:
			if (carnivore_eggEntityDiet != null && carnivore_eggEntityDiet.containsKey(entity)) {
				return carnivore_eggEntityDiet.get(entity);
			}
			break;
		case INSECTIVORE:
			if (insectivoreEntityDiet != null && insectivoreEntityDiet.containsKey(entity)) {
				return insectivoreEntityDiet.get(entity);
			}
			break;
		case PISCCARNIVORE:
			if (pisccarnivoreEntityDiet != null && pisccarnivoreEntityDiet.containsKey(entity)) {
				return pisccarnivoreEntityDiet.get(entity);
			}
			break;
		default:
			return 0;
		}
		return 0;
	}

	public Map<Integer, Integer> getFoodRenderList(EnumDiet diet) {
		switch (diet) {
		case CARNIVORE:
			if (carnivoreItemDiet == null) {
				carnivoreItemDiet = Maps.newHashMap();
			}
			return carnivoreItemDiet;
		case HERBIVORE:
			if (herbivoreItemDiet == null) {
				herbivoreItemDiet = Maps.newHashMap();
			}
			return herbivoreItemDiet;
		case OMNIVORE:
			if (omnivoreItemDiet == null) {
				omnivoreItemDiet = Maps.newHashMap();
			}
			return omnivoreItemDiet;
		case PISCIVORE:
			if (piscivoreItemDiet == null) {
				piscivoreItemDiet = Maps.newHashMap();
			}
			return piscivoreItemDiet;
		case CARNIVORE_EGG:
			if (carnivore_eggItemDiet == null) {
				carnivore_eggItemDiet = Maps.newHashMap();
			}
			return carnivore_eggItemDiet;
		case INSECTIVORE:
			if (insectivoreItemDiet == null) {
				insectivoreItemDiet = Maps.newHashMap();
			}
			return insectivoreItemDiet;
		case PISCCARNIVORE:
			if (pisccarnivoreItemDiet == null) {
				pisccarnivoreItemDiet = Maps.newHashMap();
			}
			return pisccarnivoreItemDiet;
		default:
			return carnivoreItemDiet;
		}
	}

	public void removeItemMapping(Item item, EnumDiet diet) {
		this.getFoodRenderList(diet).remove(Item.getIdFromItem(item));
	}

}
