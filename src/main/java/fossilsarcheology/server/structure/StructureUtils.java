package fossilsarcheology.server.structure;

import fossilsarcheology.server.world.FAWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.Random;

public class StructureUtils {

    public static boolean generateStructureAtWithRandomRotation(ResourceLocation structure, World world, BlockPos pos, Random random, boolean checkGround, boolean removeAir) {
        Rotation rotation = Rotation.values()[random.nextInt(Rotation.values().length)];
        Mirror mirror = Mirror.values()[random.nextInt(Mirror.values().length)];
        MinecraftServer server = world.getMinecraftServer();
        TemplateManager templateManager = world.getSaveHandler().getStructureTemplateManager();
        PlacementSettings settings = new PlacementSettings().setRotation(rotation).setMirror(mirror);
        if (removeAir) {
            settings.setReplacedBlock(Blocks.AIR);
        }
        Template template = templateManager.getTemplate(server, structure);
        BlockPos center = pos;
        switch(rotation){
            case NONE:
                center = pos;
                break;
            case CLOCKWISE_90:
                center = pos.add(template.getSize().getZ() - 1, 0, 0);
                break;
            case COUNTERCLOCKWISE_90:
                center = pos.add(0, 0, template.getSize().getX() - 1);
                break;
            case CLOCKWISE_180:
                center = pos.add(template.getSize().getX() - 1, 0, template.getSize().getZ() - 1);
        }
        if (checkGround) {
            BlockPos corner1 = pos.down();
            BlockPos corner2 = pos.add(template.getSize().getX(), -1, 0);
            BlockPos corner3 = pos.add(template.getSize().getX(), -1, template.getSize().getZ());
            BlockPos corner4 = pos.add(0, -1, template.getSize().getZ());
            if (world.getBlockState(center).isOpaqueCube() && world.getBlockState(corner1).isOpaqueCube() && world.getBlockState(corner2).isOpaqueCube() && world.getBlockState(corner3).isOpaqueCube() && world.getBlockState(corner4).isOpaqueCube()) {
                template.addBlocksToWorldChunk(world, center, settings);
                return true;
            }
            return false;
        } else {
            template.addBlocksToWorldChunk(world, center, settings);
            return true;
        }
    }

    public static void generateStructureAtWithRandomRotationWithLoot(ResourceLocation structure, ResourceLocation loot, World world, BlockPos pos, Random random, boolean checkGround, boolean removeAir) {
        Rotation rotation = Rotation.values()[random.nextInt(Rotation.values().length)];
        Mirror mirror = Mirror.values()[random.nextInt(Mirror.values().length)];
        MinecraftServer server = world.getMinecraftServer();
        TemplateManager templateManager = world.getSaveHandler().getStructureTemplateManager();
        PlacementSettings settings = new PlacementSettings().setRotation(rotation).setMirror(mirror);
        if (removeAir) {
            settings.setReplacedBlock(Blocks.AIR);
        }
        Template template = templateManager.getTemplate(server, structure);
        BlockPos center = pos;
        switch(rotation){
            case NONE:
                center = pos;
                break;
            case CLOCKWISE_90:
                center = pos.add(template.getSize().getZ() - 1, 0, 0);
                break;
            case COUNTERCLOCKWISE_90:
                center = pos.add(0, 0, template.getSize().getX() - 1);
                break;
            case CLOCKWISE_180:
                center = pos.add(template.getSize().getX() - 1, 0, template.getSize().getZ() - 1);
        }
        if (checkGround) {
            BlockPos corner1 = pos.down();
            BlockPos corner2 = pos.add(template.getSize().getX(), -1, 0);
            BlockPos corner3 = pos.add(template.getSize().getX(), -1, template.getSize().getZ());
            BlockPos corner4 = pos.add(0, -1, template.getSize().getZ());
            if (world.getBlockState(center).isOpaqueCube() && world.getBlockState(corner1).isOpaqueCube() && world.getBlockState(corner2).isOpaqueCube() && world.getBlockState(corner3).isOpaqueCube() && world.getBlockState(corner4).isOpaqueCube()) {
                template.addBlocksToWorld(world, center, new FABlockProcessorLoot(center, settings, loot), settings, 2);
            }
        } else {
            template.addBlocksToWorld(world, center, new FABlockProcessorLoot(center, settings, loot), settings, 2);
        }
    }


