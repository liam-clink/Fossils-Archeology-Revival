package com.github.revival.server.entity.mob;

import com.github.revival.server.block.FABlockRegistry;
import com.github.revival.server.item.FAItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityTarSlime extends EntitySlime {

    private int newSlimeJumpDelay;

    public EntityTarSlime(World world) {
        super(world);
        newSlimeJumpDelay = this.rand.nextInt(20) + 10;
    }

    @Override
    protected String getSlimeParticle() {
        return "blockcrack_" + Block.getIdFromBlock(FABlockRegistry.INSTANCE.tar) + "_0";
    }

    @Override
    protected EntitySlime createInstance() {
        return new EntityTarSlime(this.worldObj);
    }

    @Override
    protected float getSoundPitch() {
        return 0.5F;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        int j = MathHelper.floor_double(this.posX);
        int k = MathHelper.floor_double(this.posY);
        int l = MathHelper.floor_double(this.posZ);
        if (this.worldObj.getBlock(j, k, l) == FABlockRegistry.INSTANCE.tar) {
            this.motionY *= 1.3;
        }
        boolean flag = onGround;
        if (onGround && !flag || this.isJumping) {
            this.playSound(this.getJumpSound(), this.getSoundVolume(), getSoundPitch() * ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
        }

    }

    @Override
    public void updateRidden() {
        super.updateRidden();
        if (this.ridingEntity != null) {
            this.rotationYaw = ridingEntity.rotationYaw;
            if (this.ridingEntity instanceof EntityPlayer) {
                this.rotationYaw = ((EntityPlayer) ridingEntity).rotationYawHead;
                this.setPosition(posX, posY - 1.6F, posZ);
            }
            if (ridingEntity instanceof EntityLivingBase) {
                ((EntityLivingBase) ridingEntity).addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 1));
            }
            if (this.ticksExisted % 20 == 0) {
                this.ridingEntity.attackEntityFrom(DamageSource.causeMobDamage(this), 0.5F * this.getSlimeSize());
                this.playSound(this.getJumpSound(), this.getSoundVolume(), getSoundPitch() * ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
                squishFactor = 0.7F;
            } else {
                squishFactor = 0.0F;

            }
            //alterSquishAmount();
        }
    }

    @Override
    protected void updateEntityActionState() {
        this.despawnEntity();
        EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);

        if (entityplayer != null) {
            this.faceEntity(entityplayer, 10.0F, 20.0F);
        }

        if (this.onGround && this.newSlimeJumpDelay-- <= 0) {
            this.newSlimeJumpDelay = this.getJumpDelay();

            if (entityplayer != null) {
                this.newSlimeJumpDelay /= 3;
            }

            this.isJumping = true;
            this.playSound(this.getJumpSound(), this.getSoundVolume(), this.getSoundPitch() * ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 0.8F);
            this.moveStrafing = 1.0F - this.rand.nextFloat() * 2.0F;
            this.moveForward = (float) (1 * this.getSlimeSize());
        } else {
            this.isJumping = false;

            if (this.onGround) {
                this.moveStrafing = this.moveForward = 0.0F;
            }
        }
    }

    @Override
    protected Item getDropItem() {
        return FAItemRegistry.INSTANCE.tardrop;
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer player) {
        super.onCollideWithPlayer(player);
        if (this.rand.nextInt(6) == 0 && player.riddenByEntity == null) {
            if (!player.capabilities.isCreativeMode) {
                this.mountEntity(player);
            }
        }
    }

    @Override
    protected boolean makesSoundOnLand() {
        return false;
    }

    @Override
    protected boolean makesSoundOnJump() {
        return false;
    }

    @Override
    public boolean isEntityInsideOpaqueBlock() {
        for (int i = 0; i < 8; ++i) {
            float f = ((float) ((i) % 2) - 0.5F) * this.width * 0.8F;
            float f1 = ((float) ((i >> 1) % 2) - 0.5F) * 0.1F;
            float f2 = ((float) ((i >> 2) % 2) - 0.5F) * this.width * 0.8F;
            int j = MathHelper.floor_double(this.posX + (double) f);
            int k = MathHelper.floor_double(this.posY + (double) this.getEyeHeight() + (double) f1);
            int l = MathHelper.floor_double(this.posZ + (double) f2);

            if (this.worldObj.getBlock(j, k, l).isNormalCube() && this.worldObj.getBlock(j, k, l) != FABlockRegistry.INSTANCE.tar) {
                return true;
            }
        }

        return false;
    }
}
