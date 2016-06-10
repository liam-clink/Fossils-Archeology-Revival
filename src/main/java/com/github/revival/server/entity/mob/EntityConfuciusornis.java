package com.github.revival.server.entity.mob;

import com.github.revival.server.entity.mob.test.EntityFlyingPrehistoric;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.*;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityConfuciusornis extends EntityFlyingPrehistoric {

    public EntityConfuciusornis(World world) {
        super(world, EnumPrehistoric.Confuciusornis, 1, 1, 4, 12, 0.15, 0.25);
        this.setSize(0.5F, 0.5F);
        minSize = 0.3F;
        maxSize = 0.6F;
        teenAge = 1;
        developsResistance = false;
        breaksBlocks = false;
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
        return Attacking.BASIC;
    }

    @Override
    public Climbing aiClimbType() {
        return Climbing.NONE;
    }

    @Override
    public Following aiFollowType() {
        return Following.SKITTISH;
    }

    @Override
    public Jumping aiJumpType() {
        return Jumping.BASIC;
    }

    @Override
    public Response aiResponseType() {
        return Response.SCARED;
    }

    @Override
    public Stalking aiStalkType() {
        return Stalking.STEALTH;
    }

    @Override
    public Taming aiTameType() {
        return Taming.FEEDING;
    }

    @Override
    public Untaming aiUntameType() {
        return Untaming.NONE;
    }

    @Override
    public Moving aiMovingType() {
        return Moving.WALK;
    }

    @Override
    public WaterAbility aiWaterAbilityType() {
        return WaterAbility.NONE;
    }

    @Override
    public boolean doesFlock() {
        return false;
    }

    @Override
    public Item getOrderItem() {
        return Items.stick;
    }

    @Override
    public int getAdultAge() {
        return 3;
    }

    @Override
    protected double getFlySpeed() {
        return 0;
    }

}
