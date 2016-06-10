package com.github.revival.server.entity.mob;

import com.github.revival.server.entity.mob.test.EntitySwimmingPrehistoric;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.*;
import com.github.revival.server.item.FAItemRegistry;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityMosasaurus extends EntitySwimmingPrehistoric {

    public EntityMosasaurus(World world) {
        super(world, EnumPrehistoric.Mosasaurus, 2, 9, 12, 70, 0.3, 0.35);
        this.hasBabyTexture = false;
        this.setSize(1.5F, 0.6F);
        minSize = 0.6F;
        maxSize = 2.1F;
        teenAge = 5;
        developsResistance = true;
        breaksBlocks = true;
        hasBabyTexture = false;
        pediaScale = 6;
    }

    @Override
    public void setSpawnValues() {
    }

    @Override
    public Activity aiActivityType() {

        return Activity.DIURINAL;
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

        return Moving.AQUATIC;
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
        return 11;
    }

    @Override
    protected double getSwimSpeed() {
        return 4;
    }

	public int getMaxHunger() {
		return 125;
	}
}
