package fossilsarcheology.server.entity.ai;

import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.EntityPrehistoricSwimming;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DinoAIMakeFish extends EntityAIBase {

	private EntityPrehistoric dinosaur;
	private World world;

	public DinoAIMakeFish(EntityPrehistoric dinosaur) {
		this.dinosaur = dinosaur;
		this.world = dinosaur.worldObj;
	}

	@Override
	public boolean shouldExecute() {
		if (!this.dinosaur.isHungry()) {
			return false;
		}
		if (this.dinosaur.getRNG().nextInt(205) != 0) {
			return false;
		}
		if (!this.dinosaur.isInWater()) {
			return false;
		}
		if(this.dinosaur instanceof EntityPrehistoricSwimming && ((EntityPrehistoricSwimming)this.dinosaur).FISH_ANIMATION == null){
			return false;
		}
		return true;
	}

	public boolean continueExecuting() {
		if (!this.dinosaur.isHungry()) {
			return false;
		}
		if (!this.dinosaur.isInWater()) {
			return false;
		}
		return true;
	}
	
    public void startExecuting() {
    	if(this.dinosaur.isInWater()){
    		if(this.dinosaur instanceof EntityPrehistoricSwimming && this.dinosaur.getAnimation() != ((EntityPrehistoricSwimming)this.dinosaur).FISH_ANIMATION){
    			this.dinosaur.setAnimation(((EntityPrehistoricSwimming)this.dinosaur).FISH_ANIMATION);
    		}
    	}
    }
    
    public void updateTask() {
		if(this.dinosaur instanceof EntityPrehistoricSwimming && this.dinosaur.getAnimation() == ((EntityPrehistoricSwimming)this.dinosaur).FISH_ANIMATION){
    		if(this.dinosaur.getAnimationTick() == 20){
    			ItemStack stack2 = new ItemStack(Items.fish, 1 +  this.dinosaur.getRNG().nextInt(2), this.dinosaur.getRNG().nextInt(2));
    			this.dinosaur.entityDropItem(stack2, 1);
    			resetTask();
    			return;
    		}	
		}
		if(!(this.dinosaur instanceof EntityPrehistoricSwimming)){
			ItemStack stack2 = new ItemStack(Items.fish, 1 +  this.dinosaur.getRNG().nextInt(2), this.dinosaur.getRNG().nextInt(2));
			this.dinosaur.entityDropItem(stack2, 1);
			resetTask();
			return;
		}
    }
}
