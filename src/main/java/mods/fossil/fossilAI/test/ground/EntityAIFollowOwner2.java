/*
 ** 2013 November 05
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package mods.fossil.fossilAI.test.ground;

import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.passive.EntityTameable;

/**
 * Modified EntityAIFollowOwner that won't run if the pet is sitting.
 * 
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class EntityAIFollowOwner2 extends EntityAIFollowOwner {
    
    private EntityTameable pet;

    public EntityAIFollowOwner2(EntityTameable entity, double pathDist, float minDist, float maxDist) {
        super(entity, pathDist, minDist, maxDist);
        this.pet = entity;
    }
    
    @Override
    public boolean shouldExecute() {
        return super.shouldExecute() && !pet.isSitting();
    }
}
