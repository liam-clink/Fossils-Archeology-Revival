package fossilsarcheology.server;

import fossilsarcheology.Revival;
import fossilsarcheology.client.sound.FASoundRegistry;
import fossilsarcheology.server.achievement.FossilAchievements;
import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.block.entity.AnalyzerBlockEntity;
import fossilsarcheology.server.container.AnalyzerContainer;
import fossilsarcheology.server.entity.EntityFishBase;
import fossilsarcheology.server.entity.FAEntityRegistry;
import fossilsarcheology.server.entity.prehistoric.EntityPrehistoric;
import fossilsarcheology.server.entity.prehistoric.PrehistoricEntityType;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ServerProxy implements IGuiHandler {
    public static final int GUI_ANALYZER = 0;

    public void onPreInit() {
        NetworkRegistry.INSTANCE.registerGuiHandler(Revival.INSTANCE, this);

        FASoundRegistry.register();

        FAItemRegistry.register();
        FABlockRegistry.register();

        FAEntityRegistry.register();

        PrehistoricEntityType.register();

        FossilAchievements.register();
    }

    public void onInit() {

    }

    public void calculateChainBuffer(EntityFishBase entity) {

    }

    public void calculateChainBuffer(EntityPrehistoric entity) {

    }

    public void onPostInit() {

    }

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        if (id == GUI_ANALYZER) {
            return new AnalyzerContainer(player.inventory, (AnalyzerBlockEntity) world.getTileEntity(pos));
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    public void spawnPacketItemParticles(World worldObj, float f, float f1, float f2, double motionX, double motionY, double motionZ, Item item) {

    }

    public void spawnPacketBlockParticles(World worldObj, float f, float f1, float f2, double motionX, double motionY, double motionZ, Block block) {
    }

    public void spawnPacketHeartParticles(World worldObj, float f, float f1, float f2, double motionX, double motionY, double motionZ) {
    }
}
