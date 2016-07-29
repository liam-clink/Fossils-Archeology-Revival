package fossilsarcheology.server.entity.mob;

import fossilsarcheology.server.entity.EntityPrehistoricSwimming;
import fossilsarcheology.server.entity.ai.*;
import fossilsarcheology.server.enums.EnumPrehistoric;
import fossilsarcheology.server.enums.EnumPrehistoricAI.*;
import fossilsarcheology.server.item.FAItemRegistry;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityIcthyosaurus extends EntityPrehistoricSwimming {

    public EntityIcthyosaurus(World world) {
        super(world, EnumPrehistoric.Icthyosaurus, 1, 4, 10, 30, 0.1, 0.1);
        this.getNavigator().setAvoidsWater(false);
        FISH_ANIMATION = Animation.create(40);
        this.tasks.addTask(1, this.aiSit);
        this.tasks.addTask(2, new DinoAIWaterFindTarget(this, false));
        this.tasks.addTask(3, new DinoAIEatFeeders(this, 1));
        this.tasks.addTask(3, new DinoAIEatItems(this, 1));
        this.tasks.addTask(4, new DinoAIMakeFish(this));
        this.tasks.addTask(5, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(5, new DinoAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new DinoAIHunt(this, 20, false));
        this.setActualSize(1.2F, 1.0F);
        minSize = 0.3F;
        maxSize = 0.8F;
        teenAge = 3;
        developsResistance = true;
        pediaScale = 40;
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
        return WaterAbility.ATTACK;
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
    	if(isSkeleton()){
    		return "fossil:textures/model/icthyosaurus_0/icthyosaurus_skeleton.png";
    	}
        String gender = this.isChild() ? "_baby" : (this.getGender() == 0 ? "_female" : "_male");
        return "fossil:textures/model/icthyosaurus_0/icthyosaurus" + gender + ".png";
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
