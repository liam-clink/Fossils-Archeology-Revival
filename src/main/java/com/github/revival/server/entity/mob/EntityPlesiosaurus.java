package com.github.revival.server.entity.mob;

import com.github.revival.server.entity.mob.test.EntitySwimmingPrehistoric;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.*;
import com.github.revival.server.item.FAItemRegistry;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityPlesiosaurus extends EntitySwimmingPrehistoric {

    public EntityPlesiosaurus(World world) {
        super(world, EnumPrehistoric.Plesiosaur, 2, 12, 10, 30, 0.2, 0.3);
        this.setSize(1.0F, 1.0F);
        minSize = 0.3F;
        maxSize = 1.5F;
        teenAge = 3;
        developsResistance = true;
        breaksBlocks = true;
        pediaScale = 15;
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

        return Following.NORMAL;
    }

    @Override
    public Jumping aiJumpType() {

        return Jumping.BASIC;
    }

    @Override
    public Response aiResponseType() {

        return Response.WATERCALM;
    }

    @Override
    public Stalking aiStalkType() {

        return Stalking.NONE;
    }

    @Override
    public Taming aiTameType() {

        return Taming.IMPRINTING;
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

        return WaterAbility.IGNOREANDFISH;
    }

    @Override
    public boolean doesFlock() {

        return false;
    }

    @Override
    public Item getOrderItem() {

        return FAItemRegistry.INSTANCE.emptyShell;
    }

    @Override
    public int getAdultAge() {
        return 7;
    }

    public String getTexture() {
        String toggle = this.hasFeatherToggle ? !this.featherToggle ? "feathered/" : "scaled/" : "";
        boolean isBaby = this.isChild() && this.hasBabyTexture;
        String gender = this.hasTeenTexture ? this.isTeen() ? "_teen" : this.isChild() ? "_baby" : this.getGender() == 0 ? "_female" : "_male" : this.isChild() ? "_baby" : this.getGender() == 0 ? "_female" : "_male";
        String sleeping = !this.isSleeping() ? "" : "_sleeping";
        String toggleList = this.hasFeatherToggle ? !this.featherToggle ? "_feathered" : "_scaled" : "";
        return "fossil:textures/model/plesiosaurus_0/" + toggle + "plesiosaurus" + gender + toggleList + sleeping + ".png";
    }

    @Override
    protected double getSwimSpeed() {
        return 2;
    }

}