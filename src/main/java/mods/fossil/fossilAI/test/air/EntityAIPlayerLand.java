/*
 ** 2013 July 28
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package mods.fossil.fossilAI.test.air;
import mods.fossil.entity.mob.test.EntityFlyingDinosaur;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

/**
 * Dragon AI for instant landing, if left unmounted in air.
 * 
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class EntityAIPlayerLand extends EntityAIBase {
    
    private final EntityFlyingDinosaur dragon;
    private Vec3 landTarget;
    
    public EntityAIPlayerLand(EntityFlyingDinosaur dragon) {
        this.dragon = dragon;
    }

    @Override
    public boolean shouldExecute() {
        if (!dragon.isFlying()) {
            return false;
        }
        
        landTarget = RandomPositionGenerator.findRandomTarget(dragon, 4, 256);
        
        return landTarget != null;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return dragon.islanding;
    }    
    
    @Override
    public void startExecuting() {
        landTarget.yCoord = 0;
        dragon.getWaypoint().setVector(landTarget);
        dragon.setMoveSpeedAirHoriz(1);
        dragon.setMoveSpeedAirVert(0);
    }
}
