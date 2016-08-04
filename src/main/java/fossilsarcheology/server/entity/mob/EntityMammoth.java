package fossilsarcheology.server.entity.mob;

import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.ai.DinoAIAttackOnCollide;
import fossilsarcheology.server.entity.ai.DinoAIEatBlocks;
import fossilsarcheology.server.entity.ai.DinoAIEatFeeders;
import fossilsarcheology.server.entity.ai.DinoAIEatItems;
import fossilsarcheology.server.entity.ai.DinoAIFollowOwner;
import fossilsarcheology.server.entity.ai.DinoAIHunt;
import fossilsarcheology.server.entity.ai.DinoAILookIdle;
import fossilsarcheology.server.entity.ai.DinoAIRiding;
import fossilsarcheology.server.entity.ai.DinoAIWander;
import fossilsarcheology.server.entity.ai.DinoAIWatchClosest;
import fossilsarcheology.server.enums.EnumPrehistoricAI;
import fossilsarcheology.server.enums.PrehistoricEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
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
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import java.util.ArrayList;

public class EntityMammoth extends EntityPrehistoric implements IShearable {

    private int eatGrassTimes = 0;
    private static PotionEffect BIOME_EFFECT = new PotionEffect(Potion.weakness.id, 60, 1);
    protected boolean isSheared;

    public EntityMammoth(World world) {
        super(world, PrehistoricEntityType.MAMMOTH, 2, 12, 10, 66, 0.2, 0.3);
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().setCanSwim(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new DinoAIRiding(this, 1.0F));
        this.tasks.addTask(4, new DinoAIAttackOnCollide(this, 1.5D, false));
        this.tasks.addTask(5, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(6, new DinoAIEatBlocks(this, 1));
        this.tasks.addTask(6, new DinoAIEatFeeders(this, 1));
        this.tasks.addTask(6, new DinoAIEatItems(this, 1));
        this.tasks.addTask(7, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(8, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new DinoAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new DinoAIHunt(this, 20, false));
        this.setActualSize(1.2F, 0.7F);
        this.pediaScale = 60F;
        minSize = 1.3F;
        maxSize = 5F;
        teenAge = 7;
        developsResistance = true;
        breaksBlocks = true;
        this.ridingY = 1.25F;
        this.eatGrassTimes = 0;
        this.setSheared(false);
    }

    @Override
    public int getAttackLength() {
        return 35;
    }

    @Override
    public int getSpeakLength() {
        return 35;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(30, (byte) 3);
    }

    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
        return !this.isSheared() && !this.isChild() && !this.isSkeleton();
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        ArrayList var7 = new ArrayList();
        int var8 = 1 + this.rand.nextInt(20);
        for (int var9 = 0; var9 < var8; ++var9) {
            var7.add(new ItemStack(Blocks.wool, 1, 12));
        }
        this.setSheared(true);
        this.playSound("mob.sheep.shear", 1.0F, 1.0F);
        return var7;
    }

    public String getTexture() {
        if (this.isSkeleton()) {
            return "fossil:textures/model/" + type.toString().toLowerCase() + "_0/" + type.toString().toLowerCase() + "_skeleton.png";
        }
        String toggle = this.hasFeatherToggle ? !this.featherToggle ? "feathered/" : "scaled/" : "";
        String gender = this.isChild() ? "_baby" : this.getGender() == 0 ? "_female" : "_male";
        String sleeping = !this.isSleeping() ? this.isActuallyWeak() ? "_sleeping" : "" : "_sleeping";
        String toggleList = this.hasFeatherToggle ? !this.featherToggle ? "_feathered" : "_scaled" : "";
        return "fossil:textures/model/" + type.toString().toLowerCase() + "_0/" + toggle + type.toString().toLowerCase() + gender + toggleList + sleeping + (this.isSheared() ? "_sheared" : "") + ".png";
    }

    @Override
    public void setSpawnValues() {
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound var1) {
        super.writeEntityToNBT(var1);
        var1.setInteger("GrassTicks", this.eatGrassTimes);
        var1.setBoolean("Sheared", this.isSheared());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound var1) {
        super.readEntityFromNBT(var1);
        this.setSheared(var1.getBoolean("Sheared"));
        this.eatGrassTimes = var1.getInteger("GrassTicks");
    }

    @Override
    public void doFoodEffect(Item item) {
        super.doFoodEffect(item);
        if (this.isSheared()) {
            ++this.eatGrassTimes;
            if (this.eatGrassTimes >= 5) {
                this.setSheared(false);
                this.eatGrassTimes = 0;
            }
        }
    }

    @Override
    public void onLivingUpdate() {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posY);
        int k = MathHelper.floor_double(this.posZ);
        if (!this.isPotionActive(Potion.weakness) && this.worldObj.getBiomeGenForCoords(i, k).getFloatTemperature(i, j, k) > 1.0 && !this.isSheared()) {
            this.addPotionEffect(BIOME_EFFECT);
        }
        if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() == 17 && this.getAttackTarget() != null) {
            this.attackEntityAsMob(this.getAttackTarget());
        }
        super.onLivingUpdate();
    }

    @Override
    public EnumPrehistoricAI.Activity aiActivityType() {
        return EnumPrehistoricAI.Activity.DIURINAL;
    }

    @Override
    public EnumPrehistoricAI.Attacking aiAttackType() {
        return EnumPrehistoricAI.Attacking.KNOCKUP;
    }

    @Override
    public EnumPrehistoricAI.Climbing aiClimbType() {
        return EnumPrehistoricAI.Climbing.NONE;
    }

    @Override
    public EnumPrehistoricAI.Following aiFollowType() {
        return EnumPrehistoricAI.Following.NONE;
    }

    @Override
    public EnumPrehistoricAI.Jumping aiJumpType() {
        return EnumPrehistoricAI.Jumping.BASIC;
    }

    @Override
    public EnumPrehistoricAI.Response aiResponseType() {
        return EnumPrehistoricAI.Response.TERITORIAL;
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
        return EnumPrehistoricAI.Untaming.ATTACK;
    }

    @Override
    public EnumPrehistoricAI.Moving aiMovingType() {
        return EnumPrehistoricAI.Moving.WALK;
    }

    @Override
    public EnumPrehistoricAI.WaterAbility aiWaterAbilityType() {
        return EnumPrehistoricAI.WaterAbility.NONE;
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
        if (this.getAttackBounds().expand(3.0F, 3.0F, 3.0F).intersectsWith(entity.boundingBox)) {
            if (this.getAnimation() == NO_ANIMATION) {
                this.setAnimation(ATTACK_ANIMATION);
                return false;
            }
            if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() == 17) {
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

    public void setSheared(boolean sheared) {
        byte b0 = this.dataManager.getWatchableObjectByte(30);
        if (sheared) {
            this.dataManager.updateObject(30, (byte) (b0 | 1));
        } else {
            this.dataManager.updateObject(30, (byte) (b0 & -2));
        }
        if (!worldObj.isRemote) {
            this.isSheared = sheared;
        }
    }

    public boolean isSheared() {
        if (worldObj.isRemote) {
            boolean isSheared = (this.dataManager.getWatchableObjectByte(30) & 1) != 0;
            if ((isSheared != this.isSheared)) {
                ticksSlept = 0;
            }
            this.isSheared = isSheared;
            return isSheared;
        }
        return isSheared;
    }

    @Override
    public boolean canBeRidden() {
        return true;
    }
}
