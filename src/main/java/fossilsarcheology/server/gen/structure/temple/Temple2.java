package fossilsarcheology.server.gen.structure.temple;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class Temple2 {

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

    public static final int[][][][] blockArrayTemple = {{ // y = 5
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
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 5
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {}, {}, {}, {}}, { // x
            // =
            // 6
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}}, { // x
            // =
            // 7
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}}, { // x
            // =
            // 8
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, // {Block.getIdFromBlock(Blocks.ladder),
            // RIGHT},
            {0}, // {Block.getIdFromBlock(Blocks.ladder),
            // RIGHT},
            {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}}, { // x
            // =
            // 9
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}}, { // x
            // =
            // 10
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}}, { // x
            // =
            // 11
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}}, { // x
            // =
            // 12
            {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}}, { // x
            // =
            // 13
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}}, { // x
            // =
            // 14
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}}, { // x
            // =
            // 15
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}}, { // x
            // =
            // 16
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}}, { // x
            // =
            // 17
            {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}}, { // x
            // =
            // 18
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}}, { // x
            // =
            // 19
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}}, { // x
            // =
            // 20
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}}, { // x
            // =
            // 21
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}}, { // x
            // =
            // 22
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}}, { // x
            // =
            // 23
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}}, { // x
            // =
            // 24
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {}, {}, {}, {}}, { // x
            // =
            // 25
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
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
            // 6
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
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 6
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 7
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 8
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, // {Block.getIdFromBlock(Blocks.ladder),
            // RIGHT},
            {0}, // {Block.getIdFromBlock(Blocks.ladder),
            // RIGHT},
            {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 9
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 10
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 11
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 12
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}}, { // x
            // =
            // 13
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}}, { // x
            // =
            // 14
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}}, { // x
            // =
            // 15
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}}, { // x
            // =
            // 16
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}}, { // x
            // =
            // 17
            {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}}, { // x
            // =
            // 18
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 19
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 20
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {TempleUtil.CUSTOM_RELIC, 0, 0, 0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 21
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 22
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 23
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 24
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
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
            // 7
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
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 7
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 8
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, // {Block.getIdFromBlock(Blocks.ladder),
            // RIGHT},
            {0}, // {Block.getIdFromBlock(Blocks.ladder),
            // RIGHT},
            {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 9
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 10
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 11
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 12
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}}, { // x
            // =
            // 13
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 14
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 15
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 16
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 17
            {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}}, { // x
            // =
            // 18
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 19
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 20
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 21
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 22
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 23
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
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
            // 8
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
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 7
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 8
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 9
            {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 10
            {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 11
            {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 12
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 13
            {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 14
            {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 15
            {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 16
            {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 17
            {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 18
            {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 19
            {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 20
            {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 21
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 22
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 23
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
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
            // 9
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
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 7
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 8
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 9
            {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 10
            {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 11
            {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 12
            {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 13
            {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 14
            {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 15
            {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 16
            {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 17
            {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 18
            {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 19
            {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {0}, {0}, {0}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {0}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 20
            {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 21
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 22
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 23
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
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
            // 10
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
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 7
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 8
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 9
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 10
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), RIGHT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 11
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 12
            {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 13
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_slab), 5}, {Block.getIdFromBlock(Blocks.stone_slab), 5}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 14
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_slab), 5}, {0}, {0}, {Block.getIdFromBlock(Blocks.stone_slab), 5}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 15
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_slab), 5}, {0}, {0}, {Block.getIdFromBlock(Blocks.stone_slab), 5}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 16
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), TOWARDS}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_slab), 5}, {Block.getIdFromBlock(Blocks.stone_slab), 5}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), AWAY}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 17
            {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 18
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 19
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stone_brick_stairs), LEFT}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 20
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {Block.getIdFromBlock(Blocks.stonebrick)}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 21
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 22
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
            // =
            // 23
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}, { // x
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
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}}},};

}