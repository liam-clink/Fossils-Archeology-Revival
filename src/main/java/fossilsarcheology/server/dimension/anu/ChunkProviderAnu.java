package fossilsarcheology.server.dimension.anu;

import cpw.mods.fml.common.eventhandler.Event.Result;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.List;
import java.util.Random;

public class ChunkProviderAnu implements IChunkProvider {
	public NoiseGeneratorOctaves noiseGen4;
	public NoiseGeneratorOctaves noiseGen5;
	double[] noiseData1;
	double[] noiseData2;
	double[] noiseData3;
	double[] noiseData4;
	double[] noiseData5;
	int[][] field_73203_h = new int[32][32];
	private Random endRNG;
	private NoiseGeneratorOctaves noiseGen1;
	private NoiseGeneratorOctaves noiseGen2;
	private NoiseGeneratorOctaves noiseGen3;
	private World endWorld;
	private double[] densities;
	private BiomeGenBase[] biomesForGeneration;

	public ChunkProviderAnu(World world, long seed) {
		this.endWorld = world;
		this.endRNG = new Random(seed);
		this.noiseGen1 = new NoiseGeneratorOctaves(this.endRNG, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.endRNG, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.endRNG, 8);
		this.noiseGen4 = new NoiseGeneratorOctaves(this.endRNG, 10);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.endRNG, 16);
		NoiseGenerator[] noiseGens = { noiseGen1, noiseGen2, noiseGen3, noiseGen4, noiseGen5 };
		noiseGens = TerrainGen.getModdedNoiseGenerators(world, this.endRNG, noiseGens);
		this.noiseGen1 = (NoiseGeneratorOctaves) noiseGens[0];
		this.noiseGen2 = (NoiseGeneratorOctaves) noiseGens[1];
		this.noiseGen3 = (NoiseGeneratorOctaves) noiseGens[2];
		this.noiseGen4 = (NoiseGeneratorOctaves) noiseGens[3];
		this.noiseGen5 = (NoiseGeneratorOctaves) noiseGens[4];
	}

	public void func_147420_a(int chunkX, int chunkZ, Block[] blockArray, BiomeGenBase[] biomeArray) {
		byte b0 = 2;
		int k = b0 + 1;
		byte b1 = 33;
		int l = b0 + 1;
		this.densities = this.initializeNoiseField(this.densities, chunkX * b0, 0, chunkZ * b0, k, b1, l);
		for (int i1 = 0; i1 < b0; ++i1) {
			for (int j1 = 0; j1 < b0; ++j1) {
				for (int k1 = 0; k1 < 32; ++k1) {
					double d0 = 0.15D;
					double d1 = this.densities[(((i1 + 0) * l + j1 + 0) * b1 + k1)];
					double d2 = this.densities[(((i1 + 0) * l + j1 + 1) * b1 + k1)];
					double d3 = this.densities[(((i1 + 1) * l + j1 + 0) * b1 + k1)];
					double d4 = this.densities[(((i1 + 1) * l + j1 + 1) * b1 + k1)];
					double d5 = (this.densities[((i1) * l + j1) * b1 + k1 + 1] - d1) * d0;
					double d6 = (this.densities[((i1) * l + j1 + 1) * b1 + k1 + 1] - d2) * d0;
					double d7 = (this.densities[((i1 + 1) * l + j1) * b1 + k1 + 1] - d3) * d0;
					double d8 = (this.densities[((i1 + 1) * l + j1 + 1) * b1 + k1 + 1] - d4) * d0;
					for (int l1 = 0; l1 < 4; ++l1) {
						double d9 = 0.125D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;
						for (int i2 = 0; i2 < 8; ++i2) {
							int j2 = i2 + i1 * 8 << 11 | j1 * 8 << 7 | k1 * 4 + l1;
							short short1 = 128;
							double d14 = 0.125D;
							double d15 = d10;
							double d16 = (d11 - d10) * d14;
							for (int k2 = 0; k2 < 8; ++k2) {
								Block block = null;
								if (d15 > 0.0D) {
									block = Blocks.netherrack;
								}
								blockArray[j2] = block;
								j2 += short1;
								d15 += d16;
							}
							d10 += d12;
							d11 += d13;
						}
						d1 += d5;
						d2 += d6;
						d3 += d7;
						d4 += d8;
					}
				}
			}
		}
	}

	public void replaceBiomeBlocks(int chunkX, int chunkZ, Block[] blockArray, BiomeGenBase[] biomeArray, byte[] meta) {

		ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, chunkX, chunkZ, blockArray, meta, biomeArray, this.endWorld);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.getResult() == Result.DENY) {
			return;
		}
		for (int k = 0; k < 16; ++k) {
			for (int l = 0; l < 16; ++l) {
				byte b0 = 1;
				int i1 = -1;
				Block block = Blocks.end_stone;
				Block block1 = Blocks.end_stone;

				for (int j1 = 127; j1 >= 0; --j1) {
					int k1 = (l * 16 + k) * 128 + j1;
					Block block2 = blockArray[k1];

					if (block2 != null && block2.getMaterial() != Material.air) {
						if (block2 == Blocks.stone) {
							if (i1 == -1) {
								if (b0 <= 0) {
									block = null;
									block1 = Blocks.end_stone;
								}

								i1 = b0;

								if (j1 >= 0) {
									blockArray[k1] = block;
								} else {
									blockArray[k1] = block1;
								}
							} else if (i1 > 0) {
								--i1;
								blockArray[k1] = block1;
							}
						}
					} else {
						i1 = -1;
					}
				}
			}
		}
	}

	@Override
	public Chunk loadChunk(int x, int z) {
		return this.provideChunk(x, z);
	}

	@Override
	public Chunk provideChunk(int x, int z) {
		this.endRNG.setSeed((long) x * 341873128712L + (long) z * 132897987541L);
		Block[] ablock = new Block[32768];
		byte[] meta = new byte[ablock.length];
		this.biomesForGeneration = this.endWorld.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, x * 16, z * 16, 16, 16);
		this.func_147420_a(x, z, ablock, this.biomesForGeneration);
		this.replaceBiomeBlocks(x, z, ablock, this.biomesForGeneration, meta);
		Chunk chunk = new Chunk(this.endWorld, ablock, meta, x, z);
		byte[] abyte = chunk.getBiomeArray();
		for (int k = 0; k < abyte.length; ++k) {
			abyte[k] = (byte) this.biomesForGeneration[k].biomeID;
		}
		chunk.generateSkylightMap();
		return chunk;
	}

	private double[] initializeNoiseField(double[] noise, int a, int b, int c, int d, int e, int g) {
		ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField(this, noise, a, b, c, d, e, g);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.getResult() == Result.DENY) {
			return event.noisefield;
		}

		if (noise == null) {
			noise = new double[d * e * g];
		}

		double d0 = 684.412D;
		double d1 = 684.412D;
		this.noiseData4 = this.noiseGen4.generateNoiseOctaves(this.noiseData4, a, c, d, g, 1.121D, 1.121D, 0.5D);
		this.noiseData5 = this.noiseGen5.generateNoiseOctaves(this.noiseData5, a, c, d, g, 200.0D, 200.0D, 0.5D);
		d0 *= 2.0D;
		this.noiseData1 = this.noiseGen3.generateNoiseOctaves(this.noiseData1, a, b, c, d, e, g, d0 / 80.0D, d1 / 160.0D, d0 / 80.0D);
		this.noiseData2 = this.noiseGen1.generateNoiseOctaves(this.noiseData2, a, b, c, d, e, g, d0, d1, d0);
		this.noiseData3 = this.noiseGen2.generateNoiseOctaves(this.noiseData3, a, b, c, d, e, g, d0, d1, d0);
		int k1 = 0;
		int l1 = 0;

		for (int i2 = 0; i2 < d; ++i2) {
			for (int j2 = 0; j2 < g; ++j2) {
				double d2 = (this.noiseData4[l1] + 256.0D) / 512.0D;

				if (d2 > 1.0D) {
					d2 = 1.0D;
				}

				double d3 = this.noiseData5[l1] / 8000.0D;

				if (d3 < 0.0D) {
					d3 = -d3 * 0.3D;
				}

				d3 = d3 * 3.0D - 2.0D;
				float f = (float) (i2 + a) / 1.0F;
				float f1 = (float) (j2 + c) / 1.0F;
				float f2 = 100.0F - MathHelper.sqrt_float(f * f + f1 * f1) * 8.0F;

				if (f2 > 80.0F) {
					f2 = 80.0F;
				}

				if (f2 < -100.0F) {
					f2 = -100.0F;
				}

				if (d3 > 1.0D) {
					d3 = 1.0D;
				}

				d3 /= 8.0D;
				d3 = 0.0D;

				if (d2 < 0.0D) {
					d2 = 0.0D;
				}

				d2 += 0.5D;
				d3 = d3 * (double) e / 16.0D;
				++l1;
				double d4 = (double) e / 2.0D;

				for (int k2 = 0; k2 < e; ++k2) {
					double d5 = 0.0D;
					double d6 = ((double) k2 - d4) * 8.0D / d2;

					if (d6 < 0.0D) {
						d6 *= -1.0D;
					}

					double d7 = this.noiseData2[k1] / 512.0D;
					double d8 = this.noiseData3[k1] / 512.0D;
					double d9 = (this.noiseData1[k1] / 10.0D + 1.0D) / 2.0D;

					if (d9 < 0.0D) {
						d5 = d7;
					} else if (d9 > 1.0D) {
						d5 = d8;
					} else {
						d5 = d7 + (d8 - d7) * d9;
					}

					d5 -= 8.0D;
					d5 += (double) f2;
					byte b0 = 2;
					double d10;

					if (k2 > e / 2 - b0) {
						d10 = (double) ((float) (k2 - (e / 2 - b0)) / 64.0F);

						if (d10 < 0.0D) {
							d10 = 0.0D;
						}

						if (d10 > 1.0D) {
							d10 = 1.0D;
						}

						d5 = d5 * (1.0D - d10) + -3000.0D * d10;
					}

					b0 = 8;

					if (k2 < b0) {
						d10 = (double) ((float) (b0 - k2) / ((float) b0 - 1.0F));
						d5 = d5 * (1.0D - d10) + -30.0D * d10;
					}

					noise[k1] = d5;
					++k1;
				}
			}
		}

		return noise;
	}

	@Override
	public boolean chunkExists(int x, int z) {
		return true;
	}

	@Override
	public void populate(IChunkProvider provider, int x, int y) {
		BlockFalling.fallInstantly = true;
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(provider, endWorld, endWorld.rand, x, y, false));
		int k = x * 16;
		int l = y * 16;
		BiomeGenBase biomegenbase = this.endWorld.getBiomeGenForCoords(k + 16, l + 16);
		biomegenbase.decorate(this.endWorld, this.endWorld.rand, k, l);
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(provider, endWorld, endWorld.rand, x, y, false));
		BlockFalling.fallInstantly = false;

	}

	@Override
	public boolean saveChunks(boolean b, IProgressUpdate prog) {
		return true;
	}

	@Override
	public void saveExtraData() {}

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public boolean canSave() {
		return true;
	}

	@Override
	public String makeString() {
		return "RandomLevelSource";
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType type, int x, int y, int z) {
		BiomeGenBase biomegenbase = this.endWorld.getBiomeGenForCoords(x, z);
		return biomegenbase.getSpawnableList(type);
	}

	@Override
	public ChunkPosition func_147416_a(World world, String name, int x, int y, int z) {
		return null;
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void recreateStructures(int x, int z) {}
}