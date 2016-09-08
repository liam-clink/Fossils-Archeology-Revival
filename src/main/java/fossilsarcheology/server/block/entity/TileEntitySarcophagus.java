package fossilsarcheology.server.block.entity;

import fossilsarcheology.server.entity.mob.EntityAnu;
import net.minecraft.init.SoundEvents;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;

public class TileEntitySarcophagus extends TileEntity implements ITickable {
    public int chestState = 0;
    public int chestLidCounter;
    public int chestLidCounter2;

    public void setChestState(int state) {
        chestState = state;
    }

    @Override
    public void update() {
        if (this.chestState != 3) {
            if (chestLidCounter != 0 && chestLidCounter < 91) {
                chestLidCounter++;
            }
            if (chestLidCounter == 91) {
                this.setChestState(3);
                EntityAnu anu = new EntityAnu(worldObj);
                if (!worldObj.isRemote) {
                    anu.setLocationAndAngles(this.pos.getX() + 0.5, this.pos.getY(), this.pos.getZ() + 0.5, 0, 0);
                    worldObj.spawnEntityInWorld(anu);
                }
                anu.initializeMob();
                worldObj.playSound(null, this.pos, SoundEvents.BLOCK_CHEST_CLOSE, SoundCategory.BLOCKS, 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
            }
        } else {
            if (chestLidCounter != 0 && chestLidCounter > 0) {
                chestLidCounter--;
            }
            if (chestLidCounter == 0) {
                this.setChestState(0);
            }
        }
    }
}
