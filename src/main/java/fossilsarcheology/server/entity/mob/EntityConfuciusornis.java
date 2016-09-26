package fossilsarcheology.server.entity.mob;

import fossilsarcheology.server.entity.EntityPrehistoricFlying;
import fossilsarcheology.server.entity.ai.DinoAIEatBlocks;
import fossilsarcheology.server.entity.ai.DinoAIEatFeeders;
import fossilsarcheology.server.entity.ai.DinoAIEatItems;
import fossilsarcheology.server.entity.ai.DinoAIFindAirTarget;
import fossilsarcheology.server.entity.ai.DinoAIFollowOwner;
import fossilsarcheology.server.entity.ai.DinoAIHunt;
import fossilsarcheology.server.entity.ai.DinoAILeapAtTarget;
import fossilsarcheology.server.entity.ai.DinoAILookIdle;
import fossilsarcheology.server.entity.ai.DinoAIWander;
import fossilsarcheology.server.entity.ai.DinoAIWatchClosest;
import fossilsarcheology.server.enums.PrehistoricAI.Activity;
import fossilsarcheology.server.enums.PrehistoricAI.Attacking;
import fossilsarcheology.server.enums.PrehistoricAI.Climbing;
import fossilsarcheology.server.enums.PrehistoricAI.Following;
import fossilsarcheology.server.enums.PrehistoricAI.Jumping;
import fossilsarcheology.server.enums.PrehistoricAI.Moving;
import fossilsarcheology.server.enums.PrehistoricAI.Response;
import fossilsarcheology.server.enums.PrehistoricAI.Stalking;
import fossilsarcheology.server.enums.PrehistoricAI.Taming;
import fossilsarcheology.server.enums.PrehistoricAI.Untaming;
import fossilsarcheology.server.enums.PrehistoricAI.WaterAbility;
import fossilsarcheology.server.enums.PrehistoricEntityType;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityConfuciusornis extends EntityPrehistoricFlying {

    public EntityConfuciusornis(World world) {
        super(world, PrehistoricEntityType.CONFUCIUSORNIS, 1, 1, 4, 12, 0.15, 0.25);
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().setCanSwim(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new DinoAIFindAirTarget(this));
        this.tasks.addTask(5, new DinoAILeapAtTarget(this));
        this.tasks.addTask(6, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(7, new DinoAIEatBlocks(this));
        this.tasks.addTask(7, new DinoAIEatFeeders(this));
        this.tasks.addTask(7, new DinoAIEatItems(this));
        this.tasks.addTask(8, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(9, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new DinoAILookIdle(this));
        this.targetTasks.addTask(4, new DinoAIHunt(this, 20, false));
        this.setActualSize(0.7F, 0.8F);
        minSize = 0.3F;
        maxSize = 0.8F;
        teenAge = 2;
        developsResistance = false;
        breaksBlocks = false;
        pediaScale = 47;
    }

    @Override
    public void setSpawnValues() {
    }

    @Override
    public Activity getActivityType() {
        return Activity.DIURINAL;
    }

    @Override
    public Attacking getAttackType() {
        return Attacking.BASIC;
    }

    @Override
    public Climbing getClimbType() {
        return Climbing.NONE;
    }

    @Override
    public Following getFollowType() {
        return Following.SKITTISH;
    }

    @Override
    public Jumping getJumpType() {
        return Jumping.BASIC;
    }

    @Override
    public Response getResponseType() {
        return Response.SCARED;
    }

    @Override
    public Stalking getStalkType() {
        return Stalking.STEALTH;
    }

    @Override
    public Taming getTameType() {
        return Taming.FEEDING;
    }

    @Override
    public Untaming getUntameType() {
        return Untaming.NONE;
    }

    @Override
    public Moving getMoveType() {
        return Moving.FLIGHT;
    }

    @Override
    public WaterAbility getWaterAbilityType() {
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
        return 4;
    }

    @Override
    protected double getFlySpeed() {
        return 1;
    }

    public int getMaxHunger() {
        return 25;
    }

    @Override
    public boolean canBeRidden() {
        return false;
    }
}
