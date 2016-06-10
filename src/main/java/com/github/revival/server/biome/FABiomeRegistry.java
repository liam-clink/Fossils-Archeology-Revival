package com.github.revival.server.biome;

import com.github.revival.Revival;
import com.github.revival.server.handler.LocalizationStrings;
import net.minecraft.init.Blocks;
import net.minecraft.util.StatCollector;
import net.minecraft.world.biome.BiomeGenBase;

public enum FABiomeRegistry {
	INSTANCE;

	public BiomeGenBase anuBiome;
	public BiomeGenBase treasureBiome;

	public void init() {
		anuBiome = new BasicBiome(Revival.CONFIG.biomeIDDarknessLair, Blocks.netherrack, Blocks.netherrack, true, 0, 0).setDisableRain().setBiomeName(LocalizationStrings.BIOME_ANU).setTemperatureRainfall(0.8F, 0F).setHeight(new BiomeGenBase.Height(0F, 0F));
		treasureBiome = new BasicBiome(Revival.CONFIG.biomeIDTreasure, Blocks.air, Blocks.air, true, 1, 0).setDisableRain().setBiomeName(StatCollector.translateToLocal("biome.treasure.name")).setTemperatureRainfall(0.8F, 0F).setHeight(new BiomeGenBase.Height(0F, 0F));
	}
}
