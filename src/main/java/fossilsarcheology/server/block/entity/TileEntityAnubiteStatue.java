package fossilsarcheology.server.block.entity;

import fossilsarcheology.server.entity.mob.EntityAnubite;
import fossilsarcheology.server.handler.FossilAchievementHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityAnubiteStatue extends TileEntity implements ITickable {
    @Override
    public void update() {
        EntityPlayer player = this.worldObj.getClosestPlayer(this.pos.getX(), this.pos.getY(), this.pos.getZ(), 5, false);
        if (player != null) {
            player.addStat(FossilAchievementHandler.anubiteEncounter, 1);
            if (!player.capabilities.isCreativeMode) {
                worldObj.newExplosion(null, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 5F, true, true);
                EntityAnubite newMob = new EntityAnubite(worldObj);
                if (!worldObj.isRemote) {
                    newMob.setLocationAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0, 0);
                    worldObj.spawnEntityInWorld(newMob);
                    worldObj.removeTileEntity(this.pos);
                    worldObj.setBlockToAir(this.pos);
                }
            }
        }
    }
}
