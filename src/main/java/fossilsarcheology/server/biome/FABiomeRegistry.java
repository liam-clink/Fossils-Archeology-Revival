package fossilsarcheology.server.biome;

import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.init.Blocks;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.biome.Biome;

public enum FABiomeRegistry {
    INSTANCE;

    public Biome anuBiome;
    public Biome treasureBiome;

    public void init() {
        anuBiome = new FossilsBiome(new Biome.BiomeProperties(LocalizationStrings.BIOME_ANU).setRainDisabled().setRainfall(0.0F).setTemperature(0.8F).setHeightVariation(0.0F).setBaseHeight(0.0F), Blocks.NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), true, 0, 0);
        treasureBiome = new FossilsBiome(new Biome.BiomeProperties(I18n.translateToLocal("biome.treasure.name")).setRainDisabled().setRainfall(0.0F).setTemperature(0.8F).setHeightVariation(0.0F).setBaseHeight(0.0F), Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), true, 1, 0);
    }
}
