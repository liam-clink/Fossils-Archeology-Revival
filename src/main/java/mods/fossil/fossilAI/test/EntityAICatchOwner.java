/*
 ** 2013 November 03
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

/**
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class EntityAICatchOwner extends EntityAIBase {
    
    protected final EntityFlyingDinosaur dragon;
    protected EntityPlayer owner;
    
    public EntityAICatchOwner(EntityFlyingDinosaur dragon2) {
        this.dragon = dragon2;
    }

    @Override
    public boolean shouldExecute() {
        owner = (EntityPlayer) dragon.getOwner();
        
        if (owner == null || owner == dragon.riddenByEntity) {
            return false;
        }
        
        return owner.fallDistance > 4;
    }
}
