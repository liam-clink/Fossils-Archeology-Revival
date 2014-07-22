/*
 ** 2012 August 24
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package mods.fossil.fossilAI.test.ground;

import mods.fossil.entity.mob.test.EntityFlyingDinosaur;
import net.minecraft.entity.ai.EntityAIPanic;

/**
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class EntityAIPanicChild extends EntityAIPanic {
    
    private EntityFlyingDinosaur dragon;

    public EntityAIPanicChild(EntityFlyingDinosaur dragon, double speed) {
        super(dragon, speed);
        this.dragon = dragon;
    }

    @Override
    public boolean shouldExecute() {
        return super.shouldExecute() && !dragon.isAdult();
    }
}
