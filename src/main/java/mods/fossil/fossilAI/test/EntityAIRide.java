/*
 ** 2012 March 18
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package mods.fossil.fossilAI.test;

import mods.fossil.entity.mob.test.EntityFlyingDinosaur;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * Abstract "AI" for player-controlled movements.
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public abstract class EntityAIRide extends EntityAIBase {

    protected final EntityFlyingDinosaur dragon;
    protected EntityPlayer rider;

    public EntityAIRide(EntityFlyingDinosaur dragon2) {
        this.dragon = dragon2;
        setMutexBits(0xffffffff);
    }
    public static boolean consumeEquipped(EntityPlayer player) {
        ItemStack itemStack = player.getCurrentEquippedItem();
        
        if (itemStack != null) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean shouldExecute() {   
        rider = dragon.getRidingPlayer();
        return rider != null;
    }
}
