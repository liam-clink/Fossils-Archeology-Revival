package com.github.revival.server.entity.mob;

import com.github.revival.server.entity.ai.DinoAIAvoidEntity;
import com.github.revival.server.entity.ai.DinoAIHunt;
import com.github.revival.server.entity.ai.DinoAILookIdle;
import com.github.revival.server.entity.ai.DinoAIWatchClosest;
import com.github.revival.server.entity.mob.test.DinoAIFeeder;
import com.github.revival.server.entity.mob.test.DinoAIMakeFish;
import com.github.revival.server.entity.mob.test.DinoAIWaterFeeder;
import com.github.revival.server.entity.mob.test.DinoAIWaterFindTarget;
import com.github.revival.server.entity.mob.test.EntitySwimmingPrehistoric;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.*;
import com.github.revival.server.item.FAItemRegistry;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityPlesiosaurus extends EntitySwimmingPrehistoric {

    public EntityPlesiosaurus(World world) {
        super(world, EnumPrehistoric.Plesiosaur, 2, 12, 10, 30, 0.2, 0.3);
        this.getNavigator().setAvoidsWater(false);
        FISH_ANIMATION = Animation.create(40);
        this.tasks.addTask(1, this.aiSit);
        this.tasks.addTask(2, new DinoAIWaterFindTarget(this, false));
        this.tasks.addTask(3, new DinoAIWaterFeeder(this, 16));
        this.tasks.addTask(4, new DinoAIMakeFish(this));
        this.tasks.addTask(5, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(5, new DinoAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new DinoAIHunt(this, 20, false));
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

	public int getMaxHunger() {
		return 125;
	}
	
	@Override
	public Animation[] getAnimations() {
		return new Animation[] { SPEAK_ANIMATION, ATTACK_ANIMATION, FISH_ANIMATION };
	}

	@Override
	public boolean canBeRidden() {
		return false;
	}
}