package fossilsarcheology.server.entity.mob;

import fossilsarcheology.server.entity.EntityPrehistoricSwimming;
import fossilsarcheology.server.entity.ai.DinoAIEatFeeders;
import fossilsarcheology.server.entity.ai.DinoAIEatItems;
import fossilsarcheology.server.entity.ai.DinoAIHunt;
import fossilsarcheology.server.entity.ai.DinoAILookIdle;
import fossilsarcheology.server.entity.ai.DinoAIMakeFish;
import fossilsarcheology.server.entity.ai.DinoAIWatchClosest;
import fossilsarcheology.server.entity.ai.DinoAIWaterFindTarget;
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
import fossilsarcheology.server.item.FAItemRegistry;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityPlesiosaurus extends EntityPrehistoricSwimming {

    public EntityPlesiosaurus(World world) {
        super(world, PrehistoricEntityType.PLESIOSAUR, 2, 12, 10, 30, 0.2, 0.3);
        this.getNavigator().setAvoidsWater(false);
        FISH_ANIMATION = Animation.create(40);
        this.tasks.addTask(1, this.aiSit);
        this.tasks.addTask(2, new DinoAIWaterFindTarget(this, false));
        this.tasks.addTask(3, new DinoAIEatFeeders(this));
        this.tasks.addTask(3, new DinoAIEatItems(this));
        this.tasks.addTask(4, new DinoAIMakeFish(this));
        this.tasks.addTask(5, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(5, new DinoAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new DinoAIHunt(this, 20, false));
        this.setActualSize(1.0F, 1.5F);
        minSize = 0.3F;
        maxSize = 1.5F;
        teenAge = 3;
        developsResistance = true;
        breaksBlocks = true;
        pediaScale = 40;
    }

    @Override
    public void setSpawnValues() {
    }

    @Override
    public Activity getActivityType() {

        return Activity.BOTH;
    }

    @Override
    public Attacking getAttackType() {

        return Attacking.DROWN;
    }

    @Override
    public Climbing getClimbType() {

        return Climbing.NONE;
    }

    @Override
    public Following getFollowType() {

        return Following.NORMAL;
    }

    @Override
    public Jumping getJumpType() {

        return Jumping.BASIC;
    }

    @Override
    public Response getResponseType() {

        return Response.WATERCALM;
    }

    @Override
    public Stalking getStalkType() {

        return Stalking.NONE;
    }

    @Override
    public Taming getTameType() {

        return Taming.IMPRINTING;
    }

    @Override
    public Untaming getUntameType() {

        return Untaming.NONE;
    }

    @Override
    public Moving getMoveType() {

        return Moving.AQUATIC;
    }

    @Override
    public WaterAbility getWaterAbilityType() {

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
        if (isSkeleton()) {
            return "fossil:textures/model/plesiosaurus_0/" + "plesiosaurus_skeleton.png";
        }
        String toggle = this.hasFeatherToggle ? !this.featherToggle ? "feathered/" : "scaled/" : "";
        String gender = this.getGender() == 0 ? "_female" : "_male";
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
        return new Animation[] { speakAnimation, attackAnimation, FISH_ANIMATION };
    }

    @Override
    public boolean canBeRidden() {
        return false;
    }
}
