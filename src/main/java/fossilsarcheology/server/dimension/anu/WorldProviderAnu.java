package fossilsarcheology.server.dimension.anu;

import fossilsarcheology.Revival;
import fossilsarcheology.server.biome.FABiomeRegistry;
import fossilsarcheology.server.dimension.FADimensionHandler;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderAnu extends WorldProvider {
    @Override
    public void createBiomeProvider() {
        this.biomeProvider = new BiomeProviderSingle(FABiomeRegistry.INSTANCE.anuBiome);
        this.setDimension(Revival.CONFIG.dimensionIDDarknessLair);
        this.hasNoSky = true;
        this.isHellWorld = true;
    }

    @Override
    public float calculateCelestialAngle(long time, float p_76563_3_) {
        return 0.0F;
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Vec3d getFogColor(float celestialAngle, float partialTicks) {
        return new Vec3d(0.20000000298023224D, 0.029999999329447746D, 0.029999999329447746D);
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    protected void generateLightBrightnessTable() {
        float f = 0.1F;
        for (int i = 0; i <= 15; ++i) {
            float f1 = 1.0F - (float) i / 15.0F;
            this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float[] calcSunriseSunsetColors(float p_76560_1_, float p_76560_2_) {
        return null;
    }

    @Override
    public String getWelcomeMessage() {
        return "Entering the Land of Darkness";
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkProviderAnu(worldObj, worldObj.getSeed());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getCloudHeight() {
        return 8.0F;
    }

    @Override
    public boolean canCoordinateBeSpawn(int x, int z) {
        return this.worldObj.getBlockState(this.worldObj.getHeight(new BlockPos(x, 0, z))).getMaterial().blocksMovement();
    }

    @Override
    public BlockPos getSpawnCoordinate() {
        return new BlockPos(0, 50, 0);
    }

    @Override
    public int getAverageGroundLevel() {
        return 50;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(int p_76568_1_, int p_76568_2_) {
        return false;
    }

    @Override
    public int getRespawnDimension(EntityPlayerMP player) {
        return 0;
    }

    @Override
    public DimensionType getDimensionType() {
        return FADimensionHandler.ANU;
    }
}
