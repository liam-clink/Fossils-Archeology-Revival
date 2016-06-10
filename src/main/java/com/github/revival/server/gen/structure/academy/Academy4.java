package com.github.revival.server.gen.structure.academy;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class Academy4 {
    public static final int[][][][] blockArrayAcademy = {
            // This is where all the x, y, z values go (i, j, k). They are broke
            // down by
            // layer. This is how the array works building from x to z and by
            // layer y,
            // then they are finished by removing all the world.setBlock and
            // x, y, z coordinates leaving something like this
            // {Block.getIdFromBlock(Blocks.stone)},
            {
                    // y = 15
                    {
                            // x = 0
                            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},}, {
                    // x = 1
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
                    // x = 2
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.glass_pane)}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
                    // x = 3
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
                    // x = 4
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
                    // x = 5
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
                    // x = 6
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
                    // x = 7
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {},}, {
                    // x = 8
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.stone_slab), 5}, {Block.getIdFromBlock(Blocks.stone_slab), 5}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {},}, {
                    // x = 9
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
                    // x = 10
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
                    // x = 11
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_slab), 5}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
                    // x = 12
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_slab), 5}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
                    // x = 13
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
                    // x = 14
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.web)}, {},}, {
                    // x = 15
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.stone_slab), 5}, {Block.getIdFromBlock(Blocks.stone_slab), 5}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {},}, {
                    // x = 16
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {},}, {
                    // x = 17
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
                    // x = 18
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
                    // x = 19
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
                    // x = 20
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {},}, {
                    // x = 21
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick), 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.glass_pane)}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {},}, {
                    // x = 22
                    {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.stonebrick), 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {},}, {
                    // x = 23
                    {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},}}, {
            // y = 16
            {
                    // x = 0
                    {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},}, {
            // x = 1
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 2
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 3
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.bed), 9}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick), 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 4
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.bed), 1}, {0}, {0}, {Block.getIdFromBlock(Blocks.bed)}, {Block.getIdFromBlock(Blocks.bed), 8}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 5
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 6
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.bed)}, {Block.getIdFromBlock(Blocks.bed), 8}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 7
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.bookshelf)}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {},}, {
            // x = 8
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.crafting_table)}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.bed)}, {Block.getIdFromBlock(Blocks.bed), 8}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {},}, {
            // x = 9
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.enchanting_table)}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 10
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.furnace), 3}, {0}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 11
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.wooden_door), 4}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.wooden_door), 3}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 12
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.wooden_door), 6}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.wooden_door), 6}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 13
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 14
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.ladder), 3}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 15
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.CUSTOM_CHEST, 3, AcademyUtil.RARE_LOOT_F3}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.bed)}, {Block.getIdFromBlock(Blocks.bed), 8}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {},}, {
            // x = 16
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.jukebox), 1}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {},}, {
            // x = 17
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.bed)}, {Block.getIdFromBlock(Blocks.bed), 8}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 18
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 19
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.bed), 3}, {0}, {0}, {Block.getIdFromBlock(Blocks.bed)}, {Block.getIdFromBlock(Blocks.bed), 8}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 20
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.bed), 11}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {},}, {
            // x = 21
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick), 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {},}, {
            // x = 22
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {},}, {
            // x = 23
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},}}, {
            // y = 17
            {
                    // x = 0
                    {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},}, {
            // x = 1
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},}, {
            // x = 2
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.glass_pane)}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 3
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 4
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.glass_pane)}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 5
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 6
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 7
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.bookshelf)}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {},}, {
            // x = 8
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.glass_pane)}, {0}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {},}, {
            // x = 9
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.glass_pane)}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 10
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 11
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.wooden_door), 12}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.wooden_door), 11}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 12
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.wooden_door), 9}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.wooden_door), 14}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 13
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 14
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.ladder), 3}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.glass_pane)}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 15
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.glass_pane)}, {0}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {},}, {
            // x = 16
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {},}, {
            // x = 17
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 18
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 19
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.glass_pane)}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 20
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 21
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.glass_pane)}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 22
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},}, {
            // x = 23
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},}}, {
            // y = 18
            {
                    // x = 0
                    {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},}, {
            // x = 1
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},}, {
            // x = 2
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.glass_pane)}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {},}, {
            // x = 3
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {Block.getIdFromBlock(Blocks.glowstone)}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 4
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.glass_pane)}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 5
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 6
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 7
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.bookshelf)}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {},}, {
            // x = 8
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.glass_pane)}, {0}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {AcademyUtil.BIOME_BLOCK, 0, 1, 0}, {},}, {
            // x = 9
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.glass_pane)}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 10
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.glowstone)}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.glowstone)}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.glowstone)}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 11
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 12
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 13
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.glowstone)}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.glowstone)}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.glowstone)}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 14
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.ladder), 3}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.glass_pane)}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 15
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.glass_pane)}, {0}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 16
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 17
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 18
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 19
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.glass_pane)}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 20
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {Block.getIdFromBlock(Blocks.glowstone)}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 21
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.glass_pane)}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {},}, {
            // x = 22
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},}, {
            // x = 23
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},}}, {
            // y = 19
            {
                    // x = 0
                    {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},}, {
            // x = 1
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},}, {
            // x = 2
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {},}, {
            // x = 3
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {},}, {
            // x = 4
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 5
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 6
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 7
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.glowstone)}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 8
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 9
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 10
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.fence)}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.fence)}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.fence)}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 11
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 12
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 13
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.fence)}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.fence)}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.fence)}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 14
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.ladder), 3}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {},}, {
            // x = 15
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.web)}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 16
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {0}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 17
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {Block.getIdFromBlock(Blocks.glowstone)}, {0}, {0}, {0}, {0}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 18
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 19
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {},}, {
            // x = 20
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {},}, {
            // x = 21
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {AcademyUtil.BIOME_BLOCK, 0, 2, 2}, {}, {}, {}, {}, {},}, {
            // x = 22
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},}, {
            // x = 23
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},}}};
}
