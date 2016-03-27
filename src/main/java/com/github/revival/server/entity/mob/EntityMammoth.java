package com.github.revival.server.entity.mob;

import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.*;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
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
    public static final double baseDamage = 2;
    public static final double maxDamage = 12;
    public static final double baseHealth = 10;
    public static final double maxHealth = 66;
    public static final double baseSpeed = 0.2D;
    public static final double maxSpeed = 0.3D;
    private EntityAIEatGrass aiEatGrass = new EntityAIEatGrass(this);
    private int eatGrassTimes = 0;

    public EntityMammoth(World world) {
        super(world, EnumPrehistoric.Mammoth);
        this.setSize(0.7F, 0.7F);
    	this.pediaScale = 1.5F;
        this.tasks.addTask(10, aiEatGrass);
        minSize = 1.3F;
        maxSize = 5F;
        teenAge = 7;
        developsResistance = true;
        breaksBlocks = true;
        favoriteFood = Items.potato;
    }

    public int getAttackLength() {
		return 35;
	}
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(baseSpeed);
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(baseHealth);
        getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(baseDamage);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(30, new Byte((byte) 3));
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
            this.dataWatcher.updateObject(30, Byte.valueOf((byte) (var2 | 16)));
        } else {
            this.dataWatcher.updateObject(30, Byte.valueOf((byte) (var2 & -17)));
        }
    }

    public void writeEntityToNBT(NBTTagCompound var1) {
        super.writeEntityToNBT(var1);
        var1.setBoolean("Sheared", this.getSheared());
    }


    public void readEntityFromNBT(NBTTagCompound var1) {
        super.readEntityFromNBT(var1);
        this.setSheared(var1.getBoolean("Sheared"));

    }

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

    public void onLivingUpdate() {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posY);
        int k = MathHelper.floor_double(this.posZ);
        PotionEffect BIOME_EFFECT = new PotionEffect(Potion.weakness.id, 60, 1);
        if (!this.isPotionActive(Potion.weakness) && this.worldObj.getBiomeGenForCoords(i, k).getFloatTemperature(i, j, k) > 1.0 && !this.getSheared()) {
            //this.addPotionEffect(BIOME_EFFECT);

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

    public void updateSize() {
        double healthStep;
        double attackStep;
        double speedStep;
        healthStep = (this.maxHealth - this.baseHealth) / (this.getAdultAge() + 1);
        attackStep = (this.maxDamage - this.baseDamage) / (this.getAdultAge() + 1);
        speedStep = (this.maxSpeed - this.baseSpeed) / (this.getAdultAge() + 1);


        if (this.getDinoAge() <= this.getAdultAge()) {

            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(Math.round(this.baseHealth + (healthStep * this.getDinoAge())));
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(Math.round(this.baseDamage + (attackStep * this.getDinoAge())));
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.baseSpeed + (speedStep * this.getDinoAge()));

            if (this.isTeen()) {
                this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.5D);
            } else if (this.isAdult()) {
                this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(2.0D);
            } else {
                this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);
            }
        }
    }

    @Override
    public int getAdultAge() {
        return 14;
    }

    public float getMaleSize() {
        return 1.2F;
    }
    
	public boolean attackEntityAsMob(Entity entity)
	{
		if(this.getAnimation() == NO_ANIMATION){
			this.setAnimation(animation_attack);
			return false;
		}

		if(this.getAnimation() == animation_attack && this.getAnimationTick() == 20){
			IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.attackDamage);
			boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)iattributeinstance.getAttributeValue());

			if (flag)
			{
				if(entity.ridingEntity != null){
					if(entity.ridingEntity  == this){
						entity.mountEntity(null);
					}
				}
				entity.motionY += 0.4000000059604645D;
				double d0 = this.getAttackTarget().posX - this.posX;
				double d1 = this.getAttackTarget().posZ - this.posZ;
				float f = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
                entity.addVelocity((double)(-MathHelper.sin((this.rotationYaw - 180) * (float)Math.PI / 180.0F) * 2 * 0.5F), 0.1D, (double)(MathHelper.cos((this.rotationYaw - 180) * (float)Math.PI / 180.0F) * 2 * 0.5F));

				
			}

			return flag;
		}
		return false;
	}
}
