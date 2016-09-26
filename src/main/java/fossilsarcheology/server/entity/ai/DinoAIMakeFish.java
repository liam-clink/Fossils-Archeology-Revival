package fossilsarcheology.server.entity.ai;

import fossilsarcheology.server.entity.EntityPrehistoricSwimming;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DinoAIMakeFish extends EntityAIBase {

    private EntityPrehistoricSwimming dinosaur;
    private World world;

    public DinoAIMakeFish(EntityPrehistoricSwimming dinosaur) {
        this.dinosaur = dinosaur;
        this.world = dinosaur.worldObj;
    }

    @Override
    public boolean shouldExecute() {
        return this.dinosaur.isHungry() && this.dinosaur.getRNG().nextInt(205) == 0 && this.dinosaur.isInWater() && this.dinosaur.FISH_ANIMATION != null;
    }

    @Override
    public boolean continueExecuting() {
        return this.dinosaur.isHungry() && this.dinosaur.isInWater();
    }

    @Override
    public void startExecuting() {
        if (this.dinosaur.isInWater()) {
            if (this.dinosaur.getAnimation() != this.dinosaur.FISH_ANIMATION) {
                this.dinosaur.setAnimation(this.dinosaur.FISH_ANIMATION);
            }
        }
    }

    @Override
    public void updateTask() {
        if (this.dinosaur.getAnimation() == this.dinosaur.FISH_ANIMATION) {
            if (this.dinosaur.getAnimationTick() == 20) {
                ItemStack stack2 = new ItemStack(Items.FISH, 1 + this.dinosaur.getRNG().nextInt(2), this.dinosaur.getRNG().nextInt(2));
                this.dinosaur.entityDropItem(stack2, 1);
                this.resetTask();
            }
        }
    }
}
