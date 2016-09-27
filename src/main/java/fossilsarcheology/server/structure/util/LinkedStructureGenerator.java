package fossilsarcheology.server.structure.util;

import com.google.common.collect.Lists;
import fossilsarcheology.server.structure.StructureGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class LinkedStructureGenerator {
    private final List<Structure> structures = Lists.newLinkedList();

    private final List<BlockPos> offsets = Lists.newLinkedList();

    private final List<Byte> rotations = Lists.newLinkedList();
    private StructureGeneratorBase generator = null;
    private EnumFacing rotation = EnumFacing.NORTH;

    public <T extends StructureGeneratorBase> void setGenerator(T generator) {
        this.generator = generator;
    }

    public void rotateStructures() {
        this.rotation = this.rotation.rotateY();
    }

    public void setRotation(EnumFacing rotation) {
        this.rotation = rotation;
    }

    public void addStructure(Structure structure) {
        this.addStructureWithOffset(structure, BlockPos.ORIGIN);
    }

    public void addStructureWithOffset(Structure structure, BlockPos pos) {
        this.addStructureWithOffsetAndRotation(structure, pos, EnumFacing.NORTH);
    }

    public void addStructureWithOffsetAndRotation(Structure structure, BlockPos pos, EnumFacing rotation) {
        this.structures.add(structure);
        this.addOffset(pos);
        this.rotations.add((byte) rotation.getHorizontalIndex());
    }

    private void addOffset(BlockPos offset) {
        this.offsets.add(StructureHelper.getRotatedPosition(offset));
    }

    public void setLastOffset(BlockPos pos) {
        if (!this.structures.isEmpty()) {
            if (this.offsets.size() < this.structures.size()) {
                this.addOffset(pos);
            } else {
                this.offsets.set(this.offsets.size() - 1, StructureHelper.getRotatedPosition(pos));
            }
        }
    }

    public void setLastRotation(int rotation) {
        if (!this.rotations.isEmpty()) {
            this.rotations.set(this.rotations.size() - 1, (byte) (rotation % 4));
        }
    }

    public void generateLinkedStructures(World world, Random random, BlockPos pos) {
        this.generateLinkedStructures(null, world, random, pos);
    }

    public void generateLinkedStructures(EntityPlayer player, World world, Random random, BlockPos pos) {
        int i = 0;
        if (this.structures.size() != this.offsets.size() || this.structures.size() != this.rotations.size()) {
            System.err.println("Structure List and Offset List are not the same size, aborting generation.");
            return;
        }
        if (this.generator == null) {
            this.generator = new StructureGenerator();
        }
        if (player != null) {
            this.generator.setPlayerFacing(player);
        }
        this.setOffsetFromRotation(player != null ? this.generator.getPlayerFacing() : null);
        for (Structure structure : this.structures) {
            BlockPos offset = this.offsets.get(i);
            this.generator.setStructureWithRotation(structure, (this.rotation.getHorizontalIndex() + this.rotations.get(i)) % 4);
            this.generator.generate(world, random, pos.add(offset).up(structure.getOffsetY()));
            ++i;
        }
    }

    private void setOffsetFromRotation(EnumFacing facing) {
        if (facing != null) {
            for (int i = 0; i < this.offsets.size(); i++) {
                BlockPos offset = this.offsets.get(i);
                for (int rotation = 0; rotation < facing.getHorizontalIndex(); ++rotation) {
                    this.offsets.set(i, StructureHelper.getRotatedPosition(offset));
                }
            }
        }
    }
}
