package com.github.revival.server.entity.mob;

import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.*;
import com.github.revival.server.item.FAItemRegistry;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntitySarcosuchus extends EntityNewPrehistoric {

    public EntitySarcosuchus(World world) {
        super(world, EnumPrehistoric.Sarcosuchus, 1, 3, 5, 70, 0.25, 0.25);
        this.setSize(4.0F, 1.0F);
        minSize = 0.2F;
        maxSize = 1.3F;
        teenAge = 5;
        developsResistance = true;
        breaksBlocks = true;
    }

    @Override
    public void setSpawnValues() {

    }

    @Override
    public Activity aiActivityType() {

        return Activity.BOTH;
    }

    @Override
    public Attacking aiAttackType() {

        return Attacking.DROWN;
    }

    @Override
    public Climbing aiClimbType() {

        return Climbing.NONE;
    }

    @Override
    public Following aiFollowType() {

        return Following.AGRESSIVE;
    }

    @Override
    public Jumping aiJumpType() {

        return Jumping.BASIC;
    }

    @Override
    public Response aiResponseType() {

        return Response.AGRESSIVE;
    }

    @Override
    public Stalking aiStalkType() {

        return Stalking.NONE;
    }

    @Override
    public Taming aiTameType() {

        return Taming.BLUEGEM;
    }

    @Override
    public Untaming aiUntameType() {

        return Untaming.NONE;
    }

    @Override
    public Moving aiMovingType() {

        return Moving.SEMIAQUATIC;
    }

    @Override
    public WaterAbility aiWaterAbilityType() {

        return WaterAbility.ATTACK;
    }

    @Override
    public boolean doesFlock() {

        return false;
    }

    @Override
    public Item getOrderItem() {
        return FAItemRegistry.INSTANCE.skullStick;
    }

    @Override
    public int getAdultAge() {
        return 12;
    }
    
	public int getMaxHunger() {
		return 150;
	}
}
