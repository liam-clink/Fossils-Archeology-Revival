package fossilsarcheology.server.block.entity;

import fossilsarcheology.server.block.BlockAnubiteStatue;
import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.entity.EntityAnuEffect;
import fossilsarcheology.server.handler.FossilAchievementHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class TileEntityAnuTotem extends TileEntity implements ITickable {
    @Override
    public void update() {
        for (EntityPlayer player : worldObj.playerEntities) {
            if (this.getDistanceSq(player.posX, player.posY, player.posZ) < 40) {
                player.addStat(FossilAchievementHandler.findAnuTotem, 1);
            }
        }
        boolean hasRequirements = true;
        for (EnumFacing direction : EnumFacing.HORIZONTALS) {
            if (this.worldObj.getBlockState(this.pos.offset(direction)).getBlock() != Blocks.REDSTONE_WIRE || this.worldObj.getBlockState(this.pos.offset(direction).offset(direction.rotateY())).getBlock() != FABlockRegistry.INSTANCE.figurineBlock) {
                hasRequirements = false;
                break;
            }
        }
        if (hasRequirements) {
            for (EntityPlayer player : worldObj.playerEntities) {
                if (this.getDistanceSq(player.posX, player.posY, player.posZ) < 90) {
                    player.addStat(FossilAchievementHandler.anuPortal, 1);
                }
            }
            worldObj.newExplosion(null, pos.getX() + 0.5F, pos.getY(), pos.getZ() + 0.5, 5F, true, true);
            EntityAnuEffect newMob = new EntityAnuEffect(worldObj);
            if (!worldObj.isRemote) {
                newMob.setLocationAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0, 0);
                worldObj.spawnEntityInWorld(newMob);
            }
            newMob.setAnuRotation(worldObj.getBlockState(pos).getValue(BlockAnubiteStatue.FACING));
            newMob.playSummonSong();
            newMob.setHealth(0);
            for (EnumFacing direction : EnumFacing.HORIZONTALS) {
                BlockPos redstonePos = this.pos.offset(direction);
                BlockPos figurinePos = redstonePos.offset(direction.rotateY());
                this.worldObj.setBlockToAir(redstonePos);
                this.worldObj.setBlockToAir(figurinePos);
            }
            this.worldObj.setBlockToAir(this.pos);
        }
    }
}
