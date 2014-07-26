package mods.fossil.gens.structure;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

import java.util.List;
import java.util.Random;

public class ComponentDigSiteTent01 extends StructureVillagePieces.Village
{
    private int averageGroundLevel = -1;
    private static final int HEIGHT = 2;

    public ComponentDigSiteTent01(StructureVillagePieces.Start par1StructureVillagePieces, int componentType, Random par3Random, StructureBoundingBox par4StructureBoundingBox, int par5)
    {
        super(par1StructureVillagePieces, componentType);
        this.coordBaseMode = par5;
        this.boundingBox = par4StructureBoundingBox;
    }

    public static ComponentDigSiteTent01 buildComponent(StructureVillagePieces.Start startPiece, List par1List, Random random, int par3, int par4, int par5, int par6, int par7)
    {
        StructureBoundingBox var8 = StructureBoundingBox.getComponentToAddBoundingBox(par3, par4, par5, 0, 0, 0, 12, HEIGHT, 10, par6);
        return canVillageGoDeeper(var8) && StructureComponent.findIntersecting(par1List, var8) == null ? new ComponentDigSiteTent01(startPiece, par7, random, var8, par6) : null;
    }

    // this method create house
    public boolean addComponentParts(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox)
    {
        if (this.averageGroundLevel < 0)
        {
            this.averageGroundLevel = this.getAverageGroundLevel(par1World, par3StructureBoundingBox);

            if (this.averageGroundLevel < 0)
            {
                return true;
            }

            this.boundingBox.offset(0, this.averageGroundLevel - this.boundingBox.maxY + HEIGHT - 1, 0);
        }

        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 1, 1, 7, 5, 4, Blocks.air,       Blocks.air,         false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 0, 0, 8, 0, 5, Blocks.glowstone, Blocks.cobblestone, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 5, 0, 8, 5, 5, Blocks.glowstone, Blocks.cobblestone, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 6, 1, 8, 6, 4, Blocks.glowstone, Blocks.cobblestone, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 7, 2, 8, 7, 3, Blocks.glowstone, Blocks.cobblestone, false);
        /*
        int i = this.getMetadataWithOffset(Block.getIdFromBlock(Blocks.oak_stairs), 3);
        int j = this.getMetadataWithOffset(Block.getIdFromBlock(Blocks.oak_stairs), 2);
        int k;
        int l;

        for (k = -1; k <= 2; ++k)
        {
            for (l = 0; l <= 8; ++l)
            {
                this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.oak_stairs), i, l, 6 + k, k, par3StructureBoundingBox);
                this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.oak_stairs), j, l, 6 + k, 5 - k, par3StructureBoundingBox);
            }
        }

        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 1, 0, 0, 1, 5, Block.getIdFromBlock(Blocks.glowstone), Block.getIdFromBlock(Blocks.cobblestone), false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 1, 5, 8, 1, 5, Block.getIdFromBlock(Blocks.glowstone), Block.getIdFromBlock(Blocks.cobblestone), false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 8, 1, 0, 8, 1, 4, Block.getIdFromBlock(Blocks.glowstone), Block.getIdFromBlock(Blocks.cobblestone), false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 1, 0, 7, 1, 0, Block.getIdFromBlock(Blocks.glowstone), Block.getIdFromBlock(Blocks.cobblestone), false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, 0, 0, 4, 0, Block.getIdFromBlock(Blocks.glowstone), Block.getIdFromBlock(Blocks.cobblestone), false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, 5, 0, 4, 5, Block.getIdFromBlock(Blocks.glowstone), Block.getIdFromBlock(Blocks.cobblestone), false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 8, 2, 5, 8, 4, 5, Block.getIdFromBlock(Blocks.glowstone), Block.getIdFromBlock(Blocks.cobblestone), false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 8, 2, 0, 8, 4, 0, Block.getIdFromBlock(Blocks.glowstone), Block.getIdFromBlock(Blocks.cobblestone), false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, 1, 0, 4, 4, Block.getIdFromBlock(Blocks.planks), Block.getIdFromBlock(Blocks.planks), false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 2, 5, 7, 4, 5, Block.getIdFromBlock(Blocks.planks), Block.getIdFromBlock(Blocks.planks), false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 8, 2, 1, 8, 4, 4, Block.getIdFromBlock(Blocks.planks), Block.getIdFromBlock(Blocks.planks), false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 2, 0, 7, 4, 0, Block.getIdFromBlock(Blocks.planks), Block.getIdFromBlock(Blocks.planks), false);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.glass_pane), 0, 4, 2, 0, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.glass_pane), 0, 5, 2, 0, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.glass_pane), 0, 6, 2, 0, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.glass_pane), 0, 4, 3, 0, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.glass_pane), 0, 5, 3, 0, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.glass_pane), 0, 6, 3, 0, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.glass_pane), 0, 0, 2, 2, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.glass_pane), 0, 0, 2, 3, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.glass_pane), 0, 0, 3, 2, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.glass_pane), 0, 0, 3, 3, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.glass_pane), 0, 8, 2, 2, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.glass_pane), 0, 8, 2, 3, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.glass_pane), 0, 8, 3, 2, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.glass_pane), 0, 8, 3, 3, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.glass_pane), 0, 2, 2, 5, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.glass_pane), 0, 3, 2, 5, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.glass_pane), 0, 5, 2, 5, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.glass_pane), 0, 6, 2, 5, par3StructureBoundingBox);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 4, 1, 7, 4, 1, Block.getIdFromBlock(Blocks.planks), Block.getIdFromBlock(Blocks.planks), false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 4, 4, 7, 4, 4, Block.getIdFromBlock(Blocks.planks), Block.getIdFromBlock(Blocks.planks), false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 3, 4, 7, 3, 4, Block.getIdFromBlock(Blocks.bookshelf), Block.getIdFromBlock(Blocks.bookshelf), false);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.planks), 0, 7, 1, 4, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.oak_stairs), this.getMetadataWithOffset(Block.getIdFromBlock(Blocks.oak_stairs), 0), 7, 1, 3, par3StructureBoundingBox);
        k = this.getMetadataWithOffset(Block.getIdFromBlock(Blocks.oak_stairs), 3);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.oak_stairs), k, 6, 1, 4, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.oak_stairs), k, 5, 1, 4, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.oak_stairs), k, 4, 1, 4, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.oak_stairs), k, 3, 1, 4, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.fence), 0, 6, 1, 3, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.wooden_pressure_plate), 0, 6, 2, 3, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.fence), 0, 4, 1, 3, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.wooden_pressure_plate), 0, 4, 2, 3, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Blocks.crafting_table), 0, 7, 1, 1, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, 0, 0, 1, 1, 0, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, 0, 0, 1, 2, 0, par3StructureBoundingBox);
        this.placeDoorAtCurrentPosition(par1World, par3StructureBoundingBox, par2Random, 1, 1, 0, this.getMetadataWithOffset(Block.getIdFromBlock(Blocks.wooden_door), 1));

        if (this.getBlockIdAtCurrentPosition(par1World, 1, 0, -1, par3StructureBoundingBox) == 0 && this.getBlockIdAtCurrentPosition(par1World, 1, -1, -1, par3StructureBoundingBox) != 0)
        {
            this.placeBlockAtCurrentPosition(par1World, Block.getIdFromBlock(Block.stairsCobblestone), this.getMetadataWithOffset(Block.getIdFromBlock(Block.stairsCobblestone), 3), 1, 0, -1, par3StructureBoundingBox);
        }

        for (l = 0; l < 6; ++l)
        {
            for (int i1 = 0; i1 < 9; ++i1)
            {
                this.clearCurrentPositionBlocksUpwards(par1World, i1, 9, l, par3StructureBoundingBox);
                this.fillCurrentPositionBlocksDownwards(par1World, Block.getIdFromBlock(Blocks.cobblestone), 0, i1, -1, l, par3StructureBoundingBox);
            }
        }
        */
        this.spawnVillagers(par1World, par3StructureBoundingBox, 2, 1, 2, 1);
        return true;
    }

    // add this method if villagers will be spawn in your building
    protected int getVillagerType(int par1)
    {
        return 10;
    }
}
