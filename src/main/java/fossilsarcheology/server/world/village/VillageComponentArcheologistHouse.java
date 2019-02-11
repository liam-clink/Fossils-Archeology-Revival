package fossilsarcheology.server.world.village;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;

import java.util.List;
import java.util.Random;

public class VillageComponentArcheologistHouse extends StructureVillagePieces.Village {
    private int averageGroundLevel = -1;
    int villagerCount = 0;

    public VillageComponentArcheologistHouse() {
        super();
    }

    public VillageComponentArcheologistHouse(StructureVillagePieces.Start startPiece, int p2, Random random, StructureBoundingBox structureBox, EnumFacing facing) {
        super();
        this.villagerCount = 0;
        this.setCoordBaseMode(facing);
        this.boundingBox = structureBox;
    }

    public static VillageComponentArcheologistHouse buildComponent(StructureVillagePieces.Start startPiece, List<StructureComponent> pieces, Random random, int x, int y, int z, EnumFacing facing, int p5) {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, -1, 11, 12, 14, facing);
        return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null ? new VillageComponentArcheologistHouse(startPiece, p5, random, structureboundingbox, facing) : null;
    }
    @Override
    public boolean addComponentParts(World world, Random random, StructureBoundingBox sbb) {
        if (this.averageGroundLevel < 0) {
            this.averageGroundLevel = this.getAverageGroundLevel(world, sbb);
            if (this.averageGroundLevel < 0) {
                return false;
            }
            this.boundingBox.offset(0, this.averageGroundLevel - this.boundingBox.maxY + 4, 0);
        }
        /*for(int i = this.boundingBox.minX; i < this.boundingBox.maxX; i++){
            for(int j = this.boundingBox.minZ; j < this.boundingBox.maxZ; j++){
                world.setBlockState(new BlockPos(i, this.getYWithOffset(0) + 16, j), Blocks.GLOWSTONE.getDefaultState());
            }
        }*/
        BlockPos blockpos = new BlockPos(this.getXWithOffset(11, -1), this.getYWithOffset(0), this.getZWithOffset(11, -1));
        //world.setBlockState(blockpos.up(16), Blocks.MAGMA.getDefaultState());
        //world.setBlockState(blockpos.up(17), Blocks.FURNACE.getDefaultState().withProperty(BlockFurnace.FACING, this.getCoordBaseMode().getOpposite()));
        EnumFacing facing = this.getCoordBaseMode().getOpposite();
        BlockPos genPos = blockpos.up();
        if(facing == EnumFacing.SOUTH){
            genPos =  genPos.offset(EnumFacing.WEST, 11).offset(EnumFacing.SOUTH, 2);
        }
        return new WorldGenArcheologistHouse(this, facing.rotateY()).generate(world, random, genPos);
    }

    public IBlockState getBiomeBlock(IBlockState state){
        return getBiomeSpecificBlockState(state);
    }

}
