package com.github.revival.server.entity.mob;

import com.github.revival.server.entity.ai.DinoAIAttackOnCollide;
import com.github.revival.server.entity.ai.DinoAIAvoidEntity;
import com.github.revival.server.entity.ai.DinoAIFollowOwner;
import com.github.revival.server.entity.ai.DinoAIHunt;
import com.github.revival.server.entity.ai.DinoAILookIdle;
import com.github.revival.server.entity.ai.DinoAIWander;
import com.github.revival.server.entity.ai.DinoAIWatchClosest;
import com.github.revival.server.entity.mob.test.DinoAIFeeder;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.*;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import java.util.ArrayList;

public class EntityMammoth extends EntityNewPrehistoric implements IShearable {

    private EntityAIEatGrass aiEatGrass = new EntityAIEatGrass(this);
    private int eatGrassTimes = 0;
    private static PotionEffect BIOME_EFFECT = new PotionEffect(Potion.weakness.id, 60, 1);

    public EntityMammoth(World world) {
        super(world, EnumPrehistoric.Mammoth, 2, 12, 10, 66, 0.2, 0.3);
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().setCanSwim(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new DinoAIAvoidEntity(this, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(4, new DinoAIAttackOnCollide(this, 1.5D, false));
        this.tasks.addTask(5, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(6, new DinoAIFeeder(this, 16));
        this.tasks.addTask(7, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(8, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new DinoAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new DinoAIHunt(this, 200, false));
        this.setSize(0.7F, 0.7F);
        this.tasks.addTask(10, aiEatGrass);
        this.pediaScale = 1.5F;
        minSize = 1.3F;
        maxSize = 5F;
        teenAge = 7;
        developsResistance = true;
        breaksBlocks = true;
    }

    @Override
    public int getAttackLength() {
        return 35;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(30, (byte) 3);
    }

    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
        this.eatGrassTimes = 0;
        return !this.getSheared() && !this.isChild();
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
        ArrayList var7 = new ArrayList();
        int var8 = 1 + this.rand.nextInt(20);

        for (int var9 = 0; var9 < var8; ++var9) {

            var7.add(new ItemStack(Blocks.wool, 1, 12));

        }
        return var7;
    }

    @Override
    public void setSpawnValues() {
    }

    public boolean getSheared() {
        return (this.dataWatcher.getWatchableObjectByte(30) & 16) != 0;
    }

    public void setSheared(boolean var1) {
        byte var2 = this.dataWatcher.getWatchableObjectByte(30);

        if (var1) {
            this.dataWatcher.updateObject(30, (byte) (var2 | 16));
        } else {
            this.dataWatcher.updateObject(30, (byte) (var2 & -17));
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound var1) {
        super.writeEntityToNBT(var1);
        var1.setBoolean("Sheared", this.getSheared());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound var1) {
        super.readEntityFromNBT(var1);
        this.setSheared(var1.getBoolean("Sheared"));

    }

    @Override
    public void eatGrassBonus() {
        if (this.getSheared()) {
            ++this.eatGrassTimes;

            if (this.eatGrassTimes >= 5) {
                this.setSheared(false);
                this.eatGrassTimes = 0;
            }
        }

        if (this.isChild()) {
            int var1 = this.getGrowingAge() + 1200;

            if (var1 > 0) {
                var1 = 0;
            }

            this.setGrowingAge(var1);
        }
    }

    @Override
    public void onLivingUpdate() {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posY);
        int k = MathHelper.floor_double(this.posZ);
        if (!this.isPotionActive(Potion.weakness) && this.worldObj.getBiomeGenForCoords(i, k).getFloatTemperature(i, j, k) > 1.0 && !this.getSheared()) {
            this.addPotionEffect(BIOME_EFFECT);
        }

        super.onLivingUpdate();
    }

    @Override
    public Activity aiActivityType() {

        return Activity.DIURINAL;
    }

    @Override
    public Attacking aiAttackType() {

        return Attacking.KNOCKUP;
    }

    @Override
    public Climbing aiClimbType() {

        return Climbing.NONE;
    }

    @Override
    public Following aiFollowType() {

        return Following.NONE;
    }

    @Override
    public Jumping aiJumpType() {

        return Jumping.BASIC;
    }

    @Override
    public Response aiResponseType() {

        return Response.TERITORIAL;
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

        return Untaming.ATTACK;
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
        return true;
    }

    @Override
    public Item getOrderItem() {

        return Items.stick;
    }

    @Override
    public int getAdultAge() {
        return 14;
    }

    @Override
    public float getMaleSize() {
        return 1.2F;
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (this.getAttackBounds().intersectsWith(entity.boundingBox)) {
            if (this.getAnimation() == NO_ANIMATION) {
                this.setAnimation(ATTACK_ANIMATION);
                return false;
            }

            if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() == 20) {
                IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.attackDamage);
                boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) iattributeinstance.getAttributeValue());
                if (entity.ridingEntity != null) {
                    if (entity.ridingEntity == this) {
                        entity.mountEntity(null);
                    }
                }
                entity.motionY += 0.4000000059604645D;
                double d0 = this.getAttackTarget().posX - this.posX;
                double d1 = this.getAttackTarget().posZ - this.posZ;
                float f = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
                entity.addVelocity((double) (-MathHelper.sin((this.rotationYaw - 180) * (float) Math.PI / 180.0F) * 2 * 0.5F), 0.1D, (double) (MathHelper.cos((this.rotationYaw - 180) * (float) Math.PI / 180.0F) * 2 * 0.5F));
                return flag;
            }
        }
        return false;
    }
    
	public int getMaxHunger() {
		return 150;
	}
}
