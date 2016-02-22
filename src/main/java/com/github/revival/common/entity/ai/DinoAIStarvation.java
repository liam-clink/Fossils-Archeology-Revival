package com.github.revival.common.entity.ai;

import com.github.revival.common.config.FossilConfig;
import com.github.revival.common.entity.mob.EntityDinosaur;
import com.github.revival.common.enums.EnumOrderType;
import com.github.revival.common.enums.EnumSituation;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class DinoAIStarvation extends EntityAIBase {
    EntityDinosaur mover = null;

    public DinoAIStarvation(EntityDinosaur var1) {
        this.mover = var1;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
        //if (fossilOptions.DinoHunger)
        //{
        this.mover.decreaseHungerTick();
        return this.mover.getHungerTick() <= 0 && FossilConfig.starvingDinos;// && this.mover.worldObj.difficultySetting > 0;
        //}
        //return false;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        //this.mover.getClass();
        this.mover.setHungerTick(300);
        this.mover.decreaseHunger();

        if (!this.mover.worldObj.isRemote) {
            if (this.mover.IsDeadlyHungry()) {
                if (this.mover.OrderStatus != EnumOrderType.FreeMove) {
                    this.mover.OrderStatus = EnumOrderType.FreeMove;
                    this.mover.SendStatusMessage(EnumSituation.StarveEsc);
                } else {
                    this.mover.SendStatusMessage(EnumSituation.Hungry);
                }
            }

            if (this.mover.ItemInMouth != null) //The Dino has something in its mouth and gets hungry
            {
                if (this.mover.SelfType.FoodItemList.CheckItem(this.mover.ItemInMouth.getItem())) {
                    //its food
                    if (this.mover.IsHungry() || this.mover.SelfType.MaxHunger - this.mover.getHunger() > this.mover.SelfType.FoodItemList.getItemFood(this.mover.ItemInMouth.getItem())) {
                        //it's hungry or there is enough place in the stomach free
                        this.mover.setHunger(this.mover.getHunger() + this.mover.SelfType.FoodItemList.getItemFood(this.mover.ItemInMouth.getItem()));
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
            this.mover.SendStatusMessage(EnumSituation.Starve);
        }

        this.mover.attackEntityFrom(DamageSource.starve, 5);
    }
}
