package fossilsarcheology.server.gen.structure.temple;

import fossilsarcheology.server.gen.structure.academy.AcademyUtil;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class Temple1 {
    /*
     * For directional blocks (relative to direction of generation): 0 - Facing
	 * Right 1 - Left 2 - Towards 3 - Away 4 - Upside Down Right 5 - Upside Down
	 * Left 6 - Upside Down Towards 7 - Upside Down Away
	 */
    public static final int RIGHT = 0;
    public static final int LEFT = 1;
    public static final int TOWARDS = 2;
    public static final int AWAY = 3;
    public static final int INVERT_RIGHT = 4;
    public static final int INVERT_LEFT = 5;
    public static final int INVERT_TOWARDS = 6;
    public static final int INVERT_AWAY = 7;
    // {TempleUtil.CUSTOM_RELIC, 0, 2, 0},
    public static final int[][][][] blockArrayTemple = {{ // y = 1
            { // x = 1
                    {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 2
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 3
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 4
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 5
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 6
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {}, {}, {}, {}, {}}, { // x
            // =
            // 7
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {}, {}, {}, {}, {}}, { // x
            // =
            // 8
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {}, {}, {}, {}, {}}, { // x
            // =
            // 9
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {}, {}, {}, {}, {}}, { // x
            // =
            // 10
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {}, {}, {}, {}, {}}, { // x
            // =
            // 11
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {}, {}, {}, {}, {}}, { // x
            // =
            // 12
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {}, {}, {}, {}, {}}, { // x
            // =
            // 13
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {}, {}, {}, {}, {}}, { // x
            // =
            // 14
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.gold_block)}, // center
            {Block.getIdFromBlock(Blocks.gold_block)}, // center
            {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {}, {}, {}, {}, {}}, { // x
            // =
            // 15
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.gold_block)}, // center
            {Block.getIdFromBlock(Blocks.gold_block)}, // center
            {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {}, {}, {}, {}, {}}, { // x
            // =
            // 16
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {}, {}, {}, {}, {}}, { // x
            // =
            // 17
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {}, {}, {}, {}, {}}, { // x
            // =
            // 18
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {}, {}, {}, {}, {}}, { // x
            // =
            // 19
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {}, {}, {}, {}, {}}, { // x
            // =
            // 20
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {}, {}, {}, {}, {}}, { // x
            // =
            // 21
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {}, {}, {}, {}, {}}, { // x
            // =
            // 22
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {}, {}, {}, {}, {}}, { // x
            // =
            // 23
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.mossy_cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {Block.getIdFromBlock(Blocks.cobblestone)}, {}, {}, {}, {}, {}}, { // x
            // =
            // 24
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 25
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 26
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 27
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 28
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}}, { // y
            // =
            // 2
            { // x = 1
                    {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 2
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 3
            {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}}, { // x
            // =
            // 4
            {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}}, { // x
            // =
            // 5
            {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}}, { // x
            // =
            // 6
            {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}}, { // x=
            // 7
            {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}}, { // x
            // =
            // 8
            {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, // {Block.getIdFromBlock(Blocks.ladder),
            // LEFT},
            {0}, // {Block.getIdFromBlock(Blocks.ladder),
            // LEFT},
            {0}, {0}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}}, { // x
            // =
            // 9
            {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}}, { // x
            // =
            // 10
            {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}}, { // x
            // =
            // 11
            {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}}, { // x
            // =
            // 12
            {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {0}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {AcademyUtil.CUSTOM_CHEST, 4, AcademyUtil.TEMPLE_RARE_LOOT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}}, { // x
            // =
            // 13
            {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}}, { // x
            // =
            // 14
            {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {AcademyUtil.CUSTOM_CHEST, 4, AcademyUtil.TEMPLE_COMMON_LOOT}, // center
            {0}, // center
            {0}, {0}, {0}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}}, { // x
            // =
            // 15
            {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}}, { // x
            // =
            // 16
            {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}}, { // x
            // =
            // 17
            {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {0}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}}, { // x
            // =
            // 18
            {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {0}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}}, { // x
            // =
            // 19
            {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}}, { // x
            // =
            // 20
            {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}}, { // x
            // =
            // 21
            {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}}, { // x
            // =
            // 22
            {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}}, { // x
            // =
            // 23
            {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}}, { // x
            // =
            // 24
            {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}}, { // x
            // =
            // 25
            {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}}, { // x
            // =
            // 26
            {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}}, { // x
            // =
            // 27
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 28
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}}, { // y
            // =
            // 3
            { // x = 1
                    {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 2
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 3
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {}, {}}, { // x
            // =
            // 4
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}}, { // x
            // =
            // 5
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}}, { // x
            // =
            // 6
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}}, { // x
            // =
            // 7
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}}, { // x
            // =
            // 8
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, // {Block.getIdFromBlock(Blocks.ladder),
            // LEFT},
            {0}, // {Block.getIdFromBlock(Blocks.ladder),
            // LEFT},
            {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}}, { // x
            // =
            // 9
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}}, { // x
            // =
            // 10
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}}, { // x
            // =
            // 11
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.monster_egg), 2}, {Block.getIdFromBlock(Blocks.monster_egg), 2}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.monster_egg), 2}, {Block.getIdFromBlock(Blocks.monster_egg), 2}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}}, { // x
            // =
            // 12
            {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.monster_egg), 2}, {Block.getIdFromBlock(Blocks.monster_egg), 2}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.monster_egg), 2}, {Block.getIdFromBlock(Blocks.monster_egg), 2}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}}, { // x
            // =
            // 13
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}}, { // x
            // =
            // 14
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}}, { // x
            // =
            // 15
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}}, { // x
            // =
            // 16
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}}, { // x
            // =
            // 17
            {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.monster_egg), 2}, {Block.getIdFromBlock(Blocks.monster_egg), 2}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.monster_egg), 2}, {Block.getIdFromBlock(Blocks.monster_egg), 2}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}}, { // x
            // =
            // 18
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.monster_egg), 2}, {Block.getIdFromBlock(Blocks.monster_egg), 2}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.monster_egg), 2}, {Block.getIdFromBlock(Blocks.monster_egg), 2}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}}, { // x
            // =
            // 19
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}}, { // x
            // =
            // 20
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}}, { // x
            // =
            // 21
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}}, { // x
            // =
            // 22
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}}, { // x
            // =
            // 23
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}}, { // x
            // =
            // 24
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}}, { // x
            // =
            // 25
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}}, { // x
            // =
            // 26
            {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {}, {}}, { // x
            // =
            // 27
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 28
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}}, { // y
            // =
            // 4
            { // x = 1
                    {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 2
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 3
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 4
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 5
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}}, { // x
            // =
            // 6
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}}, { // x
            // =
            // 7
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}}, { // x
            // =
            // 8
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, // {Block.getIdFromBlock(Blocks.ladder),
            // LEFT},
            {0}, // {Block.getIdFromBlock(Blocks.ladder),
            // LEFT},
            {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}}, { // x
            // =
            // 9
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}}, { // x
            // =
            // 10
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}}, { // x
            // =
            // 11
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}}, { // x
            // =
            // 12
            {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}}, { // x
            // =
            // 13
            {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}}, { // x
            // =
            // 14
            {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}}, { // x
            // =
            // 15
            {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}}, { // x
            // =
            // 16
            {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}}, { // x
            // =
            // 17
            {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}}, { // x
            // =
            // 18
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}}, { // x
            // =
            // 19
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}}, { // x
            // =
            // 20
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}}, { // x
            // =
            // 21
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}}, { // x
            // =
            // 22
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}}, { // x
            // =
            // 23
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}}, { // x
            // =
            // 24
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}}, { // x
            // =
            // 25
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 26
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 27
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 28
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}}};
}