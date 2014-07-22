/*
 ** 2012 April 25
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package mods.fossil.fossilAI.test.air;

import mods.fossil.Fossil;
import mods.fossil.entity.mob.test.EntityFlyingDinosaur;
import mods.fossil.fossilAI.test.EntityAIRide;
import mods.fossil.util.ItemUtils;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

/**
 * AI for player-controlled air movements.
 * 
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class EntityAIRideAir extends EntityAIRide {
        
    
    double speedAir = 1; 
    double verticalSpeed = 0;
    
    public EntityAIRideAir(EntityFlyingDinosaur dragon) {
        super(dragon);
    }
    
    @Override
    public void updateTask() {
        super.updateTask();
        
        double dist = 100;

            Vec3 wp = dragon.getLookVec();

            // scale with distance
            wp.xCoord *= dist;
            wp.yCoord *= dist;
            wp.zCoord *= dist;

            // convert to absolute position
            wp.xCoord += dragon.posX;
            wp.yCoord += dragon.posY;
            wp.zCoord += dragon.posZ;

            dragon.getWaypoint().setVector(wp);

            
            //Changing altitude with forward and back
            if (rider.moveForward != 0) {
                verticalSpeed = -0.5f;
                
                if (rider.moveForward < 0) {
                	//speedAir = 1;
                    //speedAir *= 0.5;
                	verticalSpeed = 0.5f;
                }
                
            }
            
            dragon.setMoveSpeedAirHoriz(speedAir);

            // control rotation with strafing
            if (rider.moveStrafing != 0) {
                dragon.rotationYaw -= rider.moveStrafing * 6;
            }

            dragon.setMoveSpeedAirVert(verticalSpeed);
    }
}
