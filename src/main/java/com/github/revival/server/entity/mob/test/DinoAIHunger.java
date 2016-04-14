package com.github.revival.server.entity.mob.test;

import com.github.revival.Revival;
import com.github.revival.server.enums.EnumOrderType;
import com.github.revival.server.enums.EnumPrehistoricAI.Untaming;
import com.github.revival.server.enums.EnumSituation;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.ItemStack;

public class DinoAIHunger extends EntityAIBase {
    EntityNewPrehistoric mover = null;

    public DinoAIHunger(EntityNewPrehistoric var1) {
        this.mover = var1;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute() {
        //if (fossilOptions.DinoHunger)
        //{
        this.mover.decreaseHungerTick();
        return this.mover.getHungerTick() <= 0 && Revival.CONFIG.starvingDinos;// && this.mover.worldObj.difficultySetting > 0;
        //}
        //return false;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting() {
        //this.mover.getClass();
        this.mover.setHungerTick(300);
        this.mover.decreaseHunger();

        if (!this.mover.worldObj.isRemote) {
            if (this.mover.IsDeadlyHungry()) {
                if (this.mover.currentOrder != EnumOrderType.WANDER) {
                    this.mover.currentOrder = EnumOrderType.WANDER;
                    this.mover.sendStatusMessage(EnumSituation.StarveEsc);
                } else {
                    this.mover.sendStatusMessage(EnumSituation.Hungry);
                }
            }

            if (this.mover.ItemInMouth != null) //The Dino has something in its mouth and gets hungry
            {
                if (this.mover.selfType.FoodItemList.CheckItem(this.mover.ItemInMouth.getItem())) {
                    //its food
                    if (this.mover.IsHungry() || this.mover.selfType.MaxHunger - this.mover.getHunger() > this.mover.selfType.FoodItemList.getItemFood(this.mover.ItemInMouth.getItem())) {
                        //it's hungry or there is enough place in the stomach free
                        this.mover.setHunger(this.mover.getHunger() + this.mover.selfType.FoodItemList.getItemFood(this.mover.ItemInMouth.getItem()));
                        this.mover.ItemInMouth = null;
                    }
                } else {
                    //no food
                    if (this.mover.IsHungry()) {
                        //The Dino gets hungry and because of that spits the object out of the mouth
                        this.mover.entityDropItem(new ItemStack(this.mover.ItemInMouth.getItem(), 1, 0), 0.5F);
                        this.mover.ItemInMouth = null;
                    }
                }
            }

            if (this.mover.getHunger() <= 0) {
                this.handleStarvation();
            }
        }
    }

    private void handleStarvation() {
        if (this.mover.getHealth() <= 5) {
            this.mover.sendStatusMessage(EnumSituation.Starve);
            if (mover.aiUntameType() == Untaming.STARVE) {
                this.mover.sendStatusMessage(EnumSituation.Starve);
                this.mover.setTamed(false);
            }
        }

        // this.mover.attackEntityFrom(DamageSource.starve, 5);
    }
}