    public static boolean generateStructureAtWithRotation(ResourceLocation structure, World world, BlockPos pos, Random random, Rotation rotation, boolean checkGround, boolean removeAir) {
        Mirror mirror = Mirror.values()[random.nextInt(Mirror.values().length)];
        MinecraftServer server = world.getMinecraftServer();
        TemplateManager templateManager = world.getSaveHandler().getStructureTemplateManager();
        PlacementSettings settings = new PlacementSettings().setRotation(rotation).setMirror(Mirror.NONE);
        if (removeAir) {
            settings.setReplacedBlock(Blocks.AIR);
        }
        Template template = templateManager.getTemplate(server, structure);
        BlockPos center = pos;
        switch(rotation){
            case NONE:
                center = pos;
                break;
            case CLOCKWISE_90:
                center = pos.add(template.getSize().getZ() - 1, 0, 0);
                break;
            case COUNTERCLOCKWISE_90:
                center = pos.add(0, 0, template.getSize().getX() - 1);
                break;
            case CLOCKWISE_180:
                center = pos.add(template.getSize().getX() - 1, 0, template.getSize().getZ() - 1);
        }
        if (checkGround) {
            BlockPos corner1 = pos.down();
            BlockPos corner2 = pos.add(template.getSize().getX(), -1, 0);
            BlockPos corner3 = pos.add(template.getSize().getX(), -1, template.getSize().getZ());
            BlockPos corner4 = pos.add(0, -1, template.getSize().getZ());
            if (world.getBlockState(center).isOpaqueCube() && world.getBlockState(corner1).isOpaqueCube() && world.getBlockState(corner2).isOpaqueCube() && world.getBlockState(corner3).isOpaqueCube() && world.getBlockState(corner4).isOpaqueCube()) {
                template.addBlocksToWorldChunk(world, center, settings);
                return true;
            }
            return false;
        } else {
            template.addBlocksToWorldChunk(world, center, settings);
            return true;
        }
    }

    public static boolean generateStructureAtWithRotationWithLoot(ResourceLocation structure, ResourceLocation loot, World world, BlockPos pos, Random random, Rotation rotation, boolean checkGround, boolean removeAir) {
        Mirror mirror = Mirror.values()[random.nextInt(Mirror.values().length)];
        MinecraftServer server = world.getMinecraftServer();
        TemplateManager templateManager = world.getSaveHandler().getStructureTemplateManager();
        PlacementSettings settings = new PlacementSettings().setRotation(rotation).setMirror(Mirror.NONE);
        if (removeAir) {
            settings.setReplacedBlock(Blocks.AIR);
        }
        Template template = templateManager.getTemplate(server, structure);
        BlockPos center = pos.add(template.getSize().getX() / 2, 0, template.getSize().getZ() / 2);
        if (checkGround) {
            BlockPos corner1 = pos.down();
            BlockPos corner2 = pos.add(template.getSize().getX(), -1, 0);
            BlockPos corner3 = pos.add(template.getSize().getX(), -1, template.getSize().getZ());
            BlockPos corner4 = pos.add(0, -1, template.getSize().getZ());
            if (world.getBlockState(center).isOpaqueCube() && world.getBlockState(corner1).isOpaqueCube() && world.getBlockState(corner2).isOpaqueCube() && world.getBlockState(corner3).isOpaqueCube() && world.getBlockState(corner4).isOpaqueCube()) {
                template.addBlocksToWorld(world, center, structure == FAWorldGenerator.ANU_CASTLE ? new FABlockProcessorAnu(center, settings, loot) : new FABlockProcessorLoot(center, settings, loot), settings, 2);
                return true;
            }
            return false;
        } else {
            template.addBlocksToWorld(world, center, structure == FAWorldGenerator.ANU_CASTLE ? new FABlockProcessorAnu(center, settings, loot) : new FABlockProcessorLoot(center, settings, loot), settings, 2);
            return true;
        }
    }
}
