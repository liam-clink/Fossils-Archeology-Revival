package fossilsarcheology.server.structure.util;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

import java.util.LinkedList;
import java.util.List;

public class Structure {
    public final String name;

    private final List<Object[][][][]> blockArrayList = new LinkedList<>();

    private EnumFacing facing = EnumFacing.EAST;
    private BlockPos offset = BlockPos.ORIGIN;

    public Structure() {
        this.name = "";
    }

    public Structure(String name) {
        this.name = name;
    }

    public final List<Object[][][][]> blockArrayList() {
        return this.blockArrayList;
    }

    public final EnumFacing getFacing() {
        return this.facing;
    }

    public final void setFacing(EnumFacing facing) {
        this.facing = facing;
    }

    public final void addBlockArray(Object blocks[][][][]) {
        this.blockArrayList.add(blocks);
    }

    public final void addBlockArrayList(List<Object[][][][]> blocks) {
        this.blockArrayList.addAll(blocks);
    }

    public final int getSizeX() {
        return this.blockArrayList.size() > 0 ? this.blockArrayList.get(0)[0].length : 0;
    }

    public final int getSizeZ() {
        return this.blockArrayList != null ? this.blockArrayList.get(0)[0][0].length : 0;
    }

    public final int getHeight() {
        int height = 0;
        for (Object[][][][] blockArray : this.blockArrayList) {
            height += blockArray.length;
        }
        return height;
    }

    public final BlockPos getOffset() {
        return this.offset;
    }

    public final void setStructureOffset(BlockPos offset) {
        this.offset = offset;
    }
}
