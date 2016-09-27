package fossilsarcheology.server.structure.util;

import net.minecraft.util.math.BlockPos;

import java.nio.ByteBuffer;

public class BlockData {
    private BlockPos position;
    private CustomBlock customBlock;
    private ByteBuffer data;

    public BlockData(BlockPos position, CustomBlock customBlock, ByteBuffer data) {
        this.position = position;
        this.customBlock = customBlock;
        this.data = data;
    }

    public BlockPos getPosition() {
        return this.position;
    }

    public CustomBlock getCustomBlock() {
        return this.customBlock;
    }

    public ByteBuffer getData() {
        return this.data;
    }
}
