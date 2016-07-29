package fossilsarcheology.server.entity.mob;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import fossilsarcheology.server.entity.EntityPrehistoricSwimming;
import fossilsarcheology.server.entity.EntityToyBase;
import fossilsarcheology.server.entity.ai.DinoAIAttackOnCollide;
import fossilsarcheology.server.entity.ai.DinoAIEatFeeders;
import fossilsarcheology.server.entity.ai.DinoAIEatItems;
import fossilsarcheology.server.entity.ai.DinoAIFollowOwner;
import fossilsarcheology.server.entity.ai.DinoAIHunt;
import fossilsarcheology.server.entity.ai.DinoAILookIdle;
import fossilsarcheology.server.entity.ai.DinoAIRiding;
import fossilsarcheology.server.entity.ai.DinoAIWander;
import fossilsarcheology.server.entity.ai.DinoAIWatchClosest;
import fossilsarcheology.server.entity.ai.DinoAIWaterFindTarget;
import fossilsarcheology.server.enums.EnumPrehistoric;
import fossilsarcheology.server.enums.EnumPrehistoricAI;
import fossilsarcheology.server.item.FAItemRegistry;

public class EntityHenodus extends EntityPrehistoricSwimming {

    public EntityHenodus(World world) {
        super(world, EnumPrehistoric.Henodus, 1, 2, 10, 30, 0.25, 0.3);
        this.setActualSize(1.1F, 1F);
        isAmphibious = true;
        this.getNavigator().setAvoidsWater(false);
        this.tasks.addTask(1, this.aiSit);
        this.tasks.addTask(2, new DinoAIWaterFindTarget(this, true));
        this.tasks.addTask(3, new DinoAIAttackOnCollide(this, 1.5D, false));
        this.tasks.addTask(4, new DinoAIEatFeeders(this, 1));
        this.tasks.addTask(4, new DinoAIEatItems(this, 1));
        this.tasks.addTask(5, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(6, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(7, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new DinoAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new DinoAIHunt(this, 20, false));
        minSize = 0.5F;
        maxSize = 0.9F;
        teenAge = 2;
        developsResistance = true;
        this.hasBabyTexture = true;
        this.pediaScale = 40F;
    }

    @Override
    public void setSpawnValues() {
    }

    @Override
    public EnumPrehistoricAI.Activity aiActivityType() {
        return EnumPrehistoricAI.Activity.BOTH;
    }

    @Override
    public EnumPrehistoricAI.Attacking aiAttackType() {
        return EnumPrehistoricAI.Attacking.BASIC;
    }

    @Override
    public EnumPrehistoricAI.Climbing aiClimbType() {
        return EnumPrehistoricAI.Climbing.NONE;
    }

    @Override
    public EnumPrehistoricAI.Following aiFollowType() {
        return EnumPrehistoricAI.Following.NORMAL;
    }

    @Override
    public EnumPrehistoricAI.Jumping aiJumpType() {
        return EnumPrehistoricAI.Jumping.BASIC;
    }

    @Override
    public EnumPrehistoricAI.Response aiResponseType() {
        return EnumPrehistoricAI.Response.WATERCALM;
    }

    @Override
    public EnumPrehistoricAI.Stalking aiStalkType() {
        return EnumPrehistoricAI.Stalking.NONE;
    }

    @Override
    public EnumPrehistoricAI.Taming aiTameType() {
        return EnumPrehistoricAI.Taming.IMPRINTING;
    }

    @Override
    public EnumPrehistoricAI.Untaming aiUntameType() {
        return EnumPrehistoricAI.Untaming.STARVE;
    }

    @Override
    public EnumPrehistoricAI.Moving aiMovingType() {
        return EnumPrehistoricAI.Moving.SEMIAQUATIC;
    }

    @Override
    public EnumPrehistoricAI.WaterAbility aiWaterAbilityType() {
        return EnumPrehistoricAI.WaterAbility.IGNOREANDFISH;
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
    public int getTailSegments() {
        return 2;
    }

    public int getMaxHunger() {
        return 50;
    }

    @Override
    protected double getSwimSpeed() {
        return 1;
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if(this.isInWater()){
            return false;
        }
        return true;
    }

    @Override
    public boolean canBeRidden() {
        return false;
    }
}
