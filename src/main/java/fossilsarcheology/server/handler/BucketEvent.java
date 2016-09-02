package fossilsarcheology.server.handler;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

public class BucketEvent {

    public static BucketEvent INSTANCE = new BucketEvent();
    public Map<IBlockState, Item> buckets = new HashMap<IBlockState, Item>();

    private BucketEvent() {

    }

    @SubscribeEvent
    public void onBucketFill(FillBucketEvent event) {
        ItemStack result = fillCustomBucket(event.getWorld(), event.getTarget());
        if (result == null) {
            return;
        }
        event.setFilledBucket(result);
        event.setResult(Result.ALLOW);
    }

    private ItemStack fillCustomBucket(World world, RayTraceResult rayTrace) {
        IBlockState state = world.getBlockState(rayTrace.getBlockPos());
        Item bucket = this.buckets.get(state);
        if (bucket != null && world.getBlockMetadata(rayTrace.blockX, rayTrace.blockY, rayTrace.blockZ) == 0) {
            world.playSoundEffect(rayTrace.getBlockPos(), "dig.sand", 1, 1);
            world.setBlockToAir(rayTrace.getBlockPos());
            return new ItemStack(bucket);
        } else {
            return null;
        }

    }
}
