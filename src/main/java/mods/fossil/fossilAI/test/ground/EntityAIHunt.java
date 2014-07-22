/*
 ** 2013 July 20
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package mods.fossil.fossilAI.test.ground;

import mods.fossil.entity.mob.test.EntityFlyingDinosaur;
import net.minecraft.entity.ai.EntityAITargetNonTamed;

/**
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class EntityAIHunt extends EntityAITargetNonTamed {
    
    private EntityFlyingDinosaur dragon;

    public EntityAIHunt(EntityFlyingDinosaur dragon, Class clazz, int par3, boolean par4) {
        super(dragon, clazz, par3, par4);
        this.dragon = dragon;
    }

    @Override
    public boolean shouldExecute() {
        return dragon.isAdult() && super.shouldExecute();
    }
}
