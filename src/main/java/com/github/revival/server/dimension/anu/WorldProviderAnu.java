package com.github.revival.server.dimension.anu;

import com.github.revival.Revival;
import com.github.revival.server.biome.FABiomeRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderAnu extends WorldProvider {
	@Override
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(FABiomeRegistry.INSTANCE.anuBiome, 0);
		this.dimensionId = Revival.CONFIG.dimensionIDDarknessLair;
		this.hasNoSky = true;
		this.isHellWorld = true;

	}

	@Override
	public float calculateCelestialAngle(long p_76563_1_, float p_76563_3_) {
		return 0.0F;
	}

	@Override
	public boolean canRespawnHere() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Vec3 getFogColor(float p_76562_1_, float p_76562_2_) {
		return Vec3.createVectorHelper(0.20000000298023224D, 0.029999999329447746D, 0.029999999329447746D);
	}

	@Override
	public boolean isSurfaceWorld() {
		return false;
	}

	/**
	 * Creates the light to brightness table
	 */
	@Override
	protected void generateLightBrightnessTable() {
		float f = 0.1F;

		for (int i = 0; i <= 15; ++i) {
			float f1 = 1.0F - (float) i / 15.0F;
			this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
		}
	}

	/**
	 * Returns array with sunrise/sunset colors
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public float[] calcSunriseSunsetColors(float p_76560_1_, float p_76560_2_) {
		return null;
	}

	@Override
	public String getDimensionName() {
		return "Land of Darkness";
	}

	@Override
	public String getWelcomeMessage() {
		return "Entering the Land of Darkness";
	}

	@Override
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderAnu(worldObj, worldObj.getSeed());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getCloudHeight() {
		return 8.0F;
	}

	/**
	 * Will check if the x, z position specified is alright to be set as the map
	 * spawn point
	 */
	@Override
	public boolean canCoordinateBeSpawn(int p_76566_1_, int p_76566_2_) {
		return this.worldObj.getTopBlock(p_76566_1_, p_76566_2_).getMaterial().blocksMovement();
	}

	/**
	 * Gets the hard-coded portal location to use when entering this dimension.
	 */
	@Override
	public ChunkCoordinates getEntrancePortalLocation() {
		return new ChunkCoordinates(0, 50, 0);
	}

	@Override
	public int getAverageGroundLevel() {
		return 50;
	}

	/**
	 * Returns true if the given X,Z coordinate should show environmental fog.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int p_76568_1_, int p_76568_2_) {
		return false;
	}

	@Override
	public int getRespawnDimension(EntityPlayerMP player) {
		return 0;
	}
}
