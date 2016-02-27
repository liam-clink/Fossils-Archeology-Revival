/*
 ** 2012 March 18
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package com.github.revival.server.entity.ai;

import com.github.revival.server.entity.mob.PrehistoricEntity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Abstract "AI" for player-controlled movements.
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public abstract class DinoAIRide extends EntityAIBase {
    protected final PrehistoricEntity dinosaur;
    protected EntityPlayer rider;

    public DinoAIRide(PrehistoricEntity dinosaur) {
        this.dinosaur = dinosaur;
        setMutexBits(0xffffffff);
    }

    @Override
    public boolean shouldExecute() {
        rider = dinosaur.getRidingPlayer();
        return rider != null;
    }
}
