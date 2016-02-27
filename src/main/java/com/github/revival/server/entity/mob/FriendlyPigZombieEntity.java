package com.github.revival.server.entity.mob;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FriendlyPigZombieEntity extends EntityTameable {
    private static final ItemStack defaultHeldItem = new ItemStack(Items.golden_sword, 1);
    public String LeaderName;
    public EntityPlayer Leader = null;
    public PigmenSpeaker Mouth = new PigmenSpeaker(this);
    public boolean maskSpeech = true;
    private int randomSoundDelay = 0;
    private boolean dying = false;

    public FriendlyPigZombieEntity(World var1) {
        super(var1);
        this.isImmuneToFire = true;
        this.LeaderName = "Notch";
        this.getNavigator().setBreakDoors(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLiving.class, 10.0F * 2.0F, false));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, 10.0F, 10.0F, 2.0F));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);

        if (this.isTamed()) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        }
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    protected boolean isAIEnabled() {
        return true;
    }

    protected String getLivingSound() {
        return "mob.zombiepig.zpig";
    }

    protected String getHurtSound() {
        return "mob.zombiepig.zpighurt";
    }

    protected String getDeathSound() {
        return "mob.zombiepig.zpigdeath";
    }

    public ItemStack getHeldItem() {
        return defaultHeldItem;
    }

    public EntityLivingBase func_130012_q() {
        return null;
    }

    public boolean func_142018_a(EntityLivingBase theTarget,
                                 EntityLivingBase var1) {
        return false;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable p_90011_1_) {
        return null;
    }
}
